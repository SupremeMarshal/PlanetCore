package com.SupremeMarshal.ToTheEarthCore.items.food;

import com.SupremeMarshal.ToTheEarthCore.Main;
import com.SupremeMarshal.ToTheEarthCore.init.ModItems;
import com.SupremeMarshal.ToTheEarthCore.util.IHasModel;
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
