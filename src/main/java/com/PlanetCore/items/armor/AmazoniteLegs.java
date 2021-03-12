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

public class AmazoniteLegs extends ArmorBase 

{

	public AmazoniteLegs(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		// TODO Auto-generated constructor stub
	}
	
	public static final UUID MAX_HEALTH_AMAZONITELEGS_UUID = UUID.fromString("10544e2f-e783-425d-bd96-da6b05eb2341");
	public static final UUID KNOCKBACK_RESISTANCE_AMAZONITELEGS_UUID = UUID.fromString("a04e1e8e-fbdd-4b16-a912-1a183f09e84f");  
    

    private static final Map<IAttribute, AttributeModifier> modMap = new HashMap<>();
    
    static {

		modMap.put(SharedMonsterAttributes.MAX_HEALTH, new AttributeModifier(MAX_HEALTH_AMAZONITELEGS_UUID, "MAX_HEALTH_AMAZONITELEGS_UUID", 16, 0));
		modMap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE, new AttributeModifier(KNOCKBACK_RESISTANCE_AMAZONITELEGS_UUID, "KNOCKBACK_RESISTANCE_AMAZONITELEGS_UUID", 0.1, 0));
	}
   
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot,

    		ItemStack stack) {

    	Multimap<String, AttributeModifier> mods = super.getAttributeModifiers(slot, stack);
    	
    		
    	if (slot==EntityEquipmentSlot.LEGS) {

    		String maxhealth = SharedMonsterAttributes.MAX_HEALTH.getName();
    		String knockback = SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName();

    		mods.put(maxhealth, new AttributeModifier (MAX_HEALTH_AMAZONITELEGS_UUID, "MAX_HEALTH_AMAZONITELEGS_UUID", 16, 0));
    		mods.put(knockback, new AttributeModifier (KNOCKBACK_RESISTANCE_AMAZONITELEGS_UUID, "KNOCKBACK_RESISTANCE_AMAZONITELEGS_UUID", 0.1, 0));
    	}
    	return mods;
    }

	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		if (player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() == ModItems.AMAZONITE_LEGGINGS)
		{
			player.addPotionEffect(new PotionEffect(MobEffects.RESISTANCE,0,0));
			if (world.getTotalWorldTime() % 100 != 1)
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
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.8"));
		tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.9"));
		tooltip.add(net.minecraft.client.resources.I18n.format("Durability:"));
		tooltip.add(net.minecraft.client.resources.I18n.format((getMaxDamage() - getDamage(stack)) +" / "+getMaxDamage()));
	}
}
