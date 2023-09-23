package com.PlanetCore.asm.mixin;

import com.PlanetCore.asm.PlanetCoreFMLLoadingPlugin;
import net.minecraft.item.Item;
import net.minecraft.item.ItemTool;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(ItemTool.class)
public interface ItemToolAccess {
    @Accessor(remap = PlanetCoreFMLLoadingPlugin.REMAP)
    Item.ToolMaterial getToolMaterial();
}
