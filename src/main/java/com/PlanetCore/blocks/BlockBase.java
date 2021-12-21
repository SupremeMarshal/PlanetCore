package com.PlanetCore.blocks;


import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
import com.google.common.base.Predicate;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
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
import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.entity.monster.EntityIronGolem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.Explosion;
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

	@Override
	public void onEntityWalk(World worldIn, BlockPos pos, Entity entityIn) {
		ResourceLocation a = this.getRegistryName();
		IBlockState b = worldIn.getBlockState(pos);
		if (a.toString().contains("mantlerock") &&
				b.getBlock().getMetaFromState(b) >= 7 &&
				!entityIn.isImmuneToFire() && entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn)) {
			entityIn.attackEntityFrom(DamageSource.HOT_FLOOR, 0.25F * b.getBlock().getMetaFromState(b) - 1.50F);
		}
		super.onEntityWalk(worldIn, pos, entityIn);
	}

	/**
	 * Previous hardness's value + (3*Meta)
	 * public static int recursive(int in) {
	 *    return (in != 0) ? (recursive(in-1) + 3 * in) : 3;
	 * }
	 */
	private static final float [] crustHardnessByMeta = {3, 6, 9};
	private static final float [] mantleHardnessByMeta = {12, 21, 36, 71, 100, 150, 200, 250, 300, 400, 500, 600, 700, 800, 900, 1000};
	private static final float [] coreHardnessByMeta = {2500, 5000, 10000};

	@Override
	public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
		String a = this.getTranslationKey();
		int meta = getMetaFromState(blockState);
		float hardness = super.getBlockHardness(blockState, worldIn, pos);
		if (a.contains("ore")) hardness = hardness + 1.5F;
		if (a.contains("crustrock")) hardness = hardness + crustHardnessByMeta[meta];
		if (a.contains("mantlerock")) hardness = hardness + mantleHardnessByMeta[meta];
		if (a.contains("corestone")) hardness = hardness + coreHardnessByMeta[meta];
		return hardness;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random random, int l) {
		String a = this.getTranslationKey();
		Boolean c;
		Item drop = null;
		if (a.contains("redstone")) { c = true;  drop = Items.REDSTONE; }
		else if (a.contains("lapis")) { c = true; drop = Items.DYE; }
		//else if (a.contains("sulfur")) { c = true; drop = ModItems.SULFUR; }
		else if (a.contains("coal")) { c = true; drop = Items.COAL; }
		//else if (a.contains("aluminium")) { c = true; drop = ModItems.ALUMINIUM_ORE; }
		else if (a.contains("platinum")) { c = true; drop = ModItems.PLATINUM_ORE; }
		else if (a.contains("copper")) { c = true; drop = ModItems.COPPER_ORE; }
		else if (a.contains("iron")) { c = true; drop = ModItems.IRON_ORE; }
		else if (a.contains("silver")) { c = true; drop = ModItems.SILVER_ORE; }
		else if (a.contains("gold")) { c = true; drop = ModItems.GOLD_ORE; }
		else if (a.contains("tin")) { c = true; drop = ModItems.TIN_ORE; }
		//else if (a.contains("titanium")) { c = true; drop = ModItems.TITANIUM_ORE; }
		//else if (a.contains("uranium")) { c = true; drop = ModItems.URANIUM_ORE; }
		//else if (a.contains("tungsten")) { c = true; drop = ModItems.TUNGSTEN_ORE; }
		else if (a.contains("emerald")) { c = true; drop = ModItems.EMERALD; }
		else if (a.contains("sapphire")) { c = true; drop = ModItems.SAPPHIRE; }
		else if (a.contains("ruby")) { c = true; drop = ModItems.RUBY; }
		else if (a.contains("diamond")) { c = true; drop = ModItems.DIAMOND; }
		/*
		else if (a.contains("olivine")) { c = true; drop = ModItems.OLIVINE; }
		else if (a.contains("wadsleyite")) { c = true; drop = ModItems.WADSLEYITE; }
		else if (a.contains("ringwoodite")) { c = true; drop = ModItems.RINGWOODITE; }
		else if (a.contains("brigmanite")) { c = true; drop = ModItems.BRIGMANITE; }
		else if (a.contains("amazonite")) { c = true; drop = ModItems.AMAZONITE; }
		else if (a.contains("majorite")) { c = true; drop = ModItems.MAJORITE; }

		 */
		else if (a.contains("onyx")) { c = true; drop = ModItems.ONYX; }
		else { c = false;  }

		if (!c) { return Item.getItemFromBlock(this); }
		else { return new ItemStack(drop, 1, 0).getItem(); }
	}


	@Override
	public int damageDropped(IBlockState state) {
		String a = this.getTranslationKey();
		if (a.contains("lapis")) {
			return EnumDyeColor.BLUE.getDyeDamage();
		}
		else if (this == ModBlocks.CRUSTROCK || a.contains("lapis") || a.contains("redstone") || a.contains("sulfur") || a.contains("coal") || a.contains("aluminium") 
				|| a.contains("tin") || a.contains("copper") || a.contains("iron")
				|| a.contains("silver") || a.contains("gold") || a.contains("platinum") || a.contains("titanium") || a.contains("uranium") || a.contains("tungsten")
				|| a.contains("emerald") || a.contains("sapphire") || a.contains("ruby") || a.contains("topaz")
				|| a.contains("jade") || a.contains("diamond") || a.contains("olivine") || a.contains("wadsleyite")
				|| a.contains("ringwoodite") || a.contains("brigmanite") || a.contains("amazonite") || a.contains("majorite") || a.contains("onyx")) {
			return 0;
		}
		else return this.getMetaFromState(state);
	}

	@Override
	public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
		String a = this.getTranslationKey();
		Random rand = world instanceof World ? ((World)world).rand : new Random();
		if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
			int i = 0;
			if (a.contains("sulfur") || a.contains("coal")) {
				i = MathHelper.getInt(rand, 0, 2);
			} else if (a.contains("lapis")) {
				i = MathHelper.getInt(rand, 1, 3);
			} else if (a.contains("topaz") || a.contains("jade") || a.contains("emerald")) {
				i = MathHelper.getInt(rand, 2, 4);
			} else if (a.contains("ruby") || a.contains("sapphire") || a.contains("diamond")) {
				i = MathHelper.getInt(rand, 3, 7);
			} else if (a.contains("olivine") || a.contains("wadsleyite") || a.contains("ringwoodite") || a.contains("brigmanite")) {
				i = MathHelper.getInt(rand, 5, 9);
			} else if (a.contains("majorite") || a.contains("amazonite") || a.contains("onyx")) {
				i = MathHelper.getInt(rand, 7, 12);
			}

			return i;
		} else {
			return 0;
		}
	}


	@Override
	public int quantityDropped(Random random) {
		String a = this.getTranslationKey();
		return 1;
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		String a = this.getTranslationKey();
		if (a.contains("sulfur") || a.contains("coal") || a.contains("aluminium")
				|| a.contains("tin") || a.contains("copper") || a.contains("iron")
				|| a.contains("silver") || a.contains("gold") || a.contains("platinum") || a.contains("titanium") || a.contains("uranium") || a.contains("tungsten")
				|| a.contains("emerald") || a.contains("sapphire") || a.contains("ruby") || a.contains("topaz")
				|| a.contains("jade") || a.contains("diamond") || a.contains("olivine") || a.contains("wadsleyite")
				|| a.contains("ringwoodite") || a.contains("brigmanite") || a.contains("amazonite") || a.contains("majorite") || a.contains("onyx"))
		{
			if (a.contains("compact")) {
				return 3 + random.nextInt(fortune * 3 + 1);
			}
			else return 1 + random.nextInt(fortune + 1);
		}
		else if (a.contains("redstone") || a.contains("lapis"))
		{

			if (a.contains("compact")) {
				return 8 + new Random().nextInt(fortune * 4 + 4);
			}
			else if (a.contains("ore_redstone") || a.contains("crustrock_redstone") || a.contains("mantlerock_redstone")
					|| a.contains("ore_lapis") || a.contains("crustrock_lapis") || a.contains("mantlerock_lapis"))
			{
				return 4 + new Random().nextInt(fortune * 2 + 2);
			}
		}
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

				if (Math.random() >= pos.getY() * -0.0001) {
					return;
				}
				for (EnumFacing side : EnumFacing.values()) {
					BlockPos movedPos = pos.offset(side);
					IBlockState movedState = worldIn.getBlockState(movedPos);
					if (movedState.getMaterial() == Material.IRON) return;
					if (movedState == Blocks.AIR.getDefaultState() || movedState == Blocks.LADDER || movedState == Blocks.WALL_SIGN || movedState == Blocks.STONE_BUTTON || movedState == Blocks.WATER) {
						continue;
					}
					EnumFacing[] sides = Arrays.stream(EnumFacing.VALUES)
							.filter(s -> !movedPos.offset(s).equals(pos) && worldIn.isAirBlock(movedPos.offset(s)))
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
		return this == ModBlocks.IRON_BLOCK || this == ModBlocks.STEEL_BLOCK || this == ModBlocks.SILVER_BLOCK || this ==  ModBlocks.GOLD_BLOCK
				|| this == ModBlocks.PLATINUM_BLOCK || this == ModBlocks.SAPPHIRE_BLOCK || this == ModBlocks.RUBY_BLOCK
				|| this == ModBlocks.TOPAZ_BLOCK || this == ModBlocks.DIAMOND_BLOCK || this == ModBlocks.JADE_BLOCK || this == ModBlocks.AMAZONITE_BLOCK || this == ModBlocks.ONYX_BLOCK;
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
