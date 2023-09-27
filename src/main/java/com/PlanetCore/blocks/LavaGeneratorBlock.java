package com.PlanetCore.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;

public class LavaGeneratorBlock extends Block {

    public static final PropertyInteger LEVEL = PropertyInteger.create("level",0,9);
    public LavaGeneratorBlock(Material materialIn) {
        super(materialIn);
        setDefaultState(getDefaultState().withProperty(LEVEL,0));
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(LEVEL);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(LEVEL,meta);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this,LEVEL);
    }
}
