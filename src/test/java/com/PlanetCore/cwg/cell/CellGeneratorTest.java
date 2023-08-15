package com.PlanetCore.cwg.cell;

import com.PlanetCore.util.FastRandom;
import io.github.opencubicchunks.cubicchunks.api.util.MathUtil;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3i;
import org.spongepowered.noise.Noise;
import org.spongepowered.noise.NoiseQuality;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class CellGeneratorTest {

    public static void main(String[] args) throws IOException {
        cellCavesScaled();
    }


    private static void cellCavesScaled() throws IOException {

        final int w = 2048;
        final int h = 1024*3;

        final int xOff = 0;
        final int yOff = -h;
        BufferedImage noiseCave = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < w; i++) {
            for (int i1 = 0; i1 < h; i1++) {
                noiseCave.setRGB(i, i1, terrain(-1, -1, 128));
            }
        }
        CellNoiseCaveGenerator cn = new CellNoiseCaveGenerator(0);

        long seed = 42;

        cn.generateScaled(seed,
                new Vec3i(0, yOff / 4, 0),
                new Vec3i(w / 4, (yOff + h) / 4, 1), new Vec3i(4, 4, 4),
                (x, y, z, v, lavaY, lavaBlock, airBlock, cell, type, cellX, cellY, cellZ) -> {
                    int lavaDepth = lavaY - y;
                    if (Math.abs(y - cellY) <= 2) {
                        noiseCave.setRGB(x - xOff, h - 1 - (y - yOff), 0xFF00FF);
                    } else {
                        noiseCave.setRGB(x - xOff, h - 1 - (y - yOff), terrain(v, lavaDepth, cell));
                    }

                });
        ImageIO.write(noiseCave, "PNG", new File("run/caveScaled.png"));
    }

    private static void cellCavesRaw() throws IOException {
        final int w = 2048;
        final int h = 1024*3;

        BufferedImage noiseCave = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        CellNoiseCaveGenerator cn = new CellNoiseCaveGenerator(0);

        CellNoiseCaveGenerator.CaveSample cs = new CellNoiseCaveGenerator.CaveSample();
        long seed = 42;
        FastRandom rand = new FastRandom();
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                cn.finalCaveNoise(seed, x, y - 3500, 0, cs, rand);
                noiseCave.setRGB(x, y, sign(cs.noise));
            }
        }
        ImageIO.write(noiseCave, "PNG", new File("run/cave.png"));
    }

    private static void cellNoise() throws IOException {
        final int w = 2048;
        final int h = 1024*3;
        long seed = 42;
        CellGenerator cg = new CellGenerator(seed);
        BufferedImage cells = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        BufferedImage distance = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        BufferedImage distanceFromEdge = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);


        CellGenerator.CellValue val = new CellGenerator.CellValue();
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                val = cg.generate(x * 0.02, y * 0.02, 0, val);
                cells.setRGB(x, y, val.cell & 0xFFFFFF);
                distance.setRGB(x, y, gray(val.distance));
                distanceFromEdge.setRGB(x, y, gray(val.distanceFromEdge));

            }
        }
        ImageIO.write(cells, "PNG", new File("run/cells.png"));
        ImageIO.write(distance, "PNG", new File("run/cellsDist.png"));
        ImageIO.write(distanceFromEdge, "PNG", new File("run/cellsDistE.png"));
    }

    private static void turbulentCellNoise() throws IOException {
        final int w = 2048;
        final int h = 1024*3;
        long seed = 42;
        CellGenerator cg = new CellGenerator(seed);
        BufferedImage cells = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        BufferedImage distance = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);
        BufferedImage distanceFromEdge = new BufferedImage(w, h, BufferedImage.TYPE_INT_RGB);

        final double turbFreq = 0.005;
        final double turbAmp = 1.5;

        CellGenerator.CellValue val = new CellGenerator.CellValue();
        for (int x = 0; x < w; x++) {
            for (int y = 0; y < h; y++) {
                double tx = perlin((int)(seed + 1), x * turbFreq, y*turbFreq, 0, turbAmp, 0.5, 2, 6);
                double ty = perlin((int)(seed + 2), x * turbFreq, y*turbFreq, 0, turbAmp, 0.5, 2, 6);
                val = cg.generate(x * 0.02 + tx, y * 0.02 + ty, 0, val);
                cells.setRGB(x, y, val.cell & 0xFFFFFF);
                distance.setRGB(x, y, gray(val.distance));
                distanceFromEdge.setRGB(x, y, gray(val.distanceFromEdge));

            }
        }
        ImageIO.write(cells, "PNG", new File("run/cellsT.png"));
        ImageIO.write(distance, "PNG", new File("run/cellsTDist.png"));
        ImageIO.write(distanceFromEdge, "PNG", new File("run/cellsTDistE.png"));
    }

    private static double perlin(int seed, double x, double y, double z, double amplitude, double persistence, double lacunarity, int octaves) {
        double total = 0;
        for (int i = 0; i < octaves - 1; i++) {
            total += (Noise.gradientCoherentNoise3D(x, y, z, seed, NoiseQuality.BEST) * 2 - 1) * amplitude;
            amplitude *= persistence;
            x *= lacunarity;
            y *= lacunarity;
            z *= lacunarity;
        }
        total += Noise.gradientCoherentNoise3D(x, y, z, seed, NoiseQuality.BEST) * amplitude;
        return total;
    }

    private static int gray(double x) {
        int v = MathHelper.clamp((int) MathUtil.lerp(x, 0, 256), 0, 255);
        return v | v << 8 | v << 16;
    }

    private static int sign(double x) {
        if (x > 0) {
            int v = MathHelper.clamp((int) MathUtil.lerp(x, 0, 256), 0, 255);
            return v << 16;
        } else {
            return MathHelper.clamp((int) MathUtil.lerp(-x, 0, 256), 0, 255);
        }
    }

    private static int terrain(double x, int lavaDepth, int cell) {
        boolean colorizeCells = false;
        if (x < 0) {
            int col = gray(MathHelper.clamp(-x * 0.8 + 0.4, 0.4, 0.8));
            if (colorizeCells) {
                col = col & ~0xFF | (cell & 0xFF);
            }
            return col;
        }
        if (lavaDepth >= 0) {
            int r = 0xFF;
            int g = MathHelper.clamp(0xAA - lavaDepth - (int) (x * 128), 0, 255);
            return r << 16 | g << 8 | (colorizeCells ? (cell & 0xFF) : 0);
        }
        return colorizeCells ? cell & 0xFF : MathHelper.clamp((int) (x * 32), 0, 32);
    }
}