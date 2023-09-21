package com.PlanetCore.blocks;


import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
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
	public Item getItemDropped(IBlockState state, Random random, int l) {
		if (this == ModBlocks.SUPERCOMPRESSED_COAL) return Items.COAL;
		else return super.getItemDropped(state, random, l);
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (this == ModBlocks.SUPERCOMPRESSED_COAL) {
			if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState) this.getBlockState().getValidStates().iterator().next(), random, fortune)) {
				int i = random.nextInt(fortune + 2) + 8;

				if (i < 0) {
					i = 0;
				}

				return this.quantityDropped(random) * (i + 1);
			} else {
				return this.quantityDropped(random) + 8;
			}
		}
		else return 1;
	}

	@Override
	public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
		if (this == ModBlocks.LOWERMANTLE_BOULDER)
			return 15;
		else if (this == ModBlocks.HOT_BOULDER)
			return 4;
		else return super.getLightValue(state, world, pos);
	}

	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		double hardness = 0;
		double Y = pos.getY();
		if (Y < 0 && Y >= -1200)
		{
			hardness = Y * -0.02916666f + 3;
		}
		else if (Y < -1200 && Y >= -2000)
		{
			hardness = (Y + 1200) * -0.09 + 39;
		}
		else if (Y < -2000 && Y >= -2500)
		{
			hardness = (Y + 2000) * -0.072 + 111;
		}
		else if (Y < -2500 && Y >= -3000)
		{
			hardness = (Y + 2500) * -0.144 + 147;
		}
		else if (Y < -3000 && Y >= -4000)
		{
			hardness = (Y + 3000) * -0.144 + 219;
		}
		else if (Y < -4000 && Y >= -5000)
		{
			hardness = (Y + 4000) * -0.18 + 363;
		}
		else if (Y < -5000 && Y >= -5500)
		{
			hardness = (Y + 5000) * -0.54 + 543;
		}
		else if (Y < -5500 && Y >= -6000)
		{
			hardness = (Y + 5500) * -0.81 + 813;
		}
		else if (Y < -6000)
		{
			hardness = (Y + 6000) * -1.636118598 + 1218;
		}
		else return 3;
		return (float) hardness;
	}

	@Override
	public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
		if (!world.isRemote) {
			Item droppedItem = Item.getItemFromBlock(this);
			ItemStack itemStackToDrop = new ItemStack(droppedItem, 1);

			double x = pos.getX();
			double y = pos.getY();
			double z = pos.getZ();

			EntityItem entityItem = new EntityItem(world, x, y, z, itemStackToDrop);
			entityItem.setPickupDelay(10); // 10 tick pickup delay

			world.spawnEntity(entityItem);
		}

		// Remove the block
		world.setBlockToAir(pos);
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
