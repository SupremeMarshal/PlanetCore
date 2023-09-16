package com.PlanetCore.init;

import com.PlanetCore.items.armor.ArmorBase;
import com.PlanetCore.util.Reference;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;

public class ArmorMaterials {

    //ARMOR MATERIAL (name, textureName, durability, reductionAmounts, enchantability, soundOnEquip, toughness)
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_SILVER = EnumHelper.addArmorMaterial("armor_material_silver", Reference.MOD_ID + ":silver", 15,
            new int[]{1, 3, 5, 2}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F).setRepairItem(new ItemStack(ModItems.SILVER_INGOT));
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_TITANIUM = EnumHelper.addArmorMaterial("armor_material_titanium", Reference.MOD_ID + ":titanium", 30,
            new int[]{3, 6, 8, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 2.5F).setRepairItem(new ItemStack(ModItems.TITANIUM_INGOT));
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_URANIUM = EnumHelper.addArmorMaterial("armor_material_uranium", Reference.MOD_ID + ":uranium", 5,
            new int[]{3, 6, 8, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.0F).setRepairItem(new ItemStack(ModItems.URANIUM_INGOT));
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_TUNGSTEN = EnumHelper.addArmorMaterial("armor_material_tungsten", Reference.MOD_ID + ":tungsten", 60,
            new int[]{3, 6, 8, 3}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 3.5F).setRepairItem(new ItemStack(ModItems.TUNGSTEN_INGOT));
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_RUBY = EnumHelper.addArmorMaterial("armor_material_ruby", Reference.MOD_ID + ":ruby", 20,
            new int[]{3, 6, 8, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 4.0F).setRepairItem(new ItemStack(ModItems.RUBY));
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_SAPPHIRE = EnumHelper.addArmorMaterial("armor_material_sapphire", Reference.MOD_ID + ":sapphire", 25,
            new int[]{3, 6, 8, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F).setRepairItem(new ItemStack(ModItems.SAPPHIRE));
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_MAJORITE = EnumHelper.addArmorMaterial("armor_material_majorite", Reference.MOD_ID + ":majorite", 35,
            new int[]{4, 7, 9, 4}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F).setRepairItem(new ItemStack(ModItems.MAJORITE));
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_AMAZONITE = EnumHelper.addArmorMaterial("armor_material_amazonite", Reference.MOD_ID + ":amazonite", 50,
            new int[]{5, 8, 10, 5}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F).setRepairItem(new ItemStack(ModItems.AMAZONITE));
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ONYX = EnumHelper.addArmorMaterial("armor_material_onyx", Reference.MOD_ID + ":onyx", 75,
            new int[]{6, 9, 11, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F).setRepairItem(new ItemStack(ModItems.ONYX));
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ONYX_II = EnumHelper.addArmorMaterial("armor_material_onyx_ii", Reference.MOD_ID + ":onyx_ii", 75,
            new int[]{7, 10, 12, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F).setRepairItem(new ItemStack(ModItems.PAINITE));
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ONYX_III = EnumHelper.addArmorMaterial("armor_material_onyx_iii", Reference.MOD_ID + ":onyx_iii", 75,
            new int[]{8, 11, 13, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F).setRepairItem(new ItemStack(ModItems.PAINITE));
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ONYX_IV = EnumHelper.addArmorMaterial("armor_material_onyx_iv", Reference.MOD_ID + ":onyx_iv", 75,
            new int[]{9, 12, 14, 8}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F).setRepairItem(new ItemStack(ModItems.PAINITE));
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ONYX_V = EnumHelper.addArmorMaterial("armor_material_onyx_v", Reference.MOD_ID + ":onyx_v", 100,
            new int[]{10, 13, 15, 9}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F).setRepairItem(new ItemStack(ModItems.PAINITE));
    public static final ItemArmor.ArmorMaterial ARMOR_MATERIAL_ONYX_CORE = EnumHelper.addArmorMaterial("armor_material_onyx_core", Reference.MOD_ID + ":onyx_core", 200,
            new int[]{10, 13, 15, 9}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 5.0F).setRepairItem(new ItemStack(ModItems.CORE_STAR));
}