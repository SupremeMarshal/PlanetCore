package com.PlanetCore.items.armor;


import com.PlanetCore.init.ArmorMaterials;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class ArmorBase extends ItemArmor {


    private final float health;
    public final int extraArmor;
    private ArmorMaterial armorMaterials;

    public ArmorBase(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn, float health, int extraArmor) {
        super(materialIn, renderIndexIn, equipmentSlotIn);
        this.health = health;
        this.extraArmor = extraArmor;
        setCreativeTab(CreativeTabs.COMBAT);
    }

//    @Override
//    public ArmorMaterial getArmorMaterial() {
//        armorMaterials = this.getArmorMaterial();
//        return ArmorMaterial.valueOf(armorMaterials.toString()); // Replace with the appropriate ArmorMaterial
//    }

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

        tooltip.add("When equipped:");
        tooltip.add("§9"+ damageReduceAmount + " Armor");
        tooltip.add("§9"+ toughness + " Toughness");
        tooltip.add("§9"+ health + " Health bonus");
        tooltip.add("§9"+ extraArmor + " Extra Armor bonus");
        tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
    }
}