package com.PlanetCore.blocks;

import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;

public class GasBase extends BlockBase 
{

	public GasBase(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
		
		}

	@Override
	public Item getItemDropped(IBlockState state, Random random, int l)
	{
	return null;
	}

	@Override
	public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer entity, boolean willHarvest) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		Block block = this;

		if (block == ModBlocks.MANTLEGAS && !world.isRemote)
		{
			world.createExplosion(null, (int)x, (int)y, (int)z, 5, true);
		}

		return super.removedByPlayer(state, world, pos, entity, willHarvest);
	}

	public void onExplosionDestroy(World worldIn, BlockPos pos, Explosion explosionIn)
	{
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		Block block = this;
		if (block == ModBlocks.MANTLEGAS && !worldIn.isRemote)
		{
			worldIn.createExplosion(null, (int)x, (int)y, (int)z, 3, true);
		}
	}

}
	

