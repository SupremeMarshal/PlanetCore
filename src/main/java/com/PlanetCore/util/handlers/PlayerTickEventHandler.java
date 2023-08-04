package com.PlanetCore.util.handlers;

import com.PlanetCore.util.Reference;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber(modid= Reference.MOD_ID)
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


            if (Y < -500 && Y >= -1000) {
                if (event.player.world.getTotalWorldTime() % 600 == 0) {
                    if (effect == null) {
                        event.player.setFire(4);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 1);
                    }
                }
            }
            if (Y < -1000) {
                float time = 500 + ((Y+1000)/20);
                if (time < 60) {
                    time = 60;
                }
                if (event.player.world.getTotalWorldTime() % time == 0) {
                    damage = -0.002111F * (Y + 1000) + 1;
                    if (effect == null) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, damage);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        damage = damage / 2;
                        if (damage >= 1) event.player.attackEntityFrom(DamageSource.GENERIC, damage -1);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        damage = damage / 4;
                        if (damage >= 1) event.player.attackEntityFrom(DamageSource.GENERIC, damage -1);
                    }
                    if(effect != null && effect.getAmplifier() == 2) {
                        damage = damage / 8;
                        if (damage >= 1) event.player.attackEntityFrom(DamageSource.GENERIC, damage -1);
                    }
                    if(effect != null && effect.getAmplifier() == 3) {
                        damage = damage / 16;
                        if (damage >= 1.0) event.player.attackEntityFrom(DamageSource.GENERIC, damage -1);
                    }
                    if(effect != null && effect.getAmplifier() == 4) {
                        damage = damage / 32;
                        if (damage >= 0.5) event.player.attackEntityFrom(DamageSource.GENERIC, damage -0.5f);
                    }
                }
            }
        }
    }
}