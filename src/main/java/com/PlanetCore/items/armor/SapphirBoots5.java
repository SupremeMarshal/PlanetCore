package com.PlanetCore.items.armor;

import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class SapphirBoots5 extends ArmorBase

{

	public SapphirBoots5(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(name, materialIn, renderIndexIn, equipmentSlotIn);
		// TODO Auto-generated constructor stub
	}
	
	public static final UUID MAX_HEALTH_SAPPHIRBOOTS_UUID = UUID.fromString("39f3e1cd-4f21-4c34-8b0e-c393fdd254c1");
	public static final UUID KNOCKBACK_RESISTANCE_SAPPHIRBOOTS_UUID = UUID.fromString("e474f4b8-2518-4f28-bb41-27aa492a8b31");
    

    private static final Map<IAttribute, AttributeModifier> modMap = new HashMap<>();
    
    static {

		modMap.put(SharedMonsterAttributes.MAX_HEALTH, new AttributeModifier(MAX_HEALTH_SAPPHIRBOOTS_UUID, "MAX_HEALTH_SAPPHIRBOOTS_UUID", 10, 0));
		modMap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE, new AttributeModifier(KNOCKBACK_RESISTANCE_SAPPHIRBOOTS_UUID, "KNOCKBACK_RESISTANCE_SAPPHIRBOOTS_UUID", 0.025, 0));
	}
   
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot,

    		ItemStack stack) {

    	Multimap<String, AttributeModifier> mods = super.getAttributeModifiers(slot, stack);
    	
    		
    	if (slot==EntityEquipmentSlot.FEET) {

    		String maxhealth = SharedMonsterAttributes.MAX_HEALTH.getName();
    		String knockback = SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName();

    		mods.put(maxhealth, new AttributeModifier (MAX_HEALTH_SAPPHIRBOOTS_UUID, "MAX_HEALTH_SAPPHIRBOOTS_UUID", 10, 0));
    		mods.put(knockback, new AttributeModifier (KNOCKBACK_RESISTANCE_SAPPHIRBOOTS_UUID, "KNOCKBACK_RESISTANCE_SAPPHIRBOOTS_UUID", 0.025, 0));
    	}
    	return mods;
    }
	//@Override
	//public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	//{
		//if (player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ModItems.SAPPHIRE_BOOTS)
		//{
			//if (world.getTotalWorldTime() % 300 != 1)
			//{
			//	return;
			//}
			//player.heal(0.15F);
			//heal 0.6 Health per minute
		//}
	//}

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
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.0"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.1"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.2"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.3"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.4"));
		tooltip.add(net.minecraft.client.resources.I18n.format("Durability: "+(getMaxDamage() - getDamage(stack)) +" / "+getMaxDamage()));
	}
}
