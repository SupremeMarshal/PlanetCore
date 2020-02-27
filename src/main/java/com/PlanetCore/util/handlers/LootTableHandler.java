package com.SupremeMarshal.ToTheEarthCore.util.handlers;

import com.SupremeMarshal.ToTheEarthCore.util.Reference;

import net.minecraft.util.ResourceLocation;
import net.minecraft.world.storage.loot.LootTableList;

public class LootTableHandler {
	
	public static final ResourceLocation DEMON = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "demon"));
	public static final ResourceLocation BLACK_DEMON = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "black_demon"));
	public static final ResourceLocation HELLHOUND = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "hellhound"));
	public static final ResourceLocation DEATH_ENDERMAN = LootTableList.register(new ResourceLocation(Reference.MOD_ID, "death_enderman"));

}
