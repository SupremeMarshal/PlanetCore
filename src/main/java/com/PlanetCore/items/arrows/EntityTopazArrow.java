package com.PlanetCore.items.arrows;

import com.PlanetCore.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityTopazArrow extends EntityArrow
{


    public EntityTopazArrow(World worldIn)
    {
        super(worldIn);
    }

    public EntityTopazArrow(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public EntityTopazArrow(World worldIn, EntityLivingBase shooter)
    {
        super(worldIn, shooter);
    }

    @Override
    protected ItemStack getArrowStack()
    {
        return new ItemStack(ModItems.TOPAZ_ARROW);
    }


}