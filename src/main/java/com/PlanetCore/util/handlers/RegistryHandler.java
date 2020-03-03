package com.PlanetCore.util.handlers;

import com.PlanetCore.Main;
import com.PlanetCore.anvils.EntityFallingAnvil;
import com.PlanetCore.anvils.EnumVariants;
import com.PlanetCore.anvils.GuiHandler;
import com.PlanetCore.anvils.PacketHandler;
import com.PlanetCore.anvils.generic.BlockGenericAnvil;
import com.PlanetCore.init.*;
import com.PlanetCore.util.IHasModel;
import com.PlanetCore.util.ModConfiguration;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.EntityEntry;
import net.minecraftforge.fml.common.registry.EntityEntryBuilder;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.registries.IForgeRegistry;

import java.util.Iterator;


@EventBusSubscriber
public class RegistryHandler {


	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event)
	{
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}
	
	@SubscribeEvent
	public static void onBlockRegister(RegistryEvent.Register<Block> event)
	{
		event.getRegistry().registerAll(ModBlocks.BLOCKS.toArray(new Block[0]));
	}
	
	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event)
	{
		for (Item item : ModItems.ITEMS)
		{
			if(item instanceof IHasModel)
			{
				((IHasModel)item).registerModels();
			}
		}
		
		for (Block block : ModBlocks.BLOCKS)
		{
			if(block instanceof IHasModel)
			{
				((IHasModel)block).registerModels();
			}
		}
		RenderHandler.registerEntityRenders();
		RenderHandler.registerCustomMeshesAndStates();
	}

	//Extra Anvils -- Common proxy
	@SubscribeEvent
	public static void registerEntity(RegistryEvent.Register<EntityEntry> e) {
		ResourceLocation resourceLocation = new ResourceLocation("planetcore", "falling_anvil");
		e.getRegistry().register(EntityEntryBuilder.create().entity(EntityFallingAnvil.class).id(resourceLocation, 0).name(resourceLocation.getPath()).tracker(64, 1, true).build());
	}
	//---

	public static void preInitRegistries(FMLPreInitializationEvent event)
	{
		ModFluids.registerFluids();
		EntityInit.registerEntities();
		ModConfiguration.registerConfig(event);
		MinecraftForge.EVENT_BUS.register(new FogHandler());

		//Extra Anvils -- Common Proxy -- public void preInit(FMLPreInitializationEvent e)

		//---
	}



	public static void initRegistries(FMLInitializationEvent event) {


		OreDictionary.registerOre("itemCoal", new ItemStack(Items.COAL, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("itemPlank", new ItemStack(Blocks.PLANKS, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("ingotSteel", new ItemStack(ModItems.STEEL_INGOT, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("ingotSilver", new ItemStack(ModItems.SILVER_INGOT, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("ingotPlatinum", new ItemStack(ModItems.PLATINUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("itemSapphire", new ItemStack(ModItems.SAPPHIRE, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("itemRuby", new ItemStack(ModItems.RUBY, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("itemDiamond", new ItemStack(ModItems.DIAMOND, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("itemAmazonite", new ItemStack(ModItems.AMAZONITE, 1, OreDictionary.WILDCARD_VALUE));
		OreDictionary.registerOre("itemSulfur", new ItemStack(ModItems.SULFUR, 1, OreDictionary.WILDCARD_VALUE));

		//Extra Anvils -- Common Proxy -- public void init(FMLInitializationEvent e)

		//------
	}

	public static void posInitRegistries(FMLPostInitializationEvent event)
	{
		net.minecraft.item.crafting.FurnaceRecipes.instance().getSmeltingList().remove(
				new net.minecraft.item.ItemStack(net.minecraft.init.Items.IRON_HORSE_ARMOR, 1, 32767),
				new net.minecraft.item.ItemStack(net.minecraft.init.Items.IRON_NUGGET));
		net.minecraft.item.crafting.FurnaceRecipes.instance().getSmeltingList().put(
				new net.minecraft.item.ItemStack(net.minecraft.init.Items.IRON_HORSE_ARMOR, 1, 32767),
				new net.minecraft.item.ItemStack(ModItems.IRON_NUGGET));

	}

	//Extra Anvils -- Common proxy
	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> event) {
		IForgeRegistry<Item> registry = event.getRegistry();
		Iterator var2 = Main.anvils.iterator();

		while(var2.hasNext()) {
			BlockGenericAnvil anvil = (BlockGenericAnvil)var2.next();
			registry.register((new ItemBlock(anvil)).setRegistryName(anvil.getRegistryName()));
		}
	}
	//---

	
}
