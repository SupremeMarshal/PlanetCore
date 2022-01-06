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
    DIAMOND(ModItems.DIAMOND),
    SAPPHIRE(ModItems.SAPPHIRE),
    RUBY(ModItems.RUBY),
    EMERALD(ModItems.EMERALD),
    TUNGSTEN(ModItems.TUNGSTEN_ORE),
    URANIUM(ModItems.URANIUM_ORE),
    TITANIUM(ModItems.TITANIUM_ORE),
    PLATINUM(ModItems.PLATINUM_ORE),
    GOLD(ModItems.GOLD_ORE),
    SILVER(ModItems.SILVER_ORE),
    COPPER(ModItems.COPPER_ORE),
    TIN(ModItems.TIN_ORE),
    IRON(ModItems.IRON_ORE),
    ALUMINIUM(ModItems.ALUMINIUM_ORE),
    COAL(Items.COAL),
    LAPIS(Items.DYE),
    REDSTONE(Items.REDSTONE),
    SULFUR(ModItems.SULFUR),

    PAINITE_SMALL(ModItems.PAINITE_SHARD),
    ONYX_SMALL(ModItems.ONYX_SHARD),
    AMAZONITE_SMALL(ModItems.AMAZONITE_SHARD),
    MAJORITE_SMALL(ModItems.MAJORITE_SHARD),
    BRIGMANITE_SMALL(ModItems.BRIGMANITE_SHARD),
    RINGWOODITE_SMALL(ModItems.RINGWOODITE_SHARD),
    WADSLEYITE_SMALL(ModItems.WADSLEYITE_SHARD),
    OLIVINE_SMALL(ModItems.OLIVINE_SHARD),
    DIAMOND_SMALL(ModItems.DIAMOND_SHARD),
    SAPPHIRE_SMALL(ModItems.SAPPHIRE_SHARD),
    RUBY_SMALL(ModItems.RUBY_SHARD),
    EMERALD_SMALL(ModItems.EMERALD_SHARD),
    TUNGSTEN_SMALL(ModItems.TUNGSTEN_SHARD),
    URANIUM_SMALL(ModItems.URANIUM_SHARD),
    TITANIUM_SMALL(ModItems.TITANIUM_SHARD),
    PLATINUM_SMALL(ModItems.PLATINUM_SHARD),
    GOLD_SMALL(ModItems.GOLD_SHARD),
    SILVER_SMALL(ModItems.SILVER_SHARD),
    COPPER_SMALL(ModItems.COPPER_SHARD),
    TIN_SMALL(ModItems.TIN_SHARD),
    IRON_SMALL(ModItems.IRON_SHARD),
    ALUMINIUM_SMALL(ModItems.ALUMINIUM_SHARD),
    COAL_SMALL(ModItems.COAL_BIT),
    LAPIS_SMALL(ModItems.LAPIS_SHARD),
    REDSTONE_SMALL(ModItems.REDSTONE_SHARD),
    SULFUR_SMALL(ModItems.SULFUR_SHARD),

    ONYX_GRAVEL(ModItems.BLADED_ONYX),
    AMAZONITE_GRAVEL(ModItems.BLADED_AMAZONITE),
    MAJORITE_GRAVEL(ModItems.BLADED_MAJORITE),
    BRIGMANITE_GRAVEL(ModItems.BLADED_BRIGMANITE),
    RINGWOODITE_GRAVEL(ModItems.BLADED_RINGWOODITE),
    WADSLEYITE_GRAVEL(ModItems.BLADED_WADSLEYITE),
    OLIVINE_GRAVEL(ModItems.BLADED_OLIVINE),
    DIAMOND_GRAVEL(ModItems.BLADED_DIAMOND),
    SAPPHIRE_GRAVEL(ModItems.BLADED_SAPPHIRE),
    RUBY_GRAVEL(ModItems.BLADED_RUBY),
    EMERALD_GRAVEL(ModItems.BLADED_EMERALD);

    public final Item droppedItem;

    PlanetMaterial(Item droppedItem) {
        this.droppedItem = droppedItem;
    }
}