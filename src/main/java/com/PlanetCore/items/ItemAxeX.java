package com.PlanetCore.items;

import net.minecraft.item.ItemAxe;

/**
* needed because AxeItem's constructor is protected
 */
public class ItemAxeX extends ItemAxe {


    public ItemAxeX(ToolMaterial material) {
        //super(material); can't use this as it crashes vanilla;
        super(material,material.getAttackDamage(),material.getEfficiency());
    }

    public ItemAxeX(ToolMaterial material, float damage, float speed) {
        super(material, damage, speed);
    }
}
