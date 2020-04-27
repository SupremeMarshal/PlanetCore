package com.PlanetCore.init;





import com.PlanetCore.blocks.*;

import com.PlanetCore.util.Reference;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraft.block.Block;

import net.minecraft.block.material.Material;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.command.FunctionObject;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.GameRegistry.ObjectHolder;

import net.minecraftforge.registries.IForgeRegistry;



import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import java.util.ArrayList;

import java.util.List;

import java.util.Locale;

import java.util.function.Function;
import java.util.function.Supplier;

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

        ONYX(OreType.GEM, 16286.0F, 500000.0F),
        AMAZONITE( OreType.GEM, 12868.0F, 300000.0F),
        MAJORITE( OreType.GEM, 10044.0F, 200000.0F),
        BRIGMANITE( OreType.GEM, 7709.0F, 100000.0F),
        RINGWOODITE( OreType.GEM, 5780.0F, 80000.0F),
        WADSLEYITE( OreType.GEM, 4186.0F, 70000.0F),
        OLIVINE( OreType.GEM, 2868.0F, 60000.0F),
        DIAMOND( OreType.GEM, 1779.0F, 50000.0F),
        SAPPHIRE( OreType.GEM, 879.0F, 10000.0F),
        RUBY( OreType.GEM, 879.0F, 10000.0F),
        EMERALD( OreType.GEM, 654.0F, 2500.0F),
        TUNGSTEN( METAL, 510.0F, 5000.0F),
        JADE( OreType.GEM, 389.0F, 1000.0F),
        TOPAZ(OreType.GEM, 289.0F, 500.0F),
        TITANIUM( METAL, 144.0F, 200.0F),
        URANIUM( METAL, 18.0F, 10.0F),
        PLATINUM( METAL, 95.0F, 100.0F),
        GOLD(METAL, 59.0F, 60.0F),
        SILVER(METAL, 34.0F, 30.0F),
        IRON(METAL, 18.0F, 15.0F),
        COPPER(METAL, 9.0F, 1.0F),
        LAPIS(OreType.GEM, 5.0F, 1.0F),
        REDSTONE(OreType.GEM, 4.0F, 1.0F),
        SULFUR(METAL, 3.0F, 1.0F),
        SILICON(METAL, 2.5F, 1.0F),
        TIN(METAL, 2.0F, 1.0F),
        LEAD(METAL, 2.0F, 1.0F),
        ZINC(METAL, 1.5F, 1.0F),
        ALUMINIUM(METAL, 0.5F, 1.0F),
        COAL(METAL, 0.0F, 0.0F);

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
        ORE_VERYSMALL(0.0F, 0.0F, id -> new OreBase(id, Material.ROCK)),
        ORE_SMALL(0.5F, 0.5F, id -> new OreBase(id, Material.ROCK)),
        ORE(1.0F, 1.0F, id -> new OreBase(id, Material.ROCK)),
        ORE_COMPACT(4.0F, 4.0F, id -> new OreBase(id, Material.ROCK)),
        ORE_VERYCOMPACT(16.0F, 16.0F, id -> new OreBase(id, Material.ROCK)),
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


    public static final Crustrock CRUSTROCK = _null();

    public static final Mantlerock MANTLEROCK = _null();

    public static final Corerock CORESTONE = _null();


    // GENERATED END

    public static final Block STEEL_BLOCK = _null();

    //SEDIMENTARY ROCK

    public static final Block LIMESTONE = _null();

    public static List<Block> AllOreBlocks = new ArrayList<>();
    public static List<Block> AllCrustBlocks = new ArrayList<>();
    public static List<Block> AllMantleBlocks = new ArrayList<>();
    public static List<Block> AllCoreBlocks = new ArrayList<>();


    public static void register(IForgeRegistry<Block> registry) {

        boolean generateHolders = System.getProperty("planetcore.generate_holders", "false").equalsIgnoreCase("true");


        /*
        Create a loop to get the coresponding blocks.
         */
        StringBuilder holderGenString = generateHolders ? new StringBuilder(64 * 1024) : null;

        for (ModBlocks.OreForm oreForm : ModBlocks.OreForm.values()) {

            for (ModBlocks.Ore ore : ModBlocks.Ore.values()) {

                    String registryName;
                    registryName = oreForm.name().toLowerCase(Locale.ROOT) + "_" + ore.name().toLowerCase(Locale.ROOT);
                    Block block = oreForm.makeBlock(registryName);

                    block.setHardness((float) (ore.getOreHardness() * (oreForm.getBaseHardness())));

                    block.setResistance((float) (ore.getOreResistance() * (oreForm.getBaseResistance())));

                    registry.register(block);
                    if (oreForm == ModBlocks.OreForm.ORE_VERYSMALL || oreForm == ModBlocks.OreForm.ORE_SMALL || oreForm == ModBlocks.OreForm.ORE
                            || oreForm == ModBlocks.OreForm.ORE_COMPACT || oreForm == ModBlocks.OreForm.ORE_VERYCOMPACT) {
                        AllOreBlocks.add(block);

                    }
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
            if (oreForm == OreForm.CRUSTROCK || oreForm == OreForm.MANTLEROCK || oreForm == OreForm.CORESTONE) {
                String registryName;
                registryName = oreForm.name().toLowerCase(Locale.ROOT);
                Block block = oreForm.makeBlock(registryName);
                System.out.println(block.getRegistryName());
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


        for (Block block : AllOreBlocks) {
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), 0, new ModelResourceLocation(block.getRegistryName(), "inventory"));
        }

        for (Block block : AllCrustBlocks) {
            for (int meta = 0; meta < 3; meta++) {

                if (block == ModBlocks.CRUSTROCK) {
                    ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(block), meta,
                            new ModelResourceLocation(Reference.MOD_ID + ":" + Crustrock.EnumType.values()[meta].getName(), "inventory"));

                }
                if (block != ModBlocks.CRUSTROCK) {
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
                if (block != ModBlocks.MANTLEROCK) {
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
                if (block != ModBlocks.CORESTONE) {
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