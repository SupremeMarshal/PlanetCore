package com.PlanetCore.asm.mixin;

import com.PlanetCore.client.ClientMixinHooks;
import net.minecraft.client.multiplayer.PlayerControllerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(PlayerControllerMP.class)
public class PlayerControllerMPMixin {

    @Shadow private float stepSoundTickCounter;

    @Shadow private float curBlockDamageMP;

    @Inject(method = "onPlayerDamageBlock",at = @At(value = "INVOKE",target = "Lnet/minecraft/client/multiplayer/WorldClient;sendBlockBreakProgress(ILnet/minecraft/util/math/BlockPos;I)V"))
    private void hookUnbreakableSounds(BlockPos posBlock, EnumFacing directionFacing, CallbackInfoReturnable<Boolean> cir) {
        ClientMixinHooks.playUnbreakableSounds(this.stepSoundTickCounter,this.curBlockDamageMP);
    }
}
