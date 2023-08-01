package com.PlanetCore.entity.render.layers;

import com.PlanetCore.util.EmissiveUtil;
import com.PlanetCore.util.Reference;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.renderers.geo.GeoEntityRenderer;
import software.bernie.geckolib3.renderers.geo.GeoLayerRenderer;

import java.awt.*;

public class LayerOnyxDemonEyes<T extends EntityLiving & IAnimatable> extends GeoLayerRenderer<T> {


    protected GeoEntityRenderer<T> geoRendererInstance;

    public LayerOnyxDemonEyes(GeoEntityRenderer<T> renderer) {
        super(renderer);
        this.geoRendererInstance = renderer;
    }

    @Override
    public boolean shouldCombineTextures() {
        return false;
    }


    @Override
    public void render(T t, float v, float v1, float v2, float v3, float v4, float v5, software.bernie.geckolib3.core.util.Color color) {
        EmissiveUtil.preEmissiveTextureRendering();
        this.geoRendererInstance.bindTexture(new ResourceLocation(Reference.MOD_ID + ":textures/entity/onyx_demon_eyes.png"));
        GlStateManager.scale(0.33333F, 0.33333F, 0.33333F);
        this.geoRendererInstance.render(
                this.getEntityModel().getModel(new ResourceLocation(Reference.MOD_ID, "geo/demon.geo.json")),
                t,
                v,
                (float) color.getRed() / 255f,
                (float) color.getBlue() / 255f,
                (float) color.getGreen() / 255f,
                (float) color.getAlpha() / 255
        );

        EmissiveUtil.postEmissiveTextureRendering();
    }
}