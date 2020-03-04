package com.PlanetCore.init;


import java.util.HashSet;
import java.util.List;
import java.util.Random;

import com.PlanetCore.blocks.Corerock;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumBlockRenderType;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraftforge.fluids.BlockFluidClassic;
import net.minecraftforge.fluids.Fluid;


public class CoreLavaFluid extends BlockFluidClassic {

	public CoreLavaFluid(String name, Fluid fluid, Material material) {
		super(fluid, material);
		setTranslationKey(name);
		setRegistryName(name);

		setLightLevel(1);
		setDensity(400);
		setTickRate(20);
		setTickRandomly(true);
		ModBlocks.BLOCKS.add(this);
		ModItems.ITEMS.add(new ItemBlock(this).setRegistryName(name));
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

				if (d9 < wat && !(entity instanceof EntityPlayer)) {
					d5 /= d9;
					d6 /= d9;
					d7 /= d9;
					double d11 = (1.0D - d4);// * d10;
					if (!(entity instanceof EntityPlayerMP) || (entity instanceof EntityPlayerMP
							&& !((EntityPlayerMP) entity).isCreative())) {
						// entity.attackEntityFrom(DamageSource.generic,
						// ((int)((d11 * d11 + d11) / 2.0D * 8.0D *
						// bombStartStrength + 1.0D)));
						//double realisticDamage = 4*(bombStartStrength*bombStartStrength)/entity.getDistance(x, y, z);
						//double damage = entity.getDistance(x, y, z) / bombStartStrength * 250;
//					entity.attackEntityFrom(ModDamageSource.nuclearBlast, (float)damage);
						entity.attackEntityFrom(DamageSource.ON_FIRE, 6);
						entity.setFire(10);
					}
				}
			}
		}

		radius = (int) f;
	}


	public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{

		if (entityIn instanceof EntityPlayerMP)
		{
			//EntityPlayerMP player = (EntityPlayerMP) entityIn;
			//no protection = 10 damage each second (without the normal lava damage)
			//Full Amazonite protect 100%

			//no protection


			entityIn.attackEntityFrom(DamageSource.GENERIC, 8.0F);
		}
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		super.updateTick(worldIn, pos, state, rand);
		int X = pos.getX();
		int Y = pos.getY();
		int Z = pos.getZ();
		burnEntities(worldIn,X,Y,Z, 6);
		for(int x = -2; x < 3; x++) {
			for(int y = -2; y < 3; y++) {
				for(int z = -2; z < 3; z++) {
					IBlockState state2 = worldIn.getBlockState(pos.add(x, y, z));
					Block block = state2.getBlock();
					if(state2.getMaterial()==Material.ROCK && !(block instanceof Corerock) && block!=Blocks.BEDROCK)
					{
						worldIn.setBlockState(pos.add(x, y, z), Blocks.LAVA.getDefaultState());
					}

					if(state2.getMaterial()==Material.GROUND)
					{
						worldIn.setBlockState(pos.add(x, y, z), Blocks.LAVA.getDefaultState());
					}

					if(state2.getMaterial()==Material.GRASS)
					{
						worldIn.setBlockState(pos.add(x, y, z), Blocks.LAVA.getDefaultState());
					}
					if(state2.getMaterial()==Material.WATER)
					{
						worldIn.setBlockToAir(pos.add(x, y, z));
						worldIn.createExplosion(null, X+x, Y+y, Z+z, 10, true);

					}
				}
			}
		}
	}

	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

}
