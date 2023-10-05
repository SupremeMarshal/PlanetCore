package com.PlanetCore.blocks;

import com.PlanetCore.blockentity.LavaGeneratorBlockEntity;
import com.PlanetCore.blockentity.LavagenStubs;
import net.minecraft.tileentity.TileEntity;

import java.util.function.Supplier;

public enum DefaultGeneratorStats implements LavaGeneratorBlock.GeneratorStats {
    IRON(100_000,10_000,3000,10_000, LavagenStubs.Iron::new),
    DIAMOND(100_000,10_000,3000,10_000, LavagenStubs.Diamond::new),
    titanium(100_000,10_000,3000,10_000, LavagenStubs.Titanium::new),
    uranium(100_000,10_000,3000,10_000, LavagenStubs.Uranium::new),
    tungsten(100_000,10_000,3000,10_000, LavagenStubs.Tungsten::new),
    ruby(100_000,10_000,3000,10_000, LavagenStubs.Ruby::new),
    sapphire(100_000,10_000,3000,10_000, LavagenStubs.Sapphire::new),
    majorite(100_000,10_000,3000,10_000, LavagenStubs.Majorite::new),
    amazonite(100_000,10_000,3000,10_000, LavagenStubs.Amazonite::new),
    onyx(100_000,10_000,3000,10_000, LavagenStubs.Onyx::new);

    private final int energyCapacity;
    private final int energyExtractRate;
    private final int maxTemp;
    private final int fluidCapacity;
    private final Supplier<? extends LavaGeneratorBlockEntity> blockEntitySupplier;

    DefaultGeneratorStats(int energy_capacity, int extract_rate, int max_temp, int fluid_capacity, Supplier<? extends LavaGeneratorBlockEntity> blockEntitySupplier1) {
        energyCapacity = energy_capacity;
        energyExtractRate = extract_rate;
        maxTemp = max_temp;
        fluidCapacity = fluid_capacity;
        this.blockEntitySupplier = blockEntitySupplier1;
    }

    @Override
    public int energyCapacity() {
        return energyCapacity;
    }

    @Override
    public int energyExtractRate() {
        return energyExtractRate;
    }

    @Override
    public int maxTemperature() {
        return maxTemp;
    }

    @Override
    public int fluidCapacity() {
        return fluidCapacity;
    }

    @Override
    public TileEntity create() {
        return blockEntitySupplier.get();
    }
}
