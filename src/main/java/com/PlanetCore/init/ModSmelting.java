package com.PlanetCore.init;


import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModSmelting {
	
	public static void init()
	{
		/**
		 * NORMAL FURNACE RECIPES
		 */

		GameRegistry.addSmelting(Blocks.IRON_BLOCK, new ItemStack(Items.IRON_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SULFUR_BLOCK, new ItemStack(ModItems.SULFUR, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SILVER_BLOCK, new ItemStack(ModItems.SILVER_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(Blocks.GOLD_BLOCK, new ItemStack(Items.GOLD_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.TITANIUM_BLOCK, new ItemStack(ModItems.TITANIUM_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.URANIUM_BLOCK, new ItemStack(ModItems.URANIUM_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.TUNGSTEN_BLOCK, new ItemStack(ModItems.TUNGSTEN_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.RUBY_BLOCK, new ItemStack(ModItems.RUBY, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SAPPHIRE_BLOCK, new ItemStack(ModItems.SAPPHIRE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MAJORITE_BLOCK, new ItemStack(ModItems.MAJORITE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.AMAZONITE_BLOCK, new ItemStack(ModItems.AMAZONITE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.ONYX_BLOCK, new ItemStack(ModItems.ONYX, 9), 1.0F);
		
		GameRegistry.addSmelting(ModBlocks.SUPERCOMPRESSED_IRON, new ItemStack(Items.IRON_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SUPERCOMPRESSED_SULFUR, new ItemStack(ModItems.SULFUR, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SUPERCOMPRESSED_REDSTONE, new ItemStack(Blocks.REDSTONE_BLOCK, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SUPERCOMPRESSED_SILVER, new ItemStack(ModItems.SILVER_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SUPERCOMPRESSED_GOLD, new ItemStack(Items.GOLD_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SUPERCOMPRESSED_TITANIUM, new ItemStack(ModItems.TITANIUM_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SUPERCOMPRESSED_URANIUM, new ItemStack(ModItems.URANIUM_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SUPERCOMPRESSED_TUNGSTEN, new ItemStack(ModItems.TUNGSTEN_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SUPERCOMPRESSED_RUBY, new ItemStack(ModItems.RUBY, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SUPERCOMPRESSED_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SUPERCOMPRESSED_MAJORITE, new ItemStack(ModItems.MAJORITE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SUPERCOMPRESSED_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SUPERCOMPRESSED_ONYX, new ItemStack(ModItems.ONYX, 9), 1.0F);

		GameRegistry.addSmelting(ModItems.IRON_ORE, new ItemStack(Items.IRON_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.SILVER_ORE, new ItemStack(ModItems.SILVER_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.GOLD_ORE, new ItemStack(Items.GOLD_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.TITANIUM_ORE, new ItemStack(ModItems.TITANIUM_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.URANIUM_ORE, new ItemStack(ModItems.URANIUM_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.TUNGSTEN_ORE, new ItemStack(ModItems.TUNGSTEN_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COAL, new ItemStack(Items.COAL, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_IRON, new ItemStack(Items.IRON_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_GOLD, new ItemStack(Items.GOLD_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_DIAMOND, new ItemStack(Items.DIAMOND, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_EMERALD, new ItemStack(Items.EMERALD, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_SULFUR, new ItemStack(ModItems.SULFUR, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_TITANIUM, new ItemStack(ModItems.TITANIUM_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_URANIUM, new ItemStack(ModItems.URANIUM_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_TUNGSTEN, new ItemStack(ModItems.TUNGSTEN_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_RUBY, new ItemStack(ModItems.RUBY, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_MAJORITE, new ItemStack(ModItems.MAJORITE, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COMPACT_COAL, new ItemStack(Items.COAL, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COMPACT_IRON, new ItemStack(Items.IRON_INGOT, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COMPACT_GOLD, new ItemStack(Items.GOLD_INGOT, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COMPACT_DIAMOND, new ItemStack(Items.DIAMOND, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COMPACT_EMERALD, new ItemStack(Items.EMERALD, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COMPACT_SULFUR, new ItemStack(ModItems.SULFUR, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COMPACT_TITANIUM, new ItemStack(ModItems.TITANIUM_INGOT, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COMPACT_URANIUM, new ItemStack(ModItems.URANIUM_INGOT, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COMPACT_TUNGSTEN, new ItemStack(ModItems.TUNGSTEN_INGOT, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COMPACT_RUBY, new ItemStack(ModItems.RUBY, 3), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COMPACT_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 3), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COMPACT_MAJORITE, new ItemStack(ModItems.MAJORITE, 3), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COMPACT_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 3), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COAL, new ItemStack(Items.COAL, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_IRON, new ItemStack(Items.IRON_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_GOLD, new ItemStack(Items.GOLD_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_DIAMOND, new ItemStack(Items.DIAMOND, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_EMERALD, new ItemStack(Items.EMERALD, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_SULFUR, new ItemStack(ModItems.SULFUR, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_TITANIUM, new ItemStack(ModItems.TITANIUM_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_URANIUM, new ItemStack(ModItems.URANIUM_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_TUNGSTEN, new ItemStack(ModItems.TUNGSTEN_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_RUBY, new ItemStack(ModItems.RUBY, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_MAJORITE, new ItemStack(ModItems.MAJORITE, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_ONYX, new ItemStack(ModItems.ONYX, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_PAINITE, new ItemStack(ModItems.PAINITE, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_COAL, new ItemStack(Items.COAL, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_IRON, new ItemStack(Items.IRON_INGOT, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_GOLD, new ItemStack(Items.GOLD_INGOT, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_DIAMOND, new ItemStack(Items.DIAMOND, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_EMERALD, new ItemStack(Items.EMERALD, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_SULFUR, new ItemStack(ModItems.SULFUR, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_TITANIUM, new ItemStack(ModItems.TITANIUM_INGOT, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_URANIUM, new ItemStack(ModItems.URANIUM_INGOT, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_TUNGSTEN, new ItemStack(ModItems.TUNGSTEN_INGOT, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_RUBY, new ItemStack(ModItems.RUBY, 3), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 3), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_MAJORITE, new ItemStack(ModItems.MAJORITE, 3), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 3), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_ONYX, new ItemStack(ModItems.ONYX, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_PAINITE, new ItemStack(ModItems.PAINITE, 2), 1.0F);
	}
}
