package com.PlanetCore.blockentity;

import com.PlanetCore.blocks.DefaultGeneratorStats;

/**
 * this class is needed because it's not possible to register a single blockentity class to multiple blocks
 */
public class LavagenStubs {

    public static class Iron extends LavaGeneratorBlockEntity {
        public Iron() {
            super(DefaultGeneratorStats.IRON);
        }
    }
    public static class Diamond extends LavaGeneratorBlockEntity {
        public Diamond() {
            super(DefaultGeneratorStats.DIAMOND);
        }
    }
    public static class Titanium extends LavaGeneratorBlockEntity {
        public Titanium() {
            super(DefaultGeneratorStats.titanium);
        }
    }
    public static class Uranium extends LavaGeneratorBlockEntity {
        public Uranium() {
            super(DefaultGeneratorStats.uranium);
        }
    }
    public static class Tungsten extends LavaGeneratorBlockEntity {
        public Tungsten() {
            super(DefaultGeneratorStats.tungsten);
        }
    }
    public static class Ruby extends LavaGeneratorBlockEntity {
        public Ruby() {
            super(DefaultGeneratorStats.ruby);
        }
    }
    public static class Sapphire extends LavaGeneratorBlockEntity {
        public Sapphire() {
            super(DefaultGeneratorStats.sapphire);
        }
    }
    public static class Majorite extends LavaGeneratorBlockEntity {
        public Majorite() {
            super(DefaultGeneratorStats.majorite);
        }
    }
    public static class Amazonite extends LavaGeneratorBlockEntity {
        public Amazonite() {
            super(DefaultGeneratorStats.amazonite);
        }
    }
    public static class Onyx extends LavaGeneratorBlockEntity {
        public Onyx() {
            super(DefaultGeneratorStats.onyx);
        }
    }
}
