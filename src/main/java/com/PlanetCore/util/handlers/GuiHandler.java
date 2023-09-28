package com.PlanetCore.util.handlers;

import com.PlanetCore.blockentity.LavaGeneratorBlockEntity;
import com.PlanetCore.client.LavaGeneratorScreen;
import com.PlanetCore.menu.LavaGeneratorMenu;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;
import net.minecraftforge.items.ItemStackHandler;

public class GuiHandler implements IGuiHandler {

    public static final int LAVA_GENERATOR = 0;

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x,y,z));
        switch (ID) {
            case LAVA_GENERATOR:return new LavaGeneratorMenu(player,((LavaGeneratorBlockEntity)tileEntity).getItemStackHandler(),(LavaGeneratorBlockEntity) tileEntity);
        }
        return null;
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        TileEntity tileEntity = world.getTileEntity(new BlockPos(x,y,z));
        switch (ID) {
            case LAVA_GENERATOR:return new LavaGeneratorScreen(new LavaGeneratorMenu(player,new ItemStackHandler(),(LavaGeneratorBlockEntity) tileEntity));
        }
        return null;
    }
}