package com.PlanetCore.init;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

import java.util.HashMap;
import java.util.Map;

public class ToolMaterials {

    public static final Map<Item.ToolMaterial, Integer> relentlessMap = new HashMap<>();

    public static final Item.ToolMaterial WOODEN = createToolMaterial("wooden", 1, 5, 1.0F, 0.4F, 15, 1);
    public static final Item.ToolMaterial STONE = createToolMaterial("stone", 1, 32, 1.5F, 0.8F, 15, 3);
    public static final Item.ToolMaterial ALUMINIUM = createToolMaterial("alumiunium", 2, 50, 2.0F, 1.0F, 15, 3);
    public static final Item.ToolMaterial COMPLETE_ALUMINIUM = createToolMaterial("complete_alumiunium", 2, 100, 2.5F, 1.0F, 15, 3);
    public static final Item.ToolMaterial LEAD = createToolMaterial("lead", 2, 150, 3.0F, 1.4F, 5, 3);
    public static final Item.ToolMaterial COMPLETE_LEAD = createToolMaterial("complete_lead", 2, 300, 3.5F, 1.4F, 5, 3);
    public static final Item.ToolMaterial SILICON = createToolMaterial("silicon", 2, 150, 4.0F, 1.8F, 14, 3);
    public static final Item.ToolMaterial COMPLETE_SILICON = createToolMaterial("complete_silicon", 2, 300, 4.5F, 1.8F, 14, 3);
    public static final Item.ToolMaterial COPPER = createToolMaterial("copper", 2, 200, 5.0F, 2.4F, 10, 3);
    public static final Item.ToolMaterial COMPLETE_COPPER = createToolMaterial("complete_copper", 2, 400, 5.5F, 2.4F, 10, 3);
    public static final Item.ToolMaterial ZINC = createToolMaterial("zinc", 2, 250, 8.0F, 3.4F, 22, 4);
    public static final Item.ToolMaterial COMPLETE_ZINC = createToolMaterial("complete_zinc", 2, 500, 8.5F, 3.4F, 22, 4);
    public static final Item.ToolMaterial TIN = createToolMaterial("tin", 2, 200, 5.0F, 2.8F, 22, 3);
    public static final Item.ToolMaterial COMPLETE_TIN = createToolMaterial("complete_tin", 2, 400, 5.5F, 2.8F, 22, 3);
    public static final Item.ToolMaterial BRONZE = createToolMaterial("bronze", 2, 300, 12.0F, 4.0F, 22, 3);
    public static final Item.ToolMaterial COMPLETE_BRONZE = createToolMaterial("complete_bronze", 2, 600, 14.0F, 4.0F, 22, 3);
    public static final Item.ToolMaterial IRON = createToolMaterial("iron", 2, 400, 7.0F, 4.6F, 22, 4);
    public static final Item.ToolMaterial COMPLETE_IRON = createToolMaterial("complete_iron", 2, 800, 8.0F, 4.6F, 22, 4);
    public static final Item.ToolMaterial STEEL = createToolMaterial("steel", 2, 800, 9.0F, 5.2F, 22, 4);
    public static final Item.ToolMaterial COMPLETE_STEEL = createToolMaterial("complete_steel", 2, 1600, 10.0F, 5.2F, 22, 4);
    public static final Item.ToolMaterial SILVER = createToolMaterial("silver", 3, 100, 16.0F, 5.8F, 22, 5);
    public static final Item.ToolMaterial COMPLETE_SILVER = createToolMaterial("complete_silver", 3, 200, 18.0F, 5.8F, 22, 5);
    public static final Item.ToolMaterial GOLD = createToolMaterial("gold", 3, 150, 20.0F, 6.4F, 22, 5);
    public static final Item.ToolMaterial COMPLETE_GOLD = createToolMaterial("complete_gold", 3, 300, 22.0F, 6.4F, 22, 5);
    public static final Item.ToolMaterial PLATINUM = createToolMaterial("platinum", 3, 200, 24.0F, 7.0F, 22, 5);
    public static final Item.ToolMaterial COMPLETE_PLATINUM = createToolMaterial("complete_platinum", 3, 400, 26.0F, 7.0F, 22, 5);
    public static final Item.ToolMaterial TITANIUM = createToolMaterial("titanium", 3, 1000, 28.0F, 7.6F, 22, 5);
    public static final Item.ToolMaterial COMPLETE_TITANIUM = createToolMaterial("complete_titanium", 3, 2000, 30.0F, 7.6F, 22, 5);
    public static final Item.ToolMaterial URANIUM = createToolMaterial("uranium", 4, 30, 46.0F, 9.4F, 22, 6);
    public static final Item.ToolMaterial COMPLETE_URANIUM = createToolMaterial("complete_uranium", 4, 60, 50.0F, 9.4F, 22, 6);
    public static final Item.ToolMaterial TOPAZ = createToolMaterial("topaz", 4, 100, 36.0F, 8.2F, 22, 4);
    public static final Item.ToolMaterial JADE = createToolMaterial("jade", 4, 200, 44.0F, 8.8F, 22, 4);
    public static final Item.ToolMaterial TUNGSTEN = createToolMaterial("tungsten", 4, 2000, 32.0F, 7.0F, 22, 5);
    public static final Item.ToolMaterial COMPLETE_TUNGSTEN = createToolMaterial("complete_tungsten", 4, 4000, 34.0F, 7.0F, 22, 5);
    public static final Item.ToolMaterial TITANIUM_URANIUM = createToolMaterial("titanium_uranium", 4, 1030, 46.0F, 12.0F, 22, 6);
    public static final Item.ToolMaterial COMPLETE_TITANIUM_URANIUM = createToolMaterial("complete_titanium_uranium", 4, 2060, 50.0F, 12.0F, 22, 6);
    public static final Item.ToolMaterial TUNGSTEN_URANIUM = createToolMaterial("tungsten_uranium", 4, 2030, 46.0F, 12.0F, 22, 6);
    public static final Item.ToolMaterial COMPLETE_TUNGSTEN_URANIUM = createToolMaterial("complete_tungsten_uranium", 4, 4060, 50.0F, 12.0F, 22, 6);
    public static final Item.ToolMaterial TUNGSTEN_TITANIUM = createToolMaterial("tungsten_titanium", 4, 3000, 36.0F, 9.0F, 22, 6);
    public static final Item.ToolMaterial COMPLETE_TUNGSTEN_TITANIUM = createToolMaterial("complete_tungsten_titanium", 4, 6000, 38.0F, 9.0F, 22, 6);
    public static final Item.ToolMaterial EMERALD = createToolMaterial("emerald", 5, 100, 16.0F, 6.6F, 22, 3);
    public static final Item.ToolMaterial RUBY = createToolMaterial("ruby", 6, 600, 70.0F, 10.2F, 22, 4);
    public static final Item.ToolMaterial SAPPHIRE = createToolMaterial("sapphire", 6, 900, 80.0F, 10.2F, 22, 4);
    public static final Item.ToolMaterial DIAMOND = createToolMaterial("diamond", 10, 1200, 100.0F, 10.8F, 22, 4);
    public static final Item.ToolMaterial OLIVINE = createToolMaterial("olivine", 11, 1400, 120.0F, 11.6F, 22, 4);
    public static final Item.ToolMaterial WADSLEYITE = createToolMaterial("wadsleyite", 12, 1600, 140.0F, 12.6F, 22, 5);
    public static final Item.ToolMaterial RINGWOODITE = createToolMaterial("ringwoodite", 13, 2000, 160.0F, 13.8F, 22, 5);
    public static final Item.ToolMaterial BRIGMANITE = createToolMaterial("brigmanite", 14, 2500, 180.0F, 15.2F, 22, 5);
    public static final Item.ToolMaterial MAJORITE = createToolMaterial("majorite", 15, 5000, 200.0F, 16.6F, 22, 6);
    public static final Item.ToolMaterial AMAZONITE = createToolMaterial("amazonite", 100, 10000, 250.0F, 18.2F, 22, 6);
    public static final Item.ToolMaterial ONYX = createToolMaterial("onyx", 1000, 20000, 300.0F, 20.0F, 22, 6);

    public static Item.ToolMaterial createToolMaterial(String name, int harvestLevel, int maxUses, float efficiency, float damageVsEntity, int enchantability, int relentless) {
        Item.ToolMaterial toolMaterial = EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damageVsEntity, enchantability);
        relentlessMap.put(toolMaterial, relentless);
        return toolMaterial;
    }
}
