package com.PlanetCore.init;





import com.PlanetCore.blocks.*;

import com.PlanetCore.util.Reference;
import net.minecraft.block.Block;

import net.minecraft.block.material.Material;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
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

        COMPACT(4, 1.5, id -> new GemBase_compact(id, Material.ROCK)),

        VERYCOMPACT(16.0, 2.0, id -> new GemBase_verycompact(id, Material.ROCK));



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

        ZINC(true, OreType.GEM, 10, 10.0, 1.0),

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
    public static final GemBase ORE_ZINC = _null();
    public static final GemBase_verysmall ORE_ZINC_VERYSMALL = _null();
    public static final GemBase_small ORE_ZINC_SMALL = _null();
    public static final GemBase_compact ORE_ZINC_COMPACT = _null();
    public static final GemBase_verycompact ORE_ZINC_VERYCOMPACT = _null();
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

    public static final Mantlerock HARDROCK_ONYX = _null();
    public static final GemBase_verysmall HARDROCK_ONYX_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_ONYX_SMALL = _null();
    public static final GemBase_compact HARDROCK_ONYX_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_ONYX_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_MAJORITE = _null();
    public static final GemBase_verysmall HARDROCK_MAJORITE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_MAJORITE_SMALL = _null();
    public static final GemBase_compact HARDROCK_MAJORITE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_MAJORITE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_BRIGMANITE = _null();
    public static final GemBase_verysmall HARDROCK_BRIGMANITE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_BRIGMANITE_SMALL = _null();
    public static final GemBase_compact HARDROCK_BRIGMANITE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_BRIGMANITE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_RINGWOODITE = _null();
    public static final GemBase_verysmall HARDROCK_RINGWOODITE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_RINGWOODITE_SMALL = _null();
    public static final GemBase_compact HARDROCK_RINGWOODITE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_RINGWOODITE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_AMAZONITE = _null();
    public static final GemBase_verysmall HARDROCK_AMAZONITE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_AMAZONITE_SMALL = _null();
    public static final GemBase_compact HARDROCK_AMAZONITE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_AMAZONITE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_DIAMOND = _null();
    public static final GemBase_verysmall HARDROCK_DIAMOND_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_DIAMOND_SMALL = _null();
    public static final GemBase_compact HARDROCK_DIAMOND_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_DIAMOND_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_SAPPHIRE = _null();
    public static final GemBase_verysmall HARDROCK_SAPPHIRE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_SAPPHIRE_SMALL = _null();
    public static final GemBase_compact HARDROCK_SAPPHIRE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_SAPPHIRE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_WADSLEYITE = _null();
    public static final GemBase_verysmall HARDROCK_WADSLEYITE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_WADSLEYITE_SMALL = _null();
    public static final GemBase_compact HARDROCK_WADSLEYITE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_WADSLEYITE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_RUBY = _null();
    public static final GemBase_verysmall HARDROCK_RUBY_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_RUBY_SMALL = _null();
    public static final GemBase_compact HARDROCK_RUBY_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_RUBY_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_TUNGSTEN = _null();
    public static final GemBase_verysmall HARDROCK_TUNGSTEN_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_TUNGSTEN_SMALL = _null();
    public static final GemBase_compact HARDROCK_TUNGSTEN_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_TUNGSTEN_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_EMERALD = _null();
    public static final GemBase_verysmall HARDROCK_EMERALD_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_EMERALD_SMALL = _null();
    public static final GemBase_compact HARDROCK_EMERALD_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_EMERALD_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_TITANIUM = _null();
    public static final GemBase_verysmall HARDROCK_TITANIUM_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_TITANIUM_SMALL = _null();
    public static final GemBase_compact HARDROCK_TITANIUM_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_TITANIUM_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_URANIUM = _null();
    public static final GemBase_verysmall HARDROCK_URANIUM_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_URANIUM_SMALL = _null();
    public static final GemBase_compact HARDROCK_URANIUM_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_URANIUM_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_PLATINUM = _null();
    public static final GemBase_verysmall HARDROCK_PLATINUM_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_PLATINUM_SMALL = _null();
    public static final GemBase_compact HARDROCK_PLATINUM_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_PLATINUM_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_OLIVINE = _null();
    public static final GemBase_verysmall HARDROCK_OLIVINE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_OLIVINE_SMALL = _null();
    public static final GemBase_compact HARDROCK_OLIVINE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_OLIVINE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_JADE = _null();
    public static final GemBase_verysmall HARDROCK_JADE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_JADE_SMALL = _null();
    public static final GemBase_compact HARDROCK_JADE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_JADE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_TOPAZ = _null();
    public static final GemBase_verysmall HARDROCK_TOPAZ_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_TOPAZ_SMALL = _null();
    public static final GemBase_compact HARDROCK_TOPAZ_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_TOPAZ_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_GOLD = _null();
    public static final GemBase_verysmall HARDROCK_GOLD_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_GOLD_SMALL = _null();
    public static final GemBase_compact HARDROCK_GOLD_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_GOLD_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_SILVER = _null();
    public static final GemBase_verysmall HARDROCK_SILVER_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_SILVER_SMALL = _null();
    public static final GemBase_compact HARDROCK_SILVER_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_SILVER_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_REDSTONE = _null();
    public static final GemBase_verysmall HARDROCK_REDSTONE_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_REDSTONE_SMALL = _null();
    public static final GemBase_compact HARDROCK_REDSTONE_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_REDSTONE_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_LAPIS = _null();
    public static final GemBase_verysmall HARDROCK_LAPIS_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_LAPIS_SMALL = _null();
    public static final GemBase_compact HARDROCK_LAPIS_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_LAPIS_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_SULFUR = _null();
    public static final GemBase_verysmall HARDROCK_SULFUR_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_SULFUR_SMALL = _null();
    public static final GemBase_compact HARDROCK_SULFUR_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_SULFUR_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_TIN = _null();
    public static final GemBase_verysmall HARDROCK_TIN_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_TIN_SMALL = _null();
    public static final GemBase_compact HARDROCK_TIN_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_TIN_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_COPPER = _null();
    public static final GemBase_verysmall HARDROCK_COPPER_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_COPPER_SMALL = _null();
    public static final GemBase_compact HARDROCK_COPPER_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_COPPER_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_IRON = _null();
    public static final GemBase_verysmall HARDROCK_IRON_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_IRON_SMALL = _null();
    public static final GemBase_compact HARDROCK_IRON_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_IRON_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_LEAD = _null();
    public static final GemBase_verysmall HARDROCK_LEAD_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_LEAD_SMALL = _null();
    public static final GemBase_compact HARDROCK_LEAD_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_LEAD_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_ZINC = _null();
    public static final GemBase_verysmall HARDROCK_ZINC_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_ZINC_SMALL = _null();
    public static final GemBase_compact HARDROCK_ZINC_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_ZINC_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_ALUMINIUM = _null();
    public static final GemBase_verysmall HARDROCK_ALUMINIUM_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_ALUMINIUM_SMALL = _null();
    public static final GemBase_compact HARDROCK_ALUMINIUM_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_ALUMINIUM_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_SILICON = _null();
    public static final GemBase_verysmall HARDROCK_SILICON_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_SILICON_SMALL = _null();
    public static final GemBase_compact HARDROCK_SILICON_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_SILICON_VERYCOMPACT = _null();
    public static final Mantlerock HARDROCK_COAL = _null();
    public static final GemBase_verysmall HARDROCK_COAL_VERYSMALL = _null();
    public static final GemBase_small HARDROCK_COAL_SMALL = _null();
    public static final GemBase_compact HARDROCK_COAL_COMPACT = _null();
    public static final GemBase_verycompact HARDROCK_COAL_VERYCOMPACT = _null();

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
    public static final Mantlerock DEEPROCK_ZINC = _null();
    public static final GemBase_verysmall DEEPROCK_ZINC_VERYSMALL = _null();
    public static final GemBase_small DEEPROCK_ZINC_SMALL = _null();
    public static final GemBase_compact DEEPROCK_ZINC_COMPACT = _null();
    public static final GemBase_verycompact DEEPROCK_ZINC_VERYCOMPACT = _null();
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
    public static final Mantlerock CRUSTROCK_ZINC = _null();
    public static final GemBase_verysmall CRUSTROCK_ZINC_VERYSMALL = _null();
    public static final GemBase_small CRUSTROCK_ZINC_SMALL = _null();
    public static final GemBase_compact CRUSTROCK_ZINC_COMPACT = _null();
    public static final GemBase_verycompact CRUSTROCK_ZINC_VERYCOMPACT = _null();
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
    public static final Mantlerock MANTLEROCK_ZINC = _null();
    public static final GemBase_verysmall MANTLEROCK_ZINC_VERYSMALL = _null();
    public static final GemBase_small MANTLEROCK_ZINC_SMALL = _null();
    public static final GemBase_compact MANTLEROCK_ZINC_COMPACT = _null();
    public static final GemBase_verycompact MANTLEROCK_ZINC_VERYCOMPACT = _null();
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
    public static final Corerock CORESTONE_ZINC = _null();
    public static final GemBase_verysmall CORESTONE_ZINC_VERYSMALL = _null();
    public static final GemBase_small CORESTONE_ZINC_SMALL = _null();
    public static final GemBase_compact CORESTONE_ZINC_COMPACT = _null();
    public static final GemBase_verycompact CORESTONE_ZINC_VERYCOMPACT = _null();
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
    public static final Corerock INNERCORESTONE_ZINC = _null();
    public static final GemBase_verysmall INNERCORESTONE_ZINC_VERYSMALL = _null();
    public static final GemBase_small INNERCORESTONE_ZINC_SMALL = _null();
    public static final GemBase_compact INNERCORESTONE_ZINC_COMPACT = _null();
    public static final GemBase_verycompact INNERCORESTONE_ZINC_VERYCOMPACT = _null();
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
    public static final Corerock CENTERCORESTONE_ZINC = _null();
    public static final GemBase_verysmall CENTERCORESTONE_ZINC_VERYSMALL = _null();
    public static final GemBase_small CENTERCORESTONE_ZINC_SMALL = _null();
    public static final GemBase_compact CENTERCORESTONE_ZINC_COMPACT = _null();
    public static final GemBase_verycompact CENTERCORESTONE_ZINC_VERYCOMPACT = _null();
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

    public static List<Block> AllMantlerockBlocks = new ArrayList<>();

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
                if (oreForm == ModBlocks.OreForm.MANTLEROCK) {
                    AllMantlerockBlocks.add(block);
                }

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
                    if (oreForm == ModBlocks.OreForm.MANTLEROCK) {
                        AllMantlerockBlocks.add(block1);
                    }
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

                new BlocksBase("sulfur_block", Material.ROCK).setResistance(500),

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

                new Mantlerock("mantlerock", Material.ROCK),

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

    public static void registerRenders() {
        for (Block block : AllMantlerockBlocks) {
            for (int meta = 0; meta < 16; meta++) {
                ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                        new ModelResourceLocation(block.getRegistryName() + Mantlerock.EnumType.values()[meta].getName(), "inventory"));
            }
        }
    }


}