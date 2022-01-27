package com.PlanetCore.util.handlers;

import com.PlanetCore.Main;
import com.PlanetCore.entity.EntityHotBlaze;
import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
import com.PlanetCore.init.ModPotions;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.List;
import java.util.Random;

@Mod.EventBusSubscriber(modid="planetcore")
public class PlayerTickEventHandler {

    /*
    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        EntityPlayer player = event.getEntityPlayer();
        IUserSettings cap = player.getCapability(UserSettingsStorageProvider.SETTINGS_CAP, null);
        IUserSettings old = event.getOriginal().getCapability(UserSettingsStorageProvider.SETTINGS_CAP, null);
        cap.setHeatResistance(old.getHeatResistance());
    }
    @SubscribeEvent
    public static void onPlayerEquip(LivingEquipmentChangeEvent.LivingUpdateEvent event) {
        Entity entity = event.getEntityLiving();
        IUserSettings cap = entity.getCapability(UserSettingsStorageProvider.SETTINGS_CAP, null);
        if (((EntityLivingBase) entity).getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ModItems.AEROGEL_GOLD_HELMET || cap != null)
        {
            cap.setHeatResistance(5);
            System.out.println(cap.getHeatResistance());
        }
    }
    */




    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        if (event.player.getEntityWorld().getWorldType().getName() != "PlanetCore") return;

        if (!event.player.getEntityWorld().isRemote) {
            //Heal player based on food level. Heal from 0% to 100% in 600 seconds at max food lvl. Heal fully in 3 hours if food level is 1. At 0 food, player stop healing.
            if (event.player.getFoodStats().getFoodLevel() >= 1) {
                if (event.player.world.getTotalWorldTime() % 20 == 1) {
                    event.player.heal(event.player.getMaxHealth() / (12000 / event.player.getFoodStats().getFoodLevel()));
                }
            }





            PotionEffect effect = event.player.getActivePotionEffect(MobEffects.FIRE_RESISTANCE);

            float Y = (float) event.player.posY;
            float damage = 1;


            if (Y < -256 && Y >= -512) {
                if (event.player.world.getTotalWorldTime() % 600 == 0) {
                    if (effect == null) {
                        event.player.setFire(4);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 1);
                    }
                }
            }
            if (Y < -512) {
                float time = 500 + ((Y+512)/5);
                if (time < 20) {
                    time = 20;
                }
                if (event.player.world.getTotalWorldTime() % time == 0) {
                    damage = -0.0078125F * (Y + 512);
                    if (effect == null) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, damage + 1);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        damage = damage / 2;
                        if (damage >= 2) event.player.attackEntityFrom(DamageSource.GENERIC, damage -1);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        damage = damage / 4;
                        if (damage >= 2) event.player.attackEntityFrom(DamageSource.GENERIC, damage -1);
                    }
                    if(effect != null && effect.getAmplifier() == 2) {
                        damage = damage / 8;
                        if (damage >= 2.0) event.player.attackEntityFrom(DamageSource.GENERIC, damage -1);
                    }
                    if(effect != null && effect.getAmplifier() == 3) {
                        damage = damage / 16;
                        if (damage >= 1.0) event.player.attackEntityFrom(DamageSource.GENERIC, damage);
                    }
                    if(effect != null && effect.getAmplifier() == 4) {
                        damage = damage / 32;
                        if (damage >= 0.5) event.player.attackEntityFrom(DamageSource.GENERIC, damage);
                    }
                }
            }
        }
    }
}