package com.PlanetCore.init;

import com.PlanetCore.potions.CustomPotions;
import com.PlanetCore.util.Reference;
import net.minecraft.client.Minecraft;
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

public class ModPotions
{
    public static final Potion FIRE_RESISTANCE_II = new CustomPotions("fire_resistance_II", false , 13791173, 0 , 0);

    public static final PotionType FIRE_RESISTANCE_II_POTION = new PotionType("fire_resistance_II", new PotionEffect[] { new PotionEffect(FIRE_RESISTANCE_II, 3600)}).setRegistryName("fire_resistance_II");
    public static final PotionType LONG_FIRE_RESISTANCE_II_POTION = new PotionType("fire_resistance_II", new PotionEffect[] { new PotionEffect(FIRE_RESISTANCE_II, 9600)}).setRegistryName("long_fire_resistance_II");

    public static void registerPotions()
    {
        registerPotion(FIRE_RESISTANCE_II_POTION, LONG_FIRE_RESISTANCE_II_POTION, FIRE_RESISTANCE_II);

        registerPotionMixes();
    }

    private static void registerPotion(PotionType defaultPotion, PotionType longPotion, Potion effect)
    {
        ForgeRegistries.POTIONS.register(effect);
        ForgeRegistries.POTION_TYPES.register(defaultPotion);
        ForgeRegistries.POTION_TYPES.register(longPotion);

    }

    private static void registerPotionMixes()
    {
        PotionHelper.addMix(FIRE_RESISTANCE_II_POTION, Items.REDSTONE, LONG_FIRE_RESISTANCE_II_POTION);
        PotionHelper.addMix(PotionTypes.FIRE_RESISTANCE, ModItems.DEMON_STAR, FIRE_RESISTANCE_II_POTION);
    }
}
