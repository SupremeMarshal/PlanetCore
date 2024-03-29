package com.PlanetCore.blocks;

public enum PlanetExp {
    PAINITE_SUPERCOMPACT(52),
    ONYX_SUPERCOMPACT(48),
    AMAZONITE_SUPERCOMPACT(44),
    MAJORITE_SUPERCOMPACT(40),
    BRIGMANITE_SUPERCOMPACT(36),
    RINGWOODITE_SUPERCOMPACT(32),
    WADSLEYITE_SUPERCOMPACT(28),
    OLIVINE_SUPERCOMPACT(24),
    SAPPHIRE_SUPERCOMPACT(20),
    RUBY_SUPERCOMPACT(16),
    JADE_SUPERCOMPACT(12),
    TUNGSTEN_SUPERCOMPACT(12),
    TOPAZ_SUPERCOMPACT(12),
    URANIUM_SUPERCOMPACT(8),
    TITANIUM_SUPERCOMPACT(8),
    EMERALD_SUPERCOMPACT(8),
    DIAMOND_SUPERCOMPACT(8),
    GOLD_SUPERCOMPACT(4),
    SILVER_SUPERCOMPACT(4),
    COPPER_SUPERCOMPACT(2),
    TIN_SUPERCOMPACT(2),
    IRON_SUPERCOMPACT(2),
    ALUMINIUM_SUPERCOMPACT(2),
    LAPIS_SUPERCOMPACT(4),
    REDSTONE_SUPERCOMPACT(4),
    SULFUR_SUPERCOMPACT(4),
    COAL_SUPERCOMPACT(4),

    PAINITE_COMPACT(26),
    ONYX_COMPACT(24),
    AMAZONITE_COMPACT(22),
    MAJORITE_COMPACT(20),
    BRIGMANITE_COMPACT(18),
    RINGWOODITE_COMPACT(16),
    WADSLEYITE_COMPACT(14),
    OLIVINE_COMPACT(12),
    SAPPHIRE_COMPACT(10),
    RUBY_COMPACT(8),
    JADE_COMPACT(6),
    TUNGSTEN_COMPACT(6),
    TOPAZ_COMPACT(6),
    URANIUM_COMPACT(4),
    TITANIUM_COMPACT(4),
    EMERALD_COMPACT(4),
    DIAMOND_COMPACT(4),
    GOLD_COMPACT(2),
    SILVER_COMPACT(2),
    COPPER_COMPACT(1),
    TIN_COMPACT(1),
    IRON_COMPACT(1),
    ALUMINIUM_COMPACT(1),
    LAPIS_COMPACT(2),
    REDSTONE_COMPACT(2),
    SULFUR_COMPACT(2),
    COAL_COMPACT(2),

    PAINITE(13),
    ONYX(12),
    AMAZONITE(11),
    MAJORITE(10),
    BRIGMANITE(9),
    RINGWOODITE(8),
    WADSLEYITE(7),
    OLIVINE(6),
    SAPPHIRE(5),
    RUBY(4),
    JADE(3),
    TUNGSTEN(3),
    TOPAZ(3),
    URANIUM(2),
    TITANIUM(2),
    EMERALD(2),
    DIAMOND(2),
    GOLD(1),
    SILVER(1),
    COPPER(0),
    TIN(0),
    IRON(0),
    ALUMINIUM(0),
    LAPIS(1),
    REDSTONE(1),
    SULFUR(1),
    COAL(1);

    public final float exp;

    PlanetExp(float exp) {
        this.exp = exp;
    }
}