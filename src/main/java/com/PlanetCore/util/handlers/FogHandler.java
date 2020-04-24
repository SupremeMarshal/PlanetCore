package com.PlanetCore.util.handlers;

import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.EntityViewRenderEvent;
import net.minecraftforge.fluids.BlockFluidBase;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@EventBusSubscriber
public class FogHandler {


    /*@SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
    public void onEvent(EntityViewRenderEvent.FogDensity event) {
        Entity p = event.getEntity();
        double Y = p.posY;
        Block block = p.getEntityWorld().getBlockState(new BlockPos(p.posX, p.posY + p.getEyeHeight(), p.posZ)).getBlock();
        if (Y < 0) {
            if (Y < 0 && Y > -1000) {
                event.setDensity(0.01F);
            } else if (Y <= -1000 && Y > -14993) {
                event.setDensity(0.02F);
            } else if (Y <= -14993) {
                event.setDensity(0.1F);
            } else {
                //return;
                event.setDensity(0.001F);
            }
            event.setCanceled(true);
        } else if (block instanceof BlockFluidBase) {
            if (block == Blocks.LAVA) {
                event.setDensity(0.5F);
            } else if (block == ModBlocks.HOT_LAVA_FLUID) {
                event.setDensity(0.3F);
            } else if (block == ModBlocks.CORE_LAVA_FLUID) {
                event.setDensity(0.75F);
            } else if (block == Blocks.WATERLILY) {
                event.setDensity(0.1F);
            }
        }
    }


    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
    public void onEvent(EntityViewRenderEvent.FogColors event) {
        Entity p = event.getEntity();
        if (p.getEntityWorld().getBlockState(new BlockPos(p.posX, p.posY + p.getEyeHeight(), p.posZ)).getBlock() == Blocks.LAVA) {
            event.setRed(1.0F);
            event.setGreen(0.75F);
            event.setBlue(0.25F);
        } else if (p.getEntityWorld().getBlockState(new BlockPos(p.posX, p.posY + p.getEyeHeight(), p.posZ)).getBlock() == ModBlocks.HOT_LAVA_FLUID) {
            event.setRed(1.0F);
            event.setGreen(0.85F);
            event.setBlue(0.0F);
        } else if (p.getEntityWorld().getBlockState(new BlockPos(p.posX, p.posY + p.getEyeHeight(), p.posZ)).getBlock() == ModBlocks.CORE_LAVA_FLUID) {
            event.setRed(0.6F);
            event.setGreen(1.0F);
            event.setBlue(1.0F);
        } else if (p.getEntityWorld().getBlockState(new BlockPos(p.posX, p.posY + p.getEyeHeight(), p.posZ)).getBlock() == Blocks.WATERLILY) {
            event.setRed(0.1F);
            event.setGreen(0.15F);
            event.setBlue(0.80F);
        }
        double Y = event.getEntity().posY;
        if (Y < 0) {
            if (event.getEntity().posY < 0 && event.getEntity().posY > -4000) {
                event.setRed(0.9F);
                event.setGreen(0.0F);
                event.setBlue(0.0F);
            } else if (event.getEntity().posY <= -4000 && event.getEntity().posY > -6850) {
                // RED STARTING 0.48F at -4000Y, 0.99F at -6850Y
                event.setRed(1.0F);
                event.setGreen(0.1F);
                event.setBlue(0.001F);
            } else if (event.getEntity().posY <= -6850 && event.getEntity().posY > -9200) {
                // RED STARTING 0.99F at -6850Y, 0.0F at
                event.setRed(1.0F);
                event.setGreen(0.15F);
                event.setBlue(0.0F);
            } else if (event.getEntity().posY <= -9200 && event.getEntity().posY > -14993) {
                // RED STARTING 0.99F at -6850Y, 0.0F at
                event.setRed(0.99F);
                event.setGreen(0.99F);
                event.setBlue(0.2F);
            } else if (event.getEntity().posY <= -14993) {
                // RED STARTING 0.99F at -6850Y, 0.0F at
                event.setRed(0.50F);
                event.setGreen(1.0F);
                event.setBlue(1.0F);
            }
        }
    }

     */

}