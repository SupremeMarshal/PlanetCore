package com.PlanetCore.util.handlers;

import com.PlanetCore.blocks.BlockBase;
import com.PlanetCore.init.EnchantmentInit;
import com.PlanetCore.init.ToolMaterials;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
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
        double Relentless = 0;

        EntityPlayer player = event.getEntityPlayer();
        ItemStack stack = player.getHeldItemMainhand();

        //
        if (!event.getEntityPlayer().getHeldItemMainhand().getDisplayName().contains("pickaxe")) {
            if (event.getState().getMaterial() == Material.ROCK) {
                event.setNewSpeed(event.getOriginalSpeed() / 1.3F);
            }
        }

        if (!event.getEntityPlayer().getHeldItemMainhand().getDisplayName().contains("axe")) {
            if (event.getState().getMaterial() == Material.WOOD) {
                event.setNewSpeed(event.getOriginalSpeed() / 1.3F);
            }
        }

        int broken_chance = new Random().nextInt(10000);
        if (broken_chance == 1 && !event.getEntityPlayer().getHeldItemMainhand().getItem().getTranslationKey().contains("complete"))
        {



            stack.damageItem(stack.getMaxDamage()/5, player);
            if (event.getEntityPlayer().getHeldItemMainhand().getDisplayName().contains("pickaxe"))
            event.getEntityPlayer().sendMessage(new TextComponentString("The wood on the pickaxe is getting weaker").setStyle(new Style().setColor(TextFormatting.RED)));
            if (event.getEntityPlayer().getHeldItemMainhand().getDisplayName().contains("hoe"))
                event.getEntityPlayer().sendMessage(new TextComponentString("The wood on the hoe is getting weaker").setStyle(new Style().setColor(TextFormatting.RED)));
            if (event.getEntityPlayer().getHeldItemMainhand().getDisplayName().contains("sword"))
                event.getEntityPlayer().sendMessage(new TextComponentString("The wood on the sword is getting weaker").setStyle(new Style().setColor(TextFormatting.RED)));
            if (event.getEntityPlayer().getHeldItemMainhand().getDisplayName().contains("shovel"))
                event.getEntityPlayer().sendMessage(new TextComponentString("The wood on the shovel is getting weaker").setStyle(new Style().setColor(TextFormatting.RED)));
            if (event.getEntityPlayer().getHeldItemMainhand().getDisplayName().contains("shovel"))
                event.getEntityPlayer().sendMessage(new TextComponentString("The wood on the shovel is getting weaker").setStyle(new Style().setColor(TextFormatting.RED)));
        }



        if (event.getState().getBlock() instanceof BlockBase) {
                if (event.getEntityPlayer().getHeldItemMainhand().getItem() instanceof ItemPickaxe) {
                    Relentless = getRelentless(stack);

                    if (RelentlessLevel > 0) {
                        Relentless = Relentless * (1 + (RelentlessLevel / 4D));
                    }
                }

            if (Relentless < 1) {Relentless = 1; }
            breaktime = (event.getState().getBlockHardness(event.getEntityPlayer().world, event.getPos()) * 1.5F) / event.getOriginalSpeed();



            //Determine if the block is undestructible.
            if (breaktime > Relentless) {
                event.setCanceled(true);
                if (event.getEntityPlayer().world.getTotalWorldTime() % 6 == 1) {
                    event.getEntityPlayer().world.playSound(event.getEntityPlayer(), event.getEntityPlayer().getPosition(), sound[new Random().nextInt(20)], SoundCategory.BLOCKS, 1.0F, 1.0F);
                    return;
                }
                // I want to play the sound effect here and make it work in server (so client side)? without kicking player out

            }

            if (breaktime > 0.01F && breaktime <= 0.1F) {
                event.setNewSpeed(event.getOriginalSpeed() / (0.1F / breaktime));

            }
        }
    }

    public static int getRelentless(ItemStack stack) {
        Item item = stack.getItem();
        if (item instanceof ItemPickaxe) {
            Item.ToolMaterial toolMaterial = ObfuscationReflectionHelper.getPrivateValue(ItemTool.class,(ItemPickaxe)item,"field_77862_b");
            int base = ToolMaterials.relentlessMap.getOrDefault(toolMaterial,0);
            int enchLevel = EnchantmentHelper.getEnchantmentLevel(Relentless,stack);
            return base + enchLevel;
        }
        return 0;
    }



    @SubscribeEvent
    public static void onBlockBreakEvent(BlockEvent.BreakEvent event) {
        Item item = event.getPlayer().getHeldItemMainhand().getItem();
        if (item == Items.WOODEN_PICKAXE)
        {
            item.setMaxDamage(3);
        }
        if (item == Items.STONE_PICKAXE)
        {
            item.setMaxDamage(18);
        }

    }
}