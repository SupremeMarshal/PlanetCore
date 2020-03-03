package com.PlanetCore.anvils;

import com.PlanetCore.anvils.generic.BlockGenericAnvil;
import com.PlanetCore.anvils.generic.ContainerGenericAnvil;
import com.PlanetCore.anvils.generic.GuiGenericAnvil;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
    public GuiHandler() {
    }

    public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        switch(ID) {
            case 0:
                if (world.getBlockState(pos).getBlock() instanceof BlockGenericAnvil) {
                    return new ContainerGenericAnvil(player.inventory, world, pos, player, (BlockGenericAnvil)world.getBlockState(pos).getBlock());
                }
            default:
                return null;
        }
    }

    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
        BlockPos pos = new BlockPos(x, y, z);
        switch(ID) {
            case 0:
                if (world.getBlockState(new BlockPos(x, y, z)).getBlock() instanceof BlockGenericAnvil) {
                    return new GuiGenericAnvil(player.inventory, world, (BlockGenericAnvil)world.getBlockState(pos).getBlock());
                }
            default:
                return null;
        }
    }
}
