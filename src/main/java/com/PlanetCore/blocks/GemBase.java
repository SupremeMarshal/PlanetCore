package com.SupremeMarshal.ToTheEarthCore.blocks;

import com.SupremeMarshal.ToTheEarthCore.init.ModBlocks;
import com.SupremeMarshal.ToTheEarthCore.init.ModItems;
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

public class GemBase extends BlockBase 
{

	public GemBase(String name, Material material) {
		super(name, material);
		
		setSoundType(SoundType.STONE);
		setHardness(1.0F);
		setResistance(15.0F);
		setHarvestLevel("pickaxe", 1);

		


	}

	@Override
	public Item getItemDropped(IBlockState state, Random random, int l)
	{
	Block block = this;

	if (block == ModBlocks.HARDSTONE_EMERALD || block == ModBlocks.DEEPSTONE_EMERALD || block == ModBlocks.CRUSTROCK_EMERALD || block == ModBlocks.MANTLEROCK_EMERALD || block == ModBlocks.LOWER_MANTLEROCK_EMERALD)
	{return new ItemStack(Items.EMERALD, (int) (1), 0).getItem();}
	else if (block == ModBlocks.SAPHIR_ORE || block == ModBlocks.HARDSTONE_SAPHIR || block == ModBlocks.DEEPSTONE_SAPHIR || block == ModBlocks.CRUSTROCK_SAPHIR || block == ModBlocks.MANTLEROCK_SAPHIR || block == ModBlocks.LOWER_MANTLEROCK_SAPHIR)
	{return new ItemStack(ModItems.SAPHIR, (int) (1), 0).getItem();}
	else if (block == ModBlocks.RUBY_ORE || block == ModBlocks.HARDSTONE_RUBY || block == ModBlocks.DEEPSTONE_RUBY || block == ModBlocks.CRUSTROCK_RUBY || block == ModBlocks.MANTLEROCK_RUBY || block == ModBlocks.LOWER_MANTLEROCK_RUBY)
	{return new ItemStack(ModItems.RUBY, (int) (1), 0).getItem();}
	else if (block == ModBlocks.TOPAZ_ORE || block == ModBlocks.HARDSTONE_TOPAZ || block == ModBlocks.DEEPSTONE_TOPAZ || block == ModBlocks.CRUSTROCK_TOPAZ || block == ModBlocks.MANTLEROCK_TOPAZ || block == ModBlocks.LOWER_MANTLEROCK_TOPAZ)
	{return new ItemStack(ModItems.TOPAZ, (int) (1), 0).getItem();}
	else if (block == ModBlocks.DIAMOND_ORE || block == ModBlocks.HARDSTONE_DIAMOND || block == ModBlocks.DEEPSTONE_DIAMOND || block == ModBlocks.CRUSTROCK_DIAMOND || block == ModBlocks.MANTLEROCK_DIAMOND || block == ModBlocks.LOWER_MANTLEROCK_DIAMOND)
	{return new ItemStack(ModItems.DIAMOND, (int) (1), 0).getItem();}
	else if (block == ModBlocks.JADE_ORE || block == ModBlocks.HARDSTONE_JADE || block == ModBlocks.DEEPSTONE_JADE || block == ModBlocks.CRUSTROCK_JADE || block == ModBlocks.MANTLEROCK_JADE || block == ModBlocks.LOWER_MANTLEROCK_JADE)
	{return new ItemStack(ModItems.JADE, (int) (1), 0).getItem();}
	else if (block == ModBlocks.AMAZONITE_ORE || block == ModBlocks.HARDSTONE_AMAZONITE || block == ModBlocks.DEEPSTONE_AMAZONITE || block == ModBlocks.CRUSTROCK_AMAZONITE || block == ModBlocks.MANTLEROCK_AMAZONITE || block == ModBlocks.LOWER_MANTLEROCK_AMAZONITE)
	{return new ItemStack(ModItems.AMAZONITE, (int) (1), 0).getItem();}
	else if (block == ModBlocks.AMETHYST_ORE || block == ModBlocks.HARDSTONE_AMETHYST || block == ModBlocks.DEEPSTONE_AMETHYST || block == ModBlocks.CRUSTROCK_AMETHYST || block == ModBlocks.MANTLEROCK_AMETHYST || block == ModBlocks.LOWER_MANTLEROCK_AMETHYST)
	{return new ItemStack(ModItems.AMETHYST, (int) (1), 0).getItem();}
	else if (block == ModBlocks.ONYX_ORE || block == ModBlocks.HARDSTONE_ONYX || block == ModBlocks.DEEPSTONE_ONYX || block == ModBlocks.CRUSTROCK_ONYX || block == ModBlocks.MANTLEROCK_ONYX || block == ModBlocks.LOWER_MANTLEROCK_ONYX)
	{return new ItemStack(ModItems.ONYX, (int) (1), 0).getItem();}
	else if (block == ModBlocks.AZURITE_ORE || block == ModBlocks.HARDSTONE_AZURITE || block == ModBlocks.DEEPSTONE_AZURITE || block == ModBlocks.CRUSTROCK_AZURITE || block == ModBlocks.MANTLEROCK_AZURITE || block == ModBlocks.LOWER_MANTLEROCK_AZURITE)
	{return new ItemStack(ModItems.AZURITE, (int) (1), 0).getItem();}
	else if (block == ModBlocks.HARDSTONE_COAL || block == ModBlocks.DEEPSTONE_COAL || block == ModBlocks.CRUSTROCK_COAL || block == ModBlocks.MANTLEROCK_COAL || block == ModBlocks.LOWER_MANTLEROCK_COAL)
	{return new ItemStack(Items.COAL, (int) (1), 0).getItem();}
	else if (block == ModBlocks.HARDSTONE_REDSTONE || block == ModBlocks.DEEPSTONE_REDSTONE || block == ModBlocks.CRUSTROCK_REDSTONE || block == ModBlocks.MANTLEROCK_REDSTONE || block == ModBlocks.LOWER_MANTLEROCK_REDSTONE)
	{return new ItemStack(Items.REDSTONE, (int) (1), 0).getItem();}
	else if (block == ModBlocks.SULFUR_ORE || block == ModBlocks.HARDSTONE_SULFUR || block == ModBlocks.DEEPSTONE_SULFUR || block == ModBlocks.CRUSTROCK_SULFUR || block == ModBlocks.MANTLEROCK_SULFUR || block == ModBlocks.LOWER_MANTLEROCK_SULFUR)
	{return new ItemStack(ModItems.SULFUR, 1,0).getItem();}
	else
	{return new ItemStack(block, (int) (1), 0).getItem();}
	}

	@Override
	public int quantityDropped(Random random) {
		Block block = this;

		if ( block == ModBlocks.HARDSTONE_REDSTONE)
		{
			return 5 + random.nextInt(3);
		}
			
		else if (block == ModBlocks.DEEPSTONE_REDSTONE)
		{
			return 6 + random.nextInt(4);
		}
		
		else if (block == ModBlocks.CRUSTROCK_REDSTONE)
		{
			return 8 + random.nextInt(6);
		}
		else if (block == ModBlocks.MANTLEROCK_REDSTONE)
		{
			return 10 + random.nextInt(8);
		}
		else if (block == ModBlocks.LOWER_MANTLEROCK_REDSTONE)
		{
			return 11 + random.nextInt(9);
		}
		else if (block == ModBlocks.DEEPSTONE_COAL || block == ModBlocks.DEEPSTONE_SULFUR)
		{
			return 2;
		}
		else if (block == ModBlocks.CRUSTROCK_COAL || block == ModBlocks.CRUSTROCK_SULFUR)
		{
			return 3;
		}
		else if (block == ModBlocks.MANTLEROCK_COAL || block == ModBlocks.MANTLEROCK_SULFUR)
		{
			return 4;
		}
		else if (block == ModBlocks.LOWER_MANTLEROCK_COAL || block == ModBlocks.LOWER_MANTLEROCK_SULFUR)
		{
			return 4;
		}
		else
		{
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
			if (block == ModBlocks.HARDSTONE_COAL || block == ModBlocks.DEEPSTONE_COAL || block == ModBlocks.CRUSTROCK_COAL || block == ModBlocks.MANTLEROCK_COAL ||
				block == ModBlocks.HARDSTONE_REDSTONE || block == ModBlocks.DEEPSTONE_REDSTONE || block == ModBlocks.CRUSTROCK_REDSTONE || block == ModBlocks.MANTLEROCK_REDSTONE ||
				block == ModBlocks.HARDSTONE_EMERALD || block == ModBlocks.DEEPSTONE_EMERALD || block == ModBlocks.CRUSTROCK_EMERALD || block == ModBlocks.MANTLEROCK_EMERALD ||
				block == ModBlocks.SULFUR_ORE || block == ModBlocks.HARDSTONE_SULFUR || block == ModBlocks.DEEPSTONE_SULFUR || block == ModBlocks.CRUSTROCK_SULFUR || block == ModBlocks.MANTLEROCK_SULFUR)
		{
			world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
		}
		else if (block == ModBlocks.SAPHIR_ORE || block == ModBlocks.HARDSTONE_SAPHIR || block == ModBlocks.DEEPSTONE_SAPHIR || block == ModBlocks.CRUSTROCK_SAPHIR || block == ModBlocks.MANTLEROCK_SAPHIR)
		{
			for (int i = 0; i < 5; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.FLAMING_TOPAZ_ORE || block == ModBlocks.HARDSTONE_FLAMING_TOPAZ || block == ModBlocks.DEEPSTONE_FLAMING_TOPAZ || block == ModBlocks.CRUSTROCK_FLAMING_TOPAZ || block == ModBlocks.MANTLEROCK_FLAMING_TOPAZ)
		{
			for (int i = 0; i < 6; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.RUBY_ORE || block == ModBlocks.HARDSTONE_RUBY || block == ModBlocks.DEEPSTONE_RUBY || block == ModBlocks.CRUSTROCK_RUBY || block == ModBlocks.MANTLEROCK_RUBY)
		{
			for (int i = 0; i < 8; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.TOPAZ_ORE || block == ModBlocks.HARDSTONE_TOPAZ || block == ModBlocks.DEEPSTONE_TOPAZ || block == ModBlocks.CRUSTROCK_TOPAZ || block == ModBlocks.MANTLEROCK_TOPAZ)
		{
			for (int i = 0; i < 9; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.DIAMOND_ORE || block == ModBlocks.HARDSTONE_DIAMOND || block == ModBlocks.DEEPSTONE_DIAMOND || block == ModBlocks.CRUSTROCK_DIAMOND || block == ModBlocks.MANTLEROCK_DIAMOND)
		{
			for (int i = 0; i < 12; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.JADE_ORE || block == ModBlocks.HARDSTONE_JADE || block == ModBlocks.DEEPSTONE_JADE || block == ModBlocks.CRUSTROCK_JADE || block == ModBlocks.MANTLEROCK_JADE)
		{
			for (int i = 0; i < 15; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.AMAZONITE_ORE || block == ModBlocks.HARDSTONE_AMAZONITE || block == ModBlocks.DEEPSTONE_AMAZONITE || block == ModBlocks.CRUSTROCK_AMAZONITE || block == ModBlocks.MANTLEROCK_AMAZONITE)
		{
			for (int i = 0; i < 20; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.AMETHYST_ORE || block == ModBlocks.HARDSTONE_AMETHYST || block == ModBlocks.DEEPSTONE_AMETHYST || block == ModBlocks.CRUSTROCK_AMETHYST || block == ModBlocks.MANTLEROCK_AMETHYST)
		{
			for (int i = 0; i < 4; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 4));
			}
			for (int i = 0; i < 9; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.ONYX_ORE || block == ModBlocks.HARDSTONE_ONYX || block == ModBlocks.DEEPSTONE_ONYX || block == ModBlocks.CRUSTROCK_ONYX || block == ModBlocks.MANTLEROCK_ONYX)
		{
			for (int i = 0; i < 6; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 4));
			}
			for (int i = 0; i < 13; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.AZURITE_ORE || block == ModBlocks.HARDSTONE_AZURITE || block == ModBlocks.DEEPSTONE_AZURITE || block == ModBlocks.CRUSTROCK_AZURITE || block == ModBlocks.MANTLEROCK_AZURITE)
		{
			for (int i = 0; i < 9; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 4));
			}
			for (int i = 0; i < 18; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		}
		return super.removedByPlayer(state, world, pos, entity, willHarvest);
	}


// override getItemDropped() and damageDropped() respectively. one for the item, one for the meta

}


