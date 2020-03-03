package com.PlanetCore.util.handlers;

import com.PlanetCore.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class AnvilRecipeHolder {
    public static final List<AnvilRecipeHolder> ANVIL_RECIPES = new ArrayList<>();

    public static void initAnvilRecipes() {

        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_CHESTPLATE, ModItems.EMERALD_CHESTPLATE, ModItems.EMERALD_CHESTPLATE1));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_CHESTPLATE1, ModItems.EMERALD_CHESTPLATE1, ModItems.EMERALD_CHESTPLATE2));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_CHESTPLATE2, ModItems.EMERALD_CHESTPLATE2, ModItems.EMERALD_CHESTPLATE3));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_CHESTPLATE3, ModItems.EMERALD_CHESTPLATE3, ModItems.EMERALD_CHESTPLATE4));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_CHESTPLATE4, ModItems.EMERALD_CHESTPLATE4, ModItems.EMERALD_CHESTPLATE5));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_CHESTPLATE5, ModItems.EMERALD_CHESTPLATE5, ModItems.EMERALD_CHESTPLATE6));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_HELMET, ModItems.EMERALD_HELMET, ModItems.EMERALD_HELMET1));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_HELMET1, ModItems.EMERALD_HELMET1, ModItems.EMERALD_HELMET2));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_HELMET2, ModItems.EMERALD_HELMET2, ModItems.EMERALD_HELMET3));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_HELMET3, ModItems.EMERALD_HELMET3, ModItems.EMERALD_HELMET4));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_HELMET4, ModItems.EMERALD_HELMET4, ModItems.EMERALD_HELMET5));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_HELMET5, ModItems.EMERALD_HELMET5, ModItems.EMERALD_HELMET6));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_LEGGINGS, ModItems.EMERALD_LEGGINGS, ModItems.EMERALD_LEGGINGS1));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_LEGGINGS1, ModItems.EMERALD_LEGGINGS1, ModItems.EMERALD_LEGGINGS2));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_LEGGINGS2, ModItems.EMERALD_LEGGINGS2, ModItems.EMERALD_LEGGINGS3));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_LEGGINGS3, ModItems.EMERALD_LEGGINGS3, ModItems.EMERALD_LEGGINGS4));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_LEGGINGS4, ModItems.EMERALD_LEGGINGS4, ModItems.EMERALD_LEGGINGS5));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_LEGGINGS5, ModItems.EMERALD_LEGGINGS5, ModItems.EMERALD_LEGGINGS6));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_BOOTS, ModItems.EMERALD_BOOTS, ModItems.EMERALD_BOOTS1));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_BOOTS1, ModItems.EMERALD_BOOTS1, ModItems.EMERALD_BOOTS2));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_BOOTS2, ModItems.EMERALD_BOOTS2, ModItems.EMERALD_BOOTS3));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_BOOTS3, ModItems.EMERALD_BOOTS3, ModItems.EMERALD_BOOTS4));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_BOOTS4, ModItems.EMERALD_BOOTS4, ModItems.EMERALD_BOOTS5));
        ANVIL_RECIPES.add(new AnvilRecipeHolder(ModItems.EMERALD_BOOTS5, ModItems.EMERALD_BOOTS5, ModItems.EMERALD_BOOTS6));

    }

    private final Item anvilLeft;
    private final Item anvilRight;
    private final Item anvilResult;


    public AnvilRecipeHolder(Item anvilLeft, Item anvilRight, Item anvilResult) {
        this.anvilLeft = anvilLeft;
        this.anvilRight = anvilRight;
        this.anvilResult = anvilResult;
    }

    public Item getAnvilLeft() {
        return anvilLeft;
    }

    public Item getAnvilRight() {
        return anvilRight;
    }

    public Item getAnvilResult() {
        return anvilResult;
    }
}