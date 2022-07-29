package com.PlanetCore.entity.model;

import com.PlanetCore.entity.EntityOnyxDemon;
import com.PlanetCore.util.Reference;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ModelOnyxDemon extends AnimatedGeoModel<EntityOnyxDemon> {
    @Override
    public ResourceLocation getModelLocation(EntityOnyxDemon entity) {
        return new ResourceLocation(Reference.MOD_ID, "geo/demon.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(EntityOnyxDemon entity) {
        return new ResourceLocation(Reference.MOD_ID, "textures/entity/onyx_demon.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(EntityOnyxDemon entity) {
        return new ResourceLocation(Reference.MOD_ID, "animations/demon.json");
    }
}


