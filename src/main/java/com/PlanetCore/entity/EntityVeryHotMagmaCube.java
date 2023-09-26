package com.PlanetCore.entity;

import com.PlanetCore.util.handlers.LootTableHandler;
import net.minecraft.entity.Entity;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityVeryHotMagmaCube extends EntityMagmaCube
{
	protected EntityVeryHotMagmaCube createInstance()
	{
		return new EntityVeryHotMagmaCube(this.world);
	}

	public EntityVeryHotMagmaCube(World worldIn)   {
		super(worldIn);
		setSize(1.0f, 2.4f);
		this.isImmuneToFire = true;
	}

	@Override
	public void fall(float distance, float damageMultiplier)
	{
	}

	@Override
	protected ResourceLocation getLootTable() {
		return LootTableHandler.VERY_HOT_MAGMACUBE;
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
		return super.getAttackStrength() + 16;
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
	protected void applyEntityAttributes() {
		super.applyEntityAttributes();
		this.getEntityAttribute(SharedMonsterAttributes.MAX_HEALTH).setBaseValue(200D);
		this.getEntityAttribute(SharedMonsterAttributes.ARMOR).setBaseValue(3.0D);
		this.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 999999999, 5));

	}

	@Override
	protected boolean canDamagePlayer()
	{
		return true;
	}

	@Override
	public boolean getCanSpawnHere() {
		if (posY <= -2500 && posY > -8000 && getEntityWorld().getWorldType().getName() == "PlanetCore") {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public int getMaxSpawnedInChunk() {
		return 5;
	}

	@Override
	public void setDead()
	{
		int i = this.getSlimeSize();

		if (!this.world.isRemote && i > 1 && this.getHealth() <= 0.0F)
		{
			int j = 2 + this.rand.nextInt(3);

			for (int k = 0; k < j; ++k)
			{
				float f = ((float)(k % 2) - 0.5F) * (float)i / 4.0F;
				float f1 = ((float)(k / 2) - 0.5F) * (float)i / 4.0F;
				EntityVeryHotMagmaCube entityslime = this.createInstance();

				if (this.hasCustomName())
				{
					entityslime.setCustomNameTag(this.getCustomNameTag());
				}

				if (this.isNoDespawnRequired())
				{
					entityslime.enablePersistence();
				}

				entityslime.setSlimeSize(i / 2, true);
				entityslime.setLocationAndAngles(this.posX + (double)f, this.posY + 0.5D, this.posZ + (double)f1, this.rand.nextFloat() * 360.0F, 0.0F);
				this.world.spawnEntity(entityslime);
			}
		}

		super.setDead();
	}
}
