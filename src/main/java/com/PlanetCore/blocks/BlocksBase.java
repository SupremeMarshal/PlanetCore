package com.PlanetCore.blocks;




import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.util.IMetaName;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class BlocksBase extends BlockBase implements IMetaName {
	public final PlanetMaterial planetMaterial;
	public final PlanetHardness planetHardness;
	public final PlanetExp planetExp;

	public static final PropertyEnum<BlocksBase.EnumType> VARIANT_SUPERCOMPRESSED = PropertyEnum.create("variant", BlocksBase.EnumType.class);
	public BlocksBase(String name, Material material, PlanetMaterial planetMaterial, PlanetHardness planetHardness, PlanetExp planetExp) {
		super(name, material,false);
		setSoundType(SoundType.METAL);
		setHarvestLevel("pickaxe", 0);
		setTickRandomly(true);
		this.planetMaterial = planetMaterial;
		this.planetHardness = planetHardness;
		this.planetExp = planetExp;
	}

	@Override
	public int damageDropped(IBlockState state) {
		return getMetaFromState(state);
	}

	@Override
	public int getLightValue(IBlockState state) {
		return (15);
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (BlocksBase.EnumType BlocksBase$enumtype : BlocksBase.EnumType.values()) {
			items.add(new ItemStack(this, 1, BlocksBase$enumtype.getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT_SUPERCOMPRESSED, BlocksBase.EnumType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(VARIANT_SUPERCOMPRESSED).getMeta();
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this),1, getMetaFromState(world.getBlockState(pos)));
	}


	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, VARIANT_SUPERCOMPRESSED);
	}




	public enum EnumType implements IStringSerializable
	{
		COLD(0, "supercompressed"),
		HOT(1, "hot_supercompressed"),
		VERYHOT(2, "veryhot_supercompressed"),
		SUPERHEATED(3, "superheated_supercompressed");

		private static final BlocksBase.EnumType[] META_LOOKUP = new BlocksBase.EnumType[]{COLD, HOT, VERYHOT, SUPERHEATED};
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

		public static BlocksBase.EnumType byMetadata(int meta)
		{
			return META_LOOKUP[meta];
		}

		static {
			for(BlocksBase.EnumType BlocksBase$enumtype : values())
			{
				META_LOOKUP[BlocksBase$enumtype.getMeta()] = BlocksBase$enumtype;
			}
		}
	}

	@Override
	public String getSpecialName(ItemStack stack)
	{
		return BlocksBase.EnumType.values()[stack.getItemDamage()].getName();
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		System.out.println(meta);
		return this.getDefaultState().withProperty(VARIANT_SUPERCOMPRESSED, BlocksBase.EnumType.byMetadata(meta));
	}

	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		return 1000000;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random random, int i) {
		return this.planetMaterial.droppedItem;
	}

	@Override
	public int quantityDropped(Random random)
	{
		if (this == ModBlocks.SUPERCOMPRESSED_LAPIS) return 36 + random.nextInt(5);
		else if (this == ModBlocks.SUPERCOMPRESSED_REDSTONE) return 36 + random.nextInt(2);
		else return 9;
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (this == ModBlocks.SUPERCOMPRESSED_REDSTONE)
		{
			return this.quantityDropped(random) + random.nextInt(fortune + 1);
		}
		else if (fortune > 0 && Item.getItemFromBlock(this) != this.getItemDropped((IBlockState)this.getBlockState().getValidStates().iterator().next(), random, fortune))
		{
			int i = random.nextInt(fortune + 2) - 1;

			if (i < 0)
			{
				i = 0;
			}

			return this.quantityDropped(random) * (i + 1);
		}
		else
		{
			return this.quantityDropped(random);
		}
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
			int i = MathHelper.getInt(rand, (int) planetExp.exp, (int) planetExp.exp * 2);
			return i;
		}
		else return 0;
	}
}
