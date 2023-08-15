package com.PlanetCore.cwg;

import com.PlanetCore.cwg.cell.CellNoiseCaveGenerator;
import io.github.opencubicchunks.cubicchunks.api.worldgen.structure.event.InitCubicStructureGeneratorEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CustomCaveInjector {
    @SubscribeEvent
    public void inject(InitCubicStructureGeneratorEvent event) {
        switch (event.getType()) {
            case CAVE:
                event.setNewGen(new WrappedStructureGenerator(
                        //new ImprovedCaveGenerator(),
                        //new GemsCaveGenerator(),
                        //new NoiseCaveGenerator2(),
                        //new NoiseCaveGenerator3(),
                        //new NoiseCaveGenerator4()
                        new CellNoiseCaveGenerator(1234)
                ));
                break;
            case RAVINE:
                event.setNewGen(new RavineGeneratorProxy());
                break;
        }
    }
}