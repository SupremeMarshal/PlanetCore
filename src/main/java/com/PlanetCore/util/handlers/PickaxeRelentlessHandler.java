package com.PlanetCore.util.handlers;

import com.PlanetCore.blocks.*;
import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
import net.minecraft.block.material.Material;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPickaxe;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import static com.PlanetCore.init.EnchantmentInit.Relentless;

@Mod.EventBusSubscriber(modid="planetcore")
public class PickaxeRelentlessHandler {

    private static final int[] relentless = {ModItems.ToolMaterialCustom.ALUMINIUM.getRelentless(), ModItems.ToolMaterialCustom.ZINC.getRelentless(), ModItems.ToolMaterialCustom.LEAD.getRelentless(), ModItems.ToolMaterialCustom.TIN.getRelentless(), ModItems.ToolMaterialCustom.SILICON.getRelentless()/**5*/,
            ModItems.ToolMaterialCustom.COPPER.getRelentless(), ModItems.ToolMaterialCustom.IRON.getRelentless(), ModItems.ToolMaterialCustom.BRONZE.getRelentless(), ModItems.ToolMaterialCustom.STEEL.getRelentless(), ModItems.ToolMaterialCustom.SILVER.getRelentless()/**10*/,
            ModItems.ToolMaterialCustom.GOLD.getRelentless(), ModItems.ToolMaterialCustom.PLATINUM.getRelentless(), ModItems.ToolMaterialCustom.TITANIUM.getRelentless(), ModItems.ToolMaterialCustom.URANIUM.getRelentless(), ModItems.ToolMaterialCustom.TOPAZ.getRelentless()/**15*/,
            ModItems.ToolMaterialCustom.JADE.getRelentless(), ModItems.ToolMaterialCustom.TUNGSTEN.getRelentless(), ModItems.ToolMaterialCustom.TITANIUM_URANIUM.getRelentless(), ModItems.ToolMaterialCustom.TUNGSTEN_URANIUM.getRelentless(), ModItems.ToolMaterialCustom.TUNGSTEN_TITANIUM.getRelentless()/**20*/,
            ModItems.ToolMaterialCustom.EMERALD.getRelentless(), ModItems.ToolMaterialCustom.RUBY.getRelentless(), ModItems.ToolMaterialCustom.SAPPHIRE.getRelentless(), ModItems.ToolMaterialCustom.DIAMOND.getRelentless(), ModItems.ToolMaterialCustom.OLIVINE.getRelentless()/**25*/,
            ModItems.ToolMaterialCustom.WADSLEYITE.getRelentless(), ModItems.ToolMaterialCustom.RINGWOODITE.getRelentless(), ModItems.ToolMaterialCustom.BRIGMANITE.getRelentless(), ModItems.ToolMaterialCustom.MAJORITE.getRelentless(), ModItems.ToolMaterialCustom.AMAZONITE.getRelentless()/**30*/,
            ModItems.ToolMaterialCustom.ONYX.getRelentless()};
    private static final com.PlanetCore.items.tools.ItemPickaxe[] pickaxe = {ModItems.ALUMINIUM_PICKAXE, ModItems.ZINC_PICKAXE, ModItems.LEAD_PICKAXE, ModItems.TIN_PICKAXE, ModItems.SILICON_PICKAXE/**5*/,
            ModItems.COPPER_PICKAXE, ModItems.IRON_PICKAXE, ModItems.BRONZE_PICKAXE, ModItems.STEEL_PICKAXE, ModItems.SILVER_PICKAXE/**10*/,
            ModItems.GOLD_PICKAXE, ModItems.PLATINUM_PICKAXE, ModItems.TITANIUM_PICKAXE, ModItems.URANIUM_PICKAXE, ModItems.TOPAZ_PICKAXE/**15*/,
            ModItems.JADE_PICKAXE, ModItems.TUNGSTEN_PICKAXE, ModItems.TITANIUM_URANIUM_PICKAXE, ModItems.TUNGSTEN_URANIUM_PICKAXE, ModItems.TUNGSTEN_TITANIUM_PICKAXE/**20*/,
            ModItems.EMERALD_PICKAXE, ModItems.RUBY_PICKAXE, ModItems.SAPPHIRE_PICKAXE, ModItems.DIAMOND_PICKAXE, ModItems.OLIVINE_PICKAXE/**25*/,
            ModItems.WADSLEYITE_PICKAXE, ModItems.RINGWOODITE_PICKAXE, ModItems.BRIGMANITE_PICKAXE, ModItems.MAJORITE_PICKAXE, ModItems.AMAZONITE_PICKAXE/**30*/,
            ModItems.ONYX_PICKAXE};


    @SubscribeEvent
    public static void onBreakEvent(PlayerEvent.BreakSpeed event) {
        int RelentlessLevel = EnchantmentHelper.getMaxEnchantmentLevel(Relentless, event.getEntityPlayer());
        double Relentless = 0;

        if (event.getEntityPlayer().getHeldItemMainhand().getItem() == Items.WOODEN_PICKAXE) {
            if (event.getState().getMaterial() == Material.ROCK) {
                event.setNewSpeed(event.getOriginalSpeed() / 10F);
            }
        }

        if (event.getEntityPlayer().getHeldItemMainhand().getItem() == Items.STONE_PICKAXE) {
            if (event.getState().getMaterial() == Material.ROCK) {
                event.setNewSpeed(event.getOriginalSpeed() / 8F);
            }
        }

        if (event.getState().getBlock() instanceof BlockBase) {
            for (int i = 0; i < 29; i++) {
                if (event.getEntityPlayer().getHeldItemMainhand().getItem() == pickaxe[i]) {
                    Relentless = relentless[i];
                    if (RelentlessLevel > 0) {
                        Relentless = relentless[i] * (1 + (RelentlessLevel / 4D));
                    }
                    break;
                }
            }

            float breakTime = (event.getState().getBlockHardness(event.getEntityPlayer().world, event.getPos()) * 1.5F) / event.getOriginalSpeed();
            if (breakTime > Relentless) {
                event.setCanceled(true);
            }

            if (breakTime > 0.01F && breakTime <= 0.1F) {
                event.setNewSpeed(event.getOriginalSpeed() / (0.1F / breakTime));
            }
        }
    }
}