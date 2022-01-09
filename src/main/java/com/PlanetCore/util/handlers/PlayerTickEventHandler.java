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

        if (!event.player.getEntityWorld().isRemote) {
            //Heal player based on food level. Heal from 0% to 100% in 600 seconds at max food lvl. Heal fully in 3 hours if food level is 1. At 0 food, player stop healing.
            if (event.player.getFoodStats().getFoodLevel() >= 1) {
                if (event.player.world.getTotalWorldTime() % 20 == 1) {
                    event.player.heal(event.player.getMaxHealth() / (12000 / event.player.getFoodStats().getFoodLevel()));
                }
            }





            PotionEffect effect = event.player.getActivePotionEffect(MobEffects.FIRE_RESISTANCE);

            float Y = (float) event.player.posY;


            if (Y < -256 && Y >= -1024) {
                if (event.player.world.getTotalWorldTime() % 600 == 0) {

                    if (effect == null) {
                        event.player.setFire(4);
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.00390625F * Y);
                    }
                }
            }
            if (Y < -1024 && Y >= -2048) {
                if (event.player.world.getTotalWorldTime() % 600 == 0) {
                    if (effect == null) {
                        event.player.setFire(4);
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.0078125F * (Y + 1024) + 4);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.001953125F * (Y + 1024) + 1);
                    }
                }
            }
            if (Y < -2048 && Y >= -3072) {
                if (event.player.world.getTotalWorldTime() % 600 == 0) {
                    if (effect == null) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.015625F * (Y + 2048) + 12);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.00390625F * (Y + 2048) + 3);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.0009765625F * (Y + 2048) + 1);
                    }
                }
            }
            if (Y < -3072 && Y >= -4096) {
                if (event.player.world.getTotalWorldTime() % 600 == 0) {
                    if (effect == null) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.03125F * (Y + 3072) + 28);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.0078125F * (Y + 3072) + 7);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.001953125F * (Y + 3072) + 2);
                    }
                }
            }
            if (Y < -4096 && Y >= -5120) {
                if (event.player.world.getTotalWorldTime() % 600 == 0) {
                    if (effect == null) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.0625F * (Y + 4096) + 60);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.015625F * (Y + 4096) + 15);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.00390625F * (Y + 4096) + 4);
                    }
                    if(effect != null && effect.getAmplifier() == 2) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.0009765625F * (Y + 4096) + 1);
                    }
                }
            }
            if (Y < -5120 && Y >= -6144) {
                if (event.player.world.getTotalWorldTime() % 500 == 0) {
                    if (effect == null) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.125F * (Y + 5120) + 124);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.03125F * (Y + 5120) + 31);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.0078125F * (Y + 5120) + 8);
                    }
                    if(effect != null && effect.getAmplifier() == 2) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.001953125F * (Y + 5120) + 2);
                    }
                }
            }
            if (Y < -6144 && Y >= -7168) {
                if (event.player.world.getTotalWorldTime() % 400 == 0) {
                    if (effect == null) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.25F * (Y + 6144) + 252);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.0625F * (Y + 6144) + 63);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.015625F * (Y + 6144) + 16);
                    }
                    if(effect != null && effect.getAmplifier() == 2) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.00390625F * (Y + 6144) + 4);
                    }
                    if(effect != null && effect.getAmplifier() == 3) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.0009765625F * (Y + 6144) + 1);
                    }
                }
            }
            if (Y < -7168 && Y >= -8192) {
                if (event.player.world.getTotalWorldTime() % 300 == 0) {
                    if (effect == null) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.5F * (Y + 7168) + 508);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.125F * (Y + 7168) + 127);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.03125F * (Y + 7168) + 32);
                    }
                    if(effect != null && effect.getAmplifier() == 2) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.0078125F * (Y + 7168) + 8);
                    }
                    if(effect != null && effect.getAmplifier() == 3) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.001953125F * (Y + 7168) + 2);
                    }
                }
            }
            if (Y < -8192 && Y >= -9216) {
                if (event.player.world.getTotalWorldTime() % 200 == 0) {
                    if (effect == null) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, -1F * (Y + 8192) + 1020);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.25F * (Y + 8192) + 255);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.0625F * (Y + 8192) + 64);
                    }
                    if(effect != null && effect.getAmplifier() == 2) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.015625F * (Y + 8192) + 16);
                    }
                    if(effect != null && effect.getAmplifier() == 3) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.00390625F * (Y + 8192) + 4);
                    }
                    if(effect != null && effect.getAmplifier() == 4) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.0009765625F * (Y + 8192) + 1);
                    }
                }
            }
            if (Y < -8192) {
                if (event.player.world.getTotalWorldTime() % 150 == 0) {
                    if (effect == null) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, -2F * (Y + 8192) + 2044);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.5F * (Y + 8192) + 511);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.125F * (Y + 8192) + 128);
                    }
                    if(effect != null && effect.getAmplifier() == 2) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.03125F * (Y + 8192) + 32);
                    }
                    if(effect != null && effect.getAmplifier() == 3) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.0078125F * (Y + 8192) + 8);
                    }
                    if(effect != null && effect.getAmplifier() == 4) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, -0.001953125F * (Y + 8192) + 2);
                    }
                }
            }
        }
    }
}