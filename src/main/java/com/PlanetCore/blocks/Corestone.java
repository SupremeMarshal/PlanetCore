package com.PlanetCore.blocks;

import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
import com.PlanetCore.init.blocks.item.ItemBlockVariants;
import com.PlanetCore.util.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.*;
import net.minecraft.util.math.*;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class Corestone extends BlockBase implements IMetaName {

	public static final PropertyEnum<Corestone.EnumType> VARIANT = PropertyEnum.create("variant", Corestone.EnumType.class);

	public Corestone(String name, Material material) {
		super(name, material);

		setSoundType(SoundType.METAL);
		setHardness(100.0F);
		setResistance(2.0F);
		setHarvestLevel("pickaxe", 3);
		setLightLevel(1.0F);
		setTickRandomly(true);

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
		INNERCORE(1, "innercorestone"),
		CENTERCORE(2, "centercorestone");

		private static final Corestone.EnumType[] META_LOOKUP = new Corestone.EnumType[]{CORE,INNERCORE,CENTERCORE};
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
		Block block = this;
		if (!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
		{
			if (block == ModBlocks.CORESTONE)
			{
				entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 20.0F);
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
		if((worldIn.isRaining() && this == ModBlocks.CORESTONE)) {

			worldIn.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, X, Y+1, Z, 0, 0, 0);
		}
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
		BlockPos blockpos = pos.up();
		IBlockState iblockstate = worldIn.getBlockState(blockpos);

		if (iblockstate.getBlock() == Blocks.WATER || iblockstate.getBlock() == Blocks.FLOWING_WATER)
		{
			worldIn.setBlockToAir(blockpos);
			worldIn.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);
			if (worldIn instanceof WorldServer)
			{
				((WorldServer)worldIn).spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.25D, (double)blockpos.getZ() + 0.5D, 8, 0.5D, 0.25D, 0.5D, 0.0D);
			}
		}

		
	}

	public void spawnLava(World worldIn, BlockPos pos, IBlockState state)
	{
		Random rand = new Random();
		if (!worldIn.isRemote)
		{
			if (state.getBlock().getMetaFromState(state) == 0)
			{
				if (rand.nextInt(80) == 0) {
					worldIn.setBlockState(pos, ModBlocks.CORE_LAVA_FLUID.getDefaultState());
				}
			}
			if (state.getBlock().getMetaFromState(state) == 1)
			{
				if (rand.nextInt(60) == 0) {
					worldIn.setBlockState(pos, ModBlocks.CORE_LAVA_FLUID.getDefaultState());
				}
			}
			if (state.getBlock().getMetaFromState(state) == 2)
			{
				if (rand.nextInt(40) == 0) {
					worldIn.setBlockState(pos, ModBlocks.CORE_LAVA_FLUID.getDefaultState());
				}
			}
		}
	}

	public void naturalGasExplosion(World worldIn, BlockPos pos, IBlockState state)
	{
		Random rand = new Random();
		int X = pos.getX();
		int Z = pos.getZ();
		int Y = pos.getY();
		if (!worldIn.isRemote) {
			if (state.getBlock().getMetaFromState(state) == 0) {
				if (rand.nextInt(40) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 4, true);
				}
			}
			if (state.getBlock().getMetaFromState(state) == 1) {
				if (rand.nextInt(32) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 4, true);
				}
			}
			if (state.getBlock().getMetaFromState(state) == 2) {
				if (rand.nextInt(25) == 0) {
					worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 4, true);
				}
			}
		}
	}

	@SideOnly(Side.CLIENT)
	@Override
	public void randomDisplayTick(IBlockState stateIn, World worldIn, BlockPos pos, Random rand) {
		worldIn.scheduleUpdate(pos, this, this.tickRate(worldIn));
		particleEffects(stateIn, worldIn, pos, rand);
	}


	@Override
	public void onPlayerDestroy(World worldIn, BlockPos pos, IBlockState state) {
		super.onPlayerDestroy(worldIn, pos, state);
		naturalGasExplosion(worldIn, pos, state);
		spawnLava(worldIn, pos, state);
	}


	public boolean canEntitySpawn(IBlockState state, Entity entityIn)
	{
		return entityIn.isImmuneToFire();
	}

}




	

