package com.PlanetCore.items.shields;

public enum ShieldMaterial {

    ONYXV("ONYXV"),
    ONYXIV("ONYXIV"),
    ONYXIII("ONYXIII"),
    ONYXII("ONYXII"),
    ONYX("ONYX"),
    AMAZONITE("AMAZONITE"),
    MAJORITE("MAJORITE"),
    BRIGMANITE("BRIGMANITE"),
    RINGWOODITE("RINGWOODITE"),
    WADSLEYITE("WADSLEYITE"),
    OLIVINE("OLIVINE"),
    SAPPHIRE("SAPPHIRE"),
    RUBY("RUBY"),
    JADE("JADE"),
    TOPAZ("TOPAZ"),
    TUNGSTEN_TITANIUM("TUNGSTEN_TITANIUM"),
    TUNGSTEN("TUNGSTEN"),
    URANIUM("URANIUM"),
    TITANIUM("TITANIUM"),
    DIAMOND("DIAMOND"),
    GOLD("GOLD"),
    SILVER("SILVER"),
    BRONZE("BRONZE"),
    STEEL("STEEL"),
    TIN("TIN"),
    COPPER("COPPER"),
    IRON("IRON"),
    ALUMINIUM("ALUMINIUM");

    public String itemShield = null;

    ShieldMaterial(String ItemShield) {
        this.itemShield = itemShield;
    }
}
