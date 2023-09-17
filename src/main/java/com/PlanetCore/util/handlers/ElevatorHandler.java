package com.PlanetCore.util.handlers;

import com.PlanetCore.blocks.Powered_ladders.IronLadderBlock;
import com.PlanetCore.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ElevatorHandler {


    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) {
        // Check if the fall is happening within 1 second of the player leaving the elevator
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            if (player.world.getBlockState(player.getPosition()).getBlock() instanceof IronLadderBlock) {
                event.setCanceled(true); // Cancel the fall damage
            }
        }
    }
}





