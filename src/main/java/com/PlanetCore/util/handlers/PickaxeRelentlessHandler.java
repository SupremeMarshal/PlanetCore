package com.PlanetCore.util.handlers;

import com.PlanetCore.asm.mixin.ItemToolAccess;
import com.PlanetCore.blocks.BlockBase;
import com.PlanetCore.blocks.SuperCompressedOreBlock;
import com.PlanetCore.init.EnchantmentInit;
import com.PlanetCore.init.ModItems;
import com.PlanetCore.init.ModToolMaterials;
import com.PlanetCore.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemTool;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.HashMap;
import java.util.Map;

@Mod.EventBusSubscriber(modid= Reference.MOD_ID)
public class PickaxeRelentlessHandler {

    private static final Map<Item, Float> relentlessMap = new HashMap<>();
    public static final SoundEvent[] sound = {SoundHandler.INDESTRUCTIBLE, SoundHandler.INDESTRUCTIBLE1, SoundHandler.INDESTRUCTIBLE2, SoundHandler.INDESTRUCTIBLE3, SoundHandler.INDESTRUCTIBLE4, SoundHandler.INDESTRUCTIBLE5, SoundHandler.INDESTRUCTIBLE6, SoundHandler.INDESTRUCTIBLE7, SoundHandler.INDESTRUCTIBLE8, SoundHandler.INDESTRUCTIBLE9, SoundHandler.INDESTRUCTIBLE10, SoundHandler.INDESTRUCTIBLE11, SoundHandler.INDESTRUCTIBLE12, SoundHandler.INDESTRUCTIBLE13, SoundHandler.INDESTRUCTIBLE14, SoundHandler.INDESTRUCTIBLE15, SoundHandler.INDESTRUCTIBLE16, SoundHandler.INDESTRUCTIBLE17, SoundHandler.INDESTRUCTIBLE18, SoundHandler.INDESTRUCTIBLE19 };

    @SubscribeEvent
    public static void onBreakEvent(PlayerEvent.BreakSpeed event) {
        EntityPlayer player = event.getEntityPlayer();
        BlockPos pos = event.getPos();
        IBlockState state = event.getState();
        event.setCanceled(handleRelentless(player,state,pos, false));
    }

    public static void buildRelentlessMap() {

        relentlessMap.put(Items.IRON_PICKAXE,1.5F);
        relentlessMap.put(Items.GOLDEN_PICKAXE,1.5F);
        relentlessMap.put(Items.DIAMOND_PICKAXE,2.5F);

        relentlessMap.put(ModItems.IRON_DRILL,10f);

        for (Item item: Item.REGISTRY) {
            if (item instanceof ItemTool) {
                ItemTool itemTool = (ItemTool) item;
                Item.ToolMaterial toolMaterial = ((ItemToolAccess)itemTool).getToolMaterial();
                if (ModToolMaterials.toolMaterials.containsKey(toolMaterial)) {
                    relentlessMap.put(item,ModToolMaterials.toolMaterials.get(toolMaterial));
                }
            }
        }
    }

    @SubscribeEvent
    public static void breakBlock(BlockEvent.BreakEvent e) {
        EntityPlayer player = e.getPlayer();
        BlockPos pos = e.getPos();
        IBlockState state = e.getState();
        e.setCanceled(handleRelentless(player,state,pos, true));
    }

    private static boolean handleRelentless(EntityPlayer player, IBlockState state, BlockPos pos, boolean aboutToBreak) {
        if (player.capabilities.isCreativeMode) return false;
        ItemStack stack = player.getHeldItemMainhand();
        if (state.getBlock() instanceof BlockBase && !(state.getBlock() instanceof SuperCompressedOreBlock)) {
            float blockHardness = state.getBlockHardness(player.world,pos);
            float relentless = getRelentless(stack);
            float breaktime = blockHardness * 1.5F / stack.getDestroySpeed(state);//is there a better way?

            //Determine if the block is indestructible.
            if (breaktime > relentless) {
                return true;
            }
        }
        return false;
    }

    public static boolean holdingPickaxe(EntityPlayer player) {
        ItemStack stack = player.getHeldItemMainhand();
        return stack.getItem().getToolClasses(stack).contains("pickaxe");
    }


    public static float getRelentless(ItemStack stack) {
        Item item = stack.getItem();
        float base = relentlessMap.getOrDefault(item,2f);
        float enchLevel = EnchantmentHelper.getEnchantmentLevel(EnchantmentInit.Relentless,stack);
        return base + enchLevel / 2;
    }
}