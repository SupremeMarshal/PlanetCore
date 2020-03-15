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

public class CoreRockGemBase extends Corerock
{

	public CoreRockGemBase(String name, Material material) {
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

	if (block == ModBlocks.CORESTONE_EMERALD || block == ModBlocks.INNERCORESTONE_EMERALD || block == ModBlocks.CENTERCORESTONE_EMERALD)
	{return new ItemStack(Items.EMERALD, (int) (1), 0).getItem();}
	else if (block == ModBlocks.CORESTONE_SAPPHIRE || block == ModBlocks.INNERCORESTONE_SAPPHIRE || block == ModBlocks.CENTERCORESTONE_SAPPHIRE)
	{return new ItemStack(ModItems.SAPPHIRE, (int) (1), 0).getItem();}
	else if (block == ModBlocks.CORESTONE_RUBY || block == ModBlocks.INNERCORESTONE_RUBY || block == ModBlocks.CENTERCORESTONE_RUBY)
	{return new ItemStack(ModItems.RUBY, (int) (1), 0).getItem();}
	else if (block == ModBlocks.CORESTONE_TOPAZ || block == ModBlocks.INNERCORESTONE_TOPAZ || block == ModBlocks.CENTERCORESTONE_TOPAZ)
	{return new ItemStack(ModItems.TOPAZ, (int) (1), 0).getItem();}
	else if (block == ModBlocks.CORESTONE_DIAMOND || block == ModBlocks.INNERCORESTONE_DIAMOND || block == ModBlocks.CENTERCORESTONE_DIAMOND)
	{return new ItemStack(ModItems.DIAMOND, (int) (1), 0).getItem();}
	else if (block == ModBlocks.CORESTONE_JADE || block == ModBlocks.INNERCORESTONE_JADE || block == ModBlocks.CENTERCORESTONE_JADE)
	{return new ItemStack(ModItems.JADE, (int) (1), 0).getItem();}
	else if (block == ModBlocks.CORESTONE_AMAZONITE || block == ModBlocks.INNERCORESTONE_AMAZONITE || block == ModBlocks.CENTERCORESTONE_AMAZONITE)
	{return new ItemStack(ModItems.AMAZONITE, (int) (1), 0).getItem();}
	else if (block == ModBlocks.CORESTONE_AMETHYST || block == ModBlocks.INNERCORESTONE_AMETHYST || block == ModBlocks.CENTERCORESTONE_AMETHYST)
	{return new ItemStack(ModItems.AMETHYST, (int) (1), 0).getItem();}
	else if (block == ModBlocks.CORESTONE_ONYX || block == ModBlocks.INNERCORESTONE_ONYX || block == ModBlocks.CENTERCORESTONE_ONYX)
	{return new ItemStack(ModItems.ONYX, (int) (1), 0).getItem();}
	else if (block == ModBlocks.CORESTONE_AZURITE || block == ModBlocks.INNERCORESTONE_AZURITE || block == ModBlocks.CENTERCORESTONE_AZURITE)
	{return new ItemStack(ModItems.AZURITE, (int) (1), 0).getItem();}
	else if (block == ModBlocks.INNERCORESTONE_COAL || block == ModBlocks.CENTERCORESTONE_COAL)
	{return new ItemStack(Items.COAL, (int) (1), 0).getItem();}
	else if (block == ModBlocks.INNERCORESTONE_REDSTONE || block == ModBlocks.CENTERCORESTONE_REDSTONE)
	{return new ItemStack(Items.REDSTONE, (int) (1), 0).getItem();}
	else if (block == ModBlocks.INNERCORESTONE_SULFUR || block == ModBlocks.CENTERCORESTONE_SULFUR)
	{return new ItemStack(ModItems.SULFUR, 1,0).getItem();}
	else
	{return new ItemStack(block, (int) (1), 0).getItem();}
	}

	@Override
	public int quantityDropped(Random random) {
		Block block = this;

		if ( block == ModBlocks.CORESTONE_REDSTONE)
		{
			return 5 + random.nextInt(3);
		}
			
		else if (block == ModBlocks.INNERCORESTONE_REDSTONE)
		{
			return 6 + random.nextInt(4);
		}
		
		else if (block == ModBlocks.CENTERCORESTONE_REDSTONE)
		{
			return 8 + random.nextInt(6);
		}
		else if (block == ModBlocks.CORESTONE_COAL || block == ModBlocks.CORESTONE_SULFUR)
		{
			return 2;
		}
		else if (block == ModBlocks.INNERCORESTONE_COAL || block == ModBlocks.INNERCORESTONE_SULFUR)
		{
			return 3;
		}
		else if (block == ModBlocks.CENTERCORESTONE_COAL || block == ModBlocks.CENTERCORESTONE_SULFUR)
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
			if (block == ModBlocks.CORESTONE_COAL || block == ModBlocks.INNERCORESTONE_COAL || block == ModBlocks.CENTERCORESTONE_COAL ||
				block == ModBlocks.CORESTONE_REDSTONE || block == ModBlocks.INNERCORESTONE_REDSTONE || block == ModBlocks.CENTERCORESTONE_REDSTONE ||
				block == ModBlocks.CORESTONE_EMERALD || block == ModBlocks.INNERCORESTONE_EMERALD || block == ModBlocks.CENTERCORESTONE_EMERALD ||
					block == ModBlocks.CORESTONE_SULFUR || block == ModBlocks.INNERCORESTONE_SULFUR || block == ModBlocks.CENTERCORESTONE_SULFUR)
		{
			world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
		}
		else if (block == ModBlocks.CORESTONE_SAPPHIRE || block == ModBlocks.INNERCORESTONE_SAPPHIRE || block == ModBlocks.CENTERCORESTONE_SAPPHIRE)
		{
			for (int i = 0; i < 5; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.CORESTONE_FLAMING_TOPAZ || block == ModBlocks.INNERCORESTONE_FLAMING_TOPAZ || block == ModBlocks.CENTERCORESTONE_FLAMING_TOPAZ)
		{
			for (int i = 0; i < 6; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.CORESTONE_RUBY || block == ModBlocks.INNERCORESTONE_RUBY || block == ModBlocks.CENTERCORESTONE_RUBY)
		{
			for (int i = 0; i < 8; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.CORESTONE_TOPAZ || block == ModBlocks.INNERCORESTONE_TOPAZ || block == ModBlocks.CENTERCORESTONE_TOPAZ)
		{
			for (int i = 0; i < 9; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.CORESTONE_DIAMOND || block == ModBlocks.INNERCORESTONE_DIAMOND || block == ModBlocks.CENTERCORESTONE_DIAMOND)
		{
			for (int i = 0; i < 12; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.CORESTONE_JADE || block == ModBlocks.INNERCORESTONE_JADE || block == ModBlocks.CENTERCORESTONE_JADE)
		{
			for (int i = 0; i < 15; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.CORESTONE_AMAZONITE || block == ModBlocks.INNERCORESTONE_AMAZONITE || block == ModBlocks.CENTERCORESTONE_AMAZONITE)
		{
			for (int i = 0; i < 20; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.CORESTONE_AMETHYST || block == ModBlocks.INNERCORESTONE_AMETHYST || block == ModBlocks.CENTERCORESTONE_AMETHYST)
		{
			for (int i = 0; i < 4; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 4));
			}
			for (int i = 0; i < 9; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.CORESTONE_ONYX || block == ModBlocks.INNERCORESTONE_ONYX || block == ModBlocks.CENTERCORESTONE_ONYX )
		{
			for (int i = 0; i < 6; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 4));
			}
			for (int i = 0; i < 13; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		else if (block == ModBlocks.CORESTONE_AZURITE || block == ModBlocks.INNERCORESTONE_AZURITE || block == ModBlocks.CENTERCORESTONE_AZURITE)
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


