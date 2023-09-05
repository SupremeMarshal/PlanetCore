package com.PlanetCore.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemFood;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ThreeEffectFoodItem extends ItemFood {

    PotionEffect effect;
    PotionEffect effect1;
    PotionEffect effect2;

    //Amount = food bar // saturation = time to keep stomach full // animal = is for player or animal
    public ThreeEffectFoodItem(int amount, float saturation, boolean isAnimalFood, PotionEffect effect, PotionEffect effect1, PotionEffect effect2) {
        super(amount, saturation, isAnimalFood);
        setAlwaysEdible();
        this.effect = effect;
        this.effect1 = effect1;
        this.effect2 = effect2;
    }

    @Override
    public ItemFood setAlwaysEdible() {
        return super.setAlwaysEdible();
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player) {
        if (!worldIn.isRemote) {
            player.addPotionEffect(new PotionEffect(effect.getPotion(), effect.getDuration(), effect.getAmplifier(), effect.getIsAmbient(), effect.doesShowParticles()));
            player.addPotionEffect(new PotionEffect(effect1.getPotion(), effect1.getDuration(), effect1.getAmplifier(), effect1.getIsAmbient(), effect1.doesShowParticles()));
            player.addPotionEffect(new PotionEffect(effect2.getPotion(), effect2.getDuration(), effect2.getAmplifier(), effect2.getIsAmbient(), effect2.doesShowParticles()));
        }
    }
}
