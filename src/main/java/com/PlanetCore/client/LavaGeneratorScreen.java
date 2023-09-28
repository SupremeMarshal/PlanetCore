package com.PlanetCore.client;

import com.PlanetCore.menu.LavaGeneratorMenu;
import com.PlanetCore.util.Reference;
import com.google.common.collect.Lists;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;

import java.util.ArrayList;
import java.util.List;

public class LavaGeneratorScreen extends GuiContainer {
    private final InventoryPlayer playerInventory;

    public LavaGeneratorScreen(LavaGeneratorMenu inventorySlotsIn) {
        super(inventorySlotsIn);
        this.playerInventory = inventorySlotsIn.getPlayer().inventory;
    }

    public LavaGeneratorMenu getMenu() {
        return (LavaGeneratorMenu) inventorySlots;
    }

    private static final ResourceLocation TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/menu/lava_generator.png");

    private static final ResourceLocation ENERGY_TEXTURE = new ResourceLocation(Reference.MOD_ID, "textures/gui/menu/energy_bar.png");


    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        this.drawDefaultBackground();
        super.drawScreen(mouseX, mouseY, partialTicks);
        this.renderHoveredToolTip(mouseX, mouseY);
    }


    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
        String s = getMenu().getLavaGeneratorBlockEntity().getDisplayName().getUnformattedText();
        this.fontRenderer.drawString(s, this.xSize / 2 - this.fontRenderer.getStringWidth(s) / 2, 6, 4210752);
        this.fontRenderer.drawString(this.playerInventory.getDisplayName().getUnformattedText(), 8, this.ySize - 96 + 2, 4210752);
        String s1 = "Time Left: "+getMenu().getLavaGeneratorBlockEntity().getRemainingTime();//todo, translation keys
        Fluid fluid = getMenu().getLavaGeneratorBlockEntity().getCurrentFuel();
        String s2 = "Active fuel: " + (fluid == null ? null : fluid.getName());

        this.fontRenderer.drawString(s1, this.xSize / 2 - this.fontRenderer.getStringWidth(s1) / 2, 50, 4210752);
        this.fontRenderer.drawString(s2, this.xSize / 2 - this.fontRenderer.getStringWidth(s2) / 2, 60, 4210752);

    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
        GlStateManager.color(1, 1, 1, 1);
        this.mc.getTextureManager().bindTexture(TEXTURE);
        int i = (this.width - this.xSize) / 2;
        int j = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(i, j, 0, 0, this.xSize, this.ySize);

        renderFluid(guiLeft + FLUID_INPUT_X, guiTop + FLUID_INPUT_Y,
                getMenu().getLavaGeneratorBlockEntity().getFluidTank());
        renderEnergy(guiLeft + 160, guiTop + 10, getMenu().getLavaGeneratorBlockEntity().getEnergyStorage());
    }

    public static final int FL_WIDTH = 7;
    public static final int FL_HEIGHT = 52;
    static final int FLUID_INPUT_Y = 16;
    static final int FLUID_INPUT_X = 7;

    public void renderEnergy(final int xPosition, final int yPosition, EnergyStorage energyStorage) {
        this.mc.getTextureManager().bindTexture(ENERGY_TEXTURE);
        double ratio = (double)energyStorage.getEnergyStored() / energyStorage.getMaxEnergyStored();
        drawTexturedModalRect(xPosition,yPosition,0,0,9,60);
        GlStateManager.color(1,0,0,1);
        drawTexturedModalRect(xPosition+2, (int) (yPosition + 56 *(1 - ratio)) + 3,11,2,5, (int) (56 * ratio));
        GlStateManager.color(1,1,1,1);
    }

    public void renderFluid(final int xPosition, final int yPosition, FluidTank fluidTank) {
        GlStateManager.enableBlend();
        GlStateManager.enableAlpha();

        ClientUtil.drawFluid(this, this.mc, xPosition, yPosition, FL_WIDTH, FL_HEIGHT, fluidTank);

        GlStateManager.color(1, 1, 1, 1);

        GlStateManager.disableAlpha();
        GlStateManager.disableBlend();
    }

    @Override
    protected void renderHoveredToolTip(int x, int y) {
        super.renderHoveredToolTip(x, y);
        if (isPointInRegion(FLUID_INPUT_X, FLUID_INPUT_Y, FL_WIDTH, FL_HEIGHT, x, y) &&
                getMenu().getLavaGeneratorBlockEntity().getFluidTank().getFluid() != null) {
            this.drawHoveringText(getFluidTooltip(getMenu().getLavaGeneratorBlockEntity().getFluidTank()), x, y, fontRenderer);
        } else if (isPointInRegion(160,8,9,60,x,y)) {
            EnergyStorage energyStorage = getMenu().getLavaGeneratorBlockEntity().getEnergyStorage();
            List<String> tooltip = Lists.newArrayList(energyStorage.getEnergyStored() +"/"+energyStorage.getMaxEnergyStored() + " FE");

            this.drawHoveringText(tooltip, x, y, fontRenderer);
        }
    }


    public List<String> getFluidTooltip(FluidTank fluidTank) {
        List<String> tooltip = new ArrayList<>();
        FluidStack fluidStack = fluidTank.getFluid();
        if (fluidStack == null) {
            return tooltip;
        }

        String fluidName = fluidStack.getLocalizedName();
        tooltip.add(fluidName);

        String amount = I18n.format("jei.tooltip.liquid.amount.with.capacity", fluidStack.amount, fluidTank.getCapacity());
        tooltip.add(TextFormatting.GRAY + amount);
        return tooltip;
    }

}
