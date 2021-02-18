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


    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)

    public void onEvent(EntityViewRenderEvent.FogDensity event) {
        Entity p = event.getEntity();
        float Y = (float) p.posY;
        Block block = p.getEntityWorld().getBlockState(new BlockPos(p.posX, p.posY + p.getEyeHeight(), p.posZ)).getBlock();
        if (Y < 0) {
            if (Y < 0 && Y > -10000) {
                event.setDensity(-0.00025F * Y);
            } else if (Y <= -10000) {
                event.setDensity(0.5F);
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
        else event.setDensity(0.001F);
    }


    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
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
        float Y = (float) event.getEntity().posY;
        if (Y < 0) {
            if (Y < 0 && Y > -2000) {
                event.setRed(0.0F);
                event.setGreen(-0.0005F * Y);
                event.setBlue(-0.0001F * Y);
            } else if (Y <= -2000 && Y > -4000) {
                // RED STARTING 0.48F at -4000Y, 0.99F at -6850Y
                event.setRed(-0.0005F * Y);
                event.setGreen(1.0F + (0.0005F * (Y + 2000)));
                event.setBlue(0.2F + (0.0001F * (Y + 2000)));
            } else if (Y <= -4000 && Y > -6000) {
                // RED STARTING 0.99F at -6850Y, 0.0F at
                event.setRed(1.0F);
                event.setGreen(-0.0005F * (Y + 4000));
                event.setBlue(0.0F);
            } else if (Y <= -6000 && Y > -8000) {
                // RED STARTING 0.99F at -6850Y, 0.0F at
                event.setRed(1.0F);
                event.setGreen(1.0F);
                event.setBlue(-0.0001F * (Y + 6000));
            } else if (Y <= -8000 && Y > -10000) {
                // RED STARTING 0.99F at -6850Y, 0.0F at
                event.setRed(1.0F + (0.0002F * (Y + 8000)));
                event.setGreen(1.0F + (0.0002F * (Y + 8000)));
                event.setBlue(0.2F - (0.0004F * (Y + 8000)));
            }
            else if (Y <= -10000) {
                // RED STARTING 0.99F at -6850Y, 0.0F at
                event.setRed(0.6F);
                event.setGreen(0.6F);
                event.setBlue(1.0F);
            }
        }
    }
}