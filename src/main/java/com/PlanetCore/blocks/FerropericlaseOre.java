package com.PlanetCore.blocks;


import com.PlanetCore.init.EnchantmentInit;
import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
import com.PlanetCore.util.IMetaName;
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
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class FerropericlaseOre extends BlockBase implements IMetaName
{

	public static final PropertyEnum<FerropericlaseOre.EnumType> VARIANT = PropertyEnum.create("variant", FerropericlaseOre.EnumType.class);

	public FerropericlaseOre(String name, Material material) {
		super(name, material,false);
		setResistance(10);
	}

	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		return 750;
	}

	@Override
	public void getDrops(NonNullList<ItemStack> drops, IBlockAccess world, BlockPos pos, IBlockState state, int fortune) {
		Random random = new Random();
		EnumType variant = state.getValue(VARIANT);
		drops.clear();
		if (variant == EnumType.COAL) {
			drops.add(new ItemStack(Items.COAL));
		}
		else if (variant == EnumType.IRON) {
			drops.add(new ItemStack(ModItems.IRON_ORE));
		}
		else if (variant == EnumType.SULFUR) {
			drops.add(new ItemStack(ModItems.SULFUR));
		}
		else if (variant == EnumType.DIAMOND) {
			drops.add(new ItemStack(Items.DIAMOND));
		}
		else if (variant == EnumType.EMERALD) {
			drops.add(new ItemStack(Items.EMERALD));
		}
		else if (variant == EnumType.LAPIS) {
			int quantity = 4 + random.nextInt(5);
			drops.add(new ItemStack(Items.DYE, quantity, 4));
		}
		else if (variant == EnumType.REDSTONE)
		{
			int quantity = 4 + random.nextInt(2);
			drops.add(new ItemStack(Items.REDSTONE,quantity));
		}
		else if (variant == EnumType.TITANIUM) {
			drops.add(new ItemStack(ModItems.TITANIUM_ORE));
		}
		else if (variant == EnumType.URANIUM) {
			drops.add(new ItemStack(ModItems.URANIUM_ORE));
		}
		else if (variant == EnumType.TUNGSTEN) {
			drops.add(new ItemStack(ModItems.TUNGSTEN_ORE));
		}
		else if (variant == EnumType.RUBY) {
			drops.add(new ItemStack(ModItems.RUBY));
		}
		else if (variant == EnumType.SAPPHIRE) {
			drops.add(new ItemStack(ModItems.SAPPHIRE));
		}
		else if (variant == EnumType.MAJORITE) {
			drops.add(new ItemStack(ModItems.MAJORITE));
		}
		else if (variant == EnumType.AMAZONITE) {
			drops.add(new ItemStack(ModItems.AMAZONITE));
		}
		else if (variant == EnumType.ONYX) {
			drops.add(new ItemStack(ModItems.ONYX));
		}
		else
		{
			super.getDrops(drops, world, pos, state, fortune);
		}
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		return this.quantityDropped(random) + random.nextInt(fortune + 1);
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		if (this.getItemDropped(state, RANDOM, fortune) != Item.getItemFromBlock(this))
		{
			return 40 + RANDOM.nextInt(5);
		}
		return 0;
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
		FerropericlaseOre.EnumType variant = state.getValue(VARIANT);
		if (variant == EnumType.LAPIS) return EnumDyeColor.BLUE.getDyeDamage();
		return variant.getMeta();
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
				worldIn.setBlockState(pos.up(), Blocks.FIRE.getDefaultState(), 11);
			}
		}
		super.randomTick(worldIn, pos, state, rand);
	}

	// Define a map from rock types to a list of associated ore Blocks
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (FerropericlaseOre.EnumType Blackstone$enumtype : FerropericlaseOre.EnumType.values()) {
			items.add(new ItemStack(this, 1, Blackstone$enumtype.getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, FerropericlaseOre.EnumType.byMetadata(meta));
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
		COAL(0, "coal"),
		IRON(1, "iron"),
		SULFUR(2, "sulfur"),
		REDSTONE(3, "redstone"),
		LAPIS(4, "lapis"),
		DIAMOND (5, "diamond"),
		EMERALD (6, "emerald"),
		TITANIUM (7, "titanium"),
		URANIUM (8, "uranium"),
		TUNGSTEN (9, "tungsten"),
		RUBY (10, "ruby"),
		SAPPHIRE (11, "sapphire"),
		MAJORITE (12, "majorite"),
		AMAZONITE (13, "amazonite"),
		ONYX (14, "onyx");

		private static final FerropericlaseOre.EnumType[] META_LOOKUP = new FerropericlaseOre.EnumType[] {COAL, IRON, SULFUR, REDSTONE, LAPIS, DIAMOND, EMERALD, TITANIUM, URANIUM, TUNGSTEN, RUBY, SAPPHIRE, MAJORITE, AMAZONITE, ONYX};
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
			for(EnumType PeridotiteOre$enumtype : values())
			{
				META_LOOKUP[PeridotiteOre$enumtype.getMeta()] = PeridotiteOre$enumtype;
			}
		}
	}



	@Override
	public String getSpecialName(ItemStack stack)
	{
		return FerropericlaseOre.EnumType.values()[stack.getItemDamage()].getName();
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(VARIANT, FerropericlaseOre.EnumType.byMetadata(meta));
	}
}
