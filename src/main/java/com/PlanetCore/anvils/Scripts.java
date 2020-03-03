package com.PlanetCore.anvils;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.Map.Entry;

public class Scripts {
    private static JsonArray pattern = new JsonArray();
    private static String[] recipe = new String[]{"III", " i ", "iii"};

    public Scripts() {
    }

    public static void scripts() {
        String[] compass = new String[]{"south", "west", "north", "east"};

        try {
            EnumVariants[] var1 = EnumVariants.values();
            int var2 = var1.length;

            label57:
            for(int var3 = 0; var3 < var2; ++var3) {
                EnumVariants damage = var1[var3];
                Iterator var5 = Setup.MATERIAL_TO_MODID.entrySet().iterator();

                while(true) {
                    String material;
                    do {
                        do {
                            do {
                                if (!var5.hasNext()) {
                                    continue label57;
                                }

                                Entry<String, String[]> ore = (Entry)var5.next();
                                material = (String)ore.getKey();
                            } while(material.equals("silver"));
                        } while(material.equals("stone"));
                    } while(material.equals("diamond"));

                    File file = new File("jsons/blockstates/" + material + damage.getString() + ".json");
                    JsonObject variants = new JsonObject();

                    for(int i = 0; i < 4; ++i) {
                        JsonObject element = new JsonObject();
                        element.addProperty("model", "planetcore:" + material + damage.getString());
                        if (i != 0) {
                            element.addProperty("y", i * 90);
                        }

                        variants.add("facing=" + compass[i], element);
                    }

                    JsonObject blockstates = new JsonObject();
                    blockstates.add("variants", variants);
                    FileWriter writer = new FileWriter(file);
                    writer.write(Setup.prettyJson(blockstates));
                    writer.flush();
                    File file1 = new File("jsons/models/item/" + material + damage.getString() + ".json");
                    JsonObject parent = new JsonObject();
                    parent.addProperty("parent", "planetcore:block/" + material + damage.getString());
                    FileWriter writer1 = new FileWriter(file1);
                    writer1.write(Setup.prettyJson(parent));
                    writer1.flush();
                    File file2 = new File("jsons/models/block/" + material + damage.getString() + ".json");
                    JsonObject textures = new JsonObject();
                    textures.addProperty("particle", "planetcore:blocks/" + material + EnumVariants.NORMAL.getString() + "_top");
                    textures.addProperty("body", "planetcore:blocks/" + material + EnumVariants.NORMAL.getString() + "_top");
                    textures.addProperty("top", "planetcore:blocks/" + material + "_anvil_top" + damage.getString().substring(6));
                    JsonObject blockmodel = new JsonObject();
                    blockmodel.addProperty("parent", "block/anvil");
                    blockmodel.add("textures", textures);
                    FileWriter writer2 = new FileWriter(file2);
                    writer2.write(Setup.prettyJson(blockmodel));
                    writer2.flush();
                    if (damage == EnumVariants.NORMAL) {
                        File file3 = new File("jsons/recipes/" + material + damage.getString() + ".json");
                        JsonObject recipes = new JsonObject();
                        JsonObject key = new JsonObject();
                        JsonObject I = new JsonObject();
                        I.addProperty("type", "forge:ore_dict");
                        I.addProperty("ore", "block" + material.substring(0, 1).toUpperCase() + material.substring(1));
                        JsonObject i = new JsonObject();
                        i.addProperty("type", "forge:ore_dict");
                        i.addProperty("ore", "ingot" + material.substring(0, 1).toUpperCase() + material.substring(1));
                        key.add("I", I);
                        key.add("i", i);
                        recipes.add("pattern", pattern);
                        recipes.addProperty("type", "minecraft:crafting_shaped");
                        recipes.add("key", key);
                        JsonObject result = new JsonObject();
                        result.addProperty("item", "planetcore:" + material + "_anvil");
                        recipes.add("result", result);
                        FileWriter writer3 = new FileWriter(file3);
                        writer3.write(Setup.prettyJson(recipes));
                        writer3.flush();
                    }
                }
            }
        } catch (Exception var26) {
            var26.printStackTrace();
        }

    }

    static {
        String[] var0 = recipe;
        int var1 = var0.length;

        for(int var2 = 0; var2 < var1; ++var2) {
            String line = var0[var2];
            pattern.add(line);
        }

    }
}
