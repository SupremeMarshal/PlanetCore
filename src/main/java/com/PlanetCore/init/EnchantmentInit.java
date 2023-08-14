package com.PlanetCore.init;

import com.PlanetCore.enchantments.Frosting;
import com.PlanetCore.enchantments.Refiner;
import com.PlanetCore.enchantments.RelentlessEnchantment;
import com.PlanetCore.util.Reference;
import net.minecraft.enchantment.Enchantment;
import net.minecraftforge.fml.common.Mod;

import java.util.ArrayList;
import java.util.List;



@Mod.EventBusSubscriber(modid= Reference.MOD_ID)

public class EnchantmentInit

{

    public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();

    public static final Enchantment Relentless = new RelentlessEnchantment();
    public static final Enchantment Refiner = new Refiner();
    public static final Enchantment Frosting = new Frosting();

}