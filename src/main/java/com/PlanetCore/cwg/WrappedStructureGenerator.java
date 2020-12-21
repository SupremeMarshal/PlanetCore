package com.PlanetCore.cwg;

import io.github.opencubicchunks.cubicchunks.api.util.CubePos;
import io.github.opencubicchunks.cubicchunks.api.worldgen.CubePrimer;
import io.github.opencubicchunks.cubicchunks.api.worldgen.structure.ICubicStructureGenerator;

import net.minecraft.world.World;

public class WrappedStructureGenerator implements ICubicStructureGenerator {
    private final ICubicStructureGenerator[] generators;

    public WrappedStructureGenerator(ICubicStructureGenerator... generators) {
        this.generators = generators;
    }

    @Override
    public void generate(World world, CubePrimer cubePrimer, CubePos cubePos) {
        for (ICubicStructureGenerator generator : generators) {
            generator.generate(world, cubePrimer, cubePos);
        }
    }

    @Override
    public void generate(World world, CubePrimer cube, CubePos cubePos, Handler handler, int range, int rangeY, int spacingBitCount, int spacingBitCountY) {
        for (ICubicStructureGenerator generator : generators) {
            generator.generate(world, cube, cubePos, handler, range, rangeY, spacingBitCount, spacingBitCountY);
        }
    }
}