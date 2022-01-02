package com.PlanetCore.init;

import java.util.ArrayList;
import java.util.Iterator;

import com.PlanetCore.Main;
import com.PlanetCore.entity.*;
import com.PlanetCore.util.ModConfiguration;
import com.PlanetCore.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class EntityInit 
{

	public static void registerEntities()
	{
		registerEntity("flying_demon", EntityDemon.class, ModConfiguration.ENTITY_FLYING_DEMON_ID, 50, 11437146, 000000);
		//registerEntity("blackdemon", EntityDemon.class, ModConfiguration.ENTITY_BLACKDEMON_ID, 50, 999999, 000000);
		registerEntity("ghoul", EntityGhoul.class, ModConfiguration.ENTITY_GHOUL_ID, 50, 888888, 222222);
		registerEntity("hellhound", EntityHellHound.class, ModConfiguration.ENTITY_HELLHOUND_ID, 50, 666666, 000000);
		registerEntity("death_enderman", EntityDeathEnderman.class, ModConfiguration.ENTITY_DEATH_ENDERMAN_ID, 50, 666666, 000000);
		registerEntity("hot_blaze", EntityHotBlaze.class, ModConfiguration.ENTITY_HOT_BLASE_ID, 50, 999999, 000000);
		registerEntity("core_blaze", EntityCoreBlaze.class, ModConfiguration.ENTITY_CORE_BLASE_ID, 50, 999999, 999999);
	}

	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
		Biome[] spawnBiomes = allbiomes(Biome.REGISTRY);
		EntityRegistry.addSpawn(EntityDemon.class, 15, 2, 20, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityGhoul.class, 10, 1, 5, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityHellHound.class, 10, 1, 5, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityDeathEnderman.class, 1, 1, 2, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityHotBlaze.class, 20, 1, 2, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityCoreBlaze.class, 20, 1, 2, EnumCreatureType.MONSTER, spawnBiomes);
	}

	private static Biome[] allbiomes(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in)
	{

		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext())
			ls.add(itr.next());
		return ls.toArray(new Biome[ls.size()]);


	}
	
}
