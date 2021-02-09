package com.PlanetCore.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EightEffectFoodItem extends SixEffectFoodItem {
    PotionEffect effect6;
    PotionEffect effect7;

    //Amount = food bar // saturation = time to keep stomach full // animal = is for player or animal
    public EightEffectFoodItem(int amount, float saturation, boolean isAnimalFood, PotionEffect effect, PotionEffect effect1, PotionEffect effect2, PotionEffect effect3, PotionEffect effect4, PotionEffect effect5, PotionEffect effect6, PotionEffect effect7) {
        super(amount, saturation, isAnimalFood, effect, effect1, effect2, effect3, effect4, effect5);
        this.effect6 = effect6;
        this.effect7 = effect7;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        super.onFoodEaten(stack, worldIn, player);
        if (!worldIn.isRemote) {
        player.addPotionEffect(new PotionEffect(effect6.getPotion(), effect6.getDuration(), effect6.getAmplifier(), effect6.getIsAmbient(), effect6.doesShowParticles()));
        player.addPotionEffect(new PotionEffect(effect7.getPotion(), effect7.getDuration(), effect7.getAmplifier(), effect7.getIsAmbient(), effect7.doesShowParticles()));
        }


    }
}
