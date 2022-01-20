package com.PlanetCore.init;

import com.PlanetCore.fluids.FluidLiquid;

import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids
{
	public static final Fluid ALUMINIUM_LAVA_FLUID = new FluidLiquid("aluminium_lava", new ResourceLocation("planetcore:blocks/aluminium_lava_still"), new ResourceLocation("planetcore:blocks/aluminium_lava_flow"));
	public static final Fluid IRON_LAVA_FLUID = new FluidLiquid("iron_lava", new ResourceLocation("planetcore:blocks/iron_lava_still"), new ResourceLocation("planetcore:blocks/iron_lava_flow"));
	public static final Fluid TIN_LAVA_FLUID = new FluidLiquid("tin_lava", new ResourceLocation("planetcore:blocks/tin_lava_still"), new ResourceLocation("planetcore:blocks/tin_lava_flow"));
	public static final Fluid COPPER_LAVA_FLUID = new FluidLiquid("copper_lava", new ResourceLocation("planetcore:blocks/copper_lava_still"), new ResourceLocation("planetcore:blocks/copper_lava_flow"));
	public static final Fluid SILVER_LAVA_FLUID = new FluidLiquid("silver_lava", new ResourceLocation("planetcore:blocks/silver_lava_still"), new ResourceLocation("planetcore:blocks/silver_lava_flow"));
	public static final Fluid GOLD_LAVA_FLUID = new FluidLiquid("gold_lava", new ResourceLocation("planetcore:blocks/gold_lava_still"), new ResourceLocation("planetcore:blocks/gold_lava_flow"));
	public static final Fluid DIAMOND_LAVA_FLUID = new FluidLiquid("diamond_lava", new ResourceLocation("planetcore:blocks/diamond_lava_still"), new ResourceLocation("planetcore:blocks/diamond_lava_flow"));
	public static final Fluid TITANIUM_LAVA_FLUID = new FluidLiquid("titanium_lava", new ResourceLocation("planetcore:blocks/titanium_lava_still"), new ResourceLocation("planetcore:blocks/titanium_lava_flow"));
	public static final Fluid URANIUM_LAVA_FLUID = new FluidLiquid("uranium_lava", new ResourceLocation("planetcore:blocks/uranium_lava_still"), new ResourceLocation("planetcore:blocks/uranium_lava_flow"));
	public static final Fluid TUNGSTEN_LAVA_FLUID = new FluidLiquid("tungsten_lava", new ResourceLocation("planetcore:blocks/tungsten_lava_still"), new ResourceLocation("planetcore:blocks/tungsten_lava_flow"));
	public static final Fluid TOPAZ_LAVA_FLUID = new FluidLiquid("topaz_lava", new ResourceLocation("planetcore:blocks/topaz_lava_still"), new ResourceLocation("planetcore:blocks/topaz_lava_flow"));
	public static final Fluid JADE_LAVA_FLUID = new FluidLiquid("jade_lava", new ResourceLocation("planetcore:blocks/jade_lava_still"), new ResourceLocation("planetcore:blocks/jade_lava_flow"));
	public static final Fluid RUBY_LAVA_FLUID = new FluidLiquid("ruby_lava", new ResourceLocation("planetcore:blocks/ruby_lava_still"), new ResourceLocation("planetcore:blocks/ruby_lava_flow"));
	public static final Fluid SAPPHIRE_LAVA_FLUID = new FluidLiquid("sapphire_lava", new ResourceLocation("planetcore:blocks/sapphire_lava_still"), new ResourceLocation("planetcore:blocks/sapphire_lava_flow"));
	public static final Fluid OLIVINE_LAVA_FLUID = new FluidLiquid("olivine_lava", new ResourceLocation("planetcore:blocks/olivine_lava_still"), new ResourceLocation("planetcore:blocks/olivine_lava_flow"));
	public static final Fluid WADSLEYITE_LAVA_FLUID = new FluidLiquid("wadsleyite_lava", new ResourceLocation("planetcore:blocks/wadsleyite_lava_still"), new ResourceLocation("planetcore:blocks/wadsleyite_lava_flow"));
	public static final Fluid RINGWOODITE_LAVA_FLUID = new FluidLiquid("ringwoodite_lava", new ResourceLocation("planetcore:blocks/ringwoodite_lava_still"), new ResourceLocation("planetcore:blocks/ringwoodite_lava_flow"));
	public static final Fluid BRIGMANITE_LAVA_FLUID = new FluidLiquid("brigmanite_lava", new ResourceLocation("planetcore:blocks/brigmanite_lava_still"), new ResourceLocation("planetcore:blocks/brigmanite_lava_flow"));
	public static final Fluid MAJORITE_LAVA_FLUID = new FluidLiquid("majorite_lava", new ResourceLocation("planetcore:blocks/majorite_lava_still"), new ResourceLocation("planetcore:blocks/majorite_lava_flow"));
	public static final Fluid AMAZONITE_LAVA_FLUID = new FluidLiquid("amazonite_lava", new ResourceLocation("planetcore:blocks/amazonite_lava_still"), new ResourceLocation("planetcore:blocks/amazonite_lava_flow"));
	public static final Fluid ACTIVE_LAVA_FLUID = new FluidLiquid("active_lava", new ResourceLocation("planetcore:blocks/active_lava_still"), new ResourceLocation("planetcore:blocks/active_lava_flow"));
	public static final Fluid CORE_LAVA_FLUID = new FluidLiquid("core_lava", new ResourceLocation("planetcore:blocks/core_lava_still"), new ResourceLocation("planetcore:blocks/core_lava_flow"));
	public static final Fluid SULFURIC_ACID_FLUID = new FluidLiquid("sulfuric_acid", new ResourceLocation("planetcore:blocks/sulfuric_acid_still"), new ResourceLocation("planetcore:blocks/sulfuric_acid_flow"));
	public static final Fluid ONYX_LAVA_FLUID = new FluidLiquid("onyx_lava", new ResourceLocation("planetcore:blocks/onyx_lava_still"), new ResourceLocation("planetcore:blocks/onyx_lava_flow"));

	public static void registerFluids()
	{
		registerFluid(ALUMINIUM_LAVA_FLUID);
		registerFluid(IRON_LAVA_FLUID);
		registerFluid(TIN_LAVA_FLUID);
		registerFluid(COPPER_LAVA_FLUID);
		registerFluid(SILVER_LAVA_FLUID);
		registerFluid(GOLD_LAVA_FLUID);
		registerFluid(DIAMOND_LAVA_FLUID);
		registerFluid(TITANIUM_LAVA_FLUID);
		registerFluid(URANIUM_LAVA_FLUID);
		registerFluid(TUNGSTEN_LAVA_FLUID);
		registerFluid(TOPAZ_LAVA_FLUID);
		registerFluid(JADE_LAVA_FLUID);
		registerFluid(RUBY_LAVA_FLUID);
		registerFluid(SAPPHIRE_LAVA_FLUID);
		registerFluid(OLIVINE_LAVA_FLUID);
		registerFluid(WADSLEYITE_LAVA_FLUID);
		registerFluid(RINGWOODITE_LAVA_FLUID);
		registerFluid(BRIGMANITE_LAVA_FLUID);
		registerFluid(MAJORITE_LAVA_FLUID);
		registerFluid(AMAZONITE_LAVA_FLUID);
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
