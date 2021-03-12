package com.PlanetCore.util.handlers;

import com.PlanetCore.init.ModItems;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

import java.util.ArrayList;
import java.util.List;

public class AnvilRecipeHolder {
    public static final List<AnvilRecipeHolder> ANVIL_RECIPES = new ArrayList<>();

    public static void initAnvilRecipes() {



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