package com.PlanetCore.entity.goals;

import com.PlanetCore.entity.EntityDemon;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySmallFireball;

public class DemonFireBallGoal extends EntityAIBase {
    EntityDemon owner;
    public DemonFireBallGoal(EntityDemon entityDemon) {
        this.owner = entityDemon;
    }

    @Override
    public boolean shouldExecute() {
        EntityLivingBase target = this.owner.getAttackTarget();
        return target != null && target.isEntityAlive() && (!(target instanceof EntityPlayer) || !((EntityPlayer) target).isCreative())
                && this.owner.getRNG().nextInt(15) == 0 && target.getDistanceSq(this.owner) > 25;
    }

    @Override
    public boolean shouldContinueExecuting() {
        EntityLivingBase target = this.owner.getAttackTarget();
        return target != null && target.isEntityAlive() && (!(target instanceof EntityPlayer) || !((EntityPlayer) target).isCreative());
    }

    @Override
    public void startExecuting() {
        this.owner.startFireballAnim();
    }

    @Override
    public void updateTask() {
        if (this.owner.getFireballTick() == 2){
            EntityLivingBase target = this.owner.getAttackTarget();
            
            double d1 = target.posX - this.owner.posX;
            double d2 = target.getEntityBoundingBox().minY + (double)(target.height / 2.0F) - (this.owner.posY + (double)(this.owner.height / 2.0F));
            double d3 = target.posZ - this.owner.posZ;
            
            EntitySmallFireball fireball = new EntitySmallFireball(this.owner.world, this.owner, d1, d2, d3);
            fireball.posY = this.owner.posY + (double)(this.owner.height / 2.0F) + 0.5D;
            this.owner.world.spawnEntity(fireball);
        }
        if (this.owner.getFireballTick() == 6)
        {
            this.owner.stopFireballAnim();
        }
    }
}


