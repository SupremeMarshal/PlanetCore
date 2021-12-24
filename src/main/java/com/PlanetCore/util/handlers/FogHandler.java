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
    @SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)

    public void onEvent(EntityViewRenderEvent.FogDensity event) {
        event.setCanceled(true);
        Entity p = event.getEntity();
        float Y = (float) p.posY;
        Block block = p.getEntityWorld().getBlockState(new BlockPos(p.posX, p.posY + p.getEyeHeight(), p.posZ)).getBlock();
        if (Y > 0) {
            event.setDensity(0.00003F);
        }
        else if (Y <= 0 && Y > -1024) {
            event.setDensity(-0.0000585F * Y);
        }
        else if (Y <= -1024 && Y > -4032) {
            event.setDensity(0.06F);
        }
        else if (Y <= -4032 && Y > -6080) {
            event.setDensity(0.06F - (0.0000585F * (Y + 4032)));
        }
        if (block instanceof BlockFluidBase) {
            if (block == Blocks.LAVA) {
                event.setDensity(0.5F);
            } else if (block == ModBlocks.IRON_LAVA_FLUID) {
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
        } else if (p.getEntityWorld().getBlockState(new BlockPos(p.posX, p.posY + p.getEyeHeight(), p.posZ)).getBlock() == ModBlocks.IRON_LAVA_FLUID) {
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
            if (Y < 0 && Y > -1024) {
                event.setRed(0.1F);
                event.setGreen(0.2F);
                event.setBlue(0.1F);
            } else if (Y <= -1024 && Y > -2048) {
                // green to Red color
                event.setRed(0.1F -0.00087890625F * (Y + 1024));
                event.setGreen(0.2F);
                event.setBlue(0.1F + (0.00009765625F * (Y + 1024)));
            } else if (Y <= -2048 && Y > -4096) {
                // red to yellow color
                event.setRed(1.0F);
                event.setGreen(0.2F -0.000390625F * (Y + 2048));
                event.setBlue(0.0F);
            } else if (Y <= -4096 && Y > -5120) {
                // yellow to white-blue
                event.setRed(1.0F + (0.0001953125F * (Y + 4096)));
                event.setGreen(1.0F + (0.0001953125F * (Y + 4096)));
                event.setBlue(0.0F - (0.0009765625F * (Y + 4096)));
            }
            else if (Y <= -5120 && Y > -6144) {
                // white-blue to dark blue
                event.setRed(0.8F + (0.00078125F * (Y + 5120)));
                event.setGreen(0.8F + (0.00078125F * (Y + 5120)));
                event.setBlue(1.0F + (0.00068359375F * (Y + 5120)));
            }
            else if (Y <= -6144) {
                // dark blue
                event.setRed(0F);
                event.setGreen(0F);
                event.setBlue(0.3F);
            }
        }
    }
}