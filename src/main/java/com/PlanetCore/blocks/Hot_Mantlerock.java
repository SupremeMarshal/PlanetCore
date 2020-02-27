package com.PlanetCore.blocks;

import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class Hot_Mantlerock extends BlockBase
{

	public Hot_Mantlerock(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.STONE);
		setHardness(10.0F);
		setResistance(10.0F);
		setHarvestLevel("pickaxe", 2);
		setLightLevel(0.5F);
		setTickRandomly(true);

		}


	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
	{
		Block block = this;
		if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
		{
			if (block == ModBlocks.HOT_MANTLEROCK) {
				entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 3.0F);
			}
			else if (block == ModBlocks.VERY_HOT_MANTLEROCK)
			{
				entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 6.0F);
			}
			else if (block == ModBlocks.SUPER_HOT_MANTLEROCK) {
				entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 12.0F);
			}
		}

		super.onEntityWalk(worldIn, pos, entityIn);
	}

	@SideOnly(Side.CLIENT)
	public int getPackedLightmapCoords(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return 15728880;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		BlockPos blockpos = pos.up();
		IBlockState iblockstate = worldIn.getBlockState(blockpos);

		if (iblockstate.getBlock() == Blocks.WATER || iblockstate.getBlock() == Blocks.FLOWING_WATER)
		{
			worldIn.setBlockToAir(blockpos);
			worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

			if (worldIn instanceof WorldServer)
			{
				((WorldServer)worldIn).spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.25D, (double)blockpos.getZ() + 0.5D, 8, 0.5D, 0.25D, 0.5D, 0.0D);
			}
		}
	}

	public boolean canEntitySpawn(IBlockState state, Entity entityIn)
	{
		return entityIn.isImmuneToFire();
	}

}
	

