package com.PlanetCore.util.debug.render;

import com.PlanetCore.blocks.Powered_ladders.DiamondLadderBlock;
import com.PlanetCore.net.PacketHandler;
import com.PlanetCore.net.S2CLadderPacket;
import com.PlanetCore.world.LadderSavedData;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class RenderWorldLastEventHandler {

    @SubscribeEvent
    public static void onRenderWorldLastEvent(RenderWorldLastEvent event) {
        RendererCube.tryToRender(event);
    }

    @SubscribeEvent
    public static void logoff(PlayerEvent.PlayerLoggedOutEvent event) {
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP) event.player;
    }

    @SubscribeEvent
    public static void login(PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP) event.player;
        LadderSavedData ladderSavedData = DiamondLadderBlock.getOrCreate(entityPlayerMP.world);
        PacketHandler.INSTANCE.sendToDimension(new S2CLadderPacket(ladderSavedData.getPillars()), entityPlayerMP.world.provider.getDimension());
    }

    @SubscribeEvent
    public static void changeDim(PlayerEvent.PlayerChangedDimensionEvent event) {
        EntityPlayerMP entityPlayerMP = (EntityPlayerMP) event.player;
        LadderSavedData ladderSavedData = DiamondLadderBlock.getOrCreate(entityPlayerMP.world);
        PacketHandler.INSTANCE.sendToDimension(new S2CLadderPacket(ladderSavedData.getPillars()), event.toDim);
    }
}
