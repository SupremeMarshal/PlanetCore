package com.PlanetCore.util.handlers;

import com.PlanetCore.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler {

	public static final ResourceLocation CORE_BLAZE = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "core_blaze"));
	public static final ResourceLocation HOT_BLAZE = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "hot_blaze"));
	public static final ResourceLocation DEMON = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "demon"));
	public static final ResourceLocation CORE_DEMON = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "core_demon"));
	public static final ResourceLocation ONYX_DEMON = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "onyx_demon"));
	public static final ResourceLocation HELLHOUND = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "hellhound"));
	public static final ResourceLocation HOT_MAGMACUBE = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "hot_magmacube"));
	public static final ResourceLocation DEATH_ENDERMAN = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "death_enderman"));

}
