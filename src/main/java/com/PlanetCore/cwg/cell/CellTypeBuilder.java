package com.PlanetCore.cwg.cell;

import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;

import java.util.function.Supplier;

public class CellTypeBuilder {

    /**
     * controls how "suddenly" a cave system will disappear when near its cell boundary
     * low values mean that the cave will end more "softly", but as a consequence the air pockets may be smaller
     * high values mean the cave will end more abruptly near the edge of its cell, but can take more of its space
     * value of Float.POSITIVE_INFINITY makes (theoretically) infinitely thin transition wall, which in practice means cell walls
     */
    private double cellWallTransitionHardness = 2;

    /**
     * random seed modifier for the cave, so different cells can have different noise seed
     */
    private long seedModifier = 0;

    /**
     * Common multiplier for caveScale and placementScale
     */
    private double scaleFactor = 2;

    /**
     * the scale for caves when they generate
     * smaller value -> bigger caves
     */
    private double caveScale = 1 / 50.0;

    /**
     * the scale for placement
     * 2/placementScale should be roughly the average distance between cave systems
     */
    private double placementScale = 1 / 1024.0;
    /**
     * bigger value -> smaller cave systems
     * value 0f 0 means that all of the world will be cave systems
     * values above 0.5 are expected to make them unusably small
     * value 1 and above means they won't generate
     */
    private double caveSystemSizeFactor = 0.27;

    /**
     * bigger values -> less smooth transition on the edges of cave system
     */
    private double transitionConstant1 = 40;

    /**
     * bigger value means smoother transitions at the edges, but also smaller cave systems (in a way similar to caveSystemSizeFactor)
     */
    private double transitionConstant2 = 0.4;

    /**
     * bigger value -> finer detail for caves. Adding 1 -> double the detail
     */
    private int caveOctaves = 8;

    /**
     * bigger value -> finer detail for placement. Adding 1 -> double the detail
     */
    private int placementOctaves = 8;

    /**
     * bigger values -> caves are more filled with air and less with stone
     */
    private double caveFillConstant = 0.0;

    /**
     * caves will begin to get smaller above this height
     */
    private double yCutoffMax = -1500;

    /**
     * specifies how quickly they will get smaller as you go up
     */
    private double yCutoffFactorCaveMax = 0.004;

    /**
     * specifies how quickly cave systems become smaller as you go up
     */
    private double yCutoffFactorPlacementMax = 0.004;

    /**
     * caves will begin to get smaller below this height
     */
    private double yCutoffMin = -2200;

    /**
     * specifies how quickly they will get smaller as you go down
     */
    private double yCutoffFactorCaveMin = 0.001;

    /**
     * specifies how quickly cave systems become smaller as you go down
     */
    private double yCutoffFactorPlacementMin = 0.001;

    public CellTypeBuilder cellWallTransitionHardness(double cellWallTransitionHardness) {
        this.cellWallTransitionHardness = cellWallTransitionHardness;
        return this;
    }

    public CellTypeBuilder seedModifier(long seedModifier) {
        this.seedModifier = seedModifier;
        return this;
    }

    public CellTypeBuilder scaleFactor(double scaleFactor) {
        this.scaleFactor = scaleFactor;
        return this;
    }

    public CellTypeBuilder caveScale(double caveScale) {
        this.caveScale = caveScale;
        return this;
    }

    public CellTypeBuilder placementScale(double placementScale) {
        this.placementScale = placementScale;
        return this;
    }

    public CellTypeBuilder caveSystemSizeFactor(double caveSystemSizeFactor) {
        this.caveSystemSizeFactor = caveSystemSizeFactor;
        return this;
    }

    public CellTypeBuilder transitionConstant1(double transitionConstant1) {
        this.transitionConstant1 = transitionConstant1;
        return this;
    }

    public CellTypeBuilder transitionConstant2(double transitionConstant2) {
        this.transitionConstant2 = transitionConstant2;
        return this;
    }

    public CellTypeBuilder caveOctaves(int caveOctaves) {
        this.caveOctaves = caveOctaves;
        return this;
    }

    public CellTypeBuilder placementOctaves(int placementOctaves) {
        this.placementOctaves = placementOctaves;
        return this;
    }

    public CellTypeBuilder caveFillConstant(double caveFillConstant) {
        this.caveFillConstant = caveFillConstant;
        return this;
    }

    public CellTypeBuilder yCutoffMax(double yCutoffMax) {
        this.yCutoffMax = yCutoffMax;
        return this;
    }

    public CellTypeBuilder yCutoffFactorCaveMax(double yCutoffFactorCaveMax) {
        this.yCutoffFactorCaveMax = yCutoffFactorCaveMax;
        return this;
    }

    public CellTypeBuilder yCutoffFactorPlacementMax(double yCutoffFactorPlacementMax) {
        this.yCutoffFactorPlacementMax = yCutoffFactorPlacementMax;
        return this;
    }

    public CellTypeBuilder yCutoffMin(double yCutoffMin) {
        this.yCutoffMin = yCutoffMin;
        return this;
    }

    public CellTypeBuilder yCutoffFactorCaveMin(double yCutoffFactorCaveMin) {
        this.yCutoffFactorCaveMin = yCutoffFactorCaveMin;
        return this;
    }

    public CellTypeBuilder yCutoffFactorPlacementMin(double yCutoffFactorPlacementMin) {
        this.yCutoffFactorPlacementMin = yCutoffFactorPlacementMin;
        return this;
    }

    public CellCaveType build() {
        return new CellCaveType(cellWallTransitionHardness, seedModifier,
                caveScale * scaleFactor, placementScale * scaleFactor, caveSystemSizeFactor,
                transitionConstant1, transitionConstant2,
                caveOctaves, placementOctaves, caveFillConstant,
                yCutoffMax, yCutoffFactorCaveMax, yCutoffFactorPlacementMax, yCutoffMin, yCutoffFactorCaveMin, yCutoffFactorPlacementMin);
    }
}
