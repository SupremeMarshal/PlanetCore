package com.PlanetCore.util.handlers;

import com.PlanetCore.recipes.TestRecipe;
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
    }

    public static void removeRecipe(IForgeRegistryModifiable modRegistry, ResourceLocation recipe, String modID)
    {
        IRecipe p = (IRecipe)modRegistry.getValue(recipe);
        modRegistry.remove(recipe);
        modRegistry.register(TestRecipe.from(p));
    }

}
