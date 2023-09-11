package com.PlanetCore.blocks;


import com.PlanetCore.init.EnchantmentInit;
import com.PlanetCore.init.ModBlocks;
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
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

import java.util.Random;

public class GarnetOre extends BlockBase implements IMetaName
{
	public final PlanetMaterial planetMaterial;
	public final PlanetHarvestLevel planetHarvestLevel;
	public final PlanetExp planetExp;
	public static final PropertyEnum<GarnetOre.EnumType> VARIANT = PropertyEnum.create("variant", GarnetOre.EnumType.class);

	public GarnetOre(String name, Material material, PlanetMaterial planetMaterial, PlanetHarvestLevel planetHarvestLevel, PlanetExp planetExp) {
		super(name, material,false);
		this.planetMaterial = planetMaterial;
		this.planetHarvestLevel = planetHarvestLevel;
		this.planetExp = planetExp;
	}

	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		double hardness = 0;
		double Y = pos.getY();
		if (Y < 0 && Y >= -1200)
		{
			hardness = Y * -0.02916666f + 3;
		}
		else if (Y < -1200 && Y >= -2000)
		{
			hardness = (Y + 1200) * 0.09 + 39;
		}
		else if (Y < -2000 && Y >= -2500)
		{
			hardness = (Y + 2000) * 0.072 + 111;
		}
		else if (Y < -2500 && Y >= -3000)
		{
			hardness = (Y + 2500) * 0.144 + 147;
		}
		else if (Y < -3000 && Y >= -4000)
		{
			hardness = (Y + 3000) * 0.144 + 219;
		}
		else if (Y < -4000 && Y >= -5000)
		{
			hardness = (Y + 4000) * 0.18 + 363;
		}
		else if (Y < -5000 && Y >= -5500)
		{
			hardness = (Y + 5000) * 0.54 + 543;
		}
		else if (Y < -5500 && Y >= -6000)
		{
			hardness = (Y + 5500) * 0.81 + 813;
		}
		else if (Y < -6000)
		{
			hardness = (Y + 6000) * 1.636118598 + 1218;
		}
		else return 3;
		return (float) hardness;
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
				worldIn.setBlockState(pos.up(), Blocks.FIRE.getDefaultState(), 11);
			}
		}
		super.randomTick(worldIn, pos, state, rand);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random random, int l) {
		return super.getItemDropped(state, random, l);
	}

	// Define a map from rock types to a list of associated ore Blocks
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (GarnetOre.EnumType Blackstone$enumtype : GarnetOre.EnumType.values()) {
			items.add(new ItemStack(this, 1, Blackstone$enumtype.getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, GarnetOre.EnumType.byMetadata(meta));
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
		SAPPHIRE (11, "sapphire");

		private static final GarnetOre.EnumType[] META_LOOKUP = new GarnetOre.EnumType[] {COAL, IRON, SULFUR, REDSTONE, LAPIS, DIAMOND, EMERALD, TITANIUM, URANIUM, TUNGSTEN, RUBY, SAPPHIRE};
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
			for(EnumType GarnetOre$enumtype : values())
			{
				META_LOOKUP[GarnetOre$enumtype.getMeta()] = GarnetOre$enumtype;
			}
		}
	}



	@Override
	public String getSpecialName(ItemStack stack)
	{
		return GarnetOre.EnumType.values()[stack.getItemDamage()].getName();
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(VARIANT, GarnetOre.EnumType.byMetadata(meta));
	}
}
