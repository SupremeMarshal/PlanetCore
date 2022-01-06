package com.PlanetCore.blocks;

public enum PlanetHardness {
    PAINITE(1000000),
    ONYX(100000),
    AMAZONITE(50000),
    MAJORITE(33750),
    BRIGMANITE(22500),
    RINGWOODITE(15000),
    WADSLEYITE(10000),
    OLIVINE(7500),
    DIAMOND(5000),
    SAPPHIRE(3000),
    RUBY(2000),
    EMERALD(1000),
    TUNGSTEN(250),
    URANIUM(75),
    TITANIUM(50),
    PLATINUM(35),
    GOLD(22),
    SILVER(15),
    COPPER(5),
    TIN(5),
    IRON(3),
    ALUMINIUM(1),
    COAL(0),
    LAPIS(5),
    REDSTONE(5),
    SULFUR(1);

    public final float hardness;

    PlanetHardness(float hardness) {
        this.hardness = hardness;
    }
}