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

public class CrustrockOreSmall extends Crustrock implements IMetaName {

    private static final float [] crustHardnessByMeta = {3, 6, 12};
    public final PlanetMaterial planetMaterial;
    public final PlanetHardness planetHardness;

    public CrustrockOreSmall(String name, Material material, PlanetMaterial planetMaterial, PlanetHardness planetHardness)
    {
        super(name, material);
        this.planetMaterial = planetMaterial;
        this.planetHardness = planetHardness;
    }

    @Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        int meta = getMetaFromState(blockState);
        return (planetHardness.hardness / 2) + crustHardnessByMeta[meta];
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
            if (this == ModBlocks.CRUSTROCK_SMALL_SULFUR || this == ModBlocks.CRUSTROCK_SMALL_COAL) {
                i = MathHelper.getInt(rand, 0, 1);
            } else if (this == ModBlocks.CRUSTROCK_SMALL_LAPIS) {
                i = MathHelper.getInt(rand, 0, 2);
            }
            return i;
        }
        else return 0;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (this == ModBlocks.CRUSTROCK_SMALL_REDSTONE || this == ModBlocks.CRUSTROCK_SMALL_LAPIS)
        {
            return 8 + new Random().nextInt(fortune * 4 + 4);
        }
        else return 2 + random.nextInt(fortune * 2 + 1);
    }
}
