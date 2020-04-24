package com.PlanetCore.items;

import com.PlanetCore.Main;
import com.PlanetCore.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item  {

	public ItemBase(String name)
	{
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		
		ModItems.ITEMS.add(this);
	}

	public enum ItemOreType {
		SHARD,
		ORE
	}
	
	public enum Size {
		VERYSMALL(1, ItemBase.ItemOreType.SHARD),
		SMALL(3, ItemBase.ItemOreType.SHARD),
		NORMAL(1, ItemBase.ItemOreType.ORE),
		COMPACT(3, ItemBase.ItemOreType.ORE),
		VERYCOMPACT(9, ItemBase.ItemOreType.ORE);

		private final int quantityDropped;
		private final ItemBase.ItemOreType type;

		Size(int quantityDropped, ItemBase.ItemOreType type) {
			this.quantityDropped = quantityDropped;
			this.type = type;
		}

		public int quantityDropped() {
			return quantityDropped;
		}

		public ItemBase.ItemOreType getType() {
			return this.type;
		}
	}


}
