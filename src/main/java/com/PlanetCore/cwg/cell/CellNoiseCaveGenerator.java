package com.PlanetCore.cwg.cell;
import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.util.FastRandom;
import io.github.opencubicchunks.cubicchunks.api.util.Coords;
import io.github.opencubicchunks.cubicchunks.api.util.CubePos;
import io.github.opencubicchunks.cubicchunks.api.worldgen.CubePrimer;
import io.github.opencubicchunks.cubicchunks.api.worldgen.structure.ICubicStructureGenerator;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import org.spongepowered.noise.Noise;
import org.spongepowered.noise.NoiseQuality;
import java.util.function.Supplier;
public class CellNoiseCaveGenerator implements ICubicStructureGenerator {
    private final long seedModifier;
    private final double cellSizeXZ = 256;
    private final double cellSizeY = 256;
    private final double cellFreqXZ = 1 / cellSizeXZ;
    private final double cellFreqY = 1 / cellSizeY;
    private final double cellTurbulenceFreqXZ = 1.0 / 512;
    private final double cellTurbulenceFreqY = 1.0 / 512;
    private final double cellTurbulenceAmp = 1;
    public CellNoiseCaveGenerator(long seedModifier) {
        this.seedModifier = seedModifier;
    }
    // note: all methods below need to be fast. Creating new CellCaveProperties is slow, don't create them here
    //       it's best to have a pre-made table/hashmap and choose from that instead
    //       if you have to create them dynamically - try caching, or contact me
    private CellCaveType caveTypeForCell(int cellX, int cellY, int cellZ, int cell, FastRandom rand) {
        if (rand.nextBoolean() && cellY < -40)
        {
            return CellCaveTypes.SMALL_CAVES;
        }
        else if (rand.nextFloat() < 0.25 && cellY < -40)
        {
            return CellCaveTypes.VERY_SMALL_CAVES;
        }
        else return CellCaveTypes.NO_CAVE;
        //else if (rand.nextBoolean()) {
        //    return CellCaveTypes.SMALL_CAVES;
        //} else {
        //    if (rand.nextBoolean())
        //        return CellCaveTypes.VERY_SMALL_CAVES;
        //    else return CellCaveTypes.TINY_CAVE;
//
        //}
    }
    private int lavaLevel(int cellX, int cellY, int cellZ, CellCaveType type, int cell, FastRandom rand) {
        if (cellY > 0) {
            return Integer.MIN_VALUE;
        }
        int avgY = (cellY);
        return randomLevel(rand, avgY, (int) (cellSizeY / 5), true);
    }

    @SuppressWarnings("Convert2MethodRef")
    private Supplier<IBlockState> lavaBlock(int cellX, int cellY, int cellZ, CellCaveType type, int cell, FastRandom rand) {
        Block[] blocks = {
                ModBlocks.IRON_LAVA_FLUID
        };
        Block block = blocks[rand.nextInt(blocks.length)];
        return () -> block.getDefaultState();
    }

    @SuppressWarnings("Convert2MethodRef")
    private Supplier<IBlockState> airBlock(int cellX, int cellY, int cellZ, CellCaveType type, int cell, FastRandom rand) {
        return () -> Blocks.AIR.getDefaultState();
    }
    /**
     * @param averageY average Y level
     * @param spread how spread out from averageY the output should be.
     * @param gaussian if false, follow uniform distribution from averageY-spready to averageY+spread
     * if true, lava spread will follow normal (gaussian) distribution, see
     * <a href="https://en.wikipedia.org/wiki/Normal_distribution">Normal_distribution (wikipedia)</a>
     * <p>
     * ie. most values will be closer to the average specifically:
     *     68% will be within fillSpread from average (one sigma)
     *     95% will be within 2*fillSpread from average (two sigma)
     *     99.7% will be within 3*fillSpread from average (three sigma)
     *     values 6 fillSpread distances from average theoretically have one in 500,000,000 chance
     *     see: <a href="https://en.wikipedia.org/wiki/68%E2%80%9395%E2%80%9399.7_rule">68–95–99.7 rule (wikipedia)</a>
     */
    private int randomLevel(FastRandom rand, int averageY, int spread, boolean gaussian) {
        if (spread < 0) {
            return Integer.MIN_VALUE;
        }
        if (gaussian) {
            return (int) (averageY + rand.nextGaussian() * spread);
        } else {
            return rand.nextInt(averageY - spread, averageY + spread + 1);
        }
    }
    @Override public void generate(World world, CubePrimer cubePrimer, CubePos cubePos) {
        int cubeX = cubePos.getX();
        int cubeY = cubePos.getY();
        int cubeZ = cubePos.getZ();
        long worldSeed = world.getSeed();
        BlockPos start = new BlockPos(cubeX * 4, cubeY * 4, cubeZ * 4);
        BlockPos end = start.add(4, 4, 4);
        generateScaled(worldSeed ^ seedModifier, start, end, new Vec3i(4, 4, 4),
                (x, y, z, value, lavaY, lavaBlock, airBlock, cell, cellType, cellX, cellY, cellZ) -> {
                    int blockY = y;
                    x = Coords.blockToLocal(x);
                    y = Coords.blockToLocal(y);
                    z = Coords.blockToLocal(z);
                    if (value > 0) {
                        if (blockY <= lavaY) {
                            cubePrimer.setBlockState(x, y, z, lavaBlock.get());
                        } else {
                            cubePrimer.setBlockState(x, y, z, airBlock.get());
                        }
                    }
                });
    }
    public void finalCaveNoise(long seed, int x, int y, int z, CaveSample out, FastRandom rand) {
        CellGenerator.CellValue cellValue = getCellValue(seed, x, y, z);
        int cellX = MathHelper.floor(cellValue.cellX * cellSizeXZ);
        int cellY = MathHelper.floor(cellValue.cellY * cellSizeY);
        int cellZ = MathHelper.floor(cellValue.cellZ * cellSizeXZ);
        rand.setSeed(cellValue.cell);
        CellCaveType type = caveTypeForCell(cellX, cellY, cellZ, cellValue.cell, rand);
        int perlinSeed = perlinSeed(seed);
        double caveNoise = caveNoise(perlinSeed + 1024, x, y, z, type);
        double placementNoise = placementNoise(perlinSeed + 1025, x, y, z, type);
        double cellNoiseFactor = MathHelper.clamp(cellValue.distanceFromEdge * type.cellWallTransitionHardness, 0, 1);
        out.noise = placementNoise * caveNoise * cellNoiseFactor - type.transitionConstant2;
        out.cellX = cellX;
        out.cellY = cellY;
        out.cellZ = cellZ;
        out.cell = cellValue.cell;
        out.cellType = type;
    }
    private CellGenerator.CellValue getCellValue(long seed, int x, int y, int z) {
        double tx = turbulence(seed + 1, x, y, z);
        double ty = turbulence(seed + 2, x, y, z);
        double tz = turbulence(seed + 3, x, y, z);
        return CellGenerator.generate(seed, x * cellFreqXZ + tx, y * cellFreqY + ty, z * cellFreqXZ + tz, null);
    }
    private double turbulence(long seed, int x, int y, int z) {
        return perlin((int) seed, x * cellTurbulenceFreqXZ, y * cellTurbulenceFreqY, z * cellTurbulenceFreqXZ, cellTurbulenceAmp, 0.5, 2, 6);
    }
    private double caveNoise(int seed, int x, int y, int z, CellCaveType properties) {
        double freq = properties.caveScale;
        double v = perlin(seed, x * freq, y * freq, z * freq, properties.perlinCaveNoiseFactor, 0.5, 2, properties.caveOctaves);
        if (y > properties.yCutoffMax) {
            v += (properties.yCutoffMax - y) * properties.yCutoffFactorCaveMax;
        } else if (y < properties.yCutoffMin) {
            v += (y - properties.yCutoffMin) * properties.yCutoffFactorCaveMin;
        }
        v += properties.caveFillConstant;
        return v;
    }
    private double placementNoise(int seed, int x, int y, int z, CellCaveType properties) {
        if (properties.placementOctaves == 0) {
            return 1.0;
        }
        double freq = properties.placementScale;
        double v = perlin(seed, x * freq, y * freq, z * freq, properties.perlinPlacementNoiseFactor, 0.5, 2, properties.placementOctaves);
        v = Math.abs(v) - properties.caveSystemSizeFactor;
        if (y > properties.yCutoffMax) {
            v += (properties.yCutoffMax - y) * properties.yCutoffFactorPlacementMax;
        } else if (y < properties.yCutoffMin) {
            v += (y - properties.yCutoffMin) * properties.yCutoffFactorPlacementMin;
        }
        v *= properties.transitionConstant1;
        return MathHelper.clamp(v, 0, 1);
    }
    private static double perlin(int seed, double x, double y, double z, double amplitude, double persistence, double lacunarity, int octaves) {
        double total = 0;
        for (int i = 0; i < octaves - 1; i++) {
            total += (Noise.gradientCoherentNoise3D(x, y, z, seed, NoiseQuality.BEST) * 2 - 1) * amplitude;
            amplitude *= persistence;
            x *= lacunarity;
            y *= lacunarity;
            z *= lacunarity;
        }
        total += Noise.gradientCoherentNoise3D(x, y, z, seed, NoiseQuality.BEST) * amplitude;
        return total;
    }
    private static int perlinSeed(long seed) {
        return ((int) seed) ^ ((int) (seed >>> 32));
    }
    public void generateScaled(
            long seed,
            Vec3i startUnscaled, Vec3i endUnscaled,
            Vec3i scale,
            NoiseConsumer consumer) {
        if (scale.getZ() != scale.getX()) {
            throw new UnsupportedOperationException("X and Z scale must be the same!");
        }
        int minX = startUnscaled.getX();
        int minY = startUnscaled.getY();
        int minZ = startUnscaled.getZ();
        int maxX = endUnscaled.getX();
        int maxY = endUnscaled.getY();
        int maxZ = endUnscaled.getZ();
        int xSize = maxX - minX + 2;
        int ySize = maxY - minY + 2;
        int zSize = maxZ - minZ + 2;
        int xScale = scale.getX();
        int yScale = scale.getY();
        int zScale = scale.getZ();
        double stepX = 1.0 / xScale;
        double stepY = 1.0 / yScale;
        double stepZ = 1.0 / zScale;
        final double[] noiseSamples = new double[xSize * ySize * zSize];
        final int[] cellXYZV = new int[xSize * ySize * zSize * 4];
        final CellCaveType[] cellTypes = new CellCaveType[xSize * ySize * zSize];
        CaveSample tmp = new CaveSample();
        FastRandom rand = new FastRandom();
        for (int sectionY = minY; sectionY <= maxY; ++sectionY) {
            int yIdx = (sectionY - minY) * zSize;
            int y = sectionY * yScale;
            for (int sectionZ = minZ; sectionZ <= maxZ; ++sectionZ) {
                int yzIdx = (yIdx + sectionZ - minZ) * xSize;
                int z = sectionZ * zScale;
                for (int sectionX = minX; sectionX <= maxX; ++sectionX) {
                    int idx = yzIdx + sectionX - minX;
                    int x = sectionX * xScale;
                    finalCaveNoise(seed, x, y, z, tmp, rand);
                    noiseSamples[idx] = tmp.noise;
                    cellXYZV[idx<<2] = tmp.cellX;
                    cellXYZV[idx<<2|1] = tmp.cellY;
                    cellXYZV[idx<<2|2] = tmp.cellZ;
                    cellXYZV[idx<<2|3] = tmp.cell;
                    cellTypes[idx] = tmp.cellType;
                }
            }
        }
        for (int sectionY = minY; sectionY < maxY; ++sectionY) {
            int y0idx = (sectionY - minY) * zSize;
            int y1idx = (sectionY - minY + 1) * zSize;
            int y = sectionY * yScale;
            for (int sectionZ = minZ; sectionZ < maxZ; ++sectionZ) {
                int y0z0idx = (y0idx + sectionZ - minZ) * xSize;
                int y0z1idx = (y0idx + sectionZ - minZ + 1) * xSize;
                int y1z0idx = (y1idx + sectionZ - minZ) * xSize;
                int y1z1idx = (y1idx + sectionZ - minZ + 1) * xSize;
                int z = sectionZ * zScale;
                for (int sectionX = minX; sectionX < maxX; ++sectionX) {
                    int x0y0z0idx = y0z0idx + sectionX - minX;
                    int x0y0z1idx = y0z1idx + sectionX - minX;
                    int x0y1z0idx = y1z0idx + sectionX - minX;
                    int x0y1z1idx = y1z1idx + sectionX - minX;
                    int x = sectionX * xScale;
                    CellCaveType mType = cellTypes[x0y0z0idx];
                    if (mType == CellCaveTypes.NO_CAVE) {
                        continue;
                    }
                    final double v000 = noiseSamples[x0y0z0idx];
                    final double v001 = noiseSamples[x0y0z1idx];
                    final double v010 = noiseSamples[x0y1z0idx];
                    final double v011 = noiseSamples[x0y1z1idx];
                    final double v100 = noiseSamples[x0y0z0idx + 1];
                    final double v101 = noiseSamples[x0y0z1idx + 1];
                    final double v110 = noiseSamples[x0y1z0idx + 1];
                    final double v111 = noiseSamples[x0y1z1idx + 1];
                    double v0y0 = v000;
                    double v0y1 = v001;
                    double v1y0 = v100;
                    double v1y1 = v101;
                    final double d_dy__0y0 = (v010 - v000) * stepY;
                    final double d_dy__0y1 = (v011 - v001) * stepY;
                    final double d_dy__1y0 = (v110 - v100) * stepY;
                    final double d_dy__1y1 = (v111 - v101) * stepY;
                    int mCellX = cellXYZV[x0y0z0idx<<2];
                    int mCellY = cellXYZV[x0y0z0idx<<2|1];
                    int mCellZ = cellXYZV[x0y0z0idx<<2|2];
                    int mCellV = cellXYZV[x0y0z0idx<<2|3];
                    rand.setSeed(mCellV + 1);
                    int lavaLevel = lavaLevel(mCellX, mCellY, mCellZ, mType, mCellV, rand);
                    Supplier<IBlockState> lavaBlock = lavaBlock(mCellX, mCellY, mCellZ, mType, mCellV, rand);
                    Supplier<IBlockState> airBlock = airBlock(mCellX, mCellY, mCellZ, mType, mCellV, rand);
                    for (int yRel = 0; yRel < yScale; ++yRel) {
                        double vxy0 = v0y0;
                        double vxy1 = v0y1;
                        final double d_dx__xy0 = (v1y0 - v0y0) * stepX;
                        final double d_dx__xy1 = (v1y1 - v0y1) * stepX;
                        for (int xRel = 0; xRel < xScale; ++xRel) {
                            final double d_dz__xyz = (vxy1 - vxy0) * stepZ;
                            double vxyz = vxy0;
                            for (int zRel = 0; zRel < zScale; ++zRel) {
                                consumer.accept(x + xRel, y + yRel, z + zRel, vxyz, lavaLevel, lavaBlock, airBlock, mCellV, mType,
                                        mCellX, mCellY, mCellZ);
                                vxyz += d_dz__xyz;
                            }
                            vxy0 += d_dx__xy0;
                            vxy1 += d_dx__xy1;
                        }
                        v0y0 += d_dy__0y0;
                        v0y1 += d_dy__0y1;
                        v1y0 += d_dy__1y0;
                        v1y1 += d_dy__1y1;
                    }
                }
            }
        }
    }
    @FunctionalInterface
    public interface NoiseConsumer {
        void accept(int x, int y, int z, double value, int lavaY,
                    Supplier<IBlockState> lavaBlock, Supplier<IBlockState> airBlock, int cell, CellCaveType cellType,
                    int cellX, int cellY, int cellZ);
    }
    public static final class CaveSample {
        double noise;
        int cellX, cellY, cellZ, cell;
        CellCaveType cellType;
    }
}