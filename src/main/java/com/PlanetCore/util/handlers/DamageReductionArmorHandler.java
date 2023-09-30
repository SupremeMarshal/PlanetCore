package com.PlanetCore.util.handlers;

import com.PlanetCore.items.armor.ArmorBase;
import com.PlanetCore.items.shields.Shield;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
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

        float helmetExtraArmor = 0;
        float chestExtraArmor = 0;
        float legsExtraArmor = 0;
        float bootsExtraArmor = 0;
        float shieldExtraArmor = 0;

        if (helmet.getItem() instanceof ArmorBase)
            helmetExtraArmor = ((ArmorBase) helmet.getItem()).extraArmor;
        if (chestplate.getItem() instanceof ArmorBase)
            chestExtraArmor = ((ArmorBase) chestplate.getItem()).extraArmor;
        if (leggings.getItem() instanceof ArmorBase)
            legsExtraArmor = ((ArmorBase) leggings.getItem()).extraArmor;
        if (boots.getItem() instanceof ArmorBase)
            bootsExtraArmor = ((ArmorBase) boots.getItem()).extraArmor;
        if (shield.getItem() instanceof Shield)
            shieldExtraArmor = ((Shield) shield.getItem()).extraArmor;

        if (helmet.getItem() instanceof ItemArmor)
            helmetArmor = ((ItemArmor) helmet.getItem()).damageReduceAmount;
        if (chestplate.getItem() instanceof ItemArmor)
            chestArmor = ((ItemArmor) chestplate.getItem()).damageReduceAmount;
        if (leggings.getItem() instanceof ItemArmor)
            legsArmor = ((ItemArmor) leggings.getItem()).damageReduceAmount;
        if (boots.getItem() instanceof ItemArmor)
            bootsArmor = ((ItemArmor) boots.getItem()).damageReduceAmount;

        int helmetProtection = EnchantmentHelper.getEnchantmentLevel(Enchantments.PROTECTION, helmet);
        int chestProtection = EnchantmentHelper.getEnchantmentLevel(Enchantments.PROTECTION, chestplate);
        int legsProtection = EnchantmentHelper.getEnchantmentLevel(Enchantments.PROTECTION, leggings);
        int bootsProtection = EnchantmentHelper.getEnchantmentLevel(Enchantments.PROTECTION, boots);

        helmetArmor += (helmetArmor + helmetExtraArmor) * ((helmetProtection) * 0.25);
        chestArmor += (chestArmor + chestExtraArmor) * ((chestProtection) * 0.25);
        legsArmor += (legsArmor + legsExtraArmor) * ((legsProtection) * 0.25);
        bootsArmor += (bootsArmor + bootsExtraArmor) * ((bootsProtection) * 0.25);

        // Calculate the total extra armor value
        float totalExtraArmor = (helmetArmor + chestArmor + legsArmor + bootsArmor + shieldExtraArmor);

        float totalArmor = toughness + totalExtraArmor;
        // Check for Resistance effect
        PotionEffect resistanceEffect = entity.getActivePotionEffect(MobEffects.RESISTANCE);
        int amplifier = 0;
        // Get enchantment levels from each armor piece

        if (resistanceEffect != null) {
            amplifier = resistanceEffect.getAmplifier();
            totalArmor += totalArmor * ((amplifier + 1) * 0.25); // 20% more armor for each level of Resistance
        }
        // Modify damage reduction calculation here
        //damage_done * 1 - (((armor)*0.06)/(1+0.06*(armor))
        float damage = event.getAmount();
        float modifiedDamage = event.getAmount() * (float) (1 - (((totalArmor) * 0.09) / (float) (1 + 0.09 * (totalArmor))));
        if (modifiedDamage < 1) {
            event.getEntityLiving().hurtTime = -1; // Disable hurt animation
        }
        event.setAmount(modifiedDamage);
    }
}
