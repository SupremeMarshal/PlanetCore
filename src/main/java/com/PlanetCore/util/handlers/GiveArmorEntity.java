package com.PlanetCore.util.handlers;

import com.PlanetCore.entity.EntityMagmaZombie;
import com.PlanetCore.init.ModItems;
import com.PlanetCore.util.Reference;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class GiveArmorEntity {

    @SubscribeEvent
    public static void giveArmor(LivingSpawnEvent event) {
        EntityLiving entity = (EntityLiving) event.getEntityLiving();
        if (entity.posY > -700) return;
        if (entity instanceof EntitySkeleton || entity instanceof EntityMagmaZombie) {
            giveRandomArmor(entity);
        }
    }

    private static void giveRandomArmor(EntityLiving entity) {
        Random rand = new Random();

        Map<EntityEquipmentSlot, Pair<Item, Item>> equipmentMap = getEquipmentMap(entity);

        for (Map.Entry<EntityEquipmentSlot, Pair<Item, Item>> entry : equipmentMap.entrySet()) {
            float chance = rand.nextFloat();
            ItemStack stack = null;

            if (chance < 0.1) {
                stack = new ItemStack(entry.getValue().getLeft());
            } else if (chance >= 0.1 && chance < 0.15) {
                stack = new ItemStack(entry.getValue().getRight());
            }

            if (stack != null) {
                entity.setItemStackToSlot(entry.getKey(), stack);
            }
        }
    }

    private static Map<EntityEquipmentSlot, Pair<Item, Item>> getEquipmentMap(EntityLiving entity) {
        Map<EntityEquipmentSlot, Pair<Item, Item>> equipmentMap = new HashMap<>();

        if (entity instanceof EntitySkeleton) {
            equipmentMap.put(EntityEquipmentSlot.MAINHAND, Pair.of(ModItems.RUBY_BOW, ModItems.SAPPHIRE_BOW));
        } else if (entity instanceof EntityMagmaZombie) {
            equipmentMap.put(EntityEquipmentSlot.MAINHAND, Pair.of(ModItems.RUBY_SWORD, ModItems.SAPPHIRE_SWORD));
        }

        equipmentMap.put(EntityEquipmentSlot.HEAD, Pair.of(ModItems.RUBY_HELMET, ModItems.SAPPHIRE_HELMET));
        equipmentMap.put(EntityEquipmentSlot.CHEST, Pair.of(ModItems.RUBY_CHESTPLATE, ModItems.SAPPHIRE_CHESTPLATE));
        equipmentMap.put(EntityEquipmentSlot.LEGS, Pair.of(ModItems.RUBY_LEGGINGS, ModItems.SAPPHIRE_LEGGINGS));
        equipmentMap.put(EntityEquipmentSlot.FEET, Pair.of(ModItems.RUBY_BOOTS, ModItems.SAPPHIRE_BOOTS));

        return equipmentMap;
    }

}