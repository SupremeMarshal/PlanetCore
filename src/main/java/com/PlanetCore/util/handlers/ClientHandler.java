package com.PlanetCore.util.handlers;

import com.PlanetCore.init.ModItems;
import com.PlanetCore.init.ToolMaterials;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

import static com.PlanetCore.init.EnchantmentInit.Relentless;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientHandler {

    @SubscribeEvent
    public static void addTooltips(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.getItem() instanceof ItemTool) {
            float efficiency = ObfuscationReflectionHelper.getPrivateValue(ItemTool.class,(ItemTool)stack.getItem(),"field_77864_a");
            if (event.getEntityPlayer() != null) {
                int effLevel = EnchantmentHelper.getEnchantmentLevel(Enchantments.EFFICIENCY,stack);
                if (effLevel > 0) {
                    efficiency += effLevel * effLevel + 1;
                }
            }
            float relentless = PickaxeRelentlessHandler.getRelentless(stack);
            float maxHardness = relentless * efficiency / 1.5F;
            String rock = "stone";
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
            if (stack.getItem() instanceof ItemPickaxe || stack.getDisplayName().contains("pickaxe")) {
                event.getToolTip().add("Can break "+rock);
                event.getToolTip().add("Efficiency: "+ efficiency);
                event.getToolTip().add("Relentless: " + PickaxeRelentlessHandler.getRelentless(stack));
            }
        }
    }
}
