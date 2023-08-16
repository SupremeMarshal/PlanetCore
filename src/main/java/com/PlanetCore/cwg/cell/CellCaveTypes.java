package com.PlanetCore.cwg.cell;

import static com.PlanetCore.cwg.cell.CellCaveType.builder;

public class CellCaveTypes {

    public static final CellCaveType NO_CAVE = builder()
            .cellWallTransitionHardness(0)
            .scaleFactor(0)
            .caveScale(0)
            .placementScale(0)
            .caveSystemSizeFactor(0)
            .transitionConstant1(0)
            .transitionConstant2(0)
            .caveOctaves(0)
            .placementOctaves(0)
            .caveFillConstant(0)
            .yCutoffMax(Double.POSITIVE_INFINITY)
            .yCutoffFactorCaveMax(0)
            .yCutoffFactorPlacementMax(0)
            .yCutoffMin(Double.NEGATIVE_INFINITY)
            .yCutoffFactorCaveMin(0)
            .yCutoffFactorPlacementMin(0)
            .build();

    public static final CellCaveType SMALL_CAVES = builder()
            .cellWallTransitionHardness(2)
            .scaleFactor(2)
            // the scale for caves when they generate
            // smaller value = bigger caves
            .caveScale(1 / 50.0)
            // the scale for placement
            // 2/placementScale should be roughly the average distance between cave systems
            .placementScale(1 / 512.0)
            // bigger value = smaller cave systems
            // value 0f 0 means that all of the world will be cave systems
            // values above 0.5 are expected to make them unusably small
            // value 1 and above means they won't generate
            .caveSystemSizeFactor(0.30)
            // bigger values = less smooth transition on the edges of cave system
            .transitionConstant1(2)
            // bigger value means smoother transitions at the edges, but also smaller cave systems (in a way similar to caveSystemSizeFactor)
            .transitionConstant2(0.2)
            // bigger value = finer detail for caves. Adding 1 = double the detail
            .caveOctaves(16)
            // bigger value = finer detail for placement. Adding 1 = double the detail
            .placementOctaves(16)
            // bigger values -> caves are more filled with air and less with stone
            .caveFillConstant(0.3)
            .yCutoffMax(Double.POSITIVE_INFINITY)
            .yCutoffFactorCaveMax(0)
            .yCutoffFactorPlacementMax(0)
            .yCutoffMin(Double.NEGATIVE_INFINITY)
            .yCutoffFactorCaveMin(0)
            .yCutoffFactorPlacementMin(0)
            .build();
    public static final CellCaveType BIG_CAVES = builder()
            .cellWallTransitionHardness(5)
            .scaleFactor(6)
            .caveScale(1 / 100.0)
            .placementScale(1)
            .caveSystemSizeFactor(0.27)
            .transitionConstant1(40)
            .transitionConstant2(0.4)
            .caveOctaves(2)
            .placementOctaves(0)
            .caveFillConstant(0.05)
            .yCutoffMax(-200)
            .yCutoffFactorCaveMax(0.01)
            .yCutoffFactorPlacementMax(0.01)
            .yCutoffMin(-500)
            .yCutoffFactorCaveMin(0.002)
            .yCutoffFactorPlacementMin(0.002)
            .build();

    public static final CellCaveType SUPER_LARGE_CAVES = builder()
            .cellWallTransitionHardness(5)
            .scaleFactor(10)
            .caveScale(1 / 200.0)
            .placementScale(1)
            .caveSystemSizeFactor(0.1)
            .transitionConstant1(40)
            .transitionConstant2(0.4)
            .caveOctaves(1)
            .placementOctaves(0)
            .caveFillConstant(1)
            .yCutoffMax(-1200)
            .yCutoffFactorCaveMax(0.001)
            .yCutoffFactorPlacementMax(0.001)
            .yCutoffMin(-1800)
            .yCutoffFactorCaveMin(0.001)
            .yCutoffFactorPlacementMin(0.001)
            .build();
    public static final CellCaveType VERY_SMALL_CAVES = builder()
            .cellWallTransitionHardness(5)
            .scaleFactor(1)
            .caveScale(1 / 10.0)
            .placementScale(1)
            .caveSystemSizeFactor(0.27)
            .transitionConstant1(40)
            .transitionConstant2(0.4)
            .caveOctaves(8)
            .placementOctaves(0)
            .caveFillConstant(0.2)
            .yCutoffMax(Double.POSITIVE_INFINITY)
            .yCutoffFactorCaveMax(0)
            .yCutoffFactorPlacementMax(0)
            .yCutoffMin(Double.NEGATIVE_INFINITY)
            .yCutoffFactorCaveMin(0)
            .yCutoffFactorPlacementMin(0)
            .build();

    public static final CellCaveType CAVE = builder()
            .cellWallTransitionHardness(5)
            .scaleFactor(2)
            .caveScale(1 / 10.0)
            .placementScale(1)
            .caveSystemSizeFactor(0.35)
            .transitionConstant1(40)
            .transitionConstant2(0.4)
            .caveOctaves(8)
            .placementOctaves(0)
            .caveFillConstant(0.2)
            .yCutoffMax(Double.POSITIVE_INFINITY)
            .yCutoffFactorCaveMax(0)
            .yCutoffFactorPlacementMax(0)
            .yCutoffMin(Double.NEGATIVE_INFINITY)
            .yCutoffFactorCaveMin(0)
            .yCutoffFactorPlacementMin(0)
            .build();

    public static final CellCaveType CAVE1 = builder()
            .cellWallTransitionHardness(5)
            .scaleFactor(1)
            .caveScale(1 / 20.0)
            .placementScale(1)
            .caveSystemSizeFactor(0.65)
            .transitionConstant1(20)
            .transitionConstant2(0.4)
            .caveOctaves(12)
            .placementOctaves(12)
            .caveFillConstant(1)
            .yCutoffMax(-60)
            .yCutoffFactorCaveMax(0.02)
            .yCutoffFactorPlacementMax(0.02)
            .yCutoffMin(Double.NEGATIVE_INFINITY)
            .yCutoffFactorCaveMin(0)
            .yCutoffFactorPlacementMin(0)
            .build();

}
