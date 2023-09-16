package com.PlanetCore.init;

import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModPotions {
    public static final PotionType VERY_LONG_FIRE_RESISTANCE_POTION = new PotionType("very_long_fire_resistance", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 144000, 0)}).setRegistryName("very_long_fire_resistance");
    public static final PotionType FIRE_RESISTANCE_II_POTION = new PotionType("fire_resistance_II", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 3600, 1)}).setRegistryName("fire_resistance_II");
    public static final PotionType LONG_FIRE_RESISTANCE_II_POTION = new PotionType("long_fire_resistance_II", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 20*60*20, 1)}).setRegistryName("long_fire_resistance_II");
    public static final PotionType VERY_LONG_FIRE_RESISTANCE_II_POTION = new PotionType("very_long_fire_resistance_II", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 144000, 1)}).setRegistryName("very_long_fire_resistance_II");
    public static final PotionType FIRE_RESISTANCE_III_POTION = new PotionType("fire_resistance_III", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 3600, 2)}).setRegistryName("fire_resistance_III");
    public static final PotionType LONG_FIRE_RESISTANCE_III_POTION = new PotionType("long_fire_resistance_III", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 20*60*20, 2)}).setRegistryName("long_fire_resistance_III");
    public static final PotionType VERY_LONG_FIRE_RESISTANCE_III_POTION = new PotionType("very_long_fire_resistance_III", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 144000, 2)}).setRegistryName("very_long_fire_resistance_III");
    public static final PotionType FIRE_RESISTANCE_IV_POTION = new PotionType("fire_resistance_IV", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 3600, 3)}).setRegistryName("fire_resistance_IV");
    public static final PotionType LONG_FIRE_RESISTANCE_IV_POTION = new PotionType("long_fire_resistance_IV", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 20*60*20, 3)}).setRegistryName("long_fire_resistance_IV");
    public static final PotionType VERY_LONG_FIRE_RESISTANCE_IV_POTION = new PotionType("very_long_fire_resistance_IV", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 144000, 3)}).setRegistryName("very_long_fire_resistance_IV");
    public static final PotionType FIRE_RESISTANCE_V_POTION = new PotionType("fire_resistance_V", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 3600, 4)}).setRegistryName("fire_resistance_V");
    public static final PotionType LONG_FIRE_RESISTANCE_V_POTION = new PotionType("long_fire_resistance_V", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 20*60*20, 4)}).setRegistryName("long_fire_resistance_V");
    public static final PotionType VERY_LONG_FIRE_RESISTANCE_V_POTION = new PotionType("very_long_fire_resistance_V", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 144000, 4)}).setRegistryName("very_long_fire_resistance_V");
    public static final PotionType HASTE_POTION = new PotionType("haste", new PotionEffect[] { new PotionEffect(MobEffects.HASTE, 3600, 0)}).setRegistryName("haste");
    public static final PotionType LONG_HASTE_POTION = new PotionType("long_haste", new PotionEffect[] { new PotionEffect(MobEffects.HASTE, 9600, 0)}).setRegistryName("long_haste");
    public static final PotionType HASTE_II_POTION = new PotionType("haste_II", new PotionEffect[] { new PotionEffect(MobEffects.HASTE, 3600, 1)}).setRegistryName("haste_II");
    public static final PotionType LONG_HASTE_II_POTION = new PotionType("long_haste_II", new PotionEffect[] { new PotionEffect(MobEffects.HASTE, 24000, 1)}).setRegistryName("long_haste_II");

    public static void registerPotions(){
        ForgeRegistries.POTION_TYPES.register(VERY_LONG_FIRE_RESISTANCE_POTION);
        ForgeRegistries.POTION_TYPES.register(FIRE_RESISTANCE_II_POTION);
        ForgeRegistries.POTION_TYPES.register(LONG_FIRE_RESISTANCE_II_POTION);
        ForgeRegistries.POTION_TYPES.register(VERY_LONG_FIRE_RESISTANCE_II_POTION);
        ForgeRegistries.POTION_TYPES.register(FIRE_RESISTANCE_III_POTION);
        ForgeRegistries.POTION_TYPES.register(LONG_FIRE_RESISTANCE_III_POTION);
        ForgeRegistries.POTION_TYPES.register(VERY_LONG_FIRE_RESISTANCE_III_POTION);
        ForgeRegistries.POTION_TYPES.register(FIRE_RESISTANCE_IV_POTION);
        ForgeRegistries.POTION_TYPES.register(LONG_FIRE_RESISTANCE_IV_POTION);
        ForgeRegistries.POTION_TYPES.register(VERY_LONG_FIRE_RESISTANCE_IV_POTION);
        ForgeRegistries.POTION_TYPES.register(FIRE_RESISTANCE_V_POTION);
        ForgeRegistries.POTION_TYPES.register(LONG_FIRE_RESISTANCE_V_POTION);
        ForgeRegistries.POTION_TYPES.register(VERY_LONG_FIRE_RESISTANCE_V_POTION);
        ForgeRegistries.POTION_TYPES.register(HASTE_POTION);
        ForgeRegistries.POTION_TYPES.register(LONG_HASTE_POTION);
        ForgeRegistries.POTION_TYPES.register(HASTE_II_POTION);
        ForgeRegistries.POTION_TYPES.register(LONG_HASTE_II_POTION);

        PotionHelper.addMix(PotionTypes.WATER, ModItems.FIERY_MUSHROOM_FOOD , PotionTypes.AWKWARD);

        PotionHelper.addMix(PotionTypes.LONG_FIRE_RESISTANCE, ModItems.DEMON_STAR, VERY_LONG_FIRE_RESISTANCE_POTION);
        // short n -> short n+1
        PotionHelper.addMix(PotionTypes.FIRE_RESISTANCE, ModItems.HOT_MAGMA_CREAM, FIRE_RESISTANCE_II_POTION);
        PotionHelper.addMix(FIRE_RESISTANCE_II_POTION, ModItems.VERYHOT_MAGMA_CREAM, FIRE_RESISTANCE_III_POTION);
        PotionHelper.addMix(FIRE_RESISTANCE_III_POTION, ModItems.CORE_STAR, FIRE_RESISTANCE_IV_POTION);
        PotionHelper.addMix(FIRE_RESISTANCE_IV_POTION, ModItems.ONYX_STAR, FIRE_RESISTANCE_V_POTION);

        PotionHelper.addMix(LONG_FIRE_RESISTANCE_II_POTION, ModItems.DEMON_STAR, VERY_LONG_FIRE_RESISTANCE_II_POTION);
        PotionHelper.addMix(LONG_FIRE_RESISTANCE_III_POTION, ModItems.DEMON_STAR, VERY_LONG_FIRE_RESISTANCE_III_POTION);
        PotionHelper.addMix(LONG_FIRE_RESISTANCE_IV_POTION, ModItems.DEMON_STAR, VERY_LONG_FIRE_RESISTANCE_IV_POTION);
        PotionHelper.addMix(LONG_FIRE_RESISTANCE_V_POTION, ModItems.DEMON_STAR, VERY_LONG_FIRE_RESISTANCE_V_POTION);

        PotionHelper.addMix(VERY_LONG_FIRE_RESISTANCE_POTION, ModItems.HOT_MAGMA_CREAM, VERY_LONG_FIRE_RESISTANCE_II_POTION);
        PotionHelper.addMix(VERY_LONG_FIRE_RESISTANCE_II_POTION, ModItems.VERYHOT_MAGMA_CREAM, VERY_LONG_FIRE_RESISTANCE_III_POTION);
        PotionHelper.addMix(VERY_LONG_FIRE_RESISTANCE_III_POTION, ModItems.CORE_STAR, VERY_LONG_FIRE_RESISTANCE_IV_POTION);
        PotionHelper.addMix(VERY_LONG_FIRE_RESISTANCE_IV_POTION, ModItems.ONYX_STAR, VERY_LONG_FIRE_RESISTANCE_V_POTION);
        // long n -> long n+1
        PotionHelper.addMix(PotionTypes.LONG_FIRE_RESISTANCE, ModItems.HOT_MAGMA_CREAM, LONG_FIRE_RESISTANCE_II_POTION);
        PotionHelper.addMix(LONG_FIRE_RESISTANCE_II_POTION, ModItems.VERYHOT_MAGMA_CREAM, LONG_FIRE_RESISTANCE_III_POTION);
        PotionHelper.addMix(LONG_FIRE_RESISTANCE_III_POTION, ModItems.CORE_STAR, LONG_FIRE_RESISTANCE_IV_POTION);
        PotionHelper.addMix(LONG_FIRE_RESISTANCE_IV_POTION, ModItems.ONYX_STAR, LONG_FIRE_RESISTANCE_V_POTION);
        // short n -> long n
        PotionHelper.addMix(FIRE_RESISTANCE_II_POTION, Items.REDSTONE, LONG_FIRE_RESISTANCE_II_POTION);
        PotionHelper.addMix(FIRE_RESISTANCE_III_POTION, Items.REDSTONE, LONG_FIRE_RESISTANCE_III_POTION);
        PotionHelper.addMix(FIRE_RESISTANCE_IV_POTION, Items.REDSTONE, LONG_FIRE_RESISTANCE_IV_POTION);
        PotionHelper.addMix(FIRE_RESISTANCE_V_POTION, Items.REDSTONE, LONG_FIRE_RESISTANCE_V_POTION);

        PotionHelper.addMix(PotionTypes.WATER, ModItems.DEMON_STAR, HASTE_POTION);
        PotionHelper.addMix(HASTE_POTION, Items.REDSTONE, LONG_HASTE_POTION);
        PotionHelper.addMix(HASTE_POTION, ModItems.CORE_STAR, HASTE_II_POTION);
        PotionHelper.addMix(LONG_HASTE_POTION, ModItems.CORE_STAR, LONG_HASTE_II_POTION);
        PotionHelper.addMix(HASTE_II_POTION, Items.REDSTONE, LONG_HASTE_II_POTION);
    }
}