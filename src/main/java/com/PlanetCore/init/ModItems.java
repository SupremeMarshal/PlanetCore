package com.PlanetCore.init;

import com.PlanetCore.items.ItemAxeX;
import com.PlanetCore.items.ItemPickaxeX;
import com.PlanetCore.items.ItemSpadeX;
import com.PlanetCore.items.Drills.IronDrill;
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


	public static final IronDrill IRON_DRILL = (IronDrill) new IronDrill().setCreativeTab(CreativeTabs.TOOLS);

	public static final Item HOT_BLAZE_POWDER = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item HOT_MAGMA_CREAM = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item VERYHOT_MAGMA_CREAM = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	
	public static final Item CORE_FIREBALL = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item ONYX_FIREBALL = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	//IRON//
	public static final ItemSword COMPLETE_IRON_SWORD = new ItemSword(ToolMaterials.COMPLETE_IRON);
	public static final ItemSpade COMPLETE_IRON_SHOVEL = new ItemSpade(ToolMaterials.COMPLETE_IRON);
	public static final ItemPickaxe COMPLETE_IRON_PICKAXE = new ItemPickaxeX(ToolMaterials.COMPLETE_IRON);
	public static final ItemAxe COMPLETE_IRON_AXE = new ItemAxeX(ToolMaterials.COMPLETE_IRON);
	public static final ItemHoe COMPLETE_IRON_HOE = new ItemHoe(ToolMaterials.COMPLETE_IRON);

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

	public static final Item SILVER_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SILVER, 1, EntityEquipmentSlot.HEAD,0, 0);
	public static final Item SILVER_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SILVER, 1, EntityEquipmentSlot.CHEST,0, 0);
	public static final Item SILVER_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SILVER, 2, EntityEquipmentSlot.LEGS,0, 0);
	public static final Item SILVER_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SILVER, 1, EntityEquipmentSlot.FEET,0, 0);

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

	public static final Item TITANIUM_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TITANIUM, 1, EntityEquipmentSlot.HEAD,0, 1);
	public static final Item TITANIUM_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TITANIUM, 1, EntityEquipmentSlot.CHEST,0, 4);
	public static final Item TITANIUM_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TITANIUM, 2, EntityEquipmentSlot.LEGS,0, 3);
	public static final Item TITANIUM_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TITANIUM, 1, EntityEquipmentSlot.FEET,0, 1);

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

	public static final Item URANIUM_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_URANIUM, 1, EntityEquipmentSlot.HEAD,0, 2);
	public static final Item URANIUM_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_URANIUM, 1, EntityEquipmentSlot.CHEST,0, 5);
	public static final Item URANIUM_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_URANIUM, 2, EntityEquipmentSlot.LEGS,0, 4);
	public static final Item URANIUM_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_URANIUM, 1, EntityEquipmentSlot.FEET,0, 2);

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

	public static final Item TUNGSTEN_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN, 1, EntityEquipmentSlot.HEAD,0, 5);
	public static final Item TUNGSTEN_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN, 1, EntityEquipmentSlot.CHEST,0 ,8);
	public static final Item TUNGSTEN_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN, 2, EntityEquipmentSlot.LEGS,0 ,7);
	public static final Item TUNGSTEN_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN, 1, EntityEquipmentSlot.FEET,0 , 4);

	//RUBY//
	public static final ItemSword RUBY_SWORD = new ItemSword(ToolMaterials.RUBY);
	public static final ItemSpade RUBY_SHOVEL = new ItemSpadeX(ToolMaterials.RUBY);
	public static final ItemPickaxe RUBY_PICKAXE = new ItemPickaxeX(ToolMaterials.RUBY);
	public static final ItemAxe RUBY_AXE = new ItemAxeX(ToolMaterials.RUBY);
	public static final ItemHoe RUBY_HOE = new ItemHoe(ToolMaterials.RUBY);

	public static final Item RUBY_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.HEAD,.5f ,7);
	public static final Item RUBY_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.CHEST,.5f, 10);
	public static final Item RUBY_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_RUBY, 2, EntityEquipmentSlot.LEGS,.5f, 9);
	public static final Item RUBY_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.FEET,.5f, 5);

	//SAPPHIRE//
	public static final ItemSword SAPPHIRE_SWORD = new ItemSword(ToolMaterials.SAPPHIRE);
	public static final ItemSpade SAPPHIRE_SHOVEL = new ItemSpadeX(ToolMaterials.SAPPHIRE);
	public static final ItemPickaxe SAPPHIRE_PICKAXE = new ItemPickaxeX(ToolMaterials.SAPPHIRE);
	public static final ItemAxe SAPPHIRE_AXE = new ItemAxeX(ToolMaterials.SAPPHIRE);
	public static final ItemHoe SAPPHIRE_HOE = new ItemHoe(ToolMaterials.SAPPHIRE);

	public static final Item SAPPHIRE_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SAPPHIRE, 1, EntityEquipmentSlot.HEAD,1, 9);
	public static final Item SAPPHIRE_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SAPPHIRE, 1, EntityEquipmentSlot.CHEST,1, 14);
	public static final Item SAPPHIRE_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SAPPHIRE, 2, EntityEquipmentSlot.LEGS,1, 12);
	public static final Item SAPPHIRE_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_SAPPHIRE, 1, EntityEquipmentSlot.FEET,1, 7);

	//MAJORITE//
	public static final ItemSword MAJORITE_SWORD = new ItemSword(ToolMaterials.MAJORITE);
	public static final ItemSpade MAJORITE_SHOVEL = new ItemSpadeX(ToolMaterials.MAJORITE);
	public static final ItemPickaxe MAJORITE_PICKAXE = new ItemPickaxeX(ToolMaterials.MAJORITE);
	public static final ItemAxe MAJORITE_AXE = new ItemAxeX(ToolMaterials.MAJORITE);
	public static final ItemHoe MAJORITE_HOE = new ItemHoe(ToolMaterials.MAJORITE);

	public static final Item MAJORITE_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_MAJORITE, 1, EntityEquipmentSlot.HEAD,1.5f, 12);
	public static final Item MAJORITE_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_MAJORITE, 1, EntityEquipmentSlot.CHEST,1.5f, 19);
	public static final Item MAJORITE_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_MAJORITE, 2, EntityEquipmentSlot.LEGS,1.5f, 16);
	public static final Item MAJORITE_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_MAJORITE, 1, EntityEquipmentSlot.FEET,1.5f, 10);

	//AMAZONITE//
	public static final ItemSword AMAZONITE_SWORD = new ItemSword(ToolMaterials.AMAZONITE);
	public static final ItemSpade AMAZONITE_SHOVEL = new ItemSpadeX(ToolMaterials.AMAZONITE);
	public static final ItemPickaxe AMAZONITE_PICKAXE = new ItemPickaxeX(ToolMaterials.AMAZONITE);
	public static final ItemAxe AMAZONITE_AXE = new ItemAxeX(ToolMaterials.AMAZONITE);
	public static final ItemHoe AMAZONITE_HOE = new ItemHoe(ToolMaterials.AMAZONITE);

	public static final Item AMAZONITE_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_AMAZONITE, 1, EntityEquipmentSlot.HEAD,2, 16);
	public static final Item AMAZONITE_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_AMAZONITE, 1, EntityEquipmentSlot.CHEST,2, 26);
	public static final Item AMAZONITE_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_AMAZONITE, 2, EntityEquipmentSlot.LEGS,2, 21);
	public static final Item AMAZONITE_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_AMAZONITE, 1, EntityEquipmentSlot.FEET,2, 14);

	//ONYX//
	public static final ItemSword ONYX_SWORD = new ItemSword(ToolMaterials.ONYX);
	public static final ItemSpade ONYX_SHOVEL = new ItemSpadeX(ToolMaterials.ONYX);
	public static final ItemPickaxe ONYX_PICKAXE = new ItemPickaxeX(ToolMaterials.ONYX);
	public static final ItemAxe ONYX_AXE = new ItemAxeX(ToolMaterials.ONYX);
	public static final ItemHoe ONYX_HOE = new ItemHoe(ToolMaterials.ONYX);

	public static final Item ONYX_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.HEAD,2.5f, 21);
	public static final Item ONYX_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.CHEST,2.5f, 35);
	public static final Item ONYX_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX, 2, EntityEquipmentSlot.LEGS,2.5f, 28);
	public static final Item ONYX_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.FEET,2.5f, 19);

	//ONYX II//
	public static final ItemSword ONYX_II_SWORD = new ItemSword(ToolMaterials.ONYX_II);
	public static final ItemSpade ONYX_II_SHOVEL = new ItemSpadeX(ToolMaterials.ONYX_II);
	public static final ItemPickaxe ONYX_II_PICKAXE = new ItemPickaxeX(ToolMaterials.ONYX_II);
	public static final ItemAxe ONYX_II_AXE = new ItemAxeX(ToolMaterials.ONYX_II);
	public static final ItemHoe ONYX_II_HOE = new ItemHoe(ToolMaterials.ONYX_II);

	public static final Item ONYX_II_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_II, 1, EntityEquipmentSlot.HEAD,3, 28);
	public static final Item ONYX_II_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_II, 1, EntityEquipmentSlot.CHEST,3, 47);
	public static final Item ONYX_II_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_II, 2, EntityEquipmentSlot.LEGS,3, 37);
	public static final Item ONYX_II_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_II, 1, EntityEquipmentSlot.FEET,3, 26);

	//ONYX III//
	public static final ItemSword ONYX_III_SWORD = new ItemSword(ToolMaterials.ONYX_III);
	public static final ItemSpade ONYX_III_SHOVEL = new ItemSpadeX(ToolMaterials.ONYX_III);
	public static final ItemPickaxe ONYX_III_PICKAXE = new ItemPickaxeX(ToolMaterials.ONYX_III);
	public static final ItemAxe ONYX_III_AXE = new ItemAxeX(ToolMaterials.ONYX_III);
	public static final ItemHoe ONYX_III_HOE = new ItemHoe(ToolMaterials.ONYX_III);

	public static final Item ONYX_III_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_III, 1, EntityEquipmentSlot.HEAD,3.5f, 37);
	public static final Item ONYX_III_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_III, 1, EntityEquipmentSlot.CHEST,3.5f, 62);
	public static final Item ONYX_III_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_III, 2, EntityEquipmentSlot.LEGS,3.5f, 49);
	public static final Item ONYX_III_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_III, 1, EntityEquipmentSlot.FEET,3.5f, 34);

	//ONYX IV//
	public static final ItemSword ONYX_IV_SWORD = new ItemSword(ToolMaterials.ONYX_IV);
	public static final ItemSpade ONYX_IV_SHOVEL = new ItemSpadeX(ToolMaterials.ONYX_IV);
	public static final ItemPickaxe ONYX_IV_PICKAXE = new ItemPickaxeX(ToolMaterials.ONYX_IV);
	public static final ItemAxe ONYX_IV_AXE = new ItemAxeX(ToolMaterials.ONYX_IV);
	public static final ItemHoe ONYX_IV_HOE = new ItemHoe(ToolMaterials.ONYX_IV);

	public static final Item ONYX_IV_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_IV, 1, EntityEquipmentSlot.HEAD,4, 49);
	public static final Item ONYX_IV_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_IV, 1, EntityEquipmentSlot.CHEST,4, 83);
	public static final Item ONYX_IV_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_IV, 2, EntityEquipmentSlot.LEGS,4, 66);
	public static final Item ONYX_IV_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_IV, 1, EntityEquipmentSlot.FEET,4, 45);

	//ONYX V//
	public static final ItemSword ONYX_V_SWORD = new ItemSword(ToolMaterials.ONYX_V);
	public static final ItemSpade ONYX_V_SHOVEL = new ItemSpadeX(ToolMaterials.ONYX_V);
	public static final ItemPickaxe ONYX_V_PICKAXE = new ItemPickaxeX(ToolMaterials.ONYX_V);
	public static final ItemAxe ONYX_V_AXE = new ItemAxeX(ToolMaterials.ONYX_V);
	public static final ItemHoe ONYX_V_HOE = new ItemHoe(ToolMaterials.ONYX_V);

	public static final Item ONYX_V_HELMET = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_V, 1, EntityEquipmentSlot.HEAD,5, 66);
	public static final Item ONYX_V_CHESTPLATE = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_V, 1, EntityEquipmentSlot.CHEST,5, 110);
	public static final Item ONYX_V_LEGGINGS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_V, 2, EntityEquipmentSlot.LEGS,5, 88);
	public static final Item ONYX_V_BOOTS = new ArmorBase(ArmorMaterials.ARMOR_MATERIAL_ONYX_V, 1, EntityEquipmentSlot.FEET,5, 62);

	//GEMS//
	public static final Item ONYX_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item PAINITE_SHARD = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	public static final Item RUBY = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SAPPHIRE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item MAJORITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item AMAZONITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item ONYX = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item PAINITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	public static final Item BLADED_DIAMOND = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BLADED_RUBY = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BLADED_SAPPHIRE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BLADED_MAJORITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BLADED_AMAZONITE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item BLADED_ONYX = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	//ROD//
	public static final Item IRON_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SILVER_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item GOLD_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TITANIUM_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item URANIUM_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SAPPHIRE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item RUBY_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item DIAMOND_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item MAJORITE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item AMAZONITE_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item ONYX_ROD = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	//Ingot//
	public static final Item SILVER_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TITANIUM_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item URANIUM_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_INGOT = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	//Ingot//
	public static final Item IRON_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item SILVER_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item GOLD_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TITANIUM_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item URANIUM_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_ORE = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	//metal shard//
	public static final Item SULFUR = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	public static final Item SILVER_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TITANIUM_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item URANIUM_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);
	public static final Item TUNGSTEN_NUGGET = new Item().setCreativeTab(CreativeTabs.MATERIALS);

	//Bows
	public static final Item DIAMOND_BOW = new DiamondBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item RUBY_BOW = new RubyBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item SAPPHIRE_BOW = new SapphireBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item MAJORITE_BOW = new MajoriteBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item AMAZONITE_BOW = new AmazoniteBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item ONYX_BOW = new OnyxBow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item ONYX_BOW_II = new OnyxBowII().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item ONYX_BOW_III = new OnyxBowIII().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item ONYX_BOW_IV = new OnyxBowIV().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item ONYX_BOW_V = new OnyxBowV().setCreativeTab(CreativeTabs.COMBAT);


	//Arrows
	public static final Item DIAMOND_ARROW = new DiamondArrow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item RUBY_ARROW = new RubyArrow().setCreativeTab(CreativeTabs.COMBAT);
	public static final Item SAPPHIRE_ARROW = new SapphireArrow().setCreativeTab(CreativeTabs.COMBAT);
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
	public static final Item IRON_SHIELD = new Shield(ShieldMaterial.IRON, 3, 0.05f);
	public static final Item SILVER_SHIELD = new Shield(ShieldMaterial.SILVER, 4, 0.05f);
	public static final Item GOLD_SHIELD = new Shield(ShieldMaterial.GOLD, 5, 0.05f);
	public static final Item DIAMOND_SHIELD = new Shield(ShieldMaterial.DIAMOND, 6, 0.1f);
	public static final Item TITANIUM_SHIELD = new Shield(ShieldMaterial.TITANIUM, 8, 0.12f);
	public static final Item URANIUM_SHIELD = new Shield(ShieldMaterial.URANIUM, 11, 0.14f);
	public static final Item TUNGSTEN_SHIELD = new Shield(ShieldMaterial.TUNGSTEN, 15, 0.16f);
	public static final Item RUBY_SHIELD = new Shield(ShieldMaterial.RUBY, 20, 0.18f);
	public static final Item SAPPHIRE_SHIELD = new Shield(ShieldMaterial.SAPPHIRE, 27, 0.20f);
	public static final Item MAJORITE_SHIELD = new Shield(ShieldMaterial.MAJORITE, 36, 0.22f);
	public static final Item AMAZONITE_SHIELD = new Shield(ShieldMaterial.AMAZONITE, 47, 0.25f);
	public static final Item ONYX_SHIELD = new Shield(ShieldMaterial.ONYX, 63, 0.30f);
	public static final Item ONYX_II_SHIELD = new Shield(ShieldMaterial.ONYXII, 84, 0.35f);
	public static final Item ONYX_III_SHIELD = new Shield(ShieldMaterial.ONYXIII, 112, 0.40f);
	public static final Item ONYX_IV_SHIELD = new Shield(ShieldMaterial.ONYXIV, 150, 0.45f);
	public static final Item ONYX_V_SHIELD = new Shield(ShieldMaterial.ONYXV, 200, 0.50f);

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
