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
        else if (Y <= 0 && Y > -4096) {
            event.setDensity(-0.00002197265625F * Y);
        }
        else if (Y <= -4096) {
            event.setDensity(0.09F);
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
                //black to green
            } else if (Y < 0 && Y > -1024) {
                event.setRed(0.0F);
                event.setGreen(0.0F - 0.00042119140625F * Y);
                event.setBlue(0.0F - 0.00016083984375F * Y);
            } else if (Y <= -1024 && Y > -1536) {
                // green to blue-green
                event.setRed(0.0F - 0.00016083984375F * (Y + 1024));
                event.setGreen(0.4313F + 0.000336875F * (Y + 1024));
                event.setBlue(0.1647F - 0.000367578125F * (Y + 1024));
            } else if (Y <= -1536 && Y > -2048) {
                // blue-green to purple
                event.setRed(0.08235F - 0.000367578125F * (Y + 1536));
                event.setGreen(0.25882F + 0.00036F * (Y + 1536));
                event.setBlue(0.3529F + 0.000023046875F * (Y + 1536));
            } else if (Y <= -2048 && Y > -2560) {
                // purple to dark purple
                event.setRed(0.2509F + 0.0001072265625F * (Y + 2048));
                event.setGreen(0.0745F + 0.0000153125F * (Y + 2048));
                event.setBlue(0.3411F + 0.0004517578125F * (Y + 2048));
            } else if (Y <= -2560 && Y > -3072) {
                // dark purple to dark red
                event.setRed(0.196F - 0.00012265625F * (Y + 2560));
                event.setGreen(0.06666F + 0.000007734375F * (Y + 2560));
                event.setBlue(0.1098F + 0.000214453125F * (Y + 2560));
            } else if (Y <= -3072 && Y > -3584) {
                // dark red to red
                event.setRed(0.2588F - 0.0007658203125F * (Y + 3072));
                event.setGreen(0.0627F + 0.0000076171875F * (Y + 3072));
                event.setBlue(0.0F);
            } else if (Y <= -3584 && Y > -4096) {
                // red to yellow
                event.setRed(0.6509F - 0.0006818359375F * (Y + 3584));
                event.setGreen(0.0588F - 0.00183828125F * (Y + 3584));
                event.setBlue(0.0F);
            } else if (Y <= -4096 && Y > -4608) {
                // yellow to white-blue
                event.setRed(1.0F + 0.00078125F * (Y + 4096));
                event.setGreen(1.0F + 0.00078125F * (Y + 4096));
                event.setBlue(0.0F - 0.001953125F * (Y + 4096));
            }
            else if (Y <= -4608 && Y > -6080) {
                // white-blue to dark-blue
                event.setRed(0.6F + 0.000611413F * (Y + 4608));
                event.setGreen(0.6F + 0.000611413F * (Y + 4608));
                event.setBlue(1.0F - 0.000203804F * (Y + 4608));
            }
            else if (Y <= -6080) {
                // dark-blue
                event.setRed(0.1F);
                event.setGreen(0.1F);
                event.setBlue(0.3F);
            }
        }
    }
}