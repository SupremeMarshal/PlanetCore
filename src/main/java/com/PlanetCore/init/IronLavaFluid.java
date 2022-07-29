package com.PlanetCore.init;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import java.util.Random;


public class IronLavaFluid extends BlockFluidClassic {


	public IronLavaFluid(String name, Fluid fluid, Material material) {
		super(fluid, material);
		setTranslationKey(name);
		setRegistryName(name);
		setDensity(1000);
		setLightLevel(1);
		setTickRate(30);
		ModBlocks.BLOCKS.add(this);

		this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL, Integer.valueOf(0)));
		this.setTickRandomly(true);

	}

	public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{

		if (entityIn instanceof EntityPlayerMP)
		{
			entityIn.setFire(10);
			entityIn.attackEntityFrom(DamageSource.LAVA, 8.0F);
			entityIn.attackEntityFrom(DamageSource.GENERIC, 2.0F);
		}
	}

	public boolean checkForMixing(World worldIn, BlockPos pos, IBlockState state)
	{
		if (this.material == Material.LAVA && this.canCreateSources)
		{
			boolean flag = false;

			for (EnumFacing enumfacing : EnumFacing.values())
			{
				if (enumfacing != EnumFacing.DOWN && worldIn.getBlockState(pos.offset(enumfacing)).getMaterial() == Material.WATER)
				{
					flag = true;
					break;
				}
			}

			if (flag)
			{
				Integer integer = (Integer)state.getValue(LEVEL);

				if (integer.intValue() == 0)
				{
					worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, ModBlocks.IRON_SUPERCOMPACT.getDefaultState()));
					this.triggerMixEffects(worldIn, pos);
					return true;
				}

				if (integer.intValue() <= 4)
				{
					worldIn.setBlockState(pos, net.minecraftforge.event.ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, Blocks.OBSIDIAN.getDefaultState()));
					this.triggerMixEffects(worldIn, pos);
					return true;
				}
			}
		}

		return false;
	}

	protected void triggerMixEffects(World worldIn, BlockPos pos)
	{
		double d0 = (double)pos.getX();
		double d1 = (double)pos.getY();
		double d2 = (double)pos.getZ();
		worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_LAVA_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

		for (int i = 0; i < 8; ++i)
		{
			worldIn.spawnParticle(EnumParticleTypes.SMOKE_LARGE, d0 + Math.random(), d1 + 1.2D, d2 + Math.random(), 0.0D, 0.0D, 0.0D);
		}
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if (!this.checkForMixing(worldIn, pos, state))
		{
			worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
		}
		this.checkForMixing(worldIn, pos, state);
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{
		if (!this.checkForMixing(worldIn, pos, state))
		{
			worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
		}
		this.checkForMixing(worldIn, pos, state);
	}

	@Override
	protected boolean canFlowInto(IBlockAccess world, BlockPos pos)
	{
		return world.getBlockState(pos).getBlock() == this || canDisplace(world, pos);
	}


	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		super.updateTick(worldIn, pos, state, rand);
		float chance = -0.00006103515625F * (pos.getY() + 1024);
		if (pos.getY() <= 0) {
			if (Math.random() < chance && worldIn.getBlockState(pos.up()) == Blocks.AIR.getDefaultState())
				worldIn.setBlockState(pos.up(), ModBlocks.IRON_LAVA_FLUID.getDefaultState());
			if (Math.random() < chance && worldIn.getBlockState(pos.down()) == Blocks.AIR.getDefaultState())
				worldIn.setBlockState(pos.down(), ModBlocks.IRON_LAVA_FLUID.getDefaultState());
			if (Math.random() < chance && worldIn.getBlockState(pos.down()) == Blocks.AIR.getDefaultState())
				worldIn.setBlockState(pos.north(), ModBlocks.IRON_LAVA_FLUID.getDefaultState());
			if (Math.random() < chance && worldIn.getBlockState(pos.down()) == Blocks.AIR.getDefaultState())
				worldIn.setBlockState(pos.south(), ModBlocks.IRON_LAVA_FLUID.getDefaultState());
			if (Math.random() < chance && worldIn.getBlockState(pos.down()) == Blocks.AIR.getDefaultState())
				worldIn.setBlockState(pos.west(), ModBlocks.IRON_LAVA_FLUID.getDefaultState());
			if (Math.random() < chance && worldIn.getBlockState(pos.down()) == Blocks.AIR.getDefaultState())
				worldIn.setBlockState(pos.east(), ModBlocks.IRON_LAVA_FLUID.getDefaultState());
		}
		this.checkForMixing(worldIn, pos, state);
	}

	protected boolean isSurroundingBlockFlammable(World worldIn, BlockPos pos)
	{
		for (EnumFacing enumfacing : EnumFacing.values())
		{
			if (this.getCanBlockBurn(worldIn, pos.offset(enumfacing)))
			{
				return true;
			}
		}

		return false;
	}


	private boolean getCanBlockBurn(World worldIn, BlockPos pos)
	{
		return pos.getY() >= 0 && pos.getY() < 256 && !worldIn.isBlockLoaded(pos) ? false : worldIn.getBlockState(pos).getMaterial().getCanBurn();
	}



}
