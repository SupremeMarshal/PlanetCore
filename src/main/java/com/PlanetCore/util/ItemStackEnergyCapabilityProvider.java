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
import net.minecraftforge.energy.IEnergyStorage;

import javax.annotation.Nullable;

public class ItemStackEnergyCapabilityProvider<T extends Item & EnergyUser> implements ICapabilityProvider {

    public final ItemStackEnergyStorage<T> storage;

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

    public static class ItemStackEnergyStorage<T extends Item & EnergyUser> implements IEnergyStorage {

        private final ItemStack stack;
        private final T energyUser;

        public ItemStackEnergyStorage(ItemStack stack, T item) {
            this.stack = stack;
            this.energyUser = item;
        }

        @Override
        public int receiveEnergy(int maxReceive, boolean simulate) {
            if (!canReceive())
                return 0;

            int energy = getEnergyStored();
            int energyReceived = Math.min(getMaxEnergyStored() - energy, Math.min(energyUser.getTransfer(), maxReceive));
            if (!simulate) {
                setEnergy(energyReceived + energy);
            }
            return energyReceived;
        }

        @Override
        public boolean canReceive() {
            return true;
        }

        @Override
        public boolean canExtract() {
            return true;
        }

        @Override
        public int getEnergyStored() {
            return energyUser.getStoredEnergy(stack);
        }

        @Override
        public int getMaxEnergyStored() {
            return energyUser.getCapacity();
        }

        public void setEnergy(int energy) {
            energyUser.setStoredEnergy(stack,energy);
        }

        @Override
        public int extractEnergy(int maxExtract, boolean simulate) {
            if (!canExtract())
                return 0;

            int energy = getEnergyStored();
            int energyExtracted = Math.min(energy, Math.min(energyUser.getTransfer(), maxExtract));
            if (!simulate) {
                setEnergy(energy - energyExtracted);
            }
            return energyExtracted;
        }
    }
}
