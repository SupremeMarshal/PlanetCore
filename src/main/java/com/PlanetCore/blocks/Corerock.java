package com.PlanetCore.blocks;

import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class Corerock extends BlockBase {

	public Corerock(String name, Material material) {
		super(name, material);

		setSoundType(SoundType.METAL);
		setHardness(-1.0F);
		setResistance(20.0F);
		setHarvestLevel("pickaxe", 3);
		setTickRandomly(true);
		setLightLevel(1);

	}


	@Override
	public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer entity, boolean willHarvest) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		Block block = this;
		if (!world.isRemote) {
			for (int i = 0; i < 4; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 1));
			}
		}
		return super.removedByPlayer(state, world, pos, entity, willHarvest);
	}

	@Override
	public Item getItemDropped(IBlockState state, Random random, int l)
	{
		Block block = this;

        if (block == ModBlocks.CORESTONE_AZURITE || block == ModBlocks.INNERCORESTONE_AZURITE || block == ModBlocks.CENTERCORESTONE_AZURITE)
        	{return new ItemStack(ModItems.AZURITE, 1, 0).getItem();}
		else if (block == ModBlocks.CORESTONE_ONYX || block == ModBlocks.INNERCORESTONE_ONYX || block == ModBlocks.CENTERCORESTONE_ONYX)
        	{return new ItemStack(ModItems.ONYX, 1, 0).getItem();}
		else if (block == ModBlocks.CORESTONE_AMETHYST || block == ModBlocks.INNERCORESTONE_AMETHYST || block == ModBlocks.CENTERCORESTONE_AMETHYST)
		{return new ItemStack(ModItems.AMETHYST, 1, 0).getItem();}
		else if (block == ModBlocks.CORESTONE_AMAZONITE || block == ModBlocks.INNERCORESTONE_AMAZONITE || block == ModBlocks.CENTERCORESTONE_AMAZONITE)
		{return new ItemStack(ModItems.AMAZONITE, 1, 0).getItem();}
		else if (block == ModBlocks.CORESTONE_JADE || block == ModBlocks.INNERCORESTONE_JADE || block == ModBlocks.CENTERCORESTONE_JADE)
		{return new ItemStack(ModItems.JADE, 1, 0).getItem();}
		else if (block == ModBlocks.CORESTONE_DIAMOND || block == ModBlocks.INNERCORESTONE_DIAMOND || block == ModBlocks.CENTERCORESTONE_DIAMOND)
		{return new ItemStack(ModItems.DIAMOND, 1, 0).getItem();}
		else if (block == ModBlocks.CORESTONE_TOPAZ || block == ModBlocks.INNERCORESTONE_TOPAZ || block == ModBlocks.CENTERCORESTONE_TOPAZ)
		{return new ItemStack(ModItems.TOPAZ, 1, 0).getItem();}
		else if (block == ModBlocks.CORESTONE_RUBY || block == ModBlocks.INNERCORESTONE_RUBY || block == ModBlocks.CENTERCORESTONE_RUBY)
		{return new ItemStack(ModItems.RUBY, 1, 0).getItem();}
		else if (block == ModBlocks.CORESTONE_SAPPHIRE || block == ModBlocks.INNERCORESTONE_SAPPHIRE || block == ModBlocks.CENTERCORESTONE_SAPPHIRE)
		{return new ItemStack(ModItems.SAPPHIRE, 1, 0).getItem();}
		else if (block == ModBlocks.CORESTONE_EMERALD || block == ModBlocks.INNERCORESTONE_EMERALD || block == ModBlocks.CENTERCORESTONE_EMERALD)
		{return new ItemStack(Items.EMERALD, 1, 0).getItem();}
		else if (block == ModBlocks.CORESTONE_LAPIS || block == ModBlocks.INNERCORESTONE_LAPIS || block == ModBlocks.CENTERCORESTONE_LAPIS)
		{return Items.DYE;}
		else if (block == ModBlocks.CORESTONE_REDSTONE || block == ModBlocks.INNERCORESTONE_REDSTONE || block == ModBlocks.CENTERCORESTONE_REDSTONE)
		{return new ItemStack(Items.REDSTONE, 1, 0).getItem();}
		else if (block == ModBlocks.CORESTONE_COAL || block == ModBlocks.INNERCORESTONE_COAL || block == ModBlocks.CENTERCORESTONE_COAL)
		{return new ItemStack(Items.COAL, 1, 0).getItem();}
		else if (block == ModBlocks.CORESTONE_SULFUR || block == ModBlocks.INNERCORESTONE_SULFUR || block == ModBlocks.CENTERCORESTONE_SULFUR)
		{return new ItemStack(ModItems.SULFUR, 1, 0).getItem();}
		else
		{return new ItemStack(block, 1, 0).getItem();}
	}

	@Override
	public int quantityDropped(Random random) {
		Block block = this;

		if (block == ModBlocks.CORESTONE_REDSTONE)
		{
			return 12 + random.nextInt(10);
		}
		else if (block == ModBlocks.INNERCORESTONE_REDSTONE)
		{
			return 15 + random.nextInt(12);
		}
		else if (block == ModBlocks.CENTERCORESTONE_REDSTONE)
		{
			return 18 + random.nextInt(14);
		}
		else if (block == ModBlocks.CORESTONE_COAL || block == ModBlocks.CORESTONE_SULFUR)
		{
			return 5;
		}
		else if (block == ModBlocks.INNERCORESTONE_COAL || block == ModBlocks.INNERCORESTONE_SULFUR)
		{
			return 7;
		}
		else if (block == ModBlocks.CENTERCORESTONE_COAL || block == ModBlocks.CENTERCORESTONE_SULFUR)
		{
			return 9;
		}
		else
		{
			return 1;
		}

	}

	@Override
	public int damageDropped(IBlockState state) {
		Block block = this;
		if (block == ModBlocks.CORESTONE_LAPIS || block == ModBlocks.INNERCORESTONE_LAPIS || block == ModBlocks.CENTERCORESTONE_LAPIS) {
			return 4;
		}
		else
		{
			return getMetaFromState(state);
		}
	}





	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn)
	{
		Block block = this;
		if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
		{
			if (block == ModBlocks.CORESTONE)
			{
				entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 20.0F);
			}
			else if (block == ModBlocks.INNERCORESTONE)
			{
				entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 40.0F);
			}
			else if (block == ModBlocks.CENTERCORESTONE)
			{
				entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 80.0F);
			}
		}

		super.onEntityWalk(worldIn, pos, entityIn);
	}

	@SideOnly(Side.CLIENT)
	public int getPackedLightmapCoords(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return 15728880;
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		BlockPos blockpos = pos.up();
		IBlockState iblockstate = worldIn.getBlockState(blockpos);

		if (iblockstate.getBlock() == Blocks.WATER || iblockstate.getBlock() == Blocks.FLOWING_WATER)
		{
			worldIn.setBlockToAir(blockpos);
			worldIn.playSound((EntityPlayer)null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);

			if (worldIn instanceof WorldServer)
			{
				((WorldServer)worldIn).spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.25D, (double)blockpos.getZ() + 0.5D, 8, 0.5D, 0.25D, 0.5D, 0.0D);
			}
		}
	}

	public boolean canEntitySpawn(IBlockState state, Entity entityIn)
	{
		return entityIn.isImmuneToFire();
	}

}
	

