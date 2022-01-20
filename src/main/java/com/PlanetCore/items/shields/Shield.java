package com.PlanetCore.items.shields;

import com.PlanetCore.Main;
import com.PlanetCore.blocks.PlanetHardness;
import com.PlanetCore.blocks.PlanetMaterial;
import com.PlanetCore.init.ArmorMaterials;
import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
import com.PlanetCore.items.armor.ItemSetPieces;
import com.google.common.collect.Multimap;
import net.minecraft.block.SoundType;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttribute;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
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
        if (shieldMaterial == ShieldMaterial.ALUMINIUM) {this.setMaxDamage(504);}
        if (shieldMaterial == ShieldMaterial.IRON || shieldMaterial == ShieldMaterial.TIN || shieldMaterial == ShieldMaterial.COPPER) {this.setMaxDamage(672);}
        if (shieldMaterial == ShieldMaterial.STEEL) {this.setMaxDamage(1008);}
        if (shieldMaterial == ShieldMaterial.BRONZE) {this.setMaxDamage(1344);}
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
        if (shieldMaterial == ShieldMaterial.ALUMINIUM) return repair.getItem() == Item.getItemFromBlock(ModBlocks.ALUMINIUM_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.IRON) return repair.getItem() == Item.getItemFromBlock(ModBlocks.IRON_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.STEEL) return repair.getItem() == Item.getItemFromBlock(ModBlocks.STEEL_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.TIN) return repair.getItem() == Item.getItemFromBlock(ModBlocks.TIN_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.COPPER) return repair.getItem() == Item.getItemFromBlock(ModBlocks.COPPER_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.BRONZE) return repair.getItem() == Item.getItemFromBlock(ModBlocks.BRONZE_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.SILVER) return repair.getItem() == Item.getItemFromBlock(ModBlocks.SILVER_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.GOLD) return repair.getItem() == Item.getItemFromBlock(ModBlocks.GOLD_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.TITANIUM) return repair.getItem() == Item.getItemFromBlock(ModBlocks.TITANIUM_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.URANIUM) return repair.getItem() == Item.getItemFromBlock(ModBlocks.URANIUM_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.TUNGSTEN) return repair.getItem() == Item.getItemFromBlock(ModBlocks.TUNGSTEN_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.TUNGSTEN_TITANIUM) return repair.getItem() == Item.getItemFromBlock(ModBlocks.TUNGSTEN_TITANIUM_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.TOPAZ) return repair.getItem() == Item.getItemFromBlock(ModBlocks.TOPAZ_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.JADE) return repair.getItem() == Item.getItemFromBlock(ModBlocks.JADE_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.RUBY) return repair.getItem() == Item.getItemFromBlock(ModBlocks.RUBY_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.SAPPHIRE) return repair.getItem() == Item.getItemFromBlock(ModBlocks.SAPPHIRE_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.DIAMOND) return repair.getItem() == Item.getItemFromBlock(ModBlocks.DIAMOND_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.OLIVINE) return repair.getItem() == Item.getItemFromBlock(ModBlocks.OLIVINE_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.WADSLEYITE) return repair.getItem() == Item.getItemFromBlock(ModBlocks.WADSLEYITE_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.RINGWOODITE) return repair.getItem() == Item.getItemFromBlock(ModBlocks.RINGWOODITE_BLOCK) || super.getIsRepairable(toRepair, repair);
        if (shieldMaterial == ShieldMaterial.BRIGMANITE) return repair.getItem() == Item.getItemFromBlock(ModBlocks.BRIGMANITE_BLOCK) || super.getIsRepairable(toRepair, repair);
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

        if (shieldMaterial == ShieldMaterial.ALUMINIUM) return ("Aluminium shield");
        if (shieldMaterial == ShieldMaterial.IRON) return ("Iron shield");
        if (shieldMaterial == ShieldMaterial.STEEL) return ("Steel shield");
        if (shieldMaterial == ShieldMaterial.TIN) return ("Tin shield");
        if (shieldMaterial == ShieldMaterial.COPPER) return ("Copper shield");
        if (shieldMaterial == ShieldMaterial.BRONZE) return ("Bronze shield");
        if (shieldMaterial == ShieldMaterial.SILVER) return ("Silver shield");
        if (shieldMaterial == ShieldMaterial.GOLD) return ("Gold shield");
        if (shieldMaterial == ShieldMaterial.TITANIUM) return ("Titanium shield");
        if (shieldMaterial == ShieldMaterial.URANIUM) return ("Uranium shield");
        if (shieldMaterial == ShieldMaterial.TUNGSTEN) return ("Tungsten shield");
        if (shieldMaterial == ShieldMaterial.TUNGSTEN_TITANIUM) return ("Tungsten Titanium shield");
        if (shieldMaterial == ShieldMaterial.JADE) return ("Jade shield");
        if (shieldMaterial == ShieldMaterial.RUBY) return ("Ruby shield");
        if (shieldMaterial == ShieldMaterial.SAPPHIRE) return ("Sapphire shield");
        if (shieldMaterial == ShieldMaterial.DIAMOND) return ("Diamond shield");
        if (shieldMaterial == ShieldMaterial.OLIVINE) return ("Olivine shield");
        if (shieldMaterial == ShieldMaterial.WADSLEYITE) return ("Wadsleyite shield");
        if (shieldMaterial == ShieldMaterial.RINGWOODITE) return ("Ringwoodite shield");
        if (shieldMaterial == ShieldMaterial.BRIGMANITE) return ("Brigmanite shield");
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
        if (shieldMaterial == ShieldMaterial.ALUMINIUM || shieldMaterial == ShieldMaterial.IRON || shieldMaterial == ShieldMaterial.TIN || shieldMaterial == ShieldMaterial.COPPER
    || shieldMaterial == ShieldMaterial.STEEL || shieldMaterial == ShieldMaterial.BRONZE || shieldMaterial == ShieldMaterial.SILVER || shieldMaterial == ShieldMaterial.GOLD || shieldMaterial == ShieldMaterial.DIAMOND) {
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.0"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.1"));
            tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
        } else if (shieldMaterial == ShieldMaterial.TITANIUM || shieldMaterial == ShieldMaterial.URANIUM
                || shieldMaterial == ShieldMaterial.TUNGSTEN || shieldMaterial == ShieldMaterial.TUNGSTEN_TITANIUM) {
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.0"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.1"));
            tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.2"));
            tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
        } else if (shieldMaterial == ShieldMaterial.TOPAZ || shieldMaterial == ShieldMaterial.JADE || shieldMaterial == ShieldMaterial.RUBY || shieldMaterial == ShieldMaterial.SAPPHIRE) {
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
        if (shieldMaterial == ShieldMaterial.ALUMINIUM) {
            knockback = 0.03F;
        }
        if (shieldMaterial == ShieldMaterial.IRON) {
            knockback = 0.05F;
        }
        if (shieldMaterial == ShieldMaterial.TIN) {
            knockback = 0.05F;
        }
        if (shieldMaterial == ShieldMaterial.COPPER) {
            knockback = 0.05F;
        }
        if (shieldMaterial == ShieldMaterial.STEEL) {
            knockback = 0.06F;
        }
        if (shieldMaterial == ShieldMaterial.BRONZE) {
            knockback = 0.07F;
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
        if (shieldMaterial == ShieldMaterial.TUNGSTEN_TITANIUM) {
            health = 3.0F;
            knockback = 0.15F;
        }
        if (shieldMaterial == ShieldMaterial.TOPAZ) {
            health = 1.0F;
            knockback = 0.2F;
        }
        if (shieldMaterial == ShieldMaterial.JADE) {
            health = 2.0F;
            knockback = 0.2F;
        }
        if (shieldMaterial == ShieldMaterial.RUBY) {
            health = 4.0F;
            knockback = 0.2F;
        }
        if (shieldMaterial == ShieldMaterial.SAPPHIRE) {
            health = 5.0F;
            knockback = 0.22F;
        }
        if (shieldMaterial == ShieldMaterial.OLIVINE) {
            health = 6.0F;
            knockback = 0.26F;
        }
        if (shieldMaterial == ShieldMaterial.WADSLEYITE) {
            health = 7.0F;
            knockback = 0.28F;
        }
        if (shieldMaterial == ShieldMaterial.RINGWOODITE) {
            health = 8.0F;
            knockback = 0.3F;
        }
        if (shieldMaterial == ShieldMaterial.BRIGMANITE) {
            health = 9.0F;
            knockback = 0.32F;
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
