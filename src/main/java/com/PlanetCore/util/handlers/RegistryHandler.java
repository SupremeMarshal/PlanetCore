package com.PlanetCore.util.handlers;


import com.PlanetCore.init.*;
import com.PlanetCore.init.blocks.item.ItemBlockVariants;
import com.PlanetCore.util.IMetaName;
import com.PlanetCore.util.ModConfiguration;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
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
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.oredict.OreDictionary;

import java.lang.reflect.Field;

import static com.PlanetCore.util.Reference.MOD_ID;


@EventBusSubscriber
public class RegistryHandler {

    @SubscribeEvent
    public static void onItemRegister(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(ModItems.getItems().toArray(new Item[0]));
        for (Block block : ModBlocks.getBlocks()) {
            ItemBlock itemBlock;
            if (block == ModBlocks.PERIDOTITE_FIRE || block == ModBlocks.GARNET_FIRE || block == ModBlocks.BRIDGMANITE_FIRE || block == ModBlocks.FERROPERICLASE_FIRE || block == ModBlocks.HOT_FIRE || block == ModBlocks.ONYX_FIRE || block == ModBlocks.CORE_FIRE) continue;
            if (block instanceof IMetaName) {
                itemBlock = new ItemBlockVariants(block);
            } else {
                itemBlock = new ItemBlock(block);
            }
            event.getRegistry().register(itemBlock.setRegistryName(block.getRegistryName()));
        }
        OreDictionary.registerOre("itemCoal", new ItemStack(Items.COAL, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("itemPlank", new ItemStack(Blocks.PLANKS, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotSilver", new ItemStack(ModItems.SILVER_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("gemSapphire", new ItemStack(ModItems.SAPPHIRE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("gemRuby", new ItemStack(ModItems.RUBY, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("gemAmazonite", new ItemStack(ModItems.AMAZONITE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("itemSulfur", new ItemStack(ModItems.SULFUR, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotTitanium", new ItemStack(ModItems.TITANIUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotUranium", new ItemStack(ModItems.URANIUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotTungsten", new ItemStack(ModItems.TUNGSTEN_INGOT, 1, OreDictionary.WILDCARD_VALUE));


    }

    @SubscribeEvent
    public static void onBlockRegister(RegistryEvent.Register<Block> event)
    {
        ModBlocks.register(event.getRegistry());
    }



    public static void preInitRegistries(FMLPreInitializationEvent event) {

        ModFluids.registerFluids();
        EntityInit.registerEntities();
        ModConfiguration.registerConfig(event);
        RemovingVanillaRecipes recipesEvent = new RemovingVanillaRecipes();
        MinecraftForge.EVENT_BUS.register(recipesEvent);
        MinecraftForge.EVENT_BUS.register(new FogHandler());
        MinecraftForge.EVENT_BUS.register(new EntitySpawnEvent());
        MinecraftForge.EVENT_BUS.register((new DamageReductionArmorHandler()));
      //  MinecraftForge.EVENT_BUS.register((new LavaWalker()));
        ModPotions.registerPotions();
     //   NetworkRegistry.INSTANCE.registerGuiHandler(MOD_ID, new GuiHandler());


        //CapabilityManager.INSTANCE.register(IUserSettings.class, new UserSettingsStorage(), () -> new UserSettings());
    }

    @SubscribeEvent
    public static void registerEnchantment(RegistryEvent.Register<Enchantment> event) {
        event.getRegistry().registerAll(EnchantmentInit.ENCHANTMENTS.toArray(new Enchantment[0]));
    }

    @SubscribeEvent
    public static void registerSounds(RegistryEvent.Register<SoundEvent> event) {
        SoundHandler.registerSounds(event.getRegistry());
    }

    public static void initRegistries(FMLInitializationEvent event) {
        MinecraftForge.EVENT_BUS.register(new GravityHandler());
        MinecraftForge.EVENT_BUS.register(new scoreEvent());
    }

    public static void posInitRegistries(FMLPostInitializationEvent event) {

    }
}
