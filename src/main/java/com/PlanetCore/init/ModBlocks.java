package com.PlanetCore.init;





import com.PlanetCore.blocks.*;

import net.minecraft.block.Block;

import net.minecraft.block.material.Material;

import net.minecraftforge.fml.common.registry.GameRegistry;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import net.minecraftforge.registries.IForgeRegistry;



import javax.annotation.Nonnull;

import java.util.ArrayList;

import java.util.List;

import java.util.Locale;

import java.util.function.Function;



@ObjectHolder("planetcore")

public class ModBlocks {



	public enum OreType {

		GEM

	}



	public enum Ore {

		ONYX(true, OreType.GEM, 900000, 36000.0, 90000.0),

		MAJORITE(true, OreType.GEM, 600000, 12000.0, 60000.0),

		BRIGMANITE(true, OreType.GEM, 500000, 4800.0, 50000.0),

		RINGWOODITE(true, OreType.GEM, 400000, 4800.0, 40000.0),

		AMAZONITE(true, OreType.GEM, 750000, 12000.0, 75000.0),

		DIAMOND(true, OreType.GEM, 500000, 4800.0, 50000.0),

		SAPPHIRE(true, OreType.GEM, 100000, 1600.0, 10000.0),

		WADSLEYITE(true, OreType.GEM, 150000, 4800., 15000.0),

		RUBY(true, OreType.GEM, 100000, 1600.0, 10000.0),

		TUNGSTEN(true, OreType.GEM, 50000, 200.0, 5000.0),

		EMERALD(true, OreType.GEM, 25000, 150.0, 2500.0),

		TITANIUM(true, OreType.GEM, 10000, 100.0, 1000.0),

		URANIUM(true, OreType.GEM, 1200, 40.0, 120.0),

		PLATINUM(true, OreType.GEM, 5000, 60.0, 500.0),

		OLIVINE(true, OreType.GEM, 4000, 2400.0, 400),

		JADE(true, OreType.GEM, 3000, 60.0, 300.0),

		TOPAZ(true, OreType.GEM, 2500, 40.0, 250.0),

		GOLD(true, OreType.GEM, 2000, 27.0, 200.0),

		SILVER(true, OreType.GEM, 600, 18.0, 60.0),

		REDSTONE(true, OreType.GEM, 10, 18.0, 1.0),

		LAPIS(true, OreType.GEM, 10, 12.0, 1.0),

		SILICON(true, OreType.GEM, 10, 10.0, 1.0),

		LEAD(true, OreType.GEM, 10, 10.0, 1.0),

		SULFUR(true, OreType.GEM, 10, 10.0, 1.0),

		IRON(true, OreType.GEM, 300, 5.0, 1.5),

		TIN(true, OreType.GEM, 100, 5.0, 1.0),

		COPPER(true, OreType.GEM, 100, 5.0, 1.0),

		COAL(true, OreType.GEM, 0, 1.5, 0.0);





		private final boolean makeOreAndBlock;

		private final OreType type;

		private final double blockResistance;

		private final double oreHardness;

		private final double oreResistance;



		Ore(boolean makeOreAndBlock, OreType type, double blockResistance, double oreHardness, double oreResistance) {

			this.makeOreAndBlock = makeOreAndBlock;

			this.type = type;

			this.blockResistance = blockResistance;

			this.oreHardness = oreHardness;

			this.oreResistance = oreResistance;

		}



		public OreType getType() {

			return this.type;

		}



		public double getBlockResistance() {

			return blockResistance;

		}



		public boolean makeOreAndBlock() {

			return makeOreAndBlock;

		}



		public double getOreHardness() {

			return oreHardness;

		}



		public double getOreResistance() {

			return oreResistance;

		}

	}



	public enum OreForm {

		BLOCK(1.0, 1.0, id -> new BlocksBase(id, Material.ROCK), id -> new BlocksBase(id, Material.ROCK)),

		ORE(1.0, 1.0, id -> new GemBase(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		HARDROCK(3.3F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		HARDROCK1(5.5F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		HARDROCK2(8.1F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		DEEPROCK(11.2F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		DEEPROCK1(14.9F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		DEEPROCK2(19.4F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		CRUSTROCK(24.7F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		CRUSTROCK1(31.2F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		CRUSTROCK2(38.9F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		MANTLEROCK(48.2F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		MANTLEROCK1(59.4F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		MANTLEROCK2(72.7F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		MANTLEROCK3(88.8F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		MANTLEROCK4(108.1F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		MANTLEROCK5(131.2F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		MANTLEROCK6(158.9F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		MANTLEROCK7(192.2F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		MANTLEROCK8(232.1F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		LOWER_MANTLEROCK(280.0F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		LOWER_MANTLEROCK1(337.5F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		LOWER_MANTLEROCK2(406.5F, 2.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		LOWER_MANTLEROCK3(489.4F, 3.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		LOWER_MANTLEROCK4(588.7F, 4.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		LOWER_MANTLEROCK5(708.0F, 5.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		LOWER_MANTLEROCK6(851.1F, 6.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		LOWER_MANTLEROCK7(1022.8F, 7.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		LOWER_MANTLEROCK8(1228.8F, 8.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		LOWER_MANTLEROCK9(1476.1F, 9.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		LOWER_MANTLEROCK10(1772.8F, 10.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		CORESTONE(2128.9F, 12.0, id -> new Corerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		INNERCORESTONE(4257.8F, 15.0, id -> new Corerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

		CENTERCORESTONE(8515.5F, 20.0, id -> new Corerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK));



		private final double baseHardness;

		private final double baseResistance;

		private final Function<String, Block> makeBlockGem;

		private final Function<String, Block> makeBlockRock;



		OreForm(double baseHardness, double baseResistance, Function<String, Block> makeBlockGem, Function<String, Block> makeBlockRock) {

			this.baseHardness = baseHardness;

			this.baseResistance = baseResistance;

			this.makeBlockGem = makeBlockGem;

			this.makeBlockRock = makeBlockRock;

		}



		public Block makeBlock(OreType type, String registryName) {

			if (type == OreType.GEM) {

				return makeBlockGem.apply(registryName);

			} else {

				return makeBlockRock.apply(registryName);

			}

		}



		public double getBaseHardness() {

			return baseHardness;

		}



		public double getBaseResistance() {

			return baseResistance;

		}

	}





	public static List<Block> BLOCKS = new ArrayList<Block>(); // being final breaks ObjectHolder, either move to separate class or keep non-final



	/**

	 * The way ObjectHolder works with forge is that it reflectively sets public static final fields.

	 * Because creating instances in static initializers is discouraged, they have to be initialized to null.

	 *

	 * This method returns null, but forces IDE static analysis to see it as a non-null value which those fields will be at runtime.

	 *

	 * This removes a lot of useless warnings because those fields *may* be null.

	 */

	@SuppressWarnings("ConstantConditions")

	@Nonnull

	private static <T> T _null() {

		return null;

	}

	@ObjectHolder("sulfuric_acid")
	public static final Block SULFURIC_ACID_FLUID = _null();
	@ObjectHolder("hot_lava")
	public static final Block HOT_LAVA_FLUID = _null();
	@ObjectHolder("core_lava")
	public static final Block CORE_LAVA_FLUID = _null();
	@ObjectHolder("onyx_lava")
	public static final Block ONYX_LAVA_FLUID = _null();


	// GENERATED BEGIN

	public static final BlocksBase ONYX_BLOCK = _null();
	public static final BlocksBase MAJORITE_BLOCK = _null();
	public static final BlocksBase BRIGMANITE_BLOCK = _null();
	public static final BlocksBase RINGWOODITE_BLOCK = _null();
	public static final BlocksBase AMAZONITE_BLOCK = _null();
	public static final BlocksBase DIAMOND_BLOCK = _null();
	public static final BlocksBase SAPPHIRE_BLOCK = _null();
	public static final BlocksBase WADSLEYITE_BLOCK = _null();
	public static final BlocksBase RUBY_BLOCK = _null();
	public static final BlocksBase TUNGSTEN_BLOCK = _null();
	public static final BlocksBase EMERALD_BLOCK = _null();
	public static final BlocksBase TITANIUM_BLOCK = _null();
	public static final BlocksBase URANIUM_BLOCK = _null();
	public static final BlocksBase PLATINUM_BLOCK = _null();
	public static final BlocksBase OLIVINE_BLOCK = _null();
	public static final BlocksBase JADE_BLOCK = _null();
	public static final BlocksBase TOPAZ_BLOCK = _null();
	public static final BlocksBase GOLD_BLOCK = _null();
	public static final BlocksBase SILVER_BLOCK = _null();
	public static final BlocksBase REDSTONE_BLOCK = _null();
	public static final BlocksBase LAPIS_BLOCK = _null();
	public static final BlocksBase SILICON_BLOCK = _null();
	public static final BlocksBase LEAD_BLOCK = _null();
	public static final BlocksBase SULFUR_BLOCK = _null();
	public static final BlocksBase IRON_BLOCK = _null();
	public static final BlocksBase TIN_BLOCK = _null();
	public static final BlocksBase COPPER_BLOCK = _null();
	public static final BlocksBase COAL_BLOCK = _null();

	public static final GemBase ONYX_ORE = _null();
	public static final GemBase MAJORITE_ORE = _null();
	public static final GemBase BRIGMANITE_ORE = _null();
	public static final GemBase RINGWOODITE_ORE = _null();
	public static final GemBase AMAZONITE_ORE = _null();
	public static final GemBase DIAMOND_ORE = _null();
	public static final GemBase SAPPHIRE_ORE = _null();
	public static final GemBase WADSLEYITE_ORE = _null();
	public static final GemBase RUBY_ORE = _null();
	public static final GemBase TUNGSTEN_ORE = _null();
	public static final GemBase EMERALD_ORE = _null();
	public static final GemBase TITANIUM_ORE = _null();
	public static final GemBase URANIUM_ORE = _null();
	public static final GemBase PLATINUM_ORE = _null();
	public static final GemBase OLIVINE_ORE = _null();
	public static final GemBase JADE_ORE = _null();
	public static final GemBase TOPAZ_ORE = _null();
	public static final GemBase GOLD_ORE = _null();
	public static final GemBase SILVER_ORE = _null();
	public static final GemBase REDSTONE_ORE = _null();
	public static final GemBase LAPIS_ORE = _null();
	public static final GemBase SILICON_ORE = _null();
	public static final GemBase LEAD_ORE = _null();
	public static final GemBase SULFUR_ORE = _null();
	public static final GemBase IRON_ORE = _null();
	public static final GemBase TIN_ORE = _null();
	public static final GemBase COPPER_ORE = _null();
	public static final GemBase COAL_ORE = _null();

	public static final Mantlerock HARDROCK_ONYX = _null();
	public static final Mantlerock HARDROCK_MAJORITE = _null();
	public static final Mantlerock HARDROCK_BRIGMANITE = _null();
	public static final Mantlerock HARDROCK_RINGWOODITE = _null();
	public static final Mantlerock HARDROCK_AMAZONITE = _null();
	public static final Mantlerock HARDROCK_DIAMOND = _null();
	public static final Mantlerock HARDROCK_SAPPHIRE = _null();
	public static final Mantlerock HARDROCK_WADSLEYITE = _null();
	public static final Mantlerock HARDROCK_RUBY = _null();
	public static final Mantlerock HARDROCK_TUNGSTEN = _null();
	public static final Mantlerock HARDROCK_EMERALD = _null();
	public static final Mantlerock HARDROCK_TITANIUM = _null();
	public static final Mantlerock HARDROCK_URANIUM = _null();
	public static final Mantlerock HARDROCK_PLATINUM = _null();
	public static final Mantlerock HARDROCK_OLIVINE = _null();
	public static final Mantlerock HARDROCK_JADE = _null();
	public static final Mantlerock HARDROCK_TOPAZ = _null();
	public static final Mantlerock HARDROCK_GOLD = _null();
	public static final Mantlerock HARDROCK_SILVER = _null();
	public static final Mantlerock HARDROCK_REDSTONE = _null();
	public static final Mantlerock HARDROCK_LAPIS = _null();
	public static final Mantlerock HARDROCK_SILICON = _null();
	public static final Mantlerock HARDROCK_LEAD = _null();
	public static final Mantlerock HARDROCK_SULFUR = _null();
	public static final Mantlerock HARDROCK_IRON = _null();
	public static final Mantlerock HARDROCK_TIN = _null();
	public static final Mantlerock HARDROCK_COPPER = _null();
	public static final Mantlerock HARDROCK_COAL = _null();

	public static final Mantlerock HARDROCK1_ONYX = _null();
	public static final Mantlerock HARDROCK1_MAJORITE = _null();
	public static final Mantlerock HARDROCK1_BRIGMANITE = _null();
	public static final Mantlerock HARDROCK1_RINGWOODITE = _null();
	public static final Mantlerock HARDROCK1_AMAZONITE = _null();
	public static final Mantlerock HARDROCK1_DIAMOND = _null();
	public static final Mantlerock HARDROCK1_SAPPHIRE = _null();
	public static final Mantlerock HARDROCK1_WADSLEYITE = _null();
	public static final Mantlerock HARDROCK1_RUBY = _null();
	public static final Mantlerock HARDROCK1_TUNGSTEN = _null();
	public static final Mantlerock HARDROCK1_EMERALD = _null();
	public static final Mantlerock HARDROCK1_TITANIUM = _null();
	public static final Mantlerock HARDROCK1_URANIUM = _null();
	public static final Mantlerock HARDROCK1_PLATINUM = _null();
	public static final Mantlerock HARDROCK1_OLIVINE = _null();
	public static final Mantlerock HARDROCK1_JADE = _null();
	public static final Mantlerock HARDROCK1_TOPAZ = _null();
	public static final Mantlerock HARDROCK1_GOLD = _null();
	public static final Mantlerock HARDROCK1_SILVER = _null();
	public static final Mantlerock HARDROCK1_REDSTONE = _null();
	public static final Mantlerock HARDROCK1_LAPIS = _null();
	public static final Mantlerock HARDROCK1_SILICON = _null();
	public static final Mantlerock HARDROCK1_LEAD = _null();
	public static final Mantlerock HARDROCK1_SULFUR = _null();
	public static final Mantlerock HARDROCK1_IRON = _null();
	public static final Mantlerock HARDROCK1_TIN = _null();
	public static final Mantlerock HARDROCK1_COPPER = _null();
	public static final Mantlerock HARDROCK1_COAL = _null();

	public static final Mantlerock HARDROCK2_ONYX = _null();
	public static final Mantlerock HARDROCK2_MAJORITE = _null();
	public static final Mantlerock HARDROCK2_BRIGMANITE = _null();
	public static final Mantlerock HARDROCK2_RINGWOODITE = _null();
	public static final Mantlerock HARDROCK2_AMAZONITE = _null();
	public static final Mantlerock HARDROCK2_DIAMOND = _null();
	public static final Mantlerock HARDROCK2_SAPPHIRE = _null();
	public static final Mantlerock HARDROCK2_WADSLEYITE = _null();
	public static final Mantlerock HARDROCK2_RUBY = _null();
	public static final Mantlerock HARDROCK2_TUNGSTEN = _null();
	public static final Mantlerock HARDROCK2_EMERALD = _null();
	public static final Mantlerock HARDROCK2_TITANIUM = _null();
	public static final Mantlerock HARDROCK2_URANIUM = _null();
	public static final Mantlerock HARDROCK2_PLATINUM = _null();
	public static final Mantlerock HARDROCK2_OLIVINE = _null();
	public static final Mantlerock HARDROCK2_JADE = _null();
	public static final Mantlerock HARDROCK2_TOPAZ = _null();
	public static final Mantlerock HARDROCK2_GOLD = _null();
	public static final Mantlerock HARDROCK2_SILVER = _null();
	public static final Mantlerock HARDROCK2_REDSTONE = _null();
	public static final Mantlerock HARDROCK2_LAPIS = _null();
	public static final Mantlerock HARDROCK2_SILICON = _null();
	public static final Mantlerock HARDROCK2_LEAD = _null();
	public static final Mantlerock HARDROCK2_SULFUR = _null();
	public static final Mantlerock HARDROCK2_IRON = _null();
	public static final Mantlerock HARDROCK2_TIN = _null();
	public static final Mantlerock HARDROCK2_COPPER = _null();
	public static final Mantlerock HARDROCK2_COAL = _null();

	public static final Mantlerock DEEPROCK_ONYX = _null();
	public static final Mantlerock DEEPROCK_MAJORITE = _null();
	public static final Mantlerock DEEPROCK_BRIGMANITE = _null();
	public static final Mantlerock DEEPROCK_RINGWOODITE = _null();
	public static final Mantlerock DEEPROCK_AMAZONITE = _null();
	public static final Mantlerock DEEPROCK_DIAMOND = _null();
	public static final Mantlerock DEEPROCK_SAPPHIRE = _null();
	public static final Mantlerock DEEPROCK_WADSLEYITE = _null();
	public static final Mantlerock DEEPROCK_RUBY = _null();
	public static final Mantlerock DEEPROCK_TUNGSTEN = _null();
	public static final Mantlerock DEEPROCK_EMERALD = _null();
	public static final Mantlerock DEEPROCK_TITANIUM = _null();
	public static final Mantlerock DEEPROCK_URANIUM = _null();
	public static final Mantlerock DEEPROCK_PLATINUM = _null();
	public static final Mantlerock DEEPROCK_OLIVINE = _null();
	public static final Mantlerock DEEPROCK_JADE = _null();
	public static final Mantlerock DEEPROCK_TOPAZ = _null();
	public static final Mantlerock DEEPROCK_GOLD = _null();
	public static final Mantlerock DEEPROCK_SILVER = _null();
	public static final Mantlerock DEEPROCK_REDSTONE = _null();
	public static final Mantlerock DEEPROCK_LAPIS = _null();
	public static final Mantlerock DEEPROCK_SILICON = _null();
	public static final Mantlerock DEEPROCK_LEAD = _null();
	public static final Mantlerock DEEPROCK_SULFUR = _null();
	public static final Mantlerock DEEPROCK_IRON = _null();
	public static final Mantlerock DEEPROCK_TIN = _null();
	public static final Mantlerock DEEPROCK_COPPER = _null();
	public static final Mantlerock DEEPROCK_COAL = _null();

	public static final Mantlerock DEEPROCK1_ONYX = _null();
	public static final Mantlerock DEEPROCK1_MAJORITE = _null();
	public static final Mantlerock DEEPROCK1_BRIGMANITE = _null();
	public static final Mantlerock DEEPROCK1_RINGWOODITE = _null();
	public static final Mantlerock DEEPROCK1_AMAZONITE = _null();
	public static final Mantlerock DEEPROCK1_DIAMOND = _null();
	public static final Mantlerock DEEPROCK1_SAPPHIRE = _null();
	public static final Mantlerock DEEPROCK1_WADSLEYITE = _null();
	public static final Mantlerock DEEPROCK1_RUBY = _null();
	public static final Mantlerock DEEPROCK1_TUNGSTEN = _null();
	public static final Mantlerock DEEPROCK1_EMERALD = _null();
	public static final Mantlerock DEEPROCK1_TITANIUM = _null();
	public static final Mantlerock DEEPROCK1_URANIUM = _null();
	public static final Mantlerock DEEPROCK1_PLATINUM = _null();
	public static final Mantlerock DEEPROCK1_OLIVINE = _null();
	public static final Mantlerock DEEPROCK1_JADE = _null();
	public static final Mantlerock DEEPROCK1_TOPAZ = _null();
	public static final Mantlerock DEEPROCK1_GOLD = _null();
	public static final Mantlerock DEEPROCK1_SILVER = _null();
	public static final Mantlerock DEEPROCK1_REDSTONE = _null();
	public static final Mantlerock DEEPROCK1_LAPIS = _null();
	public static final Mantlerock DEEPROCK1_SILICON = _null();
	public static final Mantlerock DEEPROCK1_LEAD = _null();
	public static final Mantlerock DEEPROCK1_SULFUR = _null();
	public static final Mantlerock DEEPROCK1_IRON = _null();
	public static final Mantlerock DEEPROCK1_TIN = _null();
	public static final Mantlerock DEEPROCK1_COPPER = _null();
	public static final Mantlerock DEEPROCK1_COAL = _null();

	public static final Mantlerock DEEPROCK2_ONYX = _null();
	public static final Mantlerock DEEPROCK2_MAJORITE = _null();
	public static final Mantlerock DEEPROCK2_BRIGMANITE = _null();
	public static final Mantlerock DEEPROCK2_RINGWOODITE = _null();
	public static final Mantlerock DEEPROCK2_AMAZONITE = _null();
	public static final Mantlerock DEEPROCK2_DIAMOND = _null();
	public static final Mantlerock DEEPROCK2_SAPPHIRE = _null();
	public static final Mantlerock DEEPROCK2_WADSLEYITE = _null();
	public static final Mantlerock DEEPROCK2_RUBY = _null();
	public static final Mantlerock DEEPROCK2_TUNGSTEN = _null();
	public static final Mantlerock DEEPROCK2_EMERALD = _null();
	public static final Mantlerock DEEPROCK2_TITANIUM = _null();
	public static final Mantlerock DEEPROCK2_URANIUM = _null();
	public static final Mantlerock DEEPROCK2_PLATINUM = _null();
	public static final Mantlerock DEEPROCK2_OLIVINE = _null();
	public static final Mantlerock DEEPROCK2_JADE = _null();
	public static final Mantlerock DEEPROCK2_TOPAZ = _null();
	public static final Mantlerock DEEPROCK2_GOLD = _null();
	public static final Mantlerock DEEPROCK2_SILVER = _null();
	public static final Mantlerock DEEPROCK2_REDSTONE = _null();
	public static final Mantlerock DEEPROCK2_LAPIS = _null();
	public static final Mantlerock DEEPROCK2_SILICON = _null();
	public static final Mantlerock DEEPROCK2_LEAD = _null();
	public static final Mantlerock DEEPROCK2_SULFUR = _null();
	public static final Mantlerock DEEPROCK2_IRON = _null();
	public static final Mantlerock DEEPROCK2_TIN = _null();
	public static final Mantlerock DEEPROCK2_COPPER = _null();
	public static final Mantlerock DEEPROCK2_COAL = _null();

	public static final Mantlerock CRUSTROCK_ONYX = _null();
	public static final Mantlerock CRUSTROCK_MAJORITE = _null();
	public static final Mantlerock CRUSTROCK_BRIGMANITE = _null();
	public static final Mantlerock CRUSTROCK_RINGWOODITE = _null();
	public static final Mantlerock CRUSTROCK_AMAZONITE = _null();
	public static final Mantlerock CRUSTROCK_DIAMOND = _null();
	public static final Mantlerock CRUSTROCK_SAPPHIRE = _null();
	public static final Mantlerock CRUSTROCK_WADSLEYITE = _null();
	public static final Mantlerock CRUSTROCK_RUBY = _null();
	public static final Mantlerock CRUSTROCK_TUNGSTEN = _null();
	public static final Mantlerock CRUSTROCK_EMERALD = _null();
	public static final Mantlerock CRUSTROCK_TITANIUM = _null();
	public static final Mantlerock CRUSTROCK_URANIUM = _null();
	public static final Mantlerock CRUSTROCK_PLATINUM = _null();
	public static final Mantlerock CRUSTROCK_OLIVINE = _null();
	public static final Mantlerock CRUSTROCK_JADE = _null();
	public static final Mantlerock CRUSTROCK_TOPAZ = _null();
	public static final Mantlerock CRUSTROCK_GOLD = _null();
	public static final Mantlerock CRUSTROCK_SILVER = _null();
	public static final Mantlerock CRUSTROCK_REDSTONE = _null();
	public static final Mantlerock CRUSTROCK_LAPIS = _null();
	public static final Mantlerock CRUSTROCK_SILICON = _null();
	public static final Mantlerock CRUSTROCK_LEAD = _null();
	public static final Mantlerock CRUSTROCK_SULFUR = _null();
	public static final Mantlerock CRUSTROCK_IRON = _null();
	public static final Mantlerock CRUSTROCK_TIN = _null();
	public static final Mantlerock CRUSTROCK_COPPER = _null();
	public static final Mantlerock CRUSTROCK_COAL = _null();

	public static final Mantlerock CRUSTROCK1_ONYX = _null();
	public static final Mantlerock CRUSTROCK1_MAJORITE = _null();
	public static final Mantlerock CRUSTROCK1_BRIGMANITE = _null();
	public static final Mantlerock CRUSTROCK1_RINGWOODITE = _null();
	public static final Mantlerock CRUSTROCK1_AMAZONITE = _null();
	public static final Mantlerock CRUSTROCK1_DIAMOND = _null();
	public static final Mantlerock CRUSTROCK1_SAPPHIRE = _null();
	public static final Mantlerock CRUSTROCK1_WADSLEYITE = _null();
	public static final Mantlerock CRUSTROCK1_RUBY = _null();
	public static final Mantlerock CRUSTROCK1_TUNGSTEN = _null();
	public static final Mantlerock CRUSTROCK1_EMERALD = _null();
	public static final Mantlerock CRUSTROCK1_TITANIUM = _null();
	public static final Mantlerock CRUSTROCK1_URANIUM = _null();
	public static final Mantlerock CRUSTROCK1_PLATINUM = _null();
	public static final Mantlerock CRUSTROCK1_OLIVINE = _null();
	public static final Mantlerock CRUSTROCK1_JADE = _null();
	public static final Mantlerock CRUSTROCK1_TOPAZ = _null();
	public static final Mantlerock CRUSTROCK1_GOLD = _null();
	public static final Mantlerock CRUSTROCK1_SILVER = _null();
	public static final Mantlerock CRUSTROCK1_REDSTONE = _null();
	public static final Mantlerock CRUSTROCK1_LAPIS = _null();
	public static final Mantlerock CRUSTROCK1_SILICON = _null();
	public static final Mantlerock CRUSTROCK1_LEAD = _null();
	public static final Mantlerock CRUSTROCK1_SULFUR = _null();
	public static final Mantlerock CRUSTROCK1_IRON = _null();
	public static final Mantlerock CRUSTROCK1_TIN = _null();
	public static final Mantlerock CRUSTROCK1_COPPER = _null();
	public static final Mantlerock CRUSTROCK1_COAL = _null();

	public static final Mantlerock CRUSTROCK2_ONYX = _null();
	public static final Mantlerock CRUSTROCK2_MAJORITE = _null();
	public static final Mantlerock CRUSTROCK2_BRIGMANITE = _null();
	public static final Mantlerock CRUSTROCK2_RINGWOODITE = _null();
	public static final Mantlerock CRUSTROCK2_AMAZONITE = _null();
	public static final Mantlerock CRUSTROCK2_DIAMOND = _null();
	public static final Mantlerock CRUSTROCK2_SAPPHIRE = _null();
	public static final Mantlerock CRUSTROCK2_WADSLEYITE = _null();
	public static final Mantlerock CRUSTROCK2_RUBY = _null();
	public static final Mantlerock CRUSTROCK2_TUNGSTEN = _null();
	public static final Mantlerock CRUSTROCK2_EMERALD = _null();
	public static final Mantlerock CRUSTROCK2_TITANIUM = _null();
	public static final Mantlerock CRUSTROCK2_URANIUM = _null();
	public static final Mantlerock CRUSTROCK2_PLATINUM = _null();
	public static final Mantlerock CRUSTROCK2_OLIVINE = _null();
	public static final Mantlerock CRUSTROCK2_JADE = _null();
	public static final Mantlerock CRUSTROCK2_TOPAZ = _null();
	public static final Mantlerock CRUSTROCK2_GOLD = _null();
	public static final Mantlerock CRUSTROCK2_SILVER = _null();
	public static final Mantlerock CRUSTROCK2_REDSTONE = _null();
	public static final Mantlerock CRUSTROCK2_LAPIS = _null();
	public static final Mantlerock CRUSTROCK2_SILICON = _null();
	public static final Mantlerock CRUSTROCK2_LEAD = _null();
	public static final Mantlerock CRUSTROCK2_SULFUR = _null();
	public static final Mantlerock CRUSTROCK2_IRON = _null();
	public static final Mantlerock CRUSTROCK2_TIN = _null();
	public static final Mantlerock CRUSTROCK2_COPPER = _null();
	public static final Mantlerock CRUSTROCK2_COAL = _null();

	public static final Mantlerock MANTLEROCK_ONYX = _null();
	public static final Mantlerock MANTLEROCK_MAJORITE = _null();
	public static final Mantlerock MANTLEROCK_BRIGMANITE = _null();
	public static final Mantlerock MANTLEROCK_RINGWOODITE = _null();
	public static final Mantlerock MANTLEROCK_AMAZONITE = _null();
	public static final Mantlerock MANTLEROCK_DIAMOND = _null();
	public static final Mantlerock MANTLEROCK_SAPPHIRE = _null();
	public static final Mantlerock MANTLEROCK_WADSLEYITE = _null();
	public static final Mantlerock MANTLEROCK_RUBY = _null();
	public static final Mantlerock MANTLEROCK_TUNGSTEN = _null();
	public static final Mantlerock MANTLEROCK_EMERALD = _null();
	public static final Mantlerock MANTLEROCK_TITANIUM = _null();
	public static final Mantlerock MANTLEROCK_URANIUM = _null();
	public static final Mantlerock MANTLEROCK_PLATINUM = _null();
	public static final Mantlerock MANTLEROCK_OLIVINE = _null();
	public static final Mantlerock MANTLEROCK_JADE = _null();
	public static final Mantlerock MANTLEROCK_TOPAZ = _null();
	public static final Mantlerock MANTLEROCK_GOLD = _null();
	public static final Mantlerock MANTLEROCK_SILVER = _null();
	public static final Mantlerock MANTLEROCK_REDSTONE = _null();
	public static final Mantlerock MANTLEROCK_LAPIS = _null();
	public static final Mantlerock MANTLEROCK_SILICON = _null();
	public static final Mantlerock MANTLEROCK_LEAD = _null();
	public static final Mantlerock MANTLEROCK_SULFUR = _null();
	public static final Mantlerock MANTLEROCK_IRON = _null();
	public static final Mantlerock MANTLEROCK_TIN = _null();
	public static final Mantlerock MANTLEROCK_COPPER = _null();
	public static final Mantlerock MANTLEROCK_COAL = _null();

	public static final Mantlerock MANTLEROCK1_ONYX = _null();
	public static final Mantlerock MANTLEROCK1_MAJORITE = _null();
	public static final Mantlerock MANTLEROCK1_BRIGMANITE = _null();
	public static final Mantlerock MANTLEROCK1_RINGWOODITE = _null();
	public static final Mantlerock MANTLEROCK1_AMAZONITE = _null();
	public static final Mantlerock MANTLEROCK1_DIAMOND = _null();
	public static final Mantlerock MANTLEROCK1_SAPPHIRE = _null();
	public static final Mantlerock MANTLEROCK1_WADSLEYITE = _null();
	public static final Mantlerock MANTLEROCK1_RUBY = _null();
	public static final Mantlerock MANTLEROCK1_TUNGSTEN = _null();
	public static final Mantlerock MANTLEROCK1_EMERALD = _null();
	public static final Mantlerock MANTLEROCK1_TITANIUM = _null();
	public static final Mantlerock MANTLEROCK1_URANIUM = _null();
	public static final Mantlerock MANTLEROCK1_PLATINUM = _null();
	public static final Mantlerock MANTLEROCK1_OLIVINE = _null();
	public static final Mantlerock MANTLEROCK1_JADE = _null();
	public static final Mantlerock MANTLEROCK1_TOPAZ = _null();
	public static final Mantlerock MANTLEROCK1_GOLD = _null();
	public static final Mantlerock MANTLEROCK1_SILVER = _null();
	public static final Mantlerock MANTLEROCK1_REDSTONE = _null();
	public static final Mantlerock MANTLEROCK1_LAPIS = _null();
	public static final Mantlerock MANTLEROCK1_SILICON = _null();
	public static final Mantlerock MANTLEROCK1_LEAD = _null();
	public static final Mantlerock MANTLEROCK1_SULFUR = _null();
	public static final Mantlerock MANTLEROCK1_IRON = _null();
	public static final Mantlerock MANTLEROCK1_TIN = _null();
	public static final Mantlerock MANTLEROCK1_COPPER = _null();
	public static final Mantlerock MANTLEROCK1_COAL = _null();

	public static final Mantlerock MANTLEROCK2_ONYX = _null();
	public static final Mantlerock MANTLEROCK2_MAJORITE = _null();
	public static final Mantlerock MANTLEROCK2_BRIGMANITE = _null();
	public static final Mantlerock MANTLEROCK2_RINGWOODITE = _null();
	public static final Mantlerock MANTLEROCK2_AMAZONITE = _null();
	public static final Mantlerock MANTLEROCK2_DIAMOND = _null();
	public static final Mantlerock MANTLEROCK2_SAPPHIRE = _null();
	public static final Mantlerock MANTLEROCK2_WADSLEYITE = _null();
	public static final Mantlerock MANTLEROCK2_RUBY = _null();
	public static final Mantlerock MANTLEROCK2_TUNGSTEN = _null();
	public static final Mantlerock MANTLEROCK2_EMERALD = _null();
	public static final Mantlerock MANTLEROCK2_TITANIUM = _null();
	public static final Mantlerock MANTLEROCK2_URANIUM = _null();
	public static final Mantlerock MANTLEROCK2_PLATINUM = _null();
	public static final Mantlerock MANTLEROCK2_OLIVINE = _null();
	public static final Mantlerock MANTLEROCK2_JADE = _null();
	public static final Mantlerock MANTLEROCK2_TOPAZ = _null();
	public static final Mantlerock MANTLEROCK2_GOLD = _null();
	public static final Mantlerock MANTLEROCK2_SILVER = _null();
	public static final Mantlerock MANTLEROCK2_REDSTONE = _null();
	public static final Mantlerock MANTLEROCK2_LAPIS = _null();
	public static final Mantlerock MANTLEROCK2_SILICON = _null();
	public static final Mantlerock MANTLEROCK2_LEAD = _null();
	public static final Mantlerock MANTLEROCK2_SULFUR = _null();
	public static final Mantlerock MANTLEROCK2_IRON = _null();
	public static final Mantlerock MANTLEROCK2_TIN = _null();
	public static final Mantlerock MANTLEROCK2_COPPER = _null();
	public static final Mantlerock MANTLEROCK2_COAL = _null();

	public static final Mantlerock MANTLEROCK3_ONYX = _null();
	public static final Mantlerock MANTLEROCK3_MAJORITE = _null();
	public static final Mantlerock MANTLEROCK3_BRIGMANITE = _null();
	public static final Mantlerock MANTLEROCK3_RINGWOODITE = _null();
	public static final Mantlerock MANTLEROCK3_AMAZONITE = _null();
	public static final Mantlerock MANTLEROCK3_DIAMOND = _null();
	public static final Mantlerock MANTLEROCK3_SAPPHIRE = _null();
	public static final Mantlerock MANTLEROCK3_WADSLEYITE = _null();
	public static final Mantlerock MANTLEROCK3_RUBY = _null();
	public static final Mantlerock MANTLEROCK3_TUNGSTEN = _null();
	public static final Mantlerock MANTLEROCK3_EMERALD = _null();
	public static final Mantlerock MANTLEROCK3_TITANIUM = _null();
	public static final Mantlerock MANTLEROCK3_URANIUM = _null();
	public static final Mantlerock MANTLEROCK3_PLATINUM = _null();
	public static final Mantlerock MANTLEROCK3_OLIVINE = _null();
	public static final Mantlerock MANTLEROCK3_JADE = _null();
	public static final Mantlerock MANTLEROCK3_TOPAZ = _null();
	public static final Mantlerock MANTLEROCK3_GOLD = _null();
	public static final Mantlerock MANTLEROCK3_SILVER = _null();
	public static final Mantlerock MANTLEROCK3_REDSTONE = _null();
	public static final Mantlerock MANTLEROCK3_LAPIS = _null();
	public static final Mantlerock MANTLEROCK3_SILICON = _null();
	public static final Mantlerock MANTLEROCK3_LEAD = _null();
	public static final Mantlerock MANTLEROCK3_SULFUR = _null();
	public static final Mantlerock MANTLEROCK3_IRON = _null();
	public static final Mantlerock MANTLEROCK3_TIN = _null();
	public static final Mantlerock MANTLEROCK3_COPPER = _null();
	public static final Mantlerock MANTLEROCK3_COAL = _null();

	public static final Mantlerock MANTLEROCK4_ONYX = _null();
	public static final Mantlerock MANTLEROCK4_MAJORITE = _null();
	public static final Mantlerock MANTLEROCK4_BRIGMANITE = _null();
	public static final Mantlerock MANTLEROCK4_RINGWOODITE = _null();
	public static final Mantlerock MANTLEROCK4_AMAZONITE = _null();
	public static final Mantlerock MANTLEROCK4_DIAMOND = _null();
	public static final Mantlerock MANTLEROCK4_SAPPHIRE = _null();
	public static final Mantlerock MANTLEROCK4_WADSLEYITE = _null();
	public static final Mantlerock MANTLEROCK4_RUBY = _null();
	public static final Mantlerock MANTLEROCK4_TUNGSTEN = _null();
	public static final Mantlerock MANTLEROCK4_EMERALD = _null();
	public static final Mantlerock MANTLEROCK4_TITANIUM = _null();
	public static final Mantlerock MANTLEROCK4_URANIUM = _null();
	public static final Mantlerock MANTLEROCK4_PLATINUM = _null();
	public static final Mantlerock MANTLEROCK4_OLIVINE = _null();
	public static final Mantlerock MANTLEROCK4_JADE = _null();
	public static final Mantlerock MANTLEROCK4_TOPAZ = _null();
	public static final Mantlerock MANTLEROCK4_GOLD = _null();
	public static final Mantlerock MANTLEROCK4_SILVER = _null();
	public static final Mantlerock MANTLEROCK4_REDSTONE = _null();
	public static final Mantlerock MANTLEROCK4_LAPIS = _null();
	public static final Mantlerock MANTLEROCK4_SILICON = _null();
	public static final Mantlerock MANTLEROCK4_LEAD = _null();
	public static final Mantlerock MANTLEROCK4_SULFUR = _null();
	public static final Mantlerock MANTLEROCK4_IRON = _null();
	public static final Mantlerock MANTLEROCK4_TIN = _null();
	public static final Mantlerock MANTLEROCK4_COPPER = _null();
	public static final Mantlerock MANTLEROCK4_COAL = _null();

	public static final Mantlerock MANTLEROCK5_ONYX = _null();
	public static final Mantlerock MANTLEROCK5_MAJORITE = _null();
	public static final Mantlerock MANTLEROCK5_BRIGMANITE = _null();
	public static final Mantlerock MANTLEROCK5_RINGWOODITE = _null();
	public static final Mantlerock MANTLEROCK5_AMAZONITE = _null();
	public static final Mantlerock MANTLEROCK5_DIAMOND = _null();
	public static final Mantlerock MANTLEROCK5_SAPPHIRE = _null();
	public static final Mantlerock MANTLEROCK5_WADSLEYITE = _null();
	public static final Mantlerock MANTLEROCK5_RUBY = _null();
	public static final Mantlerock MANTLEROCK5_TUNGSTEN = _null();
	public static final Mantlerock MANTLEROCK5_EMERALD = _null();
	public static final Mantlerock MANTLEROCK5_TITANIUM = _null();
	public static final Mantlerock MANTLEROCK5_URANIUM = _null();
	public static final Mantlerock MANTLEROCK5_PLATINUM = _null();
	public static final Mantlerock MANTLEROCK5_OLIVINE = _null();
	public static final Mantlerock MANTLEROCK5_JADE = _null();
	public static final Mantlerock MANTLEROCK5_TOPAZ = _null();
	public static final Mantlerock MANTLEROCK5_GOLD = _null();
	public static final Mantlerock MANTLEROCK5_SILVER = _null();
	public static final Mantlerock MANTLEROCK5_REDSTONE = _null();
	public static final Mantlerock MANTLEROCK5_LAPIS = _null();
	public static final Mantlerock MANTLEROCK5_SILICON = _null();
	public static final Mantlerock MANTLEROCK5_LEAD = _null();
	public static final Mantlerock MANTLEROCK5_SULFUR = _null();
	public static final Mantlerock MANTLEROCK5_IRON = _null();
	public static final Mantlerock MANTLEROCK5_TIN = _null();
	public static final Mantlerock MANTLEROCK5_COPPER = _null();
	public static final Mantlerock MANTLEROCK5_COAL = _null();

	public static final Mantlerock MANTLEROCK6_ONYX = _null();
	public static final Mantlerock MANTLEROCK6_MAJORITE = _null();
	public static final Mantlerock MANTLEROCK6_BRIGMANITE = _null();
	public static final Mantlerock MANTLEROCK6_RINGWOODITE = _null();
	public static final Mantlerock MANTLEROCK6_AMAZONITE = _null();
	public static final Mantlerock MANTLEROCK6_DIAMOND = _null();
	public static final Mantlerock MANTLEROCK6_SAPPHIRE = _null();
	public static final Mantlerock MANTLEROCK6_WADSLEYITE = _null();
	public static final Mantlerock MANTLEROCK6_RUBY = _null();
	public static final Mantlerock MANTLEROCK6_TUNGSTEN = _null();
	public static final Mantlerock MANTLEROCK6_EMERALD = _null();
	public static final Mantlerock MANTLEROCK6_TITANIUM = _null();
	public static final Mantlerock MANTLEROCK6_URANIUM = _null();
	public static final Mantlerock MANTLEROCK6_PLATINUM = _null();
	public static final Mantlerock MANTLEROCK6_OLIVINE = _null();
	public static final Mantlerock MANTLEROCK6_JADE = _null();
	public static final Mantlerock MANTLEROCK6_TOPAZ = _null();
	public static final Mantlerock MANTLEROCK6_GOLD = _null();
	public static final Mantlerock MANTLEROCK6_SILVER = _null();
	public static final Mantlerock MANTLEROCK6_REDSTONE = _null();
	public static final Mantlerock MANTLEROCK6_LAPIS = _null();
	public static final Mantlerock MANTLEROCK6_SILICON = _null();
	public static final Mantlerock MANTLEROCK6_LEAD = _null();
	public static final Mantlerock MANTLEROCK6_SULFUR = _null();
	public static final Mantlerock MANTLEROCK6_IRON = _null();
	public static final Mantlerock MANTLEROCK6_TIN = _null();
	public static final Mantlerock MANTLEROCK6_COPPER = _null();
	public static final Mantlerock MANTLEROCK6_COAL = _null();

	public static final Mantlerock MANTLEROCK7_ONYX = _null();
	public static final Mantlerock MANTLEROCK7_MAJORITE = _null();
	public static final Mantlerock MANTLEROCK7_BRIGMANITE = _null();
	public static final Mantlerock MANTLEROCK7_RINGWOODITE = _null();
	public static final Mantlerock MANTLEROCK7_AMAZONITE = _null();
	public static final Mantlerock MANTLEROCK7_DIAMOND = _null();
	public static final Mantlerock MANTLEROCK7_SAPPHIRE = _null();
	public static final Mantlerock MANTLEROCK7_WADSLEYITE = _null();
	public static final Mantlerock MANTLEROCK7_RUBY = _null();
	public static final Mantlerock MANTLEROCK7_TUNGSTEN = _null();
	public static final Mantlerock MANTLEROCK7_EMERALD = _null();
	public static final Mantlerock MANTLEROCK7_TITANIUM = _null();
	public static final Mantlerock MANTLEROCK7_URANIUM = _null();
	public static final Mantlerock MANTLEROCK7_PLATINUM = _null();
	public static final Mantlerock MANTLEROCK7_OLIVINE = _null();
	public static final Mantlerock MANTLEROCK7_JADE = _null();
	public static final Mantlerock MANTLEROCK7_TOPAZ = _null();
	public static final Mantlerock MANTLEROCK7_GOLD = _null();
	public static final Mantlerock MANTLEROCK7_SILVER = _null();
	public static final Mantlerock MANTLEROCK7_REDSTONE = _null();
	public static final Mantlerock MANTLEROCK7_LAPIS = _null();
	public static final Mantlerock MANTLEROCK7_SILICON = _null();
	public static final Mantlerock MANTLEROCK7_LEAD = _null();
	public static final Mantlerock MANTLEROCK7_SULFUR = _null();
	public static final Mantlerock MANTLEROCK7_IRON = _null();
	public static final Mantlerock MANTLEROCK7_TIN = _null();
	public static final Mantlerock MANTLEROCK7_COPPER = _null();
	public static final Mantlerock MANTLEROCK7_COAL = _null();

	public static final Mantlerock MANTLEROCK8_ONYX = _null();
	public static final Mantlerock MANTLEROCK8_MAJORITE = _null();
	public static final Mantlerock MANTLEROCK8_BRIGMANITE = _null();
	public static final Mantlerock MANTLEROCK8_RINGWOODITE = _null();
	public static final Mantlerock MANTLEROCK8_AMAZONITE = _null();
	public static final Mantlerock MANTLEROCK8_DIAMOND = _null();
	public static final Mantlerock MANTLEROCK8_SAPPHIRE = _null();
	public static final Mantlerock MANTLEROCK8_WADSLEYITE = _null();
	public static final Mantlerock MANTLEROCK8_RUBY = _null();
	public static final Mantlerock MANTLEROCK8_TUNGSTEN = _null();
	public static final Mantlerock MANTLEROCK8_EMERALD = _null();
	public static final Mantlerock MANTLEROCK8_TITANIUM = _null();
	public static final Mantlerock MANTLEROCK8_URANIUM = _null();
	public static final Mantlerock MANTLEROCK8_PLATINUM = _null();
	public static final Mantlerock MANTLEROCK8_OLIVINE = _null();
	public static final Mantlerock MANTLEROCK8_JADE = _null();
	public static final Mantlerock MANTLEROCK8_TOPAZ = _null();
	public static final Mantlerock MANTLEROCK8_GOLD = _null();
	public static final Mantlerock MANTLEROCK8_SILVER = _null();
	public static final Mantlerock MANTLEROCK8_REDSTONE = _null();
	public static final Mantlerock MANTLEROCK8_LAPIS = _null();
	public static final Mantlerock MANTLEROCK8_SILICON = _null();
	public static final Mantlerock MANTLEROCK8_LEAD = _null();
	public static final Mantlerock MANTLEROCK8_SULFUR = _null();
	public static final Mantlerock MANTLEROCK8_IRON = _null();
	public static final Mantlerock MANTLEROCK8_TIN = _null();
	public static final Mantlerock MANTLEROCK8_COPPER = _null();
	public static final Mantlerock MANTLEROCK8_COAL = _null();

	public static final Mantlerock LOWER_MANTLEROCK_ONYX = _null();
	public static final Mantlerock LOWER_MANTLEROCK_MAJORITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK_BRIGMANITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK_RINGWOODITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK_AMAZONITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK_DIAMOND = _null();
	public static final Mantlerock LOWER_MANTLEROCK_SAPPHIRE = _null();
	public static final Mantlerock LOWER_MANTLEROCK_WADSLEYITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK_RUBY = _null();
	public static final Mantlerock LOWER_MANTLEROCK_TUNGSTEN = _null();
	public static final Mantlerock LOWER_MANTLEROCK_EMERALD = _null();
	public static final Mantlerock LOWER_MANTLEROCK_TITANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK_URANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK_PLATINUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK_OLIVINE = _null();
	public static final Mantlerock LOWER_MANTLEROCK_JADE = _null();
	public static final Mantlerock LOWER_MANTLEROCK_TOPAZ = _null();
	public static final Mantlerock LOWER_MANTLEROCK_GOLD = _null();
	public static final Mantlerock LOWER_MANTLEROCK_SILVER = _null();
	public static final Mantlerock LOWER_MANTLEROCK_REDSTONE = _null();
	public static final Mantlerock LOWER_MANTLEROCK_LAPIS = _null();
	public static final Mantlerock LOWER_MANTLEROCK_SILICON = _null();
	public static final Mantlerock LOWER_MANTLEROCK_LEAD = _null();
	public static final Mantlerock LOWER_MANTLEROCK_SULFUR = _null();
	public static final Mantlerock LOWER_MANTLEROCK_IRON = _null();
	public static final Mantlerock LOWER_MANTLEROCK_TIN = _null();
	public static final Mantlerock LOWER_MANTLEROCK_COPPER = _null();
	public static final Mantlerock LOWER_MANTLEROCK_COAL = _null();

	public static final Mantlerock LOWER_MANTLEROCK1_ONYX = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_MAJORITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_BRIGMANITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_RINGWOODITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_AMAZONITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_DIAMOND = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_SAPPHIRE = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_WADSLEYITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_RUBY = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_TUNGSTEN = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_EMERALD = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_TITANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_URANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_PLATINUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_OLIVINE = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_JADE = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_TOPAZ = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_GOLD = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_SILVER = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_REDSTONE = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_LAPIS = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_SILICON = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_LEAD = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_SULFUR = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_IRON = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_TIN = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_COPPER = _null();
	public static final Mantlerock LOWER_MANTLEROCK1_COAL = _null();

	public static final Mantlerock LOWER_MANTLEROCK2_ONYX = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_MAJORITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_BRIGMANITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_RINGWOODITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_AMAZONITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_DIAMOND = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_SAPPHIRE = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_WADSLEYITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_RUBY = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_TUNGSTEN = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_EMERALD = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_TITANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_URANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_PLATINUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_OLIVINE = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_JADE = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_TOPAZ = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_GOLD = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_SILVER = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_REDSTONE = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_LAPIS = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_SILICON = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_LEAD = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_SULFUR = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_IRON = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_TIN = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_COPPER = _null();
	public static final Mantlerock LOWER_MANTLEROCK2_COAL = _null();

	public static final Mantlerock LOWER_MANTLEROCK3_ONYX = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_MAJORITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_BRIGMANITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_RINGWOODITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_AMAZONITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_DIAMOND = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_SAPPHIRE = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_WADSLEYITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_RUBY = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_TUNGSTEN = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_EMERALD = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_TITANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_URANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_PLATINUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_OLIVINE = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_JADE = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_TOPAZ = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_GOLD = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_SILVER = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_REDSTONE = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_LAPIS = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_SILICON = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_LEAD = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_SULFUR = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_IRON = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_TIN = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_COPPER = _null();
	public static final Mantlerock LOWER_MANTLEROCK3_COAL = _null();

	public static final Mantlerock LOWER_MANTLEROCK4_ONYX = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_MAJORITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_BRIGMANITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_RINGWOODITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_AMAZONITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_DIAMOND = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_SAPPHIRE = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_WADSLEYITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_RUBY = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_TUNGSTEN = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_EMERALD = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_TITANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_URANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_PLATINUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_OLIVINE = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_JADE = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_TOPAZ = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_GOLD = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_SILVER = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_REDSTONE = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_LAPIS = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_SILICON = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_LEAD = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_SULFUR = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_IRON = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_TIN = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_COPPER = _null();
	public static final Mantlerock LOWER_MANTLEROCK4_COAL = _null();

	public static final Mantlerock LOWER_MANTLEROCK5_ONYX = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_MAJORITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_BRIGMANITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_RINGWOODITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_AMAZONITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_DIAMOND = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_SAPPHIRE = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_WADSLEYITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_RUBY = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_TUNGSTEN = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_EMERALD = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_TITANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_URANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_PLATINUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_OLIVINE = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_JADE = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_TOPAZ = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_GOLD = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_SILVER = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_REDSTONE = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_LAPIS = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_SILICON = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_LEAD = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_SULFUR = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_IRON = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_TIN = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_COPPER = _null();
	public static final Mantlerock LOWER_MANTLEROCK5_COAL = _null();

	public static final Mantlerock LOWER_MANTLEROCK6_ONYX = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_MAJORITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_BRIGMANITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_RINGWOODITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_AMAZONITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_DIAMOND = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_SAPPHIRE = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_WADSLEYITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_RUBY = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_TUNGSTEN = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_EMERALD = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_TITANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_URANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_PLATINUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_OLIVINE = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_JADE = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_TOPAZ = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_GOLD = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_SILVER = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_REDSTONE = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_LAPIS = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_SILICON = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_LEAD = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_SULFUR = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_IRON = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_TIN = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_COPPER = _null();
	public static final Mantlerock LOWER_MANTLEROCK6_COAL = _null();

	public static final Mantlerock LOWER_MANTLEROCK7_ONYX = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_MAJORITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_BRIGMANITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_RINGWOODITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_AMAZONITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_DIAMOND = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_SAPPHIRE = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_WADSLEYITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_RUBY = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_TUNGSTEN = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_EMERALD = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_TITANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_URANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_PLATINUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_OLIVINE = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_JADE = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_TOPAZ = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_GOLD = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_SILVER = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_REDSTONE = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_LAPIS = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_SILICON = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_LEAD = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_SULFUR = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_IRON = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_TIN = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_COPPER = _null();
	public static final Mantlerock LOWER_MANTLEROCK7_COAL = _null();

	public static final Mantlerock LOWER_MANTLEROCK8_ONYX = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_MAJORITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_BRIGMANITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_RINGWOODITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_AMAZONITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_DIAMOND = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_SAPPHIRE = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_WADSLEYITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_RUBY = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_TUNGSTEN = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_EMERALD = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_TITANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_URANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_PLATINUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_OLIVINE = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_JADE = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_TOPAZ = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_GOLD = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_SILVER = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_REDSTONE = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_LAPIS = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_SILICON = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_LEAD = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_SULFUR = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_IRON = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_TIN = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_COPPER = _null();
	public static final Mantlerock LOWER_MANTLEROCK8_COAL = _null();

	public static final Mantlerock LOWER_MANTLEROCK9_ONYX = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_MAJORITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_BRIGMANITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_RINGWOODITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_AMAZONITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_DIAMOND = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_SAPPHIRE = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_WADSLEYITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_RUBY = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_TUNGSTEN = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_EMERALD = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_TITANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_URANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_PLATINUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_OLIVINE = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_JADE = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_TOPAZ = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_GOLD = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_SILVER = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_REDSTONE = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_LAPIS = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_SILICON = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_LEAD = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_SULFUR = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_IRON = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_TIN = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_COPPER = _null();
	public static final Mantlerock LOWER_MANTLEROCK9_COAL = _null();

	public static final Mantlerock LOWER_MANTLEROCK10_ONYX = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_MAJORITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_BRIGMANITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_RINGWOODITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_AMAZONITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_DIAMOND = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_SAPPHIRE = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_WADSLEYITE = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_RUBY = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_TUNGSTEN = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_EMERALD = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_TITANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_URANIUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_PLATINUM = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_OLIVINE = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_JADE = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_TOPAZ = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_GOLD = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_SILVER = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_REDSTONE = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_LAPIS = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_SILICON = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_LEAD = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_SULFUR = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_IRON = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_TIN = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_COPPER = _null();
	public static final Mantlerock LOWER_MANTLEROCK10_COAL = _null();

	public static final Corerock CORESTONE_ONYX = _null();
	public static final Corerock CORESTONE_MAJORITE = _null();
	public static final Corerock CORESTONE_BRIGMANITE = _null();
	public static final Corerock CORESTONE_RINGWOODITE = _null();
	public static final Corerock CORESTONE_AMAZONITE = _null();
	public static final Corerock CORESTONE_DIAMOND = _null();
	public static final Corerock CORESTONE_SAPPHIRE = _null();
	public static final Corerock CORESTONE_WADSLEYITE = _null();
	public static final Corerock CORESTONE_RUBY = _null();
	public static final Corerock CORESTONE_TUNGSTEN = _null();
	public static final Corerock CORESTONE_EMERALD = _null();
	public static final Corerock CORESTONE_TITANIUM = _null();
	public static final Corerock CORESTONE_URANIUM = _null();
	public static final Corerock CORESTONE_PLATINUM = _null();
	public static final Corerock CORESTONE_OLIVINE = _null();
	public static final Corerock CORESTONE_JADE = _null();
	public static final Corerock CORESTONE_TOPAZ = _null();
	public static final Corerock CORESTONE_GOLD = _null();
	public static final Corerock CORESTONE_SILVER = _null();
	public static final Corerock CORESTONE_REDSTONE = _null();
	public static final Corerock CORESTONE_LAPIS = _null();
	public static final Corerock CORESTONE_SILICON = _null();
	public static final Corerock CORESTONE_LEAD = _null();
	public static final Corerock CORESTONE_SULFUR = _null();
	public static final Corerock CORESTONE_IRON = _null();
	public static final Corerock CORESTONE_TIN = _null();
	public static final Corerock CORESTONE_COPPER = _null();
	public static final Corerock CORESTONE_COAL = _null();

	public static final Corerock INNERCORESTONE_ONYX = _null();
	public static final Corerock INNERCORESTONE_MAJORITE = _null();
	public static final Corerock INNERCORESTONE_BRIGMANITE = _null();
	public static final Corerock INNERCORESTONE_RINGWOODITE = _null();
	public static final Corerock INNERCORESTONE_AMAZONITE = _null();
	public static final Corerock INNERCORESTONE_DIAMOND = _null();
	public static final Corerock INNERCORESTONE_SAPPHIRE = _null();
	public static final Corerock INNERCORESTONE_WADSLEYITE = _null();
	public static final Corerock INNERCORESTONE_RUBY = _null();
	public static final Corerock INNERCORESTONE_TUNGSTEN = _null();
	public static final Corerock INNERCORESTONE_EMERALD = _null();
	public static final Corerock INNERCORESTONE_TITANIUM = _null();
	public static final Corerock INNERCORESTONE_URANIUM = _null();
	public static final Corerock INNERCORESTONE_PLATINUM = _null();
	public static final Corerock INNERCORESTONE_OLIVINE = _null();
	public static final Corerock INNERCORESTONE_JADE = _null();
	public static final Corerock INNERCORESTONE_TOPAZ = _null();
	public static final Corerock INNERCORESTONE_GOLD = _null();
	public static final Corerock INNERCORESTONE_SILVER = _null();
	public static final Corerock INNERCORESTONE_REDSTONE = _null();
	public static final Corerock INNERCORESTONE_LAPIS = _null();
	public static final Corerock INNERCORESTONE_SILICON = _null();
	public static final Corerock INNERCORESTONE_LEAD = _null();
	public static final Corerock INNERCORESTONE_SULFUR = _null();
	public static final Corerock INNERCORESTONE_IRON = _null();
	public static final Corerock INNERCORESTONE_TIN = _null();
	public static final Corerock INNERCORESTONE_COPPER = _null();
	public static final Corerock INNERCORESTONE_COAL = _null();

	public static final Corerock CENTERCORESTONE_ONYX = _null();
	public static final Corerock CENTERCORESTONE_MAJORITE = _null();
	public static final Corerock CENTERCORESTONE_BRIGMANITE = _null();
	public static final Corerock CENTERCORESTONE_RINGWOODITE = _null();
	public static final Corerock CENTERCORESTONE_AMAZONITE = _null();
	public static final Corerock CENTERCORESTONE_DIAMOND = _null();
	public static final Corerock CENTERCORESTONE_SAPPHIRE = _null();
	public static final Corerock CENTERCORESTONE_WADSLEYITE = _null();
	public static final Corerock CENTERCORESTONE_RUBY = _null();
	public static final Corerock CENTERCORESTONE_TUNGSTEN = _null();
	public static final Corerock CENTERCORESTONE_EMERALD = _null();
	public static final Corerock CENTERCORESTONE_TITANIUM = _null();
	public static final Corerock CENTERCORESTONE_URANIUM = _null();
	public static final Corerock CENTERCORESTONE_PLATINUM = _null();
	public static final Corerock CENTERCORESTONE_OLIVINE = _null();
	public static final Corerock CENTERCORESTONE_JADE = _null();
	public static final Corerock CENTERCORESTONE_TOPAZ = _null();
	public static final Corerock CENTERCORESTONE_GOLD = _null();
	public static final Corerock CENTERCORESTONE_SILVER = _null();
	public static final Corerock CENTERCORESTONE_REDSTONE = _null();
	public static final Corerock CENTERCORESTONE_LAPIS = _null();
	public static final Corerock CENTERCORESTONE_SILICON = _null();
	public static final Corerock CENTERCORESTONE_LEAD = _null();
	public static final Corerock CENTERCORESTONE_SULFUR = _null();
	public static final Corerock CENTERCORESTONE_IRON = _null();
	public static final Corerock CENTERCORESTONE_TIN = _null();
	public static final Corerock CENTERCORESTONE_COPPER = _null();
	public static final Corerock CENTERCORESTONE_COAL = _null();



	// GENERATED END






	public static final Block STEEL_BLOCK = _null();

	public static final Block SOLID_BOULDER = _null();

	public static final Block VERY_SOLID_BOULDER = _null();



	public static final Block HARDROCK = _null();

	public static final Block HARDROCK1 = _null();

	public static final Block HARDROCK2 = _null();

	public static final Block HARDROCK3 = _null();

	public static final Block HARDROCK4 = _null();

	public static final Block HARDROCK5 = _null();

	public static final Block DEEPROCK = _null();

	public static final Block DEEPROCK1 = _null();

	public static final Block DEEPROCK2 = _null();

	public static final Block DEEPROCK3 = _null();

	public static final Block DEEPROCK4 = _null();

	public static final Block DEEPROCK5 = _null();

	public static final Block CRUSTROCK = _null();

	public static final Block CRUSTROCK1 = _null();

	public static final Block CRUSTROCK2 = _null();

	public static final Block CRUSTROCK3 = _null();

	public static final Block CRUSTROCK4 = _null();

	public static final Block CRUSTROCK5 = _null();

	public static final Block CRUSTROCK6 = _null();

	public static final Block CRUSTROCK7 = _null();

	public static final Block CRUSTROCK8 = _null();

	public static final Block CRUSTROCK9 = _null();

	public static final Block CRUSTROCK10 = _null();

	public static final Block MANTLEROCK = _null();

	public static final Block MANTLEROCK1 = _null();

	public static final Block MANTLEROCK2 = _null();

	public static final Block MANTLEROCK3 = _null();

	public static final Block MANTLEROCK4 = _null();

	public static final Block MANTLEROCK5 = _null();

	public static final Block MANTLEROCK6 = _null();

	public static final Block MANTLEROCK7 = _null();

	public static final Block MANTLEROCK8 = _null();

	public static final Block MANTLEROCK9 = _null();

	public static final Block MANTLEROCK10 = _null();

	public static final Block LOWER_MANTLEROCK1 = _null();

	public static final Block LOWER_MANTLEROCK2 = _null();

	public static final Block LOWER_MANTLEROCK3 = _null();

	public static final Block LOWER_MANTLEROCK4 = _null();

	public static final Block LOWER_MANTLEROCK5 = _null();

	public static final Block LOWER_MANTLEROCK6 = _null();

	public static final Block LOWER_MANTLEROCK7 = _null();

	public static final Block LOWER_MANTLEROCK8 = _null();

	public static final Block LOWER_MANTLEROCK9 = _null();

	public static final Block LOWER_MANTLEROCK10 = _null();

	public static final Block CORESTONE = _null();

	public static final Block INNERCORESTONE = _null();

	public static final Block CENTERCORESTONE = _null();

	public static final Block MAGMA_CORESTONE = _null();

	public static final Block COLD_CORESTONE = _null();



	//SEDIMENTARY ROCK

	public static final Block LIMESTONE = _null();



	public static final Block MANTLEGAS = _null();

	public static final Block HOT_MANTLEROCK = _null();

	public static final Block VERY_HOT_MANTLEROCK = _null();

	public static final Block SUPER_HOT_MANTLEROCK = _null();



	public static final Block HOTROCK = _null();



	public static void register(IForgeRegistry<Block> registry) {

		boolean generateHolders = System.getProperty("planetcore.generate_holders", "false").equalsIgnoreCase("true");



		StringBuilder holderGenString = generateHolders ? new StringBuilder(64*1024) : null;



		for (ModBlocks.OreForm oreForm : ModBlocks.OreForm.values()) {

			for (ModBlocks.Ore ore : ModBlocks.Ore.values()) {

				if (!ore.makeOreAndBlock() &&

						(oreForm == ModBlocks.OreForm.BLOCK || oreForm == ModBlocks.OreForm.ORE )) {

					continue;

				}

				String registryName;

				if (oreForm == ModBlocks.OreForm.BLOCK || oreForm == ModBlocks.OreForm.ORE) {

					registryName = ore.name().toLowerCase(Locale.ROOT) + "_" + oreForm.name().toLowerCase(Locale.ROOT);

				} else {

					registryName = oreForm.name().toLowerCase(Locale.ROOT) + "_" + ore.name().toLowerCase(Locale.ROOT);

				}



				Block block = oreForm.makeBlock(ore.getType(), registryName);

				block.setHardness((float) (ore.getOreHardness() + oreForm.getBaseHardness()));

				if (oreForm == ModBlocks.OreForm.BLOCK) {

					block.setResistance((float) ore.getBlockResistance());

				} else {

					block.setResistance((float) (ore.getOreResistance() + oreForm.getBaseResistance()));

				}

				if (generateHolders) {

					holderGenString.append("public static final ").append(block.getClass().getSimpleName())

							.append(" ").append(block.getRegistryName().getPath().toUpperCase(Locale.ROOT)).append(" = _null();\n");

				}

				registry.register(block);

			}

			if (generateHolders) holderGenString.append("\n");

		}

		if (generateHolders) {

			System.out.println("\n" + holderGenString.toString());

		}



		registry.registerAll(

				new SulfuricAcidFluid("sulfuric_acid", ModFluids.SULFURIC_ACID_FLUID, Material.WATER),

				new HotLavaFluid("hot_lava", ModFluids.HOT_LAVA_FLUID, Material.LAVA),

				new CoreLavaFluid("core_lava", ModFluids.CORE_LAVA_FLUID, Material.LAVA),

				new OnyxLavaFluid("onyx_lava", ModFluids.ONYX_LAVA_FLUID, Material.LAVA),





				new BlocksBase("steel_block", Material.ROCK).setResistance(500),

				new Mantlerock("solid_boulder", Material.ROCK).setHardness(1000.0F).setResistance(1),

				new Mantlerock("very_solid_boulder", Material.ROCK).setHardness(10000.0F).setResistance(10),

				new Mantlerock("hardrock", Material.ROCK).setHardness(3.3F),

				new Mantlerock("hardrock1", Material.ROCK).setHardness(5.5F),

				new Mantlerock("hardrock2", Material.ROCK).setHardness(8.1F),

				new Mantlerock("deeprock", Material.ROCK).setHardness(11.2F),

				new Mantlerock("deeprock1", Material.ROCK).setHardness(14.9F),

				new Mantlerock("deeprock2", Material.ROCK).setHardness(19.4F),

				new Mantlerock("crustrock", Material.ROCK).setHardness(24.7F),

				new Mantlerock("crustrock1", Material.ROCK).setHardness(31.2F),

				new Mantlerock("crustrock2", Material.ROCK).setHardness(38.9F),

				new Mantlerock("mantlerock", Material.ROCK).setHardness(48.2F).setLightLevel(0.0F),

				new Mantlerock("mantlerock1", Material.ROCK).setHardness(59.4F).setLightLevel(0.05F),

				new Mantlerock("mantlerock2", Material.ROCK).setHardness(72.7F).setLightLevel(0.01F),

				new Mantlerock("mantlerock3", Material.ROCK).setHardness(88.8F).setLightLevel(0.015F),

				new Mantlerock("mantlerock4", Material.ROCK).setHardness(108.1F).setLightLevel(0.02F),

				new Mantlerock("mantlerock5", Material.ROCK).setHardness(131.2F).setLightLevel(0.025F),

				new Mantlerock("mantlerock6", Material.ROCK).setHardness(158.9F).setLightLevel(0.03F),

				new Mantlerock("mantlerock7", Material.ROCK).setHardness(192.2F).setLightLevel(0.035F),

				new Mantlerock("mantlerock8", Material.ROCK).setHardness(232.1F).setLightLevel(0.04F),

				new Mantlerock("lower_mantlerock", Material.ROCK).setHardness(280.0F).setLightLevel(0.055F),

				new Mantlerock("lower_mantlerock1", Material.ROCK).setHardness(337.5F).setLightLevel(0.06F),

				new Mantlerock("lower_mantlerock2", Material.ROCK).setHardness(406.5F).setLightLevel(0.065F),

				new Mantlerock("lower_mantlerock3", Material.ROCK).setHardness(489.4F).setLightLevel(0.07F),

				new Mantlerock("lower_mantlerock4", Material.ROCK).setHardness(588.7F).setLightLevel(0.075F),

				new Mantlerock("lower_mantlerock5", Material.ROCK).setHardness(708.0F).setLightLevel(0.08F),

				new Mantlerock("lower_mantlerock6", Material.ROCK).setHardness(851.1F).setLightLevel(0.085F),

				new Mantlerock("lower_mantlerock7", Material.ROCK).setHardness(1022.8F).setLightLevel(0.09F),

				new Mantlerock("lower_mantlerock8", Material.ROCK).setHardness(1228.8F).setLightLevel(0.095F),

				new Mantlerock("lower_mantlerock9", Material.ROCK).setHardness(1476.1F).setLightLevel(1.0F),

				new Mantlerock("lower_mantlerock10", Material.ROCK).setHardness(1772.8F).setLightLevel(1.0F),

				new Corerock("corestone", Material.ROCK).setHardness(2128.8F),

				new Corerock("innercorestone", Material.ROCK).setHardness(4257.8F),

				new Corerock("centercorestone", Material.ROCK).setHardness(8515.5F),

				new Corerock("magma_corestone", Material.ROCK).setHardness(2128.8F),

				new BlockBase("cold_corestone", Material.ROCK).setHardness(2128.8F),



				new GemBase("limestone", Material.ROCK),

				new GasBase("mantlegas", Material.ROCK),

				new Hot_Mantlerock("hot_mantlerock_0", Material.ROCK),

				new Hot_Mantlerock("hot_mantlerock_1", Material.ROCK),

				new Hot_Mantlerock("hot_mantlerock_2", Material.ROCK),

				new BlockBase("hotrock", Material.ROCK)

		);

	}

}