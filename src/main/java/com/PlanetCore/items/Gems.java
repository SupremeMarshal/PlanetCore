package com.PlanetCore.items;

import com.PlanetCore.Main;
import com.PlanetCore.init.ModItems;
import com.PlanetCore.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Gems extends Item implements IHasModel {

	public Gems(String name)
	{
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MISC);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerModel(this, 0);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack par1ItemStack) {
		return true;
	}
}
