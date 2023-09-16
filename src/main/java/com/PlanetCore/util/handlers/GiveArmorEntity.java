package com.PlanetCore.util.handlers;

import com.PlanetCore.entity.EntityMagmaZombie;
import com.PlanetCore.init.ModItems;
import com.PlanetCore.util.Reference;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.*;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class GiveArmorEntity {

    @SubscribeEvent
    public static void giveArmor(LivingSpawnEvent event) {
        EntityLiving entity = (EntityLiving) event.getEntityLiving();
        if (entity.posY > 0) return;
        if (entity instanceof EntitySkeleton || entity instanceof EntityMagmaZombie || entity instanceof EntityZombie) {
            giveRandomArmor(entity);
        }
    }

    private static boolean shouldEquipArmor(double probability) {
        Random rand = new Random();
        return rand.nextDouble() < probability;
    }


    private static void giveRandomArmor(EntityLiving entity) {

        IHasArmor hasArmorCapability = entity.getCapability(CapabilityHandler.HAS_ARMOR_CAPABILITY, null);

        if(hasArmorCapability != null && hasArmorCapability.hasArmor()) {
            return; // This entity has already been equipped with armor, so we return early.
        }

        Random rand = new Random();
        double posY = entity.posY;

        Map<EntityEquipmentSlot, List<Item>> possibleArmors = new HashMap<>();

        // Armor types
        List<Item> diamondArmors = Arrays.asList(Items.DIAMOND_HELMET, Items.DIAMOND_CHESTPLATE, Items.DIAMOND_LEGGINGS, Items.DIAMOND_BOOTS);
        List<Item> titaniumArmors = Arrays.asList(ModItems.TITANIUM_HELMET, ModItems.TITANIUM_CHESTPLATE, ModItems.TITANIUM_LEGGINGS, ModItems.TITANIUM_BOOTS);
        List<Item> uraniumArmors = Arrays.asList(ModItems.URANIUM_HELMET, ModItems.URANIUM_CHESTPLATE, ModItems.URANIUM_LEGGINGS, ModItems.URANIUM_BOOTS);
        List<Item> tungstenArmors = Arrays.asList(ModItems.TUNGSTEN_HELMET, ModItems.TUNGSTEN_CHESTPLATE, ModItems.TUNGSTEN_LEGGINGS, ModItems.TUNGSTEN_BOOTS);
        List<Item> rubyArmors = Arrays.asList(ModItems.RUBY_HELMET, ModItems.RUBY_CHESTPLATE, ModItems.RUBY_LEGGINGS, ModItems.RUBY_BOOTS);
        List<Item> sapphireArmors = Arrays.asList(ModItems.SAPPHIRE_HELMET, ModItems.SAPPHIRE_CHESTPLATE, ModItems.SAPPHIRE_LEGGINGS, ModItems.SAPPHIRE_BOOTS);
        List<Item> majoriteArmors = Arrays.asList(ModItems.MAJORITE_HELMET, ModItems.MAJORITE_CHESTPLATE, ModItems.MAJORITE_LEGGINGS, ModItems.MAJORITE_BOOTS);

        // Swords
        Item diamondSword = Items.DIAMOND_SWORD;
        Item titaniumSword = ModItems.TITANIUM_SWORD;
        Item uraniumSword = ModItems.URANIUM_SWORD;
        Item tungstenSword = ModItems.TUNGSTEN_SWORD;
        Item rubySword = ModItems.RUBY_SWORD;
        Item sapphireSword = ModItems.SAPPHIRE_SWORD;
        Item majoriteSword = ModItems.MAJORITE_SWORD;

        List<Item> possibleSwords = new ArrayList<>();

        double probability = 0.2;

        if (posY >= -300) {
            possibleSwords.add(diamondSword);
            possibleArmors.put(EntityEquipmentSlot.HEAD, diamondArmors);
            possibleArmors.put(EntityEquipmentSlot.CHEST, diamondArmors);
            possibleArmors.put(EntityEquipmentSlot.LEGS, diamondArmors);
            possibleArmors.put(EntityEquipmentSlot.FEET, diamondArmors);
        } else if (posY >= -600) {
            possibleSwords.addAll(Arrays.asList(diamondSword, titaniumSword));
            List<Item> combined = new ArrayList<>();
            combined.addAll(diamondArmors);
            combined.addAll(titaniumArmors);
            possibleArmors.put(EntityEquipmentSlot.HEAD, combined);
            possibleArmors.put(EntityEquipmentSlot.CHEST, combined);
            possibleArmors.put(EntityEquipmentSlot.LEGS, combined);
            possibleArmors.put(EntityEquipmentSlot.FEET, combined);
        } else if (posY >= -900) {
            possibleSwords.addAll(Arrays.asList(uraniumSword, titaniumSword));
            List<Item> combined = new ArrayList<>();
            combined.addAll(uraniumArmors);
            combined.addAll(titaniumArmors);
            possibleArmors.put(EntityEquipmentSlot.HEAD, combined);
            possibleArmors.put(EntityEquipmentSlot.CHEST, combined);
            possibleArmors.put(EntityEquipmentSlot.LEGS, combined);
            possibleArmors.put(EntityEquipmentSlot.FEET, combined);
        } else if (posY >= -1200) {
            possibleSwords.addAll(Arrays.asList(tungstenSword, uraniumSword));
            List<Item> combined = new ArrayList<>();
            combined.addAll(uraniumArmors);
            combined.addAll(tungstenArmors);
            possibleArmors.put(EntityEquipmentSlot.HEAD, combined);
            possibleArmors.put(EntityEquipmentSlot.CHEST, combined);
            possibleArmors.put(EntityEquipmentSlot.LEGS, combined);
            possibleArmors.put(EntityEquipmentSlot.FEET, combined);
        } else if (posY >= -1600) {
            List<Item> combined = new ArrayList<>();
            possibleSwords.addAll(Arrays.asList(rubySword, tungstenSword));
            combined.addAll(tungstenArmors);
            combined.addAll(rubyArmors);
            possibleArmors.put(EntityEquipmentSlot.HEAD, combined);
            possibleArmors.put(EntityEquipmentSlot.CHEST, combined);
            possibleArmors.put(EntityEquipmentSlot.LEGS, combined);
            possibleArmors.put(EntityEquipmentSlot.FEET, combined);
        } else if (posY >= -2000) {
            possibleSwords.addAll(Arrays.asList(sapphireSword, rubySword));
            List<Item> combined = new ArrayList<>();
            combined.addAll(rubyArmors);
            combined.addAll(sapphireArmors);
            possibleArmors.put(EntityEquipmentSlot.HEAD, combined);
            possibleArmors.put(EntityEquipmentSlot.CHEST, combined);
            possibleArmors.put(EntityEquipmentSlot.LEGS, combined);
            possibleArmors.put(EntityEquipmentSlot.FEET, combined);
        }

        for (EntityEquipmentSlot slot : EntityEquipmentSlot.values()) {
            List<Item> armorsForSlot = possibleArmors.get(slot);

            // Update probability based on posY
            if (posY >= -300) {
                probability = 0.2;
            } else if (posY >= -600) {
                probability = 0.2;
            } else if (posY >= -900) {
                probability = 0.2;
            } else if (posY >= -1200) {
                probability = 0.2;
            } else if (posY >= -1600) {
                probability = 0.3;
            } else if (posY < -1600) {
                probability = 0.4;
            }

            if (shouldEquipArmor(probability)) {
                if (armorsForSlot != null && !armorsForSlot.isEmpty()) {
                    Item chosenArmor = armorsForSlot.get(rand.nextInt(armorsForSlot.size()));
                    entity.setItemStackToSlot(slot, new ItemStack(chosenArmor));
                }
            }

            // Sword
            double swordProbability = 0.5;  // Customize this as you want
            if (shouldEquipArmor(swordProbability)) {
                if (!possibleSwords.isEmpty()) {
                    Item chosenSword = possibleSwords.get(rand.nextInt(possibleSwords.size()));
                    entity.setItemStackToSlot(EntityEquipmentSlot.MAINHAND, new ItemStack(chosenSword));
                }
            }
        }

        if (hasArmorCapability != null) {
            hasArmorCapability.setHasArmor(true);
        }
    }

}