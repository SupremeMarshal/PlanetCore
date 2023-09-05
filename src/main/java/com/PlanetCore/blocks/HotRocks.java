package com.PlanetCore.blocks;




import com.PlanetCore.util.IMetaName;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
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
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class HotRocks extends BlockBase implements IMetaName {

	public final PlanetHardness planetHardness;
	public static final PropertyEnum<HotRocks.EnumType> VARIANT_HOTROCKS = PropertyEnum.create("variant", HotRocks.EnumType.class);

	public static final int [] LightLevel = {5, 10, 15};
	public HotRocks(String name, Material material, PlanetHardness planetHardness) {
		super(name, material,false);
		setSoundType(SoundType.STONE);
		setHarvestLevel("pickaxe", 0);
		setTickRandomly(true);
		this.planetHardness = planetHardness;
	}


	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	public int getLightValue(IBlockState state) {
		int meta = getMetaFromState(state);
		return (LightLevel[meta]);
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (HotRocks.EnumType HotRocks$enumtype : HotRocks.EnumType.values()) {
			items.add(new ItemStack(this, 1, HotRocks$enumtype.getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT_HOTROCKS, HotRocks.EnumType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(VARIANT_HOTROCKS).getMeta();
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this),1, getMetaFromState(world.getBlockState(pos)));
	}


	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, VARIANT_HOTROCKS);
	}




	public enum EnumType implements IStringSerializable
	{
		HOT(0, "hot"),
		VERYHOT(1, "veryhot"),
		SUPERHEATED(2, "superheated");

		private static final HotRocks.EnumType[] META_LOOKUP = new HotRocks.EnumType[]{HOT, VERYHOT, SUPERHEATED};
		private final int meta;
		private final String name;

		EnumType(int meta, String name)
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

		public static HotRocks.EnumType byMetadata(int meta)
		{
			return META_LOOKUP[meta];
		}

		static {
			for(HotRocks.EnumType HotRocks$enumtype : values())
			{
				META_LOOKUP[HotRocks$enumtype.getMeta()] = HotRocks$enumtype;
			}
		}
	}

	@Override
	public String getSpecialName(ItemStack stack)
	{
		return HotRocks.EnumType.values()[stack.getItemDamage()].getName();
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(VARIANT_HOTROCKS, HotRocks.EnumType.byMetadata(meta));
	}

	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		return 15;
	}
	
	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
	{
		if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
		{
			entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 1.0F);
		}
		super.onEntityWalk(worldIn, pos, entityIn);
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
			int i = MathHelper.getInt(rand, 1, 2);
			return i;
		}
		else return 0;
	}
}
