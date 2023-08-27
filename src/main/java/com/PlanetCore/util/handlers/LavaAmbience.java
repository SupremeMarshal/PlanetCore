package com.PlanetCore.util.handlers;

import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MovingSound;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LavaAmbience extends MovingSound {
    private final EntityPlayer player;
    private final World world;
    private static final float MAX_DISTANCE = 10 * 10;
    int lavaCount = 0;

    public LavaAmbience(EntityPlayer player, SoundEvent soundEvent) {
        super(soundEvent, SoundCategory.AMBIENT);
        this.player = player;
        this.world = player.world;
        this.repeat = true;
        this.repeatDelay = 0;
        this.volume = 1.0f;
        this.pitch = 1.0f;
        this.xPosF = (float) player.posX;
        this.yPosF = (float) player.posY;
        this.zPosF = (float) player.posZ;
    }

    @Override
    public void update() {
        // Check if the player is near the lava
        double minDistance = Double.MAX_VALUE;
        lavaCount = 0;
        for (int x = -10; x <= 10; x++) {
            for (int y = -10; y <= 10; y++) {
                for (int z = -10; z <= 10; z++) {
                    BlockPos pos = new BlockPos(player.posX + x, player.posY + y, player.posZ + z);
                    if (world.getBlockState(pos).getMaterial() == Material.LAVA) {
                        double distance = player.getDistanceSqToCenter(pos);
                        if (distance < minDistance) {
                            minDistance = distance;
                            this.xPosF = pos.getX();
                            this.yPosF = pos.getY();
                            this.zPosF = pos.getZ();
                        }
                        lavaCount++;
                    }
                }
            }
        }
        if (minDistance <= MAX_DISTANCE) {
            volume = calculateVolume(lavaCount);
            pitch = calculateVolume(lavaCount);
        }
        if (minDistance > MAX_DISTANCE) {
            this.donePlaying = true;
            this.repeat = false;
            Minecraft.getMinecraft().getSoundHandler().stopSound(this);
        }
    }

    private static float calculateVolume(int lavaCount) {
        // Define how the volume should be calculated based on the lava count
        // You might want to normalize it to be within a range (e.g., 0.1 to 1.0)
        if (lavaCount == 1) return 0.001f;
        if (lavaCount == 2) return 0.003f;
        if (lavaCount == 3) return 0.006f;
        else return Math.min(1.0f, 0.01f * lavaCount - 0.03f);
    }
}
