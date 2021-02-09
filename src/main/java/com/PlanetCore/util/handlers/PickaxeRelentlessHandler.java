package com.PlanetCore.util.handlers;

import com.PlanetCore.blocks.*;
import com.PlanetCore.init.ModItems;
import com.PlanetCore.init.ToolMaterials;
import javafx.geometry.Pos;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

import static com.PlanetCore.init.EnchantmentInit.Relentless;

@Mod.EventBusSubscriber(modid="planetcore")
public class PickaxeRelentlessHandler {

    //V17

    private static final int[] relentless = {ToolMaterials.WOODEN.getRelentless(), ToolMaterials.STONE.getRelentless(), ToolMaterials.ALUMINIUM.getRelentless(), ToolMaterials.ZINC.getRelentless(), ToolMaterials.LEAD.getRelentless(), ToolMaterials.TIN.getRelentless(), ToolMaterials.SILICON.getRelentless()/**5*/,
            ToolMaterials.COPPER.getRelentless(), ToolMaterials.IRON.getRelentless(), ToolMaterials.BRONZE.getRelentless(), ToolMaterials.STEEL.getRelentless(), ToolMaterials.SILVER.getRelentless()/**10*/,
            ToolMaterials.GOLD.getRelentless(), ToolMaterials.PLATINUM.getRelentless(), ToolMaterials.TITANIUM.getRelentless(), ToolMaterials.URANIUM.getRelentless(), ToolMaterials.COMPLETE_URANIUM.getRelentless(), ToolMaterials.TOPAZ.getRelentless()/**15*/,
            ToolMaterials.JADE.getRelentless(), ToolMaterials.TUNGSTEN.getRelentless(), ToolMaterials.TITANIUM_URANIUM.getRelentless(), ToolMaterials.TUNGSTEN_URANIUM.getRelentless(), ToolMaterials.TUNGSTEN_TITANIUM.getRelentless()/**20*/,
            ToolMaterials.COMPLETE_ALUMINIUM.getRelentless(), ToolMaterials.COMPLETE_ZINC.getRelentless(), ToolMaterials.COMPLETE_LEAD.getRelentless(), ToolMaterials.COMPLETE_TIN.getRelentless(), ToolMaterials.COMPLETE_SILICON.getRelentless()/**5*/,
            ToolMaterials.COMPLETE_COPPER.getRelentless(), ToolMaterials.COMPLETE_IRON.getRelentless(), ToolMaterials.COMPLETE_BRONZE.getRelentless(), ToolMaterials.COMPLETE_STEEL.getRelentless(), ToolMaterials.COMPLETE_SILVER.getRelentless()/**10*/,
            ToolMaterials.COMPLETE_GOLD.getRelentless(), ToolMaterials.COMPLETE_PLATINUM.getRelentless(), ToolMaterials.COMPLETE_TITANIUM.getRelentless(), ToolMaterials.COMPLETE_URANIUM.getRelentless(),
            ToolMaterials.COMPLETE_TUNGSTEN.getRelentless(), ToolMaterials.COMPLETE_TITANIUM_URANIUM.getRelentless(), ToolMaterials.COMPLETE_TUNGSTEN_URANIUM.getRelentless(), ToolMaterials.COMPLETE_TUNGSTEN_TITANIUM.getRelentless()/**20*/,
            ToolMaterials.EMERALD.getRelentless(), ToolMaterials.RUBY.getRelentless(), ToolMaterials.SAPPHIRE.getRelentless(), ToolMaterials.DIAMOND.getRelentless(), ToolMaterials.OLIVINE.getRelentless()/**25*/,
            ToolMaterials.WADSLEYITE.getRelentless(), ToolMaterials.RINGWOODITE.getRelentless(), ToolMaterials.BRIGMANITE.getRelentless(), ToolMaterials.MAJORITE.getRelentless(), ToolMaterials.AMAZONITE.getRelentless()/**30*/,
            ToolMaterials.ONYX.getRelentless()};
    private static final com.PlanetCore.items.tools.ItemPickaxe[] pickaxe = {ModItems.WOODEN_PICKAXE, ModItems.STONE_PICKAXE,ModItems.ALUMINIUM_PICKAXE, ModItems.ZINC_PICKAXE, ModItems.LEAD_PICKAXE, ModItems.TIN_PICKAXE, ModItems.SILICON_PICKAXE/**5*/,
            ModItems.COPPER_PICKAXE, ModItems.IRON_PICKAXE, ModItems.BRONZE_PICKAXE, ModItems.STEEL_PICKAXE, ModItems.SILVER_PICKAXE/**10*/,
            ModItems.GOLD_PICKAXE, ModItems.PLATINUM_PICKAXE, ModItems.TITANIUM_PICKAXE, ModItems.URANIUM_PICKAXE, ModItems.TOPAZ_PICKAXE/**15*/,
            ModItems.JADE_PICKAXE, ModItems.TUNGSTEN_PICKAXE, ModItems.TITANIUM_URANIUM_PICKAXE, ModItems.TUNGSTEN_URANIUM_PICKAXE, ModItems.TUNGSTEN_TITANIUM_PICKAXE/**20*/,
            ModItems.COMPLETE_ALUMINIUM_PICKAXE, ModItems.COMPLETE_ZINC_PICKAXE, ModItems.COMPLETE_LEAD_PICKAXE, ModItems.COMPLETE_TIN_PICKAXE, ModItems.COMPLETE_SILICON_PICKAXE/**5*/,
            ModItems.COMPLETE_COPPER_PICKAXE, ModItems.COMPLETE_IRON_PICKAXE, ModItems.COMPLETE_BRONZE_PICKAXE, ModItems.COMPLETE_STEEL_PICKAXE, ModItems.COMPLETE_SILVER_PICKAXE/**10*/,
            ModItems.COMPLETE_GOLD_PICKAXE, ModItems.COMPLETE_PLATINUM_PICKAXE, ModItems.COMPLETE_TITANIUM_PICKAXE, ModItems.COMPLETE_URANIUM_PICKAXE,
            ModItems.COMPLETE_TUNGSTEN_PICKAXE, ModItems.COMPLETE_TITANIUM_URANIUM_PICKAXE, ModItems.COMPLETE_TUNGSTEN_URANIUM_PICKAXE, ModItems.COMPLETE_TUNGSTEN_TITANIUM_PICKAXE/**20*/,
            ModItems.EMERALD_PICKAXE, ModItems.RUBY_PICKAXE, ModItems.SAPPHIRE_PICKAXE, ModItems.DIAMOND_PICKAXE, ModItems.OLIVINE_PICKAXE/**25*/,
            ModItems.WADSLEYITE_PICKAXE, ModItems.RINGWOODITE_PICKAXE, ModItems.BRIGMANITE_PICKAXE, ModItems.MAJORITE_PICKAXE, ModItems.AMAZONITE_PICKAXE/**30*/,
            ModItems.ONYX_PICKAXE};

    private static final SoundEvent[] sound = {SoundHandler.INDESTRUCTIBLE, SoundHandler.INDESTRUCTIBLE1, SoundHandler.INDESTRUCTIBLE2, SoundHandler.INDESTRUCTIBLE3, SoundHandler.INDESTRUCTIBLE4, SoundHandler.INDESTRUCTIBLE5, SoundHandler.INDESTRUCTIBLE6, SoundHandler.INDESTRUCTIBLE7, SoundHandler.INDESTRUCTIBLE8, SoundHandler.INDESTRUCTIBLE9, SoundHandler.INDESTRUCTIBLE10, SoundHandler.INDESTRUCTIBLE11, SoundHandler.INDESTRUCTIBLE12, SoundHandler.INDESTRUCTIBLE13, SoundHandler.INDESTRUCTIBLE14, SoundHandler.INDESTRUCTIBLE15, SoundHandler.INDESTRUCTIBLE16, SoundHandler.INDESTRUCTIBLE17, SoundHandler.INDESTRUCTIBLE18, SoundHandler.INDESTRUCTIBLE19 };






    @SubscribeEvent
    public static void onBreakEvent(PlayerEvent.BreakSpeed event) {
        int RelentlessLevel = EnchantmentHelper.getMaxEnchantmentLevel(Relentless, event.getEntityPlayer());
        float breaktime;
        double Relentless = 0;

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

            EntityPlayer player = event.getEntityPlayer();
            ItemStack stack = player.getHeldItemMainhand();

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
            for (int i = 0; i < 51; i++) {
                if (event.getEntityPlayer().getHeldItemMainhand().getItem() == pickaxe[i]) {
                    Relentless = relentless[i];

                    if (RelentlessLevel > 0) {
                        Relentless = relentless[i] * (1 + (RelentlessLevel / 4D));
                    }

                    break;
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