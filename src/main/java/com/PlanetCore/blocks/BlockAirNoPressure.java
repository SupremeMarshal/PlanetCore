package com.PlanetCore.blocks;

import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.BlockAir;

public class BlockAirNoPressure extends BlockAir {
    public BlockAirNoPressure(String name) {
        setTranslationKey(name);
        setRegistryName(name);
        ModBlocks.BLOCKS.add(this);
    }
}
