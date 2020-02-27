package com.SupremeMarshal.ToTheEarthCore.init;

import com.SupremeMarshal.ToTheEarthCore.items.Gems;
import com.SupremeMarshal.ToTheEarthCore.items.ItemBase;
import com.SupremeMarshal.ToTheEarthCore.items.armor.*;
import com.SupremeMarshal.ToTheEarthCore.items.food.EnchantedFoodEffectBase;
import com.SupremeMarshal.ToTheEarthCore.items.food.EnchantedFoodEffectBase1;
import com.SupremeMarshal.ToTheEarthCore.items.food.FoodEffectBase;
import com.SupremeMarshal.ToTheEarthCore.items.shields.*;
import com.SupremeMarshal.ToTheEarthCore.items.tools.*;
import com.SupremeMarshal.ToTheEarthCore.util.Reference;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.common.util.EnumHelper;

import java.util.ArrayList;
import java.util.List;

public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	//TOOLS MATERIAL	(NAME, HARVEST LVL, MAX USE, EFFICIENCY, DAMAGE, ENCHANTABILITY)
	public static final ToolMaterial MATERIAL_BRONZE = EnumHelper.addToolMaterial("material_bronze", 3, 200, 6.0F, 2.0F, 20);
	public static final ToolMaterial MATERIAL_IRON = EnumHelper.addToolMaterial("material_iron", 4, 300, 8.0F, 3.0F, 20);
	public static final ToolMaterial MATERIAL_STEEL = EnumHelper.addToolMaterial("material_steel", 5, 400, 10.0F, 4.0F, 18);
	public static final ToolMaterial MATERIAL_SILVER = EnumHelper.addToolMaterial("material_silver", 6, 400, 12.0F, 5.0F, 16);
	public static final ToolMaterial MATERIAL_GOLD = EnumHelper.addToolMaterial("material_gold", 7, 400, 16.0F, 6.0F, 14);
	public static final ToolMaterial MATERIAL_PLATINUM = EnumHelper.addToolMaterial("material_platinum", 8, 600, 20.0F, 7.0F, 12);
	public static final ToolMaterial MATERIAL_JADE = EnumHelper.addToolMaterial("material_jade", 9, 200, 18.0F, 4.0F, 5);
	public static final ToolMaterial MATERIAL_TOPAZ = EnumHelper.addToolMaterial("material_topaz", 10, 100, 4.0F, 4.0F, 6);
	public static final ToolMaterial MATERIAL_ES = EnumHelper.addToolMaterial("material_es", 9, 1000, 30.0F, 9.0F, 6);
	public static final ToolMaterial MATERIAL_EMERALD = EnumHelper.addToolMaterial("material_emerald", 10, 100, 20.0F, 7.0F, 10);
	public static final ToolMaterial MATERIAL_EMERALD1 = EnumHelper.addToolMaterial("material_emerald1", 10, 200, 22.0F, 7.5F, 10);
	public static final ToolMaterial MATERIAL_EMERALD2 = EnumHelper.addToolMaterial("material_emerald2", 10, 300, 24.0F, 8.0F, 10);
	public static final ToolMaterial MATERIAL_EMERALD3 = EnumHelper.addToolMaterial("material_emerald3", 10, 400, 26.0F, 8.5F, 10);
	public static final ToolMaterial MATERIAL_EMERALD4 = EnumHelper.addToolMaterial("material_emerald4", 10, 500, 28.0F, 9.0F, 10);
	public static final ToolMaterial MATERIAL_EMERALD5 = EnumHelper.addToolMaterial("material_emerald5", 10, 600, 30.0F, 9.5F, 10);
	public static final ToolMaterial MATERIAL_EMERALD6 = EnumHelper.addToolMaterial("material_emerald6", 10, 700, 32.0F, 10.0F, 10);
	public static final ToolMaterial MATERIAL_EMERALD7 = EnumHelper.addToolMaterial("material_emerald7", 10, 800, 34.0F, 10.5F, 10);
	public static final ToolMaterial MATERIAL_EMERALD8 = EnumHelper.addToolMaterial("material_emerald8", 10, 900, 36.0F, 11.0F, 10);
	public static final ToolMaterial MATERIAL_EMERALD9 = EnumHelper.addToolMaterial("material_emerald9", 10, 1000, 38.0F, 11.5F, 10);
	public static final ToolMaterial MATERIAL_EMERALD10 = EnumHelper.addToolMaterial("material_emerald10", 10, 1100, 40.0F, 12.0F, 10);
	public static final ToolMaterial MATERIAL_EMERALD11 = EnumHelper.addToolMaterial("material_emerald11", 10, 1200, 42.0F, 12.5F, 10);
	public static final ToolMaterial MATERIAL_EMERALD12 = EnumHelper.addToolMaterial("material_emerald12", 10, 1300, 44.0F, 13.0F, 10);
	public static final ToolMaterial MATERIAL_EMERALD13 = EnumHelper.addToolMaterial("material_emerald13", 10, 1400, 46.0F, 13.5F, 10);
	public static final ToolMaterial MATERIAL_EMERALD14 = EnumHelper.addToolMaterial("material_emerald14", 10, 1500, 48.0F, 14.0F, 10);
	public static final ToolMaterial MATERIAL_EMERALD15 = EnumHelper.addToolMaterial("material_emerald15", 10, 1600, 50.0F, 14.5F, 10);
	public static final ToolMaterial MATERIAL_SAPHIR = EnumHelper.addToolMaterial("material_saphir", 11, 100, 30.0F, 12.0F, 10);
	public static final ToolMaterial MATERIAL_SAPHIR1 = EnumHelper.addToolMaterial("material_saphir1", 11, 200, 34.0F, 13.0F, 10);
	public static final ToolMaterial MATERIAL_SAPHIR2 = EnumHelper.addToolMaterial("material_saphir2", 11, 300, 38.0F, 14.0F, 10);
	public static final ToolMaterial MATERIAL_SAPHIR3 = EnumHelper.addToolMaterial("material_saphir3", 11, 400, 42.0F, 15.0F, 10);
	public static final ToolMaterial MATERIAL_SAPHIR4 = EnumHelper.addToolMaterial("material_saphir4", 11, 500, 46.0F, 16.0F, 10);
	public static final ToolMaterial MATERIAL_SAPHIR5 = EnumHelper.addToolMaterial("material_saphir5", 11, 600, 50.0F, 17.0F, 10);
	public static final ToolMaterial MATERIAL_SAPHIR6 = EnumHelper.addToolMaterial("material_saphir6", 11, 700, 54.0F, 18.0F, 10);
	public static final ToolMaterial MATERIAL_SAPHIR7 = EnumHelper.addToolMaterial("material_saphir7", 11, 800, 58.0F, 19.0F, 10);
	public static final ToolMaterial MATERIAL_SAPHIR8 = EnumHelper.addToolMaterial("material_saphir8", 11, 900, 62.0F, 20.0F, 10);
	public static final ToolMaterial MATERIAL_SAPHIR9 = EnumHelper.addToolMaterial("material_saphir9", 11, 1000, 66.0F, 21.0F, 10);
	public static final ToolMaterial MATERIAL_SAPHIR10 = EnumHelper.addToolMaterial("material_saphir10", 11, 1100, 70.0F, 22.0F, 10);
	public static final ToolMaterial MATERIAL_SAPHIR11 = EnumHelper.addToolMaterial("material_saphir11", 11, 1200, 74.0F, 23.0F, 10);
	public static final ToolMaterial MATERIAL_SAPHIR12 = EnumHelper.addToolMaterial("material_saphir12", 11, 1300, 78.0F, 24.0F, 10);
	public static final ToolMaterial MATERIAL_SAPHIR13 = EnumHelper.addToolMaterial("material_saphir13", 11, 1400, 82.0F, 25.0F, 10);
	public static final ToolMaterial MATERIAL_SAPHIR14 = EnumHelper.addToolMaterial("material_saphir14", 11, 1500, 86.0F, 26.0F, 10);
	public static final ToolMaterial MATERIAL_SAPHIR15 = EnumHelper.addToolMaterial("material_saphir15", 11, 1600, 90.0F, 27.0F, 10);
	public static final ToolMaterial MATERIAL_RUBY = EnumHelper.addToolMaterial("material_ruby", 12, 100, 60.0F, 30.0F, 8);
	public static final ToolMaterial MATERIAL_AMETHYST = EnumHelper.addToolMaterial("material_amethyst", 12, 100, 300.0F, 50.0F, 4);
	public static final ToolMaterial MATERIAL_DIAMOND = EnumHelper.addToolMaterial("material_diamond", 13, 100, 100.0F, 50.0F, 6);
	public static final ToolMaterial MATERIAL_AMAZONITE = EnumHelper.addToolMaterial("material_amazonite", 14, 100, 200.0F, 100.0F, 5);
	public static final ToolMaterial MATERIAL_DEMON = EnumHelper.addToolMaterial("material_demon", 10, 1000, 25.0F, 15F, 5);
	public static final ToolMaterial MATERIAL_CORE = EnumHelper.addToolMaterial("material_core", 12, 0, 1000.0F, 500F, 5);
	public static final ToolMaterial MATERIAL_ONYX = EnumHelper.addToolMaterial("material_onyx", 15, 100, 300.0F, 150.0F, 4);
	public static final ToolMaterial MATERIAL_AZURITE = EnumHelper.addToolMaterial("material_azurite", 15, 100, 1000.0F, 100.0F, 4);
	
	
	//ARMOR MATERIAL (name, textureName, durability, reductionAmounts, enchantability, soundOnEquip, toughness)
	public static final ArmorMaterial ARMOR_MATERIAL_BRONZE= EnumHelper.addArmorMaterial("armor_material_bronze", Reference.MOD_ID + ":bronze", 8,
			new int[] {2, 4, 4, 2}, 10, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_IRON = EnumHelper.addArmorMaterial("armor_material_iron", Reference.MOD_ID + ":iron", 15,
			new int[] {2, 5, 4, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	
	public static final ArmorMaterial ARMOR_MATERIAL_STEEL = EnumHelper.addArmorMaterial("armor_material_steel", Reference.MOD_ID + ":steel", 30,
			new int[] {2, 5, 4, 2}, 18, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
	
	public static final ArmorMaterial ARMOR_MATERIAL_SILVER = EnumHelper.addArmorMaterial("armor_material_silver", Reference.MOD_ID + ":silver", 12,
			new int[] {2, 6, 5, 2}, 30, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.5F);
	
	public static final ArmorMaterial ARMOR_MATERIAL_GOLD = EnumHelper.addArmorMaterial("armor_material_gold", Reference.MOD_ID + ":gold", 45,
			new int[] {2, 6, 5, 2}, 14, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.5F);
	
	public static final ArmorMaterial ARMOR_MATERIAL_PLATINUM = EnumHelper.addArmorMaterial("armor_material_platinum", Reference.MOD_ID + ":platinum", 56,
			new int[] {3, 7, 6, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_EMERALD = EnumHelper.addArmorMaterial("armor_material_emerald", Reference.MOD_ID + ":emerald", 10,
			new int[] {3, 8, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_EMERALD1 = EnumHelper.addArmorMaterial("armor_material_emerald1", Reference.MOD_ID + ":emerald1", 11,
			new int[] {3, 8, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 1.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_EMERALD2 = EnumHelper.addArmorMaterial("armor_material_emerald2", Reference.MOD_ID + ":emerald2", 12,
			new int[] {3, 8, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_EMERALD3 = EnumHelper.addArmorMaterial("armor_material_emerald3", Reference.MOD_ID + ":emerald3", 13,
			new int[] {3, 8, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_EMERALD4 = EnumHelper.addArmorMaterial("armor_material_emerald4", Reference.MOD_ID + ":emerald4", 14,
			new int[] {3, 8, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_EMERALD5 = EnumHelper.addArmorMaterial("armor_material_emerald5", Reference.MOD_ID + ":emerald5", 15,
			new int[] {3, 8, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_EMERALD6 = EnumHelper.addArmorMaterial("armor_material_emerald6", Reference.MOD_ID + ":emerald6", 16,
			new int[] {3, 8, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_EMERALD7 = EnumHelper.addArmorMaterial("armor_material_emerald7", Reference.MOD_ID + ":emerald7", 17,
			new int[] {3, 8, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_EMERALD8 = EnumHelper.addArmorMaterial("armor_material_emerald8", Reference.MOD_ID + ":emerald8", 18,
			new int[] {3, 8, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_EMERALD9 = EnumHelper.addArmorMaterial("armor_material_emerald9", Reference.MOD_ID + ":emerald9", 19,
			new int[] {3, 8, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_EMERALD10 = EnumHelper.addArmorMaterial("armor_material_emerald10", Reference.MOD_ID + ":emerald10", 20,
			new int[] {3, 8, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_EMERALD11 = EnumHelper.addArmorMaterial("armor_material_emerald11", Reference.MOD_ID + ":emerald11", 21,
			new int[] {3, 8, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_EMERALD12 = EnumHelper.addArmorMaterial("armor_material_emerald12", Reference.MOD_ID + ":emerald12", 22,
			new int[] {3, 8, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 7.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_EMERALD13 = EnumHelper.addArmorMaterial("armor_material_emerald13", Reference.MOD_ID + ":emerald13", 23,
			new int[] {3, 8, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 7.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_EMERALD14 = EnumHelper.addArmorMaterial("armor_material_emerald14", Reference.MOD_ID + ":emerald14", 24,
			new int[] {3, 8, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 8.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_EMERALD15 = EnumHelper.addArmorMaterial("armor_material_emerald15", Reference.MOD_ID + ":emerald15", 25,
			new int[] {3, 8, 6, 3}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 8.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_SAPHIR = EnumHelper.addArmorMaterial("armor_material_saphir", Reference.MOD_ID + ":saphir", 93,
			new int[] {3, 8, 6, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	
	public static final ArmorMaterial ARMOR_MATERIAL_RUBY = EnumHelper.addArmorMaterial("armor_material_ruby", Reference.MOD_ID + ":ruby", 125,
			new int[] {4, 9, 7, 4}, 8, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 3.0F);
	
	public static final ArmorMaterial ARMOR_MATERIAL_DIAMOND = EnumHelper.addArmorMaterial("armor_material_diamond", Reference.MOD_ID + ":diamond", 187,
			new int[] {5, 10, 8, 5}, 6, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F);
	
	public static final ArmorMaterial ARMOR_MATERIAL_AMAZONITE = EnumHelper.addArmorMaterial("armor_material_amazonite", Reference.MOD_ID + ":amazonite", 250,
			new int[] {6, 12, 9, 6}, 5, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_ONYX = EnumHelper.addArmorMaterial("armor_material_onyx", Reference.MOD_ID + ":onyx", 312,
			new int[] {7, 14, 10, 7}, 4, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 8.0F);
	
	
	
//TOOLS

	//BRONZE//
	public static final ItemSword BRONZE_SWORD = new ToolSword("bronze_sword", MATERIAL_BRONZE);
	public static final ItemSpade BRONZE_SHOVEL = new ToolSpade("bronze_shovel", MATERIAL_BRONZE);
	public static final ItemPickaxe BRONZE_PICKAXE = new ToolPickaxe("bronze_pickaxe", MATERIAL_BRONZE);
	public static final ItemAxe BRONZE_AXE = new ToolAxe("bronze_axe", MATERIAL_BRONZE);
	public static final ItemHoe BRONZE_HOE = new ToolHoe("bronze_hoe", MATERIAL_BRONZE);

	public static final Item BRONZE_HELMET = new ArmorBase("bronze_helmet", ARMOR_MATERIAL_BRONZE, 1, EntityEquipmentSlot.HEAD);
	public static final Item BRONZE_CHESTPLATE = new ArmorBase("bronze_chestplate", ARMOR_MATERIAL_BRONZE, 1, EntityEquipmentSlot.CHEST);
	public static final Item BRONZE_LEGGINGS = new ArmorBase("bronze_leggings", ARMOR_MATERIAL_BRONZE, 2, EntityEquipmentSlot.LEGS);
	public static final Item BRONZE_BOOTS = new ArmorBase("bronze_boots", ARMOR_MATERIAL_BRONZE, 1, EntityEquipmentSlot.FEET);

	//IRON//
	public static final ItemSword IRON_SWORD = new ToolSword("iron_sword", MATERIAL_IRON);
	public static final ItemSpade IRON_SHOVEL = new ToolSpade("iron_shovel", MATERIAL_IRON);
	public static final ItemPickaxe IRON_PICKAXE = new ToolPickaxe("iron_pickaxe", MATERIAL_IRON);
	public static final ItemAxe IRON_AXE = new ToolAxe("iron_axe", MATERIAL_IRON);
	public static final ItemHoe IRON_HOE = new ToolHoe("iron_hoe", MATERIAL_IRON);
	
	public static final Item IRON_HELMET = new ArmorBase("iron_helmet", ARMOR_MATERIAL_IRON, 1, EntityEquipmentSlot.HEAD);
	public static final Item IRON_CHESTPLATE = new ArmorBase("iron_chestplate", ARMOR_MATERIAL_IRON, 1, EntityEquipmentSlot.CHEST);
	public static final Item IRON_LEGGINGS = new ArmorBase("iron_leggings", ARMOR_MATERIAL_IRON, 2, EntityEquipmentSlot.LEGS);
	public static final Item IRON_BOOTS = new ArmorBase("iron_boots", ARMOR_MATERIAL_IRON, 1, EntityEquipmentSlot.FEET);
	
	//STEEL//

	
	public static final ItemSword STEEL_SWORD = new ToolSword("steel_sword", MATERIAL_STEEL);
	public static final ItemSpade STEEL_SHOVEL = new ToolSpade("steel_shovel", MATERIAL_STEEL);
	public static final ItemPickaxe STEEL_PICKAXE = new ToolPickaxe("steel_pickaxe", MATERIAL_STEEL);
	public static final ItemAxe STEEL_AXE = new ToolAxe("steel_axe", MATERIAL_STEEL);
	public static final ItemHoe STEEL_HOE = new ToolHoe("steel_hoe", MATERIAL_STEEL);
	
	public static final Item STEEL_HELMET = new ArmorBase("steel_helmet", ARMOR_MATERIAL_STEEL, 1, EntityEquipmentSlot.HEAD);
	public static final Item STEEL_CHESTPLATE = new ArmorBase("steel_chestplate", ARMOR_MATERIAL_STEEL, 1, EntityEquipmentSlot.CHEST);
	public static final Item STEEL_LEGGINGS = new ArmorBase("steel_leggings", ARMOR_MATERIAL_STEEL, 2, EntityEquipmentSlot.LEGS);
	public static final Item STEEL_BOOTS = new ArmorBase("steel_boots", ARMOR_MATERIAL_STEEL, 1, EntityEquipmentSlot.FEET);
	
	//SILVER//

	
	public static final ItemSword SILVER_SWORD = new ToolSword("silver_sword", MATERIAL_SILVER);
	public static final ItemSpade SILVER_SHOVEL = new ToolSpade("silver_shovel", MATERIAL_SILVER);
	public static final ItemPickaxe SILVER_PICKAXE = new ToolPickaxe("silver_pickaxe", MATERIAL_SILVER);
	public static final ItemAxe SILVER_AXE = new ToolAxe("silver_axe", MATERIAL_SILVER);
	public static final ItemHoe SILVER_HOE = new ToolHoe("silver_hoe", MATERIAL_SILVER);
	
	public static final Item SILVER_HELMET = new SilverHelmet("silver_helmet", ARMOR_MATERIAL_SILVER, 1, EntityEquipmentSlot.HEAD);
	public static final Item SILVER_CHESTPLATE = new SilverBody("silver_chestplate", ARMOR_MATERIAL_SILVER, 1, EntityEquipmentSlot.CHEST);
	public static final Item SILVER_LEGGINGS = new SilverLegs("silver_leggings", ARMOR_MATERIAL_SILVER, 2, EntityEquipmentSlot.LEGS);
	public static final Item SILVER_BOOTS = new SilverBoots("silver_boots", ARMOR_MATERIAL_SILVER, 1, EntityEquipmentSlot.FEET);
	
	//GOLD//

	
	public static final ItemSword GOLD_SWORD = new ToolSword("gold_sword", MATERIAL_GOLD);
	public static final ItemSpade GOLD_SHOVEL = new ToolSpade("gold_shovel", MATERIAL_GOLD);
	public static final ItemPickaxe GOLD_PICKAXE = new ToolPickaxe("gold_pickaxe", MATERIAL_GOLD);
	public static final ItemAxe GOLD_AXE = new ToolAxe("gold_axe", MATERIAL_GOLD);
	public static final ItemHoe GOLD_HOE = new ToolHoe("gold_hoe", MATERIAL_GOLD);
	
	public static final Item GOLD_HELMET = new GoldHelmet("gold_helmet", ARMOR_MATERIAL_GOLD, 1, EntityEquipmentSlot.HEAD);
	public static final Item GOLD_CHESTPLATE = new GoldBody("gold_chestplate", ARMOR_MATERIAL_GOLD, 1, EntityEquipmentSlot.CHEST);
	public static final Item GOLD_LEGGINGS = new GoldLegs("gold_leggings", ARMOR_MATERIAL_GOLD, 2, EntityEquipmentSlot.LEGS);
	public static final Item GOLD_BOOTS = new GoldBoots("gold_boots", ARMOR_MATERIAL_GOLD, 1, EntityEquipmentSlot.FEET);
	
	//PLATINUM//

	
	public static final ItemSword PLATINUM_SWORD = new ToolSword("platinum_sword", MATERIAL_PLATINUM);
	public static final ItemSpade PLATINUM_SHOVEL = new ToolSpade("platinum_shovel", MATERIAL_PLATINUM);
	public static final ItemPickaxe PLATINUM_PICKAXE = new ToolPickaxe("platinum_pickaxe", MATERIAL_PLATINUM);
	public static final ItemAxe PLATINUM_AXE = new ToolAxe("platinum_axe", MATERIAL_PLATINUM);
	public static final ItemHoe PLATINUM_HOE = new ToolHoe("platinum_hoe", MATERIAL_PLATINUM);
	
	public static final Item PLATINUM_HELMET = new PlatinumHelmet("platinum_helmet", ARMOR_MATERIAL_PLATINUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item PLATINUM_CHESTPLATE = new PlatinumBody("platinum_chestplate", ARMOR_MATERIAL_PLATINUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item PLATINUM_LEGGINGS = new PlatinumLegs("platinum_leggings", ARMOR_MATERIAL_PLATINUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item PLATINUM_BOOTS = new PlatinumBoots("platinum_boots", ARMOR_MATERIAL_PLATINUM, 1, EntityEquipmentSlot.FEET);
	
	//EMERALD//

	
	public static final ItemSword EMERALD_SWORD = new ToolSword("emerald_sword", MATERIAL_EMERALD);
	public static final ItemSpade EMERALD_SHOVEL = new ToolSpade("emerald_shovel", MATERIAL_EMERALD);
	public static final ItemPickaxe EMERALD_PICKAXE = new ToolPickaxe("emerald_pickaxe", MATERIAL_EMERALD);
	public static final ItemAxe EMERALD_AXE = new ToolAxe("emerald_axe", MATERIAL_EMERALD);
	public static final ItemHoe EMERALD_HOE = new ToolHoe("emerald_hoe", MATERIAL_EMERALD);
	
	public static final Item EMERALD_HELMET = new EmeraldHelmet("emerald_helmet", ARMOR_MATERIAL_EMERALD, 1, EntityEquipmentSlot.HEAD);
	public static final Item EMERALD_CHESTPLATE = new EmeraldBody("emerald_chestplate", ARMOR_MATERIAL_EMERALD, 1, EntityEquipmentSlot.CHEST);
	public static final Item EMERALD_LEGGINGS = new EmeraldLegs("emerald_leggings", ARMOR_MATERIAL_EMERALD, 2, EntityEquipmentSlot.LEGS);
	public static final Item EMERALD_BOOTS = new EmeraldBoots("emerald_boots", ARMOR_MATERIAL_EMERALD, 1, EntityEquipmentSlot.FEET);

	//SAPHIR//


	public static final ItemSword SAPHIR_SWORD = new ToolSword("saphir_sword", MATERIAL_SAPHIR);
	public static final ItemSpade SAPHIR_SHOVEL = new ToolSpade("saphir_shovel", MATERIAL_SAPHIR);
	public static final ItemPickaxe SAPHIR_PICKAXE = new ToolPickaxe("saphir_pickaxe", MATERIAL_SAPHIR);
	public static final ItemAxe SAPHIR_AXE = new ToolAxe("saphir_axe", MATERIAL_SAPHIR);
	public static final ItemHoe SAPHIR_HOE = new ToolHoe("saphir_hoe", MATERIAL_SAPHIR);

	public static final Item SAPHIR_HELMET = new SapphirHelmet("saphir_helmet", ARMOR_MATERIAL_SAPHIR, 1, EntityEquipmentSlot.HEAD);
	public static final Item SAPHIR_CHESTPLATE = new SapphirBody("saphir_chestplate", ARMOR_MATERIAL_SAPHIR, 1, EntityEquipmentSlot.CHEST);
	public static final Item SAPHIR_LEGGINGS = new SapphirLegs("saphir_leggings", ARMOR_MATERIAL_SAPHIR, 2, EntityEquipmentSlot.LEGS);
	public static final Item SAPHIR_BOOTS = new SapphirBoots("saphir_boots", ARMOR_MATERIAL_SAPHIR, 1, EntityEquipmentSlot.FEET);
	
	//RUBY//

	
	public static final ItemSword RUBY_SWORD = new ToolSword("ruby_sword", MATERIAL_RUBY);
	public static final ItemSpade RUBY_SHOVEL = new ToolSpade("ruby_shovel", MATERIAL_RUBY);
	public static final ItemPickaxe RUBY_PICKAXE = new ToolPickaxe("ruby_pickaxe", MATERIAL_RUBY);
	public static final ItemAxe RUBY_AXE = new ToolAxe("ruby_axe", MATERIAL_RUBY);
	public static final ItemHoe RUBY_HOE = new ToolHoe("ruby_hoe", MATERIAL_RUBY);
	
	public static final Item RUBY_HELMET = new RubyHelmet("ruby_helmet", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.HEAD);
	public static final Item RUBY_CHESTPLATE = new RubyBody("ruby_chestplate", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.CHEST);
	public static final Item RUBY_LEGGINGS = new RubyLegs("ruby_leggings", ARMOR_MATERIAL_RUBY, 2, EntityEquipmentSlot.LEGS);
	public static final Item RUBY_BOOTS = new RubyBoots("ruby_boots", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.FEET);
	
	//TOPAZ//
	
	
	public static final ItemSword TOPAZ_SWORD = new ToolSword("topaz_sword", MATERIAL_TOPAZ);
	public static final ItemSpade TOPAZ_SHOVEL = new ToolSpade("topaz_shovel", MATERIAL_TOPAZ);
	public static final ItemPickaxe TOPAZ_PICKAXE = new ToolPickaxe("topaz_pickaxe", MATERIAL_TOPAZ);
	public static final ItemAxe TOPAZ_AXE = new ToolAxe("topaz_axe", MATERIAL_TOPAZ);
	public static final ItemHoe TOPAZ_HOE = new ToolHoe("topaz_hoe", MATERIAL_TOPAZ);
	
	//DIAMOND//

	
	public static final ItemSword DIAMOND_SWORD = new ToolSword("diamond_sword", MATERIAL_DIAMOND);
	public static final ItemSpade DIAMOND_SHOVEL = new ToolSpade("diamond_shovel", MATERIAL_DIAMOND);
	public static final ItemPickaxe DIAMOND_PICKAXE = new ToolPickaxe("diamond_pickaxe", MATERIAL_DIAMOND);
	public static final ItemAxe DIAMOND_AXE = new ToolAxe("diamond_axe", MATERIAL_DIAMOND);
	public static final ItemHoe DIAMOND_HOE = new ToolHoe("diamond_hoe", MATERIAL_DIAMOND);
	
	public static final Item DIAMOND_HELMET = new DiamondHelmet("diamond_helmet", ARMOR_MATERIAL_DIAMOND, 1, EntityEquipmentSlot.HEAD);
	public static final Item DIAMOND_CHESTPLATE = new DiamondBody("diamond_chestplate", ARMOR_MATERIAL_DIAMOND, 1, EntityEquipmentSlot.CHEST);
	public static final Item DIAMOND_LEGGINGS = new DiamondLegs("diamond_leggings", ARMOR_MATERIAL_DIAMOND, 2, EntityEquipmentSlot.LEGS);
	public static final Item DIAMOND_BOOTS = new DiamondBoots("diamond_boots", ARMOR_MATERIAL_DIAMOND, 1, EntityEquipmentSlot.FEET);
	
	//JADE//
	
	
	public static final ItemSword JADE_SWORD = new ToolSword("jade_sword", MATERIAL_JADE);
	public static final ItemSpade JADE_SHOVEL = new ToolSpade("jade_shovel", MATERIAL_JADE);
	public static final ItemPickaxe JADE_PICKAXE = new ToolPickaxe("jade_pickaxe", MATERIAL_JADE);
	public static final ItemAxe JADE_AXE = new ToolAxe("jade_axe", MATERIAL_JADE);
	public static final ItemHoe JADE_HOE = new ToolHoe("jade_hoe", MATERIAL_JADE);
	
	//AMAZONITE//

	
	public static final ItemSword AMAZONITE_SWORD = new ToolSword("amazonite_sword", MATERIAL_AMAZONITE);
	public static final ItemSpade AMAZONITE_SHOVEL = new ToolSpade("amazonite_shovel", MATERIAL_AMAZONITE);
	public static final ItemPickaxe AMAZONITE_PICKAXE = new ToolPickaxe("amazonite_pickaxe", MATERIAL_AMAZONITE);
	public static final ItemAxe AMAZONITE_AXE = new ToolAxe("amazonite_axe", MATERIAL_AMAZONITE);
	public static final ItemHoe AMAZONITE_HOE = new ToolHoe("amazonite_hoe", MATERIAL_AMAZONITE);
	
	public static final Item AMAZONITE_HELMET = new AmazoniteHelmet("amazonite_helmet", ARMOR_MATERIAL_AMAZONITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item AMAZONITE_CHESTPLATE = new AmazoniteBody("amazonite_chestplate", ARMOR_MATERIAL_AMAZONITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item AMAZONITE_LEGGINGS = new AmazoniteLegs("amazonite_leggings", ARMOR_MATERIAL_AMAZONITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item AMAZONITE_BOOTS = new AmazoniteBoots("amazonite_boots", ARMOR_MATERIAL_AMAZONITE, 1, EntityEquipmentSlot.FEET);


	//AMETHYST//
	
	
	public static final ItemSword AMETHYST_SWORD = new ToolSword("amethyst_sword", MATERIAL_AMETHYST);
	public static final ItemSpade AMETHYST_SHOVEL = new ToolSpade("amethyst_shovel", MATERIAL_AMETHYST);
	public static final ItemPickaxe AMETHYST_PICKAXE = new ToolPickaxe("amethyst_pickaxe", MATERIAL_AMETHYST);
	public static final ItemAxe AMETHYST_AXE = new ToolAxe("amethyst_axe", MATERIAL_AMETHYST);
	public static final ItemHoe AMETHYST_HOE = new ToolHoe("amethyst_hoe", MATERIAL_AMETHYST);

	
	//ONYX//

	public static final ItemSword ONYX_SWORD = new ToolSword("onyx_sword", MATERIAL_ONYX);
	public static final ItemSpade ONYX_SHOVEL = new ToolSpade("onyx_shovel", MATERIAL_ONYX);
	public static final ItemPickaxe ONYX_PICKAXE = new ToolPickaxe("onyx_pickaxe", MATERIAL_ONYX);
	public static final ItemAxe ONYX_AXE = new ToolAxe("onyx_axe", MATERIAL_ONYX);
 	public static final ItemHoe ONYX_HOE = new ToolHoe("onyx_hoe", MATERIAL_ONYX);

	public static final Item ONYX_HELMET = new OnyxHelmet("onyx_helmet", ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.HEAD);
	public static final Item ONYX_CHESTPLATE = new OnyxBody("onyx_chestplate", ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.CHEST);
	public static final Item ONYX_LEGGINGS = new OnyxLegs("onyx_leggings", ARMOR_MATERIAL_ONYX, 2, EntityEquipmentSlot.LEGS);
	public static final Item ONYX_BOOTS = new OnyxBoots("onyx_boots", ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.FEET);

	
	//AZURITE//
	
	public static final ItemSword AZURITE_SWORD = new ToolSword("azurite_sword", MATERIAL_AZURITE);
	public static final ItemSpade AZURITE_SHOVEL = new ToolSpade("azurite_shovel", MATERIAL_AZURITE);
	public static final ItemPickaxe AZURITE_PICKAXE = new ToolPickaxe("azurite_pickaxe", MATERIAL_AZURITE);
	public static final ItemAxe AZURITE_AXE = new ToolAxe("azurite_axe", MATERIAL_AZURITE);
 	public static final ItemHoe AZURITE_HOE = new ToolHoe("azurite_hoe", MATERIAL_AZURITE);
	
	
	//DEMON//CORE//
	
	public static final ItemSword DEMON_SWORD = new ToolSword("demon_sword", MATERIAL_DEMON);
	public static final ItemSword CORE_SWORD = new ToolSword("core_sword", MATERIAL_CORE);
	
	

	//GEMS//
	public static final Item SAPHIR = new ItemBase("saphir");
	public static final Item RUBY = new ItemBase("ruby");
	public static final Item TOPAZ = new ItemBase("topaz");
	public static final Item DIAMOND = new ItemBase("diamond");
	public static final Item JADE = new ItemBase("jade");
	public static final Item AMAZONITE = new Gems("amazonite");
	public static final Item AMETHYST = new Gems("amethyst");
	public static final Item ONYX = new Gems("onyx");
	public static final Item AZURITE = new Gems("azurite");
	
	//ROD//
	public static final Item EMERALD_ROD = new ItemBase("emerald_rod");
	public static final Item SAPHIR_ROD = new ItemBase("saphir_rod");
	public static final Item RUBY_ROD = new ItemBase("ruby_rod");
	public static final Item TOPAZ_ROD = new ItemBase("topaz_rod");
	public static final Item DIAMOND_ROD = new ItemBase("diamond_rod");
	public static final Item JADE_ROD = new ItemBase("jade_rod");
	public static final Item AMAZONITE_ROD = new Gems("amazonite_rod");
	public static final Item AMETHYST_ROD = new Gems("amethyst_rod");
	public static final Item ONYX_ROD = new Gems("onyx_rod");
	public static final Item AZURITE_ROD = new Gems("azurite_rod");
	
	//Ingot//
	public static final Item IRON_INGOT = new ItemBase("iron_ingot");
	public static final Item STEEL_INGOT = new ItemBase("steel_ingot");
	public static final Item SILVER_INGOT = new ItemBase("silver_ingot");
	public static final Item GOLD_INGOT = new ItemBase("gold_ingot");
	public static final Item PLATINUM_INGOT = new ItemBase("platinum_ingot");

	public static final Item IRON_COAL = new ItemBase("iron_coal");
	public static final Item SULFUR = new ItemBase("sulfur");
	
	public static final Item IRON_NUGGET = new ItemBase("iron_nugget");
	public static final Item STEEL_NUGGET = new ItemBase("steel_nugget");
	public static final Item SILVER_NUGGET = new ItemBase("silver_nugget");
	public static final Item GOLD_NUGGET = new ItemBase("gold_nugget");
	public static final Item PLATINUM_NUGGET = new ItemBase("platinum_nugget");
	
	public static final Item DEMON_STAR = new ItemBase("demon_star");
	public static final Item DEMON_STAR_CHARGED = new Gems("demon_star_charged");
	public static final Item CORE_STAR = new ItemBase("core_star");

	public static final Item PLATINUM_APPLE = new FoodEffectBase("platinum_apple", 10, 3.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 6000,4, false, false),
			new PotionEffect(MobEffects.REGENERATION, 400,2, false, false),
			new PotionEffect(MobEffects.STRENGTH, 3000,0, false, false));

	public static final Item ENCHANTED_PLATINUM_APPLE = new EnchantedFoodEffectBase("enchanted_platinum_apple", 10, 3.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 6000,4, false, false),
			new PotionEffect(MobEffects.REGENERATION, 800,2, false, false),
			new PotionEffect(MobEffects.STRENGTH, 3000,1, false, false),
			new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000,1, false, false),
			new PotionEffect(MobEffects.RESISTANCE, 6000,1, false, false),
			new PotionEffect(MobEffects.GLOWING, 3000,0, false, false));

	public static final Item SAPHIR_APPLE = new EnchantedFoodEffectBase("saphir_apple", 15, 6.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 12000,8, false, false),
			new PotionEffect(MobEffects.REGENERATION, 1200,3, false, false),
			new PotionEffect(MobEffects.STRENGTH, 6000,1, false, false),
			new PotionEffect(MobEffects.SPEED, 6000,0, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 6000,0, false, false),
			new PotionEffect(MobEffects.GLOWING, 3000,0, false, false));


	public static final Item ENCHANTED_SAPHIR_APPLE = new EnchantedFoodEffectBase1("enchanted_saphir_apple", 15, 6.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 12000,8, false, false),
			new PotionEffect(MobEffects.REGENERATION, 1200,3, false, false),
			new PotionEffect(MobEffects.STRENGTH, 6000,2, false, false),
			new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000,2, false, false),
			new PotionEffect(MobEffects.RESISTANCE, 6000,2, false, false),
			new PotionEffect(MobEffects.SPEED, 6000,1, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 6000,1, false, false),
			new PotionEffect(MobEffects.GLOWING, 6000,0, false, false));

	public static final Item RUBY_APPLE = new EnchantedFoodEffectBase("ruby_apple", 20, 12.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 12000,12, false, false),
			new PotionEffect(MobEffects.REGENERATION, 3000,4, false, false),
			new PotionEffect(MobEffects.STRENGTH, 6000,2, false, false),
			new PotionEffect(MobEffects.SPEED, 6000,1, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 6000,1, false, false),
			new PotionEffect(MobEffects.GLOWING, 6000,0, false, false));


	public static final Item ENCHANTED_RUBY_APPLE = new EnchantedFoodEffectBase1("enchanted_ruby_apple", 20, 12.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 12000,12, false, false),
			new PotionEffect(MobEffects.REGENERATION, 3000,4, false, false),
			new PotionEffect(MobEffects.STRENGTH, 6000,3, false, false),
			new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000,2, false, false),
			new PotionEffect(MobEffects.RESISTANCE, 6000,2, false, false),
			new PotionEffect(MobEffects.SPEED, 6000,2, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 6000,2, false, false),
			new PotionEffect(MobEffects.GLOWING, 6000,0, false, false));

	public static final Item DIAMOND_APPLE = new EnchantedFoodEffectBase("diamond_apple", 20, 24.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 24000,16, false, false),
			new PotionEffect(MobEffects.REGENERATION, 6000,4, false, false),
			new PotionEffect(MobEffects.SPEED, 6000,2, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 6000,2, false, false),
			new PotionEffect(MobEffects.STRENGTH, 6000,4, false, false),
			new PotionEffect(MobEffects.GLOWING, 6000,0, false, false));

	public static final Item ENCHANTED_DIAMOND_APPLE = new EnchantedFoodEffectBase1("enchanted_diamond_apple", 20, 24.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 24000,16, false, false),
			new PotionEffect(MobEffects.REGENERATION, 12000,4, false, false),
			new PotionEffect(MobEffects.STRENGTH, 12000,5, false, false),
			new PotionEffect(MobEffects.FIRE_RESISTANCE, 12000,2, false, false),
			new PotionEffect(MobEffects.RESISTANCE, 12000,2, false, false),
			new PotionEffect(MobEffects.SPEED, 12000,3, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 12000,3, false, false),
			new PotionEffect(MobEffects.GLOWING, 12000,0, false, false));

//SHIELDS
	public static final Item IRON_SHIELD = new IronShield("iron_shield");
	public static final Item STEEL_SHIELD = new SteelShield("steel_shield");
	public static final Item SILVER_SHIELD = new SilverShield("silver_shield");
	public static final Item GOLD_SHIELD = new GoldShield("gold_shield");
	public static final Item PLATINUM_SHIELD = new PlatinumShield("platinum_shield");
	public static final Item SAPPHIRE_SHIELD = new SapphireShield("sapphire_shield");
	public static final Item RUBY_SHIELD = new RubyShield("ruby_shield");
	public static final Item DIAMOND_SHIELD = new DiamondShield("diamond_shield");
	public static final Item AMAZONITE_SHIELD = new AmazoniteShield("amazonite_shield");
	public static final Item ONYX_SHIELD = new OnyxShield("onyx_shield");



}
