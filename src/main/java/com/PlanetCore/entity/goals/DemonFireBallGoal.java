package com.PlanetCore.entity.goals;

import com.PlanetCore.entity.EntityDemon;
import com.PlanetCore.entity.EntityHotLargeFireball;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;

public class DemonFireBallGoal extends EntityAIBase {
    EntityDemon owner;
    public DemonFireBallGoal(EntityDemon entityDemon) {
        this.owner = entityDemon;
    }

    @Override
    public boolean shouldExecute()
    {
        EntityLivingBase entitylivingbase = this.owner.getAttackTarget();
        return entitylivingbase != null && entitylivingbase.isEntityAlive() && !this.owner.onGround;
    }

    @Override
    public boolean shouldContinueExecuting() {
        EntityLivingBase entitylivingbase = this.owner.getAttackTarget();
        return entitylivingbase != null && entitylivingbase.isEntityAlive() && !this.owner.onGround;
    }

    @Override
    public void startExecuting() {
    }

    private int attackStep;
    private int attackTime;
    private double getFollowDistance()
    {
        IAttributeInstance iattributeinstance = this.owner.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
        return iattributeinstance == null ? 16.0D : iattributeinstance.getAttributeValue();
    }

    public void updateTask()
    {
        --this.attackTime;
        EntityLivingBase entitylivingbase = this.owner.getAttackTarget();
        double d0 = this.owner.getDistanceSq(entitylivingbase);

        if (d0 < 4.0D)
        {
            if (this.attackTime <= 0)
            {
                this.attackTime = 20;
                this.owner.attackEntityAsMob(entitylivingbase);
            }

            this.owner.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 1.0D);
        }
        else if (d0 < this.getFollowDistance() * this.getFollowDistance())
        {
            double d1 = entitylivingbase.posX - this.owner.posX;
            double d2 = entitylivingbase.getEntityBoundingBox().minY + (double)(entitylivingbase.height / 2.0F) - (this.owner.posY + (double)(this.owner.height / 2.0F));
            double d3 = entitylivingbase.posZ - this.owner.posZ;

            if (this.attackTime <= 0)
            {
                ++this.attackStep;

                if (this.attackStep == 1)
                {
                    this.attackTime = 30;
                }
                else if (this.attackStep <= 2)
                {
                    this.attackTime = 6;
                    this.owner.startFireballAnim();
                }
                else
                {
                    this.attackTime = 50;
                    this.attackStep = 0;
                }

                if (this.attackStep > 1)
                {
                    float f = MathHelper.sqrt(MathHelper.sqrt(d0)) * 0.5F;
                    this.owner.world.playEvent((EntityPlayer)null, 1018, new BlockPos((int)this.owner.posX, (int)this.owner.posY, (int)this.owner.posZ), 0);

                        EntityHotLargeFireball entityhotlargefireball = new EntityHotLargeFireball(this.owner.world, this.owner, d1, d2+1, d3);
                        //
                        this.owner.world.spawnEntity(entityhotlargefireball);
                }
            }

            this.owner.getLookHelper().setLookPositionWithEntity(entitylivingbase, 10.0F, 10.0F);
        }
        else
        {
            this.owner.getNavigator().clearPath();
            this.owner.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 1.0D);
        }

        super.updateTask();
    }
}


