package com.PlanetCore.util.handlers;

import com.PlanetCore.blocks.furnaces.*;
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
        if(ID == Reference.GUI_STEEL_FURNACE) return new ContainerSteelFurnace(player.inventory, (TileEntitySteelFurnace)world.getTileEntity(new BlockPos(x,y,z)));
        if(ID == Reference.GUI_TUNGSTEN_FURNACE) return new ContainerTungstenFurnace(player.inventory, (TileEntityTungstenFurnace)world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        if(ID == Reference.GUI_CRUSTROCK_FURNACE) return new GuiCrustrockFurnace(player.inventory, (TileEntityCrustrockFurnace)world.getTileEntity(new BlockPos(x,y,z)));
        if(ID == Reference.GUI_STEEL_FURNACE) return new GuiSteelFurnace(player.inventory, (TileEntitySteelFurnace)world.getTileEntity(new BlockPos(x,y,z)));
        if(ID == Reference.GUI_TUNGSTEN_FURNACE) return new GuiTungstenFurnace(player.inventory, (TileEntityTungstenFurnace)world.getTileEntity(new BlockPos(x,y,z)));
        return null;
    }

}
