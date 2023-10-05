package com.PlanetCore.blocks;

import com.PlanetCore.blockentity.LavaGeneratorBlockEntity;
import com.PlanetCore.blockentity.LavagenStubs;
import net.minecraft.tileentity.TileEntity;

import java.util.function.Supplier;

public enum DefaultGeneratorStats implements LavaGeneratorBlock.GeneratorStats {
    IRON(100000,10000,3000,10000, LavagenStubs.Iron::new),
    DIAMOND(500000,20000,4200,10000, LavagenStubs.Diamond::new),
    titanium(1000000,300000,4200,10000, LavagenStubs.Titanium::new),
    uranium(1000000,400000,4200,10000, LavagenStubs.Uranium::new),
    tungsten(2000000,500000,4500,10000, LavagenStubs.Tungsten::new),
    ruby(5000000,750000,5000,10000, LavagenStubs.Ruby::new),
    sapphire(10000000,1000000,6000,10000, LavagenStubs.Sapphire::new),
    majorite(20000000,1000000,7000,10000, LavagenStubs.Majorite::new),
    amazonite(50000000,1000000,8000,10000, LavagenStubs.Amazonite::new),
    onyx(100000000,1000000,10000,10000, LavagenStubs.Onyx::new);

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
