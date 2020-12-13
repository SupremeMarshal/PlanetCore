package com.PlanetCore.util.handlers;

import com.PlanetCore.blocks.*;
import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
import javafx.geometry.Pos;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.text.Style;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.awt.event.MouseEvent;
import java.util.Random;

import static com.PlanetCore.init.EnchantmentInit.Relentless;

@Mod.EventBusSubscriber(modid="planetcore")
public class PickaxeRelentlessHandler {

    private static final int[] relentless = {ModItems.ToolMaterialCustom.WOODEN.getRelentless(), ModItems.ToolMaterialCustom.STONE.getRelentless(), ModItems.ToolMaterialCustom.ALUMINIUM.getRelentless(), ModItems.ToolMaterialCustom.ZINC.getRelentless(), ModItems.ToolMaterialCustom.LEAD.getRelentless(), ModItems.ToolMaterialCustom.TIN.getRelentless(), ModItems.ToolMaterialCustom.SILICON.getRelentless()/**5*/,
            ModItems.ToolMaterialCustom.COPPER.getRelentless(), ModItems.ToolMaterialCustom.IRON.getRelentless(), ModItems.ToolMaterialCustom.BRONZE.getRelentless(), ModItems.ToolMaterialCustom.STEEL.getRelentless(), ModItems.ToolMaterialCustom.SILVER.getRelentless()/**10*/,
            ModItems.ToolMaterialCustom.GOLD.getRelentless(), ModItems.ToolMaterialCustom.PLATINUM.getRelentless(), ModItems.ToolMaterialCustom.TITANIUM.getRelentless(), ModItems.ToolMaterialCustom.URANIUM.getRelentless(), ModItems.ToolMaterialCustom.TOPAZ.getRelentless()/**15*/,
            ModItems.ToolMaterialCustom.JADE.getRelentless(), ModItems.ToolMaterialCustom.TUNGSTEN.getRelentless(), ModItems.ToolMaterialCustom.TITANIUM_URANIUM.getRelentless(), ModItems.ToolMaterialCustom.TUNGSTEN_URANIUM.getRelentless(), ModItems.ToolMaterialCustom.TUNGSTEN_TITANIUM.getRelentless()/**20*/,
            ModItems.ToolMaterialCustom.COMPLETE_ALUMINIUM.getRelentless(), ModItems.ToolMaterialCustom.COMPLETE_ZINC.getRelentless(), ModItems.ToolMaterialCustom.COMPLETE_LEAD.getRelentless(), ModItems.ToolMaterialCustom.COMPLETE_TIN.getRelentless(), ModItems.ToolMaterialCustom.COMPLETE_SILICON.getRelentless()/**5*/,
            ModItems.ToolMaterialCustom.COMPLETE_COPPER.getRelentless(), ModItems.ToolMaterialCustom.COMPLETE_IRON.getRelentless(), ModItems.ToolMaterialCustom.COMPLETE_BRONZE.getRelentless(), ModItems.ToolMaterialCustom.COMPLETE_STEEL.getRelentless(), ModItems.ToolMaterialCustom.COMPLETE_SILVER.getRelentless()/**10*/,
            ModItems.ToolMaterialCustom.COMPLETE_GOLD.getRelentless(), ModItems.ToolMaterialCustom.COMPLETE_PLATINUM.getRelentless(), ModItems.ToolMaterialCustom.COMPLETE_TITANIUM.getRelentless(), ModItems.ToolMaterialCustom.COMPLETE_URANIUM.getRelentless(),
            ModItems.ToolMaterialCustom.COMPLETE_TUNGSTEN.getRelentless(), ModItems.ToolMaterialCustom.COMPLETE_TITANIUM_URANIUM.getRelentless(), ModItems.ToolMaterialCustom.COMPLETE_TUNGSTEN_URANIUM.getRelentless(), ModItems.ToolMaterialCustom.COMPLETE_TUNGSTEN_TITANIUM.getRelentless()/**20*/,
            ModItems.ToolMaterialCustom.EMERALD.getRelentless(), ModItems.ToolMaterialCustom.RUBY.getRelentless(), ModItems.ToolMaterialCustom.SAPPHIRE.getRelentless(), ModItems.ToolMaterialCustom.DIAMOND.getRelentless(), ModItems.ToolMaterialCustom.OLIVINE.getRelentless()/**25*/,
            ModItems.ToolMaterialCustom.WADSLEYITE.getRelentless(), ModItems.ToolMaterialCustom.RINGWOODITE.getRelentless(), ModItems.ToolMaterialCustom.BRIGMANITE.getRelentless(), ModItems.ToolMaterialCustom.MAJORITE.getRelentless(), ModItems.ToolMaterialCustom.AMAZONITE.getRelentless()/**30*/,
            ModItems.ToolMaterialCustom.ONYX.getRelentless()};
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
                event.setNewSpeed(event.getOriginalSpeed() / 3F);
            }
        }

        if (!event.getEntityPlayer().getHeldItemMainhand().getDisplayName().contains("axe")) {
            if (event.getState().getMaterial() == Material.WOOD) {
                event.setNewSpeed(event.getOriginalSpeed() / 3F);
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
            for (int i = 0; i < 31; i++) {
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
                if (event.getEntityPlayer().world.getTotalWorldTime() % 6 != 1) {
                    return;
                }
            }

            if (breaktime > 0.01F && breaktime <= 0.1F) {
                event.setNewSpeed(event.getOriginalSpeed() / (0.1F / breaktime));

            }
        }
    }

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onBreakEvent0(PlayerEvent.BreakSpeed event) {
        int RelentlessLevel = EnchantmentHelper.getMaxEnchantmentLevel(Relentless, event.getEntityPlayer());
        float breaktime;
        double Relentless = 0;

        //

        if (event.getState().getBlock() instanceof BlockBase) {
            for (int i = 0; i < 31; i++) {
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
                if (event.getEntityPlayer().world.getTotalWorldTime() % 6 != 1) {
                    return;
                }
                event.getEntityPlayer().world.playSound(event.getEntityPlayer(), event.getEntityPlayer().getPosition(), sound[new Random().nextInt(20)], SoundCategory.getByName("action"), 1.0F, 1.0F);
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