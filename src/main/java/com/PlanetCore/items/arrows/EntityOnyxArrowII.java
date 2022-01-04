package com.PlanetCore.items.arrows;

import com.PlanetCore.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityOnyxArrowII extends EntityArrow
{


    public EntityOnyxArrowII(World worldIn)
    {
        super(worldIn);
    }

    public EntityOnyxArrowII(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public EntityOnyxArrowII(World worldIn, EntityLivingBase shooter)
    {
        super(worldIn, shooter);
    }

    @Override
    protected ItemStack getArrowStack()
    {
        return new ItemStack(ModItems.ONYX_ARROW_II);
    }


}