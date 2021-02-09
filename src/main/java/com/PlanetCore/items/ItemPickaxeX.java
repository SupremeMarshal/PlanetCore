package com.PlanetCore.items;

import net.minecraft.item.ItemPickaxe;
/**
* needed because PickaxeItem's constructor is protected
 */
public class ItemPickaxeX extends ItemPickaxe {
    public ItemPickaxeX(ToolMaterial material) {
        super(material);
    }
}
