package com.PlanetCore.net;

import com.PlanetCore.util.Reference;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

public class PacketHandler {

  public static SimpleNetworkWrapper INSTANCE = null;

  public PacketHandler() {
  }
  public static void registerMessages() {
    INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
    // Register messages which are sent from the client to the server here:
    INSTANCE.registerMessage(S2CLadderPacket.Handler.class, S2CLadderPacket.class, 0, Side.CLIENT);
  }
}