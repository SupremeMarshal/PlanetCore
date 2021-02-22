package com.PlanetCore.entity;

import com.PlanetCore.util.handlers.LootTableHandler;


import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackMelee;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityBlackDemon extends EntityMob
{

	
	public EntityBlackDemon(World worldIn)   {
		super(worldIn);
		setSize(0.6f, 3.6f);
		this.isImmuneToFire = true;
	}

	protected void initEntityAI () 
	{
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, false, false));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
		this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.2, true));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayerMP.class, (float) 12));
		this.tasks.addTask(5, new EntityAIWander(this, 0.6));
		this.tasks.addTask(6, new EntityAILookIdle(this));
		this.tasks.addTask(7, new EntityAISwimming(this));
	}
	
	@Override
	protected void entityInit()  {
		// TODO Auto-generated method stub
		super.entityInit();
	}

	@Override
	public void readEntityFromNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.readEntityFromNBT(compound);
	}

	@Override
	public void writeEntityToNBT(NBTTagCompound compound) {
		// TODO Auto-generated method stub
		super.writeEntityToNBT(compound);	
	}
	
	@Override
	public float getEyeHeight()
	{ return 3.5F; }
	
	protected Item getDropItem() {
		return null;
	}

	@Override
	protected ResourceLocation getLootTable() {
	return LootTableHandler.BLACK_DEMON;
	}
	
	public net.minecraft.util.SoundEvent getAmbientSound() {
		return net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.enderdragon.growl"));
	}

	public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
		return net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.enderdragon.hurt"));
	}

	public net.minecraft.util.SoundEvent getDeathSound() {
		return net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
				"entity.enderdragon_fireball.explode"));
	}

	protected float getSoundVolume() {
		return 0.6F;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();

		this.getAttributeMap().registerAttribute(SharedMonsterAttributes.FLYING_SPEED).setBaseValue(0.3D);

		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(250D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(10.0D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(1.0D);
		this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(32D);
	}

	@Override
	public boolean getCanSpawnHere() {
		if (posY <= -1300) {
			return super.getCanSpawnHere();
		} else {
			return false;
		}
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		if (posY <= -1600 && posY >= -1800) {
			return 2;
		}
		if (posY < -1800 && posY >= -2000) {
			return 3;
		}
		if (posY < -2000 && posY >= -2200) {
			return 5;
		}
		if (posY < -2200 && posY >= -2400) {
			return 7;
		}
		if (posY < -2400 && posY >= -2600) {
			return 9;
		}
		if (posY < -2600 && posY >= -2800) {
			return 12;
		}
		if (posY < -2800 && posY >= -3000) {
			return 15;
		}
		if (posY < -3000) {
			return 20;
		} else {
			return 1;
		}
	}
	
	
}
