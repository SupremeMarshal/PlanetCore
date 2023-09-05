package com.PlanetCore.blocks;


import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;


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
}
