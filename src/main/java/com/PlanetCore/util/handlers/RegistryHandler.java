package com.PlanetCore.util.handlers;


import com.PlanetCore.Main;
import com.PlanetCore.init.EnchantmentInit;
import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModFluids;
import com.PlanetCore.init.ModItems;
import com.PlanetCore.init.blocks.item.ItemBlockVariants;
import com.PlanetCore.util.IMetaName;
import com.PlanetCore.util.ModConfiguration;
import com.PlanetCore.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;
import net.minecraftforge.oredict.RecipeSorter;


@EventBusSubscriber
public class RegistryHandler {


    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.getItems().toArray(new Item[0]));
        for (Block block : ModBlocks.getBlocks()) {
            ItemBlock itemBlock;
            if (block instanceof IMetaName) {
                itemBlock = new ItemBlockVariants(block);
            } else {
                itemBlock = new ItemBlock(block);
            }
            event.getRegistry().register(itemBlock.setRegistryName(block.getRegistryName()));
        }
    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        ModBlocks.register(event.getRegistry());
        TileEntityHandler.registerTileEntities();
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {

        ForgeRegistries.ITEMS.getValues().stream()
                .filter(item -> Reference.MOD_ID.equals(item.getRegistryName().getNamespace())).forEach(item -> {
                    if (item instanceof ItemBlockVariants) {
                        for (int i = 0; i < 3;i++) {
                        //    ModelLoader.setCustomModelResourceLocation(item, i, new ModelResourceLocation(item.getRegistryName(), "inventory"));
                        }
                    } else {
                        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
                    }
        });


        RenderHandler.registerEntityRenders();
        RenderHandler.registerCustomMeshesAndStates();
        ModBlocks.registerRenders();
    }

    @SubscribeEvent
    public static void registerEnchantment(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().registerAll(EnchantmentInit.ENCHANTMENTS.toArray(new Enchantment[0]));
    }


    public static void preInitRegistries(FMLPreInitializationEvent event) {
        ModFluids.registerFluids();
        //EntityInit.registerEntities();
        ModConfiguration.registerConfig(event);
        RemovingVanillaRecipes recipesEvent = new RemovingVanillaRecipes();
        MinecraftForge.EVENT_BUS.register(recipesEvent);
        MinecraftForge.EVENT_BUS.register(new FogHandler());
        //CapabilityManager.INSTANCE.register(IUserSettings.class, new UserSettingsStorage(), () -> new UserSettings());


    }

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        SoundHandler.registerSounds(event.getRegistry());
    }

    public static void initRegistries(FMLInitializationEvent event) {

        NetworkRegistry.INSTANCE.registerGuiHandler(Main.instance, new GuiHandler());

        OreDictionary.registerOre("itemCoal", new ItemStack(Items.COAL, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("itemPlank", new ItemStack(Blocks.PLANKS, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotSteel", new ItemStack(ModItems.STEEL_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotAluminium", new ItemStack(ModItems.ALUMINIUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotAluminum", new ItemStack(ModItems.ALUMINIUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotLead", new ItemStack(ModItems.LEAD_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotSilicon", new ItemStack(ModItems.SILICON_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotCopper", new ItemStack(ModItems.COPPER_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotTin", new ItemStack(ModItems.TIN_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotSilver", new ItemStack(ModItems.SILVER_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotPlatinum", new ItemStack(ModItems.PLATINUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("gemSapphire", new ItemStack(ModItems.SAPPHIRE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("gemRuby", new ItemStack(ModItems.RUBY, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("gemDiamond", new ItemStack(ModItems.DIAMOND, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("gemAmazonite", new ItemStack(ModItems.AMAZONITE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("itemSulfur", new ItemStack(ModItems.SULFUR, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotBronze", new ItemStack(ModItems.BRONZE_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotTitanium", new ItemStack(ModItems.TITANIUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotTitanum", new ItemStack(ModItems.TITANIUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotUranium", new ItemStack(ModItems.URANIUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotUranum", new ItemStack(ModItems.URANIUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotTungsten", new ItemStack(ModItems.TUNGSTEN_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotZinc", new ItemStack(ModItems.ZINC_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("gemTopaz", new ItemStack(ModItems.TOPAZ, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("gemJade", new ItemStack(ModItems.JADE, 1, OreDictionary.WILDCARD_VALUE));



    }

    public static void posInitRegistries(FMLPostInitializationEvent event) {

        //ToolItem field protected final float efficiency;
        Items.WOODEN_PICKAXE.setHarvestLevel("pickaxe", 2);
        Items.STONE_PICKAXE.setHarvestLevel("pickaxe", 2);
        Items.IRON_PICKAXE.setHarvestLevel("pickaxe", 2);

        FurnaceRecipes.instance().getSmeltingList().remove(
                new ItemStack(Items.IRON_HORSE_ARMOR, 1, 32767),
                new ItemStack(Items.IRON_NUGGET));
        FurnaceRecipes.instance().getSmeltingList().put(
                new ItemStack(Items.IRON_HORSE_ARMOR, 1, 32767),
                new ItemStack(ModItems.IRON_NUGGET));
    }


}
