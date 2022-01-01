package com.PlanetCore.entity;

import com.PlanetCore.entity.goals.DemonAttackMeleeAi;
import com.PlanetCore.entity.goals.DemonFireBallGoal;
import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.util.handlers.LootTableHandler;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Random;

public class EntityDemon extends EntityMob implements IAnimatable {
	public EntityDemon(World worldIn)   {
		super(worldIn);
		setSize(2f, 3f);
		this.isImmuneToFire = true;
		//this.setNoGravity(true);
	}

	private static final DataParameter<Integer> TEXTURE = EntityDataManager.<Integer>createKey(EntityDemon.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> ATTACK_TICK = EntityDataManager.<Integer>createKey(EntityDemon.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> FLY_TICK = EntityDataManager.<Integer>createKey(EntityDemon.class, DataSerializers.VARINT);
	private static final DataParameter<Integer> FIREBALL_TICK = EntityDataManager.<Integer>createKey(EntityDemon.class, DataSerializers.VARINT);

	public int getTextureType(){
		return this.dataManager.get(TEXTURE);
	}

	@Override
	public void onAddedToWorld() {
		super.onAddedToWorld();
		if (this.getTextureType() == -1){
			this.dataManager.set(TEXTURE, rand.nextInt(2));
		}
	}


	@Override
	public void onLivingUpdate() {
		super.onLivingUpdate();
		int random = rand.nextInt(40);
		if (random == 40) this.jump();
		if (this.onGround) this.dataManager.set(FLY_TICK, 0);
		if (!this.onGround) this.dataManager.set(FLY_TICK, 1);
		if (this.getAttackTick() > 0){
			this.dataManager.set(ATTACK_TICK, this.getAttackTick() - 1);
		}
		if (this.getFireballTick() > 0){
			this.dataManager.set(FIREBALL_TICK, this.getFireballTick() - 1);
		}
	}

	protected void initEntityAI () {
		this.tasks.addTask(5, new EntityDemon.AIRandomFly(this));
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, false, false));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
		this.tasks.addTask(3, new DemonAttackMeleeAi(this, 1.0, true));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayerMP.class, (float) 12));
		this.tasks.addTask(5, new EntityAIWander(this, 0.6));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(7, new EntityAISwimming(this));
		this.tasks.addTask(3, new DemonFireBallGoal(this));
	}
	
	@Override
	protected void entityInit()  {
		super.entityInit();
		this.dataManager.register(TEXTURE, -1);
		this.dataManager.register(FIREBALL_TICK, 0);
		this.dataManager.register(ATTACK_TICK, 0);
		this.dataManager.register(FLY_TICK, 0);
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		super.readEntityFromNBT(compound);
		this.dataManager.set(TEXTURE, compound.getInteger("texture"));
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		super.writeEntityToNBT(compound);
		compound.setInteger("texture", this.getTextureType());
	}
	
	@Override
	protected ResourceLocation getLootTable() {
	return LootTableHandler.DEMON;
	}
	
	@Override
	public float getEyeHeight()
	{ return 3.0F; }
	
	protected Item getDropItem() {
		return null;
	}

	public net.minecraft.util.SoundEvent getAmbientSound() {
		return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.enderdragon.growl"));
	}

	public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
		return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.enderdragon.hurt"));
	}

	public net.minecraft.util.SoundEvent getDeathSound() {
		return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
				"entity.enderdragon_fireball.explode"));
	}

	@Override
	public boolean getCanSpawnHere() {
		if (posY < -1024 && posY >= -6144) {
			return super.getCanSpawnHere();
		} else {
			return false;
		}
	}

	@Override
	protected boolean canDespawn() {
		return false;
	}

	@Override
	protected boolean isValidLightLevel() {
		return true;
	}

	@Override
	public int getMaxSpawnedInChunk() {
		if (posY < -1024 && posY >= -2048) {
			return 1;
		}
		else if (posY < -2048 && posY >= -3072) {
			return 4;
		}
		else if (posY < -3072 && posY >= -4096) {
			return 8;
		}
		else if (posY < -4096 && posY >= -5120) {
			return 4;
		}
		else if (posY < -5120 && posY >= -6144) {
			return 1;
		}
		else return 0;
	}
	
	
	
	protected float getSoundVolume() {
		return 0.6F;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.4D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(120D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(5.0D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(80.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(12D);
		this.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 999999999, 8));
	}


	// GECKOLIB ANIMATIONS

	AnimationFactory factory = new AnimationFactory(this);
	@Override
	public void registerControllers(AnimationData animationData) {
		animationData.addAnimationController(new AnimationController(this, "movementController", 0, this::predicate));
	}

	@Override
	public AnimationFactory getFactory() {
		return this.factory;
	}

	private <E extends IAnimatable> PlayState predicate(AnimationEvent<E> event) {

		if (this.getFireballTick() > 0){
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.demon.fireball", true));
			return PlayState.CONTINUE;
		}

		if (this.getAttackTick() > 0){
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.demon.punch", true));
			return PlayState.CONTINUE;
		}

		if (this.getAttackTick() == 0 && this.getFireballTick() == 0 && this.getFlyTick() > 0){
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.demon.flying", true));
			return PlayState.CONTINUE;
		}

		if (this.getAttackTick() > 0 && this.getFireballTick() == 0 && this.getFlyTick() > 0){
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.demon.fly_attack", true));
			return PlayState.CONTINUE;
		}

		if (!(event.getLimbSwingAmount() > -0.15F && event.getLimbSwingAmount() < 0.15F)) {
			event.getController().setAnimation(new AnimationBuilder().addAnimation("animation.demon.walk", true));
			return PlayState.CONTINUE;
		}

		return PlayState.STOP;
	}

	public void startFireballAnim() {
		this.dataManager.set(FIREBALL_TICK, 14);
	}

	public void stopFireballAnim() {
		this.dataManager.set(FIREBALL_TICK, 0);
	}

	public void startAttackAnim() {
		this.dataManager.set(ATTACK_TICK, 40);
	}

	public void stopAttackAnim() {
		this.dataManager.set(ATTACK_TICK, 0);
	}

	public int getFireballTick() {
		return this.dataManager.get(FIREBALL_TICK);
	}

	public int getAttackTick() {
		return this.dataManager.get(ATTACK_TICK);
	}

	public int getFlyTick() {
		return this.dataManager.get(FLY_TICK);
	}

	// stolen from ghast, added target check
	static class AIRandomFly extends EntityAIBase
	{
		private final EntityDemon parentEntity;

		public AIRandomFly(EntityDemon ghast)
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
				if (this.parentEntity.world.getBlockState(go).getBlock() == Blocks.AIR || this.parentEntity.world.getBlockState(go).getBlock() == ModBlocks.AIR_NO_PRESSURE){
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

	protected boolean hasAttackTarget(){
		boolean living = this.getAttackTarget() != null && this.getAttackTarget().isEntityAlive();
		if (!living) return false;
		boolean notCreative = !(this.getAttackTarget() instanceof EntityPlayer) || !((EntityPlayer)this.getAttackTarget()).isCreative();
		return living && notCreative;
	}
}
