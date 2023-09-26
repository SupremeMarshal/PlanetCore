package com.PlanetCore.blocks;

import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class SlateOre extends Slate
{

	private boolean isOn;
	public final PlanetMaterial planetMaterial;
	public final PlanetHardness planetHardness;
	public final PlanetHarvestLevel planetHarvestLevel;
	public final PlanetExp planetExp;

	public SlateOre(String name, Material material, PlanetMaterial planetMaterial, PlanetHardness planetHardness, PlanetHarvestLevel planetHarvestLevel, PlanetExp planetExp)
	{
		super(name, material);
		this.planetMaterial = planetMaterial;
		this.planetHardness = planetHardness;
		this.planetHarvestLevel = planetHarvestLevel;
		this.planetExp = planetExp;
		setResistance(100);
	}

	@Override
	public int getHarvestLevel(IBlockState state) {
		return planetHarvestLevel.harvestLevel;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random random, int i) {
		return this.planetMaterial.droppedItem;
	}

	@Override
	public int damageDropped(IBlockState state) {
		if (this == ModBlocks.SLATE_LAPIS) {
			return EnumDyeColor.BLUE.getDyeDamage();
		}
		else return 0;
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

	@Override
	public int quantityDropped(Random random)
	{
		if (this == ModBlocks.SLATE_LAPIS) return 4 + random.nextInt(5);
		else if (this == ModBlocks.SLATE_REDSTONE) return 4 + random.nextInt(2);
		else return 1;
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random)
	{
		return this.quantityDropped(random) + random.nextInt(fortune + 1);
	}
}
