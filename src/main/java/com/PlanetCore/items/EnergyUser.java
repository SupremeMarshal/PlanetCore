package com.PlanetCore.items;

import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

import java.util.List;

public interface EnergyUser {

    String ENERGY = "Energy";

    int getCapacity();
    int getTransfer();
    default int getStoredEnergy(ItemStack stack) {
        return stack.hasTagCompound() ? stack.getTagCompound().getInteger(ENERGY) : 0;
    }

    default void setStoredEnergy(ItemStack stack,int amount) {
        if (!stack.hasTagCompound())stack.setTagCompound(new NBTTagCompound());
        stack.getTagCompound().setInteger(ENERGY, amount);
    }

    default void addEnergyTooltip(ItemStack stack, List<String> tooltip) {
        tooltip.add(getStoredEnergy(stack) + "/"+getCapacity() + " FE");
    }

    void consumeEnergy(ItemStack stack,int amount);

}
