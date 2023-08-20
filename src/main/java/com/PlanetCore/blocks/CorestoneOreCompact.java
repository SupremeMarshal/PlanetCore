package com.PlanetCore.blocks;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class CorestoneOreCompact extends Corestone {

    public final PlanetMaterial planetMaterial;
    public final PlanetHardness planetHardness;
    public final PlanetExp planetExp;
    private static final float [] coreHardnessByMeta = {80, 160, 320, 640};

    public CorestoneOreCompact(String name, Material material, PlanetMaterial planetMaterial, PlanetHardness planetHardness, PlanetExp planetExp)
    {
        super(name, material);
        this.planetMaterial = planetMaterial;
        this.planetHardness = planetHardness;
        this.planetExp = planetExp;
    }

    @Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        int meta = getMetaFromState(blockState);
        if (planetHardness.hardness < coreHardnessByMeta[meta])
        {
            return coreHardnessByMeta[meta];
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

    @Override
    public int quantityDropped(Random random)
    {
        return 2;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped(this.getBlockState().getValidStates().iterator().next(), random, fortune))
        {
            int i = random.nextInt(fortune + 1) - 1;

            if (i < 0)
            {
                i = 0;
            }

            return this.quantityDropped(random) * (i + 1);
        }
        else
        {
            return this.quantityDropped(random);
        }
    }
}
