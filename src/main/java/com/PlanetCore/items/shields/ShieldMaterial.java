package com.PlanetCore.items.shields;

public enum ShieldMaterial {

    ONYXV("ONYXV"),
    ONYXIV("ONYXIV"),
    ONYXIII("ONYXIII"),
    ONYXII("ONYXII"),
    ONYX("ONYX"),
    AMAZONITE("AMAZONITE"),
    MAJORITE("MAJORITE"),
    SAPPHIRE("SAPPHIRE"),
    RUBY("RUBY"),
    TUNGSTEN("TUNGSTEN"),
    URANIUM("URANIUM"),
    TITANIUM("TITANIUM"),
    DIAMOND("DIAMOND"),
    GOLD("GOLD"),
    SILVER("SILVER"),
    IRON("IRON");

    public String itemShield = null;

    ShieldMaterial(String ItemShield) {
        this.itemShield = itemShield;
    }
}
