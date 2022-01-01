
package com.PlanetCore.entity.render;

import com.PlanetCore.entity.EntityCoreBlaze;
import com.PlanetCore.entity.EntityHotBlaze;
import com.PlanetCore.util.Reference;
import net.minecraft.client.model.ModelBlaze;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCoreBlaze extends RenderLiving<EntityCoreBlaze> {

    public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/core_blaze.png");

    public RenderCoreBlaze(RenderManager manager) {
        super(manager, new ModelBlaze(), 0F);
    }


    @Override
    protected ResourceLocation getEntityTexture(EntityCoreBlaze entity) {
        return TEXTURES;
    }

    @Override
    public float prepareScale(EntityCoreBlaze entitylivingbaseIn, float partialTicks) {
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(-2.0F, -2.0F, 2.0F);
        this.preRenderCallback(entitylivingbaseIn, partialTicks);
        GlStateManager.translate(0.0F, -1.7F, 0.0F);
        return 0.0625F * 1.5F;
    }
}
