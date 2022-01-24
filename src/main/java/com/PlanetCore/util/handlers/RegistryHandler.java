package com.PlanetCore.util.handlers;


import com.PlanetCore.Main;
import com.PlanetCore.init.*;
import com.PlanetCore.init.blocks.item.ItemBlockVariants;
import com.PlanetCore.items.armor.ItemSetPieces;
import com.PlanetCore.util.IMetaName;
import com.PlanetCore.util.ModConfiguration;
import com.PlanetCore.util.Reference;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.FurnaceRecipes;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
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

import java.util.Collections;


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
                for (int i = 0; i < 3; i++) {
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
        EntityInit.registerEntities();
        ModConfiguration.registerConfig(event);
        RemovingVanillaRecipes recipesEvent = new RemovingVanillaRecipes();
        MinecraftForge.EVENT_BUS.register(recipesEvent);
        MinecraftForge.EVENT_BUS.register(new FogHandler());
        MinecraftForge.EVENT_BUS.register(new EntitySpawnEvent());
        ModPotions.registerPotions();
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
        OreDictionary.registerOre("ingotBoron", new ItemStack(ModItems.BORON_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotLithium", new ItemStack(ModItems.LITHIUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotMagnesium", new ItemStack(ModItems.MAGNESIUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotThorium", new ItemStack(ModItems.THORIUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotAluminum", new ItemStack(ModItems.ALUMINIUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotAluminium", new ItemStack(ModItems.ALUMINIUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotCopper", new ItemStack(ModItems.COPPER_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotTin", new ItemStack(ModItems.TIN_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotSilver", new ItemStack(ModItems.SILVER_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("gemSapphire", new ItemStack(ModItems.SAPPHIRE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("gemRuby", new ItemStack(ModItems.RUBY, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("gemAmazonite", new ItemStack(ModItems.AMAZONITE, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("itemSulfur", new ItemStack(ModItems.SULFUR, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotBronze", new ItemStack(ModItems.BRONZE_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotTitanium", new ItemStack(ModItems.TITANIUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotUranium", new ItemStack(ModItems.URANIUM_INGOT, 1, OreDictionary.WILDCARD_VALUE));
        OreDictionary.registerOre("ingotTungsten", new ItemStack(ModItems.TUNGSTEN_INGOT, 1, OreDictionary.WILDCARD_VALUE));


    }

    public static void posInitRegistries(FMLPostInitializationEvent event) {

        ItemSetPieces.registerSetBonus(new ItemSetPieces.SetBonus(
                        ItemSetPieces.newArrayList(
                                new Item[] {ModItems.JADE_HELMET, ModItems.SAPPHIRE_HELMET, ModItems.OLIVINE_HELMET, ModItems.WADSLEYITE_HELMET, ModItems.RINGWOODITE_HELMET, ModItems.BRIGMANITE_HELMET, ModItems.MAJORITE_HELMET, ModItems.AMAZONITE_HELMET, ModItems.ONYX_HELMET, ModItems.ONYX_II_HELMET, ModItems.ONYX_III_HELMET, ModItems.ONYX_IV_HELMET, ModItems.ONYX_V_HELMET},
                                new Item[] {ModItems.JADE_CHESTPLATE, ModItems.SAPPHIRE_CHESTPLATE, ModItems.OLIVINE_CHESTPLATE, ModItems.WADSLEYITE_CHESTPLATE, ModItems.RINGWOODITE_CHESTPLATE, ModItems.BRIGMANITE_CHESTPLATE, ModItems.MAJORITE_CHESTPLATE, ModItems.AMAZONITE_CHESTPLATE, ModItems.ONYX_CHESTPLATE, ModItems.ONYX_II_CHESTPLATE, ModItems.ONYX_III_CHESTPLATE, ModItems.ONYX_IV_CHESTPLATE, ModItems.ONYX_V_CHESTPLATE},
                                new Item[] {ModItems.JADE_LEGGINGS, ModItems.SAPPHIRE_LEGGINGS, ModItems.OLIVINE_LEGGINGS, ModItems.WADSLEYITE_LEGGINGS, ModItems.RINGWOODITE_LEGGINGS, ModItems.BRIGMANITE_LEGGINGS, ModItems.MAJORITE_LEGGINGS, ModItems.AMAZONITE_LEGGINGS, ModItems.ONYX_LEGGINGS, ModItems.ONYX_II_LEGGINGS, ModItems.ONYX_III_LEGGINGS, ModItems.ONYX_IV_LEGGINGS, ModItems.ONYX_V_LEGGINGS},
                                new Item[] {ModItems.JADE_BOOTS, ModItems.SAPPHIRE_BOOTS, ModItems.OLIVINE_BOOTS, ModItems.WADSLEYITE_BOOTS, ModItems.RINGWOODITE_BOOTS, ModItems.BRIGMANITE_BOOTS, ModItems.MAJORITE_BOOTS, ModItems.AMAZONITE_BOOTS, ModItems.ONYX_BOOTS, ModItems.ONYX_II_BOOTS, ModItems.ONYX_III_BOOTS, ModItems.ONYX_IV_BOOTS, ModItems.ONYX_V_BOOTS}
                        ),
                        new PotionEffect(MobEffects.RESISTANCE, 0, 0)
                )
        );
        ItemSetPieces.registerSetBonus(new ItemSetPieces.SetBonus(
                        ItemSetPieces.newArrayList(
                                new Item[] {ModItems.OLIVINE_HELMET, ModItems.WADSLEYITE_HELMET, ModItems.RINGWOODITE_HELMET, ModItems.BRIGMANITE_HELMET, ModItems.MAJORITE_HELMET, ModItems.AMAZONITE_HELMET, ModItems.ONYX_HELMET, ModItems.ONYX_II_HELMET, ModItems.ONYX_III_HELMET, ModItems.ONYX_IV_HELMET, ModItems.ONYX_V_HELMET},
                                new Item[] {ModItems.OLIVINE_CHESTPLATE, ModItems.WADSLEYITE_CHESTPLATE, ModItems.RINGWOODITE_CHESTPLATE, ModItems.BRIGMANITE_CHESTPLATE, ModItems.MAJORITE_CHESTPLATE, ModItems.AMAZONITE_CHESTPLATE, ModItems.ONYX_CHESTPLATE, ModItems.ONYX_II_CHESTPLATE, ModItems.ONYX_III_CHESTPLATE, ModItems.ONYX_IV_CHESTPLATE, ModItems.ONYX_V_CHESTPLATE},
                                new Item[] {ModItems.OLIVINE_LEGGINGS, ModItems.WADSLEYITE_LEGGINGS, ModItems.RINGWOODITE_LEGGINGS, ModItems.BRIGMANITE_LEGGINGS, ModItems.MAJORITE_LEGGINGS, ModItems.AMAZONITE_LEGGINGS, ModItems.ONYX_LEGGINGS, ModItems.ONYX_II_LEGGINGS, ModItems.ONYX_III_LEGGINGS, ModItems.ONYX_IV_LEGGINGS, ModItems.ONYX_V_LEGGINGS},
                                new Item[] {ModItems.OLIVINE_BOOTS, ModItems.WADSLEYITE_BOOTS, ModItems.RINGWOODITE_BOOTS, ModItems.BRIGMANITE_BOOTS, ModItems.MAJORITE_BOOTS, ModItems.AMAZONITE_BOOTS, ModItems.ONYX_BOOTS, ModItems.ONYX_II_BOOTS, ModItems.ONYX_III_BOOTS, ModItems.ONYX_IV_BOOTS, ModItems.ONYX_V_BOOTS}
                        ),
                        new PotionEffect(MobEffects.RESISTANCE, 0, 1),
                        new PotionEffect(MobEffects.REGENERATION, 0, 0)
                )
        );
        ItemSetPieces.registerSetBonus(new ItemSetPieces.SetBonus(
                        ItemSetPieces.newArrayList(
                                new Item[] {ModItems.MAJORITE_HELMET, ModItems.AMAZONITE_HELMET, ModItems.ONYX_HELMET, ModItems.ONYX_II_HELMET, ModItems.ONYX_III_HELMET, ModItems.ONYX_IV_HELMET, ModItems.ONYX_V_HELMET},
                                new Item[] {ModItems.MAJORITE_CHESTPLATE, ModItems.AMAZONITE_CHESTPLATE, ModItems.ONYX_CHESTPLATE, ModItems.ONYX_II_CHESTPLATE, ModItems.ONYX_III_CHESTPLATE, ModItems.ONYX_IV_CHESTPLATE, ModItems.ONYX_V_CHESTPLATE},
                                new Item[] {ModItems.MAJORITE_LEGGINGS, ModItems.AMAZONITE_LEGGINGS, ModItems.ONYX_LEGGINGS, ModItems.ONYX_II_LEGGINGS, ModItems.ONYX_III_LEGGINGS, ModItems.ONYX_IV_LEGGINGS, ModItems.ONYX_V_LEGGINGS},
                                new Item[] {ModItems.MAJORITE_BOOTS, ModItems.AMAZONITE_BOOTS, ModItems.ONYX_BOOTS, ModItems.ONYX_II_BOOTS, ModItems.ONYX_III_BOOTS, ModItems.ONYX_IV_BOOTS, ModItems.ONYX_V_BOOTS}
                        ),
                        new PotionEffect(MobEffects.RESISTANCE, 0, 2),
                        new PotionEffect(MobEffects.REGENERATION, 0, 0)
                )
        );
        ItemSetPieces.registerSetBonus(new ItemSetPieces.SetBonus(
                        ItemSetPieces.newArrayList(
                                new Item[] {ModItems.AMAZONITE_HELMET, ModItems.ONYX_HELMET, ModItems.ONYX_II_HELMET, ModItems.ONYX_III_HELMET, ModItems.ONYX_IV_HELMET, ModItems.ONYX_V_HELMET},
                                new Item[] {ModItems.AMAZONITE_CHESTPLATE, ModItems.ONYX_CHESTPLATE, ModItems.ONYX_II_CHESTPLATE, ModItems.ONYX_III_CHESTPLATE, ModItems.ONYX_IV_CHESTPLATE, ModItems.ONYX_V_CHESTPLATE},
                                new Item[] {ModItems.AMAZONITE_LEGGINGS, ModItems.ONYX_LEGGINGS, ModItems.ONYX_II_LEGGINGS, ModItems.ONYX_III_LEGGINGS, ModItems.ONYX_IV_LEGGINGS, ModItems.ONYX_V_LEGGINGS},
                                new Item[] {ModItems.AMAZONITE_BOOTS, ModItems.ONYX_BOOTS, ModItems.ONYX_II_BOOTS, ModItems.ONYX_III_BOOTS, ModItems.ONYX_IV_BOOTS, ModItems.ONYX_V_BOOTS}
                        ),
                        new PotionEffect(MobEffects.RESISTANCE, 0, 2),
                        new PotionEffect(MobEffects.REGENERATION, 0, 1)
                )
        );
        ItemSetPieces.registerSetBonus(new ItemSetPieces.SetBonus(
                        ItemSetPieces.newArrayList(
                                new Item[] {ModItems.ONYX_HELMET, ModItems.ONYX_II_HELMET, ModItems.ONYX_III_HELMET, ModItems.ONYX_IV_HELMET, ModItems.ONYX_V_HELMET},
                                new Item[] {ModItems.ONYX_CHESTPLATE, ModItems.ONYX_II_CHESTPLATE, ModItems.ONYX_III_CHESTPLATE, ModItems.ONYX_IV_CHESTPLATE, ModItems.ONYX_V_CHESTPLATE},
                                new Item[] {ModItems.ONYX_LEGGINGS, ModItems.ONYX_II_LEGGINGS, ModItems.ONYX_III_LEGGINGS, ModItems.ONYX_IV_LEGGINGS, ModItems.ONYX_V_LEGGINGS},
                                new Item[] {ModItems.ONYX_BOOTS, ModItems.ONYX_II_BOOTS, ModItems.ONYX_III_BOOTS, ModItems.ONYX_IV_BOOTS, ModItems.ONYX_V_BOOTS}
                        ),
                        new PotionEffect(MobEffects.RESISTANCE, 0, 2),
                        new PotionEffect(MobEffects.STRENGTH, 0, 0),
                        new PotionEffect(MobEffects.SPEED, 0, 0),
                        new PotionEffect(MobEffects.REGENERATION, 0, 1)
                )
        );
        ItemSetPieces.registerSetBonus(new ItemSetPieces.SetBonus(
                        Collections.unmodifiableList(ItemSetPieces.newArrayList(
                                new Item[] {ModItems.ONYX_II_HELMET, ModItems.ONYX_III_HELMET, ModItems.ONYX_IV_HELMET, ModItems.ONYX_V_HELMET},
                                new Item[] {ModItems.ONYX_II_CHESTPLATE, ModItems.ONYX_III_CHESTPLATE, ModItems.ONYX_IV_CHESTPLATE, ModItems.ONYX_V_CHESTPLATE},
                                new Item[] {ModItems.ONYX_II_LEGGINGS, ModItems.ONYX_III_LEGGINGS, ModItems.ONYX_IV_LEGGINGS, ModItems.ONYX_V_LEGGINGS},
                                new Item[] {ModItems.ONYX_II_BOOTS, ModItems.ONYX_III_BOOTS, ModItems.ONYX_IV_BOOTS, ModItems.ONYX_V_BOOTS}
                        )),
                        new PotionEffect(MobEffects.RESISTANCE, 0, 2),
                        new PotionEffect(MobEffects.FIRE_RESISTANCE, 0, 2),
                        new PotionEffect(MobEffects.STRENGTH, 0, 1),
                        new PotionEffect(MobEffects.SPEED, 0, 1),
                        new PotionEffect(MobEffects.REGENERATION, 0, 1)
                )
        );
        ItemSetPieces.registerSetBonus(new ItemSetPieces.SetBonus(
                        ItemSetPieces.newArrayList(
                                new Item[] {ModItems.ONYX_III_HELMET, ModItems.ONYX_IV_HELMET, ModItems.ONYX_V_HELMET},
                                new Item[] {ModItems.ONYX_III_CHESTPLATE, ModItems.ONYX_IV_CHESTPLATE, ModItems.ONYX_V_CHESTPLATE},
                                new Item[] {ModItems.ONYX_III_LEGGINGS, ModItems.ONYX_IV_LEGGINGS, ModItems.ONYX_V_LEGGINGS},
                                new Item[] {ModItems.ONYX_III_BOOTS, ModItems.ONYX_IV_BOOTS, ModItems.ONYX_V_BOOTS}
                        ),
                        new PotionEffect(MobEffects.RESISTANCE, 0, 2),
                        new PotionEffect(MobEffects.FIRE_RESISTANCE, 0, 2),
                        new PotionEffect(MobEffects.STRENGTH, 0, 2),
                        new PotionEffect(MobEffects.SPEED, 0, 1),
                        new PotionEffect(MobEffects.REGENERATION, 0, 2)
                )
        );
        ItemSetPieces.registerSetBonus(new ItemSetPieces.SetBonus(
                        ItemSetPieces.newArrayList(
                                new Item[] {ModItems.ONYX_IV_HELMET, ModItems.ONYX_V_HELMET},
                                new Item[] {ModItems.ONYX_IV_CHESTPLATE, ModItems.ONYX_V_CHESTPLATE},
                                new Item[] {ModItems.ONYX_IV_LEGGINGS, ModItems.ONYX_V_LEGGINGS},
                                new Item[] {ModItems.ONYX_IV_BOOTS, ModItems.ONYX_V_BOOTS}
                        ),
                        new PotionEffect(MobEffects.RESISTANCE, 0, 2),
                        new PotionEffect(MobEffects.FIRE_RESISTANCE, 0, 3),
                        new PotionEffect(MobEffects.STRENGTH, 0, 3),
                        new PotionEffect(MobEffects.SPEED, 0, 1),
                        new PotionEffect(MobEffects.REGENERATION, 0, 3)
                )
        );
        ItemSetPieces.registerSetBonus(new ItemSetPieces.SetBonus(
                        ItemSetPieces.newArrayList(
                                new Item[] {ModItems.ONYX_V_HELMET},
                                new Item[] {ModItems.ONYX_V_CHESTPLATE},
                                new Item[] {ModItems.ONYX_V_LEGGINGS},
                                new Item[] {ModItems.ONYX_V_BOOTS}
                        ),
                        new PotionEffect(MobEffects.RESISTANCE, 0, 3),
                        new PotionEffect(MobEffects.FIRE_RESISTANCE, 0, 4),
                        new PotionEffect(MobEffects.STRENGTH, 0, 4),
                        new PotionEffect(MobEffects.SPEED, 0, 1),
                        new PotionEffect(MobEffects.REGENERATION, 0, 4)

                )
        );
    }
}
