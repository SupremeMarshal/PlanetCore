package com.PlanetCore.capability;

import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilityProvider;


public class UserSettingsStorageProvider  {
    /*
    implements ICapabilityProvider {

    @CapabilityInject(value = IUserSettings.class)
    public static final Capability<IUserSettings> SETTINGS_CAP = null;

    private IUserSettings userSettingsInstance;

    public UserSettingsStorageProvider() {
        this.userSettingsInstance = new UserSettings();
    }

    @Override
    public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
        if(capability == SETTINGS_CAP) return true;
        return false;
    }

    @Override
    public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
        if(this.hasCapability(capability, facing)) return (T)this.userSettingsInstance;
        return null;
    }

     */
}