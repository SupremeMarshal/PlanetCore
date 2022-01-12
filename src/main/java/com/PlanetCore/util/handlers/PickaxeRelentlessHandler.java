package com.PlanetCore.util.handlers;

import com.PlanetCore.blocks.BlockBase;
import com.PlanetCore.init.EnchantmentInit;
import com.PlanetCore.init.ToolMaterials;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

import static com.PlanetCore.init.EnchantmentInit.Relentless;

@Mod.EventBusSubscriber(modid="planetcore")
public class PickaxeRelentlessHandler {

    private static final SoundEvent[] sound = {SoundHandler.INDESTRUCTIBLE, SoundHandler.INDESTRUCTIBLE1, SoundHandler.INDESTRUCTIBLE2, SoundHandler.INDESTRUCTIBLE3, SoundHandler.INDESTRUCTIBLE4, SoundHandler.INDESTRUCTIBLE5, SoundHandler.INDESTRUCTIBLE6, SoundHandler.INDESTRUCTIBLE7, SoundHandler.INDESTRUCTIBLE8, SoundHandler.INDESTRUCTIBLE9, SoundHandler.INDESTRUCTIBLE10, SoundHandler.INDESTRUCTIBLE11, SoundHandler.INDESTRUCTIBLE12, SoundHandler.INDESTRUCTIBLE13, SoundHandler.INDESTRUCTIBLE14, SoundHandler.INDESTRUCTIBLE15, SoundHandler.INDESTRUCTIBLE16, SoundHandler.INDESTRUCTIBLE17, SoundHandler.INDESTRUCTIBLE18, SoundHandler.INDESTRUCTIBLE19 };






    @SubscribeEvent
    public static void onBreakEvent(PlayerEvent.BreakSpeed event) {
        int RelentlessLevel = EnchantmentHelper.getMaxEnchantmentLevel(Relentless, event.getEntityPlayer());
        float breaktime;
        float Relentless = 0;

        EntityPlayer player = event.getEntityPlayer();
        ItemStack stack = player.getHeldItemMainhand();



        if (event.getState().getBlock() instanceof BlockBase) {
                if (event.getEntityPlayer().getHeldItemMainhand().getItem() instanceof ItemPickaxe) {
                    Relentless = getRelentless(stack);

                    if (RelentlessLevel > 0) {
                        Relentless = Relentless + (RelentlessLevel / 2F);
                    }
                }

            if (Relentless < 1) {Relentless = 1; }
            breaktime = (event.getState().getBlockHardness(event.getEntityPlayer().world, event.getPos()) * 1.5F) / event.getOriginalSpeed();



            //Determine if the block is undestructible.
            if (breaktime > Relentless && event.getState().getBlock() != Blocks.OBSIDIAN) {
                event.setCanceled(true);
                if (event.getEntityPlayer().getHeldItemMainhand().getItem() instanceof ItemPickaxe && event.getEntityPlayer().world.getTotalWorldTime() % 6 == 1) {
                    event.getEntityPlayer().world.playSound(event.getEntityPlayer(), event.getEntityPlayer().getPosition(), sound[new Random().nextInt(20)], SoundCategory.BLOCKS, 1.0F, 1.0F);
                    return;
                }


            }

            if (breaktime > 0.001F && breaktime <= 0.1F) {
                event.setNewSpeed(event.getOriginalSpeed() / (0.1F / breaktime));

            }
        }
    }

    public static float getRelentless(ItemStack stack) {
        Item item = stack.getItem();
        if (item instanceof ItemPickaxe) {
            Item.ToolMaterial toolMaterial = ObfuscationReflectionHelper.getPrivateValue(ItemTool.class,(ItemPickaxe)item,"field_77862_b");
            float base = ToolMaterials.relentlessMap.getOrDefault(toolMaterial,0F);
            float enchLevel = EnchantmentHelper.getEnchantmentLevel(Relentless,stack);
            return base + enchLevel;
        }
        return 0;
    }
}