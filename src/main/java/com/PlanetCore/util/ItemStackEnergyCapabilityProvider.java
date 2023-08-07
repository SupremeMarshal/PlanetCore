package com.PlanetCore.util;

import com.PlanetCore.items.EnergyUser;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;

import javax.annotation.Nullable;

public class ItemStackEnergyCapabilityProvider<T extends Item & EnergyUser> implements ICapabilityProvider {

    public static final String ENERGY = "Energy";
    public final EnergyStorage storage;

    public ItemStackEnergyCapabilityProvider(final ItemStack stack, T item) {
        this.storage = new ItemStackEnergyStorage<>(stack,item);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        return this.getCapability(capability, facing) != null;
    }

    @Nullable
    @Override
    public <C> C getCapability(Capability<C> capability, EnumFacing facing) {
        if (capability == CapabilityEnergy.ENERGY) {
            return CapabilityEnergy.ENERGY.cast(this.storage);
        }
        return null;
    }

    public static class ItemStackEnergyStorage<T extends Item & EnergyUser> extends EnergyStorage {

        private final ItemStack stack;

        public ItemStackEnergyStorage(ItemStack stack, T item) {
            super(item.getCapacity(),item.getTransfer());
            this.energy = item.getStoredEnergy(stack);
            this.stack = stack;
        }

        @Override
        public int receiveEnergy(int maxReceive, boolean simulate) {
            int i = super.receiveEnergy(maxReceive, simulate);
            if (!simulate && i > 0) {
                saveToItem();
            }
            return i;
        }

        public void saveToItem() {
            if (!stack.hasTagCompound()) stack.setTagCompound(new NBTTagCompound());
            stack.getTagCompound().setInteger(ENERGY,energy);
        }

        @Override
        public int extractEnergy(int maxExtract, boolean simulate) {
            int i = super.extractEnergy(maxExtract, simulate);
            if (!simulate && i > 0) {
                saveToItem();
            }
            return i;
        }
    }
}
