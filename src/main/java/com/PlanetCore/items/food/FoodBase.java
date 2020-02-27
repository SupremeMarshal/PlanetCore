package com.PlanetCore.items.food;

import com.PlanetCore.Main;
import com.PlanetCore.init.ModItems;
import com.PlanetCore.util.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class FoodBase extends ItemFood implements IHasModel
{
    //Amount = food bar // saturation = time to keep stomach full // animal = is for player or animal
    public FoodBase(String name, int amount, float saturation, boolean isAnimalFood)
    {
        super(amount, saturation, isAnimalFood);
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.FOOD);
        ModItems.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerModel(this, 0);
    }
}
