package com.PlanetCore.init;

import com.PlanetCore.fluids.FluidLiquid;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

public class ModFluids
{
	public static final Fluid IRON_LAVA_FLUID = new FluidLiquid("iron_lava", new ResourceLocation("planetcore:blocks/iron_lava_still"), new ResourceLocation("planetcore:blocks/iron_lava_flow")).setTemperature(2000);
	public static final Fluid SUPERHEATED_LAVA_FLUID = new FluidLiquid("superheated_lava", new ResourceLocation("planetcore:blocks/superheated_lava_still"), new ResourceLocation("planetcore:blocks/superheated_lava_flow")).setTemperature(6000);
	public static final Fluid REDSTONE_LAVA_FLUID = new FluidLiquid("redstone_lava", new ResourceLocation("planetcore:blocks/redstone_lava_still"), new ResourceLocation("planetcore:blocks/redstone_lava_flow")).setTemperature(2000);
	public static final Fluid SILVER_LAVA_FLUID = new FluidLiquid("silver_lava", new ResourceLocation("planetcore:blocks/silver_lava_still"), new ResourceLocation("planetcore:blocks/silver_lava_flow")).setTemperature(2000);
	public static final Fluid GOLD_LAVA_FLUID = new FluidLiquid("gold_lava", new ResourceLocation("planetcore:blocks/gold_lava_still"), new ResourceLocation("planetcore:blocks/gold_lava_flow")).setTemperature(2500);
	public static final Fluid DIAMOND_LAVA_FLUID = new FluidLiquid("diamond_lava", new ResourceLocation("planetcore:blocks/diamond_lava_still"), new ResourceLocation("planetcore:blocks/diamond_lava_flow")).setTemperature(4000);
	public static final Fluid TITANIUM_LAVA_FLUID = new FluidLiquid("titanium_lava", new ResourceLocation("planetcore:blocks/titanium_lava_still"), new ResourceLocation("planetcore:blocks/titanium_lava_flow")).setTemperature(4000);
	public static final Fluid URANIUM_LAVA_FLUID = new FluidLiquid("uranium_lava", new ResourceLocation("planetcore:blocks/uranium_lava_still"), new ResourceLocation("planetcore:blocks/uranium_lava_flow")).setTemperature(4000);
	public static final Fluid TUNGSTEN_LAVA_FLUID = new FluidLiquid("tungsten_lava", new ResourceLocation("planetcore:blocks/tungsten_lava_still"), new ResourceLocation("planetcore:blocks/tungsten_lava_flow")).setTemperature(5000);
	public static final Fluid RUBY_LAVA_FLUID = new FluidLiquid("ruby_lava", new ResourceLocation("planetcore:blocks/ruby_lava_still"), new ResourceLocation("planetcore:blocks/ruby_lava_flow")).setTemperature(6000);
	public static final Fluid SAPPHIRE_LAVA_FLUID = new FluidLiquid("sapphire_lava", new ResourceLocation("planetcore:blocks/sapphire_lava_still"), new ResourceLocation("planetcore:blocks/sapphire_lava_flow")).setTemperature(6000);
	public static final Fluid MAJORITE_LAVA_FLUID = new FluidLiquid("majorite_lava", new ResourceLocation("planetcore:blocks/majorite_lava_still"), new ResourceLocation("planetcore:blocks/majorite_lava_flow")).setTemperature(7000);
	public static final Fluid AMAZONITE_LAVA_FLUID = new FluidLiquid("amazonite_lava", new ResourceLocation("planetcore:blocks/amazonite_lava_still"), new ResourceLocation("planetcore:blocks/amazonite_lava_flow")).setTemperature(8000);
	public static final Fluid ONYX_LAVA_FLUID = new FluidLiquid("onyx_lava", new ResourceLocation("planetcore:blocks/onyx_lava_still"), new ResourceLocation("planetcore:blocks/onyx_lava_flow")).setTemperature(9000);
	public static final Fluid PAINITE_LAVA_FLUID = new FluidLiquid("painite_lava", new ResourceLocation("planetcore:blocks/painite_lava_still"), new ResourceLocation("planetcore:blocks/painite_lava_flow")).setTemperature(10000);
	public static void registerFluids()
	{
		registerFluid(IRON_LAVA_FLUID);
		registerFluid(SUPERHEATED_LAVA_FLUID);
		registerFluid(REDSTONE_LAVA_FLUID);
		registerFluid(SILVER_LAVA_FLUID);
		registerFluid(GOLD_LAVA_FLUID);
		registerFluid(DIAMOND_LAVA_FLUID);
		registerFluid(TITANIUM_LAVA_FLUID);
		registerFluid(URANIUM_LAVA_FLUID);
		registerFluid(TUNGSTEN_LAVA_FLUID);
		registerFluid(RUBY_LAVA_FLUID);
		registerFluid(SAPPHIRE_LAVA_FLUID);
		registerFluid(MAJORITE_LAVA_FLUID);
		registerFluid(AMAZONITE_LAVA_FLUID);
		registerFluid(ONYX_LAVA_FLUID);
		registerFluid(PAINITE_LAVA_FLUID);
	}
	public static void registerFluid(Fluid fluid)
	{
		FluidRegistry.registerFluid(fluid);
		FluidRegistry.addBucketForFluid(fluid);
	}
}
