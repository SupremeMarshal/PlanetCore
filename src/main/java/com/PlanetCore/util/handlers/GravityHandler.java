package com.PlanetCore.util.handlers;
import com.PlanetCore.util.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.entity.living.LivingFallEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraft.entity.player.EntityPlayer;
@Mod.EventBusSubscriber(modid= Reference.MOD_ID)
public class GravityHandler {

    // Usage example

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
    }

    public static double calculateGravityModifier(double yPosition) {
        if (yPosition >= 0) {
            return 1.0;
        }
        yPosition = Math.min(yPosition,2500);
        double modifier = Math.sqrt(1 + yPosition / 2600);
        // Calculate the normalized Y position within the range
        return modifier;
    }

    @SubscribeEvent
    public void onPlayerJump(LivingEvent.LivingJumpEvent event)
    {
        //double jumpHeightMultiplier = jumpLevel + (-0.0005 * event.getEntityLiving().posY);
        //event.getEntityLiving().motionY *= jumpHeightMultiplier;
    }

    @SubscribeEvent
    public void onPlayerFall(LivingFallEvent event)
    {
        // Increase falling speed when gravity is low
       // double modifiedFallDistance = event.getDistance() / gravityLevel;

        // Apply the modified fall distance
       // event.setDistance((float) modifiedFallDistance);
    }
}
