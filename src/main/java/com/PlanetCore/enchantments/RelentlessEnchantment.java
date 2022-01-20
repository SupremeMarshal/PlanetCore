package com.PlanetCore.enchantments;

import com.PlanetCore.init.EnchantmentInit;
import com.PlanetCore.util.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.init.Enchantments;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.util.ResourceLocation;


public class RelentlessEnchantment extends Enchantment

{

    public RelentlessEnchantment()

    {

        super(Rarity.RARE, EnumEnchantmentType.DIGGER, new EntityEquipmentSlot[] {EntityEquipmentSlot.MAINHAND});

        this.setName("relentless");

        this.setRegistryName(new ResourceLocation(Reference.MOD_ID + ":relentless"));



        EnchantmentInit.ENCHANTMENTS.add(this);

    }



    @Override

    public int getMinEnchantability(int enchantmentLevel)

    {

        return 20;

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





}