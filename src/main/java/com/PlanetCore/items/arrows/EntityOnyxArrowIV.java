package com.PlanetCore.items.arrows;

import com.PlanetCore.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityOnyxArrowIV extends EntityArrow
{


    public EntityOnyxArrowIV(World worldIn)
    {
        super(worldIn);
    }

    public EntityOnyxArrowIV(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public EntityOnyxArrowIV(World worldIn, EntityLivingBase shooter)
    {
        super(worldIn, shooter);
    }

    @Override
    protected ItemStack getArrowStack()
    {
        return new ItemStack(ModItems.ONYX_ARROW_IV);
    }


}