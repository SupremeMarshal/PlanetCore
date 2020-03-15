package com.PlanetCore.init;


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
	public static final Block ONYX_LAVA_BLOCK = new OnyxLavaFluid("onyx_lava", ModFluids.ONYX_LAVA_FLUID, Material.LAVA);

	public static final Block AZURITE_BLOCK = new BlocksBase("azurite_block", Material.ROCK);
	public static final Block ONYX_BLOCK = new BlocksBase("onyx_block", Material.ROCK).setResistance(1000000);
	public static final Block AMETHYST_BLOCK = new BlocksBase("amethyst_block", Material.ROCK);
	public static final Block AMAZONITE_BLOCK = new BlocksBase("amazonite_block", Material.ROCK).setResistance(500000);
	public static final Block JADE_BLOCK = new BlocksBase("jade_block", Material.ROCK);
	public static final Block DIAMOND_BLOCK = new BlocksBase("diamond_block", Material.ROCK).setResistance(200000);
	public static final Block TOPAZ_BLOCK = new BlocksBase("topaz_block", Material.ROCK);
	public static final Block RUBY_BLOCK = new BlocksBase("ruby_block", Material.ROCK).setResistance(100000);
	public static final Block FLAMING_TOPAZ_BLOCK = new BlocksBase("flaming_topaz_block", Material.ROCK);
	public static final Block SAPPHIRE_BLOCK = new BlocksBase("sapphire_block", Material.ROCK).setResistance(50000);
	public static final Block PLATINUM_BLOCK = new BlocksBase("platinum_block", Material.ROCK).setResistance(3000);
	public static final Block GOLD_BLOCK = new BlocksBase("gold_block", Material.ROCK).setResistance(2000);
	public static final Block SILVER_BLOCK = new BlocksBase("silver_block", Material.ROCK).setResistance(1000);
	public static final Block STEEL_BLOCK = new BlocksBase("steel_block", Material.ROCK).setResistance(500);
	public static final Block IRON_BLOCK = new BlocksBase("iron_block", Material.ROCK).setResistance(100);
	public static final Block SULFUR_BLOCK = new BlocksBase("sulfur_block", Material.ROCK);
	
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
	
	public static final Block HARDROCK_AZURITE = new GemBase("hardrock_azurite", Material.ROCK);
	public static final Block HARDROCK_ONYX = new GemBase("hardrock_onyx", Material.ROCK);
	public static final Block HARDROCK_AMETHYST = new GemBase("hardrock_amethyst", Material.ROCK);
	public static final Block HARDROCK_AMAZONITE = new GemBase("hardrock_amazonite", Material.ROCK);
	public static final Block HARDROCK_JADE = new GemBase("hardrock_jade", Material.ROCK);
	public static final Block HARDROCK_DIAMOND = new GemBase("hardrock_diamond", Material.ROCK);
	public static final Block HARDROCK_TOPAZ = new GemBase("hardrock_topaz", Material.ROCK);
	public static final Block HARDROCK_RUBY = new GemBase("hardrock_ruby", Material.ROCK);
	public static final Block HARDROCK_FLAMING_TOPAZ = new GemBase("hardrock_flaming_topaz", Material.ROCK);
	public static final Block HARDROCK_SAPPHIRE = new GemBase("hardrock_sapphire", Material.ROCK);
	public static final Block HARDROCK_EMERALD = new GemBase("hardrock_emerald", Material.ROCK);
	public static final Block HARDROCK_PLATINUM = new RockBase("hardrock_platinum", Material.ROCK);
	public static final Block HARDROCK_GOLD = new RockBase("hardrock_gold", Material.ROCK);
	public static final Block HARDROCK_SILVER = new RockBase("hardrock_silver", Material.ROCK);
	public static final Block HARDROCK_IRON = new RockBase("hardrock_iron", Material.ROCK);
	public static final Block HARDROCK_COAL = new GemBase("hardrock_coal", Material.ROCK);
	public static final Block HARDROCK_REDSTONE = new GemBase("hardrock_redstone", Material.ROCK);
	public static final Block HARDROCK_LAPIS = new RockBase("hardrock_lapis", Material.ROCK);
	public static final Block HARDROCK_SULFUR = new GemBase("hardrock_sulfur", Material.ROCK);
	
	public static final Block DEEPROCK_AZURITE = new GemBase("deeprock_azurite", Material.ROCK);
	public static final Block DEEPROCK_ONYX = new GemBase("deeprock_onyx", Material.ROCK);
	public static final Block DEEPROCK_AMETHYST = new GemBase("deeprock_amethyst", Material.ROCK);
	public static final Block DEEPROCK_AMAZONITE = new GemBase("deeprock_amazonite", Material.ROCK);
	public static final Block DEEPROCK_JADE = new GemBase("deeprock_jade", Material.ROCK);
	public static final Block DEEPROCK_DIAMOND = new GemBase("deeprock_diamond", Material.ROCK);
	public static final Block DEEPROCK_TOPAZ = new GemBase("deeprock_topaz", Material.ROCK);
	public static final Block DEEPROCK_RUBY = new GemBase("deeprock_ruby", Material.ROCK);
	public static final Block DEEPROCK_FLAMING_TOPAZ = new GemBase("deeprock_flaming_topaz", Material.ROCK);
	public static final Block DEEPROCK_SAPPHIRE = new GemBase("deeprock_sapphire", Material.ROCK);
	public static final Block DEEPROCK_EMERALD = new GemBase("deeprock_emerald", Material.ROCK);
	public static final Block DEEPROCK_PLATINUM = new RockBase("deeprock_platinum", Material.ROCK);
	public static final Block DEEPROCK_GOLD = new RockBase("deeprock_gold", Material.ROCK);
	public static final Block DEEPROCK_SILVER = new RockBase("deeprock_silver", Material.ROCK);
	public static final Block DEEPROCK_IRON = new RockBase("deeprock_iron", Material.ROCK);
	public static final Block DEEPROCK_COAL = new GemBase("deeprock_coal", Material.ROCK);
	public static final Block DEEPROCK_REDSTONE = new GemBase("deeprock_redstone", Material.ROCK);
	public static final Block DEEPROCK_LAPIS = new RockBase("deeprock_lapis", Material.ROCK);
	public static final Block DEEPROCK_SULFUR = new GemBase("deeprock_sulfur", Material.ROCK);

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

	public static final Block CORESTONE_AZURITE = new CoreRockGemBase("corestone_azurite", Material.ROCK);
	public static final Block CORESTONE_ONYX = new CoreRockGemBase("corestone_onyx", Material.ROCK);
	public static final Block CORESTONE_AMETHYST = new CoreRockGemBase("corestone_amethyst", Material.ROCK);
	public static final Block CORESTONE_AMAZONITE = new CoreRockGemBase("corestone_amazonite", Material.ROCK);
	public static final Block CORESTONE_JADE = new CoreRockGemBase("corestone_jade", Material.ROCK);
	public static final Block CORESTONE_DIAMOND = new CoreRockGemBase("corestone_diamond", Material.ROCK);
	public static final Block CORESTONE_TOPAZ = new CoreRockGemBase("corestone_topaz", Material.ROCK);
	public static final Block CORESTONE_RUBY = new CoreRockGemBase("corestone_ruby", Material.ROCK);
	public static final Block CORESTONE_FLAMING_TOPAZ = new CoreRockGemBase("corestone_flaming_topaz", Material.ROCK);
	public static final Block CORESTONE_SAPPHIRE = new CoreRockGemBase("corestone_sapphire", Material.ROCK);
	public static final Block CORESTONE_EMERALD = new CoreRockGemBase("corestone_emerald", Material.ROCK);
	public static final Block CORESTONE_LAPIS = new CoreRockGemBase("corestone_lapis", Material.ROCK);
	public static final Block CORESTONE_REDSTONE = new CoreRockGemBase("corestone_redstone", Material.ROCK);
	public static final Block CORESTONE_PLATINUM = new CoreRockGemBase("corestone_platinum", Material.ROCK);
	public static final Block CORESTONE_GOLD = new CoreRockGemBase("corestone_gold", Material.ROCK);
	public static final Block CORESTONE_SILVER = new CoreRockGemBase("corestone_silver", Material.ROCK);
	public static final Block CORESTONE_IRON = new CoreRockGemBase("corestone_iron", Material.ROCK);
	public static final Block CORESTONE_COAL = new CoreRockGemBase("corestone_coal", Material.ROCK);
	public static final Block CORESTONE_SULFUR = new CoreRockGemBase("corestone_sulfur", Material.ROCK);

	public static final Block INNERCORESTONE_AZURITE = new CoreRockGemBase("innercorestone_azurite", Material.ROCK);
	public static final Block INNERCORESTONE_ONYX = new CoreRockGemBase("innercorestone_onyx", Material.ROCK);
	public static final Block INNERCORESTONE_AMETHYST = new CoreRockGemBase("innercorestone_amethyst", Material.ROCK);
	public static final Block INNERCORESTONE_AMAZONITE = new CoreRockGemBase("innercorestone_amazonite", Material.ROCK);
	public static final Block INNERCORESTONE_JADE = new CoreRockGemBase("innercorestone_jade", Material.ROCK);
	public static final Block INNERCORESTONE_DIAMOND = new CoreRockGemBase("innercorestone_diamond", Material.ROCK);
	public static final Block INNERCORESTONE_TOPAZ = new CoreRockGemBase("innercorestone_topaz", Material.ROCK);
	public static final Block INNERCORESTONE_RUBY = new CoreRockGemBase("innercorestone_ruby", Material.ROCK);
	public static final Block INNERCORESTONE_FLAMING_TOPAZ = new CoreRockGemBase("innercorestone_flaming_topaz", Material.ROCK);
	public static final Block INNERCORESTONE_SAPPHIRE = new CoreRockGemBase("innercorestone_sapphire", Material.ROCK);
	public static final Block INNERCORESTONE_EMERALD = new CoreRockGemBase("innercorestone_emerald", Material.ROCK);
	public static final Block INNERCORESTONE_LAPIS = new CoreRockGemBase("innercorestone_lapis", Material.ROCK);
	public static final Block INNERCORESTONE_REDSTONE = new CoreRockGemBase("innercorestone_redstone", Material.ROCK);
	public static final Block INNERCORESTONE_PLATINUM = new CoreRockGemBase("innercorestone_platinum", Material.ROCK);
	public static final Block INNERCORESTONE_GOLD = new CoreRockGemBase("innercorestone_gold", Material.ROCK);
	public static final Block INNERCORESTONE_SILVER = new CoreRockGemBase("innercorestone_silver", Material.ROCK);
	public static final Block INNERCORESTONE_IRON = new CoreRockGemBase("innercorestone_iron", Material.ROCK);
	public static final Block INNERCORESTONE_COAL = new CoreRockGemBase("innercorestone_coal", Material.ROCK);
	public static final Block INNERCORESTONE_SULFUR = new CoreRockGemBase("innercorestone_sulfur", Material.ROCK);
	
	public static final Block CENTERCORESTONE_AZURITE = new CoreRockGemBase("centercorestone_azurite", Material.ROCK);
	public static final Block CENTERCORESTONE_ONYX = new CoreRockGemBase("centercorestone_onyx", Material.ROCK);
	public static final Block CENTERCORESTONE_AMETHYST = new CoreRockGemBase("centercorestone_amethyst", Material.ROCK);
	public static final Block CENTERCORESTONE_AMAZONITE = new CoreRockGemBase("centercorestone_amazonite", Material.ROCK);
	public static final Block CENTERCORESTONE_JADE = new CoreRockGemBase("centercorestone_jade", Material.ROCK);
	public static final Block CENTERCORESTONE_DIAMOND = new CoreRockGemBase("centercorestone_diamond", Material.ROCK);
	public static final Block CENTERCORESTONE_TOPAZ = new CoreRockGemBase("centercorestone_topaz", Material.ROCK);
	public static final Block CENTERCORESTONE_RUBY = new CoreRockGemBase("centercorestone_ruby", Material.ROCK);
	public static final Block CENTERCORESTONE_FLAMING_TOPAZ = new CoreRockGemBase("centercorestone_flaming_topaz", Material.ROCK);
	public static final Block CENTERCORESTONE_SAPPHIRE = new CoreRockGemBase("centercorestone_sapphire", Material.ROCK);
	public static final Block CENTERCORESTONE_EMERALD = new CoreRockGemBase("centercorestone_emerald", Material.ROCK);
	public static final Block CENTERCORESTONE_LAPIS = new CoreRockGemBase("centercorestone_lapis", Material.ROCK);
	public static final Block CENTERCORESTONE_REDSTONE = new CoreRockGemBase("centercorestone_redstone", Material.ROCK);
	public static final Block CENTERCORESTONE_PLATINUM = new CoreRockGemBase("centercorestone_platinum", Material.ROCK);
	public static final Block CENTERCORESTONE_GOLD = new CoreRockGemBase("centercorestone_gold", Material.ROCK);
	public static final Block CENTERCORESTONE_SILVER = new CoreRockGemBase("centercorestone_silver", Material.ROCK);
	public static final Block CENTERCORESTONE_IRON = new CoreRockGemBase("centercorestone_iron", Material.ROCK);
	public static final Block CENTERCORESTONE_COAL = new CoreRockGemBase("centercorestone_coal", Material.ROCK);
	public static final Block CENTERCORESTONE_SULFUR = new CoreRockGemBase("centercorestone_sulfur", Material.ROCK);
	
	public static final Block HARDROCK = new RockBase("hardrock", Material.ROCK);
	public static final Block HARDROCK1 = new RockBase("hardrock1", Material.ROCK);
	public static final Block HARDROCK2 = new RockBase("hardrock2", Material.ROCK);
	public static final Block HARDROCK3 = new RockBase("hardrock3", Material.ROCK);
	public static final Block DEEPROCK = new RockBase("deeprock", Material.ROCK);
	public static final Block DEEPROCK1 = new RockBase("deeprock1", Material.ROCK);
	public static final Block DEEPROCK2 = new RockBase("deeprock2", Material.ROCK);
	public static final Block DEEPROCK3 = new RockBase("deeprock3", Material.ROCK);
	public static final Block DEEPROCK4 = new RockBase("deeprock4", Material.ROCK);
	public static final Block DEEPROCK5 = new RockBase("deeprock5", Material.ROCK);
	public static final Block CRUSTROCK = new RockBase("crustrock", Material.ROCK);
	public static final Block CRUSTROCK1 = new RockBase("crustrock1", Material.ROCK);
	public static final Block CRUSTROCK2 = new RockBase("crustrock2", Material.ROCK);
	public static final Block CRUSTROCK3 = new RockBase("crustrock3", Material.ROCK);
	public static final Block CRUSTROCK4 = new RockBase("crustrock4", Material.ROCK);
	public static final Block CRUSTROCK5 = new RockBase("crustrock5", Material.ROCK);
	public static final Block MANTLEROCK = new Mantlerock("mantlerock", Material.ROCK).setLightLevel(0.0F);
	public static final Block MANTLEROCK1 = new Mantlerock("mantlerock1", Material.ROCK).setLightLevel(0.05F);
	public static final Block MANTLEROCK2 = new Mantlerock("mantlerock2", Material.ROCK).setLightLevel(0.01F);
	public static final Block MANTLEROCK3 = new Mantlerock("mantlerock3", Material.ROCK).setLightLevel(0.015F);
	public static final Block MANTLEROCK4 = new Mantlerock("mantlerock4", Material.ROCK).setLightLevel(0.02F);
	public static final Block MANTLEROCK5 = new Mantlerock("mantlerock5", Material.ROCK).setLightLevel(0.025F);
	public static final Block MANTLEROCK6 = new Mantlerock("mantlerock6", Material.ROCK).setLightLevel(0.03F);
	public static final Block MANTLEROCK7 = new Mantlerock("mantlerock7", Material.ROCK).setLightLevel(0.035F);
	public static final Block MANTLEROCK8 = new Mantlerock("mantlerock8", Material.ROCK).setLightLevel(0.04F);
	public static final Block MANTLEROCK9 = new Mantlerock("mantlerock9", Material.ROCK).setLightLevel(0.045F);
	public static final Block MANTLEROCK10 = new Mantlerock("mantlerock10", Material.ROCK).setLightLevel(0.05F);
	public static final Block LOWER_MANTLEROCK1 = new Mantlerock("lower_mantlerock1", Material.ROCK).setLightLevel(0.055F);
	public static final Block LOWER_MANTLEROCK2 = new Mantlerock("lower_mantlerock2", Material.ROCK).setLightLevel(0.06F);
	public static final Block LOWER_MANTLEROCK3 = new Mantlerock("lower_mantlerock3", Material.ROCK).setLightLevel(0.065F);
	public static final Block LOWER_MANTLEROCK4 = new Mantlerock("lower_mantlerock4", Material.ROCK).setLightLevel(0.07F);
	public static final Block LOWER_MANTLEROCK5 = new Mantlerock("lower_mantlerock5", Material.ROCK).setLightLevel(0.075F);
	public static final Block LOWER_MANTLEROCK6 = new Mantlerock("lower_mantlerock6", Material.ROCK).setLightLevel(0.08F);
	public static final Block LOWER_MANTLEROCK7 = new Mantlerock("lower_mantlerock7", Material.ROCK).setLightLevel(0.085F);
	public static final Block LOWER_MANTLEROCK8 = new Mantlerock("lower_mantlerock8", Material.ROCK).setLightLevel(0.09F);
	public static final Block LOWER_MANTLEROCK9 = new Mantlerock("lower_mantlerock9", Material.ROCK).setLightLevel(0.095F);
	public static final Block LOWER_MANTLEROCK10 = new Mantlerock("lower_mantlerock10", Material.ROCK).setLightLevel(1.0F);
	public static final Block CORESTONE = new Corerock("corestone", Material.ROCK);
	public static final Block INNERCORESTONE = new Corerock("innercorestone", Material.ROCK);
	public static final Block CENTERCORESTONE = new Corerock("centercorestone", Material.ROCK);
	public static final Block MAGMA_CORESTONE = new Corerock("magma_corestone", Material.ROCK);
	public static final Block COLD_CORESTONE = new BlockBase("cold_corestone", Material.ROCK);

	//SEDIMENTARY ROCK
	public static final Block LIMESTONE = new RockBase("limestone", Material.ROCK);
	
	public static final Block MANTLEGAS = new GasBase("mantlegas", Material.ROCK);
	public static final Block HOT_MANTLEROCK = new Hot_Mantlerock("hot_mantlerock_0", Material.ROCK);
	public static final Block VERY_HOT_MANTLEROCK = new Hot_Mantlerock("hot_mantlerock_1", Material.ROCK);
	public static final Block SUPER_HOT_MANTLEROCK = new Hot_Mantlerock("hot_mantlerock_2", Material.ROCK);
	
	public static final Block HOTROCK = new BlockBase("hotrock", Material.ROCK);
	
	
}

