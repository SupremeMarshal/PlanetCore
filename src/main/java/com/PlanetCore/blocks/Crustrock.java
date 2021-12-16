package com.PlanetCore.blocks;




import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
import com.PlanetCore.init.blocks.item.ItemBlockVariants;
import com.PlanetCore.util.IMetaName;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class Crustrock extends BlockBase implements IMetaName
{



	public static final PropertyEnum<Crustrock.EnumType> VARIANT = PropertyEnum.create("variant", Crustrock.EnumType.class);

	public Crustrock(String name, Material material)
	{
		super(name, material);

		setSoundType(SoundType.STONE);
		setHarvestLevel("pickaxe", 0);
		setTickRandomly(true);

	}

	@Override
	public Item getItemDropped(IBlockState state, Random random, int l) {
		int meta = this.getMetaFromState(state);
		if (meta >= 3 && this == ModBlocks.CRUSTROCK)
			return Item.getItemFromBlock(ModBlocks.CRUST_COBBLESTONE);
		else if (meta < 3 && this == ModBlocks.CRUSTROCK)
			return Item.getItemFromBlock(Blocks.COBBLESTONE);
		else return super.getItemDropped(state, random, l);
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (Crustrock.EnumType crustrock$enumtype : Crustrock.EnumType.values()) {
			items.add(new ItemStack(this, 1, crustrock$enumtype.getMeta()));
		}
	}



	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, Crustrock.EnumType.byMetadata(meta));
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
		return new BlockStateContainer(this, VARIANT);
	}


	public enum EnumType implements IStringSerializable
	{
		CRUSTROCK(0, "crustrock"),
		CRUSTROCK1(1, "crustrock1"),
		CRUSTROCK2(2, "crustrock2");



		private static final Crustrock.EnumType[] META_LOOKUP = new Crustrock.EnumType[]{CRUSTROCK,CRUSTROCK1,CRUSTROCK2};
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

		public static Crustrock.EnumType byMetadata(int meta)
		{
			return META_LOOKUP[meta];
		}

		static {
			for(Crustrock.EnumType crustrock$enumtype : values())
			{
				META_LOOKUP[crustrock$enumtype.getMeta()] = crustrock$enumtype;
			}
		}
	}

	@Override
	public String getSpecialName(ItemStack stack)
	{
		return Crustrock.EnumType.values()[stack.getItemDamage()].getName();
	}



	//Lava Decompression event
	//Lava being spawned from removing the pressure
	//This event can be stacked with earthquake.
	//=(G26+1536)/(-12500)/64
	//=(G152+9600)/(-12500)/64
	public void lavaDecompression(World worldIn, BlockPos pos, IBlockState state) {
		float chance = pos.getY()+1000/-3000/64F;
		float chance1 = pos.getY()+9600/-3000/64F;
		if (pos.getY() < -1000 && Math.random() <= chance && !worldIn.isRemote) {
			worldIn.setBlockState(pos, Blocks.LAVA.getDefaultState());
		}
	}

	@Override
	public void onPlayerDestroy(World worldIn, BlockPos pos, IBlockState state) {
		//naturalGasExplosion(worldIn, pos, state);
		//earthquake(worldIn, pos, state);
		lavaDecompression(worldIn, pos, state);
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
