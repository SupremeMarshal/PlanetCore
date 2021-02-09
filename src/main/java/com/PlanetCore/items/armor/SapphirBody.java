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

public class SapphirBody extends ArmorBase 

{

	public SapphirBody(ArmorMaterial materialIn, int renderIndexIn, EntityEquipmentSlot equipmentSlotIn) {
		super(materialIn, renderIndexIn, equipmentSlotIn);
		// TODO Auto-generated constructor stub
	}
    
	public static final UUID MAX_HEALTH_SAPPHIRBODY_UUID = UUID.fromString("55d9df5c-62e7-4723-906f-fb1a71082ffa");
	public static final UUID KNOCKBACK_RESISTANCE_SAPPHIRBODY_UUID = UUID.fromString("743d9294-493d-4741-85b0-b469cbd7f5fa");  
    

    private static final Map<IAttribute, AttributeModifier> modMap = new HashMap<>();
    
    static {

		modMap.put(SharedMonsterAttributes.MAX_HEALTH, new AttributeModifier(MAX_HEALTH_SAPPHIRBODY_UUID, "MAX_HEALTH_SAPPHIRBODY_UUID", 6, 0));
		modMap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE, new AttributeModifier(KNOCKBACK_RESISTANCE_SAPPHIRBODY_UUID, "KNOCKBACK_RESISTANCE_SAPPHIRBODY_UUID", 0.025, 0));
	}
   
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot,

    		ItemStack stack) {

    	Multimap<String, AttributeModifier> mods = super.getAttributeModifiers(slot, stack);
    	
    		
    	if (slot==EntityEquipmentSlot.CHEST) {

    		String maxhealth = SharedMonsterAttributes.MAX_HEALTH.getName();
    		String knockbackplatinumbody = SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName();

    		mods.put(maxhealth, new AttributeModifier (MAX_HEALTH_SAPPHIRBODY_UUID, "MAX_HEALTH_SAPPHIRBODY_UUID", 6, 0));
    		mods.put(knockbackplatinumbody, new AttributeModifier (KNOCKBACK_RESISTANCE_SAPPHIRBODY_UUID, "KNOCKBACK_RESISTANCE_SAPPHIRBODY_UUID", 0.025, 0));
    	}
    	return mods;
    }
    //regen 1 health every 37.5 second
	//regen 1.6 health per minute
	//@Override
	//public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	//{
		//if (player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() == ModItems.SAPPHIRE_CHESTPLATE)
		//{
			//if (world.getTotalWorldTime() % 300 != 1)
			//{
				//return;
			//}
			//player.heal(0.4F);
			//heal 1.6 Health per minute
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
