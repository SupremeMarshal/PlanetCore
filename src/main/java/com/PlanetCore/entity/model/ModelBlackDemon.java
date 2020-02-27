package com.PlanetCore.entity.model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraft.client.renderer.GlStateManager;


/**
 * ModelBlackDemon - Either Mojang or a mod author
 * Created using Tabula 7.0.0
 */
public class ModelBlackDemon extends ModelBase {
    public double[] modelScale = new double[] { 0.7D, 0.7D, 0.6D };
    public ModelRenderer rightarm;
    public ModelRenderer leftleg;
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer rightleg;
    public ModelRenderer leftarm;
    public ModelRenderer rightarmChild;
    public ModelRenderer leftlegChild;
    public ModelRenderer bodyChild;
    public ModelRenderer bodyChild_1;
    public ModelRenderer bodyChild_2;
    public ModelRenderer tail;
    public ModelRenderer tail_1;
    public ModelRenderer tail_2;
    public ModelRenderer tail_3;
    public ModelRenderer headChild;
    public ModelRenderer headChild_1;
    public ModelRenderer headChild_2;
    public ModelRenderer headChild_3;
    public ModelRenderer headChild_4;
    public ModelRenderer headChild_5;
    public ModelRenderer headChild_6;
    public ModelRenderer rightlegChild;
    public ModelRenderer leftarmChild;

    public ModelBlackDemon() {
        this.textureWidth = 128;
        this.textureHeight = 128;
        this.leftarmChild = new ModelRenderer(this, 86, 19);
        this.leftarmChild.setRotationPoint(0.0F, 1.5F, 1.0F);
        this.leftarmChild.addBox(3.0F, 8.0F, 1.0F, 5, 16, 6, 0.0F);
        this.setRotateAngle(leftarmChild, -0.5235987755982988F, 0.0F, 0.3141592653589793F);
        this.leftleg = new ModelRenderer(this, 6, 49);
        this.leftleg.setRotationPoint(5.0F, -3.0F, 1.0F);
        this.leftleg.addBox(-4.0F, -3.0F, -2.0F, 8, 21, 7, 0.0F);
        this.setRotateAngle(leftleg, 0.03316125578789226F, 0.0F, 0.0F);
        this.tail = new ModelRenderer(this, 76, 86);
        this.tail.setRotationPoint(0.0F, 17.7F, 0.0F);
        this.tail.addBox(-4.0F, -3.0F, 0.0F, 7, 5, 16, 0.0F);
        this.setRotateAngle(tail, -0.9204866475018095F, 0.0F, 0.0F);
        this.leftarm = new ModelRenderer(this, 86, 0);
        this.leftarm.setRotationPoint(8.0F, -20.0F, 1.0F);
        this.leftarm.addBox(-1.0F, -2.0F, -3.0F, 6, 16, 6, 0.0F);
        this.setRotateAngle(leftarm, 0.2617993877991494F, 0.0F, -0.27454029133870805F);
        this.headChild_4 = new ModelRenderer(this, 38, 5);
        this.headChild_4.mirror = true;
        this.headChild_4.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headChild_4.addBox(-8.0F, -5.0F, -0.5F, 5, 5, 6, 0.0F);
        this.setRotateAngle(headChild_4, 0.17453292519943295F, -0.3141592653589793F, 0.4363323129985824F);
        this.rightleg = new ModelRenderer(this, 6, 49);
        this.rightleg.mirror = true;
        this.rightleg.setRotationPoint(-4.0F, -3.0F, 1.0F);
        this.rightleg.addBox(-4.0F, -3.0F, -2.0F, 8, 21, 7, 0.0F);
        this.setRotateAngle(rightleg, 0.017802358370342164F, 0.0F, 0.0F);
        this.headChild_6 = new ModelRenderer(this, 61, 0);
        this.headChild_6.mirror = true;
        this.headChild_6.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headChild_6.addBox(-5.5F, -11.5F, 11.0F, 2, 11, 2, 0.0F);
        this.setRotateAngle(headChild_6, 1.9896753472735356F, 0.0F, -0.5235987755982988F);
        this.rightlegChild = new ModelRenderer(this, 6, 90);
        this.rightlegChild.mirror = true;
        this.rightlegChild.setRotationPoint(0.2F, 0.0F, -1.7F);
        this.rightlegChild.addBox(-5.0F, 14.0F, -3.0F, 9, 7, 10, 0.0F);
        this.headChild_5 = new ModelRenderer(this, 56, 0);
        this.headChild_5.mirror = true;
        this.headChild_5.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headChild_5.addBox(0.0F, -10.0F, 6.0F, 3, 7, 4, 0.0F);
        this.setRotateAngle(headChild_5, 1.2042771838760875F, 0.13962634015954636F, -1.0122909661567112F);
        this.tail_3 = new ModelRenderer(this, 49, 106);
        this.tail_3.setRotationPoint(-0.5F, 0.0F, 6.0F);
        this.tail_3.addBox(-2.0F, 1.0F, 0.0F, 4, 5, 6, 0.0F);
        this.setRotateAngle(tail_3, 0.22689280275926282F, 0.0F, 0.0F);
        this.headChild_1 = new ModelRenderer(this, 38, 5);
        this.headChild_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headChild_1.addBox(3.0F, -5.0F, -0.5F, 5, 5, 6, 0.0F);
        this.setRotateAngle(headChild_1, 0.17453292519943295F, 0.3141592653589793F, -0.4363323129985824F);
        this.bodyChild_1 = new ModelRenderer(this, 52, 16);
        this.bodyChild_1.mirror = true;
        this.bodyChild_1.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bodyChild_1.addBox(-12.0F, -3.0F, -3.0F, 8, 8, 9, 0.0F);
        this.setRotateAngle(bodyChild_1, 0.0F, 0.0F, -0.24434609527920614F);
        this.headChild_2 = new ModelRenderer(this, 56, 0);
        this.headChild_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headChild_2.addBox(-3.0F, -10.0F, 6.0F, 3, 7, 4, 0.0F);
        this.setRotateAngle(headChild_2, 1.2042771838760875F, -0.13962634015954636F, 1.0122909661567112F);
        this.tail_2 = new ModelRenderer(this, 48, 88);
        this.tail_2.setRotationPoint(0.0F, 0.1F, 6.1F);
        this.tail_2.addBox(-2.0F, 2.0F, 0.0F, 3, 3, 8, 0.0F);
        this.setRotateAngle(tail_2, 0.24434609527920614F, 0.0F, 0.0F);
        this.rightarm = new ModelRenderer(this, 86, 0);
        this.rightarm.mirror = true;
        this.rightarm.setRotationPoint(-8.0F, -20.0F, 1.0F);
        this.rightarm.addBox(-5.0F, -2.0F, -3.0F, 6, 16, 6, 0.0F);
        this.setRotateAngle(rightarm, 0.2617993877991494F, 0.0F, 0.27454029133870805F);
        this.bodyChild = new ModelRenderer(this, 51, 16);
        this.bodyChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bodyChild.addBox(4.0F, -3.0F, -3.0F, 8, 8, 9, 0.0F);
        this.setRotateAngle(bodyChild, 0.0F, 0.0F, 0.24434609527920614F);
        this.rightarmChild = new ModelRenderer(this, 86, 19);
        this.rightarmChild.mirror = true;
        this.rightarmChild.setRotationPoint(0.0F, 1.5F, 1.0F);
        this.rightarmChild.addBox(-8.0F, 8.0F, 1.0F, 5, 16, 6, 0.0F);
        this.setRotateAngle(rightarmChild, -0.5235987755982988F, 0.0F, -0.3141592653589793F);
        this.bodyChild_2 = new ModelRenderer(this, 81, 53);
        this.bodyChild_2.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bodyChild_2.addBox(-7.0F, 10.3F, -3.0F, 14, 15, 9, 0.0F);
        this.head = new ModelRenderer(this, 6, 0);
        this.head.setRotationPoint(0.0F, -27.0F, -2.0F);
        this.head.addBox(-4.0F, -10.0F, -4.0F, 8, 10, 8, 0.0F);
        this.setRotateAngle(head, 0.32812189937493397F, 0.0F, 0.0F);
        this.tail_1 = new ModelRenderer(this, 47, 70);
        this.tail_1.setRotationPoint(0.0F, -2.9F, 13.5F);
        this.tail_1.addBox(-3.0F, 1.0F, 0.0F, 5, 4, 8, 0.0F);
        this.setRotateAngle(tail_1, 0.2059488517353309F, 0.0F, 0.0F);
        this.leftlegChild = new ModelRenderer(this, 6, 90);
        this.leftlegChild.setRotationPoint(-0.1F, 0.0F, -1.8F);
        this.leftlegChild.addBox(-4.0F, 14.0F, -3.0F, 9, 7, 10, 0.0F);
        this.headChild_3 = new ModelRenderer(this, 61, 0);
        this.headChild_3.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headChild_3.addBox(3.5F, -11.5F, 11.0F, 2, 11, 2, 0.0F);
        this.setRotateAngle(headChild_3, 1.9896753472735356F, 0.0F, 0.5235987755982988F);
        this.body = new ModelRenderer(this, 2, 23);
        this.body.setRotationPoint(0.0F, -27.3F, -2.0F);
        this.body.addBox(-8.0F, 0.1F, -4.0F, 16, 11, 11, 0.0F);
        this.setRotateAngle(body, 0.1884955592153876F, 0.014486232791552934F, -0.027052603405912107F);
        this.headChild = new ModelRenderer(this, 37, 0);
        this.headChild.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.headChild.addBox(-2.0F, -2.0F, -4.5F, 4, 3, 2, 0.0F);
        this.setRotateAngle(headChild, 0.20943951023931953F, 0.0F, 0.0F);
        this.leftarm.addChild(this.leftarmChild);
        this.body.addChild(this.tail);
        this.head.addChild(this.headChild_4);
        this.head.addChild(this.headChild_6);
        this.rightleg.addChild(this.rightlegChild);
        this.head.addChild(this.headChild_5);
        this.tail_2.addChild(this.tail_3);
        this.head.addChild(this.headChild_1);
        this.body.addChild(this.bodyChild_1);
        this.head.addChild(this.headChild_2);
        this.tail_1.addChild(this.tail_2);
        this.body.addChild(this.bodyChild);
        this.rightarm.addChild(this.rightarmChild);
        this.body.addChild(this.bodyChild_2);
        this.tail.addChild(this.tail_1);
        this.leftleg.addChild(this.leftlegChild);
        this.head.addChild(this.headChild_3);
        this.head.addChild(this.headChild);
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        GlStateManager.pushMatrix();
        GlStateManager.scale(1D / modelScale[0], 1D / modelScale[1], 1D / modelScale[2]);
        this.leftleg.render(f5);
        this.leftarm.render(f5);
        this.rightleg.render(f5);
        this.rightarm.render(f5);
        this.head.render(f5);
        this.body.render(f5);
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
		this.leftleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount;
		this.rightleg.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount;
		
		this.rightarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F + (float) Math.PI) * 1.4F * limbSwingAmount * 0.5F;
		this.leftarm.rotateAngleX = MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount * 0.5F;
	}
    
    
    // Here I want to get the attack animation for when the demon attack the player, I have not figured it out yet.
    
    //public void animate(EntityLiving entity, float time, float distance, float loop, float lookY, float lookX, float scale) {
    	
    	//float pi = (float)Math.PI;
        
    	// Custom Mob Check:
       // if(!(entity instanceof EntityDemon)) return;
        
        // Attack Target:
       // if EntityDemon.hasAttackTarget()) {
        //	float offsetArmHead = 0.0F;
        //	rightarm.rotateAngleY += -(0.1F - offsetArmHead * 0.6F) + head.rotateAngleY;
        //	rightarm.rotateAngleX += -((float)Math.PI / 2F) + head.rotateAngleX;
        //	rightarm.rotateAngleZ += MathHelper.cos(loop * 0.09F) * 0.05F + 0.05F;
        //	rightarm.rotateAngleX += MathHelper.sin(loop * 0.067F) * 0.05F;
      //  }
   // }
    
    
}
