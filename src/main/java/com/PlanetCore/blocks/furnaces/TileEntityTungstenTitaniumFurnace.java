package com.PlanetCore.blocks.furnaces;

import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModFluids;
import com.PlanetCore.init.ModItems;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ItemStackHelper;
import net.minecraft.inventory.SlotFurnaceFuel;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.IFluidHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityTungstenTitaniumFurnace extends TileEntityLockable implements ITickable, IInventory {


    /** The ItemStacks that hold the items currently being used in the furnace */
    private NonNullList<ItemStack> furnaceItemStacks = NonNullList.<ItemStack>withSize(4, ItemStack.EMPTY);
    /** The number of ticks that the furnace will keep burning */
    private int furnaceBurnTime;
    /** The number of ticks that a fresh copy of the currently-burning item would keep the furnace burning for */
    private int currentItemBurnTime;
    private int cookTime;
    private int totalCookTime;
    private String furnaceCustomName;

    /**
     * Returns the number of slots in the inventory.
     */
    public int getSizeInventory()
    {
        return this.furnaceItemStacks.size();
    }

    public boolean isEmpty()
    {
        for (ItemStack itemstack : this.furnaceItemStacks)
        {
            if (!itemstack.isEmpty())
            {
                return false;
            }
        }

        return true;
    }

    /**
     * Returns the stack in the given slot.
     */
    public ItemStack getStackInSlot(int index)
    {
        return this.furnaceItemStacks.get(index);
    }

    /**
     * Removes up to a specified number of items from an inventory slot and returns them in a new stack.
     */
    public ItemStack decrStackSize(int index, int count)
    {
        return ItemStackHelper.getAndSplit(this.furnaceItemStacks, index, count);
    }

    /**
     * Removes a stack from the given slot and returns it.
     */
    public ItemStack removeStackFromSlot(int index)
    {
        return ItemStackHelper.getAndRemove(this.furnaceItemStacks, index);
    }

    /**
     * Sets the given item stack to the specified slot in the inventory (can be crafting or armor sections).
     */
    public void setInventorySlotContents(int index, ItemStack stack)
    {
        ItemStack itemstack = this.furnaceItemStacks.get(index);
        boolean flag = !stack.isEmpty() && stack.isItemEqual(itemstack) && ItemStack.areItemStackTagsEqual(stack, itemstack);
        this.furnaceItemStacks.set(index, stack);

        if (stack.getCount() > this.getInventoryStackLimit())
        {
            stack.setCount(this.getInventoryStackLimit());
        }

        if (index == 0 && !flag)
        {
            this.totalCookTime = this.getCookTime(stack);
            this.cookTime = 0;
            this.markDirty();
        }
    }


    public String getName()
    {
        return this.hasCustomName() ? this.furnaceCustomName : "container.tungsten_titanium_furnace";
    }


    public boolean hasCustomName()
    {
        return this.furnaceCustomName != null && !this.furnaceCustomName.isEmpty();
    }

    public void setCustomInventoryName(String p_145951_1_)
    {
        this.furnaceCustomName = p_145951_1_;
    }

    public static void registerFixesFurnace(DataFixer fixer)
    {
        fixer.registerWalker(FixTypes.BLOCK_ENTITY, new ItemStackDataLists(TileEntityFurnace.class, new String[] {"Items"}));
    }

    public void readFromNBT(NBTTagCompound compound)
    {
        super.readFromNBT(compound);
        this.furnaceItemStacks = NonNullList.<ItemStack>withSize(this.getSizeInventory(), ItemStack.EMPTY);
        ItemStackHelper.loadAllItems(compound, this.furnaceItemStacks);
        this.furnaceBurnTime = compound.getInteger("BurnTime");
        this.cookTime = compound.getInteger("CookTime");
        this.totalCookTime = compound.getInteger("CookTimeTotal");
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks.get(2));

        if (compound.hasKey("CustomName", 8))
        {
            this.furnaceCustomName = compound.getString("CustomName");
        }
    }

    public NBTTagCompound writeToNBT(NBTTagCompound compound)
    {
        super.writeToNBT(compound);
        compound.setInteger("BurnTime", (short)this.furnaceBurnTime);
        compound.setInteger("CookTime", (short)this.cookTime);
        compound.setInteger("CookTimeTotal", (short)this.totalCookTime);
        ItemStackHelper.saveAllItems(compound, this.furnaceItemStacks);

        if (this.hasCustomName())
        {
            compound.setString("CustomName", this.furnaceCustomName);
        }

        return compound;
    }

    /**
     * Returns the maximum stack size for a inventory slot. Seems to always be 64, possibly will be extended.
     */
    public int getInventoryStackLimit()
    {
        return 64;
    }

    /**
     * Furnace isBurning
     */
    public boolean isBurning()
    {
        return this.furnaceBurnTime > 0;
    }

    @SideOnly(Side.CLIENT)
    public static boolean isBurning(IInventory inventory)
    {
        return inventory.getField(0) > 0;
    }
    /**
     * Like the old updateEntity(), except more generic.
     */
    public void update() {
        Boolean tungsten_uranium_ingot = (this.furnaceItemStacks.get(0).getItem() == FluidUtil.getFilledBucket(new FluidStack(ModFluids.URANIUM_LAVA_FLUID, Fluid.BUCKET_VOLUME)).getItem() && this.furnaceItemStacks.get(1).getItem() == FluidUtil.getFilledBucket(new FluidStack(ModFluids.TUNGSTEN_LAVA_FLUID, Fluid.BUCKET_VOLUME)).getItem()) || (this.furnaceItemStacks.get(0).getItem() == FluidUtil.getFilledBucket(new FluidStack(ModFluids.TUNGSTEN_LAVA_FLUID, Fluid.BUCKET_VOLUME)).getItem() && this.furnaceItemStacks.get(1).getItem() == FluidUtil.getFilledBucket(new FluidStack(ModFluids.URANIUM_LAVA_FLUID, Fluid.BUCKET_VOLUME)).getItem());

        boolean flag = this.isBurning();
        boolean flag1 = false;
        if (this.isBurning()) {
            --this.furnaceBurnTime;
            if (tungsten_uranium_ingot) this.totalCookTime = 300;
        }

        if (!world.isRemote) {
            ItemStack[] inputs = new ItemStack[]{this.furnaceItemStacks.get(0), this.furnaceItemStacks.get(1)};

            ItemStack fuel = this.furnaceItemStacks.get(2);
            ItemStack result = this.furnaceItemStacks.get(3);


            if (this.furnaceItemStacks.get(0).isEmpty() && this.furnaceItemStacks.get(1).isEmpty()) {
                this.cookTime = 0;
            }


            if ((this.isBurning() || !fuel.isEmpty()) && (!this.furnaceItemStacks.get(0).isEmpty() || !this.furnaceItemStacks.get(1).isEmpty())) {
                if (!this.isBurning() && this.canSmelt()) {
                    this.furnaceBurnTime = getItemBurnTime(fuel);
                    this.currentItemBurnTime = furnaceBurnTime;

                    if (this.isBurning()) {
                        flag1 = true;
                        if (!fuel.isEmpty()) {
                            Item item = fuel.getItem();
                            fuel.shrink(1);
                            if (fuel.isEmpty()) {
                                ItemStack item1 = item.getContainerItem(fuel);
                                this.furnaceItemStacks.set(2, item1);
                            }
                        }
                    }
                }
                if (this.isBurning() && this.canSmelt()) {
                    cookTime++;

                    if (cookTime == totalCookTime) {
                        this.cookTime = 0;
                        if (this.furnaceItemStacks.get(0).isEmpty() && this.furnaceItemStacks.get(1).isEmpty()) {
                            return;
                        }
                        if (this.canSmelt()) {
                            if (result.isEmpty()) {
                                furnaceItemStacks.set(3, new ItemStack(ModItems.TUNGSTEN_URANIUM_INGOT, 1));
                                inputs[1].shrink(1);
                                inputs[0].shrink(1);
                            }
                            else {
                                this.furnaceItemStacks.get(3).grow(1);
                                inputs[1].shrink(1);
                                inputs[0].shrink(1);
                            }

                        }
                        flag1 = true;
                    }
                } else {
                    this.cookTime = 0;
                }
            }
            if (flag != this.isBurning()) {
                flag1 = true;
                TungstenTitaniumFurnace.setState(this.isBurning(), this.world, this.pos);
            }
        }
        if (flag1) {
            this.markDirty();
        }
    }

    public int getCookTime(ItemStack stack)
    {
        return 200;
    }

    /**
     * Returns true if the furnace can smelt an item, i.e. has a source item, destination stack isn't full, etc.
     */
    private boolean canSmelt()
    {
        ItemStack[] inputs = new ItemStack[]{this.furnaceItemStacks.get(0), this.furnaceItemStacks.get(1)};
        Boolean tungsten_uranium_ingot = (this.furnaceItemStacks.get(0).getItem() == FluidUtil.getFilledBucket(new FluidStack(ModFluids.URANIUM_LAVA_FLUID, Fluid.BUCKET_VOLUME)).getItem() && this.furnaceItemStacks.get(1).getItem() == FluidUtil.getFilledBucket(new FluidStack(ModFluids.TUNGSTEN_LAVA_FLUID, Fluid.BUCKET_VOLUME)).getItem()) || (this.furnaceItemStacks.get(0).getItem() == FluidUtil.getFilledBucket(new FluidStack(ModFluids.TUNGSTEN_LAVA_FLUID, Fluid.BUCKET_VOLUME)).getItem() && this.furnaceItemStacks.get(1).getItem() == FluidUtil.getFilledBucket(new FluidStack(ModFluids.URANIUM_LAVA_FLUID, Fluid.BUCKET_VOLUME)).getItem());

        Boolean canSmelt = (tungsten_uranium_ingot);

        if (canSmelt && this.furnaceItemStacks.get(3).getCount() <= 64)
        {
            if (!furnaceItemStacks.get(3).isEmpty() && (tungsten_uranium_ingot) && furnaceItemStacks.get(3).getItem() != ModItems.TUNGSTEN_URANIUM_INGOT) return false;
            else if ((tungsten_uranium_ingot) && inputs[0].getCount() < 1) return false;
            else if ((tungsten_uranium_ingot) && inputs[1].getCount() < 1) return false;
            else return true;
        }
        else return false;
    }

    /**
     * Returns the number of ticks that the supplied fuel item will keep the furnace burning, or 0 if the item isn't
     * fuel
     */
    public static int getItemBurnTime(ItemStack stack)
    {
        if (stack.isEmpty())
        {
            return 0;
        }
        else
        {
            Item item = stack.getItem();
            if (item == FluidUtil.getFilledBucket(new FluidStack(ModFluids.TUNGSTEN_LAVA_FLUID, Fluid.BUCKET_VOLUME)).getItem())
            {
                return 5000;
            }
            else
            {
                return 0;
            }
        }
    }

    public static boolean isItemFuel(ItemStack stack)
    {
        return getItemBurnTime(stack) > 0;
    }

    /**
     * Don't rename this method to canInteractWith due to conflicts with Container
     */
    public boolean isUsableByPlayer(EntityPlayer player)
    {
        if (this.world.getTileEntity(this.pos) != this)
        {
            return false;
        }
        else
        {
            return player.getDistanceSq((double)this.pos.getX() + 0.5D, (double)this.pos.getY() + 0.5D, (double)this.pos.getZ() + 0.5D) <= 64.0D;
        }
    }

    public void openInventory(EntityPlayer player)
    {
    }

    public void closeInventory(EntityPlayer player)
    {
    }

    /**
     * Returns true if automation is allowed to insert the given stack (ignoring stack size) into the given slot. For
     * guis use Slot.isItemValid
     */
    public boolean isItemValidForSlot(int index, ItemStack stack)
    {
        if (index == 2)
        {
            return false;
        }
        else if (index != 1)
        {
            return true;
        }
        else
        {
            return isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack);
        }
    }

    /**
     * Returns true if automation can insert the given item in the given slot from the given side.
     */
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
    {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    public String getGuiID()
    {
        return "planetcore:tungsten_titanium_furnace";
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new ContainerTungstenTitaniumFurnace(playerInventory, this);
    }

    public int getField(int id)
    {
        switch (id)
        {
            case 0:
                return this.furnaceBurnTime;
            case 1:
                return this.currentItemBurnTime;
            case 2:
                return this.cookTime;
            case 3:
                return this.totalCookTime;
            default:
                return 0;
        }
    }

    public void setField(int id, int value)
    {
        switch (id)
        {
            case 0:
                this.furnaceBurnTime = value;
                break;
            case 1:
                this.currentItemBurnTime = value;
                break;
            case 2:
                this.cookTime = value;
                break;
            case 3:
                this.totalCookTime = value;
        }
    }

    public int getFieldCount()
    {
        return 4;
    }

    public void clear()
    {
        this.furnaceItemStacks.clear();
    }
}