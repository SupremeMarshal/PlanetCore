package com.PlanetCore.init;





import com.PlanetCore.blocks.*;

import net.minecraft.block.Block;

import net.minecraft.block.material.Material;

import net.minecraftforge.fml.common.registry.GameRegistry;

import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import net.minecraftforge.registries.IForgeRegistry;



import javax.annotation.Nonnull;

import java.util.ArrayList;

import java.util.List;

import java.util.Locale;

import java.util.function.Function;



@ObjectHolder("planetcore")

public class ModBlocks {


    public enum Ore_size {

        VERYSMALL(0.25, 0.25, id -> new GemBase_verysmall(id, Material.ROCK)),

        SMALL(0.5, 0.5, id -> new GemBase_small(id, Material.ROCK)),

        COMPACT(2, 2.0, id -> new GemBase_compact(id, Material.ROCK)),

        VERYCOMPACT(4.0, 4.0, id -> new GemBase_verycompact(id, Material.ROCK));



        private final double baseHardness;

        private final double baseResistance;

        private final Function<String, Block> makeBlockSize;



        Ore_size(double baseHardness, double baseResistance, Function<String, Block> makeBlockSize) {

            this.baseHardness = baseHardness;

            this.baseResistance = baseResistance;

            this.makeBlockSize = makeBlockSize;

        }

        public Block makeBlock(String registryName) {

            return makeBlockSize.apply(registryName);

        }

        public double getBaseHardness() {

            return baseHardness;

        }



        public double getBaseResistance() {

            return baseResistance;

        }

    }



    public enum OreType {

        GEM

    }



    public enum Ore {

        ONYX(true, OreType.GEM, 900000, 36000.0, 90000.0),

        MAJORITE(true, OreType.GEM, 600000, 12000.0, 60000.0),

        BRIGMANITE(true, OreType.GEM, 500000, 4800.0, 50000.0),

        RINGWOODITE(true, OreType.GEM, 400000, 4800.0, 40000.0),

        AMAZONITE(true, OreType.GEM, 750000, 12000.0, 75000.0),

        DIAMOND(true, OreType.GEM, 500000, 4800.0, 50000.0),

        SAPPHIRE(true, OreType.GEM, 100000, 1600.0, 10000.0),

        WADSLEYITE(true, OreType.GEM, 150000, 4800., 15000.0),

        RUBY(true, OreType.GEM, 100000, 1600.0, 10000.0),

        TUNGSTEN(true, OreType.GEM, 50000, 200.0, 5000.0),

        EMERALD(true, OreType.GEM, 25000, 150.0, 2500.0),

        TITANIUM(true, OreType.GEM, 10000, 100.0, 1000.0),

        URANIUM(true, OreType.GEM, 1200, 40.0, 120.0),

        PLATINUM(true, OreType.GEM, 5000, 60.0, 500.0),

        OLIVINE(true, OreType.GEM, 4000, 2400.0, 400),

        JADE(true, OreType.GEM, 3000, 60.0, 300.0),

        TOPAZ(true, OreType.GEM, 2500, 40.0, 250.0),

        GOLD(true, OreType.GEM, 2000, 27.0, 200.0),

        SILVER(true, OreType.GEM, 600, 18.0, 60.0),

        REDSTONE(true, OreType.GEM, 10, 18.0, 1.0),

        LAPIS(true, OreType.GEM, 10, 12.0, 1.0),

        SULFUR(true, OreType.GEM, 10, 10.0, 1.0),

        TIN(true, OreType.GEM, 100, 5.0, 1.0),

        COPPER(true, OreType.GEM, 100, 5.0, 1.0),

        IRON(true, OreType.GEM, 300, 5.0, 1.5),

        LEAD(true, OreType.GEM, 10, 10.0, 1.0),

        ALUMINIUM(true, OreType.GEM, 10, 10.0, 1.0),

        SILICON(true, OreType.GEM, 10, 10.0, 1.0),

        COAL(true, OreType.GEM, 0, 1.5, 0.0);





        private final boolean makeOreAndBlock;

        private final OreType type;

        private final double blockResistance;

        private final double oreHardness;

        private final double oreResistance;



        Ore(boolean makeOreAndBlock, OreType type, double blockResistance, double oreHardness, double oreResistance) {

            this.makeOreAndBlock = makeOreAndBlock;

            this.type = type;

            this.blockResistance = blockResistance;

            this.oreHardness = oreHardness;

            this.oreResistance = oreResistance;

        }



        public OreType getType() {

            return this.type;

        }



        public double getBlockResistance() {

            return blockResistance;

        }



        public boolean makeOreAndBlock() {

            return makeOreAndBlock;

        }



        public double getOreHardness() {

            return oreHardness;

        }



        public double getOreResistance() {

            return oreResistance;

        }

    }


    public enum OreForm {

        ORE(1.0, 1.0, id -> new GemBase(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        HARDROCK(3.6F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        DEEPROCK(6.5F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        CRUSTROCK(10.7F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        MANTLEROCK(16.4F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        MANTLEROCK1(24.5F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        MANTLEROCK2(35.8F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        MANTLEROCK3(51.6F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        MANTLEROCK4(73.7F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        MANTLEROCK5(104.7F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        MANTLEROCK6(148.1F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        MANTLEROCK7(208.9F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        MANTLEROCK8(293.9F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        LOWER_MANTLEROCK(413.0F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        LOWER_MANTLEROCK1(579.6F, 1.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        LOWER_MANTLEROCK2(813.0F, 2.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        LOWER_MANTLEROCK3(1139.7F, 3.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        LOWER_MANTLEROCK4(1597.0F, 4.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        LOWER_MANTLEROCK5(2237.4F, 5.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        LOWER_MANTLEROCK6(3133.8F, 6.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        LOWER_MANTLEROCK7(4388.8F, 7.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        LOWER_MANTLEROCK8(6145.9F, 8.0, id -> new Mantlerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        CORESTONE(12291.7F, 12.0, id -> new Corerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        INNERCORESTONE(17209.9F, 15.0, id -> new Corerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK)),

        CENTERCORESTONE(24095.4F, 20.0, id -> new Corerock(id, Material.ROCK), id -> new GemBase(id, Material.ROCK));



        private final double baseHardness;

        private final double baseResistance;

        private final Function<String, Block> makeBlockGem;





        OreForm(double baseHardness, double baseResistance, Function<String, Block> makeBlockGem, Function<String, Block> makeBlockRock) {

            this.baseHardness = baseHardness;

            this.baseResistance = baseResistance;

            this.makeBlockGem = makeBlockGem;
        }


        public Block makeBlock(String registryName) {

            return makeBlockGem.apply(registryName);

        }



        public double getBaseHardness() {

            return baseHardness;

        }



        public double getBaseResistance() {

            return baseResistance;

        }

    }





    public static List<Block> BLOCKS = new ArrayList<Block>(); // being final breaks ObjectHolder, either move to separate class or keep non-final



    /**

     * The way ObjectHolder works with forge is that it reflectively sets public static final fields.

     * Because creating instances in static initializers is discouraged, they have to be initialized to null.

     *

     * This method returns null, but forces IDE static analysis to see it as a non-null value which those fields will be at runtime.

     *

     * This removes a lot of useless warnings because those fields *may* be null.

     */

    @SuppressWarnings("ConstantConditions")

    @Nonnull

    private static <T> T _null() {

        return null;

    }

    @ObjectHolder("sulfuric_acid")
    public static final Block SULFURIC_ACID_FLUID = _null();
    @ObjectHolder("hot_lava")
    public static final Block HOT_LAVA_FLUID = _null();
    @ObjectHolder("core_lava")
    public static final Block CORE_LAVA_FLUID = _null();
    @ObjectHolder("onyx_lava")
    public static final Block ONYX_LAVA_FLUID = _null();


    // GENERATED BEGIN

    public static final BlocksBase ONYX_BLOCK = _null();
    public static final BlocksBase MAJORITE_BLOCK = _null();
    public static final BlocksBase BRIGMANITE_BLOCK = _null();
    public static final BlocksBase RINGWOODITE_BLOCK = _null();
    public static final BlocksBase AMAZONITE_BLOCK = _null();
    public static final BlocksBase DIAMOND_BLOCK = _null();
    public static final BlocksBase SAPPHIRE_BLOCK = _null();
    public static final BlocksBase RUBY_BLOCK = _null();
    public static final BlocksBase PLATINUM_BLOCK = _null();
    public static final BlocksBase JADE_BLOCK = _null();
    public static final BlocksBase TOPAZ_BLOCK = _null();
    public static final BlocksBase GOLD_BLOCK = _null();
    public static final BlocksBase SILVER_BLOCK = _null();
    public static final BlocksBase IRON_BLOCK = _null();

    public static final GemBase ORE_ONYX = _null();
    public static final GemBase_verysmall ORE_ONYX_VERYSMALL = _null();
    public static final GemBase_small ORE_ONYX_SMALL = _null();
    public static final GemBase_compact ORE_ONYX_COMPACT = _null();
    public static final GemBase_verycompact ORE_ONYX_VERYCOMPACT = _null();
    public static final GemBase ORE_MAJORITE = _null();
    public static final GemBase_verysmall ORE_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small ORE_MAJORITE_SMALL = _null();
    public static final GemBase_compact ORE_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact ORE_MAJORITE_VERYCOMPACT = _null();
    public static final GemBase ORE_BRIGMANITE = _null();
    public static final GemBase_verysmall ORE_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small ORE_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact ORE_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact ORE_BRIGMANITE_VERYCOMPACT = _null();
    public static final GemBase ORE_RINGWOODITE = _null();
    public static final GemBase_verysmall ORE_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small ORE_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact ORE_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact ORE_RINGWOODITE_VERYCOMPACT = _null();
    public static final GemBase ORE_AMAZONITE = _null();
    public static final GemBase_verysmall ORE_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small ORE_AMAZONITE_SMALL = _null();
    public static final GemBase_compact ORE_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact ORE_AMAZONITE_VERYCOMPACT = _null();
    public static final GemBase ORE_DIAMOND = _null();
    public static final GemBase_verysmall ORE_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small ORE_DIAMOND_SMALL = _null();
    public static final GemBase_compact ORE_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact ORE_DIAMOND_VERYCOMPACT = _null();
    public static final GemBase ORE_SAPPHIRE = _null();
    public static final GemBase_verysmall ORE_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small ORE_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact ORE_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact ORE_SAPPHIRE_VERYCOMPACT = _null();
    public static final GemBase ORE_WADSLEYITE = _null();
    public static final GemBase_verysmall ORE_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small ORE_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact ORE_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact ORE_WADSLEYITE_VERYCOMPACT = _null();
    public static final GemBase ORE_RUBY = _null();
    public static final GemBase_verysmall ORE_RUBY_VERYSMALL = _null();
    public static final GemBase_small ORE_RUBY_SMALL = _null();
    public static final GemBase_compact ORE_RUBY_COMPACT = _null();
    public static final GemBase_verycompact ORE_RUBY_VERYCOMPACT = _null();
    public static final GemBase ORE_TUNGSTEN = _null();
    public static final GemBase_verysmall ORE_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small ORE_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact ORE_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact ORE_TUNGSTEN_VERYCOMPACT = _null();
    public static final GemBase ORE_EMERALD = _null();
    public static final GemBase_verysmall ORE_EMERALD_VERYSMALL = _null();
    public static final GemBase_small ORE_EMERALD_SMALL = _null();
    public static final GemBase_compact ORE_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact ORE_EMERALD_VERYCOMPACT = _null();
    public static final GemBase ORE_TITANIUM = _null();
    public static final GemBase_verysmall ORE_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small ORE_TITANIUM_SMALL = _null();
    public static final GemBase_compact ORE_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact ORE_TITANIUM_VERYCOMPACT = _null();
    public static final GemBase ORE_URANIUM = _null();
    public static final GemBase_verysmall ORE_URANIUM_VERYSMALL = _null();
    public static final GemBase_small ORE_URANIUM_SMALL = _null();
    public static final GemBase_compact ORE_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact ORE_URANIUM_VERYCOMPACT = _null();
    public static final GemBase ORE_PLATINUM = _null();
    public static final GemBase_verysmall ORE_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small ORE_PLATINUM_SMALL = _null();
    public static final GemBase_compact ORE_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact ORE_PLATINUM_VERYCOMPACT = _null();
    public static final GemBase ORE_OLIVINE = _null();
    public static final GemBase_verysmall ORE_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small ORE_OLIVINE_SMALL = _null();
    public static final GemBase_compact ORE_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact ORE_OLIVINE_VERYCOMPACT = _null();
    public static final GemBase ORE_JADE = _null();
    public static final GemBase_verysmall ORE_JADE_VERYSMALL = _null();
    public static final GemBase_small ORE_JADE_SMALL = _null();
    public static final GemBase_compact ORE_JADE_COMPACT = _null();
    public static final GemBase_verycompact ORE_JADE_VERYCOMPACT = _null();
    public static final GemBase ORE_TOPAZ = _null();
    public static final GemBase_verysmall ORE_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small ORE_TOPAZ_SMALL = _null();
    public static final GemBase_compact ORE_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact ORE_TOPAZ_VERYCOMPACT = _null();
    public static final GemBase ORE_GOLD = _null();
    public static final GemBase_verysmall ORE_GOLD_VERYSMALL = _null();
    public static final GemBase_small ORE_GOLD_SMALL = _null();
    public static final GemBase_compact ORE_GOLD_COMPACT = _null();
    public static final GemBase_verycompact ORE_GOLD_VERYCOMPACT = _null();
    public static final GemBase ORE_SILVER = _null();
    public static final GemBase_verysmall ORE_SILVER_VERYSMALL = _null();
    public static final GemBase_small ORE_SILVER_SMALL = _null();
    public static final GemBase_compact ORE_SILVER_COMPACT = _null();
    public static final GemBase_verycompact ORE_SILVER_VERYCOMPACT = _null();
    public static final GemBase ORE_REDSTONE = _null();
    public static final GemBase_verysmall ORE_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small ORE_REDSTONE_SMALL = _null();
    public static final GemBase_compact ORE_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact ORE_REDSTONE_VERYCOMPACT = _null();
    public static final GemBase ORE_LAPIS = _null();
    public static final GemBase_verysmall ORE_LAPIS_VERYSMALL = _null();
    public static final GemBase_small ORE_LAPIS_SMALL = _null();
    public static final GemBase_compact ORE_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact ORE_LAPIS_VERYCOMPACT = _null();
    public static final GemBase ORE_SULFUR = _null();
    public static final GemBase_verysmall ORE_SULFUR_VERYSMALL = _null();
    public static final GemBase_small ORE_SULFUR_SMALL = _null();
    public static final GemBase_compact ORE_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact ORE_SULFUR_VERYCOMPACT = _null();
    public static final GemBase ORE_TIN = _null();
    public static final GemBase_verysmall ORE_TIN_VERYSMALL = _null();
    public static final GemBase_small ORE_TIN_SMALL = _null();
    public static final GemBase_compact ORE_TIN_COMPACT = _null();
    public static final GemBase_verycompact ORE_TIN_VERYCOMPACT = _null();
    public static final GemBase ORE_COPPER = _null();
    public static final GemBase_verysmall ORE_COPPER_VERYSMALL = _null();
    public static final GemBase_small ORE_COPPER_SMALL = _null();
    public static final GemBase_compact ORE_COPPER_COMPACT = _null();
    public static final GemBase_verycompact ORE_COPPER_VERYCOMPACT = _null();
    public static final GemBase ORE_IRON = _null();
    public static final GemBase_verysmall ORE_IRON_VERYSMALL = _null();
    public static final GemBase_small ORE_IRON_SMALL = _null();
    public static final GemBase_compact ORE_IRON_COMPACT = _null();
    public static final GemBase_verycompact ORE_IRON_VERYCOMPACT = _null();
    public static final GemBase ORE_LEAD = _null();
    public static final GemBase_verysmall ORE_LEAD_VERYSMALL = _null();
    public static final GemBase_small ORE_LEAD_SMALL = _null();
    public static final GemBase_compact ORE_LEAD_COMPACT = _null();
    public static final GemBase_verycompact ORE_LEAD_VERYCOMPACT = _null();
    public static final GemBase ORE_ALUMINIUM = _null();
    public static final GemBase_verysmall ORE_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small ORE_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact ORE_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact ORE_ALUMINIUM_VERYCOMPACT = _null();
    public static final GemBase ORE_SILICON = _null();
    public static final GemBase_verysmall ORE_SILICON_VERYSMALL = _null();
    public static final GemBase_small ORE_SILICON_SMALL = _null();
    public static final GemBase_compact ORE_SILICON_COMPACT = _null();
    public static final GemBase_verycompact ORE_SILICON_VERYCOMPACT = _null();
    public static final GemBase ORE_COAL = _null();
    public static final GemBase_verysmall ORE_COAL_VERYSMALL = _null();
    public static final GemBase_small ORE_COAL_SMALL = _null();
    public static final GemBase_compact ORE_COAL_COMPACT = _null();
    public static final GemBase_verycompact ORE_COAL_VERYCOMPACT = _null();

    public static final Mantlerock HARDROCK1_ONYX = _null();
    public static final GemBase_verysmall HARDROCK1_ONYX_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_ONYX_SMALL = _null();
    public static final GemBase_compact HARDROCK1_ONYX_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_MAJORITE = _null();
    public static final GemBase_verysmall HARDROCK1_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_MAJORITE_SMALL = _null();
    public static final GemBase_compact HARDROCK1_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_BRIGMANITE = _null();
    public static final GemBase_verysmall HARDROCK1_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact HARDROCK1_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_RINGWOODITE = _null();
    public static final GemBase_verysmall HARDROCK1_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact HARDROCK1_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_AMAZONITE = _null();
    public static final GemBase_verysmall HARDROCK1_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_AMAZONITE_SMALL = _null();
    public static final GemBase_compact HARDROCK1_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_DIAMOND = _null();
    public static final GemBase_verysmall HARDROCK1_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_DIAMOND_SMALL = _null();
    public static final GemBase_compact HARDROCK1_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_SAPPHIRE = _null();
    public static final GemBase_verysmall HARDROCK1_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact HARDROCK1_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_WADSLEYITE = _null();
    public static final GemBase_verysmall HARDROCK1_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact HARDROCK1_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_RUBY = _null();
    public static final GemBase_verysmall HARDROCK1_RUBY_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_RUBY_SMALL = _null();
    public static final GemBase_compact HARDROCK1_RUBY_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_TUNGSTEN = _null();
    public static final GemBase_verysmall HARDROCK1_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact HARDROCK1_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_EMERALD = _null();
    public static final GemBase_verysmall HARDROCK1_EMERALD_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_EMERALD_SMALL = _null();
    public static final GemBase_compact HARDROCK1_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_TITANIUM = _null();
    public static final GemBase_verysmall HARDROCK1_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_TITANIUM_SMALL = _null();
    public static final GemBase_compact HARDROCK1_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_URANIUM = _null();
    public static final GemBase_verysmall HARDROCK1_URANIUM_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_URANIUM_SMALL = _null();
    public static final GemBase_compact HARDROCK1_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_PLATINUM = _null();
    public static final GemBase_verysmall HARDROCK1_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_PLATINUM_SMALL = _null();
    public static final GemBase_compact HARDROCK1_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_OLIVINE = _null();
    public static final GemBase_verysmall HARDROCK1_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_OLIVINE_SMALL = _null();
    public static final GemBase_compact HARDROCK1_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_JADE = _null();
    public static final GemBase_verysmall HARDROCK1_JADE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_JADE_SMALL = _null();
    public static final GemBase_compact HARDROCK1_JADE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_JADE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_TOPAZ = _null();
    public static final GemBase_verysmall HARDROCK1_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_TOPAZ_SMALL = _null();
    public static final GemBase_compact HARDROCK1_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_GOLD = _null();
    public static final GemBase_verysmall HARDROCK1_GOLD_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_GOLD_SMALL = _null();
    public static final GemBase_compact HARDROCK1_GOLD_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_SILVER = _null();
    public static final GemBase_verysmall HARDROCK1_SILVER_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_SILVER_SMALL = _null();
    public static final GemBase_compact HARDROCK1_SILVER_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_REDSTONE = _null();
    public static final GemBase_verysmall HARDROCK1_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_REDSTONE_SMALL = _null();
    public static final GemBase_compact HARDROCK1_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_LAPIS = _null();
    public static final GemBase_verysmall HARDROCK1_LAPIS_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_LAPIS_SMALL = _null();
    public static final GemBase_compact HARDROCK1_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_SULFUR = _null();
    public static final GemBase_verysmall HARDROCK1_SULFUR_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_SULFUR_SMALL = _null();
    public static final GemBase_compact HARDROCK1_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_TIN = _null();
    public static final GemBase_verysmall HARDROCK1_TIN_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_TIN_SMALL = _null();
    public static final GemBase_compact HARDROCK1_TIN_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_TIN_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_COPPER = _null();
    public static final GemBase_verysmall HARDROCK1_COPPER_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_COPPER_SMALL = _null();
    public static final GemBase_compact HARDROCK1_COPPER_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_IRON = _null();
    public static final GemBase_verysmall HARDROCK1_IRON_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_IRON_SMALL = _null();
    public static final GemBase_compact HARDROCK1_IRON_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_IRON_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_LEAD = _null();
    public static final GemBase_verysmall HARDROCK1_LEAD_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_LEAD_SMALL = _null();
    public static final GemBase_compact HARDROCK1_LEAD_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_ALUMINIUM = _null();
    public static final GemBase_verysmall HARDROCK1_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact HARDROCK1_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_SILICON = _null();
    public static final GemBase_verysmall HARDROCK1_SILICON_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_SILICON_SMALL = _null();
    public static final GemBase_compact HARDROCK1_SILICON_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK1_COAL = _null();
    public static final GemBase_verysmall HARDROCK1_COAL_VERYSMALL = _null();
    public static final GemBase_small HARDROCK1_COAL_SMALL = _null();
    public static final GemBase_compact HARDROCK1_COAL_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK1_COAL_VERYCOMPACT = _null();

    public static final Mantlerock DEEPROCK_ONYX = _null();
    public static final GemBase_verysmall DEEPROCK_ONYX_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_ONYX_SMALL = _null();
    public static final GemBase_compact DEEPROCK_ONYX_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_MAJORITE = _null();
    public static final GemBase_verysmall DEEPROCK_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_MAJORITE_SMALL = _null();
    public static final GemBase_compact DEEPROCK_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_BRIGMANITE = _null();
    public static final GemBase_verysmall DEEPROCK_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact DEEPROCK_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_RINGWOODITE = _null();
    public static final GemBase_verysmall DEEPROCK_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact DEEPROCK_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_AMAZONITE = _null();
    public static final GemBase_verysmall DEEPROCK_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_AMAZONITE_SMALL = _null();
    public static final GemBase_compact DEEPROCK_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_DIAMOND = _null();
    public static final GemBase_verysmall DEEPROCK_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_DIAMOND_SMALL = _null();
    public static final GemBase_compact DEEPROCK_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_SAPPHIRE = _null();
    public static final GemBase_verysmall DEEPROCK_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact DEEPROCK_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_WADSLEYITE = _null();
    public static final GemBase_verysmall DEEPROCK_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact DEEPROCK_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_RUBY = _null();
    public static final GemBase_verysmall DEEPROCK_RUBY_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_RUBY_SMALL = _null();
    public static final GemBase_compact DEEPROCK_RUBY_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_TUNGSTEN = _null();
    public static final GemBase_verysmall DEEPROCK_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact DEEPROCK_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_EMERALD = _null();
    public static final GemBase_verysmall DEEPROCK_EMERALD_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_EMERALD_SMALL = _null();
    public static final GemBase_compact DEEPROCK_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_TITANIUM = _null();
    public static final GemBase_verysmall DEEPROCK_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_TITANIUM_SMALL = _null();
    public static final GemBase_compact DEEPROCK_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_URANIUM = _null();
    public static final GemBase_verysmall DEEPROCK_URANIUM_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_URANIUM_SMALL = _null();
    public static final GemBase_compact DEEPROCK_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_PLATINUM = _null();
    public static final GemBase_verysmall DEEPROCK_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_PLATINUM_SMALL = _null();
    public static final GemBase_compact DEEPROCK_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_OLIVINE = _null();
    public static final GemBase_verysmall DEEPROCK_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_OLIVINE_SMALL = _null();
    public static final GemBase_compact DEEPROCK_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_JADE = _null();
    public static final GemBase_verysmall DEEPROCK_JADE_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_JADE_SMALL = _null();
    public static final GemBase_compact DEEPROCK_JADE_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_JADE_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_TOPAZ = _null();
    public static final GemBase_verysmall DEEPROCK_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_TOPAZ_SMALL = _null();
    public static final GemBase_compact DEEPROCK_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_GOLD = _null();
    public static final GemBase_verysmall DEEPROCK_GOLD_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_GOLD_SMALL = _null();
    public static final GemBase_compact DEEPROCK_GOLD_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_SILVER = _null();
    public static final GemBase_verysmall DEEPROCK_SILVER_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_SILVER_SMALL = _null();
    public static final GemBase_compact DEEPROCK_SILVER_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_REDSTONE = _null();
    public static final GemBase_verysmall DEEPROCK_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_REDSTONE_SMALL = _null();
    public static final GemBase_compact DEEPROCK_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_LAPIS = _null();
    public static final GemBase_verysmall DEEPROCK_LAPIS_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_LAPIS_SMALL = _null();
    public static final GemBase_compact DEEPROCK_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_SULFUR = _null();
    public static final GemBase_verysmall DEEPROCK_SULFUR_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_SULFUR_SMALL = _null();
    public static final GemBase_compact DEEPROCK_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_TIN = _null();
    public static final GemBase_verysmall DEEPROCK_TIN_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_TIN_SMALL = _null();
    public static final GemBase_compact DEEPROCK_TIN_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_TIN_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_COPPER = _null();
    public static final GemBase_verysmall DEEPROCK_COPPER_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_COPPER_SMALL = _null();
    public static final GemBase_compact DEEPROCK_COPPER_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_IRON = _null();
    public static final GemBase_verysmall DEEPROCK_IRON_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_IRON_SMALL = _null();
    public static final GemBase_compact DEEPROCK_IRON_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_IRON_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_LEAD = _null();
    public static final GemBase_verysmall DEEPROCK_LEAD_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_LEAD_SMALL = _null();
    public static final GemBase_compact DEEPROCK_LEAD_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_ALUMINIUM = _null();
    public static final GemBase_verysmall DEEPROCK_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact DEEPROCK_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_SILICON = _null();
    public static final GemBase_verysmall DEEPROCK_SILICON_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_SILICON_SMALL = _null();
    public static final GemBase_compact DEEPROCK_SILICON_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock DEEPROCK_COAL = _null();
    public static final GemBase_verysmall DEEPROCK_COAL_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_COAL_SMALL = _null();
    public static final GemBase_compact DEEPROCK_COAL_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_COAL_VERYCOMPACT = _null();

    public static final Mantlerock CRUSTROCK_ONYX = _null();
    public static final GemBase_verysmall CRUSTROCK_ONYX_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_ONYX_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_ONYX_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_MAJORITE = _null();
    public static final GemBase_verysmall CRUSTROCK_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_MAJORITE_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_BRIGMANITE = _null();
    public static final GemBase_verysmall CRUSTROCK_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_RINGWOODITE = _null();
    public static final GemBase_verysmall CRUSTROCK_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_AMAZONITE = _null();
    public static final GemBase_verysmall CRUSTROCK_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_AMAZONITE_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_DIAMOND = _null();
    public static final GemBase_verysmall CRUSTROCK_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_DIAMOND_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_SAPPHIRE = _null();
    public static final GemBase_verysmall CRUSTROCK_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_WADSLEYITE = _null();
    public static final GemBase_verysmall CRUSTROCK_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_RUBY = _null();
    public static final GemBase_verysmall CRUSTROCK_RUBY_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_RUBY_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_RUBY_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_TUNGSTEN = _null();
    public static final GemBase_verysmall CRUSTROCK_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_EMERALD = _null();
    public static final GemBase_verysmall CRUSTROCK_EMERALD_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_EMERALD_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_TITANIUM = _null();
    public static final GemBase_verysmall CRUSTROCK_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_TITANIUM_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_URANIUM = _null();
    public static final GemBase_verysmall CRUSTROCK_URANIUM_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_URANIUM_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_PLATINUM = _null();
    public static final GemBase_verysmall CRUSTROCK_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_PLATINUM_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_OLIVINE = _null();
    public static final GemBase_verysmall CRUSTROCK_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_OLIVINE_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_JADE = _null();
    public static final GemBase_verysmall CRUSTROCK_JADE_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_JADE_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_JADE_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_JADE_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_TOPAZ = _null();
    public static final GemBase_verysmall CRUSTROCK_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_TOPAZ_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_GOLD = _null();
    public static final GemBase_verysmall CRUSTROCK_GOLD_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_GOLD_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_GOLD_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_SILVER = _null();
    public static final GemBase_verysmall CRUSTROCK_SILVER_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_SILVER_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_SILVER_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_REDSTONE = _null();
    public static final GemBase_verysmall CRUSTROCK_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_REDSTONE_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_LAPIS = _null();
    public static final GemBase_verysmall CRUSTROCK_LAPIS_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_LAPIS_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_SULFUR = _null();
    public static final GemBase_verysmall CRUSTROCK_SULFUR_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_SULFUR_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_TIN = _null();
    public static final GemBase_verysmall CRUSTROCK_TIN_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_TIN_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_TIN_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_TIN_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_COPPER = _null();
    public static final GemBase_verysmall CRUSTROCK_COPPER_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_COPPER_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_COPPER_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_IRON = _null();
    public static final GemBase_verysmall CRUSTROCK_IRON_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_IRON_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_IRON_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_IRON_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_LEAD = _null();
    public static final GemBase_verysmall CRUSTROCK_LEAD_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_LEAD_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_LEAD_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_ALUMINIUM = _null();
    public static final GemBase_verysmall CRUSTROCK_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_SILICON = _null();
    public static final GemBase_verysmall CRUSTROCK_SILICON_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_SILICON_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_SILICON_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock CRUSTROCK_COAL = _null();
    public static final GemBase_verysmall CRUSTROCK_COAL_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_COAL_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_COAL_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_COAL_VERYCOMPACT = _null();

    public static final Mantlerock MANTLEROCK_ONYX = _null();
    public static final GemBase_verysmall MANTLEROCK_ONYX_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_ONYX_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_ONYX_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_MAJORITE = _null();
    public static final GemBase_verysmall MANTLEROCK_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_MAJORITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_BRIGMANITE = _null();
    public static final GemBase_verysmall MANTLEROCK_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_RINGWOODITE = _null();
    public static final GemBase_verysmall MANTLEROCK_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_AMAZONITE = _null();
    public static final GemBase_verysmall MANTLEROCK_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_AMAZONITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_DIAMOND = _null();
    public static final GemBase_verysmall MANTLEROCK_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_DIAMOND_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_SAPPHIRE = _null();
    public static final GemBase_verysmall MANTLEROCK_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_WADSLEYITE = _null();
    public static final GemBase_verysmall MANTLEROCK_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_RUBY = _null();
    public static final GemBase_verysmall MANTLEROCK_RUBY_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_RUBY_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_RUBY_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_TUNGSTEN = _null();
    public static final GemBase_verysmall MANTLEROCK_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_EMERALD = _null();
    public static final GemBase_verysmall MANTLEROCK_EMERALD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_EMERALD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_TITANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_TITANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_URANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK_URANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_URANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_PLATINUM = _null();
    public static final GemBase_verysmall MANTLEROCK_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_PLATINUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_OLIVINE = _null();
    public static final GemBase_verysmall MANTLEROCK_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_OLIVINE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_JADE = _null();
    public static final GemBase_verysmall MANTLEROCK_JADE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_JADE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_JADE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_JADE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_TOPAZ = _null();
    public static final GemBase_verysmall MANTLEROCK_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_TOPAZ_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_GOLD = _null();
    public static final GemBase_verysmall MANTLEROCK_GOLD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_GOLD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_GOLD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_SILVER = _null();
    public static final GemBase_verysmall MANTLEROCK_SILVER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_SILVER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_SILVER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_REDSTONE = _null();
    public static final GemBase_verysmall MANTLEROCK_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_REDSTONE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_LAPIS = _null();
    public static final GemBase_verysmall MANTLEROCK_LAPIS_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_LAPIS_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_SULFUR = _null();
    public static final GemBase_verysmall MANTLEROCK_SULFUR_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_SULFUR_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_TIN = _null();
    public static final GemBase_verysmall MANTLEROCK_TIN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_TIN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_TIN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_TIN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_COPPER = _null();
    public static final GemBase_verysmall MANTLEROCK_COPPER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_COPPER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_COPPER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_IRON = _null();
    public static final GemBase_verysmall MANTLEROCK_IRON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_IRON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_IRON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_IRON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_LEAD = _null();
    public static final GemBase_verysmall MANTLEROCK_LEAD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_LEAD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_LEAD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_ALUMINIUM = _null();
    public static final GemBase_verysmall MANTLEROCK_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_SILICON = _null();
    public static final GemBase_verysmall MANTLEROCK_SILICON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_SILICON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_SILICON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK_COAL = _null();
    public static final GemBase_verysmall MANTLEROCK_COAL_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_COAL_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_COAL_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_COAL_VERYCOMPACT = _null();

    public static final Mantlerock MANTLEROCK1_ONYX = _null();
    public static final GemBase_verysmall MANTLEROCK1_ONYX_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_ONYX_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_ONYX_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_MAJORITE = _null();
    public static final GemBase_verysmall MANTLEROCK1_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_MAJORITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_BRIGMANITE = _null();
    public static final GemBase_verysmall MANTLEROCK1_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_RINGWOODITE = _null();
    public static final GemBase_verysmall MANTLEROCK1_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_AMAZONITE = _null();
    public static final GemBase_verysmall MANTLEROCK1_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_AMAZONITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_DIAMOND = _null();
    public static final GemBase_verysmall MANTLEROCK1_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_DIAMOND_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_SAPPHIRE = _null();
    public static final GemBase_verysmall MANTLEROCK1_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_WADSLEYITE = _null();
    public static final GemBase_verysmall MANTLEROCK1_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_RUBY = _null();
    public static final GemBase_verysmall MANTLEROCK1_RUBY_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_RUBY_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_RUBY_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_TUNGSTEN = _null();
    public static final GemBase_verysmall MANTLEROCK1_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_EMERALD = _null();
    public static final GemBase_verysmall MANTLEROCK1_EMERALD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_EMERALD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_TITANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK1_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_TITANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_URANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK1_URANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_URANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_PLATINUM = _null();
    public static final GemBase_verysmall MANTLEROCK1_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_PLATINUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_OLIVINE = _null();
    public static final GemBase_verysmall MANTLEROCK1_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_OLIVINE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_JADE = _null();
    public static final GemBase_verysmall MANTLEROCK1_JADE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_JADE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_JADE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_JADE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_TOPAZ = _null();
    public static final GemBase_verysmall MANTLEROCK1_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_TOPAZ_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_GOLD = _null();
    public static final GemBase_verysmall MANTLEROCK1_GOLD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_GOLD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_GOLD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_SILVER = _null();
    public static final GemBase_verysmall MANTLEROCK1_SILVER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_SILVER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_SILVER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_REDSTONE = _null();
    public static final GemBase_verysmall MANTLEROCK1_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_REDSTONE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_LAPIS = _null();
    public static final GemBase_verysmall MANTLEROCK1_LAPIS_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_LAPIS_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_SULFUR = _null();
    public static final GemBase_verysmall MANTLEROCK1_SULFUR_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_SULFUR_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_TIN = _null();
    public static final GemBase_verysmall MANTLEROCK1_TIN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_TIN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_TIN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_TIN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_COPPER = _null();
    public static final GemBase_verysmall MANTLEROCK1_COPPER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_COPPER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_COPPER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_IRON = _null();
    public static final GemBase_verysmall MANTLEROCK1_IRON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_IRON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_IRON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_IRON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_LEAD = _null();
    public static final GemBase_verysmall MANTLEROCK1_LEAD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_LEAD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_LEAD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_ALUMINIUM = _null();
    public static final GemBase_verysmall MANTLEROCK1_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_SILICON = _null();
    public static final GemBase_verysmall MANTLEROCK1_SILICON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_SILICON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_SILICON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK1_COAL = _null();
    public static final GemBase_verysmall MANTLEROCK1_COAL_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK1_COAL_SMALL = _null();
    public static final GemBase_compact MANTLEROCK1_COAL_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK1_COAL_VERYCOMPACT = _null();

    public static final Mantlerock MANTLEROCK2_ONYX = _null();
    public static final GemBase_verysmall MANTLEROCK2_ONYX_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_ONYX_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_ONYX_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_MAJORITE = _null();
    public static final GemBase_verysmall MANTLEROCK2_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_MAJORITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_BRIGMANITE = _null();
    public static final GemBase_verysmall MANTLEROCK2_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_RINGWOODITE = _null();
    public static final GemBase_verysmall MANTLEROCK2_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_AMAZONITE = _null();
    public static final GemBase_verysmall MANTLEROCK2_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_AMAZONITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_DIAMOND = _null();
    public static final GemBase_verysmall MANTLEROCK2_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_DIAMOND_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_SAPPHIRE = _null();
    public static final GemBase_verysmall MANTLEROCK2_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_WADSLEYITE = _null();
    public static final GemBase_verysmall MANTLEROCK2_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_RUBY = _null();
    public static final GemBase_verysmall MANTLEROCK2_RUBY_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_RUBY_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_RUBY_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_TUNGSTEN = _null();
    public static final GemBase_verysmall MANTLEROCK2_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_EMERALD = _null();
    public static final GemBase_verysmall MANTLEROCK2_EMERALD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_EMERALD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_TITANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK2_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_TITANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_URANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK2_URANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_URANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_PLATINUM = _null();
    public static final GemBase_verysmall MANTLEROCK2_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_PLATINUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_OLIVINE = _null();
    public static final GemBase_verysmall MANTLEROCK2_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_OLIVINE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_JADE = _null();
    public static final GemBase_verysmall MANTLEROCK2_JADE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_JADE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_JADE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_JADE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_TOPAZ = _null();
    public static final GemBase_verysmall MANTLEROCK2_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_TOPAZ_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_GOLD = _null();
    public static final GemBase_verysmall MANTLEROCK2_GOLD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_GOLD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_GOLD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_SILVER = _null();
    public static final GemBase_verysmall MANTLEROCK2_SILVER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_SILVER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_SILVER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_REDSTONE = _null();
    public static final GemBase_verysmall MANTLEROCK2_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_REDSTONE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_LAPIS = _null();
    public static final GemBase_verysmall MANTLEROCK2_LAPIS_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_LAPIS_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_SULFUR = _null();
    public static final GemBase_verysmall MANTLEROCK2_SULFUR_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_SULFUR_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_TIN = _null();
    public static final GemBase_verysmall MANTLEROCK2_TIN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_TIN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_TIN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_TIN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_COPPER = _null();
    public static final GemBase_verysmall MANTLEROCK2_COPPER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_COPPER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_COPPER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_IRON = _null();
    public static final GemBase_verysmall MANTLEROCK2_IRON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_IRON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_IRON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_IRON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_LEAD = _null();
    public static final GemBase_verysmall MANTLEROCK2_LEAD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_LEAD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_LEAD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_ALUMINIUM = _null();
    public static final GemBase_verysmall MANTLEROCK2_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_SILICON = _null();
    public static final GemBase_verysmall MANTLEROCK2_SILICON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_SILICON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_SILICON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK2_COAL = _null();
    public static final GemBase_verysmall MANTLEROCK2_COAL_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK2_COAL_SMALL = _null();
    public static final GemBase_compact MANTLEROCK2_COAL_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK2_COAL_VERYCOMPACT = _null();

    public static final Mantlerock MANTLEROCK3_ONYX = _null();
    public static final GemBase_verysmall MANTLEROCK3_ONYX_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_ONYX_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_ONYX_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_MAJORITE = _null();
    public static final GemBase_verysmall MANTLEROCK3_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_MAJORITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_BRIGMANITE = _null();
    public static final GemBase_verysmall MANTLEROCK3_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_RINGWOODITE = _null();
    public static final GemBase_verysmall MANTLEROCK3_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_AMAZONITE = _null();
    public static final GemBase_verysmall MANTLEROCK3_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_AMAZONITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_DIAMOND = _null();
    public static final GemBase_verysmall MANTLEROCK3_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_DIAMOND_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_SAPPHIRE = _null();
    public static final GemBase_verysmall MANTLEROCK3_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_WADSLEYITE = _null();
    public static final GemBase_verysmall MANTLEROCK3_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_RUBY = _null();
    public static final GemBase_verysmall MANTLEROCK3_RUBY_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_RUBY_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_RUBY_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_TUNGSTEN = _null();
    public static final GemBase_verysmall MANTLEROCK3_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_EMERALD = _null();
    public static final GemBase_verysmall MANTLEROCK3_EMERALD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_EMERALD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_TITANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK3_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_TITANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_URANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK3_URANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_URANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_PLATINUM = _null();
    public static final GemBase_verysmall MANTLEROCK3_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_PLATINUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_OLIVINE = _null();
    public static final GemBase_verysmall MANTLEROCK3_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_OLIVINE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_JADE = _null();
    public static final GemBase_verysmall MANTLEROCK3_JADE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_JADE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_JADE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_JADE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_TOPAZ = _null();
    public static final GemBase_verysmall MANTLEROCK3_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_TOPAZ_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_GOLD = _null();
    public static final GemBase_verysmall MANTLEROCK3_GOLD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_GOLD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_GOLD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_SILVER = _null();
    public static final GemBase_verysmall MANTLEROCK3_SILVER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_SILVER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_SILVER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_REDSTONE = _null();
    public static final GemBase_verysmall MANTLEROCK3_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_REDSTONE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_LAPIS = _null();
    public static final GemBase_verysmall MANTLEROCK3_LAPIS_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_LAPIS_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_SULFUR = _null();
    public static final GemBase_verysmall MANTLEROCK3_SULFUR_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_SULFUR_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_TIN = _null();
    public static final GemBase_verysmall MANTLEROCK3_TIN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_TIN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_TIN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_TIN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_COPPER = _null();
    public static final GemBase_verysmall MANTLEROCK3_COPPER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_COPPER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_COPPER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_IRON = _null();
    public static final GemBase_verysmall MANTLEROCK3_IRON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_IRON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_IRON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_IRON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_LEAD = _null();
    public static final GemBase_verysmall MANTLEROCK3_LEAD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_LEAD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_LEAD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_ALUMINIUM = _null();
    public static final GemBase_verysmall MANTLEROCK3_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_SILICON = _null();
    public static final GemBase_verysmall MANTLEROCK3_SILICON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_SILICON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_SILICON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK3_COAL = _null();
    public static final GemBase_verysmall MANTLEROCK3_COAL_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK3_COAL_SMALL = _null();
    public static final GemBase_compact MANTLEROCK3_COAL_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK3_COAL_VERYCOMPACT = _null();

    public static final Mantlerock MANTLEROCK4_ONYX = _null();
    public static final GemBase_verysmall MANTLEROCK4_ONYX_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_ONYX_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_ONYX_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_MAJORITE = _null();
    public static final GemBase_verysmall MANTLEROCK4_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_MAJORITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_BRIGMANITE = _null();
    public static final GemBase_verysmall MANTLEROCK4_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_RINGWOODITE = _null();
    public static final GemBase_verysmall MANTLEROCK4_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_AMAZONITE = _null();
    public static final GemBase_verysmall MANTLEROCK4_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_AMAZONITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_DIAMOND = _null();
    public static final GemBase_verysmall MANTLEROCK4_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_DIAMOND_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_SAPPHIRE = _null();
    public static final GemBase_verysmall MANTLEROCK4_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_WADSLEYITE = _null();
    public static final GemBase_verysmall MANTLEROCK4_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_RUBY = _null();
    public static final GemBase_verysmall MANTLEROCK4_RUBY_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_RUBY_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_RUBY_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_TUNGSTEN = _null();
    public static final GemBase_verysmall MANTLEROCK4_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_EMERALD = _null();
    public static final GemBase_verysmall MANTLEROCK4_EMERALD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_EMERALD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_TITANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK4_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_TITANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_URANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK4_URANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_URANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_PLATINUM = _null();
    public static final GemBase_verysmall MANTLEROCK4_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_PLATINUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_OLIVINE = _null();
    public static final GemBase_verysmall MANTLEROCK4_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_OLIVINE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_JADE = _null();
    public static final GemBase_verysmall MANTLEROCK4_JADE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_JADE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_JADE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_JADE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_TOPAZ = _null();
    public static final GemBase_verysmall MANTLEROCK4_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_TOPAZ_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_GOLD = _null();
    public static final GemBase_verysmall MANTLEROCK4_GOLD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_GOLD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_GOLD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_SILVER = _null();
    public static final GemBase_verysmall MANTLEROCK4_SILVER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_SILVER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_SILVER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_REDSTONE = _null();
    public static final GemBase_verysmall MANTLEROCK4_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_REDSTONE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_LAPIS = _null();
    public static final GemBase_verysmall MANTLEROCK4_LAPIS_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_LAPIS_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_SULFUR = _null();
    public static final GemBase_verysmall MANTLEROCK4_SULFUR_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_SULFUR_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_TIN = _null();
    public static final GemBase_verysmall MANTLEROCK4_TIN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_TIN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_TIN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_TIN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_COPPER = _null();
    public static final GemBase_verysmall MANTLEROCK4_COPPER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_COPPER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_COPPER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_IRON = _null();
    public static final GemBase_verysmall MANTLEROCK4_IRON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_IRON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_IRON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_IRON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_LEAD = _null();
    public static final GemBase_verysmall MANTLEROCK4_LEAD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_LEAD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_LEAD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_ALUMINIUM = _null();
    public static final GemBase_verysmall MANTLEROCK4_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_SILICON = _null();
    public static final GemBase_verysmall MANTLEROCK4_SILICON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_SILICON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_SILICON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK4_COAL = _null();
    public static final GemBase_verysmall MANTLEROCK4_COAL_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK4_COAL_SMALL = _null();
    public static final GemBase_compact MANTLEROCK4_COAL_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK4_COAL_VERYCOMPACT = _null();

    public static final Mantlerock MANTLEROCK5_ONYX = _null();
    public static final GemBase_verysmall MANTLEROCK5_ONYX_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_ONYX_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_ONYX_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_MAJORITE = _null();
    public static final GemBase_verysmall MANTLEROCK5_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_MAJORITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_BRIGMANITE = _null();
    public static final GemBase_verysmall MANTLEROCK5_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_RINGWOODITE = _null();
    public static final GemBase_verysmall MANTLEROCK5_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_AMAZONITE = _null();
    public static final GemBase_verysmall MANTLEROCK5_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_AMAZONITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_DIAMOND = _null();
    public static final GemBase_verysmall MANTLEROCK5_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_DIAMOND_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_SAPPHIRE = _null();
    public static final GemBase_verysmall MANTLEROCK5_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_WADSLEYITE = _null();
    public static final GemBase_verysmall MANTLEROCK5_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_RUBY = _null();
    public static final GemBase_verysmall MANTLEROCK5_RUBY_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_RUBY_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_RUBY_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_TUNGSTEN = _null();
    public static final GemBase_verysmall MANTLEROCK5_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_EMERALD = _null();
    public static final GemBase_verysmall MANTLEROCK5_EMERALD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_EMERALD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_TITANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK5_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_TITANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_URANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK5_URANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_URANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_PLATINUM = _null();
    public static final GemBase_verysmall MANTLEROCK5_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_PLATINUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_OLIVINE = _null();
    public static final GemBase_verysmall MANTLEROCK5_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_OLIVINE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_JADE = _null();
    public static final GemBase_verysmall MANTLEROCK5_JADE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_JADE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_JADE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_JADE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_TOPAZ = _null();
    public static final GemBase_verysmall MANTLEROCK5_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_TOPAZ_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_GOLD = _null();
    public static final GemBase_verysmall MANTLEROCK5_GOLD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_GOLD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_GOLD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_SILVER = _null();
    public static final GemBase_verysmall MANTLEROCK5_SILVER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_SILVER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_SILVER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_REDSTONE = _null();
    public static final GemBase_verysmall MANTLEROCK5_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_REDSTONE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_LAPIS = _null();
    public static final GemBase_verysmall MANTLEROCK5_LAPIS_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_LAPIS_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_SULFUR = _null();
    public static final GemBase_verysmall MANTLEROCK5_SULFUR_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_SULFUR_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_TIN = _null();
    public static final GemBase_verysmall MANTLEROCK5_TIN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_TIN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_TIN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_TIN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_COPPER = _null();
    public static final GemBase_verysmall MANTLEROCK5_COPPER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_COPPER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_COPPER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_IRON = _null();
    public static final GemBase_verysmall MANTLEROCK5_IRON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_IRON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_IRON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_IRON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_LEAD = _null();
    public static final GemBase_verysmall MANTLEROCK5_LEAD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_LEAD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_LEAD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_ALUMINIUM = _null();
    public static final GemBase_verysmall MANTLEROCK5_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_SILICON = _null();
    public static final GemBase_verysmall MANTLEROCK5_SILICON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_SILICON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_SILICON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK5_COAL = _null();
    public static final GemBase_verysmall MANTLEROCK5_COAL_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK5_COAL_SMALL = _null();
    public static final GemBase_compact MANTLEROCK5_COAL_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK5_COAL_VERYCOMPACT = _null();

    public static final Mantlerock MANTLEROCK6_ONYX = _null();
    public static final GemBase_verysmall MANTLEROCK6_ONYX_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_ONYX_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_ONYX_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_MAJORITE = _null();
    public static final GemBase_verysmall MANTLEROCK6_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_MAJORITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_BRIGMANITE = _null();
    public static final GemBase_verysmall MANTLEROCK6_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_RINGWOODITE = _null();
    public static final GemBase_verysmall MANTLEROCK6_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_AMAZONITE = _null();
    public static final GemBase_verysmall MANTLEROCK6_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_AMAZONITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_DIAMOND = _null();
    public static final GemBase_verysmall MANTLEROCK6_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_DIAMOND_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_SAPPHIRE = _null();
    public static final GemBase_verysmall MANTLEROCK6_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_WADSLEYITE = _null();
    public static final GemBase_verysmall MANTLEROCK6_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_RUBY = _null();
    public static final GemBase_verysmall MANTLEROCK6_RUBY_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_RUBY_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_RUBY_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_TUNGSTEN = _null();
    public static final GemBase_verysmall MANTLEROCK6_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_EMERALD = _null();
    public static final GemBase_verysmall MANTLEROCK6_EMERALD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_EMERALD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_TITANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK6_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_TITANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_URANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK6_URANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_URANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_PLATINUM = _null();
    public static final GemBase_verysmall MANTLEROCK6_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_PLATINUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_OLIVINE = _null();
    public static final GemBase_verysmall MANTLEROCK6_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_OLIVINE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_JADE = _null();
    public static final GemBase_verysmall MANTLEROCK6_JADE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_JADE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_JADE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_JADE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_TOPAZ = _null();
    public static final GemBase_verysmall MANTLEROCK6_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_TOPAZ_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_GOLD = _null();
    public static final GemBase_verysmall MANTLEROCK6_GOLD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_GOLD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_GOLD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_SILVER = _null();
    public static final GemBase_verysmall MANTLEROCK6_SILVER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_SILVER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_SILVER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_REDSTONE = _null();
    public static final GemBase_verysmall MANTLEROCK6_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_REDSTONE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_LAPIS = _null();
    public static final GemBase_verysmall MANTLEROCK6_LAPIS_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_LAPIS_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_SULFUR = _null();
    public static final GemBase_verysmall MANTLEROCK6_SULFUR_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_SULFUR_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_TIN = _null();
    public static final GemBase_verysmall MANTLEROCK6_TIN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_TIN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_TIN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_TIN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_COPPER = _null();
    public static final GemBase_verysmall MANTLEROCK6_COPPER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_COPPER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_COPPER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_IRON = _null();
    public static final GemBase_verysmall MANTLEROCK6_IRON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_IRON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_IRON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_IRON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_LEAD = _null();
    public static final GemBase_verysmall MANTLEROCK6_LEAD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_LEAD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_LEAD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_ALUMINIUM = _null();
    public static final GemBase_verysmall MANTLEROCK6_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_SILICON = _null();
    public static final GemBase_verysmall MANTLEROCK6_SILICON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_SILICON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_SILICON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK6_COAL = _null();
    public static final GemBase_verysmall MANTLEROCK6_COAL_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK6_COAL_SMALL = _null();
    public static final GemBase_compact MANTLEROCK6_COAL_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK6_COAL_VERYCOMPACT = _null();

    public static final Mantlerock MANTLEROCK7_ONYX = _null();
    public static final GemBase_verysmall MANTLEROCK7_ONYX_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_ONYX_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_ONYX_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_MAJORITE = _null();
    public static final GemBase_verysmall MANTLEROCK7_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_MAJORITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_BRIGMANITE = _null();
    public static final GemBase_verysmall MANTLEROCK7_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_RINGWOODITE = _null();
    public static final GemBase_verysmall MANTLEROCK7_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_AMAZONITE = _null();
    public static final GemBase_verysmall MANTLEROCK7_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_AMAZONITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_DIAMOND = _null();
    public static final GemBase_verysmall MANTLEROCK7_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_DIAMOND_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_SAPPHIRE = _null();
    public static final GemBase_verysmall MANTLEROCK7_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_WADSLEYITE = _null();
    public static final GemBase_verysmall MANTLEROCK7_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_RUBY = _null();
    public static final GemBase_verysmall MANTLEROCK7_RUBY_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_RUBY_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_RUBY_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_TUNGSTEN = _null();
    public static final GemBase_verysmall MANTLEROCK7_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_EMERALD = _null();
    public static final GemBase_verysmall MANTLEROCK7_EMERALD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_EMERALD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_TITANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK7_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_TITANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_URANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK7_URANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_URANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_PLATINUM = _null();
    public static final GemBase_verysmall MANTLEROCK7_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_PLATINUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_OLIVINE = _null();
    public static final GemBase_verysmall MANTLEROCK7_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_OLIVINE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_JADE = _null();
    public static final GemBase_verysmall MANTLEROCK7_JADE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_JADE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_JADE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_JADE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_TOPAZ = _null();
    public static final GemBase_verysmall MANTLEROCK7_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_TOPAZ_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_GOLD = _null();
    public static final GemBase_verysmall MANTLEROCK7_GOLD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_GOLD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_GOLD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_SILVER = _null();
    public static final GemBase_verysmall MANTLEROCK7_SILVER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_SILVER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_SILVER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_REDSTONE = _null();
    public static final GemBase_verysmall MANTLEROCK7_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_REDSTONE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_LAPIS = _null();
    public static final GemBase_verysmall MANTLEROCK7_LAPIS_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_LAPIS_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_SULFUR = _null();
    public static final GemBase_verysmall MANTLEROCK7_SULFUR_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_SULFUR_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_TIN = _null();
    public static final GemBase_verysmall MANTLEROCK7_TIN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_TIN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_TIN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_TIN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_COPPER = _null();
    public static final GemBase_verysmall MANTLEROCK7_COPPER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_COPPER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_COPPER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_IRON = _null();
    public static final GemBase_verysmall MANTLEROCK7_IRON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_IRON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_IRON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_IRON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_LEAD = _null();
    public static final GemBase_verysmall MANTLEROCK7_LEAD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_LEAD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_LEAD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_ALUMINIUM = _null();
    public static final GemBase_verysmall MANTLEROCK7_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_SILICON = _null();
    public static final GemBase_verysmall MANTLEROCK7_SILICON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_SILICON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_SILICON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK7_COAL = _null();
    public static final GemBase_verysmall MANTLEROCK7_COAL_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK7_COAL_SMALL = _null();
    public static final GemBase_compact MANTLEROCK7_COAL_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK7_COAL_VERYCOMPACT = _null();

    public static final Mantlerock MANTLEROCK8_ONYX = _null();
    public static final GemBase_verysmall MANTLEROCK8_ONYX_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_ONYX_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_ONYX_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_MAJORITE = _null();
    public static final GemBase_verysmall MANTLEROCK8_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_MAJORITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_BRIGMANITE = _null();
    public static final GemBase_verysmall MANTLEROCK8_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_RINGWOODITE = _null();
    public static final GemBase_verysmall MANTLEROCK8_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_AMAZONITE = _null();
    public static final GemBase_verysmall MANTLEROCK8_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_AMAZONITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_DIAMOND = _null();
    public static final GemBase_verysmall MANTLEROCK8_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_DIAMOND_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_SAPPHIRE = _null();
    public static final GemBase_verysmall MANTLEROCK8_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_WADSLEYITE = _null();
    public static final GemBase_verysmall MANTLEROCK8_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_RUBY = _null();
    public static final GemBase_verysmall MANTLEROCK8_RUBY_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_RUBY_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_RUBY_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_TUNGSTEN = _null();
    public static final GemBase_verysmall MANTLEROCK8_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_EMERALD = _null();
    public static final GemBase_verysmall MANTLEROCK8_EMERALD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_EMERALD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_TITANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK8_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_TITANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_URANIUM = _null();
    public static final GemBase_verysmall MANTLEROCK8_URANIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_URANIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_PLATINUM = _null();
    public static final GemBase_verysmall MANTLEROCK8_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_PLATINUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_OLIVINE = _null();
    public static final GemBase_verysmall MANTLEROCK8_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_OLIVINE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_JADE = _null();
    public static final GemBase_verysmall MANTLEROCK8_JADE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_JADE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_JADE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_JADE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_TOPAZ = _null();
    public static final GemBase_verysmall MANTLEROCK8_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_TOPAZ_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_GOLD = _null();
    public static final GemBase_verysmall MANTLEROCK8_GOLD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_GOLD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_GOLD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_SILVER = _null();
    public static final GemBase_verysmall MANTLEROCK8_SILVER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_SILVER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_SILVER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_REDSTONE = _null();
    public static final GemBase_verysmall MANTLEROCK8_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_REDSTONE_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_LAPIS = _null();
    public static final GemBase_verysmall MANTLEROCK8_LAPIS_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_LAPIS_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_SULFUR = _null();
    public static final GemBase_verysmall MANTLEROCK8_SULFUR_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_SULFUR_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_TIN = _null();
    public static final GemBase_verysmall MANTLEROCK8_TIN_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_TIN_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_TIN_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_TIN_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_COPPER = _null();
    public static final GemBase_verysmall MANTLEROCK8_COPPER_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_COPPER_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_COPPER_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_IRON = _null();
    public static final GemBase_verysmall MANTLEROCK8_IRON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_IRON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_IRON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_IRON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_LEAD = _null();
    public static final GemBase_verysmall MANTLEROCK8_LEAD_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_LEAD_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_LEAD_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_ALUMINIUM = _null();
    public static final GemBase_verysmall MANTLEROCK8_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_SILICON = _null();
    public static final GemBase_verysmall MANTLEROCK8_SILICON_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_SILICON_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_SILICON_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock MANTLEROCK8_COAL = _null();
    public static final GemBase_verysmall MANTLEROCK8_COAL_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK8_COAL_SMALL = _null();
    public static final GemBase_compact MANTLEROCK8_COAL_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK8_COAL_VERYCOMPACT = _null();

    public static final Mantlerock LOWER_MANTLEROCK_ONYX = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_ONYX_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_ONYX_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_ONYX_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_MAJORITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_MAJORITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_BRIGMANITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_RINGWOODITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_AMAZONITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_AMAZONITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_DIAMOND = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_DIAMOND_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_SAPPHIRE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_WADSLEYITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_RUBY = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_RUBY_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_RUBY_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_RUBY_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_TUNGSTEN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_EMERALD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_EMERALD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_EMERALD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_TITANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_TITANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_URANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_URANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_URANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_PLATINUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_PLATINUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_OLIVINE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_OLIVINE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_JADE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_JADE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_JADE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_JADE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_JADE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_TOPAZ = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_TOPAZ_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_GOLD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_GOLD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_GOLD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_GOLD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_SILVER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_SILVER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_SILVER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_SILVER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_REDSTONE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_REDSTONE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_LAPIS = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_LAPIS_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_LAPIS_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_SULFUR = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_SULFUR_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_SULFUR_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_TIN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_TIN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_TIN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_TIN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_TIN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_COPPER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_COPPER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_COPPER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_COPPER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_IRON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_IRON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_IRON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_IRON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_IRON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_LEAD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_LEAD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_LEAD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_LEAD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_ALUMINIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_SILICON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_SILICON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_SILICON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_SILICON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK_COAL = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK_COAL_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK_COAL_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK_COAL_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK_COAL_VERYCOMPACT = _null();

    public static final Mantlerock LOWER_MANTLEROCK1_ONYX = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_ONYX_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_ONYX_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_ONYX_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_MAJORITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_MAJORITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_BRIGMANITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_RINGWOODITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_AMAZONITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_AMAZONITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_DIAMOND = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_DIAMOND_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_SAPPHIRE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_WADSLEYITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_RUBY = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_RUBY_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_RUBY_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_RUBY_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_TUNGSTEN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_EMERALD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_EMERALD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_EMERALD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_TITANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_TITANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_URANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_URANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_URANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_PLATINUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_PLATINUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_OLIVINE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_OLIVINE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_JADE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_JADE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_JADE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_JADE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_JADE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_TOPAZ = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_TOPAZ_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_GOLD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_GOLD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_GOLD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_GOLD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_SILVER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_SILVER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_SILVER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_SILVER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_REDSTONE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_REDSTONE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_LAPIS = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_LAPIS_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_LAPIS_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_SULFUR = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_SULFUR_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_SULFUR_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_TIN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_TIN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_TIN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_TIN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_TIN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_COPPER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_COPPER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_COPPER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_COPPER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_IRON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_IRON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_IRON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_IRON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_IRON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_LEAD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_LEAD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_LEAD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_LEAD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_ALUMINIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_SILICON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_SILICON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_SILICON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_SILICON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK1_COAL = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK1_COAL_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK1_COAL_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK1_COAL_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK1_COAL_VERYCOMPACT = _null();

    public static final Mantlerock LOWER_MANTLEROCK2_ONYX = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_ONYX_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_ONYX_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_ONYX_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_MAJORITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_MAJORITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_BRIGMANITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_RINGWOODITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_AMAZONITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_AMAZONITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_DIAMOND = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_DIAMOND_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_SAPPHIRE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_WADSLEYITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_RUBY = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_RUBY_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_RUBY_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_RUBY_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_TUNGSTEN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_EMERALD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_EMERALD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_EMERALD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_TITANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_TITANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_URANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_URANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_URANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_PLATINUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_PLATINUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_OLIVINE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_OLIVINE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_JADE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_JADE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_JADE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_JADE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_JADE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_TOPAZ = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_TOPAZ_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_GOLD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_GOLD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_GOLD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_GOLD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_SILVER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_SILVER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_SILVER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_SILVER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_REDSTONE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_REDSTONE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_LAPIS = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_LAPIS_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_LAPIS_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_SULFUR = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_SULFUR_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_SULFUR_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_TIN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_TIN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_TIN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_TIN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_TIN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_COPPER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_COPPER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_COPPER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_COPPER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_IRON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_IRON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_IRON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_IRON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_IRON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_LEAD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_LEAD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_LEAD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_LEAD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_ALUMINIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_SILICON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_SILICON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_SILICON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_SILICON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK2_COAL = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK2_COAL_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK2_COAL_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK2_COAL_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK2_COAL_VERYCOMPACT = _null();

    public static final Mantlerock LOWER_MANTLEROCK3_ONYX = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_ONYX_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_ONYX_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_ONYX_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_MAJORITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_MAJORITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_BRIGMANITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_RINGWOODITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_AMAZONITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_AMAZONITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_DIAMOND = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_DIAMOND_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_SAPPHIRE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_WADSLEYITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_RUBY = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_RUBY_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_RUBY_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_RUBY_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_TUNGSTEN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_EMERALD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_EMERALD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_EMERALD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_TITANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_TITANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_URANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_URANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_URANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_PLATINUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_PLATINUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_OLIVINE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_OLIVINE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_JADE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_JADE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_JADE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_JADE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_JADE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_TOPAZ = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_TOPAZ_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_GOLD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_GOLD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_GOLD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_GOLD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_SILVER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_SILVER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_SILVER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_SILVER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_REDSTONE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_REDSTONE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_LAPIS = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_LAPIS_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_LAPIS_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_SULFUR = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_SULFUR_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_SULFUR_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_TIN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_TIN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_TIN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_TIN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_TIN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_COPPER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_COPPER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_COPPER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_COPPER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_IRON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_IRON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_IRON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_IRON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_IRON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_LEAD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_LEAD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_LEAD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_LEAD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_ALUMINIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_SILICON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_SILICON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_SILICON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_SILICON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK3_COAL = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK3_COAL_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK3_COAL_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK3_COAL_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK3_COAL_VERYCOMPACT = _null();

    public static final Mantlerock LOWER_MANTLEROCK4_ONYX = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_ONYX_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_ONYX_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_ONYX_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_MAJORITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_MAJORITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_BRIGMANITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_RINGWOODITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_AMAZONITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_AMAZONITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_DIAMOND = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_DIAMOND_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_SAPPHIRE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_WADSLEYITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_RUBY = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_RUBY_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_RUBY_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_RUBY_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_TUNGSTEN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_EMERALD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_EMERALD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_EMERALD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_TITANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_TITANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_URANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_URANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_URANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_PLATINUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_PLATINUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_OLIVINE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_OLIVINE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_JADE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_JADE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_JADE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_JADE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_JADE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_TOPAZ = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_TOPAZ_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_GOLD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_GOLD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_GOLD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_GOLD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_SILVER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_SILVER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_SILVER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_SILVER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_REDSTONE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_REDSTONE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_LAPIS = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_LAPIS_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_LAPIS_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_SULFUR = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_SULFUR_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_SULFUR_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_TIN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_TIN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_TIN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_TIN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_TIN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_COPPER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_COPPER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_COPPER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_COPPER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_IRON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_IRON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_IRON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_IRON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_IRON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_LEAD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_LEAD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_LEAD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_LEAD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_ALUMINIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_SILICON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_SILICON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_SILICON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_SILICON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK4_COAL = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK4_COAL_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK4_COAL_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK4_COAL_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK4_COAL_VERYCOMPACT = _null();

    public static final Mantlerock LOWER_MANTLEROCK5_ONYX = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_ONYX_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_ONYX_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_ONYX_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_MAJORITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_MAJORITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_BRIGMANITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_RINGWOODITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_AMAZONITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_AMAZONITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_DIAMOND = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_DIAMOND_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_SAPPHIRE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_WADSLEYITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_RUBY = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_RUBY_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_RUBY_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_RUBY_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_TUNGSTEN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_EMERALD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_EMERALD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_EMERALD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_TITANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_TITANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_URANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_URANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_URANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_PLATINUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_PLATINUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_OLIVINE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_OLIVINE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_JADE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_JADE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_JADE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_JADE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_JADE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_TOPAZ = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_TOPAZ_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_GOLD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_GOLD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_GOLD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_GOLD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_SILVER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_SILVER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_SILVER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_SILVER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_REDSTONE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_REDSTONE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_LAPIS = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_LAPIS_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_LAPIS_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_SULFUR = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_SULFUR_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_SULFUR_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_TIN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_TIN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_TIN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_TIN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_TIN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_COPPER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_COPPER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_COPPER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_COPPER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_IRON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_IRON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_IRON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_IRON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_IRON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_LEAD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_LEAD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_LEAD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_LEAD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_ALUMINIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_SILICON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_SILICON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_SILICON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_SILICON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK5_COAL = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK5_COAL_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK5_COAL_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK5_COAL_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK5_COAL_VERYCOMPACT = _null();

    public static final Mantlerock LOWER_MANTLEROCK6_ONYX = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_ONYX_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_ONYX_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_ONYX_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_MAJORITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_MAJORITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_BRIGMANITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_RINGWOODITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_AMAZONITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_AMAZONITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_DIAMOND = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_DIAMOND_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_SAPPHIRE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_WADSLEYITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_RUBY = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_RUBY_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_RUBY_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_RUBY_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_TUNGSTEN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_EMERALD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_EMERALD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_EMERALD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_TITANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_TITANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_URANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_URANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_URANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_PLATINUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_PLATINUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_OLIVINE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_OLIVINE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_JADE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_JADE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_JADE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_JADE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_JADE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_TOPAZ = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_TOPAZ_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_GOLD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_GOLD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_GOLD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_GOLD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_SILVER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_SILVER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_SILVER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_SILVER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_REDSTONE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_REDSTONE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_LAPIS = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_LAPIS_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_LAPIS_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_SULFUR = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_SULFUR_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_SULFUR_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_TIN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_TIN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_TIN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_TIN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_TIN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_COPPER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_COPPER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_COPPER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_COPPER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_IRON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_IRON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_IRON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_IRON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_IRON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_LEAD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_LEAD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_LEAD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_LEAD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_ALUMINIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_SILICON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_SILICON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_SILICON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_SILICON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK6_COAL = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK6_COAL_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK6_COAL_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK6_COAL_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK6_COAL_VERYCOMPACT = _null();

    public static final Mantlerock LOWER_MANTLEROCK7_ONYX = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_ONYX_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_ONYX_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_ONYX_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_MAJORITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_MAJORITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_BRIGMANITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_RINGWOODITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_AMAZONITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_AMAZONITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_DIAMOND = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_DIAMOND_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_SAPPHIRE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_WADSLEYITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_RUBY = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_RUBY_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_RUBY_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_RUBY_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_TUNGSTEN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_EMERALD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_EMERALD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_EMERALD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_TITANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_TITANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_URANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_URANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_URANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_PLATINUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_PLATINUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_OLIVINE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_OLIVINE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_JADE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_JADE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_JADE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_JADE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_JADE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_TOPAZ = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_TOPAZ_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_GOLD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_GOLD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_GOLD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_GOLD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_SILVER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_SILVER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_SILVER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_SILVER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_REDSTONE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_REDSTONE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_LAPIS = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_LAPIS_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_LAPIS_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_SULFUR = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_SULFUR_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_SULFUR_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_TIN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_TIN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_TIN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_TIN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_TIN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_COPPER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_COPPER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_COPPER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_COPPER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_IRON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_IRON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_IRON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_IRON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_IRON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_LEAD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_LEAD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_LEAD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_LEAD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_ALUMINIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_SILICON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_SILICON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_SILICON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_SILICON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK7_COAL = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK7_COAL_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK7_COAL_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK7_COAL_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK7_COAL_VERYCOMPACT = _null();

    public static final Mantlerock LOWER_MANTLEROCK8_ONYX = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_ONYX_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_ONYX_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_ONYX_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_MAJORITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_MAJORITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_BRIGMANITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_RINGWOODITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_AMAZONITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_AMAZONITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_DIAMOND = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_DIAMOND_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_SAPPHIRE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_WADSLEYITE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_RUBY = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_RUBY_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_RUBY_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_RUBY_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_TUNGSTEN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_EMERALD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_EMERALD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_EMERALD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_TITANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_TITANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_URANIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_URANIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_URANIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_PLATINUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_PLATINUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_OLIVINE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_OLIVINE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_JADE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_JADE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_JADE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_JADE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_JADE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_TOPAZ = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_TOPAZ_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_GOLD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_GOLD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_GOLD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_GOLD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_SILVER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_SILVER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_SILVER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_SILVER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_REDSTONE = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_REDSTONE_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_LAPIS = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_LAPIS_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_LAPIS_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_SULFUR = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_SULFUR_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_SULFUR_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_TIN = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_TIN_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_TIN_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_TIN_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_TIN_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_COPPER = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_COPPER_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_COPPER_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_COPPER_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_IRON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_IRON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_IRON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_IRON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_IRON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_LEAD = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_LEAD_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_LEAD_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_LEAD_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_ALUMINIUM = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_SILICON = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_SILICON_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_SILICON_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_SILICON_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock LOWER_MANTLEROCK8_COAL = _null();
    public static final GemBase_verysmall LOWER_MANTLEROCK8_COAL_VERYSMALL = _null();
    public static final GemBase_small LOWER_MANTLEROCK8_COAL_SMALL = _null();
    public static final GemBase_compact LOWER_MANTLEROCK8_COAL_COMPACT = _null();
    public static final GemBase_verycompact LOWER_MANTLEROCK8_COAL_VERYCOMPACT = _null();

    public static final Corerock CORESTONE_ONYX = _null();
    public static final GemBase_verysmall CORESTONE_ONYX_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_ONYX_SMALL = _null();
    public static final GemBase_compact CORESTONE_ONYX_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_ONYX_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_MAJORITE = _null();
    public static final GemBase_verysmall CORESTONE_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_MAJORITE_SMALL = _null();
    public static final GemBase_compact CORESTONE_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_MAJORITE_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_BRIGMANITE = _null();
    public static final GemBase_verysmall CORESTONE_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact CORESTONE_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_BRIGMANITE_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_RINGWOODITE = _null();
    public static final GemBase_verysmall CORESTONE_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact CORESTONE_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_RINGWOODITE_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_AMAZONITE = _null();
    public static final GemBase_verysmall CORESTONE_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_AMAZONITE_SMALL = _null();
    public static final GemBase_compact CORESTONE_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_AMAZONITE_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_DIAMOND = _null();
    public static final GemBase_verysmall CORESTONE_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_DIAMOND_SMALL = _null();
    public static final GemBase_compact CORESTONE_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_DIAMOND_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_SAPPHIRE = _null();
    public static final GemBase_verysmall CORESTONE_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact CORESTONE_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_SAPPHIRE_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_WADSLEYITE = _null();
    public static final GemBase_verysmall CORESTONE_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact CORESTONE_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_WADSLEYITE_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_RUBY = _null();
    public static final GemBase_verysmall CORESTONE_RUBY_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_RUBY_SMALL = _null();
    public static final GemBase_compact CORESTONE_RUBY_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_RUBY_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_TUNGSTEN = _null();
    public static final GemBase_verysmall CORESTONE_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact CORESTONE_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_TUNGSTEN_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_EMERALD = _null();
    public static final GemBase_verysmall CORESTONE_EMERALD_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_EMERALD_SMALL = _null();
    public static final GemBase_compact CORESTONE_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_EMERALD_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_TITANIUM = _null();
    public static final GemBase_verysmall CORESTONE_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_TITANIUM_SMALL = _null();
    public static final GemBase_compact CORESTONE_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_TITANIUM_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_URANIUM = _null();
    public static final GemBase_verysmall CORESTONE_URANIUM_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_URANIUM_SMALL = _null();
    public static final GemBase_compact CORESTONE_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_URANIUM_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_PLATINUM = _null();
    public static final GemBase_verysmall CORESTONE_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_PLATINUM_SMALL = _null();
    public static final GemBase_compact CORESTONE_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_PLATINUM_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_OLIVINE = _null();
    public static final GemBase_verysmall CORESTONE_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_OLIVINE_SMALL = _null();
    public static final GemBase_compact CORESTONE_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_OLIVINE_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_JADE = _null();
    public static final GemBase_verysmall CORESTONE_JADE_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_JADE_SMALL = _null();
    public static final GemBase_compact CORESTONE_JADE_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_JADE_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_TOPAZ = _null();
    public static final GemBase_verysmall CORESTONE_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_TOPAZ_SMALL = _null();
    public static final GemBase_compact CORESTONE_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_TOPAZ_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_GOLD = _null();
    public static final GemBase_verysmall CORESTONE_GOLD_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_GOLD_SMALL = _null();
    public static final GemBase_compact CORESTONE_GOLD_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_GOLD_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_SILVER = _null();
    public static final GemBase_verysmall CORESTONE_SILVER_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_SILVER_SMALL = _null();
    public static final GemBase_compact CORESTONE_SILVER_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_SILVER_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_REDSTONE = _null();
    public static final GemBase_verysmall CORESTONE_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_REDSTONE_SMALL = _null();
    public static final GemBase_compact CORESTONE_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_REDSTONE_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_LAPIS = _null();
    public static final GemBase_verysmall CORESTONE_LAPIS_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_LAPIS_SMALL = _null();
    public static final GemBase_compact CORESTONE_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_LAPIS_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_SULFUR = _null();
    public static final GemBase_verysmall CORESTONE_SULFUR_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_SULFUR_SMALL = _null();
    public static final GemBase_compact CORESTONE_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_SULFUR_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_TIN = _null();
    public static final GemBase_verysmall CORESTONE_TIN_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_TIN_SMALL = _null();
    public static final GemBase_compact CORESTONE_TIN_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_TIN_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_COPPER = _null();
    public static final GemBase_verysmall CORESTONE_COPPER_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_COPPER_SMALL = _null();
    public static final GemBase_compact CORESTONE_COPPER_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_COPPER_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_IRON = _null();
    public static final GemBase_verysmall CORESTONE_IRON_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_IRON_SMALL = _null();
    public static final GemBase_compact CORESTONE_IRON_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_IRON_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_LEAD = _null();
    public static final GemBase_verysmall CORESTONE_LEAD_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_LEAD_SMALL = _null();
    public static final GemBase_compact CORESTONE_LEAD_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_LEAD_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_ALUMINIUM = _null();
    public static final GemBase_verysmall CORESTONE_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact CORESTONE_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_ALUMINIUM_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_SILICON = _null();
    public static final GemBase_verysmall CORESTONE_SILICON_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_SILICON_SMALL = _null();
    public static final GemBase_compact CORESTONE_SILICON_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_SILICON_VERYCOMPACT = _null();
    public static final Corerock CORESTONE_COAL = _null();
    public static final GemBase_verysmall CORESTONE_COAL_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_COAL_SMALL = _null();
    public static final GemBase_compact CORESTONE_COAL_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_COAL_VERYCOMPACT = _null();

    public static final Corerock INNERCORESTONE_ONYX = _null();
    public static final GemBase_verysmall INNERCORESTONE_ONYX_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_ONYX_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_ONYX_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_ONYX_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_MAJORITE = _null();
    public static final GemBase_verysmall INNERCORESTONE_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_MAJORITE_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_MAJORITE_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_BRIGMANITE = _null();
    public static final GemBase_verysmall INNERCORESTONE_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_BRIGMANITE_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_RINGWOODITE = _null();
    public static final GemBase_verysmall INNERCORESTONE_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_RINGWOODITE_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_AMAZONITE = _null();
    public static final GemBase_verysmall INNERCORESTONE_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_AMAZONITE_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_AMAZONITE_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_DIAMOND = _null();
    public static final GemBase_verysmall INNERCORESTONE_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_DIAMOND_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_DIAMOND_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_SAPPHIRE = _null();
    public static final GemBase_verysmall INNERCORESTONE_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_SAPPHIRE_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_WADSLEYITE = _null();
    public static final GemBase_verysmall INNERCORESTONE_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_WADSLEYITE_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_RUBY = _null();
    public static final GemBase_verysmall INNERCORESTONE_RUBY_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_RUBY_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_RUBY_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_RUBY_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_TUNGSTEN = _null();
    public static final GemBase_verysmall INNERCORESTONE_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_TUNGSTEN_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_EMERALD = _null();
    public static final GemBase_verysmall INNERCORESTONE_EMERALD_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_EMERALD_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_EMERALD_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_TITANIUM = _null();
    public static final GemBase_verysmall INNERCORESTONE_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_TITANIUM_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_TITANIUM_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_URANIUM = _null();
    public static final GemBase_verysmall INNERCORESTONE_URANIUM_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_URANIUM_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_URANIUM_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_PLATINUM = _null();
    public static final GemBase_verysmall INNERCORESTONE_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_PLATINUM_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_PLATINUM_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_OLIVINE = _null();
    public static final GemBase_verysmall INNERCORESTONE_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_OLIVINE_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_OLIVINE_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_JADE = _null();
    public static final GemBase_verysmall INNERCORESTONE_JADE_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_JADE_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_JADE_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_JADE_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_TOPAZ = _null();
    public static final GemBase_verysmall INNERCORESTONE_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_TOPAZ_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_TOPAZ_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_GOLD = _null();
    public static final GemBase_verysmall INNERCORESTONE_GOLD_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_GOLD_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_GOLD_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_GOLD_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_SILVER = _null();
    public static final GemBase_verysmall INNERCORESTONE_SILVER_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_SILVER_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_SILVER_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_SILVER_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_REDSTONE = _null();
    public static final GemBase_verysmall INNERCORESTONE_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_REDSTONE_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_REDSTONE_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_LAPIS = _null();
    public static final GemBase_verysmall INNERCORESTONE_LAPIS_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_LAPIS_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_LAPIS_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_SULFUR = _null();
    public static final GemBase_verysmall INNERCORESTONE_SULFUR_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_SULFUR_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_SULFUR_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_TIN = _null();
    public static final GemBase_verysmall INNERCORESTONE_TIN_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_TIN_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_TIN_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_TIN_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_COPPER = _null();
    public static final GemBase_verysmall INNERCORESTONE_COPPER_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_COPPER_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_COPPER_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_COPPER_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_IRON = _null();
    public static final GemBase_verysmall INNERCORESTONE_IRON_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_IRON_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_IRON_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_IRON_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_LEAD = _null();
    public static final GemBase_verysmall INNERCORESTONE_LEAD_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_LEAD_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_LEAD_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_LEAD_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_ALUMINIUM = _null();
    public static final GemBase_verysmall INNERCORESTONE_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_ALUMINIUM_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_SILICON = _null();
    public static final GemBase_verysmall INNERCORESTONE_SILICON_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_SILICON_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_SILICON_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_SILICON_VERYCOMPACT = _null();
    public static final Corerock INNERCORESTONE_COAL = _null();
    public static final GemBase_verysmall INNERCORESTONE_COAL_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_COAL_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_COAL_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_COAL_VERYCOMPACT = _null();

    public static final Corerock CENTERCORESTONE_ONYX = _null();
    public static final GemBase_verysmall CENTERCORESTONE_ONYX_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_ONYX_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_ONYX_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_ONYX_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_MAJORITE = _null();
    public static final GemBase_verysmall CENTERCORESTONE_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_MAJORITE_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_MAJORITE_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_BRIGMANITE = _null();
    public static final GemBase_verysmall CENTERCORESTONE_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_BRIGMANITE_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_RINGWOODITE = _null();
    public static final GemBase_verysmall CENTERCORESTONE_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_RINGWOODITE_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_AMAZONITE = _null();
    public static final GemBase_verysmall CENTERCORESTONE_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_AMAZONITE_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_AMAZONITE_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_DIAMOND = _null();
    public static final GemBase_verysmall CENTERCORESTONE_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_DIAMOND_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_DIAMOND_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_SAPPHIRE = _null();
    public static final GemBase_verysmall CENTERCORESTONE_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_SAPPHIRE_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_WADSLEYITE = _null();
    public static final GemBase_verysmall CENTERCORESTONE_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_WADSLEYITE_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_RUBY = _null();
    public static final GemBase_verysmall CENTERCORESTONE_RUBY_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_RUBY_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_RUBY_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_RUBY_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_TUNGSTEN = _null();
    public static final GemBase_verysmall CENTERCORESTONE_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_TUNGSTEN_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_EMERALD = _null();
    public static final GemBase_verysmall CENTERCORESTONE_EMERALD_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_EMERALD_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_EMERALD_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_TITANIUM = _null();
    public static final GemBase_verysmall CENTERCORESTONE_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_TITANIUM_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_TITANIUM_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_URANIUM = _null();
    public static final GemBase_verysmall CENTERCORESTONE_URANIUM_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_URANIUM_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_URANIUM_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_PLATINUM = _null();
    public static final GemBase_verysmall CENTERCORESTONE_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_PLATINUM_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_PLATINUM_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_OLIVINE = _null();
    public static final GemBase_verysmall CENTERCORESTONE_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_OLIVINE_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_OLIVINE_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_JADE = _null();
    public static final GemBase_verysmall CENTERCORESTONE_JADE_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_JADE_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_JADE_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_JADE_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_TOPAZ = _null();
    public static final GemBase_verysmall CENTERCORESTONE_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_TOPAZ_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_TOPAZ_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_GOLD = _null();
    public static final GemBase_verysmall CENTERCORESTONE_GOLD_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_GOLD_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_GOLD_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_GOLD_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_SILVER = _null();
    public static final GemBase_verysmall CENTERCORESTONE_SILVER_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_SILVER_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_SILVER_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_SILVER_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_REDSTONE = _null();
    public static final GemBase_verysmall CENTERCORESTONE_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_REDSTONE_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_REDSTONE_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_LAPIS = _null();
    public static final GemBase_verysmall CENTERCORESTONE_LAPIS_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_LAPIS_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_LAPIS_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_SULFUR = _null();
    public static final GemBase_verysmall CENTERCORESTONE_SULFUR_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_SULFUR_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_SULFUR_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_TIN = _null();
    public static final GemBase_verysmall CENTERCORESTONE_TIN_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_TIN_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_TIN_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_TIN_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_COPPER = _null();
    public static final GemBase_verysmall CENTERCORESTONE_COPPER_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_COPPER_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_COPPER_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_COPPER_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_IRON = _null();
    public static final GemBase_verysmall CENTERCORESTONE_IRON_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_IRON_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_IRON_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_IRON_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_LEAD = _null();
    public static final GemBase_verysmall CENTERCORESTONE_LEAD_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_LEAD_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_LEAD_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_LEAD_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_ALUMINIUM = _null();
    public static final GemBase_verysmall CENTERCORESTONE_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_ALUMINIUM_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_SILICON = _null();
    public static final GemBase_verysmall CENTERCORESTONE_SILICON_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_SILICON_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_SILICON_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_SILICON_VERYCOMPACT = _null();
    public static final Corerock CENTERCORESTONE_COAL = _null();
    public static final GemBase_verysmall CENTERCORESTONE_COAL_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_COAL_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_COAL_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_COAL_VERYCOMPACT = _null();





    // GENERATED END






    public static final Block STEEL_BLOCK = _null();

    public static final Block SOLID_BOULDER = _null();

    public static final Block VERY_SOLID_BOULDER = _null();



    public static final Block HARDROCK = _null();

    public static final Block DEEPROCK = _null();

    public static final Block CRUSTROCK = _null();

    public static final Block MANTLEROCK = _null();

    public static final Block MANTLEROCK1 = _null();

    public static final Block MANTLEROCK2 = _null();

    public static final Block MANTLEROCK3 = _null();

    public static final Block MANTLEROCK4 = _null();

    public static final Block MANTLEROCK5 = _null();

    public static final Block MANTLEROCK6 = _null();

    public static final Block MANTLEROCK7 = _null();

    public static final Block MANTLEROCK8 = _null();

    public static final Block LOWER_MANTLEROCK1 = _null();

    public static final Block LOWER_MANTLEROCK2 = _null();

    public static final Block LOWER_MANTLEROCK3 = _null();

    public static final Block LOWER_MANTLEROCK4 = _null();

    public static final Block LOWER_MANTLEROCK5 = _null();

    public static final Block LOWER_MANTLEROCK6 = _null();

    public static final Block LOWER_MANTLEROCK7 = _null();

    public static final Block LOWER_MANTLEROCK8 = _null();

    public static final Block CORESTONE = _null();

    public static final Block INNERCORESTONE = _null();

    public static final Block CENTERCORESTONE = _null();

    public static final Block MAGMA_CORESTONE = _null();

    public static final Block COLD_CORESTONE = _null();



    //SEDIMENTARY ROCK

    public static final Block LIMESTONE = _null();



    public static final Block MANTLEGAS = _null();

    public static final Block HOT_MANTLEROCK = _null();

    public static final Block VERY_HOT_MANTLEROCK = _null();

    public static final Block SUPER_HOT_MANTLEROCK = _null();



    public static final Block HOTROCK = _null();



    public static void register(IForgeRegistry<Block> registry) {

        boolean generateHolders = System.getProperty("planetcore.generate_holders", "false").equalsIgnoreCase("true");



        StringBuilder holderGenString = generateHolders ? new StringBuilder(64*1024) : null;

        for (ModBlocks.OreForm oreForm : ModBlocks.OreForm.values()) {

            for (ModBlocks.Ore ore : ModBlocks.Ore.values()) {

                String registryName;

                    registryName = oreForm.name().toLowerCase(Locale.ROOT) + "_" + ore.name().toLowerCase(Locale.ROOT);

                Block block = oreForm.makeBlock(registryName);

                block.setHardness((float) (ore.getOreHardness() + (oreForm.getBaseHardness())));

                block.setResistance((float) (ore.getOreResistance() + (oreForm.getBaseResistance())));

                if (generateHolders) {

                    holderGenString.append("public static final ").append(block.getClass().getSimpleName())

                            .append(" ").append(block.getRegistryName().getPath().toUpperCase(Locale.ROOT)).append(" = _null();\n");

                }

                registry.register(block);

                for (ModBlocks.Ore_size Ore_size : ModBlocks.Ore_size.values()) {

                    String registryName1;

                    registryName1 = oreForm.name().toLowerCase(Locale.ROOT) + "_" + ore.name().toLowerCase(Locale.ROOT) + "_" + Ore_size.name().toLowerCase(Locale.ROOT);

                    Block block1 = Ore_size.makeBlock(registryName1);

                    block1.setHardness((float) (oreForm.getBaseHardness() + (ore.getOreHardness() * (Ore_size.getBaseHardness()))));

                    block1.setResistance((float) (oreForm.getBaseResistance() + (ore.getOreResistance() * (Ore_size.getBaseResistance()))));

                    if (generateHolders) {

                        holderGenString.append("public static final ").append(block1.getClass().getSimpleName())

                                .append(" ").append(block1.getRegistryName().getPath().toUpperCase(Locale.ROOT)).append(" = _null();\n");

                    }

                    registry.register(block1);

                }

            }
            if (generateHolders) holderGenString.append("\n");
        }

        if (generateHolders) {

            System.out.println("\n" + holderGenString.toString());

        }




        registry.registerAll(

                new SulfuricAcidFluid("sulfuric_acid", ModFluids.SULFURIC_ACID_FLUID, Material.WATER),

                new HotLavaFluid("hot_lava", ModFluids.HOT_LAVA_FLUID, Material.LAVA),

                new CoreLavaFluid("core_lava", ModFluids.CORE_LAVA_FLUID, Material.LAVA),

                new OnyxLavaFluid("onyx_lava", ModFluids.ONYX_LAVA_FLUID, Material.LAVA),


                new BlocksBase("iron_block", Material.ROCK).setResistance(500),

                new BlocksBase("steel_block", Material.ROCK).setResistance(500),

                new BlocksBase("silver_block", Material.ROCK).setResistance(500),

                new BlocksBase("gold_block", Material.ROCK).setResistance(500),

                new BlocksBase("platinum_block", Material.ROCK).setResistance(500),

                new BlocksBase("emerald_block", Material.ROCK).setResistance(500),

                new BlocksBase("sapphire_block", Material.ROCK).setResistance(500),

                new BlocksBase("ruby_block", Material.ROCK).setResistance(500),

                new BlocksBase("diamond_block", Material.ROCK).setResistance(500),

                new BlocksBase("amazonite_block", Material.ROCK).setResistance(500),

                new BlocksBase("onyx_block", Material.ROCK).setResistance(500),

                new Mantlerock("solid_boulder", Material.ROCK).setHardness(1000.0F).setResistance(1),

                new Mantlerock("very_solid_boulder", Material.ROCK).setHardness(10000.0F).setResistance(10),

                new Mantlerock("hardrock", Material.ROCK).setHardness(3.3F),

                new Mantlerock("hardrock1", Material.ROCK).setHardness(5.5F),

                new Mantlerock("hardrock2", Material.ROCK).setHardness(8.1F),

                new Mantlerock("deeprock", Material.ROCK).setHardness(11.2F),

                new Mantlerock("deeprock1", Material.ROCK).setHardness(14.9F),

                new Mantlerock("deeprock2", Material.ROCK).setHardness(19.4F),

                new Mantlerock("crustrock", Material.ROCK).setHardness(24.7F),

                new Mantlerock("crustrock1", Material.ROCK).setHardness(31.2F),

                new Mantlerock("crustrock2", Material.ROCK).setHardness(38.9F),

                new Mantlerock("mantlerock", Material.ROCK).setHardness(48.2F).setLightLevel(0.0F),

                new Mantlerock("mantlerock1", Material.ROCK).setHardness(59.4F).setLightLevel(0.05F),

                new Mantlerock("mantlerock2", Material.ROCK).setHardness(72.7F).setLightLevel(0.01F),

                new Mantlerock("mantlerock3", Material.ROCK).setHardness(88.8F).setLightLevel(0.015F),

                new Mantlerock("mantlerock4", Material.ROCK).setHardness(108.1F).setLightLevel(0.02F),

                new Mantlerock("mantlerock5", Material.ROCK).setHardness(131.2F).setLightLevel(0.025F),

                new Mantlerock("mantlerock6", Material.ROCK).setHardness(158.9F).setLightLevel(0.03F),

                new Mantlerock("mantlerock7", Material.ROCK).setHardness(192.2F).setLightLevel(0.035F),

                new Mantlerock("mantlerock8", Material.ROCK).setHardness(232.1F).setLightLevel(0.04F),

                new Mantlerock("lower_mantlerock", Material.ROCK).setHardness(280.0F).setLightLevel(0.055F),

                new Mantlerock("lower_mantlerock1", Material.ROCK).setHardness(337.5F).setLightLevel(0.06F),

                new Mantlerock("lower_mantlerock2", Material.ROCK).setHardness(406.5F).setLightLevel(0.065F),

                new Mantlerock("lower_mantlerock3", Material.ROCK).setHardness(489.4F).setLightLevel(0.07F),

                new Mantlerock("lower_mantlerock4", Material.ROCK).setHardness(588.7F).setLightLevel(0.075F),

                new Mantlerock("lower_mantlerock5", Material.ROCK).setHardness(708.0F).setLightLevel(0.08F),

                new Mantlerock("lower_mantlerock6", Material.ROCK).setHardness(851.1F).setLightLevel(0.085F),

                new Mantlerock("lower_mantlerock7", Material.ROCK).setHardness(1022.8F).setLightLevel(0.09F),

                new Mantlerock("lower_mantlerock8", Material.ROCK).setHardness(1228.8F).setLightLevel(0.095F),

                new Mantlerock("lower_mantlerock9", Material.ROCK).setHardness(1476.1F).setLightLevel(1.0F),

                new Mantlerock("lower_mantlerock10", Material.ROCK).setHardness(1772.8F).setLightLevel(1.0F),

                new Corerock("corestone", Material.ROCK).setHardness(2128.8F),

                new Corerock("innercorestone", Material.ROCK).setHardness(4257.8F),

                new Corerock("centercorestone", Material.ROCK).setHardness(8515.5F),

                new Corerock("magma_corestone", Material.ROCK).setHardness(2128.8F),

                new BlockBase("cold_corestone", Material.ROCK).setHardness(2128.8F),



                new GemBase("limestone", Material.ROCK),

                new GasBase("mantlegas", Material.ROCK),

                new Hot_Mantlerock("hot_mantlerock_0", Material.ROCK),

                new Hot_Mantlerock("hot_mantlerock_1", Material.ROCK),

                new Hot_Mantlerock("hot_mantlerock_2", Material.ROCK),

                new BlockBase("hotrock", Material.ROCK)

        );

    }

}