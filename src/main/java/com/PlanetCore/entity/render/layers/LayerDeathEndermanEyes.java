package com.SupremeMarshal.ToTheEarthCore.entity.render.layers;

import com.SupremeMarshal.ToTheEarthCore.entity.EntityDeathEnderman;
import com.SupremeMarshal.ToTheEarthCore.entity.render.RenderDeathEnderman;
import com.SupremeMarshal.ToTheEarthCore.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerDeathEndermanEyes implements LayerRenderer<EntityDeathEnderman>
{
    private static final ResourceLocation RES_ENDERMAN_EYES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/death_enderman_eyes.png");
    private final RenderDeathEnderman deathendermanRenderer;

    public LayerDeathEndermanEyes(RenderDeathEnderman DeathendermanRendererIn)
    {
        this.deathendermanRenderer = DeathendermanRendererIn;
    }

    public void doRenderLayer(EntityDeathEnderman entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
        this.deathendermanRenderer.bindTexture(RES_ENDERMAN_EYES);
        GlStateManager.enableBlend();
        GlStateManager.disableAlpha();
        GlStateManager.blendFunc(GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ONE);
        GlStateManager.disableLighting();
        GlStateManager.depthMask(!entitylivingbaseIn.isInvisible());
        int i = 61680;
        int j = 61680;
        int k = 0;
        OpenGlHelper.setLightmapTextureCoords(OpenGlHelper.lightmapTexUnit, 61680.0F, 0.0F);
        GlStateManager.enableLighting();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        Minecraft.getMinecraft().entityRenderer.setupFogColor(true);
        this.deathendermanRenderer.getMainModel().render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
        Minecraft.getMinecraft().entityRenderer.setupFogColor(false);
        this.deathendermanRenderer.setLightmap(entitylivingbaseIn);
        GlStateManager.depthMask(true);
        GlStateManager.disableBlend();
        GlStateManager.enableAlpha();
    }



    public boolean shouldCombineTextures()
    {
        return false;
    }
}