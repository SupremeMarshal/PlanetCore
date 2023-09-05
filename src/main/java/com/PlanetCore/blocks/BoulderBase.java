package com.PlanetCore.blocks;


import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;


public class BoulderBase extends BlockBase {

	public BoulderBase(String name, Material material) {
		super(name, material, false);
		setSoundType(SoundType.STONE);
		setHarvestLevel("pickaxe", 0);
		setTickRandomly(true);
	}
	@Override
	public int getLightValue(IBlockState state) {
		if (this == ModBlocks.BOULDER) return 3;
		else if (this == ModBlocks.HOT_BOULDER) return 6;
		else return (15);
	}
}
