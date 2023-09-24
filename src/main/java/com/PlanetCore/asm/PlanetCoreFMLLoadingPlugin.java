package com.PlanetCore.asm;

import net.minecraftforge.fml.common.FMLLog;
import net.minecraftforge.fml.relauncher.IFMLLoadingPlugin;
import org.spongepowered.asm.launch.MixinBootstrap;
import org.spongepowered.asm.mixin.Mixins;

import javax.annotation.Nullable;
import java.util.Map;

public class PlanetCoreFMLLoadingPlugin implements IFMLLoadingPlugin {
    public PlanetCoreFMLLoadingPlugin() {
        FMLLog.log.info("PlanetCore Mixin init");
        MixinBootstrap.init();

        Mixins.addConfiguration("mixins.mixins.planetcore.json");
    }

    public static final boolean REMAP = false;

    @Override
    public String[] getASMTransformerClass() {
        return new String[0];
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Nullable
    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}