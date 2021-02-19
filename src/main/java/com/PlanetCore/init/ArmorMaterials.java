package com.PlanetCore.init;

import com.PlanetCore.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorMaterials {
    //ARMOR MATERIAL (name, textureName, durability, reductionAmounts, enchantability, soundOnEquip, toughness)
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ALUMINIUM = EnumHelper.addArmorMaterial("armor_material_aluminium", Reference.MOD_ID + ":aluminium", 5,
        new int[] {1, 3, 2, 1}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ZINC = EnumHelper.addArmorMaterial("armor_material_zinc", Reference.MOD_ID + ":zinc", 25,
        new int[] {2, 5, 4, 2}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_LEAD = EnumHelper.addArmorMaterial("armor_material_lead", Reference.MOD_ID + ":lead", 15,
        new int[] {2, 4, 3, 1}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_TIN = EnumHelper.addArmorMaterial("armor_material_tin", Reference.MOD_ID + ":tin", 20,
        new int[] {2, 4, 3, 2}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_SILICON = EnumHelper.addArmorMaterial("armor_material_silicon", Reference.MOD_ID + ":silicon", 10,
        new int[] {2, 4, 3, 1}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_COPPER = EnumHelper.addArmorMaterial("armor_material_copper", Reference.MOD_ID + ":copper", 20,
        new int[] {2, 3, 3, 2}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_IRON = EnumHelper.addArmorMaterial("armor_material_iron", Reference.MOD_ID + ":iron", 30,
        new int[] {3, 5, 4, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_BRONZE = EnumHelper.addArmorMaterial("armor_material_bronze", Reference.MOD_ID + ":bronze", 40,
        new int[] {3, 6, 5, 3}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_STEEL = EnumHelper.addArmorMaterial("armor_material_steel", Reference.MOD_ID + ":steel", 35,
        new int[] {3, 6, 5, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_SILVER = EnumHelper.addArmorMaterial("armor_material_silver", Reference.MOD_ID + ":silver", 45,
        new int[] {4, 7, 6, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_GOLD = EnumHelper.addArmorMaterial("armor_material_gold", Reference.MOD_ID + ":gold", 50,
        new int[] {4, 7, 6, 4}, 14, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_AEROGEL_GOLD = EnumHelper.addArmorMaterial("armor_material_aerogel_gold", Reference.MOD_ID + ":aerogel_gold", 360,
        new int[] {4, 7, 6, 4}, 14, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_PLATINUM = EnumHelper.addArmorMaterial("armor_material_platinum", Reference.MOD_ID + ":platinum", 55,
        new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_TITANIUM = EnumHelper.addArmorMaterial("armor_material_titanium", Reference.MOD_ID + ":titanium", 120,
        new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_URANIUM = EnumHelper.addArmorMaterial("armor_material_uranium", Reference.MOD_ID + ":uranium", 5,
        new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_TOPAZ = EnumHelper.addArmorMaterial("armor_material_topaz", Reference.MOD_ID + ":topaz", 130,
        new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_JADE = EnumHelper.addArmorMaterial("armor_material_jade", Reference.MOD_ID + ":jade", 140,
        new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_TUNGSTEN = EnumHelper.addArmorMaterial("armor_material_tungsten", Reference.MOD_ID + ":tungsten", 150,
        new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_TITANIUM_URANIUM = EnumHelper.addArmorMaterial("armor_material_titanium_uranium", Reference.MOD_ID + ":titanium_uranium", 130,
        new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_TUNGSTEN_URANIUM = EnumHelper.addArmorMaterial("armor_material_tungsten_uranium", Reference.MOD_ID + ":tungsten_uranium", 160,
        new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_TUNGSTEN_TITANIUM = EnumHelper.addArmorMaterial("armor_material_tungsten_titanium", Reference.MOD_ID + ":tungsten_titanium", 270,
        new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_EMERALD = EnumHelper.addArmorMaterial("armor_material_emerald", Reference.MOD_ID + ":emerald", 85,
        new int[] {3, 5, 4, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_RUBY = EnumHelper.addArmorMaterial("armor_material_ruby", Reference.MOD_ID + ":ruby", 90,
        new int[] {7, 12, 10, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 10.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_SAPPHIRE = EnumHelper.addArmorMaterial("armor_material_sapphire", Reference.MOD_ID + ":sapphire", 95,
        new int[] {6, 10, 9, 5}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_DIAMOND = EnumHelper.addArmorMaterial("armor_material_diamond", Reference.MOD_ID + ":diamond", 100,
        new int[] {8, 14, 12, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 13.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_OLIVINE = EnumHelper.addArmorMaterial("armor_material_olivine", Reference.MOD_ID + ":olivine", 220,
        new int[] {8, 14, 12, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 13.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_WADSLEYITE = EnumHelper.addArmorMaterial("armor_material_wadsleyite", Reference.MOD_ID + ":wadsleyite", 240,
        new int[] {8, 14, 12, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 13.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_RINGWOODITE = EnumHelper.addArmorMaterial("armor_material_ringwoodite", Reference.MOD_ID + ":ringwoodite", 260,
        new int[] {8, 14, 12, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 13.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_BRIGMANITE = EnumHelper.addArmorMaterial("armor_material_brigmanite", Reference.MOD_ID + ":brigmanite", 280,
        new int[] {8, 14, 12, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 13.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_MAJORITE = EnumHelper.addArmorMaterial("armor_material_majorite", Reference.MOD_ID + ":majorite", 300,
        new int[] {8, 14, 12, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 13.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_AMAZONITE = EnumHelper.addArmorMaterial("armor_material_amazonite", Reference.MOD_ID + ":amazonite", 200,
        new int[] {6, 12, 9, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ONYX = EnumHelper.addArmorMaterial("armor_material_onyx", Reference.MOD_ID + ":onyx", 250,
        new int[] {7, 14, 10, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 8.0F);
}
