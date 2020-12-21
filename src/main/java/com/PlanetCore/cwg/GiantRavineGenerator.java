package com.PlanetCore.cwg;

import io.github.opencubicchunks.cubicchunks.api.util.Coords;
import io.github.opencubicchunks.cubicchunks.api.util.CubePos;
import io.github.opencubicchunks.cubicchunks.api.world.ICube;
import io.github.opencubicchunks.cubicchunks.api.worldgen.CubePrimer;
import io.github.opencubicchunks.cubicchunks.api.worldgen.structure.ICubicStructureGenerator;
import io.github.opencubicchunks.cubicchunks.cubicgen.StructureGenUtil;
import io.github.opencubicchunks.cubicchunks.cubicgen.customcubic.CustomGeneratorSettings;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.world.World;
import net.minecraft.world.gen.structure.StructureBoundingBox;

import javax.annotation.Nonnull;
import java.util.Random;
import java.util.function.Predicate;

import static io.github.opencubicchunks.cubicchunks.api.util.Coords.cubeToMinBlock;
import static io.github.opencubicchunks.cubicchunks.api.util.Coords.localToBlock;
import static net.minecraft.util.math.MathHelper.*;
import static net.minecraft.util.math.MathHelper.floor;

public class GiantRavineGenerator implements ICubicStructureGenerator {

    //V17

    /**
     * Vanilla value: 50
     * <p>
     * Multiply by 16 and divide by 8: 16 cubes in vanilla chunks, only one in 8 cubes has structures generated
     */
    private static final int RAVINE_RARITY = 100 * 16 / (2 * 2 * 2);

    /**
     * Add this value to lava height (Y below which lava exists)
     * <p>
     * Positive value to increase amount of lava, negative to decrease.
     */
    private static final double LAVA_HEIGHT_OFFSET = -10;

    /**
     * Determine the height at which lava can generate up to 100%, filling the ravine.
     * Do not put zero as it create a divide by zero error.
     * The base height is always 0 and lava will have 0% chance at base height.
     */
    private static final double CAVE_MAX_LAVA_HEIGHT = -4000;

    private static final double VERT_SIZE_FACTOR = 1.2;

    /**
     * Value added to the size of the cave (radius)
     */
    private static final double RAVINE_SIZE_ADD = 1.6D;

    private static final double MIN_RAND_SIZE_FACTOR = 0.4;
    private static final double MAX_RAND_SIZE_FACTOR = 2.00;

    /**
     * After each step the Y direction component will be multiplied by this value
     */
    private static final float FLATTEN_FACTOR = 0.7f;

    /**
     * Each step ravine direction angles will be changed by this fraction of values that specify how direction changes
     */
    private static final float DIRECTION_CHANGE_FACTOR = 0.05f;

    /**
     * This fraction of the previous value that controls horizontal direction changes will be used in next step
     */
    private static final float PREV_HORIZ_DIRECTION_CHANGE_WEIGHT = 0.5f;

    /**
     * This fraction of the previous value that controls vertical direction changes will be used in next step
     */
    private static final float PREV_VERT_DIRECTION_CHANGE_WEIGHT = 0.6f;

    /**
     * Maximum value by which horizontal cave direction randomly changes each step, lower values are much more likely.
     */
    private static final float MAX_ADD_DIRECTION_CHANGE_HORIZ = 3.0f;

    /**
     * Maximum value by which vertical cave direction randomly changes each step, lower values are much more likely.
     */
    private static final float MAX_ADD_DIRECTION_CHANGE_VERT = 2.0f;

    /**
     * 1 in this amount of steps will actually carve any blocks,
     */
    private static final int CARVE_STEP_RARITY = 4;

    /**
     * Higher values will make width difference between top/bottom and center smaller
     * lower values will make top and bottom of the ravine smaller. Values less than one will shrink size of the ravine
     */
    private static final double STRETCH_Y_FACTOR = 6.0;

    /**
     * Controls which blocks can be replaced by cave
     */
    @Nonnull
    private static final Predicate<IBlockState> isBlockReplaceable = (state ->
            state.getMaterial() == Material.ROCK || state.getMaterial() == Material.IRON || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS);

    private final int maxCubeY;

    /**
     * Contains values of ravine widths at each height.
     * <p>
     * For cubic chunks the height value used wraps around.
     */
    @Nonnull private float[] widthDecreaseFactors = new float[1024];

    private final int range = 8;

    public GiantRavineGenerator(int maxCubeY) {
        this.maxCubeY = maxCubeY;
    }


    @Override public void generate(World world, CubePrimer cube, CubePos cubePos) {

        this.generate(world, cube, cubePos, this::generate, range, range, 1, 1);

    }


    protected void generate(World world, Random rand, CubePrimer cube, int structureX, int structureY, int structureZ,
                            CubePos generatedCubePos) {
        if (rand.nextInt(RAVINE_RARITY) != 0 || structureY > maxCubeY) {
            return;
        }
        double startX = localToBlock(structureX, rand.nextInt(ICube.SIZE));
        double startY = localToBlock(structureY, rand.nextInt(ICube.SIZE));
        double startZ = localToBlock(structureZ, rand.nextInt(ICube.SIZE));

        float vertDirectionAngle = rand.nextFloat() * (float) Math.PI * (rand.nextFloat() * 8.0F);
        float horizDirectionAngle = (rand.nextFloat() - 0.5F) * 2.0F / 4.0F;
        float baseRavineSize = (rand.nextFloat() * 5.0F * rand.nextFloat() + rand.nextFloat()) * 5.0F;

        int startWalkedDistance = 0;
        int maxWalkedDistance = 0;//choose value automatically

        double lavaHeight = rand.nextDouble() * (startY/CAVE_MAX_LAVA_HEIGHT);

        this.generateNode(cube, rand.nextLong(), generatedCubePos, startX, startY, startZ,
                baseRavineSize, vertDirectionAngle, horizDirectionAngle,
                startWalkedDistance, maxWalkedDistance, VERT_SIZE_FACTOR, lavaHeight);
    }

    private void generateNode(CubePrimer cube, long seed, CubePos generatedCubePos,
                              double ravineX, double ravineY, double ravineZ,
                              float baseRavineSize, float horizDirAngle, float vertDirAngle,
                              int startWalkedDistance, int maxWalkedDistance, double vertRavineSizeMod,
                              double lavaHeight) {
        Random rand = new Random(seed);

        //store by how much the horizontal and vertical(?) direction angles will change each step
        float horizDirChange = rand.nextFloat() * rand.nextFloat() * rand.nextFloat();
        float vertDirChange = rand.nextFloat() * rand.nextFloat() * rand.nextFloat();

        if (maxWalkedDistance <= 0) {
            int maxBlockRadius = cubeToMinBlock(this.range - 1);
            maxWalkedDistance = maxBlockRadius - rand.nextInt(maxBlockRadius / 4);
        }

        //always false for ravine generator
        boolean finalStep = false;

        int walkedDistance;
        if (startWalkedDistance == -1) {
            //UNUSED: generate a ravine equivalent of cave room
            //start at half distance towards the end = max size
            walkedDistance = maxWalkedDistance / 2;
            finalStep = true;
        } else {
            walkedDistance = startWalkedDistance;
        }

        this.widthDecreaseFactors = generateRavineWidthFactors(rand);

        for (; walkedDistance < maxWalkedDistance; ++walkedDistance) {
            float fractionWalked = walkedDistance / (float) maxWalkedDistance;
            //horizontal and vertical size of the ravine
            //size starts small and increases, then decreases as ravine goes further
            double ravineSizeHoriz = RAVINE_SIZE_ADD + sin(fractionWalked * (float) Math.PI) * baseRavineSize;
            double ravineSizeVert = ravineSizeHoriz * vertRavineSizeMod;
            ravineSizeHoriz *= rand.nextFloat() * (MAX_RAND_SIZE_FACTOR - MIN_RAND_SIZE_FACTOR) + MIN_RAND_SIZE_FACTOR;
            ravineSizeVert *= rand.nextFloat() * (MAX_RAND_SIZE_FACTOR - MIN_RAND_SIZE_FACTOR) + MIN_RAND_SIZE_FACTOR;

            //Walk forward a single step:

            //from sin(alpha)=y/r and cos(alpha)=x/r ==> x = r*cos(alpha) and y = r*sin(alpha)
            //always moves by one block in some direction

            //here x is xzDirectionSize, y is yDirection
            float xzDirectionFactor = cos(vertDirAngle);
            float yDirectionFactor = sin(vertDirAngle);

            ravineX += cos(horizDirAngle) * xzDirectionFactor;
            ravineY += yDirectionFactor;
            ravineZ += sin(horizDirAngle) * xzDirectionFactor;

            vertDirAngle *= FLATTEN_FACTOR * (rand.nextFloat()+1);

            //change the direction
            vertDirAngle += vertDirChange * DIRECTION_CHANGE_FACTOR * (rand.nextFloat()+rand.nextFloat());
            horizDirAngle += horizDirChange * DIRECTION_CHANGE_FACTOR * (rand.nextFloat()+rand.nextFloat());
            //update direction change angles
            vertDirChange *= PREV_VERT_DIRECTION_CHANGE_WEIGHT * (rand.nextFloat()+rand.nextFloat());
            horizDirChange *= PREV_HORIZ_DIRECTION_CHANGE_WEIGHT * (rand.nextFloat()+rand.nextFloat());
            vertDirChange += (rand.nextFloat() - rand.nextFloat()) * rand.nextFloat() * MAX_ADD_DIRECTION_CHANGE_VERT * (rand.nextFloat()+rand.nextFloat());
            horizDirChange += (rand.nextFloat() - rand.nextFloat()) * rand.nextFloat() * MAX_ADD_DIRECTION_CHANGE_HORIZ * (rand.nextFloat()+rand.nextFloat());

            if (rand.nextInt(CARVE_STEP_RARITY) == 0 && !finalStep) {
                continue;
            }

            double xDist = ravineX - generatedCubePos.getXCenter();
            double zDist = ravineZ - generatedCubePos.getZCenter();
            double maxStepsDist = maxWalkedDistance - walkedDistance;

            double maxDistToCube = baseRavineSize + RAVINE_SIZE_ADD + ICube.SIZE;
            //can this cube be reached at all?
            //if even after going max distance allowed by remaining steps, it's still too far - stop
            //NOTE: don't check yDist, this is optimization and with Y scale stretched as much as with ravines
            //the check would be useless
            //TODO: does it make any performance difference?
            if (xDist * xDist + zDist * zDist - maxStepsDist * maxStepsDist > maxDistToCube * maxDistToCube) {
                return;
            }

            tryCarveBlocks(cube, generatedCubePos,
                    ravineX, ravineY, ravineZ,
                    ravineSizeHoriz, ravineSizeVert, lavaHeight);

            if (finalStep) {
                return;
            }
        }
    }

    private void tryCarveBlocks(CubePrimer cube, CubePos generatedCubePos,
                                double ravineX, double ravineY, double ravineZ,
                                double ravineSizeHoriz, double ravineSizeVert, double lavaHeight) {
        double genCubeCenterX = generatedCubePos.getXCenter();
        double genCubeCenterY = generatedCubePos.getYCenter();
        double genCubeCenterZ = generatedCubePos.getZCenter();
        if (ravineX < genCubeCenterX - ICube.SIZE - ravineSizeHoriz * 2.0D ||
                ravineY < genCubeCenterY - ICube.SIZE - ravineSizeVert * 2.0D ||
                ravineZ < genCubeCenterZ - ICube.SIZE - ravineSizeHoriz * 2.0D ||
                ravineX > genCubeCenterX + ICube.SIZE + ravineSizeHoriz * 2.0D ||
                ravineY > genCubeCenterY + ICube.SIZE + ravineSizeVert * 2.0D ||
                ravineZ > genCubeCenterZ + ICube.SIZE + ravineSizeHoriz * 2.0D) {
            return;
        }
        int minLocalX = floor(ravineX - ravineSizeHoriz) - generatedCubePos.getMinBlockX() - 1;
        int maxLocalX = floor(ravineX + ravineSizeHoriz) - generatedCubePos.getMinBlockX() + 1;
        int minLocalY = floor(ravineY - ravineSizeVert) - generatedCubePos.getMinBlockY() - 1;
        int maxLocalY = floor(ravineY + ravineSizeVert) - generatedCubePos.getMinBlockY() + 1;
        int minLocalZ = floor(ravineZ - ravineSizeHoriz) - generatedCubePos.getMinBlockZ() - 1;
        int maxLocalZ = floor(ravineZ + ravineSizeHoriz) - generatedCubePos.getMinBlockZ() + 1;

        //skip if everything is outside of that cube
        if (maxLocalX <= 0 || minLocalX >= ICube.SIZE ||
                maxLocalY <= 0 || minLocalY >= ICube.SIZE ||
                maxLocalZ <= 0 || minLocalZ >= ICube.SIZE) {
            return;
        }
        StructureBoundingBox boundingBox = new StructureBoundingBox(minLocalX, minLocalY, minLocalZ, maxLocalX, maxLocalY, maxLocalZ);

        StructureGenUtil.clampBoundingBoxToLocalCube(boundingBox);

        boolean hitLiquid = StructureGenUtil.scanWallsForBlock(cube, boundingBox,
                (b) -> b.getBlock() == Blocks.WATER || b.getBlock() == Blocks.FLOWING_WATER);

        if (!hitLiquid) {
            carveBlocks(cube, generatedCubePos, ravineX, ravineY, ravineZ,
                    ravineSizeHoriz, ravineSizeVert, boundingBox, lavaHeight);
        }
    }

    private void carveBlocks(CubePrimer cube, CubePos generatedCubePos,
                             double ravineX, double ravineY, double ravineZ,
                             double ravineSizeHoriz, double ravineSizeVert, StructureBoundingBox boundingBox,
                             double lavaHeight) {
        int generatedCubeX = generatedCubePos.getX();
        int generatedCubeY = generatedCubePos.getY();
        int generatedCubeZ = generatedCubePos.getZ();

        int minX = boundingBox.minX;
        int maxX = boundingBox.maxX;
        int minY = boundingBox.minY;
        int maxY = boundingBox.maxY;
        int minZ = boundingBox.minZ;
        int maxZ = boundingBox.maxZ;

        for (int localX = minX; localX < maxX; ++localX) {
            double distX = StructureGenUtil.normalizedDistance(generatedCubeX, localX, ravineX, ravineSizeHoriz);

            for (int localZ = minZ; localZ < maxZ; ++localZ) {
                double distZ = StructureGenUtil.normalizedDistance(generatedCubeZ, localZ, ravineZ, ravineSizeHoriz);

                if (distX * distX + distZ * distZ >= 1.0D) {
                    continue;
                }
                for (int localY = minY; localY < maxY; ++localY) {
                    double distY = StructureGenUtil.normalizedDistance(generatedCubeY, localY, ravineY, ravineSizeVert);

                    if (distX * distX + distZ * distZ + distY * distY >= 1.0D) {
                        continue;
                    }

                    //distY*distY/STRETCH_Y_FACTOR is a hack
                    //it should make the ravine way more stretched in the Y dimension, but because of previous checks
                    //most of these blocks beyond the not-stretched height range are never carved out
                    //the result is that instead the ravine isn't very small at the bottom,
                    //but ends with actual floor instead
                    double widthDecreaseFactor = this.widthDecreaseFactors[(localY + generatedCubeY * ICube.SIZE) & 0xFF];




                    if (!isBlockReplaceable.test(cube.getBlockState(localX, localY, localZ))) {
                        continue;
                    }
                    double variable = generatedCubeY;
                    double variable1 = generatedCubePos.getMaxBlockY();
                    double variable2 = ravineY;
                    double variable3 = localToBlock(generatedCubeY, localY);
                    double variable4 = (ravineY-50) - (((ravineY-50)-(ravineY+50))*lavaHeight);
                    double variable5 = ravineY - ravineSizeVert*16;
                    double variable6 = lavaHeight;
                    if (localToBlock(generatedCubeY, localY) < variable4)  {
                        cube.setBlockState(localX, localY, localZ, Blocks.FLOWING_LAVA.getDefaultState());
                    } else {
                        cube.setBlockState(localX, localY, localZ, Blocks.LAVA.getDefaultState());
                    }
                }
            }
        }
    }

    private float[] generateRavineWidthFactors(Random rand) {
        float[] values = new float[1024];
        float value = 1.0F;

        for (int i = 0; i < ICube.SIZE*ICube.SIZE; ++i) {
            //~33% probability that the value will change at that height
            if (i == 0 || rand.nextInt(2) == 0) {
                //value = 1.xxx, lower = higher probability -> Wider parts are more common.
                value = 1.0F + rand.nextFloat() * rand.nextFloat();
            }

            values[i] = value * value;
        }

        return values;
    }
}
