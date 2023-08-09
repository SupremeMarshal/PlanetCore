package com.PlanetCore.util.handlers;

import com.PlanetCore.blocks.BlockBase;
import com.PlanetCore.blocks.GemsGravel;
import com.PlanetCore.init.ToolMaterials;
import com.PlanetCore.util.Reference;
import net.minecraft.block.state.IBlockState;
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
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Random;

import static com.PlanetCore.init.EnchantmentInit.Relentless;

@Mod.EventBusSubscriber(modid= Reference.MOD_ID)
public class PickaxeRelentlessHandler {

    private static final SoundEvent[] sound = {SoundHandler.INDESTRUCTIBLE, SoundHandler.INDESTRUCTIBLE1, SoundHandler.INDESTRUCTIBLE2, SoundHandler.INDESTRUCTIBLE3, SoundHandler.INDESTRUCTIBLE4, SoundHandler.INDESTRUCTIBLE5, SoundHandler.INDESTRUCTIBLE6, SoundHandler.INDESTRUCTIBLE7, SoundHandler.INDESTRUCTIBLE8, SoundHandler.INDESTRUCTIBLE9, SoundHandler.INDESTRUCTIBLE10, SoundHandler.INDESTRUCTIBLE11, SoundHandler.INDESTRUCTIBLE12, SoundHandler.INDESTRUCTIBLE13, SoundHandler.INDESTRUCTIBLE14, SoundHandler.INDESTRUCTIBLE15, SoundHandler.INDESTRUCTIBLE16, SoundHandler.INDESTRUCTIBLE17, SoundHandler.INDESTRUCTIBLE18, SoundHandler.INDESTRUCTIBLE19 };

    @SubscribeEvent
    public static void onBreakEvent(PlayerEvent.BreakSpeed event) {
        EntityPlayer player = event.getEntityPlayer();
        int RelentlessLevel = EnchantmentHelper.getMaxEnchantmentLevel(Relentless, player);
        BlockPos pos = event.getPos();
        IBlockState state = event.getState();
        event.setCanceled(handleRelentless(player,state,pos,RelentlessLevel,false));
    }

    @SubscribeEvent
    public static void breakBlock(BlockEvent.BreakEvent e) {
        EntityPlayer player = e.getPlayer();
        int RelentlessLevel = EnchantmentHelper.getMaxEnchantmentLevel(Relentless, player);
        BlockPos pos = e.getPos();
        IBlockState state = e.getState();
        e.setCanceled(handleRelentless(player,state,pos,RelentlessLevel,true));
    }

    private static boolean handleRelentless(EntityPlayer player, IBlockState state, BlockPos pos,int relentlessEnchant,boolean aboutToBreak) {
        if (player.capabilities.isCreativeMode) return false;
        ItemStack stack = player.getHeldItemMainhand();
        if (state.getBlock() instanceof BlockBase) {
            float blockHardness = state.getBlockHardness(player.world,pos);
            float Relentless = holdingPickaxe(player) ? getRelentless(stack) : 1;
            float breaktime = blockHardness * 1.5F / stack.getDestroySpeed(state);//is there a better way?

            //Determine if the block is undestructible.
            if (breaktime > Relentless) {
                if (!aboutToBreak) {
                    if (holdingPickaxe(player) && player.world.getTotalWorldTime() % 6 == 1) {
                        player.world.playSound(player, player.getPosition(), sound[new Random().nextInt(20)], SoundCategory.BLOCKS, 1.0F, 1.0F);
                    } else if (player.getEntityWorld().isRemote && player.world.getTotalWorldTime() % 140 == 1) {
                        player.sendMessage(new TextComponentString("Block is indestructible!"));
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static boolean holdingPickaxe(EntityPlayer player) {
        ItemStack stack = player.getHeldItemMainhand();
        return stack.getItem().getToolClasses(stack).contains("pickaxe");
    }


    public static float getRelentless(ItemStack stack) {
        Item item = stack.getItem();
        if (item instanceof ItemTool) {
            Item.ToolMaterial toolMaterial = ObfuscationReflectionHelper.getPrivateValue(ItemTool.class,(ItemTool)item,"field_77862_b");
            float base = ToolMaterials.relentlessMap.getOrDefault(toolMaterial,2.0F);
            if (stack.getItem() == Items.IRON_PICKAXE) base = ToolMaterials.relentlessMap.getOrDefault(toolMaterial,1.5F);
            if (stack.getItem() == Items.GOLDEN_PICKAXE) base = ToolMaterials.relentlessMap.getOrDefault(toolMaterial,1.5F);
            if (stack.getItem() == Items.DIAMOND_PICKAXE) base = ToolMaterials.relentlessMap.getOrDefault(toolMaterial,2.5F);
            float enchLevel = EnchantmentHelper.getEnchantmentLevel(Relentless,stack);
            return base + (enchLevel / 2);
        }
        return 2;
    }
}