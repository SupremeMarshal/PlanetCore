package com.PlanetCore.blocks;


import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.items.Drills.DrillItem;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


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

	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		return 50;
	}

	@Override
	public float getPlayerRelativeBlockHardness(IBlockState state, EntityPlayer player, World worldIn, BlockPos pos) {
		return player.getHeldItemMainhand().getItem() instanceof DrillItem ? super.getPlayerRelativeBlockHardness(state, player, worldIn, pos) : 0;
	}
}
