package com.PlanetCore.util.handlers;

import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientHandler {

    @SubscribeEvent
    public static void addTooltips(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.getItem() instanceof ItemPickaxe || stack.getDisplayName().contains("ickaxe")) {
            float efficiency = event.getItemStack().getDestroySpeed(Blocks.STONE.getDefaultState());
            //float efficiency1 = ObfuscationReflectionHelper.getPrivateValue(ItemTool.class,(ItemTool)stack.getItem(),"field_77864_a");
            if (event.getEntityPlayer() != null) {
                int effLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.EFFICIENCY, stack);
                if (effLevel > 0) {
                    efficiency += effLevel * effLevel + 1;
                }
                PotionEffect effect = (event.getEntityPlayer()).getActivePotionEffect(MobEffects.HASTE);
                if (effect != null)
                {
                    efficiency = efficiency*(1+(0.2F*effect.getAmplifier()));
                }
            }
            float relentless = PickaxeRelentlessHandler.getRelentless(stack);
            float maxHardness = relentless * efficiency / 1.5F;
            String rock = "stone";
            String ore = "coal";
            String supercompact = "coal";
            if (maxHardness < 1.5F) rock = "can't break stone";
            if (maxHardness >= 1.5F && maxHardness < 9) rock = "stone";
            if (maxHardness >= 9 && maxHardness < 14) rock = "crustrock";
            if (maxHardness >= 14 && maxHardness < 22) rock = "crustrock1";
            if (maxHardness >= 22 && maxHardness < 60) rock = "crustrock2";
            if (maxHardness >= 60 && maxHardness < 70) rock = "mantlerock";
            if (maxHardness >= 70 && maxHardness < 100) rock = "mantlerock1";
            if (maxHardness >= 100 && maxHardness < 150) rock = "mantlerock2";
            if (maxHardness >= 150 && maxHardness < 200) rock = "lower_mantlerock";
            if (maxHardness >= 200 && maxHardness < 250) rock = "lower_mantlerock1";
            if (maxHardness >= 250 && maxHardness < 360) rock = "lower_mantlerock2";
            if (maxHardness >= 360 && maxHardness < 460) rock = "corestone";
            if (maxHardness >= 460 && maxHardness < 560) rock = "corestone1";
            if (maxHardness >= 560 && maxHardness < 770) rock = "corestone2";
            if (maxHardness >= 770 && maxHardness < 1000) rock = "innercorestone";
            if (maxHardness >= 1000 && maxHardness < 1250) rock = "innercorestone1";
            if (maxHardness >= 1250 && maxHardness < 1500) rock = "innercorestone2";
            if (maxHardness >= 1500) rock = "centercorestone";

            if (maxHardness < 2) ore = "coal ore (tier 1) , ";
            if (maxHardness >= 2 && maxHardness < 3) ore = "sulfur (tier 1)";
            if (maxHardness >= 3 && maxHardness < 3.5) ore = "redstone, lapis (tier 1)";
            if (maxHardness >= 3.5 && maxHardness < 4.5) ore = "aluminium (tier 2)";
            if (maxHardness >= 4.5 && maxHardness < 5.5) ore = "iron, tin, copper (tier 3), compact coal";
            if (maxHardness >= 5.5 && maxHardness < 6.5) ore = "iron, tin, copper (tier 3), compact sulfur";
            if (maxHardness >= 6.5 && maxHardness < 7.5) ore = "silver (tier 4), compact redstone, lapis";
            if (maxHardness >= 7.5 && maxHardness < 8.5) ore = "gold (tier 5), compact aluminium";
            if (maxHardness >= 8.5 && maxHardness < 10) ore = "diamond, emerald (tier 6), compact iron, tin, copper";
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
    }
}
