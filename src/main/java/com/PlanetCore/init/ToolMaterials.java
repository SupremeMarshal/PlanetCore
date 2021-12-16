package com.PlanetCore.init;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

import java.util.HashMap;
import java.util.Map;

public class ToolMaterials {

    public static final Map<Item.ToolMaterial, Integer> relentlessMap = new HashMap<>();

    public static final Item.ToolMaterial WOODEN = createToolMaterial("wooden", 1, 5, 1.0F, 0.4F, 15, 1);
    public static final Item.ToolMaterial STONE = createToolMaterial("stone", 1, 32, 1.5F, 0.8F, 15, 2);
    public static final Item.ToolMaterial ALUMINIUM = createToolMaterial("alumiunium", 2, 50, 2.0F, 1.0F, 15, 3);
    public static final Item.ToolMaterial COMPLETE_ALUMINIUM = createToolMaterial("complete_alumiunium", 2, 100, 2.0F, 1.0F, 15, 3);
    public static final Item.ToolMaterial IRON = createToolMaterial("iron", 2, 400, 3.0F, 2.0F, 22, 3);
    public static final Item.ToolMaterial COMPLETE_IRON = createToolMaterial("complete_iron", 2, 800, 3.0F, 2.0F, 22, 3);
    public static final Item.ToolMaterial STEEL = createToolMaterial("steel", 2, 800, 4.0F, 2.5F, 22, 3);
    public static final Item.ToolMaterial COMPLETE_STEEL = createToolMaterial("complete_steel", 2, 1600, 4.0F, 2.5F, 22, 3);
    public static final Item.ToolMaterial COPPER = createToolMaterial("copper", 2, 200, 5.0F, 2.8F, 10, 3);
    public static final Item.ToolMaterial COMPLETE_COPPER = createToolMaterial("complete_copper", 2, 400, 5.0F, 2.8F, 10, 3);
    public static final Item.ToolMaterial TIN = createToolMaterial("tin", 2, 200, 5.0F, 2.8F, 22, 3);
    public static final Item.ToolMaterial COMPLETE_TIN = createToolMaterial("complete_tin", 2, 400, 5.0F, 2.8F, 22, 3);
    public static final Item.ToolMaterial BRONZE = createToolMaterial("bronze", 2, 300, 6.0F, 4.0F, 22, 4);
    public static final Item.ToolMaterial COMPLETE_BRONZE = createToolMaterial("complete_bronze", 2, 600, 6.0F, 4.0F, 22, 4);
    public static final Item.ToolMaterial SILVER = createToolMaterial("silver", 3, 200, 12.0F, 5.8F, 22, 4);
    public static final Item.ToolMaterial COMPLETE_SILVER = createToolMaterial("complete_silver", 3, 400, 12.0F, 5.8F, 22, 4);
    public static final Item.ToolMaterial GOLD = createToolMaterial("gold", 3, 300, 18F, 6.4F, 22, 4);
    public static final Item.ToolMaterial COMPLETE_GOLD = createToolMaterial("complete_gold", 3, 600, 18.0F, 6.4F, 22, 4);
    public static final Item.ToolMaterial PLATINUM = createToolMaterial("platinum", 3, 400, 24.0F, 7.0F, 22, 4);
    public static final Item.ToolMaterial COMPLETE_PLATINUM = createToolMaterial("complete_platinum", 3, 800, 24.0F, 7.0F, 22, 4);
    public static final Item.ToolMaterial TITANIUM = createToolMaterial("titanium", 3, 1000, 30.0F, 7.6F, 22, 4);
    public static final Item.ToolMaterial COMPLETE_TITANIUM = createToolMaterial("complete_titanium", 3, 2000, 30.0F, 7.6F, 22, 4);
    public static final Item.ToolMaterial URANIUM = createToolMaterial("uranium", 4, 30, 100.0F, 9.4F, 22, 3);
    public static final Item.ToolMaterial COMPLETE_URANIUM = createToolMaterial("complete_uranium", 4, 60, 100.0F, 9.4F, 22, 3);
    public static final Item.ToolMaterial TUNGSTEN = createToolMaterial("tungsten", 4, 2000, 42.0F, 7.0F, 22, 4);
    public static final Item.ToolMaterial COMPLETE_TUNGSTEN = createToolMaterial("complete_tungsten", 4, 4000, 42.0F, 7.0F, 22, 4);
    public static final Item.ToolMaterial TITANIUM_URANIUM = createToolMaterial("titanium_uranium", 4, 1030, 130.0F, 12.0F, 22, 3);
    public static final Item.ToolMaterial COMPLETE_TITANIUM_URANIUM = createToolMaterial("complete_titanium_uranium", 4, 2060, 130.0F, 12.0F, 22, 3);
    public static final Item.ToolMaterial TUNGSTEN_URANIUM = createToolMaterial("tungsten_uranium", 4, 2030, 142.0F, 12.0F, 22, 3);
    public static final Item.ToolMaterial COMPLETE_TUNGSTEN_URANIUM = createToolMaterial("complete_tungsten_uranium", 4, 4060, 142.0F, 12.0F, 22, 3);
    public static final Item.ToolMaterial TUNGSTEN_TITANIUM = createToolMaterial("tungsten_titanium", 4, 3000, 72.0F, 9.0F, 22, 4);
    public static final Item.ToolMaterial COMPLETE_TUNGSTEN_TITANIUM = createToolMaterial("complete_tungsten_titanium", 4, 6000, 72.0F, 9.0F, 22, 4);
    public static final Item.ToolMaterial EMERALD = createToolMaterial("emerald", 5, 600, 200.0F, 9.5F, 22, 4);
    public static final Item.ToolMaterial RUBY = createToolMaterial("ruby", 6, 900, 300.0F, 10.0F, 22, 4);
    public static final Item.ToolMaterial SAPPHIRE = createToolMaterial("sapphire", 6, 1200, 500.0F, 11.0F, 22, 4);
    public static final Item.ToolMaterial DIAMOND = createToolMaterial("diamond", 10, 1500, 1000.0F, 12.5F, 22, 5);
    public static final Item.ToolMaterial OLIVINE = createToolMaterial("olivine", 11, 1600, 1500.0F, 13.0F, 22, 5);
    public static final Item.ToolMaterial WADSLEYITE = createToolMaterial("wadsleyite", 12, 1800, 2000.0F, 13.5F, 22, 5);
    public static final Item.ToolMaterial RINGWOODITE = createToolMaterial("ringwoodite", 13, 2000, 2500.0F, 14.0F, 22, 5);
    public static final Item.ToolMaterial BRIGMANITE = createToolMaterial("brigmanite", 14, 2500, 3000.0F, 14.5F, 22, 5);
    public static final Item.ToolMaterial MAJORITE = createToolMaterial("majorite", 15, 3000, 3500.0F, 15.0F, 22, 5);
    public static final Item.ToolMaterial AMAZONITE = createToolMaterial("amazonite", 100, 5000, 5000.0F, 17.5F, 22, 6);
    public static final Item.ToolMaterial ONYX = createToolMaterial("onyx", 1000, 10000, 10000.0F, 20.0F, 22, 7);

    public static Item.ToolMaterial createToolMaterial(String name, int harvestLevel, int maxUses, float efficiency, float damageVsEntity, int enchantability, int relentless) {
        Item.ToolMaterial toolMaterial = EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damageVsEntity, enchantability);
        relentlessMap.put(toolMaterial, relentless);
        return toolMaterial;
    }
}
