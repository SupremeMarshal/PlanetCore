package com.PlanetCore.blocks;

public enum PlanetHardness {
    PAINITE_SUPERCOMPACT(16000),
    ONYX_SUPERCOMPACT(8000),
    AMAZONITE_SUPERCOMPACT(4000),
    MAJORITE_SUPERCOMPACT(2000),
    SAPPHIRE_SUPERCOMPACT(1200),
    RUBY_SUPERCOMPACT(800),
    TUNGSTEN_SUPERCOMPACT(400),
    URANIUM_SUPERCOMPACT(300),
    TITANIUM_SUPERCOMPACT(200),
    EMERALD_SUPERCOMPACT(100.0F),
    DIAMOND_SUPERCOMPACT(100.0F),
    GOLD_SUPERCOMPACT(50F),
    SILVER_SUPERCOMPACT(50F),
    IRON_SUPERCOMPACT(50F),
    LAPIS_SUPERCOMPACT(10F),
    REDSTONE_SUPERCOMPACT(10F),
    SULFUR_SUPERCOMPACT(10F),
    COAL_SUPERCOMPACT(10F),

    PAINITE_COMPACT(303),
    ONYX_COMPACT(202),
    AMAZONITE_COMPACT(135),
    MAJORITE_COMPACT(90),
    SAPPHIRE_COMPACT(60),
    RUBY_COMPACT(40),
    TUNGSTEN_COMPACT(21),
    URANIUM_COMPACT(15),
    TITANIUM_COMPACT(15),
    EMERALD_COMPACT(10.0F),
    DIAMOND_COMPACT(10.0F),
    GOLD_COMPACT(5F),
    SILVER_COMPACT(5F),
    IRON_COMPACT(5F),
    LAPIS_COMPACT(5F),
    REDSTONE_COMPACT(5F),
    SULFUR_COMPACT(4.5F),
    COAL_COMPACT(4.5F),

    PAINITE(202),
    PAINITE_SMALL(135),
    ONYX(135),
    ONYX_SMALL(90),
    AMAZONITE(90),
    MAJORITE(60),
    SAPPHIRE(40),
    RUBY(21),
    TUNGSTEN(15),
    URANIUM(10),
    TITANIUM(10),
    EMERALD(5.0F),
    DIAMOND(5.0F),
    GOLD(5.0F),
    SILVER(3.5F),
    IRON(3.5F),
    LAPIS(3),
    REDSTONE(3),
    SULFUR(2),
    HOT_ROCK(10),
    COAL(0.5F);

    public final float hardness;

    PlanetHardness(float hardness) {
        this.hardness = hardness;
    }
}