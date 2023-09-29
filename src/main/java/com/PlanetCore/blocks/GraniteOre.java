package com.PlanetCore.blocks;


import com.PlanetCore.init.EnchantmentInit;
import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
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
import net.minecraft.world.World;

import java.util.Random;

public class GraniteOre extends BlockBase implements IMetaName
{
	public static final PropertyEnum<GraniteOre.EnumType> VARIANT = PropertyEnum.create("variant", GraniteOre.EnumType.class);

	public GraniteOre(String name, Material material) {
		super(name, material,false);
		setResistance(100);
	}

	@Override
	public int quantityDropped(Random random)
	{
		if (this == ModBlocks.GRANITE.getStateFromMeta(4).getBlock()) return 4 + random.nextInt(5);
		else if (this == ModBlocks.GRANITE.getStateFromMeta(3).getBlock()) return 4 + random.nextInt(2);
		else return 1;
	}
	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		return this.quantityDropped(random) + random.nextInt(fortune + 1);
	}

	@Override
	public int damageDropped(IBlockState state) {
		int meta = getMetaFromState(state);
		if (meta == 4) return EnumDyeColor.BLUE.getDyeDamage();
		else return meta;
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
		int meta = getMetaFromState(state);
		if (meta == 0) return Items.COAL;
		else if (meta == 1) return ModItems.IRON_ORE;
		else if (meta == 2) return ModItems.SULFUR;
		else if (meta == 3) return Items.REDSTONE;
		else if (meta == 4) return Items.DYE;
		else if (meta == 5) return ModItems.SILVER_ORE;
		else if (meta == 6) return ModItems.GOLD_ORE;
		else if (meta == 7) return Items.DIAMOND;
		else if (meta == 8) return Items.EMERALD;
		return super.getItemDropped(state, random, l);
	}

	// Define a map from rock types to a list of associated ore Blocks
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (GraniteOre.EnumType Granite$enumtype : GraniteOre.EnumType.values()) {
			items.add(new ItemStack(this, 1, Granite$enumtype.getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, GraniteOre.EnumType.byMetadata(meta));
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
		SILVER(5, "silver"),
		GOLD(6, "gold"),
		DIAMOND (7, "diamond"),
		EMERALD (8, "emerald");

		private static final GraniteOre.EnumType[] META_LOOKUP = new GraniteOre.EnumType[] {COAL, IRON, SULFUR, REDSTONE, LAPIS, SILVER, GOLD, DIAMOND, EMERALD};
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
			for(EnumType GraniteOre$enumtype : values())
			{
				META_LOOKUP[GraniteOre$enumtype.getMeta()] = GraniteOre$enumtype;
			}
		}
	}



	@Override
	public String getSpecialName(ItemStack stack)
	{
		return GraniteOre.EnumType.values()[stack.getItemDamage()].getName();
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		return this.getDefaultState().withProperty(VARIANT, GraniteOre.EnumType.byMetadata(meta));
	}
}
