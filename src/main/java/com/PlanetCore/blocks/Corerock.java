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
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Corerock extends BlockBase {

	public Corerock(String name, Material material) {
		super(name, material);

		setSoundType(SoundType.METAL);
		setHardness(-1.0F);
		setResistance(100.0F);
		setHarvestLevel("pickaxe", 3);
		setLightLevel(1.0F);
		setTickRandomly(true);

	}


	@Override
	public boolean removedByPlayer(IBlockState state, World world, BlockPos pos, EntityPlayer entity, boolean willHarvest) {
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		Block block = this;
		if (!world.isRemote) {
			for (int i = 0; i < 4; i++) {
				world.spawnEntity(new EntityXPOrb(world, x, y, z, 1));
			}
		}
		return super.removedByPlayer(state, world, pos, entity, willHarvest);
	}
}

	/*@Override
	public Item getItemDropped(IBlockState state, Random random, int l)
	{
		Block block = this;

		if (block == ModBlocks.CORESTONE_ONYX || block == ModBlocks.INNERCORESTONE_ONYX || block == ModBlocks.CENTERCORESTONE_ONYX)
		{return new ItemStack(ModItems.ONYX, 1, 0).getItem();}
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



	public static void burnEntities(World world, int x, int y, int z, int radius) {
		float f = radius;
		HashSet hashset = new HashSet();
		int i;
		int j;
		int k;
		double d5;
		double d6;
		double d7;
		double wat = radius/** 2 */
				;
				/*
		boolean isOccupied = false;

		// bombStartStrength *= 2.0F;
		i = MathHelper.floor(x - wat - 1.0D);
		j = MathHelper.floor(x + wat + 1.0D);
		k = MathHelper.floor(y - wat - 1.0D);
		int i2 = MathHelper.floor(y + wat + 1.0D);
		int l = MathHelper.floor(z - wat - 1.0D);
		int j2 = MathHelper.floor(z + wat + 1.0D);
		AxisAlignedBB bb = new AxisAlignedBB(i,k,l,j,i2,j2);
		List list = world.getEntitiesWithinAABBExcludingEntity(null, bb);
		Vec3d vec3 = new Vec3d(x, y, z);

		for (int i1 = 0; i1 < list.size(); ++i1) {
			Entity entity = (Entity) list.get(i1);
			double d4 = entity.getDistance(x, y, z) / radius;

			if (d4 <= 1.0D) {
				d5 = entity.posX - x;
				d6 = entity.posY + entity.getEyeHeight() - y;
				d7 = entity.posZ - z;
				BlockPos pos1 = new BlockPos(x,y,z);
				BlockPos pos2 = new BlockPos(entity.posX,entity.posY + entity.getEyeHeight(),entity.posZ);
				double d9 = MathHelper.sqrt(d5 * d5 + d6 * d6 + d7 * d7);

				if (d9 < wat) {
					d5 /= d9;
					d6 /= d9;
					d7 /= d9;
					double d11 = (1.0D - d4);// * d10;
					if (!(entity instanceof EntityPlayerMP) || (entity instanceof EntityPlayerMP
							&& !((EntityPlayerMP) entity).isCreative())) {
						entity.attackEntityFrom(DamageSource.ON_FIRE, 6);
						entity.setFire(10);
					}
				}
			}
		}
		radius = (int) f;
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

	private void particleEffects(IBlockState stateIn, World worldIn, BlockPos pos, Random rand)
	{
		int X = pos.getX();
		int Y = pos.getY();
		int Z = pos.getZ();
		if((worldIn.isRaining() && this == ModBlocks.CORESTONE) || (worldIn.isRaining() && this == ModBlocks.MAGMA_CORESTONE)) {

			worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, X, Y+1, Z, 0, 0, 0);
		}
	}

	public void thermalEffects(World worldIn, BlockPos pos, IBlockState state)
	{
		int X = pos.getX();
		int Y = pos.getY();
		int Z = pos.getZ();
		Random rand = new Random();
		burnEntities(worldIn,X,Y,Z, 8);

		if (this != ModBlocks.COLD_CORESTONE)
		{
			for(int x = -2; x < 3; x++) {
				for(int y = -2; y < 3; y++) {
					for(int z = -2; z < 3; z++) {
						IBlockState state2 = worldIn.getBlockState(pos.add(x, y, z));
						Block block = state2.getBlock();
						if(state2.getMaterial()==Material.ROCK || state2.getMaterial()==Material.GROUND || state2.getMaterial()==Material.GRASS
								&& !(block instanceof Corerock) && block!=Blocks.BEDROCK && block!=ModBlocks.COLD_CORESTONE)
						{
							worldIn.setBlockState(new BlockPos(x, y, z),Blocks.LAVA.getDefaultState());
						}
						if(state2.getMaterial()==Material.SNOW)
						{
							worldIn.setBlockToAir(new BlockPos(x, y, z));
						}
						if(state2.getMaterial()==Material.WATER || state2.getMaterial()==Material.ICE || state2.getMaterial()==Material.CRAFTED_SNOW)
						{

							if (this == ModBlocks.CORESTONE)
							{
								worldIn.setBlockState(new BlockPos(x, y, z), ModBlocks.MAGMA_CORESTONE.getDefaultState());
								worldIn.createExplosion(null, X+x, Y+y, Z+z, 8, false);
							}
							if (this == ModBlocks.MAGMA_CORESTONE)
							{
								worldIn.setBlockState(new BlockPos(x, y, z), ModBlocks.COLD_CORESTONE.getDefaultState());
								worldIn.createExplosion(null, X+x, Y+y, Z+z, 4, false);
							}
							worldIn.setBlockToAir(pos.add(x, y, z));
						}
						if(state2.getBlock().getFlammability(worldIn, pos, null)>0 || state2.getMaterial()==Material.WOOD || state2.getMaterial()==Material.CLOTH || state2.getMaterial()==Material.PLANTS || state2.getMaterial()==Material.LEAVES)
						{
							worldIn.setBlockState(pos.add(x, y, z), Blocks.FIRE.getDefaultState());
						}
						if(pos.getY()>=-17920 && pos.getY()<=-12700)
						{
							if(rand.nextInt(6000) == 0)
							{
								return;
							}
							worldIn.setBlockState(pos, ModBlocks.CORE_LAVA_FLUID.getDefaultState());
						}
						else if(pos.getY()>-12675 && pos.getY()<=-1000)
						{
							if(rand.nextInt(6000) == 0)
							{
								return;
							}
							if (this == ModBlocks.CENTERCORESTONE){
								worldIn.setBlockState(pos, ModBlocks.INNERCORESTONE.getDefaultState());
							}

							else if (this == ModBlocks.INNERCORESTONE){
								worldIn.setBlockState(pos, ModBlocks.CORESTONE.getDefaultState());
							}
						}
						else if(worldIn.canBlockSeeSky(pos) == true && worldIn.isRaining() == false)
						{
							if(rand.nextInt(1200) == 0)
							{
								if (this == ModBlocks.CENTERCORESTONE)
									worldIn.setBlockState(pos, ModBlocks.CORESTONE.getDefaultState());
								else if (this == ModBlocks.INNERCORESTONE)
									worldIn.setBlockState(pos, ModBlocks.CORESTONE.getDefaultState());
								else if (this == ModBlocks.CORESTONE)
									worldIn.setBlockState(pos, ModBlocks.MAGMA_CORESTONE.getDefaultState());
								else worldIn.setBlockState(pos, ModBlocks.COLD_CORESTONE.getDefaultState());
							}
						}
						else if(worldIn.canBlockSeeSky(pos) == false)
						{
							if(rand.nextInt(2400) == 0)
							{
								if (this == ModBlocks.CENTERCORESTONE)
									worldIn.setBlockState(pos, ModBlocks.CORESTONE.getDefaultState());
								else if (this == ModBlocks.INNERCORESTONE)
									worldIn.setBlockState(pos, ModBlocks.CORESTONE.getDefaultState());
								else if (this == ModBlocks.CORESTONE)
									worldIn.setBlockState(pos, ModBlocks.MAGMA_CORESTONE.getDefaultState());
								else worldIn.setBlockState(pos, ModBlocks.COLD_CORESTONE.getDefaultState());
							}
						}
						else if(worldIn.canBlockSeeSky(pos) == true && worldIn.isRaining() == true)
						{
							if(rand.nextInt(200) == 0)
							{
								if (this == ModBlocks.CENTERCORESTONE)
									worldIn.setBlockState(pos, ModBlocks.CORESTONE.getDefaultState());
								else if (this == ModBlocks.INNERCORESTONE)
									worldIn.setBlockState(pos, ModBlocks.CORESTONE.getDefaultState());
								else if (this == ModBlocks.CORESTONE)
									worldIn.setBlockState(pos, ModBlocks.MAGMA_CORESTONE.getDefaultState());
								else worldIn.setBlockState(pos, ModBlocks.COLD_CORESTONE.getDefaultState());
							}
						}
					}
				}
			}
		}

	}
	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{
		thermalEffects(worldIn, pos, state);
	}

	@Override
	public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
	{
		super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
		//thermalEffects(worldIn, pos, state);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		thermalEffects(worldIn, pos, state);
		/*BlockPos blockpos = pos.up();
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
	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
		particleEffects(stateIn, worldIn, pos, rand);
	}



	public boolean canEntitySpawn(IBlockState state, Entity entityIn)
	{
		return entityIn.isImmuneToFire();
	}

}

				 */


	

