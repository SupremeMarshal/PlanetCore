package com.PlanetCore.util.handlers;

import com.PlanetCore.blocks.furnaces.TileEntitySinteringFurnace;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {

    public static void registerTileEntities()
    {

        GameRegistry.registerTileEntity(TileEntitySinteringFurnace.class, "planetcore:sintering_furnace");

    }

}
