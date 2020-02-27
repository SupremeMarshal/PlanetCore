package com.SupremeMarshal.ToTheEarthCore.entity.render;

import com.SupremeMarshal.ToTheEarthCore.entity.EntityDemon;
import com.SupremeMarshal.ToTheEarthCore.entity.model.ModelDemon;
import com.SupremeMarshal.ToTheEarthCore.util.Reference;

import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderDemon extends RenderLiving<EntityDemon> {

	public static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/entity/demon.png");
	
	public RenderDemon(RenderManager manager) {
		super(manager, new ModelDemon(), 1.0F);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected ResourceLocation getEntityTexture(EntityDemon entity) {
		// TODO Auto-generated method stub
		return TEXTURES;
	}
	
	@Override
	protected void applyRotations(EntityDemon entityLiving, float p_77043_2_, float rotationYaw, float partialTicks) 
	{
		super.applyRotations(entityLiving, p_77043_2_, rotationYaw, partialTicks);
	}
}
