package com.PlanetCore.init;

import com.PlanetCore.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorMaterials {
    //ARMOR MATERIAL (name, textureName, durability, reductionAmounts, enchantability, soundOnEquip, toughness)
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_SILVER = EnumHelper.addArmorMaterial("armor_material_silver", Reference.MOD_ID + ":silver", 15,
            new int[]{3, 8, 6, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_TITANIUM = EnumHelper.addArmorMaterial("armor_material_titanium", Reference.MOD_ID + ":titanium", 30,
            new int[]{3, 8, 6, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_URANIUM = EnumHelper.addArmorMaterial("armor_material_uranium", Reference.MOD_ID + ":uranium", 5,
            new int[]{3, 8, 6, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_TUNGSTEN = EnumHelper.addArmorMaterial("armor_material_tungsten", Reference.MOD_ID + ":tungsten", 60,
            new int[]{3, 8, 6, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 4.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_RUBY = EnumHelper.addArmorMaterial("armor_material_ruby", Reference.MOD_ID + ":ruby", 20,
            new int[]{3, 8, 6, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_SAPPHIRE = EnumHelper.addArmorMaterial("armor_material_sapphire", Reference.MOD_ID + ":sapphire", 25,
            new int[]{3, 8, 6, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_MAJORITE = EnumHelper.addArmorMaterial("armor_material_majorite", Reference.MOD_ID + ":majorite", 35,
            new int[]{4, 9, 7, 4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 7.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_AMAZONITE = EnumHelper.addArmorMaterial("armor_material_amazonite", Reference.MOD_ID + ":amazonite", 50,
            new int[]{4, 9, 7, 4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 8.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ONYX = EnumHelper.addArmorMaterial("armor_material_onyx", Reference.MOD_ID + ":onyx", 75,
            new int[]{5, 10, 8, 5}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 9.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ONYX_II = EnumHelper.addArmorMaterial("armor_material_onyx_ii", Reference.MOD_ID + ":onyx_ii", 75,
            new int[]{5, 10, 8, 5}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 10.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ONYX_III = EnumHelper.addArmorMaterial("armor_material_onyx_iii", Reference.MOD_ID + ":onyx_iii", 75,
            new int[]{5, 10, 8, 5}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 11.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ONYX_IV = EnumHelper.addArmorMaterial("armor_material_onyx_iv", Reference.MOD_ID + ":onyx_iv", 75,
            new int[]{5, 10, 8, 5}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 12.0F);
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ONYX_V = EnumHelper.addArmorMaterial("armor_material_onyx_v", Reference.MOD_ID + ":onyx_v", 100,
            new int[]{5, 10, 8, 5}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 13.0F);
}
