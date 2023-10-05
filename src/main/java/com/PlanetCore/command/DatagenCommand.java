package com.PlanetCore.command;

import com.PlanetCore.blocks.DefaultGeneratorStats;
import com.PlanetCore.blocks.LavaGeneratorBlock;
import com.PlanetCore.util.Reference;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.stream.JsonWriter;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.server.MinecraftServer;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public class DatagenCommand extends CommandBase {
    @Override
    public String getName() {
        return "datagen";
    }

    @Override
    public String getUsage(ICommandSender sender) {
        return "datagen";
    }

    @Override
    public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
        write();
    }

    private static final String[] prefixs = Arrays.stream(DefaultGeneratorStats.values()).map(Enum::name).map(StringUtils::toRootLowerCase).toArray(String[]::new);

    static final Gson gson = new GsonBuilder().disableHtmlEscaping().create();

    public static void write() {
        JsonWriter writer = null;
        try {
            for (String prefix : prefixs) {
                blockstate(prefix);
                models(prefix);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(writer);
        }
    }

    static final String GEN = "generated";
    private static void blockstate(String prefix) throws IOException {
        File root = new File(GEN+"/blockstates/");
        root.mkdirs();
        File blockstate = new File(GEN+"/blockstates/"+prefix+"_lava_generator.json");
        JsonWriter writer = gson.newJsonWriter(new FileWriter(blockstate));
        writer.setIndent("    ");
        JsonObject object = new JsonObject();
        JsonObject variants = new JsonObject();

        PropertyInteger propertyInteger = LavaGeneratorBlock.LEVEL;

        for (int i : propertyInteger.getAllowedValues()) {

            JsonObject model = new JsonObject();
            model.addProperty("model",Reference.MOD_ID+":"+prefix+"_lava_generator_level_"+i);

            variants.add(propertyInteger.getName()+"="+propertyInteger.getName(i),model);
        }
        object.add("variants",variants);
        gson.toJson(object, writer);
        IOUtils.closeQuietly(writer);
    }

    private static void models(String prefix) throws IOException {

        File root = new File(GEN+"/models/block");
        root.mkdirs();

        PropertyInteger propertyInteger = LavaGeneratorBlock.LEVEL;

        for (int i : propertyInteger.getAllowedValues()) {
            File blockmodel = new File(GEN+"/models/block/"+prefix+"_lava_generator_level_"+i+".json");
            JsonWriter writer = gson.newJsonWriter(new FileWriter(blockmodel));
            writer.setIndent("    ");
            JsonObject object = new JsonObject();

            object.addProperty("parent","block/cube_bottom_top");

            JsonObject textures = cubeBottomTop(prefix,i);
            object.add("textures",textures);
            gson.toJson(object, writer);
            IOUtils.closeQuietly(writer);
        }


        root = new File(GEN+"/models/item");
        root.mkdirs();

        File itemmodel = new File(GEN+"/models/item/"+prefix+"_lava_generator.json");
        JsonWriter writer = gson.newJsonWriter(new FileWriter(itemmodel));
        writer.setIndent("    ");
        JsonObject object = new JsonObject();
        object.addProperty("parent",Reference.MOD_ID+":block/"+prefix+"_lava_generator_level_0");
        gson.toJson(object, writer);
        IOUtils.closeQuietly(writer);
    }

    private static JsonObject cubeBottomTop(String prefix,int i) {
        JsonObject textures = new JsonObject();
        textures.addProperty("bottom",Reference.MOD_ID+":blocks/lava_generator_"+prefix+"_bottom");
        textures.addProperty("top",Reference.MOD_ID+":blocks/lava_generator_"+prefix+"_top_"+ (i > 0 ? "on" : "off") );
        textures.addProperty("side",Reference.MOD_ID+":blocks/lava_generator_"+prefix+"_side_"+i);
        return textures;
    }

}
