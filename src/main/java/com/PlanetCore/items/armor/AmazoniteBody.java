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

public class AmazoniteBody extends ArmorBase 

{

	public AmazoniteBody(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		// TODO Auto-generated constructor stub
	}
	
	public static final UUID MAX_HEALTH_AMAZONITEBODY_UUID = UUID.fromString("75d55eda-1239-427e-9deb-4e5085526d2f");
	public static final UUID KNOCKBACK_RESISTANCE_AMAZONITEBODY_UUID = UUID.fromString("ecabca0f-d409-4f73-82c2-b866f3f0bd06");  
    

    private static final Map<IAttribute, AttributeModifier> modMap = new HashMap<>();
    
    static {

		modMap.put(SharedMonsterAttributes.MAX_HEALTH, new AttributeModifier(MAX_HEALTH_AMAZONITEBODY_UUID, "MAX_HEALTH_AMAZONITEBODY_UUID", 14, 0));
		modMap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE, new AttributeModifier(KNOCKBACK_RESISTANCE_AMAZONITEBODY_UUID, "KNOCKBACK_RESISTANCE_AMAZONITEBODY_UUID", 0.1D, 0));
	}
   @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot,

    		ItemStack stack) {

    	Multimap<String, AttributeModifier> mods = super.getAttributeModifiers(slot, stack);
    	
    		
    	if (slot==EntityEquipmentSlot.CHEST) {

    		String maxhealth = SharedMonsterAttributes.MAX_HEALTH.getName();
    		String knockback = SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName();

    		mods.put(maxhealth, new AttributeModifier (MAX_HEALTH_AMAZONITEBODY_UUID, "MAX_HEALTH_AMAZONITEBODY_UUID", 14, 0));
    		mods.put(knockback, new AttributeModifier (KNOCKBACK_RESISTANCE_AMAZONITEBODY_UUID, "KNOCKBACK_RESISTANCE_AMAZONITEBODY_UUID", 0.1D, 0));

    	}
    	return mods;
    }



	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		if (player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ModItems.AMAZONITE_HELMET
				&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ModItems.AMAZONITE_CHESTPLATE
				&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ModItems.AMAZONITE_LEGGINGS
				&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() == ModItems.AMAZONITE_BOOTS)
		{
			player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 0, 0));
		}
		if (player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ModItems.AMAZONITE_CHESTPLATE)
		{
			player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE,0,0));
			if (world.getTotalWorldTime() % 100 != 1)
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
		tooltip.add(net.minecraft.client.resources.I18n.format("Durability:"));
		tooltip.add(net.minecraft.client.resources.I18n.format((getMaxDamage() - getDamage(stack)) +" / "+getMaxDamage()));
	}

}
//player.heal(0.001F);