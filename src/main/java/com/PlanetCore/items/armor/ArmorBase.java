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
import net.minecraft.init.Items;
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

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ALUMINIUM) return repair.getItem() == ModItems.ALUMINIUM_INGOT || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_STEEL) return repair.getItem() == ModItems.STEEL_INGOT || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TIN) return repair.getItem() == ModItems.TIN_INGOT || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_COPPER) return repair.getItem() == ModItems.COPPER_INGOT || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_BRONZE) return repair.getItem() == ModItems.BRONZE_INGOT || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_SILVER) return repair.getItem() == ModItems.SILVER_INGOT || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TITANIUM) return repair.getItem() == ModItems.TITANIUM_INGOT || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_URANIUM) return repair.getItem() == ModItems.URANIUM_INGOT || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN) return repair.getItem() == ModItems.TUNGSTEN_INGOT || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_TITANIUM) return repair.getItem() == ModItems.TUNGSTEN_TITANIUM_INGOT || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_JADE) return repair.getItem() == ModItems.JADE || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_RUBY) return repair.getItem() == ModItems.RUBY || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_SAPPHIRE) return repair.getItem() == ModItems.SAPPHIRE || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_OLIVINE) return repair.getItem() == ModItems.OLIVINE || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_WADSLEYITE) return repair.getItem() == ModItems.WADSLEYITE || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_RINGWOODITE) return repair.getItem() == ModItems.RINGWOODITE || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_BRIGMANITE) return repair.getItem() == ModItems.BRIGMANITE || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_MAJORITE) return repair.getItem() == ModItems.MAJORITE || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_AMAZONITE) return repair.getItem() == ModItems.AMAZONITE || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX) return repair.getItem() == ModItems.ONYX || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX_II) return repair.getItem() == ModItems.PAINITE || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX_III) return repair.getItem() == ModItems.PAINITE || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX_IV) return repair.getItem() == ModItems.PAINITE || super.getIsRepairable(toRepair, repair);
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX_V) return repair.getItem() == ModItems.PAINITE || super.getIsRepairable(toRepair, repair);
        return super.getIsRepairable(toRepair, repair);
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
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TITANIUM) health = 0.5F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_URANIUM) health = 0.5F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN) health = 1.0F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_TITANIUM) health = 1.5F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TOPAZ) health = 0.5F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_JADE) health = 1.0F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_RUBY) health = 2.0F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_SAPPHIRE) health = 2.5F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_OLIVINE) health = 3.0F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_WADSLEYITE) health = 3.5F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_RINGWOODITE) health = 4.0F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_BRIGMANITE) health = 4.5F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_MAJORITE) health = 5.0F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_AMAZONITE) health = 6.0F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX) health = 7.0F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX_II) health = 8.0F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX_III) health = 9.0F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX_IV) health = 10.0F;
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ONYX_V) health = 11.0F;



        String maxhealth = SharedMonsterAttributes.MAX_HEALTH.getName();
        String knockback_resistance = SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName();

        if (slot == EntityEquipmentSlot.HEAD) {

            mods.put(maxhealth, new AttributeModifier(MAX_HEALTH_HELM_UUID, "MAX_HEALTH_HELM_UUID", health, 0));
        }
        if (slot == EntityEquipmentSlot.CHEST) {

            mods.put(maxhealth, new AttributeModifier(MAX_HEALTH_BODY_UUID, "MAX_HEALTH_BODY_UUID", health, 0));
        }
        if (slot == EntityEquipmentSlot.LEGS) {

            mods.put(maxhealth, new AttributeModifier(MAX_HEALTH_LEGS_UUID, "MAX_HEALTH_LEGS_UUID", health, 0));
        }
        if (slot == EntityEquipmentSlot.FEET) {

            mods.put(maxhealth, new AttributeModifier(MAX_HEALTH_BOOTS_UUID, "MAX_HEALTH_BOOTS_UUID", health, 0));
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
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_ALUMINIUM || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_STEEL
                || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TIN || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_COPPER
                || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_BRONZE
                || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_SILVER) {
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.0"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.1"));
            tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TITANIUM || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_URANIUM
                || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TUNGSTEN_TITANIUM) {
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.0"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.1"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.2"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.3"));
            tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_TOPAZ || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_JADE || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_RUBY || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_SAPPHIRE) {
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.0"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.1"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.2"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.3"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.4"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.5"));
            tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
        }
        if (getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_OLIVINE || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_WADSLEYITE || getArmorMaterial() == ArmorMaterials.ARMOR_MATERIAL_RINGWOODITE
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
            tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
        }
    }
}