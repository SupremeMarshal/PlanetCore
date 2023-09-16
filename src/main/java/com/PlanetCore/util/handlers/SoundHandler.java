package com.PlanetCore.util.handlers;

import com.PlanetCore.util.Reference;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.registries.IForgeRegistry;

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
    public static SoundEvent CRUST_MUSIC;
    public static SoundEvent CRUST1_MUSIC;
    public static SoundEvent CRUST2_MUSIC;
    public static SoundEvent MANTLE_MUSIC;
    public static SoundEvent MANTLE1_MUSIC;
    public static SoundEvent MANTLE1_1_MUSIC;
    public static SoundEvent MANTLE2_MUSIC;
    public static SoundEvent LAVA_AMBIENCE;
    public static void registerSounds(IForgeRegistry<SoundEvent> registry)
    {
        INDESTRUCTIBLE = registerSound("action.indestructible",registry);
        INDESTRUCTIBLE1 = registerSound("action.indestructible1", registry);
        INDESTRUCTIBLE2 = registerSound("action.indestructible2", registry);
        INDESTRUCTIBLE3 = registerSound("action.indestructible3", registry);
        INDESTRUCTIBLE4 = registerSound("action.indestructible4", registry);
        INDESTRUCTIBLE5 = registerSound("action.indestructible5", registry);
        INDESTRUCTIBLE6 = registerSound("action.indestructible6", registry);
        INDESTRUCTIBLE7 = registerSound("action.indestructible7", registry);
        INDESTRUCTIBLE8 = registerSound("action.indestructible8", registry);
        INDESTRUCTIBLE9 = registerSound("action.indestructible9", registry);
        INDESTRUCTIBLE10 = registerSound("action.indestructible10", registry);
        INDESTRUCTIBLE11 = registerSound("action.indestructible11", registry);
        INDESTRUCTIBLE12 = registerSound("action.indestructible12", registry);
        INDESTRUCTIBLE13 = registerSound("action.indestructible13", registry);
        INDESTRUCTIBLE14 = registerSound("action.indestructible14", registry);
        INDESTRUCTIBLE15 = registerSound("action.indestructible15", registry);
        INDESTRUCTIBLE16 = registerSound("action.indestructible16", registry);
        INDESTRUCTIBLE17 = registerSound("action.indestructible17", registry);
        INDESTRUCTIBLE18 = registerSound("action.indestructible18", registry);
        INDESTRUCTIBLE19 = registerSound("action.indestructible19", registry);
        CRUST_MUSIC = registerSound("crust_music", registry);
        CRUST1_MUSIC = registerSound("crust1_music", registry);
        CRUST2_MUSIC = registerSound("crust2_music", registry);
        MANTLE_MUSIC = registerSound("mantle_music", registry);
        MANTLE1_MUSIC = registerSound("mantle1_music", registry);
        MANTLE1_1_MUSIC = registerSound("mantle1-1_music", registry);
        MANTLE2_MUSIC = registerSound("mantle2_music", registry);
        LAVA_AMBIENCE = registerSound("lava_ambience", registry);
    }
    private static SoundEvent registerSound(String name, IForgeRegistry<SoundEvent> registry)
    {
        ResourceLocation location = new ResourceLocation(Reference.MOD_ID, name);
        SoundEvent event = new SoundEvent(location);
        event.setRegistryName(name);
        registry.register(event);
        return event;
    }
}
