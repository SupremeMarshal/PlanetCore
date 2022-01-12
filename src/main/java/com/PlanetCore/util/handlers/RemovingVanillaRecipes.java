package com.PlanetCore.util.handlers;

import com.PlanetCore.recipes.TestRecipe;
import com.PlanetCore.util.Reference;
import net.minecraft.item.crafting.IRecipe;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.registries.IForgeRegistryModifiable;

public class RemovingVanillaRecipes {
    @SubscribeEvent
    public void registerRecipe(RegistryEvent.Register<IRecipe> event)
    {
        IForgeRegistryModifiable modRegistry = (IForgeRegistryModifiable)event.getRegistry();
        removeRecipe(modRegistry, new ResourceLocation("minecraft:stone_sword"), Reference.MOD_ID);
        removeRecipe(modRegistry, new ResourceLocation("minecraft:stone_pickaxe"), Reference.MOD_ID);
        removeRecipe(modRegistry, new ResourceLocation("minecraft:stone_axe"), Reference.MOD_ID);
        removeRecipe(modRegistry, new ResourceLocation("minecraft:stone_shovel"), Reference.MOD_ID);
        removeRecipe(modRegistry, new ResourceLocation("minecraft:stone_hoe"), Reference.MOD_ID);
        removeRecipe(modRegistry, new ResourceLocation("minecraft:wooden_sword"), Reference.MOD_ID);
        removeRecipe(modRegistry, new ResourceLocation("minecraft:wooden_pickaxe"), Reference.MOD_ID);
        removeRecipe(modRegistry, new ResourceLocation("minecraft:wooden_axe"), Reference.MOD_ID);
        removeRecipe(modRegistry, new ResourceLocation("minecraft:wooden_shovel"), Reference.MOD_ID);
        removeRecipe(modRegistry, new ResourceLocation("minecraft:wooden_hoe"), Reference.MOD_ID);
        removeRecipe(modRegistry, new ResourceLocation("minecraft:iron_sword"), Reference.MOD_ID);
        removeRecipe(modRegistry, new ResourceLocation("minecraft:iron_pickaxe"), Reference.MOD_ID);
        removeRecipe(modRegistry, new ResourceLocation("minecraft:iron_axe"), Reference.MOD_ID);
        removeRecipe(modRegistry, new ResourceLocation("minecraft:iron_shovel"), Reference.MOD_ID);
        removeRecipe(modRegistry, new ResourceLocation("minecraft:iron_hoe"), Reference.MOD_ID);
    }

    public static void removeRecipe(IForgeRegistryModifiable modRegistry, ResourceLocation recipe, String modID)
    {
        IRecipe p = (IRecipe)modRegistry.getValue(recipe);
        modRegistry.remove(recipe);
        modRegistry.register(TestRecipe.from(p));
    }

}
