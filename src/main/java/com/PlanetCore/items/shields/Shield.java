package com.PlanetCore.items.shields;

import com.PlanetCore.init.ModBlocks;
import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
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


public class Shield extends ItemShield {

    public final ShieldMaterial shieldMaterial;
    public Shield(ShieldMaterial shieldMaterial) {

        this.shieldMaterial = shieldMaterial;
        if (shieldMaterial == ShieldMaterial.SILVER) {this.setMaxDamage(504);}
        else if (shieldMaterial == ShieldMaterial.IRON || shieldMaterial == ShieldMaterial.GOLD) {this.setMaxDamage(672);}
        else this.setMaxDamage(4368);
        //I'll do the rest later

    }
    /**
     * Using these UUID for adding knockback resistance later.
     */

    public static final UUID KNOCKBACK_RESISTANCE_SHIELD_UUID = UUID

            .fromString("7b557bbc-cadb-4633-b904-9ce2286716b4");

    public static final UUID MAX_HEALTH_SHIELD_UUID = UUID

            .fromString("b2d341c6-8fd0-4506-9660-f1a0aa1cb84a");

    private static final Map<IAttribute, AttributeModifier> modMap = new HashMap<>();

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        if (shieldMaterial == ShieldMaterial.IRON) return repair.getItem() == Item.getItemFromBlock(ModBlocks.IRON_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.SILVER) return repair.getItem() == Item.getItemFromBlock(ModBlocks.SILVER_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.GOLD) return repair.getItem() == Item.getItemFromBlock(ModBlocks.GOLD_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.TITANIUM) return repair.getItem() == Item.getItemFromBlock(ModBlocks.TITANIUM_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.URANIUM) return repair.getItem() == Item.getItemFromBlock(ModBlocks.URANIUM_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.TUNGSTEN) return repair.getItem() == Item.getItemFromBlock(ModBlocks.TUNGSTEN_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.RUBY) return repair.getItem() == Item.getItemFromBlock(ModBlocks.RUBY_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.SAPPHIRE) return repair.getItem() == Item.getItemFromBlock(ModBlocks.SAPPHIRE_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.DIAMOND) return repair.getItem() == Item.getItemFromBlock(ModBlocks.DIAMOND_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.MAJORITE) return repair.getItem() == Item.getItemFromBlock(ModBlocks.MAJORITE_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.AMAZONITE) return repair.getItem() == Item.getItemFromBlock(ModBlocks.AMAZONITE_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.ONYX) return repair.getItem() == Item.getItemFromBlock(ModBlocks.ONYX_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.ONYXII) return repair.getItem() == Item.getItemFromBlock(ModBlocks.PAINITE_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.ONYXIII) return repair.getItem() == Item.getItemFromBlock(ModBlocks.PAINITE_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.ONYXIV) return repair.getItem() == Item.getItemFromBlock(ModBlocks.PAINITE_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.ONYXV) return repair.getItem() == Item.getItemFromBlock(ModBlocks.PAINITE_BLOCK) || super.getIsRepairable(toRepair, repair);


        return super.getIsRepairable(toRepair, repair);
    }

    @Override
    public boolean isShield(ItemStack stack, @Nullable EntityLivingBase entity)
    {
        return stack.getItem() == this;
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {

        if (shieldMaterial == ShieldMaterial.IRON) return ("Iron shield");
        if (shieldMaterial == ShieldMaterial.SILVER) return ("Silver shield");
        if (shieldMaterial == ShieldMaterial.GOLD) return ("Gold shield");
        if (shieldMaterial == ShieldMaterial.TITANIUM) return ("Titanium shield");
        if (shieldMaterial == ShieldMaterial.URANIUM) return ("Uranium shield");
        if (shieldMaterial == ShieldMaterial.TUNGSTEN) return ("Tungsten shield");
        if (shieldMaterial == ShieldMaterial.RUBY) return ("Ruby shield");
        if (shieldMaterial == ShieldMaterial.SAPPHIRE) return ("Sapphire shield");
        if (shieldMaterial == ShieldMaterial.DIAMOND) return ("Diamond shield");
        if (shieldMaterial == ShieldMaterial.MAJORITE) return ("Majorite shield");
        if (shieldMaterial == ShieldMaterial.AMAZONITE) return ("Amazonite shield");
        if (shieldMaterial == ShieldMaterial.ONYX) return ("Onyx shield");
        if (shieldMaterial == ShieldMaterial.ONYXII) return ("Onyx shield II");
        if (shieldMaterial == ShieldMaterial.ONYXIII) return ("Onyx shield III");
        if (shieldMaterial == ShieldMaterial.ONYXIV) return ("Onyx shield IV");
        if (shieldMaterial == ShieldMaterial.ONYXV) return ("Onyx shield V");
        return ("Shield");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (!stack.hasTagCompound()) {
            stack.setTagCompound(new NBTTagCompound());
        }

        if (!stack.getTagCompound().hasKey("HideFlags")) {
            // hides normal info
            stack.getTagCompound().setInteger("HideFlags", 2);
        }
        if (shieldMaterial == ShieldMaterial.IRON || shieldMaterial == ShieldMaterial.SILVER || shieldMaterial == ShieldMaterial.GOLD || shieldMaterial == ShieldMaterial.DIAMOND) {
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.0"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.1"));
            tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
        } else if (shieldMaterial == ShieldMaterial.TITANIUM || shieldMaterial == ShieldMaterial.URANIUM
                || shieldMaterial == ShieldMaterial.TUNGSTEN) {
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.0"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.1"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.2"));
            tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
        } else if (shieldMaterial == ShieldMaterial.RUBY || shieldMaterial == ShieldMaterial.SAPPHIRE) {
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.0"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.1"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.2"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.3"));
            tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
        } else {
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.0"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.1"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.2"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.3"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.4"));
            tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
        }
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot,

                                                                     ItemStack stack) {

        Multimap<String, AttributeModifier> mods = super.getAttributeModifiers(slot, stack);


        float health = 0;
        float knockback = 0;
        if (shieldMaterial == ShieldMaterial.IRON) {
            knockback = 0.05F;
        }
        if (shieldMaterial == ShieldMaterial.SILVER) {
            knockback = 0.08F;
        }
        if (shieldMaterial == ShieldMaterial.GOLD) {
            knockback = 0.09F;
        }
        if (shieldMaterial == ShieldMaterial.DIAMOND) {
            knockback = 0.1F;
        }
        if (shieldMaterial == ShieldMaterial.TITANIUM) {
            health = 1.0F;
            knockback = 0.11F;
        }
        if (shieldMaterial == ShieldMaterial.URANIUM) {
            health = 1.0F;
            knockback = 0.12F;
        }
        if (shieldMaterial == ShieldMaterial.TUNGSTEN) {
            health = 2.0F;
            knockback = 0.14F;
        }
        if (shieldMaterial == ShieldMaterial.RUBY) {
            health = 4.0F;
            knockback = 0.2F;
        }
        if (shieldMaterial == ShieldMaterial.SAPPHIRE) {
            health = 5.0F;
            knockback = 0.22F;
        }
        if (shieldMaterial == ShieldMaterial.MAJORITE) {
            health = 10.0F;
            knockback = 0.34F;
        }
        if (shieldMaterial == ShieldMaterial.AMAZONITE) {
            health = 11.0F;
            knockback = 0.36F;
        }
        if (shieldMaterial == ShieldMaterial.ONYX) {
            health = 12.0F;
            knockback = 0.38F;

        }
        if (shieldMaterial == ShieldMaterial.ONYXII) {
            health = 13.0F;
            knockback = 0.4F;

        }
        if (shieldMaterial == ShieldMaterial.ONYXIII) {
            health = 14.0F;
            knockback = 0.42F;

        }
        if (shieldMaterial == ShieldMaterial.ONYXIV) {
            health = 15.0F;
            knockback = 0.44F;
        }
        if (shieldMaterial == ShieldMaterial.ONYXV) {
            health = 16.0F;
            knockback = 0.46F;
        }


        String maxhealth = SharedMonsterAttributes.MAX_HEALTH.getName();
        String knockback_resistance = SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName();

        if (slot == EntityEquipmentSlot.OFFHAND) {

            mods.put(maxhealth, new AttributeModifier(MAX_HEALTH_SHIELD_UUID, "MAX_HEALTH_SHIELD_UUID", health, 0));
            mods.put(knockback_resistance, new AttributeModifier(KNOCKBACK_RESISTANCE_SHIELD_UUID, "KNOCKBACK_RESISTANCE_SHIELD_UUID", knockback, 0));
        }
        return mods;
    }

}
