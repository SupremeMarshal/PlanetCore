package com.PlanetCore.entity.render.layers;

import java.awt.Color;

import com.PlanetCore.util.EmissiveUtil;
import com.PlanetCore.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;

public class LayerOnyxDemonEyes<T extends EntityLiving & IAnimatable> extends GeoLayerRenderer<T> {


    protected GeoEntityRenderer<T> geoRendererInstance;

    public LayerOnyxDemonEyes(GeoEntityRenderer<T> renderer) {
        super(renderer);
        this.geoRendererInstance = renderer;
    }


    @Override
    public void render(T entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, Color renderColor) {

        EmissiveUtil.preEmissiveTextureRendering();
        this.geoRendererInstance.bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/entity/onyx_demon_eyes.png"));
        GlStateManager.scale(0.33333F, 0.33333F, 0.33333F);
        this.geoRendererInstance.render(
                this.getEntityModel().getModel(new ResourceLocation(Reference.MOD_ID, "geo/demon.geo.json")),
                entitylivingbaseIn,
                partialTicks,
                (float) renderColor.getRed() / 255f,
                (float) renderColor.getBlue() / 255f,
                (float) renderColor.getGreen() / 255f,
                (float) renderColor.getAlpha() / 255
        );

        EmissiveUtil.postEmissiveTextureRendering();
    }



    @Override
    public boolean shouldCombineTextures() {
        return false;
    }


}