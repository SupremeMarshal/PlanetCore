package com.PlanetCore.anvils.Gold;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nonnull;

import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryBasic;
import net.minecraft.inventory.InventoryCraftResult;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.commons.lang3.StringUtils;

public class ContainerGoldAnvil extends Container {
    private IInventory outputSlot;
    private IInventory inputSlots;
    private World theWorld;
    private BlockPos selfPosition;
    public int maximumCost;
    public int maximumCap;
    public int materialCost;
    public String repairedItemName;
    private final EntityPlayer thePlayer;

    @SideOnly(Side.CLIENT)
    public ContainerGoldAnvil(InventoryPlayer playerInventory, World worldIn, EntityPlayer player) {
        this(playerInventory, worldIn, BlockPos.ORIGIN, player);
    }

    public ContainerGoldAnvil(InventoryPlayer playerInventory, final World worldIn, final BlockPos blockPosIn, EntityPlayer player) {
        this.maximumCap = 160;
        this.outputSlot = new InventoryCraftResult();
        this.inputSlots = new InventoryBasic("Repair", true, 2) {
            public void markDirty() {
                super.markDirty();
                ContainerGoldAnvil.this.onCraftMatrixChanged(this);
            }
        };
        this.selfPosition = blockPosIn;
        this.theWorld = worldIn;
        this.thePlayer = player;
        this.addSlotToContainer(new Slot(this.inputSlots, 0, 27, 47));
        this.addSlotToContainer(new Slot(this.inputSlots, 1, 76, 47));
        this.addSlotToContainer(new Slot(this.outputSlot, 2, 134, 47) {
            public boolean isItemValid(ItemStack stack) {
                return false;
            }

            public boolean canTakeStack(EntityPlayer playerIn) {
                return (playerIn.capabilities.isCreativeMode || playerIn.experienceLevel >= ContainerGoldAnvil.this.maximumCost) && ContainerGoldAnvil.this.maximumCost > 0 && this.getHasStack();
            }

            @Nonnull
            public ItemStack onTake(EntityPlayer playerIn, @Nonnull ItemStack stack) {
                if (!playerIn.capabilities.isCreativeMode) {
                    playerIn.addExperienceLevel(-ContainerGoldAnvil.this.maximumCost);
                }

                float breakChance = this.getBreakChance(playerIn, stack);
                ContainerGoldAnvil.this.inputSlots.setInventorySlotContents(0, ItemStack.EMPTY);
                if (ContainerGoldAnvil.this.materialCost > 0) {
                    ItemStack itemstack = ContainerGoldAnvil.this.inputSlots.getStackInSlot(1);
                    if (!itemstack.isEmpty() && itemstack.getCount() > ContainerGoldAnvil.this.materialCost) {
                        itemstack.shrink(ContainerGoldAnvil.this.materialCost);
                        ContainerGoldAnvil.this.inputSlots.setInventorySlotContents(1, itemstack);
                    } else {
                        ContainerGoldAnvil.this.inputSlots.setInventorySlotContents(1, ItemStack.EMPTY);
                    }
                } else {
                    ContainerGoldAnvil.this.inputSlots.setInventorySlotContents(1, ItemStack.EMPTY);
                }

                ContainerGoldAnvil.this.maximumCost = 0;
                IBlockState iblockstate = worldIn.getBlockState(blockPosIn);
                if (!playerIn.capabilities.isCreativeMode && !worldIn.isRemote && iblockstate.getBlock() instanceof BlockGoldAnvil && playerIn.getRNG().nextFloat() < breakChance) {
                    iblockstate = BlockGoldAnvil.damage(iblockstate);
                    if (iblockstate == null) {
                        worldIn.setBlockToAir(blockPosIn);
                        worldIn.playEvent(1029, blockPosIn, 0);
                    } else {
                        worldIn.setBlockState(blockPosIn, iblockstate, 2);
                        worldIn.playEvent(1030, blockPosIn, 0);
                    }
                } else if (!worldIn.isRemote) {
                    worldIn.playEvent(1030, blockPosIn, 0);
                }

                return stack;
            }

            public float getBreakChance(EntityPlayer playerIn, ItemStack stack) {
                return ForgeHooks.onAnvilRepair(playerIn, stack, ContainerGoldAnvil.this.inputSlots.getStackInSlot(0), ContainerGoldAnvil.this.inputSlots.getStackInSlot(1)) / 64.0F;
            }
        });

        int k;
        for(k = 0; k < 3; ++k) {
            for(int j = 0; j < 9; ++j) {
                this.addSlotToContainer(new Slot(playerInventory, j + k * 9 + 9, 8 + j * 18, 84 + k * 18));
            }
        }

        for(k = 0; k < 9; ++k) {
            this.addSlotToContainer(new Slot(playerInventory, k, 8 + k * 18, 142));
        }

    }

    public void onCraftMatrixChanged(IInventory inventoryIn) {
        super.onCraftMatrixChanged(inventoryIn);
        if (inventoryIn == this.inputSlots) {
            this.updateRepairOutput();
        }

    }

    public void updateRepairOutput() {
        ItemStack itemstack = this.inputSlots.getStackInSlot(0);
        this.maximumCost = 1;
        int i = 0;
        int j = 0;
        int k = 0;
        if (itemstack.isEmpty()) {
            this.outputSlot.setInventorySlotContents(0, ItemStack.EMPTY);
            this.maximumCost = 0;
        } else {
            ItemStack itemstack1 = itemstack.copy();
            ItemStack itemstack2 = this.inputSlots.getStackInSlot(1);
            Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(itemstack1);
            j = j + itemstack.getRepairCost() + (itemstack2.isEmpty() ? 0 : itemstack2.getRepairCost());
            this.materialCost = 0;
            boolean flag = false;
            int i2;
            if (!itemstack2.isEmpty()) {
                if (!onAnvilChange(this, itemstack, itemstack2, this.outputSlot, this.repairedItemName, j)) {
                    return;
                }

                flag = itemstack2.getItem() == Items.ENCHANTED_BOOK && !ItemEnchantedBook.getEnchantments(itemstack2).isEmpty();
                int i1;
                int j1;
                if (itemstack1.isItemStackDamageable() && itemstack1.getItem().getIsRepairable(itemstack, itemstack2)) {
                    i2 = Math.min(itemstack1.getItemDamage(), itemstack1.getMaxDamage() / 4);
                    if (i2 <= 0) {
                        this.outputSlot.setInventorySlotContents(0, ItemStack.EMPTY);
                        this.maximumCost = 0;
                        return;
                    }

                    for(i1 = 0; i2 > 0 && i1 < itemstack2.getCount(); ++i1) {
                        j1 = itemstack1.getItemDamage() - i2;
                        itemstack1.setItemDamage(j1);
                        ++i;
                        i2 = Math.min(itemstack1.getItemDamage(), itemstack1.getMaxDamage() / 4);
                    }

                    this.materialCost = i1;
                } else {
                    if (!flag && (itemstack1.getItem() != itemstack2.getItem() || !itemstack1.isItemStackDamageable())) {
                        this.outputSlot.setInventorySlotContents(0, ItemStack.EMPTY);
                        this.maximumCost = 0;
                        return;
                    }

                    int i3;
                    int j3;
                    if (itemstack1.isItemStackDamageable() && !flag) {
                        i2 = itemstack.getMaxDamage() - itemstack.getItemDamage();
                        i1 = itemstack2.getMaxDamage() - itemstack2.getItemDamage();
                        j1 = i1 + itemstack1.getMaxDamage() * 12 / 100;
                        i3 = i2 + j1;
                        j3 = itemstack1.getMaxDamage() - i3;
                        if (j3 < 0) {
                            j3 = 0;
                        }

                        if (j3 < itemstack1.getMetadata()) {
                            itemstack1.setItemDamage(j3);
                            i += 2;
                        }
                    }

                    Map<Enchantment, Integer> map1 = EnchantmentHelper.getEnchantments(itemstack2);
                    Iterator var19 = map1.keySet().iterator();

                    label156:
                    while(true) {
                        Enchantment enchantment1;
                        do {
                            if (!var19.hasNext()) {
                                break label156;
                            }

                            enchantment1 = (Enchantment)var19.next();
                        } while(enchantment1 == null);

                        i3 = (Integer)map.getOrDefault(enchantment1, 0);
                        j3 = (Integer)map1.get(enchantment1);
                        j3 = i3 == j3 ? j3 + 1 : Math.max(j3, i3);
                        boolean flag1 = enchantment1.canApply(itemstack);
                        if (this.thePlayer.capabilities.isCreativeMode || itemstack.getItem() == Items.ENCHANTED_BOOK) {
                            flag1 = true;
                        }

                        Iterator var15 = map.keySet().iterator();

                        while(var15.hasNext()) {
                            Enchantment enchantment = (Enchantment)var15.next();
                            if (enchantment != null && enchantment != enchantment1 && !enchantment.isCompatibleWith(enchantment1)) {
                                flag1 = false;
                                ++i;
                            }
                        }

                        if (flag1) {
                            if (j3 > enchantment1.getMaxLevel()) {
                                j3 = enchantment1.getMaxLevel();
                            }

                            map.put(enchantment1, j3);
                            int k3 = 0;
                            switch(enchantment1.getRarity()) {
                                case COMMON:
                                    k3 = 1;
                                    break;
                                case UNCOMMON:
                                    k3 = 2;
                                    break;
                                case RARE:
                                    k3 = 4;
                                    break;
                                case VERY_RARE:
                                    k3 = 8;
                            }

                            if (flag) {
                                k3 = Math.max(1, k3 / 2);
                            }

                            i += k3 * j3;
                        }
                    }
                }
            }

            if (flag && !itemstack1.getItem().isBookEnchantable(itemstack1, itemstack2)) {
                itemstack1 = ItemStack.EMPTY;
            }

            if (StringUtils.isBlank(this.repairedItemName)) {
                if (itemstack.hasDisplayName()) {
                    k = 1;
                    i += k;
                    itemstack1.clearCustomName();
                }
            } else if (!this.repairedItemName.equals(itemstack.getDisplayName())) {
                k = 1;
                i += k;
                itemstack1.setStackDisplayName(this.repairedItemName);
            }

            this.maximumCost = j + i;
            if (i <= 0) {
                itemstack1 = ItemStack.EMPTY;
            }

            if (k == i && k > 0 && this.maximumCost >= this.maximumCap) {
                this.maximumCost = this.maximumCap - 1;
            }

            if (this.maximumCost >= this.maximumCap && !this.thePlayer.capabilities.isCreativeMode) {
                itemstack1 = ItemStack.EMPTY;
            }

            if (!itemstack1.isEmpty()) {
                i2 = itemstack1.getRepairCost();
                if (!itemstack2.isEmpty() && i2 < itemstack2.getRepairCost()) {
                    i2 = itemstack2.getRepairCost();
                }

                if (k != i) {
                    i2 = i2 * 2 + 1;
                }

                itemstack1.setRepairCost(i2);
                EnchantmentHelper.setEnchantments(map, itemstack1);
            }

            this.outputSlot.setInventorySlotContents(0, itemstack1);
            this.detectAndSendChanges();
        }

    }

    public void addListener(IContainerListener listener) {
        super.addListener(listener);
        listener.sendWindowProperty(this, 0, this.maximumCost);
    }

    @SideOnly(Side.CLIENT)
    public void updateProgressBar(int id, int data) {
        if (id == 0) {
            this.maximumCost = data;
        }

    }

    public void onContainerClosed(EntityPlayer playerIn) {
        super.onContainerClosed(playerIn);
        if (!this.theWorld.isRemote) {
            for(int i = 0; i < this.inputSlots.getSizeInventory(); ++i) {
                ItemStack itemstack = this.inputSlots.removeStackFromSlot(i);
                if (!itemstack.isEmpty()) {
                    playerIn.dropItem(itemstack, false);
                }
            }
        }

    }

    public boolean canInteractWith(@Nonnull EntityPlayer playerIn) {
        return this.theWorld.getBlockState(this.selfPosition).getBlock() instanceof BlockGoldAnvil && playerIn.getDistanceSq((double)this.selfPosition.getX() + 0.5D, (double)this.selfPosition.getY() + 0.5D, (double)this.selfPosition.getZ() + 0.5D) <= 64.0D;
    }

    @Nonnull
    public ItemStack transferStackInSlot(EntityPlayer playerIn, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = (Slot)this.inventorySlots.get(index);
        if (slot != null && slot.getHasStack()) {
            ItemStack itemstack1 = slot.getStack();
            itemstack = itemstack1.copy();
            if (index == 2) {
                if (!this.mergeItemStack(itemstack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onSlotChange(itemstack1, itemstack);
            } else if (index != 0 && index != 1) {
                if (index < 39 && !this.mergeItemStack(itemstack1, 0, 2, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.mergeItemStack(itemstack1, 3, 39, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.putStack(ItemStack.EMPTY);
            } else {
                slot.onSlotChanged();
            }

            if (itemstack1.getCount() == itemstack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(playerIn, itemstack1);
        }

        return itemstack;
    }

    public void updateItemName(String newName) {
        this.repairedItemName = newName;
        if (this.getSlot(2).getHasStack()) {
            ItemStack itemstack = this.getSlot(2).getStack();
            if (StringUtils.isBlank(newName)) {
                itemstack.clearCustomName();
            } else {
                itemstack.setStackDisplayName(this.repairedItemName);
            }
        }

        this.updateRepairOutput();
    }

    public static boolean onAnvilChange(ContainerGoldAnvil container, ItemStack left, ItemStack right, IInventory outputSlot, String name, int baseCost) {
        AnvilUpdateEvent e = new AnvilUpdateEvent(left, right, name, baseCost);
        if (MinecraftForge.EVENT_BUS.post(e)) {
            return false;
        } else if (e.getOutput().isEmpty()) {
            return true;
        } else {
            outputSlot.setInventorySlotContents(0, e.getOutput());
            container.maximumCost = e.getCost();
            container.materialCost = e.getMaterialCost();
            return false;
        }
    }
}