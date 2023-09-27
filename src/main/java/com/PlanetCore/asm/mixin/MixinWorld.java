package com.PlanetCore.asm.mixin;

import com.PlanetCore.cwg.PlanetCoreWorldType;
import io.github.opencubicchunks.cubicchunks.api.world.ICubicWorld;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.*;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(World.class)
public abstract class MixinWorld {

    @Shadow @Final public WorldProvider provider;

    @Shadow public abstract WorldType getWorldType();

    @Inject(at = @At("HEAD"), method = "setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/state/IBlockState;I)Z", cancellable = true)
    public void setBlockState(BlockPos pos, IBlockState state, int flags, CallbackInfoReturnable<Boolean> callback) {
        if (!((ICubicWorld) this).isCubicWorld() ||
                !(getWorldType() instanceof PlanetCoreWorldType) ||
                provider.getDimensionType() != DimensionType.OVERWORLD) {
            return;
        }
        if ((state.getBlock() != Blocks.WATER && state.getBlock() != Blocks.FLOWING_WATER) || pos.getY() >= -512) return;
        callback.setReturnValue(false);
        if (!(((Object)this) instanceof WorldServer)) return;
        WorldServer world = (WorldServer)(Object)this;
        if (world.playerEntities.isEmpty()) return;
        WorldServer serverWorld = (WorldServer) (Object) this;
        for (EntityPlayer player : world.playerEntities) {
            if (player.getDistanceSqToCenter(pos) > 8*8) continue;
            world.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (world.rand.nextFloat() - world.rand.nextFloat()) * 0.8F);
            serverWorld.spawnParticle(
                    EnumParticleTypes.SMOKE_LARGE,
                    pos.getX(), pos.getY(), pos.getZ(),
                    8, 1, 1, 1, 0.0);
            return;
        }
    }

}
