package com.PlanetCore.init;


import com.PlanetCore.blocks.BlockBase;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

public class ModSmelting {

	private static final String[] Item1 = {"INGOT", "SWORD", "AXE", "PICKAXE", "SPADE", "HOE",
			"HELMET", "CHESTPLATE", "LEGGINGS", "BOOTS", "ROD"};
	//"STEEL", "BRONZE", "TITANIUM_URANIUM", "TUNGSTEN_URANIUM", "TUNGSTEN_TITANIUM",
	private static final String[] Material = {"SULFUR","ALUMINIUM", "ZINC", "LEAD", "TIN", "SILICON", "COPPER", "IRON", "SILVER",
			"GOLD", "PLATINUM", "TITANIUM", "URANIUM", "TUNGSTEN", "REDSTONE", "TOPAZ", "JADE", "EMERALD", "RUBY", "SAPPHIRE", "DIAMOND", "OLIVINE",
			"WADSLEYITE", "RINGWOODITE", "BRIGMANITE", "MAJORITE", "AMAZONITE", "ONYX"};

	private static final String[] Rock = {"ORE", "CRUSTROCK", "MANTLEROCK", "CORESTONE"};
	private static final String[] Size = {"SMALL", "", "COMPACT"};
	private static final int[] Amount = {2,1,3};


	public static void init()
	{
		String blockname;
		String itemname;
		Block block;
		Item item;
		/**
		 * NORMAL FURNACE RECIPES
		 */
		for (int size = 0; size < 3; size++) {
			for (int material = 0; (material < 28); material++) {

				if (material < 14)
				{
					if (size < 1)
					{
						itemname = "planetcore:" + Material[material].toLowerCase(Locale.ROOT) + "_nugget";
					}
					else itemname = "planetcore:" + Material[material].toLowerCase(Locale.ROOT) + "_ingot";
				}
				else
				{
					if (size < 1)
					{
						itemname = "planetcore:" + Material[material].toLowerCase(Locale.ROOT) + "_shard";
					}
					else
					{
						itemname = "planetcore:" + Material[material].toLowerCase(Locale.ROOT);
						if (Material[material].contains("EMERALD") || Material[material].contains("REDSTONE"))
						{
							itemname = "minecraft:" + Material[material].toLowerCase(Locale.ROOT);
						}
					}
				}

				item = Item.getByNameOrId(itemname);

				for (int rock = 0; rock < 4; rock++)
				{
					if (rock == 3 && material < 14)
					{
						continue;
					}

					if (size == 1)
					{
						blockname = "planetcore:" + Rock[rock].toLowerCase(Locale.ROOT) + "_" + Material[material].toLowerCase(Locale.ROOT);
						block = BlockBase.getBlockFromName(blockname).getBlockState().getBlock();
						GameRegistry.addSmelting(block, new ItemStack(item, Amount[size]), 0.25F * Amount[size]);
					}
					if (size != 1)
					{
						blockname = "planetcore:" + Rock[rock].toLowerCase(Locale.ROOT) + "_" + Size[size].toLowerCase(Locale.ROOT) + "_" + Material[material].toLowerCase(Locale.ROOT);
						block = BlockBase.getBlockFromName(blockname).getBlockState().getBlock();
						GameRegistry.addSmelting(block, new ItemStack(item, Amount[size]), 0.25F * Amount[size]);
					}
				}
			}
		}

		int random = new Random().nextInt(4) + 1;
		GameRegistry.addSmelting(ModBlocks.ALUMINIUM_SUPERCOMPACT, new ItemStack(ModItems.ALUMINIUM_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.TIN_SUPERCOMPACT, new ItemStack(ModItems.TIN_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.COPPER_SUPERCOMPACT, new ItemStack(ModItems.COPPER_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.IRON_SUPERCOMPACT, new ItemStack(ModItems.IRON_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SULFUR_SUPERCOMPACT, new ItemStack(ModItems.SULFUR, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.REDSTONE_SUPERCOMPACT, new ItemStack(Blocks.REDSTONE_BLOCK, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SILVER_SUPERCOMPACT, new ItemStack(ModItems.SILVER_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.GOLD_SUPERCOMPACT, new ItemStack(ModItems.GOLD_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.PLATINUM_SUPERCOMPACT, new ItemStack(ModItems.PLATINUM_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.TITANIUM_SUPERCOMPACT, new ItemStack(ModItems.TITANIUM_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.URANIUM_SUPERCOMPACT, new ItemStack(ModItems.URANIUM_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.TUNGSTEN_SUPERCOMPACT, new ItemStack(ModItems.TUNGSTEN_INGOT, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.TOPAZ_SUPERCOMPACT, new ItemStack(ModItems.TOPAZ, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.JADE_SUPERCOMPACT, new ItemStack(ModItems.JADE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.EMERALD_SUPERCOMPACT, new ItemStack(Items.EMERALD, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.RUBY_SUPERCOMPACT, new ItemStack(ModItems.RUBY, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.SAPPHIRE_SUPERCOMPACT, new ItemStack(ModItems.SAPPHIRE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.DIAMOND_SUPERCOMPACT, new ItemStack(ModItems.DIAMOND, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.OLIVINE_SUPERCOMPACT, new ItemStack(ModItems.OLIVINE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.WADSLEYITE_SUPERCOMPACT, new ItemStack(ModItems.WADSLEYITE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.RINGWOODITE_SUPERCOMPACT, new ItemStack(ModItems.RINGWOODITE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.MAJORITE_SUPERCOMPACT, new ItemStack(ModItems.MAJORITE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.AMAZONITE_SUPERCOMPACT, new ItemStack(ModItems.AMAZONITE, 9), 1.0F);
		GameRegistry.addSmelting(ModBlocks.ONYX_SUPERCOMPACT, new ItemStack(ModItems.ONYX, 9), 1.0F);

		GameRegistry.addSmelting(ModItems.ALUMINIUM_ORE, new ItemStack(ModItems.ALUMINIUM_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.ALUMINIUM_SHARD, new ItemStack(ModItems.ALUMINIUM_NUGGET, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.TIN_ORE, new ItemStack(ModItems.TIN_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.TIN_SHARD, new ItemStack(ModItems.TIN_NUGGET, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.COPPER_ORE, new ItemStack(ModItems.COPPER_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.COPPER_SHARD, new ItemStack(ModItems.COPPER_NUGGET, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.IRON_ORE, new ItemStack(ModItems.IRON_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.IRON_SHARD, new ItemStack(ModItems.IRON_NUGGET, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.SILVER_ORE, new ItemStack(ModItems.SILVER_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.SILVER_SHARD, new ItemStack(ModItems.SILVER_NUGGET, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.GOLD_ORE, new ItemStack(ModItems.GOLD_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.GOLD_SHARD, new ItemStack(ModItems.GOLD_NUGGET, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.PLATINUM_ORE, new ItemStack(ModItems.PLATINUM_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.PLATINUM_SHARD, new ItemStack(ModItems.PLATINUM_NUGGET, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.TITANIUM_ORE, new ItemStack(ModItems.TITANIUM_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.TITANIUM_SHARD, new ItemStack(ModItems.TITANIUM_NUGGET, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.URANIUM_ORE, new ItemStack(ModItems.URANIUM_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.URANIUM_SHARD, new ItemStack(ModItems.URANIUM_NUGGET, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.TUNGSTEN_ORE, new ItemStack(ModItems.TUNGSTEN_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModItems.TUNGSTEN_SHARD, new ItemStack(ModItems.TUNGSTEN_NUGGET, 1), 1.0F);



		GameRegistry.addSmelting(Blocks.REDSTONE_ORE, new ItemStack(Items.REDSTONE, 5), 1.5F);




		GameRegistry.addSmelting(Items.IRON_HORSE_ARMOR, new ItemStack(ModItems.IRON_NUGGET, 1), 0.0F);

	}

	public static void RemoveSmelting(ItemStack resultStack) {
		ItemStack recipeResult = null;
		Map<ItemStack,ItemStack> recipes = FurnaceRecipes.instance().getSmeltingList();
		Iterator<ItemStack> iterator = recipes.keySet().iterator();
		resultStack = new ItemStack(Items.IRON_HORSE_ARMOR, 1, 0);
		while(iterator.hasNext()) {
			ItemStack tmpRecipe = iterator.next();
			recipeResult = recipes.get(tmpRecipe);
			if (ItemStack.areItemStacksEqual(resultStack, recipeResult)) {
				iterator.remove();
			}
		}
	}
}
