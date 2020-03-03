package com.PlanetCore.anvils;


import com.PlanetCore.anvils.PacketAnvilRename.Handler;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {
    public static SimpleNetworkWrapper INSTANCE = null;

    public PacketHandler() {
    }

    public static void registerMessages(String channelName) {
        INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(channelName);
        registerMessages();
    }

    public static void registerMessages() {
        INSTANCE.registerMessage(Handler.class, PacketAnvilRename.class, 0, Side.SERVER);
    }
}