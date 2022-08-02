package com.PlanetCore.blocks;

import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.util.IMetaName;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Corestone extends BlockBase implements IMetaName {

	private static final float [] coreHardnessByMeta = {180, 230, 280, 385, 500, 625, 1000};
	public static final PropertyEnum<Corestone.EnumType> VARIANT = PropertyEnum.create("variant", Corestone.EnumType.class);

	public Corestone(String name, Material material) {
		super(name, material);

		setSoundType(SoundType.METAL);
		setHarvestLevel("pickaxe", 3);
		setLightLevel(1.0F);
		setTickRandomly(true);

	}

	@Override
	public int damageDropped(IBlockState state) {
		if (this == ModBlocks.CORESTONE) {
			return getMetaFromState(state);
		}
		else return 0;
	}

	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		int meta = getMetaFromState(blockState);
		return coreHardnessByMeta[meta];
	}
	
	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (Corestone.EnumType Corestone$enumtype : Corestone.EnumType.values()) {
			items.add(new ItemStack(this, 1, Corestone$enumtype.getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, Corestone.EnumType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return state.getValue(VARIANT).getMeta();
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this),1, getMetaFromState(world.getBlockState(pos)));
	}


	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, VARIANT);
	}




	public enum EnumType implements IStringSerializable
	{
		CORE(0, "corestone"),
		CORE1(1, "corestone1"),
		CORE2(2, "corestone2"),
		INNERCORE(3, "innercorestone"),
		INNERCORE1(4, "innercorestone1"),
		INNERCORE2(5, "innercorestone2"),
		CENTERCORE(6, "centercorestone");

		private static final Corestone.EnumType[] META_LOOKUP = new Corestone.EnumType[]{CORE, CORE1, CORE2, INNERCORE, INNERCORE1, INNERCORE2, CENTERCORE};
		private final int meta;
		private final String name;

		EnumType(int meta, String name)
		{
			this.meta=meta;
			this.name=name;
		}

		@Override
		public String getName() {
			return this.name;
		}

		public int getMeta()
		{
			return this.meta;
		}

		@Override
		public String toString()
		{
			return this.name;
		}

		public static Corestone.EnumType byMetadata(int meta)
		{
			return META_LOOKUP[meta];
		}

		static {
			for(Corestone.EnumType Corestone$enumtype : values())
			{
				META_LOOKUP[Corestone$enumtype.getMeta()] = Corestone$enumtype;
			}
		}
	}

	@Override
	public String getSpecialName(ItemStack stack)
	{
		return Corestone.EnumType.values()[stack.getItemDamage()].getName();
	}

	@Override
	public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing blockFaceClickedOn, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
		System.out.println(meta);
		return this.getDefaultState().withProperty(VARIANT, Corestone.EnumType.byMetadata(meta));
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
		/*
		if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
		{
				entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 20.0F);
		}

		 */

		super.onEntityWalk(worldIn, pos, entityIn);
	}

	protected static final AxisAlignedBB COLLISION_AABB = new AxisAlignedBB(0.0125D, 0.0D, 0.0125D, 0.9875D, 0.9375D, 0.9875D);

	public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
	{
		return COLLISION_AABB;
	}


	@Override
	public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
		if (entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
		{
			PotionEffect effect = ((EntityLivingBase) entityIn).getActivePotionEffect(MobEffects.FIRE_RESISTANCE);
			float damage = 0;
			if (state.getBlock().getMetaFromState(state) == 0) damage = 4;
			else if (state.getBlock().getMetaFromState(state) == 1) damage = 8;
			else if (state.getBlock().getMetaFromState(state) == 2) damage = 12;
			else if (state.getBlock().getMetaFromState(state) == 3) damage = 16;
			else if (state.getBlock().getMetaFromState(state) == 4) damage = 32;
			else if (state.getBlock().getMetaFromState(state) == 5) damage = 64;
			else if (state.getBlock().getMetaFromState(state) == 6) damage = 128;
			if (effect == null) {
				entityIn.attackEntityFrom(DamageSource.LAVA, damage);
				entityIn.setFire(10);
			}
			else if (effect != null && effect.getAmplifier() == 0) {
				damage = damage / 4;
				if (damage >= 1) entityIn.attackEntityFrom(DamageSource.GENERIC, damage);
			}
			else if (effect != null && effect.getAmplifier() == 1) {
				damage = damage / 16;
				if (damage >= 1) entityIn.attackEntityFrom(DamageSource.GENERIC, damage);
			}
			else if (effect != null && effect.getAmplifier() == 2) {
				damage = damage / 64;
				if (damage >= 1) entityIn.attackEntityFrom(DamageSource.GENERIC, damage);
			}
		}
		//entityIn.attackEntityFrom(DamageSource.CACTUS, 1.0F);
		super.onEntityCollision(worldIn, pos, state, entityIn);
	}

	@SideOnly(Side.CLIENT)
	public int getPackedLightmapCoords(IBlockState state, IBlockAccess source, BlockPos pos)
	{
		return 15728880;
	}




	public void naturalGasExplosion(World worldIn, BlockPos pos, IBlockState state)
	{
		Random rand = new Random();
		int X = pos.getX();
		int Z = pos.getZ();
		int Y = pos.getY();
		if (!worldIn.isRemote && Y < -1600) {
			if (state.getBlock().getMetaFromState(state) == 0) {
				if (rand.nextInt(240) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 4, true);
				}
			}
			if (state.getBlock().getMetaFromState(state) == 1) {
				if (rand.nextInt(260) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 5, true);
				}
			}
			if (state.getBlock().getMetaFromState(state) == 2) {
				if (rand.nextInt(280) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 6, true);
				}
			}
			if (state.getBlock().getMetaFromState(state) == 3) {
				if (rand.nextInt(300) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 7, true);
				}
			}
			if (state.getBlock().getMetaFromState(state) == 4) {
				if (rand.nextInt(320) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 8, true);
				}
			}
			if (state.getBlock().getMetaFromState(state) == 5) {
				if (rand.nextInt(340) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 9, true);
				}
			}
			if (state.getBlock().getMetaFromState(state) == 6) {
				if (rand.nextInt(360) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 10, true);
				}
			}
		}
	}


	@Override
	public void onPlayerDestroy(World worldIn, BlockPos pos, IBlockState state) {
		super.onPlayerDestroy(worldIn, pos, state);
		naturalGasExplosion(worldIn, pos, state);
	}


	public boolean canEntitySpawn(IBlockState state, Entity entityIn)
	{
		return entityIn.isImmuneToFire();
	}

}




	

