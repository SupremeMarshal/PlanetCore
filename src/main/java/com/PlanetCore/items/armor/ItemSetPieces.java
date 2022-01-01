package com.PlanetCore.items.armor;
import it.unimi.dsi.fastutil.objects.Reference2ReferenceOpenHashMap;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.*;

public class ItemSetPieces {
    public static class SetBonus {
        final List<Item[]> requiredItemSets;
        final List<PotionEffect> bonuses;

        public SetBonus(List<Item[]> requiredItems, PotionEffect... bonuses) {
            this.requiredItemSets = requiredItems;
            this.bonuses = Arrays.asList(bonuses);
        }

        /**
         * Returns if the given list of items meets the requirements of the set bonus
         * ie has a piece in every Item[] of the requiredItemSets field
         */
        public boolean requirementsMet(List<Item> items) {
            for (Item[] requiredItemSet : requiredItemSets) {
                boolean anyMeetRequirement = false;
                for (Item requiredItem : requiredItemSet) {
                    for (Item item : items) {
                        if (requiredItem == item) {
                            anyMeetRequirement = true;
                            break;
                        }
                    }
                }
                if(!anyMeetRequirement) {
                    return false;
                }
            }
            return true;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            SetBonus setBonus = (SetBonus) o;
            return Objects.equals(requiredItemSets, setBonus.requiredItemSets) && Objects.equals(bonuses, setBonus.bonuses);
        }

        @Override
        public int hashCode() {
            return Objects.hash(requiredItemSets, bonuses);
        }
    }

    private static final Map<Item, List<SetBonus>> setBonusesByItem = new Reference2ReferenceOpenHashMap<>();

    public static void registerSetBonus(@Nonnull SetBonus setBonus) {
        for (Item[] requiredItems : setBonus.requiredItemSets) {
            for (Item requiredItem : requiredItems) {
                setBonusesByItem.computeIfAbsent(requiredItem, item -> new ArrayList<>()).add(setBonus);
            }
        }
    }

    @Nullable
    public static List<PotionEffect> getSetBonus(@Nonnull Item... items) {
        List<Item> nonNullItems = collectNonNullValues(items);
        if(nonNullItems.size() == 0)
            return null;

        //Collect all possible set bonuses into a single set
        Set<SetBonus> allPossibleSetBonuses = new HashSet<>();
        for (Item item : nonNullItems) {
            List<SetBonus> setBonus = setBonusesByItem.get(item);
            if (setBonus != null) {
                allPossibleSetBonuses.addAll(setBonus);
            }
        }

        //Find all set bonuses the given items meet, and add to array
        List<PotionEffect> effects = new ArrayList<>();
        for (SetBonus setBonus : allPossibleSetBonuses) {
            if(setBonus.requirementsMet(nonNullItems)) {
                effects.addAll(setBonus.bonuses);
            }
        }
        return effects;
    }

    private static <T> ArrayList<T> collectNonNullValues(T[] ts) {
        ArrayList<T> nonNullTs = new ArrayList<>();
        for (T t : ts) {
            if(t != null) {
                nonNullTs.add(t);
            }
        }
        return nonNullTs;
    }

    public static <T> ArrayList<T[]> newArrayList(T[]... tArrays) {
        return new ArrayList<>(Arrays.asList(tArrays));
    }
}