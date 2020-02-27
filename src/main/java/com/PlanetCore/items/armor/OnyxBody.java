package com.PlanetCore.items.armor;

import com.PlanetCore.init.ModItems;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class OnyxBody extends ArmorBase

{

	public OnyxBody(String name, ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(name, materialIn, renderIndexIn, equipmentSlotIn);
		// TODO Auto-generated constructor stub
	}
	
	public static final UUID MAX_HEALTH_ONYXBODY_UUID = UUID.fromString("3deeaf1b-5493-4fb9-b9ad-39d51225347c");
	public static final UUID KNOCKBACK_RESISTANCE_ONYXBODY_UUID = UUID.fromString("e7a5098c-273f-4b5c-9293-9fd74d678ff3");
    

    private static final Map<IAttribute, AttributeModifier> modMap = new HashMap<>();
    
    static {

		modMap.put(SharedMonsterAttributes.MAX_HEALTH, new AttributeModifier(MAX_HEALTH_ONYXBODY_UUID, "MAX_HEALTH_ONYXBODY_UUID", 18, 0));
		modMap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE, new AttributeModifier(KNOCKBACK_RESISTANCE_ONYXBODY_UUID, "KNOCKBACK_RESISTANCE_ONYXBODY_UUID", 0.15, 0));
	}
   @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot,

    		ItemStack stack) {

    	Multimap<String, AttributeModifier> mods = super.getAttributeModifiers(slot, stack);
    	
    		
    	if (slot==EntityEquipmentSlot.CHEST) {

    		String maxhealth = SharedMonsterAttributes.MAX_HEALTH.getName();
    		String knockback = SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName();

    		mods.put(maxhealth, new AttributeModifier (MAX_HEALTH_ONYXBODY_UUID, "MAX_HEALTH_ONYXBODY_UUID", 18, 0));
    		mods.put(knockback, new AttributeModifier (KNOCKBACK_RESISTANCE_ONYXBODY_UUID, "KNOCKBACK_RESISTANCE_ONYXBODY_UUID", 0.15, 0));

    	}
    	return mods;
    }

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		if (player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ModItems.ONYX_HELMET
				&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ModItems.ONYX_CHESTPLATE
				&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ModItems.ONYX_LEGGINGS
				&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ModItems.ONYX_BOOTS)
		{
			player.addPotionEffect(new PotionEffect(MobEffects.SPEED, 0, 0));
			player.addPotionEffect(new PotionEffect(MobEffects.JUMP_BOOST, 0, 0));
			player.addPotionEffect(new PotionEffect(MobEffects.STRENGTH, 0, 0));
			player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 0, 0));
			player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE,0,1));
		}
		if (player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ModItems.ONYX_CHESTPLATE)
		{
			player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE,0,0));
			if (world.getTotalWorldTime() % 60 != 1)
			{
				return;
			}
			player.heal(0.4F);
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
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.8"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.9"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.10"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.11"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.12"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.13"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.14"));
		tooltip.add(net.minecraft.client.resources.I18n.format("Durability:"));
		tooltip.add(net.minecraft.client.resources.I18n.format((getMaxDamage() - getDamage(stack)) +" / "+getMaxDamage()));
	}

}
//player.heal(0.001F);