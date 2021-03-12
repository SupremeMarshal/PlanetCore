package com.PlanetCore.items.armor;

import com.PlanetCore.init.ModItems;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
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

public class RingwooditeLegs extends ArmorBase

{

	public RingwooditeLegs(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		// TODO Auto-generated constructor stub
	}
	
	public static final UUID MAX_HEALTH_DIAMONDLEGS_UUID = UUID.fromString("150f4849-6538-46a4-b67f-d23f3b59aa34");
	public static final UUID KNOCKBACK_RESISTANCE_DIAMONDLEGS_UUID = UUID.fromString("4834272d-8e85-4fe4-b828-e00876a88ee2");  
    

    private static final Map<IAttribute, AttributeModifier> modMap = new HashMap<>();
    
    static {

		modMap.put(SharedMonsterAttributes.MAX_HEALTH, new AttributeModifier(MAX_HEALTH_DIAMONDLEGS_UUID, "MAX_HEALTH_DIAMONDLEGS_UUID", 11, 0));
		modMap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE, new AttributeModifier(KNOCKBACK_RESISTANCE_DIAMONDLEGS_UUID, "KNOCKBACK_RESISTANCE_DIAMONDLEGS_UUID", 0.075, 0));
	}
   
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot,

    		ItemStack stack) {

    	Multimap<String, AttributeModifier> mods = super.getAttributeModifiers(slot, stack);
    	
    		
    	if (slot==EntityEquipmentSlot.LEGS) {

    		String maxhealth = SharedMonsterAttributes.MAX_HEALTH.getName();
    		String knockback = SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName();

    		mods.put(maxhealth, new AttributeModifier (MAX_HEALTH_DIAMONDLEGS_UUID, "MAX_HEALTH_DIAMONDLEGS_UUID", 11, 0));
    		mods.put(knockback, new AttributeModifier (KNOCKBACK_RESISTANCE_DIAMONDLEGS_UUID, "KNOCKBACK_RESISTANCE_DIAMONDLEGS_UUID", 0.075, 0));
    	}
    	return mods;
    }

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		if (player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ModItems.DIAMOND_LEGGINGS)
		{
			if (world.getTotalWorldTime() % 150 != 1)
			{
				return;
			}
			player.heal(0.3F);
		}
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
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.0"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.1"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.2"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.3"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.4"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.5"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.6"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.7"));
		tooltip.add(net.minecraft.client.resources.I18n.format("Durability: "+(getMaxDamage() - getDamage(stack)) +" / "+getMaxDamage()));
		tooltip.add(net.minecraft.client.resources.I18n.format("Combine two diamond leggings in the anvil to upgrade it."));
	}
}
