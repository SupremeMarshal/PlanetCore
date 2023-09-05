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
    public final float knockbackResistance;
    public final int extraArmor;
    public Shield(ShieldMaterial shieldMaterial, int extraArmor, float knockbackResistance) {

        this.shieldMaterial = shieldMaterial;
        this.extraArmor = extraArmor;
        this.knockbackResistance = knockbackResistance;
        this.setMaxDamage(3000);
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
        tooltip.add("§9" + knockbackResistance + "% Knockback Resistance");
        tooltip.add("§9" + extraArmor + " Extra Armor bonus");
        tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot,

                                                                     ItemStack stack) {

        Multimap<String, AttributeModifier> mods = super.getAttributeModifiers(slot, stack);

        String maxhealth = SharedMonsterAttributes.MAX_HEALTH.getName();
        String knockback_resistance = SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName();

        if (slot == EntityEquipmentSlot.OFFHAND) {
            mods.put(knockback_resistance, new AttributeModifier(KNOCKBACK_RESISTANCE_SHIELD_UUID, "KNOCKBACK_RESISTANCE_SHIELD_UUID", knockbackResistance, 0));
        }
        return mods;
    }

}
