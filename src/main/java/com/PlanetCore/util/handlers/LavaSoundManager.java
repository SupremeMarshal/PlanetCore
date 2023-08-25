package com.PlanetCore.util.handlers;

import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.util.Reference;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.HashMap;
import java.util.Map;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class LavaSoundManager {
    private static final Map<EntityPlayer, LavaAmbience> playingSounds = new HashMap<>();
    private static final float MAX_DISTANCE = 10 * 10;

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if (event.phase != TickEvent.Phase.END) return;
        LavaAmbience existingSound = playingSounds.get(event.player);

        // Check if the sound is already playing for this player
        if (existingSound != null && Minecraft.getMinecraft().getSoundHandler().isSoundPlaying(existingSound)) return;

        EntityPlayer player = event.player;
        World world = player.world;
        double minDistance = Double.MAX_VALUE;

        for (int x = -10; x <= 10; x++) {
            for (int y = -10; y <= 10; y++) {
                for (int z = -10; z <= 10; z++) {
                    BlockPos pos = new BlockPos(player.posX + x, player.posY + y, player.posZ + z);
                    if (world.getBlockState(pos).getMaterial() == Material.LAVA) {
                        double distance = player.getDistanceSqToCenter(pos);
                        if (distance < minDistance) {
                            minDistance = distance;
                        }
                    }
                }
            }
        }

        if (minDistance <= MAX_DISTANCE) {
            // Schedule the sound playing on the main thread
            Minecraft.getMinecraft().addScheduledTask(() -> {
                // Create the sound and play it inside the scheduled task
                LavaAmbience newSound = new LavaAmbience(player, SoundHandler.LAVA_AMBIENCE);
                Minecraft.getMinecraft().getSoundHandler().playSound(newSound);
                playingSounds.put(player, newSound);
            });
        }
    }
}
