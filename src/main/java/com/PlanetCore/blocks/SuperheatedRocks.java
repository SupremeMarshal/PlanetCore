package com.PlanetCore.blocks;


import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class SuperheatedRocks extends BlockBase {

	public final PlanetHardness planetHardness;

	public SuperheatedRocks(String name, Material material, PlanetHardness planetHardness) {
		super(name, material,false);
		setSoundType(SoundType.STONE);
		setHarvestLevel("pickaxe", 0);
		setTickRandomly(true);
		this.planetHardness = planetHardness;
	}

	@Override
	public int getLightValue(IBlockState state) {
		return (15);
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
	{
		if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
		{
			entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 2.0F);
		}
		super.onEntityWalk(worldIn, pos, entityIn);
	}
	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		return planetHardness.hardness;
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
			int i = MathHelper.getInt(rand, 3,6);
			return i;
		}
		else return 0;
	}
}
