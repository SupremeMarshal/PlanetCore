package com.PlanetCore.util.handlers;

import com.PlanetCore.util.Reference;
import net.minecraft.entity.EnumCreatureType;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid= Reference.MOD_ID)
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
