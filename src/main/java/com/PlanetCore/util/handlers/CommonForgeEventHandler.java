package com.PlanetCore.util.handlers;

import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid="planetcore")
public class CommonForgeEventHandler {

    @SubscribeEvent
    public static void onBreakEvent(PlayerEvent.BreakSpeed event)
    {
        float breakTime = (event.getState().getBlockHardness(event.getEntityPlayer().world, event.getPos()) *1.5F) / event.getOriginalSpeed();
        if (breakTime > 8.0F) {
            event.setCanceled(true);
        }

        if (breakTime <= 0.1F) {
            event.setNewSpeed(event.getOriginalSpeed()/(0.1F/breakTime));
        }
    }
}