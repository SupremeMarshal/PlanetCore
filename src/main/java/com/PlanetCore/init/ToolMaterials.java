package com.PlanetCore.init;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

import java.util.HashMap;
import java.util.Map;

public class ToolMaterials {

    public static final Map<Item.ToolMaterial, Integer> relentlessMap = new HashMap<>();

    public static final Item.ToolMaterial WOODEN = createToolMaterial("wooden", 1, 5, 1.0F, 0.4F, 15, 1);
    public static final Item.ToolMaterial STONE = createToolMaterial("stone", 1, 32, 1.5F, 0.8F, 15, 3);
    public static final Item.ToolMaterial ALUMINIUM = createToolMaterial("alumiunium", 2, 60, 2.0F, 1.0F, 15, 3);
    public static final Item.ToolMaterial COMPLETE_ALUMINIUM = createToolMaterial("complete_alumiunium", 2, 120, 2.5F, 1.0F, 15, 3);
    public static final Item.ToolMaterial LEAD = createToolMaterial("stone", 2, 150, 3.0F, 1.4F, 5, 3);
    public static final Item.ToolMaterial COMPLETE_LEAD = createToolMaterial("complete_lead", 2, 300, 3.5F, 1.4F, 5, 3);
    public static final Item.ToolMaterial SILICON = createToolMaterial("stone", 2, 360, 4.0F, 1.8F, 14, 3);
    public static final Item.ToolMaterial COMPLETE_SILICON = createToolMaterial("complete_silicon", 2, 720, 4.5F, 1.8F, 14, 3);
    public static final Item.ToolMaterial COPPER = createToolMaterial("stone", 2, 240, 5.0F, 2.4F, 10, 4);
    public static final Item.ToolMaterial COMPLETE_COPPER = createToolMaterial("complete_copper", 2, 480, 5.5F, 2.4F, 10, 4);
    public static final Item.ToolMaterial ZINC = createToolMaterial("stone", 2, 300, 8.0F, 3.4F, 22, 3);
    public static final Item.ToolMaterial COMPLETE_ZINC = createToolMaterial("complete_zinc", 2, 600, 8.5F, 3.4F, 22, 3);
    public static final Item.ToolMaterial TIN = createToolMaterial("tin", 2, 190, 5.0F, 2.8F, 22, 3);
    public static final Item.ToolMaterial COMPLETE_TIN = createToolMaterial("complete_tin", 2, 380, 5.5F, 2.8F, 22, 3);
    public static final Item.ToolMaterial BRONZE = createToolMaterial("bronze", 2, 500, 12.0F, 4.0F, 22, 5);
    public static final Item.ToolMaterial COMPLETE_BRONZE = createToolMaterial("complete_bronze", 2, 1000, 14.0F, 4.0F, 22, 5);
    public static final Item.ToolMaterial IRON = createToolMaterial("iron", 2, 1000, 7.0F, 4.6F, 22, 5);
    public static final Item.ToolMaterial COMPLETE_IRON = createToolMaterial("complete_iron", 2, 2000, 8.0F, 4.6F, 22, 5);
    public static final Item.ToolMaterial STEEL = createToolMaterial("stone", 2, 1600, 9.0F, 5.2F, 22, 5);
    public static final Item.ToolMaterial COMPLETE_STEEL = createToolMaterial("complete_steel", 2, 3200, 10.0F, 5.2F, 22, 5);
    public static final Item.ToolMaterial SILVER = createToolMaterial("silver", 3, 600, 16.0F, 5.8F, 22, 5);
    public static final Item.ToolMaterial COMPLETE_SILVER = createToolMaterial("complete_silver", 3, 1200, 18.0F, 5.8F, 22, 5);
    public static final Item.ToolMaterial GOLD = createToolMaterial("gold", 3, 800, 20.0F, 6.4F, 22, 5);
    public static final Item.ToolMaterial COMPLETE_GOLD = createToolMaterial("complete_gold", 3, 1600, 22.0F, 6.4F, 22, 5);
    public static final Item.ToolMaterial PLATINUM = createToolMaterial("platinum", 3, 1000, 24.0F, 7.0F, 22, 5);
    public static final Item.ToolMaterial COMPLETE_PLATINUM = createToolMaterial("complete_platinum", 3, 2000, 26.0F, 7.0F, 22, 5);
    public static final Item.ToolMaterial TITANIUM = createToolMaterial("titanium", 3, 2000, 28.0F, 7.6F, 22, 5);
    public static final Item.ToolMaterial COMPLETE_TITANIUM = createToolMaterial("complete_titanium", 3, 4000, 30.0F, 7.6F, 22, 5);
    public static final Item.ToolMaterial URANIUM = createToolMaterial("uranium", 4, 100, 46.0F, 9.4F, 22, 6);
    public static final Item.ToolMaterial COMPLETE_URANIUM = createToolMaterial("complete_uranium", 4, 200, 50.0F, 9.4F, 22, 6);
    public static final Item.ToolMaterial TOPAZ = createToolMaterial("topaz", 4, 600, 36.0F, 8.2F, 22, 4);
    public static final Item.ToolMaterial JADE = createToolMaterial("jade", 4, 900, 44.0F, 8.8F, 22, 4);
    public static final Item.ToolMaterial TUNGSTEN = createToolMaterial("tungsten", 4, 6000, 32.0F, 7.0F, 22, 5);
    public static final Item.ToolMaterial COMPLETE_TUNGSTEN = createToolMaterial("complete_tungsten", 4, 12000, 34.0F, 7.0F, 22, 5);
    public static final Item.ToolMaterial TITANIUM_URANIUM = createToolMaterial("tungsten_uranium", 4, 2100, 46.0F, 12.0F, 22, 7);
    public static final Item.ToolMaterial COMPLETE_TITANIUM_URANIUM = createToolMaterial("complete_titanium_uranium", 4, 4200, 50.0F, 12.0F, 22, 7);
    public static final Item.ToolMaterial TUNGSTEN_URANIUM = createToolMaterial("tungsten_uranium", 4, 6100, 46.0F, 12.0F, 22, 7);
    public static final Item.ToolMaterial COMPLETE_TUNGSTEN_URANIUM = createToolMaterial("complete_tungsten_uranium", 4, 12200, 50.0F, 12.0F, 22, 7);
    public static final Item.ToolMaterial TUNGSTEN_TITANIUM = createToolMaterial("tungsten_titanium", 4, 20000, 36.0F, 9.0F, 22, 7);
    public static final Item.ToolMaterial COMPLETE_TUNGSTEN_TITANIUM = createToolMaterial("complete_tungsten_titanium", 4, 40000, 38.0F, 9.0F, 22, 7);
    public static final Item.ToolMaterial EMERALD = createToolMaterial("emerald", 5, 1000, 16.0F, 6.6F, 22, 5);
    public static final Item.ToolMaterial RUBY = createToolMaterial("ruby", 6, 2000, 70.0F, 10.2F, 22, 8);
    public static final Item.ToolMaterial SAPPHIRE = createToolMaterial("sapphire", 6, 2400, 80.0F, 10.2F, 22, 8);
    public static final Item.ToolMaterial DIAMOND = createToolMaterial("diamond", 10, 6400, 100.0F, 10.8F, 22, 16);
    public static final Item.ToolMaterial OLIVINE = createToolMaterial("olivine", 11, 8000, 120.0F, 11.6F, 22, 24);
    public static final Item.ToolMaterial WADSLEYITE = createToolMaterial("wadsleyite", 12, 9600, 140.0F, 12.6F, 22, 26);
    public static final Item.ToolMaterial RINGWOODITE = createToolMaterial("ringwoodite", 13, 10200, 160.0F, 13.8F, 22, 28);
    public static final Item.ToolMaterial BRIGMANITE = createToolMaterial("brigmanite", 14, 12800, 180.0F, 15.2F, 22, 30);
    public static final Item.ToolMaterial MAJORITE = createToolMaterial("majorite", 15, 14400, 200.0F, 16.6F, 22, 32);
    public static final Item.ToolMaterial AMAZONITE = createToolMaterial("amazonite", 100, 32000, 250.0F, 18.2F, 22, 64);
    public static final Item.ToolMaterial ONYX = createToolMaterial("onyx", 1000, 128000, 300.0F, 20.0F, 22, 128);

    public static Item.ToolMaterial createToolMaterial(String name, int harvestLevel, int maxUses, float efficiency, float damageVsEntity, int enchantability, int relentless) {
        Item.ToolMaterial toolMaterial = EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damageVsEntity, enchantability);
        relentlessMap.put(toolMaterial, relentless);
        return toolMaterial;
    }
}
