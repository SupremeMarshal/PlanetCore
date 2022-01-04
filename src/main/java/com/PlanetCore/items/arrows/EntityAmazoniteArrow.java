package com.PlanetCore.items.arrows;

import com.PlanetCore.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityAmazoniteArrow extends EntityArrow
{


    public EntityAmazoniteArrow(World worldIn)
    {
        super(worldIn);
    }

    public EntityAmazoniteArrow(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public EntityAmazoniteArrow(World worldIn, EntityLivingBase shooter)
    {
        super(worldIn, shooter);
    }

    @Override
    protected ItemStack getArrowStack()
    {
        return new ItemStack(ModItems.AMAZONITE_ARROW);
    }


}