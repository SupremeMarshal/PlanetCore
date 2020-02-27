package com.SupremeMarshal.ToTheEarthCore.items.shields;

import com.SupremeMarshal.ToTheEarthCore.Main;
import com.SupremeMarshal.ToTheEarthCore.init.ModBlocks;
import com.SupremeMarshal.ToTheEarthCore.util.IHasModel;
import com.google.common.collect.Multimap;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
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


public class DiamondShield extends ShieldBase implements IHasModel {


    /**
     * Using these UUID for adding knockback resistance later.
     */

    public static final UUID KNOCKBACK_RESISTANCE_DIAMONDSHIELD_UUID = UUID

            .fromString("d69563c9-a86b-498f-b49b-8c8bcc9df9bd");

    public static final UUID MAX_HEALTH_DIAMONDSHIELD_UUID = UUID

            .fromString("80f58d88-c01a-40ec-9ff6-b46d3a07417e");

    private static final Map<IAttribute, AttributeModifier> modMap = new HashMap<>();


    static {

        modMap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE,

                new AttributeModifier(KNOCKBACK_RESISTANCE_DIAMONDSHIELD_UUID,

                        "Diamond Shield knockback resistance", 0.35D, 0));

        modMap.put(SharedMonsterAttributes.MAX_HEALTH,

                new AttributeModifier(MAX_HEALTH_DIAMONDSHIELD_UUID,

                        "Diamond Shield max health", 20, 0));

    }


    public DiamondShield(String name) {
        super(name);
        this.setMaxDamage(15000);
    }


    @SideOnly(Side.CLIENT)
    public void initModel() {
        ModelLoader.setCustomModelResourceLocation(this, 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }

    @Override
    public void registerModels() {
        Main.proxy.registerModel(this, 0);
    }

    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return repair.getItem() == Item.getItemFromBlock(ModBlocks.DIAMOND_BLOCK) ? true : super.getIsRepairable(toRepair, repair);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {

        return ("§dDiamond shield");
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

            mods.put(knockback, new AttributeModifier (KNOCKBACK_RESISTANCE_DIAMONDSHIELD_UUID, "Diamond Shield knockback resistance", 0.35D, 0));
            mods.put(maxhealth, new AttributeModifier (MAX_HEALTH_DIAMONDSHIELD_UUID, "Diamond Shield max health", 20, 0));


        }
        return mods;
    }




}
