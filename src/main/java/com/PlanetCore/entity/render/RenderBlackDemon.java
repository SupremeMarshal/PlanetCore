package com.PlanetCore.entity.render;

import com.PlanetCore.entity.EntityBlackDemon;
import com.PlanetCore.entity.model.ModelBlackDemon;
import com.PlanetCore.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderBlackDemon extends RenderLiving<EntityBlackDemon> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/blackdemon.png");
	
	public RenderBlackDemon(RenderManager manager) {
		super(manager, new ModelBlackDemon(), 1.0F);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected ResourceLocation getEntityTexture(EntityBlackDemon entity) {
		// TODO Auto-generated method stub
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityBlackDemon entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) 
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
