package com.PlanetCore.client;

import com.PlanetCore.util.handlers.PickaxeRelentlessHandler;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;

public class ClientMixinHooks {

    public static void playUnbreakableSounds(BlockPos posBlock, float stepSoundTickCounter, float curBlockDamageMP) {
        //the second is needed otherwise unbreakable sound will play
        if (curBlockDamageMP == 0 && Minecraft.getMinecraft().player.world.getBlockState(posBlock).getMaterial() != Material.AIR) {
            EntityPlayer player = Minecraft.getMinecraft().player;
            if (PickaxeRelentlessHandler.holdingPickaxe(player) && player.world.getTotalWorldTime() % 6 == 1) {
                player.world.playSound(player, player.getPosition(), PickaxeRelentlessHandler.sound[player.getRNG().nextInt(20)], SoundCategory.BLOCKS, 1.0F, 1.0F);
            } else if (player.world.getTotalWorldTime() % 140 == 1) {
                player.sendMessage(new TextComponentString("Block is indestructible!"));
            }
        }
    }
}
