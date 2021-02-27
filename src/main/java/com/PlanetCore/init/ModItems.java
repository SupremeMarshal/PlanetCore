package com.PlanetCore.init;

import com.PlanetCore.items.ShinyItem;
import com.PlanetCore.items.ItemAxeX;
import com.PlanetCore.items.ItemPickaxeX;
import com.PlanetCore.items.armor.*;
import com.PlanetCore.items.food.SixEffectFoodItem;
import com.PlanetCore.items.food.EightEffectFoodItem;
import com.PlanetCore.items.food.ThreeEffectFoodItem;
import com.PlanetCore.items.shields.*;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ModItems {


	private static final List<Item> ITEMS = new ArrayList<>();


	public static final Item HOT_BLAZE_POWDER = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item HOT_MAGMA_CREAM = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	//TOOLS

	//WOODEN//
	public static final ItemSword WOODEN_SWORD = new ItemSword(ToolMaterials.WOODEN);
	public static final ItemSpade WOODEN_SHOVEL = new ItemSpade(ToolMaterials.WOODEN);
	public static final ItemPickaxe WOODEN_PICKAXE = new ItemPickaxeX(ToolMaterials.WOODEN);
	public static final ItemAxe WOODEN_AXE = new ItemAxeX(ToolMaterials.WOODEN);
	public static final ItemHoe WOODEN_HOE = new ItemHoe(ToolMaterials.WOODEN);

	//STONE//
	public static final ItemSword STONE_SWORD = new ItemSword(ToolMaterials.STONE);
	public static final ItemSpade STONE_SHOVEL = new ItemSpade(ToolMaterials.STONE);
	public static final ItemPickaxe STONE_PICKAXE = new ItemPickaxeX(ToolMaterials.STONE);
	public static final ItemAxe STONE_AXE = new ItemAxeX(ToolMaterials.STONE);
	public static final ItemHoe STONE_HOE = new ItemHoe(ToolMaterials.STONE);

	//ALUMINIUM//
	public static final ItemSword ALUMINIUM_SWORD = new ItemSword(ToolMaterials.ALUMINIUM);
	public static final ItemSpade ALUMINIUM_SHOVEL = new ItemSpade(ToolMaterials.ALUMINIUM);
	public static final ItemPickaxe ALUMINIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.ALUMINIUM);
	public static final ItemAxe ALUMINIUM_AXE = new ItemAxeX(ToolMaterials.ALUMINIUM);
	public static final ItemHoe ALUMINIUM_HOE = new ItemHoe(ToolMaterials.ALUMINIUM);
	public static final ItemSword COMPLETE_ALUMINIUM_SWORD = new ItemSword(ToolMaterials.COMPLETE_ALUMINIUM);
	public static final ItemSpade COMPLETE_ALUMINIUM_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_ALUMINIUM);
	public static final ItemPickaxe COMPLETE_ALUMINIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_ALUMINIUM);
	public static final ItemAxe COMPLETE_ALUMINIUM_AXE = new ItemAxeX(ToolMaterials.COMPLETE_ALUMINIUM);
	public static final ItemHoe COMPLETE_ALUMINIUM_HOE = new ItemHoe(ToolMaterials.COMPLETE_ALUMINIUM);

	public static final Item ALUMINIUM_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ALUMINIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item ALUMINIUM_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ALUMINIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item ALUMINIUM_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ALUMINIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item ALUMINIUM_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ALUMINIUM, 1, EntityEquipmentSlot.FEET);

	//ZINC//
	public static final ItemSword ZINC_SWORD = new ItemSword(ToolMaterials.ZINC);
	public static final ItemSpade ZINC_SHOVEL = new ItemSpade(ToolMaterials.ZINC);
	public static final ItemPickaxe ZINC_PICKAXE = new ItemPickaxeX(ToolMaterials.ZINC);
	public static final ItemAxe ZINC_AXE = new ItemAxeX(ToolMaterials.ZINC);
	public static final ItemHoe ZINC_HOE = new ItemHoe(ToolMaterials.ZINC);
	public static final ItemSword COMPLETE_ZINC_SWORD = new ItemSword(ToolMaterials.COMPLETE_ZINC);
	public static final ItemSpade COMPLETE_ZINC_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_ZINC);
	public static final ItemPickaxe COMPLETE_ZINC_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_ZINC);
	public static final ItemAxe COMPLETE_ZINC_AXE = new ItemAxeX(ToolMaterials.COMPLETE_ZINC);
	public static final ItemHoe COMPLETE_ZINC_HOE = new ItemHoe(ToolMaterials.COMPLETE_ZINC);

	public static final Item ZINC_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ZINC, 1, EntityEquipmentSlot.HEAD);
	public static final Item ZINC_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ZINC, 1, EntityEquipmentSlot.CHEST);
	public static final Item ZINC_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ZINC, 2, EntityEquipmentSlot.LEGS);
	public static final Item ZINC_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ZINC, 1, EntityEquipmentSlot.FEET);

	//LEAD//
	public static final ItemSword LEAD_SWORD = new ItemSword(ToolMaterials.LEAD);
	public static final ItemSpade LEAD_SHOVEL = new ItemSpade(ToolMaterials.LEAD);
	public static final ItemPickaxe LEAD_PICKAXE = new ItemPickaxeX(ToolMaterials.LEAD);
	public static final ItemAxe LEAD_AXE = new ItemAxeX(ToolMaterials.LEAD);
	public static final ItemHoe LEAD_HOE = new ItemHoe(ToolMaterials.LEAD);
	public static final ItemSword COMPLETE_LEAD_SWORD = new ItemSword(ToolMaterials.COMPLETE_LEAD);
	public static final ItemSpade COMPLETE_LEAD_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_LEAD);
	public static final ItemPickaxe COMPLETE_LEAD_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_LEAD);
	public static final ItemAxe COMPLETE_LEAD_AXE = new ItemAxeX(ToolMaterials.COMPLETE_LEAD);
	public static final ItemHoe COMPLETE_LEAD_HOE = new ItemHoe(ToolMaterials.COMPLETE_LEAD);

	public static final Item LEAD_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_LEAD, 1, EntityEquipmentSlot.HEAD);
	public static final Item LEAD_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_LEAD, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEAD_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_LEAD, 2, EntityEquipmentSlot.LEGS);
	public static final Item LEAD_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_LEAD, 1, EntityEquipmentSlot.FEET);

	//TIN//
	public static final ItemSword TIN_SWORD = new ItemSword(ToolMaterials.TIN);
	public static final ItemSpade TIN_SHOVEL = new ItemSpade(ToolMaterials.TIN);
	public static final ItemPickaxe TIN_PICKAXE = new ItemPickaxeX(ToolMaterials.TIN);
	public static final ItemAxe TIN_AXE = new ItemAxeX(ToolMaterials.TIN);
	public static final ItemHoe TIN_HOE = new ItemHoe(ToolMaterials.TIN);
	public static final ItemSword COMPLETE_TIN_SWORD = new ItemSword(ToolMaterials.COMPLETE_TIN);
	public static final ItemSpade COMPLETE_TIN_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_TIN);
	public static final ItemPickaxe COMPLETE_TIN_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_TIN);
	public static final ItemAxe COMPLETE_TIN_AXE = new ItemAxeX(ToolMaterials.COMPLETE_TIN);
	public static final ItemHoe COMPLETE_TIN_HOE = new ItemHoe(ToolMaterials.COMPLETE_TIN);

	public static final Item TIN_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TIN, 1, EntityEquipmentSlot.HEAD);
	public static final Item TIN_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TIN, 1, EntityEquipmentSlot.CHEST);
	public static final Item TIN_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TIN, 2, EntityEquipmentSlot.LEGS);
	public static final Item TIN_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TIN, 1, EntityEquipmentSlot.FEET);

	//SILICON//
	public static final ItemSword SILICON_SWORD = new ItemSword(ToolMaterials.SILICON);
	public static final ItemSpade SILICON_SHOVEL = new ItemSpade(ToolMaterials.SILICON);
	public static final ItemPickaxe SILICON_PICKAXE = new ItemPickaxeX(ToolMaterials.SILICON);
	public static final ItemAxe SILICON_AXE = new ItemAxeX(ToolMaterials.SILICON);
	public static final ItemHoe SILICON_HOE = new ItemHoe(ToolMaterials.SILICON);
	public static final ItemSword COMPLETE_SILICON_SWORD = new ItemSword(ToolMaterials.COMPLETE_SILICON);
	public static final ItemSpade COMPLETE_SILICON_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_SILICON);
	public static final ItemPickaxe COMPLETE_SILICON_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_SILICON);
	public static final ItemAxe COMPLETE_SILICON_AXE = new ItemAxeX(ToolMaterials.COMPLETE_SILICON);
	public static final ItemHoe COMPLETE_SILICON_HOE = new ItemHoe(ToolMaterials.COMPLETE_SILICON);

	public static final Item SILICON_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SILICON, 1, EntityEquipmentSlot.HEAD);
	public static final Item SILICON_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SILICON, 1, EntityEquipmentSlot.CHEST);
	public static final Item SILICON_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SILICON, 2, EntityEquipmentSlot.LEGS);
	public static final Item SILICON_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SILICON, 1, EntityEquipmentSlot.FEET);

	//COPPER//
	public static final ItemSword COPPER_SWORD = new ItemSword(ToolMaterials.COPPER);
	public static final ItemSpade COPPER_SHOVEL = new ItemSpade(ToolMaterials.COPPER);
	public static final ItemPickaxe COPPER_PICKAXE = new ItemPickaxeX(ToolMaterials.COPPER);
	public static final ItemAxe COPPER_AXE = new ItemAxeX(ToolMaterials.COPPER);
	public static final ItemHoe COPPER_HOE = new ItemHoe(ToolMaterials.COPPER);
	public static final ItemSword COMPLETE_COPPER_SWORD = new ItemSword(ToolMaterials.COMPLETE_COPPER);
	public static final ItemSpade COMPLETE_COPPER_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_COPPER);
	public static final ItemPickaxe COMPLETE_COPPER_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_COPPER);
	public static final ItemAxe COMPLETE_COPPER_AXE = new ItemAxeX(ToolMaterials.COMPLETE_COPPER);
	public static final ItemHoe COMPLETE_COPPER_HOE = new ItemHoe(ToolMaterials.COMPLETE_COPPER);

	public static final Item COPPER_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_COPPER, 1, EntityEquipmentSlot.HEAD);
	public static final Item COPPER_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_COPPER, 1, EntityEquipmentSlot.CHEST);
	public static final Item COPPER_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_COPPER, 2, EntityEquipmentSlot.LEGS);
	public static final Item COPPER_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_COPPER, 1, EntityEquipmentSlot.FEET);

	//IRON//
	public static final ItemSword IRON_SWORD = new ItemSword(ToolMaterials.IRON);
	public static final ItemSpade IRON_SHOVEL = new ItemSpade(ToolMaterials.IRON);
	public static final ItemPickaxe IRON_PICKAXE = new ItemPickaxeX(ToolMaterials.IRON);
	public static final ItemAxe IRON_AXE = new ItemAxeX(ToolMaterials.IRON);
	public static final ItemHoe IRON_HOE = new ItemHoe(ToolMaterials.IRON);
	public static final ItemSword COMPLETE_IRON_SWORD = new ItemSword(ToolMaterials.COMPLETE_IRON);
	public static final ItemSpade COMPLETE_IRON_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_IRON);
	public static final ItemPickaxe COMPLETE_IRON_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_IRON);
	public static final ItemAxe COMPLETE_IRON_AXE = new ItemAxeX(ToolMaterials.COMPLETE_IRON);
	public static final ItemHoe COMPLETE_IRON_HOE = new ItemHoe(ToolMaterials.COMPLETE_IRON);

	public static final Item IRON_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_IRON, 1, EntityEquipmentSlot.HEAD);
	public static final Item IRON_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_IRON, 1, EntityEquipmentSlot.CHEST);
	public static final Item IRON_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_IRON, 2, EntityEquipmentSlot.LEGS);
	public static final Item IRON_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_IRON, 1, EntityEquipmentSlot.FEET);

	//STEEL//
	public static final ItemSword STEEL_SWORD = new ItemSword(ToolMaterials.STEEL);
	public static final ItemSpade STEEL_SHOVEL = new ItemSpade(ToolMaterials.STEEL);
	public static final ItemPickaxe STEEL_PICKAXE = new ItemPickaxeX(ToolMaterials.STEEL);
	public static final ItemAxe STEEL_AXE = new ItemAxeX(ToolMaterials.STEEL);
	public static final ItemHoe STEEL_HOE = new ItemHoe(ToolMaterials.STEEL);
	public static final ItemSword COMPLETE_STEEL_SWORD = new ItemSword(ToolMaterials.COMPLETE_STEEL);
	public static final ItemSpade COMPLETE_STEEL_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_STEEL);
	public static final ItemPickaxe COMPLETE_STEEL_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_STEEL);
	public static final ItemAxe COMPLETE_STEEL_AXE = new ItemAxeX(ToolMaterials.COMPLETE_STEEL);
	public static final ItemHoe COMPLETE_STEEL_HOE = new ItemHoe(ToolMaterials.COMPLETE_STEEL);

	public static final Item STEEL_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_STEEL, 1, EntityEquipmentSlot.HEAD);
	public static final Item STEEL_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_STEEL, 1, EntityEquipmentSlot.CHEST);
	public static final Item STEEL_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_STEEL, 2, EntityEquipmentSlot.LEGS);
	public static final Item STEEL_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_STEEL, 1, EntityEquipmentSlot.FEET);

	//BRONZE//
	public static final ItemSword BRONZE_SWORD = new ItemSword(ToolMaterials.BRONZE);
	public static final ItemSpade BRONZE_SHOVEL = new ItemSpade(ToolMaterials.BRONZE);
	public static final ItemPickaxe BRONZE_PICKAXE = new ItemPickaxeX(ToolMaterials.BRONZE);
	public static final ItemAxe BRONZE_AXE = new ItemAxeX(ToolMaterials.BRONZE);
	public static final ItemHoe BRONZE_HOE = new ItemHoe(ToolMaterials.BRONZE);
	public static final ItemSword COMPLETE_BRONZE_SWORD = new ItemSword(ToolMaterials.COMPLETE_BRONZE);
	public static final ItemSpade COMPLETE_BRONZE_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_BRONZE);
	public static final ItemPickaxe COMPLETE_BRONZE_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_BRONZE);
	public static final ItemAxe COMPLETE_BRONZE_AXE = new ItemAxeX(ToolMaterials.COMPLETE_BRONZE);
	public static final ItemHoe COMPLETE_BRONZE_HOE = new ItemHoe(ToolMaterials.COMPLETE_BRONZE);

	public static final Item BRONZE_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_BRONZE, 1, EntityEquipmentSlot.HEAD);
	public static final Item BRONZE_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_BRONZE, 1, EntityEquipmentSlot.CHEST);
	public static final Item BRONZE_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_BRONZE, 2, EntityEquipmentSlot.LEGS);
	public static final Item BRONZE_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_BRONZE, 1, EntityEquipmentSlot.FEET);

	//SILVER//
	public static final ItemSword SILVER_SWORD = new ItemSword(ToolMaterials.SILVER);
	public static final ItemSpade SILVER_SHOVEL = new ItemSpade(ToolMaterials.SILVER);
	public static final ItemPickaxe SILVER_PICKAXE = new ItemPickaxeX(ToolMaterials.SILVER);
	public static final ItemAxe SILVER_AXE = new ItemAxeX(ToolMaterials.SILVER);
	public static final ItemHoe SILVER_HOE = new ItemHoe(ToolMaterials.SILVER);
	public static final ItemSword COMPLETE_SILVER_SWORD = new ItemSword(ToolMaterials.COMPLETE_SILVER);
	public static final ItemSpade COMPLETE_SILVER_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_SILVER);
	public static final ItemPickaxe COMPLETE_SILVER_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_SILVER);
	public static final ItemAxe COMPLETE_SILVER_AXE = new ItemAxeX(ToolMaterials.COMPLETE_SILVER);
	public static final ItemHoe COMPLETE_SILVER_HOE = new ItemHoe(ToolMaterials.COMPLETE_SILVER);

	public static final Item SILVER_HELMET = new SilverHelmet(ArmorMaterials.ARMOR_MATERIAL_SILVER, 1, EntityEquipmentSlot.HEAD);
	public static final Item SILVER_CHESTPLATE = new SilverBody(ArmorMaterials.ARMOR_MATERIAL_SILVER, 1, EntityEquipmentSlot.CHEST);
	public static final Item SILVER_LEGGINGS = new SilverLegs(ArmorMaterials.ARMOR_MATERIAL_SILVER, 2, EntityEquipmentSlot.LEGS);
	public static final Item SILVER_BOOTS = new SilverBoots(ArmorMaterials.ARMOR_MATERIAL_SILVER, 1, EntityEquipmentSlot.FEET);

	//GOLD//
	public static final ItemSword GOLD_SWORD = new ItemSword(ToolMaterials.GOLD);
	public static final ItemSpade GOLD_SHOVEL = new ItemSpade(ToolMaterials.GOLD);
	public static final ItemPickaxe GOLD_PICKAXE = new ItemPickaxeX(ToolMaterials.GOLD);
	public static final ItemAxe GOLD_AXE = new ItemAxeX(ToolMaterials.GOLD);
	public static final ItemHoe GOLD_HOE = new ItemHoe(ToolMaterials.GOLD);
	public static final ItemSword COMPLETE_GOLD_SWORD = new ItemSword(ToolMaterials.COMPLETE_GOLD);
	public static final ItemSpade COMPLETE_GOLD_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_GOLD);
	public static final ItemPickaxe COMPLETE_GOLD_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_GOLD);
	public static final ItemAxe COMPLETE_GOLD_AXE = new ItemAxeX(ToolMaterials.COMPLETE_GOLD);
	public static final ItemHoe COMPLETE_GOLD_HOE = new ItemHoe(ToolMaterials.COMPLETE_GOLD);

	public static final Item GOLD_HELMET = new GoldHelmet(ArmorMaterials.ARMOR_MATERIAL_GOLD, 1, EntityEquipmentSlot.HEAD);
	public static final Item GOLD_CHESTPLATE = new GoldBody(ArmorMaterials.ARMOR_MATERIAL_GOLD, 1, EntityEquipmentSlot.CHEST);
	public static final Item GOLD_LEGGINGS = new GoldLegs(ArmorMaterials.ARMOR_MATERIAL_GOLD, 2, EntityEquipmentSlot.LEGS);
	public static final Item GOLD_BOOTS = new GoldBoots(ArmorMaterials.ARMOR_MATERIAL_GOLD, 1, EntityEquipmentSlot.FEET);

	public static final Item AEROGEL_GOLD_HELMET = new GoldHelmet(ArmorMaterials.ARMOR_MATERIAL_AEROGEL_GOLD, 1, EntityEquipmentSlot.HEAD);
	public static final Item AEROGEL_GOLD_CHESTPLATE = new GoldBody(ArmorMaterials.ARMOR_MATERIAL_AEROGEL_GOLD, 1, EntityEquipmentSlot.CHEST);
	public static final Item AEROGEL_GOLD_LEGGINGS = new GoldLegs(ArmorMaterials.ARMOR_MATERIAL_AEROGEL_GOLD, 2, EntityEquipmentSlot.LEGS);
	public static final Item AEROGEL_GOLD_BOOTS = new GoldBoots(ArmorMaterials.ARMOR_MATERIAL_AEROGEL_GOLD, 1, EntityEquipmentSlot.FEET);

	//PLATINUM//
	public static final ItemSword PLATINUM_SWORD = new ItemSword(ToolMaterials.PLATINUM);
	public static final ItemSpade PLATINUM_SHOVEL = new ItemSpade(ToolMaterials.PLATINUM);
	public static final ItemPickaxe PLATINUM_PICKAXE = new ItemPickaxeX(ToolMaterials.PLATINUM);
	public static final ItemAxe PLATINUM_AXE = new ItemAxeX(ToolMaterials.PLATINUM);
	public static final ItemHoe PLATINUM_HOE = new ItemHoe(ToolMaterials.PLATINUM);
	public static final ItemSword COMPLETE_PLATINUM_SWORD = new ItemSword(ToolMaterials.COMPLETE_PLATINUM);
	public static final ItemSpade COMPLETE_PLATINUM_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_PLATINUM);
	public static final ItemPickaxe COMPLETE_PLATINUM_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_PLATINUM);
	public static final ItemAxe COMPLETE_PLATINUM_AXE = new ItemAxeX(ToolMaterials.COMPLETE_PLATINUM);
	public static final ItemHoe COMPLETE_PLATINUM_HOE = new ItemHoe(ToolMaterials.COMPLETE_PLATINUM);

	public static final Item PLATINUM_HELMET = new PlatinumHelmet(ArmorMaterials.ARMOR_MATERIAL_PLATINUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item PLATINUM_CHESTPLATE = new PlatinumBody(ArmorMaterials.ARMOR_MATERIAL_PLATINUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item PLATINUM_LEGGINGS = new PlatinumLegs(ArmorMaterials.ARMOR_MATERIAL_PLATINUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item PLATINUM_BOOTS = new PlatinumBoots(ArmorMaterials.ARMOR_MATERIAL_PLATINUM, 1, EntityEquipmentSlot.FEET);

	//TITANIUM//
	public static final ItemSword TITANIUM_SWORD = new ItemSword(ToolMaterials.TITANIUM);
	public static final ItemSpade TITANIUM_SHOVEL = new ItemSpade(ToolMaterials.TITANIUM);
	public static final ItemPickaxe TITANIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.TITANIUM);
	public static final ItemAxe TITANIUM_AXE = new ItemAxeX(ToolMaterials.TITANIUM);
	public static final ItemHoe TITANIUM_HOE = new ItemHoe(ToolMaterials.TITANIUM);
	public static final ItemSword COMPLETE_TITANIUM_SWORD = new ItemSword(ToolMaterials.COMPLETE_TITANIUM);
	public static final ItemSpade COMPLETE_TITANIUM_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_TITANIUM);
	public static final ItemPickaxe COMPLETE_TITANIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_TITANIUM);
	public static final ItemAxe COMPLETE_TITANIUM_AXE = new ItemAxeX(ToolMaterials.COMPLETE_TITANIUM);
	public static final ItemHoe COMPLETE_TITANIUM_HOE = new ItemHoe(ToolMaterials.COMPLETE_TITANIUM);

	public static final Item TITANIUM_HELMET = new TitaniumHelmet(ArmorMaterials.ARMOR_MATERIAL_TITANIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item TITANIUM_CHESTPLATE = new TitaniumBody(ArmorMaterials.ARMOR_MATERIAL_TITANIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item TITANIUM_LEGGINGS = new TitaniumHelmet(ArmorMaterials.ARMOR_MATERIAL_TITANIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item TITANIUM_BOOTS = new TitaniumBoots(ArmorMaterials.ARMOR_MATERIAL_TITANIUM, 1, EntityEquipmentSlot.FEET);

	//URANIUM//
	public static final ItemSword URANIUM_SWORD = new ItemSword(ToolMaterials.URANIUM);
	public static final ItemSpade URANIUM_SHOVEL = new ItemSpade(ToolMaterials.URANIUM);
	public static final ItemPickaxe URANIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.URANIUM);
	public static final ItemAxe URANIUM_AXE = new ItemAxeX(ToolMaterials.URANIUM);
	public static final ItemHoe URANIUM_HOE = new ItemHoe(ToolMaterials.URANIUM);
	public static final ItemSword COMPLETE_URANIUM_SWORD = new ItemSword(ToolMaterials.COMPLETE_URANIUM);
	public static final ItemSpade COMPLETE_URANIUM_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_URANIUM);
	public static final ItemPickaxe COMPLETE_URANIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_URANIUM);
	public static final ItemAxe COMPLETE_URANIUM_AXE = new ItemAxeX(ToolMaterials.COMPLETE_URANIUM);
	public static final ItemHoe COMPLETE_URANIUM_HOE = new ItemHoe(ToolMaterials.COMPLETE_URANIUM);

	public static final Item URANIUM_HELMET = new UraniumHelmet(ArmorMaterials.ARMOR_MATERIAL_URANIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item URANIUM_CHESTPLATE = new UraniumBody(ArmorMaterials.ARMOR_MATERIAL_URANIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item URANIUM_LEGGINGS = new UraniumLegs(ArmorMaterials.ARMOR_MATERIAL_URANIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item URANIUM_BOOTS = new UraniumBoots(ArmorMaterials.ARMOR_MATERIAL_URANIUM, 1, EntityEquipmentSlot.FEET);

	//TOPAZ//
	public static final ItemSword TOPAZ_SWORD = new ItemSword(ToolMaterials.TOPAZ);
	public static final ItemSpade TOPAZ_SHOVEL = new ItemSpade(ToolMaterials.TOPAZ);
	public static final ItemPickaxe TOPAZ_PICKAXE = new ItemPickaxeX(ToolMaterials.TOPAZ);
	public static final ItemAxe TOPAZ_AXE = new ItemAxeX(ToolMaterials.TOPAZ);
	public static final ItemHoe TOPAZ_HOE = new ItemHoe(ToolMaterials.TOPAZ);

	public static final Item TOPAZ_HELMET = new TopazHelmet(ArmorMaterials.ARMOR_MATERIAL_TOPAZ, 1, EntityEquipmentSlot.HEAD);
	public static final Item TOPAZ_CHESTPLATE = new TopazBody(ArmorMaterials.ARMOR_MATERIAL_TOPAZ, 1, EntityEquipmentSlot.CHEST);
	public static final Item TOPAZ_LEGGINGS = new TopazLegs(ArmorMaterials.ARMOR_MATERIAL_TOPAZ, 2, EntityEquipmentSlot.LEGS);
	public static final Item TOPAZ_BOOTS = new TopazBoots(ArmorMaterials.ARMOR_MATERIAL_TOPAZ, 1, EntityEquipmentSlot.FEET);

	//JADE//
	public static final ItemSword JADE_SWORD = new ItemSword(ToolMaterials.JADE);
	public static final ItemSpade JADE_SHOVEL = new ItemSpade(ToolMaterials.JADE);
	public static final ItemPickaxe JADE_PICKAXE = new ItemPickaxeX(ToolMaterials.JADE);
	public static final ItemAxe JADE_AXE = new ItemAxeX(ToolMaterials.JADE);
	public static final ItemHoe JADE_HOE = new ItemHoe(ToolMaterials.JADE);

	public static final Item JADE_HELMET = new JadeHelmet(ArmorMaterials.ARMOR_MATERIAL_JADE, 1, EntityEquipmentSlot.HEAD);
	public static final Item JADE_CHESTPLATE = new JadeBody(ArmorMaterials.ARMOR_MATERIAL_JADE, 1, EntityEquipmentSlot.CHEST);
	public static final Item JADE_LEGGINGS = new JadeLegs(ArmorMaterials.ARMOR_MATERIAL_JADE, 2, EntityEquipmentSlot.LEGS);
	public static final Item JADE_BOOTS = new JadeBoots(ArmorMaterials.ARMOR_MATERIAL_JADE, 1, EntityEquipmentSlot.FEET);

	//TUNGSTEN//
	public static final ItemSword TUNGSTEN_SWORD = new ItemSword(ToolMaterials.TUNGSTEN);
	public static final ItemSpade TUNGSTEN_SHOVEL = new ItemSpade(ToolMaterials.TUNGSTEN);
	public static final ItemPickaxe TUNGSTEN_PICKAXE = new ItemPickaxeX(ToolMaterials.TUNGSTEN);
	public static final ItemAxe TUNGSTEN_AXE = new ItemAxeX(ToolMaterials.TUNGSTEN);
	public static final ItemHoe TUNGSTEN_HOE = new ItemHoe(ToolMaterials.TUNGSTEN);
	public static final ItemSword COMPLETE_TUNGSTEN_SWORD = new ItemSword(ToolMaterials.COMPLETE_TUNGSTEN);
	public static final ItemSpade COMPLETE_TUNGSTEN_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_TUNGSTEN);
	public static final ItemPickaxe COMPLETE_TUNGSTEN_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_TUNGSTEN);
	public static final ItemAxe COMPLETE_TUNGSTEN_AXE = new ItemAxeX(ToolMaterials.COMPLETE_TUNGSTEN);
	public static final ItemHoe COMPLETE_TUNGSTEN_HOE = new ItemHoe(ToolMaterials.COMPLETE_TUNGSTEN);

	public static final Item TUNGSTEN_HELMET = new TungstenHelmet(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN, 1, EntityEquipmentSlot.HEAD);
	public static final Item TUNGSTEN_CHESTPLATE = new TungstenBody(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN, 1, EntityEquipmentSlot.CHEST);
	public static final Item TUNGSTEN_LEGGINGS = new TungstenLegs(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN, 2, EntityEquipmentSlot.LEGS);
	public static final Item TUNGSTEN_BOOTS = new TungstenBoots(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN, 1, EntityEquipmentSlot.FEET);

	//TITANIUM_URANIUM//
	public static final ItemSword TITANIUM_URANIUM_SWORD = new ItemSword(ToolMaterials.TITANIUM_URANIUM);
	public static final ItemSpade TITANIUM_URANIUM_SHOVEL = new ItemSpade(ToolMaterials.TITANIUM_URANIUM);
	public static final ItemPickaxe TITANIUM_URANIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.TITANIUM_URANIUM);
	public static final ItemAxe TITANIUM_URANIUM_AXE = new ItemAxeX(ToolMaterials.TITANIUM_URANIUM);
	public static final ItemHoe TITANIUM_URANIUM_HOE = new ItemHoe(ToolMaterials.TITANIUM_URANIUM);
	public static final ItemSword COMPLETE_TITANIUM_URANIUM_SWORD = new ItemSword(ToolMaterials.COMPLETE_TITANIUM_URANIUM);
	public static final ItemSpade COMPLETE_TITANIUM_URANIUM_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_TITANIUM_URANIUM);
	public static final ItemPickaxe COMPLETE_TITANIUM_URANIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_TITANIUM_URANIUM);
	public static final ItemAxe COMPLETE_TITANIUM_URANIUM_AXE = new ItemAxeX(ToolMaterials.COMPLETE_TITANIUM_URANIUM);
	public static final ItemHoe COMPLETE_TITANIUM_URANIUM_HOE = new ItemHoe(ToolMaterials.COMPLETE_TITANIUM_URANIUM);

	public static final Item TITANIUM_URANIUM_HELMET = new Titanium_UraniumHelmet(ArmorMaterials.ARMOR_MATERIAL_TITANIUM_URANIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item TITANIUM_URANIUM_CHESTPLATE = new Titanium_UraniumBody(ArmorMaterials.ARMOR_MATERIAL_TITANIUM_URANIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item TITANIUM_URANIUM_LEGGINGS = new Titanium_UraniumLegs(ArmorMaterials.ARMOR_MATERIAL_TITANIUM_URANIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item TITANIUM_URANIUM_BOOTS = new Titanium_UraniumBoots(ArmorMaterials.ARMOR_MATERIAL_TITANIUM_URANIUM, 1, EntityEquipmentSlot.FEET);

	//TUNGSTEN_URANIUM//
	public static final ItemSword TUNGSTEN_URANIUM_SWORD = new ItemSword(ToolMaterials.TUNGSTEN_URANIUM);
	public static final ItemSpade TUNGSTEN_URANIUM_SHOVEL = new ItemSpade(ToolMaterials.TUNGSTEN_URANIUM);
	public static final ItemPickaxe TUNGSTEN_URANIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.TUNGSTEN_URANIUM);
	public static final ItemAxe TUNGSTEN_URANIUM_AXE = new ItemAxeX(ToolMaterials.TUNGSTEN_URANIUM);
	public static final ItemHoe TUNGSTEN_URANIUM_HOE = new ItemHoe(ToolMaterials.TUNGSTEN_URANIUM);
	public static final ItemSword COMPLETE_TUNGSTEN_URANIUM_SWORD = new ItemSword(ToolMaterials.COMPLETE_TUNGSTEN_URANIUM);
	public static final ItemSpade COMPLETE_TUNGSTEN_URANIUM_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_TUNGSTEN_URANIUM);
	public static final ItemPickaxe COMPLETE_TUNGSTEN_URANIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_TUNGSTEN_URANIUM);
	public static final ItemAxe COMPLETE_TUNGSTEN_URANIUM_AXE = new ItemAxeX(ToolMaterials.COMPLETE_TUNGSTEN_URANIUM);
	public static final ItemHoe COMPLETE_TUNGSTEN_URANIUM_HOE = new ItemHoe(ToolMaterials.COMPLETE_TUNGSTEN_URANIUM);

	public static final Item TUNGSTEN_URANIUM_HELMET = new Tungsten_UraniumHelmet(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_URANIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item TUNGSTEN_URANIUM_CHESTPLATE = new Tungsten_UraniumBody(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_URANIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item TUNGSTEN_URANIUM_LEGGINGS = new Tungsten_UraniumLegs(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_URANIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item TUNGSTEN_URANIUM_BOOTS = new Tungsten_UraniumBoots(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_URANIUM, 1, EntityEquipmentSlot.FEET);

	//TUNGSTEN_TITANIUM//
	public static final ItemSword TUNGSTEN_TITANIUM_SWORD = new ItemSword(ToolMaterials.TUNGSTEN_TITANIUM);
	public static final ItemSpade TUNGSTEN_TITANIUM_SHOVEL = new ItemSpade(ToolMaterials.TUNGSTEN_TITANIUM);
	public static final ItemPickaxe TUNGSTEN_TITANIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.TUNGSTEN_TITANIUM);
	public static final ItemPickaxe COMPLETE_TUNGSTEN_TITANIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_TUNGSTEN_TITANIUM);
	public static final ItemAxe TUNGSTEN_TITANIUM_AXE = new ItemAxeX(ToolMaterials.TUNGSTEN_TITANIUM);
	public static final ItemHoe TUNGSTEN_TITANIUM_HOE = new ItemHoe(ToolMaterials.TUNGSTEN_TITANIUM);

	public static final Item TUNGSTEN_TITANIUM_HELMET = new Tungsten_TitaniumHelmet(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_TITANIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item TUNGSTEN_TITANIUM_CHESTPLATE = new Tungsten_TitaniumBody(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_TITANIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item TUNGSTEN_TITANIUM_LEGGINGS = new Tungsten_TitaniumLegs(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_TITANIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item TUNGSTEN_TITANIUM_BOOTS = new Tungsten_TitaniumBoots(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_TITANIUM, 1, EntityEquipmentSlot.FEET);

	//EMERALD//
	public static final ItemSword EMERALD_SWORD = new ItemSword(ToolMaterials.EMERALD);
	public static final ItemSpade EMERALD_SHOVEL = new ItemSpade(ToolMaterials.EMERALD);
	public static final ItemPickaxe EMERALD_PICKAXE = new ItemPickaxeX(ToolMaterials.EMERALD);
	public static final ItemAxe EMERALD_AXE = new ItemAxeX(ToolMaterials.EMERALD);
	public static final ItemHoe EMERALD_HOE = new ItemHoe(ToolMaterials.EMERALD);

	public static final Item EMERALD_HELMET = new EmeraldHelmet(ArmorMaterials.ARMOR_MATERIAL_EMERALD, 1, EntityEquipmentSlot.HEAD);
	public static final Item EMERALD_CHESTPLATE = new EmeraldBody(ArmorMaterials.ARMOR_MATERIAL_EMERALD, 1, EntityEquipmentSlot.CHEST);
	public static final Item EMERALD_LEGGINGS = new EmeraldLegs(ArmorMaterials.ARMOR_MATERIAL_EMERALD, 2, EntityEquipmentSlot.LEGS);
	public static final Item EMERALD_BOOTS = new EmeraldBoots(ArmorMaterials.ARMOR_MATERIAL_EMERALD, 1, EntityEquipmentSlot.FEET);

	//RUBY//
	public static final ItemSword RUBY_SWORD = new ItemSword(ToolMaterials.RUBY);
	public static final ItemSpade RUBY_SHOVEL = new ItemSpade(ToolMaterials.RUBY);
	public static final ItemPickaxe RUBY_PICKAXE = new ItemPickaxeX(ToolMaterials.RUBY);
	public static final ItemAxe RUBY_AXE = new ItemAxeX(ToolMaterials.RUBY);
	public static final ItemHoe RUBY_HOE = new ItemHoe(ToolMaterials.RUBY);

	public static final Item RUBY_HELMET = new RubyHelmet(ArmorMaterials.ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.HEAD);
	public static final Item RUBY_CHESTPLATE = new RubyBody(ArmorMaterials.ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.CHEST);
	public static final Item RUBY_LEGGINGS = new RubyLegs(ArmorMaterials.ARMOR_MATERIAL_RUBY, 2, EntityEquipmentSlot.LEGS);
	public static final Item RUBY_BOOTS = new RubyBoots(ArmorMaterials.ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.FEET);

	//SAPPHIRE//
	public static final ItemSword SAPPHIRE_SWORD = new ItemSword(ToolMaterials.SAPPHIRE);
	public static final ItemSpade SAPPHIRE_SHOVEL = new ItemSpade(ToolMaterials.SAPPHIRE);
	public static final ItemPickaxe SAPPHIRE_PICKAXE = new ItemPickaxeX(ToolMaterials.SAPPHIRE);
	public static final ItemAxe SAPPHIRE_AXE = new ItemAxeX(ToolMaterials.SAPPHIRE);
	public static final ItemHoe SAPPHIRE_HOE = new ItemHoe(ToolMaterials.SAPPHIRE);

	public static final Item SAPPHIRE_HELMET = new SapphirHelmet(ArmorMaterials.ARMOR_MATERIAL_SAPPHIRE, 1, EntityEquipmentSlot.HEAD);
	public static final Item SAPPHIRE_CHESTPLATE = new SapphirBody(ArmorMaterials.ARMOR_MATERIAL_SAPPHIRE, 1, EntityEquipmentSlot.CHEST);
	public static final Item SAPPHIRE_LEGGINGS = new SapphirLegs(ArmorMaterials.ARMOR_MATERIAL_SAPPHIRE, 2, EntityEquipmentSlot.LEGS);
	public static final Item SAPPHIRE_BOOTS = new SapphirBoots(ArmorMaterials.ARMOR_MATERIAL_SAPPHIRE, 1, EntityEquipmentSlot.FEET);

	//DIAMOND//
	public static final ItemSword DIAMOND_SWORD = new ItemSword(ToolMaterials.DIAMOND);
	public static final ItemSpade DIAMOND_SHOVEL = new ItemSpade(ToolMaterials.DIAMOND);
	public static final ItemPickaxe DIAMOND_PICKAXE = new ItemPickaxeX(ToolMaterials.DIAMOND);
	public static final ItemAxe DIAMOND_AXE = new ItemAxeX(ToolMaterials.DIAMOND);
	public static final ItemHoe DIAMOND_HOE = new ItemHoe(ToolMaterials.DIAMOND);

	public static final Item DIAMOND_HELMET = new DiamondHelmet(ArmorMaterials.ARMOR_MATERIAL_DIAMOND, 1, EntityEquipmentSlot.HEAD);
	public static final Item DIAMOND_CHESTPLATE = new DiamondBody(ArmorMaterials.ARMOR_MATERIAL_DIAMOND, 1, EntityEquipmentSlot.CHEST);
	public static final Item DIAMOND_LEGGINGS = new DiamondLegs(ArmorMaterials.ARMOR_MATERIAL_DIAMOND, 2, EntityEquipmentSlot.LEGS);
	public static final Item DIAMOND_BOOTS = new DiamondBoots(ArmorMaterials.ARMOR_MATERIAL_DIAMOND, 1, EntityEquipmentSlot.FEET);

	//OLIVINE//
	public static final ItemSword OLIVINE_SWORD = new ItemSword(ToolMaterials.OLIVINE);
	public static final ItemSpade OLIVINE_SHOVEL = new ItemSpade(ToolMaterials.OLIVINE);
	public static final ItemPickaxe OLIVINE_PICKAXE = new ItemPickaxeX(ToolMaterials.OLIVINE);
	public static final ItemAxe OLIVINE_AXE = new ItemAxeX(ToolMaterials.OLIVINE);
	public static final ItemHoe OLIVINE_HOE = new ItemHoe(ToolMaterials.OLIVINE);

	public static final Item OLIVINE_HELMET = new OlivineHelmet(ArmorMaterials.ARMOR_MATERIAL_OLIVINE, 1, EntityEquipmentSlot.HEAD);
	public static final Item OLIVINE_CHESTPLATE = new OlivineBody(ArmorMaterials.ARMOR_MATERIAL_OLIVINE, 1, EntityEquipmentSlot.CHEST);
	public static final Item OLIVINE_LEGGINGS = new OlivineLegs(ArmorMaterials.ARMOR_MATERIAL_OLIVINE, 2, EntityEquipmentSlot.LEGS);
	public static final Item OLIVINE_BOOTS = new OlivineBoots(ArmorMaterials.ARMOR_MATERIAL_OLIVINE, 1, EntityEquipmentSlot.FEET);

	//WADSLEYITE//
	public static final ItemSword WADSLEYITE_SWORD = new ItemSword(ToolMaterials.WADSLEYITE);
	public static final ItemSpade WADSLEYITE_SHOVEL = new ItemSpade(ToolMaterials.WADSLEYITE);
	public static final ItemPickaxe WADSLEYITE_PICKAXE = new ItemPickaxeX(ToolMaterials.WADSLEYITE);
	public static final ItemAxe WADSLEYITE_AXE = new ItemAxeX(ToolMaterials.WADSLEYITE);
	public static final ItemHoe WADSLEYITE_HOE = new ItemHoe(ToolMaterials.WADSLEYITE);

	public static final Item WADSLEYITE_HELMET = new WadsleyiteHelmet(ArmorMaterials.ARMOR_MATERIAL_WADSLEYITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item WADSLEYITE_CHESTPLATE = new WadsleyiteBody(ArmorMaterials.ARMOR_MATERIAL_WADSLEYITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item WADSLEYITE_LEGGINGS = new WadsleyiteLegs(ArmorMaterials.ARMOR_MATERIAL_WADSLEYITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item WADSLEYITE_BOOTS = new WadsleyiteBoots(ArmorMaterials.ARMOR_MATERIAL_WADSLEYITE, 1, EntityEquipmentSlot.FEET);

	//RINGWOODITE//
	public static final ItemSword RINGWOODITE_SWORD = new ItemSword(ToolMaterials.RINGWOODITE);
	public static final ItemSpade RINGWOODITE_SHOVEL = new ItemSpade(ToolMaterials.RINGWOODITE);
	public static final ItemPickaxe RINGWOODITE_PICKAXE = new ItemPickaxeX(ToolMaterials.RINGWOODITE);
	public static final ItemAxe RINGWOODITE_AXE = new ItemAxeX(ToolMaterials.RINGWOODITE);
	public static final ItemHoe RINGWOODITE_HOE = new ItemHoe(ToolMaterials.RINGWOODITE);

	public static final Item RINGWOODITE_HELMET = new RingwooditeHelmet(ArmorMaterials.ARMOR_MATERIAL_RINGWOODITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item RINGWOODITE_CHESTPLATE = new RingwooditeBody(ArmorMaterials.ARMOR_MATERIAL_RINGWOODITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item RINGWOODITE_LEGGINGS = new RingwooditeLegs(ArmorMaterials.ARMOR_MATERIAL_RINGWOODITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item RINGWOODITE_BOOTS = new RingwooditeBoots(ArmorMaterials.ARMOR_MATERIAL_RINGWOODITE, 1, EntityEquipmentSlot.FEET);

	//BRIGMANITE//
	public static final ItemSword BRIGMANITE_SWORD = new ItemSword(ToolMaterials.BRIGMANITE);
	public static final ItemSpade BRIGMANITE_SHOVEL = new ItemSpade(ToolMaterials.BRIGMANITE);
	public static final ItemPickaxe BRIGMANITE_PICKAXE = new ItemPickaxeX(ToolMaterials.BRIGMANITE);
	public static final ItemAxe BRIGMANITE_AXE = new ItemAxeX(ToolMaterials.BRIGMANITE);
	public static final ItemHoe BRIGMANITE_HOE = new ItemHoe(ToolMaterials.BRIGMANITE);

	public static final Item BRIGMANITE_HELMET = new SapphirHelmet(ArmorMaterials.ARMOR_MATERIAL_BRIGMANITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item BRIGMANITE_CHESTPLATE = new SapphirBody(ArmorMaterials.ARMOR_MATERIAL_BRIGMANITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item BRIGMANITE_LEGGINGS = new SapphirLegs(ArmorMaterials.ARMOR_MATERIAL_BRIGMANITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item BRIGMANITE_BOOTS = new SapphirBoots(ArmorMaterials.ARMOR_MATERIAL_BRIGMANITE, 1, EntityEquipmentSlot.FEET);

	//MAJORITE//
	public static final ItemSword MAJORITE_SWORD = new ItemSword(ToolMaterials.MAJORITE);
	public static final ItemSpade MAJORITE_SHOVEL = new ItemSpade(ToolMaterials.MAJORITE);
	public static final ItemPickaxe MAJORITE_PICKAXE = new ItemPickaxeX(ToolMaterials.MAJORITE);
	public static final ItemAxe MAJORITE_AXE = new ItemAxeX(ToolMaterials.MAJORITE);
	public static final ItemHoe MAJORITE_HOE = new ItemHoe(ToolMaterials.MAJORITE);

	public static final Item MAJORITE_HELMET = new SapphirHelmet(ArmorMaterials.ARMOR_MATERIAL_MAJORITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item MAJORITE_CHESTPLATE = new SapphirBody(ArmorMaterials.ARMOR_MATERIAL_MAJORITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item MAJORITE_LEGGINGS = new SapphirLegs(ArmorMaterials.ARMOR_MATERIAL_MAJORITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item MAJORITE_BOOTS = new SapphirBoots(ArmorMaterials.ARMOR_MATERIAL_MAJORITE, 1, EntityEquipmentSlot.FEET);

	//AMAZONITE//
	public static final ItemSword AMAZONITE_SWORD = new ItemSword(ToolMaterials.AMAZONITE);
	public static final ItemSpade AMAZONITE_SHOVEL = new ItemSpade(ToolMaterials.AMAZONITE);
	public static final ItemPickaxe AMAZONITE_PICKAXE = new ItemPickaxeX(ToolMaterials.AMAZONITE);
	public static final ItemAxe AMAZONITE_AXE = new ItemAxeX(ToolMaterials.AMAZONITE);
	public static final ItemHoe AMAZONITE_HOE = new ItemHoe(ToolMaterials.AMAZONITE);

	public static final Item AMAZONITE_HELMET = new AmazoniteHelmet(ArmorMaterials.ARMOR_MATERIAL_AMAZONITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item AMAZONITE_CHESTPLATE = new AmazoniteBody(ArmorMaterials.ARMOR_MATERIAL_AMAZONITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item AMAZONITE_LEGGINGS = new AmazoniteLegs(ArmorMaterials.ARMOR_MATERIAL_AMAZONITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item AMAZONITE_BOOTS = new AmazoniteBoots(ArmorMaterials.ARMOR_MATERIAL_AMAZONITE, 1, EntityEquipmentSlot.FEET);

	//ONYX//
	public static final ItemSword ONYX_SWORD = new ItemSword(ToolMaterials.ONYX);
	public static final ItemSpade ONYX_SHOVEL = new ItemSpade(ToolMaterials.ONYX);
	public static final ItemPickaxe ONYX_PICKAXE = new ItemPickaxeX(ToolMaterials.ONYX);
	public static final ItemAxe ONYX_AXE = new ItemAxeX(ToolMaterials.ONYX);
	public static final ItemHoe ONYX_HOE = new ItemHoe(ToolMaterials.ONYX);

	public static final Item ONYX_HELMET = new OnyxHelmet(ArmorMaterials.ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.HEAD);
	public static final Item ONYX_CHESTPLATE = new OnyxBody(ArmorMaterials.ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.CHEST);
	public static final Item ONYX_LEGGINGS = new OnyxLegs(ArmorMaterials.ARMOR_MATERIAL_ONYX, 2, EntityEquipmentSlot.LEGS);
	public static final Item ONYX_BOOTS = new OnyxBoots(ArmorMaterials.ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.FEET);


	//DEMON//CORE//

	//GEMS//
	public static final Item SULFUR_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item REDSTONE_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item LAPIS_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item EMERALD_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SAPPHIRE_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item RUBY_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TOPAZ_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item JADE_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item DIAMOND_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item OLIVINE_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item WADSLEYITE_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item RINGWOODITE_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BRIGMANITE_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item AMAZONITE_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item MAJORITE_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item ONYX_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SAPPHIRE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item EMERALD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item RUBY = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TOPAZ = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item JADE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item DIAMOND = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item OLIVINE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item WADSLEYITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item RINGWOODITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BRIGMANITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item AMAZONITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item MAJORITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item ONYX = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	//ROD//
	public static final Item ALUMINIUM_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item LEAD_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SILICON_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item COPPER_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item ZINC_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TIN_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item IRON_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item STEEL_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BRONZE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SILVER_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item GOLD_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item PLATINUM_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TITANIUM_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item URANIUM_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TITANIUM_URANIUM_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_URANIUM_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_TITANIUM_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TOPAZ_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item JADE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item EMERALD_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SAPPHIRE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item RUBY_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item DIAMOND_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item OLIVINE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item WADSLEYITE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item RINGWOODITE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BRIGMANITE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item AMAZONITE_ROD = new ShinyItem().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item MAJORITE_ROD = new ShinyItem().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item ONYX_ROD = new ShinyItem().setCreativeTab(CreativeTabs.MATERIALS);

	//Ingot//
	public static final Item ALUMINIUM_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item LEAD_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SILICON_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item COPPER_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item ZINC_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TIN_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item IRON_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item STEEL_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BRONZE_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SILVER_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item GOLD_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item PLATINUM_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TITANIUM_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item URANIUM_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TITANIUM_URANIUM_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_URANIUM_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_TITANIUM_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	public static final Item IRON_COAL = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SULFUR = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	public static final Item COAL_BIT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item ALUMINIUM_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item LEAD_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SILICON_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item COPPER_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item ZINC_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TIN_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item IRON_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item STEEL_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BRONZE_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SILVER_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item GOLD_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item PLATINUM_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TITANIUM_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item URANIUM_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TITANIUM_URANIUM_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_URANIUM_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_TITANIUM_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	public static final Item DEMON_STAR = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item DEMON_STAR_CHARGED = new ShinyItem().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item CORE_STAR = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item ENHANCING_GEM = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	public static final Item PLATINUM_APPLE = new ThreeEffectFoodItem(10, 3.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 6000, 4, false, false),
			new PotionEffect(MobEffects.REGENERATION, 400, 2, false, false),
			new PotionEffect(MobEffects.FIRE_RESISTANCE, 3600, 0, false, false));

	public static final Item ENCHANTED_PLATINUM_APPLE = new SixEffectFoodItem(10, 3.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 6000, 4, false, false),
			new PotionEffect(MobEffects.REGENERATION, 800, 2, false, false),
			new PotionEffect(MobEffects.STRENGTH, 3000, 1, false, false),
			new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 1, false, false),
			new PotionEffect(MobEffects.RESISTANCE, 6000, 1, false, false),
			new PotionEffect(MobEffects.GLOWING, 3000, 0, false, false));

	public static final Item TITANIUM_APPLE = new SixEffectFoodItem(15, 6.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 12000, 8, false, false),
			new PotionEffect(MobEffects.REGENERATION, 1200, 3, false, false),
			new PotionEffect(MobEffects.STRENGTH, 6000, 1, false, false),
			new PotionEffect(MobEffects.SPEED, 6000, 0, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 6000, 0, false, false),
			new PotionEffect(MobEffects.GLOWING, 3000, 0, false, false));


	public static final Item ENCHANTED_TITANIUM_APPLE = new EightEffectFoodItem(15, 6.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 12000, 8, false, false),
			new PotionEffect(MobEffects.REGENERATION, 1200, 3, false, false),
			new PotionEffect(MobEffects.STRENGTH, 6000, 2, false, false),
			new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 2, false, false),
			new PotionEffect(MobEffects.RESISTANCE, 6000, 2, false, false),
			new PotionEffect(MobEffects.SPEED, 6000, 1, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 6000, 1, false, false),
			new PotionEffect(MobEffects.GLOWING, 6000, 0, false, false));

	public static final Item TUNGSTEN_APPLE = new SixEffectFoodItem(20, 12.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 12000, 12, false, false),
			new PotionEffect(MobEffects.REGENERATION, 3000, 4, false, false),
			new PotionEffect(MobEffects.HEALTH_BOOST, 12000, 12, false, false),
			new PotionEffect(MobEffects.SPEED, 6000, 1, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 6000, 1, false, false),
			new PotionEffect(MobEffects.GLOWING, 6000, 0, false, false));


	public static final Item ENCHANTED_RUBY_APPLE = new EightEffectFoodItem(20, 12.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 12000, 12, false, false),
			new PotionEffect(MobEffects.REGENERATION, 3000, 4, false, false),
			new PotionEffect(MobEffects.STRENGTH, 6000, 3, false, false),
			new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000, 2, false, false),
			new PotionEffect(MobEffects.RESISTANCE, 6000, 2, false, false),
			new PotionEffect(MobEffects.SPEED, 6000, 2, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 6000, 2, false, false),
			new PotionEffect(MobEffects.GLOWING, 6000, 0, false, false));

	public static final Item DIAMOND_APPLE = new SixEffectFoodItem(20, 24.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 24000, 16, false, false),
			new PotionEffect(MobEffects.REGENERATION, 6000, 4, false, false),
			new PotionEffect(MobEffects.SPEED, 6000, 2, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 6000, 2, false, false),
			new PotionEffect(MobEffects.STRENGTH, 6000, 4, false, false),
			new PotionEffect(MobEffects.GLOWING, 6000, 0, false, false));

	public static final Item ENCHANTED_DIAMOND_APPLE = new EightEffectFoodItem(20, 24.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 24000, 16, false, false),
			new PotionEffect(MobEffects.REGENERATION, 12000, 4, false, false),
			new PotionEffect(MobEffects.STRENGTH, 12000, 5, false, false),
			new PotionEffect(MobEffects.FIRE_RESISTANCE, 12000, 2, false, false),
			new PotionEffect(MobEffects.RESISTANCE, 12000, 2, false, false),
			new PotionEffect(MobEffects.SPEED, 12000, 3, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 12000, 3, false, false),
			new PotionEffect(MobEffects.GLOWING, 12000, 0, false, false));

	//SHIELDS
	public static final Item ALUMINIUM_SHIELD = new ItemShield();
	public static final Item LEAD_SHIELD = new ItemShield();
	public static final Item SILICON_SHIELD = new ItemShield();
	public static final Item COPPER_SHIELD = new ItemShield();
	public static final Item ZINC_SHIELD = new ItemShield();
	public static final Item TIN_SHIELD = new ItemShield();
	public static final Item IRON_SHIELD = new IronShield();
	public static final Item STEEL_SHIELD = new SteelShield();
	public static final Item BRONZE_SHIELD = new ItemShield();
	public static final Item SILVER_SHIELD = new SilverShield();
	public static final Item GOLD_SHIELD = new GoldShield();
	public static final Item PLATINUM_SHIELD = new PlatinumShield();
	public static final Item TITANIUM_SHIELD = new ItemShield();
	public static final Item URANIUM_SHIELD = new ItemShield();
	public static final Item TUNGSTEN_SHIELD = new ItemShield();
	public static final Item TITANIUM_URANIUM_SHIELD = new ItemShield();
	public static final Item TUNGSTEN_URANIUM_SHIELD = new ItemShield();
	public static final Item TUNGSTEN_TITANIUM_SHIELD = new ItemShield();
	public static final Item TOPAZ_SHIELD = new ItemShield();
	public static final Item JADE_SHIELD = new ItemShield();
	public static final Item EMERALD_SHIELD = new EmeraldShield();
	public static final Item SAPPHIRE_SHIELD = new SapphireShield();
	public static final Item RUBY_SHIELD = new RubyShield();
	public static final Item DIAMOND_SHIELD = new DiamondShield();
	public static final Item OLIVINE_SHIELD = new ItemShield();
	public static final Item WADSLEYITE_SHIELD = new ItemShield();
	public static final Item RINGWOODITE_SHIELD = new ItemShield();
	public static final Item BRIGMANITE_SHIELD = new ItemShield();
	public static final Item AMAZONITE_SHIELD = new ItemShield();
	public static final Item MAJORITE_SHIELD = new MajoriteShield();
	public static final Item ONYX_SHIELD = new OnyxShield();

	public static List<Item> getItems() {
		if (ITEMS.isEmpty()) {
			Field[] fields = ModItems.class.getDeclaredFields();
			for (Field field : fields) {
				try {
					Object obj = field.get(null);
					if (obj instanceof Item) {
						Item item = (Item)obj;
						if (item.getRegistryName() == null) {
							String name = field.getName().toLowerCase(Locale.ROOT);
							item.setRegistryName(name);
							item.setTranslationKey(name);
						}
						ITEMS.add((Item)obj);
					}
				} catch (IllegalAccessException e) {
					e.printStackTrace();
				}
			}
		}
		return ITEMS;
	}
}
