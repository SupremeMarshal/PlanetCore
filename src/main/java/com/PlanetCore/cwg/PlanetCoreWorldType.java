package com.PlanetCore.cwg;

import io.github.opencubicchunks.cubicchunks.api.util.IntRange;
import io.github.opencubicchunks.cubicchunks.api.world.ICubicWorldType;
import io.github.opencubicchunks.cubicchunks.api.worldgen.ICubeGenerator;
import io.github.opencubicchunks.cubicchunks.cubicgen.asm.mixin.common.accessor.IBiomeProvider;
import io.github.opencubicchunks.cubicchunks.cubicgen.blue.endless.jankson.api.DeserializationException;
import io.github.opencubicchunks.cubicchunks.cubicgen.blue.endless.jankson.api.SyntaxError;
import io.github.opencubicchunks.cubicchunks.cubicgen.customcubic.CustomGeneratorSettings;
import io.github.opencubicchunks.cubicchunks.cubicgen.customcubic.CustomTerrainGenerator;
import io.github.opencubicchunks.cubicchunks.cubicgen.preset.CustomGenSettingsSerialization;
import io.github.opencubicchunks.cubicchunks.cubicgen.preset.fixer.CustomGeneratorSettingsFixer;
import io.github.opencubicchunks.cubicchunks.cubicgen.preset.fixer.PresetLoadError;
import net.minecraft.init.Biomes;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraft.world.WorldSettings;
import net.minecraft.world.WorldType;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.biome.BiomeProvider;
import net.minecraft.world.biome.BiomeProviderSingle;
import net.minecraft.world.gen.ChunkGeneratorSettings;
import net.minecraft.world.storage.WorldInfo;
import net.minecraftforge.common.DimensionManager;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class PlanetCoreWorldType extends WorldType implements ICubicWorldType {
    public PlanetCoreWorldType() {
        super("PlanetCore");
    }

    public static BiomeProvider makeBiomeProvider(World world, CustomGeneratorSettings conf) {
        WorldSettings fakeSettings = new WorldSettings(world.getWorldInfo());
        ChunkGeneratorSettings.Factory fakeGenOpts = new ChunkGeneratorSettings.Factory();
        fakeGenOpts.biomeSize = conf.biomeSize;
        fakeGenOpts.riverSize = conf.riverSize;
        fakeSettings.setGeneratorOptions(fakeGenOpts.toString());
        WorldInfo fakeInfo = new WorldInfo(fakeSettings, world.getWorldInfo().getWorldName());
        fakeInfo.setTerrainType(WorldType.CUSTOMIZED);
        Biome biome = Biome.getBiomeForId(conf.biome);
        return (BiomeProvider) (conf.biome < 0 ? new BiomeProvider(fakeInfo) : new BiomeProviderSingle(biome == null ? Biomes.OCEAN : biome));
    }

    private IBiomeProvider self() {
        return (IBiomeProvider) this;
    }

    public IntRange calculateGenerationHeightRange(WorldServer world) {
        CustomGeneratorSettings opts = CustomGeneratorSettings.getFromWorld(world);
        return new IntRange(0, (int) opts.actualHeight);
    }

    public boolean hasCubicGeneratorForWorld(World w) {
        return w.provider.getClass() == DimensionManager.getProvider(0).getClass();
    }

    public BiomeProvider getBiomeProvider(World world) {
        if (world.isRemote) {
            return new BiomeProviderSingle(Biomes.PLAINS);
        } else {
            CustomGeneratorSettings conf = CustomGeneratorSettings.getFromWorld(world);
            return makeBiomeProvider(world, conf);
        }
    }

    public ICubeGenerator createCubeGenerator(World world) {
        CustomGeneratorSettings cfg;
        try (InputStream in = PlanetCoreWorldType.class.getResourceAsStream("/assets/planetcore/preset.json5")) {
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            byte[] buf = new byte[4096];
            for (int i; (i = in.read(buf)) >= 0;) {
                baos.write(buf, 0, i);
            }

            String jsonString = new String(baos.toByteArray(), StandardCharsets.UTF_8);
            jsonString = CustomGeneratorSettingsFixer.INSTANCE.fixJsonString(jsonString, (String)null);
            cfg = CustomGenSettingsSerialization.jankson().fromJsonCarefully(jsonString, CustomGeneratorSettings.class);
        } catch (IOException e) {
            throw new RuntimeException("unable to load preset!", e);
        } catch (DeserializationException | PresetLoadError var3) {
            throw new RuntimeException(var3);
        } catch (SyntaxError var4) {
            String message = var4.getMessage() + "\n" + var4.getLineMessage();
            throw new RuntimeException(message, var4);
        }
        return new CustomTerrainGenerator(world, world.getBiomeProvider(), cfg, world.getSeed());
    }
}
