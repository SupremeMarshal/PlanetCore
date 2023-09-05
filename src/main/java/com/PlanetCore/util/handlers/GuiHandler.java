package com.PlanetCore.util.handlers;

import com.PlanetCore.items.tutorialBook.ContainerTutorialBook;
import com.PlanetCore.items.tutorialBook.GuiTutorialBook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return new ContainerTutorialBook();
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        return new GuiTutorialBook();
    }
}