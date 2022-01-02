package com.PlanetCore.items.arrows;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class EmeraldArrow extends Item
{
    public EntityEmeraldArrow createArrow(World worldIn, ItemStack stack, EntityLivingBase shooter)
    {
        EntityEmeraldArrow entityEmeraldArrow = new EntityEmeraldArrow(worldIn, shooter);
        return entityEmeraldArrow;
    }

    public boolean isInfinite(ItemStack stack, ItemStack bow, net.minecraft.entity.player.EntityPlayer player)
    {
        int enchant = net.minecraft.enchantment.EnchantmentHelper.getEnchantmentLevel(net.minecraft.init.Enchantments.INFINITY, bow);
        return enchant <= 0 ? false : this.getClass() == EmeraldArrow.class;
    }
}
