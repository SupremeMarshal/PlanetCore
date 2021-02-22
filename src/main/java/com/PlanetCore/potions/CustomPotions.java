package com.PlanetCore.potions;

import com.PlanetCore.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;

public class CustomPotions extends Potion {
    public CustomPotions(String name, boolean isBadEffectIn, int colour, int iconIndexX, int iconIndexY) {
        super(isBadEffectIn, colour);
        setPotionName("effect." + name);
        setIconIndex(iconIndexX, iconIndexY);
        setRegistryName(new ResourceLocation(Reference.MOD_ID + ":" + name));
    }

    @Override
    public boolean hasStatusIcon() {
        Minecraft.getMinecraft().getTextureManager().bindTexture(new ResourceLocation(Reference.MOD_ID + "textures/gui/potion_effects.png"));
        return true;
    }
}