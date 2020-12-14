package com.PlanetCore.cwg;

import io.github.opencubicchunks.cubicchunks.api.util.Coords;
import io.github.opencubicchunks.cubicchunks.api.util.CubePos;
import io.github.opencubicchunks.cubicchunks.api.worldgen.CubePrimer;
import io.github.opencubicchunks.cubicchunks.api.worldgen.structure.ICubicStructureGenerator;
import io.github.opencubicchunks.cubicchunks.cubicgen.customcubic.CustomGeneratorSettings;
import net.minecraft.world.World;

public class RavineGeneratorProxy implements ICubicStructureGenerator {
    protected ICubicStructureGenerator ravines;
    protected ICubicStructureGenerator giantRavines;

    @Override
    public void generate(World world, CubePrimer cubePrimer, CubePos cubePos) {
        if (this.ravines == null) { //init generators
            //we need this hack because we need the generator settings, and the populator init event doesn't provide access to them
            int maxCubeY = Coords.blockToCube(CustomGeneratorSettings.getFromWorld(world).expectedBaseHeight);
            this.ravines = new ImprovedRavineGenerator(maxCubeY);
            this.giantRavines = new GiantRavineGenerator(maxCubeY);
        }

        this.ravines.generate(world, cubePrimer, cubePos);
        this.giantRavines.generate(world, cubePrimer, cubePos);
    }
}
