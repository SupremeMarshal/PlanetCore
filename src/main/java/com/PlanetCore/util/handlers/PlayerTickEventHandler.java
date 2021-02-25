package com.PlanetCore.util.handlers;

import com.PlanetCore.Main;
import com.PlanetCore.entity.EntityHotBlaze;
import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModPotions;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
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

            boolean isActive = false;
            if (event.player.isPotionActive(ModPotions.FIRE_RESISTANCE_II)) isActive = true;
            if (isActive) event.player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 0, 1));

            int x, y, z;
            x = event.player.getPosition().getX();
            y = event.player.getPosition().getY();
            z = event.player.getPosition().getZ();
            Iterable<BlockPos> it = BlockPos.getAllInBox(x - 3, y - 3, z - 3, x + 3, y + 3, z + 3);
            PotionEffect effect = event.player.getActivePotionEffect(MobEffects.FIRE_RESISTANCE);
            for (BlockPos pos : it) {
                IBlockState state = event.player.world.getBlockState(pos);
                if (state.getMaterial() == Material.LAVA) {

                    if (event.player.world.getTotalWorldTime() % 1600 == 0) {

                        if(!event.player.isImmuneToFire())
                        {
                            event.player.setFire(4);
                            event.player.attackEntityFrom(DamageSource.GENERIC, 2.0F);
                        }
                        if(effect != null && effect.getAmplifier() == 0) {
                            event.player.attackEntityFrom(DamageSource.GENERIC, 1.0F);
                        }
                        if(effect != null && effect.getAmplifier() == 1) {
                            event.player.attackEntityFrom(DamageSource.GENERIC, 0.5F);
                        }
                    }
                }
                if (state.getBlock() == ModBlocks.HOT_LAVA_FLUID) {
                    if (event.player.world.getTotalWorldTime() % 800 == 0) {
                        if(!event.player.isImmuneToFire())
                        {
                            event.player.setFire(6);
                            event.player.attackEntityFrom(DamageSource.GENERIC, 4.0F);
                        }
                        if(effect != null && effect.getAmplifier() == 0) {
                            event.player.attackEntityFrom(DamageSource.GENERIC, 2.0F);
                        }
                        if(effect != null && effect.getAmplifier() == 1) {
                            event.player.attackEntityFrom(DamageSource.GENERIC, 1.0F);
                        }
                    }
                }
                if (state.getBlock() == ModBlocks.CORE_LAVA_FLUID) {
                    if (event.player.world.getTotalWorldTime() % 400 == 0) {
                        if(!event.player.isImmuneToFire())
                        {
                            event.player.setFire(8);
                            event.player.attackEntityFrom(DamageSource.GENERIC, 8.0F);
                        }
                        if(effect != null && effect.getAmplifier() == 0) {
                            event.player.attackEntityFrom(DamageSource.GENERIC, 4.0F);
                        }
                        if(effect != null && effect.getAmplifier() == 1) {
                            event.player.attackEntityFrom(DamageSource.GENERIC, 2.0F);
                        }
                    }
                }
                if (state.getBlock() == ModBlocks.ONYX_LAVA_FLUID) {
                    if (event.player.world.getTotalWorldTime() % 200 == 0) {
                        if(!event.player.isImmuneToFire())
                        {
                            event.player.setFire(8);
                            event.player.attackEntityFrom(DamageSource.GENERIC, 12.0F);
                        }
                        if(effect != null && effect.getAmplifier() == 0) {
                            event.player.attackEntityFrom(DamageSource.GENERIC, 8.0F);
                        }
                        if(effect != null && effect.getAmplifier() == 1) {
                            event.player.attackEntityFrom(DamageSource.GENERIC, 4.0F);
                        }
                    }
                }
            }

            /*
             */


            if (event.player.posY > -1500 && event.player.posY < -1000) {
                if (event.player.world.getTotalWorldTime() % 1000 == 0) {

                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(4);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.5F);
                    }
                }
            }
            if (event.player.posY > -2000 && event.player.posY < -1501) {
                if (event.player.world.getTotalWorldTime() % 833 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(4);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 1);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.25F);
                    }
                }
            }
            if (event.player.posY > -2500 && event.player.posY < -2001) {
                if (event.player.world.getTotalWorldTime() % 694 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 1.5F);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.375F);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.1875F);
                    }
                }
            }
            if (event.player.posY > -3000 && event.player.posY < -2501) {
                if (event.player.world.getTotalWorldTime() % 578 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 2);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.5F);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.25F);
                    }
                }
            }
            if (event.player.posY > -3500 && event.player.posY < -3001) {
                if (event.player.world.getTotalWorldTime() % 482 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 2.5F);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.625F);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.312F);
                    }
                }
            }
            if (event.player.posY > -4000 && event.player.posY < -3501) {
                if (event.player.world.getTotalWorldTime() % 401 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 3);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.75F);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.375F);
                    }
                }
            }
            if (event.player.posY > -4500 && event.player.posY < -4001) {
                if (event.player.world.getTotalWorldTime() % 334 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 3.5F);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.875F);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.4375F);
                    }
                }
            }
            if (event.player.posY > -5000 && event.player.posY < -4501) {
                if (event.player.world.getTotalWorldTime() % 239 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 4);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 1.0F);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.5F);
                    }
                }
            }
            if (event.player.posY > -5500 && event.player.posY < -5001) {
                if (event.player.world.getTotalWorldTime() % 170 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 4.5F);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 1.125F);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.5625F);
                    }
                }
            }
            if (event.player.posY > -6000 && event.player.posY < -5501) {
                if (event.player.world.getTotalWorldTime() % 122 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 5);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 1.25F);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.625F);
                    }
                }
            }
            if (event.player.posY > -7000 && event.player.posY < -6001) {
                if (event.player.world.getTotalWorldTime() % 100 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 5.5F);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 1.375F);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.6875F);
                    }
                }
            }
            if (event.player.posY > -8000 && event.player.posY < -7001) {
                if (event.player.world.getTotalWorldTime() % 90 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(4);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 6);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 1.5F);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.75F);
                    }
                }
            }
            if (event.player.posY > -8000 && event.player.posY < -7001) {
                if (event.player.world.getTotalWorldTime() % 80 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 6.5F);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 1.625F);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.8125F);
                    }
                }
            }
            if (event.player.posY > -9000 && event.player.posY < -8001) {
                if (event.player.world.getTotalWorldTime() % 70 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 7);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 1.75F);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.875F);
                    }
                }
            }
            if (event.player.posY > -10000 && event.player.posY < -9001) {
                if (event.player.world.getTotalWorldTime() % 60 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 7.5F);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 1.875F);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.9375F);
                    }
                }
            }
            if (event.player.posY > -100000 && event.player.posY < -10001) {
                if (event.player.world.getTotalWorldTime() % 50 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 8);
                    }
                    if(effect != null && effect.getAmplifier() == 0) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 2.0F);
                    }
                    if(effect != null && effect.getAmplifier() == 1) {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 1.0F);
                    }
                }
            }

            // HotBlaze damages you when nearby
            if (event.player.world.getTotalWorldTime() % 400 == 0){
                Main.LOGGER.debug("doing hot blaze fire");

                World world = event.player.world;
                Vec3d pos = event.player.getPositionVector();
                double range = 3;
                List<EntityHotBlaze> blazes = world.getEntitiesWithinAABB(EntityHotBlaze.class, new AxisAlignedBB(pos.x + range, pos.y + range, pos.z + range, pos.x - range, pos.y - range, pos.z - range));

                if (blazes.size() > 0){
                    if(!event.player.isImmuneToFire())
                    {
                        event.player.setFire(4);
                        event.player.attackEntityFrom(DamageSource.GENERIC, 4.0F);
                    }
                    if(effect != null && effect.getAmplifier() == 0)
                    {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 1.0F);
                    }
                    if(effect != null && effect.getAmplifier() == 1)
                    {
                        event.player.attackEntityFrom(DamageSource.GENERIC, 0.5F);
                    }
                }
            }
        }
    }


}