package com.PlanetCore.util.handlers;

import com.PlanetCore.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

public class SoundHandler
{
    public static SoundEvent INDESTRUCTIBLE;
    public static SoundEvent INDESTRUCTIBLE1;
    public static SoundEvent INDESTRUCTIBLE2;
    public static SoundEvent INDESTRUCTIBLE3;
    public static SoundEvent INDESTRUCTIBLE4;
    public static SoundEvent INDESTRUCTIBLE5;
    public static SoundEvent INDESTRUCTIBLE6;
    public static SoundEvent INDESTRUCTIBLE7;
    public static SoundEvent INDESTRUCTIBLE8;
    public static SoundEvent INDESTRUCTIBLE9;
    public static SoundEvent INDESTRUCTIBLE10;
    public static SoundEvent INDESTRUCTIBLE11;
    public static SoundEvent INDESTRUCTIBLE12;
    public static SoundEvent INDESTRUCTIBLE13;
    public static SoundEvent INDESTRUCTIBLE14;
    public static SoundEvent INDESTRUCTIBLE15;
    public static SoundEvent INDESTRUCTIBLE16;
    public static SoundEvent INDESTRUCTIBLE17;
    public static SoundEvent INDESTRUCTIBLE18;
    public static SoundEvent INDESTRUCTIBLE19;
    public static void registerSounds()
    {
        INDESTRUCTIBLE = registerSound("action.indestructible");
        INDESTRUCTIBLE1 = registerSound("action.indestructible1");
        INDESTRUCTIBLE2 = registerSound("action.indestructible2");
        INDESTRUCTIBLE3 = registerSound("action.indestructible3");
        INDESTRUCTIBLE4 = registerSound("action.indestructible4");
        INDESTRUCTIBLE5 = registerSound("action.indestructible5");
        INDESTRUCTIBLE6 = registerSound("action.indestructible6");
        INDESTRUCTIBLE7 = registerSound("action.indestructible7");
        INDESTRUCTIBLE8 = registerSound("action.indestructible8");
        INDESTRUCTIBLE9 = registerSound("action.indestructible9");
        INDESTRUCTIBLE10 = registerSound("action.indestructible10");
        INDESTRUCTIBLE11 = registerSound("action.indestructible11");
        INDESTRUCTIBLE12 = registerSound("action.indestructible12");
        INDESTRUCTIBLE13 = registerSound("action.indestructible13");
        INDESTRUCTIBLE14 = registerSound("action.indestructible14");
        INDESTRUCTIBLE15 = registerSound("action.indestructible15");
        INDESTRUCTIBLE16 = registerSound("action.indestructible16");
        INDESTRUCTIBLE17 = registerSound("action.indestructible17");
        INDESTRUCTIBLE18 = registerSound("action.indestructible18");
        INDESTRUCTIBLE19 = registerSound("action.indestructible19");
    }
    private static SoundEvent registerSound(String name)
    {
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        ForgeRegistries.SOUND_EVENTS.register(event);
        return event;
    }
}
