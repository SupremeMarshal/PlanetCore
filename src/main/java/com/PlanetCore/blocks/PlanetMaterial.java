package com.PlanetCore.blocks;

import com.PlanetCore.init.ModItems;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public enum PlanetMaterial {
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
    SULFUR(ModItems.SULFUR);

    public final Item droppedItem;

    PlanetMaterial(Item droppedItem) {
        this.droppedItem = droppedItem;
    }
}