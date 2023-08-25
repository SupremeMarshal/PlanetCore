package com.PlanetCore.init;


import com.PlanetCore.blocks.*;
import com.PlanetCore.blocks.Powered_ladders.Powered_ladders;
import com.PlanetCore.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;

import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;


@ObjectHolder(Reference.MOD_ID)

public class ModBlocks {

    public static List<Block> BLOCKS = new ArrayList<>(); // being final breaks ObjectHolder, either move to separate class or keep non-final


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

    @ObjectHolder("iron_lava")
    public static final IronLavaFluid IRON_LAVA_FLUID = _null();
    @ObjectHolder("redstone_lava")
    public static final MetalLavaFluid REDSTONE_LAVA_FLUID = _null();
    @ObjectHolder("silver_lava")
    public static final MetalLavaFluid SILVER_LAVA_FLUID = _null();
    @ObjectHolder("gold_lava")
    public static final MetalLavaFluid GOLD_LAVA_FLUID = _null();
    @ObjectHolder("diamond_lava")
    public static final GemLavaFluid DIAMOND_LAVA_FLUID = _null();
    @ObjectHolder("titanium_lava")
    public static final MetalLavaFluid TITANIUM_LAVA_FLUID = _null();
    @ObjectHolder("uranium_lava")
    public static final MetalLavaFluid URANIUM_LAVA_FLUID = _null();
    @ObjectHolder("tungsten_lava")
    public static final MetalLavaFluid TUNGSTEN_LAVA_FLUID = _null();
    @ObjectHolder("ruby_lava")
    public static final GemLavaFluid RUBY_LAVA_FLUID = _null();
    @ObjectHolder("sapphire_lava")
    public static final GemLavaFluid SAPPHIRE_LAVA_FLUID = _null();
    @ObjectHolder("majorite_lava")
    public static final GemLavaFluid MAJORITE_LAVA_FLUID = _null();
    @ObjectHolder("amazonite_lava")
    public static final GemLavaFluid AMAZONITE_LAVA_FLUID = _null();
    @ObjectHolder("onyx_lava")
    public static final GemLavaFluid ONYX_LAVA_FLUID = _null();
    @ObjectHolder("painite_lava")
    public static final GemLavaFluid PAINITE_LAVA_FLUID = _null();

    public static final BlockAirNoPressure AIR_NO_PRESSURE = _null();

    public static final Crustrock CRUSTROCK = _null();
    public static final Mantlerock MANTLEROCK = _null();
    public static final Corestone CORESTONE = _null();

    public static final HotRocks GRANITE = _null();
    public static final HotRocks DIORITE = _null();
    public static final HotRocks ANDESITE = _null();

    public static final Powered_ladders IRON_LADDERS = _null();
    public static final Powered_ladders DIAMOND_LADDERS = _null();

    public static final GemsGravel RUBY_GRAVEL = _null();
    public static final GemsGravel SAPPHIRE_GRAVEL = _null();
    public static final GemsGravel DIAMOND_GRAVEL = _null();
    public static final GemsGravel MAJORITE_GRAVEL = _null();
    public static final GemsGravel AMAZONITE_GRAVEL = _null();
    public static final GemsGravel ONYX_GRAVEL = _null();

    public static final OreBase ORE_IRON = _null();
    public static final OreBase ORE_SILVER = _null();
    public static final OreBase ORE_GOLD = _null();
    public static final OreBase ORE_DIAMOND = _null();
    public static final OreBase ORE_SULFUR = _null();

    public static final OreCompactBase ORE_COMPACT_COAL = _null();
    public static final OreCompactBase ORE_COMPACT_IRON = _null();
    public static final OreCompactBase ORE_COMPACT_SILVER = _null();
    public static final OreCompactBase ORE_COMPACT_GOLD = _null();
    public static final OreCompactBase ORE_COMPACT_EMERALD = _null();
    public static final OreCompactBase ORE_COMPACT_DIAMOND = _null();
    public static final OreCompactBase ORE_COMPACT_LAPIS = _null();
    public static final OreCompactBase ORE_COMPACT_REDSTONE = _null();
    public static final OreCompactBase ORE_COMPACT_SULFUR = _null();

    public static final CrustrockOre CRUSTROCK_COAL = _null();
    public static final CrustrockOre CRUSTROCK_SULFUR = _null();
    public static final CrustrockOre CRUSTROCK_REDSTONE = _null();
    public static final CrustrockOre CRUSTROCK_LAPIS = _null();
    public static final CrustrockOre CRUSTROCK_IRON = _null();
    public static final CrustrockOre CRUSTROCK_SILVER = _null();
    public static final CrustrockOre CRUSTROCK_GOLD = _null();
    public static final CrustrockOre CRUSTROCK_EMERALD = _null();
    public static final CrustrockOre CRUSTROCK_DIAMOND = _null();
    public static final CrustrockOre CRUSTROCK_TITANIUM = _null();
    public static final CrustrockOre CRUSTROCK_URANIUM = _null();
    public static final CrustrockOre CRUSTROCK_TUNGSTEN = _null();

    public static final CrustrockOreCompact CRUSTROCK_COMPACT_COAL = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_SULFUR = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_REDSTONE = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_LAPIS = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_IRON = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_SILVER = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_GOLD = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_EMERALD = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_DIAMOND = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_TITANIUM = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_URANIUM = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_TUNGSTEN = _null();

    public static final MantlerockOre MANTLEROCK_COAL = _null();
    public static final MantlerockOre MANTLEROCK_SULFUR = _null();
    public static final MantlerockOre MANTLEROCK_REDSTONE = _null();
    public static final MantlerockOre MANTLEROCK_LAPIS = _null();
    public static final MantlerockOre MANTLEROCK_IRON = _null();
    public static final MantlerockOre MANTLEROCK_SILVER = _null();
    public static final MantlerockOre MANTLEROCK_GOLD = _null();
    public static final MantlerockOre MANTLEROCK_TITANIUM = _null();
    public static final MantlerockOre MANTLEROCK_URANIUM = _null();
    public static final MantlerockOre MANTLEROCK_TUNGSTEN = _null();
    public static final MantlerockOre MANTLEROCK_RUBY = _null();
    public static final MantlerockOre MANTLEROCK_SAPPHIRE = _null();
    public static final MantlerockOre MANTLEROCK_EMERALD = _null();
    public static final MantlerockOre MANTLEROCK_DIAMOND = _null();
    public static final MantlerockOre MANTLEROCK_MAJORITE = _null();
    public static final MantlerockOre MANTLEROCK_AMAZONITE = _null();
    public static final MantlerockOre MANTLEROCK_ONYX = _null();
    public static final MantlerockOre MANTLEROCK_PAINITE = _null();

    public static final MantlerockOreCompact MANTLEROCK_COMPACT_COAL = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_SULFUR = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_REDSTONE = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_LAPIS = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_IRON = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_SILVER = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_GOLD = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_TITANIUM = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_URANIUM = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_TUNGSTEN = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_RUBY = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_SAPPHIRE = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_EMERALD = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_DIAMOND = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_MAJORITE = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_AMAZONITE = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_ONYX = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_PAINITE = _null();

    public static final CorestoneOre CORESTONE_COAL = _null();
    public static final CorestoneOre CORESTONE_SULFUR = _null();
    public static final CorestoneOre CORESTONE_REDSTONE = _null();
    public static final CorestoneOre CORESTONE_LAPIS = _null();
    public static final CorestoneOre CORESTONE_IRON = _null();
    public static final CorestoneOre CORESTONE_SILVER = _null();
    public static final CorestoneOre CORESTONE_GOLD = _null();
    public static final CorestoneOre CORESTONE_TITANIUM = _null();
    public static final CorestoneOre CORESTONE_URANIUM = _null();
    public static final CorestoneOre CORESTONE_TUNGSTEN = _null();
    public static final CorestoneOre CORESTONE_EMERALD = _null();
    public static final CorestoneOre CORESTONE_RUBY = _null();
    public static final CorestoneOre CORESTONE_SAPPHIRE = _null();
    public static final CorestoneOre CORESTONE_DIAMOND = _null();
    public static final CorestoneOre CORESTONE_OLIVINE = _null();
    public static final CorestoneOre CORESTONE_WADSLEYITE = _null();
    public static final CorestoneOre CORESTONE_RINGWOODITE = _null();
    public static final CorestoneOre CORESTONE_BRIGMANITE = _null();
    public static final CorestoneOre CORESTONE_MAJORITE = _null();
    public static final CorestoneOre CORESTONE_AMAZONITE = _null();
    public static final CorestoneOre CORESTONE_ONYX = _null();
    public static final CorestoneOre CORESTONE_PAINITE = _null();

    public static final CorestoneOreCompact CORESTONE_COMPACT_COAL = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_SULFUR = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_REDSTONE = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_LAPIS = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_IRON = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_SILVER = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_GOLD = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_TITANIUM = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_URANIUM = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_TUNGSTEN = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_EMERALD = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_RUBY = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_SAPPHIRE = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_DIAMOND = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_OLIVINE = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_MAJORITE = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_AMAZONITE = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_ONYX = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_PAINITE = _null();

    public static final BlockBase PAINITE_BLOCK = _null();
    public static final BlockBase ONYX_BLOCK = _null();
    public static final BlockBase AMAZONITE_BLOCK = _null();
    public static final BlockBase MAJORITE_BLOCK = _null();
    public static final BlockBase SAPPHIRE_BLOCK = _null();
    public static final BlockBase RUBY_BLOCK = _null();
    public static final BlockBase TUNGSTEN_BLOCK = _null();
    public static final BlockBase TITANIUM_BLOCK = _null();
    public static final BlockBase URANIUM_BLOCK = _null();
    public static final BlockBase SILVER_BLOCK = _null();
    public static final BlockBase SULFUR_BLOCK = _null();

    public static final VeryHotRocks MANTLEROCK1_BOULDER = _null();
    public static final VeryHotRocks MANTLEROCK2_BOULDER = _null();
    public static final VeryHotRocks LOWER_MANTLEROCK_BOULDER = _null();
    public static final VeryHotRocks LOWER_MANTLEROCK1_BOULDER = _null();
    public static final VeryHotRocks LOWER_MANTLEROCK2_BOULDER = _null();
    public static final SuperheatedRocks OUTERCORE_BOULDER = _null();
    public static final SuperheatedRocks INNERCORE_BOULDER = _null();
    public static final SuperheatedRocks CENTERCORE_BOULDER = _null();
    public static final SuperheatedRocks SUPERHEATED_BEDROCK = _null();

    public static final BlocksBase SUPERCOMPRESSED_PAINITE = _null();
    public static final BlocksBase SUPERCOMPRESSED_ONYX = _null();
    public static final BlocksBase SUPERCOMPRESSED_AMAZONITE = _null();
    public static final BlocksBase SUPERCOMPRESSED_MAJORITE = _null();
    public static final BlocksBase SUPERCOMPRESSED_DIAMOND = _null();
    public static final BlocksBase SUPERCOMPRESSED_SAPPHIRE = _null();
    public static final BlocksBase SUPERCOMPRESSED_RUBY = _null();
    public static final BlocksBase SUPERCOMPRESSED_URANIUM = _null();
    public static final BlocksBase SUPERCOMPRESSED_TUNGSTEN = _null();
    public static final BlocksBase SUPERCOMPRESSED_TITANIUM = _null();
    public static final BlocksBase SUPERCOMPRESSED_EMERALD = _null();
    public static final BlocksBase SUPERCOMPRESSED_GOLD = _null();
    public static final BlocksBase SUPERCOMPRESSED_SILVER = _null();
    public static final BlocksBase SUPERCOMPRESSED_LAPIS = _null();
    public static final BlocksBase SUPERCOMPRESSED_REDSTONE = _null();
    public static final BlocksBase SUPERCOMPRESSED_SULFUR = _null();
    public static final BlocksBase SUPERCOMPRESSED_IRON = _null();
    public static final BlockBase SUPERCOMPRESSED_COAL = _null();

    public static final BlockBase CRUST_COBBLESTONE = _null();

    // GENERATED BEGIN

    public static final Corestone COLD_CORESTONE = _null();


    // GENERATED END

    public static void register(IForgeRegistry<Block> registry) {

        boolean generateHolders = System.getProperty("planetcore.generate_holders", "false").equalsIgnoreCase("true");


        /*
        Create a loop to get the coresponding blocks.
         */

        registry.registerAll(

                new Powered_ladders("iron_ladders"),
                new Powered_ladders("diamond_ladders"),
                new BlockAirNoPressure("air_no_pressure", Material.FIRE).setResistance(100000),
                new BlockBase("crust_cobblestone", Material.ROCK,false).setHardness(2.0F).setResistance(1),
                new SuperheatedRocks("superheated_bedrock", Material.ROCK, PlanetHardness.AMAZONITE).setResistance(1000000),
                new HotRocks("granite", Material.ROCK, PlanetHardness.HOT_ROCK).setResistance(2),
                new HotRocks("diorite", Material.ROCK, PlanetHardness.HOT_ROCK).setResistance(2),
                new HotRocks("andesite", Material.ROCK, PlanetHardness.HOT_ROCK).setResistance(2),
                new IronLavaFluid("iron_lava", ModFluids.IRON_LAVA_FLUID, Material.LAVA).setDensity(1500),
                new MetalLavaFluid("redstone_lava", ModFluids.REDSTONE_LAVA_FLUID, Material.LAVA).setDensity(1500),
                new MetalLavaFluid("silver_lava", ModFluids.SILVER_LAVA_FLUID, Material.LAVA).setDensity(1500),
                new MetalLavaFluid("gold_lava", ModFluids.GOLD_LAVA_FLUID, Material.LAVA).setDensity(1500),
                new GemLavaFluid("diamond_lava", ModFluids.DIAMOND_LAVA_FLUID, Material.LAVA).setDensity(1500),
                new MetalLavaFluid("titanium_lava", ModFluids.TITANIUM_LAVA_FLUID, Material.LAVA).setDensity(2000),
                new MetalLavaFluid("uranium_lava", ModFluids.URANIUM_LAVA_FLUID, Material.LAVA).setDensity(2000),
                new MetalLavaFluid("tungsten_lava", ModFluids.TUNGSTEN_LAVA_FLUID, Material.LAVA).setDensity(3000),
                new GemLavaFluid("ruby_lava", ModFluids.RUBY_LAVA_FLUID, Material.LAVA).setDensity(5000),
                new GemLavaFluid("sapphire_lava", ModFluids.SAPPHIRE_LAVA_FLUID, Material.LAVA).setDensity(6000),
                new GemLavaFluid("majorite_lava", ModFluids.MAJORITE_LAVA_FLUID, Material.LAVA).setDensity(12000),
                new GemLavaFluid("amazonite_lava", ModFluids.AMAZONITE_LAVA_FLUID, Material.LAVA).setDensity(13000),
                new GemLavaFluid("onyx_lava", ModFluids.ONYX_LAVA_FLUID, Material.LAVA).setDensity(14000),
                new GemLavaFluid("painite_lava", ModFluids.PAINITE_LAVA_FLUID, Material.LAVA).setDensity(1500),
                new GemsGravel("diamond_gravel", PlanetMaterial.DIAMOND_GRAVEL, PlanetHardness.DIAMOND),
                new GemsGravel("ruby_gravel", PlanetMaterial.RUBY_GRAVEL, PlanetHardness.RUBY),
                new GemsGravel("sapphire_gravel", PlanetMaterial.SAPPHIRE_GRAVEL, PlanetHardness.SAPPHIRE),
                new GemsGravel("majorite_gravel", PlanetMaterial.MAJORITE_GRAVEL, PlanetHardness.MAJORITE),
                new GemsGravel("amazonite_gravel", PlanetMaterial.AMAZONITE_GRAVEL, PlanetHardness.AMAZONITE),
                new GemsGravel("onyx_gravel", PlanetMaterial.ONYX_GRAVEL, PlanetHardness.ONYX),
                new VeryHotRocks("mantlerock1_boulder", Material.ROCK, PlanetHardness.HOT_ROCK).setResistance(1).setLightLevel(3),
                new VeryHotRocks("mantlerock2_boulder", Material.ROCK, PlanetHardness.HOT_ROCK).setResistance(1).setLightLevel(5),
                new VeryHotRocks("lower_mantlerock_boulder", Material.ROCK, PlanetHardness.HOT_ROCK).setResistance(1).setLightLevel(7),
                new VeryHotRocks("lower_mantlerock1_boulder", Material.ROCK, PlanetHardness.HOT_ROCK).setResistance(1).setLightLevel(9),
                new VeryHotRocks("lower_mantlerock2_boulder", Material.ROCK, PlanetHardness.HOT_ROCK).setResistance(1).setLightLevel(11),
                new SuperheatedRocks("outercore_boulder", Material.ROCK, PlanetHardness.HOT_ROCK).setResistance(1).setLightLevel(13),
                new SuperheatedRocks("innercore_boulder", Material.ROCK, PlanetHardness.HOT_ROCK).setResistance(1).setLightLevel(15),
                new SuperheatedRocks("centercore_boulder", Material.ROCK, PlanetHardness.HOT_ROCK).setResistance(1).setLightLevel(15),
                new BlockBase("sulfur_block", Material.ROCK,false).setHardness(1F).setResistance(1),
                new BlockBase("silver_block", Material.IRON,true).setHardness(15.0F).setResistance(1),
                new BlockBase("titanium_block", Material.IRON,true).setHardness(50F).setResistance(3),
                new BlockBase("uranium_block", Material.IRON,true).setHardness(75F).setResistance(4),
                new BlockBase("tungsten_block", Material.IRON,true).setHardness(250F).setResistance(5),
                new BlockBase("ruby_block", Material.IRON,true).setHardness(2000F).setResistance(7),
                new BlockBase("sapphire_block", Material.IRON,true).setHardness(3000F).setResistance(8),
                new BlockBase("majorite_block", Material.IRON,true).setHardness(33750F).setResistance(20),
                new BlockBase("amazonite_block", Material.IRON,true).setHardness(50000F).setResistance(25),
                new BlockBase("onyx_block", Material.IRON,true).setHardness(200000F).setResistance(30),
                new BlockBase("painite_block", Material.IRON,true).setHardness(1000000F).setResistance(30),
                new BlocksBase("supercompressed_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR_SUPERCOMPACT, PlanetExp.SULFUR_SUPERCOMPACT).setResistance(1),
                new BlocksBase("supercompressed_redstone", Material.ROCK, PlanetMaterial.REDSTONE, PlanetHardness.REDSTONE_SUPERCOMPACT, PlanetExp.REDSTONE_SUPERCOMPACT).setResistance(1),
                new BlocksBase("supercompressed_lapis", Material.ROCK, PlanetMaterial.LAPIS, PlanetHardness.LAPIS_SUPERCOMPACT, PlanetExp.LAPIS_SUPERCOMPACT).setResistance(1),
                new BlockBase("supercompressed_coal", Material.ROCK,false).setResistance(1),
                new BlocksBase("supercompressed_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON_SUPERCOMPACT, PlanetExp.IRON_SUPERCOMPACT).setResistance(4),
                new BlocksBase("supercompressed_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER_SUPERCOMPACT, PlanetExp.SILVER_SUPERCOMPACT).setResistance(6),
                new BlocksBase("supercompressed_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD_SUPERCOMPACT, PlanetExp.GOLD_SUPERCOMPACT).setResistance(8),
                new BlocksBase("supercompressed_diamond", Material.ROCK, PlanetMaterial.DIAMOND, PlanetHardness.DIAMOND_SUPERCOMPACT, PlanetExp.DIAMOND_SUPERCOMPACT).setResistance(25),
                new BlocksBase("supercompressed_emerald", Material.ROCK, PlanetMaterial.EMERALD, PlanetHardness.EMERALD_SUPERCOMPACT, PlanetExp.EMERALD_SUPERCOMPACT).setResistance(25),
                new BlocksBase("supercompressed_titanium", Material.ROCK, PlanetMaterial.TITANIUM, PlanetHardness.TITANIUM_SUPERCOMPACT, PlanetExp.TITANIUM_SUPERCOMPACT).setResistance(50),
                new BlocksBase("supercompressed_uranium", Material.ROCK, PlanetMaterial.URANIUM, PlanetHardness.URANIUM_SUPERCOMPACT, PlanetExp.URANIUM_SUPERCOMPACT).setResistance(50),
                new BlocksBase("supercompressed_tungsten", Material.ROCK, PlanetMaterial.TUNGSTEN, PlanetHardness.TUNGSTEN_SUPERCOMPACT, PlanetExp.TUNGSTEN_SUPERCOMPACT).setResistance(50),
                new BlocksBase("supercompressed_ruby", Material.ROCK, PlanetMaterial.RUBY, PlanetHardness.RUBY_SUPERCOMPACT, PlanetExp.RUBY_SUPERCOMPACT).setResistance(100),
                new BlocksBase("supercompressed_sapphire", Material.ROCK, PlanetMaterial.SAPPHIRE, PlanetHardness.SAPPHIRE_SUPERCOMPACT, PlanetExp.SAPPHIRE_SUPERCOMPACT).setResistance(100),
                new BlocksBase("supercompressed_majorite", Material.ROCK, PlanetMaterial.MAJORITE, PlanetHardness.MAJORITE_SUPERCOMPACT, PlanetExp.MAJORITE_SUPERCOMPACT).setResistance(200),
                new BlocksBase("supercompressed_amazonite", Material.ROCK, PlanetMaterial.AMAZONITE, PlanetHardness.AMAZONITE_SUPERCOMPACT, PlanetExp.AMAZONITE_SUPERCOMPACT).setResistance(250),
                new BlocksBase("supercompressed_onyx", Material.ROCK, PlanetMaterial.ONYX, PlanetHardness.ONYX_SUPERCOMPACT, PlanetExp.ONYX_SUPERCOMPACT).setResistance(300),
                new BlocksBase("supercompressed_painite", Material.ROCK, PlanetMaterial.PAINITE, PlanetHardness.PAINITE_SUPERCOMPACT, PlanetExp.PAINITE_SUPERCOMPACT).setResistance(300),
                new Crustrock("crustrock", Material.ROCK).setResistance(1),
                new Mantlerock("mantlerock", Material.ROCK).setResistance(1),
                new Corestone("corestone", Material.ROCK).setResistance(1),

                new OreBase("ore_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON, PlanetHarvestLevel.IRON, PlanetExp.IRON).setResistance(1),
                new OreBase("ore_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER, PlanetHarvestLevel.SILVER,PlanetExp.SILVER).setResistance(1),
                new OreBase("ore_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD, PlanetHarvestLevel.GOLD,PlanetExp.GOLD).setResistance(1),
                new OreBase("ore_diamond", Material.ROCK, PlanetMaterial.DIAMOND, PlanetHardness.DIAMOND, PlanetHarvestLevel.DIAMOND,PlanetExp.DIAMOND).setResistance(1),
                new OreBase("ore_emerald", Material.ROCK, PlanetMaterial.EMERALD, PlanetHardness.EMERALD, PlanetHarvestLevel.EMERALD,PlanetExp.EMERALD).setResistance(1),
                new OreBase("ore_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR, PlanetHarvestLevel.SULFUR,PlanetExp.SULFUR).setResistance(1),
                new OreCompactBase("ore_compact_coal", Material.ROCK, PlanetMaterial.COAL, PlanetHardness.COAL_COMPACT, PlanetHarvestLevel.COAL_COMPACT,PlanetExp.COAL_COMPACT).setResistance(1),
                new OreCompactBase("ore_compact_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON_COMPACT, PlanetHarvestLevel.IRON_COMPACT,PlanetExp.IRON_COMPACT).setResistance(1),
                new OreCompactBase("ore_compact_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER_COMPACT, PlanetHarvestLevel.SILVER_COMPACT,PlanetExp.SILVER_COMPACT).setResistance(1),
                new OreCompactBase("ore_compact_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD_COMPACT, PlanetHarvestLevel.GOLD_COMPACT,PlanetExp.GOLD_COMPACT).setResistance(1),
                new OreCompactBase("ore_compact_diamond", Material.ROCK, PlanetMaterial.DIAMOND, PlanetHardness.DIAMOND_COMPACT, PlanetHarvestLevel.DIAMOND_COMPACT,PlanetExp.DIAMOND_COMPACT).setResistance(10),
                new OreCompactBase("ore_compact_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR_COMPACT, PlanetHarvestLevel.SULFUR_COMPACT,PlanetExp.SULFUR_COMPACT).setResistance(1),
                new OreCompactBase("ore_compact_lapis", Material.ROCK, PlanetMaterial.LAPIS, PlanetHardness.LAPIS_COMPACT, PlanetHarvestLevel.LAPIS_COMPACT,PlanetExp.LAPIS_COMPACT).setResistance(1),
                new OreCompactBase("ore_compact_emerald", Material.ROCK, PlanetMaterial.EMERALD, PlanetHardness.EMERALD_COMPACT, PlanetHarvestLevel.EMERALD_COMPACT,PlanetExp.EMERALD_COMPACT).setResistance(10),

                new CrustrockOre("crustrock_coal", Material.ROCK, PlanetMaterial.COAL, PlanetHardness.COAL, PlanetHarvestLevel.COAL,PlanetExp.COAL).setResistance(1),
                new CrustrockOre("crustrock_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON, PlanetHarvestLevel.IRON,PlanetExp.IRON).setResistance(1),
                new CrustrockOre("crustrock_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER, PlanetHarvestLevel.SILVER,PlanetExp.SILVER).setResistance(1),
                new CrustrockOre("crustrock_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD, PlanetHarvestLevel.GOLD,PlanetExp.GOLD).setResistance(1),
                new CrustrockOre("crustrock_diamond", Material.ROCK, PlanetMaterial.DIAMOND, PlanetHardness.DIAMOND, PlanetHarvestLevel.DIAMOND,PlanetExp.DIAMOND).setResistance(1),
                new CrustrockOre("crustrock_emerald", Material.ROCK, PlanetMaterial.EMERALD, PlanetHardness.EMERALD, PlanetHarvestLevel.EMERALD,PlanetExp.EMERALD).setResistance(1),
                new CrustrockOre("crustrock_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR, PlanetHarvestLevel.SULFUR,PlanetExp.SULFUR).setResistance(1),
                new CrustrockOre("crustrock_redstone", Material.ROCK, PlanetMaterial.REDSTONE, PlanetHardness.REDSTONE, PlanetHarvestLevel.REDSTONE,PlanetExp.REDSTONE).setResistance(1),
                new CrustrockOre("crustrock_lapis", Material.ROCK, PlanetMaterial.LAPIS, PlanetHardness.LAPIS, PlanetHarvestLevel.LAPIS,PlanetExp.LAPIS).setResistance(1),
                new CrustrockOre("crustrock_titanium", Material.ROCK, PlanetMaterial.TITANIUM, PlanetHardness.TITANIUM, PlanetHarvestLevel.TITANIUM,PlanetExp.TITANIUM).setResistance(1),
                new CrustrockOre("crustrock_uranium", Material.ROCK, PlanetMaterial.URANIUM, PlanetHardness.URANIUM, PlanetHarvestLevel.URANIUM,PlanetExp.URANIUM).setResistance(1),
                new CrustrockOre("crustrock_tungsten", Material.ROCK, PlanetMaterial.TUNGSTEN, PlanetHardness.TUNGSTEN, PlanetHarvestLevel.TUNGSTEN,PlanetExp.TUNGSTEN).setResistance(1),
                new CrustrockOreCompact("crustrock_compact_coal", Material.ROCK, PlanetMaterial.COAL, PlanetHardness.COAL_COMPACT, PlanetHarvestLevel.COAL_COMPACT,PlanetExp.COAL_COMPACT).setResistance(1),
                new CrustrockOreCompact("crustrock_compact_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON_COMPACT, PlanetHarvestLevel.IRON_COMPACT,PlanetExp.IRON_COMPACT).setResistance(1),
                new CrustrockOreCompact("crustrock_compact_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER_COMPACT, PlanetHarvestLevel.SILVER_COMPACT,PlanetExp.SILVER_COMPACT).setResistance(1),
                new CrustrockOreCompact("crustrock_compact_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD_COMPACT, PlanetHarvestLevel.GOLD_COMPACT,PlanetExp.GOLD_COMPACT).setResistance(1),
                new CrustrockOreCompact("crustrock_compact_diamond", Material.ROCK, PlanetMaterial.DIAMOND, PlanetHardness.DIAMOND_COMPACT, PlanetHarvestLevel.DIAMOND_COMPACT,PlanetExp.DIAMOND_COMPACT).setResistance(10),
                new CrustrockOreCompact("crustrock_compact_emerald", Material.ROCK, PlanetMaterial.EMERALD, PlanetHardness.EMERALD_COMPACT, PlanetHarvestLevel.EMERALD_COMPACT,PlanetExp.EMERALD_COMPACT).setResistance(10),
                new CrustrockOreCompact("crustrock_compact_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR_COMPACT, PlanetHarvestLevel.SULFUR,PlanetExp.SULFUR_COMPACT).setResistance(10),
                new CrustrockOreCompact("crustrock_compact_redstone", Material.ROCK, PlanetMaterial.REDSTONE, PlanetHardness.REDSTONE_COMPACT, PlanetHarvestLevel.REDSTONE,PlanetExp.REDSTONE_COMPACT).setResistance(10),
                new CrustrockOreCompact("crustrock_compact_lapis", Material.ROCK, PlanetMaterial.LAPIS, PlanetHardness.LAPIS_COMPACT, PlanetHarvestLevel.LAPIS_COMPACT,PlanetExp.LAPIS_COMPACT).setResistance(10),
                new CrustrockOreCompact("crustrock_compact_titanium", Material.ROCK, PlanetMaterial.TITANIUM, PlanetHardness.TITANIUM_COMPACT, PlanetHarvestLevel.TITANIUM_COMPACT,PlanetExp.TITANIUM_COMPACT).setResistance(10),
                new CrustrockOreCompact("crustrock_compact_uranium", Material.ROCK, PlanetMaterial.URANIUM, PlanetHardness.URANIUM_COMPACT, PlanetHarvestLevel.URANIUM_COMPACT,PlanetExp.URANIUM_COMPACT).setResistance(10),
                new CrustrockOreCompact("crustrock_compact_tungsten", Material.ROCK, PlanetMaterial.TUNGSTEN, PlanetHardness.TUNGSTEN_COMPACT, PlanetHarvestLevel.TUNGSTEN_COMPACT,PlanetExp.TUNGSTEN_COMPACT).setResistance(10),

                new MantlerockOre("mantlerock_coal", Material.ROCK, PlanetMaterial.COAL, PlanetHardness.COAL, PlanetHarvestLevel.COAL,PlanetExp.COAL).setResistance(1),
                new MantlerockOre("mantlerock_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON, PlanetHarvestLevel.IRON,PlanetExp.IRON).setResistance(1),
                new MantlerockOre("mantlerock_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER, PlanetHarvestLevel.SILVER,PlanetExp.SILVER).setResistance(1),
                new MantlerockOre("mantlerock_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD, PlanetHarvestLevel.GOLD,PlanetExp.GOLD).setResistance(1),
                new MantlerockOre("mantlerock_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR, PlanetHarvestLevel.SULFUR,PlanetExp.SULFUR).setResistance(1),
                new MantlerockOre("mantlerock_redstone", Material.ROCK, PlanetMaterial.REDSTONE, PlanetHardness.REDSTONE, PlanetHarvestLevel.REDSTONE,PlanetExp.REDSTONE).setResistance(1),
                new MantlerockOre("mantlerock_lapis", Material.ROCK, PlanetMaterial.LAPIS, PlanetHardness.LAPIS, PlanetHarvestLevel.LAPIS,PlanetExp.LAPIS).setResistance(1),
                new MantlerockOre("mantlerock_titanium", Material.ROCK, PlanetMaterial.TITANIUM, PlanetHardness.TITANIUM, PlanetHarvestLevel.TITANIUM,PlanetExp.TITANIUM).setResistance(1),
                new MantlerockOre("mantlerock_uranium", Material.ROCK, PlanetMaterial.URANIUM, PlanetHardness.URANIUM, PlanetHarvestLevel.URANIUM,PlanetExp.URANIUM).setResistance(1),
                new MantlerockOre("mantlerock_tungsten", Material.ROCK, PlanetMaterial.TUNGSTEN, PlanetHardness.TUNGSTEN, PlanetHarvestLevel.TUNGSTEN,PlanetExp.TUNGSTEN).setResistance(1),
                new MantlerockOre("mantlerock_ruby", Material.ROCK, PlanetMaterial.RUBY, PlanetHardness.RUBY, PlanetHarvestLevel.RUBY,PlanetExp.RUBY).setResistance(1),
                new MantlerockOre("mantlerock_sapphire", Material.ROCK, PlanetMaterial.SAPPHIRE, PlanetHardness.SAPPHIRE, PlanetHarvestLevel.SAPPHIRE,PlanetExp.SAPPHIRE).setResistance(1),
                new MantlerockOre("mantlerock_diamond", Material.ROCK, PlanetMaterial.DIAMOND, PlanetHardness.DIAMOND, PlanetHarvestLevel.DIAMOND,PlanetExp.DIAMOND).setResistance(1),
                new MantlerockOre("mantlerock_emerald", Material.ROCK, PlanetMaterial.EMERALD, PlanetHardness.EMERALD, PlanetHarvestLevel.EMERALD,PlanetExp.EMERALD).setResistance(1),
                new MantlerockOre("mantlerock_majorite", Material.ROCK, PlanetMaterial.MAJORITE, PlanetHardness.MAJORITE, PlanetHarvestLevel.MAJORITE,PlanetExp.MAJORITE).setResistance(10),
                new MantlerockOre("mantlerock_amazonite", Material.ROCK, PlanetMaterial.AMAZONITE, PlanetHardness.AMAZONITE, PlanetHarvestLevel.AMAZONITE,PlanetExp.AMAZONITE).setResistance(10),
                new MantlerockOre("mantlerock_onyx", Material.ROCK, PlanetMaterial.ONYX, PlanetHardness.ONYX, PlanetHarvestLevel.ONYX,PlanetExp.ONYX).setResistance(10),
                new MantlerockOre("mantlerock_painite", Material.ROCK, PlanetMaterial.PAINITE, PlanetHardness.PAINITE, PlanetHarvestLevel.PAINITE,PlanetExp.PAINITE).setResistance(10),

                new MantlerockOreCompact("mantlerock_compact_coal", Material.ROCK, PlanetMaterial.COAL, PlanetHardness.COAL_COMPACT, PlanetHarvestLevel.COAL_COMPACT,PlanetExp.COAL_COMPACT).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON_COMPACT, PlanetHarvestLevel.IRON_COMPACT,PlanetExp.IRON_COMPACT).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER_COMPACT, PlanetHarvestLevel.SILVER_COMPACT,PlanetExp.SILVER_COMPACT).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD_COMPACT, PlanetHarvestLevel.GOLD_COMPACT,PlanetExp.GOLD_COMPACT).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR_COMPACT, PlanetHarvestLevel.SULFUR_COMPACT,PlanetExp.SULFUR_COMPACT).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_redstone", Material.ROCK, PlanetMaterial.REDSTONE, PlanetHardness.REDSTONE_COMPACT, PlanetHarvestLevel.REDSTONE_COMPACT,PlanetExp.REDSTONE_COMPACT).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_lapis", Material.ROCK, PlanetMaterial.LAPIS, PlanetHardness.LAPIS_COMPACT, PlanetHarvestLevel.LAPIS_COMPACT,PlanetExp.LAPIS_COMPACT).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_titanium", Material.ROCK, PlanetMaterial.TITANIUM, PlanetHardness.TITANIUM_COMPACT, PlanetHarvestLevel.TITANIUM_COMPACT,PlanetExp.TITANIUM_COMPACT).setResistance(10),
                new MantlerockOreCompact("mantlerock_compact_uranium", Material.ROCK, PlanetMaterial.URANIUM, PlanetHardness.URANIUM_COMPACT, PlanetHarvestLevel.URANIUM_COMPACT,PlanetExp.URANIUM_COMPACT).setResistance(10),
                new MantlerockOreCompact("mantlerock_compact_tungsten", Material.ROCK, PlanetMaterial.TUNGSTEN, PlanetHardness.TUNGSTEN_COMPACT, PlanetHarvestLevel.TUNGSTEN_COMPACT,PlanetExp.TUNGSTEN_COMPACT).setResistance(10),
                new MantlerockOreCompact("mantlerock_compact_ruby", Material.ROCK, PlanetMaterial.RUBY, PlanetHardness.RUBY_COMPACT, PlanetHarvestLevel.RUBY_COMPACT,PlanetExp.RUBY_COMPACT).setResistance(10),
                new MantlerockOreCompact("mantlerock_compact_sapphire", Material.ROCK, PlanetMaterial.SAPPHIRE, PlanetHardness.SAPPHIRE_COMPACT, PlanetHarvestLevel.SAPPHIRE_COMPACT,PlanetExp.SAPPHIRE_COMPACT).setResistance(10),
                new MantlerockOreCompact("mantlerock_compact_diamond", Material.ROCK, PlanetMaterial.DIAMOND, PlanetHardness.DIAMOND_COMPACT, PlanetHarvestLevel.DIAMOND_COMPACT,PlanetExp.DIAMOND_COMPACT).setResistance(10),
                new MantlerockOreCompact("mantlerock_compact_emerald", Material.ROCK, PlanetMaterial.EMERALD, PlanetHardness.EMERALD_COMPACT, PlanetHarvestLevel.EMERALD_COMPACT,PlanetExp.EMERALD_COMPACT).setResistance(10),
                new MantlerockOreCompact("mantlerock_compact_majorite", Material.ROCK, PlanetMaterial.MAJORITE, PlanetHardness.MAJORITE_COMPACT, PlanetHarvestLevel.MAJORITE_COMPACT,PlanetExp.MAJORITE_COMPACT).setResistance(100),
                new MantlerockOreCompact("mantlerock_compact_amazonite", Material.ROCK, PlanetMaterial.AMAZONITE, PlanetHardness.AMAZONITE_COMPACT, PlanetHarvestLevel.AMAZONITE_COMPACT,PlanetExp.AMAZONITE_COMPACT).setResistance(10),
                new MantlerockOreCompact("mantlerock_compact_onyx", Material.ROCK, PlanetMaterial.ONYX, PlanetHardness.ONYX_COMPACT, PlanetHarvestLevel.ONYX_COMPACT,PlanetExp.ONYX_COMPACT).setResistance(10),
                new MantlerockOreCompact("mantlerock_compact_painite", Material.ROCK, PlanetMaterial.PAINITE, PlanetHardness.PAINITE_COMPACT, PlanetHarvestLevel.PAINITE_COMPACT,PlanetExp.PAINITE_COMPACT).setResistance(10),

                new CorestoneOre("corestone_coal", Material.ROCK, PlanetMaterial.COAL, PlanetHardness.COAL, PlanetHarvestLevel.COAL,PlanetExp.COAL).setResistance(1),
                new CorestoneOre("corestone_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON, PlanetHarvestLevel.IRON,PlanetExp.IRON).setResistance(1),
                new CorestoneOre("corestone_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER, PlanetHarvestLevel.SILVER,PlanetExp.SILVER).setResistance(1),
                new CorestoneOre("corestone_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD, PlanetHarvestLevel.GOLD,PlanetExp.GOLD).setResistance(1),
                new CorestoneOre("corestone_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR, PlanetHarvestLevel.SULFUR,PlanetExp.SULFUR).setResistance(1),
                new CorestoneOre("corestone_redstone", Material.ROCK, PlanetMaterial.REDSTONE, PlanetHardness.REDSTONE, PlanetHarvestLevel.REDSTONE,PlanetExp.REDSTONE).setResistance(1),
                new CorestoneOre("corestone_lapis", Material.ROCK, PlanetMaterial.LAPIS, PlanetHardness.LAPIS, PlanetHarvestLevel.LAPIS,PlanetExp.LAPIS).setResistance(1),
                new CorestoneOre("corestone_titanium", Material.ROCK, PlanetMaterial.TITANIUM, PlanetHardness.TITANIUM, PlanetHarvestLevel.TITANIUM,PlanetExp.TITANIUM).setResistance(1),
                new CorestoneOre("corestone_uranium", Material.ROCK, PlanetMaterial.URANIUM, PlanetHardness.URANIUM, PlanetHarvestLevel.URANIUM,PlanetExp.URANIUM).setResistance(1),
                new CorestoneOre("corestone_tungsten", Material.ROCK, PlanetMaterial.TUNGSTEN, PlanetHardness.TUNGSTEN, PlanetHarvestLevel.TUNGSTEN,PlanetExp.TUNGSTEN).setResistance(1),
                new CorestoneOre("corestone_ruby", Material.ROCK, PlanetMaterial.RUBY, PlanetHardness.RUBY, PlanetHarvestLevel.RUBY,PlanetExp.RUBY).setResistance(1),
                new CorestoneOre("corestone_sapphire", Material.ROCK, PlanetMaterial.SAPPHIRE, PlanetHardness.SAPPHIRE, PlanetHarvestLevel.SAPPHIRE,PlanetExp.SAPPHIRE).setResistance(1),
                new CorestoneOre("corestone_diamond", Material.ROCK, PlanetMaterial.DIAMOND, PlanetHardness.DIAMOND, PlanetHarvestLevel.DIAMOND,PlanetExp.DIAMOND).setResistance(1),
                new CorestoneOre("corestone_emerald", Material.ROCK, PlanetMaterial.EMERALD, PlanetHardness.EMERALD, PlanetHarvestLevel.EMERALD,PlanetExp.EMERALD).setResistance(1),
                new CorestoneOre("corestone_majorite", Material.ROCK, PlanetMaterial.MAJORITE, PlanetHardness.MAJORITE, PlanetHarvestLevel.MAJORITE,PlanetExp.MAJORITE).setResistance(10),
                new CorestoneOre("corestone_amazonite", Material.ROCK, PlanetMaterial.AMAZONITE, PlanetHardness.AMAZONITE, PlanetHarvestLevel.AMAZONITE,PlanetExp.AMAZONITE).setResistance(10),
                new CorestoneOre("corestone_onyx", Material.ROCK, PlanetMaterial.ONYX, PlanetHardness.ONYX, PlanetHarvestLevel.ONYX,PlanetExp.ONYX).setResistance(10),
                new CorestoneOre("corestone_painite", Material.ROCK, PlanetMaterial.PAINITE, PlanetHardness.PAINITE, PlanetHarvestLevel.PAINITE,PlanetExp.PAINITE).setResistance(10),

                new CorestoneOreCompact("corestone_compact_coal", Material.ROCK, PlanetMaterial.COAL, PlanetHardness.COAL_COMPACT, PlanetHarvestLevel.COAL_COMPACT,PlanetExp.COAL_COMPACT).setResistance(1),
                new CorestoneOreCompact("corestone_compact_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON_COMPACT, PlanetHarvestLevel.IRON_COMPACT,PlanetExp.IRON_COMPACT).setResistance(1),
                new CorestoneOreCompact("corestone_compact_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER_COMPACT, PlanetHarvestLevel.SILVER_COMPACT,PlanetExp.SILVER_COMPACT).setResistance(1),
                new CorestoneOreCompact("corestone_compact_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD_COMPACT, PlanetHarvestLevel.GOLD_COMPACT,PlanetExp.GOLD_COMPACT).setResistance(1),
                new CorestoneOreCompact("corestone_compact_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR_COMPACT, PlanetHarvestLevel.SULFUR_COMPACT,PlanetExp.SULFUR_COMPACT).setResistance(1),
                new CorestoneOreCompact("corestone_compact_redstone", Material.ROCK, PlanetMaterial.REDSTONE, PlanetHardness.REDSTONE_COMPACT, PlanetHarvestLevel.REDSTONE_COMPACT,PlanetExp.REDSTONE_COMPACT).setResistance(1),
                new CorestoneOreCompact("corestone_compact_lapis", Material.ROCK, PlanetMaterial.LAPIS, PlanetHardness.LAPIS_COMPACT, PlanetHarvestLevel.LAPIS_COMPACT,PlanetExp.LAPIS_COMPACT).setResistance(1),
                new CorestoneOreCompact("corestone_compact_titanium", Material.ROCK, PlanetMaterial.TITANIUM, PlanetHardness.TITANIUM_COMPACT, PlanetHarvestLevel.TITANIUM_COMPACT,PlanetExp.TITANIUM_COMPACT).setResistance(10),
                new CorestoneOreCompact("corestone_compact_uranium", Material.ROCK, PlanetMaterial.URANIUM, PlanetHardness.URANIUM_COMPACT, PlanetHarvestLevel.URANIUM_COMPACT,PlanetExp.URANIUM_COMPACT).setResistance(10),
                new CorestoneOreCompact("corestone_compact_tungsten", Material.ROCK, PlanetMaterial.TUNGSTEN, PlanetHardness.TUNGSTEN_COMPACT, PlanetHarvestLevel.TUNGSTEN_COMPACT,PlanetExp.TUNGSTEN_COMPACT).setResistance(10),
                new CorestoneOreCompact("corestone_compact_ruby", Material.ROCK, PlanetMaterial.RUBY, PlanetHardness.RUBY_COMPACT, PlanetHarvestLevel.RUBY_COMPACT,PlanetExp.RUBY_COMPACT).setResistance(10),
                new CorestoneOreCompact("corestone_compact_sapphire", Material.ROCK, PlanetMaterial.SAPPHIRE, PlanetHardness.SAPPHIRE_COMPACT, PlanetHarvestLevel.SAPPHIRE_COMPACT,PlanetExp.SAPPHIRE_COMPACT).setResistance(10),
                new CorestoneOreCompact("corestone_compact_diamond", Material.ROCK, PlanetMaterial.DIAMOND, PlanetHardness.DIAMOND_COMPACT, PlanetHarvestLevel.DIAMOND_COMPACT,PlanetExp.DIAMOND_COMPACT).setResistance(10),
                new CorestoneOreCompact("corestone_compact_emerald", Material.ROCK, PlanetMaterial.EMERALD, PlanetHardness.EMERALD_COMPACT, PlanetHarvestLevel.EMERALD_COMPACT,PlanetExp.EMERALD_COMPACT).setResistance(10),
                new CorestoneOreCompact("corestone_compact_majorite", Material.ROCK, PlanetMaterial.MAJORITE, PlanetHardness.MAJORITE_COMPACT, PlanetHarvestLevel.MAJORITE_COMPACT,PlanetExp.MAJORITE_COMPACT).setResistance(100),
                new CorestoneOreCompact("corestone_compact_amazonite", Material.ROCK, PlanetMaterial.AMAZONITE, PlanetHardness.AMAZONITE_COMPACT, PlanetHarvestLevel.AMAZONITE_COMPACT,PlanetExp.AMAZONITE_COMPACT).setResistance(10),
                new CorestoneOreCompact("corestone_compact_onyx", Material.ROCK, PlanetMaterial.ONYX, PlanetHardness.ONYX_COMPACT, PlanetHarvestLevel.ONYX_COMPACT,PlanetExp.ONYX_COMPACT).setResistance(10),
                new CorestoneOreCompact("corestone_compact_painite", Material.ROCK, PlanetMaterial.PAINITE, PlanetHardness.PAINITE_COMPACT, PlanetHarvestLevel.PAINITE_COMPACT,PlanetExp.PAINITE_COMPACT).setResistance(10)

                );
    }

    public static void registerRenders() {

        for (int meta = 0; meta < 3; meta++) {
            String name = Reference.MOD_ID + ":" + HotRocks.EnumType.values()[meta].getName();
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.GRANITE), meta, new ModelResourceLocation(name + "_granite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.DIORITE), meta, new ModelResourceLocation(name + "_diorite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.ANDESITE), meta, new ModelResourceLocation(name + "_andesite", "inventory"));
        }

        for (int meta = 0; meta < 4; meta++) {
            String name = Reference.MOD_ID + ":" + BlocksBase.EnumType.values()[meta].getName();
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SUPERCOMPRESSED_SULFUR), meta, new ModelResourceLocation(name + "_sulfur", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SUPERCOMPRESSED_IRON), meta, new ModelResourceLocation(name + "_iron", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SUPERCOMPRESSED_LAPIS), meta, new ModelResourceLocation(name + "_lapis", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SUPERCOMPRESSED_REDSTONE), meta, new ModelResourceLocation(name + "_redstone", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SUPERCOMPRESSED_SILVER), meta, new ModelResourceLocation(name + "_silver", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SUPERCOMPRESSED_GOLD), meta, new ModelResourceLocation(name + "_gold", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SUPERCOMPRESSED_EMERALD), meta, new ModelResourceLocation(name + "_emerald", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SUPERCOMPRESSED_DIAMOND), meta, new ModelResourceLocation(name + "_diamond", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SUPERCOMPRESSED_URANIUM), meta, new ModelResourceLocation(name + "_uranium", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SUPERCOMPRESSED_TITANIUM), meta, new ModelResourceLocation(name + "_titanium", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SUPERCOMPRESSED_TUNGSTEN), meta, new ModelResourceLocation(name + "_tungsten", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SUPERCOMPRESSED_RUBY), meta, new ModelResourceLocation(name + "_ruby", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SUPERCOMPRESSED_SAPPHIRE), meta, new ModelResourceLocation(name + "_sapphire", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SUPERCOMPRESSED_MAJORITE), meta, new ModelResourceLocation(name + "_majorite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SUPERCOMPRESSED_AMAZONITE), meta, new ModelResourceLocation(name + "_amazonite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SUPERCOMPRESSED_ONYX), meta, new ModelResourceLocation(name + "_onyx", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SUPERCOMPRESSED_PAINITE), meta, new ModelResourceLocation(name + "_painite", "inventory"));
        }

        for (int meta = 0; meta < 3; meta++) {
            String name = Reference.MOD_ID + ":" + Crustrock.EnumType.values()[meta].getName();
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK), meta, new ModelResourceLocation(name, "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COAL), meta, new ModelResourceLocation(name + "_coal", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_SULFUR), meta, new ModelResourceLocation(name + "_sulfur", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_REDSTONE), meta, new ModelResourceLocation(name + "_redstone", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_LAPIS), meta, new ModelResourceLocation(name + "_lapis", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_IRON), meta, new ModelResourceLocation(name + "_iron", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_SILVER), meta, new ModelResourceLocation(name + "_silver", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_GOLD), meta, new ModelResourceLocation(name + "_gold", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_DIAMOND), meta, new ModelResourceLocation(name + "_diamond", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_EMERALD), meta, new ModelResourceLocation(name + "_emerald", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_TITANIUM), meta, new ModelResourceLocation(name + "_titanium", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_URANIUM), meta, new ModelResourceLocation(name + "_uranium", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_TUNGSTEN), meta, new ModelResourceLocation(name + "_tungsten", "inventory"));

            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_COAL), meta, new ModelResourceLocation(name + "_compact_coal", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_SULFUR), meta, new ModelResourceLocation(name + "_compact_sulfur", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_REDSTONE), meta, new ModelResourceLocation(name + "_compact_redstone", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_LAPIS), meta, new ModelResourceLocation(name + "_compact_lapis", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_IRON), meta, new ModelResourceLocation(name + "_compact_iron", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_SILVER), meta, new ModelResourceLocation(name + "_compact_silver", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_GOLD), meta, new ModelResourceLocation(name + "_compact_gold", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_DIAMOND), meta, new ModelResourceLocation(name + "_compact_diamond", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_EMERALD), meta, new ModelResourceLocation(name + "_compact_emerald", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_TITANIUM), meta, new ModelResourceLocation(name + "_compact_titanium", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_URANIUM), meta, new ModelResourceLocation(name + "_compact_uranium", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_TUNGSTEN), meta, new ModelResourceLocation(name + "_compact_tungsten", "inventory"));
        }

        for (int meta = 0; meta < 6; meta++) {
            String name = Reference.MOD_ID + ":" + Mantlerock.EnumType.values()[meta].getName();

            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK), meta, new ModelResourceLocation(name, "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COAL), meta, new ModelResourceLocation(name + "_coal", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SULFUR), meta, new ModelResourceLocation(name + "_sulfur", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_REDSTONE), meta, new ModelResourceLocation(name + "_redstone", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_LAPIS), meta, new ModelResourceLocation(name + "_lapis", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_IRON), meta, new ModelResourceLocation(name + "_iron", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SILVER), meta, new ModelResourceLocation(name + "_silver", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_GOLD), meta, new ModelResourceLocation(name + "_gold", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_TITANIUM), meta, new ModelResourceLocation(name + "_titanium", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_URANIUM), meta, new ModelResourceLocation(name + "_uranium", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_TUNGSTEN), meta, new ModelResourceLocation(name + "_tungsten", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_RUBY), meta, new ModelResourceLocation(name + "_ruby", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SAPPHIRE), meta, new ModelResourceLocation(name + "_sapphire", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_DIAMOND), meta, new ModelResourceLocation(name + "_diamond", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_EMERALD), meta, new ModelResourceLocation(name + "_emerald", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_MAJORITE), meta, new ModelResourceLocation(name + "_majorite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_AMAZONITE), meta, new ModelResourceLocation(name + "_amazonite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_ONYX), meta, new ModelResourceLocation(name + "_onyx", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_PAINITE), meta, new ModelResourceLocation(name + "_painite", "inventory"));

            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_COAL), meta, new ModelResourceLocation(name + "_compact_coal", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_SULFUR), meta, new ModelResourceLocation(name + "_compact_sulfur", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_REDSTONE), meta, new ModelResourceLocation(name + "_compact_redstone", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_LAPIS), meta, new ModelResourceLocation(name + "_compact_lapis", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_IRON), meta, new ModelResourceLocation(name + "_compact_iron", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_SILVER), meta, new ModelResourceLocation(name + "_compact_silver", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_GOLD), meta, new ModelResourceLocation(name + "_compact_gold", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_TITANIUM), meta, new ModelResourceLocation(name + "_compact_titanium", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_URANIUM), meta, new ModelResourceLocation(name + "_compact_uranium", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_TUNGSTEN), meta, new ModelResourceLocation(name + "_compact_tungsten", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_RUBY), meta, new ModelResourceLocation(name + "_compact_ruby", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_SAPPHIRE), meta, new ModelResourceLocation(name + "_compact_sapphire", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_DIAMOND), meta, new ModelResourceLocation(name + "_compact_diamond", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_EMERALD), meta, new ModelResourceLocation(name + "_compact_emerald", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_MAJORITE), meta, new ModelResourceLocation(name + "_compact_majorite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_AMAZONITE), meta, new ModelResourceLocation(name + "_compact_amazonite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_ONYX), meta, new ModelResourceLocation(name + "_compact_onyx", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_PAINITE), meta, new ModelResourceLocation(name + "_compact_painite", "inventory"));
        }

        for (int meta = 0; meta < 3; meta++) {

            String name = Reference.MOD_ID + ":" + Corestone.EnumType.values()[meta].getName();
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE), meta, new ModelResourceLocation(name, "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COAL), meta, new ModelResourceLocation(name + "_coal", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_SULFUR), meta, new ModelResourceLocation(name + "_sulfur", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_REDSTONE), meta, new ModelResourceLocation(name + "_redstone", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_LAPIS), meta, new ModelResourceLocation(name + "_lapis", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_IRON), meta, new ModelResourceLocation(name + "_iron", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_SILVER), meta, new ModelResourceLocation(name + "_silver", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_GOLD), meta, new ModelResourceLocation(name + "_gold", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_TITANIUM), meta, new ModelResourceLocation(name + "_titanium", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_URANIUM), meta, new ModelResourceLocation(name + "_uranium", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_TUNGSTEN), meta, new ModelResourceLocation(name + "_tungsten", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_RUBY), meta, new ModelResourceLocation(name + "_ruby", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_SAPPHIRE), meta, new ModelResourceLocation(name + "_sapphire", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_DIAMOND), meta, new ModelResourceLocation(name + "_diamond", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_EMERALD), meta, new ModelResourceLocation(name + "_emerald", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_MAJORITE), meta, new ModelResourceLocation(name + "_majorite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_AMAZONITE), meta, new ModelResourceLocation(name + "_amazonite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_ONYX), meta, new ModelResourceLocation(name + "_onyx", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_PAINITE), meta, new ModelResourceLocation(name + "_painite", "inventory"));

            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_COAL), meta, new ModelResourceLocation(name + "_compact_coal", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_SULFUR), meta, new ModelResourceLocation(name + "_compact_sulfur", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_REDSTONE), meta, new ModelResourceLocation(name + "_compact_redstone", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_LAPIS), meta, new ModelResourceLocation(name + "_compact_lapis", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_IRON), meta, new ModelResourceLocation(name + "_compact_iron", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_SILVER), meta, new ModelResourceLocation(name + "_compact_silver", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_GOLD), meta, new ModelResourceLocation(name + "_compact_gold", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_TITANIUM), meta, new ModelResourceLocation(name + "_compact_titanium", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_URANIUM), meta, new ModelResourceLocation(name + "_compact_uranium", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_TUNGSTEN), meta, new ModelResourceLocation(name + "_compact_tungsten", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_RUBY), meta, new ModelResourceLocation(name + "_compact_ruby", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_SAPPHIRE), meta, new ModelResourceLocation(name + "_compact_sapphire", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_DIAMOND), meta, new ModelResourceLocation(name + "_compact_diamond", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_EMERALD), meta, new ModelResourceLocation(name + "_compact_emerald", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_MAJORITE), meta, new ModelResourceLocation(name + "_compact_majorite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_AMAZONITE), meta, new ModelResourceLocation(name + "_compact_amazonite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_ONYX), meta, new ModelResourceLocation(name + "_compact_onyx", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_PAINITE), meta, new ModelResourceLocation(name + "_compact_painite", "inventory"));
        }
    }

    public static List<Block> getBlocks() {
        return BLOCKS;
    }
}