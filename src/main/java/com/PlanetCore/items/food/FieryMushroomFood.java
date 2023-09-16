package com.PlanetCore.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class FieryMushroomFood extends ItemFood {
    public FieryMushroomFood(int amount, float saturation, boolean isWolfFood) {
        super(amount, saturation, isWolfFood);
        // TODO: Set your item properties here
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote) {
            player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 3600, 0)); // 3 minutes of fire resistance
        }
        super.onFoodEaten(stack, worldIn, player);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn)
    {
        if (!worldIn.isRemote) {
            // Start eating animation and sound.
            playerIn.setActiveHand(handIn);
        }
        ItemStack itemstack = playerIn.getHeldItem(handIn);
        return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);
    }
}
