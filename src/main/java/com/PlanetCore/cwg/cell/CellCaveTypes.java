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
    public static final CellCaveType VERY_SMALL_CAVES = builder()
            .cellWallTransitionHardness(5)
            .scaleFactor(1)
            .caveScale(1 / 10.0)
            .placementScale(1 / 2560.0)
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

    public static final CellCaveType GRANITE_CAVE = builder()
            .cellWallTransitionHardness(2)
            .scaleFactor(2)
            // the scale for caves when they generate
            // smaller value = bigger caves
            .caveScale(1 / 250.0)
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
            .caveFillConstant(0.9)
            .yCutoffMax(Double.POSITIVE_INFINITY)
            .yCutoffFactorCaveMax(0)
            .yCutoffFactorPlacementMax(0)
            .yCutoffMin(Double.NEGATIVE_INFINITY)
            .yCutoffFactorCaveMin(0)
            .yCutoffFactorPlacementMin(0)
            .build();
    public static final CellCaveType QUARTZ_CAVE = builder()
            .cellWallTransitionHardness(2)
            .scaleFactor(2)
            // the scale for caves when they generate
            // smaller value = bigger caves
            .caveScale(1 / 250.0)
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
            .caveFillConstant(0.9)
            .yCutoffMax(Double.POSITIVE_INFINITY)
            .yCutoffFactorCaveMax(0)
            .yCutoffFactorPlacementMax(0)
            .yCutoffMin(Double.NEGATIVE_INFINITY)
            .yCutoffFactorCaveMin(0)
            .yCutoffFactorPlacementMin(0)
            .build();

    public static final CellCaveType BLACKSTONE_CAVE = builder()
            .cellWallTransitionHardness(2)
            .scaleFactor(2)
            // the scale for caves when they generate
            // smaller value = bigger caves
            .caveScale(1 / 250.0)
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
            .caveFillConstant(0.9)
            .yCutoffMax(Double.POSITIVE_INFINITY)
            .yCutoffFactorCaveMax(0)
            .yCutoffFactorPlacementMax(0)
            .yCutoffMin(Double.NEGATIVE_INFINITY)
            .yCutoffFactorCaveMin(0)
            .yCutoffFactorPlacementMin(0)
            .build();

    public static final CellCaveType PERIDOTITE_CAVE = builder()
            .cellWallTransitionHardness(2)
            .scaleFactor(2)
            // the scale for caves when they generate
            // smaller value = bigger caves
            .caveScale(1 / 250.0)
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
            .caveFillConstant(0.9)
            .yCutoffMax(Double.POSITIVE_INFINITY)
            .yCutoffFactorCaveMax(0)
            .yCutoffFactorPlacementMax(0)
            .yCutoffMin(Double.NEGATIVE_INFINITY)
            .yCutoffFactorCaveMin(0)
            .yCutoffFactorPlacementMin(0)
            .build();

    public static final CellCaveType GARNET_CAVE = builder()
            .cellWallTransitionHardness(2)
            .scaleFactor(2)
            // the scale for caves when they generate
            // smaller value = bigger caves
            .caveScale(1 / 250.0)
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
            .caveFillConstant(0.9)
            .yCutoffMax(Double.POSITIVE_INFINITY)
            .yCutoffFactorCaveMax(0)
            .yCutoffFactorPlacementMax(0)
            .yCutoffMin(Double.NEGATIVE_INFINITY)
            .yCutoffFactorCaveMin(0)
            .yCutoffFactorPlacementMin(0)
            .build();

    public static final CellCaveType BRIDGMANITE_CAVE = builder()
            .cellWallTransitionHardness(2)
            .scaleFactor(2)
            // the scale for caves when they generate
            // smaller value = bigger caves
            .caveScale(1 / 250.0)
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
            .caveFillConstant(0.9)
            .yCutoffMax(Double.POSITIVE_INFINITY)
            .yCutoffFactorCaveMax(0)
            .yCutoffFactorPlacementMax(0)
            .yCutoffMin(Double.NEGATIVE_INFINITY)
            .yCutoffFactorCaveMin(0)
            .yCutoffFactorPlacementMin(0)
            .build();

    public static final CellCaveType FERROPERICLASE_CAVE = builder()
            .cellWallTransitionHardness(2)
            .scaleFactor(2)
            // the scale for caves when they generate
            // smaller value = bigger caves
            .caveScale(1 / 250.0)
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
            .caveFillConstant(0.9)
            .yCutoffMax(Double.POSITIVE_INFINITY)
            .yCutoffFactorCaveMax(0)
            .yCutoffFactorPlacementMax(0)
            .yCutoffMin(Double.NEGATIVE_INFINITY)
            .yCutoffFactorCaveMin(0)
            .yCutoffFactorPlacementMin(0)
            .build();
    public static final CellCaveType CORESTONE_CAVE = builder()
            .cellWallTransitionHardness(2)
            .scaleFactor(2)
            // the scale for caves when they generate
            // smaller value = bigger caves
            .caveScale(1 / 250.0)
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
            .caveFillConstant(0.9)
            .yCutoffMax(Double.POSITIVE_INFINITY)
            .yCutoffFactorCaveMax(0)
            .yCutoffFactorPlacementMax(0)
            .yCutoffMin(Double.NEGATIVE_INFINITY)
            .yCutoffFactorCaveMin(0)
            .yCutoffFactorPlacementMin(0)
            .build();

    public static final CellCaveType ONYXSLATE_CAVE = builder()
            .cellWallTransitionHardness(2)
            .scaleFactor(2)
            // the scale for caves when they generate
            // smaller value = bigger caves
            .caveScale(1 / 250.0)
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
            .caveFillConstant(0.9)
            .yCutoffMax(Double.POSITIVE_INFINITY)
            .yCutoffFactorCaveMax(0)
            .yCutoffFactorPlacementMax(0)
            .yCutoffMin(Double.NEGATIVE_INFINITY)
            .yCutoffFactorCaveMin(0)
            .yCutoffFactorPlacementMin(0)
            .build();
    public static final CellCaveType COAL_CAVE = builder()
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

    public static final CellCaveType IRON_CAVE = builder()
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

    public static final CellCaveType SULFUR_CAVE = builder()
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

    public static final CellCaveType REDSTONE_CAVE = builder()
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

    public static final CellCaveType LAPIS_CAVE = builder()
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

    public static final CellCaveType SILVER_CAVE = builder()
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

    public static final CellCaveType GOLD_CAVE = builder()
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

    public static final CellCaveType TITANIUM_CAVE = builder()
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

    public static final CellCaveType URANIUM_CAVE = builder()
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

    public static final CellCaveType TUNGSTEN_CAVE = builder()
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

    public static final CellCaveType DIAMOND_CAVE = builder()
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

    public static final CellCaveType EMERALD_CAVE = builder()
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

    public static final CellCaveType RUBY_CAVE = builder()
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

    public static final CellCaveType SAPPHIRE_CAVE = builder()
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

    public static final CellCaveType MAJORITE_CAVE = builder()
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

    public static final CellCaveType AMAZONITE_CAVE = builder()
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

    public static final CellCaveType ONYX_CAVE = builder()
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

    public static final CellCaveType PAINITE_CAVE = builder()
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
}
