package com.PlanetCore.init;


import com.PlanetCore.blocks.Corerock;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.EntityEquipmentSlot;
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

import java.util.HashSet;
import java.util.List;
import java.util.Random;


public class OnyxLavaFluid extends BlockFluidClassic {

	public OnyxLavaFluid(String name, Fluid fluid, Material material) {
		super(fluid, material);
		setTranslationKey(name);
		setRegistryName(name);

		setLightLevel(1);
		setDensity(400);
		setTickRate(20);
		setTickRandomly(true);
		ModBlocks.BLOCKS.add(this);
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
						entity.attackEntityFrom(DamageSource.ON_FIRE, 12);
						entity.setFire(20);
					}
				}
			}
		}

		radius = (int) f;
	}


	public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn)
	{

		if (entityIn instanceof EntityPlayerMP && ((EntityPlayerMP) entityIn).getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ModItems.ONYX_HELMET
				&& ((EntityPlayerMP) entityIn).getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ModItems.ONYX_CHESTPLATE
				&& ((EntityPlayerMP) entityIn).getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ModItems.ONYX_LEGGINGS
				&& ((EntityPlayerMP) entityIn).getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ModItems.ONYX_BOOTS)
		{
			entityIn.attackEntityFrom(DamageSource.GENERIC, 20.0F);
		}
		else
		{
			entityIn.attackEntityFrom(DamageSource.GENERIC, 999.0F);
		}
	}


	@Override
	public EnumBlockRenderType getRenderType(IBlockState state) {
		return EnumBlockRenderType.MODEL;
	}

}
