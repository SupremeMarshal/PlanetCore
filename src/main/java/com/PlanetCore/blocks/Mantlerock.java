package com.PlanetCore.blocks;


import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.util.IMetaName;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class Mantlerock extends BlockBase implements IMetaName
{



	public static final PropertyEnum<Mantlerock.EnumType> VARIANT = PropertyEnum.<Mantlerock.EnumType>create("variant",Mantlerock.EnumType.class);

	public Mantlerock(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.STONE);
		setHarvestLevel("pickaxe", 0);
		setTickRandomly(true);
	}

	public static final int [] mantleLightLevel = {0, 0, 0, 0, 0, 1, 2, 4, 6, 8, 10, 11, 12, 13, 14, 15};

	@Override
	public int getLightValue(IBlockState state) {
		int meta = getMetaFromState(state);
		return (mantleLightLevel[meta]);
	}

	// TODO: how to make this work?
	// @Override
	// void addItemBlock() {
	// 	ModItems.ITEMS.add(new ItemBlockVariants(this).setRegistryName(this.getRegistryName()));
	// }

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (Mantlerock.EnumType mantlerock$enumtype : Mantlerock.EnumType.values()) {
			items.add(new ItemStack(this, 1, mantlerock$enumtype.getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, Mantlerock.EnumType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((Mantlerock.EnumType)state.getValue(VARIANT)).getMeta();
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this),1,(int)(getMetaFromState(world.getBlockState(pos))));
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}


	public static enum EnumType implements IStringSerializable
	{
		MANTLEROCK(0, "mantlerock"),
		MANTLEROCK1(1, "mantlerock1"),
		MANTLEROCK2(2, "mantlerock2"),
		MANTLEROCK3(3, "mantlerock3"),
		MANTLEROCK4(4, "mantlerock4"),
		MANTLEROCK5(5, "mantlerock5"),
		MANTLEROCK6(6, "mantlerock6"),
		MANTLEROCK7(7, "mantlerock7"),
		MANTLEROCK8(8, "mantlerock8"),
		LOWER_MANTLEROCK(9, "lower_mantlerock"),
		LOWER_MANTLEROCK1(10, "lower_mantlerock1"),
		LOWER_MANTLEROCK2(11, "lower_mantlerock2"),
		LOWER_MANTLEROCK3(12, "lower_mantlerock3"),
		LOWER_MANTLEROCK4(13, "lower_mantlerock4"),
		LOWER_MANTLEROCK5(14, "lower_mantlerock5"),
		LOWER_MANTLEROCK6(15, "lower_mantlerock6");

		private static final 	Mantlerock.EnumType[] META_LOOKUP = new Mantlerock.EnumType[]{MANTLEROCK, MANTLEROCK1, MANTLEROCK2, MANTLEROCK3, MANTLEROCK4, MANTLEROCK5, MANTLEROCK6,
		MANTLEROCK7, MANTLEROCK8, LOWER_MANTLEROCK, LOWER_MANTLEROCK1, LOWER_MANTLEROCK2, LOWER_MANTLEROCK3, LOWER_MANTLEROCK4, LOWER_MANTLEROCK5, LOWER_MANTLEROCK6};
		private final int meta;
		private final String name;

		private EnumType(int meta, String name)
		{
			this.meta=meta;
			this.name=name;
		}



		@Override
		public String getName() {
			return this.name;
		}

		public int getMeta()
		{
			return this.meta;
		}

		@Override
		public String toString()
		{
			return this.name;
		}

		public static Mantlerock.EnumType byMetadata(int meta)
		{
			return META_LOOKUP[meta];
		}

		static {
			for(Mantlerock.EnumType mantlerock$enumtype : values())
			{
				META_LOOKUP[mantlerock$enumtype.getMeta()] = mantlerock$enumtype;
			}
		}
	}

	@Override
	public String getSpecialName(ItemStack stack)
	{
		return Mantlerock.EnumType.values()[stack.getItemDamage()].getName();
	}



	public void spawnLava(World worldIn, BlockPos pos, IBlockState state)
	{
		Random rand = new Random();
		if (!worldIn.isRemote)
		{
			if (state.getBlock().getMetaFromState(state) == 5)
			{
				if (rand.nextInt(1000) == 0) {
					worldIn.setBlockState(pos, ModBlocks.ACTIVE_LAVA_FLUID.getDefaultState());
				}
			}
			if (state.getBlock().getMetaFromState(state) == 6)
			{
				if (rand.nextInt(833) == 0) {
					worldIn.setBlockState(pos, ModBlocks.ACTIVE_LAVA_FLUID.getDefaultState());
				}
			}
			if (state.getBlock().getMetaFromState(state) == 7)
			{
				if (rand.nextInt(694) == 0) {
					worldIn.setBlockState(pos, ModBlocks.ACTIVE_LAVA_FLUID.getDefaultState());
				}
			}
			if (state.getBlock().getMetaFromState(state) == 8)
			{
				if (rand.nextInt(578) == 0) {
					worldIn.setBlockState(pos, ModBlocks.ACTIVE_LAVA_FLUID.getDefaultState());
				}
			}
			if (state.getBlock().getMetaFromState(state) == 9)
			{
				if (rand.nextInt(482) == 0) {
					worldIn.setBlockState(pos, ModBlocks.ACTIVE_LAVA_FLUID.getDefaultState());
				}
			}
			if (state.getBlock().getMetaFromState(state) == 10)
			{
				if (rand.nextInt(401) == 0) {
					worldIn.setBlockState(pos, ModBlocks.ACTIVE_LAVA_FLUID.getDefaultState());
				}
			}
			if (state.getBlock().getMetaFromState(state) == 11)
			{
				if (rand.nextInt(334) == 0) {
					worldIn.setBlockState(pos, ModBlocks.ACTIVE_LAVA_FLUID.getDefaultState());
				}
			}
			if (state.getBlock().getMetaFromState(state) == 12)
			{
				if (rand.nextInt(279) == 0) {
					worldIn.setBlockState(pos, ModBlocks.ACTIVE_LAVA_FLUID.getDefaultState());
				}
			}
			if (state.getBlock().getMetaFromState(state) == 13)
			{
				if (rand.nextInt(232) == 0) {
					worldIn.setBlockState(pos, ModBlocks.ACTIVE_LAVA_FLUID.getDefaultState());
				}
			}
			if (state.getBlock().getMetaFromState(state) == 14)
			{
				if (rand.nextInt(193) == 0) {
					worldIn.setBlockState(pos, ModBlocks.ACTIVE_LAVA_FLUID.getDefaultState());
				}
			}
			if (state.getBlock().getMetaFromState(state) == 15)
			{
				if (rand.nextInt(161) == 0) {
					worldIn.setBlockState(pos, ModBlocks.ACTIVE_LAVA_FLUID.getDefaultState());
				}
			}

		}
	}

	//Natural Gas Explosion event
	//Upon destroying the block, it has a small chance to explode. The deeper the rock is, the more probability it has to explode with a larger explosion.
	public void naturalGasExplosion(World worldIn, BlockPos pos, IBlockState state)
	{
		Random rand = new Random();
		int X = pos.getX();
		int Z = pos.getZ();
		int Y = pos.getY();
		if (!worldIn.isRemote) {
			if (state == ModBlocks.MANTLEROCK && state.getBlock().getMetaFromState(state) == 0) {
				if (rand.nextInt(2000) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(2) + 1, true);
				}
			}
			if (state == ModBlocks.MANTLEROCK && state.getBlock().getMetaFromState(state) == 1) {
				if (rand.nextInt(1666) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(3) + 1, true);
				}
			}
			if (state == ModBlocks.MANTLEROCK && state.getBlock().getMetaFromState(state) == 2) {
				if (rand.nextInt(1388) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(4) + 1, true);
				}
			}
			if (state == ModBlocks.MANTLEROCK && state.getBlock().getMetaFromState(state) == 3) {
				if (rand.nextInt(1157) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(5) + 1, true);
				}
			}
			if (state == ModBlocks.MANTLEROCK && state.getBlock().getMetaFromState(state) == 4) {
				if (rand.nextInt(964) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(6) + 1, true);
				}
			}
			if (state == ModBlocks.MANTLEROCK && state.getBlock().getMetaFromState(state) == 5) {
				if (rand.nextInt(803) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(7) + 1, true);
				}
			}
			if (state == ModBlocks.MANTLEROCK && state.getBlock().getMetaFromState(state) == 6) {
				if (rand.nextInt(669) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(8) + 1, true);
				}
			}
			if (state == ModBlocks.MANTLEROCK && state.getBlock().getMetaFromState(state) == 7) {
				if (rand.nextInt(558) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 1, true);
				}
			}
			if (state == ModBlocks.MANTLEROCK && state.getBlock().getMetaFromState(state) == 8) {
				if (rand.nextInt(465) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 1, true);
				}
			}
			if (state == ModBlocks.MANTLEROCK && state.getBlock().getMetaFromState(state) == 9) {
				if (rand.nextInt(387) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(8) + 2, true);
				}
			}
			if (state == ModBlocks.MANTLEROCK && state.getBlock().getMetaFromState(state) == 10) {
				if (rand.nextInt(323) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 2, true);
				}
			}
			if (state == ModBlocks.MANTLEROCK && state.getBlock().getMetaFromState(state) == 11) {
				if (rand.nextInt(269) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(8) + 3, true);
				}
			}
			if (state == ModBlocks.MANTLEROCK && state.getBlock().getMetaFromState(state) == 12) {
				if (rand.nextInt(224) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 3, true);
				}
			}
			if (state == ModBlocks.MANTLEROCK && state.getBlock().getMetaFromState(state) == 13) {
				if (rand.nextInt(186) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(8) + 4, true);
				}
			}
			if (state == ModBlocks.MANTLEROCK && state.getBlock().getMetaFromState(state) == 14) {
				if (rand.nextInt(155) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 4, true);
				}
			}
			if (state == ModBlocks.MANTLEROCK && state.getBlock().getMetaFromState(state) == 15) {
				if (rand.nextInt(129) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 5, true);
				}
			}
		}
	}






	/*
	//Unstable block
	public void unstableBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		int x;
		int y;
		int z;

		x = pos.getX();
		y = pos.getY() -1;
		z = pos.getZ();
		Random rand = new Random();
		BlockPos pos2 = new BlockPos(x,y,z);
		IBlockState state2 = worldIn.getBlockState(pos2);
		if (state2.getMaterial()!=Material.AIR)
		{
			//Block become stable
		}
		if (state2.getMaterial()==Material.AIR)
		{
			if (rand.nextInt(500)==0)
			{
				//Create falling boulder
			}
		}
	}
	 */


	//Lava Decompression event
	//Lava being spawned from removing the pressure
	//This event can be stacked with earthquake.
	//=(G26+1536)/(-12500)/64
	//=(G152+9600)/(-12500)/64

	@Override
	public void onPlayerDestroy(World worldIn, BlockPos pos, IBlockState state) {
		super.onPlayerDestroy(worldIn, pos, state);
		naturalGasExplosion(worldIn, pos, state);
		spawnLava(worldIn, pos, state);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		super.updateTick(worldIn, pos, state, rand);

		//unstableBlock(worldIn,pos,state);
		//Only if the event has started
		//lavaDecompression(worldIn,pos,state);
	}



}
