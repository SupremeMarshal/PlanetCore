package com.PlanetCore.items.arrows;

import com.PlanetCore.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityOnyxArrowV extends EntityArrow
{


    public EntityOnyxArrowV(World worldIn)
    {
        super(worldIn);
    }

    public EntityOnyxArrowV(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public EntityOnyxArrowV(World worldIn, EntityLivingBase shooter)
    {
        super(worldIn, shooter);
    }

    @Override
    protected ItemStack getArrowStack()
    {
        return new ItemStack(ModItems.ONYX_ARROW_V);
    }


}