package com.PlanetCore.cwg;

import io.github.opencubicchunks.cubicchunks.api.worldgen.structure.event.InitCubicStructureGeneratorEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class CustomCaveInjector {
    @SubscribeEvent
    public void inject(InitCubicStructureGeneratorEvent event) {
        switch (event.getType()) {
            case CAVE:
                event.setNewGen(new ImprovedCaveGenerator());
                break;
        }
    }
}
