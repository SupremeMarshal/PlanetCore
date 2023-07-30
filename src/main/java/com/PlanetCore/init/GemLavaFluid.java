package com.PlanetCore.init;


import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.event.ForgeEventFactory;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import java.util.List;
import java.util.Random;


public class GemLavaFluid extends BlockFluidClassic {


	public GemLavaFluid(String name, Fluid fluid, Material material) {
		super(fluid, material);
		setTranslationKey(name);
		setRegistryName(name);
		setLightLevel(1);
		setTickRate(30);
		ModBlocks.BLOCKS.add(this);

		this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL, Integer.valueOf(0)));
		this.setTickRandomly(true);

	}

	public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{

		if (entityIn instanceof EntityLivingBase)
		{
			PotionEffect effect = ((EntityLivingBase) entityIn).getActivePotionEffect(MobEffects.FIRE_RESISTANCE);
			float damage = 0;
			if (state.getBlock() == ModBlocks.DIAMOND_LAVA_FLUID) damage = 2;
			else if (state.getBlock() == ModBlocks.RUBY_LAVA_FLUID) damage = 8;
			else if (state.getBlock() == ModBlocks.SAPPHIRE_LAVA_FLUID) damage = 12;
			else if (state.getBlock() == ModBlocks.MAJORITE_LAVA_FLUID) damage = 32;
			else if (state.getBlock() == ModBlocks.AMAZONITE_LAVA_FLUID) damage = 40;
			else if (state.getBlock() == ModBlocks.ONYX_LAVA_FLUID) damage = 48;
			else if (state.getBlock() == ModBlocks.PAINITE_LAVA_FLUID) damage = 64;
			if (effect == null) {
				entityIn.attackEntityFrom(DamageSource.LAVA, damage * 4);
				entityIn.setFire(10);
			}
			else if (effect != null && effect.getAmplifier() == 0) {
				entityIn.attackEntityFrom(DamageSource.GENERIC, damage);
			}
			else if (effect != null && effect.getAmplifier() == 1) {
				damage = damage / 2;
				if (damage >= 1) entityIn.attackEntityFrom(DamageSource.GENERIC, damage);
			}
			else if (effect != null && effect.getAmplifier() == 2) {
				damage = damage / 4;
				if (damage >= 2) entityIn.attackEntityFrom(DamageSource.GENERIC, damage);
			}
			else if (effect != null && effect.getAmplifier() == 3) {
				damage = damage / 8;
				if (damage >= 3) entityIn.attackEntityFrom(DamageSource.GENERIC, damage);
			}
			else if (effect != null && effect.getAmplifier() == 4) {
				damage = damage / 16;
				if (damage >= 4) entityIn.attackEntityFrom(DamageSource.GENERIC, damage);
			}
		}
		super.onEntityCollision(worldIn, pos, state, entityIn);
	}

	public boolean checkForMixing(World worldIn, BlockPos pos, IBlockState state)
	{
		if (this.material == Material.LAVA)
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
					if (this == ModBlocks.DIAMOND_LAVA_FLUID) worldIn.setBlockState(pos, ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, ModBlocks.DIAMOND_SUPERCOMPACT.getDefaultState()));
					if (this == ModBlocks.RUBY_LAVA_FLUID) worldIn.setBlockState(pos, ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, ModBlocks.RUBY_SUPERCOMPACT.getDefaultState()));
					if (this == ModBlocks.SAPPHIRE_LAVA_FLUID) worldIn.setBlockState(pos, ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, ModBlocks.SAPPHIRE_SUPERCOMPACT.getDefaultState()));
					if (this == ModBlocks.MAJORITE_LAVA_FLUID) worldIn.setBlockState(pos, ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, ModBlocks.MAJORITE_SUPERCOMPACT.getDefaultState()));
					if (this == ModBlocks.AMAZONITE_LAVA_FLUID) worldIn.setBlockState(pos, ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, ModBlocks.AMAZONITE_SUPERCOMPACT.getDefaultState()));
					if (this == ModBlocks.ONYX_LAVA_FLUID) worldIn.setBlockState(pos, ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, ModBlocks.ONYX_SUPERCOMPACT.getDefaultState()));
					if (this == ModBlocks.PAINITE_LAVA_FLUID) worldIn.setBlockState(pos, ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, ModBlocks.PAINITE_SUPERCOMPACT.getDefaultState()));
					this.triggerMixEffects(worldIn, pos);
					return true;
				}

				if (integer.intValue() <= 4)
				{
					worldIn.setBlockState(pos, ForgeEventFactory.fireFluidPlaceBlockEvent(worldIn, pos, pos, Blocks.OBSIDIAN.getDefaultState()));
					this.triggerMixEffects(worldIn, pos);
					return true;
				}
			}
		}
		return false;
	}


	public static void burnEntities(World world, int x, int y, int z, int radius, IBlockState state) {

		AxisAlignedBB bb = new AxisAlignedBB(x + 5, y + 5, z + 5, x - 5, y - 5, z - 5);
		List list = world.getEntitiesWithinAABB(EntityLivingBase.class, bb);

		for (int i = 0; i < list.size(); ++i) {
			Entity entity = (Entity) list.get(i);

			{
				PotionEffect effect = ((EntityLivingBase) entity).getActivePotionEffect(MobEffects.FIRE_RESISTANCE);
				float damage = 0;
				if (state.getBlock() == ModBlocks.DIAMOND_LAVA_FLUID) damage = 2;
				else if (state.getBlock() == ModBlocks.RUBY_LAVA_FLUID) damage = 8;
				else if (state.getBlock() == ModBlocks.SAPPHIRE_LAVA_FLUID) damage = 12;
				else if (state.getBlock() == ModBlocks.MAJORITE_LAVA_FLUID) damage = 32;
				else if (state.getBlock() == ModBlocks.AMAZONITE_LAVA_FLUID) damage = 40;
				else if (state.getBlock() == ModBlocks.ONYX_LAVA_FLUID) damage = 48;
				else if (state.getBlock() == ModBlocks.PAINITE_LAVA_FLUID) damage = 64;
				if (effect == null) {
					entity.attackEntityFrom(DamageSource.ON_FIRE, damage * 2);
					entity.setFire(6);
				} else if (effect != null && effect.getAmplifier() == 0) {
					entity.attackEntityFrom(DamageSource.GENERIC, damage);
				} else if (effect != null && effect.getAmplifier() == 1) {
					damage = damage / 2;
					if (damage >= 1) entity.attackEntityFrom(DamageSource.GENERIC, damage);
				} else if (effect != null && effect.getAmplifier() == 2) {
					damage = damage / 4;
					if (damage >= 2) entity.attackEntityFrom(DamageSource.GENERIC, damage);
				} else if (effect != null && effect.getAmplifier() == 3) {
					damage = damage / 8;
					if (damage >= 3) entity.attackEntityFrom(DamageSource.GENERIC, damage);
				} else if (effect != null && effect.getAmplifier() == 4) {
					damage = damage / 16;
					if (damage >= 4) entity.attackEntityFrom(DamageSource.GENERIC, damage);
				}
			}
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
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		if (!this.checkForMixing(worldIn, pos, state))
		{
			worldIn.scheduleUpdate(pos, this, tickRate);
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
		int X = pos.getX();
		int Y = pos.getY();
		int Z = pos.getZ();
		burnEntities(worldIn,X,Y,Z, 6, state);
		this.checkForMixing(worldIn, pos, state);
	}
}
