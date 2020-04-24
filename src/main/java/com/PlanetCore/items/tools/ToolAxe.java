
package com.PlanetCore.items.tools;

import com.PlanetCore.init.ModItems;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class ToolAxe extends ItemAxe {
	public ToolAxe(String name, ModItems.ToolMaterialCustom material) {
		super(material, 3.0F, -3.5F);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
	}


	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		if (!stack.hasTagCompound()) {

			stack.setTagCompound(new NBTTagCompound());

		}

		if (!stack.getTagCompound().hasKey("HideFlags")) {

			// hides normal info

			stack.getTagCompound().setInteger("HideFlags", 2);

		}
		tooltip.add(net.minecraft.client.resources.I18n.format("When in main hand:"));
		tooltip.add(net.minecraft.client.resources.I18n.format((int)this.attackDamage+" Attack Damage"));
		tooltip.add(net.minecraft.client.resources.I18n.format(this.attackSpeed+" Attack Speed"));
		tooltip.add(net.minecraft.client.resources.I18n.format((int)this.efficiency+" Efficiency"));
		tooltip.add(net.minecraft.client.resources.I18n.format("Durability:" +(getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
	}
}
