package com.PlanetCore.init;





import com.PlanetCore.blocks.*;

import com.PlanetCore.init.blocks.item.ItemBlockVariants;
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

import static com.PlanetCore.init.ModBlocks.OreType.METAL;


@ObjectHolder("planetcore")

public class ModBlocks {

    /*TO DO
    All size use same class as rocktype
    is Ore_size enum needed?

    public enum Ore_size {

        VERYSMALL(0.25, 0.25),
        SMALL(0.5, 0.5),
        COMPACT(4, 1.5),
        VERYCOMPACT(16.0, 2.0);

        private final double baseHardness;
        private final double baseResistance;

        Ore_size(double baseHardness, double baseResistance) {
            this.baseHardness = baseHardness;
            this.baseResistance = baseResistance;
        }

        public double getBaseHardness() {
            return baseHardness;
        }

        public double getBaseResistance() {
            return baseResistance;
        }
    }

     */


    public enum OreType {
        GEM,
        METAL
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
        TUNGSTEN(true, METAL, 50000, 200.0, 5000.0),
        EMERALD(true, OreType.GEM, 25000, 150.0, 2500.0),
        TITANIUM(true, METAL, 10000, 100.0, 1000.0),
        URANIUM(true, METAL, 1200, 40.0, 120.0),
        PLATINUM(true, METAL, 5000, 60.0, 500.0),
        OLIVINE(true, OreType.GEM, 4000, 2400.0, 400),
        JADE(true, OreType.GEM, 3000, 60.0, 300.0),
        TOPAZ(true, OreType.GEM, 2500, 40.0, 250.0),
        GOLD(true, METAL, 2000, 27.0, 200.0),
        SILVER(true, METAL, 600, 18.0, 60.0),
        REDSTONE(true, OreType.GEM, 10, 18.0, 1.0),
        LAPIS(true, OreType.GEM, 10, 12.0, 1.0),
        SULFUR(true, METAL, 10, 10.0, 1.0),
        TIN(true, METAL, 100, 5.0, 1.0),
        COPPER(true, METAL, 100, 5.0, 1.0),
        IRON(true, METAL, 300, 5.0, 1.5),
        LEAD(true, METAL, 10, 10.0, 1.0),
        ZINC(true, METAL, 10, 10.0, 1.0),
        ALUMINIUM(true, METAL, 10, 10.0, 1.0),
        SILICON(true, METAL, 10, 10.0, 1.0),
        COAL(true, METAL, 0, 1.5, 0.0);

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

    /*
    Each rocktype (stone, crust, mantlerock, core) have differant size, but all size use the same class as their rock type.
    This is to ensure they do have the respective amount of meta.
    I don't know how to have each size use the same class as their rocktype inside Ore_size enum.
    "Stone" type don't use meta so they use OreBase class.
    Crust have 3 meta. Mantle use 16 meta. Core use 3 meta (will add more meta later for core).
     */
    public enum OreForm {
        ORE(1.0F, 1.0F, id -> new OreBase(id, Material.ROCK)),
        CRUSTROCK_VERYSMALL(0.0F, 0.0F, id -> new Crustrock(id, Material.ROCK)),
        CRUSTROCK_SMALL(0.5F, 0.5F, id -> new Crustrock(id, Material.ROCK)),
        CRUSTROCK(1.0F, 1.0F, id -> new Crustrock(id, Material.ROCK)),
        CRUSTROCK_COMPACT(4.0F, 4.0F, id -> new Crustrock(id, Material.ROCK)),
        CRUSTROCK_VERYCOMPACT(16.0F, 16.0F, id -> new Crustrock(id, Material.ROCK)),
        MANTLEROCK_VERYSMALL(0.0F, 0.0F, id -> new Mantlerock(id, Material.ROCK)),
        MANTLEROCK_SMALL(0.5F, 0.5F, id -> new Mantlerock(id, Material.ROCK)),
        MANTLEROCK(1.0F, 1.0F, id -> new Mantlerock(id, Material.ROCK)),
        MANTLEROCK_COMPACT(4.0F, 4.0F, id -> new Mantlerock(id, Material.ROCK)),
        MANTLEROCK_VERYCOMPACT(16.0F, 16.0F, id -> new Mantlerock(id, Material.ROCK)),
        CORESTONE_VERYSMALL(0.0F, 0.0F, id -> new Corerock(id, Material.ROCK)),
        CORESTONE_SMALL(0.5F, 0.5F, id -> new Corerock(id, Material.ROCK)),
        CORESTONE(1.0F, 1.0F, id -> new Corerock(id, Material.ROCK)),
        CORESTONE_COMPACT(4.0F, 4.0F, id -> new Corerock(id, Material.ROCK)),
        CORESTONE_VERYCOMPACT(16.0F, 16.0F, id -> new Corerock(id, Material.ROCK));

        private final double baseHardness;
        private final double baseResistance;
        private final Function<String, Block> makeBlock;

        OreForm(double baseHardness, double baseResistance, Function<String, Block> makeBlock) {
            this.baseHardness = baseHardness;
            this.baseResistance = baseResistance;
            this.makeBlock = makeBlock;
        }

        public Block makeBlock(String registryName) {
            return makeBlock.apply(registryName);
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
     * <p>
     * Because creating instances in static initializers is discouraged, they have to be initialized to null.
     * <p>
     * <p>
     * <p>
     * This method returns null, but forces IDE static analysis to see it as a non-null value which those fields will be at runtime.
     * <p>
     * <p>
     * <p>
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

    // GENERATED BEGIN

    public static final OreBase ORE_ONYX = _null();
    public static final OreBase ORE_MAJORITE = _null();
    public static final OreBase ORE_BRIGMANITE = _null();
    public static final OreBase ORE_RINGWOODITE = _null();
    public static final OreBase ORE_AMAZONITE = _null();
    public static final OreBase ORE_DIAMOND = _null();
    public static final OreBase ORE_SAPPHIRE = _null();
    public static final OreBase ORE_WADSLEYITE = _null();
    public static final OreBase ORE_RUBY = _null();
    public static final OreBase ORE_TUNGSTEN = _null();
    public static final OreBase ORE_EMERALD = _null();
    public static final OreBase ORE_TITANIUM = _null();
    public static final OreBase ORE_URANIUM = _null();
    public static final OreBase ORE_PLATINUM = _null();
    public static final OreBase ORE_OLIVINE = _null();
    public static final OreBase ORE_JADE = _null();
    public static final OreBase ORE_TOPAZ = _null();
    public static final OreBase ORE_GOLD = _null();
    public static final OreBase ORE_SILVER = _null();
    public static final OreBase ORE_REDSTONE = _null();
    public static final OreBase ORE_LAPIS = _null();
    public static final OreBase ORE_SULFUR = _null();
    public static final OreBase ORE_TIN = _null();
    public static final OreBase ORE_COPPER = _null();
    public static final OreBase ORE_IRON = _null();
    public static final OreBase ORE_LEAD = _null();
    public static final OreBase ORE_ZINC = _null();
    public static final OreBase ORE_ALUMINIUM = _null();
    public static final OreBase ORE_SILICON = _null();
    public static final OreBase ORE_COAL = _null();

    public static final Crustrock CRUSTROCK_VERYSMALL_ONYX = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_MAJORITE = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_BRIGMANITE = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_RINGWOODITE = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_AMAZONITE = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_DIAMOND = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_SAPPHIRE = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_WADSLEYITE = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_RUBY = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_TUNGSTEN = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_EMERALD = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_TITANIUM = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_URANIUM = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_PLATINUM = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_OLIVINE = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_JADE = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_TOPAZ = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_GOLD = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_SILVER = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_REDSTONE = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_LAPIS = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_SULFUR = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_TIN = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_COPPER = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_IRON = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_LEAD = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_ZINC = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_ALUMINIUM = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_SILICON = _null();
    public static final Crustrock CRUSTROCK_VERYSMALL_COAL = _null();

    public static final Crustrock CRUSTROCK_SMALL_ONYX = _null();
    public static final Crustrock CRUSTROCK_SMALL_MAJORITE = _null();
    public static final Crustrock CRUSTROCK_SMALL_BRIGMANITE = _null();
    public static final Crustrock CRUSTROCK_SMALL_RINGWOODITE = _null();
    public static final Crustrock CRUSTROCK_SMALL_AMAZONITE = _null();
    public static final Crustrock CRUSTROCK_SMALL_DIAMOND = _null();
    public static final Crustrock CRUSTROCK_SMALL_SAPPHIRE = _null();
    public static final Crustrock CRUSTROCK_SMALL_WADSLEYITE = _null();
    public static final Crustrock CRUSTROCK_SMALL_RUBY = _null();
    public static final Crustrock CRUSTROCK_SMALL_TUNGSTEN = _null();
    public static final Crustrock CRUSTROCK_SMALL_EMERALD = _null();
    public static final Crustrock CRUSTROCK_SMALL_TITANIUM = _null();
    public static final Crustrock CRUSTROCK_SMALL_URANIUM = _null();
    public static final Crustrock CRUSTROCK_SMALL_PLATINUM = _null();
    public static final Crustrock CRUSTROCK_SMALL_OLIVINE = _null();
    public static final Crustrock CRUSTROCK_SMALL_JADE = _null();
    public static final Crustrock CRUSTROCK_SMALL_TOPAZ = _null();
    public static final Crustrock CRUSTROCK_SMALL_GOLD = _null();
    public static final Crustrock CRUSTROCK_SMALL_SILVER = _null();
    public static final Crustrock CRUSTROCK_SMALL_REDSTONE = _null();
    public static final Crustrock CRUSTROCK_SMALL_LAPIS = _null();
    public static final Crustrock CRUSTROCK_SMALL_SULFUR = _null();
    public static final Crustrock CRUSTROCK_SMALL_TIN = _null();
    public static final Crustrock CRUSTROCK_SMALL_COPPER = _null();
    public static final Crustrock CRUSTROCK_SMALL_IRON = _null();
    public static final Crustrock CRUSTROCK_SMALL_LEAD = _null();
    public static final Crustrock CRUSTROCK_SMALL_ZINC = _null();
    public static final Crustrock CRUSTROCK_SMALL_ALUMINIUM = _null();
    public static final Crustrock CRUSTROCK_SMALL_SILICON = _null();
    public static final Crustrock CRUSTROCK_SMALL_COAL = _null();

    public static final Crustrock CRUSTROCK_ONYX = _null();
    public static final Crustrock CRUSTROCK_MAJORITE = _null();
    public static final Crustrock CRUSTROCK_BRIGMANITE = _null();
    public static final Crustrock CRUSTROCK_RINGWOODITE = _null();
    public static final Crustrock CRUSTROCK_AMAZONITE = _null();
    public static final Crustrock CRUSTROCK_DIAMOND = _null();
    public static final Crustrock CRUSTROCK_SAPPHIRE = _null();
    public static final Crustrock CRUSTROCK_WADSLEYITE = _null();
    public static final Crustrock CRUSTROCK_RUBY = _null();
    public static final Crustrock CRUSTROCK_TUNGSTEN = _null();
    public static final Crustrock CRUSTROCK_EMERALD = _null();
    public static final Crustrock CRUSTROCK_TITANIUM = _null();
    public static final Crustrock CRUSTROCK_URANIUM = _null();
    public static final Crustrock CRUSTROCK_PLATINUM = _null();
    public static final Crustrock CRUSTROCK_OLIVINE = _null();
    public static final Crustrock CRUSTROCK_JADE = _null();
    public static final Crustrock CRUSTROCK_TOPAZ = _null();
    public static final Crustrock CRUSTROCK_GOLD = _null();
    public static final Crustrock CRUSTROCK_SILVER = _null();
    public static final Crustrock CRUSTROCK_REDSTONE = _null();
    public static final Crustrock CRUSTROCK_LAPIS = _null();
    public static final Crustrock CRUSTROCK_SULFUR = _null();
    public static final Crustrock CRUSTROCK_TIN = _null();
    public static final Crustrock CRUSTROCK_COPPER = _null();
    public static final Crustrock CRUSTROCK_IRON = _null();
    public static final Crustrock CRUSTROCK_LEAD = _null();
    public static final Crustrock CRUSTROCK_ZINC = _null();
    public static final Crustrock CRUSTROCK_ALUMINIUM = _null();
    public static final Crustrock CRUSTROCK_SILICON = _null();
    public static final Crustrock CRUSTROCK_COAL = _null();
    public static final Crustrock CRUSTROCK = _null();

    public static final Crustrock CRUSTROCK_COMPACT_ONYX = _null();
    public static final Crustrock CRUSTROCK_COMPACT_MAJORITE = _null();
    public static final Crustrock CRUSTROCK_COMPACT_BRIGMANITE = _null();
    public static final Crustrock CRUSTROCK_COMPACT_RINGWOODITE = _null();
    public static final Crustrock CRUSTROCK_COMPACT_AMAZONITE = _null();
    public static final Crustrock CRUSTROCK_COMPACT_DIAMOND = _null();
    public static final Crustrock CRUSTROCK_COMPACT_SAPPHIRE = _null();
    public static final Crustrock CRUSTROCK_COMPACT_WADSLEYITE = _null();
    public static final Crustrock CRUSTROCK_COMPACT_RUBY = _null();
    public static final Crustrock CRUSTROCK_COMPACT_TUNGSTEN = _null();
    public static final Crustrock CRUSTROCK_COMPACT_EMERALD = _null();
    public static final Crustrock CRUSTROCK_COMPACT_TITANIUM = _null();
    public static final Crustrock CRUSTROCK_COMPACT_URANIUM = _null();
    public static final Crustrock CRUSTROCK_COMPACT_PLATINUM = _null();
    public static final Crustrock CRUSTROCK_COMPACT_OLIVINE = _null();
    public static final Crustrock CRUSTROCK_COMPACT_JADE = _null();
    public static final Crustrock CRUSTROCK_COMPACT_TOPAZ = _null();
    public static final Crustrock CRUSTROCK_COMPACT_GOLD = _null();
    public static final Crustrock CRUSTROCK_COMPACT_SILVER = _null();
    public static final Crustrock CRUSTROCK_COMPACT_REDSTONE = _null();
    public static final Crustrock CRUSTROCK_COMPACT_LAPIS = _null();
    public static final Crustrock CRUSTROCK_COMPACT_SULFUR = _null();
    public static final Crustrock CRUSTROCK_COMPACT_TIN = _null();
    public static final Crustrock CRUSTROCK_COMPACT_COPPER = _null();
    public static final Crustrock CRUSTROCK_COMPACT_IRON = _null();
    public static final Crustrock CRUSTROCK_COMPACT_LEAD = _null();
    public static final Crustrock CRUSTROCK_COMPACT_ZINC = _null();
    public static final Crustrock CRUSTROCK_COMPACT_ALUMINIUM = _null();
    public static final Crustrock CRUSTROCK_COMPACT_SILICON = _null();
    public static final Crustrock CRUSTROCK_COMPACT_COAL = _null();

    public static final Crustrock CRUSTROCK_VERYCOMPACT_ONYX = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_MAJORITE = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_BRIGMANITE = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_RINGWOODITE = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_AMAZONITE = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_DIAMOND = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_SAPPHIRE = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_WADSLEYITE = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_RUBY = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_TUNGSTEN = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_EMERALD = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_TITANIUM = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_URANIUM = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_PLATINUM = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_OLIVINE = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_JADE = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_TOPAZ = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_GOLD = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_SILVER = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_REDSTONE = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_LAPIS = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_SULFUR = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_TIN = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_COPPER = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_IRON = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_LEAD = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_ZINC = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_ALUMINIUM = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_SILICON = _null();
    public static final Crustrock CRUSTROCK_VERYCOMPACT_COAL = _null();

    public static final Mantlerock MANTLEROCK_VERYSMALL_ONYX = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_MAJORITE = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_BRIGMANITE = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_RINGWOODITE = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_AMAZONITE = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_DIAMOND = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_SAPPHIRE = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_WADSLEYITE = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_RUBY = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_TUNGSTEN = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_EMERALD = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_TITANIUM = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_URANIUM = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_PLATINUM = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_OLIVINE = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_JADE = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_TOPAZ = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_GOLD = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_SILVER = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_REDSTONE = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_LAPIS = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_SULFUR = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_TIN = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_COPPER = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_IRON = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_LEAD = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_ZINC = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_ALUMINIUM = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_SILICON = _null();
    public static final Mantlerock MANTLEROCK_VERYSMALL_COAL = _null();

    public static final Mantlerock MANTLEROCK_SMALL_ONYX = _null();
    public static final Mantlerock MANTLEROCK_SMALL_MAJORITE = _null();
    public static final Mantlerock MANTLEROCK_SMALL_BRIGMANITE = _null();
    public static final Mantlerock MANTLEROCK_SMALL_RINGWOODITE = _null();
    public static final Mantlerock MANTLEROCK_SMALL_AMAZONITE = _null();
    public static final Mantlerock MANTLEROCK_SMALL_DIAMOND = _null();
    public static final Mantlerock MANTLEROCK_SMALL_SAPPHIRE = _null();
    public static final Mantlerock MANTLEROCK_SMALL_WADSLEYITE = _null();
    public static final Mantlerock MANTLEROCK_SMALL_RUBY = _null();
    public static final Mantlerock MANTLEROCK_SMALL_TUNGSTEN = _null();
    public static final Mantlerock MANTLEROCK_SMALL_EMERALD = _null();
    public static final Mantlerock MANTLEROCK_SMALL_TITANIUM = _null();
    public static final Mantlerock MANTLEROCK_SMALL_URANIUM = _null();
    public static final Mantlerock MANTLEROCK_SMALL_PLATINUM = _null();
    public static final Mantlerock MANTLEROCK_SMALL_OLIVINE = _null();
    public static final Mantlerock MANTLEROCK_SMALL_JADE = _null();
    public static final Mantlerock MANTLEROCK_SMALL_TOPAZ = _null();
    public static final Mantlerock MANTLEROCK_SMALL_GOLD = _null();
    public static final Mantlerock MANTLEROCK_SMALL_SILVER = _null();
    public static final Mantlerock MANTLEROCK_SMALL_REDSTONE = _null();
    public static final Mantlerock MANTLEROCK_SMALL_LAPIS = _null();
    public static final Mantlerock MANTLEROCK_SMALL_SULFUR = _null();
    public static final Mantlerock MANTLEROCK_SMALL_TIN = _null();
    public static final Mantlerock MANTLEROCK_SMALL_COPPER = _null();
    public static final Mantlerock MANTLEROCK_SMALL_IRON = _null();
    public static final Mantlerock MANTLEROCK_SMALL_LEAD = _null();
    public static final Mantlerock MANTLEROCK_SMALL_ZINC = _null();
    public static final Mantlerock MANTLEROCK_SMALL_ALUMINIUM = _null();
    public static final Mantlerock MANTLEROCK_SMALL_SILICON = _null();
    public static final Mantlerock MANTLEROCK_SMALL_COAL = _null();

    public static final Mantlerock MANTLEROCK_ONYX = _null();
    public static final Mantlerock MANTLEROCK_MAJORITE = _null();
    public static final Mantlerock MANTLEROCK_BRIGMANITE = _null();
    public static final Mantlerock MANTLEROCK_RINGWOODITE = _null();
    public static final Mantlerock MANTLEROCK_AMAZONITE = _null();
    public static final Mantlerock MANTLEROCK_DIAMOND = _null();
    public static final Mantlerock MANTLEROCK_SAPPHIRE = _null();
    public static final Mantlerock MANTLEROCK_WADSLEYITE = _null();
    public static final Mantlerock MANTLEROCK_RUBY = _null();
    public static final Mantlerock MANTLEROCK_TUNGSTEN = _null();
    public static final Mantlerock MANTLEROCK_EMERALD = _null();
    public static final Mantlerock MANTLEROCK_TITANIUM = _null();
    public static final Mantlerock MANTLEROCK_URANIUM = _null();
    public static final Mantlerock MANTLEROCK_PLATINUM = _null();
    public static final Mantlerock MANTLEROCK_OLIVINE = _null();
    public static final Mantlerock MANTLEROCK_JADE = _null();
    public static final Mantlerock MANTLEROCK_TOPAZ = _null();
    public static final Mantlerock MANTLEROCK_GOLD = _null();
    public static final Mantlerock MANTLEROCK_SILVER = _null();
    public static final Mantlerock MANTLEROCK_REDSTONE = _null();
    public static final Mantlerock MANTLEROCK_LAPIS = _null();
    public static final Mantlerock MANTLEROCK_SULFUR = _null();
    public static final Mantlerock MANTLEROCK_TIN = _null();
    public static final Mantlerock MANTLEROCK_COPPER = _null();
    public static final Mantlerock MANTLEROCK_IRON = _null();
    public static final Mantlerock MANTLEROCK_LEAD = _null();
    public static final Mantlerock MANTLEROCK_ZINC = _null();
    public static final Mantlerock MANTLEROCK_ALUMINIUM = _null();
    public static final Mantlerock MANTLEROCK_SILICON = _null();
    public static final Mantlerock MANTLEROCK_COAL = _null();
    public static final Mantlerock MANTLEROCK = _null();

    public static final Mantlerock MANTLEROCK_COMPACT_ONYX = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_MAJORITE = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_BRIGMANITE = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_RINGWOODITE = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_AMAZONITE = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_DIAMOND = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_SAPPHIRE = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_WADSLEYITE = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_RUBY = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_TUNGSTEN = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_EMERALD = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_TITANIUM = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_URANIUM = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_PLATINUM = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_OLIVINE = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_JADE = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_TOPAZ = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_GOLD = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_SILVER = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_REDSTONE = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_LAPIS = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_SULFUR = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_TIN = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_COPPER = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_IRON = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_LEAD = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_ZINC = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_ALUMINIUM = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_SILICON = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_COAL = _null();

    public static final Mantlerock MANTLEROCK_VERYCOMPACT_ONYX = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_MAJORITE = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_BRIGMANITE = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_RINGWOODITE = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_AMAZONITE = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_DIAMOND = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_SAPPHIRE = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_WADSLEYITE = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_RUBY = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_TUNGSTEN = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_EMERALD = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_TITANIUM = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_URANIUM = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_PLATINUM = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_OLIVINE = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_JADE = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_TOPAZ = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_GOLD = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_SILVER = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_REDSTONE = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_LAPIS = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_SULFUR = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_TIN = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_COPPER = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_IRON = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_LEAD = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_ZINC = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_ALUMINIUM = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_SILICON = _null();
    public static final Mantlerock MANTLEROCK_VERYCOMPACT_COAL = _null();

    public static final Corerock CORESTONE_VERYSMALL_ONYX = _null();
    public static final Corerock CORESTONE_VERYSMALL_MAJORITE = _null();
    public static final Corerock CORESTONE_VERYSMALL_BRIGMANITE = _null();
    public static final Corerock CORESTONE_VERYSMALL_RINGWOODITE = _null();
    public static final Corerock CORESTONE_VERYSMALL_AMAZONITE = _null();
    public static final Corerock CORESTONE_VERYSMALL_DIAMOND = _null();
    public static final Corerock CORESTONE_VERYSMALL_SAPPHIRE = _null();
    public static final Corerock CORESTONE_VERYSMALL_WADSLEYITE = _null();
    public static final Corerock CORESTONE_VERYSMALL_RUBY = _null();
    public static final Corerock CORESTONE_VERYSMALL_EMERALD = _null();
    public static final Corerock CORESTONE_VERYSMALL_OLIVINE = _null();
    public static final Corerock CORESTONE_VERYSMALL_JADE = _null();
    public static final Corerock CORESTONE_VERYSMALL_TOPAZ = _null();
    public static final Corerock CORESTONE_VERYSMALL_REDSTONE = _null();
    public static final Corerock CORESTONE_VERYSMALL_LAPIS = _null();

    public static final Corerock CORESTONE_SMALL_ONYX = _null();
    public static final Corerock CORESTONE_SMALL_MAJORITE = _null();
    public static final Corerock CORESTONE_SMALL_BRIGMANITE = _null();
    public static final Corerock CORESTONE_SMALL_RINGWOODITE = _null();
    public static final Corerock CORESTONE_SMALL_AMAZONITE = _null();
    public static final Corerock CORESTONE_SMALL_DIAMOND = _null();
    public static final Corerock CORESTONE_SMALL_SAPPHIRE = _null();
    public static final Corerock CORESTONE_SMALL_WADSLEYITE = _null();
    public static final Corerock CORESTONE_SMALL_RUBY = _null();
    public static final Corerock CORESTONE_SMALL_EMERALD = _null();
    public static final Corerock CORESTONE_SMALL_OLIVINE = _null();
    public static final Corerock CORESTONE_SMALL_JADE = _null();
    public static final Corerock CORESTONE_SMALL_TOPAZ = _null();
    public static final Corerock CORESTONE_SMALL_REDSTONE = _null();
    public static final Corerock CORESTONE_SMALL_LAPIS = _null();

    public static final Corerock CORESTONE_ONYX = _null();
    public static final Corerock CORESTONE_MAJORITE = _null();
    public static final Corerock CORESTONE_BRIGMANITE = _null();
    public static final Corerock CORESTONE_RINGWOODITE = _null();
    public static final Corerock CORESTONE_AMAZONITE = _null();
    public static final Corerock CORESTONE_DIAMOND = _null();
    public static final Corerock CORESTONE_SAPPHIRE = _null();
    public static final Corerock CORESTONE_WADSLEYITE = _null();
    public static final Corerock CORESTONE_RUBY = _null();
    public static final Corerock CORESTONE_EMERALD = _null();
    public static final Corerock CORESTONE_OLIVINE = _null();
    public static final Corerock CORESTONE_JADE = _null();
    public static final Corerock CORESTONE_TOPAZ = _null();
    public static final Corerock CORESTONE_REDSTONE = _null();
    public static final Corerock CORESTONE_LAPIS = _null();
    public static final Corerock CORESTONE = _null();

    public static final Corerock CORESTONE_COMPACT_ONYX = _null();
    public static final Corerock CORESTONE_COMPACT_MAJORITE = _null();
    public static final Corerock CORESTONE_COMPACT_BRIGMANITE = _null();
    public static final Corerock CORESTONE_COMPACT_RINGWOODITE = _null();
    public static final Corerock CORESTONE_COMPACT_AMAZONITE = _null();
    public static final Corerock CORESTONE_COMPACT_DIAMOND = _null();
    public static final Corerock CORESTONE_COMPACT_SAPPHIRE = _null();
    public static final Corerock CORESTONE_COMPACT_WADSLEYITE = _null();
    public static final Corerock CORESTONE_COMPACT_RUBY = _null();
    public static final Corerock CORESTONE_COMPACT_EMERALD = _null();
    public static final Corerock CORESTONE_COMPACT_OLIVINE = _null();
    public static final Corerock CORESTONE_COMPACT_JADE = _null();
    public static final Corerock CORESTONE_COMPACT_TOPAZ = _null();
    public static final Corerock CORESTONE_COMPACT_REDSTONE = _null();
    public static final Corerock CORESTONE_COMPACT_LAPIS = _null();

    public static final Corerock CORESTONE_VERYCOMPACT_ONYX = _null();
    public static final Corerock CORESTONE_VERYCOMPACT_MAJORITE = _null();
    public static final Corerock CORESTONE_VERYCOMPACT_BRIGMANITE = _null();
    public static final Corerock CORESTONE_VERYCOMPACT_RINGWOODITE = _null();
    public static final Corerock CORESTONE_VERYCOMPACT_AMAZONITE = _null();
    public static final Corerock CORESTONE_VERYCOMPACT_DIAMOND = _null();
    public static final Corerock CORESTONE_VERYCOMPACT_SAPPHIRE = _null();
    public static final Corerock CORESTONE_VERYCOMPACT_WADSLEYITE = _null();
    public static final Corerock CORESTONE_VERYCOMPACT_RUBY = _null();
    public static final Corerock CORESTONE_VERYCOMPACT_EMERALD = _null();
    public static final Corerock CORESTONE_VERYCOMPACT_OLIVINE = _null();
    public static final Corerock CORESTONE_VERYCOMPACT_JADE = _null();
    public static final Corerock CORESTONE_VERYCOMPACT_TOPAZ = _null();
    public static final Corerock CORESTONE_VERYCOMPACT_REDSTONE = _null();
    public static final Corerock CORESTONE_VERYCOMPACT_LAPIS = _null();

    // GENERATED END

    public static final Block STEEL_BLOCK = _null();

    //SEDIMENTARY ROCK

    public static final Block LIMESTONE = _null();

    public static List<Block> AllCrustBlocks = new ArrayList<>();
    public static List<Block> AllMantleBlocks = new ArrayList<>();
    public static List<Block> AllCoreBlocks = new ArrayList<>();


    public static void register(IForgeRegistry<Block> registry) {

        boolean generateHolders = System.getProperty("planetcore.generate_holders", "false").equalsIgnoreCase("true");


        StringBuilder holderGenString = generateHolders ? new StringBuilder(64 * 1024) : null;

        for (ModBlocks.OreForm oreForm : ModBlocks.OreForm.values()) {

            for (ModBlocks.Ore ore : ModBlocks.Ore.values()) {


                if (!((oreForm == OreForm.CORESTONE || oreForm == OreForm.CORESTONE_VERYSMALL || oreForm == OreForm.CORESTONE_SMALL
                        || oreForm == OreForm.CORESTONE_COMPACT || oreForm == OreForm.CORESTONE_VERYCOMPACT) && ore.type == METAL)) {
                    String registryName;
                    registryName = oreForm.name().toLowerCase(Locale.ROOT) + "_" + ore.name().toLowerCase(Locale.ROOT);
                    Block block = oreForm.makeBlock(registryName);

                    block.setHardness((float) (ore.getOreHardness() + (oreForm.getBaseHardness())));

                    block.setResistance((float) (ore.getOreResistance() + (oreForm.getBaseResistance())));

                    registry.register(block);
                    if (oreForm == ModBlocks.OreForm.CRUSTROCK_VERYSMALL || oreForm == ModBlocks.OreForm.CRUSTROCK_SMALL || oreForm == ModBlocks.OreForm.CRUSTROCK
                            || oreForm == ModBlocks.OreForm.CRUSTROCK_COMPACT || oreForm == ModBlocks.OreForm.CRUSTROCK_VERYCOMPACT) {
                        AllCrustBlocks.add(block);
                    }
                    if (oreForm == ModBlocks.OreForm.MANTLEROCK_VERYSMALL || oreForm == ModBlocks.OreForm.MANTLEROCK_SMALL || oreForm == ModBlocks.OreForm.MANTLEROCK
                            || oreForm == ModBlocks.OreForm.MANTLEROCK_COMPACT || oreForm == ModBlocks.OreForm.MANTLEROCK_VERYCOMPACT) {
                        AllMantleBlocks.add(block);
                    }
                    if (oreForm == ModBlocks.OreForm.CORESTONE_VERYSMALL || oreForm == ModBlocks.OreForm.CORESTONE_SMALL || oreForm == ModBlocks.OreForm.CORESTONE
                            || oreForm == ModBlocks.OreForm.CORESTONE_COMPACT || oreForm == ModBlocks.OreForm.CORESTONE_VERYCOMPACT) {
                        AllCoreBlocks.add(block);
                    }
                    if (generateHolders) {
                        holderGenString.append("public static final ").append(block.getClass().getSimpleName())
                                .append(" ").append(block.getRegistryName().getPath().toUpperCase(Locale.ROOT)).append(" = _null();\n");
                    }
                }

            }
            if (oreForm == OreForm.CRUSTROCK || oreForm == OreForm.MANTLEROCK || oreForm == OreForm.CORESTONE) {
                String registryName;
                registryName = oreForm.name().toLowerCase(Locale.ROOT);
                Block block = oreForm.makeBlock(registryName);
                block.setHardness((float) oreForm.getBaseHardness());
                block.setResistance((float) oreForm.getBaseResistance());
                registry.register(block);
                if (oreForm == OreForm.CRUSTROCK) {
                    AllCrustBlocks.add(block);
                }
                if (oreForm == OreForm.MANTLEROCK) {
                    AllMantleBlocks.add(block);
                }
                if (oreForm == OreForm.CORESTONE) {
                    AllCoreBlocks.add(block);
                }
                if (generateHolders) {
                    holderGenString.append("public static final ").append(block.getClass().getSimpleName())
                            .append(" ").append(block.getRegistryName().getPath().toUpperCase(Locale.ROOT)).append(" = _null();\n");
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
                new OreBase("limestone", Material.ROCK)
        );
    }

    public static void registerRenders() {

        for (Block block : AllCrustBlocks) {
            for (int meta = 0; meta < 3; meta++) {
                if (block == ModBlocks.CRUSTROCK) {
                    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                            new ModelResourceLocation(Reference.MOD_ID + ":" + Crustrock.EnumType.values()[meta].getName(), "inventory"));
                }
                else {
                    String name = block.getRegistryName().toString();
                    String removeRocktype = name.replace("crustrock_", "");
                    String ore = removeRocktype.replace("planetcore:", "");
                    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                            new ModelResourceLocation(Reference.MOD_ID + ":" + Crustrock.EnumType.values()[meta].getName() + "_" + ore, "inventory"));
                }
            }
        }
        for (Block block : AllMantleBlocks) {
            for (int meta = 0; meta < 16; meta++) {
                if (block == ModBlocks.MANTLEROCK) {
                    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                            new ModelResourceLocation(Reference.MOD_ID + ":" + Mantlerock.EnumType.values()[meta].getName(), "inventory"));
                }
                else {
                    String name = block.getRegistryName().toString();
                    String removeRocktype = name.replace("mantlerock_", "");
                    String ore = removeRocktype.replace("planetcore:", "");
                    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                            new ModelResourceLocation(Reference.MOD_ID + ":" + Mantlerock.EnumType.values()[meta].getName() + "_" + ore, "inventory"));
                }
            }
        }
        for (Block block : AllCoreBlocks) {
            for (int meta = 0; meta < 3; meta++) {
                if (block == ModBlocks.CORESTONE) {
                    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                            new ModelResourceLocation(Reference.MOD_ID + ":" + Corerock.EnumType.values()[meta].getName(), "inventory"));
                }
                else {
                    String name = block.getRegistryName().toString();
                    String removeRocktype = name.replace("corestone_", "");
                    String ore = removeRocktype.replace("planetcore:", "");
                    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                            new ModelResourceLocation(Reference.MOD_ID + ":" + Corerock.EnumType.values()[meta].getName() + "_" + ore, "inventory"));
                }
            }
        }
    }
}