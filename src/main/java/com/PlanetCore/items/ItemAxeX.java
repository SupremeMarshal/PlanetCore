package com.PlanetCore.items;

import net.minecraft.item.ItemAxe;

/**
* needed because AxeItem's constructor is protected
 */
public class ItemAxeX extends ItemAxe {


    public ItemAxeX(ToolMaterial material) {
        //super(material); can't use this as it crashes vanilla;
        super(material,material.getAttackDamage(),material.getEfficiency());
        this.attackDamage = material.getAttackDamage() * 1.4F;
        this.attackSpeed = -3F;
    }

    public ItemAxeX(ToolMaterial material, float damage, float speed) {
        super(material, damage, speed);
    }
}
