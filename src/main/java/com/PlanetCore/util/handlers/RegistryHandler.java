package com.PlanetCore.util.handlers;


import com.PlanetCore.init.*;
import com.PlanetCore.init.blocks.item.ItemBlockVariants;
import com.PlanetCore.items.armor.ItemSetPieces;
import com.PlanetCore.util.IMetaName;
import com.PlanetCore.util.ModConfiguration;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
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

import java.util.Collections;

import static com.PlanetCore.util.Reference.MOD_ID;


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
    public static void onBlockRegister(RegistryEvent.Register<Block> event) {
        ModBlocks.register(event.getRegistry());
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {

        ForgeRegistries.ITEMS.getValues().stream()
                .filter(item -> MOD_ID.equals(item.getRegistryName().getNamespace())).forEach(item -> {
                    if (!item.getHasSubtypes()) {
                        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
                    }
                });

        RenderHandler.registerEntityRenders();
        RenderHandler.registerCustomMeshesAndStates();
        ModBlocks.registerRenders();
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
    }

    public static void posInitRegistries(FMLPostInitializationEvent event) {

        ItemSetPieces.registerSetBonus(new ItemSetPieces.SetBonus(
                        ItemSetPieces.newArrayList(
                                new Item[] {ModItems.MAJORITE_HELMET, ModItems.AMAZONITE_HELMET, ModItems.ONYX_HELMET, ModItems.ONYX_II_HELMET, ModItems.ONYX_III_HELMET, ModItems.ONYX_IV_HELMET, ModItems.ONYX_V_HELMET},
                                new Item[] {ModItems.MAJORITE_CHESTPLATE, ModItems.AMAZONITE_CHESTPLATE, ModItems.ONYX_CHESTPLATE, ModItems.ONYX_II_CHESTPLATE, ModItems.ONYX_III_CHESTPLATE, ModItems.ONYX_IV_CHESTPLATE, ModItems.ONYX_V_CHESTPLATE},
                                new Item[] {ModItems.MAJORITE_LEGGINGS, ModItems.AMAZONITE_LEGGINGS, ModItems.ONYX_LEGGINGS, ModItems.ONYX_II_LEGGINGS, ModItems.ONYX_III_LEGGINGS, ModItems.ONYX_IV_LEGGINGS, ModItems.ONYX_V_LEGGINGS},
                                new Item[] {ModItems.MAJORITE_BOOTS, ModItems.AMAZONITE_BOOTS, ModItems.ONYX_BOOTS, ModItems.ONYX_II_BOOTS, ModItems.ONYX_III_BOOTS, ModItems.ONYX_IV_BOOTS, ModItems.ONYX_V_BOOTS}
                        ),
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
                        new PotionEffect(MobEffects.STRENGTH, 0, 4),
                        new PotionEffect(MobEffects.SPEED, 0, 1),
                        new PotionEffect(MobEffects.REGENERATION, 0, 4)

                )
        );
    }
}
