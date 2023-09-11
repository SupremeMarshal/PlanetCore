package com.PlanetCore.blocks;

import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.BlockFire;

public class customFire extends BlockFire {
    public customFire(String name) {
        super();
        setTranslationKey(name);
        setRegistryName(name);
        ModBlocks.BLOCKS.add(this);
    }
}
