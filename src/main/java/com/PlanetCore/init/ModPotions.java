package com.PlanetCore.init;

import com.PlanetCore.potions.CustomPotions;
import com.PlanetCore.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.PotionTypes;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionHelper;
import net.minecraft.potion.PotionType;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class ModPotions {
    public static final PotionType FIRE_RESISTANCE_II_POTION = new PotionType("fire_resistance_II", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 3600, 1)}).setRegistryName("fire_resistance_II");
    public static final PotionType LONG_FIRE_RESISTANCE_II_POTION = new PotionType("long_fire_resistance_II", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 20*60*8, 1)}).setRegistryName("long_fire_resistance_II");
    public static final PotionType FIRE_RESISTANCE_III_POTION = new PotionType("fire_resistance_III", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 3600, 2)}).setRegistryName("fire_resistance_III");
    public static final PotionType LONG_FIRE_RESISTANCE_III_POTION = new PotionType("long_fire_resistance_III", new PotionEffect[] { new PotionEffect(MobEffects.FIRE_RESISTANCE, 20*60*8, 2)}).setRegistryName("long_fire_resistance_III");

    public static void registerPotions(){
        ForgeRegistries.POTION_TYPES.register(FIRE_RESISTANCE_II_POTION);
        ForgeRegistries.POTION_TYPES.register(LONG_FIRE_RESISTANCE_II_POTION);
        ForgeRegistries.POTION_TYPES.register(FIRE_RESISTANCE_III_POTION);
        ForgeRegistries.POTION_TYPES.register(LONG_FIRE_RESISTANCE_III_POTION);

        // short n -> short n+1
        PotionHelper.addMix(PotionTypes.FIRE_RESISTANCE, ModItems.HOT_MAGMA_CREAM, FIRE_RESISTANCE_II_POTION);
        PotionHelper.addMix(FIRE_RESISTANCE_II_POTION, ModItems.DEMON_STAR, FIRE_RESISTANCE_III_POTION);

        // long n -> long n+1
        PotionHelper.addMix(PotionTypes.LONG_FIRE_RESISTANCE, ModItems.HOT_MAGMA_CREAM, LONG_FIRE_RESISTANCE_II_POTION);
        PotionHelper.addMix(LONG_FIRE_RESISTANCE_II_POTION, ModItems.DEMON_STAR, LONG_FIRE_RESISTANCE_III_POTION);

        // short n -> long n
        PotionHelper.addMix(FIRE_RESISTANCE_II_POTION, Items.REDSTONE, LONG_FIRE_RESISTANCE_II_POTION);
        PotionHelper.addMix(FIRE_RESISTANCE_III_POTION, Items.REDSTONE, LONG_FIRE_RESISTANCE_III_POTION);
    }
}