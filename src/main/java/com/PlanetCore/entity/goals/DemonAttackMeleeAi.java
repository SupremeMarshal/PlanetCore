package com.PlanetCore.entity.goals;

import com.PlanetCore.entity.EntityDemon;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.ai.EntityAIBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.pathfinding.Path;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;


    public class DemonAttackMeleeAi extends EntityAIBase {

        /**
         * An amount of decrementing ticks that allows the entity to attack once the tick reaches 0.
         */
        protected int attackTick;
        /**
         * The speed with which the mob will approach the target
         */
        double speedTowardsTarget;
        /**
         * When true, the mob will continue chasing its target, even if it can't find a path to them right now.
         */
        boolean longMemory;
        /**
         * The PathEntity of our entity.
         */
        Path path;
        private int delayCounter;
        private double targetX;
        private double targetY;
        private double targetZ;
        protected final int attackInterval = 20;
        private int failedPathFindingPenalty = 0;
        private boolean canPenalize = false;

        EntityDemon owner;
        public DemonAttackMeleeAi(EntityDemon entityDemon, double speedIn, boolean useLongMemory) {
            this.owner = entityDemon;
            this.speedTowardsTarget = speedIn;
            this.longMemory = useLongMemory;
            this.setMutexBits(3);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute() {
            EntityLivingBase entitylivingbase = this.owner.getAttackTarget();

            if (entitylivingbase == null) {
                return false;
            } else if (!entitylivingbase.isEntityAlive()) {
                return false;
            } else {
                if (canPenalize) {
                    if (--this.delayCounter <= 0) {
                        this.path = this.owner.getNavigator().getPathToEntityLiving(entitylivingbase);
                        this.delayCounter = 4 + this.owner.getRNG().nextInt(7);
                        return this.path != null;
                    } else {
                        return true;
                    }
                }
                this.path = this.owner.getNavigator().getPathToEntityLiving(entitylivingbase);

                if (this.path != null) {
                    return true;
                } else {
                    return this.getAttackReachSqr(entitylivingbase) >= this.owner.getDistanceSq(entitylivingbase.posX, entitylivingbase.getEntityBoundingBox().minY, entitylivingbase.posZ);
                }
            }
        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting() {
            EntityLivingBase entitylivingbase = this.owner.getAttackTarget();

            if (entitylivingbase == null) {
                return false;
            } else if (!entitylivingbase.isEntityAlive()) {
                return false;
            } else if (!this.longMemory) {
                return !this.owner.getNavigator().noPath();
            } else if (!this.owner.isWithinHomeDistanceFromPosition(new BlockPos(entitylivingbase))) {
                return false;
            } else {
                return !(entitylivingbase instanceof EntityPlayer) || !((EntityPlayer) entitylivingbase).isSpectator() && !((EntityPlayer) entitylivingbase).isCreative();
            }
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting() {
            this.owner.getNavigator().setPath(this.path, this.speedTowardsTarget);
            this.delayCounter = 0;
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask() {
            EntityLivingBase entitylivingbase = this.owner.getAttackTarget();

            if (entitylivingbase instanceof EntityPlayer && (((EntityPlayer) entitylivingbase).isSpectator() || ((EntityPlayer) entitylivingbase).isCreative())) {
                this.owner.setAttackTarget((EntityLivingBase) null);
            }

            this.owner.getNavigator().clearPath();
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask() {
            EntityLivingBase entitylivingbase = this.owner.getAttackTarget();
            this.owner.getLookHelper().setLookPositionWithEntity(entitylivingbase, 30.0F, 30.0F);
            double d0 = this.owner.getDistanceSq(entitylivingbase.posX, entitylivingbase.getEntityBoundingBox().minY, entitylivingbase.posZ);
            --this.delayCounter;

            if ((this.longMemory || this.owner.getEntitySenses().canSee(entitylivingbase)) && this.delayCounter <= 0 && (this.targetX == 0.0D && this.targetY == 0.0D && this.targetZ == 0.0D || entitylivingbase.getDistanceSq(this.targetX, this.targetY, this.targetZ) >= 1.0D || this.owner.getRNG().nextFloat() < 0.05F)) {
                this.targetX = entitylivingbase.posX;
                this.targetY = entitylivingbase.getEntityBoundingBox().minY;
                this.targetZ = entitylivingbase.posZ;
                this.delayCounter = 4 + this.owner.getRNG().nextInt(7);

                if (this.canPenalize) {
                    this.delayCounter += failedPathFindingPenalty;
                    if (this.owner.getNavigator().getPath() != null) {
                        net.minecraft.pathfinding.PathPoint finalPathPoint = this.owner.getNavigator().getPath().getFinalPathPoint();
                        if (finalPathPoint != null && entitylivingbase.getDistanceSq(finalPathPoint.x, finalPathPoint.y, finalPathPoint.z) < 1)
                            failedPathFindingPenalty = 0;
                        else
                            failedPathFindingPenalty += 10;
                    } else {
                        failedPathFindingPenalty += 10;
                    }
                }

                if (d0 > 1024.0D) {
                    this.delayCounter += 10;
                } else if (d0 > 256.0D) {
                    this.delayCounter += 5;
                }

                if (!this.owner.getNavigator().tryMoveToEntityLiving(entitylivingbase, this.speedTowardsTarget)) {
                    this.delayCounter += 15;
                }
            }

            this.attackTick = Math.max(this.attackTick - 1, 0);
            this.checkAndPerformAttack(entitylivingbase, d0);
        }

        protected void checkAndPerformAttack(EntityLivingBase enemy, double distToEnemySqr) {
            double d0 = this.getAttackReachSqr(enemy);

            if (distToEnemySqr <= d0 && this.attackTick <= 0) {
                this.attackTick = 20;
                this.owner.startAttackAnim();
                this.owner.swingArm(EnumHand.MAIN_HAND);
                this.owner.attackEntityAsMob(enemy);
            }
        }

        protected double getAttackReachSqr(EntityLivingBase attackTarget) {
            return (double) (this.owner.width * 2.0F * this.owner.width * 2.0F + attackTarget.width);
        }
    }
