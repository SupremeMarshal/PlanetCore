package com.PlanetCore.init;

import com.PlanetCore.Main;
import com.PlanetCore.entity.*;
import com.PlanetCore.items.arrows.*;
import com.PlanetCore.util.ModConfiguration;
import com.PlanetCore.util.Reference;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EnumCreatureType;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.biome.Biome;
import net.minecraftforge.common.BiomeDictionary;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class EntityInit 
{

	public static void registerEntities()
	{
		register("corefireball", EntityCoreFireball.class, ModConfiguration.ENTITY_COREFIREBALL_ID, 50, 11437146, 000000);
		register("corelargefireball", EntityCoreLargeFireball.class, ModConfiguration.ENTITY_CORELARGEFIREBALL_ID, 50, 11437146, 000000);
		register("onyxfireball", EntityOnyxFireball.class, ModConfiguration.ENTITY_ONYX_FIREBALL_ID, 50, 11437146, 000000);
		register("demon", EntityDemon.class, ModConfiguration.ENTITY_DEMON_ID, 50, 11437146, 000000);
		register("core_demon", EntityCoreDemon.class, ModConfiguration.ENTITY_CORE_DEMON_ID, 50, 11437146, 000000);
		register("onyx_demon", EntityOnyxDemon.class, ModConfiguration.ENTITY_ONYX_DEMON_ID, 50, 11437146, 000000);
		register("ghoul", EntityGhoul.class, ModConfiguration.ENTITY_GHOUL_ID, 50, 888888, 222222);
		register("hellhound", EntityHellHound.class, ModConfiguration.ENTITY_HELLHOUND_ID, 50, 666666, 000000);
		register("death_enderman", EntityDeathEnderman.class, ModConfiguration.ENTITY_DEATH_ENDERMAN_ID, 50, 666666, 000000);
		register("hot_blaze", EntityHotBlaze.class, ModConfiguration.ENTITY_HOT_BLASE_ID, 50, 999999, 000000);
		register("core_blaze", EntityCoreBlaze.class, ModConfiguration.ENTITY_CORE_BLASE_ID, 50, 999999, 999999);
		register("hot_magmacube", EntityHotMagmaCube.class, ModConfiguration.ENTITY_HOT_MAGMACUBE_ID, 50, 11437146, 000000);
		register("very_hot_magmacube", EntityVeryHotMagmaCube.class, ModConfiguration.ENTITY_VERY_HOT_MAGMACUBE_ID, 50, 11437146, 000000);
		register("magma_zombie", EntityMagmaZombie.class, ModConfiguration.ENTITY_MAGMA_ZOMBIE_ID, 50, 11437146, 000000);
		registerArrow("diamond_arrow", EntityDiamondArrow.class, ModConfiguration.ENTITY_DIAMOND_ARROW_ID);
		registerArrow("ruby_arrow", EntityRubyArrow.class, ModConfiguration.ENTITY_RUBY_ARROW_ID);
		registerArrow("sapphire_arrow", EntitySapphireArrow.class, ModConfiguration.ENTITY_SAPPHIRE_ARROW_ID);
		registerArrow("majorite_arrow", EntityMajoriteArrow.class, ModConfiguration.ENTITY_MAJORITE_ARROW_ID);
		registerArrow("amazonite_arrow", EntityAmazoniteArrow.class, ModConfiguration.ENTITY_AMAZONITE_ARROW_ID);
		registerArrow("onyx_arrow", EntityOnyxArrow.class, ModConfiguration.ENTITY_ONYX_ARROW_ID);
		registerArrow("onyx_arrow_ii", EntityOnyxArrowII.class, ModConfiguration.ENTITY_ONYX_ARROW_II_ID);
		registerArrow("onyx_arrow_iii", EntityOnyxArrowIII.class, ModConfiguration.ENTITY_ONYX_ARROW_III_ID);
		registerArrow("onyx_arrow_iv", EntityOnyxArrowIV.class, ModConfiguration.ENTITY_ONYX_ARROW_IV_ID);
		registerArrow("onyx_arrow_v", EntityOnyxArrowV.class, ModConfiguration.ENTITY_ONYX_ARROW_V_ID);

	}

	public static void register(RegistryEvent.Register<EntityEntry> e) {
		EntityEntry nitrogenCooler = EntityEntryBuilder.create().entity(NitrogenCoolerEntity.class)
				.name("nitrogen_cooler").id("nitrogen_cooler",0).tracker(64, 1, true).build();
		e.getRegistry().register(nitrogenCooler);
	}

	private static void register(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
		Biome[] spawnBiomes = allbiomes(Biome.REGISTRY);
		EntityRegistry.addSpawn(EntityDemon.class, 6, 1, 3, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityDemon.class, 1, 1, 1, EnumCreatureType.MONSTER, getNetherBiome());
		EntityRegistry.addSpawn(EntityCoreDemon.class, 1, 1, 1, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityOnyxDemon.class, 1, 1, 1, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityGhoul.class, 5, 1, 2, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityHellHound.class, 5, 1, 3, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityHellHound.class, 8, 1, 3, EnumCreatureType.MONSTER, getNetherBiome());
		EntityRegistry.addSpawn(EntityDeathEnderman.class, 1, 1, 1, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityHotBlaze.class, 5, 1, 3, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityCoreBlaze.class, 4, 1, 3, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityHotMagmaCube.class, 10, 2, 4, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityVeryHotMagmaCube.class, 10, 2, 4, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityMagmaZombie.class, 20, 2, 8, EnumCreatureType.MONSTER, spawnBiomes);
	}

	private static void registerArrow(String name, Class<? extends Entity> entity, int id)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, 64, 20, true);
	}

	private static Biome[] allbiomes(net.minecraft.util.registry.RegistryNamespaced<ResourceLocation, Biome> in)
	{

		Iterator<Biome> itr = in.iterator();
		ArrayList<Biome> ls = new ArrayList<Biome>();
		while (itr.hasNext())
			ls.add(itr.next());
		return ls.toArray(new Biome[ls.size()]);


	}

	public static Biome getNetherBiome() {
		Set<Biome> netherBiomes = BiomeDictionary.getBiomes(BiomeDictionary.Type.NETHER);
		for (Biome biome : netherBiomes) {
			// Assuming you want the default Nether biome, which is usually called "hell"
			if (biome.getRegistryName().getPath().equals("hell")) {
				return biome;
			}
		}
		return null;
	}
}
