package com.PlanetCore.capability;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

public class UserSettingsStorage  {

    /*
    implements Capability.IStorage<IUserSettings>
    @Override
    public NBTBase writeNBT(Capability<IUserSettings> capability, IUserSettings instance, EnumFacing side) {
        NBTTagCompound comp = new NBTTagCompound();
        comp.setInteger("heatRes", instance.getHeatResistance());
        return comp;
    }

    @Override
    public void readNBT(Capability<IUserSettings> capability, IUserSettings instance, EnumFacing side, NBTBase nbt) {
        NBTTagCompound comp = (NBTTagCompound)nbt;
        instance.setHeatResistance(comp.getInteger("heatRes"));
    }

     */
}
