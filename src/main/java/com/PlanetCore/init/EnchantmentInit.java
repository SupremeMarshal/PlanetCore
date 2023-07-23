package com.PlanetCore.init;

import com.PlanetCore.enchantments.CoolingCore;
import com.PlanetCore.enchantments.RelentlessEnchantment;
import com.PlanetCore.util.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.ArrayList;
import java.util.List;



@Mod.EventBusSubscriber(modid= Reference.MOD_ID)

public class EnchantmentInit

{

    public static final List<Enchantment> ENCHANTMENTS = new ArrayList<Enchantment>();

    public static final Enchantment Relentless = new RelentlessEnchantment();

}