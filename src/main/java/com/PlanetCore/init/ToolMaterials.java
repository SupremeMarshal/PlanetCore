package com.PlanetCore.init;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

import java.util.HashMap;
import java.util.Map;

public class ToolMaterials {

    public static final Map<Item.ToolMaterial, Float> relentlessMap = new HashMap<>();

    public static final Item.ToolMaterial COMPLETE_IRON = createToolMaterial("complete_iron", 2, 500, 6.0F, 2.0F, 22, 1.5F);
    public static final Item.ToolMaterial SILVER = createToolMaterial("silver", 2, 33, 10.0F, 3.0F, 22, 1.5F);
    public static final Item.ToolMaterial COMPLETE_SILVER = createToolMaterial("complete_silver", 2, 75, 10.0F, -0.5F, 22, 1.5F);
    public static final Item.ToolMaterial COMPLETE_GOLD = createToolMaterial("complete_gold", 2, 75, 12.0F, 0.0F, 22, 1.5F);
    public static final Item.ToolMaterial COMPLETE_DIAMOND = createToolMaterial("complete_diamond", 3, 3122, 8.0F, 3.0F, 22, 2.5F);
    public static final Item.ToolMaterial TITANIUM = createToolMaterial("titanium", 4, 500, 12.0F, 4.0F, 22, 2.5F);
    public static final Item.ToolMaterial COMPLETE_TITANIUM = createToolMaterial("complete_titanium", 4, 1000, 12.0F, 4.0F, 22, 2.5F);
    public static final Item.ToolMaterial URANIUM = createToolMaterial("uranium", 4, 120, 15.0F, 5.0F, 22, 3.0F);
    public static final Item.ToolMaterial COMPLETE_URANIUM = createToolMaterial("complete_uranium", 4, 240, 15.0F, 5.0F, 22, 3.0F);
    public static final Item.ToolMaterial TUNGSTEN = createToolMaterial("tungsten", 5, 2000, 20.0F, 6.0F, 22, 3.5F);
    public static final Item.ToolMaterial COMPLETE_TUNGSTEN = createToolMaterial("complete_tungsten", 5, 4000, 20.0F, 6.0F, 22, 3.5F);
    public static final Item.ToolMaterial RUBY = createToolMaterial("ruby", 6, 3122, 30.0F, 7.0F, 22, 4F);
    public static final Item.ToolMaterial SAPPHIRE = createToolMaterial("sapphire", 7, 3122, 45.0F, 8.0F, 22, 4F);
    public static final Item.ToolMaterial MAJORITE = createToolMaterial("majorite", 8, 3122, 60.0F, 10.0F, 22, 4);
    public static final Item.ToolMaterial AMAZONITE = createToolMaterial("amazonite", 9, 3122, 100.0F, 14.0F, 22, 4);
    public static final Item.ToolMaterial ONYX = createToolMaterial("onyx", 10, 3122, 150.0F, 18.0F, 22, 5);
    public static final Item.ToolMaterial ONYX_II = createToolMaterial("onyx_II", 11, 3122, 225.0F, 22.0F, 22, 5);
    public static final Item.ToolMaterial ONYX_III = createToolMaterial("onyx_III", 12, 3122, 337.0F, 30.0F, 22, 5);
    public static final Item.ToolMaterial ONYX_IV = createToolMaterial("onyx_IV", 13, 3122, 506.0F, 40.0F, 22, 5);
    public static final Item.ToolMaterial ONYX_V = createToolMaterial("onyx_V", 14, 3122, 760.0F, 50.0F, 22, 5);
    public static final Item.ToolMaterial ONYX_CORE = createToolMaterial("onyx_core", 15, 20000, 1000.0F, 75.0F, 22, 5);
    public static Item.ToolMaterial createToolMaterial(String name, int harvestLevel, int maxUses, float efficiency, float damageVsEntity, int enchantability, float relentless) {
        Item.ToolMaterial toolMaterial = EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damageVsEntity, enchantability);
        relentlessMap.put(toolMaterial, relentless);
        return toolMaterial;
    }
}
