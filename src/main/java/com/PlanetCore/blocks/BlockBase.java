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

	/*
	@Override
	public Block setHardness(float hardness) {
		int meta = getMetaFromState(getDefaultState());
		IBlockState state = this.getDefaultState();
		if (meta == 1 && state == ModBlocks.MANTLEROCK.getDefaultState()) { return super.setHardness(-1F); }
		else {return super.setHardness(hardness);}
	}

	 */

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
	private static final float [] crustHardnessByMeta = {2, 2.5F, 3, 3.5F, 4, 4.5F, 5, 5.5F, 6};
	private static final float [] mantleHardnessByMeta = {7, 8, 9, 10, 12, 14, 17, 20, 25, 30, 36, 43, 51, 62, 74, 100};
	private static final float [] coreHardnessByMeta = {200, 400, 600};



	private static final String[] MaterialItem = {"ALUMINIUM", "ZINC", "LEAD", "TIN", "SILICON", "COPPER", "IRON", "SILVER",
			"GOLD", "PLATINUM", "TITANIUM", "URANIUM", "TUNGSTEN", "TOPAZ", "JADE", "EMERALD", "RUBY", "SAPPHIRE", "DIAMOND", "OLIVINE",
			"WADSLEYITE", "RINGWOODITE", "BRIGMANITE", "MAJORITE", "AMAZONITE", "ONYX", "COAL", "SULFUR"};










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
		Boolean b;
		Boolean c;
		Item drop = null;
		if (a.contains("small")) { b = true; }
		else {b = false;}
		if (a.contains("redstone")) { c = true; if (!b) { drop = Items.REDSTONE; } else { drop = ModItems.REDSTONE_SHARD; }}
		else if (a.contains("lapis")) { c = true; if (!b) { drop = Items.DYE; } else { drop = ModItems.LAPIS_SHARD; }}
		else if (a.contains("sulfur")) { c = true; if (!b) { drop = ModItems.SULFUR; } else { drop = ModItems.SULFUR_SHARD; }}
		else if (a.contains("coal")) { c = true; if (!b) { drop = Items.COAL; } else { drop = ModItems.COAL_BIT; }}
		else if (a.contains("emerald")) { c = true; if (!b) { drop = ModItems.EMERALD; } else { drop = ModItems.EMERALD_SHARD; }}
		else if (a.contains("sapphire")) { c = true; if (!b) { drop = ModItems.SAPPHIRE; } else { drop = ModItems.SAPPHIRE_SHARD; }}
		else if (a.contains("ruby")) { c = true; if (!b) { drop = ModItems.RUBY; } else { drop = ModItems.RUBY_SHARD; }}
		else if (a.contains("topaz")) { c = true; if (!b) { drop = ModItems.TOPAZ; } else { drop = ModItems.TOPAZ_SHARD; }}
		else if (a.contains("jade")) { c = true; if (!b) { drop = ModItems.JADE; } else { drop = ModItems.JADE_SHARD; }}
		else if (a.contains("diamond")) { c = true; if (!b) { drop = ModItems.DIAMOND; } else { drop = ModItems.DIAMOND_SHARD; }}
		else if (a.contains("olivine")) { c = true; if (!b) { drop = ModItems.OLIVINE; } else { drop = ModItems.OLIVINE_SHARD; }}
		else if (a.contains("wadsleyite")) { c = true; if (!b) { drop = ModItems.WADSLEYITE; } else { drop = ModItems.WADSLEYITE_SHARD; }}
		else if (a.contains("ringwoodite")) { c = true; if (!b) { drop = ModItems.RINGWOODITE; } else { drop = ModItems.RINGWOODITE_SHARD; }}
		else if (a.contains("brigmanite")) { c = true; if (!b) { drop = ModItems.BRIGMANITE; } else { drop = ModItems.BRIGMANITE_SHARD; }}
		else if (a.contains("amazonite")) { c = true; if (!b) { drop = ModItems.AMAZONITE; } else { drop = ModItems.AMAZONITE_SHARD; }}
		else if (a.contains("majorite")) { c = true; if (!b) { drop = ModItems.MAJORITE; } else { drop = ModItems.MAJORITE_SHARD; }}
		else if (a.contains("onyx")) { c = true; if (!b) { drop = ModItems.ONYX; } else { drop = ModItems.ONYX_SHARD; }}
		else { c = false;  }

		if (!c) { return Item.getItemFromBlock(this); }
		else { return new ItemStack(drop, 1, 0).getItem(); }
	}


	@Override
	public int damageDropped(IBlockState state) {
		String a = this.getTranslationKey();
		if (a.contains("lapis") && !a.contains("small")) {
			return EnumDyeColor.BLUE.getDyeDamage();
		}
		else if (this == ModBlocks.CRUSTROCK || a.contains("redstone") || a.contains("sulfur") || a.contains("coal") || a.contains("emerald")
				|| a.contains("sapphire") || a.contains("ruby") || a.contains("topaz") || a.contains("jade")
				|| a.contains("diamond") || a.contains("olivine") || a.contains("wadsleyite") || a.contains("ringwoodite")
				|| a.contains("brigmanite") || a.contains("amazonite") || a.contains("majorite") || a.contains("onyx")) {
			return 0;
		}
		else return this.getMetaFromState(state);
	}

/*
	@Override
	public int damageDropped(IBlockState state) {
		return super.damageDropped(state);
	}

 */

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
	public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
		world.setBlockToAir(pos);
		this.onExplosionDestroy(world, pos, explosion);
	}

	@Override
	public int quantityDropped(Random random) {
		String a = this.getTranslationKey();
		return 1;
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		String a = this.getTranslationKey();
		if (a.contains("sulfur") || a.contains("coal")
				|| a.contains("emerald") || a.contains("sapphire") || a.contains("ruby") || a.contains("topaz")
				|| a.contains("jade") || a.contains("diamond") || a.contains("olivine") || a.contains("wadsleyite")
				|| a.contains("ringwoodite") || a.contains("brigmanite") || a.contains("amazonite") || a.contains("majorite") || a.contains("onyx"))
		{
			if (a.contains("small") || a.contains("compact")) {
				return 3 + random.nextInt(fortune * 3 + 1);
			}
			else return 1 + random.nextInt(fortune + 1);
		}
		else if (a.contains("redstone") || a.contains("lapis"))
		{

			if (a.contains("small")) {
				return 8 + new Random().nextInt(fortune * 4 + 4);
			}
			else if (a.contains("compact")) {
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


			if ((this == ModBlocks.MANTLEROCK) && pos.getY() < -1000 && (Math.random() <= ((pos.getY() +1000) / -100000.0F)))
			{
				for (EnumFacing side : EnumFacing.values())
				{
					BlockPos movedPos = pos.offset(side);
					IBlockState movedState = worldIn.getBlockState(movedPos);
					float PressureLevel = (movedPos.getY()+1000) * -0.04F;
					if (movedState.getMaterial() == Material.IRON) return;
					if (movedState == Blocks.AIR.getDefaultState() || movedState == Blocks.LADDER || movedState == Blocks.WALL_SIGN || movedState == Blocks.STONE_BUTTON || movedState.getBlockHardness(worldIn, movedPos) - 10F > PressureLevel)
					{
						continue;
					}
					EnumFacing[] sides = Arrays.stream(EnumFacing.VALUES)
							.filter(s -> !movedPos.offset(s).equals(pos) && worldIn.isAirBlock(movedPos.offset(s)))
							.toArray(EnumFacing[]::new);
					if (sides.length == 0)
					{
						continue;
					}
					worldIn.setBlockState(movedPos.offset(sides[rand.nextInt(sides.length)]), movedState);
					worldIn.setBlockState(movedPos, worldIn.getBlockState(pos));
					return;
				}
			}
		}





/**
	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		float PressureLevel = pos.getY()*-0.05F;
			if (pos.getY() < 0 && Math.random() <= (pos.getY() / -40000.0F) && !(this instanceof Corerock) && !(this instanceof BlocksBase)) {
				for (EnumFacing side : EnumFacing.values()) {
					BlockPos movedPos = pos.offset(side);
					IBlockState movedState = worldIn.getBlockState(movedPos);
					if (movedState == Blocks.AIR.getDefaultState() || movedState == Blocks.LADDER || movedState == Blocks.WALL_SIGN || movedState == Blocks.STONE_BUTTON || movedState.getBlock().getBlockHardness(state, worldIn, pos) < PressureLevel) {
						continue;
					}
					EnumFacing[] sides = Arrays.stream(EnumFacing.VALUES)
							.filter(s -> !movedPos.offset(s).equals(pos) && worldIn.isAirBlock(movedPos.offset(s)))
							.toArray(EnumFacing[]::new);
					if (sides.length == 0) continue;
					worldIn.setBlockState(movedPos.offset(sides[rand.nextInt(sides.length)]), movedState);
					worldIn.setBlockState(movedPos, worldIn.getBlockState(pos));
					return;
				}
			}
		}

 */







	/*
	The unstable effect cause the blocks to fall around you when destroying blocks.
	I will change it to make it happen more often above a certain Y level and only decrease the further down you go.
	 */
	/*public static void unstable(World worldIn, BlockPos pos, IBlockState state) {
		int x;
		int y;
		int z;
		x = pos.getX();
		y = pos.getY();
		z = pos.getZ();
		float counter = 0;
		Random rand = new Random();
		int rand2 = (rand.nextInt(2));
		int rand4 = (rand.nextInt(4));
		float chance = (float)Math.random();
		Iterable<BlockPos> it = BlockPos.getAllInBox(x - 12, y - 12, z - 12, x + 12, y + 12, z + 12);
		for (BlockPos pos1 : it) {
			IBlockState state2 = worldIn.getBlockState(pos1);
			if (state2.getMaterial() == Material.AIR) {
				counter++;
			}
		}
		float SuperChance = (pos.getY() / (-600000.0F / ((counter + 1F) / 64F)));
		float SuperChance1 = ((-6000 - pos.getY()) / (-1800000.0F / ((counter + 1F) / 64F)));
		if ((y <= 0 && y >= -1500 && Math.random() <= SuperChance) || (y <= -1500 && y >= -6000 && Math.random() <= SuperChance1))
		{
			for (BlockPos pos2 : it) {
				IBlockState state2 = worldIn.getBlockState(pos2);
				if (state2.getMaterial() == Material.AIR)
				{
					int x1 = pos2.getX();
					int y1 = pos2.getY() + 1;
					int z1 = pos2.getZ();
					BlockPos pos3 = new BlockPos(x1, y1, z1);
					IBlockState state3 = worldIn.getBlockState(pos3);
					if (state3.getMaterial() == Material.ROCK && !worldIn.isRemote && Math.random() <= chance)
					{
						int x2 = pos3.getX();
						int y2 = pos3.getY();
						int z2 = pos3.getZ();
						{
							EntityFallingBlock entityfallingblock = new EntityFallingBlock(worldIn, x2 + 0.5, y2, z2 + 0.5,state3);
							entityfallingblock.setHurtEntities(true);
							worldIn.spawnEntity(entityfallingblock);
						}
					}
				}
			}
		}
	}
	 */

	private void unharvestable(World worldIn, BlockPos pos, EntityPlayer entity) {

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

	@Override
	public void onPlayerDestroy(World worldIn, BlockPos pos, IBlockState state) {
		//naturalGasExplosion(worldIn, pos, state);
		//lavaDecompression(worldIn, pos, state);
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
