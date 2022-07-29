package com.PlanetCore.init;


import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;

import java.util.List;
import java.util.Random;


public class CoreLavaFluid extends BlockFluidClassic {

	public CoreLavaFluid(String name, Fluid fluid, Material material) {
		super(fluid, material);
		setTranslationKey(name);
		setRegistryName(name);

		setLightLevel(1);
		setDensity(400);
		setTickRate(8);
		setTickRandomly(true);
		this.setDefaultState(this.blockState.getBaseState().withProperty(LEVEL, Integer.valueOf(0)));
		ModBlocks.BLOCKS.add(this);
	}



	public void vaporizeWater(World worldIn, BlockPos pos, IBlockState state)
	{
		if (this.material == Material.LAVA)
		{
			for (EnumFacing enumfacing : EnumFacing.values()) {

				if (worldIn.getBlockState(pos.offset(enumfacing)) == Blocks.WATER.getDefaultState()) {
					worldIn.setBlockState(pos.offset(enumfacing), Blocks.AIR.getDefaultState());
				}

			}
		}
	}


	public static void burnEntities(World world, int x, int y, int z, int radius) {

		AxisAlignedBB bb = new AxisAlignedBB(x + 5, y + 5, z + 5, x - 5, y - 5, z - 5);
		List list = world.getEntitiesWithinAABB(EntityLiving.class, bb);

		for (int i = 0; i < list.size(); ++i) {
			Entity entity = (Entity) list.get(i);
			{
				PotionEffect effect = ((EntityLiving) entity).getActivePotionEffect(MobEffects.FIRE_RESISTANCE);
				if (effect == null) {
					entity.attackEntityFrom(DamageSource.ON_FIRE, 32);
					entity.setFire(10);
				}
				if (effect != null && effect.getAmplifier() == 0) {
					entity.attackEntityFrom(DamageSource.GENERIC, 8);
				}
				if (effect != null && effect.getAmplifier() == 1) {
					entity.attackEntityFrom(DamageSource.GENERIC, 2);
				}
			}
		}
	}





	public void coreTemperature(World worldIn, BlockPos pos,IBlockState state)
	{
		int X = pos.getX();
		int Y = pos.getY();
		int Z = pos.getZ();
		burnEntities(worldIn,X,Y,Z, 9);
		Random rand = new Random();

		if(worldIn.canSeeSky(pos) == true && worldIn.isRaining() == false)
		{
			if(rand.nextInt(120) == 0)
			{
				worldIn.setBlockState(pos, ModBlocks.CORESTONE.getDefaultState());
			}
		}
		else if(worldIn.canSeeSky(pos) == true && worldIn.isRaining() == true)
		{
			if(rand.nextInt(20) == 0)
			{
				worldIn.setBlockState(pos, ModBlocks.CORESTONE.getDefaultState());
			}
		}
		else if(worldIn.canSeeSky(pos) == false && pos.getY() > -1000)
			if(rand.nextInt(240) == 0)
			{
				worldIn.setBlockState(pos, ModBlocks.CORESTONE.getDefaultState());
			}
	}

	@Override
	public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{
		if (entityIn instanceof EntityLivingBase) {
			PotionEffect effect = ((EntityLivingBase) entityIn).getActivePotionEffect(MobEffects.FIRE_RESISTANCE);
			if (effect == null) {
				entityIn.attackEntityFrom(DamageSource.ON_FIRE, 32);
				entityIn.setFire(10);
			}
			if (effect != null && effect.getAmplifier() == 0) {
				entityIn.attackEntityFrom(DamageSource.GENERIC, 8);
			}
			if (effect != null && effect.getAmplifier() == 1) {
				entityIn.attackEntityFrom(DamageSource.GENERIC, 2);
			}
		}
		super.onEntityCollision(worldIn, pos, state, entityIn);
	}


	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		super.updateTick(worldIn, pos, state, rand);
		//thermalEffects(worldIn,pos,state);
		coreTemperature(worldIn,pos,state);
		vaporizeWater(worldIn, pos, state);
		float chance = -0.0001220703125F * (pos.getY() + 5000) + 0.3F;
		if (pos.getY() <= -4800) {
			if ((Math.random() < chance && worldIn.getBlockState(pos.up()) == Blocks.AIR.getDefaultState()
					|| worldIn.getBlockState(pos.up()) == Blocks.WATER.getDefaultState()))
				worldIn.setBlockState(pos.up(), ModBlocks.CORE_LAVA_FLUID.getDefaultState());
			if ((Math.random() < chance && worldIn.getBlockState(pos.down()) == Blocks.AIR.getDefaultState()
					|| worldIn.getBlockState(pos.up()) == Blocks.WATER.getDefaultState()))
				worldIn.setBlockState(pos.down(), ModBlocks.CORE_LAVA_FLUID.getDefaultState());
			if ((Math.random() < chance && worldIn.getBlockState(pos.north()) == Blocks.AIR.getDefaultState()
					|| worldIn.getBlockState(pos.up()) == Blocks.WATER.getDefaultState()))
				worldIn.setBlockState(pos.north(), ModBlocks.CORE_LAVA_FLUID.getDefaultState());
			if ((Math.random() < chance && worldIn.getBlockState(pos.south()) == Blocks.AIR.getDefaultState()
					|| worldIn.getBlockState(pos.up()) == Blocks.WATER.getDefaultState()))
				worldIn.setBlockState(pos.south(), ModBlocks.CORE_LAVA_FLUID.getDefaultState());
			if ((Math.random() < chance && worldIn.getBlockState(pos.west()) == Blocks.AIR.getDefaultState()
					|| worldIn.getBlockState(pos.up()) == Blocks.WATER.getDefaultState()))
				worldIn.setBlockState(pos.west(), ModBlocks.CORE_LAVA_FLUID.getDefaultState());
			if ((Math.random() < chance && worldIn.getBlockState(pos.east()) == Blocks.AIR.getDefaultState()
					|| worldIn.getBlockState(pos.up()) == Blocks.WATER.getDefaultState()))
				worldIn.setBlockState(pos.east(), ModBlocks.CORE_LAVA_FLUID.getDefaultState());
		}
	}



	 






	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

}
