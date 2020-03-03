package com.PlanetCore.anvils.generic;

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
public class GuiGenericAnvil extends GuiContainer implements IContainerListener {
    private static final ResourceLocation anvilResource = new ResourceLocation("textures/gui/container/anvil.png");
    private ContainerGenericAnvil anvil;
    private GuiTextField nameField;
    private final InventoryPlayer playerInventory;
    private static final ResourceLocation hammer = new ResourceLocation("planetcore", "textures/gui/hammer.png");

    public GuiGenericAnvil(InventoryPlayer inventoryIn, World worldIn, BlockGenericAnvil genericAnvil) {
        super(new ContainerGenericAnvil(inventoryIn, worldIn, Minecraft.getMinecraft().player, genericAnvil));
        this.playerInventory = inventoryIn;
        this.anvil = (ContainerGenericAnvil)this.inventorySlots;
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
        this.nameField.setMaxStringLength(2147483647);
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
        if (this.anvil.maximumCost >= 0) {
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

        this.mc.getTextureManager().bindTexture(hammer);
        GuiGenericAnvil.EnumAnvilType.getType(this.anvil.name).color.setColor();
        drawModalRectWithCustomSizedTexture(i + 25, j + 7, 0.0F, 0.0F, 22, 22, 22.0F, 22.0F);
        GuiGenericAnvil.Color.reset();
    }

    public void sendAllContents(@Nonnull Container containerToSend, @Nonnull NonNullList<ItemStack> itemsList) {
        this.sendSlotContents(containerToSend, 0, containerToSend.getSlot(0).getStack());
    }

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

    public static class Color {
        public final int r;
        public final int g;
        public final int b;
        public final int a;

        Color(int red, int green, int blue) {
            this(red, green, blue, 255);
        }

        Color(int red, int green, int blue, int alpha) {
            this.r = red;
            this.g = green;
            this.b = blue;
            this.a = alpha;
        }

        public void setColor() {
            GlStateManager.color((float)this.r / 255.0F, (float)this.g / 255.0F, (float)this.b / 255.0F, (float)this.a / 255.0F);
        }

        public static void reset() {
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        }
    }

    public static enum EnumAnvilType {
        ERROR(new GuiGenericAnvil.Color(0, 0, 0)),
        EMERALD(new GuiGenericAnvil.Color(10, 255, 20)),
        ARDITE(new GuiGenericAnvil.Color(255, 95, 0)),
        BRONZE(new GuiGenericAnvil.Color(0, 12, 255)),
        COBALT(new GuiGenericAnvil.Color(0, 12, 255)),
        COPPER(new GuiGenericAnvil.Color(255, 127, 0)),
        DIAMOND(new GuiGenericAnvil.Color(0, 255, 225)),
        ELECTRUM(new GuiGenericAnvil.Color(255, 255, 155)),
        ENDSTEEL(new GuiGenericAnvil.Color(255, 255, 200)),
        GOLD(new GuiGenericAnvil.Color(255, 245, 0)),
        INFERIUM(new GuiGenericAnvil.Color(50, 255, 10)),
        INTERMEDIUM(new GuiGenericAnvil.Color(255, 120, 0)),
        INVAR(new GuiGenericAnvil.Color(150, 150, 150)),
        IRIDIUM(new GuiGenericAnvil.Color(194, 192, 216)),
        LEAD(new GuiGenericAnvil.Color(124, 138, 181)),
        MANYULLYN(new GuiGenericAnvil.Color(165, 0, 255)),
        NICKEL(new GuiGenericAnvil.Color(255, 255, 185)),
        PLATINUM(new GuiGenericAnvil.Color(10, 220, 255)),
        PRUDENTIUM(new GuiGenericAnvil.Color(0, 255, 0)),
        STELLAR(new GuiGenericAnvil.Color(250, 250, 250)),
        SILVER(new GuiGenericAnvil.Color(185, 235, 255)),
        STEEL(new GuiGenericAnvil.Color(60, 60, 60)),
        STONE(new GuiGenericAnvil.Color(130, 130, 130)),
        SUPERIUM(new GuiGenericAnvil.Color(0, 0, 255)),
        SUPREMIUM(new GuiGenericAnvil.Color(255, 0, 0)),
        TIN(new GuiGenericAnvil.Color(171, 192, 201));

        public final GuiGenericAnvil.Color color;

        private EnumAnvilType(GuiGenericAnvil.Color color) {
            this.color = color;
        }

        public static GuiGenericAnvil.EnumAnvilType getType(String s) {
            try {
                return valueOf(s.toUpperCase());
            } catch (IllegalArgumentException var2) {
                return ERROR;
            }
        }
    }
}