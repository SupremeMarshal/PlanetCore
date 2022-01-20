package com.PlanetCore.entity;

import com.PlanetCore.util.handlers.LootTableHandler;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

import java.util.Random;

public class EntityCoreBlaze extends EntityBlaze {
    public EntityCoreBlaze(World worldIn) {
        super(worldIn);

        this.setSize(1.2F, 2.4F);
        this.moveHelper = new EntityCoreBlaze.BlazeMoveHelper(this);
        this.setNoGravity(true);
    }

    @Override
    protected void applyEntityAttributes() {
        super.applyEntityAttributes();
        this.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE).setBaseValue(64.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(24.0D);
        this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(400.0D);
        this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(3.0D);
    }

    @Override
    protected void initEntityAI(){
        this.tasks.addTask(5, new EntityCoreBlaze.AIRandomFly(this));
        this.tasks.addTask(4, new EntityCoreBlaze.AIFireballAttack(this));
        // this.tasks.addTask(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
        // this.tasks.addTask(7, new EntityAIWanderAvoidWater(this, 1.0D, 0.0F));
        this.tasks.addTask(3, new EntityAIWatchClosest(this, EntityPlayer.class, 32.0F));
        this.tasks.addTask(8, new EntityAILookIdle(this));
        this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
        this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayer.class, true));
    }

    @Override
    public void onLivingUpdate()
    {
        this.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 0, 3));
        super.onLivingUpdate();
    }

    @Override
    protected boolean canDespawn() {
        return false;
    }

    protected boolean hasAttackTarget(){
        boolean living = this.getAttackTarget() != null && this.getAttackTarget().isEntityAlive();
        if (!living) return false;
        boolean notCreative = !(this.getAttackTarget() instanceof EntityPlayer) || !((EntityPlayer)this.getAttackTarget()).isCreative();
        return living && notCreative;
    }

    // stolen from ghast, added target check
    static class AIRandomFly extends EntityAIBase
    {
        private final EntityCoreBlaze parentEntity;

        public AIRandomFly(EntityCoreBlaze ghast)
        {
            this.parentEntity = ghast;
            this.setMutexBits(1);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute(){
            if (this.parentEntity.hasAttackTarget()) return false;
            if (this.parentEntity.getRNG().nextInt(30) == 0) return true;

            EntityMoveHelper entitymovehelper = this.parentEntity.getMoveHelper();

            if (!entitymovehelper.isUpdating())
            {
                return true;
            }
            else
            {
                double d0 = entitymovehelper.getX() - this.parentEntity.posX;
                double d1 = entitymovehelper.getY() - this.parentEntity.posY;
                double d2 = entitymovehelper.getZ() - this.parentEntity.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;
                return d3 < 1.0D || d3 > 3600.0D;
            }


        }

        /**
         * Returns whether an in-progress EntityAIBase should continue executing
         */
        public boolean shouldContinueExecuting()
        {
            return false;
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            Random random = this.parentEntity.getRNG();

            double d0 = this.parentEntity.posX + (double)((random.nextFloat() - 0.5F) * 64.0F);
            double d1 = this.parentEntity.posY + (double)((random.nextFloat() - 0.5F) * 16.0F);
            double d2 = this.parentEntity.posZ + (double)((random.nextFloat() - 0.5F) * 64.0F);
            for (int i=0;i<16;i++){
                BlockPos go = new BlockPos(d0, d1, d2);
                if (this.parentEntity.world.getBlockState(go).getBlock() == Blocks.AIR){
                    System.out.println("found air");
                    break;
                }

                d0 = this.parentEntity.posX + (double)((random.nextFloat() - 0.5F) * 64.0F);
                d1 = this.parentEntity.posY + (double)((random.nextFloat() - 0.5F) * 16.0F);
                d2 = this.parentEntity.posZ + (double)((random.nextFloat() - 0.5F) * 64.0F);
            }

            this.parentEntity.getMoveHelper().setMoveTo(d0, d1, d2, 1.5D);
        }
    }

    // same as vanilla
    static class AIFireballAttack extends EntityAIBase
    {
        private final EntityBlaze blaze;
        private int attackStep;
        private int attackTime;

        public AIFireballAttack(EntityCoreBlaze blazeIn)
        {
            this.blaze = blazeIn;
            this.setMutexBits(9);
        }

        /**
         * Returns whether the EntityAIBase should begin execution.
         */
        public boolean shouldExecute()
        {
            EntityLivingBase entitylivingbase = this.blaze.getAttackTarget();
            return entitylivingbase != null && entitylivingbase.isEntityAlive();
        }

        /**
         * Execute a one shot task or start executing a continuous task
         */
        public void startExecuting()
        {
            this.attackStep = 0;
            this.blaze.getNavigator().clearPath();
        }

        /**
         * Reset the task's internal state. Called when this task is interrupted by another one
         */
        public void resetTask()
        {
            this.blaze.setOnFire(false);
        }

        /**
         * Keep ticking a continuous task that has already been started
         */
        public void updateTask()
        {
            --this.attackTime;
            EntityLivingBase entitylivingbase = this.blaze.getAttackTarget();
            double d0 = this.blaze.getDistanceSq(entitylivingbase);

            if (d0 < 4.0D)
            {
                if (this.attackTime <= 0)
                {
                    this.attackTime = 20;
                    this.blaze.attackEntityAsMob(entitylivingbase);
                }

                this.blaze.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 1.0D);
            }
            else if (d0 < this.getFollowDistance() * this.getFollowDistance())
            {
                double d1 = entitylivingbase.posX - this.blaze.posX;
                double d2 = entitylivingbase.getEntityBoundingBox().minY + (double)(entitylivingbase.height / 2.0F) - (this.blaze.posY + (double)(this.blaze.height / 2.0F));
                double d3 = entitylivingbase.posZ - this.blaze.posZ;

                if (this.attackTime <= 0)
                {
                    ++this.attackStep;

                    if (this.attackStep == 1)
                    {
                        this.attackTime = 60;
                        this.blaze.setOnFire(true);
                    }
                    else if (this.attackStep <= 4)
                    {
                        this.attackTime = 6;
                    }
                    else
                    {
                        this.attackTime = 100;
                        this.attackStep = 0;
                        this.blaze.setOnFire(false);
                    }

                    if (this.attackStep > 1)
                    {
                        float f = MathHelper.sqrt(MathHelper.sqrt(d0)) * 0.5F;
                        this.blaze.world.playEvent((EntityPlayer)null, 1018, new BlockPos((int)this.blaze.posX, (int)this.blaze.posY, (int)this.blaze.posZ), 0);

                        for (int i = 0; i < 1; ++i)
                        {
                            EntityCoreFireball entitycorefireball = new EntityCoreFireball(this.blaze.world, this.blaze, d1 + this.blaze.getRNG().nextGaussian() * (double)f, d2, d3 + this.blaze.getRNG().nextGaussian() * (double)f);
                            //
                            entitycorefireball.posY = this.blaze.posY + (double)(this.blaze.height / 2.0F) + 0.5D;
                            this.blaze.world.spawnEntity(entitycorefireball);
                        }
                    }
                }

                this.blaze.getLookHelper().setLookPositionWithEntity(entitylivingbase, 10.0F, 10.0F);
            }
            else
            {
                this.blaze.getNavigator().clearPath();
                this.blaze.getMoveHelper().setMoveTo(entitylivingbase.posX, entitylivingbase.posY, entitylivingbase.posZ, 1.0D);
            }

            super.updateTask();
        }

        private double getFollowDistance()
        {
            IAttributeInstance iattributeinstance = this.blaze.getEntityAttribute(SharedMonsterAttributes.FOLLOW_RANGE);
            return iattributeinstance == null ? 16.0D : iattributeinstance.getAttributeValue();
        }
    }

    static class BlazeMoveHelper extends EntityMoveHelper
    {
        private final EntityCoreBlaze parentEntity;
        private int courseChangeCooldown;

        public BlazeMoveHelper(EntityCoreBlaze ghast)
        {
            super(ghast);
            this.parentEntity = ghast;
        }

        public void onUpdateMoveHelper()
        {
            if (this.action == Action.MOVE_TO)
            {
                double d0 = this.posX - this.parentEntity.posX;
                double d1 = this.posY - this.parentEntity.posY;
                double d2 = this.posZ - this.parentEntity.posZ;
                double d3 = d0 * d0 + d1 * d1 + d2 * d2;

                if (this.courseChangeCooldown-- <= 0)
                {
                    this.courseChangeCooldown += this.parentEntity.getRNG().nextInt(5) + 2;
                    d3 = (double)MathHelper.sqrt(d3);

                    if (this.isNotColliding(this.posX, this.posY, this.posZ, d3))
                    {
                        this.parentEntity.motionX += d0 / d3 * 0.1D;
                        this.parentEntity.motionY += d1 / d3 * 0.1D;
                        this.parentEntity.motionZ += d2 / d3 * 0.1D;
                    }
                    else {
                        if (this.parentEntity.hasAttackTarget()) {
                            this.action = Action.WAIT;
                        } else {
                            this.parentEntity.motionY += 0.03;
                        }
                    }
                }
            }
        }

        /**
         * Checks if entity bounding box is not colliding with terrain
         */
        private boolean isNotColliding(double x, double y, double z, double p_179926_7_)
        {
            double d0 = (x - this.parentEntity.posX) / p_179926_7_;
            double d1 = (y - this.parentEntity.posY) / p_179926_7_;
            double d2 = (z - this.parentEntity.posZ) / p_179926_7_;
            AxisAlignedBB axisalignedbb = this.parentEntity.getEntityBoundingBox();

            for (int i = 1; (double)i < p_179926_7_; ++i)
            {
                axisalignedbb = axisalignedbb.offset(d0, d1, d2);

                if (!this.parentEntity.world.getCollisionBoxes(this.parentEntity, axisalignedbb).isEmpty())
                {
                    return false;
                }
            }

            return true;
        }
    }

    @Override
    protected ResourceLocation getLootTable() {
        return LootTableHandler.CORE_BLAZE;
    }

    @Override
    public boolean getCanSpawnHere() {
        if (posY < -1792) {
            return true;
        }
        else return false;
    }

    @Override
    protected boolean isValidLightLevel() {
        return true;
    }


    @Override
    public int getMaxSpawnedInChunk() {
        return 3;
    }


}
