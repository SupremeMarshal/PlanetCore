package com.PlanetCore.items.shields;

import com.google.common.collect.Multimap;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.text.translation.I18n;
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

    public String getItemStackDisplayName(ItemStack stack)
    {
        return I18n.translateToLocal(this.getUnlocalizedNameInefficiently(stack) + ".name").trim();
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return shieldMaterial.getRepairMaterial().test(repair) || super.getIsRepairable(toRepair, repair);
    }

    @Override
    public boolean isShield(ItemStack stack, @Nullable EntityLivingBase entity)
    {
        return true;
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
