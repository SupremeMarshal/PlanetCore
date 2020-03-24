package com.PlanetCore.blocks;

import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;

public class GemBase_small extends BlockBase
{

	public GemBase_small(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 1);

		


	}

	@Override
	public Item getItemDropped(IBlockState state, Random random, int l) {
		Block block = this;

		if (block == ModBlocks.HARDROCK_EMERALD || block == ModBlocks.DEEPROCK_EMERALD || block == ModBlocks.CRUSTROCK_EMERALD || block == ModBlocks.MANTLEROCK_EMERALD || block == ModBlocks.LOWER_MANTLEROCK_EMERALD) {
			return new ItemStack(Items.EMERALD, (int) (1), 0).getItem();
		} else if (block == ModBlocks.SAPPHIRE_ORE || block == ModBlocks.HARDROCK_SAPPHIRE || block == ModBlocks.DEEPROCK_SAPPHIRE || block == ModBlocks.CRUSTROCK_SAPPHIRE || block == ModBlocks.MANTLEROCK_SAPPHIRE || block == ModBlocks.LOWER_MANTLEROCK_SAPPHIRE) {
			return new ItemStack(ModItems.SAPPHIRE, (int) (1), 0).getItem();
		} else if (block == ModBlocks.RUBY_ORE || block == ModBlocks.HARDROCK_RUBY || block == ModBlocks.DEEPROCK_RUBY || block == ModBlocks.CRUSTROCK_RUBY || block == ModBlocks.MANTLEROCK_RUBY || block == ModBlocks.LOWER_MANTLEROCK_RUBY) {
			return new ItemStack(ModItems.RUBY, (int) (1), 0).getItem();
		} else if (block == ModBlocks.TOPAZ_ORE || block == ModBlocks.HARDROCK_TOPAZ || block == ModBlocks.DEEPROCK_TOPAZ || block == ModBlocks.CRUSTROCK_TOPAZ || block == ModBlocks.MANTLEROCK_TOPAZ || block == ModBlocks.LOWER_MANTLEROCK_TOPAZ) {
			return new ItemStack(ModItems.TOPAZ, (int) (1), 0).getItem();
		} else if (block == ModBlocks.DIAMOND_ORE || block == ModBlocks.HARDROCK_DIAMOND || block == ModBlocks.DEEPROCK_DIAMOND || block == ModBlocks.CRUSTROCK_DIAMOND || block == ModBlocks.MANTLEROCK_DIAMOND || block == ModBlocks.LOWER_MANTLEROCK_DIAMOND) {
			return new ItemStack(ModItems.DIAMOND, (int) (1), 0).getItem();
		} else if (block == ModBlocks.JADE_ORE || block == ModBlocks.HARDROCK_JADE || block == ModBlocks.DEEPROCK_JADE || block == ModBlocks.CRUSTROCK_JADE || block == ModBlocks.MANTLEROCK_JADE || block == ModBlocks.LOWER_MANTLEROCK_JADE) {
			return new ItemStack(ModItems.JADE, (int) (1), 0).getItem();
		} else if (block == ModBlocks.AMAZONITE_ORE || block == ModBlocks.HARDROCK_AMAZONITE || block == ModBlocks.DEEPROCK_AMAZONITE || block == ModBlocks.CRUSTROCK_AMAZONITE || block == ModBlocks.MANTLEROCK_AMAZONITE || block == ModBlocks.LOWER_MANTLEROCK_AMAZONITE) {
			return new ItemStack(ModItems.AMAZONITE, (int) (1), 0).getItem();
		} else if (block == ModBlocks.ONYX_ORE || block == ModBlocks.HARDROCK_ONYX || block == ModBlocks.DEEPROCK_ONYX || block == ModBlocks.CRUSTROCK_ONYX || block == ModBlocks.MANTLEROCK_ONYX || block == ModBlocks.LOWER_MANTLEROCK_ONYX) {
			return new ItemStack(ModItems.ONYX, (int) (1), 0).getItem();
		} else if (block == ModBlocks.HARDROCK_COAL || block == ModBlocks.DEEPROCK_COAL || block == ModBlocks.CRUSTROCK_COAL || block == ModBlocks.MANTLEROCK_COAL || block == ModBlocks.LOWER_MANTLEROCK_COAL) {
			return new ItemStack(Items.COAL, (int) (1), 0).getItem();
		} else if (block == ModBlocks.HARDROCK_REDSTONE || block == ModBlocks.DEEPROCK_REDSTONE || block == ModBlocks.CRUSTROCK_REDSTONE || block == ModBlocks.MANTLEROCK_REDSTONE || block == ModBlocks.LOWER_MANTLEROCK_REDSTONE) {
			return new ItemStack(Items.REDSTONE, (int) (1), 0).getItem();
		} else if (block == ModBlocks.SULFUR_ORE || block == ModBlocks.HARDROCK_SULFUR || block == ModBlocks.DEEPROCK_SULFUR || block == ModBlocks.CRUSTROCK_SULFUR || block == ModBlocks.MANTLEROCK_SULFUR || block == ModBlocks.LOWER_MANTLEROCK_SULFUR) {
			return new ItemStack(ModItems.SULFUR, 1, 0).getItem();
		} else if (block == ModBlocks.DEEPROCK_LAPIS || block == ModBlocks.HARDROCK_LAPIS || block == ModBlocks.CRUSTROCK_LAPIS || block == ModBlocks.MANTLEROCK_LAPIS || block == ModBlocks.LOWER_MANTLEROCK_LAPIS || block == ModBlocks.CORESTONE_LAPIS || block == ModBlocks.INNERCORESTONE_LAPIS || block == ModBlocks.CENTERCORESTONE_LAPIS) {
			return Items.DYE;
		} else {
			return new ItemStack(block, (int) (1), 0).getItem();
		}
	}

	@Override
	public int quantityDropped(Random random) {
		Block block = this;

		if (block == ModBlocks.HARDROCK_REDSTONE) {
			return 5 + random.nextInt(3);
		} else if (block == ModBlocks.DEEPROCK_REDSTONE) {
			return 6 + random.nextInt(4);
		} else if (block == ModBlocks.CRUSTROCK_REDSTONE) {
			return 8 + random.nextInt(6);
		} else if (block == ModBlocks.MANTLEROCK_REDSTONE) {
			return 10 + random.nextInt(8);
		} else if (block == ModBlocks.LOWER_MANTLEROCK_REDSTONE) {
			return 11 + random.nextInt(9);
		} else if (block == ModBlocks.DEEPROCK_COAL || block == ModBlocks.DEEPROCK_SULFUR) {
			return 2;
		} else if (block == ModBlocks.CRUSTROCK_COAL || block == ModBlocks.CRUSTROCK_SULFUR) {
			return 3;
		} else if (block == ModBlocks.MANTLEROCK_COAL || block == ModBlocks.MANTLEROCK_SULFUR) {
			return 4;
		} else if (block == ModBlocks.LOWER_MANTLEROCK_COAL || block == ModBlocks.LOWER_MANTLEROCK_SULFUR) {
			return 4;
		} else if (block == ModBlocks.HARDROCK_LAPIS) {
			return 3;
		} else if (block == ModBlocks.DEEPROCK_LAPIS) {
			return 4;
		} else if (block == ModBlocks.CRUSTROCK_LAPIS) {
			return 8;
		} else if (block == ModBlocks.MANTLEROCK_LAPIS) {
			return 12;
		} else if (block == ModBlocks.LOWER_MANTLEROCK_LAPIS) {
			return 16;
		} else {
			return 1;
		}
	}


	@Override
	public boolean canDropFromExplosion(Explosion explosionIn)
	{
		return false;
	}

	@Override
	public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer entity, boolean willHarvest) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		Block block = this;
		if (!world.isRemote) {
			if (block == ModBlocks.HARDROCK_REDSTONE || block == ModBlocks.DEEPROCK_REDSTONE || block == ModBlocks.CRUSTROCK_REDSTONE || block == ModBlocks.MANTLEROCK_REDSTONE) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		return super.removedByPlayer(state, world, pos, entity, willHarvest);
	}

	@Override
	public int damageDropped(IBlockState state) {
		Block block = this;
		if (block == ModBlocks.DEEPROCK_LAPIS || block == ModBlocks.HARDROCK_LAPIS || block == ModBlocks.CRUSTROCK_LAPIS || block == ModBlocks.MANTLEROCK_LAPIS || block == ModBlocks.LOWER_MANTLEROCK_LAPIS || block == ModBlocks.CORESTONE_LAPIS || block == ModBlocks.INNERCORESTONE_LAPIS || block == ModBlocks.CENTERCORESTONE_LAPIS) {
			return 4;
		}
		return super.damageDropped(state);
	}

// override getItemDropped() and damageDropped() respectively. one for the item, one for the meta

}


