package com.PlanetCore.util.handlers;


import net.minecraftforge.event.terraingen.OreGenEvent;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class WorldgenHandler {
    @SubscribeEvent
    public void noDiamonds(OreGenEvent.GenerateMinable e) {
        if (e.getType() == OreGenEvent.GenerateMinable.EventType.DIAMOND) {
            e.setResult(Event.Result.DENY);
        }
    }
}
