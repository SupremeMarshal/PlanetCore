package com.PlanetCore.items.arrows;

import com.PlanetCore.init.ModItems;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EntityDiamondArrow extends EntityArrow
{


    public EntityDiamondArrow(World worldIn)
    {
        super(worldIn);
    }

    public EntityDiamondArrow(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

    public EntityDiamondArrow(World worldIn, EntityLivingBase shooter)
    {
        super(worldIn, shooter);
    }

    @Override
    protected ItemStack getArrowStack()
    {
        return new ItemStack(ModItems.DIAMOND_ARROW);
    }


}