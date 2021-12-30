package com.PlanetCore.asm.mixin;

import net.minecraft.entity.passive.EntityAnimal;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

@Mixin(EntityAnimal.class)
public class MixinEntityAnimal {
    @Inject(method = "getCanSpawnHere",
            at = @At(
                    value = "FIELD",
                    target = "Lnet/minecraft/entity/passive/EntityAnimal;world:Lnet/minecraft/world/World;",
                    ordinal = 0
            ),
            locals = LocalCapture.CAPTURE_FAILHARD,
            cancellable = true
    )
    private void minimumSpawnHeight(CallbackInfoReturnable<Boolean> cir, int x, int y, int z) {
        if(y < 0) {
            cir.setReturnValue(false);
        }
        //otherwise, default to the vanilla behaviour
    }
}
