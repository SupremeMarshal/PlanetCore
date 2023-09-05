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


public class BlockBase extends Block {

	private final boolean mineral;

	public BlockBase(String name, Material material, boolean mineral) {
		super(material);
		this.mineral = mineral;
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		ModBlocks.BLOCKS.add(this);
		setSoundType(SoundType.METAL);
	}

	/**
	 * Previous hardness's value + (3*Meta)
	 * public static int recursive(int in) {
	 *    return (in != 0) ? (recursive(in-1) + 3 * in) : 3;
	 * }
	 */


	@Override
	public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
		if (this == ModBlocks.LOWERMANTLE_BOULDER)
			return 15;
		else if (this == ModBlocks.HOT_BOULDER)
			return 4;
		else return super.getLightValue(state, world, pos);
	}

	/**
	 * cause the terrain to close on itself, creating a pressure effect inside the planet.
	 * @param worldIn
	 * @param pos
	 * @param state
	 * @param rand
	 */



	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		if ((this == ModBlocks.SLATE) && pos.getY() <= -512) {


			/**
			 * The pressure effect occur more and more below -512Y. The pressure effect cause the terrain to close on itself.
			 */
			if (Math.random() >= (pos.getY() + 512) * -0.000025) {
				return;
			}
			for (EnumFacing side : EnumFacing.values()) {
				BlockPos movedPos = pos.offset(side);
				IBlockState movedState = worldIn.getBlockState(movedPos);
				if (movedState.getMaterial() == Material.IRON) return;
				if (movedState == Blocks.AIR.getDefaultState()) {
					continue;
				}
				EnumFacing[] sides = Arrays.stream(EnumFacing.VALUES)
						.filter(s -> !movedPos.offset(s).equals(pos) && getCachedBlocks().contains(worldIn.getBlockState(movedPos.offset(s)).getBlock()))
						.toArray(EnumFacing[]::new);
				if (sides.length == 0) {
					continue;
				}
				worldIn.setBlockState(movedPos.offset(sides[rand.nextInt(sides.length)]), movedState);
				worldIn.setBlockState(movedPos, worldIn.getBlockState(pos));
				return;
			}
		}
	}

	//replace this with tags in 1.13+
	private static HashSet<Block> cache = new HashSet<>();

	private static HashSet<Block> getCachedBlocks() {
		if (cache.isEmpty()) {
			for (Block block: Block.REGISTRY) {
				if (block == Blocks.AIR
						|| block instanceof BlockLadder
						|| block.getMaterial(block.getDefaultState()) == Material.WATER
						|| block instanceof BlockTorch
						|| block instanceof BlockBanner
						|| block instanceof BlockBasePressurePlate
						|| block instanceof BlockBrewingStand
						|| block instanceof BlockBed
						|| block instanceof BlockBush
						|| block instanceof BlockButton
						|| block instanceof BlockCactus
						|| block instanceof BlockDirt
						|| block instanceof BlockCake
						|| block instanceof BlockCarpet) {
					cache.add(block);
				}
			}
		}
		return cache;
	}

	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon) {
		return mineral;
	}
}
