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

public class MantlerockOreSmall extends Mantlerock implements IMetaName {

    public final PlanetMaterial planetMaterial;
    public final PlanetHardness planetHardness;
    private static final float [] mantleHardnessByMeta = {24, 33, 47, 65, 92, 129, 193, 290, 435, 653, 979, 1469, 2204, 3306, 4959, 7438};

    public MantlerockOreSmall(String name, Material material, PlanetMaterial planetMaterial, PlanetHardness planetHardness)
    {
        super(name, material);
        this.planetMaterial = planetMaterial;
        this.planetHardness = planetHardness;
    }

    @Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        int meta = getMetaFromState(blockState);
        return (planetHardness.hardness / 2) + mantleHardnessByMeta[meta];
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int i) {
        return this.planetMaterial.droppedItem;
    }

    @Override
    public int damageDropped(IBlockState state) {
        if (this == ModBlocks.MANTLEROCK_SMALL_LAPIS) {
            return EnumDyeColor.BLUE.getDyeDamage();
        }
        else return 0;
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
            int i = 0;
            if (this == ModBlocks.MANTLEROCK_SMALL_SULFUR || this == ModBlocks.MANTLEROCK_SMALL_COAL) {
                i = MathHelper.getInt(rand, 0, 1);
            } else if (this == ModBlocks.MANTLEROCK_SMALL_LAPIS) {
                i = MathHelper.getInt(rand, 0, 2);
            } else if (this == ModBlocks.MANTLEROCK_SMALL_EMERALD) {
                i = MathHelper.getInt(rand, 1, 2);
            } else if (this == ModBlocks.MANTLEROCK_SMALL_RUBY || this == ModBlocks.MANTLEROCK_SMALL_SAPPHIRE || this == ModBlocks.MANTLEROCK_SMALL_DIAMOND) {
                i = MathHelper.getInt(rand, 2, 3);
            } else if (this == ModBlocks.MANTLEROCK_SMALL_OLIVINE || this == ModBlocks.MANTLEROCK_SMALL_WADSLEYITE || this == ModBlocks.MANTLEROCK_SMALL_RINGWOODITE || this == ModBlocks.MANTLEROCK_SMALL_BRIGMANITE || this == ModBlocks.MANTLEROCK_SMALL_MAJORITE) {
                i = MathHelper.getInt(rand, 3, 6);
            } else if (this == ModBlocks.MANTLEROCK_SMALL_AMAZONITE) {
                i = MathHelper.getInt(rand, 6, 12);
            }
            return i;
        }
        else return 0;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (this == ModBlocks.MANTLEROCK_SMALL_REDSTONE || this == ModBlocks.MANTLEROCK_SMALL_LAPIS)
        {
            return 8 + new Random().nextInt(fortune * 4 + 4);
        }
        else return 2 + random.nextInt(fortune * 2 + 1);
    }
}
