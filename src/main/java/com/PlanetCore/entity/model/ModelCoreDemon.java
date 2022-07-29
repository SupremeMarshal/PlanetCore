package com.PlanetCore.entity.model;

import com.PlanetCore.entity.EntityCoreDemon;
import com.PlanetCore.util.Reference;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ModelCoreDemon extends AnimatedGeoModel<EntityCoreDemon> {
    @Override
    public ResourceLocation getModelLocation(EntityCoreDemon entity) {
        return new ResourceLocation(Reference.MOD_ID, "geo/demon.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(EntityCoreDemon entity) {
        return new ResourceLocation(Reference.MOD_ID, "textures/entity/demon_core.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(EntityCoreDemon entity) {
        return new ResourceLocation(Reference.MOD_ID, "animations/demon.json");
    }
}


