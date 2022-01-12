package com.PlanetCore.blocks;

import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class OreCompactBase extends BlockBase {

    public final PlanetMaterial planetMaterial;
    public final PlanetHardness planetHardness;

    public OreCompactBase(String name, Material material, PlanetMaterial planetMaterial, PlanetHardness planetHardness)
    {
        super(name, material);
        this.planetMaterial = planetMaterial;
        this.planetHardness = planetHardness;
    }

    @Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        return planetHardness.hardness * 4 + 1.5F;
    }

    @Override
    public int damageDropped(IBlockState state) {
        if (this == ModBlocks.ORE_COMPACT_LAPIS) {
            return EnumDyeColor.BLUE.getDyeDamage();
        }
        else return 0;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int i) {
        return this.planetMaterial.droppedItem;
    }


    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
            int i = 0;
            if (this == ModBlocks.ORE_COMPACT_SULFUR || this == ModBlocks.ORE_COMPACT_COAL) {
                i = MathHelper.getInt(rand, 2, 4);
            } else if (this == ModBlocks.ORE_COMPACT_LAPIS) {
                i = MathHelper.getInt(rand, 2, 6);
            }
            return i;
        }
        else return 0;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (this == ModBlocks.ORE_COMPACT_REDSTONE || this == ModBlocks.ORE_COMPACT_LAPIS)
        {
            return 12 + new Random().nextInt(fortune * 6 + 6);
        }
        else return 3 + random.nextInt(fortune * 3 + 1);
    }
}
