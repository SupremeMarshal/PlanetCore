package com.PlanetCore.items.shields;

import com.PlanetCore.Main;
import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.util.IHasModel;
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





public class IronShield extends ShieldBase implements IHasModel {


    /**
     * Using these UUID for adding knockback resistance later.
     */

    public static final UUID KNOCKBACK_RESISTANCE_IRONSHIELD_UUID = UUID

            .fromString("bd020c0b-1252-4bfe-b3bd-1af7412d0d89");

    private static final Map<IAttribute, AttributeModifier> modMap = new HashMap<>();


    static {

        modMap.put(SharedMonsterAttributes.KNOCKBACK_RESISTANCE,

                new AttributeModifier(KNOCKBACK_RESISTANCE_IRONSHIELD_UUID,

                        "Iron Shield knockback resistance", 0.05D, 0));

    }


    public IronShield(String name) {
        super(name);
        this.setMaxDamage(1000);
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
        return repair.getItem() == Item.getItemFromBlock(ModBlocks.IRON_BLOCK) ? true : super.getIsRepairable(toRepair, repair);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack) {

        return ("Iron shield");
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
    {
        if (!stack.hasTagCompound()) {

            stack.setTagCompound(new NBTTagCompound());

        }

        if (!stack.getTagCompound().hasKey("HideFlags")) {

            // hides "+10 knockback resist"

            stack.getTagCompound().setInteger("HideFlags", 2);

        }

        tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.0"));
        tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey()+".tooltip.1"));
        tooltip.add(net.minecraft.client.resources.I18n.format("Durability:"));
        tooltip.add(net.minecraft.client.resources.I18n.format((getMaxDamage() - getDamage(stack)) +" / "+getMaxDamage()));
    }

    @Override
    public Multimap<String, AttributeModifier> getAttributeModifiers(EntityEquipmentSlot slot,

                                                                     ItemStack stack) {

        Multimap<String, AttributeModifier> mods = super.getAttributeModifiers(slot, stack);


        if (slot==EntityEquipmentSlot.MAINHAND || slot==EntityEquipmentSlot.OFFHAND ) {

            String knockback = SharedMonsterAttributes.KNOCKBACK_RESISTANCE.getName();

            mods.put(knockback, new AttributeModifier (KNOCKBACK_RESISTANCE_IRONSHIELD_UUID, "Iron Shield knockback resistance", 0.05D, 0));

        }
        return mods;
    }

}
