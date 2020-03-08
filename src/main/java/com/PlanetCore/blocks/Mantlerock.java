package com.PlanetCore.blocks;


import com.PlanetCore.Main;
import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
import com.PlanetCore.util.IHasModel;
import com.google.common.base.Predicate;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMaterialMatcher;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;

import static org.apache.commons.lang3.RandomUtils.nextDouble;


public class Mantlerock extends BlockBase
{

	public Mantlerock(String name, Material material) {
		super(name, material);

		setSoundType(SoundType.STONE);

		setResistance(100.0F);
		setHarvestLevel("pickaxe", 0);
		setTickRandomly(true);

	}

	//Natural Gas Explosion event
	//Upon destroying the block, it has a small chance to explode. The deeper the rock is, the more probability it has to explode with a larger explosion.
	public void naturalGasExplosion(World worldIn, BlockPos pos, IBlockState state)
	{
		double r = nextDouble();
		int X = pos.getX();
		int Z = pos.getZ();
		for(int Y = -768; Y > -4544; Y--)
		{
			int Strength = Y / -768 + 2;
			try
			{
				double Probability = 10000 / (Y + 768);

				r = r * (Probability);
				if (r <= Probability)
				{
					worldIn.createExplosion(null, X, Y, Z, Strength, true);
				}
			}
			catch (ArithmeticException e)
			{
				return;
			}
		}
		for(int Y = -4545; Y > -5824; Y--)
		{
			int Strength = Y / -768 + 2;
			try
			{
				double Probability = 5000 / (Y + 4544) + 0.006;
				r = r * (Probability);
				if (r <= Probability)
				{
					worldIn.createExplosion(null, X, Y, Z, Strength, true);
				}
			}
			catch (ArithmeticException e)
			{
				return;
			}
		}
	}


	//Earthquake event
	//Upon destroying the block, by a player or by explosion, the surrounding area for the player have a chance to crumble.
	//How this event should work




	//Lava being spawned from removing the pressure
	//This event can be stacked with earthquake.

	@Override
	public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
		super.onBlockExploded(world, pos, explosion);
		naturalGasExplosion(world, pos, (IBlockState)explosion);
	}

	@Override
	public void onPlayerDestroy(World worldIn, BlockPos pos, IBlockState state) {
		super.onPlayerDestroy(worldIn, pos, state);
		naturalGasExplosion(worldIn, pos, state);
	}



}
