package com.PlanetCore.util.handlers;

import net.minecraft.entity.item.EntityXPOrb;
import net.minecraft.world.World;

public class XPOrb {
	
	public static void executeProcedure(java.util.HashMap<String, Object> dependencies) {
		
		int x = (int) dependencies.get("x");
		int y = (int) dependencies.get("y");
		int z = (int) dependencies.get("z");
		World world = (World) dependencies.get("world");
		if (!world.isRemote) {
			world.spawnEntity(new EntityXPOrb(world, x, y, z, (int) 2));
		}
	}

}
