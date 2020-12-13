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

public class TileEntitySinteringFurnace extends TileEntityLockable implements ITickable, IInventory {


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
        return this.hasCustomName() ? this.furnaceCustomName : "container.sintering_furnace";
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
        Boolean empty_slot0 = this.furnaceItemStacks.get(0).isEmpty();
        Boolean empty_slot1 = this.furnaceItemStacks.get(1).getCount() == 0;
        Boolean small_tin_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("small_tin");
        Boolean small_tin_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("small_tin");
        Boolean small_copper_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("small_copper");
        Boolean small_copper_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("small_copper");
        Boolean bronze_nugget = ((small_tin_slot0 && small_copper_slot1) || (small_copper_slot0 && small_tin_slot1));
        Boolean tin_slot0 = (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("ore_tin") || (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("crustrock_tin")) || (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("mantlerock_tin")));
        Boolean tin_slot1 = (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("ore_tin") || (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("crustrock_tin")) || (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("mantlerock_tin")));
        Boolean copper_slot0 = (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("ore_copper") || (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("crustrock_copper")) || (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("mantlerock_copper")));
        Boolean copper_slot1 = (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("ore_copper") || (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("crustrock_copper")) || (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("mantlerock_copper")));
        Boolean bronze_ingot = ((tin_slot0 && copper_slot1) || (copper_slot0 && tin_slot1));
        Boolean compact_tin_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("compact_tin");
        Boolean compact_tin_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("compact_tin");
        Boolean compact_copper_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("compact_copper");
        Boolean compact_copper_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("compact_copper");
        Boolean tin_supercompact_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("tin_supercompact");
        Boolean tin_supercompact_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("tin_supercompact");
        Boolean copper_supercompact_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("copper_supercompact");
        Boolean copper_supercompact_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("copper_supercompact");
        Boolean bronze_compact = ((compact_tin_slot0 && compact_copper_slot1) || (compact_copper_slot0 && compact_tin_slot1));
        Boolean bronze_block = (tin_supercompact_slot0 && copper_supercompact_slot1) || (tin_supercompact_slot1 && copper_supercompact_slot0);
        Boolean small_iron_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("small_iron");
        Boolean small_iron_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("small_iron");
        Boolean iron_slot0 = (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("ore_iron") || (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("crustrock_iron")) || (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("mantlerock_iron")));
        Boolean iron_slot1 = (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("ore_iron") || (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("crustrock_iron")) || (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("mantlerock_iron")));
        Boolean compact_iron_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("compact_iron");
        Boolean compact_iron_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("compact_iron");
        Boolean iron_supercompact_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("iron_supercompact");
        Boolean iron_supercompact_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("iron_supercompact");
        Boolean iron_nugget_50 = ((small_iron_slot0 && small_iron_slot1) || (small_iron_slot0 && small_iron_slot1)) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == ModItems.IRON_NUGGET);
        Boolean iron_nugget_25 = ((small_iron_slot0 && empty_slot1) || (empty_slot0 && small_iron_slot1)) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == ModItems.IRON_NUGGET);
        Boolean iron_ingot_50 = ((iron_slot0 && iron_slot1) || (iron_slot0 && iron_slot1)) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == ModItems.IRON_INGOT);
        Boolean iron_ingot_25 = ((iron_slot0 && empty_slot1) || (empty_slot0 && iron_slot1)) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == ModItems.IRON_INGOT);
        Boolean iron_compact_150 = ((compact_iron_slot0 && compact_iron_slot1) || (compact_iron_slot0 && compact_iron_slot1)) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == ModItems.IRON_INGOT);
        Boolean iron_compact_75 = ((compact_iron_slot0 && empty_slot1) || (empty_slot0 && compact_iron_slot1)) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == ModItems.IRON_INGOT);
        Boolean iron_nugget_slot0 = this.furnaceItemStacks.get(0).getItem() == ModItems.IRON_NUGGET;
        Boolean iron_nugget_slot1 = this.furnaceItemStacks.get(1).getItem() == ModItems.IRON_NUGGET;
        Boolean iron_ingot_slot0 = this.furnaceItemStacks.get(0).getItem() == ModItems.IRON_INGOT;
        Boolean iron_ingot_slot1 = this.furnaceItemStacks.get(1).getItem() == ModItems.IRON_INGOT;
        Boolean iron_block = (iron_supercompact_slot0 && empty_slot1) || (iron_supercompact_slot1 && empty_slot0);
        Boolean iron_block_double = (iron_supercompact_slot0 && iron_supercompact_slot1);
        Boolean coal_slot0 = this.furnaceItemStacks.get(0).getItem() == Items.COAL;
        Boolean coal_slot1 = this.furnaceItemStacks.get(1).getItem() == Items.COAL;
        Boolean coal_block_slot0 = (this.furnaceItemStacks.get(0).getItem() == Item.getItemFromBlock(Blocks.COAL_BLOCK)) || (this.furnaceItemStacks.get(0).getItem() == Item.getItemFromBlock(ModBlocks.COAL_SUPERCOMPACT));
        Boolean coal_block_slot1 = (this.furnaceItemStacks.get(1).getItem() == Item.getItemFromBlock(Blocks.COAL_BLOCK)) || (this.furnaceItemStacks.get(1).getItem() == Item.getItemFromBlock(ModBlocks.COAL_SUPERCOMPACT));
        Boolean steel_nugget = (((iron_nugget_slot0 || small_iron_slot0)  && coal_slot1) || ((iron_nugget_slot1 || small_iron_slot1) && coal_slot0)) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == ModItems.STEEL_NUGGET);
        Boolean steel_ingot1 = ((iron_ingot_slot0 || iron_slot0) && coal_slot1 && this.furnaceItemStacks.get(1).getCount() >= 9) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == ModItems.STEEL_INGOT);
        Boolean steel_ingot0 = ((iron_ingot_slot1 || iron_slot1) && coal_slot0 && this.furnaceItemStacks.get(0).getCount() >= 9) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == ModItems.STEEL_INGOT);
        Boolean steel_ingot_coalblock = (((iron_ingot_slot0 || iron_slot0) && coal_block_slot1) || ((iron_ingot_slot1 || iron_slot1) && coal_block_slot0)) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == ModItems.STEEL_INGOT);
        Boolean steel_ingot_compact1 = ((compact_iron_slot0 && coal_slot1) && this.furnaceItemStacks.get(1).getCount() >= 27) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == ModItems.STEEL_INGOT);
        Boolean steel_ingot_compact0 = ((compact_iron_slot1 && coal_slot0) && this.furnaceItemStacks.get(0).getCount() >= 27) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == ModItems.STEEL_INGOT);
        Boolean steel_ingot_compact_coalblock = ((compact_iron_slot1 && coal_block_slot0 && this.furnaceItemStacks.get(0).getCount() >= 3) || (compact_iron_slot0 && coal_block_slot1 && this.furnaceItemStacks.get(1).getCount() >= 3)) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == ModItems.STEEL_INGOT);
        Boolean steel_block0 = ((iron_supercompact_slot1 || this.furnaceItemStacks.get(1).getItem() == Item.getItemFromBlock(ModBlocks.IRON_BLOCK)) && coal_block_slot0 && this.furnaceItemStacks.get(0).getCount() >= 3) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == Item.getItemFromBlock(ModBlocks.STEEL_BLOCK));
        Boolean steel_block1 = ((iron_supercompact_slot0 || this.furnaceItemStacks.get(0).getItem() == Item.getItemFromBlock(ModBlocks.IRON_BLOCK)) && coal_block_slot0 && this.furnaceItemStacks.get(1).getCount() >= 3) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == Item.getItemFromBlock(ModBlocks.STEEL_BLOCK));

        boolean flag = this.isBurning();
        boolean flag1 = false;
        if (this.isBurning()) {
            --this.furnaceBurnTime;
            if (iron_nugget_25 || iron_nugget_50) this.totalCookTime = 200;
            if (iron_ingot_25) this.totalCookTime = 200;
            if (iron_ingot_50) this.totalCookTime = 400;
            if (iron_compact_75) this.totalCookTime = 200;
            if (iron_compact_150) this.totalCookTime = 400;
            if (iron_block) this.totalCookTime = 200;
            if (iron_block_double) this.totalCookTime = 400;
            if (steel_nugget) this.totalCookTime = 200;
            if (steel_ingot0 || steel_ingot1 || steel_ingot_coalblock) this.totalCookTime = 400;
            if (steel_ingot_compact0 || steel_ingot_compact1 || steel_ingot_compact_coalblock) this.totalCookTime = 800;
            if (steel_block0 || steel_block1) this.totalCookTime = 1600;
            if (small_tin_slot0 || small_copper_slot0) this.totalCookTime = 400;
            if (tin_slot0 || copper_slot0) this.totalCookTime = 800;
            if (compact_tin_slot0 || compact_copper_slot0) this.totalCookTime = 1600;
            if (bronze_block) this.totalCookTime = 3200;
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
                            int random = new Random().nextInt(4) + 1;
                            Console.println(random);
                            Boolean smelt25 = random == 1;
                            Boolean smelt50 = random <= 2;
                            Boolean smelt75 = random <= 3;
                            int amount;
                            int amount1;
                            int amount2;
                            int amount3;
                            if (smelt25) amount = 1;
                            else amount = 0;
                            if (smelt50) {
                                amount1 = 1;
                                amount3 = 2;
                            } else {
                                amount1 = 0;
                                amount3 = 1;
                            }
                            if (smelt75) amount2 = 1;
                            else amount2 = 0;
                            if (result.isEmpty()) {

                                if (bronze_nugget) furnaceItemStacks.set(3, new ItemStack(ModItems.BRONZE_NUGGET, amount));
                                if (bronze_ingot) furnaceItemStacks.set(3, new ItemStack(ModItems.BRONZE_INGOT, amount));
                                if (bronze_compact)
                                    furnaceItemStacks.set(3, new ItemStack(ModItems.BRONZE_INGOT, amount*3));
                                if (iron_nugget_25)
                                    furnaceItemStacks.set(3, new ItemStack(ModItems.IRON_NUGGET, 1));
                                if (iron_nugget_50)
                                    furnaceItemStacks.set(3, new ItemStack(ModItems.IRON_NUGGET, 2));
                                if (iron_ingot_25)
                                    furnaceItemStacks.set(3, new ItemStack(ModItems.IRON_INGOT, 1));
                                if (iron_ingot_50)
                                    furnaceItemStacks.set(3, new ItemStack(ModItems.IRON_INGOT, 2));
                                if (iron_compact_75)
                                    furnaceItemStacks.set(3, new ItemStack(ModItems.IRON_INGOT, 3));
                                if (iron_compact_150)
                                    furnaceItemStacks.set(3, new ItemStack(ModItems.IRON_INGOT, 6));
                                if (steel_nugget)
                                    furnaceItemStacks.set(3, new ItemStack(ModItems.STEEL_NUGGET, amount1));
                                if (steel_ingot0 || steel_ingot1 || steel_ingot_coalblock)
                                    furnaceItemStacks.set(3, new ItemStack(ModItems.STEEL_INGOT, amount1));
                                if (steel_ingot_compact0 || steel_ingot_compact1 || steel_ingot_compact_coalblock)
                                    furnaceItemStacks.set(3, new ItemStack(ModItems.STEEL_INGOT, 3));
                                if (steel_block0 || steel_block1)
                                    furnaceItemStacks.set(3, new ItemStack(ModBlocks.STEEL_BLOCK, 1));
                                inputs[0].shrink(1);
                                inputs[1].shrink(1);
                            } else {
                                boolean smelt = true;
                                if (bronze_nugget || bronze_ingot) this.furnaceItemStacks.get(3).grow(amount);
                                if (bronze_compact) this.furnaceItemStacks.get(3).grow(amount*3);
                                if (iron_nugget_25) this.furnaceItemStacks.get(3).grow(1);
                                if (iron_ingot_25) this.furnaceItemStacks.get(3).grow(1);
                                if (iron_nugget_50 || iron_ingot_50) this.furnaceItemStacks.get(3).grow(2);
                                if (iron_compact_75) this.furnaceItemStacks.get(3).grow(3);
                                if (iron_compact_150) this.furnaceItemStacks.get(3).grow(6);
                                if (steel_nugget) this.furnaceItemStacks.get(3).grow(amount1);
                                if (steel_ingot0) {
                                    inputs[0].shrink(8);
                                    this.furnaceItemStacks.get(3).grow(1);
                                }
                                if (steel_ingot1)
                                {
                                    inputs[1].shrink(8);
                                    this.furnaceItemStacks.get(3).grow(amount1);
                                }
                                if (steel_ingot_coalblock) this.furnaceItemStacks.get(3).grow(1);
                                if (steel_ingot_compact0)
                                {
                                    inputs[0].shrink(26);
                                    this.furnaceItemStacks.get(3).grow(amount1*3);
                                }
                                if (steel_ingot_compact1)
                                {
                                    inputs[1].shrink(26);
                                    this.furnaceItemStacks.get(3).grow(amount1*3);
                                }
                                if (steel_ingot_compact_coalblock) this.furnaceItemStacks.get(3).grow(amount1*3);
                                if (steel_block0)
                                {
                                    inputs[0].shrink(2);
                                    this.furnaceItemStacks.get(3).grow(amount1);
                                }
                                if (steel_block1)
                                {
                                    inputs[1].shrink(2);
                                    this.furnaceItemStacks.get(3).grow(amount1);
                                }
                                inputs[0].shrink(1);
                                inputs[1].shrink(1);
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
                SinteringFurnace.setState(this.isBurning(), this.world, this.pos);
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
        Boolean empty_slot0 = this.furnaceItemStacks.get(0).isEmpty();
        Boolean empty_slot1 = this.furnaceItemStacks.get(1).getCount() == 0;
        Boolean small_tin_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("small_tin");
        Boolean small_tin_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("small_tin");
        Boolean small_copper_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("small_copper");
        Boolean small_copper_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("small_copper");
        Boolean bronze_nugget = ((small_tin_slot0 && small_copper_slot1) || (small_copper_slot0 && small_tin_slot1));
        Boolean tin_slot0 = (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("ore_tin") || (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("crustrock_tin")) || (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("mantlerock_tin")));
        Boolean tin_slot1 = (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("ore_tin") || (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("crustrock_tin")) || (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("mantlerock_tin")));
        Boolean copper_slot0 = (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("ore_copper") || (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("crustrock_copper")) || (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("mantlerock_copper")));
        Boolean copper_slot1 = (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("ore_copper") || (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("crustrock_copper")) || (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("mantlerock_copper")));
        Boolean bronze_ingot = ((tin_slot0 && copper_slot1) || (copper_slot0 && tin_slot1));
        Boolean compact_tin_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("compact_tin");
        Boolean compact_tin_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("compact_tin");
        Boolean compact_copper_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("compact_copper");
        Boolean compact_copper_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("compact_copper");
        Boolean tin_supercompact_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("tin_supercompact");
        Boolean tin_supercompact_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("tin_supercompact");
        Boolean copper_supercompact_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("copper_supercompact");
        Boolean copper_supercompact_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("copper_supercompact");
        Boolean bronze_compact = ((compact_tin_slot0 && compact_copper_slot1) || (compact_copper_slot0 && compact_tin_slot1));
        Boolean bronze_block = (tin_supercompact_slot0 && copper_supercompact_slot1) || (tin_supercompact_slot1 && copper_supercompact_slot0);
        Boolean small_iron_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("small_iron");
        Boolean small_iron_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("small_iron");
        Boolean iron_slot0 = (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("ore_iron") || (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("crustrock_iron")) || (this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("mantlerock_iron")));
        Boolean iron_slot1 = (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("ore_iron") || (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("crustrock_iron")) || (this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("mantlerock_iron")));
        Boolean compact_iron_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("compact_iron");
        Boolean compact_iron_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("compact_iron");
        Boolean iron_supercompact_slot0 = this.furnaceItemStacks.get(0).getItem().getTranslationKey().contains("iron_supercompact");
        Boolean iron_supercompact_slot1 = this.furnaceItemStacks.get(1).getItem().getTranslationKey().contains("iron_supercompact");
        Boolean iron_nugget_50 = ((small_iron_slot0 && small_iron_slot1) || (small_iron_slot0 && small_iron_slot1)) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == ModItems.IRON_NUGGET);
        Boolean iron_nugget_25 = ((small_iron_slot0 && empty_slot1) || (empty_slot0 && small_iron_slot1)) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == ModItems.IRON_NUGGET);
        Boolean iron_ingot_50 = ((iron_slot0 && iron_slot1) || (iron_slot0 && iron_slot1)) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == ModItems.IRON_INGOT);
        Boolean iron_ingot_25 = ((iron_slot0 && empty_slot1) || (empty_slot0 && iron_slot1)) && (this.furnaceItemStacks.get(3).isEmpty() || this.furnaceItemStacks.get(3).getItem() == ModItems.IRON_INGOT);;
        Boolean iron_compact_150 = ((compact_iron_slot0 && compact_iron_slot1) || (compact_iron_slot0 && compact_iron_slot1));
        Boolean iron_compact_75 = ((compact_iron_slot0 && empty_slot1) || (empty_slot0 && compact_iron_slot1));
        Boolean iron_nugget_slot0 = this.furnaceItemStacks.get(0).getItem() == ModItems.IRON_NUGGET;
        Boolean iron_nugget_slot1 = this.furnaceItemStacks.get(1).getItem() == ModItems.IRON_NUGGET;
        Boolean iron_ingot_slot0 = this.furnaceItemStacks.get(0).getItem() == ModItems.IRON_INGOT;
        Boolean iron_ingot_slot1 = this.furnaceItemStacks.get(1).getItem() == ModItems.IRON_INGOT;
        Boolean iron_block = (iron_supercompact_slot0 && empty_slot1) || (iron_supercompact_slot1 && empty_slot0);
        Boolean iron_block_double = (iron_supercompact_slot0 && iron_supercompact_slot1);
        Boolean coal_slot0 = this.furnaceItemStacks.get(0).getItem() == Items.COAL;
        Boolean coal_slot1 = this.furnaceItemStacks.get(1).getItem() == Items.COAL;
        Boolean coal_block_slot0 = (this.furnaceItemStacks.get(0).getItem() == Item.getItemFromBlock(Blocks.COAL_BLOCK)) || (this.furnaceItemStacks.get(0).getItem() == Item.getItemFromBlock(ModBlocks.COAL_SUPERCOMPACT));
        Boolean coal_block_slot1 = (this.furnaceItemStacks.get(1).getItem() == Item.getItemFromBlock(Blocks.COAL_BLOCK)) || (this.furnaceItemStacks.get(1).getItem() == Item.getItemFromBlock(ModBlocks.COAL_SUPERCOMPACT));
        Boolean steel_nugget = ((iron_nugget_slot0 || small_iron_slot0)  && coal_slot1) || ((iron_nugget_slot1 || small_iron_slot1) && coal_slot0);
        Boolean steel_ingot1 = ((iron_ingot_slot0 || iron_slot0) && coal_slot1 && this.furnaceItemStacks.get(1).getCount() >= 9);
        Boolean steel_ingot0 = ((iron_ingot_slot1 || iron_slot1) && coal_slot0 && this.furnaceItemStacks.get(0).getCount() >= 9);
        Boolean steel_ingot_coalblock = ((iron_ingot_slot0 || iron_slot0) && coal_block_slot1) || ((iron_ingot_slot1 || iron_slot1) && coal_block_slot0);
        Boolean steel_ingot_compact1 = (compact_iron_slot0 && coal_slot1) && this.furnaceItemStacks.get(1).getCount() >= 27;
        Boolean steel_ingot_compact0 = (compact_iron_slot1 && coal_slot0) && this.furnaceItemStacks.get(0).getCount() >= 27;
        Boolean steel_ingot_compact_coalblock = (compact_iron_slot1 && coal_block_slot0 && this.furnaceItemStacks.get(0).getCount() >= 3) || (compact_iron_slot0 && coal_block_slot1 && this.furnaceItemStacks.get(1).getCount() >= 3);
        Boolean steel_block0 = ((iron_supercompact_slot1 || this.furnaceItemStacks.get(1).getItem() == Item.getItemFromBlock(ModBlocks.IRON_BLOCK)) && coal_block_slot0 && this.furnaceItemStacks.get(0).getCount() >= 3);
        Boolean steel_block1 = ((iron_supercompact_slot0 || this.furnaceItemStacks.get(0).getItem() == Item.getItemFromBlock(ModBlocks.IRON_BLOCK)) && coal_block_slot0 && this.furnaceItemStacks.get(1).getCount() >= 3);
        Boolean canSmelt = (
                iron_nugget_25 || iron_nugget_50 || iron_ingot_25 || iron_ingot_50 || iron_compact_75 || iron_compact_150 || iron_block || iron_block_double
                || steel_nugget || steel_ingot0 || steel_ingot1 || steel_ingot_coalblock || steel_ingot_compact0
                        || steel_ingot_compact1 || steel_ingot_compact_coalblock || steel_block0 || steel_block1
                || bronze_nugget || bronze_ingot || bronze_compact || bronze_block);
        if (canSmelt && this.furnaceItemStacks.get(3).getCount() <= 64)
        {
            if (!furnaceItemStacks.get(3).isEmpty() && bronze_nugget && furnaceItemStacks.get(3).getItem() != ModItems.BRONZE_NUGGET) return false;
            else if (!furnaceItemStacks.get(3).isEmpty() && (bronze_ingot || bronze_compact) && furnaceItemStacks.get(3).getItem() != ModItems.BRONZE_INGOT) return false;
            else return true;

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
        return "planetcore:sintering_furnace";
    }

    public Container createContainer(InventoryPlayer playerInventory, EntityPlayer playerIn)
    {
        return new ContainerSinteringFurnace(playerInventory, this);
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