package com.PlanetCore.items.Drills;

import com.PlanetCore.util.Reference;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class IronDrillModel extends AnimatedGeoModel<IronDrillItem> {
    @Override
    public ResourceLocation getModelLocation(IronDrillItem object) {
        return new ResourceLocation(Reference.MOD_ID, "geo/iron_drill.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(IronDrillItem object) {
        return new ResourceLocation(Reference.MOD_ID, "textures/items/iron_drill.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(IronDrillItem animatable) {
        return new ResourceLocation(Reference.MOD_ID, "animations/drill_activated.json");
    }
}
