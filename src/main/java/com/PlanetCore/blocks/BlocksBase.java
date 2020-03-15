package com.PlanetCore.blocks;




import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;

public class BlocksBase extends BlockBase
{
	public BlocksBase(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.STONE);
		setHarvestLevel("pickaxe", 0);
		setTickRandomly(true);
	}
}
