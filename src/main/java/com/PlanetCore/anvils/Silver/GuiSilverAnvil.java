package com.PlanetCore.anvils.Silver;

import com.PlanetCore.anvils.PacketAnvilRename;

import java.io.IOException;
import javax.annotation.Nonnull;

import com.PlanetCore.anvils.PacketHandler;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiTextField;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IContainerListener;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.input.Keyboard;




    @SideOnly(Side.CLIENT)
    public class GuiSilverAnvil extends GuiContainer implements IContainerListener {
        private static final ResourceLocation anvilResource = new ResourceLocation("planetcore", "textures/gui/silver_anvil.png");
        private ContainerSilverAnvil anvil;
        private GuiTextField nameField;
        private final InventoryPlayer playerInventory;

        public GuiSilverAnvil(InventoryPlayer inventoryIn, World worldIn) {
            super(new ContainerSilverAnvil(inventoryIn, worldIn, Minecraft.getMinecraft().player));
            this.playerInventory = inventoryIn;
            this.anvil = (ContainerSilverAnvil)this.inventorySlots;
        }

        public void initGui() {
            super.initGui();
            Keyboard.enableRepeatEvents(true);
            int i = (this.width - this.xSize) / 2;
            int j = (this.height - this.ySize) / 2;
            this.nameField = new GuiTextField(0, this.fontRenderer, i + 62, j + 24, 103, 12);
            this.nameField.setTextColor(-1);
            this.nameField.setDisabledTextColour(-1);
            this.nameField.setEnableBackgroundDrawing(false);
            this.nameField.setMaxStringLength(35);
            this.inventorySlots.removeListener(this);
            this.inventorySlots.addListener(this);
        }

        public void onGuiClosed() {
            super.onGuiClosed();
            Keyboard.enableRepeatEvents(false);
            this.inventorySlots.removeListener(this);
        }

        protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
            GlStateManager.disableLighting();
            GlStateManager.disableBlend();
            this.fontRenderer.drawString(I18n.format("container.repair", new Object[0]), 60, 6, 4210752);
            if (this.anvil.maximumCost > 0) {
                int i = 8453920;
                boolean flag = true;
                String s = I18n.format("container.repair.cost", new Object[]{this.anvil.maximumCost});
                if (this.anvil.maximumCost >= this.anvil.maximumCap && !this.mc.player.capabilities.isCreativeMode) {
                    s = I18n.format("container.repair.expensive", new Object[0]);
                    i = 16736352;
                } else if (!this.anvil.getSlot(2).getHasStack()) {
                    flag = false;
                } else if (!this.anvil.getSlot(2).canTakeStack(this.playerInventory.player)) {
                    i = 16736352;
                }

                if (flag) {
                    int j = -16777216 | (i & 16579836) >> 2 | i & -16777216;
                    int k = this.xSize - 8 - this.fontRenderer.getStringWidth(s);
                    int l = 67;
                    if (this.fontRenderer.getUnicodeFlag()) {
                        drawRect(k - 3, l - 2, this.xSize - 7, l + 10, -16777216);
                        drawRect(k - 2, l - 1, this.xSize - 8, l + 9, -12895429);
                    } else {
                        this.fontRenderer.drawString(s, k, l + 1, j);
                        this.fontRenderer.drawString(s, k + 1, l, j);
                        this.fontRenderer.drawString(s, k + 1, l + 1, j);
                    }

                    this.fontRenderer.drawString(s, k, l, i);
                }
            }

            GlStateManager.enableLighting();
        }

        protected void keyTyped(char typedChar, int keyCode) throws IOException {
            if (this.nameField.textboxKeyTyped(typedChar, keyCode)) {
                this.renameItem();
            } else {
                super.keyTyped(typedChar, keyCode);
            }

        }

        private void renameItem() {
            String s = this.nameField.getText();
            Slot slot = this.anvil.getSlot(0);
            if (slot.getHasStack() && !slot.getStack().hasDisplayName() && s.equals(slot.getStack().getDisplayName())) {
                s = "";
            }

            this.anvil.updateItemName(s);
            PacketHandler.INSTANCE.sendToServer(new PacketAnvilRename(s));
        }

        protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
            super.mouseClicked(mouseX, mouseY, mouseButton);
            this.nameField.mouseClicked(mouseX, mouseY, mouseButton);
        }

        public void drawScreen(int mouseX, int mouseY, float partialTicks) {
            this.drawDefaultBackground();
            super.drawScreen(mouseX, mouseY, partialTicks);
            this.renderHoveredToolTip(mouseX, mouseY);
            GlStateManager.disableLighting();
            GlStateManager.disableBlend();
            this.nameField.drawTextBox();
        }

        protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
            this.mc.getTextureManager().bindTexture(anvilResource);
            int i = (this.width - this.xSize) / 2;
            int j = (this.height - this.ySize) / 2;
            this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);
            this.drawTexturedModalRect(i + 59, j + 20, 0, this.ySize + (this.anvil.getSlot(0).getHasStack() ? 0 : 16), 110, 16);
            if ((this.anvil.getSlot(0).getHasStack() || this.anvil.getSlot(1).getHasStack()) && !this.anvil.getSlot(2).getHasStack()) {
                this.drawTexturedModalRect(i + 99, j + 45, this.xSize, 0, 28, 21);
            }

        }

        public void sendAllContents(@Nonnull Container containerToSend, @Nonnull NonNullList<ItemStack> itemsList) {
            this.sendSlotContents(containerToSend, 0, containerToSend.getSlot(0).getStack());
        }
///////////////////////////////////huhuh


        public void sendSlotContents(@Nonnull Container containerToSend, int slotInd, @Nonnull ItemStack stack) {
            if (slotInd == 0) {
                this.nameField.setText(stack.isEmpty() ? "" : stack.getDisplayName());
                this.nameField.setEnabled(!stack.isEmpty());
                if (!stack.isEmpty()) {
                    this.renameItem();
                }
            }

        }

        public void sendWindowProperty(@Nonnull Container containerIn, int varToUpdate, int newValue) {
        }

        public void sendAllWindowProperties(@Nonnull Container containerIn, @Nonnull IInventory inventory) {
        }
    }

