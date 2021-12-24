package com.PlanetCore.util.handlers;

import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
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
        Material material = p.getEntityWorld().getBlockState(new BlockPos(p.posX, p.posY + p.getEyeHeight(), p.posZ)).getMaterial();
        if (material == Material.LAVA) {
            event.setDensity(1.5F);
        }
        else if (block == Blocks.WATER || block == Blocks.FLOWING_WATER || block == Blocks.WATERLILY) {
            event.setDensity(0.2F);
        }
        else if (Y > 0) {
            event.setDensity(0.00003F);
        }
        else if (Y <= 0 && Y > -1024) {
            event.setDensity(-0.0000585F * Y);
        }
        else if (Y <= -1024) {
            event.setDensity(0.06F);
        }


    }


    @SideOnly(Side.CLIENT)
    @SubscribeEvent(priority = EventPriority.HIGH, receiveCanceled = true)
    public void onEvent(EntityViewRenderEvent.FogColors event) {
        Entity p = event.getEntity();
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
            } else if (block == ModBlocks.CORE_LAVA_FLUID) {
                event.setRed(0.6F);
                event.setGreen(1.0F);
                event.setBlue(1.0F);
            } else if (block == ModBlocks.ONYX_LAVA_FLUID) {
                event.setRed(0.0F);
                event.setGreen(0.0F);
                event.setBlue(0.3F);
            } else if (block == Blocks.WATER || block == Blocks.WATERLILY || block == Blocks.FLOWING_WATER) {
                event.setRed(0.1F);
                event.setGreen(0.15F);
                event.setBlue(0.80F);
            } else if (Y < 0 && Y > -1024) {
                event.setRed(0.1F);
                event.setGreen(0.2F);
                event.setBlue(0.1F);
            } else if (Y <= -1024 && Y > -2048) {
                // green to purple color
                event.setRed(0.1F -0.00087890625F * (Y + 1024));
                event.setGreen(0.2F +0.0001953125F * (Y + 1024));
                event.setBlue(0.1F - (0.000390625F * (Y + 1024)));
            } else if (Y <= -2048 && Y > -3072) {
                // purple to red color
                event.setRed(1.0F);
                event.setGreen(0.0F);
                event.setBlue(0.5F + (0.00048828125F * (Y + 2048)));
            } else if (Y <= -3072 && Y > -4096) {
                // red to yellow color
                event.setRed(1.0F);
                event.setGreen(0.0F -0.0009765625F * (Y + 3072));
                event.setBlue(0.0F);
            } else if (Y <= -4096 && Y > -5120) {
                // yellow to white-blue
                event.setRed(1.0F + (0.000390625F * (Y + 4096)));
                event.setGreen(1.0F + (0.000390625F * (Y + 4096)));
                event.setBlue(0.0F - (0.0009765625F * (Y + 4096)));
            }
            else if (Y <= -5120) {
                // white-blue
                event.setRed(0.6F);
                event.setGreen(0.6F);
                event.setBlue(1.0F);
            }
        }
    }
}