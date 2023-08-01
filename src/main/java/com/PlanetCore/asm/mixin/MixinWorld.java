package com.PlanetCore.asm.mixin;

import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(World.class)
public abstract class MixinWorld {

    @Shadow public abstract boolean setBlockToAir(BlockPos pos);

    @Inject(at = @At("HEAD"), method = "setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/state/IBlockState;I)Z", cancellable = true, remap = false)
    public void setBlockState(BlockPos pos, IBlockState state, int flags, CallbackInfoReturnable<Boolean> callback) {
        if (state.getBlock() != Blocks.WATER || pos.getY() >= -512) return;
        callback.setReturnValue(true);
        if (!(((Object)this) instanceof WorldServer)) return;
        WorldServer world = (WorldServer)(Object)this;
        if (world.playerEntities.isEmpty()) return;
        for (EntityPlayer player : world.playerEntities) {
            if (player.getDistanceSqToCenter(pos) > 16) continue;
            world.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
            for (int k = 0; k < 8; ++k) {
                world.spawnParticle(EnumParticleTypes.SMOKE_LARGE,
                        pos.getX() + Math.random(), pos.getY() + Math.random(), pos.getZ() + Math.random(), 0.0D, 0.0D, 0.0D);
            }
            return;
        }
    }

}
