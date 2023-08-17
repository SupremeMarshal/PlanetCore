package com.PlanetCore.util;

/**
 * Similar to java.util.Random functionality, but not thread safe, no argument checks, and lower quality RNG
 */
public class FastRandom {
    private static final long multiplier = 0x5DEECE66DL;
    private static final long addend = 0xBL;
    private static final long mask = (1L << 48) - 1;
    private long seed;
    private boolean haveNextNextGaussian = false;
    private double nextNextGaussian;

    public void setSeed(long seed) {
        this.seed = seed;
        haveNextNextGaussian = false;
    }

    public int nextBits(int bits) {
        seed = (seed * multiplier + addend) & mask;
        return (int)(seed >>> (48 - bits));
    }

    public boolean nextBoolean() {
        return nextBits(1) != 0;
    }

    public int nextInt(int bound) {
        if ((bound & -bound) == bound)
            // i.e., bound is a power of 2
            return (int)((bound * (long)nextBits(31)) >> 31);
        return nextBits(31) % bound;
    }

    public int nextInt(int minInclusive, int maxExclusive) {
        return nextInt(maxExclusive - minInclusive) + minInclusive;
    }

    public float nextFloat() {
        return nextBits(24) * (1f / (1 << 24));
    }

    public double nextDouble() {
        return (((long)(nextBits(26)) << 27) + nextBits(27)) * (1.0 / (1L << 53));
    }

    public double nextGaussian() {
        // See Knuth, ACP, Section 3.4.1 Algorithm C.
        if (haveNextNextGaussian) {
            haveNextNextGaussian = false;
            return nextNextGaussian;
        } else {
            double v1, v2, s;
            do {
                v1 = 2 * nextFloat() - 1; // between -1 and 1
                v2 = 2 * nextFloat() - 1; // between -1 and 1
                s = v1 * v1 + v2 * v2;
            } while (s >= 1 || s == 0);
            double multiplier = StrictMath.sqrt(-2 * StrictMath.log(s)/s);
            nextNextGaussian = v2 * multiplier;
            haveNextNextGaussian = true;
            return v1 * multiplier;
        }
    }
}
