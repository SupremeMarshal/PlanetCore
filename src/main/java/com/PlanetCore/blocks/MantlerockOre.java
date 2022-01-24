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
    public final PlanetExp planetExp;
    private static final float [] mantleHardnessByMeta = {60, 70, 100, 150, 200, 250};

    public MantlerockOre(String name, Material material, PlanetMaterial planetMaterial, PlanetHardness planetHardness, PlanetExp planetExp)
    {
        super(name, material);
        this.planetMaterial = planetMaterial;
        this.planetHardness = planetHardness;
        this.planetExp = planetExp;
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
    public int getHarvestLevel(IBlockState state) {
        return super.getHarvestLevel(state);
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
            int i = MathHelper.getInt(rand, (int) planetExp.exp, (int) planetExp.exp * 2);
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
