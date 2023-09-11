package com.PlanetCore.blocks;


import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;


public class MagmaBase extends BlockBase {

	public MagmaBase(String name, Material material) {
		super(name, material, false);
		setSoundType(SoundType.STONE);
		setHarvestLevel("pickaxe", 0);
		setTickRandomly(true);
	}

	@Override
	public int getLightValue(IBlockState state) {
		if (this == ModBlocks.MANTLE_MAGMA) return 6;
		else return (15);
	}

	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		int Y = pos.getY();
		if (Y < -400 && Math.random() < 0.5 && (worldIn.isAirBlock(pos.up()))) {
			{
				if (this == ModBlocks.MANTLE_MAGMA) worldIn.setBlockState(pos.up(), Blocks.FIRE.getDefaultState(), 11);
				else if (this == ModBlocks.LOWERMANTLE_MAGMA) worldIn.setBlockState(pos.up(), ModBlocks.HOT_FIRE.getDefaultState(), 11);
				else if (this == ModBlocks.OUTERCORE_MAGMA || this == ModBlocks.INNERCORE_MAGMA) worldIn.setBlockState(pos.up(), ModBlocks.CORE_FIRE.getDefaultState(), 11);
				else worldIn.setBlockState(pos.up(), Blocks.FIRE.getDefaultState(), 11);
			}
		}
		super.randomTick(worldIn, pos, state, rand);
	}
}
