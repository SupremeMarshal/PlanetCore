package com.PlanetCore.items.shields;

import com.PlanetCore.Main;
import com.PlanetCore.init.ModBlocks;
import com.google.common.collect.Multimap;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


public class RubyShield extends ItemShield {


    /**
     * Using these UUID for adding knockback resistance later.
     */

    public static final UUID KNOCKBACK_RESISTANCE_RUBYSHIELD_UUID = UUID

            .fromString("a40f2a1c-1a04-4b7f-806e-226172034a59");

    public static final UUID MAX_HEALTH_RUBYSHIELD_UUID = UUID

            .fromString("9e7f4ea3-70cb-4568-b839-f5de4807267e");

    private static final Map<IAttribute, AttributeModifier> modMap = new HashMap<>();


    static {

        modMap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE,

                new AttributeModifier(KNOCKBACK_RESISTANCE_RUBYSHIELD_UUID,

                        "Ruby Shield knockback resistance", 0.3D, 0));

        modMap.put(SharedMonsterAttributes.MAX_HEALTH,

                new AttributeModifier(MAX_HEALTH_RUBYSHIELD_UUID,

                        "Ruby Shield max health", 16, 0));

    }

        //this.setMaxDamage(10000);

public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return repair.getItem() == Item.getItemFromBlock(ModBlocks.RUBY_BLOCK) ? true : super.getIsRepairable(toRepair, repair);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {

        return ("§bRuby shield");
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
        tooltip.add(net.minecraft.client.resources.I18n.format("Durability:"));
        tooltip.add(net.minecraft.client.resources.I18n.format((getMaxDamage() - getDamage(stack)) +" / "+getMaxDamage()));
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot,

                                                                     ItemStack stack) {

        Multimap<String, AttributeModifier> mods = super.getAttributeModifiers(slot, stack);


        if (slot==EntityEquipmentSlot.OFFHAND ) {

            String knockback = SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName();
            String maxhealth = SharedMonsterAttributes.MAX_HEALTH.getName();

            mods.put(knockback, new AttributeModifier (KNOCKBACK_RESISTANCE_RUBYSHIELD_UUID, "Ruby Shield knockback resistance", 0.3D, 0));
            mods.put(maxhealth, new AttributeModifier (MAX_HEALTH_RUBYSHIELD_UUID, "Ruby Shield max health", 16, 0));


        }
        return mods;
    }




}
