package com.PlanetCore.anvils.generic;

public class AnvilProperties {
    public final String material;
    public final int cap;
    public final double weight;
    public final double fallResistance;
    public final double durabilityMultiplier;
    public final double enchantability;
    public final boolean causesPlayerDamage;

    public AnvilProperties(String materialName, int maxLevelCap, double weight, double fallResistance, double durabilityMultiplier, double costMultiplier, boolean causesPlayerDamage) {
        this.material = materialName;
        this.cap = maxLevelCap;
        this.weight = weight;
        this.fallResistance = fallResistance;
        this.durabilityMultiplier = durabilityMultiplier;
        this.enchantability = costMultiplier;
        this.causesPlayerDamage = causesPlayerDamage;
    }
}
