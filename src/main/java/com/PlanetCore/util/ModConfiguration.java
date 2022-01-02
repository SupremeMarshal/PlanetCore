package com.PlanetCore.util;

import java.io.File;

import com.PlanetCore.Main;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ModConfiguration 
{

    public static Configuration config;
	
	public static int ENTITY_DEMON_ID = 201;
	// public static int ENTITY_BLACKDEMON_ID = 202;
	public static int ENTITY_GHOUL_ID = 203;
	public static int ENTITY_HELLHOUND_ID = 204;
	public static int ENTITY_DEATH_ENDERMAN_ID = 206;
	public static int ENTITY_HOT_BLASE_ID = 207;
	public static int ENTITY_CORE_BLASE_ID = 208;
	public static int ENTITY_CORE_DEMON_ID = 209;
	public static int ENTITY_EMERALD_ARROW_ID = 210;
	public static int GUI_CRUSTROCK_FURNACE_ID = 5;
	public static int GUI_STEEL_FURNACE_ID = 6;
	public static int GUI_TITANIUM_FURNACE_ID = 7;
	public static int GUI_TUNGSTEN_FURNACE_ID = 8;
	public static int GUI_TUNGSTEN_TITANIUM_FURNACE_ID = 9;


	public static void init(File file)
	{
		config = new Configuration(file);
		
		String category;
		
		category = "Entity IDs";
		config.addCustomCategoryComment(category, "Set the ID's for the entities to ensure that they don't clash with other mod's ids");
		ENTITY_DEMON_ID = config.getInt("ENTITY_DEMON_ID", category, 201, 201, 999, "Entity IDs below 201 are used by Minecraft");
		ENTITY_CORE_DEMON_ID = config.getInt("ENTITY_CORE_DEMON_ID", category, 201, 201, 999, "Entity IDs below 201 are used by Minecraft");
		ENTITY_GHOUL_ID = config.getInt("ENTITY_GHOUL_ID", category, 201, 201, 999, "Entity IDs below 201 are used by Minecraft");
		ENTITY_HELLHOUND_ID = config.getInt("ENTITY_HELLHOUND_ID", category, 201, 201, 999, "Entity IDs below 201 are used by Minecraft");
		ENTITY_DEATH_ENDERMAN_ID = config.getInt("ENTITY_DEATH_ENDERMAN_ID", category, 201, 201, 999, "Entity IDs below 201 are used by Minecraft");
		ENTITY_EMERALD_ARROW_ID = config.getInt("ENTITY_EMERALD_ARROW_ID", category, 201, 201, 999, "Entity IDs below 201 are used by Minecraft");

		category = "GUI IDs";
		config.addCustomCategoryComment(category, "Set the ID's for the GUI's to ensure that they don't clash with other mod's ids");
		GUI_CRUSTROCK_FURNACE_ID = config.getInt("GUI_CRUSTROCK_FURNACE_ID", category, 1, 1, 999, "Set the ID for the Crustrock Furnace (Non-Electric)");
		GUI_STEEL_FURNACE_ID = config.getInt("GUI_STEEL_FURNACE_ID", category, 1, 1, 999, "Set the ID for the Steel Furnace (Non-Electric)");
		GUI_TITANIUM_FURNACE_ID = config.getInt("GUI_TITANIUM_FURNACE_ID", category, 1, 1, 999, "Set the ID for the Titanium Furnace (Non-Electric)");
		GUI_TUNGSTEN_FURNACE_ID = config.getInt("GUI_TUNGSTEN_FURNACE_ID", category, 1, 1, 999, "Set the ID for the Tungsten Furnace (Non-Electric)");
		GUI_TUNGSTEN_TITANIUM_FURNACE_ID = config.getInt("GUI_TUNGSTEN_TITANIUM_FURNACE_ID", category, 1, 1, 999, "Set the ID for the Tungsten Titanium Furnace (Non-Electric)");
	}
	
	public static void registerConfig(FMLPreInitializationEvent event)
	{
		Main.config = new File(event.getModConfigurationDirectory() + "/" + Reference.MOD_ID);
		Main.config.mkdirs();
		init(new File(Main.config.getPath(), Reference.MOD_ID + ".cfg"));
	}
	
}
