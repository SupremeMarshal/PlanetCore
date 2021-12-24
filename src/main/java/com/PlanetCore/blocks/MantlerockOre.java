package com.PlanetCore.blocks;

import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.util.IMetaName;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class MantlerockOre extends Mantlerock implements IMetaName {

    public final PlanetMaterial planetMaterial;
    public final PlanetHardness planetHardness;
    private static final float [] mantleHardnessByMeta = {12, 21, 36, 71, 100, 150, 200, 250, 300, 400, 500, 600, 700, 800, 900, 1000};

    public MantlerockOre(String name, Material material, PlanetMaterial planetMaterial, PlanetHardness planetHardness)
    {
        super(name, material);
        this.planetMaterial = planetMaterial;
        this.planetHardness = planetHardness;
    }

    @Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        int meta = getMetaFromState(blockState);
        return planetHardness.hardness + mantleHardnessByMeta[meta];
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int i) {
        return this.planetMaterial.droppedItem;
    }

    @Override
    public int damageDropped(IBlockState state) {
        if (this == ModBlocks.MANTLEROCK_LAPIS) {
            return EnumDyeColor.BLUE.getDyeDamage();
        }
        else return 0;
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
            int i = 0;
            if (this == ModBlocks.MANTLEROCK_SULFUR || this == ModBlocks.MANTLEROCK_COAL) {
                i = MathHelper.getInt(rand, 1, 2);
            } else if (this == ModBlocks.MANTLEROCK_LAPIS) {
                i = MathHelper.getInt(rand, 1, 3);
            } else if (this == ModBlocks.MANTLEROCK_EMERALD) {
                i = MathHelper.getInt(rand, 2, 4);
            } else if (this == ModBlocks.MANTLEROCK_RUBY || this == ModBlocks.MANTLEROCK_SAPPHIRE || this == ModBlocks.MANTLEROCK_DIAMOND) {
                i = MathHelper.getInt(rand, 3, 6);
            } else if (this == ModBlocks.MANTLEROCK_OLIVINE || this == ModBlocks.MANTLEROCK_WADSLEYITE || this == ModBlocks.MANTLEROCK_RINGWOODITE || this == ModBlocks.MANTLEROCK_BRIGMANITE || this == ModBlocks.MANTLEROCK_MAJORITE) {
                i = MathHelper.getInt(rand, 6, 12);
            } else if (this == ModBlocks.MANTLEROCK_AMAZONITE) {
                i = MathHelper.getInt(rand, 12, 24);
            }
            return i;
        }
        else return 0;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (this == ModBlocks.MANTLEROCK_REDSTONE || this == ModBlocks.MANTLEROCK_LAPIS)
        {
            return 4 + new Random().nextInt(fortune * 2 + 2);
        }
        else return 1 + random.nextInt(fortune + 1);
    }
}
