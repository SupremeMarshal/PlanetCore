package com.PlanetCore.items;

import net.minecraft.item.ItemStack;

import java.util.List;

public interface EnergyUser {

    int getCapacity();
    int getTransfer();
    int getStoredEnergy(ItemStack stack);

    default void addEnergyTooltip(ItemStack stack, List<String> tooltip) {
        tooltip.add(getStoredEnergy(stack) + "/"+getCapacity() + " FE");
    }

    void consumeEnergy(ItemStack stack,int amount);

}
