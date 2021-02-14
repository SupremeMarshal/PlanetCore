package com.PlanetCore.util.handlers;

import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

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



            int x, y, z;
            x = event.player.getPosition().getX();
            y = event.player.getPosition().getY();
            z = event.player.getPosition().getZ();
            Iterable<BlockPos> it = BlockPos.getAllInBox(x - 4, y - 4, z - 4, x + 4, y + 4, z + 4);
                if (!event.player.isImmuneToFire()) {
                    for (BlockPos pos : it) {
                        IBlockState state = event.player.world.getBlockState(pos);
                        if (state.getMaterial() == Material.LAVA) {

                            if (event.player.world.getTotalWorldTime() % 400 == 0) {
                                event.player.setFire(5);
                                event.player.attackEntityFrom(DamageSource.LAVA, 2.0F);
                            }
                        }
                    }
                    for (BlockPos pos1 : it) {
                        IBlockState state1 = event.player.world.getBlockState(pos1);
                        if (state1.getBlock() == ModBlocks.HOT_LAVA_FLUID) {
                            if (event.player.world.getTotalWorldTime() % 200 == 0) {
                                event.player.setFire(15);
                                event.player.attackEntityFrom(DamageSource.LAVA, 6.0F);
                            }
                        }
                    }
                }


            if (event.player.posY > -1500 && event.player.posY < -1000) {
                if (event.player.world.getTotalWorldTime() % 1000 == 0) {

                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(4);
                    }
                    event.player.attackEntityFrom(DamageSource.LAVA, 0);
                }
            }
            if (event.player.posY > -2000 && event.player.posY < -1501) {
                if (event.player.world.getTotalWorldTime() % 833 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(4);
                    }
                    event.player.attackEntityFrom(DamageSource.LAVA, 1);
                }
            }
            if (event.player.posY > -2500 && event.player.posY < -2001) {
                if (event.player.world.getTotalWorldTime() % 694 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                    }
                    event.player.attackEntityFrom(DamageSource.LAVA, 2);
                }
            }
            if (event.player.posY > -3000 && event.player.posY < -2501) {
                if (event.player.world.getTotalWorldTime() % 578 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                    }
                    event.player.attackEntityFrom(DamageSource.LAVA, 3);
                }
            }
            if (event.player.posY > -3500 && event.player.posY < -3001) {
                if (event.player.world.getTotalWorldTime() % 482 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                    }
                    event.player.attackEntityFrom(DamageSource.LAVA, 4);
                }
            }
            if (event.player.posY > -4000 && event.player.posY < -3501) {
                if (event.player.world.getTotalWorldTime() % 401 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                    }
                    event.player.attackEntityFrom(DamageSource.LAVA, 5);
                }
            }
            if (event.player.posY > -4500 && event.player.posY < -4001) {
                if (event.player.world.getTotalWorldTime() % 334 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                    }
                    event.player.attackEntityFrom(DamageSource.LAVA, 6);
                }
            }
            if (event.player.posY > -5000 && event.player.posY < -4501) {
                if (event.player.world.getTotalWorldTime() % 239 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                    }
                    event.player.attackEntityFrom(DamageSource.LAVA, 6);
                }
            }
            if (event.player.posY > -5500 && event.player.posY < -5001) {
                if (event.player.world.getTotalWorldTime() % 170 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                    }
                    event.player.attackEntityFrom(DamageSource.LAVA, 7);
                }
            }
            if (event.player.posY > -6000 && event.player.posY < -5501) {
                if (event.player.world.getTotalWorldTime() % 122 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                    }
                    event.player.attackEntityFrom(DamageSource.LAVA, 7);
                }
            }
            if (event.player.posY > -7000 && event.player.posY < -6001) {
                if (event.player.world.getTotalWorldTime() % 100 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                    }
                    event.player.attackEntityFrom(DamageSource.LAVA, 8);
                }
            }
            if (event.player.posY > -8000 && event.player.posY < -7001) {
                if (event.player.world.getTotalWorldTime() % 100 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(4);
                    }
                    event.player.attackEntityFrom(DamageSource.LAVA, 8);
                }
            }
            if (event.player.posY > -8000 && event.player.posY < -7001) {
                if (event.player.world.getTotalWorldTime() % 100 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                    }
                    event.player.attackEntityFrom(DamageSource.LAVA, 9);
                }
            }
            if (event.player.posY > -9000 && event.player.posY < -8001) {
                if (event.player.world.getTotalWorldTime() % 100 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                    }
                    event.player.attackEntityFrom(DamageSource.LAVA, 10);
                }
            }
            if (event.player.posY > -10000 && event.player.posY < -9001) {
                if (event.player.world.getTotalWorldTime() % 100 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                    }
                    event.player.attackEntityFrom(DamageSource.LAVA, 11);
                }
            }
            if (event.player.posY > -100000 && event.player.posY < -10001) {
                if (event.player.world.getTotalWorldTime() % 100 == 0) {
                    if (!event.player.isImmuneToFire()) {
                        event.player.setFire(5);
                    }
                    event.player.attackEntityFrom(DamageSource.LAVA, 12);
                }
            }
        }
    }


}
