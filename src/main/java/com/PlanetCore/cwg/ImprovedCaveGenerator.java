package com.PlanetCore.cwg;

import com.PlanetCore.init.ModBlocks;
import io.github.opencubicchunks.cubicchunks.api.util.CubePos;
import io.github.opencubicchunks.cubicchunks.api.util.MathUtil;
import io.github.opencubicchunks.cubicchunks.api.world.ICube;
import io.github.opencubicchunks.cubicchunks.api.worldgen.CubePrimer;
import io.github.opencubicchunks.cubicchunks.api.worldgen.structure.ICubicStructureGenerator;
import io.github.opencubicchunks.cubicchunks.cubicgen.StructureGenUtil;
import net.minecraft.block.Block;
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
import static io.github.opencubicchunks.cubicchunks.cubicgen.StructureGenUtil.normalizedDistance;
import static java.lang.Math.max;
import static net.minecraft.util.math.MathHelper.*;
import static net.minecraft.util.math.MathHelper.floor;

public class ImprovedCaveGenerator implements ICubicStructureGenerator {

    //=============================================
    //Possibly configurable values
    //=============================================

    /**
     * 1 in CAVE_RARITY attempts will result in generating any caves at all
     * <p>
     * Vanilla value: 7 Multiply by 16 and divide by 8: there are 16 cubes in a vanilla chunk, but only one cube per 8
     * has caves generated
     */
    private static final int CAVE_RARITY = 16 * 7 / (2 * 2 * 2);

    /**
     * Maximum amount of starting nodes
     */
    private static final int MAX_INIT_NODES = 10;

    /**
     * 1 in LARGE_NODE_RARITY initial attempts will result in large node
     */
    private static final int LARGE_NODE_RARITY = 4;

    /**
     * The maximum amount of additional branches after generating large node. Random value between 0 and
     * LARGE_NODE_MAX_BRANCHES is chosen.
     */
    private static final int LARGE_NODE_MAX_BRANCHES = 4;

    /**
     * 1 in BIG_CAVE_RARITY branches will start bigger than usual
     */
    private static final int BIG_CAVE_RARITY = 9;

    /**
     * Value added to the size of the cave (radius)
     */
    private static double CAVE_SIZE_ADD = 1.5D;

    /**
     * In 1 of STEEP_STEP_RARITY steps, cave will be flattened using STEEPER_FLATTEN_FACTOR instead of FLATTEN_FACTOR
     */
    private static final int STEEP_STEP_RARITY = 6;

    /**
     * After each step the Y direction component will be multiplied by this value, unless steeper cave is allowed
     */
    private static final float FLATTEN_FACTOR = 0.7f;

    /**
     * If steeper cave is allowed - this value will be used instead of FLATTEN_FACTOR
     */
    private static final float STEEPER_FLATTEN_FACTOR = 0.92f;

    /**
     * Each step cave direction angles will be changed by this fraction of values that specify how direction changes
     */
    private static final float DIRECTION_CHANGE_FACTOR = 0.1f;

    /**
     * This fraction of the previous value that controls horizontal direction changes will be used in next step
     */
    private static final float PREV_HORIZ_DIRECTION_CHANGE_WEIGHT = 0.75f;

    /**
     * This fraction of the previous value that controls vertical direction changes will be used in next step
     */
    private static final float PREV_VERT_DIRECTION_CHANGE_WEIGHT = 0.9f;

    /**
     * Maximum value by which horizontal cave direction randomly changes each step, lower values are much more likely.
     */
    private static final float MAX_ADD_DIRECTION_CHANGE_HORIZ = 4.0f;

    /**
     * Maximum value by which vertical cave direction randomly changes each step, lower values are much more likely.
     */
    private static final float MAX_ADD_DIRECTION_CHANGE_VERT = 2.0f;

    /**
     * 1 in this amount of steps will actually carve any blocks,
     */
    private static final int CARVE_STEP_RARITY = 4;

    private static int OUTER_CAVE_THICKNESS = 2;

    private static boolean REPLACE_WITH_AIR = false;

    private static final int SPECIAL_CAVE_RARITY = 2;

    private static Block CAVE_MATERIAL = Blocks.STONE;

    private static Block SPECIAL_CAVE_MATERIAL = Blocks.STONE;


    public enum CaveType {

        CAVE0(Blocks.STONE,1.0, -30.0,128,10000,-10000, 10000, 64, 64),
        CAVE1(Block.getBlockFromName("planetcore:coal_supercompact"),0.01, -10.0,16,10000,-10000, 10000, 64, 64),
        CAVE2(Block.getBlockFromName("planetcore:aluminium_supercompact"),0.07, -11.0,16,10000,-10000, 10000, 64, 64),
        CAVE3(Block.getBlockFromName("planetcore:zinc_supercompact"),0.04, -12.0,16,10000,-10000, 10000, 64, 64),
        CAVE4(Block.getBlockFromName("planetcore:lead_supercompact"),0.04, -13.0,16,10000, -10000, 10000, 64, 64),
        CAVE5(Block.getBlockFromName("planetcore:tin_supercompact"),0.03, -14.0,16,10000, -10000, 10000, 64, 64),
        CAVE6(Block.getBlockFromName("planetcore:copper_supercompact"),0.03, -15.0,16,10000,-10000, 10000, 64, 64),
        CAVE7(Block.getBlockFromName("planetcore:iron_supercompact"),0.05, -16.0,16,10000,-10000, 10000, 64, 64),
        CAVE8(Block.getBlockFromName("planetcore:redstone_supercompact"),0.02, -17.0,16,10000, -10000, 10000, 64, 64),
        CAVE9(Block.getBlockFromName("planetcore:silver_supercompact"),0.02, -18.0,16,10000, -10000, 10000, 64, 64),
        CAVE10(Block.getBlockFromName("planetcore:gold_supercompact"),0.01, -19.0,16,10000,-10000, 10000, 64, 64),
        CAVE11(Block.getBlockFromName("planetcore:platinum_supercompact"),0.01, -20.0,16,10000,-10000, 10000, 64, 64),
        CAVE12(Block.getBlockFromName("planetcore:titanium_supercompact"),0.01, -21.0,16,10000, -10000, 10000, 64, 64),
        CAVE13(Block.getBlockFromName("planetcore:uranium_supercompact"),0.01, -23.0,16,10000, -10000, 10000, 64, 64),
        CAVE14(Block.getBlockFromName("planetcore:tungsten_supercompact"),0.01, -25.0,16,10000, -10000, 10000, 64, 64),
        CAVE15(Block.getBlockFromName("planetcore:topaz_supercompact"),0.01, -30.0,16,10000, -10000, 10000, 64, 64),
        CAVE16(Block.getBlockFromName("planetcore:jade_supercompact"),0.01, -35.0,16,10000, -10000, 10000, 64, 64),
        CAVE17(Block.getBlockFromName("planetcore:emerald_supercompact"),0.005, -40.0,16,10000, -10000, 10000, 64, 64),
        CAVE18(Block.getBlockFromName("planetcore:ruby_supercompact"),0.005, -50.0,16,10000, -10000, 10000, 64, 64),
        CAVE19(Block.getBlockFromName("planetcore:sapphire_supercompact"),0.005, -50.0,16,10000, -10000, 10000, 64, 64),
        CAVE20(Block.getBlockFromName("planetcore:diamond_supercompact"),0.005, -60.0,16,10000, -10000, 10000, 64, 64),
        CAVE21(Block.getBlockFromName("planetcore:olivine_supercompact"),0.005, -80.0,16,10000, -10000, 10000, 64, 64),
        CAVE22(Block.getBlockFromName("planetcore:wadsleyite_supercompact"),0.005, -100.0,16,10000, -10000, 10000, 64, 64),
        CAVE23(Block.getBlockFromName("planetcore:ringwoodite_supercompact"),0.005, -120.0,16,10000, -10000, 10000, 64, 64),
        CAVE24(Block.getBlockFromName("planetcore:brigmanite_supercompact"),0.005, -140.0,16,10000, -10000, 10000, 64, 64),
        CAVE25(Block.getBlockFromName("planetcore:majorite_supercompact"),0.005, -160.0,16,10000, -10000, 10000, 64, 64),
        CAVE26(Block.getBlockFromName("planetcore:amazonite_supercompact"),0.005, -180.0,16,10000, -10000, 10000, 64, 64),
        CAVE27(Block.getBlockFromName("planetcore:onyx_supercompact"),0.005, -200.0,16,10000, -10000, 10000, 64, 64);


        private final Block block;
        private final double probability;
        private final double heightMean;
        private final double heightStdDeviation;
        private final double heightSpacing;
        private final double minHeight;
        private final double maxHeight;
        private final double expectedHeightVariation;
        private final double expectedBaseHeight;


        CaveType(Block block, double probability, double heightMean,double heightStdDeviation, double heightSpacing, double minHeight, double maxHeight, double expectedHeightVariation, double expectedBaseHeight) {
            this.block = block;
            this.probability = probability;
            this.heightMean = heightMean;
            this.heightStdDeviation = heightStdDeviation;
            this.heightSpacing = heightSpacing;
            this.minHeight = minHeight;
            this.maxHeight = maxHeight;
            this.expectedHeightVariation = expectedHeightVariation;
            this.expectedBaseHeight = expectedBaseHeight;
        }

        public Block block() {
            return block;
        }

        public double probability() {
            return probability;
        }

        public double heightMean() {
            return heightMean;
        }

        public double heightStdDeviation() {
            return heightStdDeviation;
        }

        public double heightSpacing() {
            return heightSpacing;
        }

        public double minHeight() {
            return minHeight;
        }

        public double maxHeight() {
            return maxHeight;
        }

        public double expectedHeightVariation() {
            return expectedHeightVariation;
        }

        public double expectedBaseHeight() {
            return expectedBaseHeight;
        }
    }


    /**
     * Relative "height" if depth floor
     * <p>
     * -1 results in round cave without flat floor 1 will completely fill the cave 0 will result in lower half of the
     * cave to be filled with stone
     */
    private static final double CAVE_FLOOR_DEPTH = -0.7;

    private static final int RANGE = 8;
    /**
     * Controls which blocks can be replaced by cave
     */
    private static Predicate<IBlockState> isBlockReplaceable = (state ->
            state.getMaterial() == Material.ROCK || state.getMaterial() == Material.IRON || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS || state.getBlock() == Blocks.AIR || state.getBlock() == Blocks.GLASS || state.getBlock() == ModBlocks.CORE_LAVA_FLUID);

    @Override public void generate(World world, CubePrimer cube, CubePos cubePos) {
        this.generate(world, cube, cubePos, this::generate, RANGE, RANGE, 1, 1);
    }

    protected void generate(World world, Random rand, CubePrimer cube,
                            int cubeXOrigin, int cubeYOrigin, int cubeZOrigin, CubePos generatedCubePos) {

        /**
         * Loop over all of the blocks inside the enum list
         * Each blocks contain their periodic gaussian values
         * Each blocks contain a max Y and min Y
         * The caves will generate with these blocks
         */
        if (rand.nextInt(CAVE_RARITY) != 0) {
            return;
        }

        for (CaveType cave : CaveType.values()) {
            if (cave != CaveType.CAVE0 && cubeYOrigin > -10)
            {
                continue;
            }

            //very low probability of generating high number
            int nodes = rand.nextInt(rand.nextInt(rand.nextInt(MAX_INIT_NODES + 1) + 1) + 1);

            int minBlockY = Math.round((float) (cave.minHeight * cave.expectedHeightVariation + cave.expectedBaseHeight));
            int maxBlockY = Math.round((float) (cave.maxHeight * cave.expectedHeightVariation + cave.expectedBaseHeight));
            double spacing = cave.heightSpacing;
            //temporary fix for slider becoming 0 at minimum position
            if (cave.heightSpacing == 0.0) {
                spacing = 0.5;
            }
            int iSpacing = Math.round((float) (spacing * cave.expectedHeightVariation));
            int iMean = Math.round((float) (cave.heightMean * cave.expectedHeightVariation + cave.expectedBaseHeight));
            double scaledStdDev = cave.heightStdDeviation * cave.expectedHeightVariation;

            if ((cubeYOrigin > maxBlockY) || (cubeYOrigin < minBlockY)) {
                continue;
            }
            double modifier = MathUtil.bellCurveProbabilityCyclic(cubeYOrigin, iMean, scaledStdDev, iSpacing);

            double random = Math.abs(rand.nextDouble());
            double probability = cave.probability * modifier;
            if (cave != CaveType.CAVE0) {
                //Modify base probability with the curve
                if (random < probability) {
                    isBlockReplaceable = (state -> state.getMaterial() == Material.ROCK || state.getMaterial() == Material.IRON || state.getMaterial() == Material.AIR || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS);
                    CAVE_MATERIAL = cave.block;
                    nodes = rand.nextInt(rand.nextInt(rand.nextInt(5) + 1) + 1);
                } else { continue; }
            }
            else
            {
                isBlockReplaceable = (state -> state.getMaterial() == Material.ROCK || state.getBlock() == Blocks.DIRT || state.getBlock() == Blocks.GRASS);
                CAVE_MATERIAL = cave.block;
                nodes = rand.nextInt(rand.nextInt(rand.nextInt(rand.nextInt(15) +2) +2) +1);
            }

            for (int node = 0; node < nodes; ++node) {

                double branchStartX = localToBlock(cubeXOrigin, rand.nextInt(ICube.SIZE));
                double branchStartY = localToBlock(cubeYOrigin, rand.nextInt(ICube.SIZE));
                double branchStartZ = localToBlock(cubeZOrigin, rand.nextInt(ICube.SIZE));
                int subBranches = 1;

                if (rand.nextInt(LARGE_NODE_RARITY) == 0) {
                    this.generateLargeNode(cube, rand, rand.nextLong(), generatedCubePos,
                            branchStartX, branchStartY, branchStartZ);
                    subBranches += rand.nextInt(LARGE_NODE_MAX_BRANCHES);
                }

                for (int branch = 0; branch < subBranches; ++branch) {

                    float horizDirAngle = rand.nextFloat() * (float) Math.PI * 2.0F;
                    float vertDirAngle = (rand.nextFloat() - 0.5F) * 2.0F / 8.0F;
                    float baseHorizSize = rand.nextFloat() * 2.0F * rand.nextFloat() + rand.nextFloat();

                    if (rand.nextInt(4) == 0) {
                        baseHorizSize *= rand.nextFloat() * rand.nextFloat() * 3.0F + 1.0F;
                    }

                    int startWalkedDistance = 0;
                    int maxWalkedDistance = 0;
                    double vertCaveSizeMod = 1.0 * (rand.nextDouble()+0.5);

                    if (cave == CaveType.CAVE0)
                    {
                        CAVE_SIZE_ADD = rand.nextInt(rand.nextInt(rand.nextInt(4) + 1) + 1) + 1.5D;
                        OUTER_CAVE_THICKNESS = 0;
                        REPLACE_WITH_AIR = true;
                        long tempLong = rand.nextLong();
                        this.generateNode(cube, tempLong, generatedCubePos,
                                branchStartX, branchStartY, branchStartZ,
                                baseHorizSize, horizDirAngle, vertDirAngle,
                                startWalkedDistance, maxWalkedDistance, vertCaveSizeMod);
                    }
                    else
                    {
                        CAVE_SIZE_ADD = rand.nextInt(rand.nextInt(rand.nextInt(4) + 1) + 1) + 1.5D;
                        OUTER_CAVE_THICKNESS = 2;
                        REPLACE_WITH_AIR = false;
                        long tempLong = rand.nextLong();
                        this.generateNode(cube, tempLong, generatedCubePos,
                                branchStartX, branchStartY, branchStartZ,
                                baseHorizSize, horizDirAngle, vertDirAngle,
                                startWalkedDistance, maxWalkedDistance, vertCaveSizeMod);

                        OUTER_CAVE_THICKNESS = 0;
                        REPLACE_WITH_AIR = true;
                        this.generateNode(cube, tempLong, generatedCubePos,
                                branchStartX, branchStartY, branchStartZ,
                                baseHorizSize, horizDirAngle, vertDirAngle,
                                startWalkedDistance, maxWalkedDistance, vertCaveSizeMod);

                    }
                }
            }
        }
    }


    /**
     * Generates a flattened cave "room", usually more caves split off it
     */
    private void generateLargeNode(CubePrimer cube, Random rand, long seed, CubePos generatedCubePos,
                                   double x, double y, double z) {
        float baseHorizSize = 1.0F + rand.nextFloat() * 6.0F;
        float horizDirAngle = 0;
        float vertDirAngle = 0;

        int startWalkedDistance = -1;
        int maxWalkedDistance = -1;
        double vertCaveSizeMod = 1.0;
        this.generateNode(cube, seed, generatedCubePos, x, y, z,
                baseHorizSize, horizDirAngle, vertDirAngle,
                startWalkedDistance, maxWalkedDistance, vertCaveSizeMod);
    }

    /**
     * Recursively generates a node in the current cave system tree.
     *
     * @param cube block buffer to modify
     * @param seed random seed to use
     * @param generatedCubePos position of the cube to modify
     * @param caveX starting x coordinate of the cave
     * @param caveY starting Y coordinate of the cave
     * @param caveZ starting Z coordinate of the cave
     * @param baseCaveSize initial value for cave size, size decreases as cave goes further
     * @param horizDirAngle horizontal direction angle
     * @param vertCaveSizeMod vertical direction angle
     * @param startWalkedDistance the amount of steps the cave already went forwards, used in recursive step. -1 means
     * that there will be only one step
     * @param maxWalkedDistance maximum distance the cave can go forwards, <= 0 to use default
     * @param vertDirAngle changes vertical size of the cave, values < 1 result in flattened caves, > 1 result in
     * vertically stretched caves
     */
    private void generateNode(CubePrimer cube, long seed,
                              CubePos generatedCubePos,
                              double caveX, double caveY, double caveZ,
                              float baseCaveSize, float horizDirAngle, float vertDirAngle,
                              int startWalkedDistance, int maxWalkedDistance, double vertCaveSizeMod) {
        Random rand = new Random(seed);

        //store by how much the horizontal and vertical direction angles will change each step
        float horizDirChange = 0.0F;
        float vertDirChange = 0.0F;

        if (maxWalkedDistance <= 0) {
            int maxBlockRadius = cubeToMinBlock(RANGE - 1);
            maxWalkedDistance = maxBlockRadius - rand.nextInt(maxBlockRadius / 4);
        }

        //if true - this branch won't generate new sub-branches
        boolean finalStep = false;

        int walkedDistance;
        if (startWalkedDistance == -1) {
            //generate a cave "room"
            //start at half distance towards the end = max cave size
            walkedDistance = maxWalkedDistance / 2;
            finalStep = true;
        } else {
            walkedDistance = startWalkedDistance;
        }

        int splitPoint = rand.nextInt(maxWalkedDistance / 2) + maxWalkedDistance / 4;

        for (; walkedDistance < maxWalkedDistance; ++walkedDistance) {
            float fractionWalked = walkedDistance / (float) maxWalkedDistance;
            //horizontal and vertical size of the cave
            //size starts small and increases, then decreases as cave goes further
            double caveSizeHoriz = OUTER_CAVE_THICKNESS + CAVE_SIZE_ADD + sin(fractionWalked * (float) Math.PI) * baseCaveSize;
            double caveSizeVert = OUTER_CAVE_THICKNESS + ((caveSizeHoriz-OUTER_CAVE_THICKNESS) * vertCaveSizeMod);

            //Walk forward a single step:

            //from sin(alpha)=y/r and cos(alpha)=x/r ==> x = r*cos(alpha) and y = r*sin(alpha)
            //always moves by one block in some direction

            //here x is xzDirectionFactor, y is yDirectionFactor
            float xzDirectionFactor = cos(vertDirAngle);
            float yDirectionFactor = sin(vertDirAngle);

            //here y is directionZ and x is directionX
            caveX += cos(horizDirAngle) * xzDirectionFactor;
            caveY += yDirectionFactor;
            caveZ += sin(horizDirAngle) * xzDirectionFactor;

            if (rand.nextInt(STEEP_STEP_RARITY) == 0) {
                vertDirAngle *= STEEPER_FLATTEN_FACTOR;
            } else {
                vertDirAngle *= FLATTEN_FACTOR;
            }

            //change the direction
            vertDirAngle += vertDirChange * DIRECTION_CHANGE_FACTOR;
            horizDirAngle += horizDirChange * DIRECTION_CHANGE_FACTOR;
            //update direction change angles
            vertDirChange *= PREV_VERT_DIRECTION_CHANGE_WEIGHT;
            horizDirChange *= PREV_HORIZ_DIRECTION_CHANGE_WEIGHT;
            vertDirChange += (rand.nextFloat() - rand.nextFloat()) * rand.nextFloat() * MAX_ADD_DIRECTION_CHANGE_VERT;
            horizDirChange += (rand.nextFloat() - rand.nextFloat()) * rand.nextFloat() * MAX_ADD_DIRECTION_CHANGE_HORIZ;

            //if we reached split point - try to split
            //can split only if it's not final branch and the cave is still big enough (>1 block radius)
            if (!finalStep && walkedDistance == splitPoint && baseCaveSize > 1.0F) {
                this.generateNode(cube, rand.nextLong(),
                        generatedCubePos, caveX, caveY, caveZ,
                        rand.nextFloat() * 0.5F + 0.5F,//base cave size
                        horizDirAngle - ((float) Math.PI / 2F),//horiz. angle - subtract 90 degrees
                        vertDirAngle / 3.0F, walkedDistance, maxWalkedDistance,
                        1.0D);
                this.generateNode(cube, rand.nextLong(), generatedCubePos, caveX, caveY, caveZ,
                        rand.nextFloat() * 0.5F + 0.5F,//base cave size
                        horizDirAngle + ((float) Math.PI / 2F),//horiz. angle - add 90 degrees
                        vertDirAngle / 3.0F, walkedDistance, maxWalkedDistance,
                        1.0D);
                return;
            }

            //carve blocks only on some percentage of steps, unless this is the final branch
            if (rand.nextInt(CARVE_STEP_RARITY) == 0 && !finalStep) {
                continue;
            }

            double xDist = caveX - generatedCubePos.getXCenter();
            double yDist = caveY - generatedCubePos.getYCenter();
            double zDist = caveZ - generatedCubePos.getZCenter();
            double maxStepsDist = maxWalkedDistance - walkedDistance;
            //CHANGE: multiply max(1, vertCaveSizeMod)
            double maxDistToCube = baseCaveSize * max(1, vertCaveSizeMod) + CAVE_SIZE_ADD + ICube.SIZE;

            //can this cube be reached at all?
            //if even after going max distance allowed by remaining steps, it's still too far - stop
            //TODO: does it make any performance difference?
            if (xDist * xDist + yDist * yDist + zDist * zDist - maxStepsDist * maxStepsDist > maxDistToCube * maxDistToCube) {
                return;
            }

            tryCarveBlocks(cube, generatedCubePos,
                    caveX, caveY, caveZ,
                    caveSizeHoriz, caveSizeVert);
            if (finalStep) {
                return;
            }
        }
    }

    //returns true if cave generation should be continued
    private void tryCarveBlocks(@Nonnull CubePrimer cube, @Nonnull CubePos generatedCubePos,
                                double caveX, double caveY, double caveZ,
                                double caveSizeHoriz, double caveSizeVert) {
        double genCubeCenterX = generatedCubePos.getXCenter();
        double genCubeCenterY = generatedCubePos.getYCenter();
        double genCubeCenterZ = generatedCubePos.getZCenter();

        //Can current step position affect currently modified cube?
        //TODO: is multiply by 2 needed?
        if (caveX < genCubeCenterX - ICube.SIZE - caveSizeHoriz * 2.0D ||
                caveY < genCubeCenterY - ICube.SIZE - caveSizeVert * 2.0D ||
                caveZ < genCubeCenterZ - ICube.SIZE - caveSizeHoriz * 2.0D ||
                caveX > genCubeCenterX + ICube.SIZE + caveSizeHoriz * 2.0D ||
                caveY > genCubeCenterY + ICube.SIZE + caveSizeVert * 2.0D ||
                caveZ > genCubeCenterZ + ICube.SIZE + caveSizeHoriz * 2.0D) {
            return;
        }
        int minLocalX = floor(caveX - caveSizeHoriz) - generatedCubePos.getMinBlockX() - 1;
        int maxLocalX = floor(caveX + caveSizeHoriz) - generatedCubePos.getMinBlockX() + 1;
        int minLocalY = floor(caveY - caveSizeVert) - generatedCubePos.getMinBlockY() - 1;
        int maxLocalY = floor(caveY + caveSizeVert) - generatedCubePos.getMinBlockY() + 1;
        int minLocalZ = floor(caveZ - caveSizeHoriz) - generatedCubePos.getMinBlockZ() - 1;
        int maxLocalZ = floor(caveZ + caveSizeHoriz) - generatedCubePos.getMinBlockZ() + 1;

        //skip is if everything is outside of that cube
        if (maxLocalX <= 0 || minLocalX >= ICube.SIZE ||
                maxLocalY <= 0 || minLocalY >= ICube.SIZE ||
                maxLocalZ <= 0 || minLocalZ >= ICube.SIZE) {
            return;
        }
        StructureBoundingBox boundingBox = new StructureBoundingBox(minLocalX, minLocalY, minLocalZ, maxLocalX, maxLocalY, maxLocalZ);

        StructureGenUtil.clampBoundingBoxToLocalCube(boundingBox);

        boolean hitLiquid = StructureGenUtil.scanWallsForBlock(cube, boundingBox,
                (b) -> b.getBlock() == Blocks.LAVA || b.getBlock() == Blocks.FLOWING_LAVA);

        if (!hitLiquid) {
            carveBlocks(cube, generatedCubePos, caveX, caveY, caveZ, caveSizeHoriz, caveSizeVert, boundingBox);
        }
    }

    private void carveBlocks(CubePrimer cube,
                             CubePos generatedCubePos,
                             double caveX, double caveY, double caveZ,
                             double caveSizeHoriz, double caveSizeVert,
                             StructureBoundingBox boundingBox) {

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
            double distX = normalizedDistance(generatedCubeX, localX, caveX, caveSizeHoriz);

            for (int localZ = minZ; localZ < maxZ; ++localZ) {
                double distZ = normalizedDistance(generatedCubeZ, localZ, caveZ, caveSizeHoriz);

                if (distX * distX + distZ * distZ >= 1.0D) {
                    continue;
                }
                for (int localY = minY; localY < maxY; ++localY) {
                    double distY = normalizedDistance(generatedCubeY, localY, caveY, caveSizeVert);

                    IBlockState state = cube.getBlockState(localX, localY, localZ);

                    if (!isBlockReplaceable.test(state)) {
                        continue;
                    }

                    if (shouldCarveBlock(distX, distY, distZ)) {
                        // No lava generation, infinite depth. Lava will be generated differently (or not generated)
                        if(REPLACE_WITH_AIR) {
                            cube.setBlockState(localX, localY, localZ, Blocks.AIR.getDefaultState());
                        }
                        else{
                            cube.setBlockState(localX, localY, localZ, CAVE_MATERIAL.getDefaultState());
                        }
                    } else if (state.getBlock() == Blocks.DIRT) {
                        //vanilla dirt-grass replacement works by scanning top-down and moving the block
                        //cubic chunks needs to be a bit more hacky about it
                        //instead of keeping track of the encountered grass block
                        //cubic chunks replaces any dirt block (it's before population, no ore-like dirt formations yet)
                        //with grass, if the block above would be deleted by this cave generator step
                        double distYAbove = normalizedDistance(generatedCubeY, localY + 1, caveY, caveSizeVert);
                        if (shouldCarveBlock(distX, distYAbove, distZ)) {
                            cube.setBlockState(localX, localY, localZ, Blocks.GRASS.getDefaultState());
                        }
                    }
                }
            }
        }
    }

    private static boolean shouldCarveBlock(double distX, double distY, double distZ) {
        //distY > CAVE_FLOOR_DEPTH --> flattened floor
        return distY > CAVE_FLOOR_DEPTH && distX * distX + distY * distY + distZ * distZ < 1.0D;
    }
}
