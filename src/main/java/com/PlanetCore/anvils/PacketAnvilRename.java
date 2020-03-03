package com.PlanetCore.anvils;


import com.PlanetCore.anvils.generic.ContainerGenericAnvil;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.minecraft.util.IThreadListener;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.network.ByteBufUtils;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class PacketAnvilRename implements IMessage {
    private String name;
    private int length;

    public PacketAnvilRename() {
    }

    public PacketAnvilRename(String s) {
        this.name = s;
    }

    public void fromBytes(ByteBuf buf) {
        this.name = ByteBufUtils.readUTF8String(buf);
    }

    public void toBytes(ByteBuf buf) {
        ByteBufUtils.writeUTF8String(buf, this.name);
    }

    public static class Handler implements IMessageHandler<PacketAnvilRename, IMessage> {
        public Handler() {
        }

        public IMessage onMessage(PacketAnvilRename message, MessageContext ctx) {
            FMLCommonHandler.instance().getWorldThread(ctx.netHandler).addScheduledTask(() -> {
                this.handle(message, ctx);
            });
            return null;
        }

        private void handle(PacketAnvilRename message, MessageContext ctx) {
            EntityPlayerMP playerEntity = ctx.getServerHandler().player;
            Container container = playerEntity.openContainer;
            IThreadListener mainThread = (WorldServer)ctx.getServerHandler().player.world;
            mainThread.addScheduledTask(() -> {
                if (container instanceof ContainerGenericAnvil) {
                    ContainerGenericAnvil anvil = (ContainerGenericAnvil)ctx.getServerHandler().player.openContainer;
                    anvil.updateItemName(message.name);
                }

            });
        }
    }
}
