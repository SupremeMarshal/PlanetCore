package com.PlanetCore.init;

import com.PlanetCore.fluids.FluidLiquid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids
{
	public static final Fluid HOT_LAVA_FLUID = new FluidLiquid("hot_lava", new ResourceLocation("planetcore:blocks/hot_lava_still"), new ResourceLocation("planetcore:blocks/hot_lava_flow"));
	public static final Fluid ACTIVE_LAVA_FLUID = new FluidLiquid("active_lava", new ResourceLocation("planetcore:blocks/active_lava_still"), new ResourceLocation("planetcore:blocks/active_lava_flow"));
	public static final Fluid CORE_LAVA_FLUID = new FluidLiquid("core_lava", new ResourceLocation("planetcore:blocks/core_lava_still"), new ResourceLocation("planetcore:blocks/core_lava_flow"));
	public static final Fluid SULFURIC_ACID_FLUID = new FluidLiquid("sulfuric_acid", new ResourceLocation("planetcore:blocks/sulfuric_acid_still"), new ResourceLocation("planetcore:blocks/sulfuric_acid_flow"));
	public static final Fluid ONYX_LAVA_FLUID = new FluidLiquid("onyx_lava", new ResourceLocation("planetcore:blocks/onyx_lava_still"), new ResourceLocation("planetcore:blocks/onyx_lava_flow"));

	public static void registerFluids()
	{
		registerFluid(HOT_LAVA_FLUID);
		registerFluid(ACTIVE_LAVA_FLUID);
		registerFluid(CORE_LAVA_FLUID);
		registerFluid(SULFURIC_ACID_FLUID);
		registerFluid(ONYX_LAVA_FLUID);
	}
	public static void registerFluid(Fluid fluid)
	{
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}
}
