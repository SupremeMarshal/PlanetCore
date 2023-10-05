package com.PlanetCore.blockentity;

import com.PlanetCore.init.ModFluids;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import java.util.Map;

public class LavaFuelStats {

    //todo, make user defined
    public final int rate;
    public final int time;

    public LavaFuelStats(int rate, int time) {
        this.rate = rate;
        this.time = time;
    }

    public static final LavaFuelStats LAVA = new LavaFuelStats(25,20 * 1 * 60);
    public static final LavaFuelStats IRON_LAVA = new LavaFuelStats(50,20 * 1 * 60);
    public static final LavaFuelStats SILVER_LAVA = new LavaFuelStats(50,20 * 1 * 60);
    public static final LavaFuelStats GOLD_LAVA = new LavaFuelStats(50,20 * 1 * 60);


    public static void bootstrap(Map<Fluid, LavaFuelStats> generatorStatsMap) {
        generatorStatsMap.put(FluidRegistry.LAVA,IRON_LAVA);
        generatorStatsMap.put(ModFluids.IRON_LAVA_FLUID,IRON_LAVA);
        generatorStatsMap.put(ModFluids.SILVER_LAVA_FLUID,SILVER_LAVA);
        generatorStatsMap.put(ModFluids.GOLD_LAVA_FLUID,GOLD_LAVA);
    }
}
