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

import java.lang.reflect.Field;
import java.util.ArrayList;

import java.util.HashSet;
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

    public enum ItemDropped {
        SHARD,
        ORE
    }


    public enum Ore {

        ONYX(OreType.GEM, 55500.0F, 9.5F),
        AMAZONITE(OreType.GEM, 24666.0F, 9.0F),
        MAJORITE(OreType.GEM, 10963.0F, 8.5F),
        BRIGMANITE(OreType.GEM, 9975.0F, 8.0F),
        RINGWOODITE(OreType.GEM, 6650.0F, 7.5F),
        WADSLEYITE(OreType.GEM, 4433.0F, 7.0F),
        OLIVINE(OreType.GEM, 2955.0F, 6.5F),
        DIAMOND(OreType.GEM, 1970.0F, 6.0F),
        SAPPHIRE(OreType.GEM, 1313.0F, 5.5F),
        RUBY(OreType.GEM, 875.0F, 5.0F),
        EMERALD(OreType.GEM, 583.0F, 3.5F),
        TUNGSTEN(METAL, 76.0F, 3.0F),
        JADE(OreType.GEM, 389.0F, 2.5F),
        TOPAZ(OreType.GEM, 259.0F, 2.0F),
        TITANIUM(METAL, 51.0F, 1.5F),
        URANIUM(METAL, 115.0F, 1.0F),
        PLATINUM(METAL, 34.0F, 1.3F),
        GOLD(METAL, 22.0F, 1.2F),
        SILVER(METAL, 15.0F, 1.1F),
        IRON(METAL, 10.0F, 1.0F),
        LAPIS(OreType.GEM, 5.0F, 1.0F),
        REDSTONE(OreType.GEM, 5.0F, 1.0F),
        SULFUR(METAL, 3.0F, 1.0F),
        ZINC(METAL, 6.75F, 1.0F),
        COPPER(METAL, 4.5F, 1.0F),
        TIN(METAL, 4.5F, 1.0F),
        SILICON(METAL, 3F, 1.0F),
        LEAD(METAL, 2.0F, 1.0F),
        ALUMINIUM(METAL, 1.0F, 1.0F),
        COAL(METAL, 0.1F, 0.0F);

        private final OreType type;
        private final double oreHardness;
        private final double oreResistance;

        Ore(OreType type, double oreHardness, double oreResistance) {
            this.type = type;
            this.oreHardness = oreHardness;
            this.oreResistance = oreResistance;
        }

        public OreType getType() {
            return this.type;
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
        //ORE_VERYSMALL(0.0F, 0.0F, id -> new OreBase(id, Material.ROCK)),
        ORE_SMALL(0.25F, 1 + 0.5F, id -> new BlockBase(id, Material.ROCK)),
        ORE(1.0F, 1 + 1F, id -> new BlockBase(id, Material.ROCK)),
        ORE_COMPACT(4.0F, 1 + 1.2F, id -> new BlockBase(id, Material.ROCK)),
        //ORE_VERYCOMPACT(16.0F, 16.0F, id -> new OreBase(id, Material.ROCK)),
        //CRUSTROCK_VERYSMALL(0.0F, 0.0F, id -> new Crustrock(id, Material.ROCK)),
        CRUSTROCK_SMALL(0.25F, 1 + 0.5F, id -> new Crustrock(id, Material.ROCK)),
        CRUSTROCK(1.0F, 1 + 1F, id -> new Crustrock(id, Material.ROCK)),
        CRUSTROCK_COMPACT(4.0F, 1 + 1.2F, id -> new Crustrock(id, Material.ROCK)),
        //CRUSTROCK_VERYCOMPACT(16.0F, 16.0F, id -> new Crustrock(id, Material.ROCK)),
        //MANTLEROCK_VERYSMALL(0.0F, 0.0F, id -> new Mantlerock(id, Material.ROCK)),
        MANTLEROCK_SMALL(0.25F, 1 + 0.5F, id -> new Mantlerock(id, Material.ROCK)),
        MANTLEROCK(1.0F, 1 + 1F, id -> new Mantlerock(id, Material.ROCK)),
        MANTLEROCK_COMPACT(4.0F, 1 + 1.2F, id -> new Mantlerock(id, Material.ROCK)),
        //MANTLEROCK_VERYCOMPACT(16.0F, 16.0F, id -> new Mantlerock(id, Material.ROCK)),
        //CORESTONE_VERYSMALL(0.0F, 0.0F, id -> new Corerock(id, Material.ROCK)),
        CORESTONE_SMALL(0.25F, 0.5F, id -> new Corerock(id, Material.ROCK)),
        CORESTONE(1.0F, 2 + 1F, id -> new Corerock(id, Material.ROCK)),
        CORESTONE_COMPACT(4.0F, 2 + 1.2F, id -> new Corerock(id, Material.ROCK));
        //CORESTONE_VERYCOMPACT(16.0F, 16.0F, id -> new Corerock(id, Material.ROCK));

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

    public static final BlockBase ORE_SMALL_COPPER = _null();
    public static final BlockBase ORE_COPPER = _null();
    public static final BlockBase ORE_COMPACT_COPPER = _null();

    public static final BlockBase ORE_SMALL_TIN = _null();
    public static final BlockBase ORE_TIN = _null();
    public static final BlockBase ORE_COMPACT_TIN = _null();

    public static final Crustrock CRUSTROCK_SMALL_COPPER = _null();
    public static final Crustrock CRUSTROCK_COPPER = _null();
    public static final Crustrock CRUSTROCK_COMPACT_COPPER = _null();

    public static final Crustrock CRUSTROCK_SMALL_TIN = _null();
    public static final Crustrock CRUSTROCK_TIN = _null();
    public static final Crustrock CRUSTROCK_COMPACT_TIN = _null();

    public static final BlockBase ORE_SMALL_IRON = _null();
    public static final BlockBase ORE_IRON = _null();
    public static final BlockBase ORE_COMPACT_IRON = _null();

    public static final Crustrock CRUSTROCK_SMALL_IRON = _null();
    public static final Crustrock CRUSTROCK_IRON = _null();
    public static final Crustrock CRUSTROCK_COMPACT_IRON = _null();

    public static final Mantlerock MANTLEROCK_SMALL_IRON = _null();
    public static final Mantlerock MANTLEROCK_IRON = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_IRON = _null();

    public static final Mantlerock MANTLEROCK_SMALL_COPPER = _null();
    public static final Mantlerock MANTLEROCK_COPPER = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_COPPER = _null();

    public static final Mantlerock MANTLEROCK_SMALL_TIN = _null();
    public static final Mantlerock MANTLEROCK_TIN = _null();
    public static final Mantlerock MANTLEROCK_COMPACT_TIN = _null();

    public static final BlocksBase ONYX_BLOCK = _null();
    public static final BlocksBase AMAZONITE_BLOCK = _null();
    public static final BlocksBase MAJORITE_BLOCK = _null();
    public static final BlocksBase BRIGMANITE_BLOCK = _null();
    public static final BlocksBase RINGWOODITE_BLOCK = _null();
    public static final BlocksBase OLIVINE_BLOCK = _null();
    public static final BlocksBase DIAMOND_BLOCK = _null();
    public static final BlocksBase SAPPHIRE_BLOCK = _null();
    public static final BlocksBase RUBY_BLOCK = _null();
    public static final BlocksBase TUNGSTEN_TITANIUM_BLOCK = _null();
    public static final BlocksBase TUNGSTEN_URANIUM_BLOCK = _null();
    public static final BlocksBase TUNGSTEN_BLOCK = _null();
    public static final BlocksBase TITANIUM_URANIUM_BLOCK = _null();
    public static final BlocksBase TITANIUM_BLOCK = _null();
    public static final BlocksBase URANIUM_BLOCK = _null();
    public static final BlocksBase PLATINUM_BLOCK = _null();
    public static final BlocksBase JADE_BLOCK = _null();
    public static final BlocksBase TOPAZ_BLOCK = _null();
    public static final BlocksBase GOLD_BLOCK = _null();
    public static final BlocksBase SILVER_BLOCK = _null();
    public static final BlocksBase SULFUR_BLOCK = _null();
    public static final BlocksBase BRONZE_BLOCK = _null();
    public static final BlocksBase STEEL_BLOCK = _null();
    public static final BlocksBase IRON_BLOCK = _null();
    public static final BlocksBase COPPER_BLOCK = _null();
    public static final BlocksBase TIN_BLOCK = _null();
    public static final BlocksBase ZINC_BLOCK = _null();
    public static final BlocksBase SILICON_BLOCK = _null();
    public static final BlocksBase LEAD_BLOCK = _null();
    public static final BlocksBase ALUMINIUM_BLOCK = _null();

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
    public static final BlocksBase URANIUM_SUPERCOMPACT = _null();
    public static final BlocksBase TUNGSTEN_SUPERCOMPACT = _null();
    public static final BlocksBase TITANIUM_SUPERCOMPACT = _null();
    public static final BlocksBase PLATINUM_SUPERCOMPACT = _null();
    public static final BlocksBase JADE_SUPERCOMPACT = _null();
    public static final BlocksBase TOPAZ_SUPERCOMPACT = _null();
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
    public static final BlocksBase ZINC_SUPERCOMPACT = _null();
    public static final BlocksBase SILICON_SUPERCOMPACT = _null();
    public static final BlocksBase LEAD_SUPERCOMPACT = _null();
    public static final BlocksBase ALUMINIUM_SUPERCOMPACT = _null();
    public static final BlocksBase COAL_SUPERCOMPACT = _null();

    public static final BlockBase CRUST_COBBLESTONE = _null();

    // GENERATED BEGIN


    public static final Crustrock CRUSTROCK = _null();

    public static final Mantlerock MANTLEROCK = _null();

    public static final Corerock CORESTONE = _null();

    public static final Corerock COLD_CORESTONE = _null();


    // GENERATED END


    //SEDIMENTARY ROCK

    public static final Block LIMESTONE = _null();

    public static List<Block> AllOreBlocks = new ArrayList<>();
    public static List<Block> AllCrustBlocks = new ArrayList<>();
    public static List<Block> AllMantleBlocks = new ArrayList<>();
    public static List<Block> AllCoreBlocks = new ArrayList<>();
    public static List<Block> rock = new ArrayList<>();


    public static void register(IForgeRegistry<Block> registry) {

        boolean generateHolders = System.getProperty("planetcore.generate_holders", "false").equalsIgnoreCase("true");


        /*
        Create a loop to get the coresponding blocks.
         */
        StringBuilder holderGenString = generateHolders ? new StringBuilder(64 * 1024) : null;

        OreForm[] oreForms = new OreForm[] {OreForm.CRUSTROCK ,OreForm.MANTLEROCK, OreForm.CORESTONE};

        for (OreForm oreForm : oreForms) {
            String registryName = oreForm.name().toLowerCase(Locale.ROOT);
            Block block = oreForm.makeBlock(registryName);
            registry.register(block);
            rock.add(block);
        }

        for (ModBlocks.OreForm oreForm : ModBlocks.OreForm.values()) {

            for (ModBlocks.Ore ore : ModBlocks.Ore.values()) {
                if (ore.type == OreType.METAL && (oreForm == OreForm.CORESTONE || /*oreForm == OreForm.CORESTONE_VERYSMALL || */ oreForm == OreForm.CORESTONE_SMALL
                        || oreForm == OreForm.CORESTONE_COMPACT /* || oreForm == OreForm.CORESTONE_VERYCOMPACT */)) {
                    continue;
                }
                String registryName = oreForm.name().toLowerCase(Locale.ROOT) + "_" + ore.name().toLowerCase(Locale.ROOT);
                Block block = oreForm.makeBlock(registryName);

                block.setHardness((float) (ore.getOreHardness() * (oreForm.getBaseHardness())));

                block.setResistance((float) (ore.getOreResistance() * (oreForm.getBaseResistance())));

                registry.register(block);
                //BLOCKS.add(block);

                if (registryName.contains("ore_")) {
                    AllOreBlocks.add(block);
                }
                if (registryName.contains("crustrock")) {
                    AllCrustBlocks.add(block);
                }
                if (registryName.contains("mantlerock")) {
                    AllMantleBlocks.add(block);
                }
                if (registryName.contains("corestone")) {
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

                new BlockBase("crust_cobblestone", Material.ROCK).setResistance(6).setHardness(10.0F),
                new CrustrockFurnace("crustrock_furnace", false).setHardness(12.0F).setResistance(6).setCreativeTab(CreativeTabs.DECORATIONS),
                new CrustrockFurnace("lit_crustrock_furnace", true).setHardness(8.0F).setResistance(500).setLightLevel(0.975F),
                new SulfuricAcidFluid("sulfuric_acid", ModFluids.SULFURIC_ACID_FLUID, Material.WATER),
                new HotLavaFluid("hot_lava", ModFluids.HOT_LAVA_FLUID, Material.LAVA),
                new ActiveLavaFluid("active_lava", ModFluids.ACTIVE_LAVA_FLUID, Material.LAVA),
                new CoreLavaFluid("core_lava", ModFluids.CORE_LAVA_FLUID, Material.LAVA),
                new OnyxLavaFluid("onyx_lava", ModFluids.ONYX_LAVA_FLUID, Material.LAVA),
                new BlocksBase("sulfur_block", Material.ROCK).setResistance(1).setHardness(40F),
                new BlocksBase("aluminium_block", Material.ROCK).setResistance(1).setHardness(10F),
                new BlocksBase("zinc_block", Material.ROCK).setResistance(1).setHardness(60.0F),
                new BlocksBase("lead_block", Material.ROCK).setResistance(1).setHardness(15.0F),
                new BlocksBase("tin_block", Material.ROCK).setResistance(2).setHardness(50.0F),
                new BlocksBase("copper_block", Material.ROCK).setResistance(2).setHardness(50.0F),
                new BlocksBase("silicon_block", Material.ROCK).setResistance(1).setHardness(25.0F),
                new BlocksBase("iron_block", Material.ROCK).setResistance(3).setHardness(75.0F),
                new BlocksBase("steel_block", Material.ROCK).setResistance(4).setHardness(100.0F),
                new BlocksBase("bronze_block", Material.ROCK).setResistance(4).setHardness(125.0F),
                new BlocksBase("silver_block", Material.ROCK).setResistance(5).setHardness(150.0F),
                new BlocksBase("gold_block", Material.ROCK).setResistance(6).setHardness(175F),
                new BlocksBase("platinum_block", Material.ROCK).setResistance(7).setHardness(200F),
                new BlocksBase("titanium_block", Material.ROCK).setResistance(8).setHardness(225F),
                new BlocksBase("titanium_uranium_block", Material.ROCK).setResistance(8).setHardness(225F),
                new BlocksBase("uranium_block", Material.ROCK).setResistance(2).setHardness(50F),
                new BlocksBase("tungsten_block", Material.ROCK).setResistance(9).setHardness(250F),
                new BlocksBase("tungsten_uranium_block", Material.ROCK).setResistance(9).setHardness(250F),
                new BlocksBase("tungsten_titanium_block", Material.ROCK).setResistance(10).setHardness(275F),
                new BlocksBase("topaz_block", Material.ROCK).setResistance(6).setHardness(300F),
                new BlocksBase("jade_block", Material.ROCK).setResistance(6).setHardness(325F),
                new BlocksBase("sapphire_block", Material.ROCK).setResistance(11).setHardness(350F),
                new BlocksBase("ruby_block", Material.ROCK).setResistance(11).setHardness(375F),
                new BlocksBase("diamond_block", Material.ROCK).setResistance(12).setHardness(400F),
                new BlocksBase("olivine_block", Material.ROCK).setResistance(13).setHardness(425F),
                new BlocksBase("wadsleyite_block", Material.ROCK).setResistance(14).setHardness(450F),
                new BlocksBase("ringwoodite_block", Material.ROCK).setResistance(15).setHardness(475F),
                new BlocksBase("brigmanite_block", Material.ROCK).setResistance(16).setHardness(500F),
                new BlocksBase("majorite_block", Material.ROCK).setResistance(17).setHardness(525F),
                new BlocksBase("amazonite_block", Material.ROCK).setResistance(18).setHardness(550F),
                new BlocksBase("onyx_block", Material.ROCK).setResistance(19).setHardness(575F),
                new BlocksBase("sulfur_supercompact", Material.ROCK).setResistance(1).setHardness(64),
                new BlocksBase("redstone_supercompact", Material.ROCK).setResistance(3).setHardness(192),
                new BlocksBase("lapis_supercompact", Material.ROCK).setResistance(4).setHardness(224),
                new BlocksBase("coal_supercompact", Material.ROCK).setResistance(1).setHardness(5.0F),
                new BlocksBase("aluminium_supercompact", Material.ROCK).setResistance(1).setHardness(9.6F),
                new BlocksBase("zinc_supercompact", Material.ROCK).setResistance(2).setHardness(160.0F),
                new BlocksBase("lead_supercompact", Material.ROCK).setResistance(2).setHardness(24.0F),
                new BlocksBase("tin_supercompact", Material.ROCK).setResistance(2).setHardness(96.0F),
                new BlocksBase("copper_supercompact", Material.ROCK).setResistance(2).setHardness(128.0F),
                new BlocksBase("silicon_supercompact", Material.ROCK).setResistance(2).setHardness(48.0F),
                new BlocksBase("iron_supercompact", Material.ROCK).setResistance(5).setHardness(288.0F),
                new BlocksBase("silver_supercompact", Material.ROCK).setResistance(5).setHardness(544),
                new BlocksBase("gold_supercompact", Material.ROCK).setResistance(6).setHardness(944),
                new BlocksBase("platinum_supercompact", Material.ROCK).setResistance(6).setHardness(1520),
                new BlocksBase("titanium_supercompact", Material.ROCK).setResistance(7).setHardness(2304),
                new BlocksBase("uranium_supercompact", Material.ROCK).setResistance(5).setHardness(288),
                new BlocksBase("tungsten_supercompact", Material.ROCK).setResistance(8).setHardness(8160),
                new BlocksBase("topaz_supercompact", Material.ROCK).setResistance(7).setHardness(4624),
                new BlocksBase("jade_supercompact", Material.ROCK).setResistance(8).setHardness(6224),
                new BlocksBase("emerald_supercompact", Material.ROCK).setResistance(3).setHardness(6224),
                new BlocksBase("sapphire_supercompact", Material.ROCK).setResistance(9).setHardness(10000),
                new BlocksBase("ruby_supercompact", Material.ROCK).setResistance(10).setHardness(10000),
                new BlocksBase("diamond_supercompact", Material.ROCK).setResistance(11).setHardness(20000),
                new BlocksBase("olivine_supercompact", Material.ROCK).setResistance(12).setHardness(22000),
                new BlocksBase("wadsleyite_supercompact", Material.ROCK).setResistance(13).setHardness(24000),
                new BlocksBase("ringwoodite_supercompact", Material.ROCK).setResistance(14).setHardness(26000),
                new BlocksBase("brigmanite_supercompact", Material.ROCK).setResistance(15).setHardness(28000),
                new BlocksBase("majorite_supercompact", Material.ROCK).setResistance(16).setHardness(30000),
                new BlocksBase("amazonite_supercompact", Material.ROCK).setResistance(17).setHardness(32000),
                new BlocksBase("onyx_supercompact", Material.ROCK).setResistance(18).setHardness(50000),
                new BlockBase("limestone", Material.ROCK));
                /*
                new Crustrock("crustrock", Material.ROCK),
                new Mantlerock("mantlerock", Material.ROCK),
                new Corerock("corestone", Material.ROCK)

                 */
    }


    public static void registerRenders() {
        for (Block block : rock) {
            if (block.getRegistryName().toString().equals("planetcore:crustrock")) {
                for (int meta = 0; meta < 9; meta++) {
                    String name = Reference.MOD_ID + ":" + Crustrock.EnumType.values()[meta].getName();
                    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                            new ModelResourceLocation(name, "inventory"));
                }
            }
            if (block.getRegistryName().toString().equals("planetcore:mantlerock")) {
                for (int meta = 0; meta < 16; meta++) {
                    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                            new ModelResourceLocation(Reference.MOD_ID + ":" + Mantlerock.EnumType.values()[meta].getName(), "inventory"));
                }
            }
            if (block.getRegistryName().toString().equals("planetcore:corestone")) {
                for (int meta = 0; meta < 3; meta++) {
                    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                            new ModelResourceLocation(Reference.MOD_ID + ":" + Corerock.EnumType.values()[meta].getName(), "inventory"));
                }
            }
        }

        for (Block block : AllOreBlocks) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
        }

        for (Block block : AllCrustBlocks) {
            for (int meta = 0; meta < 9; meta++) {
                if (block.getRegistryName().toString().contains("crustrock_")) {
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

                if (block.getRegistryName().toString().contains("mantlerock_")) {
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
                if (block.getRegistryName().toString().contains("corestone_")) {
                    String name = block.getRegistryName().toString();
                    String removeRocktype = name.replace("corestone_", "");
                    String ore = removeRocktype.replace("planetcore:", "");
                    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                            new ModelResourceLocation("planetcore:" + Corerock.EnumType.values()[meta].getName() + "_" + ore, "inventory"));
                }
            }
        }
    }

    public static List<Block> getBlocks() {
        return BLOCKS;
    }
}