package com.PlanetCore.entity;

import com.PlanetCore.util.handlers.LootTableHandler;
import net.minecraft.entity.monster.EntityMagmaCube;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.item.Item;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class EntityHotMagmaCube extends EntityMagmaCube
{

	protected EntityHotMagmaCube createInstance()
	{
		return new EntityHotMagmaCube(this.world);
	}

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
	protected ResourceLocation getLootTable() {
		return LootTableHandler.HOT_MAGMACUBE;
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
		if (posY <= -64 && getEntityWorld().getWorldType().getName() == "PlanetCore") {
			return true;
		} else {
			return false;
		}
	}


	@Override
	public int getMaxSpawnedInChunk() {
		return 3;
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
				EntityHotMagmaCube entityslime = this.createInstance();

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
