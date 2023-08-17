package com.PlanetCore.cwg.cell;

import java.util.Objects;

// properties of an individual cell noise cave
@SuppressWarnings({"Convert2MethodRef"}) // converting to references breaks on null values in tests
public final class CellCaveType {
    public final double cellWallTransitionHardness;

    public final long seedModifier;

    public final double caveScale;
    public final double placementScale;
    public final double caveSystemSizeFactor;

    public final double transitionConstant1;
    public final double transitionConstant2;

    public final int caveOctaves;
    public final int placementOctaves;

    public final double caveFillConstant;

    public final double yCutoffMax;
    public final double yCutoffFactorCaveMax;
    public final double yCutoffFactorPlacementMax;

    public final double yCutoffMin;
    public final double yCutoffFactorCaveMin;
    public final double yCutoffFactorPlacementMin;

    final double perlinCaveNoiseFactor, perlinPlacementNoiseFactor;

    public static CellTypeBuilder builder() {
        return new CellTypeBuilder();
    }

    CellCaveType(double cellWallTransitionHardness, long seedModifier, double caveScale, double placementScale,
            double caveSystemSizeFactor, double transitionConstant1, double transitionConstant2, int caveOctaves, int placementOctaves,
            double caveFillConstant, double yCutoffMax, double yCutoffFactorCaveMax, double yCutoffFactorPlacementMax, double yCutoffMin,
            double yCutoffFactorCaveMin,
            double yCutoffFactorPlacementMin) {
        this.cellWallTransitionHardness = cellWallTransitionHardness;
        this.seedModifier = seedModifier;
        this.caveScale = caveScale;
        this.placementScale = placementScale;
        this.caveSystemSizeFactor = caveSystemSizeFactor;
        this.transitionConstant1 = transitionConstant1;
        this.transitionConstant2 = transitionConstant2;
        this.caveOctaves = caveOctaves;
        this.placementOctaves = placementOctaves;
        this.caveFillConstant = caveFillConstant;
        this.yCutoffMax = yCutoffMax;
        this.yCutoffFactorCaveMax = yCutoffFactorCaveMax;
        this.yCutoffFactorPlacementMax = yCutoffFactorPlacementMax;
        this.yCutoffMin = yCutoffMin;
        this.yCutoffFactorCaveMin = yCutoffFactorCaveMin;
        this.yCutoffFactorPlacementMin = yCutoffFactorPlacementMin;

        this.perlinCaveNoiseFactor = perlinMaxValue(caveOctaves, 0.5);
        this.perlinPlacementNoiseFactor = perlinMaxValue(placementOctaves, 0.5);
    }

    @Override public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        CellCaveType that = (CellCaveType) o;
        return Double.compare(cellWallTransitionHardness, that.cellWallTransitionHardness) == 0 && seedModifier == that.seedModifier
                && Double.compare(caveScale, that.caveScale) == 0 && Double.compare(placementScale, that.placementScale) == 0
                && Double.compare(caveSystemSizeFactor, that.caveSystemSizeFactor) == 0
                && Double.compare(transitionConstant1, that.transitionConstant1) == 0
                && Double.compare(transitionConstant2, that.transitionConstant2) == 0 && caveOctaves == that.caveOctaves
                && placementOctaves == that.placementOctaves && Double.compare(caveFillConstant, that.caveFillConstant) == 0
                && Double.compare(yCutoffMax, that.yCutoffMax) == 0 && Double.compare(yCutoffFactorCaveMax, that.yCutoffFactorCaveMax) == 0
                && Double.compare(yCutoffFactorPlacementMax, that.yCutoffFactorPlacementMax) == 0 && Double.compare(yCutoffMin, that.yCutoffMin) == 0
                && Double.compare(yCutoffFactorCaveMin, that.yCutoffFactorCaveMin) == 0
                && Double.compare(yCutoffFactorPlacementMin, that.yCutoffFactorPlacementMin) == 0;
    }

    @Override public int hashCode() {
        return Objects.hash(cellWallTransitionHardness,
                seedModifier,
                caveScale, placementScale, caveSystemSizeFactor, transitionConstant1, transitionConstant2, caveOctaves, placementOctaves,
                caveFillConstant, yCutoffMax, yCutoffFactorCaveMax, yCutoffFactorPlacementMax, yCutoffMin, yCutoffFactorCaveMin,
                yCutoffFactorPlacementMin);
    }

    @Override public String toString() {
        return "CellCaveType{" +
                ", cellWallTransitionHardness=" + cellWallTransitionHardness +
                ", seedModifier=" + seedModifier +
                ", caveScale=" + caveScale +
                ", placementScale=" + placementScale +
                ", caveSystemSizeFactor=" + caveSystemSizeFactor +
                ", transitionConstant1=" + transitionConstant1 +
                ", transitionConstant2=" + transitionConstant2 +
                ", caveOctaves=" + caveOctaves +
                ", placementOctaves=" + placementOctaves +
                ", caveFillConstant=" + caveFillConstant +
                ", yCutoffMax=" + yCutoffMax +
                ", yCutoffFactorCaveMax=" + yCutoffFactorCaveMax +
                ", yCutoffFactorPlacementMax=" + yCutoffFactorPlacementMax +
                ", yCutoffMin=" + yCutoffMin +
                ", yCutoffFactorCaveMin=" + yCutoffFactorCaveMin +
                ", yCutoffFactorPlacementMin=" + yCutoffFactorPlacementMin +
                ", perlinCaveNoiseFactor=" + perlinCaveNoiseFactor +
                ", perlinPlacementNoiseFactor=" + perlinPlacementNoiseFactor +
                '}';
    }

    private static double perlinMaxValue(int octaves, double persistence) {
        // value of geometric series in the form ar^0 + ar^1 + ar^2 ... + ar^(n-1):
        // a * (1 - r^n) / (1 - r)
        // see: https://en.wikipedia.org/wiki/Geometric_series
        // in this case, r=persistence, a=1, and n=octaves
        return (1 - Math.pow(persistence, octaves)) / (1 - persistence);
    }

}
