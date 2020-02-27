package com.PlanetCore.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelZombie - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelGhoul extends ModelBase {
    public ModelRenderer field_178723_h;
    public ModelRenderer field_78116_c;
    public ModelRenderer field_78115_e;
    public ModelRenderer field_178724_i;
    public ModelRenderer field_178720_f;

    public ModelGhoul() {
        this.textureWidth = 64;
        this.textureHeight = 64;
        this.field_178723_h = new ModelRenderer(this, 40, 16);
        this.field_178723_h.setRotationPoint(-5.0F, 2.0F, 0.0F);
        this.field_178723_h.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(field_178723_h, -1.3962634801864624F, -0.10000000149011613F, 0.10000000149011613F);
        this.field_178724_i = new ModelRenderer(this, 40, 16);
        this.field_178724_i.mirror = true;
        this.field_178724_i.setRotationPoint(5.0F, 2.0F, 0.0F);
        this.field_178724_i.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        this.setRotateAngle(field_178724_i, -1.3962634015954636F, 0.10000736613927509F, -0.10000736613927509F);
        this.field_78115_e = new ModelRenderer(this, 16, 16);
        this.field_78115_e.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_78115_e.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        this.field_178720_f = new ModelRenderer(this, 0, 0);
        this.field_178720_f.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_178720_f.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.5F);
        this.field_78116_c = new ModelRenderer(this, 0, 0);
        this.field_78116_c.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.field_78116_c.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.field_178723_h.render(f5);
        this.field_178724_i.render(f5);
        this.field_78115_e.render(f5);
        this.field_178720_f.render(f5);
        this.field_78116_c.render(f5);
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
