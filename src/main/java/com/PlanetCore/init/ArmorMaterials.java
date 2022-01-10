package com.PlanetCore.init;

import com.PlanetCore.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorMaterials {
    //ARMOR MATERIAL (name, textureName, durability, reductionAmounts, enchantability, soundOnEquip, toughness)
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ALUMINIUM = EnumHelper.addArmorMaterial("armor_material_aluminium", Reference.MOD_ID + ":aluminium", 12,
            new int[]{1, 3, 2, 1}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_IRON = EnumHelper.addArmorMaterial("armor_material_iron", Reference.MOD_ID + ":iron", 15,
            new int[]{2, 4, 3, 2}, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_STEEL = EnumHelper.addArmorMaterial("armor_material_steel", Reference.MOD_ID + ":steel", 20,
            new int[]{3, 5, 4, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_TIN = EnumHelper.addArmorMaterial("armor_material_tin", Reference.MOD_ID + ":tin", 15,
            new int[]{2, 4, 3, 2}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_COPPER = EnumHelper.addArmorMaterial("armor_material_copper", Reference.MOD_ID + ":copper", 15,
            new int[]{2, 4, 3, 2}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_BRONZE = EnumHelper.addArmorMaterial("armor_material_bronze", Reference.MOD_ID + ":bronze", 18,
            new int[]{4, 6, 5, 3}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_SILVER = EnumHelper.addArmorMaterial("armor_material_silver", Reference.MOD_ID + ":silver", 15,
            new int[]{4, 7, 6, 4}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_GOLD = EnumHelper.addArmorMaterial("armor_material_gold", Reference.MOD_ID + ":gold", 15,
            new int[]{4, 7, 6, 4}, 14, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_PLATINUM = EnumHelper.addArmorMaterial("armor_material_platinum", Reference.MOD_ID + ":platinum", 20,
            new int[]{5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_TITANIUM = EnumHelper.addArmorMaterial("armor_material_titanium", Reference.MOD_ID + ":titanium", 30,
            new int[]{5, 7, 6, 5}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 4.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_URANIUM = EnumHelper.addArmorMaterial("armor_material_uranium", Reference.MOD_ID + ":uranium", 5,
            new int[]{5, 7, 6, 5}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 4.5F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_TITANIUM_URANIUM = EnumHelper.addArmorMaterial("armor_material_titanium_uranium", Reference.MOD_ID + ":titanium_uranium", 25,
            new int[]{5, 7, 6, 5}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 5.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_TUNGSTEN = EnumHelper.addArmorMaterial("armor_material_tungsten", Reference.MOD_ID + ":tungsten", 60,
            new int[]{5, 7, 6, 5}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 6.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_TUNGSTEN_TITANIUM = EnumHelper.addArmorMaterial("armor_material_tungsten_titanium", Reference.MOD_ID + ":tungsten_titanium", 70,
            new int[]{5, 7, 6, 5}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 7.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_TUNGSTEN_URANIUM = EnumHelper.addArmorMaterial("armor_material_tungsten_uranium", Reference.MOD_ID + ":tungsten_uranium", 50,
            new int[]{5, 7, 6, 5}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 8.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_EMERALD = EnumHelper.addArmorMaterial("armor_material_emerald", Reference.MOD_ID + ":emerald", 15,
            new int[]{5, 7, 6, 5}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 10.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_RUBY = EnumHelper.addArmorMaterial("armor_material_ruby", Reference.MOD_ID + ":ruby", 20,
            new int[]{5, 7, 6, 5}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 12.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_SAPPHIRE = EnumHelper.addArmorMaterial("armor_material_sapphire", Reference.MOD_ID + ":sapphire", 25,
            new int[]{5, 7, 6, 5}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 14.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_DIAMOND = EnumHelper.addArmorMaterial("armor_material_diamond", Reference.MOD_ID + ":diamond", 30,
            new int[]{6, 9, 8, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 16.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_OLIVINE = EnumHelper.addArmorMaterial("armor_material_olivine", Reference.MOD_ID + ":olivine", 35,
            new int[]{6, 9, 8, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 18.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_WADSLEYITE = EnumHelper.addArmorMaterial("armor_material_wadsleyite", Reference.MOD_ID + ":wadsleyite", 35,
            new int[]{6, 9, 8, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 20.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_RINGWOODITE = EnumHelper.addArmorMaterial("armor_material_ringwoodite", Reference.MOD_ID + ":ringwoodite", 35,
            new int[]{6, 9, 8, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 22.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_BRIGMANITE = EnumHelper.addArmorMaterial("armor_material_brigmanite", Reference.MOD_ID + ":brigmanite", 35,
            new int[]{6, 9, 8, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 24.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_MAJORITE = EnumHelper.addArmorMaterial("armor_material_majorite", Reference.MOD_ID + ":majorite", 35,
            new int[]{6, 9, 8, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 26.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_AMAZONITE = EnumHelper.addArmorMaterial("armor_material_amazonite", Reference.MOD_ID + ":amazonite", 50,
            new int[]{7, 10, 9, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 28.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ONYX = EnumHelper.addArmorMaterial("armor_material_onyx", Reference.MOD_ID + ":onyx", 75,
            new int[]{7, 10, 9, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 30.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ONYX_II = EnumHelper.addArmorMaterial("armor_material_onyx_ii", Reference.MOD_ID + ":onyx_ii", 75,
            new int[]{7, 10, 9, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 35.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ONYX_III = EnumHelper.addArmorMaterial("armor_material_onyx_iii", Reference.MOD_ID + ":onyx_iii", 75,
            new int[]{7, 10, 9, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 40.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ONYX_IV = EnumHelper.addArmorMaterial("armor_material_onyx_iv", Reference.MOD_ID + ":onyx_iv", 75,
            new int[]{7, 10, 9, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 45.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ONYX_V = EnumHelper.addArmorMaterial("armor_material_onyx_v", Reference.MOD_ID + ":onyx_v", 100,
            new int[]{7, 10, 9, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 50.0F);
}
