package com.PlanetCore.init;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

import java.util.HashMap;
import java.util.Map;

public class ToolMaterials {

    public static final Map<Item.ToolMaterial, Float> relentlessMap = new HashMap<>();

    public static final Item.ToolMaterial WOODEN = createToolMaterial("wooden", 1, 5, 1.0F, 0.4F, 15, 1);
    public static final Item.ToolMaterial STONE = createToolMaterial("stone", 1, 32, 1.5F, 0.8F, 15, 2);
    public static final Item.ToolMaterial ALUMINIUM = createToolMaterial("aluminium", 2, 50, 2.0F, 1.0F, 15, 2);
    public static final Item.ToolMaterial COMPLETE_ALUMINIUM = createToolMaterial("complete_aluminium", 2, 100, 2.0F, 1.0F, 15, 2);
    public static final Item.ToolMaterial IRON = createToolMaterial("iron", 2, 400, 3.0F, 2.0F, 22, 2);
    public static final Item.ToolMaterial COMPLETE_IRON = createToolMaterial("complete_iron", 2, 800, 3.0F, 2.0F, 22, 2);
    public static final Item.ToolMaterial STEEL = createToolMaterial("steel", 2, 800, 4.0F, 2.5F, 22, 2.5F);
    public static final Item.ToolMaterial COMPLETE_STEEL = createToolMaterial("complete_steel", 2, 1600, 4.0F, 2.5F, 22, 2.5F);
    public static final Item.ToolMaterial COPPER = createToolMaterial("copper", 2, 200, 5.0F, 2.8F, 10, 2.0F);
    public static final Item.ToolMaterial COMPLETE_COPPER = createToolMaterial("complete_copper", 2, 400, 5.0F, 2.8F, 10, 2.0F);
    public static final Item.ToolMaterial TIN = createToolMaterial("tin", 2, 200, 3.0F, 2.8F, 22, 2.5F);
    public static final Item.ToolMaterial COMPLETE_TIN = createToolMaterial("complete_tin", 2, 400, 3.0F, 2.8F, 22, 2.5F);
    public static final Item.ToolMaterial BRONZE = createToolMaterial("bronze", 2, 300, 8.0F, 4.0F, 22, 2.5F);
    public static final Item.ToolMaterial COMPLETE_BRONZE = createToolMaterial("complete_bronze", 2, 600, 8.0F, 4.0F, 22, 2.5F);
    public static final Item.ToolMaterial SILVER = createToolMaterial("silver", 3, 200, 15.0F, 5.8F, 22, 2.5F);
    public static final Item.ToolMaterial COMPLETE_SILVER = createToolMaterial("complete_silver", 3, 400, 15.0F, 5.8F, 22, 2.5F);
    public static final Item.ToolMaterial GOLD = createToolMaterial("gold", 3, 300, 22F, 6.4F, 22, 2.5F);
    public static final Item.ToolMaterial COMPLETE_GOLD = createToolMaterial("complete_gold", 3, 600, 22.0F, 6.4F, 22, 2.5F);
    public static final Item.ToolMaterial PLATINUM = createToolMaterial("platinum", 3, 400, 35.0F, 7.0F, 22, 2.5F);
    public static final Item.ToolMaterial COMPLETE_PLATINUM = createToolMaterial("complete_platinum", 3, 800, 35.0F, 7.0F, 22, 2.5F);
    public static final Item.ToolMaterial TITANIUM = createToolMaterial("titanium", 3, 1000, 50.0F, 7.6F, 22, 2.5F);
    public static final Item.ToolMaterial COMPLETE_TITANIUM = createToolMaterial("complete_titanium", 3, 2000, 50.0F, 7.6F, 22, 2.5F);
    public static final Item.ToolMaterial URANIUM = createToolMaterial("uranium", 4, 30, 75.0F, 8.2F, 22, 2.5F);
    public static final Item.ToolMaterial COMPLETE_URANIUM = createToolMaterial("complete_uranium", 4, 60, 75.0F, 8.2F, 22, 2.5F);
    public static final Item.ToolMaterial TITANIUM_URANIUM = createToolMaterial("titanium_uranium", 4, 120, 125.0F, 8.8F, 22, 2.5F);
    public static final Item.ToolMaterial COMPLETE_TITANIUM_URANIUM = createToolMaterial("complete_titanium_uranium", 4, 240, 125.0F, 8.8F, 22, 2.5F);
    public static final Item.ToolMaterial TUNGSTEN = createToolMaterial("tungsten", 4, 2000, 250.0F, 10.0F, 22, 2.5F);
    public static final Item.ToolMaterial COMPLETE_TUNGSTEN = createToolMaterial("complete_tungsten", 4, 4000, 250.0F, 10.0F, 22, 2.5F);
    public static final Item.ToolMaterial TUNGSTEN_TITANIUM = createToolMaterial("tungsten_titanium", 4, 3000, 375.0F, 11.2F, 22, 2.5F);
    public static final Item.ToolMaterial COMPLETE_TUNGSTEN_TITANIUM = createToolMaterial("complete_tungsten_titanium", 4, 6000, 375.0F, 11.2F, 22, 2.5F);
    public static final Item.ToolMaterial TUNGSTEN_URANIUM = createToolMaterial("tungsten_uranium", 4, 180, 562.0F, 12.4F, 22, 2.5F);
    public static final Item.ToolMaterial COMPLETE_TUNGSTEN_URANIUM = createToolMaterial("complete_tungsten_uranium", 4, 380, 562.0F, 12.4F, 22, 2.5F);
    public static final Item.ToolMaterial EMERALD = createToolMaterial("emerald", 5, 600, 1000.0F, 13.6F, 22, 3);
    public static final Item.ToolMaterial RUBY = createToolMaterial("ruby", 6, 900, 2000.0F, 14.8F, 22, 3);
    public static final Item.ToolMaterial SAPPHIRE = createToolMaterial("sapphire", 6, 1200, 3000.0F, 16.0F, 22, 3);
    public static final Item.ToolMaterial DIAMOND = createToolMaterial("diamond", 10, 2500, 5000.0F, 17.2F, 22, 3);
    public static final Item.ToolMaterial OLIVINE = createToolMaterial("olivine", 11, 1200, 7500.0F, 18.4F, 22, 3);
    public static final Item.ToolMaterial WADSLEYITE = createToolMaterial("wadsleyite", 12, 1200, 10000.0F, 19.6F, 22, 3);
    public static final Item.ToolMaterial RINGWOODITE = createToolMaterial("ringwoodite", 13, 1200, 15000.0F, 20.8F, 22, 3);
    public static final Item.ToolMaterial BRIGMANITE = createToolMaterial("brigmanite", 14, 1200, 22500.0F, 22.0F, 22, 3);
    public static final Item.ToolMaterial MAJORITE = createToolMaterial("majorite", 15, 1200, 33750.0F, 23.2F, 22, 3.5F);
    public static final Item.ToolMaterial AMAZONITE = createToolMaterial("amazonite", 100, 1200, 50000.0F, 25.0F, 22, 4);
    public static final Item.ToolMaterial ONYX = createToolMaterial("onyx", 1000, 2500, 100000.0F, 26.8F, 22, 4.5F);
    public static final Item.ToolMaterial ONYX_II = createToolMaterial("onyx_II", 1000, 2500, 200000.0F, 30.4F, 22, 5.0F);
    public static final Item.ToolMaterial ONYX_III = createToolMaterial("onyx_III", 1000, 2500, 300000.0F, 32.2F, 22, 5.0F);
    public static final Item.ToolMaterial ONYX_IV = createToolMaterial("onyx_IV", 1000, 2500, 400000.0F, 34.0F, 22, 5.0F);
    public static final Item.ToolMaterial ONYX_V = createToolMaterial("onyx_V", 1000, 2500, 500000.0F, 35.8F, 22, 5.0F);

    public static Item.ToolMaterial createToolMaterial(String name, int harvestLevel, int maxUses, float efficiency, float damageVsEntity, int enchantability, float relentless) {
        Item.ToolMaterial toolMaterial = EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damageVsEntity, enchantability);
        relentlessMap.put(toolMaterial, relentless);
        return toolMaterial;
    }
}
