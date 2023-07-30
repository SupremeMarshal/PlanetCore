package com.PlanetCore.init;


import com.PlanetCore.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Locale;

public class ModSmelting {
	
	public static void init()
	{
		/**
		 * NORMAL FURNACE RECIPES
		 */

		GameRegistry.addSmelting(ModBlocks.IRON_BLOCK, new ItemStack(Items.IRON_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SULFUR_BLOCK, new ItemStack(ModItems.SULFUR, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SILVER_BLOCK, new ItemStack(ModItems.SILVER_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.GOLD_BLOCK, new ItemStack(Items.GOLD_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.TITANIUM_BLOCK, new ItemStack(ModItems.TITANIUM_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.URANIUM_BLOCK, new ItemStack(ModItems.URANIUM_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.TUNGSTEN_BLOCK, new ItemStack(ModItems.TUNGSTEN_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.RUBY_BLOCK, new ItemStack(ModItems.RUBY, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SAPPHIRE_BLOCK, new ItemStack(ModItems.SAPPHIRE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MAJORITE_BLOCK, new ItemStack(ModItems.MAJORITE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.AMAZONITE_BLOCK, new ItemStack(ModItems.AMAZONITE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.ONYX_BLOCK, new ItemStack(ModItems.ONYX, 9), 1.0F);
		
		GameRegistry.addSmelting(ModBlocks.IRON_SUPERCOMPACT, new ItemStack(Items.IRON_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SULFUR_SUPERCOMPACT, new ItemStack(ModItems.SULFUR, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.REDSTONE_SUPERCOMPACT, new ItemStack(Blocks.REDSTONE_BLOCK, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SILVER_SUPERCOMPACT, new ItemStack(ModItems.SILVER_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.GOLD_SUPERCOMPACT, new ItemStack(Items.GOLD_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.TITANIUM_SUPERCOMPACT, new ItemStack(ModItems.TITANIUM_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.URANIUM_SUPERCOMPACT, new ItemStack(ModItems.URANIUM_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.TUNGSTEN_SUPERCOMPACT, new ItemStack(ModItems.TUNGSTEN_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.RUBY_SUPERCOMPACT, new ItemStack(ModItems.RUBY, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SAPPHIRE_SUPERCOMPACT, new ItemStack(ModItems.SAPPHIRE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MAJORITE_SUPERCOMPACT, new ItemStack(ModItems.MAJORITE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.AMAZONITE_SUPERCOMPACT, new ItemStack(ModItems.AMAZONITE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.ONYX_SUPERCOMPACT, new ItemStack(ModItems.ONYX, 9), 1.0F);

		GameRegistry.addSmelting(ModItems.IRON_ORE, new ItemStack(Items.IRON_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.SILVER_ORE, new ItemStack(ModItems.SILVER_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.GOLD_ORE, new ItemStack(Items.GOLD_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.TITANIUM_ORE, new ItemStack(ModItems.TITANIUM_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.URANIUM_ORE, new ItemStack(ModItems.URANIUM_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.TUNGSTEN_ORE, new ItemStack(ModItems.TUNGSTEN_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_RUBY, new ItemStack(ModItems.RUBY, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_MAJORITE, new ItemStack(ModItems.MAJORITE, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COMPACT_RUBY, new ItemStack(ModItems.RUBY, 3), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COMPACT_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 3), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COMPACT_MAJORITE, new ItemStack(ModItems.MAJORITE, 3), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COMPACT_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 3), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_RUBY, new ItemStack(ModItems.RUBY, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_MAJORITE, new ItemStack(ModItems.MAJORITE, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_ONYX, new ItemStack(ModItems.ONYX, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_PAINITE, new ItemStack(ModItems.PAINITE, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_RUBY, new ItemStack(ModItems.RUBY, 3), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 3), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_MAJORITE, new ItemStack(ModItems.MAJORITE, 3), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 3), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_ONYX, new ItemStack(ModItems.ONYX, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COMPACT_PAINITE, new ItemStack(ModItems.PAINITE, 1), 1.0F);
	}
}
