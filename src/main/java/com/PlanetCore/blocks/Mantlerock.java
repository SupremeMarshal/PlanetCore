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
import net.minecraft.item.EnumDyeColor;
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


	private static final float [] mantleHardnessByMeta = {24, 33, 47, 65, 92, 129, 193, 290, 435, 653, 979, 1469, 2204, 3306, 4959, 7438};
	public static final int [] mantleLightLevel = {0, 0, 0, 0, 0, 1, 2, 4, 6, 8, 10, 11, 12, 13, 14, 15};
	public static final PropertyEnum<Mantlerock.EnumType> VARIANT = PropertyEnum.<Mantlerock.EnumType>create("variant",Mantlerock.EnumType.class);


	public Mantlerock(String name, Material material)
	{
		super(name, material);
		setSoundType(SoundType.STONE);
		setHarvestLevel("pickaxe", 0);
		setTickRandomly(true);
	}

	@Override
	public int damageDropped(IBlockState state) {
		int meta = getMetaFromState(state);
		return meta;
	}

	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		int meta = getMetaFromState(blockState);
		return mantleHardnessByMeta[meta];
	}

	@Override
	public int getLightValue(IBlockState state) {
		int meta = getMetaFromState(state);
		return (mantleLightLevel[meta]);
	}

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


	//Natural Gas Explosion event
	//Upon destroying the block, it has a small chance to explode. The deeper the rock is, the more probability it has to explode with a larger explosion.
	public void naturalGasExplosion(World worldIn, BlockPos pos, IBlockState state)
	{
		Random rand = new Random();
		int X = pos.getX();
		int Z = pos.getZ();
		int Y = pos.getY();
		if (!worldIn.isRemote) {
			if (pos.getY() <= -1024 && pos.getY() > -1280 && rand.nextInt(2000) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(2) + 1, true);
			}
			if (pos.getY() <= -1280 && pos.getY() > -1536 && rand.nextInt(1666) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(3) + 1, true);
			}
			if (pos.getY() <= -1536 && pos.getY() > -1792 && rand.nextInt(1388) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(4) + 1, true);
			}
			if (pos.getY() <= -1792 && pos.getY() > -2048 && rand.nextInt(1157) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(5) + 1, true);
			}
			if (pos.getY() <= -2048 && pos.getY() > -2304 && rand.nextInt(964) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(6) + 1, true);
			}
			if (pos.getY() <= -2304 && pos.getY() > -2560 && rand.nextInt(803) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(7) + 1, true);
			}
			if (pos.getY() <= -2560 && pos.getY() > -2816 && rand.nextInt(669) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(8) + 1, true);
			}
			if (pos.getY() <= -2816 && pos.getY() > -3072 && rand.nextInt(558) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 1, true);
			}
			if (pos.getY() <= -3072 && pos.getY() > -3328 && rand.nextInt(465) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 1, true);
			}
			if (pos.getY() <= -3328 && pos.getY() > -3584 && rand.nextInt(387) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(8) + 2, true);
			}
			if (pos.getY() <= -3584 && pos.getY() > -3840 && rand.nextInt(323) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 2, true);
			}
			if (pos.getY() <= -3840 && pos.getY() > -4096 && rand.nextInt(269) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(8) + 3, true);
			}
			if (pos.getY() <= -4096 && pos.getY() > -4608 && rand.nextInt(250) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 3, true);
			}
			if (pos.getY() <= -4608 && pos.getY() > -5120 && rand.nextInt(250) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(8) + 4, true);
			}
			if (pos.getY() <= -5120 && pos.getY() > -5632 && rand.nextInt(250) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 4, true);
			}
			if (pos.getY() <= -5632 && rand.nextInt(250) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 5, true);
			}
		}
	}

	@Override
	public void onPlayerDestroy(World worldIn, BlockPos pos, IBlockState state) {
		super.onPlayerDestroy(worldIn, pos, state);
		naturalGasExplosion(worldIn, pos, state);
	}
}
