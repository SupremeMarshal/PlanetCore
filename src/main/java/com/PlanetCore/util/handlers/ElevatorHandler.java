package com.PlanetCore.util.handlers;

import com.PlanetCore.blocks.Powered_ladders.IronLadderBlock;
import com.PlanetCore.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ElevatorHandler {

    private static boolean wasOnElevator = false;
    private static long lastElevatorTime = 0L;

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.player == null) {
            return;
        }
        boolean isPowered = false;
        EntityPlayer player = event.player;
        boolean isOnElevator = player.world.getBlockState(new BlockPos(player.posX, player.posY, player.posZ)).getBlock() instanceof IronLadderBlock;
        IBlockState state = player.world.getBlockState(new BlockPos(player.posX, player.posY, player.posZ));
        if (state.getBlock() instanceof IronLadderBlock)
        {
            isPowered = state.getValue(IronLadderBlock.POWERED);
        }
        double elevatorSpeed = 0.2;
        if (isPowered)
        {
            elevatorSpeed = 1;
        }
        if (event.player instanceof EntityPlayerSP && event.phase == TickEvent.Phase.END) {



            if (isOnElevator) {
                wasOnElevator = true;
                lastElevatorTime = System.currentTimeMillis();
                EntityPlayerSP player1 = (EntityPlayerSP) event.player;
                // If the player is looking downwards and pressing the "down" key
                if (player1.movementInput.sneak)
                {
                    player.motionY = 0;
                }
                else if (player.rotationPitch > 45.0F || player1.movementInput.backKeyDown) {
                    player.motionY = -elevatorSpeed;
                }
                // If the player is looking upwards and pressing the "up" key
                else if (player.rotationPitch < -45.0F && (player1.movementInput.forwardKeyDown || player1.movementInput.jump)) {
                    player.motionY = elevatorSpeed;
                }
                // If the player is on the ladder but not trying to go up or down
                else {
                    player.motionY = -elevatorSpeed;
                }
            }
            else {
                if (wasOnElevator && System.currentTimeMillis() - lastElevatorTime < 1000) { // 1000 ms = 1 second
                    player.motionY = 0;
                    wasOnElevator = false;
                }
            }
        }
    }

    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) {
        // Check if the fall is happening within 1 second of the player leaving the elevator
        if (event.getEntityLiving() instanceof EntityPlayer && System.currentTimeMillis() - lastElevatorTime < 1000) {
            event.setCanceled(true); // Cancel the fall damage
        }
    }
}




