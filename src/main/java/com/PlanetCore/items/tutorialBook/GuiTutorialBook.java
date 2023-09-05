package com.PlanetCore.items.tutorialBook;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.util.ResourceLocation;

public class GuiTutorialBook extends GuiScreen {

    private static final int GUI_WIDTH = 400;
    private static final int GUI_HEIGHT = 400;

    private GuiButton closeButton;
    private GuiButton nextButton;
    private GuiButton prevButton;
    private GuiButton[] pageButton = new GuiButton[7];
    public static int currentPage = 0;
    private final ResourceLocation backgroundTexture = new ResourceLocation("planetcore","textures/gui/tutorial_book_gui.png");
    private final ResourceLocation mantlerock1boulderTexture = new ResourceLocation("planetcore", "textures/gui/mantlerock1_boulder.png");
    private String[] tutorialPages = {
            "Welcome to Planetcore Tutorial!\n\nTable of contents\n\n-Page 2: Complete pickaxes and Relentless\n\n-Page 3: Temperature and fire resistance\n\n-Page 4: Tools, ores and rocks tier list\n\n-Page 5: Armor points system and damage reduction.\n\n-Page 7: Caves Generations",
            "Complete pickaxes and Relentless\n\nHere is a screenshot of\n\nhow you can make\n\na complete pickaxe.\n\nComplete pickaxes have\ntwice the durability.",
            "Temperature and fire resistance\n\nThe relentless is\na time in seconds\nmeasurement that\n check how long before\na rock become\n indestructible.\nIf you have\n2 relentless points,\nthen if it take you\nmore than 2 seconds to\nbreak a block,\nthen the block is\nindestructible.",
            "Temperature\n\n",
            "Page 5: ",
            "Page 6: ",
            "Page 7: ",
            "Page 8: "
            // Add more pages as needed
    };


    public GuiTutorialBook() {
    }

    @Override
    public void initGui() {
        super.initGui();

        int posX = (width - GUI_WIDTH) / 2;
        int posY = (height - GUI_HEIGHT) / 2;
        // Add buttons, text fields, and other GUI elements here
        closeButton = new GuiButton(0, posX + GUI_WIDTH - 30, posY + 5, 20, 20, "X");
        buttonList.add(closeButton);

        nextButton = new GuiButton(1, posX + GUI_WIDTH - 30, posY + 380, 20, 20, ">");
        buttonList.add(nextButton);

        prevButton = new GuiButton(2, posX + GUI_WIDTH - 400, posY + 380, 20, 20, "<");
        buttonList.add(prevButton);

        for (int i = 0; i < pageButton.length; i++) {
            pageButton[i] = new GuiButton(i, posX + 50, posY + 54 + (int) (i*17.5f), 13, 13, String.valueOf(i));
            buttonList.add(pageButton[i]);
        }



    }

    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {

        //drawDefaultBackground();
        this.mc.getTextureManager().bindTexture(backgroundTexture);

        int posX = (width - GUI_WIDTH) / 2;
        int posY = (height - GUI_HEIGHT) / 2;

        // Draw the scaled background texture
        this.drawScaledCustomSizeModalRect(posX, posY, 0, 0, GUI_WIDTH, GUI_HEIGHT, GUI_WIDTH, GUI_HEIGHT, GUI_WIDTH, GUI_HEIGHT);
        // Display the content of the current page


        int imageX = posX + 300;
        int imageY = posY + 54;

        this.mc.getTextureManager().bindTexture(mantlerock1boulderTexture);
        this.drawScaledCustomSizeModalRect(imageX, imageY, 0, 0, 16, 16, 16 , 16, 16, 16);
        //GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
        //Gui.drawScaledCustomSizeModalRect(imageX, imageY, -1, -1, 16,16,16,16,16,16);

        fontRenderer.drawSplitString(tutorialPages[currentPage], posX + 20, posY + 20, GUI_WIDTH - 20, 0x000000);

        // Display page numbers
        String pageNumberText = "Page " + (currentPage + 1) + " of " + tutorialPages.length;
        fontRenderer.drawString(pageNumberText, posX + GUI_WIDTH - fontRenderer.getStringWidth(pageNumberText) - 20, posY + GUI_HEIGHT - 40, 0x000000);

        if (currentPage > 0) {
            for (int i = 0; i < pageButton.length; i++) {
                buttonList.remove(pageButton[i]);
            }
        }
        //super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean doesGuiPauseGame() {
        return false;
    }

    @Override
    protected void actionPerformed(GuiButton button) {
        int posX = (width - GUI_WIDTH) / 2;
        int posY = (height - GUI_HEIGHT) / 2;
        if (currentPage == 0) {
            for (int i = 0; i < pageButton.length; i++) {
                pageButton[i] = new GuiButton(i, posX + 50, posY + 54 + (int) (i*17.5f), 13, 13, String.valueOf(i));
                buttonList.add(pageButton[i]);
            }
        }

        // Handle button clicks and other interactions
        if (button == closeButton) {
            // Close the GUI
            mc.displayGuiScreen(null);
        }

        if (button == nextButton) {
            // Navigate to the next page
            currentPage++;

            if (currentPage >= tutorialPages.length) {
                // Reset to the first page when reaching the end
                currentPage = 0;
            }
        }

        if (button == prevButton) {
            // Navigate to the next page
            currentPage--;

            if (currentPage <= -1) currentPage = 0;
        }

        for (int i = 0; i < pageButton.length; i++) {
            if (button == pageButton[i]) {
                // Navigate to the page 2
                currentPage = i+1;
            }
        }
    }

//    @SubscribeEvent
//    public void onGuiDraw(GuiScreenEvent.DrawScreenEvent.Post event) {
//        if (event.getGui() instanceof GuiTutorialBook)
//            if (GuiTutorialBook.currentPage == 4) {
//
//                event.
//
//        }

}