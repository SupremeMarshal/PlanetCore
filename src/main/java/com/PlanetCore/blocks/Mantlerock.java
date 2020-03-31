package com.PlanetCore.blocks;




import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.util.IMetaName;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyEnum;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IStringSerializable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static javax.swing.UIManager.put;

public class Mantlerock extends BlockBase implements IMetaName
{



	public static final PropertyEnum<Mantlerock.EnumType> VARIANT = PropertyEnum.<Mantlerock.EnumType>create("variant",Mantlerock.EnumType.class);

	public Mantlerock(String name, Material material)
	{
		super(name, material);

		setSoundType(SoundType.STONE);

		setResistance(100.0F);
		setHarvestLevel("pickaxe", 0);
		setTickRandomly(true);

	}

	@Override
	public int damageDropped(IBlockState state)
	{
		return ((Mantlerock.EnumType)state.getValue(VARIANT)).getMeta();
	}

	@Override
	public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
		for (Mantlerock.EnumType mantlerock$enumtype : Mantlerock.EnumType.values()) {
			items.add(new ItemStack(this, 1, mantlerock$enumtype.getMeta()));
		}
	}

	@Override
	public IBlockState getStateFromMeta(int meta)
	{
		return this.getDefaultState().withProperty(VARIANT, Mantlerock.EnumType.byMetadata(meta));
	}

	@Override
	public int getMetaFromState(IBlockState state)
	{
		return ((Mantlerock.EnumType)state.getValue(VARIANT)).getMeta();
	}

	@Override
	public ItemStack getPickBlock(IBlockState state, RayTraceResult target, World world, BlockPos pos, EntityPlayer player) {
		return new ItemStack(Item.getItemFromBlock(this),1,(int)(getMetaFromState(world.getBlockState(pos))));
	}

	@Override
	protected BlockStateContainer createBlockState()
	{
		return new BlockStateContainer(this, new IProperty[] {VARIANT});
	}


	public static enum EnumType implements IStringSerializable
	{
		MANTLEROCK(0, "mantlerock"),
		MANTLEROCK1(1, "mantlerock1"),
		MANTLEROCK2(2, "mantlerock2"),
		MANTLEROCK3(3, "mantlerock3"),
		MANTLEROCK4(4, "mantlerock4"),
		MANTLEROCK5(5, "mantlerock5"),
		MANTLEROCK6(6, "mantlerock6"),
		MANTLEROCK7(7, "mantlerock7"),
		MANTLEROCK8(8, "mantlerock8"),
		LOWER_MANTLEROCK(9, "lower_mantlerock"),
		LOWER_MANTLEROCK1(10, "lower_mantlerock1"),
		LOWER_MANTLEROCK2(11, "lower_mantlerock2"),
		LOWER_MANTLEROCK3(12, "lower_mantlerock3"),
		LOWER_MANTLEROCK4(13, "lower_mantlerock4"),
		LOWER_MANTLEROCK5(14, "lower_mantlerock5"),
		LOWER_MANTLEROCK6(15, "lower_mantlerock6");

		private static final Mantlerock.EnumType[] META_LOOKUP = new Mantlerock.EnumType[values().length];
		private final int meta;
		private final String name, unlocalizedName;

		private EnumType(int meta, String name)
		{
			this(meta, name, name);
		}

		private EnumType(int meta, String name, String unlocalizedName) {
			this.meta = meta;
			this.name = name;
			this.unlocalizedName = unlocalizedName;
		}

		@Override
		public String getName() {
			return this.name;
		}

		public int getMeta()
		{
			return this.meta;
		}

		public String getUnlocalizedName()
		{
			return this.unlocalizedName;
		}

		@Override
		public String toString()
		{
			return this.name;
		}

		public static Mantlerock.EnumType byMetadata(int meta)
		{
			return META_LOOKUP[meta];
		}

		static {
			for(Mantlerock.EnumType mantlerock$enumtype : values())
			{
				META_LOOKUP[mantlerock$enumtype.getMeta()] = mantlerock$enumtype;
			}
		}

	}

	@Override
	public String getSpecialName(ItemStack stack)
	{
		return Mantlerock.EnumType.values()[stack.getItemDamage()].getName();
	}



	//Natural Gas Explosion event
	//Upon destroying the block, it has a small chance to explode. The deeper the rock is, the more probability it has to explode with a larger explosion.
	/*public void naturalGasExplosion(World worldIn, BlockPos pos, IBlockState state)
	{
		Random rand = new Random();
		int X = pos.getX();
		int Z = pos.getZ();
		for(int Y = -768; Y > -4544; Y--)
		{
			int Strength = Y / -768 + 2;
			if(Y < 768) {
				if (rand.nextInt(10000 / (Y + 768)) == 0) {
					worldIn.createExplosion(null, X, Y, Z, Strength, true);
				}
			}
		}
		for(int Y = -4545; Y > -5824; Y--)
		{
			if(Y < 768) {
				int Strength = Y / -768 + 2;
				if (rand.nextInt(5000 / (Y + 4544)) == 0) {
					worldIn.createExplosion(null, X, Y, Z, Strength, true);
				}
			}
		}
	}
	*/
	/*
	public static void push(World world, int X, int Y, int Z)
	{
		if (!world.isRemote)
		{
			AxisAlignedBB bb1 = new AxisAlignedBB(X - 10, Y - 10, Z - 10, X + 10, Y + 10, Z + 10);
			List<Entity> list1 = world.getEntitiesWithinAABBExcludingEntity(null, bb1);
			for (int i1 = 0; i1 < list1.size(); ++i1) {
				Entity entity = list1.get(i1);
				entity.motionY = 1;
				if (entity instanceof EntityPlayer)
				{
					EntityPlayer entityplayer = (EntityPlayer)entity;
					put(entityplayer, new Vec3d(0, 1, 0));
				}
				System.out.println("The code got here");
			}
		}
	}
*/



		/*
		IBlockState state1 = worldIn.getBlockState(pos.up());
		IBlockState state2 = worldIn.getBlockState(pos.down());
		IBlockState state3 = worldIn.getBlockState(pos.east());
		IBlockState state4 = worldIn.getBlockState(pos.west());
		IBlockState state5 = worldIn.getBlockState(pos.south());
		IBlockState state6 = worldIn.getBlockState(pos.north());
		/*
		int X = pos.getX();
		int Y = pos.getY();
		int Z = pos.getZ();
		AxisAlignedBB bb2 = new AxisAlignedBB(X,Y,Z,X,Y-2,Z);
		AxisAlignedBB bb3 = new AxisAlignedBB(X,Y,Z,X-1,Y,Z);
		AxisAlignedBB bb4 = new AxisAlignedBB(X,Y,Z,X+1,Y,Z);
		AxisAlignedBB bb5 = new AxisAlignedBB(X,Y,Z,X,Y,Z-1);
		AxisAlignedBB bb6 = new AxisAlignedBB(X,Y,Z,X,Y,Z+1);

		List list2 = worldIn.getEntitiesWithinAABBExcludingEntity(null, bb2);
		List list3 = worldIn.getEntitiesWithinAABBExcludingEntity(null, bb3);
		List list4 = worldIn.getEntitiesWithinAABBExcludingEntity(null, bb4);
		List list5 = worldIn.getEntitiesWithinAABBExcludingEntity(null, bb5);
		List list6 = worldIn.getEntitiesWithinAABBExcludingEntity(null, bb6);

 		*/

/*
		//if (rand.nextInt(20) == 0) {
		int sides = 0;
		if (state1.getMaterial() == Material.AIR) {
			sides++;
		} else if (state2.getMaterial() == Material.AIR) {
			sides++;
		} else if (state3.getMaterial() == Material.AIR) {
			sides++;
		} else if (state4.getMaterial() == Material.AIR) {
			sides++;
		} else if (state5.getMaterial() == Material.AIR) {
			sides++;
		} else if (state6.getMaterial() == Material.AIR) {
			sides++;
		}

		int k = rand.nextInt(sides - 1);
		if (sides == 0) {
			worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
			return;
		} else if (k == 0) {
			worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
			worldIn.setBlockState(pos.up(), state.getBlock().getDefaultState());
		} else if (k == 1) {
			worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
			worldIn.setBlockState(pos.down(), state.getBlock().getDefaultState());
		} else if (k == 2) {
			worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
			worldIn.setBlockState(pos.east(), state.getBlock().getDefaultState());
		} else if (k == 3) {
			worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
			worldIn.setBlockState(pos.west(), state.getBlock().getDefaultState());
		} else if (k == 4) {
			worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
			worldIn.setBlockState(pos.south(), state.getBlock().getDefaultState());
		} else if (k == 5) {
			worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
			worldIn.setBlockState(pos.north(), state.getBlock().getDefaultState());
		}
	}

 */

		// can just do this first.
		//worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());



		/* up, down, etc. in same order as `states`. probably a method to get dir from int, idk, if not use this */


/*
		BlockPos[] offsets = new BlockPos[]{pos.up(), pos.down(), pos.east(), pos.west(), pos.north(), pos.south()};
		IBlockState[] states = {worldIn.getBlockState(offsets[0]),worldIn.getBlockState(offsets[1]),worldIn.getBlockState(offsets[2]),worldIn.getBlockState(offsets[3]),worldIn.getBlockState(offsets[4]),worldIn.getBlockState(offsets[5])};

		int sides = 0;

		for (IBlockState neighborState : states) {
			if (neighborState.getMaterial() == Material.AIR) {
				sides += 1;
			}
		}
		if (sides == 0) {
			return;
		}
		int k = rand.nextInt(sides-1);
		int j = 0;
		for (int i = 0; i < 6; i++) {
			IBlockState neighborState = states[i];
			if (neighborState.getMaterial() == Material.AIR) {
				if (j == k) {
					worldIn.setBlockState(pos.add(offsets[i]), state.getBlock().getDefaultState());
					worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());

					return;
				} else {
					j++;
				}
			}
		}
*/

		//}

				/*
			{

				worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
				worldIn.setBlockState(pos.up(), state.getBlock().getDefaultState());
				System.out.println("side1");
			}
			else if (chance == 0 && state1.getMaterial() != Material.AIR && state1.getMaterial() != Material.LAVA && state1.getMaterial() != Material.WATER
					&& state2.getMaterial() == Material.AIR && state2.getMaterial() != Material.LAVA && state2.getMaterial() != Material.WATER)
			{

				worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
				worldIn.setBlockState(pos.up(), state.getBlock().getDefaultState());
				System.out.println("side1");
			}
			else if (chance == 1 && state2.getMaterial() == Material.AIR && state2.getMaterial() != Material.LAVA && state2.getMaterial() != Material.WATER)
			{
				worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
				worldIn.setBlockState(pos.down(), state.getBlock().getDefaultState());
			/*
			for (int i1 = 0; i1 < list2.size(); ++i1)
			{
				Entity entity = (Entity) list2.get(i1);

				System.out.println("push successful 2");
			}
			*/
/*
				System.out.println("side2");
			}
			else if (chance == 2 && state3.getMaterial() == Material.AIR && state3.getMaterial() != Material.LAVA && state3.getMaterial() != Material.WATER)
			{
				worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
				worldIn.setBlockState(pos.east(), state.getBlock().getDefaultState());

				System.out.println("side3");
			}
			else if (chance == 3 && state4.getMaterial() == Material.AIR && state2.getMaterial() != Material.LAVA && state2.getMaterial() != Material.WATER)
			{
				worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
				worldIn.setBlockState(pos.west(), state.getBlock().getDefaultState());
				System.out.println("side4");
			}
			else if (chance == 4 && state5.getMaterial() == Material.AIR && state1.getMaterial() != Material.LAVA && state1.getMaterial() != Material.WATER)
			{
				worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
				worldIn.setBlockState(pos.south(), state.getBlock().getDefaultState());
				System.out.println("Random Integers: " + chance);
			}
			else if (chance == 5 && state6.getMaterial() == Material.AIR && state1.getMaterial() != Material.LAVA && state1.getMaterial() != Material.WATER)
			{
				worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
				worldIn.setBlockState(pos.north(), state.getBlock().getDefaultState());
				System.out.println("side6");
			}
		}
	}

 */


	//Earthquake event
	//Upon destroying the block, by a player or by explosion, the surrounding area for the player have a chance to crumble.
	//How this event should work: No description
	/*public static void earthquake(World worldIn, BlockPos pos, IBlockState state)
	{

		int x;
		int y;
		int z;
		x = pos.getX() -13;
		y = pos.getY() -13;
		z = pos.getZ() -13;
		int x1;
		int y1;
		int z1;
		x1 = pos.getX() +14;
		y1 = pos.getY() +14;
		z1 = pos.getZ() +14;


		Random rand = new Random();
		int Y = pos.getY();
		//&& rand.nextInt(-500 / (Y / 64)) == 0
			//if(Y <=0 && Y >= -4544 )

				Iterable<BlockPos> it = BlockPos.getAllInBox(x, y, z, x1, y1, z1);
				for (BlockPos pos2 : it)
				{
					IBlockState state2 = worldIn.getBlockState(pos2);
					if (state2.getMaterial()==Material.AIR)
					{
							int x3 = pos2.getX();
							int y3 = pos2.getY()+1;
							int z3 = pos2.getZ();
							BlockPos pos3 = new BlockPos(x3,y3,z3);
							IBlockState state3 = worldIn.getBlockState(pos3);
						if (state3.getBlock() instanceof Mantlerock) {
							if (!worldIn.isRemote) {
								  EntityFallingBlock entityfallingblock = new EntityFallingBlock(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, worldIn.getBlockState(pos));
        entityfallingblock.setHurtEntities(true);
        //this.onStartFalling(entityfallingblock);
        					worldIn.spawnEntity(entityfallingblock);
							}
						}
					}
				}
	}


	/*
	//Unstable block
	public void unstableBlock(World worldIn, BlockPos pos, IBlockState state)
	{
		int x;
		int y;
		int z;

		x = pos.getX();
		y = pos.getY() -1;
		z = pos.getZ();
		Random rand = new Random();
		BlockPos pos2 = new BlockPos(x,y,z);
		IBlockState state2 = worldIn.getBlockState(pos2);
		if (state2.getMaterial()!=Material.AIR)
		{
			//Block become stable
		}
		if (state2.getMaterial()==Material.AIR)
		{
			if (rand.nextInt(500)==0)
			{
				//Create falling boulder
			}
		}
	}
	 */


	//Lava Decompression event
	//Lava being spawned from removing the pressure
	//This event can be stacked with earthquake.
	//=(G26+1536)/(-12500)/64
	//=(G152+9600)/(-12500)/64
	public void lavaDecompression(World worldIn, BlockPos pos, IBlockState state) {
		float chance = pos.getY()+1536/-12500/64F;
		float chance1 = pos.getY()+9600/-12500/64F;
		if (pos.getY() < -1530 && pos.getY() > -9536 && Math.random() <= chance && !worldIn.isRemote) {
			worldIn.setBlockState(pos, (IBlockState) Blocks.LAVA);
		}
		if (pos.getY() <= -9536 && Math.random() <= 0.01F && !worldIn.isRemote) {
			worldIn.setBlockState(pos, (IBlockState) Blocks.LAVA);
		}
		if (pos.getY() < -9536 && pos.getY() > -12650 && Math.random() <= chance1 && !worldIn.isRemote) {
			worldIn.setBlockState(pos, (IBlockState) ModBlocks.CORE_LAVA_FLUID);
		}
	}



	@Override
	public void onBlockExploded(World world, BlockPos pos, Explosion explosion) {
		super.onBlockExploded(world, pos, explosion);
		//naturalGasExplosion(world, pos, (IBlockState)explosion);
		//earthquake(world, pos, (IBlockState)explosion);
		lavaDecompression(world, pos, (IBlockState)explosion);
	}

	@Override
	public void onPlayerDestroy(World worldIn, BlockPos pos, IBlockState state) {
		super.onPlayerDestroy(worldIn, pos, state);
		//naturalGasExplosion(worldIn, pos, state);
		//earthquake(worldIn, pos, state);
		lavaDecompression(worldIn, pos, state);
	}

	@Override
	public void updateTick(World worldIn, BlockPos pos, IBlockState state, Random rand)
	{
		super.updateTick(worldIn, pos, state, rand);

		//unstableBlock(worldIn,pos,state);
		//Only if the event has started
		//lavaDecompression(worldIn,pos,state);
	}



}
