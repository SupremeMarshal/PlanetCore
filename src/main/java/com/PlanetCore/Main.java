package com.PlanetCore;


import com.PlanetCore.anvils.Scripts;
import com.PlanetCore.anvils.generic.BlockGenericAnvil;
import com.PlanetCore.init.ModSmelting;
import com.PlanetCore.proxy.CommonProxy;
import com.PlanetCore.util.Reference;
import com.PlanetCore.util.handlers.RegistryHandler;

import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION)
public class Main {

	@Instance
	public static Main instance;

	//Extra Anvils
	public static final HashMap<BlockGenericAnvil, BlockGenericAnvil> anvilDamageMap = new HashMap();
	public static final List<BlockGenericAnvil> anvils = new ArrayList();
	public static ArrayList<String> strings = new ArrayList();
	public static Logger logger = LogManager.getLogger();
	//---

	@SidedProxy(clientSide = Reference.CLIENT, serverSide = Reference.SERVER)
	public static CommonProxy proxy;


	
	public static File config;



	static { FluidRegistry.enableUniversalBucket(); }

	//Extra Anvils
	public Main() {
	}
	//---

	@EventHandler
	public static void PreInit(FMLPreInitializationEvent event)
	{
		//Extra Anvils
		boolean doJson = false;
		if (doJson) {
			Scripts.scripts();
		}
		RegistryHandler.preInitRegistries(event);
		proxy.preInit(event);
		//---

	}
	
	@EventHandler
    public static void init(FMLInitializationEvent event) {
		ModSmelting.init();
		RegistryHandler.initRegistries(event);
		//Extra Anvils
		proxy.init(event);
		//---
    }


	@EventHandler
	public static void PostInit(FMLPostInitializationEvent event)
	{
		RegistryHandler.posInitRegistries(event);
	}
	
	
}