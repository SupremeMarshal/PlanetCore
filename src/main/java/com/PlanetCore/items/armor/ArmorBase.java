package com.PlanetCore.items.armor;


import com.PlanetCore.init.ArmorMaterials;
import com.PlanetCore.init.ModItems;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class ArmorBase extends ItemArmor {


    public ArmorBase(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        setCreativeTab(CreativeTabs.COMBAT);
    }

    public static final UUID MAX_HEALTH_HELM_UUID = UUID.fromString("de2d6ce5-561c-47e6-a9d1-219b6a1fac02");
    public static final UUID MAX_HEALTH_BODY_UUID = UUID.fromString("f32661c4-8f25-4404-a3d3-6627735bf883");
    public static final UUID MAX_HEALTH_LEGS_UUID = UUID.fromString("ec5baf86-1084-44e6-b8f6-2477f3c18140");
    public static final UUID MAX_HEALTH_BOOTS_UUID = UUID.fromString("a9fb9d05-55c3-4647-b29e-3eeedeedcd29");

    public static final UUID KNOCKBACK_RESISTANCE_HELM_UUID = UUID.fromString("6c764957-a79a-4eb9-96e4-77ca2cec60c4");
    public static final UUID KNOCKBACK_RESISTANCE_BODY_UUID = UUID.fromString("e7a6a399-db3f-4535-afb2-f8c5a45f543d");
    public static final UUID KNOCKBACK_RESISTANCE_LEGS_UUID = UUID.fromString("4834272d-8e85-4fe4-b828-e00876a88ee2");
    public static final UUID KNOCKBACK_RESISTANCE_BOOTS_UUID = UUID.fromString("fca00d5f-0943-4b9f-ad4b-c0c7aed66d1c");

    private static final Map<IAttribute, AttributeModifier> modMap = new HashMap<>();


    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot,

                                                                     ItemStack stack) {

        Multimap<String, AttributeModifier> mods = super.getAttributeModifiers(slot, stack);

        float health = 0;
        float knockback = 0;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_SILVER) health = 0.5F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_GOLD) health = 1.0F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_PLATINUM) health = 1.5F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TITANIUM) health = 2.0F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_URANIUM) health = 2.5F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TITANIUM_URANIUM) health = 3.0F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN) health = 3.5F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_TITANIUM) health = 4.0F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_URANIUM) health = 4.5F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_EMERALD) {
            health = 5.0F;
            knockback = 0.02F;
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_RUBY) {
            health = 6.0F;
            knockback = 0.04F;
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_SAPPHIRE) {
            health = 7.0F;
            knockback = 0.06F;
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_DIAMOND) {
            health = 8.0F;
            knockback = 0.08F;
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_OLIVINE) {
            health = 10.0F;
            knockback = 0.1F;
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_WADSLEYITE) {
            health = 12.0F;
            knockback = 0.12F;
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_RINGWOODITE) {
            health = 14.0F;
            knockback = 0.14F;
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_BRIGMANITE) {
            health = 16.0F;
            knockback = 0.16F;
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_MAJORITE) {
            health = 18.0F;
            knockback = 0.2F;
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_AMAZONITE) {
            health = 20.0F;
            knockback = 0.2F;
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX) {
            health = 25.0F;
            knockback = 0.25F;
        }


        String maxhealth = SharedMonsterAttributes.MAX_HEALTH.getName();
        String knockback_resistance = SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName();

        if (slot == EntityEquipmentSlot.HEAD) {

            mods.put(maxhealth, new AttributeModifier(MAX_HEALTH_HELM_UUID, "MAX_HEALTH_HELM_UUID", health, 0));
            mods.put(knockback_resistance, new AttributeModifier(KNOCKBACK_RESISTANCE_HELM_UUID, "KNOCKBACK_RESISTANCE_HELM_UUID", knockback, 0));
        }
        if (slot == EntityEquipmentSlot.CHEST) {

            mods.put(maxhealth, new AttributeModifier(MAX_HEALTH_BODY_UUID, "MAX_HEALTH_BODY_UUID", health, 0));
            mods.put(knockback_resistance, new AttributeModifier(KNOCKBACK_RESISTANCE_BODY_UUID, "KNOCKBACK_RESISTANCE_BODY_UUID", knockback, 0));
        }
        if (slot == EntityEquipmentSlot.LEGS) {

            mods.put(maxhealth, new AttributeModifier(MAX_HEALTH_LEGS_UUID, "MAX_HEALTH_LEGS_UUID", health, 0));
            mods.put(knockback_resistance, new AttributeModifier(KNOCKBACK_RESISTANCE_LEGS_UUID, "KNOCKBACK_RESISTANCE_LEGS_UUID", knockback, 0));
        }
        if (slot == EntityEquipmentSlot.FEET) {

            mods.put(maxhealth, new AttributeModifier(MAX_HEALTH_BOOTS_UUID, "MAX_HEALTH_BOOTS_UUID", health, 0));
            mods.put(knockback_resistance, new AttributeModifier(KNOCKBACK_RESISTANCE_BOOTS_UUID, "KNOCKBACK_RESISTANCE_BOOTS_UUID", knockback, 0));
        }
        return mods;
    }


    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
    {
        Item head = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem();
        Item chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem();
        Item legs = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem();
        Item boots = player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem();
        Item headS = ModItems.ONYX_HELMET;
        Item chestS = ModItems.ONYX_CHESTPLATE;
        Item legsS = ModItems.ONYX_LEGGINGS;
        Item bootsS = ModItems.ONYX_BOOTS;
        Item headA = ModItems.AMAZONITE_HELMET;
        Item chestA = ModItems.AMAZONITE_CHESTPLATE;
        Item legsA = ModItems.AMAZONITE_LEGGINGS;
        Item bootsA = ModItems.AMAZONITE_BOOTS;
        Item headB = ModItems.MAJORITE_HELMET;
        Item chestB = ModItems.MAJORITE_CHESTPLATE;
        Item legsB = ModItems.MAJORITE_LEGGINGS;
        Item bootsB = ModItems.MAJORITE_BOOTS;
        Item headC = ModItems.BRIGMANITE_HELMET;
        Item chestC = ModItems.BRIGMANITE_CHESTPLATE;
        Item legsC = ModItems.BRIGMANITE_LEGGINGS;
        Item bootsC = ModItems.BRIGMANITE_BOOTS;
        Item headD = ModItems.RINGWOODITE_HELMET;
        Item chestD = ModItems.RINGWOODITE_CHESTPLATE;
        Item legsD = ModItems.RINGWOODITE_LEGGINGS;
        Item bootsD = ModItems.RINGWOODITE_BOOTS;
        Item headE = ModItems.WADSLEYITE_HELMET;
        Item chestE = ModItems.WADSLEYITE_CHESTPLATE;
        Item legsE = ModItems.WADSLEYITE_LEGGINGS;
        Item bootsE = ModItems.WADSLEYITE_BOOTS;
        Item headF = ModItems.OLIVINE_HELMET;
        Item chestF = ModItems.OLIVINE_CHESTPLATE;
        Item legsF = ModItems.OLIVINE_LEGGINGS;
        Item bootsF = ModItems.OLIVINE_BOOTS;
        Item headG = ModItems.DIAMOND_HELMET;
        Item chestG = ModItems.DIAMOND_CHESTPLATE;
        Item legsG = ModItems.DIAMOND_LEGGINGS;
        Item bootsG = ModItems.DIAMOND_BOOTS;
        Item headH = ModItems.SAPPHIRE_HELMET;
        Item chestH = ModItems.SAPPHIRE_CHESTPLATE;
        Item legsH = ModItems.SAPPHIRE_LEGGINGS;
        Item bootsH = ModItems.SAPPHIRE_BOOTS;
        Item headI = ModItems.RUBY_HELMET;
        Item chestI = ModItems.RUBY_CHESTPLATE;
        Item legsI = ModItems.RUBY_LEGGINGS;
        Item bootsI = ModItems.RUBY_BOOTS;
        Item headJ = ModItems.EMERALD_HELMET;
        Item chestJ = ModItems.EMERALD_CHESTPLATE;
        Item legsJ = ModItems.EMERALD_LEGGINGS;
        Item bootsJ = ModItems.EMERALD_BOOTS;
        if ((head == headS || head == headA || head == headB || head == headC || head == headD || head == headE || head == headF || head == headG || head == headH || head == headI || head == headJ)
                && (chest == chestS || chest == chestA || chest == chestB || chest == chestC || chest == chestD || chest == chestE || chest == chestF || chest == chestG || chest == chestH || chest == chestI || chest == chestJ)
                && (legs == legsS || legs == legsA || legs == legsB || legs == legsC || legs == legsD || legs == legsE || legs == legsF || legs == legsG || legs == legsH || legs == legsI || legs == legsJ)
                && (boots == bootsS || boots == bootsA || boots == bootsB || boots == bootsC || boots == bootsD || boots == bootsE || boots == bootsF || boots == bootsG || boots == bootsH || boots == bootsI || boots == bootsJ))
        {
            player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 0, 0));
        }
        if ((head == headS || head == headA || head == headB || head == headC || head == headD || head == headE || head == headF)
                && (chest == chestS || chest == chestA || chest == chestB || chest == chestC || chest == chestD || chest == chestE || chest == chestF)
                && (legs == legsS || legs == legsA || legs == legsB || legs == legsC || legs == legsD || legs == legsE || legs == legsF)
                && (boots == bootsS || boots == bootsA || boots == bootsB || boots == bootsC || boots == bootsD || boots == bootsE || boots == bootsF))
        {
            player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 0, 1));
        }
        if ((head == headS || head == headA) && (chest == chestS || chest == chestA) && (legs == legsS || legs == legsA) && (boots == bootsS || boots == bootsA))
        {
            player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 0, 2));
        }
        if (head == headS && chest == chestS && legs == legsS && boots == bootsS)
        {
            player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE, 0, 3));
        }
    }


    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {

        if (!stack.hasTagCompound()) {

            stack.setTagCompound(new NBTTagCompound());

        }

        if (!stack.getTagCompound().hasKey("HideFlags")) {

            // hides normal info

            stack.getTagCompound().setInteger("HideFlags", 2);

        }

        /**
         * tooltip 0 = When equipped:
         * tooltip 1 = +0 Armor
         * tooltip 2 = +0 Toughness
         * tooltip 3 = +0 Max health
         * tooltip 4 = +0 Knockback resistance
         * tooltip 5 = When full armor of this tier or above is equipped:
         * tooltip 6 = +Resistance
         */
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ALUMINIUM || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_IRON) {
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.0"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.1"));
            tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_STEEL || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TIN || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_COPPER || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_BRONZE) {
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.0"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.1"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.2"));
            tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_SILVER || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_GOLD || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_PLATINUM
                || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TITANIUM || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_URANIUM || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TITANIUM_URANIUM
                || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_TITANIUM || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_URANIUM) {
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.0"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.1"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.2"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.3"));
            tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_EMERALD || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_RUBY || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_SAPPHIRE
                || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_DIAMOND || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_OLIVINE || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_WADSLEYITE || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_RINGWOODITE
                || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_BRIGMANITE || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_MAJORITE || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_AMAZONITE || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX) {
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.0"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.1"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.2"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.3"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.4"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.5"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.6"));
            tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
        }
    }
}