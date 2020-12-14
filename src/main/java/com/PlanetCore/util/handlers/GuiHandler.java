package com.PlanetCore.util.handlers;

import com.PlanetCore.blocks.furnaces.ContainerCrustrockFurnace;
import com.PlanetCore.blocks.furnaces.GuiCrustrockFurnace;
import com.PlanetCore.blocks.furnaces.TileEntityCrustrockFurnace;
import com.PlanetCore.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler{

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == Reference.GUI_CRUSTROCK_FURNACE) return new ContainerCrustrockFurnace(player.inventory, (TileEntityCrustrockFurnace)world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == Reference.GUI_CRUSTROCK_FURNACE) return new GuiCrustrockFurnace(player.inventory, (TileEntityCrustrockFurnace)world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }

}
