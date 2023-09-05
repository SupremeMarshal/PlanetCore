package com.PlanetCore.init;


import com.PlanetCore.blocks.*;
import com.PlanetCore.blocks.Powered_ladders.DiamondLadderBlock;
import com.PlanetCore.blocks.Powered_ladders.IronLadderBlock;
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
    @ObjectHolder("superheated_lava")
    public static final IronLavaFluid SUPERHEATED_LAVA_FLUID = _null();
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

    public static final HotRocks GRANITE = _null();
    public static final HotRocks DIORITE = _null();
    public static final HotRocks ANDESITE = _null();

    public static final BoulderBase BOULDER = _null();
    public static final BoulderBase HOT_BOULDER = _null();
    public static final BoulderBase LOWERMANTLE_BOULDER = _null();
    public static final BoulderBase OUTERCORE_BOULDER = _null();
    public static final BoulderBase INNERCORE_BOULDER = _null();
    public static final BoulderBase CALCITE = _null();
    public static final BoulderBase BLACKSTONE = _null();

    public static final BlockBase MANTLE_MAGMA = _null();
    public static final BlockBase LOWERMANTLE_MAGMA = _null();
    public static final BlockBase OUTERCORE_MAGMA = _null();
    public static final BlockBase INNERCORE_MAGMA = _null();

    public static final IronLadderBlock IRON_LADDERS = _null();
    public static final DiamondLadderBlock DIAMOND_LADDERS = _null();

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

    public static final Slate SLATE = _null();
    public static final SlateOre SLATE_COAL = _null();
    public static final SlateOre SLATE_SULFUR = _null();
    public static final SlateOre SLATE_REDSTONE = _null();
    public static final SlateOre SLATE_LAPIS = _null();
    public static final SlateOre SLATE_IRON = _null();
    public static final SlateOre SLATE_SILVER = _null();
    public static final SlateOre SLATE_GOLD = _null();
    public static final SlateOre SLATE_TITANIUM = _null();
    public static final SlateOre SLATE_URANIUM = _null();
    public static final SlateOre SLATE_TUNGSTEN = _null();
    public static final SlateOre SLATE_RUBY = _null();
    public static final SlateOre SLATE_SAPPHIRE = _null();
    public static final SlateOre SLATE_EMERALD = _null();
    public static final SlateOre SLATE_DIAMOND = _null();
    public static final SlateOre SLATE_MAJORITE = _null();
    public static final SlateOre SLATE_AMAZONITE = _null();
    public static final SlateOre SLATE_ONYX = _null();
    public static final SlateOre SLATE_PAINITE = _null();

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


    // GENERATED END

    public static void register(IForgeRegistry<Block> registry) {

        boolean generateHolders = System.getProperty("planetcore.generate_holders", "false").equalsIgnoreCase("true");


        /*
        Create a loop to get the coresponding blocks.
         */

        registry.registerAll(

                new IronLadderBlock().setTranslationKey("iron_ladders").setRegistryName("iron_ladders").setCreativeTab(CreativeTabs.BUILDING_BLOCKS),
                new DiamondLadderBlock().setTranslationKey("diamond_ladders").setRegistryName("diamond_ladders").setCreativeTab(CreativeTabs.BUILDING_BLOCKS),
                new MagmaBase("mantle_magma", Material.ROCK).setHardness(1.0f),
                new MagmaBase("lowermantle_magma", Material.ROCK).setHardness(1.0f),
                new MagmaBase("outercore_magma", Material.ROCK).setHardness(1.0f),
                new MagmaBase("innercore_magma", Material.ROCK).setHardness(1.0f),
                new BoulderBase("boulder", Material.ROCK).setHardness(1000000.0F),
                new BoulderBase("red_boulder", Material.ROCK).setHardness(1000000.0F),
                new BoulderBase("mantle_boulder", Material.ROCK).setHardness(1000000.0F),
                new BoulderBase("lowermantle_boulder", Material.ROCK).setHardness(1000000.0F),
                new BoulderBase("outercore_boulder", Material.ROCK).setHardness(1000000.0F),
                new BoulderBase("innercore_boulder", Material.ROCK).setHardness(1000000.0F),
                new BlockBase("calcite", Material.ROCK, false).setHardness(5.0F),
                new BlockBase("blackstone", Material.ROCK, false).setHardness(25.0F),
                new BlockBase("crust_cobblestone", Material.ROCK,false).setHardness(2.0F).setResistance(1),
                new SuperheatedRocks("superheated_bedrock", Material.ROCK, PlanetHardness.AMAZONITE).setResistance(1000000),
                new HotRocks("granite", Material.ROCK, PlanetHardness.HOT_ROCK).setResistance(2),
                new HotRocks("diorite", Material.ROCK, PlanetHardness.HOT_ROCK).setResistance(2),
                new HotRocks("andesite", Material.ROCK, PlanetHardness.HOT_ROCK).setResistance(2),
                new IronLavaFluid("iron_lava", ModFluids.IRON_LAVA_FLUID, Material.LAVA).setDensity(1500),
                new IronLavaFluid("superheated_lava", ModFluids.SUPERHEATED_LAVA_FLUID, Material.LAVA).setDensity(1500),
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
                new VeryHotRocks("hot_mantlerock", Material.ROCK, PlanetHardness.HOT_ROCK).setResistance(1).setLightLevel(3),
                new VeryHotRocks("hot_mantlerock1", Material.ROCK, PlanetHardness.HOT_ROCK).setResistance(1).setLightLevel(5),
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
                new Slate("slate", Material.ROCK),

                new OreBase("ore_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER, PlanetHarvestLevel.SILVER,PlanetExp.SILVER).setResistance(1),
                new OreBase("ore_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR, PlanetHarvestLevel.SULFUR,PlanetExp.SULFUR).setResistance(1),

                new SlateOre("slate_coal", Material.ROCK, PlanetMaterial.COAL, PlanetHardness.COAL, PlanetHarvestLevel.COAL,PlanetExp.COAL).setResistance(1),
                new SlateOre("slate_iron", Material.ROCK, PlanetMaterial.IRON, PlanetHardness.IRON, PlanetHarvestLevel.IRON,PlanetExp.IRON).setResistance(1),
                new SlateOre("slate_silver", Material.ROCK, PlanetMaterial.SILVER, PlanetHardness.SILVER, PlanetHarvestLevel.SILVER,PlanetExp.SILVER).setResistance(1),
                new SlateOre("slate_gold", Material.ROCK, PlanetMaterial.GOLD, PlanetHardness.GOLD, PlanetHarvestLevel.GOLD,PlanetExp.GOLD).setResistance(1),
                new SlateOre("slate_sulfur", Material.ROCK, PlanetMaterial.SULFUR, PlanetHardness.SULFUR, PlanetHarvestLevel.SULFUR,PlanetExp.SULFUR).setResistance(1),
                new SlateOre("slate_redstone", Material.ROCK, PlanetMaterial.REDSTONE, PlanetHardness.REDSTONE, PlanetHarvestLevel.REDSTONE,PlanetExp.REDSTONE).setResistance(1),
                new SlateOre("slate_lapis", Material.ROCK, PlanetMaterial.LAPIS, PlanetHardness.LAPIS, PlanetHarvestLevel.LAPIS,PlanetExp.LAPIS).setResistance(1),
                new SlateOre("slate_titanium", Material.ROCK, PlanetMaterial.TITANIUM, PlanetHardness.TITANIUM, PlanetHarvestLevel.TITANIUM,PlanetExp.TITANIUM).setResistance(1),
                new SlateOre("slate_uranium", Material.ROCK, PlanetMaterial.URANIUM, PlanetHardness.URANIUM, PlanetHarvestLevel.URANIUM,PlanetExp.URANIUM).setResistance(1),
                new SlateOre("slate_tungsten", Material.ROCK, PlanetMaterial.TUNGSTEN, PlanetHardness.TUNGSTEN, PlanetHarvestLevel.TUNGSTEN,PlanetExp.TUNGSTEN).setResistance(1),
                new SlateOre("slate_ruby", Material.ROCK, PlanetMaterial.RUBY, PlanetHardness.RUBY, PlanetHarvestLevel.RUBY,PlanetExp.RUBY).setResistance(1),
                new SlateOre("slate_sapphire", Material.ROCK, PlanetMaterial.SAPPHIRE, PlanetHardness.SAPPHIRE, PlanetHarvestLevel.SAPPHIRE,PlanetExp.SAPPHIRE).setResistance(1),
                new SlateOre("slate_diamond", Material.ROCK, PlanetMaterial.DIAMOND, PlanetHardness.DIAMOND, PlanetHarvestLevel.DIAMOND,PlanetExp.DIAMOND).setResistance(1),
                new SlateOre("slate_emerald", Material.ROCK, PlanetMaterial.EMERALD, PlanetHardness.EMERALD, PlanetHarvestLevel.EMERALD,PlanetExp.EMERALD).setResistance(1),
                new SlateOre("slate_majorite", Material.ROCK, PlanetMaterial.MAJORITE, PlanetHardness.MAJORITE, PlanetHarvestLevel.MAJORITE,PlanetExp.MAJORITE).setResistance(10),
                new SlateOre("slate_amazonite", Material.ROCK, PlanetMaterial.AMAZONITE, PlanetHardness.AMAZONITE, PlanetHarvestLevel.AMAZONITE,PlanetExp.AMAZONITE).setResistance(10),
                new SlateOre("slate_onyx", Material.ROCK, PlanetMaterial.ONYX, PlanetHardness.ONYX, PlanetHarvestLevel.ONYX,PlanetExp.ONYX).setResistance(10),
                new SlateOre("slate_painite", Material.ROCK, PlanetMaterial.PAINITE, PlanetHardness.PAINITE, PlanetHarvestLevel.PAINITE,PlanetExp.PAINITE).setResistance(10)
                );
    }

    public static void registerRenders() {

        for (int meta = 0; meta < 3; meta++) {
            String name = Reference.MOD_ID + ":" + HotRocks.EnumType.values()[meta].getName();
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.GRANITE), meta, new ModelResourceLocation(name + "_granite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.DIORITE), meta, new ModelResourceLocation(name + "_diorite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.ANDESITE), meta, new ModelResourceLocation(name + "_andesite", "inventory"));
        }

        for (int meta = 0; meta < 6; meta++) {

            String name = Reference.MOD_ID + ":" + Slate.EnumType.values()[meta].getName();
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE), meta, new ModelResourceLocation(name, "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_COAL), meta, new ModelResourceLocation(name + "_coal", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_SULFUR), meta, new ModelResourceLocation(name + "_sulfur", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_REDSTONE), meta, new ModelResourceLocation(name + "_redstone", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_LAPIS), meta, new ModelResourceLocation(name + "_lapis", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_IRON), meta, new ModelResourceLocation(name + "_iron", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_SILVER), meta, new ModelResourceLocation(name + "_silver", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_GOLD), meta, new ModelResourceLocation(name + "_gold", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_TITANIUM), meta, new ModelResourceLocation(name + "_titanium", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_URANIUM), meta, new ModelResourceLocation(name + "_uranium", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_TUNGSTEN), meta, new ModelResourceLocation(name + "_tungsten", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_RUBY), meta, new ModelResourceLocation(name + "_ruby", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_SAPPHIRE), meta, new ModelResourceLocation(name + "_sapphire", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_DIAMOND), meta, new ModelResourceLocation(name + "_diamond", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_EMERALD), meta, new ModelResourceLocation(name + "_emerald", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_MAJORITE), meta, new ModelResourceLocation(name + "_majorite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_AMAZONITE), meta, new ModelResourceLocation(name + "_amazonite", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_ONYX), meta, new ModelResourceLocation(name + "_onyx", "inventory"));
            ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(ModBlocks.SLATE_PAINITE), meta, new ModelResourceLocation(name + "_painite", "inventory"));
        }
    }

    public static List<Block> getBlocks() {
        return BLOCKS;
    }
}