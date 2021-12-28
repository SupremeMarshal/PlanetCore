package com.PlanetCore.util.handlers;

import com.PlanetCore.blocks.furnaces.*;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class TileEntityHandler {

    public static void registerTileEntities()
    {

        GameRegistry.registerTileEntity(TileEntityCrustrockFurnace.class, "planetcore:crustrock_furnace");
        GameRegistry.registerTileEntity(TileEntitySteelFurnace.class, "planetcore:steel_furnace");
        GameRegistry.registerTileEntity(TileEntityTitaniumFurnace.class, "planetcore:titanium_furnace");
        GameRegistry.registerTileEntity(TileEntityTungstenFurnace.class, "planetcore:tungsten_furnace");
        GameRegistry.registerTileEntity(TileEntityTungstenTitaniumFurnace.class, "planetcore:tungsten_titanium_furnace");



    }

}
