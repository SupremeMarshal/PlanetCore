package com.PlanetCore.blocks;

import com.PlanetCore.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public enum PlanetMaterial {
    PAINITE(ModItems.PAINITE),
    ONYX(ModItems.ONYX),
    AMAZONITE(ModItems.AMAZONITE),
    MAJORITE(ModItems.MAJORITE),
    BRIGMANITE(ModItems.BRIGMANITE),
    RINGWOODITE(ModItems.RINGWOODITE),
    WADSLEYITE(ModItems.WADSLEYITE),
    OLIVINE(ModItems.OLIVINE),
    SAPPHIRE(ModItems.SAPPHIRE),
    RUBY(ModItems.RUBY),
    JADE(ModItems.JADE),
    TOPAZ(ModItems.TOPAZ),
    TUNGSTEN(ModItems.TUNGSTEN_ORE),
    URANIUM(ModItems.URANIUM_ORE),
    TITANIUM(ModItems.TITANIUM_ORE),
    DIAMOND(Items.DIAMOND),
    GOLD(ModItems.GOLD_ORE),
    SILVER(ModItems.SILVER_ORE),
    COPPER(ModItems.COPPER_ORE),
    TIN(ModItems.TIN_ORE),
    IRON(ModItems.IRON_ORE),
    ALUMINIUM(ModItems.ALUMINIUM_ORE),
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
    BRIGMANITE_GRAVEL(ModItems.BLADED_BRIGMANITE),
    RINGWOODITE_GRAVEL(ModItems.BLADED_RINGWOODITE),
    WADSLEYITE_GRAVEL(ModItems.BLADED_WADSLEYITE),
    OLIVINE_GRAVEL(ModItems.BLADED_OLIVINE),
    SAPPHIRE_GRAVEL(ModItems.BLADED_SAPPHIRE),
    RUBY_GRAVEL(ModItems.BLADED_RUBY),
    JADE_GRAVEL(ModItems.BLADED_JADE),
    TOPAZ_GRAVEL(ModItems.BLADED_TOPAZ),
    DIAMOND_GRAVEL(ModItems.BLADED_DIAMOND);

    public final Item droppedItem;

    PlanetMaterial(Item droppedItem) {
        this.droppedItem = droppedItem;
    }
}