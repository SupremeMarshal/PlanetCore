package com.PlanetCore.init;


import com.PlanetCore.blocks.BlockBase;
import com.PlanetCore.blocks.Crustrock;
import com.PlanetCore.items.ItemBase;
import com.PlanetCore.items.tools.ItemPickaxe;
import net.minecraft.block.Block;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Iterator;
import java.util.Locale;
import java.util.Map;

import static org.apache.commons.io.FilenameUtils.getName;

public class ModSmelting {

	private static final String[] Item1 = {"INGOT", "SWORD", "AXE", "PICKAXE", "SPADE", "HOE",
			"HELMET", "CHESTPLATE", "LEGGINGS", "BOOTS", "ROD"};
	//"STEEL", "BRONZE", "TITANIUM_URANIUM", "TUNGSTEN_URANIUM", "TUNGSTEN_TITANIUM",
	private static final String[] Material = {"ALUMINIUM", "ZINC", "LEAD", "TIN", "SILICON", "COPPER", "IRON", "SILVER",
			"GOLD", "PLATINUM", "TITANIUM", "URANIUM", "TUNGSTEN", "TOPAZ", "JADE", "EMERALD", "RUBY", "SAPPHIRE", "DIAMOND", "OLIVINE",
			"WADSLEYITE", "RINGWOODITE", "BRIGMANITE", "MAJORITE", "AMAZONITE", "ONYX"};

	private static final String[] Meta = {"HARDROCK", "DEEPROCK", "CRUSTROCK"};

	private static final String[] Rock = {"CRUSTROCK", "MANTLEROCK", "CORESTONE"};
	private static final String[] Size = {"VERYSMALL", "SMALL", "", "COMPACT", "VERYCOMPACT"};
	private static final int[] Amount = {1,3,1,6,9};


	public static void init()
	{
		String blockname;
		String itemname = new String();
		Block block;
		Item item;
		/**
		 * NORMAL FURNACE RECIPES
		 */
		for (int size = 0; size < 5; size++) {
			for (int material = 0; (material < 26); material++) {

				if (material < 13)
				{

					if (size < 2)
					{
						itemname = "planetcore:" + Material[material].toLowerCase(Locale.ROOT) + "_nugget";
					}
					else itemname = "planetcore:" + Material[material].toLowerCase(Locale.ROOT) + "_ingot";
				}
				else
				{
					if (size < 2)
					{
						itemname = "planetcore:" + Material[material].toLowerCase(Locale.ROOT) + "_shard";
					}
					else itemname = "planetcore:" + Material[material].toLowerCase(Locale.ROOT);
				}

				item = ItemBase.getByNameOrId(itemname).getDefaultInstance().getItem();

				for (int rock = 0; rock < 3; rock++) {

					if (size == 2)
					{
						blockname = "planetcore:" + Rock[rock].toLowerCase(Locale.ROOT) + "_" + Material[material].toLowerCase(Locale.ROOT);
						block = BlockBase.getBlockFromName(blockname).getBlockState().getBlock();
						GameRegistry.addSmelting(block, new ItemStack(item, Amount[size]), 0.25F * Amount[size]);
					}
					if (size != 2)
					{
						blockname = "planetcore:" + Rock[rock].toLowerCase(Locale.ROOT) + "_" + Size[size].toLowerCase(Locale.ROOT) + "_" + Material[material].toLowerCase(Locale.ROOT);
						block = BlockBase.getBlockFromName(blockname).getBlockState().getBlock();
						GameRegistry.addSmelting(block, new ItemStack(item, Amount[size]), 0.25F * Amount[size]);
					}
				}
			}
		}
/*
		public enum ToolMaterial
		{
			ALUMINIUM(
			LEAD(
			SILICON(
			COPPER(
			ZINC(
			TIN(
			IRON(
			STEEL(
			BRONZE(
			SILVER(
			GOLD(
			PLATINUM(
			TITANIUM(
			URANIUM(
			TOPAZ(
			JADE(
			TUNGSTEN(
			TITANIUM_URANIUM(
			TUNGSTEN_URANIUM(
			TUNGSTEN_TITANIUM(
			EMERALD(
			RUBY(
			SAPPHIRE(
			DIAMOND(
			OLIVINE(
			WADSLEYITE(
			RINGWOODITE(
			BRIGMANITE(
			MAJORITE(
			AMAZONITE(
			ONYX(

	 */


		//GameRegistry.addSmelting(ModBlocks.HARDROCK_COAL, new ItemStack(Items.COAL, 1), 0.75F);
		
		//GameRegistry.addSmelting(ModBlocks.HARDROCK_SULFUR, new ItemStack(ModItems.SULFUR, 1), 0.75F);

		

		//GameRegistry.addSmelting(ModBlocks.HARDROCK_IRON, new ItemStack(ModItems.IRON_INGOT, 1), 0.75F);


		GameRegistry.addSmelting(ModItems.IRON_COAL, new ItemStack(ModItems.STEEL_INGOT, 1), 1.0F);


		//GameRegistry.addSmelting(ModBlocks.HARDROCK_SILVER, new ItemStack(ModItems.SILVER_INGOT, 1), 1.25F);


		//GameRegistry.addSmelting(ModBlocks.HARDROCK_GOLD, new ItemStack(ModItems.GOLD_INGOT, 1), 1.75F);



		//GameRegistry.addSmelting(ModBlocks.HARDROCK_PLATINUM, new ItemStack(ModItems.PLATINUM_INGOT, 1), 2.25F);


		GameRegistry.addSmelting(Blocks.REDSTONE_ORE, new ItemStack(Items.REDSTONE, 5), 1.5F);
		//GameRegistry.addSmelting(ModBlocks.HARDROCK_REDSTONE, new ItemStack(Items.REDSTONE, 6), 1.75F);


		//GameRegistry.addSmelting(ModBlocks.HARDROCK_EMERALD, new ItemStack(Items.EMERALD, 1), 2.25F);



		//GameRegistry.addSmelting(ModBlocks.HARDROCK_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 1), 2.75F);

		

		//GameRegistry.addSmelting(ModBlocks.HARDROCK_RUBY, new ItemStack(ModItems.RUBY, 1), 3.25F);

		

		//GameRegistry.addSmelting(ModBlocks.HARDROCK_TOPAZ, new ItemStack(ModItems.TOPAZ, 1), 3.75F);

		

		//GameRegistry.addSmelting(ModBlocks.HARDROCK_DIAMOND, new ItemStack(ModItems.DIAMOND, 1), 4.25F);


		//GameRegistry.addSmelting(ModBlocks.HARDROCK_JADE, new ItemStack(ModItems.JADE, 1), 4.75F);


		//GameRegistry.addSmelting(ModBlocks.HARDROCK_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 1), 5.25F);

		

		//GameRegistry.addSmelting(ModBlocks.HARDROCK_ONYX, new ItemStack(ModItems.ONYX, 1), 6.25F);



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
