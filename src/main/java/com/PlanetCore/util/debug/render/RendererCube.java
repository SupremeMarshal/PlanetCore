package com.PlanetCore.util.debug.render;

import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
import com.PlanetCore.util.Reference;
import com.PlanetCore.world.Pillar;
import com.flowpowered.noise.module.combiner.Min;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.RenderWorldLastEvent;
import org.lwjgl.Sys;
import org.lwjgl.opengl.GL11;

import java.awt.*;
import java.util.HashSet;
import java.util.Set;

public class RendererCube {

    public static boolean DEBUG = true;
    private static Set<Pillar> rendererCubeTargets = new HashSet<>();
    private static long currentTime;

    public static void draw(Set<Pillar> pillars) {
        RendererCube.rendererCubeTargets = pillars;
        currentTime = System.currentTimeMillis();
    }

    /**
     * This method called by RenderWorldLastEvent handler.
     * It does nothing until the draw() method assign the necessary delay to the global field named currentTime.
     */
    static void tryToRender(RenderWorldLastEvent event) {

        if (!DEBUG || (!Minecraft.getMinecraft().player.getHeldItemMainhand().getItem().getRegistryName().getNamespace().equals(Reference.MOD_ID))) return;

        for (Pillar pillar : rendererCubeTargets) {
            prepareToRender(event, Color.CYAN);
            render(pillar);
            finishRender();
        }
    }

    private static void prepareToRender(RenderWorldLastEvent event, Color color) {
        EntityPlayerSP player = Minecraft.getMinecraft().player;

        double playerX = player.prevPosX + (player.posX - player.prevPosX) * event.getPartialTicks() - 0.5;
        double playerY = player.prevPosY + (player.posY - player.prevPosY) * event.getPartialTicks();
        double playerZ = player.prevPosZ + (player.posZ - player.prevPosZ) * event.getPartialTicks() - 0.5;

        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_LINE_SMOOTH);
        GL11.glHint(GL11.GL_LINE_SMOOTH_HINT, GL11.GL_NICEST);
        GL11.glLineWidth(1.0f);
        GL11.glColor3ub((byte) color.getRed(), (byte) color.getGreen(), (byte) color.getBlue());
        GL11.glPushMatrix();
        GL11.glTranslated(-playerX, -playerY, -playerZ);
    }

    private static void render(Pillar pillar) {
        float horOffset = 0.49f;
        float height = pillar.getHeight();

        BlockPos base = pillar.getBase();

        float x = base.getX();
        float y = base.getY();
        float z = base.getZ();

        // Edge 1.
        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3f(x + horOffset, y, z + horOffset);
        GL11.glVertex3f(x - horOffset, y, z + horOffset);
        GL11.glEnd();

        // Edge 2.
        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3f(x + horOffset, y, z - horOffset);
        GL11.glVertex3f(x - horOffset, y, z - horOffset);
        GL11.glEnd();

        // Edge 3.
        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3f(x + horOffset, y + height, z + horOffset);
        GL11.glVertex3f(x - horOffset, y + height, z + horOffset);
        GL11.glEnd();

        // Edge 4.
        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3f(x + horOffset, y + height, z - horOffset);
        GL11.glVertex3f(x - horOffset, y + height, z - horOffset);
        GL11.glEnd();

        // Edge 5.
        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3f(x + horOffset, y, z + horOffset);
        GL11.glVertex3f(x + horOffset, y + height, z + horOffset);
        GL11.glEnd();

        // Edge 6.
        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3f(x + horOffset, y, z - horOffset);
        GL11.glVertex3f(x + horOffset, y + height, z - horOffset);
        GL11.glEnd();

        // Edge 7.
        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3f(x - horOffset, y, z + horOffset);
        GL11.glVertex3f(x - horOffset, y + height, z + horOffset);
        GL11.glEnd();

        // Edge 8.
        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3f(x - horOffset, y, z - horOffset);
        GL11.glVertex3f(x - horOffset, y + height, z - horOffset);
        GL11.glEnd();

        // Edge 9.
        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3f(x + horOffset, y, z + horOffset);
        GL11.glVertex3f(x + horOffset, y, z - horOffset);
        GL11.glEnd();

        // Edge 10.
        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3f(x - horOffset, y, z + horOffset);
        GL11.glVertex3f(x - horOffset, y, z - horOffset);
        GL11.glEnd();

        // Edge 11.
        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3f(x + horOffset, y + height, z + horOffset);
        GL11.glVertex3f(x + horOffset, y + height, z - horOffset);
        GL11.glEnd();

        // Edge 12.
        GL11.glBegin(GL11.GL_LINE_STRIP);
        GL11.glVertex3f(x - horOffset, y + height, z + horOffset);
        GL11.glVertex3f(x - horOffset, y + height, z - horOffset);
        GL11.glEnd();
    }

    private static void finishRender() {
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glPopMatrix();
    }

}
