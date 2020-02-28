package com.PlanetCore.init;


import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraftforge.fml.common.registry.GameRegistry;

import java.util.Iterator;
import java.util.Map;

public class ModSmelting {

	public static void init()
	{
		GameRegistry.addSmelting(ModBlocks.HARDSTONE_COAL, new ItemStack(Items.COAL, 1), 0.75F);
		GameRegistry.addSmelting(ModBlocks.DEEPSTONE_COAL, new ItemStack(Items.COAL, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CRUSTROCK_COAL, new ItemStack(Items.COAL, 3), 1.5F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_COAL, new ItemStack(Items.COAL, 4), 2.0F);
		GameRegistry.addSmelting(ModBlocks.LOWER_MANTLEROCK_COAL, new ItemStack(Items.COAL, 4), 2.25F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_COAL, new ItemStack(Items.COAL, 5), 2.5F);
		GameRegistry.addSmelting(ModBlocks.INNERCORESTONE_COAL, new ItemStack(Items.COAL, 7), 3.0F);
		GameRegistry.addSmelting(ModBlocks.CENTERCORESTONE_COAL, new ItemStack(Items.COAL, 9), 3.5F);
		
		GameRegistry.addSmelting(ModBlocks.HARDSTONE_SULFUR, new ItemStack(ModItems.SULFUR, 1), 0.75F);
		GameRegistry.addSmelting(ModBlocks.DEEPSTONE_SULFUR, new ItemStack(ModItems.SULFUR, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CRUSTROCK_SULFUR, new ItemStack(ModItems.SULFUR, 3), 1.5F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_SULFUR, new ItemStack(ModItems.SULFUR, 4), 2.0F);
		GameRegistry.addSmelting(ModBlocks.LOWER_MANTLEROCK_SULFUR, new ItemStack(ModItems.SULFUR, 4), 2.25F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_SULFUR, new ItemStack(ModItems.SULFUR, 5), 2.5F);
		GameRegistry.addSmelting(ModBlocks.INNERCORESTONE_SULFUR, new ItemStack(ModItems.SULFUR, 7), 3.0F);
		GameRegistry.addSmelting(ModBlocks.CENTERCORESTONE_SULFUR, new ItemStack(ModItems.SULFUR, 9), 3.5F);
		
		GameRegistry.addSmelting(ModBlocks.IRON_ORE, new ItemStack(ModItems.IRON_INGOT, 1), 0.5F);
		GameRegistry.addSmelting(ModBlocks.HARDSTONE_IRON, new ItemStack(ModItems.IRON_INGOT, 1), 0.75F);
		GameRegistry.addSmelting(ModBlocks.DEEPSTONE_IRON, new ItemStack(ModItems.IRON_INGOT, 2), 1.0F);
		GameRegistry.addSmelting(ModBlocks.CRUSTROCK_IRON, new ItemStack(ModItems.IRON_INGOT, 3), 1.5F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_IRON, new ItemStack(ModItems.IRON_INGOT, 4), 2.0F);
		GameRegistry.addSmelting(ModBlocks.LOWER_MANTLEROCK_IRON, new ItemStack(ModItems.IRON_INGOT, 4), 2.25F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_IRON, new ItemStack(ModItems.IRON_INGOT, 5), 2.5F);
		GameRegistry.addSmelting(ModBlocks.INNERCORESTONE_IRON, new ItemStack(ModItems.IRON_INGOT, 6), 3.0F);
		GameRegistry.addSmelting(ModBlocks.CENTERCORESTONE_IRON, new ItemStack(ModItems.IRON_INGOT, 7), 3.5F);

		GameRegistry.addSmelting(ModItems.IRON_COAL, new ItemStack(ModItems.STEEL_INGOT, 1), 1.0F);

		GameRegistry.addSmelting(ModBlocks.SILVER_ORE, new ItemStack(ModItems.SILVER_INGOT, 1), 1.0F);
		GameRegistry.addSmelting(ModBlocks.HARDSTONE_SILVER, new ItemStack(ModItems.SILVER_INGOT, 1), 1.25F);
		GameRegistry.addSmelting(ModBlocks.DEEPSTONE_SILVER, new ItemStack(ModItems.SILVER_INGOT, 1), 1.5F);
		GameRegistry.addSmelting(ModBlocks.CRUSTROCK_SILVER, new ItemStack(ModItems.SILVER_INGOT, 1), 2.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_SILVER, new ItemStack(ModItems.SILVER_INGOT, 2), 4.0F);
		GameRegistry.addSmelting(ModBlocks.LOWER_MANTLEROCK_SILVER, new ItemStack(ModItems.SILVER_INGOT, 2), 5.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_SILVER, new ItemStack(ModItems.SILVER_INGOT, 3), 6.0F);
		GameRegistry.addSmelting(ModBlocks.INNERCORESTONE_SILVER, new ItemStack(ModItems.SILVER_INGOT, 4), 8.0F);
		GameRegistry.addSmelting(ModBlocks.CENTERCORESTONE_SILVER, new ItemStack(ModItems.SILVER_INGOT, 5), 10.0F);

		GameRegistry.addSmelting(ModBlocks.GOLD_ORE, new ItemStack(ModItems.GOLD_INGOT, 1), 1.5F);
		GameRegistry.addSmelting(ModBlocks.HARDSTONE_GOLD, new ItemStack(ModItems.GOLD_INGOT, 1), 1.75F);
		GameRegistry.addSmelting(ModBlocks.DEEPSTONE_GOLD, new ItemStack(ModItems.GOLD_INGOT, 1), 2.0F);
		GameRegistry.addSmelting(ModBlocks.CRUSTROCK_GOLD, new ItemStack(ModItems.GOLD_INGOT, 1), 2.5F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_GOLD, new ItemStack(ModItems.GOLD_INGOT, 2), 5.0F);
		GameRegistry.addSmelting(ModBlocks.LOWER_MANTLEROCK_GOLD, new ItemStack(ModItems.GOLD_INGOT, 2), 6.25F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_GOLD, new ItemStack(ModItems.GOLD_INGOT, 3), 7.5F);
		GameRegistry.addSmelting(ModBlocks.INNERCORESTONE_GOLD, new ItemStack(ModItems.GOLD_INGOT, 4), 10.0F);
		GameRegistry.addSmelting(ModBlocks.CENTERCORESTONE_GOLD, new ItemStack(ModItems.GOLD_INGOT, 5), 12.5F);

		GameRegistry.addSmelting(ModBlocks.PLATINUM_ORE, new ItemStack(ModItems.PLATINUM_INGOT, 1), 2F);
		GameRegistry.addSmelting(ModBlocks.HARDSTONE_PLATINUM, new ItemStack(ModItems.PLATINUM_INGOT, 1), 2.25F);
		GameRegistry.addSmelting(ModBlocks.DEEPSTONE_PLATINUM, new ItemStack(ModItems.PLATINUM_INGOT, 1), 2.5F);
		GameRegistry.addSmelting(ModBlocks.CRUSTROCK_PLATINUM, new ItemStack(ModItems.PLATINUM_INGOT, 1), 3.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_PLATINUM, new ItemStack(ModItems.PLATINUM_INGOT, 2), 6.0F);
		GameRegistry.addSmelting(ModBlocks.LOWER_MANTLEROCK_PLATINUM, new ItemStack(ModItems.PLATINUM_INGOT, 2), 7.5F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_PLATINUM, new ItemStack(ModItems.PLATINUM_INGOT, 3), 9.0F);
		GameRegistry.addSmelting(ModBlocks.INNERCORESTONE_PLATINUM, new ItemStack(ModItems.PLATINUM_INGOT, 4), 12.0F);
		GameRegistry.addSmelting(ModBlocks.CENTERCORESTONE_PLATINUM, new ItemStack(ModItems.PLATINUM_INGOT, 5), 15.0F);

		GameRegistry.addSmelting(Blocks.REDSTONE_ORE, new ItemStack(Items.REDSTONE, 5), 1.5F);
		GameRegistry.addSmelting(ModBlocks.HARDSTONE_REDSTONE, new ItemStack(Items.REDSTONE, 6), 1.75F);
		GameRegistry.addSmelting(ModBlocks.DEEPSTONE_REDSTONE, new ItemStack(Items.REDSTONE, 7), 2.0F);
		GameRegistry.addSmelting(ModBlocks.CRUSTROCK_REDSTONE, new ItemStack(Items.REDSTONE, 10), 3.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_REDSTONE, new ItemStack(Items.REDSTONE, 14), 4.0F);
		GameRegistry.addSmelting(ModBlocks.LOWER_MANTLEROCK_REDSTONE, new ItemStack(Items.REDSTONE, 16), 4.5F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_REDSTONE, new ItemStack(Items.REDSTONE, 18), 5.0F);
		GameRegistry.addSmelting(ModBlocks.INNERCORESTONE_REDSTONE, new ItemStack(Items.REDSTONE, 22), 6.0F);
		GameRegistry.addSmelting(ModBlocks.CENTERCORESTONE_REDSTONE, new ItemStack(Items.REDSTONE, 26), 7.0F);

		GameRegistry.addSmelting(ModBlocks.HARDSTONE_EMERALD, new ItemStack(Items.EMERALD, 1), 2.25F);
		GameRegistry.addSmelting(ModBlocks.DEEPSTONE_EMERALD, new ItemStack(Items.EMERALD, 1), 2.5F);
		GameRegistry.addSmelting(ModBlocks.CRUSTROCK_EMERALD, new ItemStack(Items.EMERALD, 1), 3.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_EMERALD, new ItemStack(Items.EMERALD, 1), 3.5F);
		GameRegistry.addSmelting(ModBlocks.LOWER_MANTLEROCK_EMERALD, new ItemStack(Items.EMERALD, 1), 5.25F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_EMERALD, new ItemStack(Items.EMERALD, 1), 7.0F);
		GameRegistry.addSmelting(ModBlocks.INNERCORESTONE_EMERALD, new ItemStack(Items.EMERALD, 1), 10.5F);
		GameRegistry.addSmelting(ModBlocks.CENTERCORESTONE_EMERALD, new ItemStack(Items.EMERALD, 1), 14.0F);

		GameRegistry.addSmelting(ModBlocks.SAPPHIRE_ORE, new ItemStack(ModItems.SAPPHIRE, 1), 2.5F);
		GameRegistry.addSmelting(ModBlocks.HARDSTONE_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 1), 2.75F);
		GameRegistry.addSmelting(ModBlocks.DEEPSTONE_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 1), 3.0F);
		GameRegistry.addSmelting(ModBlocks.CRUSTROCK_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 1), 3.5F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 1), 4.0F);
		GameRegistry.addSmelting(ModBlocks.LOWER_MANTLEROCK_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 1), 6.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 1), 8.0F);
		GameRegistry.addSmelting(ModBlocks.INNERCORESTONE_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 1), 12.0F);
		GameRegistry.addSmelting(ModBlocks.CENTERCORESTONE_SAPPHIRE, new ItemStack(ModItems.SAPPHIRE, 1), 16.0F);
		
		GameRegistry.addSmelting(ModBlocks.RUBY_ORE, new ItemStack(ModItems.RUBY, 1), 3.0F);
		GameRegistry.addSmelting(ModBlocks.HARDSTONE_RUBY, new ItemStack(ModItems.RUBY, 1), 3.25F);
		GameRegistry.addSmelting(ModBlocks.DEEPSTONE_RUBY, new ItemStack(ModItems.RUBY, 1), 3.5F);
		GameRegistry.addSmelting(ModBlocks.CRUSTROCK_RUBY, new ItemStack(ModItems.RUBY, 1), 4.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_RUBY, new ItemStack(ModItems.RUBY, 1), 4.5F);
		GameRegistry.addSmelting(ModBlocks.LOWER_MANTLEROCK_RUBY, new ItemStack(ModItems.RUBY, 1), 6.75F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_RUBY, new ItemStack(ModItems.RUBY, 1), 9.0F);
		GameRegistry.addSmelting(ModBlocks.INNERCORESTONE_RUBY, new ItemStack(ModItems.RUBY, 1), 13.5F);
		GameRegistry.addSmelting(ModBlocks.CENTERCORESTONE_RUBY, new ItemStack(ModItems.RUBY, 1), 18.0F);
		
		GameRegistry.addSmelting(ModBlocks.TOPAZ_ORE, new ItemStack(ModItems.TOPAZ, 1), 3.5F);
		GameRegistry.addSmelting(ModBlocks.HARDSTONE_TOPAZ, new ItemStack(ModItems.TOPAZ, 1), 3.75F);
		GameRegistry.addSmelting(ModBlocks.DEEPSTONE_TOPAZ, new ItemStack(ModItems.TOPAZ, 1), 4.0F);
		GameRegistry.addSmelting(ModBlocks.CRUSTROCK_TOPAZ, new ItemStack(ModItems.TOPAZ, 1), 4.5F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_TOPAZ, new ItemStack(ModItems.TOPAZ, 1), 5.0F);
		GameRegistry.addSmelting(ModBlocks.LOWER_MANTLEROCK_TOPAZ, new ItemStack(ModItems.TOPAZ, 1), 7.5F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_TOPAZ, new ItemStack(ModItems.TOPAZ, 1), 10.0F);
		GameRegistry.addSmelting(ModBlocks.INNERCORESTONE_TOPAZ, new ItemStack(ModItems.TOPAZ, 1), 15.0F);
		GameRegistry.addSmelting(ModBlocks.CENTERCORESTONE_TOPAZ, new ItemStack(ModItems.TOPAZ, 1), 20.0F);
		
		GameRegistry.addSmelting(ModBlocks.DIAMOND_ORE, new ItemStack(ModItems.DIAMOND, 1), 4.0F);
		GameRegistry.addSmelting(ModBlocks.HARDSTONE_DIAMOND, new ItemStack(ModItems.DIAMOND, 1), 4.25F);
		GameRegistry.addSmelting(ModBlocks.DEEPSTONE_DIAMOND, new ItemStack(ModItems.DIAMOND, 1), 4.5F);
		GameRegistry.addSmelting(ModBlocks.CRUSTROCK_DIAMOND, new ItemStack(ModItems.DIAMOND, 1), 5.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_DIAMOND, new ItemStack(ModItems.DIAMOND, 1), 5.5F);
		GameRegistry.addSmelting(ModBlocks.LOWER_MANTLEROCK_DIAMOND, new ItemStack(ModItems.DIAMOND, 1), 8.25F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_DIAMOND, new ItemStack(ModItems.DIAMOND, 1), 11.0F);
		GameRegistry.addSmelting(ModBlocks.INNERCORESTONE_DIAMOND, new ItemStack(ModItems.DIAMOND, 1), 16.5F);
		GameRegistry.addSmelting(ModBlocks.CENTERCORESTONE_DIAMOND, new ItemStack(ModItems.DIAMOND, 1), 22.0F);

		GameRegistry.addSmelting(ModBlocks.JADE_ORE, new ItemStack(ModItems.JADE, 1), 4.5F);
		GameRegistry.addSmelting(ModBlocks.HARDSTONE_JADE, new ItemStack(ModItems.JADE, 1), 4.75F);
		GameRegistry.addSmelting(ModBlocks.DEEPSTONE_JADE, new ItemStack(ModItems.JADE, 1), 5.0F);
		GameRegistry.addSmelting(ModBlocks.CRUSTROCK_JADE, new ItemStack(ModItems.JADE, 1), 5.5F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_JADE, new ItemStack(ModItems.JADE, 1), 6.0F);
		GameRegistry.addSmelting(ModBlocks.LOWER_MANTLEROCK_JADE, new ItemStack(ModItems.JADE, 1), 9.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_JADE, new ItemStack(ModItems.JADE, 1), 12.0F);
		GameRegistry.addSmelting(ModBlocks.INNERCORESTONE_JADE, new ItemStack(ModItems.JADE, 1), 18.0F);
		GameRegistry.addSmelting(ModBlocks.CENTERCORESTONE_JADE, new ItemStack(ModItems.JADE, 1), 24.0F);

		GameRegistry.addSmelting(ModBlocks.AMAZONITE_ORE, new ItemStack(ModItems.AMAZONITE, 1), 5.0F);
		GameRegistry.addSmelting(ModBlocks.HARDSTONE_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 1), 5.25F);
		GameRegistry.addSmelting(ModBlocks.DEEPSTONE_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 1), 5.5F);
		GameRegistry.addSmelting(ModBlocks.CRUSTROCK_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 1), 6.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 1), 6.5F);
		GameRegistry.addSmelting(ModBlocks.LOWER_MANTLEROCK_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 1), 9.75F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 1), 13.0F);
		GameRegistry.addSmelting(ModBlocks.INNERCORESTONE_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 1), 19.5F);
		GameRegistry.addSmelting(ModBlocks.CENTERCORESTONE_AMAZONITE, new ItemStack(ModItems.AMAZONITE, 1), 26.0F);

		GameRegistry.addSmelting(ModBlocks.AMETHYST_ORE, new ItemStack(ModItems.AMETHYST, 1), 5.5F);
		GameRegistry.addSmelting(ModBlocks.HARDSTONE_AMETHYST, new ItemStack(ModItems.AMETHYST, 1), 5.75F);
		GameRegistry.addSmelting(ModBlocks.DEEPSTONE_AMETHYST, new ItemStack(ModItems.AMETHYST, 1), 6.0F);
		GameRegistry.addSmelting(ModBlocks.CRUSTROCK_AMETHYST, new ItemStack(ModItems.AMETHYST, 1), 6.5F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_AMETHYST, new ItemStack(ModItems.AMETHYST, 1), 7.0F);
		GameRegistry.addSmelting(ModBlocks.LOWER_MANTLEROCK_AMETHYST, new ItemStack(ModItems.AMETHYST, 1), 10.5F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_AMETHYST, new ItemStack(ModItems.AMETHYST, 1), 14.0F);
		GameRegistry.addSmelting(ModBlocks.INNERCORESTONE_AMETHYST, new ItemStack(ModItems.AMETHYST, 1), 21.0F);
		GameRegistry.addSmelting(ModBlocks.CENTERCORESTONE_AMETHYST, new ItemStack(ModItems.AMETHYST, 1), 28.0F);
		
		GameRegistry.addSmelting(ModBlocks.ONYX_ORE, new ItemStack(ModItems.ONYX, 1), 6.0F);
		GameRegistry.addSmelting(ModBlocks.HARDSTONE_ONYX, new ItemStack(ModItems.ONYX, 1), 6.25F);
		GameRegistry.addSmelting(ModBlocks.DEEPSTONE_ONYX, new ItemStack(ModItems.ONYX, 1), 6.5F);
		GameRegistry.addSmelting(ModBlocks.CRUSTROCK_ONYX, new ItemStack(ModItems.ONYX, 1), 7.0F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_ONYX, new ItemStack(ModItems.ONYX, 1), 7.5F);
		GameRegistry.addSmelting(ModBlocks.LOWER_MANTLEROCK_ONYX, new ItemStack(ModItems.ONYX, 1), 11.25F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_ONYX, new ItemStack(ModItems.ONYX, 1), 15.0F);
		GameRegistry.addSmelting(ModBlocks.INNERCORESTONE_ONYX, new ItemStack(ModItems.ONYX, 1), 22.5F);
		GameRegistry.addSmelting(ModBlocks.CENTERCORESTONE_ONYX, new ItemStack(ModItems.ONYX, 1), 30.0F);
		
		GameRegistry.addSmelting(ModBlocks.AZURITE_ORE, new ItemStack(ModItems.AZURITE, 1), 6.5F);
		GameRegistry.addSmelting(ModBlocks.HARDSTONE_AZURITE, new ItemStack(ModItems.AZURITE, 1), 6.75F);
		GameRegistry.addSmelting(ModBlocks.DEEPSTONE_AZURITE, new ItemStack(ModItems.AZURITE, 1), 7.0F);
		GameRegistry.addSmelting(ModBlocks.CRUSTROCK_AZURITE, new ItemStack(ModItems.AZURITE, 1), 7.5F);
		GameRegistry.addSmelting(ModBlocks.MANTLEROCK_AZURITE, new ItemStack(ModItems.AZURITE, 1), 8.0F);
		GameRegistry.addSmelting(ModBlocks.LOWER_MANTLEROCK_AZURITE, new ItemStack(ModItems.AZURITE, 1), 12.0F);
		GameRegistry.addSmelting(ModBlocks.CORESTONE_AZURITE, new ItemStack(ModItems.AZURITE, 1), 16.0F);
		GameRegistry.addSmelting(ModBlocks.INNERCORESTONE_AZURITE, new ItemStack(ModItems.AZURITE, 1), 24.0F);
		GameRegistry.addSmelting(ModBlocks.CENTERCORESTONE_AZURITE, new ItemStack(ModItems.AZURITE, 1), 32.0F);

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
