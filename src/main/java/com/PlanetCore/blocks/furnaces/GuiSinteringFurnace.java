package com.PlanetCore.blocks.furnaces;

import com.PlanetCore.util.Reference;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiSinteringFurnace extends GuiContainer
{
    private static final ResourceLocation TEXTURES = new ResourceLocation(Reference.MOD_ID + ":textures/gui/sintering_furnace.png");
    private final InventoryPlayer player;
    private final TileEntitySinteringFurnace tileentity;

    public GuiSinteringFurnace(InventoryPlayer player, TileEntitySinteringFurnace tileentity)
    {
        super(new ContainerSinteringFurnace(player, tileentity));
        this.player = player;
        this.tileentity = tileentity;
    }

    @Override
    protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY)
    {
        String tileName = "Alloy Furnace";
        this.fontRenderer.drawString(tileName, 100, 8, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY)
    {
        GlStateManager.color(1.0f, 1.0f, 1.0f, 1.0f);
        this.mc.getTextureManager().bindTexture(TEXTURES);
        this.drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);

        if(TileEntitySinteringFurnace.isBurning(tileentity))
        {
            int k = this.getBurnLeftScaled(13);
            //fire texture
            this.drawTexturedModalRect(this.guiLeft + 47, this.guiTop + 76 - k, 176, 12 - k, 20, k + 1);
        }

        int l = this.getCookProgressScaled(161);
        //progress bar
        this.drawTexturedModalRect(this.guiLeft + 7, this.guiTop + 77, 0, 180, l + 1, 6);
    }

    private int getBurnLeftScaled(int pixels)
    {
        int i = this.tileentity.getField(1);
        if(i == 0) i = 200;
        return this.tileentity.getField(0) * pixels / i;
    }

    private int getCookProgressScaled(int pixels)
    {
        int i = this.tileentity.getField(2);
        int j = this.tileentity.getField(3);
        return j != 0 && i != 0 ? i * pixels / j : 0;
    }
}