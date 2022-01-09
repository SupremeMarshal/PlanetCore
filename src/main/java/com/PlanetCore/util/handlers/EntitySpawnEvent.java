package com.PlanetCore.util.handlers;

import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod.EventBusSubscriber(modid="planetcore")
public class EntitySpawnEvent {

    @SubscribeEvent
    public void onCheckSpawnClient(LivingSpawnEvent.CheckSpawn cs)
    {
        if ((!cs.getEntity().isImmuneToFire() && cs.getEntity().getPosition().getY() < -1980) || (cs.getEntity().posY < 0 && cs.getEntity().isCreatureType(EnumCreatureType.CREATURE, true)))
            cs.setResult(Event.Result.DENY);
        else
            cs.setResult(Event.Result.DEFAULT);
    }

}
