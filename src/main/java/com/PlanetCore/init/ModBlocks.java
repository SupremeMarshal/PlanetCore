package com.PlanetCore.init;


import com.PlanetCore.blocks.*;
import com.PlanetCore.blocks.furnaces.CrustrockFurnace;
import com.PlanetCore.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;
import net.minecraftforge.registries.IForgeRegistry;
import javax.annotation.Nonnull;
import java.util.ArrayList;
import java.util.List;


@ObjectHolder("planetcore")

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

    @ObjectHolder("sulfuric_acid")
    public static final Block SULFURIC_ACID_FLUID = _null();
    @ObjectHolder("hot_lava")
    public static final Block HOT_LAVA_FLUID = _null();
    @ObjectHolder("active_lava")
    public static final Block ACTIVE_LAVA_FLUID = _null();
    @ObjectHolder("core_lava")
    public static final Block CORE_LAVA_FLUID = _null();
    @ObjectHolder("onyx_lava")
    public static final Block ONYX_LAVA_FLUID = _null();

    public static final CrustrockFurnace CRUSTROCK_FURNACE = _null();
    public static final CrustrockFurnace LIT_CRUSTROCK_FURNACE = _null();

    public static final Crustrock CRUSTROCK = _null();
    public static final Mantlerock MANTLEROCK = _null();
    public static final Corestone CORESTONE = _null();

    public static final OreBase ORE_ALUMINUM = _null();
    public static final OreBase ORE_IRON = _null();
    public static final OreBase ORE_TIN = _null();
    public static final OreBase ORE_COPPER = _null();
    public static final OreBase ORE_SILVER = _null();
    public static final OreBase ORE_GOLD = _null();
    public static final OreBase ORE_SULFUR = _null();

    public static final OreSmallBase ORE_SMALL_COAL = _null();
    public static final OreSmallBase ORE_SMALL_IRON = _null();
    public static final OreSmallBase ORE_SMALL_TIN = _null();
    public static final OreSmallBase ORE_SMALL_COPPER = _null();
    public static final OreSmallBase ORE_SMALL_SILVER = _null();
    public static final OreSmallBase ORE_SMALL_GOLD = _null();
    public static final OreSmallBase ORE_SMALL_LAPIS = _null();
    public static final OreSmallBase ORE_SMALL_REDSTONE = _null();
    public static final OreSmallBase ORE_SMALL_SULFUR = _null();

    public static final OreCompactBase ORE_COMPACT_COAL = _null();
    public static final OreCompactBase ORE_COMPACT_IRON = _null();
    public static final OreCompactBase ORE_COMPACT_TIN = _null();
    public static final OreCompactBase ORE_COMPACT_COPPER = _null();
    public static final OreCompactBase ORE_COMPACT_SILVER = _null();
    public static final OreCompactBase ORE_COMPACT_GOLD = _null();
    public static final OreCompactBase ORE_COMPACT_LAPIS = _null();
    public static final OreCompactBase ORE_COMPACT_REDSTONE = _null();
    public static final OreCompactBase ORE_COMPACT_SULFUR = _null();

    public static final CrustrockOre CRUSTROCK_COAL = _null();
    public static final CrustrockOre CRUSTROCK_SULFUR = _null();
    public static final CrustrockOre CRUSTROCK_REDSTONE = _null();
    public static final CrustrockOre CRUSTROCK_LAPIS = _null();
    public static final CrustrockOre CRUSTROCK_ALUMINUM = _null();
    public static final CrustrockOre CRUSTROCK_IRON = _null();
    public static final CrustrockOre CRUSTROCK_TIN = _null();
    public static final CrustrockOre CRUSTROCK_COPPER = _null();
    public static final CrustrockOre CRUSTROCK_SILVER = _null();
    public static final CrustrockOre CRUSTROCK_GOLD = _null();
    public static final CrustrockOre CRUSTROCK_PLATINUM = _null();
    public static final CrustrockOre CRUSTROCK_TITANUM = _null();

    public static final CrustrockOreSmall CRUSTROCK_SMALL_COAL = _null();
    public static final CrustrockOreSmall CRUSTROCK_SMALL_SULFUR = _null();
    public static final CrustrockOreSmall CRUSTROCK_SMALL_REDSTONE = _null();
    public static final CrustrockOreSmall CRUSTROCK_SMALL_LAPIS = _null();
    public static final CrustrockOreSmall CRUSTROCK_SMALL_ALUMINUM = _null();
    public static final CrustrockOreSmall CRUSTROCK_SMALL_IRON = _null();
    public static final CrustrockOreSmall CRUSTROCK_SMALL_TIN = _null();
    public static final CrustrockOreSmall CRUSTROCK_SMALL_COPPER = _null();
    public static final CrustrockOreSmall CRUSTROCK_SMALL_SILVER = _null();
    public static final CrustrockOreSmall CRUSTROCK_SMALL_GOLD = _null();
    public static final CrustrockOreSmall CRUSTROCK_SMALL_PLATINUM = _null();
    public static final CrustrockOreSmall CRUSTROCK_SMALL_TITANUM = _null();

    public static final CrustrockOreCompact CRUSTROCK_COMPACT_COAL = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_SULFUR = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_REDSTONE = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_LAPIS = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_ALUMINUM = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_IRON = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_TIN = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_COPPER = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_SILVER = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_GOLD = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_PLATINUM = _null();
    public static final CrustrockOreCompact CRUSTROCK_COMPACT_TITANUM = _null();

    public static final MantlerockOre MANTLEROCK_COAL = _null();
    public static final MantlerockOre MANTLEROCK_SULFUR = _null();
    public static final MantlerockOre MANTLEROCK_REDSTONE = _null();
    public static final MantlerockOre MANTLEROCK_LAPIS = _null();
    public static final MantlerockOre MANTLEROCK_ALUMINUM = _null();
    public static final MantlerockOre MANTLEROCK_IRON = _null();
    public static final MantlerockOre MANTLEROCK_TIN = _null();
    public static final MantlerockOre MANTLEROCK_COPPER = _null();
    public static final MantlerockOre MANTLEROCK_SILVER = _null();
    public static final MantlerockOre MANTLEROCK_GOLD = _null();
    public static final MantlerockOre MANTLEROCK_PLATINUM = _null();
    public static final MantlerockOre MANTLEROCK_TITANUM = _null();
    public static final MantlerockOre MANTLEROCK_URANUM = _null();
    public static final MantlerockOre MANTLEROCK_TUNGSTEN = _null();
    public static final MantlerockOre MANTLEROCK_EMERALD = _null();
    public static final MantlerockOre MANTLEROCK_RUBY = _null();
    public static final MantlerockOre MANTLEROCK_SAPPHIRE = _null();
    public static final MantlerockOre MANTLEROCK_DIAMOND = _null();
    public static final MantlerockOre MANTLEROCK_OLIVINE = _null();
    public static final MantlerockOre MANTLEROCK_WADSLEYITE = _null();
    public static final MantlerockOre MANTLEROCK_RINGWOODITE = _null();
    public static final MantlerockOre MANTLEROCK_BRIGMANITE = _null();
    public static final MantlerockOre MANTLEROCK_MAJORITE = _null();
    public static final MantlerockOre MANTLEROCK_AMAZONITE = _null();

    public static final MantlerockOreSmall MANTLEROCK_SMALL_COAL = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_SULFUR = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_REDSTONE = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_LAPIS = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_ALUMINUM = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_IRON = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_TIN = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_COPPER = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_SILVER = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_GOLD = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_PLATINUM = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_TITANUM = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_URANUM = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_TUNGSTEN = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_EMERALD = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_RUBY = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_SAPPHIRE = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_DIAMOND = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_OLIVINE = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_WADSLEYITE = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_RINGWOODITE = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_BRIGMANITE = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_MAJORITE = _null();
    public static final MantlerockOreSmall MANTLEROCK_SMALL_AMAZONITE = _null();

    public static final MantlerockOreCompact MANTLEROCK_COMPACT_COAL = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_SULFUR = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_REDSTONE = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_LAPIS = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_ALUMINUM = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_IRON = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_TIN = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_COPPER = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_SILVER = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_GOLD = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_PLATINUM = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_TITANUM = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_URANUM = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_TUNGSTEN = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_EMERALD = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_RUBY = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_SAPPHIRE = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_DIAMOND = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_OLIVINE = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_WADSLEYITE = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_RINGWOODITE = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_BRIGMANITE = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_MAJORITE = _null();
    public static final MantlerockOreCompact MANTLEROCK_COMPACT_AMAZONITE = _null();

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

    public static final CorestoneOreSmall CORESTONE_SMALL_EMERALD = _null();
    public static final CorestoneOreSmall CORESTONE_SMALL_RUBY = _null();
    public static final CorestoneOreSmall CORESTONE_SMALL_SAPPHIRE = _null();
    public static final CorestoneOreSmall CORESTONE_SMALL_DIAMOND = _null();
    public static final CorestoneOreSmall CORESTONE_SMALL_OLIVINE = _null();
    public static final CorestoneOreSmall CORESTONE_SMALL_WADSLEYITE = _null();
    public static final CorestoneOreSmall CORESTONE_SMALL_RINGWOODITE = _null();
    public static final CorestoneOreSmall CORESTONE_SMALL_BRIGMANITE = _null();
    public static final CorestoneOreSmall CORESTONE_SMALL_MAJORITE = _null();
    public static final CorestoneOreSmall CORESTONE_SMALL_AMAZONITE = _null();
    public static final CorestoneOreSmall CORESTONE_SMALL_ONYX = _null();

    public static final CorestoneOreCompact CORESTONE_COMPACT_EMERALD = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_RUBY = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_SAPPHIRE = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_DIAMOND = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_OLIVINE = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_WADSLEYITE = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_RINGWOODITE = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_BRIGMANITE = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_MAJORITE = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_AMAZONITE = _null();
    public static final CorestoneOreCompact CORESTONE_COMPACT_ONYX = _null();

    public static final BlockBase ONYX_BLOCK = _null();
    public static final BlockBase AMAZONITE_BLOCK = _null();
    public static final BlockBase MAJORITE_BLOCK = _null();
    public static final BlockBase BRIGMANITE_BLOCK = _null();
    public static final BlockBase RINGWOODITE_BLOCK = _null();
    public static final BlockBase OLIVINE_BLOCK = _null();
    public static final BlockBase DIAMOND_BLOCK = _null();
    public static final BlockBase SAPPHIRE_BLOCK = _null();
    public static final BlockBase RUBY_BLOCK = _null();
    public static final BlockBase TUNGSTEN_titanum_BLOCK = _null();
    public static final BlockBase TUNGSTEN_uranum_BLOCK = _null();
    public static final BlockBase TUNGSTEN_BLOCK = _null();
    public static final BlockBase TITANUM_URANUM_BLOCK = _null();
    public static final BlockBase TITANUM_BLOCK = _null();
    public static final BlockBase URANUM_BLOCK = _null();
    public static final BlockBase PLATINUM_BLOCK = _null();
    public static final BlockBase JADE_BLOCK = _null();
    public static final BlockBase TOPAZ_BLOCK = _null();
    public static final BlockBase GOLD_BLOCK = _null();
    public static final BlockBase SILVER_BLOCK = _null();
    public static final BlockBase SULFUR_BLOCK = _null();
    public static final BlockBase BRONZE_BLOCK = _null();
    public static final BlockBase STEEL_BLOCK = _null();
    public static final BlockBase IRON_BLOCK = _null();
    public static final BlockBase COPPER_BLOCK = _null();
    public static final BlockBase TIN_BLOCK = _null();
    public static final BlockBase ALUMINUM_BLOCK = _null();

    public static final BlocksBase ONYX_SUPERCOMPACT = _null();
    public static final BlocksBase AMAZONITE_SUPERCOMPACT = _null();
    public static final BlocksBase MAJORITE_SUPERCOMPACT = _null();
    public static final BlocksBase BRIGMANITE_SUPERCOMPACT = _null();
    public static final BlocksBase RINGWOODITE_SUPERCOMPACT = _null();
    public static final BlocksBase OLIVINE_SUPERCOMPACT = _null();
    public static final BlocksBase WADSLEYITE_SUPERCOMPACT = _null();
    public static final BlocksBase DIAMOND_SUPERCOMPACT = _null();
    public static final BlocksBase SAPPHIRE_SUPERCOMPACT = _null();
    public static final BlocksBase RUBY_SUPERCOMPACT = _null();
    public static final BlocksBase EMERALD_SUPERCOMPACT = _null();
    public static final BlocksBase URANUM_SUPERCOMPACT = _null();
    public static final BlocksBase TUNGSTEN_SUPERCOMPACT = _null();
    public static final BlocksBase TITANUM_SUPERCOMPACT = _null();
    public static final BlocksBase PLATINUM_SUPERCOMPACT = _null();
    public static final BlocksBase GOLD_SUPERCOMPACT = _null();
    public static final BlocksBase SILVER_SUPERCOMPACT = _null();
    public static final BlocksBase LAPIS_SUPERCOMPACT = _null();
    public static final BlocksBase REDSTONE_SUPERCOMPACT = _null();
    public static final BlocksBase SULFUR_SUPERCOMPACT = _null();
    public static final BlocksBase BRONZE_SUPERCOMPACT = _null();
    public static final BlocksBase STEEL_SUPERCOMPACT = _null();
    public static final BlocksBase IRON_SUPERCOMPACT = _null();
    public static final BlocksBase COPPER_SUPERCOMPACT = _null();
    public static final BlocksBase TIN_SUPERCOMPACT = _null();
    public static final BlocksBase ALUMINUM_SUPERCOMPACT = _null();
    public static final BlocksBase COAL_SUPERCOMPACT = _null();

    public static final BlockBase CRUST_COBBLESTONE = _null();

    // GENERATED BEGIN

    public static final Corestone COLD_CORESTONE = _null();


    // GENERATED END


    //SEDIMENTARY ROCK

    public static final Block LIMESTONE = _null();

    public static void register(IForgeRegistry<Block> registry) {

        boolean generateHolders = System.getProperty("planetcore.generate_holders", "false").equalsIgnoreCase("true");


        /*
        Create a loop to get the coresponding blocks.
         */

        registry.registerAll(

                new BlockBase("crust_cobblestone", Material.ROCK).setHardness(5.0F).setResistance(1),
                new CrustrockFurnace("crustrock_furnace", false).setHardness(5.0F).setCreativeTab(CreativeTabs.DECORATIONS).setResistance(1),
                new CrustrockFurnace("lit_crustrock_furnace", true).setHardness(5.0F).setResistance(500).setLightLevel(0.975F).setResistance(1),
                new SulfuricAcidFluid("sulfuric_acid", ModFluids.SULFURIC_ACID_FLUID, Material.WATER).setResistance(1),
                new HotLavaFluid("hot_lava", ModFluids.HOT_LAVA_FLUID, Material.LAVA).setResistance(1),
                new CoreLavaFluid("core_lava", ModFluids.CORE_LAVA_FLUID, Material.LAVA).setResistance(1),
                new ActiveLavaFluid("active_lava", ModFluids.ACTIVE_LAVA_FLUID, Material.LAVA).setResistance(1),
                new OnyxLavaFluid("onyx_lava", ModFluids.ONYX_LAVA_FLUID, Material.LAVA).setResistance(1),
                new BlockBase("sulfur_block", Material.ROCK).setHardness(5F).setResistance(1),
                new BlockBase("aluminum_block", Material.IRON).setHardness(5F).setResistance(1),
                new BlockBase("tin_block", Material.IRON).setHardness(10.0F).setResistance(1),
                new BlockBase("copper_block", Material.IRON).setHardness(10.0F).setResistance(1),
                new BlockBase("iron_block", Material.IRON).setHardness(7.0F).setResistance(1),
                new BlockBase("steel_block", Material.IRON).setHardness(10.0F).setResistance(1),
                new BlockBase("bronze_block", Material.IRON).setHardness(15.0F).setResistance(1),
                new BlockBase("silver_block", Material.IRON).setHardness(24.0F).setResistance(1),
                new BlockBase("gold_block", Material.IRON).setHardness(48F).setResistance(1),
                new BlockBase("platinum_block", Material.IRON).setHardness(72F).setResistance(2),
                new BlockBase("titanum_block", Material.IRON).setHardness(96F).setResistance(3),
                new BlockBase("titanum_uranum_block", Material.IRON).setHardness(100F).setResistance(4),
                new BlockBase("uranum_block", Material.IRON).setHardness(100F).setResistance(4),
                new BlockBase("tungsten_block", Material.IRON).setHardness(200F).setResistance(5),
                new BlockBase("tungsten_uranum_block", Material.IRON).setHardness(200F).setResistance(5),
                new BlockBase("tungsten_titanum_block", Material.IRON).setHardness(300F).setResistance(6),
                new BlockBase("emerald_block", Material.IRON).setHardness(400F).setResistance(6),
                new BlockBase("ruby_block", Material.IRON).setHardness(800F).setResistance(7),
                new BlockBase("sapphire_block", Material.IRON).setHardness(1200F).setResistance(8),
                new BlockBase("diamond_block", Material.IRON).setHardness(2000F).setResistance(10),
                new BlockBase("olivine_block", Material.IRON).setHardness(4000F).setResistance(12),
                new BlockBase("wadsleyite_block", Material.IRON).setHardness(6000F).setResistance(14),
                new BlockBase("ringwoodite_block", Material.IRON).setHardness(8000F).setResistance(16),
                new BlockBase("brigmanite_block", Material.IRON).setHardness(10000F).setResistance(18),
                new BlockBase("majorite_block", Material.IRON).setHardness(12000F).setResistance(20),
                new BlockBase("amazonite_block", Material.IRON).setHardness(17500F).setResistance(25),
                new BlockBase("onyx_block", Material.IRON).setHardness(25000F).setResistance(30),
                new BlocksBase("sulfur_supercompact", Material.ROCK, PlanetMaterial.SULFUR).setHardness(64).setResistance(1),
                new BlocksBase("redstone_supercompact", Material.ROCK, PlanetMaterial.REDSTONE).setHardness(256).setResistance(1),
                new BlocksBase("lapis_supercompact", Material.ROCK, PlanetMaterial.LAPIS).setHardness(256).setResistance(1),
                new BlocksBase("coal_supercompact", Material.ROCK, PlanetMaterial.COAL).setHardness(8).setResistance(1),
                new BlocksBase("aluminum_supercompact", Material.ROCK, PlanetMaterial.ALUMINUM).setHardness(16).setResistance(1),
                new BlocksBase("tin_supercompact", Material.ROCK, PlanetMaterial.TIN).setHardness(32).setResistance(1),
                new BlocksBase("copper_supercompact", Material.ROCK, PlanetMaterial.COPPER).setHardness(32).setResistance(1),
                new BlocksBase("iron_supercompact", Material.ROCK, PlanetMaterial.IRON).setHardness(64).setResistance(1),
                new BlocksBase("silver_supercompact", Material.ROCK, PlanetMaterial.SILVER).setHardness(768).setResistance(1),
                new BlocksBase("gold_supercompact", Material.ROCK, PlanetMaterial.GOLD).setHardness(1536).setResistance(1),
                new BlocksBase("platinum_supercompact", Material.ROCK, PlanetMaterial.PLATINUM).setHardness(2304).setResistance(2),
                new BlocksBase("titanum_supercompact", Material.ROCK, PlanetMaterial.TITANUM).setHardness(3072).setResistance(3),
                new BlocksBase("uranum_supercompact", Material.ROCK, PlanetMaterial.URANUM).setHardness(3072).setResistance(4),
                new BlocksBase("tungsten_supercompact", Material.ROCK, PlanetMaterial.TUNGSTEN).setHardness(6400).setResistance(5),
                new BlocksBase("emerald_supercompact", Material.ROCK, PlanetMaterial.EMERALD).setHardness(25600).setResistance(6),
                new BlocksBase("ruby_supercompact", Material.ROCK, PlanetMaterial.RUBY).setHardness(51200).setResistance(7),
                new BlocksBase("sapphire_supercompact", Material.ROCK, PlanetMaterial.SAPPHIRE).setHardness(76800).setResistance(8),
                new BlocksBase("diamond_supercompact", Material.ROCK, PlanetMaterial.DIAMOND).setHardness(128000).setResistance(10),
                new BlocksBase("olivine_supercompact", Material.ROCK, PlanetMaterial.OLIVINE).setHardness(256000).setResistance(12),
                new BlocksBase("wadsleyite_supercompact", Material.ROCK, PlanetMaterial.WADSLEYITE).setHardness(384000).setResistance(14),
                new BlocksBase("ringwoodite_supercompact", Material.ROCK, PlanetMaterial.RINGWOODITE).setHardness(512000).setResistance(16),
                new BlocksBase("brigmanite_supercompact", Material.ROCK, PlanetMaterial.BRIGMANITE).setHardness(640000).setResistance(18),
                new BlocksBase("majorite_supercompact", Material.ROCK, PlanetMaterial.MAJORITE).setHardness(768000).setResistance(20),
                new BlocksBase("amazonite_supercompact", Material.ROCK, PlanetMaterial.AMAZONITE).setHardness(1120000).setResistance(25),
                new BlocksBase("onyx_supercompact", Material.ROCK, PlanetMaterial.ONYX).setHardness(1600000).setResistance(30),
                new BlockBase("limestone", Material.ROCK).setResistance(1),
                new Crustrock("crustrock", Material.ROCK).setResistance(1),
                new Mantlerock("mantlerock", Material.ROCK).setResistance(1),
                new Corestone("corestone", Material.ROCK).setResistance(1),

                new OreBase("ore_aluminum", Material.ROCK, PlanetMaterial.ALUMINUM, PlanetHardness.ALUMINUM).setResistance(1),
                new OreBase("ore_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON).setResistance(1),
                new OreBase("ore_copper", Material.ROCK, PlanetMaterial.COPPER, PlanetHardness.COPPER).setResistance(1),
                new OreBase("ore_tin", Material.ROCK, PlanetMaterial.TIN, PlanetHardness.TIN).setResistance(1),
                new OreBase("ore_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER).setResistance(1),
                new OreBase("ore_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD).setResistance(1),
                new OreBase("ore_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR).setResistance(1),
                new OreSmallBase("ore_small_coal", Material.ROCK, PlanetMaterial.COAL, PlanetHardness.COAL).setResistance(1),
                new OreSmallBase("ore_small_aluminum", Material.ROCK, PlanetMaterial.ALUMINUM, PlanetHardness.ALUMINUM).setResistance(1),
                new OreSmallBase("ore_small_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON).setResistance(1),
                new OreSmallBase("ore_small_copper", Material.ROCK, PlanetMaterial.COPPER, PlanetHardness.COPPER).setResistance(1),
                new OreSmallBase("ore_small_tin", Material.ROCK, PlanetMaterial.TIN, PlanetHardness.TIN).setResistance(1),
                new OreSmallBase("ore_small_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER).setResistance(1),
                new OreSmallBase("ore_small_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD).setResistance(1),
                new OreSmallBase("ore_small_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR).setResistance(1),
                new OreSmallBase("ore_small_lapis", Material.ROCK, PlanetMaterial.LAPIS, PlanetHardness.LAPIS).setResistance(1),
                new OreCompactBase("ore_compact_coal", Material.ROCK, PlanetMaterial.COAL, PlanetHardness.COAL).setResistance(1),
                new OreCompactBase("ore_compact_aluminum", Material.ROCK, PlanetMaterial.ALUMINUM, PlanetHardness.ALUMINUM).setResistance(1),
                new OreCompactBase("ore_compact_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON).setResistance(1),
                new OreCompactBase("ore_compact_copper", Material.ROCK, PlanetMaterial.COPPER, PlanetHardness.COPPER).setResistance(1),
                new OreCompactBase("ore_compact_tin", Material.ROCK, PlanetMaterial.TIN, PlanetHardness.TIN).setResistance(1),
                new OreCompactBase("ore_compact_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER).setResistance(1),
                new OreCompactBase("ore_compact_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD).setResistance(1),
                new OreCompactBase("ore_compact_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR).setResistance(1),
                new OreCompactBase("ore_compact_lapis", Material.ROCK, PlanetMaterial.LAPIS, PlanetHardness.LAPIS).setResistance(1),

                new CrustrockOre("crustrock_coal", Material.ROCK, PlanetMaterial.COAL, PlanetHardness.COAL).setResistance(1),
                new CrustrockOre("crustrock_aluminum", Material.ROCK, PlanetMaterial.ALUMINUM, PlanetHardness.ALUMINUM).setResistance(1),
                new CrustrockOre("crustrock_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON).setResistance(1),
                new CrustrockOre("crustrock_copper", Material.ROCK, PlanetMaterial.COPPER, PlanetHardness.COPPER).setResistance(1),
                new CrustrockOre("crustrock_tin", Material.ROCK, PlanetMaterial.TIN, PlanetHardness.TIN).setResistance(1),
                new CrustrockOre("crustrock_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER).setResistance(1),
                new CrustrockOre("crustrock_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD).setResistance(1),
                new CrustrockOre("crustrock_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR).setResistance(1),
                new CrustrockOre("crustrock_redstone", Material.ROCK, PlanetMaterial.REDSTONE, PlanetHardness.REDSTONE).setResistance(1),
                new CrustrockOre("crustrock_lapis", Material.ROCK, PlanetMaterial.LAPIS, PlanetHardness.LAPIS).setResistance(1),
                new CrustrockOre("crustrock_platinum", Material.ROCK, PlanetMaterial.PLATINUM, PlanetHardness.PLATINUM).setResistance(1),
                new CrustrockOre("crustrock_titanum", Material.ROCK, PlanetMaterial.TITANUM, PlanetHardness.TITANUM).setResistance(1),
                new CrustrockOreSmall("crustrock_small_coal", Material.ROCK, PlanetMaterial.COAL, PlanetHardness.COAL).setResistance(1),
                new CrustrockOreSmall("crustrock_small_aluminum", Material.ROCK, PlanetMaterial.ALUMINUM, PlanetHardness.ALUMINUM).setResistance(1),
                new CrustrockOreSmall("crustrock_small_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON).setResistance(1),
                new CrustrockOreSmall("crustrock_small_copper", Material.ROCK, PlanetMaterial.COPPER, PlanetHardness.COPPER).setResistance(1),
                new CrustrockOreSmall("crustrock_small_tin", Material.ROCK, PlanetMaterial.TIN, PlanetHardness.TIN).setResistance(1),
                new CrustrockOreSmall("crustrock_small_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER).setResistance(1),
                new CrustrockOreSmall("crustrock_small_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD).setResistance(1),
                new CrustrockOreSmall("crustrock_small_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR).setResistance(1),
                new CrustrockOreSmall("crustrock_small_redstone", Material.ROCK, PlanetMaterial.REDSTONE, PlanetHardness.REDSTONE).setResistance(1),
                new CrustrockOreSmall("crustrock_small_lapis", Material.ROCK, PlanetMaterial.LAPIS, PlanetHardness.LAPIS).setResistance(1),
                new CrustrockOreSmall("crustrock_small_platinum", Material.ROCK, PlanetMaterial.PLATINUM, PlanetHardness.PLATINUM).setResistance(1),
                new CrustrockOreSmall("crustrock_small_titanum", Material.ROCK, PlanetMaterial.TITANUM, PlanetHardness.TITANUM).setResistance(1),
                new CrustrockOreCompact("crustrock_compact_coal", Material.ROCK, PlanetMaterial.COAL, PlanetHardness.COAL).setResistance(1),
                new CrustrockOreCompact("crustrock_compact_aluminum", Material.ROCK, PlanetMaterial.ALUMINUM, PlanetHardness.ALUMINUM).setResistance(1),
                new CrustrockOreCompact("crustrock_compact_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON).setResistance(1),
                new CrustrockOreCompact("crustrock_compact_copper", Material.ROCK, PlanetMaterial.COPPER, PlanetHardness.COPPER).setResistance(1),
                new CrustrockOreCompact("crustrock_compact_tin", Material.ROCK, PlanetMaterial.TIN, PlanetHardness.TIN).setResistance(1),
                new CrustrockOreCompact("crustrock_compact_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER).setResistance(1),
                new CrustrockOreCompact("crustrock_compact_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD).setResistance(1),
                new CrustrockOreCompact("crustrock_compact_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR).setResistance(1),
                new CrustrockOreCompact("crustrock_compact_redstone", Material.ROCK, PlanetMaterial.REDSTONE, PlanetHardness.REDSTONE).setResistance(1),
                new CrustrockOreCompact("crustrock_compact_lapis", Material.ROCK, PlanetMaterial.LAPIS, PlanetHardness.LAPIS).setResistance(1),
                new CrustrockOreCompact("crustrock_compact_platinum", Material.ROCK, PlanetMaterial.PLATINUM, PlanetHardness.PLATINUM).setResistance(1),
                new CrustrockOreCompact("crustrock_compact_titanum", Material.ROCK, PlanetMaterial.TITANUM, PlanetHardness.TITANUM).setResistance(1),

                new MantlerockOre("mantlerock_coal", Material.ROCK, PlanetMaterial.COAL, PlanetHardness.COAL).setResistance(1),
                new MantlerockOre("mantlerock_aluminum", Material.ROCK, PlanetMaterial.ALUMINUM, PlanetHardness.ALUMINUM).setResistance(1),
                new MantlerockOre("mantlerock_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON).setResistance(1),
                new MantlerockOre("mantlerock_copper", Material.ROCK, PlanetMaterial.COPPER, PlanetHardness.COPPER).setResistance(1),
                new MantlerockOre("mantlerock_tin", Material.ROCK, PlanetMaterial.TIN, PlanetHardness.TIN).setResistance(1),
                new MantlerockOre("mantlerock_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER).setResistance(1),
                new MantlerockOre("mantlerock_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD).setResistance(1),
                new MantlerockOre("mantlerock_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR).setResistance(1),
                new MantlerockOre("mantlerock_redstone", Material.ROCK, PlanetMaterial.REDSTONE, PlanetHardness.REDSTONE).setResistance(1),
                new MantlerockOre("mantlerock_lapis", Material.ROCK, PlanetMaterial.LAPIS, PlanetHardness.LAPIS).setResistance(1),
                new MantlerockOre("mantlerock_platinum", Material.ROCK, PlanetMaterial.PLATINUM, PlanetHardness.PLATINUM).setResistance(1),
                new MantlerockOre("mantlerock_titanum", Material.ROCK, PlanetMaterial.TITANUM, PlanetHardness.TITANUM).setResistance(1),
                new MantlerockOre("mantlerock_uranum", Material.ROCK, PlanetMaterial.URANUM, PlanetHardness.URANUM).setResistance(1),
                new MantlerockOre("mantlerock_tungsten", Material.ROCK, PlanetMaterial.TUNGSTEN, PlanetHardness.TUNGSTEN).setResistance(1),
                new MantlerockOre("mantlerock_emerald", Material.ROCK, PlanetMaterial.EMERALD, PlanetHardness.EMERALD).setResistance(1),
                new MantlerockOre("mantlerock_ruby", Material.ROCK, PlanetMaterial.RUBY, PlanetHardness.RUBY).setResistance(1),
                new MantlerockOre("mantlerock_sapphire", Material.ROCK, PlanetMaterial.SAPPHIRE, PlanetHardness.SAPPHIRE).setResistance(1),
                new MantlerockOre("mantlerock_diamond", Material.ROCK, PlanetMaterial.DIAMOND, PlanetHardness.DIAMOND).setResistance(1),
                new MantlerockOre("mantlerock_olivine", Material.ROCK, PlanetMaterial.OLIVINE, PlanetHardness.OLIVINE).setResistance(1),
                new MantlerockOre("mantlerock_wadsleyite", Material.ROCK, PlanetMaterial.WADSLEYITE, PlanetHardness.WADSLEYITE).setResistance(1),
                new MantlerockOre("mantlerock_ringwoodite", Material.ROCK, PlanetMaterial.RINGWOODITE, PlanetHardness.RINGWOODITE).setResistance(1),
                new MantlerockOre("mantlerock_brigmanite", Material.ROCK, PlanetMaterial.BRIGMANITE, PlanetHardness.BRIGMANITE).setResistance(1),
                new MantlerockOre("mantlerock_majorite", Material.ROCK, PlanetMaterial.MAJORITE, PlanetHardness.MAJORITE).setResistance(1),
                new MantlerockOre("mantlerock_amazonite", Material.ROCK, PlanetMaterial.AMAZONITE, PlanetHardness.AMAZONITE).setResistance(1),

                new MantlerockOreSmall("mantlerock_small_coal", Material.ROCK, PlanetMaterial.COAL, PlanetHardness.COAL).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_aluminum", Material.ROCK, PlanetMaterial.ALUMINUM, PlanetHardness.ALUMINUM).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_copper", Material.ROCK, PlanetMaterial.COPPER, PlanetHardness.COPPER).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_tin", Material.ROCK, PlanetMaterial.TIN, PlanetHardness.TIN).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_redstone", Material.ROCK, PlanetMaterial.REDSTONE, PlanetHardness.REDSTONE).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_lapis", Material.ROCK, PlanetMaterial.LAPIS, PlanetHardness.LAPIS).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_platinum", Material.ROCK, PlanetMaterial.PLATINUM, PlanetHardness.PLATINUM).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_titanum", Material.ROCK, PlanetMaterial.TITANUM, PlanetHardness.TITANUM).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_uranum", Material.ROCK, PlanetMaterial.URANUM, PlanetHardness.URANUM).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_tungsten", Material.ROCK, PlanetMaterial.TUNGSTEN, PlanetHardness.TUNGSTEN).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_emerald", Material.ROCK, PlanetMaterial.EMERALD, PlanetHardness.EMERALD).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_ruby", Material.ROCK, PlanetMaterial.RUBY, PlanetHardness.RUBY).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_sapphire", Material.ROCK, PlanetMaterial.SAPPHIRE, PlanetHardness.SAPPHIRE).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_diamond", Material.ROCK, PlanetMaterial.DIAMOND, PlanetHardness.DIAMOND).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_olivine", Material.ROCK, PlanetMaterial.OLIVINE, PlanetHardness.OLIVINE).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_wadsleyite", Material.ROCK, PlanetMaterial.WADSLEYITE, PlanetHardness.WADSLEYITE).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_ringwoodite", Material.ROCK, PlanetMaterial.RINGWOODITE, PlanetHardness.RINGWOODITE).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_brigmanite", Material.ROCK, PlanetMaterial.BRIGMANITE, PlanetHardness.BRIGMANITE).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_majorite", Material.ROCK, PlanetMaterial.MAJORITE, PlanetHardness.MAJORITE).setResistance(1),
                new MantlerockOreSmall("mantlerock_small_amazonite", Material.ROCK, PlanetMaterial.AMAZONITE, PlanetHardness.AMAZONITE).setResistance(1),

                new MantlerockOreCompact("mantlerock_compact_coal", Material.ROCK, PlanetMaterial.COAL, PlanetHardness.COAL).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_aluminum", Material.ROCK, PlanetMaterial.ALUMINUM, PlanetHardness.ALUMINUM).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_copper", Material.ROCK, PlanetMaterial.COPPER, PlanetHardness.COPPER).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_tin", Material.ROCK, PlanetMaterial.TIN, PlanetHardness.TIN).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_redstone", Material.ROCK, PlanetMaterial.REDSTONE, PlanetHardness.REDSTONE).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_lapis", Material.ROCK, PlanetMaterial.LAPIS, PlanetHardness.LAPIS).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_platinum", Material.ROCK, PlanetMaterial.PLATINUM, PlanetHardness.PLATINUM).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_titanum", Material.ROCK, PlanetMaterial.TITANUM, PlanetHardness.TITANUM).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_uranum", Material.ROCK, PlanetMaterial.URANUM, PlanetHardness.URANUM).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_tungsten", Material.ROCK, PlanetMaterial.TUNGSTEN, PlanetHardness.TUNGSTEN).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_emerald", Material.ROCK, PlanetMaterial.EMERALD, PlanetHardness.EMERALD).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_ruby", Material.ROCK, PlanetMaterial.RUBY, PlanetHardness.RUBY).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_sapphire", Material.ROCK, PlanetMaterial.SAPPHIRE, PlanetHardness.SAPPHIRE).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_diamond", Material.ROCK, PlanetMaterial.DIAMOND, PlanetHardness.DIAMOND).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_olivine", Material.ROCK, PlanetMaterial.OLIVINE, PlanetHardness.OLIVINE).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_wadsleyite", Material.ROCK, PlanetMaterial.WADSLEYITE, PlanetHardness.WADSLEYITE).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_ringwoodite", Material.ROCK, PlanetMaterial.RINGWOODITE, PlanetHardness.RINGWOODITE).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_brigmanite", Material.ROCK, PlanetMaterial.BRIGMANITE, PlanetHardness.BRIGMANITE).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_majorite", Material.ROCK, PlanetMaterial.MAJORITE, PlanetHardness.MAJORITE).setResistance(1),
                new MantlerockOreCompact("mantlerock_compact_amazonite", Material.ROCK, PlanetMaterial.AMAZONITE, PlanetHardness.AMAZONITE).setResistance(1),

                new CorestoneOre("corestone_emerald", Material.ROCK, PlanetMaterial.EMERALD, PlanetHardness.EMERALD).setResistance(10),
                new CorestoneOre("corestone_ruby", Material.ROCK, PlanetMaterial.RUBY, PlanetHardness.RUBY).setResistance(10),
                new CorestoneOre("corestone_sapphire", Material.ROCK, PlanetMaterial.SAPPHIRE, PlanetHardness.SAPPHIRE).setResistance(10),
                new CorestoneOre("corestone_diamond", Material.ROCK, PlanetMaterial.DIAMOND, PlanetHardness.DIAMOND).setResistance(10),
                new CorestoneOre("corestone_olivine", Material.ROCK, PlanetMaterial.OLIVINE, PlanetHardness.OLIVINE).setResistance(10),
                new CorestoneOre("corestone_wadsleyite", Material.ROCK, PlanetMaterial.WADSLEYITE, PlanetHardness.WADSLEYITE).setResistance(10),
                new CorestoneOre("corestone_ringwoodite", Material.ROCK, PlanetMaterial.RINGWOODITE, PlanetHardness.RINGWOODITE).setResistance(10),
                new CorestoneOre("corestone_brigmanite", Material.ROCK, PlanetMaterial.BRIGMANITE, PlanetHardness.BRIGMANITE).setResistance(10),
                new CorestoneOre("corestone_majorite", Material.ROCK, PlanetMaterial.MAJORITE, PlanetHardness.MAJORITE).setResistance(10),
                new CorestoneOre("corestone_amazonite", Material.ROCK, PlanetMaterial.AMAZONITE, PlanetHardness.AMAZONITE).setResistance(10),
                new CorestoneOre("corestone_onyx", Material.ROCK, PlanetMaterial.ONYX, PlanetHardness.ONYX).setResistance(10),

                new CorestoneOreSmall("corestone_small_emerald", Material.ROCK, PlanetMaterial.EMERALD, PlanetHardness.EMERALD).setResistance(10),
                new CorestoneOreSmall("corestone_small_ruby", Material.ROCK, PlanetMaterial.RUBY, PlanetHardness.RUBY).setResistance(10),
                new CorestoneOreSmall("corestone_small_sapphire", Material.ROCK, PlanetMaterial.SAPPHIRE, PlanetHardness.SAPPHIRE).setResistance(10),
                new CorestoneOreSmall("corestone_small_diamond", Material.ROCK, PlanetMaterial.DIAMOND, PlanetHardness.DIAMOND).setResistance(10),
                new CorestoneOreSmall("corestone_small_olivine", Material.ROCK, PlanetMaterial.OLIVINE, PlanetHardness.OLIVINE).setResistance(10),
                new CorestoneOreSmall("corestone_small_wadsleyite", Material.ROCK, PlanetMaterial.WADSLEYITE, PlanetHardness.WADSLEYITE).setResistance(10),
                new CorestoneOreSmall("corestone_small_ringwoodite", Material.ROCK, PlanetMaterial.RINGWOODITE, PlanetHardness.RINGWOODITE).setResistance(10),
                new CorestoneOreSmall("corestone_small_brigmanite", Material.ROCK, PlanetMaterial.BRIGMANITE, PlanetHardness.BRIGMANITE).setResistance(10),
                new CorestoneOreSmall("corestone_small_majorite", Material.ROCK, PlanetMaterial.MAJORITE, PlanetHardness.MAJORITE).setResistance(10),
                new CorestoneOreSmall("corestone_small_amazonite", Material.ROCK, PlanetMaterial.AMAZONITE, PlanetHardness.AMAZONITE).setResistance(10),
                new CorestoneOreSmall("corestone_small_onyx", Material.ROCK, PlanetMaterial.ONYX, PlanetHardness.ONYX).setResistance(10),

                new CorestoneOreCompact("corestone_compact_emerald", Material.ROCK, PlanetMaterial.EMERALD, PlanetHardness.EMERALD).setResistance(10),
                new CorestoneOreCompact("corestone_compact_ruby", Material.ROCK, PlanetMaterial.RUBY, PlanetHardness.RUBY).setResistance(10),
                new CorestoneOreCompact("corestone_compact_sapphire", Material.ROCK, PlanetMaterial.SAPPHIRE, PlanetHardness.SAPPHIRE).setResistance(10),
                new CorestoneOreCompact("corestone_compact_diamond", Material.ROCK, PlanetMaterial.DIAMOND, PlanetHardness.DIAMOND).setResistance(10),
                new CorestoneOreCompact("corestone_compact_olivine", Material.ROCK, PlanetMaterial.OLIVINE, PlanetHardness.OLIVINE).setResistance(10),
                new CorestoneOreCompact("corestone_compact_wadsleyite", Material.ROCK, PlanetMaterial.WADSLEYITE, PlanetHardness.WADSLEYITE).setResistance(10),
                new CorestoneOreCompact("corestone_compact_ringwoodite", Material.ROCK, PlanetMaterial.RINGWOODITE, PlanetHardness.RINGWOODITE).setResistance(10),
                new CorestoneOreCompact("corestone_compact_brigmanite", Material.ROCK, PlanetMaterial.BRIGMANITE, PlanetHardness.BRIGMANITE).setResistance(10),
                new CorestoneOreCompact("corestone_compact_majorite", Material.ROCK, PlanetMaterial.MAJORITE, PlanetHardness.MAJORITE).setResistance(10),
                new CorestoneOreCompact("corestone_compact_amazonite", Material.ROCK, PlanetMaterial.AMAZONITE, PlanetHardness.AMAZONITE).setResistance(10),
                new CorestoneOreCompact("corestone_compact_onyx", Material.ROCK, PlanetMaterial.ONYX, PlanetHardness.ONYX).setResistance(10)
        );
    }

    public static void registerRenders() {
        for (int meta = 0; meta < 3; meta++) {
            String name = Reference.MOD_ID + ":" + Crustrock.EnumType.values()[meta].getName();
            String name1 = Reference.MOD_ID + ":" + Corestone.EnumType.values()[meta].getName();
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK), meta, new ModelResourceLocation(name, "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COAL), meta, new ModelResourceLocation(name + "_coal", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_SULFUR), meta, new ModelResourceLocation(name + "_sulfur", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_REDSTONE), meta, new ModelResourceLocation(name + "_redstone", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_LAPIS), meta, new ModelResourceLocation(name + "_lapis", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_ALUMINUM), meta, new ModelResourceLocation(name + "_aluminum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_IRON), meta, new ModelResourceLocation(name + "_iron", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COPPER), meta, new ModelResourceLocation(name + "_copper", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_TIN), meta, new ModelResourceLocation(name + "_tin", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_SILVER), meta, new ModelResourceLocation(name + "_silver", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_GOLD), meta, new ModelResourceLocation(name + "_gold", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_PLATINUM), meta, new ModelResourceLocation(name + "_platinum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_TITANUM), meta, new ModelResourceLocation(name + "_titanum", "inventory"));

            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_SMALL_COAL), meta, new ModelResourceLocation(name + "_coal", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_SMALL_SULFUR), meta, new ModelResourceLocation(name + "_sulfur", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_SMALL_REDSTONE), meta, new ModelResourceLocation(name + "_redstone", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_SMALL_LAPIS), meta, new ModelResourceLocation(name + "_lapis", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_SMALL_ALUMINUM), meta, new ModelResourceLocation(name + "_aluminum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_SMALL_IRON), meta, new ModelResourceLocation(name + "_iron", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_SMALL_COPPER), meta, new ModelResourceLocation(name + "_copper", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_SMALL_TIN), meta, new ModelResourceLocation(name + "_tin", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_SMALL_SILVER), meta, new ModelResourceLocation(name + "_silver", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_SMALL_GOLD), meta, new ModelResourceLocation(name + "_gold", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_SMALL_PLATINUM), meta, new ModelResourceLocation(name + "_platinum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_SMALL_TITANUM), meta, new ModelResourceLocation(name + "_titanum", "inventory"));

            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_COAL), meta, new ModelResourceLocation(name + "_coal", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_SULFUR), meta, new ModelResourceLocation(name + "_sulfur", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_REDSTONE), meta, new ModelResourceLocation(name + "_redstone", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_LAPIS), meta, new ModelResourceLocation(name + "_lapis", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_ALUMINUM), meta, new ModelResourceLocation(name + "_aluminum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_IRON), meta, new ModelResourceLocation(name + "_iron", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_COPPER), meta, new ModelResourceLocation(name + "_copper", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_TIN), meta, new ModelResourceLocation(name + "_tin", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_SILVER), meta, new ModelResourceLocation(name + "_silver", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_GOLD), meta, new ModelResourceLocation(name + "_gold", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_PLATINUM), meta, new ModelResourceLocation(name + "_platinum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CRUSTROCK_COMPACT_TITANUM), meta, new ModelResourceLocation(name + "_titanum", "inventory"));

            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE), meta, new ModelResourceLocation(name1, "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_EMERALD), meta, new ModelResourceLocation(name1 + "_emerald", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_RUBY), meta, new ModelResourceLocation(name1 + "_ruby", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_SAPPHIRE), meta, new ModelResourceLocation(name1 + "_sapphire", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_DIAMOND), meta, new ModelResourceLocation(name1 + "_diamond", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_OLIVINE), meta, new ModelResourceLocation(name1 + "_olivine", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_WADSLEYITE), meta, new ModelResourceLocation(name1 + "_wadsleyite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_RINGWOODITE), meta, new ModelResourceLocation(name1 + "_ringwoodite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_BRIGMANITE), meta, new ModelResourceLocation(name1 + "_brigmanite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_MAJORITE), meta, new ModelResourceLocation(name1 + "_majorite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_AMAZONITE), meta, new ModelResourceLocation(name1 + "_amazonite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_ONYX), meta, new ModelResourceLocation(name1 + "_onyx", "inventory"));

            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_SMALL_EMERALD), meta, new ModelResourceLocation(name1 + "_emerald", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_SMALL_RUBY), meta, new ModelResourceLocation(name1 + "_ruby", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_SMALL_SAPPHIRE), meta, new ModelResourceLocation(name1 + "_sapphire", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_SMALL_DIAMOND), meta, new ModelResourceLocation(name1 + "_diamond", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_SMALL_OLIVINE), meta, new ModelResourceLocation(name1 + "_olivine", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_SMALL_WADSLEYITE), meta, new ModelResourceLocation(name1 + "_wadsleyite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_SMALL_RINGWOODITE), meta, new ModelResourceLocation(name1 + "_ringwoodite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_SMALL_BRIGMANITE), meta, new ModelResourceLocation(name1 + "_brigmanite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_SMALL_MAJORITE), meta, new ModelResourceLocation(name1 + "_majorite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_SMALL_AMAZONITE), meta, new ModelResourceLocation(name1 + "_amazonite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_SMALL_ONYX), meta, new ModelResourceLocation(name1 + "_onyx", "inventory"));

            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_EMERALD), meta, new ModelResourceLocation(name1 + "_emerald", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_RUBY), meta, new ModelResourceLocation(name1 + "_ruby", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_SAPPHIRE), meta, new ModelResourceLocation(name1 + "_sapphire", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_DIAMOND), meta, new ModelResourceLocation(name1 + "_diamond", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_OLIVINE), meta, new ModelResourceLocation(name1 + "_olivine", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_WADSLEYITE), meta, new ModelResourceLocation(name1 + "_wadsleyite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_RINGWOODITE), meta, new ModelResourceLocation(name1 + "_ringwoodite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_BRIGMANITE), meta, new ModelResourceLocation(name1 + "_brigmanite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_MAJORITE), meta, new ModelResourceLocation(name1 + "_majorite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_AMAZONITE), meta, new ModelResourceLocation(name1 + "_amazonite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.CORESTONE_COMPACT_ONYX), meta, new ModelResourceLocation(name1 + "_onyx", "inventory"));
        }

        for (int meta = 0; meta < 16; meta++) {
            String name = Reference.MOD_ID + ":" + Mantlerock.EnumType.values()[meta].getName();

            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK), meta, new ModelResourceLocation(name, "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COAL), meta, new ModelResourceLocation(name + "_coal", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SULFUR), meta, new ModelResourceLocation(name + "_sulfur", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_REDSTONE), meta, new ModelResourceLocation(name + "_redstone", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_LAPIS), meta, new ModelResourceLocation(name + "_lapis", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_ALUMINUM), meta, new ModelResourceLocation(name + "_aluminum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_IRON), meta, new ModelResourceLocation(name + "_iron", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COPPER), meta, new ModelResourceLocation(name + "_copper", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_TIN), meta, new ModelResourceLocation(name + "_tin", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SILVER), meta, new ModelResourceLocation(name + "_silver", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_GOLD), meta, new ModelResourceLocation(name + "_gold", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_PLATINUM), meta, new ModelResourceLocation(name + "_platinum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_TITANUM), meta, new ModelResourceLocation(name + "_titanum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_URANUM), meta, new ModelResourceLocation(name + "_uranum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_TUNGSTEN), meta, new ModelResourceLocation(name + "_tungsten", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_EMERALD), meta, new ModelResourceLocation(name + "_emerald", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_RUBY), meta, new ModelResourceLocation(name + "_ruby", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SAPPHIRE), meta, new ModelResourceLocation(name + "_sapphire", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_DIAMOND), meta, new ModelResourceLocation(name + "_diamond", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_OLIVINE), meta, new ModelResourceLocation(name + "_olivine", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_WADSLEYITE), meta, new ModelResourceLocation(name + "_wadsleyite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_RINGWOODITE), meta, new ModelResourceLocation(name + "_ringwoodite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_BRIGMANITE), meta, new ModelResourceLocation(name + "_brigmanite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_MAJORITE), meta, new ModelResourceLocation(name + "_majorite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_AMAZONITE), meta, new ModelResourceLocation(name + "_amazonite", "inventory"));

            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_COAL), meta, new ModelResourceLocation(name + "_coal", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_SULFUR), meta, new ModelResourceLocation(name + "_sulfur", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_REDSTONE), meta, new ModelResourceLocation(name + "_redstone", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_LAPIS), meta, new ModelResourceLocation(name + "_lapis", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_ALUMINUM), meta, new ModelResourceLocation(name + "_aluminum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_IRON), meta, new ModelResourceLocation(name + "_iron", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_COPPER), meta, new ModelResourceLocation(name + "_copper", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_TIN), meta, new ModelResourceLocation(name + "_tin", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_SILVER), meta, new ModelResourceLocation(name + "_silver", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_GOLD), meta, new ModelResourceLocation(name + "_gold", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_PLATINUM), meta, new ModelResourceLocation(name + "_platinum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_TITANUM), meta, new ModelResourceLocation(name + "_titanum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_URANUM), meta, new ModelResourceLocation(name + "_uranum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_TUNGSTEN), meta, new ModelResourceLocation(name + "_tungsten", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_EMERALD), meta, new ModelResourceLocation(name + "_emerald", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_RUBY), meta, new ModelResourceLocation(name + "_ruby", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_SAPPHIRE), meta, new ModelResourceLocation(name + "_sapphire", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_DIAMOND), meta, new ModelResourceLocation(name + "_diamond", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_OLIVINE), meta, new ModelResourceLocation(name + "_olivine", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_WADSLEYITE), meta, new ModelResourceLocation(name + "_wadsleyite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_RINGWOODITE), meta, new ModelResourceLocation(name + "_ringwoodite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_BRIGMANITE), meta, new ModelResourceLocation(name + "_brigmanite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_MAJORITE), meta, new ModelResourceLocation(name + "_majorite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_SMALL_AMAZONITE), meta, new ModelResourceLocation(name + "_amazonite", "inventory"));

            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_COAL), meta, new ModelResourceLocation(name + "_coal", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_SULFUR), meta, new ModelResourceLocation(name + "_sulfur", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_REDSTONE), meta, new ModelResourceLocation(name + "_redstone", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_LAPIS), meta, new ModelResourceLocation(name + "_lapis", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_ALUMINUM), meta, new ModelResourceLocation(name + "_aluminum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_IRON), meta, new ModelResourceLocation(name + "_iron", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_COPPER), meta, new ModelResourceLocation(name + "_copper", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_TIN), meta, new ModelResourceLocation(name + "_tin", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_SILVER), meta, new ModelResourceLocation(name + "_silver", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_GOLD), meta, new ModelResourceLocation(name + "_gold", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_PLATINUM), meta, new ModelResourceLocation(name + "_platinum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_TITANUM), meta, new ModelResourceLocation(name + "_titanum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_URANUM), meta, new ModelResourceLocation(name + "_uranum", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_TUNGSTEN), meta, new ModelResourceLocation(name + "_tungsten", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_EMERALD), meta, new ModelResourceLocation(name + "_emerald", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_RUBY), meta, new ModelResourceLocation(name + "_ruby", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_SAPPHIRE), meta, new ModelResourceLocation(name + "_sapphire", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_DIAMOND), meta, new ModelResourceLocation(name + "_diamond", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_OLIVINE), meta, new ModelResourceLocation(name + "_olivine", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_WADSLEYITE), meta, new ModelResourceLocation(name + "_wadsleyite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_RINGWOODITE), meta, new ModelResourceLocation(name + "_ringwoodite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_BRIGMANITE), meta, new ModelResourceLocation(name + "_brigmanite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_MAJORITE), meta, new ModelResourceLocation(name + "_majorite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.MANTLEROCK_COMPACT_AMAZONITE), meta, new ModelResourceLocation(name + "_amazonite", "inventory"));
        }
    }

    public static List<Block> getBlocks() {
        return BLOCKS;
    }
}