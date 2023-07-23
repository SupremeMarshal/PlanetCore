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
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.ArrayList;
import java.util.Iterator;

public class EntityInit 
{

	public static void registerEntities()
	{
		registerEntity("corefireball", EntityCoreFireball.class, ModConfiguration.ENTITY_COREFIREBALL_ID, 50, 11437146, 000000);
		registerEntity("corelargefireball", EntityCoreLargeFireball.class, ModConfiguration.ENTITY_CORELARGEFIREBALL_ID, 50, 11437146, 000000);
		registerEntity("onyxfireball", EntityOnyxFireball.class, ModConfiguration.ENTITY_ONYX_FIREBALL_ID, 50, 11437146, 000000);
		registerEntity("demon", EntityDemon.class, ModConfiguration.ENTITY_DEMON_ID, 50, 11437146, 000000);
		registerEntity("core_demon", EntityCoreDemon.class, ModConfiguration.ENTITY_CORE_DEMON_ID, 50, 11437146, 000000);
		registerEntity("onyx_demon", EntityOnyxDemon.class, ModConfiguration.ENTITY_ONYX_DEMON_ID, 50, 11437146, 000000);
		registerEntity("ghoul", EntityGhoul.class, ModConfiguration.ENTITY_GHOUL_ID, 50, 888888, 222222);
		registerEntity("hellhound", EntityHellHound.class, ModConfiguration.ENTITY_HELLHOUND_ID, 50, 666666, 000000);
		registerEntity("death_enderman", EntityDeathEnderman.class, ModConfiguration.ENTITY_DEATH_ENDERMAN_ID, 50, 666666, 000000);
		registerEntity("hot_blaze", EntityHotBlaze.class, ModConfiguration.ENTITY_HOT_BLASE_ID, 50, 999999, 000000);
		registerEntity("core_blaze", EntityCoreBlaze.class, ModConfiguration.ENTITY_CORE_BLASE_ID, 50, 999999, 999999);
		registerEntity("hot_magmacube", EntityHotMagmaCube.class, ModConfiguration.ENTITY_HOT_MAGMACUBE_ID, 50, 11437146, 000000);
		registerEntity("very_hot_magmacube", EntityVeryHotMagmaCube.class, ModConfiguration.ENTITY_VERY_HOT_MAGMACUBE_ID, 50, 11437146, 000000);
		registerArrow("diamond_arrow", EntityDiamondArrow.class, ModConfiguration.ENTITY_DIAMOND_ARROW_ID);
		registerArrow("topaz_arrow", EntityTopazArrow.class, ModConfiguration.ENTITY_TOPAZ_ARROW_ID);
		registerArrow("jade_arrow", EntityJadeArrow.class, ModConfiguration.ENTITY_JADE_ARROW_ID);
		registerArrow("ruby_arrow", EntityRubyArrow.class, ModConfiguration.ENTITY_RUBY_ARROW_ID);
		registerArrow("sapphire_arrow", EntitySapphireArrow.class, ModConfiguration.ENTITY_SAPPHIRE_ARROW_ID);
		registerArrow("olivine_arrow", EntityOlivineArrow.class, ModConfiguration.ENTITY_OLIVINE_ARROW_ID);
		registerArrow("wadsleyite_arrow", EntityWadsleyiteArrow.class, ModConfiguration.ENTITY_WADSLEYITE_ARROW_ID);
		registerArrow("ringwoodite_arrow", EntityRingwooditeArrow.class, ModConfiguration.ENTITY_RINGWOODITE_ARROW_ID);
		registerArrow("brigmanite_arrow", EntityBrigmaniteArrow.class, ModConfiguration.ENTITY_BRIGMANITE_ARROW_ID);
		registerArrow("majorite_arrow", EntityMajoriteArrow.class, ModConfiguration.ENTITY_MAJORITE_ARROW_ID);
		registerArrow("amazonite_arrow", EntityAmazoniteArrow.class, ModConfiguration.ENTITY_AMAZONITE_ARROW_ID);
		registerArrow("onyx_arrow", EntityOnyxArrow.class, ModConfiguration.ENTITY_ONYX_ARROW_ID);
		registerArrow("onyx_arrow_ii", EntityOnyxArrowII.class, ModConfiguration.ENTITY_ONYX_ARROW_II_ID);
		registerArrow("onyx_arrow_iii", EntityOnyxArrowIII.class, ModConfiguration.ENTITY_ONYX_ARROW_III_ID);
		registerArrow("onyx_arrow_iv", EntityOnyxArrowIV.class, ModConfiguration.ENTITY_ONYX_ARROW_IV_ID);
		registerArrow("onyx_arrow_v", EntityOnyxArrowV.class, ModConfiguration.ENTITY_ONYX_ARROW_V_ID);
	}

	private static void registerEntity(String name, Class<? extends Entity> entity, int id, int range, int color1, int color2)
	{
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID + ":" + name), entity, name, id, Main.instance, range, 1, true, color1, color2);
		Biome[] spawnBiomes = allbiomes(Biome.REGISTRY);
		EntityRegistry.addSpawn(EntityDemon.class, 80, 1, 6, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityCoreDemon.class, 1, 1, 1, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityOnyxDemon.class, 1, 1, 1, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityGhoul.class, 5, 1, 2, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityHellHound.class, 5, 1, 3, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityDeathEnderman.class, 1, 1, 1, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityHotBlaze.class, 5, 1, 3, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityCoreBlaze.class, 4, 1, 3, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityHotMagmaCube.class, 10, 2, 4, EnumCreatureType.MONSTER, spawnBiomes);
		EntityRegistry.addSpawn(EntityVeryHotMagmaCube.class, 10, 2, 4, EnumCreatureType.MONSTER, spawnBiomes);
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
	
}
