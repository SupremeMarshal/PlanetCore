package com.PlanetCore.entity.model;

import com.PlanetCore.entity.EntityDemon;
import com.PlanetCore.util.Reference;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import software.bernie.geckolib3.model.AnimatedGeoModel;

public class ModelDemon extends AnimatedGeoModel<EntityDemon> {
    @Override
    public ResourceLocation getModelLocation(EntityDemon entity) {
        return new ResourceLocation(Reference.MOD_ID, "geo/demon.geo.json");
    }

    @Override
    public ResourceLocation getTextureLocation(EntityDemon entity) {
        // return new ResourceLocation(Reference.MOD_ID, "textures/entity/demon_black.png");
        return new ResourceLocation(Reference.MOD_ID, "textures/entity/demon_red.png");
    }

    @Override
    public ResourceLocation getAnimationFileLocation(EntityDemon entity) {
        return new ResourceLocation(Reference.MOD_ID, "animations/demon.json");
    }
}
