package com.PlanetCore.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EntityHotFireball extends net.minecraft.entity.projectile.EntitySmallFireball {
    public EntityHotFireball(World worldIn) {
        super(worldIn);
    }

    @SideOnly(Side.CLIENT)
    public EntityHotFireball(World worldIn, double x, double y, double z, double accelX, double accelY, double accelZ)
    {
        super(worldIn, x, y, z, accelX, accelY, accelZ);
    }

    public EntityHotFireball(World worldIn, EntityLivingBase shooter, double accelX, double accelY, double accelZ)
    {
        super(worldIn, shooter, accelX, accelY, accelZ);
    }

    @Override
    protected void onImpact(RayTraceResult result)
    {
        if (!this.world.isRemote)
        {
            if (result.entityHit != null)
            {
                result.entityHit.attackEntityFrom(DamageSource.GENERIC, 3.0F);
                this.applyEnchantments(this.shootingEntity, result.entityHit);
            }

            boolean flag = net.minecraftforge.event.ForgeEventFactory.getMobGriefingEvent(this.world, this.shootingEntity);
            this.setDead();
        }
    }

}
