package com.PlanetCore.blocks.furnaces;

import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntityFurnace;

    public class SlotTungstenTitaniumFurnaceFuel extends Slot
    {
        public SlotTungstenTitaniumFurnaceFuel(IInventory inventoryIn, int slotIndex, int xPosition, int yPosition)
        {
            super(inventoryIn, slotIndex, xPosition, yPosition);
        }

        /**
         * Check if the stack is allowed to be placed in this slot, used for armor slots as well as furnace fuel.
         */
        public boolean isItemValid(ItemStack stack)
        {
            return TileEntityTungstenTitaniumFurnace.isItemFuel(stack) || isBucket(stack);
        }

        public int getItemStackLimit(ItemStack stack)
        {
            return isBucket(stack) ? 1 : super.getItemStackLimit(stack);
        }

        public static boolean isBucket(ItemStack stack)
        {
            return stack.getItem() == Items.BUCKET;
        }
}
