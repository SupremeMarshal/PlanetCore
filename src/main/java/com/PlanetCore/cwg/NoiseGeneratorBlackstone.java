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

public class NoiseGeneratorBlackstone implements ICubicStructureGenerator {
    //V17
    private IBuilder builder;
    private IBlockState stoneBlock;
    private IBlockState oceanBlock;

    public NoiseGeneratorBlackstone() {
    }

    @Override
    public void generate(World world, CubePrimer cubePrimer, CubePos cubePos) {
        if (this.builder == null) {
            double scaleFactor = 1;
            // the scale for caves when they generate
            // smaller value = bigger caves
            double caveScale = scaleFactor * 1 / 150.0;
            // the scale for placement
            // 2/placementScale should be roughly the average distance between cave systems
            double placementScale = scaleFactor * 1 / 150.0;

            // bigger value = smaller cave systems
            // value 0f 0 means that all of the world will be cave systems
            // values above 0.5 are expected to make them unusably small
            // value 1 and above means they won't generate
            double caveSystemSizeFactor = 0.30;

            // bigger values = less smooth transition on the edges of cave system
            double transitionConstant1 = 32;
            // bigger value means smoother transitions at the edges, but also smaller cave systems (in a way similar to caveSystemSizeFactor)
            double transitionConstant2 = 6;

            // bigger value = finer detail for caves. Adding 1 = double the detail
            int caveOctaves = 8;
            // bigger value = finer detail for placement. Adding 1 = double the detail
            int placementOctaves = 8;

            // bigger values -> caves are more filled with air and less with stone
            double caveFillConstant = 32;

            // caves will begin to get smaller above this height
            double yCutoff = -500;
            // specifies how quickly they will get smaller as you go up
            double yCutoffFactor1 = 0.004;
            // specifies how quickly cave systems become smaller as you go up
            double yCutoffFactor2 = 0.004;

            // caves will begin to get smaller below this height
            double yCutoff1 = -1000;
            // specifies how quickly they will get smaller as you go down
            double yCutoffFactor3 = -0.004;
            // specifies how quickly cave systems become smaller as you go down
            double yCutoffFactor4 = -0.004;

            IBuilder caveNoise = NoiseSource.perlin().frequency(caveScale).octaves(caveOctaves).normalizeTo(-1, 1).seed(world.getSeed() + 1026).create()
                    .add((x, y, z) -> y > yCutoff ? ((yCutoff - y) * yCutoffFactor1) : y < yCutoff1 ? ((yCutoff1 - y) * yCutoffFactor3) : 0);

            IBuilder placementNoise = NoiseSource.perlin().frequency(placementScale).octaves(placementOctaves).normalizeTo(-1, 1).seed(world.getSeed() + 1027).create()
                    .apply(Math::abs).sub(caveSystemSizeFactor)
                    .add((x, y, z) -> y > yCutoff ? ((yCutoff - y) * yCutoffFactor2) : y < yCutoff1 ? ((yCutoff1 - y) * yCutoffFactor4) : 0)
                    .mul(transitionConstant1).clamp(0, 1);

            this.builder = placementNoise.mul(caveNoise.add(caveFillConstant)).sub(transitionConstant2);
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
            if (value > 0 && cubePrimer.getBlockState(x,y,z) != Blocks.AIR) {
                cubePrimer.setBlockState(x, y, z, ModBlocks.ROCK.getStateFromMeta(1));
            } else {
                if (value + gradY > 0) {
                    Biome biome = world.getBiomeProvider().getBiome(new BlockPos(blockX, blockY, blockZ));
                    if (cubePrimer.getBlockState(x, y, z) == biome.fillerBlock) {
                        cubePrimer.setBlockState(x, y, z, biome.topBlock);
                    }
                }
            }
        });
    }
}