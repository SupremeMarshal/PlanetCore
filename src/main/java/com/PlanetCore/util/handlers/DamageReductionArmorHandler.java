package com.PlanetCore.util.handlers;

import com.PlanetCore.items.armor.ArmorBase;
import com.PlanetCore.items.shields.Shield;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class DamageReductionArmorHandler {

    @SubscribeEvent
    public static void onLivingHurt(LivingHurtEvent event) {
        if (event.getEntityLiving() instanceof EntityPlayer) {
            EntityPlayer player = (EntityPlayer) event.getEntityLiving();
            float toughness = (float) player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue();
            float armor = (float) player.getEntityAttribute(SharedMonsterAttributes.ARMOR).getAttributeValue();
            // Get the armor pieces from the player's equipment slots
            ItemStack helmet = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
            ItemStack chestplate = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
            ItemStack leggings = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
            ItemStack boots = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
            ItemStack shield = player.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);

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
            float totalExtraArmor = ( helmetArmor + chestArmor + legsArmor + bootsArmor + shieldArmor );

            // Modify damage reduction calculation here
            //damage_done * 1 - (((armor)*0.06)/(1+0.06*(armor))
            float damage = event.getAmount();
            float modifiedDamage = event.getAmount() * (float) (1 - (((armor + toughness + totalExtraArmor) * 0.03) / (float) (1 + 0.03 * (armor + toughness + totalExtraArmor)))); // Example modification
            if (modifiedDamage < 1) {
                event.getEntityLiving().hurtTime = -1; // Disable hurt animation
            }
            event.setAmount(modifiedDamage);
        }
    }
}
