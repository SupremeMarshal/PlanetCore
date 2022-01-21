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

public class MantlerockOreCompact extends Mantlerock implements IMetaName {

    public final PlanetMaterial planetMaterial;
    public final PlanetHardness planetHardness;
    private static final float [] mantleHardnessByMeta = {60, 70, 100, 150, 200, 250};

    public MantlerockOreCompact(String name, Material material, PlanetMaterial planetMaterial, PlanetHardness planetHardness)
    {
        super(name, material);
        this.planetMaterial = planetMaterial;
        this.planetHardness = planetHardness;
    }

    @Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        int meta = getMetaFromState(blockState);
        if (planetHardness.hardness < mantleHardnessByMeta[meta])
        {
            return mantleHardnessByMeta[meta];
        }
        return planetHardness.hardness;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int i) {
        return this.planetMaterial.droppedItem;
    }


    @Override
    public int damageDropped(IBlockState state) {
        if (this == ModBlocks.MANTLEROCK_COMPACT_LAPIS) {
            return EnumDyeColor.BLUE.getDyeDamage();
        }
        else return 0;
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
            int i = 0;
            if (this == ModBlocks.MANTLEROCK_COMPACT_SULFUR || this == ModBlocks.MANTLEROCK_COMPACT_COAL) {
                i = MathHelper.getInt(rand, 3, 6);
            } else if (this == ModBlocks.MANTLEROCK_COMPACT_LAPIS) {
                i = MathHelper.getInt(rand, 3, 9);
            } else if (this == ModBlocks.MANTLEROCK_COMPACT_JADE) {
                i = MathHelper.getInt(rand, 6, 12);
            } else if (this == ModBlocks.MANTLEROCK_COMPACT_RUBY || this == ModBlocks.MANTLEROCK_COMPACT_SAPPHIRE || this == ModBlocks.MANTLEROCK_COMPACT_DIAMOND) {
                i = MathHelper.getInt(rand, 9, 18);
            } else if (this == ModBlocks.MANTLEROCK_COMPACT_OLIVINE || this == ModBlocks.MANTLEROCK_COMPACT_WADSLEYITE || this == ModBlocks.MANTLEROCK_COMPACT_RINGWOODITE || this == ModBlocks.MANTLEROCK_COMPACT_BRIGMANITE || this == ModBlocks.MANTLEROCK_COMPACT_MAJORITE) {
                i = MathHelper.getInt(rand, 18, 36);
            } else if (this == ModBlocks.MANTLEROCK_COMPACT_AMAZONITE) {
                i = MathHelper.getInt(rand, 36, 72);
            }
            return i;
        }
        else return 0;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (this == ModBlocks.MANTLEROCK_COMPACT_REDSTONE || this == ModBlocks.MANTLEROCK_COMPACT_LAPIS)
        {
            return 12 + new Random().nextInt(fortune * 6 + 6);
        }
        else return 3 + random.nextInt(fortune * 3 + 1);
    }
}
