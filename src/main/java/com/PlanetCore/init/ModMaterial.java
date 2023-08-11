package com.PlanetCore.init;

import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialTransparent;

public class ModMaterial {

    public static final ModMaterial AIR_NO_PRESSURE = new ModMaterial(MapColor.AIR);
    private final MapColor materialMapColor;
    public ModMaterial(MapColor materialMapColor) {
        this.materialMapColor = materialMapColor;
    }
}
