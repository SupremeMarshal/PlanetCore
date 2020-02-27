package com.PlanetCore.entity.render;

import com.PlanetCore.entity.EntityGhoul;
import com.PlanetCore.entity.model.ModelGhoul;
import com.PlanetCore.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderGhoul extends RenderLiving<EntityGhoul> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/ghoul.png");
	
	public RenderGhoul(RenderManager manager) {
		super(manager, new ModelGhoul(), 1.0F);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected ResourceLocation getEntityTexture(EntityGhoul entity) {
		// TODO Auto-generated method stub
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityGhoul entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) 
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
