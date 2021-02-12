package com.PlanetCore.util.handlers;

import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientHandler {

    @SubscribeEvent
    public static void addTooltips(ItemTooltipEvent event) {
        ItemStack stack = event.getItemStack();
        if (stack.getItem() instanceof ItemTool) {
            float efficiency = ObfuscationReflectionHelper.getPrivateValue(ItemTool.class,(ItemTool)stack.getItem(),"field_77864_a");
            event.getToolTip().add("Efficiency: "+ efficiency);
            if (stack.getItem() instanceof ItemPickaxe) {
                event.getToolTip().add("Relentless: " + PickaxeRelentlessHandler.getRelentless(stack));
            }
        }
    }
}
