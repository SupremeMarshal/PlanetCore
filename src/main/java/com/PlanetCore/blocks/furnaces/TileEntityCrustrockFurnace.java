package com.PlanetCore.blocks.furnaces;

import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFurnace;
import net.minecraft.block.material.Material;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.*;
import net.minecraft.item.*;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.tileentity.TileEntityLockable;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.NonNullList;
import net.minecraft.util.datafix.DataFixer;
import net.minecraft.util.datafix.FixTypes;
import net.minecraft.util.datafix.walkers.ItemStackDataLists;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import scala.Console;

import java.util.Random;

public class TileEntityCrustrockFurnace extends TileEntityLockable implements ITickable, IInventory {


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
        return this.hasCustomName() ? this.furnaceCustomName : "container.crustrock_furnace";
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
        this.currentItemBurnTime = getItemBurnTime(this.furnaceItemStacks.get(1));

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
        Boolean steel_ingot = (this.furnaceItemStacks.get(0).getItem() == ModItems.IRON_INGOT && this.furnaceItemStacks.get(1).getItem() == Item.getItemFromBlock(Blocks.COAL_BLOCK)) || (this.furnaceItemStacks.get(0).getItem() == Item.getItemFromBlock(Blocks.COAL_BLOCK) && this.furnaceItemStacks.get(1).getItem() == ModItems.IRON_INGOT);
        Boolean steel_ingot1 = (this.furnaceItemStacks.get(0).getItem() == Items.COAL && this.furnaceItemStacks.get(1).getItem() == ModItems.IRON_INGOT);
        Boolean steel_ingot2 = (this.furnaceItemStacks.get(0).getItem() == ModItems.IRON_INGOT && this.furnaceItemStacks.get(1).getItem() == Items.COAL);
        Boolean bronze_ingot = (this.furnaceItemStacks.get(0).getItem() == ModItems.TIN_INGOT && this.furnaceItemStacks.get(1).getItem() == ModItems.COPPER_INGOT) || (this.furnaceItemStacks.get(0).getItem() == ModItems.COPPER_INGOT && this.furnaceItemStacks.get(1).getItem() == ModItems.TIN_INGOT);
        Boolean titanium_uranium_ingot = (this.furnaceItemStacks.get(0).getItem() == ModItems.TITANIUM_INGOT && this.furnaceItemStacks.get(1).getItem() == ModItems.URANIUM_INGOT) || (this.furnaceItemStacks.get(0).getItem() == ModItems.URANIUM_INGOT && this.furnaceItemStacks.get(1).getItem() == ModItems.TITANIUM_INGOT);
        Boolean tungsten_uranium_ingot = (this.furnaceItemStacks.get(0).getItem() == ModItems.URANIUM_INGOT && this.furnaceItemStacks.get(1).getItem() == ModItems.TUNGSTEN_INGOT) || (this.furnaceItemStacks.get(0).getItem() == ModItems.TUNGSTEN_INGOT && this.furnaceItemStacks.get(1).getItem() == ModItems.URANIUM_INGOT);
        Boolean tungsten_titanium_ingot = (this.furnaceItemStacks.get(0).getItem() == ModItems.TITANIUM_INGOT && this.furnaceItemStacks.get(1).getItem() == ModItems.TUNGSTEN_INGOT) || (this.furnaceItemStacks.get(0).getItem() == ModItems.TUNGSTEN_INGOT && this.furnaceItemStacks.get(1).getItem() == ModItems.TITANIUM_INGOT);

        boolean flag = this.isBurning();
        boolean flag1 = false;
        if (this.isBurning()) {
            --this.furnaceBurnTime;
            if (steel_ingot || steel_ingot1 || steel_ingot2) this.totalCookTime = 1000;
            if (bronze_ingot) this.totalCookTime = 250;
            if (titanium_uranium_ingot) this.totalCookTime = 500;
            if (tungsten_uranium_ingot) this.totalCookTime = 750;
            if (tungsten_titanium_ingot) this.totalCookTime = 1000;
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

                                if (steel_ingot || steel_ingot1 || steel_ingot2) furnaceItemStacks.set(3, new ItemStack(ModItems.STEEL_INGOT, 1));
                                if (bronze_ingot) furnaceItemStacks.set(3, new ItemStack(ModItems.BRONZE_INGOT, 1));
                                if (titanium_uranium_ingot) furnaceItemStacks.set(3, new ItemStack(ModItems.TITANIUM_URANIUM_INGOT, 1));
                                if (tungsten_uranium_ingot) furnaceItemStacks.set(3, new ItemStack(ModItems.TUNGSTEN_URANIUM_INGOT, 1));
                                if (tungsten_titanium_ingot) furnaceItemStacks.set(3, new ItemStack(ModItems.TUNGSTEN_TITANIUM_INGOT, 1));

                                if (steel_ingot1)
                                {
                                    inputs[0].shrink(8);
                                    inputs[1].shrink(1);
                                }
                                if (steel_ingot2)
                                {
                                    inputs[1].shrink(8);
                                    inputs[0].shrink(1);
                                }
                                if (bronze_ingot || titanium_uranium_ingot || tungsten_uranium_ingot || tungsten_titanium_ingot)
                                {
                                    inputs[1].shrink(2);
                                    inputs[0].shrink(2);
                                }


                            } else {
                                this.furnaceItemStacks.get(3).grow(1);
                                if (steel_ingot1)
                                {
                                    inputs[0].shrink(8);
                                    inputs[1].shrink(1);
                                }
                                if (steel_ingot2)
                                {
                                    inputs[1].shrink(8);
                                    inputs[0].shrink(1);
                                }
                                if (bronze_ingot || titanium_uranium_ingot || tungsten_uranium_ingot || tungsten_titanium_ingot)
                                {
                                    inputs[1].shrink(2);
                                    inputs[0].shrink(2);
                                }
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
                CrustrockFurnace.setState(this.isBurning(), this.world, this.pos);
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
        Boolean steel_ingot = (this.furnaceItemStacks.get(0).getItem() == ModItems.IRON_INGOT && this.furnaceItemStacks.get(1).getItem() == Item.getItemFromBlock(Blocks.COAL_BLOCK)) || (this.furnaceItemStacks.get(0).getItem() == Item.getItemFromBlock(Blocks.COAL_BLOCK) && this.furnaceItemStacks.get(1).getItem() == ModItems.IRON_INGOT);
        Boolean steel_ingot1 = (this.furnaceItemStacks.get(0).getItem() == Items.COAL && this.furnaceItemStacks.get(1).getItem() == ModItems.IRON_INGOT);
        Boolean steel_ingot2 = (this.furnaceItemStacks.get(0).getItem() == ModItems.IRON_INGOT && this.furnaceItemStacks.get(1).getItem() == Items.COAL);
        Boolean bronze_ingot = (this.furnaceItemStacks.get(0).getItem() == ModItems.TIN_INGOT && this.furnaceItemStacks.get(1).getItem() == ModItems.COPPER_INGOT) || (this.furnaceItemStacks.get(0).getItem() == ModItems.COPPER_INGOT && this.furnaceItemStacks.get(1).getItem() == ModItems.TIN_INGOT);
        Boolean titanium_uranium_ingot = (this.furnaceItemStacks.get(0).getItem() == ModItems.TITANIUM_INGOT && this.furnaceItemStacks.get(1).getItem() == ModItems.URANIUM_INGOT) || (this.furnaceItemStacks.get(0).getItem() == ModItems.URANIUM_INGOT && this.furnaceItemStacks.get(1).getItem() == ModItems.TITANIUM_INGOT);
        Boolean tungsten_uranium_ingot = (this.furnaceItemStacks.get(0).getItem() == ModItems.URANIUM_INGOT && this.furnaceItemStacks.get(1).getItem() == ModItems.TUNGSTEN_INGOT) || (this.furnaceItemStacks.get(0).getItem() == ModItems.TUNGSTEN_INGOT && this.furnaceItemStacks.get(1).getItem() == ModItems.URANIUM_INGOT);
        Boolean tungsten_titanium_ingot = (this.furnaceItemStacks.get(0).getItem() == ModItems.TITANIUM_INGOT && this.furnaceItemStacks.get(1).getItem() == ModItems.TUNGSTEN_INGOT) || (this.furnaceItemStacks.get(0).getItem() == ModItems.TUNGSTEN_INGOT && this.furnaceItemStacks.get(1).getItem() == ModItems.TITANIUM_INGOT);

        Boolean canSmelt = (
                steel_ingot || steel_ingot1 || steel_ingot2 || bronze_ingot || titanium_uranium_ingot
                || tungsten_uranium_ingot || tungsten_titanium_ingot
        );

        if (canSmelt && this.furnaceItemStacks.get(3).getCount() <= 64)
        {

            if (!furnaceItemStacks.get(3).isEmpty() && (bronze_ingot) && furnaceItemStacks.get(3).getItem() != ModItems.BRONZE_INGOT) return false;
            if (!furnaceItemStacks.get(3).isEmpty() && (titanium_uranium_ingot) && furnaceItemStacks.get(3).getItem() != ModItems.TITANIUM_URANIUM_INGOT) return false;
            if (!furnaceItemStacks.get(3).isEmpty() && (tungsten_uranium_ingot) && furnaceItemStacks.get(3).getItem() != ModItems.TUNGSTEN_URANIUM_INGOT) return false;
            if (!furnaceItemStacks.get(3).isEmpty() && (tungsten_titanium_ingot) && furnaceItemStacks.get(3).getItem() != ModItems.TUNGSTEN_TITANIUM_INGOT) return false;
            if (steel_ingot1 && inputs[0].getCount() < 9) return false;
            if (steel_ingot2 && inputs[1].getCount() < 9) return false;
            if (bronze_ingot && inputs[0].getCount() < 2 || bronze_ingot && inputs[1].getCount() < 2) return false;
            if ((titanium_uranium_ingot || tungsten_uranium_ingot || tungsten_titanium_ingot) && inputs[0].getCount() < 2) return false;
            if ((titanium_uranium_ingot || tungsten_uranium_ingot || tungsten_titanium_ingot) && inputs[1].getCount() < 2) return false;
            return true;
        }
        else return false;
    }

    /**
     * Turn one item from the furnace source stack into the appropriate smelted item in the furnace result stack
     */
    public void smeltItem()
    {
        if (this.canSmelt())
        {
            ItemStack itemstack = this.furnaceItemStacks.get(0);
            ItemStack itemstack1 = FurnaceRecipes.instance().getSmeltingResult(itemstack);
            ItemStack itemstack2 = this.furnaceItemStacks.get(2);

            if (itemstack2.isEmpty())
            {
                this.furnaceItemStacks.set(2, itemstack1.copy());
            }
            else if (itemstack2.getItem() == itemstack1.getItem())
            {
                itemstack2.grow(itemstack1.getCount());
            }

            if (itemstack.getItem() == Item.getItemFromBlock(Blocks.SPONGE) && itemstack.getMetadata() == 1 && !((ItemStack)this.furnaceItemStacks.get(1)).isEmpty() && ((ItemStack)this.furnaceItemStacks.get(1)).getItem() == Items.BUCKET)
            {
                this.furnaceItemStacks.set(1, new ItemStack(Items.WATER_BUCKET));
            }

            itemstack.shrink(1);
        }
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
            int burnTime = net.minecraftforge.event.ForgeEventFactory.getItemBurnTime(stack);
            if (burnTime >= 0) return burnTime;
            Item item = stack.getItem();

            if (item == Item.getItemFromBlock(Blocks.WOODEN_SLAB))
            {
                return 75;
            }
            else if (item == Item.getItemFromBlock(Blocks.WOOL))
            {
                return 50;
            }
            else if (item == Item.getItemFromBlock(Blocks.CARPET))
            {
                return 10;
            }
            else if (item == Item.getItemFromBlock(Blocks.LADDER))
            {
                return 100;
            }
            else if (item == Item.getItemFromBlock(Blocks.WOODEN_BUTTON))
            {
                return 50;
            }
            else if (Block.getBlockFromItem(item).getDefaultState().getMaterial() == Material.WOOD)
            {
                return 150;
            }
            else if (item == Item.getItemFromBlock(Blocks.COAL_BLOCK))
            {
                return 5333;
            }
            else if (item instanceof ItemTool && "WOOD".equals(((ItemTool)item).getToolMaterialName()))
            {
                return 80;
            }
            else if (item instanceof ItemSword && "WOOD".equals(((ItemSword)item).getToolMaterialName()))
            {
                return 80;
            }
            else if (item instanceof ItemHoe && "WOOD".equals(((ItemHoe)item).getMaterialName()))
            {
                return 80;
            }
            else if (item == Items.STICK)
            {
                return 20;
            }
            else if (item != Items.BOW && item != Items.FISHING_ROD)
            {
                if (item == Items.SIGN)
                {
                    return 50;
                }
                else if (item == Items.COAL)
                {
                    return 600;
                }
                else if (item == Items.LAVA_BUCKET)
                {
                    return 6666;
                }
                else if (item != Item.getItemFromBlock(Blocks.SAPLING) && item != Items.BOWL)
                {
                    if (item == Items.BLAZE_ROD)
                    {
                        return 1200;
                    }
                    else if (item instanceof ItemDoor && item != Items.IRON_DOOR)
                    {
                        return 100;
                    }
                    else
                    {
                        return item instanceof ItemBoat ? 200 : 0;
                    }
                }
                else
                {
                    return 50;
                }
            }
            else
            {
                return 150;
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
            ItemStack itemstack = this.furnaceItemStacks.get(1);
            return isItemFuel(stack) || SlotFurnaceFuel.isBucket(stack) && itemstack.getItem() != Items.BUCKET;
        }
    }


    /**
     * Returns true if automation can insert the given item in the given slot from the given side.
     */
    public boolean canInsertItem(int index, ItemStack itemStackIn, EnumFacing direction)
    {
        return this.isItemValidForSlot(index, itemStackIn);
    }

    /**
     * Returns true if automation can extract the given item in the given slot from the given side.
     */
    public boolean canExtractItem(int index, ItemStack stack, EnumFacing direction)
    {
        if (direction == EnumFacing.DOWN && index == 1)
        {
            Item item = stack.getItem();

            if (item != Items.WATER_BUCKET && item != Items.BUCKET)
            {
                return false;
            }
        }

        return true;
    }

    public String getGuiID()
    {
        return "planetcore:crustrock_furnace";
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new ContainerCrustrockFurnace(playerInventory, this);
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