package com.PlanetCore.items.shields;

import com.PlanetCore.init.ModBlocks;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum ShieldMaterial {

    ONYXV("ONYXV", () -> Ingredient.fromItem(Item.getItemFromBlock(ModBlocks.PAINITE_BLOCK))),
    ONYXIV("ONYXIV", () -> Ingredient.fromItem(Item.getItemFromBlock(ModBlocks.PAINITE_BLOCK))),
    ONYXIII("ONYXIII", () -> Ingredient.fromItem(Item.getItemFromBlock(ModBlocks.ONYX_BLOCK))),
    ONYXII("ONYXII", () -> Ingredient.fromItem(Item.getItemFromBlock(ModBlocks.PAINITE_BLOCK))),
    ONYX("ONYX", () -> Ingredient.fromItem(Item.getItemFromBlock(ModBlocks.ONYX_BLOCK))),
    AMAZONITE("AMAZONITE", () -> Ingredient.fromItem(Item.getItemFromBlock(ModBlocks.AMAZONITE_BLOCK))),
    MAJORITE("MAJORITE", () -> Ingredient.fromItem(Item.getItemFromBlock(ModBlocks.MAJORITE_BLOCK))),
    SAPPHIRE("SAPPHIRE", () -> Ingredient.fromItem(Item.getItemFromBlock(ModBlocks.SAPPHIRE_BLOCK))),
    RUBY("RUBY", () -> Ingredient.fromItem(Item.getItemFromBlock(ModBlocks.RUBY_BLOCK))),
    TUNGSTEN("TUNGSTEN", () -> Ingredient.fromItem(Item.getItemFromBlock(ModBlocks.TUNGSTEN_BLOCK))),
    URANIUM("URANIUM", () -> Ingredient.fromItem(Item.getItemFromBlock(ModBlocks.URANIUM_BLOCK))),
    TITANIUM("TITANIUM", () -> Ingredient.fromItem(Item.getItemFromBlock(ModBlocks.TITANIUM_BLOCK))),
    DIAMOND("DIAMOND", () -> Ingredient.fromItem(Item.getItemFromBlock(Blocks.DIAMOND_BLOCK))),
    GOLD("GOLD", () -> Ingredient.fromItem(Item.getItemFromBlock(Blocks.GOLD_BLOCK))),
    SILVER("SILVER", () -> Ingredient.fromItem(Item.getItemFromBlock(ModBlocks.SILVER_BLOCK))),
    IRON("IRON", () -> Ingredient.fromItem(Item.getItemFromBlock(Blocks.IRON_BLOCK)));

    private final String itemShield;
    public final Supplier<Ingredient> repairMaterial;

    ShieldMaterial(String itemShield, Supplier<Ingredient> repairMaterial) {
        this.itemShield = itemShield;
        this.repairMaterial = repairMaterial;
    }

    public Ingredient getRepairMaterial() {
        return repairMaterial.get();
    }
}
