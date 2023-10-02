package com.PlanetCore.util;

import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.items.Drills.DrillItem;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum DrillMaterials implements DrillItem.DrillMaterial {
    IRON(7,10000,2, 100000, 50, () -> Ingredient.fromStacks(new ItemStack(Blocks.IRON_BLOCK))),
    diamond(9,20000,3, 500000, 250, () -> Ingredient.fromStacks(new ItemStack(Blocks.DIAMOND_BLOCK))),
    titanium(13,20000,4, 1000000, 500, () -> Ingredient.fromStacks(new ItemStack(ModBlocks.TITANIUM_BLOCK))),
    uranium(16,20000,5, 1000000, 500, () -> Ingredient.fromStacks(new ItemStack(ModBlocks.URANIUM_BLOCK))),
    tungsten(21,30000, 6, 2000000, 1000, () -> Ingredient.fromStacks(new ItemStack(ModBlocks.TUNGSTEN_BLOCK))),
    ruby(30,40000,7, 5000000, 2000, () -> Ingredient.fromStacks(new ItemStack(ModBlocks.RUBY_BLOCK))),
    sapphire(45,50000,8, 10000000, 3000, () -> Ingredient.fromStacks(new ItemStack(ModBlocks.SAPPHIRE_BLOCK))),
    majorite(60,60000,9, 20000000, 4000, () -> Ingredient.fromStacks(new ItemStack(ModBlocks.MAJORITE_BLOCK))),
    amazonite(100,75000,10, 50000000, 5000, () -> Ingredient.fromStacks(new ItemStack(ModBlocks.AMAZONITE_BLOCK))),
    onyx(150,100000,11, 100000000, 10000, () -> Ingredient.fromStacks(new ItemStack(ModBlocks.ONYX_BLOCK)));

    private final float miningSpeed;
    private final int durability;
    private final int harvestLevel;
    private final int capacity;
    private final int consumption;
    private final LazyLoadedValue<Ingredient> repairIngredient;


    DrillMaterials(float mining_speed, int durability, int harvestLevel, int capacity, int consumption, Supplier<Ingredient> repairMaterial) {
        miningSpeed = mining_speed;
        this.durability = durability;
        this.harvestLevel = harvestLevel;
        this.capacity = capacity;
        this.consumption = consumption;
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
    public int getCapacity() {
        return capacity;
    }

    @Override
    public int getConsumption() {
        return consumption;
    }

    @Override
    public Ingredient getRepairMaterial() {
        return repairIngredient.get();
    }
}
