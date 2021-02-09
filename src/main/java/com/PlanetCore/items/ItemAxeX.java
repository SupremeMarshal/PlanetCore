package com.PlanetCore.items;

import net.minecraft.item.ItemAxe;

/**
* needed because AxeItem's constructor is protected
 */
public class ItemAxeX extends ItemAxe {
    public ItemAxeX(ToolMaterial material) {
        super(material);
    }

    public ItemAxeX(ToolMaterial material, float damage, float speed) {
        super(material, damage, speed);
    }
}
