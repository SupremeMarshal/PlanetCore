package com.PlanetCore.asm.mixin;

import com.PlanetCore.util.handlers.GravityHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(EntityLivingBase.class)
public abstract class EntityLivingBaseMixin extends Entity {
    public EntityLivingBaseMixin(World worldIn) {
        super(worldIn);
    }


    @Inject(method = "travel",at = @At(value = "INVOKE",target = "Lnet/minecraft/entity/EntityLivingBase;hasNoGravity()Z",ordinal = 0))
    private void modifyGravity(float strafe, float vertical, float forward, CallbackInfo ci) {
        if (!hasNoGravity()) {
            double gravityMultiplier = GravityHandler.calculateGravityModifier(posY);
            if (gravityMultiplier < 1) {
                motionY += .08 * (1 - gravityMultiplier);
            }
        }
    }
}
