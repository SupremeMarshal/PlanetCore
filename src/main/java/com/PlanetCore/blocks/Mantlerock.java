package com.PlanetCore.blocks;




import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.List;
import java.util.Random;

import static javax.swing.UIManager.put;

public class Mantlerock extends BlockBase
{

	public Mantlerock(String name, Material material) {
		super(name, material);

		setSoundType(SoundType.STONE);

		setResistance(100.0F);
		setHarvestLevel("pickaxe", 0);
		setTickRandomly(true);

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
	Random rand = new Random();
	//Pressure!
	public void pressure(World worldIn, BlockPos pos, IBlockState state) {

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

		int side1 = 0;
		int side2 = 0;
		int side3 = 0;
		int side4 = 0;
		int side5 = 0;
		int side6 = 0;
		int sides = side1 + side2 + side3 + side4 + side5 + side6;
		int chance = rand.nextInt(6);
		//if (rand.nextInt(20) == 0) {
			if (state1.getMaterial() == Material.AIR) {
				side1 = 1;
			} else if (state1.getMaterial() != Material.AIR) {
				side1 = 0;
				sides++;
				System.out.println("Sides1: " + sides);
			}
			else if (state2.getMaterial() == Material.AIR) {
				side2 = 1;
			} else if (state2.getMaterial() != Material.AIR) {
				side2 = 0;
				sides++;
				System.out.println("Sides2: " + sides);
			}
			else if (state3.getMaterial() == Material.AIR) {
				side3 = 1;
			} else if (state3.getMaterial() != Material.AIR) {
				side3 = 0;
				sides++;
				System.out.println("Sides3: " + sides);
			}
			else if (state4.getMaterial() == Material.AIR) {
				side4 = 1;
			} else if (state4.getMaterial() != Material.AIR) {
				side4 = 0;
				sides++;
				System.out.println("Sides4: " + sides);
			}
			else if (state5.getMaterial() == Material.AIR) {
				side5 = 1;
			} else if (state5.getMaterial() != Material.AIR) {
				side5 = 0;
				sides++;
				System.out.println("Sides4: " + sides);
			}
			else if (state6.getMaterial() == Material.AIR) {
				side6 = 1;
			} else if (state5.getMaterial() != Material.AIR) {
				side6 = 0;
				sides++;
				System.out.println("Sides5: " + sides);
			}
if (side1 == 0 && side2 == 0 && side3 == 0 && side4 ==0 && side5 ==0 && side6 ==0)
{
	return;
}
else if (side1 == 1 && side2 == 0 && side3 == 0 && side4 ==0 && side5 ==0 && side6 ==0)
{
	worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
	worldIn.setBlockState(pos.up(), state1.getBlock().getDefaultState());
}
else if (side1 == 1 && side2 == 1 && side3 == 0 && side4 ==0 && side5 ==0 && side6 ==0)
{
	int prob = rand.nextInt(2);
	if (prob ==0)
	{
		worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
		worldIn.setBlockState(pos.up(), state1.getBlock().getDefaultState());
	}
	else if (prob ==1)
	{
		worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
		worldIn.setBlockState(pos.down(), state2.getBlock().getDefaultState());
	}
}
else if (side1 == 1 && side2 == 1 && side3 == 1 && side4 ==0 && side5 ==0 && side6 ==0)
{
	int prob = rand.nextInt(3);
	if (prob ==0)
	{
		worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
		worldIn.setBlockState(pos.up(), state1.getBlock().getDefaultState());
	}
	else if (prob ==1)
	{
		worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
		worldIn.setBlockState(pos.down(), state2.getBlock().getDefaultState());
	}
	else if (prob ==2)
	{
		worldIn.setBlockState(pos, ModBlocks.MANTLEROCK.getDefaultState());
		worldIn.setBlockState(pos.east(), state3.getBlock().getDefaultState());
	}
}
else if (side1 == 1 && side2 == 1 && side3 == 1 && side4 ==1 && side5 ==0 && side6 ==0)
{

}
else if (side1 == 1 && side2 == 1 && side3 == 1 && side4 ==1 && side5 ==1 && side6 ==0)
{

}
else if (side1 == 1 && side2 == 1 && side3 == 1 && side4 ==1 && side5 ==1 && side6 ==1)
{

}

		//}
	}
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
								EntityFallingBlock entityfallingblock = new EntityFallingBlock(worldIn, (double) pos.getX() + 0.5D, (double) pos.getY(), (double) pos.getZ() + 0.5D, worldIn.getBlockState(pos));
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
	public void lavaDecompression(World WorldIn, BlockPos pos, IBlockState state)
	{

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
		lavaDecompression(worldIn,pos,state);
		pressure(worldIn,pos,state);
	}





}
