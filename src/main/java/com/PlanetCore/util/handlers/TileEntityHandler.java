package com.PlanetCore.util.handlers;

import com.PlanetCore.blocks.furnaces.TileEntityCrustrockFurnace;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {

    public static void registerTileEntities()
    {

        GameRegistry.registerTileEntity(TileEntityCrustrockFurnace.class, "planetcore:crustrock_furnace");

    }

}
