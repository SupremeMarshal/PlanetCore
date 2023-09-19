package com.PlanetCore.util.handlers;

import com.PlanetCore.items.armor.ArmorBase;
import com.PlanetCore.items.shields.Shield;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class DamageReductionArmorHandler {

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        EntityLivingBase entity = event.getEntityLiving();
        float toughness = (float) entity.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue();
        float armor = (float) entity.getEntityAttribute(SharedMonsterAttributes.ARMOR).getAttributeValue();
        // Get the armor pieces from the player's equipment slots
        ItemStack helmet = entity.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
        ItemStack chestplate = entity.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
        ItemStack leggings = entity.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
        ItemStack boots = entity.getItemStackFromSlot(EntityEquipmentSlot.FEET);
        ItemStack shield = entity.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);

        float helmetArmor = 0;
        float chestArmor = 0;
        float legsArmor = 0;
        float bootsArmor = 0;
        float shieldArmor = 0;

        if (helmet.getItem() instanceof ArmorBase)
            helmetArmor = ((ArmorBase) helmet.getItem()).extraArmor;
        if (chestplate.getItem() instanceof ArmorBase)
            chestArmor = ((ArmorBase) chestplate.getItem()).extraArmor;
        if (leggings.getItem() instanceof ArmorBase)
            legsArmor = ((ArmorBase) leggings.getItem()).extraArmor;
        if (boots.getItem() instanceof ArmorBase)
            bootsArmor = ((ArmorBase) boots.getItem()).extraArmor;
        if (shield.getItem() instanceof Shield)
            shieldArmor = ((Shield) shield.getItem()).extraArmor;

        // Calculate the total extra armor value
        float totalExtraArmor = (helmetArmor + chestArmor + legsArmor + bootsArmor + shieldArmor);

        float totalArmor = armor + toughness + totalExtraArmor;
        // Check for Resistance effect
        PotionEffect resistanceEffect = entity.getActivePotionEffect(MobEffects.RESISTANCE);
        if (resistanceEffect != null) {
            int amplifier = resistanceEffect.getAmplifier();
            totalArmor += totalArmor * ((amplifier + 1) * 0.2); // 10% more armor for each level of Resistance
        }
        // Modify damage reduction calculation here
        //damage_done * 1 - (((armor)*0.06)/(1+0.06*(armor))
        float damage = event.getAmount();
        float modifiedDamage = event.getAmount() * (float) (1 - (((totalArmor) * 0.03) / (float) (1 + 0.03 * (totalArmor))));
        if (modifiedDamage < 1) {
            event.getEntityLiving().hurtTime = -1; // Disable hurt animation
        }
        event.setAmount(modifiedDamage);
    }
}
