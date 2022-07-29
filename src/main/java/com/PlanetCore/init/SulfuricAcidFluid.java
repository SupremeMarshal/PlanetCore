package com.PlanetCore.init;


import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import java.util.Random;


public class SulfuricAcidFluid extends BlockFluidClassic {


	public SulfuricAcidFluid(String name, Fluid fluid, Material material) {
		super(fluid, material);
		setTranslationKey(name);
		setRegistryName(name);
		setDensity(50);
		setLightLevel(0);
		setTickRate(10);
		ModBlocks.BLOCKS.add(this);

		this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL, Integer.valueOf(0)));
		this.setTickRandomly(true);

	}

	public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{

		if (entityIn instanceof EntityPlayerMP)
		{



			entityIn.attackEntityFrom(DamageSource.GENERIC, 1.0F);
		}
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
	protected boolean canFlowInto(IBlockAccess world, BlockPos pos)
	{
		return world.getBlockState(pos).getBlock() == this || canDisplace(world, pos);
	}


	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{

		int quantaRemaining = quantaPerBlock - state.getValue(LEVEL);
		int expQuanta = -101;

		// check adjacent block levels if non-source
		if (quantaRemaining < quantaPerBlock)
		{
			int adjacentSourceBlocks = 0;

			if (ForgeEventFactory.canCreateFluidSource(worldIn, pos, state, canCreateSources))
			{
				for (EnumFacing side : EnumFacing.Plane.HORIZONTAL)
				{
					if (isSourceBlock(worldIn, pos.offset(side))) adjacentSourceBlocks++;
				}
			}

			// new source block
			if (adjacentSourceBlocks >= 2 && (worldIn.getBlockState(pos.up(densityDir)).getMaterial().isSolid() || isSourceBlock(worldIn, pos.up(densityDir))))
			{
				expQuanta = quantaPerBlock;
			}
			// unobstructed flow from 'above'
			else if (worldIn.getBlockState(pos.down(densityDir)).getBlock() == this
					|| hasDownhillFlow(worldIn, pos, EnumFacing.EAST)
					|| hasDownhillFlow(worldIn, pos, EnumFacing.WEST)
					|| hasDownhillFlow(worldIn, pos, EnumFacing.NORTH)
					|| hasDownhillFlow(worldIn, pos, EnumFacing.SOUTH))
			{
				expQuanta = quantaPerBlock - 1;
			}
			else
			{
				int maxQuanta = -100;
				for (EnumFacing side : EnumFacing.Plane.HORIZONTAL)
				{
					maxQuanta = getLargerQuanta(worldIn, pos.offset(side), maxQuanta);
				}
				expQuanta = maxQuanta - 1;
			}

			// decay calculation
			if (expQuanta != quantaRemaining)
			{
				quantaRemaining = expQuanta;

				if (expQuanta <= 0)
				{
					worldIn.setBlockToAir(pos);
				}
				else
				{
					worldIn.setBlockState(pos, state.withProperty(LEVEL, quantaPerBlock - expQuanta), 2);
					worldIn.scheduleUpdate(pos, this, tickRate);
					worldIn.notifyNeighborsOfStateChange(pos, this, false);
				}
			}
		}

		// Flow vertically if possible
		if (canDisplace(worldIn, pos.up(densityDir)))
		{
			flowIntoBlock(worldIn, pos.up(densityDir), 1);
			return;
		}

		// Flow outward if possible
		int flowMeta = quantaPerBlock - quantaRemaining + 1;
		if (flowMeta >= quantaPerBlock)
		{
			return;
		}

		if (isSourceBlock(worldIn, pos) || !isFlowingVertically(worldIn, pos))
		{
			if (worldIn.getBlockState(pos.down(densityDir)).getBlock() == this)
			{
				flowMeta = 1;
			}
			boolean flowTo[] = getOptimalFlowDirections(worldIn, pos);
			for (int i = 0; i < 4; i++)
			{
				if (flowTo[i]) flowIntoBlock(worldIn, pos.offset(SIDES.get(i)), flowMeta);
			}
		}

	}




}
