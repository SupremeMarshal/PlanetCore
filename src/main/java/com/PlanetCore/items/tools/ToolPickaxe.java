package com.PlanetCore.items.tools;

import com.PlanetCore.Main;
import com.PlanetCore.init.ModItems;
import com.PlanetCore.util.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ToolPickaxe extends ItemPickaxe implements IHasModel {
	public ToolPickaxe(String name, ToolMaterial material)
	{
		super(material);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
		
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() 
	{
		Main.proxy.registerModel(this, 0);
	}


	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		Item pickaxe = this;
		if (!stack.hasTagCompound()) {

			stack.setTagCompound(new NBTTagCompound());

		}

		if (!stack.getTagCompound().hasKey("HideFlags")) {

			// hides normal info

			stack.getTagCompound().setInteger("HideFlags", 2);

		}
			tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.0"));
			tooltip.add(net.minecraft.client.resources.I18n.format("$9Efficiency: +"+this.efficiency));
			tooltip.add(net.minecraft.client.resources.I18n.format("Durability:"));
			tooltip.add(net.minecraft.client.resources.I18n.format((getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));

	}
}
