package com.PlanetCore.anvils;

public enum EnumVariants {
    NORMAL("_anvil"),
    CHIPPED("_anvil_chipped"),
    DAMAGED("_anvil_damaged");

    private String s;

    private EnumVariants(String variant) {
        this.s = variant;
    }

    public String getString() {
        return this.s;
    }
}
