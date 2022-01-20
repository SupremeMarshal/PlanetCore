package com.PlanetCore.blocks;

public enum PlanetHardness {
    PAINITE(990),
    ONYX(760),
    AMAZONITE(550),
    MAJORITE(450),
    BRIGMANITE(290),
    RINGWOODITE(240),
    WADSLEYITE(190),
    OLIVINE(140),
    SAPPHIRE(90),
    RUBY(65),
    JADE(25),
    TUNGSTEN(20),
    TOPAZ(13.5F),
    URANIUM(10),
    TITANIUM(10),
    DIAMOND(8.5F),
    GOLD(7.5F),
    SILVER(6.5F),
    COPPER(4.5F),
    TIN(4.5F),
    IRON(4.5F),
    ALUMINIUM(3.5F),
    COAL(0.5F),
    LAPIS(3),
    EMERALD(8.5F),
    REDSTONE(3),
    SULFUR(2);

    public final float hardness;

    PlanetHardness(float hardness) {
        this.hardness = hardness;
    }
}