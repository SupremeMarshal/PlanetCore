package com.PlanetCore.menu;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.items.SlotItemHandler;

public class LavaGeneratorMenu extends Container {

    private final EntityPlayer player;

    public LavaGeneratorMenu(EntityPlayer player, ItemStackHandler inventory) {
        this.player = player;
        addSlotToContainer(new SlotItemHandler(inventory,0,100,50));
        addPlayerSlots(player.inventory);
    }

    public void addPlayerSlots(InventoryPlayer playerInventory) {
        int i = 8;
        int j = 84;

        for (int k = 0; k < 3; ++k) {
            for (int l = 0; l < 9; ++l) {
                this.addSlotToContainer(new Slot(playerInventory, l + k * 9 + 9, i + l * 18, j + k * 18));
            }
        }

        for (int i1 = 0; i1 < 9; ++i1) {
            this.addSlotToContainer(new Slot(playerInventory, i1, i + i1 * 18, j + 58));
        }
    }

    public EntityPlayer getPlayer() {
        return player;
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn) {
        return true;//todo, range check
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        
        int sc = 1;
        
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index < sc)
            {
                if (!this.mergeItemStack(itemstack1, sc, this.inventorySlots.size(), true))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 0, sc, false))
            {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty())
            {
                slot.putStack(ItemStack.EMPTY);
            }
            else
            {
                slot.onSlotChanged();
            }
        }

        return itemstack;
    }
}
