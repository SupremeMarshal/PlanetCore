package com.PlanetCore.blockentity;

import com.PlanetCore.init.ModFluids;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;

import java.util.Map;

public class GeneratorStats {

    //todo, make user defined
    public final int rate;
    public final int time;

    public GeneratorStats(int rate, int time) {
        this.rate = rate;
        this.time = time;
    }

    public static final GeneratorStats LAVA = new GeneratorStats(250,20 * 5 * 60);
    public static final GeneratorStats IRON_LAVA = new GeneratorStats(500,20 * 5 * 60);
    public static final GeneratorStats SILVER_LAVA = new GeneratorStats(500,20 * 5 * 60);
    public static final GeneratorStats GOLD_LAVA = new GeneratorStats(500,20 * 5 * 60);


    public static void bootstrap(Map<Fluid, GeneratorStats> generatorStatsMap) {
        generatorStatsMap.put(FluidRegistry.LAVA,IRON_LAVA);
        generatorStatsMap.put(ModFluids.IRON_LAVA_FLUID,IRON_LAVA);
        generatorStatsMap.put(ModFluids.SILVER_LAVA_FLUID,SILVER_LAVA);
        generatorStatsMap.put(ModFluids.GOLD_LAVA_FLUID,GOLD_LAVA);
    }
}
