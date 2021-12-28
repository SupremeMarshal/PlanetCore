package com.PlanetCore.blocks.furnaces;



import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.*;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class ContainerTitaniumFurnace extends Container
{
    private final IInventory tileFurnace;
    private int cookTime, totalCookTime, burnTime, currentBurnTime;

    public ContainerTitaniumFurnace(InventoryPlayer playerInventory, IInventory furnaceInventory)
    {
        this.tileFurnace = furnaceInventory;

        this.addSlotToContainer(new Slot(furnaceInventory, 0, 25, 11));
        this.addSlotToContainer(new Slot(furnaceInventory, 1, 68, 11));
        this.addSlotToContainer(new SlotTitaniumFurnaceFuel(furnaceInventory, 2, 10, 45));
        this.addSlotToContainer(new SlotFurnaceOutput(playerInventory.player, furnaceInventory, 3, 106, 27));

        for(int y = 0; y < 3; y++)
        {
            for(int x = 0; x < 9; x++)
            {
                this.addSlotToContainer(new Slot(playerInventory, x + y*9 + 9, 8 + x*18, 84 + y*18));
            }
        }

        for(int x = 0; x < 9; x++)
        {
            this.addSlotToContainer(new Slot(playerInventory, x, 8 + x * 18, 142));
        }
    }

    @Override
    public void detectAndSendChanges()
    {
        super.detectAndSendChanges();

        for(int i = 0; i < this.listeners.size(); ++i)
        {
            IContainerListener listener = (IContainerListener)this.listeners.get(i);

            if(this.cookTime != this.tileFurnace.getField(2)) listener.sendWindowProperty(this, 2, this.tileFurnace.getField(2));
            if(this.burnTime != this.tileFurnace.getField(0)) listener.sendWindowProperty(this, 0, this.tileFurnace.getField(0));
            if(this.currentBurnTime != this.tileFurnace.getField(1)) listener.sendWindowProperty(this, 1, this.tileFurnace.getField(1));
            if(this.totalCookTime != this.tileFurnace.getField(3)) listener.sendWindowProperty(this, 3, this.tileFurnace.getField(3));
        }

        this.cookTime = this.tileFurnace.getField(2);
        this.burnTime = this.tileFurnace.getField(0);
        this.currentBurnTime = this.tileFurnace.getField(1);
        this.totalCookTime = this.tileFurnace.getField(3);
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data)
    {
        this.tileFurnace.setField(id, data);
    }

    @Override
    public boolean canInteractWith(EntityPlayer playerIn)
    {
        return this.tileFurnace.isUsableByPlayer(playerIn);
    }

    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index)
    {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.inventorySlots.get(index);

        if (slot != null && slot.getHasStack())
        {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();

            if (index == 3)
            {
                if (!this.mergeItemStack(itemstack1, 4, 40, true))
                {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            }
            else if (index != 0 && index != 1 && index != 2)
            {
                if (!FurnaceRecipes.instance().getSmeltingResult(itemstack1).isEmpty())
                {
                    if (!this.mergeItemStack(itemstack1, 0, 1, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (TileEntityFurnace.isItemFuel(itemstack1))
                {
                    if (!this.mergeItemStack(itemstack1, 1, 2, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 3 && index < 30)
                {
                    if (!this.mergeItemStack(itemstack1, 31, 40, false))
                    {
                        return ItemStack.EMPTY;
                    }
                }
                else if (index >= 30 && index < 39 && !this.mergeItemStack(itemstack1, 3, 30, false))
                {
                    return ItemStack.EMPTY;
                }
            }
            else if (!this.mergeItemStack(itemstack1, 3, 40, false))
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

            if (itemstack1.getCount() == itemstack.getCount())
            {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }

}