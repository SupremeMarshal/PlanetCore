package com.SupremeMarshal.ToTheEarthCore.items.food;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class EnchantedFoodEffectBase1 extends FoodBase
{

    PotionEffect effect;
    PotionEffect effect1;
    PotionEffect effect2;
    PotionEffect effect3;
    PotionEffect effect4;
    PotionEffect effect5;
    PotionEffect effect6;
    PotionEffect effect7;

    //Amount = food bar // saturation = time to keep stomach full // animal = is for player or animal
    public EnchantedFoodEffectBase1(String name, int amount, float saturation, boolean isAnimalFood, PotionEffect effect, PotionEffect effect1, PotionEffect effect2, PotionEffect effect3, PotionEffect effect4, PotionEffect effect5, PotionEffect effect6, PotionEffect effect7)
    {
        super(name, amount, saturation, isAnimalFood);
        setAlwaysEdible();
        this.effect = effect;
        this.effect1 = effect1;
        this.effect2 = effect2;
        this.effect3 = effect3;
        this.effect4 = effect4;
        this.effect5 = effect5;
        this.effect6 = effect6;
        this.effect7 = effect7;
    }

    @Override
    protected void onFoodEaten(ItemStack stack, World worldIn, EntityPlayer player)
    {
        if (!worldIn.isRemote)
        {
        player.addPotionEffect(new PotionEffect(effect.getPotion(), effect.getDuration(), effect.getAmplifier(), effect.getIsAmbient(), effect.doesShowParticles()));
        player.addPotionEffect(new PotionEffect(effect1.getPotion(), effect1.getDuration(), effect1.getAmplifier(), effect1.getIsAmbient(), effect1.doesShowParticles()));
        player.addPotionEffect(new PotionEffect(effect2.getPotion(), effect2.getDuration(), effect2.getAmplifier(), effect2.getIsAmbient(), effect2.doesShowParticles()));
        player.addPotionEffect(new PotionEffect(effect3.getPotion(), effect3.getDuration(), effect3.getAmplifier(), effect3.getIsAmbient(), effect3.doesShowParticles()));
        player.addPotionEffect(new PotionEffect(effect4.getPotion(), effect4.getDuration(), effect4.getAmplifier(), effect4.getIsAmbient(), effect4.doesShowParticles()));
        player.addPotionEffect(new PotionEffect(effect5.getPotion(), effect5.getDuration(), effect5.getAmplifier(), effect5.getIsAmbient(), effect5.doesShowParticles()));
        player.addPotionEffect(new PotionEffect(effect6.getPotion(), effect6.getDuration(), effect6.getAmplifier(), effect6.getIsAmbient(), effect6.doesShowParticles()));
        player.addPotionEffect(new PotionEffect(effect7.getPotion(), effect7.getDuration(), effect7.getAmplifier(), effect7.getIsAmbient(), effect7.doesShowParticles()));
        }


    }

    @SideOnly(Side.CLIENT)
    public boolean hasEffect(ItemStack stack)
    {
        return true;
    }
}
