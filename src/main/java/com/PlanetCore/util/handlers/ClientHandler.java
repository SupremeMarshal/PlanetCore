package com.PlanetCore.util.handlers;

import com.PlanetCore.blocks.Corestone;
import com.PlanetCore.blocks.Crustrock;
import com.PlanetCore.blocks.Mantlerock;
import com.PlanetCore.blocks.PlanetHardness;
import com.PlanetCore.items.Drills.IronDrill;
import net.minecraft.block.state.IBlockState;
import com.PlanetCore.items.armor.ArmorBase;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.util.GeckoLibUtil;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientHandler {

    @SubscribeEvent
    public static void addTooltips(ItemTooltipEvent event) {
        if (event.getEntityPlayer() != null) {
            ItemStack stack = event.getItemStack();
            EntityPlayer player = event.getEntityPlayer();
            if (stack.getItem() instanceof ItemPickaxe || stack.getDisplayName().contains("ickaxe")) {
                float efficiency = event.getItemStack().getDestroySpeed(Blocks.STONE.getDefaultState());
                //float efficiency1 = ObfuscationReflectionHelper.getPrivateValue(ItemTool.class,(ItemTool)stack.getItem(),"field_77864_a");
                if (event.getEntityPlayer() != null) {
                    int effLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.EFFICIENCY, stack);
                    if (effLevel > 0) {
                        efficiency += effLevel * effLevel + 1;
                    }
                    PotionEffect effect = (event.getEntityPlayer()).getActivePotionEffect(MobEffects.HASTE);
                    if (effect != null) {
                        efficiency = efficiency * (1 + (0.2F * effect.getAmplifier()));
                    }
                }
                float relentless = PickaxeRelentlessHandler.getRelentless(stack);
                float maxHardness = relentless * efficiency / 1.5F;
                String rock = "stone";
                String ore = "coal";
                String supercompact = "coal";
                if (maxHardness < 1.5F) rock = "can't break stone";
                if (maxHardness >= 1.5F) rock = "stone";
                if (maxHardness >= Crustrock.crustHardnessByMeta[0]) rock = "crustrock";
                if (maxHardness >= Crustrock.crustHardnessByMeta[1]) rock = "crustrock1";
                if (maxHardness >= Crustrock.crustHardnessByMeta[2]) rock = "crustrock2";
                if (maxHardness >= Mantlerock.mantleHardnessByMeta[0]) rock = "mantlerock";
                if (maxHardness >= Mantlerock.mantleHardnessByMeta[1]) rock = "mantlerock1";
                if (maxHardness >= Mantlerock.mantleHardnessByMeta[2]) rock = "mantlerock2";
                if (maxHardness >= Mantlerock.mantleHardnessByMeta[3]) rock = "lower_mantlerock";
                if (maxHardness >= Mantlerock.mantleHardnessByMeta[4]) rock = "lower_mantlerock1";
                if (maxHardness >= Mantlerock.mantleHardnessByMeta[5]) rock = "lower_mantlerock2";
                if (maxHardness >= Corestone.coreHardnessByMeta[0]) rock = "corestone";
                if (maxHardness >= Corestone.coreHardnessByMeta[1]) rock = "innercorestone";
                if (maxHardness >= Corestone.coreHardnessByMeta[2]) rock = "centercorestone";

                event.getToolTip().add("Can break up to " + rock);
                event.getToolTip().add("Efficiency: " + efficiency);
                event.getToolTip().add("Relentless: " + relentless);


            }

            if (stack.getItem() instanceof ItemArmor && isItemInArmorSlot(stack, player)) {

                float toughness = (float) player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue();
                float armor = (float) player.getEntityAttribute(SharedMonsterAttributes.ARMOR).getAttributeValue();
                event.getToolTip().add("Total damage reduction:");

                ItemStack helmet = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
                ItemStack chestplate = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
                ItemStack leggings = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
                ItemStack boots = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);

                float helmetArmor = 0;
                float chestArmor = 0;
                float legsArmor = 0;
                float bootsArmor = 0;

                if (helmet.getItem() instanceof ArmorBase) helmetArmor = ((ArmorBase) helmet.getItem()).extraArmor;
                if (chestplate.getItem() instanceof ArmorBase)
                    chestArmor = ((ArmorBase) chestplate.getItem()).extraArmor;
                if (leggings.getItem() instanceof ArmorBase) legsArmor = ((ArmorBase) leggings.getItem()).extraArmor;
                if (boots.getItem() instanceof ArmorBase) bootsArmor = ((ArmorBase) boots.getItem()).extraArmor;
                // Calculate the total extra armor value
                float totalExtraArmor = (helmetArmor + chestArmor + legsArmor + bootsArmor);

                float modifiedDamage = (float) (((armor + toughness + totalExtraArmor) * 0.03) / (float) (1 + 0.03 * (armor + toughness + totalExtraArmor)));
                event.getToolTip().add(String.format("%.2f", modifiedDamage * 100) + "%");
            }
        }
    }

    private static boolean isItemInArmorSlot(ItemStack itemStack, EntityPlayer player) {
        for (EntityEquipmentSlot slot : EntityEquipmentSlot.values()) {
            if (player.getItemStackFromSlot(slot) == itemStack && slot != EntityEquipmentSlot.MAINHAND && slot != EntityEquipmentSlot.OFFHAND) {
                return true;
            }
        }
        return false;
    }

    @SubscribeEvent
    public static void trackLeftClick(InputUpdateEvent e) {
        boolean attacking = Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown();
        ItemStack stack = Minecraft.getMinecraft().player.getHeldItemMainhand();
        if (stack.getItem() instanceof IronDrill) {
            IronDrill ironDrill = (IronDrill) stack.getItem();
            AnimationController<?> controller =
                    GeckoLibUtil.getControllerForStack(ironDrill.getFactory(), stack, IronDrill.CTRL_NAME);
            if (attacking) {
                controller.setAnimation(IronDrill.ACTIVE_DRILL);
            } else {
                controller.setAnimation(IronDrill.INACTIVE_DRILL);
            }
        }
    }

    @SubscribeEvent
    public static void temperatureHud(RenderGameOverlayEvent event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            Minecraft minecraft = Minecraft.getMinecraft();
            EntityPlayer player = minecraft.player;
            if (player != null) {
                double y = player.posY;
                if (y < 0) {
                    double temp = TemperatureHandler.calcTemp(y);
                    PotionEffect effect = player.getActivePotionEffect(MobEffects.FIRE_RESISTANCE);
                    int fireResist = effect == null ? 0 : effect.getAmplifier() + 1;
                    int limit = TemperatureHandler.getLimit(fireResist);
                    int color = 0x00ff00;

                    if (temp >= limit) {
                        color = 0xff0000;
                    } else if (limit - temp < limit - (limit / 1.2)) {
                        color = 0xffff00;
                    }
                    minecraft.ingameGUI.drawString(minecraft.fontRenderer,"Temperature: "+String.format("%.0f",temp) +" C",0,0,color);
                }
            }
        }
    }

    @SubscribeEvent
    public static void playSound(PlaySoundEvent e) {
        EntityPlayer player = Minecraft.getMinecraft().player;

        if (player != null) {
            ItemStack stack = player.getHeldItemMainhand();
            if (stack.getItem() instanceof IronDrill) {
                ISound sound = e.getSound();
                ResourceLocation rl = sound.getSoundLocation();
                if (rl.getPath().endsWith("hit")) {
                    e.setResultSound(null);
                }
            }
        }
    }

    @SubscribeEvent
    public static void overlay(RenderBlockOverlayEvent e) {
        RenderBlockOverlayEvent.OverlayType overlayType = e.getOverlayType();
        if (overlayType == RenderBlockOverlayEvent.OverlayType.FIRE) {
            EntityPlayer player = e.getPlayer();
            if (player.isBurning()) {

                PotionEffect effect = player.getActivePotionEffect(MobEffects.FIRE_RESISTANCE);
                int fireResist = effect == null ? 0 : effect.getAmplifier() + 1;
                double y = player.posY;
                double temp = TemperatureHandler.calcTemp(y);
                double damage = TemperatureHandler.getDamage(temp,fireResist);
                if (damage <= 0) {
                    e.setCanceled(true);
                }
            }
        }
    }
}
