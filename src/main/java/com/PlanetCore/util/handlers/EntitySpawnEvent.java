package com.PlanetCore.util.handlers;

import com.PlanetCore.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.ForgeRegistry;

@Mod.EventBusSubscriber(modid= Reference.MOD_ID)
public class EntitySpawnEvent {

    @SubscribeEvent
    public void onCheckSpawnClient(LivingSpawnEvent.CheckSpawn cs) {
        if (cs.getEntity().getClass().equals(EntityMagmaCube.class) && cs.getEntity().posY < -64) {
            cs.setResult(Event.Result.ALLOW);
        } else if ((!cs.getEntity().isImmuneToFire() && cs.getEntity().getPosition().getY() < 0) || (cs.getEntity().posY < 0 && cs.getEntity().isCreatureType(EnumCreatureType.CREATURE, true)))
            cs.setResult(Event.Result.DENY);
        else
            cs.setResult(Event.Result.DEFAULT);

    }
}
