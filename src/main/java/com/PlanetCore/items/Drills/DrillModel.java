package com.PlanetCore.items.Drills;

import com.PlanetCore.util.Reference;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class DrillModel extends AnimatedGeoModel<DrillItem> {

    private final ResourceLocation model;
    private final ResourceLocation texture;

    private final ResourceLocation animation;
    public DrillModel(String prefix) {
        model = new ResourceLocation(Reference.MOD_ID,"geo/drill.geo.json");
        texture = new ResourceLocation(Reference.MOD_ID,"textures/items/"+prefix+".png");
        animation = new ResourceLocation(Reference.MOD_ID,"animations/drill_activated.json");
    }
    @Override
    public ResourceLocation getModelLocation(DrillItem object) {
        return model;
    }

    @Override
    public ResourceLocation getTextureLocation(DrillItem object) {
        return texture;
    }

    @Override
    public ResourceLocation getAnimationFileLocation(DrillItem animatable) {
        return animation;
    }
}
