package com.PlanetCore.cwg.cell;

import io.github.opencubicchunks.cubicchunks.cubicgen.RngHash;
import net.minecraft.util.math.MathHelper;

/**
 * Cell and voronoi noise generator source
 */
public class CellGenerator {


    private final long seed;

    public CellGenerator(long seed) {
        this.seed = seed;
    }

    public CellValue generate(double x, double y, double z, CellValue v) {
        return generate(seed, x, y, z, v);
    }

    public static CellValue generate(long seed, double x, double y, double z, CellValue v) {
        if (v == null) {
            v = new CellValue();
        }
        int ix = MathHelper.floor(x);
        int iy = MathHelper.floor(y);
        int iz = MathHelper.floor(z);
        float fx = (float) (x - ix);
        float fy = (float) (y - iy);
        float fz = (float) (z - iz);

        v.distance = Double.POSITIVE_INFINITY;
        double dsqMin2 = Float.POSITIVE_INFINITY;
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                for (int dz = -1; dz <= 1; dz++) {
                    int cx = ix + dx;
                    int cy = iy + dy;
                    int cz = iz + dz;
                    int rnd = hash(cx, cy, cz, seed);
                    // take most significant 10 bits for each coords (total 60 bits)
                    // take the least significant bits for Y as that's where any artifacts matter the least
                    // NOTE: multiply by inverse so that the JVM actually compiles it into floating point multiply
                    float vx = (rnd >>> 12 & 0x3FF) * (1f / 0x3FF) + dx;
                    float vy = (rnd >>> 2 & 0x3FF) * (1f / 0x3FF) + dy;
                    float vz = (rnd >>> 22 & 0x3FF) * (1f / 0x3FF) + dz;
                    float dvx = vx - fx;
                    float dvy = vy - fy;
                    float dvz = vz - fz;

                    float dsq = dvx * dvx + dvy * dvy + dvz * dvz;
                    // NOTE: v.distance currently stores squared distance, square root done at the end
                    // also cell stores value before final hash, and x/y/z are converted to global coords at the end
                    if (dsq < v.distance) {
                        dsqMin2 = v.distance;
                        v.distance = dsq;
                        v.cell = rnd;
                        v.cellX = vx;
                        v.cellY = vy;
                        v.cellZ = vz;
                    } else if (dsq < dsqMin2) {
                        dsqMin2 = dsq;
                    }
                }
            }
        }
        // NOTE: different distance functions could be used here
        v.distance = Math.sqrt(v.distance);
        v.distanceFromEdge = Math.sqrt(dsqMin2) - v.distance;
        v.cellX += ix;
        v.cellY += iy;
        v.cellZ += iz;
        v.cell = hash(v.cell); // original value was used to generate cell position, mix it up again
        return v;
    }

    private static int hash(int x, int y, int z, long seed) {
        // TODO: better/faster hash function? This should have pretty good quality visually but may be slow
        int hash;
        hash = RngHash.murmurHashCoords((int) (seed >>> 32), x, y, z);
        hash = RngHash.murmurHashInt(hash, (int) seed);
        return RngHash.murmurHashFinalize(hash);
    }

    private static int hash(int v) {
        return RngHash.murmurHashFinalize(v);
    }

    public static final class CellValue {
        public int cell;
        public double distance;
        public double distanceFromEdge;
        public double cellX, cellY, cellZ;
    }

}
