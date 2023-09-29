package com.PlanetCore.blocks;


import com.PlanetCore.init.EnchantmentInit;
import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.util.IMetaName;
import net.minecraft.block.Block;
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
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.*;

public class Rock extends BlockBase implements IMetaName
{

	public static final int [] LightLevel = {0, 0, 0, 0, 10, 0, 10, 0, 10, 0, 15, 15, 0, 15};
	public static final PropertyEnum<Rock.EnumType> VARIANT = PropertyEnum.create("variant", Rock.EnumType.class);

	public Rock(String name, Material material) {
		super(name, material, false);
		setSoundType(SoundType.STONE);
		setHarvestLevel("pickaxe", 0);
		setTickRandomly(true);
		setResistance(10);

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
	public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer player, boolean willHarvest) {
		Random rand = new Random();
		int X = pos.getX();
		int Z = pos.getZ();
		int Y = pos.getY();
		int meta = getMetaFromState(state);
		int refinerLevel = EnchantmentHelper.getMaxEnchantmentLevel(EnchantmentInit.Refiner, player);
		int frostingLevel = EnchantmentHelper.getMaxEnchantmentLevel(EnchantmentInit.Frosting, player);
		if (!world.isRemote) {
			if (Math.random() < (-0.000175 * (Y + 640)) * (1 - (0.2 * refinerLevel))) {
				world.createExplosion(null, X, Y, Z, rand.nextInt(5) + 1, true);
			}
			if (Math.random() < (-0.000175 * (Y + 640)) * (1 - (0.2 * frostingLevel))) {
				world.setBlockState(pos, ModBlocks.IRON_LAVA_FLUID.getDefaultState());
			}
		}
		return super.removedByPlayer(state, world, pos, player, willHarvest);
	}

	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		int Y = pos.getY();
		int meta = getMetaFromState(state);
		if (Y < -400 && meta > 1 && Math.random() < 0.1 * meta && (worldIn.isAirBlock(pos.up()))) {
			{
				if (meta == 3 || meta == 4) {
					worldIn.setBlockState(pos.up(), ModBlocks.PERIDOTITE_FIRE.getDefaultState(), 11);
				}
				else if (meta == 5 || meta == 6) {
					worldIn.setBlockState(pos.up(), ModBlocks.GARNET_FIRE.getDefaultState(), 11);
				}
				else if (meta == 7 || meta == 8) {
					worldIn.setBlockState(pos.up(), ModBlocks.BRIDGMANITE_FIRE.getDefaultState(), 11);
				}
				else if (meta == 9 || meta == 10) {
					worldIn.setBlockState(pos.up(), ModBlocks.FERROPERICLASE_FIRE.getDefaultState(), 11);
				}
				else if (meta == 11) {
					worldIn.setBlockState(pos.up(), ModBlocks.CORE_FIRE.getDefaultState(), 11);
				}
				else if (meta == 12 || meta == 13) {
					worldIn.setBlockState(pos.up(), ModBlocks.ONYX_FIRE.getDefaultState(), 11);
				}
				else worldIn.setBlockState(pos.up(), Blocks.FIRE.getDefaultState(), 11);
			}
		}
		super.randomTick(worldIn, pos, state, rand);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random random, int l) {
		return super.getItemDropped(state, random, l);
	}

	@Override
	public int getLightValue(IBlockState state) {
		int meta = getMetaFromState(state);
		return (LightLevel[meta]);
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (BlackstoneOre.EnumType Blackstone$enumtype : BlackstoneOre.EnumType.values()) {
			items.add(new ItemStack(this, 1, Blackstone$enumtype.getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, Rock.EnumType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(VARIANT).getMeta();
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this),1, getMetaFromState(world.getBlockState(pos)));
	}


	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}




	public enum EnumType implements IStringSerializable
	{
		QUARTZ(0, "quartz"),
		GRANITE(1, "granite"),
		BLACKSTONE(2, "blackstone"),
		PERIDOTITE(3, "peridotite"),
		HOT_PERIDOTITE(4, "hot_peridotite"),
		GARNET(5, "garnet"),
		HOT_GARNET(6, "hot_garnet"),
		BRIDGMANITE (7, "bridgmanite"),
		HOT_BRIDGMANITE (8, "hot_bridgmanite"),
		FERROPERICLASE (9, "ferropericlase"),
		HOT_FERROPERICLASE (10, "hot_ferropericlase"),
		CORESTONE(11, "corestone"),
		ONYXSLATE(12, "onyxslate"),
		HOT_ONYXSLATE(13, "hot_onyxslate");

		private static final Rock.EnumType[] META_LOOKUP = new Rock.EnumType[] {QUARTZ, GRANITE, BLACKSTONE, PERIDOTITE, HOT_PERIDOTITE, GARNET, HOT_GARNET, BRIDGMANITE, HOT_BRIDGMANITE, FERROPERICLASE, HOT_FERROPERICLASE, CORESTONE, ONYXSLATE, HOT_ONYXSLATE};
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

		public static EnumType byMetadata(int meta)
		{
			return META_LOOKUP[meta];
		}

		static {
			for(EnumType Rock$enumtype : values())
			{
				META_LOOKUP[Rock$enumtype.getMeta()] = Rock$enumtype;
			}
		}
	}



	@Override
	public String getSpecialName(ItemStack stack)
	{
		return Rock.EnumType.values()[stack.getItemDamage()].getName();
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(VARIANT, Rock.EnumType.byMetadata(meta));
	}
}
