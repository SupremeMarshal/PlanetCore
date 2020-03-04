package com.PlanetCore.init;

import com.PlanetCore.anvils.Gold.BlockGoldAnvil;
import com.PlanetCore.blocks.*;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

import java.util.ArrayList;
import java.util.List;


public class ModBlocks {


	public static final List<Block> BLOCKS = new ArrayList<Block>();


	public static final Block SULFURIC_ACID_BLOCK = new SulfuricAcidFluid("sulfuric_acid", ModFluids.SULFURIC_ACID_FLUID, Material.WATER);
	public static final Block HOT_LAVA_BLOCK = new HotLavaFluid("hot_lava", ModFluids.HOT_LAVA_FLUID, Material.LAVA);
	public static final Block CORE_LAVA_BLOCK = new CoreLavaFluid("core_lava", ModFluids.CORE_LAVA_FLUID, Material.LAVA);

	public static final Block AZURITE_BLOCK = new RockBase("azurite_block", Material.ROCK);
	public static final Block ONYX_BLOCK = new RockBase("onyx_block", Material.ROCK);
	public static final Block AMETHYST_BLOCK = new RockBase("amethyst_block", Material.ROCK);
	public static final Block AMAZONITE_BLOCK = new RockBase("amazonite_block", Material.ROCK);
	public static final Block JADE_BLOCK = new RockBase("jade_block", Material.ROCK);
	public static final Block DIAMOND_BLOCK = new RockBase("diamond_block", Material.ROCK);
	public static final Block TOPAZ_BLOCK = new RockBase("topaz_block", Material.ROCK);
	public static final Block RUBY_BLOCK = new RockBase("ruby_block", Material.ROCK);
	public static final Block FLAMING_TOPAZ_BLOCK = new RockBase("flaming_topaz_block", Material.ROCK);
	public static final Block SAPPHIRE_BLOCK = new RockBase("sapphire_block", Material.ROCK);
	public static final Block PLATINUM_BLOCK = new RockBase("platinum_block", Material.ROCK);
	public static final Block GOLD_BLOCK = new RockBase("gold_block", Material.ROCK);
	public static final Block SILVER_BLOCK = new RockBase("silver_block", Material.ROCK);
	public static final Block STEEL_BLOCK = new RockBase("steel_block", Material.ROCK);
	public static final Block IRON_BLOCK = new RockBase("iron_block", Material.ROCK);
	public static final Block SULFUR_BLOCK = new BlockBase("sulfur_block", Material.ROCK);
	
	public static final Block AZURITE_ORE = new GemBase("azurite_ore", Material.ROCK);
	public static final Block ONYX_ORE = new GemBase("onyx_ore", Material.ROCK);
	public static final Block AMETHYST_ORE = new GemBase("amethyst_ore", Material.ROCK);
	public static final Block AMAZONITE_ORE = new GemBase("amazonite_ore", Material.ROCK);
	public static final Block JADE_ORE = new GemBase("jade_ore", Material.ROCK);
	public static final Block DIAMOND_ORE = new GemBase("diamond_ore", Material.ROCK);
	public static final Block TOPAZ_ORE = new GemBase("topaz_ore", Material.ROCK);
	public static final Block RUBY_ORE = new GemBase("ruby_ore", Material.ROCK);
	public static final Block FLAMING_TOPAZ_ORE = new GemBase("flaming_topaz_ore", Material.ROCK);
	public static final Block SAPPHIRE_ORE = new GemBase("sapphire_ore", Material.ROCK);
	public static final Block PLATINUM_ORE = new GemBase("platinum_ore", Material.ROCK);
	public static final Block GOLD_ORE = new GemBase("gold_ore", Material.ROCK);
	public static final Block SILVER_ORE = new GemBase("silver_ore", Material.ROCK);
	public static final Block IRON_ORE = new GemBase("iron_ore", Material.ROCK);
	public static final Block SULFUR_ORE = new GemBase("sulfur_ore", Material.ROCK);
	
	public static final Block HARDSTONE_AZURITE = new GemBase("hardstone_azurite", Material.ROCK);
	public static final Block HARDSTONE_ONYX = new GemBase("hardstone_onyx", Material.ROCK);
	public static final Block HARDSTONE_AMETHYST = new GemBase("hardstone_amethyst", Material.ROCK);
	public static final Block HARDSTONE_AMAZONITE = new GemBase("hardstone_amazonite", Material.ROCK);
	public static final Block HARDSTONE_JADE = new GemBase("hardstone_jade", Material.ROCK);
	public static final Block HARDSTONE_DIAMOND = new GemBase("hardstone_diamond", Material.ROCK);
	public static final Block HARDSTONE_TOPAZ = new GemBase("hardstone_topaz", Material.ROCK);
	public static final Block HARDSTONE_RUBY = new GemBase("hardstone_ruby", Material.ROCK);
	public static final Block HARDSTONE_FLAMING_TOPAZ = new GemBase("hardstone_flaming_topaz", Material.ROCK);
	public static final Block HARDSTONE_SAPPHIRE = new GemBase("hardstone_sapphire", Material.ROCK);
	public static final Block HARDSTONE_EMERALD = new GemBase("hardstone_emerald", Material.ROCK);
	public static final Block HARDSTONE_PLATINUM = new RockBase("hardstone_platinum", Material.ROCK);
	public static final Block HARDSTONE_GOLD = new RockBase("hardstone_gold", Material.ROCK);
	public static final Block HARDSTONE_SILVER = new RockBase("hardstone_silver", Material.ROCK);
	public static final Block HARDSTONE_IRON = new RockBase("hardstone_iron", Material.ROCK);
	public static final Block HARDSTONE_COAL = new GemBase("hardstone_coal", Material.ROCK);
	public static final Block HARDSTONE_REDSTONE = new GemBase("hardstone_redstone", Material.ROCK);
	public static final Block HARDSTONE_LAPIS = new RockBase("hardstone_lapis", Material.ROCK);
	public static final Block HARDSTONE_SULFUR = new GemBase("hardstone_sulfur", Material.ROCK);
	
	public static final Block DEEPSTONE_AZURITE = new GemBase("deepstone_azurite", Material.ROCK);
	public static final Block DEEPSTONE_ONYX = new GemBase("deepstone_onyx", Material.ROCK);
	public static final Block DEEPSTONE_AMETHYST = new GemBase("deepstone_amethyst", Material.ROCK);
	public static final Block DEEPSTONE_AMAZONITE = new GemBase("deepstone_amazonite", Material.ROCK);
	public static final Block DEEPSTONE_JADE = new GemBase("deepstone_jade", Material.ROCK);
	public static final Block DEEPSTONE_DIAMOND = new GemBase("deepstone_diamond", Material.ROCK);
	public static final Block DEEPSTONE_TOPAZ = new GemBase("deepstone_topaz", Material.ROCK);
	public static final Block DEEPSTONE_RUBY = new GemBase("deepstone_ruby", Material.ROCK);
	public static final Block DEEPSTONE_FLAMING_TOPAZ = new GemBase("deepstone_flaming_topaz", Material.ROCK);
	public static final Block DEEPSTONE_SAPPHIRE = new GemBase("deepstone_sapphire", Material.ROCK);
	public static final Block DEEPSTONE_EMERALD = new GemBase("deepstone_emerald", Material.ROCK);
	public static final Block DEEPSTONE_PLATINUM = new RockBase("deepstone_platinum", Material.ROCK);
	public static final Block DEEPSTONE_GOLD = new RockBase("deepstone_gold", Material.ROCK);
	public static final Block DEEPSTONE_SILVER = new RockBase("deepstone_silver", Material.ROCK);
	public static final Block DEEPSTONE_IRON = new RockBase("deepstone_iron", Material.ROCK);
	public static final Block DEEPSTONE_COAL = new GemBase("deepstone_coal", Material.ROCK);
	public static final Block DEEPSTONE_REDSTONE = new GemBase("deepstone_redstone", Material.ROCK);
	public static final Block DEEPSTONE_LAPIS = new RockBase("deepstone_lapis", Material.ROCK);
	public static final Block DEEPSTONE_SULFUR = new GemBase("deepstone_sulfur", Material.ROCK);

	public static final Block CRUSTROCK_AZURITE = new GemBase("crustrock_azurite", Material.ROCK);
	public static final Block CRUSTROCK_ONYX = new GemBase("crustrock_onyx", Material.ROCK);
	public static final Block CRUSTROCK_AMETHYST = new GemBase("crustrock_amethyst", Material.ROCK);
	public static final Block CRUSTROCK_AMAZONITE = new GemBase("crustrock_amazonite", Material.ROCK);
	public static final Block CRUSTROCK_JADE = new GemBase("crustrock_jade", Material.ROCK);
	public static final Block CRUSTROCK_DIAMOND = new GemBase("crustrock_diamond", Material.ROCK);
	public static final Block CRUSTROCK_TOPAZ = new GemBase("crustrock_topaz", Material.ROCK);
	public static final Block CRUSTROCK_RUBY = new GemBase("crustrock_ruby", Material.ROCK);
	public static final Block CRUSTROCK_FLAMING_TOPAZ = new GemBase("crustrock_flaming_topaz", Material.ROCK);
	public static final Block CRUSTROCK_SAPPHIRE = new GemBase("crustrock_sapphire", Material.ROCK);
	public static final Block CRUSTROCK_EMERALD = new GemBase("crustrock_emerald", Material.ROCK);
	public static final Block CRUSTROCK_PLATINUM = new RockBase("crustrock_platinum", Material.ROCK);
	public static final Block CRUSTROCK_GOLD = new RockBase("crustrock_gold", Material.ROCK);
	public static final Block CRUSTROCK_SILVER = new RockBase("crustrock_silver", Material.ROCK);
	public static final Block CRUSTROCK_IRON = new RockBase("crustrock_iron", Material.ROCK);
	public static final Block CRUSTROCK_COAL = new GemBase("crustrock_coal", Material.ROCK);
	public static final Block CRUSTROCK_REDSTONE = new GemBase("crustrock_redstone", Material.ROCK);
	public static final Block CRUSTROCK_LAPIS = new RockBase("crustrock_lapis", Material.ROCK);
	public static final Block CRUSTROCK_SULFUR = new GemBase("crustrock_sulfur", Material.ROCK);
	
	public static final Block MANTLEROCK_AZURITE = new GemBase("mantlerock_azurite", Material.ROCK);
	public static final Block MANTLEROCK_ONYX = new GemBase("mantlerock_onyx", Material.ROCK);
	public static final Block MANTLEROCK_AMETHYST = new GemBase("mantlerock_amethyst", Material.ROCK);
	public static final Block MANTLEROCK_AMAZONITE = new GemBase("mantlerock_amazonite", Material.ROCK);
	public static final Block MANTLEROCK_JADE = new GemBase("mantlerock_jade", Material.ROCK);
	public static final Block MANTLEROCK_DIAMOND = new GemBase("mantlerock_diamond", Material.ROCK);
	public static final Block MANTLEROCK_TOPAZ = new GemBase("mantlerock_topaz", Material.ROCK);
	public static final Block MANTLEROCK_RUBY = new GemBase("mantlerock_ruby", Material.ROCK);
	public static final Block MANTLEROCK_FLAMING_TOPAZ = new GemBase("mantlerock_flaming_topaz", Material.ROCK);
	public static final Block MANTLEROCK_SAPPHIRE = new GemBase("mantlerock_sapphire", Material.ROCK);
	public static final Block MANTLEROCK_EMERALD = new GemBase("mantlerock_emerald", Material.ROCK);
	public static final Block MANTLEROCK_PLATINUM = new RockBase("mantlerock_platinum", Material.ROCK);
	public static final Block MANTLEROCK_GOLD = new RockBase("mantlerock_gold", Material.ROCK);
	public static final Block MANTLEROCK_SILVER = new RockBase("mantlerock_silver", Material.ROCK);
	public static final Block MANTLEROCK_IRON = new RockBase("mantlerock_iron", Material.ROCK);
	public static final Block MANTLEROCK_COAL = new GemBase("mantlerock_coal", Material.ROCK);
	public static final Block MANTLEROCK_REDSTONE = new GemBase("mantlerock_redstone", Material.ROCK);
	public static final Block MANTLEROCK_LAPIS = new RockBase("mantlerock_lapis", Material.ROCK);
	public static final Block MANTLEROCK_SULFUR = new GemBase("mantlerock_sulfur", Material.ROCK);
	
	public static final Block LOWER_MANTLEROCK_AZURITE = new GemBase("lower_mantlerock_azurite", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_ONYX = new GemBase("lower_mantlerock_onyx", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_AMETHYST = new GemBase("lower_mantlerock_amethyst", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_AMAZONITE = new GemBase("lower_mantlerock_amazonite", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_JADE = new GemBase("lower_mantlerock_jade", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_DIAMOND = new GemBase("lower_mantlerock_diamond", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_TOPAZ = new GemBase("lower_mantlerock_topaz", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_RUBY = new GemBase("lower_mantlerock_ruby", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_FLAMING_TOPAZ = new GemBase("lower_mantlerock_flaming_topaz", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_SAPPHIRE = new GemBase("lower_mantlerock_sapphire", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_EMERALD = new GemBase("lower_mantlerock_emerald", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_PLATINUM = new RockBase("lower_mantlerock_platinum", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_GOLD = new RockBase("lower_mantlerock_gold", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_SILVER = new RockBase("lower_mantlerock_silver", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_IRON = new RockBase("lower_mantlerock_iron", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_COAL = new GemBase("lower_mantlerock_coal", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_REDSTONE = new GemBase("lower_mantlerock_redstone", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_LAPIS = new RockBase("lower_mantlerock_lapis", Material.ROCK);
	public static final Block LOWER_MANTLEROCK_SULFUR = new GemBase("lower_mantlerock_sulfur", Material.ROCK);

	public static final Block CORESTONE_AZURITE = new Corerock("corestone_azurite", Material.ROCK);
	public static final Block CORESTONE_ONYX = new Corerock("corestone_onyx", Material.ROCK);
	public static final Block CORESTONE_AMETHYST = new Corerock("corestone_amethyst", Material.ROCK);
	public static final Block CORESTONE_AMAZONITE = new Corerock("corestone_amazonite", Material.ROCK);
	public static final Block CORESTONE_JADE = new Corerock("corestone_jade", Material.ROCK);
	public static final Block CORESTONE_DIAMOND = new Corerock("corestone_diamond", Material.ROCK);
	public static final Block CORESTONE_TOPAZ = new Corerock("corestone_topaz", Material.ROCK);
	public static final Block CORESTONE_RUBY = new Corerock("corestone_ruby", Material.ROCK);
	public static final Block CORESTONE_FLAMING_TOPAZ = new Corerock("corestone_flaming_topaz", Material.ROCK);
	public static final Block CORESTONE_SAPPHIRE = new Corerock("corestone_sapphire", Material.ROCK);
	public static final Block CORESTONE_EMERALD = new Corerock("corestone_emerald", Material.ROCK);
	public static final Block CORESTONE_LAPIS = new Corerock("corestone_lapis", Material.ROCK);
	public static final Block CORESTONE_REDSTONE = new Corerock("corestone_redstone", Material.ROCK);
	public static final Block CORESTONE_PLATINUM = new Corerock("corestone_platinum", Material.ROCK);
	public static final Block CORESTONE_GOLD = new Corerock("corestone_gold", Material.ROCK);
	public static final Block CORESTONE_SILVER = new Corerock("corestone_silver", Material.ROCK);
	public static final Block CORESTONE_IRON = new Corerock("corestone_iron", Material.ROCK);
	public static final Block CORESTONE_COAL = new Corerock("corestone_coal", Material.ROCK);
	public static final Block CORESTONE_SULFUR = new Corerock("corestone_sulfur", Material.ROCK);

	public static final Block INNERCORESTONE_AZURITE = new Corerock("innercorestone_azurite", Material.ROCK);
	public static final Block INNERCORESTONE_ONYX = new Corerock("innercorestone_onyx", Material.ROCK);
	public static final Block INNERCORESTONE_AMETHYST = new Corerock("innercorestone_amethyst", Material.ROCK);
	public static final Block INNERCORESTONE_AMAZONITE = new Corerock("innercorestone_amazonite", Material.ROCK);
	public static final Block INNERCORESTONE_JADE = new Corerock("innercorestone_jade", Material.ROCK);
	public static final Block INNERCORESTONE_DIAMOND = new Corerock("innercorestone_diamond", Material.ROCK);
	public static final Block INNERCORESTONE_TOPAZ = new Corerock("innercorestone_topaz", Material.ROCK);
	public static final Block INNERCORESTONE_RUBY = new Corerock("innercorestone_ruby", Material.ROCK);
	public static final Block INNERCORESTONE_FLAMING_TOPAZ = new Corerock("innercorestone_flaming_topaz", Material.ROCK);
	public static final Block INNERCORESTONE_SAPPHIRE = new Corerock("innercorestone_sapphire", Material.ROCK);
	public static final Block INNERCORESTONE_EMERALD = new Corerock("innercorestone_emerald", Material.ROCK);
	public static final Block INNERCORESTONE_LAPIS = new Corerock("innercorestone_lapis", Material.ROCK);
	public static final Block INNERCORESTONE_REDSTONE = new Corerock("innercorestone_redstone", Material.ROCK);
	public static final Block INNERCORESTONE_PLATINUM = new Corerock("innercorestone_platinum", Material.ROCK);
	public static final Block INNERCORESTONE_GOLD = new Corerock("innercorestone_gold", Material.ROCK);
	public static final Block INNERCORESTONE_SILVER = new Corerock("innercorestone_silver", Material.ROCK);
	public static final Block INNERCORESTONE_IRON = new Corerock("innercorestone_iron", Material.ROCK);
	public static final Block INNERCORESTONE_COAL = new Corerock("innercorestone_coal", Material.ROCK);
	public static final Block INNERCORESTONE_SULFUR = new Corerock("innercorestone_sulfur", Material.ROCK);
	
	public static final Block CENTERCORESTONE_AZURITE = new Corerock("centercorestone_azurite", Material.ROCK);
	public static final Block CENTERCORESTONE_ONYX = new Corerock("centercorestone_onyx", Material.ROCK);
	public static final Block CENTERCORESTONE_AMETHYST = new Corerock("centercorestone_amethyst", Material.ROCK);
	public static final Block CENTERCORESTONE_AMAZONITE = new Corerock("centercorestone_amazonite", Material.ROCK);
	public static final Block CENTERCORESTONE_JADE = new Corerock("centercorestone_jade", Material.ROCK);
	public static final Block CENTERCORESTONE_DIAMOND = new Corerock("centercorestone_diamond", Material.ROCK);
	public static final Block CENTERCORESTONE_TOPAZ = new Corerock("centercorestone_topaz", Material.ROCK);
	public static final Block CENTERCORESTONE_RUBY = new Corerock("centercorestone_ruby", Material.ROCK);
	public static final Block CENTERCORESTONE_FLAMING_TOPAZ = new Corerock("centercorestone_flaming_topaz", Material.ROCK);
	public static final Block CENTERCORESTONE_SAPPHIRE = new Corerock("centercorestone_sapphire", Material.ROCK);
	public static final Block CENTERCORESTONE_EMERALD = new Corerock("centercorestone_emerald", Material.ROCK);
	public static final Block CENTERCORESTONE_LAPIS = new Corerock("centercorestone_lapis", Material.ROCK);
	public static final Block CENTERCORESTONE_REDSTONE = new Corerock("centercorestone_redstone", Material.ROCK);
	public static final Block CENTERCORESTONE_PLATINUM = new Corerock("centercorestone_platinum", Material.ROCK);
	public static final Block CENTERCORESTONE_GOLD = new Corerock("centercorestone_gold", Material.ROCK);
	public static final Block CENTERCORESTONE_SILVER = new Corerock("centercorestone_silver", Material.ROCK);
	public static final Block CENTERCORESTONE_IRON = new Corerock("centercorestone_iron", Material.ROCK);
	public static final Block CENTERCORESTONE_COAL = new Corerock("centercorestone_coal", Material.ROCK);
	public static final Block CENTERCORESTONE_SULFUR = new Corerock("centercorestone_sulfur", Material.ROCK);
	
	public static final Block HARDSTONE = new RockBase("hardstone", Material.ROCK);
	public static final Block DEEPSTONE = new RockBase("deepstone", Material.ROCK);
	public static final Block CRUSTROCK = new RockBase("crustrock", Material.ROCK);
	public static final Block MANTLEROCK = new RockBase("mantlerock", Material.ROCK);
	public static final Block LOWER_MANTLEROCK = new RockBase("lower_mantlerock", Material.ROCK);
	public static final Block CORESTONE = new Corerock("corestone", Material.ROCK);
	public static final Block INNERCORESTONE = new Corerock("innercorestone", Material.ROCK);
	public static final Block CENTERCORESTONE = new Corerock("centercorestone", Material.ROCK);
	public static final Block COLD_CORESTONE = new BlockBase("cold_corestone", Material.ROCK);

	//SEDIMENTARY ROCK
	public static final Block LIMESTONE = new RockBase("limestone", Material.ROCK);
	
	public static final Block MANTLEGAS = new GasBase("mantlegas", Material.ROCK);
	public static final Block HOT_MANTLEROCK = new Hot_Mantlerock("hot_mantlerock_0", Material.ROCK);
	public static final Block VERY_HOT_MANTLEROCK = new Hot_Mantlerock("hot_mantlerock_1", Material.ROCK);
	public static final Block SUPER_HOT_MANTLEROCK = new Hot_Mantlerock("hot_mantlerock_2", Material.ROCK);
	
	public static final Block HOTROCK = new BlockBase("hotrock", Material.ROCK);
	
	
}

