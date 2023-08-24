package com.PlanetCore.blocks;

public enum PlanetHarvestLevel {
    PAINITE_COMPACT(11),
    ONYX_COMPACT(10),
    AMAZONITE_COMPACT(9),
    MAJORITE_COMPACT(8),
    SAPPHIRE_COMPACT(7),
    RUBY_COMPACT(6),
    TUNGSTEN_COMPACT(5),
    URANIUM_COMPACT(4),
    TITANIUM_COMPACT(4),
    EMERALD_COMPACT(3),
    DIAMOND_COMPACT(3),
    GOLD_COMPACT(2),
    SILVER_COMPACT(2),
    IRON_COMPACT(2),
    LAPIS_COMPACT(2),
    REDSTONE_COMPACT(3),
    SULFUR_COMPACT(2),
    COAL_COMPACT(1),

    PAINITE(10),
    ONYX(9),
    AMAZONITE(8),
    MAJORITE(7),
    SAPPHIRE(6),
    RUBY(5),
    TUNGSTEN(4),
    URANIUM(3),
    TITANIUM(3),
    EMERALD(2),
    DIAMOND(2),
    GOLD(2),
    SILVER(1),
    IRON(1),
    LAPIS(1),
    REDSTONE(2),
    SULFUR(1),
    HOT_ROCK(1),
    COAL(0);

    public final int harvestLevel;

    PlanetHarvestLevel(int harvestLevel) {
        this.harvestLevel = harvestLevel;
    }
}