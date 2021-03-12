package com.PlanetCore.util.handlers;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.Map;
import java.util.Optional;


import static com.PlanetCore.util.handlers.AnvilRecipeHolder.initAnvilRecipes;
import static net.minecraft.item.ItemStack.EMPTY;

@Mod.EventBusSubscriber(modid="planetcore")
public class AnvilHandler {

    @SubscribeEvent
    public static void onAnvilUpdate(AnvilUpdateEvent event) {
        ItemStack stack1 = event.getLeft();
        ItemStack stack2 = event.getRight();
        initAnvilRecipes();

        Optional<AnvilRecipeHolder> recipe =  AnvilRecipeHolder.ANVIL_RECIPES.stream().filter(arh -> stack1.getItem() == (arh.getAnvilLeft()) && stack2.getItem() == (arh.getAnvilRight())).findAny();
        System.out.println(recipe);
        if(recipe.isPresent()) {



            int finalDamage = stack1.getItemDamage() + stack2.getItemDamage();

            ItemStack finalResult = new ItemStack(recipe.get().getAnvilResult());
            finalResult.setItemDamage(finalDamage);

            Map<Enchantment, Integer> map = EnchantmentHelper.getEnchantments(stack1);

            EnchantmentHelper.getEnchantments(stack2).forEach((ench, level) -> {
                if(map.containsKey(ench)) {
                    if(map.get(ench) < level)
                        map.replace(ench, level);
                } else {
                    map.put(ench, level);
                }
            });

            EnchantmentHelper.setEnchantments(map, finalResult);
            event.setCost(1);
            event.setOutput(finalResult);
        }
        else
        {
            System.out.println("wrong recipe");
            event.setOutput(EMPTY);
        }
    }
}