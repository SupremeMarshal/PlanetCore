package com.SupremeMarshal.ToTheEarthCore.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;

/**
 * ModelWolf - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelHellHound extends ModelBase {
    public double[] modelScale = new double[] { 0.8D, 0.9D, 0.9D };
    public ModelRenderer front_left_leg;
    public ModelRenderer body;
    public ModelRenderer back_body;
    public ModelRenderer Left_back_leg;
    public ModelRenderer right_back_leg;
    public ModelRenderer front_right_leg;
    public ModelRenderer tail;
    public ModelRenderer head;
    public ModelRenderer head_1;
    public ModelRenderer Left_back_feet;
    public ModelRenderer right_back_feet;
    public ModelRenderer right_ear;
    public ModelRenderer left_ear;

    public ModelHellHound() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        this.left_ear = new ModelRenderer(this, 16, 14);
        this.left_ear.setRotationPoint(0.6F, -0.8F, -1.4F);
        this.left_ear.addBox(2.0F, -5.0F, -2.0F, 2, 3, 1, 0.0F);
        this.setRotateAngle(left_ear, -0.3490658503988659F, -0.6981317007977318F, 0.13962634015954636F);
        this.Left_back_leg = new ModelRenderer(this, 0, 18);
        this.Left_back_leg.setRotationPoint(1.0F, 13.5F, 7.0F);
        this.Left_back_leg.addBox(0.0F, -2.0F, -1.0F, 4, 7, 4, 0.0F);
        this.setRotateAngle(Left_back_leg, 0.5061454830783556F, 0.08726646259971647F, 0.0F);
        this.front_left_leg = new ModelRenderer(this, 0, 18);
        this.front_left_leg.setRotationPoint(1.8F, 13.7F, -4.0F);
        this.front_left_leg.addBox(0.0F, 1.0F, -1.0F, 2, 7, 2, 0.0F);
        this.back_body = new ModelRenderer(this, 18, 14);
        this.back_body.setRotationPoint(0.0F, 12.5F, 2.5F);
        this.back_body.addBox(-3.0F, -2.0F, -3.0F, 6, 9, 6, 0.0F);
        this.setRotateAngle(back_body, 1.520181778487061F, 0.0F, 0.0F);
        this.right_back_leg = new ModelRenderer(this, 0, 18);
        this.right_back_leg.setRotationPoint(-4.0F, 13.5F, 7.0F);
        this.right_back_leg.addBox(-1.0F, -2.0F, -1.0F, 4, 7, 4, 0.0F);
        this.setRotateAngle(right_back_leg, 0.5061454830783556F, -0.08726646259971647F, 0.0F);
        this.tail = new ModelRenderer(this, 9, 18);
        this.tail.setRotationPoint(-1.0F, 12.0F, 8.3F);
        this.tail.addBox(0.0F, 0.0F, -1.0F, 2, 8, 2, 0.0F);
        this.Left_back_feet = new ModelRenderer(this, 0, 18);
        this.Left_back_feet.setRotationPoint(0.9F, 3.0F, 0.0F);
        this.Left_back_feet.addBox(-1.0F, -1.0F, 0.0F, 3, 7, 3, 0.0F);
        this.setRotateAngle(Left_back_feet, -0.7958701389094143F, 0.0F, 0.0F);
        this.right_back_feet = new ModelRenderer(this, 2, 18);
        this.right_back_feet.setRotationPoint(0.1F, 3.0F, 0.0F);
        this.right_back_feet.addBox(0.0F, -1.0F, 0.0F, 3, 7, 3, 0.0F);
        this.setRotateAngle(right_back_feet, -0.7923794804054256F, 0.0F, 0.0F);
        this.front_right_leg = new ModelRenderer(this, 0, 18);
        this.front_right_leg.setRotationPoint(-3.8F, 13.7F, -4.0F);
        this.front_right_leg.addBox(0.0F, 1.0F, -1.0F, 2, 7, 2, 0.0F);
        this.right_ear = new ModelRenderer(this, 16, 14);
        this.right_ear.setRotationPoint(-1.1F, -1.1F, -1.4F);
        this.right_ear.addBox(-2.0F, -5.0F, 0.0F, 2, 3, 1, 0.0F);
        this.setRotateAngle(right_ear, -0.3490658503988659F, 0.6981317007977318F, -0.13962634015954636F);
        this.head_1 = new ModelRenderer(this, 0, 10);
        this.head_1.setRotationPoint(-0.7F, 12.1F, -7.0F);
        this.head_1.addBox(-1.5F, 0.0F, -5.0F, 5, 3, 4, 0.0F);
        this.head = new ModelRenderer(this, 0, 0);
        this.head.setRotationPoint(-1.0F, 12.5F, -7.0F);
        this.head.addBox(-2.0F, -3.0F, -2.0F, 6, 6, 4, 0.0F);
        this.body = new ModelRenderer(this, 21, 0);
        this.body.setRotationPoint(-1.0F, 13.0F, -1.8F);
        this.body.addBox(-3.0F, -3.0F, -3.0F, 8, 6, 7, 0.0F);
        this.setRotateAngle(body, 1.5707963267948966F, 0.0F, 0.0F);
        this.head.addChild(this.left_ear);
        this.Left_back_leg.addChild(this.Left_back_feet);
        this.right_back_leg.addChild(this.right_back_feet);
        this.head.addChild(this.right_ear);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.scale(1D / modelScale[0], 1D / modelScale[1], 1D / modelScale[2]);
        this.Left_back_leg.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.front_left_leg.offsetX, this.front_left_leg.offsetY, this.front_left_leg.offsetZ);
        GlStateManager.translate(this.front_left_leg.rotationPointX * f5, this.front_left_leg.rotationPointY * f5, this.front_left_leg.rotationPointZ * f5);
        GlStateManager.scale(1.2D, 1.0D, 1.2D);
        GlStateManager.translate(-this.front_left_leg.offsetX, -this.front_left_leg.offsetY, -this.front_left_leg.offsetZ);
        GlStateManager.translate(-this.front_left_leg.rotationPointX * f5, -this.front_left_leg.rotationPointY * f5, -this.front_left_leg.rotationPointZ * f5);
        this.front_left_leg.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.back_body.offsetX, this.back_body.offsetY, this.back_body.offsetZ);
        GlStateManager.translate(this.back_body.rotationPointX * f5, this.back_body.rotationPointY * f5, this.back_body.rotationPointZ * f5);
        GlStateManager.scale(1.1D, 1.1D, 0.8D);
        GlStateManager.translate(-this.back_body.offsetX, -this.back_body.offsetY, -this.back_body.offsetZ);
        GlStateManager.translate(-this.back_body.rotationPointX * f5, -this.back_body.rotationPointY * f5, -this.back_body.rotationPointZ * f5);
        this.back_body.render(f5);
        GlStateManager.popMatrix();
        this.right_back_leg.render(f5);
        this.tail.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.front_right_leg.offsetX, this.front_right_leg.offsetY, this.front_right_leg.offsetZ);
        GlStateManager.translate(this.front_right_leg.rotationPointX * f5, this.front_right_leg.rotationPointY * f5, this.front_right_leg.rotationPointZ * f5);
        GlStateManager.scale(1.2D, 1.0D, 1.2D);
        GlStateManager.translate(-this.front_right_leg.offsetX, -this.front_right_leg.offsetY, -this.front_right_leg.offsetZ);
        GlStateManager.translate(-this.front_right_leg.rotationPointX * f5, -this.front_right_leg.rotationPointY * f5, -this.front_right_leg.rotationPointZ * f5);
        this.front_right_leg.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.head_1.offsetX, this.head_1.offsetY, this.head_1.offsetZ);
        GlStateManager.translate(this.head_1.rotationPointX * f5, this.head_1.rotationPointY * f5, this.head_1.rotationPointZ * f5);
        GlStateManager.scale(0.8D, 1.1D, 1.0D);
        GlStateManager.translate(-this.head_1.offsetX, -this.head_1.offsetY, -this.head_1.offsetZ);
        GlStateManager.translate(-this.head_1.rotationPointX * f5, -this.head_1.rotationPointY * f5, -this.head_1.rotationPointZ * f5);
        this.head_1.render(f5);
        GlStateManager.popMatrix();
        this.head.render(f5);
        GlStateManager.pushMatrix();
        GlStateManager.translate(this.body.offsetX, this.body.offsetY, this.body.offsetZ);
        GlStateManager.translate(this.body.rotationPointX * f5, this.body.rotationPointY * f5, this.body.rotationPointZ * f5);
        GlStateManager.scale(1.2D, 1.2D, 1.2D);
        GlStateManager.translate(-this.body.offsetX, -this.body.offsetY, -this.body.offsetZ);
        GlStateManager.translate(-this.body.rotationPointX * f5, -this.body.rotationPointY * f5, -this.body.rotationPointZ * f5);
        this.body.render(f5);
        GlStateManager.popMatrix();
        GlStateManager.popMatrix();
    }

    /**
     * This is a helper function from Tabula to set the rotation of model parts
     */
    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
    
    @Override
    public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn) {
    	super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
		this.head.rotateAngleY = netHeadYaw * 0.017453292F;
		this.head.rotateAngleX = headPitch * 0.017453292F;
		this.head_1.rotateAngleY = netHeadYaw * 0.017453292F;
		this.head_1.rotateAngleX = headPitch * 0.017453292F;
		this.Left_back_leg.rotateAngleX = (MathHelper.cos(limbSwing * 0.7662F) * 1.4F * limbSwingAmount) +0.29F;
		this.right_back_leg.rotateAngleX = (MathHelper.cos(limbSwing * 0.7662F + (float)Math.PI) * 1.4F * limbSwingAmount) +0.29F;
		
		this.front_right_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.7662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
		this.front_left_leg.rotateAngleX = MathHelper.cos(limbSwing * 0.7662F) * 1.4F * limbSwingAmount * 0.5F;
    }
}
