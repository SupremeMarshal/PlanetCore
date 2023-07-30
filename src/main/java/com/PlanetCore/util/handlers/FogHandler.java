package com.PlanetCore.util.handlers;

import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class FogHandler {


    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)

    public void onEvent(EntityViewRenderEvent.FogDensity event) {
        Entity p = event.getEntity();
        String worldType = p.getEntityWorld().getWorldType().getName();
        if (worldType != "PlanetCore") {
            event.setCanceled(false);
        } else event.setCanceled(true);
        float Y = (float) p.posY;
        if (worldType == "PlanetCore") {
            Block block = p.getEntityWorld().getBlockState(new BlockPos(p.posX, p.posY + p.getEyeHeight(), p.posZ)).getBlock();
            Material material = p.getEntityWorld().getBlockState(new BlockPos(p.posX, p.posY + p.getEyeHeight(), p.posZ)).getMaterial();
            if (material == Material.LAVA) {
                event.setDensity(1.5F);
            } else if (block == Blocks.WATER || block == Blocks.FLOWING_WATER || block == Blocks.WATERLILY) {
                event.setDensity(0.2F);
            } else if (Y > 0) {
                event.setDensity(0.00003F);
            } else if (Y <= 0 && Y > -2048) {
                event.setDensity(-0.0000439453125F * Y);
            } else if (Y <= -2048) {
                event.setDensity(0.09F);
            }


        }
    }


    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
    public void onEvent(EntityViewRenderEvent.FogColors event) {
        Entity p = event.getEntity();
        String worldType = p.getEntityWorld().getWorldType().getName();
        if (worldType == "PlanetCore") {
            float Y = (float) event.getEntity().posY;
            Block block = p.getEntityWorld().getBlockState(new BlockPos(p.posX, p.posY + p.getEyeHeight(), p.posZ)).getBlock();
            if (Y < 0) {
                if (block == Blocks.LAVA || block == Blocks.FLOWING_LAVA) {
                    event.setRed(1.0F);
                    event.setGreen(0.75F);
                    event.setBlue(0.25F);
                } else if (block == ModBlocks.IRON_LAVA_FLUID) {
                    event.setRed(1.0F);
                    event.setGreen(0.85F);
                    event.setBlue(0.0F);
                } else if (block == ModBlocks.ONYX_LAVA_FLUID) {
                    event.setRed(0.0F);
                    event.setGreen(0.0F);
                    event.setBlue(0.3F);
                } else if (block == Blocks.WATER || block == Blocks.WATERLILY || block == Blocks.FLOWING_WATER) {
                    event.setRed(0.1F);
                    event.setGreen(0.15F);
                    event.setBlue(0.80F);

                    /** color fog
                     green
                     0
                     0.4313
                     0.1647

                     blue-green
                     0.08235
                     0.25882
                     0.3529

                     purple
                     0.2509
                     0.0745
                     0.3411

                     dark-purple
                     0.196
                     0.06666
                     0.1098

                     dark-red
                     0.2588
                     0.0627
                     0.0

                     red
                     0.6509
                     0.0588
                     0.0

                     yellow
                     1.0
                     1.0
                     0.0


                     */
                    //black to red
                } else if (Y < 0 && Y > -512) {
                    event.setRed(0.0F - (1/512F) * Y);
                    event.setGreen(0.0F);
                    event.setBlue(0.0F);
                } else if (Y <= -512 && Y > -2048) {
                    // green to blue-green
                    event.setRed(1.0F);
                    event.setGreen(0.0F - ((1/1536F) * (Y + 512)));
                    event.setBlue(0.0F);// - 0.000367578125F * 2 * (Y + 512));
                }
                else if (Y <= -2048 && Y > -2500) {
                    // blue-green to purple
                    event.setRed(1F);
                    event.setGreen(1F);
                    event.setBlue(0.0F - (1/452F) * (Y + 2048));
                }
            }
        }
    }
}