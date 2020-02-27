package com.PlanetCore.fluids;

import net.minecraft.util.ResourceLocation;



public class Hot_lava extends FluidLiquid
{

	
public Hot_lava(String name, ResourceLocation still, ResourceLocation flow) 
{
	super(name, still, flow);
	this.setUnlocalizedName(name);
}

}