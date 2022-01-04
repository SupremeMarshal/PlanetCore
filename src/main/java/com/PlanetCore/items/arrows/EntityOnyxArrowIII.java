package com.PlanetCore.items.arrows;

import com.PlanetCore.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityOnyxArrowIII extends EntityArrow
{


    public EntityOnyxArrowIII(World worldIn)
    {
        super(worldIn);
    }

    public EntityOnyxArrowIII(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public EntityOnyxArrowIII(World worldIn, EntityLivingBase shooter)
    {
        super(worldIn, shooter);
    }

    @Override
    protected ItemStack getArrowStack()
    {
        return new ItemStack(ModItems.ONYX_ARROW_III);
    }


}