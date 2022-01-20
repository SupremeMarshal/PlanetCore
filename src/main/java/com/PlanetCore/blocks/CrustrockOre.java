package com.PlanetCore.blocks;

import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.util.IMetaName;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class CrustrockOre extends Crustrock implements IMetaName
{

	public final PlanetMaterial planetMaterial;
	public final PlanetHardness planetHardness;
	private static final float [] crustHardnessByMeta = {9, 14, 22};

	public CrustrockOre(String name, Material material, PlanetMaterial planetMaterial, PlanetHardness planetHardness)
	{
		super(name, material);
		this.planetMaterial = planetMaterial;
		this.planetHardness = planetHardness;
	}

	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		int meta = getMetaFromState(blockState);
		if (planetHardness.hardness < crustHardnessByMeta[meta])
		{
			return crustHardnessByMeta[meta];
		}
		return planetHardness.hardness;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random random, int i) {
		return this.planetMaterial.droppedItem;
	}

	@Override
	public int damageDropped(IBlockState state) {
		if (this == ModBlocks.CRUSTROCK_LAPIS) {
			return EnumDyeColor.BLUE.getDyeDamage();
		}
		else return 0;
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
			int i = 0;
			if (this == ModBlocks.CRUSTROCK_SULFUR || this == ModBlocks.CRUSTROCK_COAL) {
				i = MathHelper.getInt(rand, 1, 2);
			} else if (this == ModBlocks.CRUSTROCK_LAPIS) {
				i = MathHelper.getInt(rand, 1, 3);
			}
			return i;
		}
		else return 0;
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (this == ModBlocks.CRUSTROCK_REDSTONE || this == ModBlocks.CRUSTROCK_LAPIS)
		{
			return 4 + new Random().nextInt(fortune * 2 + 2);
		}
		else return 1;
	}
}
