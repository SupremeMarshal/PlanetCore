package com.PlanetCore.entity.render;

import com.PlanetCore.entity.EntityMagmaZombie;
import net.minecraft.client.model.ModelZombie;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerBipedArmor;
import net.minecraft.client.renderer.entity.layers.LayerHeldItem;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


@SideOnly(Side.CLIENT)
public class RenderMagmaZombie extends RenderLiving<EntityMagmaZombie> {
    private final ResourceLocation MAGMA_ZOMBIE_TEXTURES = new ResourceLocation("planetcore:textures/entity/magma_zombie.png");

    public RenderMagmaZombie(RenderManager manager) {
        super(manager, new ModelZombie(), 0.25F);
        // Add armor layer
        this.addLayer(new LayerBipedArmor(this) {
            @Override
            protected void initArmor() {
                this.modelLeggings = new ModelZombie(0.5F, true);
                this.modelArmor = new ModelZombie(1.0F, true);
            }
        });

        this.addLayer(new LayerHeldItem(this));
    }

    @Override
    protected ResourceLocation getEntityTexture(EntityMagmaZombie entity) {
        return MAGMA_ZOMBIE_TEXTURES;
    }
}