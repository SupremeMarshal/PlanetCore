package com.PlanetCore.entity.render;


import com.PlanetCore.entity.EntityHellHound;
import com.PlanetCore.entity.model.ModelHellHound;
import com.PlanetCore.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderHellHound extends RenderLiving<EntityHellHound> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/hellhound.png");
	
	public RenderHellHound(RenderManager manager) {
		super(manager, new ModelHellHound(), 1.0F);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected ResourceLocation getEntityTexture(EntityHellHound entity) {
		// TODO Auto-generated method stub
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityHellHound entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) 
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
