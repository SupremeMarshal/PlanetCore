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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import java.util.Random;

public class Mantlerock extends BlockBase implements IMetaName
{


	private static final float [] mantleHardnessByMeta = {10, 15, 20, 30, 40, 50};
	public static final int [] mantleLightLevel = {0, 7, 10, 15, 15, 15};
	public static final PropertyEnum<Mantlerock.EnumType> VARIANT = PropertyEnum.<Mantlerock.EnumType>create("variant",Mantlerock.EnumType.class);


	public Mantlerock(String name, Material material)
	{
		super(name, material,false);
		setSoundType(SoundType.STONE);
		setHarvestLevel("pickaxe", 0);
		setTickRandomly(true);
	}

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
	{
		int meta = getMetaFromState(worldIn.getBlockState(pos));
		if (meta > 1 && !entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
		{
			entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, meta - 1);
		}

		super.onEntityWalk(worldIn, pos, entityIn);
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
		LOWER_MANTLEROCK(3, "lower_mantlerock"),
		LOWER_MANTLEROCK1(4, "lower_mantlerock1"),
		LOWER_MANTLEROCK2(5, "lower_mantlerock2");


		private static final 	Mantlerock.EnumType[] META_LOOKUP = new Mantlerock.EnumType[]{MANTLEROCK, MANTLEROCK1, MANTLEROCK2, LOWER_MANTLEROCK, LOWER_MANTLEROCK1, LOWER_MANTLEROCK2};
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
		if (stack.getItemDamage() > 6) return null;
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
		int meta = getMetaFromState(state);
		if (!worldIn.isRemote) {
			if (meta == 0 && Math.random() < 0.01) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(2) + 1, true);
			}
			else if (meta == 1 && Math.random() < 0.02) {
				worldIn.createExplosion(null, X, Y, Z, rand.nextInt(3) + 1, true);
			}
			else if (meta == 2 && Math.random() < 0.03) {
				worldIn.createExplosion(null, X, Y, Z, rand.nextInt(4) + 1, true);
			}
			else if (meta == 3 && Math.random() < 0.04) {
				worldIn.createExplosion(null, X, Y, Z, rand.nextInt(5) + 1, true);
			}
			else if (meta == 4 && Math.random() < 0.05) {
				worldIn.createExplosion(null, X, Y, Z, rand.nextInt(5) + 1, true);
			}
			else if (meta == 5 && Math.random() < 0.06) {
				worldIn.createExplosion(null, X, Y, Z, rand.nextInt(5) + 1, true);
			}
		}
	}

	@Override
	public void onPlayerDestroy(World worldIn, BlockPos pos, IBlockState state) {
		super.onPlayerDestroy(worldIn, pos, state);
		naturalGasExplosion(worldIn, pos, state);
		if (getMetaFromState(state) == 1 && Math.random() < 0.02)
		{
			worldIn.setBlockState(pos, ModBlocks.IRON_LAVA_FLUID.getDefaultState());
		}
		else if (getMetaFromState(state) == 2 && Math.random() < 0.08)
		{
			worldIn.setBlockState(pos, ModBlocks.IRON_LAVA_FLUID.getDefaultState());
		}
		else if (getMetaFromState(state) == 3 && Math.random() < 0.2)
		{
			worldIn.setBlockState(pos, ModBlocks.IRON_LAVA_FLUID.getDefaultState());
		}
		else if (getMetaFromState(state) == 4 && Math.random() < 0.4)
		{
			worldIn.setBlockState(pos, ModBlocks.IRON_LAVA_FLUID.getDefaultState());
		}
		else if (getMetaFromState(state) == 5)
		{
			worldIn.setBlockState(pos, ModBlocks.IRON_LAVA_FLUID.getDefaultState());
		}
	}
}
