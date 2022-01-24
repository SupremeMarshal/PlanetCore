package com.PlanetCore.blocks;

import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.util.IMetaName;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class OreBase extends BlockBase {

    public final PlanetMaterial planetMaterial;
    public final PlanetHardness planetHardness;
    public final PlanetExp planetExp;

    public OreBase(String name, Material material, PlanetMaterial planetMaterial, PlanetHardness planetHardness, PlanetExp planetExp)
    {
        super(name, material);
        this.planetMaterial = planetMaterial;
        this.planetHardness = planetHardness;
        this.planetExp = planetExp;
    }

    @Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        if (planetHardness.hardness < 1.5F)
        {
            return 1.5F;
        }
        return planetHardness.hardness;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int i) {
        return this.planetMaterial.droppedItem;
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
}
