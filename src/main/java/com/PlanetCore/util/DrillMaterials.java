package com.PlanetCore.util;

import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.items.Drills.DrillItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum DrillMaterials implements DrillItem.DrillMaterial {
    IRON(7,10000,2, () -> Ingredient.fromStacks(new ItemStack(Blocks.IRON_BLOCK))),
    diamond(7,10000,2, () -> Ingredient.fromStacks(new ItemStack(Blocks.DIAMOND_BLOCK))),
    titanium(7,10000,2, () -> Ingredient.fromStacks(new ItemStack(ModBlocks.TITANIUM_BLOCK))),
    uranium(7,10000,2, () -> Ingredient.fromStacks(new ItemStack(ModBlocks.URANIUM_BLOCK))),
    tungsten(7,10000, 2,() -> Ingredient.fromStacks(new ItemStack(ModBlocks.TUNGSTEN_BLOCK))),
    ruby(7,10000,2, () -> Ingredient.fromStacks(new ItemStack(ModBlocks.RUBY_BLOCK))),
    sapphire(7,10000,2, () -> Ingredient.fromStacks(new ItemStack(ModBlocks.SAPPHIRE_BLOCK))),
    majorite(7,10000,2, () -> Ingredient.fromStacks(new ItemStack(ModBlocks.MAJORITE_BLOCK))),
    amazonite(7,10000,2, () -> Ingredient.fromStacks(new ItemStack(ModBlocks.AMAZONITE_BLOCK))),
    onyx(7,10000,2, () -> Ingredient.fromStacks(new ItemStack(ModBlocks.ONYX_BLOCK)));

    private final float miningSpeed;
    private final int durability;
    private final int harvestLevel;
    private final LazyLoadedValue<Ingredient> repairIngredient;


    DrillMaterials(float mining_speed, int durability,int harvestLevel, Supplier<Ingredient> repairMaterial) {
        miningSpeed = mining_speed;
        this.durability = durability;
        this.harvestLevel = harvestLevel;
        repairIngredient = new LazyLoadedValue<>(repairMaterial);
    }

    @Override
    public float getMiningSpeed() {
        return miningSpeed;
    }

    @Override
    public int getDurability() {
        return durability;
    }

    @Override
    public int getHarvestLevel() {
        return harvestLevel;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairIngredient.get();
    }
}
