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

public class SapphirBody6 extends ArmorBase

{

	public SapphirBody6(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(name, materialIn, renderIndexIn, equipmentSlotIn);
		// TODO Auto-generated constructor stub
	}

	public static final UUID MAX_HEALTH_SAPPHIRBODY_UUID = UUID.fromString("75ec8f54-9ecd-4b44-b9b9-546e2dd63560");
	public static final UUID KNOCKBACK_RESISTANCE_SAPPHIRBODY_UUID = UUID.fromString("0a0a8dcf-d27c-448c-8a1f-6a4cc1961f61");


    private static final Map<IAttribute, AttributeModifier> modMap = new HashMap<>();

    static {

		modMap.put(SharedMonsterAttributes.MAX_HEALTH, new AttributeModifier(MAX_HEALTH_SAPPHIRBODY_UUID, "MAX_HEALTH_SAPPHIRBODY_UUID", 21, 0));
		modMap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE, new AttributeModifier(KNOCKBACK_RESISTANCE_SAPPHIRBODY_UUID, "KNOCKBACK_RESISTANCE_SAPPHIRBODY_UUID", 0.05, 0));
	}

    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot,

    		ItemStack stack) {

    	Multimap<String, AttributeModifier> mods = super.getAttributeModifiers(slot, stack);


    	if (slot==EntityEquipmentSlot.CHEST) {

    		String maxhealth = SharedMonsterAttributes.MAX_HEALTH.getName();
    		String knockbackplatinumbody = SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName();

    		mods.put(maxhealth, new AttributeModifier (MAX_HEALTH_SAPPHIRBODY_UUID, "MAX_HEALTH_SAPPHIRBODY_UUID", 21, 0));
    		mods.put(knockbackplatinumbody, new AttributeModifier (KNOCKBACK_RESISTANCE_SAPPHIRBODY_UUID, "KNOCKBACK_RESISTANCE_SAPPHIRBODY_UUID", 0.05, 0));
    	}
    	return mods;
    }

	//@Override
	//public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	//{

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
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.5"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.6"));
		tooltip.add(net.minecraft.client.resources.I18n.format("Durability:"));
		tooltip.add(net.minecraft.client.resources.I18n.format((getMaxDamage() - getDamage(stack)) +" / "+getMaxDamage()));
	}
}
