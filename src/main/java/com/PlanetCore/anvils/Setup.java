package com.PlanetCore.anvils;

import com.PlanetCore.Main;
import com.PlanetCore.anvils.generic.BlockGenericAnvil;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.ShapedOreRecipe;
import net.minecraftforge.registries.IForgeRegistry;
import org.apache.commons.io.IOUtils;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

@EventBusSubscriber
public class Setup {
    public static Map<String, String[]> MATERIAL_TO_MODID = new LinkedHashMap();

    public Setup() {
    }

    public static void writeConfig() {
        File file = new File("config/planetcore.json");
        if (!file.exists()) {
            BufferedInputStream in = new BufferedInputStream(Setup.class.getResourceAsStream("/default.json"));
            String s = null;

            try {
                s = IOUtils.toString(in, Charset.defaultCharset());
            } catch (IOException var7) {
                var7.printStackTrace();
            }

            JsonObject convertedObject = (JsonObject)(new Gson()).fromJson(s, JsonObject.class);
            String s1 = prettyJson(convertedObject);

            try {
                FileWriter writer = new FileWriter(file);
                writer.write(s1);
                writer.flush();
            } catch (IOException var6) {
                var6.printStackTrace();
            }

        }
    }

    public static String prettyJson(JsonObject j) {
        Gson gson = (new GsonBuilder()).setPrettyPrinting().create();
        return gson.toJson(j);
    }

    @SubscribeEvent
    public static void registerRecipes(Register<IRecipe> event) {
        IForgeRegistry<IRecipe> registry = event.getRegistry();
        Iterator var2 = Main.anvils.iterator();

        while(var2.hasNext()) {
            BlockGenericAnvil anvil = (BlockGenericAnvil)var2.next();
            if (anvil.variant == EnumVariants.NORMAL && !anvil.properties.material.equals("vibrant_alloy") && !anvil.properties.material.equals("energetic_alloy")) {
                IRecipe recipe = new ShapedOreRecipe(new ResourceLocation("planetcore", anvil.properties.material + "anvil"), new ItemStack(anvil), new Object[]{"bbb", " i ", "iii", 'b', "block" + anvil.properties.material.substring(0, 1).toUpperCase() + anvil.properties.material.substring(1), 'i', "ingot" + anvil.properties.material.substring(0, 1).toUpperCase() + anvil.properties.material.substring(1)});
                recipe.setRegistryName(new ResourceLocation("planetcore", anvil.properties.material + "anvil"));
                registry.register(recipe);
            }
        }

    }

    @SubscribeEvent
    public static void registerBlocks(Register<Block> event) {
        writeConfig();
        IForgeRegistry registry = event.getRegistry();
    }



    static {
        String[] minecraft = new String[]{"minecraft"};
        MATERIAL_TO_MODID.put("diamond", minecraft);
        MATERIAL_TO_MODID.put("gold", minecraft);
        MATERIAL_TO_MODID.put("stone", minecraft);
        String[] aluminum = new String[]{"immersiveengineering", "thermalfoundation"};
        MATERIAL_TO_MODID.put("aluminum", aluminum);
        String[] ardite = new String[]{"tconstruct"};
        MATERIAL_TO_MODID.put("ardite", ardite);
        String[] bronze = new String[]{"embers", "thermalfoundation", "immersiveengineering", "forestry", "mekanism", "nuclearcraft", "projectred"};
        MATERIAL_TO_MODID.put("bronze", bronze);
        String[] cobalt = new String[]{"tconstruct"};
        MATERIAL_TO_MODID.put("cobalt", cobalt);
        String[] copper = new String[]{"embers", "thermalfoundation", "immersiveengineering", "forestry", "mekanism", "nuclearcraft", "projectred"};
        MATERIAL_TO_MODID.put("copper", copper);
        String[] electrum = new String[]{"immersiveengineering", "thermalfoundation"};
        MATERIAL_TO_MODID.put("electrum", electrum);
        String[] enderium = new String[]{"thermalfoundation"};
        MATERIAL_TO_MODID.put("enderium", enderium);
        String[] endsteel = new String[]{"enderio"};
        MATERIAL_TO_MODID.put("endsteel", endsteel);
        String[] energetic_alloy = new String[]{"enderio"};
        MATERIAL_TO_MODID.put("energetic_alloy", energetic_alloy);
        String[] invar = new String[]{"thermalfoundation"};
        MATERIAL_TO_MODID.put("invar", invar);
        String[] iridium = new String[]{"ic2", "thermalfoundation"};
        MATERIAL_TO_MODID.put("iridium", iridium);
        String[] lead = new String[]{"thermalfoundation", "embers", "nuclearcraft"};
        MATERIAL_TO_MODID.put("lead", lead);
        String[] manyullyn = new String[]{"tconstruct"};
        MATERIAL_TO_MODID.put("manyullyn", manyullyn);
        String[] nickel = new String[]{"thermalfoundation"};
        MATERIAL_TO_MODID.put("nickel", nickel);
        String[] platinum = new String[]{"planetcore"};
        MATERIAL_TO_MODID.put("platinum", platinum);
        String[] signalum = new String[]{"thermalfoundation"};
        MATERIAL_TO_MODID.put("signalum", signalum);
        String[] silver = new String[]{"planetcore", "immersiveengineering", "nuclearcraft", "projectred"};
        MATERIAL_TO_MODID.put("silver", silver);
        String[] steel = new String[]{"immersiveengineering", "nuclearcraft", "thermalfoundation", "tconstruct"};
        MATERIAL_TO_MODID.put("steel", steel);
        String[] stellar = new String[]{"enderioendergy"};
        MATERIAL_TO_MODID.put("stellar", stellar);
        String[] tin = new String[]{"thermalfoundation", "forestry", "nuclearcraft", "nuclearcraft"};
        MATERIAL_TO_MODID.put("tin", tin);
        String[] vibrant_alloy = new String[]{"enderio"};
        MATERIAL_TO_MODID.put("vibrant_alloy", vibrant_alloy);
    }
}
