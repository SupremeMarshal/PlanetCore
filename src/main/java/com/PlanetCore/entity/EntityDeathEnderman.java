package com.SupremeMarshal.ToTheEarthCore.entity;

import com.SupremeMarshal.ToTheEarthCore.util.handlers.LootTableHandler;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityDeathEnderman extends EntityEnderman
{


	public EntityDeathEnderman(World worldIn)   {
		super(worldIn);
		setSize(0.9f, 2.0f);
		this.isImmuneToFire = true;
	}

	protected void initEntityAI () 
	{
		this.targetTasks.addTask(1, new EntityAINearestAttackableTarget(this, EntityPlayerMP.class, false, false));
		this.targetTasks.addTask(2, new EntityAIHurtByTarget(this, true));
		this.tasks.addTask(3, new EntityAIAttackMelee(this, 1.0, true));
		this.tasks.addTask(4, new EntityAIWatchClosest(this, EntityPlayerMP.class, (float) 18));
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
	protected ResourceLocation getLootTable() {
	return LootTableHandler.DEATH_ENDERMAN;
	}
	
	@Override
	public float getEyeHeight()
	{ return 1.0F; }
	
	protected Item getDropItem() {
		return null;
	}

	public net.minecraft.util.SoundEvent getAmbientSound() {
		return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.enderman.ambient"));
	}

	public net.minecraft.util.SoundEvent getHurtSound(DamageSource ds) {
		return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation("entity.enderman.hurt"));
	}

	public net.minecraft.util.SoundEvent getDeathSound() {
		return (net.minecraft.util.SoundEvent) net.minecraft.util.SoundEvent.REGISTRY.getObject(new ResourceLocation(
				"entity.enderman.death"));
	}

	protected float getSoundVolume() {
		return 2.0F;
	}
	
	@Override
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.5D);
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(60D);
		this.getEntityAttribute(SharedMonsterAttributes.KNOCKBACK_RESISTANCE).setBaseValue(0.8D);
		if (this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE) != null)
			this.getEntityAttribute(SharedMonsterAttributes.ATTACK_DAMAGE).setBaseValue(8D);
	}

	@Override
	public boolean getCanSpawnHere() {
		if (posY <= -400) {
			return super.getCanSpawnHere();
		} else {
			return false;
		}
	}
	
	@Override
	public int getMaxSpawnedInChunk() {
		if (posY <= -600 && posY >= -800) {
			return 3;
		}
		if (posY < -800 && posY >= -1000) {
			return 4;
		}
		if (posY < -1000 && posY >= -1200) {
			return 6;
		}
		if (posY < -1200 && posY >= -1400) {
			return 8;
		}
		if (posY < -1400 && posY >= -1600) {
			return 12;
		}
		if (posY < -1600 && posY >= -1800) {
			return 16;
		}
		if (posY < -1800 && posY >= -2000) {
			return 20;
		}
		if (posY < -2000) {
			return 25;
		} else {
			return 1;
		}
	}
	
	
}
