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


    public static double calculateGravityModifier(double yPosition) {
        if (yPosition >= 0) {
            return 1.0;
        }
        double modifier = yPosition > -5995 ? (1 + yPosition / 6000) : 0.05;
        // Calculate the normalized Y position within the range
        return modifier;
    }

}
