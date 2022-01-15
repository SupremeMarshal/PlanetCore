package com.PlanetCore.cwg;

import com.PlanetCore.init.ModBlocks;
import io.github.opencubicchunks.cubicchunks.api.util.Coords;
import io.github.opencubicchunks.cubicchunks.api.util.CubePos;
import io.github.opencubicchunks.cubicchunks.api.world.ICube;
import io.github.opencubicchunks.cubicchunks.api.worldgen.CubePrimer;
import io.github.opencubicchunks.cubicchunks.api.worldgen.structure.ICubicStructureGenerator;
import io.github.opencubicchunks.cubicchunks.cubicgen.blue.endless.jankson.api.DeserializationException;
import io.github.opencubicchunks.cubicchunks.cubicgen.customcubic.CustomGeneratorSettings;
import io.github.opencubicchunks.cubicchunks.cubicgen.customcubic.builder.IBuilder;
import io.github.opencubicchunks.cubicchunks.cubicgen.customcubic.builder.NoiseSource;
import io.github.opencubicchunks.cubicchunks.cubicgen.preset.fixer.CustomGeneratorSettingsFixer;
import io.github.opencubicchunks.cubicchunks.cubicgen.preset.fixer.PresetLoadError;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3i;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;

import java.util.Map;

public class NoiseCaveGenerator2 implements ICubicStructureGenerator {
    //V17
    private IBuilder builder;
    private IBlockState stoneBlock;

    public NoiseCaveGenerator2() {
    }

    @Override
    public void generate(World world, CubePrimer cubePrimer, CubePos cubePos) {
        if (this.builder == null) {
            double scaleFactor = 2;

            // the scale for caves when they generate
            // smaller value = bigger caves
            double caveScale = scaleFactor * 1 / 50.0;
            // the scale for placement
            // 2/placementScale should be roughly the average distance between cave systems
            double placementScale = scaleFactor * 1 / 1024.0;
            // bigger value = smaller cave systems
            // value 0f 0 means that all of the world will be cave systems
            // values above 0.5 are expected to make them unusably small
            // value 1 and above means they won't generate
            double caveSystemSizeFactor = 0.27;


            // bigger values = less smooth transition on the edges of cave system
            double transitionConstant1 = 40;
            // bigger value means smoother transitions at the edges, but also smaller cave systems (in a way similar to caveSystemSizeFactor)
            double transitionConstant2 = 0.07;

            // bigger value = finer detail for caves. Adding 1 = double the detail
            int caveOctaves = 8;
            // bigger value = finer detail for placement. Adding 1 = double the detail
            int placementOctaves = 8;

            // bigger values -> caves are more filled with air and less with stone
            double caveFillConstant = 0.0;

            // caves will begin to get smaller above this height
            double yCutoff = -32;
            // specifies how quickly they will get smaller as you go up
            double yCutoffFactor1 = 0.004;
            // specifies how quickly cave systems become smaller as you go up
            double yCutoffFactor2 = 0.004;

            IBuilder caveNoise = NoiseSource.perlin().frequency(caveScale).octaves(caveOctaves).normalizeTo(-1, 1).seed(world.getSeed() + 1024).create()
                    .add((x, y, z) -> y < yCutoff ? 0 : ((yCutoff - y) * yCutoffFactor1));
            IBuilder placementNoise = NoiseSource.perlin().frequency(placementScale).octaves(placementOctaves).normalizeTo(-1, 1).seed(world.getSeed() + 1025).create()
                    .apply(Math::abs).sub(caveSystemSizeFactor)
                    .add((x, y, z) -> y < yCutoff ? 0 : ((yCutoff - y) * yCutoffFactor2))
                    .mul(transitionConstant1).clamp(0, 1);
            this.builder = placementNoise.mul(caveNoise.add(caveFillConstant)).sub(transitionConstant2);
            this.stoneBlock = findStoneBlock(world.getWorldInfo().getGeneratorOptions(), cubePos);
        }
        int cubeX = cubePos.getX();
        int cubeY = cubePos.getY();
        int cubeZ = cubePos.getZ();

        BlockPos start = new BlockPos(cubeX * 4, cubeY * 4, cubeZ * 4);
        BlockPos end = start.add(4, 4, 4);
        builder.forEachScaled(start, end, new Vec3i(4, 4, 4), (x, y, z, gradX, gradY, gradZ, value) -> {
            int blockX = x;
            int blockY = y;
            int blockZ = z;
            x = Coords.blockToLocal(x);
            y = Coords.blockToLocal(y);
            z = Coords.blockToLocal(z);
            boolean skip = false;
            if (y != ICube.SIZE - 1) {
                if (!cubePrimer.getBlockState(x, y, z).getMaterial().isLiquid() && cubePrimer.getBlockState(x, y + 1, z).getMaterial().isLiquid()) {
                    cubePrimer.setBlockState(x, y, z, stoneBlock);
                    skip = true;
                }
            }
            if (cubePrimer.getBlockState(x, y, z).getMaterial().isLiquid()) {
                skip = true;
            }

            if (!skip) {
                if (value > 0) {
                    cubePrimer.setBlockState(x, y, z, ModBlocks.AIR_NO_PRESSURE.getDefaultState());
                }
                else {
                    if (value + gradY > 0) {
                        Biome biome = world.getBiomeProvider().getBiome(new BlockPos(blockX, blockY, blockZ));
                        if (cubePrimer.getBlockState(x, y, z) == biome.fillerBlock) {
                            cubePrimer.setBlockState(x, y, z, biome.topBlock);
                        }
                    }
                }
            }
        });
    }

    private IBlockState findStoneBlock(String generatorOptions, CubePos cubePos) {
        try {
            CustomGeneratorSettings settings = CustomGeneratorSettingsFixer.INSTANCE.fixPreset(generatorOptions);
            return findStoneBlock(settings, cubePos);
        } catch (PresetLoadError | DeserializationException err) {
            throw new RuntimeException(err);
        }
    }

    private IBlockState findStoneBlock(CustomGeneratorSettings settings, CubePos cubePos) {
        for (Map.Entry<CustomGeneratorSettings.IntAABB, CustomGeneratorSettings> layer : settings.cubeAreas.map) {
            if (layer.getKey().contains(cubePos.getX(), cubePos.getY(), cubePos.getZ())) {
                return findStoneBlock(layer.getValue(), cubePos);
            }
        }
        return settings.replacerConfig.getBlockstate("cubicgen", "terrain_fill_block", Blocks.STONE.getDefaultState());
    }
}