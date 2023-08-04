package com.PlanetCore.blocks;


import com.PlanetCore.init.ModBlocks;
import com.google.common.base.Predicate;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.BlockWorldState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.block.state.pattern.BlockMaterialMatcher;
import net.minecraft.block.state.pattern.BlockPattern;
import net.minecraft.block.state.pattern.BlockStateMatcher;
import net.minecraft.block.state.pattern.FactoryBlockPattern;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Random;


public class BlockBase extends Block {
	private BlockPattern snowmanPattern;
	private BlockPattern golemBasePattern;
	private BlockPattern golemPattern;
	private static final Predicate<IBlockState> IS_PUMPKIN = new Predicate<IBlockState>() {
		public boolean apply(@Nullable IBlockState p_apply_1_) {
			return p_apply_1_ != null && (p_apply_1_.getBlock() == Blocks.PUMPKIN || p_apply_1_.getBlock() == Blocks.LIT_PUMPKIN);
		}
	};

	public BlockBase(String name, Material material) {
		super(material);

		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
		ModBlocks.BLOCKS.add(this);
		setSoundType(SoundType.METAL);
	}

	/**
	 * Previous hardness's value + (3*Meta)
	 * public static int recursive(int in) {
	 *    return (in != 0) ? (recursive(in-1) + 3 * in) : 3;
	 * }
	 */

	@Override
	public int quantityDropped(Random random) {
		return 1;
	}


	/**
	 * cause the terrain to close on itself, creating a pressure effect inside the planet.
	 * @param worldIn
	 * @param pos
	 * @param state
	 * @param rand
	 */

		@Override
		public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
			if ((this == ModBlocks.MANTLEROCK || this == ModBlocks.CRUSTROCK || this == ModBlocks.CORESTONE) && pos.getY() < 0) {


				/**
				 * The pressure effect occur more and more exponentially. Every 1024 Y level, the pressure effect's growth by Y level is doubled.
				 * At -6500Y, the chance is at 37% making the pressure happen extremely frequently.
				 * Goodluck mining at these levels.
				 */
				if (pos.getY() < 0 && Math.random() >= pos.getY() * -0.0000025) {
					return;
				}
				for (EnumFacing side : EnumFacing.values()) {
					BlockPos movedPos = pos.offset(side);
					IBlockState movedState = worldIn.getBlockState(movedPos);
					if (movedState.getMaterial() == Material.IRON || movedState.getBlock() == ModBlocks.AIR_NO_PRESSURE) return;
					if (movedState == Blocks.AIR.getDefaultState()) {
						continue;
					}
					EnumFacing[] sides = Arrays.stream(EnumFacing.VALUES)
							.filter(s -> !movedPos.offset(s).equals(pos) && (worldIn.isAirBlock(movedPos.offset(s))
									|| worldIn.getBlockState(movedPos.offset(s)).getBlock() instanceof BlockLadder
									|| worldIn.getBlockState(movedPos.offset(s)).getMaterial() == Material.WATER
									|| worldIn.getBlockState(movedPos.offset(s)).getBlock() instanceof BlockTorch
									|| worldIn.getBlockState(movedPos.offset(s)).getBlock() instanceof BlockBanner
									|| worldIn.getBlockState(movedPos.offset(s)).getBlock() instanceof BlockBasePressurePlate
									|| worldIn.getBlockState(movedPos.offset(s)).getBlock() instanceof BlockBrewingStand
									|| worldIn.getBlockState(movedPos.offset(s)).getBlock() instanceof BlockBed
									|| worldIn.getBlockState(movedPos.offset(s)).getBlock() instanceof BlockBush
									|| worldIn.getBlockState(movedPos.offset(s)).getBlock() instanceof BlockButton
									|| worldIn.getBlockState(movedPos.offset(s)).getBlock() instanceof BlockCactus
									|| worldIn.getBlockState(movedPos.offset(s)).getBlock() instanceof BlockDirt
									|| worldIn.getBlockState(movedPos.offset(s)).getBlock() instanceof BlockCake
									|| worldIn.getBlockState(movedPos.offset(s)).getBlock() instanceof BlockCarpet
									|| worldIn.getBlockState(movedPos.offset(s)).getBlock() instanceof BlockCarrot
									|| worldIn.getBlockState(movedPos.offset(s)).getBlock() instanceof BlockCrops))
							.toArray(EnumFacing[]::new);
					if (sides.length == 0) {
						continue;
					}
					worldIn.setBlockState(movedPos.offset(sides[rand.nextInt(sides.length)]), movedState);
					worldIn.setBlockState(movedPos, worldIn.getBlockState(pos));
					return;
				}
			}
		}


	public boolean isBeaconBase(IBlockAccess worldObj, BlockPos pos, BlockPos beacon)
	{
		return this == ModBlocks.IRON_BLOCK || this == ModBlocks.SILVER_BLOCK || this ==  ModBlocks.GOLD_BLOCK
				|| this == ModBlocks.SAPPHIRE_BLOCK || this == ModBlocks.RUBY_BLOCK
				|| this == ModBlocks.DIAMOND_BLOCK || this == ModBlocks.MAJORITE_BLOCK || this == ModBlocks.AMAZONITE_BLOCK || this == ModBlocks.ONYX_BLOCK;
	}

	private void add(BlockPos pos, IBlockState state) {
		
	}

	@Override
	public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state)
	{
		Block block = this;
		if (block == ModBlocks.IRON_BLOCK) {
			super.onBlockAdded(worldIn, pos, state);
			this.trySpawnGolem(worldIn, pos);
		}
	}


	private void trySpawnGolem(World worldIn, BlockPos pos)
	{
		BlockPattern.PatternHelper blockpattern$patternhelper = this.getSnowmanPattern().match(worldIn, pos);

		if (blockpattern$patternhelper == null)
		{

			blockpattern$patternhelper = this.getGolemPattern().match(worldIn, pos);

			if (blockpattern$patternhelper != null)
			{
				for (int j = 0; j < this.getGolemPattern().getPalmLength(); ++j)
				{
					for (int k = 0; k < this.getGolemPattern().getThumbLength(); ++k)
					{
						worldIn.setBlockState(blockpattern$patternhelper.translateOffset(j, k, 0).getPos(), Blocks.AIR.getDefaultState(), 2);
					}
				}

				BlockPos blockpos = blockpattern$patternhelper.translateOffset(1, 2, 0).getPos();
				EntityIronGolem entityirongolem = new EntityIronGolem(worldIn);
				entityirongolem.setPlayerCreated(true);
				entityirongolem.setLocationAndAngles((double)blockpos.getX() + 0.5D, (double)blockpos.getY() + 0.05D, (double)blockpos.getZ() + 0.5D, 0.0F, 0.0F);
				worldIn.spawnEntity(entityirongolem);

				for (EntityPlayerMP entityplayermp1 : worldIn.getEntitiesWithinAABB(EntityPlayerMP.class, entityirongolem.getEntityBoundingBox().grow(5.0D)))
				{
					CriteriaTriggers.SUMMONED_ENTITY.trigger(entityplayermp1, entityirongolem);
				}

				for (int j1 = 0; j1 < 120; ++j1)
				{
					worldIn.spawnParticle(EnumParticleTypes.SNOWBALL, (double)blockpos.getX() + worldIn.rand.nextDouble(), (double)blockpos.getY() + worldIn.rand.nextDouble() * 3.9D, (double)blockpos.getZ() + worldIn.rand.nextDouble(), 0.0D, 0.0D, 0.0D);
				}

				for (int k1 = 0; k1 < this.getGolemPattern().getPalmLength(); ++k1)
				{
					for (int l1 = 0; l1 < this.getGolemPattern().getThumbLength(); ++l1)
					{
						BlockWorldState blockworldstate1 = blockpattern$patternhelper.translateOffset(k1, l1, 0);
						worldIn.notifyNeighborsRespectDebug(blockworldstate1.getPos(), Blocks.AIR, false);
					}
				}
			}
		}
	}

	protected BlockPattern getSnowmanPattern()
	{
		if (this.snowmanPattern == null)
		{
			this.snowmanPattern = FactoryBlockPattern.start().aisle("^", "#", "#").where('^', BlockWorldState.hasState(IS_PUMPKIN)).where('#', BlockWorldState.hasState(BlockStateMatcher.forBlock(Blocks.SNOW))).build();
		}

		return this.snowmanPattern;
	}


	protected BlockPattern getGolemBasePattern()
	{
		if (this.golemBasePattern == null)
		{
			this.golemBasePattern = FactoryBlockPattern.start().aisle("~ ~", "###", "~#~").where('#', BlockWorldState.hasState(BlockStateMatcher.forBlock(ModBlocks.IRON_BLOCK))).where('~', BlockWorldState.hasState(BlockMaterialMatcher.forMaterial(Material.AIR))).build();
		}

		return this.golemBasePattern;
	}


	protected BlockPattern getGolemPattern()
	{
		if (this.golemPattern == null)
		{
			this.golemPattern = FactoryBlockPattern.start().aisle("~^~", "###", "~#~").where('^', BlockWorldState.hasState(IS_PUMPKIN)).where('#', BlockWorldState.hasState(BlockStateMatcher.forBlock(ModBlocks.IRON_BLOCK))).where('~', BlockWorldState.hasState(BlockMaterialMatcher.forMaterial(Material.AIR))).build();
		}

		return this.golemPattern;
	}

}
