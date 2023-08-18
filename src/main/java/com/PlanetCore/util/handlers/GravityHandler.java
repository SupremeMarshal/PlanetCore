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

    public static double gravityLevel = 1;
    public static double jumpLevel = 1;
    private int fallingTicks;

    public void incrementFallingTicks() {
        fallingTicks++;
    }

    public int getFallingTicks() {
        return fallingTicks;
    }

    public boolean isPlayerInLiquid(EntityPlayer player, Material material) {
        BlockPos playerPosition = player.getPosition();
        IBlockState blockState = player.world.getBlockState(playerPosition);

        return blockState.getMaterial() == material;
    }

    // Usage example

    @SubscribeEvent
    public void onPlayerTick(TickEvent.PlayerTickEvent event) {
        EntityPlayer player = event.player;
        boolean inWater = isPlayerInLiquid(player, Material.WATER);
        boolean inLava = isPlayerInLiquid(player, Material.LAVA);
        if (player.capabilities.isFlying || inWater || inLava) return;
        boolean isJumping = player.motionY > 0 && !player.onGround;
        // Modify player motion based on Y position
        boolean isFalling = player.motionY < 0 && !player.onGround;
        if (isFalling) incrementFallingTicks();
        else fallingTicks = 0;
        gravityLevel = calculateGravityModifier(player.posY);
        if (!isJumping) player.motionY *= gravityLevel;
        if (isFalling) player.motionY -= (0.0005 / gravityLevel) * fallingTicks;
        if (player.motionY < -5) player.motionY = -5;
        if (player.motionY > 3) player.motionY = 3;
    }

    private double calculateGravityModifier(double yPosition) {
        if (yPosition >= 0) {
            return 1.0;
        }
        double minY = -5000;
        double maxY = 0;
        double yRange = maxY - minY;
        // Calculate the normalized Y position within the range
        double normalizedYPos = (yPosition - minY) / yRange;
        return normalizedYPos;
    }

    @SubscribeEvent
    public void onPlayerJump(LivingEvent.LivingJumpEvent event)
    {
        double jumpHeightMultiplier = jumpLevel + (-0.0005 * event.getEntityLiving().posY);
        event.getEntityLiving().motionY *= jumpHeightMultiplier;
    }

    @SubscribeEvent
    public void onPlayerFall(LivingFallEvent event)
    {
        // Increase falling speed when gravity is low
        double modifiedFallDistance = event.getDistance() / gravityLevel;

        // Apply the modified fall distance
        event.setDistance((float) modifiedFallDistance);
    }
}
