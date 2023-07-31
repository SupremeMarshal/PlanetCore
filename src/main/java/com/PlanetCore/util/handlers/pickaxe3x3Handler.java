package com.PlanetCore.util.handlers;

import com.PlanetCore.init.ModItems;
import net.minecraft.block.Block;

import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingDestroyBlockEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid="planetcore")
public class pickaxe3x3Handler {

    @SubscribeEvent
    public static void onBreakEvent(BlockEvent.BreakEvent event) {
        Item pickaxe = event.getPlayer().getHeldItemMainhand().getItem();
        EnumFacing facing = EnumFacing.getDirectionFromEntityLiving(event.getPos(), event.getPlayer()).getOpposite();
        if (pickaxe == ModItems.RUBY_PICKAXE || pickaxe == ModItems.ONYX_V_PICKAXE)
        {
            if (facing == EnumFacing.DOWN) {
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().north(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().south(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().east(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().west(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().north().west(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().north().east(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().south().west(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().south().east(), true);
            }
            if (facing == EnumFacing.UP) {
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().north(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().south(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().east(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().west(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().north().west(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().north().east(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().south().west(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().south().east(), true);
            }
            if (facing == EnumFacing.EAST) {
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().up(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().down(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().north(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().south(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().up().north(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().down().north(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().up().south(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().down().south(), true);
            }
            if (facing == EnumFacing.WEST) {
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().up(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().down(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().north(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().south(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().up().north(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().down().north(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().up().south(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().down().south(), true);
            }
            if (facing == EnumFacing.NORTH) {
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().up(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().down(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().east(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().west(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().up().east(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().down().east(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().up().west(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().down().west(), true);
            }
            if (facing == EnumFacing.SOUTH) {
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().up(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().down(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().east(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().west(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().up().east(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().down().east(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().up().west(), true);
                event.getPlayer().getEntityWorld().destroyBlock(event.getPos().down().west(), true);
            }
        }
    }
    
    
}
