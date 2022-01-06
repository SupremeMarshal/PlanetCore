package com.PlanetCore.items.shields;

import com.PlanetCore.init.ModItems;
import net.minecraft.item.Item;


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
    DIAMOND("DIAMOND"),
    SAPPHIRE("SAPPHIRE"),
    RUBY("RUBY"),
    EMERALD("EMERALD"),
    TUNGSTEN_URANIUM("TUNGSTEN_URANIUM"),
    TUNGSTEN_TITANIUM("TUNGSTEN_TITANIUM"),
    TUNGSTEN("TUNGSTEN"),
    TITANIUM_URANIUM("TITANIUM_URANIUM"),
    URANIUM("URANIUM"),
    TITANIUM("TITANIUM"),
    PLATINUM("PLATINUM"),
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
