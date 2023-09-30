package com.PlanetCore.util.handlers;

import com.PlanetCore.util.Reference;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.entity.monster.EntityGhast;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid= Reference.MOD_ID)
public class EntitySpawnHandler {

    @SubscribeEvent
    public void onCheckSpawn(LivingSpawnEvent.CheckSpawn cs) {
        double y = cs.getY();
        EntityLivingBase entity = cs.getEntityLiving();
        Class<? extends EntityLivingBase> clazz = entity.getClass();

        /*
        if (clazz.equals(EntityGhast.class)) {
            cs.setResult((y > -1000 && y < 0) ? Event.Result.DEFAULT : Event.Result.DENY);
        } else
         */
        if (clazz.equals(EntityMagmaCube.class) && y < -64) {
            cs.setResult(Event.Result.ALLOW);
        } else if (clazz == EntitySlime.class) {
            cs.setResult(y > -256 ? Event.Result.DEFAULT : Event.Result.DENY);
        } else if ((!entity.isImmuneToFire() && y < 0) ||
                (y < 0 && entity.isCreatureType(EnumCreatureType.CREATURE, true)))
            cs.setResult(Event.Result.DENY);
        else
            cs.setResult(Event.Result.DEFAULT);
    }


    //private static final Biome.SpawnListEntry GHAST = new Biome.SpawnListEntry(EntityGhast.class, 50, 4, 4);

    //ghasts are not a default overworld spawn
//    @SubscribeEvent
//    public static void addSpawns(WorldEvent.PotentialSpawns e) {
//        World world = e.getWorld();
//        if (world.provider.getDimension() == 0 && e.getPos().getY() < 0) { //overworld only
//            e.getList().add(GHAST);
//        }
//    }
}
