package com.PlanetCore.enchantments;

import com.PlanetCore.init.EnchantmentInit;
import com.PlanetCore.util.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;


public class CoolingCore extends Enchantment

{

    public CoolingCore()

    {

        super(Rarity.VERY_RARE, EnumEnchantmentType.ARMOR_FEET, new EntityEquipmentSlot[] {EntityEquipmentSlot.FEET});

        this.setName("coolingcore");

        this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":cooling_core"));



        EnchantmentInit.ENCHANTMENTS.add(this);

    }



    @Override

    public int getMinEnchantability(int enchantmentLevel)

    {

        return 20 * enchantmentLevel;

    }



    @Override

    public int getMaxEnchantability(int enchantmentLevel)

    {

        return this.getMinEnchantability(enchantmentLevel) + 10;

    }



    @Override

    public int getMaxLevel()

    {

        return 1;

    }



    @Override

    protected boolean canApplyTogether(Enchantment ench)

    {

        return super.canApplyTogether(ench) && ench != Enchantments.FROST_WALKER && ench != Enchantments.DEPTH_STRIDER;

    }

}