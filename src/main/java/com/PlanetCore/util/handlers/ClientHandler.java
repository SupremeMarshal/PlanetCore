package com.PlanetCore.util.handlers;

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

import java.text.DecimalFormat;

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
                if (maxHardness >= 1.5F && maxHardness < 4) rock = "stone";
                if (maxHardness >= 4 && maxHardness < 8) rock = "crustrock";
                if (maxHardness >= 8 && maxHardness < 12) rock = "crustrock1";
                if (maxHardness >= 12 && maxHardness < 20) rock = "crustrock2";
                if (maxHardness >= 20 && maxHardness < 30) rock = "mantlerock";
                if (maxHardness >= 30 && maxHardness < 50) rock = "mantlerock1";
                if (maxHardness >= 50 && maxHardness < 75) rock = "mantlerock2";
                if (maxHardness >= 75 && maxHardness < 100) rock = "lower_mantlerock";
                if (maxHardness >= 100 && maxHardness < 125) rock = "lower_mantlerock1";
                if (maxHardness >= 125 && maxHardness < 180) rock = "lower_mantlerock2";
                if (maxHardness >= 180 && maxHardness < 230) rock = "corestone";
                if (maxHardness >= 230 && maxHardness < 280) rock = "corestone1";
                if (maxHardness >= 280 && maxHardness < 385) rock = "corestone2";
                if (maxHardness >= 385 && maxHardness < 500) rock = "innercorestone";
                if (maxHardness >= 500 && maxHardness < 625) rock = "innercorestone1";
                if (maxHardness >= 625 && maxHardness < 1000) rock = "innercorestone2";
                if (maxHardness >= 1000) rock = "centercorestone";

                if (maxHardness < 2) ore = "coal ore (tier 1) , ";
                if (maxHardness >= 2 && maxHardness < 3) ore = "sulfur (tier 1)";
                if (maxHardness >= 3 && maxHardness < 3.5) ore = "redstone, lapis (tier 1)";
                if (maxHardness >= 3.5 && maxHardness < 4.5) ore = "aluminium (tier 2)";
                if (maxHardness >= 4.5 && maxHardness < 5.5) ore = "iron, tin, copper (tier 3), compact coal";
                if (maxHardness >= 5.5 && maxHardness < 6.5) ore = "iron, tin, copper (tier 3), compact sulfur";
                if (maxHardness >= 6.5 && maxHardness < 7.5) ore = "silver (tier 4), compact redstone, lapis";
                if (maxHardness >= 7.5 && maxHardness < 8.5) ore = "gold (tier 5), compact aluminium";
                if (maxHardness >= 8.5 && maxHardness < 10)
                    ore = "diamond, emerald (tier 6), compact iron, tin, copper";
                if (maxHardness >= 10 && maxHardness < 13.4) ore = "diamond, emerald (tier 6), compact silver";
                if (maxHardness >= 13.4 && maxHardness < 13.5) ore = "titanium, uranium (tier 7), compact silver";
                if (maxHardness >= 13.5 && maxHardness < 15.0) ore = "topaz (tier 8), compact silver";
                if (maxHardness >= 15.0 && maxHardness < 19) ore = "topaz (tier 8), compact gold";
                if (maxHardness >= 19.0 && maxHardness < 20) ore = "topaz (tier 8), compact diamond, emerald";
                if (maxHardness >= 20 && maxHardness < 22) ore = "tungsten (tier 9), compact diamond, emerald";
                if (maxHardness >= 22 && maxHardness < 25) ore = "tungsten (tier 9), compact titanium, uranium";
                if (maxHardness >= 25 && maxHardness < 27) ore = "jade (tier 10), compact titanium, uranium";
                if (maxHardness >= 27 && maxHardness < 65) ore = "jade (tier 10), compact topaz";
                if (maxHardness >= 65 && maxHardness < 70) ore = "ruby (tier 11), compact topaz";
                if (maxHardness >= 70 && maxHardness < 90) ore = "ruby (tier 11), compact tungsten";
                if (maxHardness >= 90 && maxHardness < 100) ore = "sapphire (tier 12), compact tungsten";
                if (maxHardness >= 100 && maxHardness < 140) ore = "sapphire (tier 12), compact jade";
                if (maxHardness >= 140 && maxHardness < 190) ore = "olivine (tier 13), compact jade";
                if (maxHardness >= 190 && maxHardness < 200) ore = "wadsleyite (tier 14), compact jade";
                if (maxHardness >= 200 && maxHardness < 240) ore = "wadsleyite (tier 14), compact ruby";
                if (maxHardness >= 240 && maxHardness < 250) ore = "ringwoodite (tier 15), compact ruby";
                if (maxHardness >= 250 && maxHardness < 290) ore = "ringwoodite (tier 15), compact sapphire";
                if (maxHardness >= 290 && maxHardness < 360) ore = "brigmanite (tier 16), compact sapphire";
                if (maxHardness >= 360 && maxHardness < 450) ore = "brigmanite (tier 16), compact olivine";
                if (maxHardness >= 450 && maxHardness < 460) ore = "majorite (tier 17), compact olivine";
                if (maxHardness >= 460 && maxHardness < 550) ore = "majorite (tier 17), compact wadsleyite";
                if (maxHardness >= 550 && maxHardness < 560) ore = "amazonite (tier 18), compact wadsleyite";
                if (maxHardness >= 560 && maxHardness < 660) ore = "amazonite (tier 18), compact ringwoodite";
                if (maxHardness >= 660 && maxHardness < 760) ore = "amazonite (tier 18), compact brigmanite";
                if (maxHardness >= 760 && maxHardness < 990) ore = "onyx (tier 19), compact brigmanite";
                if (maxHardness >= 990 && maxHardness < 1000) ore = "painite (tier 20), compact brigmanite";
                if (maxHardness >= 1000 && maxHardness < 1300) ore = "painite (tier 20), compact majorite";
                if (maxHardness >= 1300 && maxHardness < 1500) ore = "painite (tier 20), compact amazonite";
                if (maxHardness >= 1500 && maxHardness < 2000) ore = "painite (tier 20), compact onyx";
                if (maxHardness >= 2000) ore = "painite (tier 20), compact painite";

                if (maxHardness < 6.5) supercompact = "none";
                if (maxHardness >= 6.5 && maxHardness < 7.5) supercompact = "coal";
                if (maxHardness >= 7.5 && maxHardness < 8.5) supercompact = "sulfur";
                if (maxHardness >= 8.5 && maxHardness < 9) supercompact = "redstone, lapis";
                if (maxHardness >= 9 && maxHardness < 13.5) supercompact = "aluminium";
                if (maxHardness >= 13.5 && maxHardness < 19) supercompact = "iron, tin, copper";
                if (maxHardness >= 19 && maxHardness < 22) supercompact = "silver";
                if (maxHardness >= 22 && maxHardness < 50) supercompact = "gold";
                if (maxHardness >= 50 && maxHardness < 70) supercompact = "diamond, emerald";
                if (maxHardness >= 70 && maxHardness < 100) supercompact = "titanium, uranium";
                if (maxHardness >= 100 && maxHardness < 180) supercompact = "topaz";
                if (maxHardness >= 180 && maxHardness < 220) supercompact = "tungsten";
                if (maxHardness >= 220 && maxHardness < 400) supercompact = "jade";
                if (maxHardness >= 400 && maxHardness < 500) supercompact = "ruby";
                if (maxHardness >= 500 && maxHardness < 600) supercompact = "sapphire";
                if (maxHardness >= 600 && maxHardness < 900) supercompact = "olivine";
                if (maxHardness >= 900 && maxHardness < 1100) supercompact = "wadlseyite";
                if (maxHardness >= 1100 && maxHardness < 1400) supercompact = "ringwoodite";
                if (maxHardness >= 1400 && maxHardness < 1600) supercompact = "brigmanite";
                if (maxHardness >= 1600 && maxHardness < 1800) supercompact = "majorite";
                if (maxHardness >= 1800 && maxHardness < 2380) supercompact = "amazonite";
                if (maxHardness >= 2380) supercompact = "onyx";

                event.getToolTip().add("Can break " + rock);
                event.getToolTip().add("Can break ores: " + ore);
                event.getToolTip().add("Can break supercompact: " + supercompact);
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
                    } else if (limit - temp < 10) {
                        color = 0xffff00;
                    }
                    minecraft.ingameGUI.drawString(minecraft.fontRenderer,"Temperature: "+temp +" C",0,0,color);
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
