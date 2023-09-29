package com.PlanetCore.blocks;


import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.items.Drills.IronDrillItem;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import java.util.Random;

public class SuperCompressedOreBlock extends BlockBase {
	public final PlanetMaterial planetMaterial;
	public final PlanetExp planetExp;
	public final PlanetHardness planetHardness;
	public SuperCompressedOreBlock(String name, Material material, PlanetMaterial planetMaterial, PlanetHardness planetHardness, PlanetExp planetExp) {
		super(name, material,false);
		setSoundType(SoundType.METAL);
		setHarvestLevel("pickaxe", 0);
		setTickRandomly(true);
		this.planetMaterial = planetMaterial;
		this.planetHardness = planetHardness;
		setHardness(planetHardness.hardness);
		this.planetExp = planetExp;
	}

	@Override
	public int damageDropped(IBlockState state) {
		if (this == ModBlocks.SUPERCOMPRESSED_LAPIS) return EnumDyeColor.BLUE.getDyeDamage();
		return getMetaFromState(state);
	}

	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		return planetHardness.hardness;
	}

	@Override
	public float getPlayerRelativeBlockHardness(IBlockState state, EntityPlayer player, World worldIn, BlockPos pos) {
		return player.getHeldItemMainhand().getItem() instanceof IronDrillItem ? super.getPlayerRelativeBlockHardness(state, player, worldIn, pos) : 0;
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
