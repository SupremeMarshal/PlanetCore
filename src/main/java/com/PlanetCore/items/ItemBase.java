package com.SupremeMarshal.ToTheEarthCore.items;

import com.SupremeMarshal.ToTheEarthCore.Main;
import com.SupremeMarshal.ToTheEarthCore.init.ModItems;
import com.SupremeMarshal.ToTheEarthCore.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name)
	{
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerModel(this, 0);
	}


}
