package com.PlanetCore.blocks;

import com.PlanetCore.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public enum PlanetMaterial {
    PAINITE(ModItems.PAINITE),
    ONYX(ModItems.ONYX),
    AMAZONITE(ModItems.AMAZONITE),
    MAJORITE(ModItems.MAJORITE),
    SAPPHIRE(ModItems.SAPPHIRE),
    RUBY(ModItems.RUBY),
    TUNGSTEN(ModItems.TUNGSTEN_ORE),
    URANIUM(ModItems.URANIUM_ORE),
    TITANIUM(ModItems.TITANIUM_ORE),
    DIAMOND(Items.DIAMOND),
    GOLD(ModItems.GOLD_ORE),
    SILVER(ModItems.SILVER_ORE),
    IRON(ModItems.IRON_ORE),
    COAL(Items.COAL),
    LAPIS(Items.DYE),
    EMERALD(Items.EMERALD),
    REDSTONE(Items.REDSTONE),
    SULFUR(ModItems.SULFUR),

    PAINITE_SMALL(ModItems.PAINITE_SHARD),
    ONYX_SMALL(ModItems.ONYX_SHARD),

    ONYX_GRAVEL(ModItems.BLADED_ONYX),
    AMAZONITE_GRAVEL(ModItems.BLADED_AMAZONITE),
    MAJORITE_GRAVEL(ModItems.BLADED_MAJORITE),
    SAPPHIRE_GRAVEL(ModItems.BLADED_SAPPHIRE),
    RUBY_GRAVEL(ModItems.BLADED_RUBY),
    DIAMOND_GRAVEL(ModItems.BLADED_DIAMOND);

    public final Item droppedItem;

    PlanetMaterial(Item droppedItem) {
        this.droppedItem = droppedItem;
    }
}