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
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX_II) {
            health = 30.0F;
            knockback = 0.25F;
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX_III) {
            health = 40.0F;
            knockback = 0.25F;
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX_IV) {
            health = 50.0F;
            knockback = 0.25F;
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX_V) {
            health = 60.0F;
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
    public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack) {
        Item head = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem();
        Item chest = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem();
        Item legs = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem();
        Item boots = player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem();

        List<PotionEffect> effects = ItemSetPieces.getSetBonus(head, chest, legs, boots);
        for (PotionEffect effect : effects) {
            player.addPotionEffect(effect);
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
                || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_BRIGMANITE || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_MAJORITE || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_AMAZONITE) {
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.0"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.1"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.2"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.3"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.4"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.5"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.6"));
            tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX_II || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX_III || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX_IV || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX_V) {
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.0"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.1"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.2"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.3"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.4"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.5"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.6"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.7"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.8"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.9"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.10"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.11"));
            tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
        }
    }
}