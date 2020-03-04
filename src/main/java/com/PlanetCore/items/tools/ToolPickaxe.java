package com.PlanetCore.items.tools;

import com.PlanetCore.Main;
import com.PlanetCore.init.ModItems;
import com.PlanetCore.util.IHasModel;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
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

		this.addPropertyOverride(new ResourceLocation("holding"), new IItemPropertyGetter() {


			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
				IItemPropertyGetter pickaxe = this;
				if (entityIn == null)
				{
					return 0.0F;
				}
				else

				return entityIn.getHeldItemMainhand().getItem() == ModItems.EMERALD_PICKAXE1
						|| entityIn.getHeldItemMainhand().getItem() == ModItems.EMERALD_PICKAXE2
						|| entityIn.getHeldItemMainhand().getItem() == ModItems.EMERALD_PICKAXE3
						|| entityIn.getHeldItemMainhand().getItem() == ModItems.EMERALD_PICKAXE4
						|| entityIn.getHeldItemMainhand().getItem() == ModItems.EMERALD_PICKAXE5
						|| entityIn.getHeldItemMainhand().getItem() == ModItems.EMERALD_PICKAXE6? 1.0F : 0.0F;
			}
		});
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
