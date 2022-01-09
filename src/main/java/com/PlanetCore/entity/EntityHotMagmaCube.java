package com.PlanetCore.entity;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.*;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityHotMagmaCube extends EntityMagmaCube
{


	public EntityHotMagmaCube(World worldIn)   {
		super(worldIn);
		setSize(0.8f, 2.2f);
		this.isImmuneToFire = true;
	}

	@Override
	public void fall(float distance, float damageMultiplier)
	{
	}

	@Override
	protected void jump()
	{
		this.motionY = (double)(0.96F + (float)this.getSlimeSize() * 0.13F);
		this.isAirBorne = true;
		net.minecraftforge.common.ForgeHooks.onLivingJump(this);
	}

	@Override
	protected int getAttackStrength()
	{
		return super.getAttackStrength() + 8;
	}

	@Override
	protected void handleJumpLava()
	{
		this.motionY = (double)(0.5F + (float)this.getSlimeSize() * 0.07F);
		this.isAirBorne = true;
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
	
	protected Item getDropItem() {
		return null;
	}

	protected float getSoundVolume() {
		return 0.6F;
	}

	
	@Override
	public boolean getCanSpawnHere() {
		if (posY <= -1024) {
			return true;
		} else {
			return false;
		}
	}


	@Override
	public int getMaxSpawnedInChunk() {
		return 3;
	}
	
}
