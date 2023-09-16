package com.PlanetCore.util.handlers;

public class HasArmor implements IHasArmor {
    private boolean hasArmor = false;

    @Override
    public boolean hasArmor() {
        return hasArmor;
    }

    @Override
    public void setHasArmor(boolean hasArmor) {
        this.hasArmor = hasArmor;
    }
}