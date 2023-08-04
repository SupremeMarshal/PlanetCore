package com.PlanetCore;


import com.PlanetCore.cwg.CustomCaveInjector;
import com.PlanetCore.cwg.PlanetCoreWorldType;
import com.PlanetCore.init.ModSmelting;
import com.PlanetCore.init.ToolMaterials;
import com.PlanetCore.util.Reference;
import com.PlanetCore.util.handlers.RegistryHandler;

import com.PlanetCore.util.handlers.WorldgenHandler;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import software.bernie.example.GeckoLibMod;
import software.bernie.geckolib3.GeckoLib;


import java.io.File;


@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {
    public Main()
    {
        GeckoLib.initialize();
        GeckoLibMod.DISABLE_IN_DEV = true;
    }
    

    @Instance
    public static Main instance;

    public static Logger LOGGER;


    public static File config;


    static {
        FluidRegistry.enableUniversalBucket();
    }

    @EventHandler
    public static void PreInit(FMLPreInitializationEvent event) {
        LOGGER = event.getModLog();
        RegistryHandler.preInitRegistries(event);

        MinecraftForge.TERRAIN_GEN_BUS.register(new CustomCaveInjector());
        MinecraftForge.ORE_GEN_BUS.register(new WorldgenHandler());
        new PlanetCoreWorldType();
    }

    @EventHandler
    public static void init(FMLInitializationEvent event) {

        RegistryHandler.initRegistries(event);
    }


    @EventHandler
    public static void PostInit(FMLPostInitializationEvent event) {
        RegistryHandler.posInitRegistries(event);
        ModSmelting.init();
    }


}