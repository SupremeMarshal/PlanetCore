package com.PlanetCore.util.handlers;

import com.PlanetCore.util.Reference;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class CapabilityHandler {
    @CapabilityInject(IHasArmor.class)
    public static final Capability<IHasArmor> HAS_ARMOR_CAPABILITY = null;

    public static void register() {
        CapabilityManager.INSTANCE.register(IHasArmor.class, new IStorage<IHasArmor>() {

            @Override
            public NBTBase writeNBT(Capability<IHasArmor> capability, IHasArmor instance, EnumFacing side) {
                return new NBTTagByte((byte) (instance.hasArmor() ? 1 : 0));
            }

            @Override
            public void readNBT(Capability<IHasArmor> capability, IHasArmor instance, EnumFacing side, NBTBase nbt) {
                if (nbt instanceof NBTTagByte) {
                    instance.setHasArmor(((NBTTagByte) nbt).getByte() != 0);
                }
            }
        }, HasArmor::new);
    }
}