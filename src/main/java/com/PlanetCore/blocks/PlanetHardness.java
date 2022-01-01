package com.PlanetCore.blocks;

public enum PlanetHardness {
    PAINITE(100000),
    ONYX(25000),
    AMAZONITE(10000),
    MAJORITE(5000),
    BRIGMANITE(3000),
    RINGWOODITE(2500),
    WADSLEYITE(2000),
    OLIVINE(1500),
    DIAMOND(1000),
    SAPPHIRE(300),
    RUBY(200),
    EMERALD(100),
    TUNGSTEN(50),
    URANIUM(32),
    TITANIUM(24),
    PLATINUM(16),
    GOLD(12),
    SILVER(6),
    COPPER(4),
    TIN(4),
    IRON(3),
    ALUMINIUM(2),
    COAL(0),
    LAPIS(5),
    REDSTONE(5),
    SULFUR(1);

    public final float hardness;

    PlanetHardness(float hardness) {
        this.hardness = hardness;
    }
}