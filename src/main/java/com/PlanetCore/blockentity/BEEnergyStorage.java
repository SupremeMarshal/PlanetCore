package com.PlanetCore.blockentity;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.energy.EnergyStorage;

public class BEEnergyStorage extends EnergyStorage {
    public BEEnergyStorage(int capacity) {
        super(capacity);
    }

    public BEEnergyStorage(int capacity, int maxTransfer) {
        super(capacity, maxTransfer);
    }

    public BEEnergyStorage(int capacity, int maxReceive, int maxExtract) {
        super(capacity, maxReceive, maxExtract);
    }

    public BEEnergyStorage(int capacity, int maxReceive, int maxExtract, int energy) {
        super(capacity, maxReceive, maxExtract, energy);
    }


    @Override
    public int extractEnergy(int maxExtract, boolean simulate) {
        int i = super.extractEnergy(maxExtract, simulate);
        if (i != 0 && !simulate) {
            onChange();
        }
        return i;
    }

    @Override
    public int receiveEnergy(int maxReceive, boolean simulate) {
        int i = super.receiveEnergy(maxReceive, simulate);
        if (i != 0 && !simulate) {
            onChange();
        }
        return i;
    }

    public void onChange() {

    }

    public NBTTagCompound serialize() {
        NBTTagCompound nbtTagCompound = new NBTTagCompound();
        nbtTagCompound.setInteger("energy",energy);
        return nbtTagCompound;
    }

    public void read(NBTTagCompound nbtTagCompound) {
        energy = nbtTagCompound.getInteger("energy");
    }
}
