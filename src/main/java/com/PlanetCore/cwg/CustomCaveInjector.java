package com.PlanetCore.cwg;

import com.PlanetCore.cwg.cell.CellNoiseCaveGenerator;
import com.PlanetCore.cwg.cell.CellNoiseOreCaveGenerator;
import com.PlanetCore.cwg.cell.CellNoiseRareOreCaveGenerator;
import com.PlanetCore.cwg.cell.CellNoiseRockBiomeGenerator;
import io.github.opencubicchunks.cubicchunks.api.worldgen.structure.event.InitCubicStructureGeneratorEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CustomCaveInjector {
    @SubscribeEvent
    public void inject(InitCubicStructureGeneratorEvent event) {
        switch (event.getType()) {
            case CAVE:
                event.setNewGen(new WrappedStructureGenerator(
                        //new GemsCaveGenerator(),
                        new CellNoiseRockBiomeGenerator(1233),
                        new CellNoiseOreCaveGenerator(1234),
                        new CellNoiseRareOreCaveGenerator(1235),
                        new CellNoiseCaveGenerator(1236),
                        new ImprovedCaveGenerator()



                ));
                break;
            case RAVINE:
                event.setNewGen(new RavineGeneratorProxy());
                break;
        }
    }
}