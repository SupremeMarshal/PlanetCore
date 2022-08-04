package com.PlanetCore.init;

import com.PlanetCore.items.ItemAxeX;
import com.PlanetCore.items.ItemPickaxeX;
import com.PlanetCore.items.ItemSpadeX;
import com.PlanetCore.items.armor.ArmorBase;
import com.PlanetCore.items.arrows.*;
import com.PlanetCore.items.bows.*;
import com.PlanetCore.items.shields.Shield;
import com.PlanetCore.items.shields.ShieldMaterial;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class ModItems {


	private static final List<Item> ITEMS = new ArrayList<>();


	public static final Item HOT_BLAZE_POWDER = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item HOT_MAGMA_CREAM = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item VERY_HOT_MAGMA_CREAM = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	
	public static final Item CORE_FIREBALL = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item ONYX_FIREBALL = new Item().setCreativeTab(CreativeTabs.MATERIALS);

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
	public static final ItemSword COMPLETE_IRON_SWORD = new ItemSword(ToolMaterials.COMPLETE_IRON);
	public static final ItemSpade COMPLETE_IRON_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_IRON);
	public static final ItemPickaxe COMPLETE_IRON_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_IRON);
	public static final ItemAxe COMPLETE_IRON_AXE = new ItemAxeX(ToolMaterials.COMPLETE_IRON);
	public static final ItemHoe COMPLETE_IRON_HOE = new ItemHoe(ToolMaterials.COMPLETE_IRON);

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

	public static final Item SILVER_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SILVER, 1, EntityEquipmentSlot.HEAD);
	public static final Item SILVER_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SILVER, 1, EntityEquipmentSlot.CHEST);
	public static final Item SILVER_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SILVER, 2, EntityEquipmentSlot.LEGS);
	public static final Item SILVER_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SILVER, 1, EntityEquipmentSlot.FEET);

	//GOLD//
	public static final ItemSword COMPLETE_GOLD_SWORD = new ItemSword(ToolMaterials.COMPLETE_GOLD);
	public static final ItemSpade COMPLETE_GOLD_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_GOLD);
	public static final ItemPickaxe COMPLETE_GOLD_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_GOLD);
	public static final ItemAxe COMPLETE_GOLD_AXE = new ItemAxeX(ToolMaterials.COMPLETE_GOLD);
	public static final ItemHoe COMPLETE_GOLD_HOE = new ItemHoe(ToolMaterials.COMPLETE_GOLD);

	//DIAMOND//
	public static final ItemSword COMPLETE_DIAMOND_SWORD = new ItemSword(ToolMaterials.COMPLETE_DIAMOND);
	public static final ItemSpade COMPLETE_DIAMOND_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_DIAMOND);
	public static final ItemPickaxe COMPLETE_DIAMOND_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_DIAMOND);
	public static final ItemAxe COMPLETE_DIAMOND_AXE = new ItemAxeX(ToolMaterials.COMPLETE_DIAMOND);
	public static final ItemHoe COMPLETE_DIAMOND_HOE = new ItemHoe(ToolMaterials.COMPLETE_DIAMOND);

	//TITANIUM//
	public static final ItemSword TITANIUM_SWORD = new ItemSword(ToolMaterials.TITANIUM);
	public static final ItemSpade TITANIUM_SHOVEL = new ItemSpadeX(ToolMaterials.TITANIUM);
	public static final ItemPickaxe TITANIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.TITANIUM);
	public static final ItemAxe TITANIUM_AXE = new ItemAxeX(ToolMaterials.TITANIUM);
	public static final ItemHoe TITANIUM_HOE = new ItemHoe(ToolMaterials.TITANIUM);
	public static final ItemSword COMPLETE_TITANIUM_SWORD = new ItemSword(ToolMaterials.COMPLETE_TITANIUM);
	public static final ItemSpade COMPLETE_TITANIUM_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_TITANIUM);
	public static final ItemPickaxe COMPLETE_TITANIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_TITANIUM);
	public static final ItemAxe COMPLETE_TITANIUM_AXE = new ItemAxeX(ToolMaterials.COMPLETE_TITANIUM);
	public static final ItemHoe COMPLETE_TITANIUM_HOE = new ItemHoe(ToolMaterials.COMPLETE_TITANIUM);

	public static final Item TITANIUM_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TITANIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item TITANIUM_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TITANIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item TITANIUM_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TITANIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item TITANIUM_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TITANIUM, 1, EntityEquipmentSlot.FEET);

	//URANIUM//
	public static final ItemSword URANIUM_SWORD = new ItemSword(ToolMaterials.URANIUM);
	public static final ItemSpade URANIUM_SHOVEL = new ItemSpadeX(ToolMaterials.URANIUM);
	public static final ItemPickaxe URANIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.URANIUM);
	public static final ItemAxe URANIUM_AXE = new ItemAxeX(ToolMaterials.URANIUM);
	public static final ItemHoe URANIUM_HOE = new ItemHoe(ToolMaterials.URANIUM);
	public static final ItemSword COMPLETE_URANIUM_SWORD = new ItemSword(ToolMaterials.COMPLETE_URANIUM);
	public static final ItemSpade COMPLETE_URANIUM_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_URANIUM);
	public static final ItemPickaxe COMPLETE_URANIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_URANIUM);
	public static final ItemAxe COMPLETE_URANIUM_AXE = new ItemAxeX(ToolMaterials.COMPLETE_URANIUM);
	public static final ItemHoe COMPLETE_URANIUM_HOE = new ItemHoe(ToolMaterials.COMPLETE_URANIUM);

	public static final Item URANIUM_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_URANIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item URANIUM_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_URANIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item URANIUM_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_URANIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item URANIUM_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_URANIUM, 1, EntityEquipmentSlot.FEET);

	//TUNGSTEN//
	public static final ItemSword TUNGSTEN_SWORD = new ItemSword(ToolMaterials.TUNGSTEN);
	public static final ItemSpade TUNGSTEN_SHOVEL = new ItemSpadeX(ToolMaterials.TUNGSTEN);
	public static final ItemPickaxe TUNGSTEN_PICKAXE = new ItemPickaxeX(ToolMaterials.TUNGSTEN);
	public static final ItemAxe TUNGSTEN_AXE = new ItemAxeX(ToolMaterials.TUNGSTEN);
	public static final ItemHoe TUNGSTEN_HOE = new ItemHoe(ToolMaterials.TUNGSTEN);
	public static final ItemSword COMPLETE_TUNGSTEN_SWORD = new ItemSword(ToolMaterials.COMPLETE_TUNGSTEN);
	public static final ItemSpade COMPLETE_TUNGSTEN_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_TUNGSTEN);
	public static final ItemPickaxe COMPLETE_TUNGSTEN_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_TUNGSTEN);
	public static final ItemAxe COMPLETE_TUNGSTEN_AXE = new ItemAxeX(ToolMaterials.COMPLETE_TUNGSTEN);
	public static final ItemHoe COMPLETE_TUNGSTEN_HOE = new ItemHoe(ToolMaterials.COMPLETE_TUNGSTEN);

	public static final Item TUNGSTEN_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN, 1, EntityEquipmentSlot.HEAD);
	public static final Item TUNGSTEN_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN, 1, EntityEquipmentSlot.CHEST);
	public static final Item TUNGSTEN_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN, 2, EntityEquipmentSlot.LEGS);
	public static final Item TUNGSTEN_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN, 1, EntityEquipmentSlot.FEET);

	//TUNGSTEN_TITANIUM//
	public static final ItemSword TUNGSTEN_TITANIUM_SWORD = new ItemSword(ToolMaterials.TUNGSTEN_TITANIUM);
	public static final ItemSpade TUNGSTEN_TITANIUM_SHOVEL = new ItemSpadeX(ToolMaterials.TUNGSTEN_TITANIUM);
	public static final ItemPickaxe TUNGSTEN_TITANIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.TUNGSTEN_TITANIUM);
	public static final ItemPickaxe COMPLETE_TUNGSTEN_TITANIUM_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_TUNGSTEN_TITANIUM);
	public static final ItemAxe TUNGSTEN_TITANIUM_AXE = new ItemAxeX(ToolMaterials.TUNGSTEN_TITANIUM);
	public static final ItemHoe TUNGSTEN_TITANIUM_HOE = new ItemHoe(ToolMaterials.TUNGSTEN_TITANIUM);

	public static final Item TUNGSTEN_TITANIUM_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_TITANIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item TUNGSTEN_TITANIUM_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_TITANIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item TUNGSTEN_TITANIUM_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_TITANIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item TUNGSTEN_TITANIUM_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_TITANIUM, 1, EntityEquipmentSlot.FEET);

	//TOPAZ//
	public static final ItemSword TOPAZ_SWORD = new ItemSword(ToolMaterials.TOPAZ);
	public static final ItemSpade TOPAZ_SHOVEL = new ItemSpadeX(ToolMaterials.TOPAZ);
	public static final ItemPickaxe TOPAZ_PICKAXE = new ItemPickaxeX(ToolMaterials.TOPAZ);
	public static final ItemAxe TOPAZ_AXE = new ItemAxeX(ToolMaterials.TOPAZ);
	public static final ItemHoe TOPAZ_HOE = new ItemHoe(ToolMaterials.TOPAZ);

	public static final Item TOPAZ_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TOPAZ, 1, EntityEquipmentSlot.HEAD);
	public static final Item TOPAZ_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TOPAZ, 1, EntityEquipmentSlot.CHEST);
	public static final Item TOPAZ_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TOPAZ, 2, EntityEquipmentSlot.LEGS);
	public static final Item TOPAZ_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TOPAZ, 1, EntityEquipmentSlot.FEET);
	
	//JADE//
	public static final ItemSword JADE_SWORD = new ItemSword(ToolMaterials.JADE);
	public static final ItemSpade JADE_SHOVEL = new ItemSpadeX(ToolMaterials.JADE);
	public static final ItemPickaxe JADE_PICKAXE = new ItemPickaxeX(ToolMaterials.JADE);
	public static final ItemAxe JADE_AXE = new ItemAxeX(ToolMaterials.JADE);
	public static final ItemHoe JADE_HOE = new ItemHoe(ToolMaterials.JADE);

	public static final Item JADE_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_JADE, 1, EntityEquipmentSlot.HEAD);
	public static final Item JADE_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_JADE, 1, EntityEquipmentSlot.CHEST);
	public static final Item JADE_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_JADE, 2, EntityEquipmentSlot.LEGS);
	public static final Item JADE_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_JADE, 1, EntityEquipmentSlot.FEET);

	//RUBY//
	public static final ItemSword RUBY_SWORD = new ItemSword(ToolMaterials.RUBY);
	public static final ItemSpade RUBY_SHOVEL = new ItemSpadeX(ToolMaterials.RUBY);
	public static final ItemPickaxe RUBY_PICKAXE = new ItemPickaxeX(ToolMaterials.RUBY);
	public static final ItemAxe RUBY_AXE = new ItemAxeX(ToolMaterials.RUBY);
	public static final ItemHoe RUBY_HOE = new ItemHoe(ToolMaterials.RUBY);

	public static final Item RUBY_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.HEAD);
	public static final Item RUBY_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.CHEST);
	public static final Item RUBY_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_RUBY, 2, EntityEquipmentSlot.LEGS);
	public static final Item RUBY_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.FEET);

	//SAPPHIRE//
	public static final ItemSword SAPPHIRE_SWORD = new ItemSword(ToolMaterials.SAPPHIRE);
	public static final ItemSpade SAPPHIRE_SHOVEL = new ItemSpadeX(ToolMaterials.SAPPHIRE);
	public static final ItemPickaxe SAPPHIRE_PICKAXE = new ItemPickaxeX(ToolMaterials.SAPPHIRE);
	public static final ItemAxe SAPPHIRE_AXE = new ItemAxeX(ToolMaterials.SAPPHIRE);
	public static final ItemHoe SAPPHIRE_HOE = new ItemHoe(ToolMaterials.SAPPHIRE);

	public static final Item SAPPHIRE_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SAPPHIRE, 1, EntityEquipmentSlot.HEAD);
	public static final Item SAPPHIRE_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SAPPHIRE, 1, EntityEquipmentSlot.CHEST);
	public static final Item SAPPHIRE_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SAPPHIRE, 2, EntityEquipmentSlot.LEGS);
	public static final Item SAPPHIRE_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SAPPHIRE, 1, EntityEquipmentSlot.FEET);

	//OLIVINE//
	public static final ItemSword OLIVINE_SWORD = new ItemSword(ToolMaterials.OLIVINE);
	public static final ItemSpade OLIVINE_SHOVEL = new ItemSpadeX(ToolMaterials.OLIVINE);
	public static final ItemPickaxe OLIVINE_PICKAXE = new ItemPickaxeX(ToolMaterials.OLIVINE);
	public static final ItemAxe OLIVINE_AXE = new ItemAxeX(ToolMaterials.OLIVINE);
	public static final ItemHoe OLIVINE_HOE = new ItemHoe(ToolMaterials.OLIVINE);

	public static final Item OLIVINE_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_OLIVINE, 1, EntityEquipmentSlot.HEAD);
	public static final Item OLIVINE_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_OLIVINE, 1, EntityEquipmentSlot.CHEST);
	public static final Item OLIVINE_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_OLIVINE, 2, EntityEquipmentSlot.LEGS);
	public static final Item OLIVINE_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_OLIVINE, 1, EntityEquipmentSlot.FEET);

	//WADSLEYITE//
	public static final ItemSword WADSLEYITE_SWORD = new ItemSword(ToolMaterials.WADSLEYITE);
	public static final ItemSpade WADSLEYITE_SHOVEL = new ItemSpadeX(ToolMaterials.WADSLEYITE);
	public static final ItemPickaxe WADSLEYITE_PICKAXE = new ItemPickaxeX(ToolMaterials.WADSLEYITE);
	public static final ItemAxe WADSLEYITE_AXE = new ItemAxeX(ToolMaterials.WADSLEYITE);
	public static final ItemHoe WADSLEYITE_HOE = new ItemHoe(ToolMaterials.WADSLEYITE);

	public static final Item WADSLEYITE_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_WADSLEYITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item WADSLEYITE_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_WADSLEYITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item WADSLEYITE_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_WADSLEYITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item WADSLEYITE_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_WADSLEYITE, 1, EntityEquipmentSlot.FEET);

	//RINGWOODITE//
	public static final ItemSword RINGWOODITE_SWORD = new ItemSword(ToolMaterials.RINGWOODITE);
	public static final ItemSpade RINGWOODITE_SHOVEL = new ItemSpadeX(ToolMaterials.RINGWOODITE);
	public static final ItemPickaxe RINGWOODITE_PICKAXE = new ItemPickaxeX(ToolMaterials.RINGWOODITE);
	public static final ItemAxe RINGWOODITE_AXE = new ItemAxeX(ToolMaterials.RINGWOODITE);
	public static final ItemHoe RINGWOODITE_HOE = new ItemHoe(ToolMaterials.RINGWOODITE);

	public static final Item RINGWOODITE_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_RINGWOODITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item RINGWOODITE_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_RINGWOODITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item RINGWOODITE_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_RINGWOODITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item RINGWOODITE_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_RINGWOODITE, 1, EntityEquipmentSlot.FEET);

	//BRIGMANITE//
	public static final ItemSword BRIGMANITE_SWORD = new ItemSword(ToolMaterials.BRIGMANITE);
	public static final ItemSpade BRIGMANITE_SHOVEL = new ItemSpadeX(ToolMaterials.BRIGMANITE);
	public static final ItemPickaxe BRIGMANITE_PICKAXE = new ItemPickaxeX(ToolMaterials.BRIGMANITE);
	public static final ItemAxe BRIGMANITE_AXE = new ItemAxeX(ToolMaterials.BRIGMANITE);
	public static final ItemHoe BRIGMANITE_HOE = new ItemHoe(ToolMaterials.BRIGMANITE);

	public static final Item BRIGMANITE_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_BRIGMANITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item BRIGMANITE_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_BRIGMANITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item BRIGMANITE_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_BRIGMANITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item BRIGMANITE_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_BRIGMANITE, 1, EntityEquipmentSlot.FEET);

	//MAJORITE//
	public static final ItemSword MAJORITE_SWORD = new ItemSword(ToolMaterials.MAJORITE);
	public static final ItemSpade MAJORITE_SHOVEL = new ItemSpadeX(ToolMaterials.MAJORITE);
	public static final ItemPickaxe MAJORITE_PICKAXE = new ItemPickaxeX(ToolMaterials.MAJORITE);
	public static final ItemAxe MAJORITE_AXE = new ItemAxeX(ToolMaterials.MAJORITE);
	public static final ItemHoe MAJORITE_HOE = new ItemHoe(ToolMaterials.MAJORITE);

	public static final Item MAJORITE_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_MAJORITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item MAJORITE_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_MAJORITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item MAJORITE_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_MAJORITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item MAJORITE_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_MAJORITE, 1, EntityEquipmentSlot.FEET);

	//AMAZONITE//
	public static final ItemSword AMAZONITE_SWORD = new ItemSword(ToolMaterials.AMAZONITE);
	public static final ItemSpade AMAZONITE_SHOVEL = new ItemSpadeX(ToolMaterials.AMAZONITE);
	public static final ItemPickaxe AMAZONITE_PICKAXE = new ItemPickaxeX(ToolMaterials.AMAZONITE);
	public static final ItemAxe AMAZONITE_AXE = new ItemAxeX(ToolMaterials.AMAZONITE);
	public static final ItemHoe AMAZONITE_HOE = new ItemHoe(ToolMaterials.AMAZONITE);

	public static final Item AMAZONITE_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_AMAZONITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item AMAZONITE_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_AMAZONITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item AMAZONITE_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_AMAZONITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item AMAZONITE_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_AMAZONITE, 1, EntityEquipmentSlot.FEET);

	//ONYX//
	public static final ItemSword ONYX_SWORD = new ItemSword(ToolMaterials.ONYX);
	public static final ItemSpade ONYX_SHOVEL = new ItemSpadeX(ToolMaterials.ONYX);
	public static final ItemPickaxe ONYX_PICKAXE = new ItemPickaxeX(ToolMaterials.ONYX);
	public static final ItemAxe ONYX_AXE = new ItemAxeX(ToolMaterials.ONYX);
	public static final ItemHoe ONYX_HOE = new ItemHoe(ToolMaterials.ONYX);

	public static final Item ONYX_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.HEAD);
	public static final Item ONYX_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.CHEST);
	public static final Item ONYX_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX, 2, EntityEquipmentSlot.LEGS);
	public static final Item ONYX_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.FEET);

	//ONYX II//
	public static final ItemSword ONYX_II_SWORD = new ItemSword(ToolMaterials.ONYX_II);
	public static final ItemSpade ONYX_II_SHOVEL = new ItemSpadeX(ToolMaterials.ONYX_II);
	public static final ItemPickaxe ONYX_II_PICKAXE = new ItemPickaxeX(ToolMaterials.ONYX_II);
	public static final ItemAxe ONYX_II_AXE = new ItemAxeX(ToolMaterials.ONYX_II);
	public static final ItemHoe ONYX_II_HOE = new ItemHoe(ToolMaterials.ONYX_II);

	public static final Item ONYX_II_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_II, 1, EntityEquipmentSlot.HEAD);
	public static final Item ONYX_II_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_II, 1, EntityEquipmentSlot.CHEST);
	public static final Item ONYX_II_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_II, 2, EntityEquipmentSlot.LEGS);
	public static final Item ONYX_II_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_II, 1, EntityEquipmentSlot.FEET);

	//ONYX III//
	public static final ItemSword ONYX_III_SWORD = new ItemSword(ToolMaterials.ONYX_III);
	public static final ItemSpade ONYX_III_SHOVEL = new ItemSpadeX(ToolMaterials.ONYX_III);
	public static final ItemPickaxe ONYX_III_PICKAXE = new ItemPickaxeX(ToolMaterials.ONYX_III);
	public static final ItemAxe ONYX_III_AXE = new ItemAxeX(ToolMaterials.ONYX_III);
	public static final ItemHoe ONYX_III_HOE = new ItemHoe(ToolMaterials.ONYX_III);

	public static final Item ONYX_III_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_III, 1, EntityEquipmentSlot.HEAD);
	public static final Item ONYX_III_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_III, 1, EntityEquipmentSlot.CHEST);
	public static final Item ONYX_III_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_III, 2, EntityEquipmentSlot.LEGS);
	public static final Item ONYX_III_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_III, 1, EntityEquipmentSlot.FEET);

	//ONYX IV//
	public static final ItemSword ONYX_IV_SWORD = new ItemSword(ToolMaterials.ONYX_IV);
	public static final ItemSpade ONYX_IV_SHOVEL = new ItemSpadeX(ToolMaterials.ONYX_IV);
	public static final ItemPickaxe ONYX_IV_PICKAXE = new ItemPickaxeX(ToolMaterials.ONYX_IV);
	public static final ItemAxe ONYX_IV_AXE = new ItemAxeX(ToolMaterials.ONYX_IV);
	public static final ItemHoe ONYX_IV_HOE = new ItemHoe(ToolMaterials.ONYX_IV);

	public static final Item ONYX_IV_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_IV, 1, EntityEquipmentSlot.HEAD);
	public static final Item ONYX_IV_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_IV, 1, EntityEquipmentSlot.CHEST);
	public static final Item ONYX_IV_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_IV, 2, EntityEquipmentSlot.LEGS);
	public static final Item ONYX_IV_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_IV, 1, EntityEquipmentSlot.FEET);

	//ONYX V//
	public static final ItemSword ONYX_V_SWORD = new ItemSword(ToolMaterials.ONYX_V);
	public static final ItemSpade ONYX_V_SHOVEL = new ItemSpadeX(ToolMaterials.ONYX_V);
	public static final ItemPickaxe ONYX_V_PICKAXE = new ItemPickaxeX(ToolMaterials.ONYX_V);
	public static final ItemAxe ONYX_V_AXE = new ItemAxeX(ToolMaterials.ONYX_V);
	public static final ItemHoe ONYX_V_HOE = new ItemHoe(ToolMaterials.ONYX_V);

	public static final Item ONYX_V_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_V, 1, EntityEquipmentSlot.HEAD);
	public static final Item ONYX_V_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_V, 1, EntityEquipmentSlot.CHEST);
	public static final Item ONYX_V_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_V, 2, EntityEquipmentSlot.LEGS);
	public static final Item ONYX_V_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_V, 1, EntityEquipmentSlot.FEET);


	//DEMON//CORE//

	//GEMS//
	public static final Item ONYX_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item PAINITE_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	public static final Item TOPAZ = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item JADE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item RUBY = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SAPPHIRE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item OLIVINE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item WADSLEYITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item RINGWOODITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BRIGMANITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item MAJORITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item AMAZONITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item ONYX = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item PAINITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	public static final Item BLADED_DIAMOND = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BLADED_TOPAZ = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BLADED_JADE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BLADED_RUBY = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BLADED_SAPPHIRE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BLADED_OLIVINE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BLADED_WADSLEYITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BLADED_RINGWOODITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BLADED_BRIGMANITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BLADED_MAJORITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BLADED_AMAZONITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BLADED_ONYX = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	//ROD//
	public static final Item ALUMINIUM_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item COPPER_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TIN_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item IRON_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item STEEL_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BRONZE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SILVER_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item GOLD_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TITANIUM_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item URANIUM_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_TITANIUM_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TOPAZ_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item JADE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SAPPHIRE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item RUBY_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item DIAMOND_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item OLIVINE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item WADSLEYITE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item RINGWOODITE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BRIGMANITE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item MAJORITE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item AMAZONITE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item ONYX_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	//Ingot//
	public static final Item ALUMINIUM_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item COPPER_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TIN_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item STEEL_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BRONZE_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SILVER_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TITANIUM_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BORON_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item LITHIUM_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item MAGNESIUM_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item THORIUM_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item URANIUM_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_TITANIUM_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	//Ingot//
	public static final Item ALUMINIUM_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item COPPER_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TIN_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item IRON_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SILVER_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item GOLD_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TITANIUM_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item URANIUM_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BORON_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item LITHIUM_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item MAGNESIUM_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item THORIUM_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	//metal shard//
	public static final Item SULFUR = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	public static final Item ALUMINIUM_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item COPPER_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TIN_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item STEEL_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BRONZE_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SILVER_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item GOLD_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TITANIUM_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item URANIUM_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_TITANIUM_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	//Bows
	public static final Item DIAMOND_BOW = new DiamondBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item TOPAZ_BOW = new TopazBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item JADE_BOW = new JadeBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item RUBY_BOW = new RubyBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item SAPPHIRE_BOW = new SapphireBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item OLIVINE_BOW = new OlivineBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item WADSLEYITE_BOW = new WadsleyiteBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item RINGWOODITE_BOW = new RingwooditeBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item BRIGMANITE_BOW = new BrigmaniteBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item MAJORITE_BOW = new MajoriteBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item AMAZONITE_BOW = new AmazoniteBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item ONYX_BOW = new OnyxBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item ONYX_BOW_II = new OnyxBowII().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item ONYX_BOW_III = new OnyxBowIII().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item ONYX_BOW_IV = new OnyxBowIV().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item ONYX_BOW_V = new OnyxBowV().setCreativeTab(CreativeTabs.COMBAT);


	//Arrows
	public static final Item DIAMOND_ARROW = new DiamondArrow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item TOPAZ_ARROW = new TopazArrow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item JADE_ARROW = new JadeArrow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item RUBY_ARROW = new RubyArrow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item SAPPHIRE_ARROW = new SapphireArrow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item OLIVINE_ARROW = new OlivineArrow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item WADSLEYITE_ARROW = new WadsleyiteArrow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item RINGWOODITE_ARROW = new RingwooditeArrow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item BRIGMANITE_ARROW = new BrigmaniteArrow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item MAJORITE_ARROW = new MajoriteArrow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item AMAZONITE_ARROW = new AmazoniteArrow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item ONYX_ARROW = new OnyxArrow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item ONYX_ARROW_II = new OnyxArrowII().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item ONYX_ARROW_III = new OnyxArrowIII().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item ONYX_ARROW_IV = new OnyxArrowIV().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item ONYX_ARROW_V = new OnyxArrowV().setCreativeTab(CreativeTabs.COMBAT);

	public static final Item DEMON_STAR = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item CORE_STAR = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item ONYX_STAR = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	/*
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

	 */

	//SHIELDS
	public static final Item ALUMINIUM_SHIELD = new Shield(ShieldMaterial.ALUMINIUM);
	public static final Item COPPER_SHIELD = new Shield(ShieldMaterial.COPPER);
	public static final Item TIN_SHIELD = new Shield(ShieldMaterial.TIN);
	public static final Item IRON_SHIELD = new Shield(ShieldMaterial.IRON);
	public static final Item STEEL_SHIELD = new Shield(ShieldMaterial.STEEL);
	public static final Item BRONZE_SHIELD = new Shield(ShieldMaterial.BRONZE);
	public static final Item SILVER_SHIELD = new Shield(ShieldMaterial.SILVER);
	public static final Item GOLD_SHIELD = new Shield(ShieldMaterial.GOLD);
	public static final Item TITANIUM_SHIELD = new Shield(ShieldMaterial.TITANIUM);
	public static final Item URANIUM_SHIELD = new Shield(ShieldMaterial.URANIUM);
	public static final Item TUNGSTEN_SHIELD = new Shield(ShieldMaterial.TUNGSTEN);
	public static final Item TUNGSTEN_TITANIUM_SHIELD = new Shield(ShieldMaterial.TUNGSTEN_TITANIUM);
	public static final Item TOPAZ_SHIELD = new Shield(ShieldMaterial.TOPAZ);
	public static final Item JADE_SHIELD = new Shield(ShieldMaterial.JADE);
	public static final Item SAPPHIRE_SHIELD = new Shield(ShieldMaterial.SAPPHIRE);
	public static final Item RUBY_SHIELD = new Shield(ShieldMaterial.RUBY);
	public static final Item DIAMOND_SHIELD = new Shield(ShieldMaterial.DIAMOND);
	public static final Item OLIVINE_SHIELD = new Shield(ShieldMaterial.OLIVINE);
	public static final Item WADSLEYITE_SHIELD = new Shield(ShieldMaterial.WADSLEYITE);
	public static final Item RINGWOODITE_SHIELD = new Shield(ShieldMaterial.RINGWOODITE);
	public static final Item BRIGMANITE_SHIELD = new Shield(ShieldMaterial.BRIGMANITE);
	public static final Item MAJORITE_SHIELD = new Shield(ShieldMaterial.MAJORITE);
	public static final Item AMAZONITE_SHIELD = new Shield(ShieldMaterial.AMAZONITE);
	public static final Item ONYX_SHIELD = new Shield(ShieldMaterial.ONYX);
	public static final Item ONYX_II_SHIELD = new Shield(ShieldMaterial.ONYXII);
	public static final Item ONYX_III_SHIELD = new Shield(ShieldMaterial.ONYXIII);
	public static final Item ONYX_IV_SHIELD = new Shield(ShieldMaterial.ONYXIV);
	public static final Item ONYX_V_SHIELD = new Shield(ShieldMaterial.ONYXV);

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
