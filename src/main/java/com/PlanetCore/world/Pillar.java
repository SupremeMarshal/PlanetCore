package com.PlanetCore.world;

import net.minecraft.util.math.BlockPos;

import java.util.Objects;

public class Pillar {
    private BlockPos base;
    private int height;

    public Pillar(BlockPos base, int height) {
        this.base = base;
        this.height = height;
    }

    public static Pillar of(BlockPos pos,int height) {
        return new Pillar(pos,height);
    }

    public BlockPos getBase() {
        return base;
    }

    public void setBase(BlockPos base) {
        this.base = base;
    }

    public BlockPos getTop() {
        return base.toImmutable().up(height-1);
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public boolean contains(BlockPos pos) {
        if (pos.getX() == base.getX() && pos.getZ() == base.getZ()) {
            int diff = pos.getY() - base.getY();
            if (diff < 0)return false;
            return height > diff;
        }
        return false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pillar pillar = (Pillar) o;
        return height == pillar.height && Objects.equals(base, pillar.base);
    }

    @Override
    public int hashCode() {
        return Objects.hash(base, height);
    }
}
