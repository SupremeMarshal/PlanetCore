package com.PlanetCore.init;

import net.minecraft.item.Item;
import net.minecraftforge.common.util.EnumHelper;

import java.util.HashMap;
import java.util.Map;

public class ToolMaterials {

    public static final Map<Item.ToolMaterial, Float> relentlessMap = new HashMap<>();

    public static final Item.ToolMaterial ALUMINIUM = createToolMaterial("aluminium", 2, 196, 5.0F, 1.0F, 15, 1.5F);
    public static final Item.ToolMaterial COMPLETE_ALUMINIUM = createToolMaterial("complete_aluminium", 2, 393, 5.0F, 1.0F, 15, 1.5F);
    public static final Item.ToolMaterial COMPLETE_IRON = createToolMaterial("complete_iron", 2, 500, 6.0F, 2.0F, 22, 1.5F);
    public static final Item.ToolMaterial STEEL = createToolMaterial("steel", 2, 500, 6.0F, 2, 22, 2.0F);
    public static final Item.ToolMaterial COMPLETE_STEEL = createToolMaterial("complete_steel", 2, 1000, 6.0F, 2, 22, 2.0F);
    public static final Item.ToolMaterial COPPER = createToolMaterial("copper", 2, 200, 6.0F, 2, 10, 1.5F);
    public static final Item.ToolMaterial COMPLETE_COPPER = createToolMaterial("complete_copper", 2, 400, 6.0F, 2, 10, 1.5F);
    public static final Item.ToolMaterial TIN = createToolMaterial("tin", 2, 200, 6.0F, 2, 22, 1.5F);
    public static final Item.ToolMaterial COMPLETE_TIN = createToolMaterial("complete_tin", 2, 400, 6.0F, 2, 22, 1.5F);
    public static final Item.ToolMaterial BRONZE = createToolMaterial("bronze", 2, 400, 8.0F, 2.5F, 22, 1.5F);
    public static final Item.ToolMaterial COMPLETE_BRONZE = createToolMaterial("complete_bronze", 2, 800, 8.0F, 2.5F, 22, 1.5F);
    public static final Item.ToolMaterial SILVER = createToolMaterial("silver", 3, 33, 10.0F, 0.0F, 22, 1.5F);
    public static final Item.ToolMaterial COMPLETE_SILVER = createToolMaterial("complete_silver", 3, 75, 10.0F, 0.0F, 22, 1.5F);
    public static final Item.ToolMaterial COMPLETE_GOLD = createToolMaterial("complete_gold", 3, 75, 12.0F, 0.0F, 22, 1.5F);
    public static final Item.ToolMaterial COMPLETE_DIAMOND = createToolMaterial("complete_diamond", 3, 3122, 8.0F, 3.0F, 22, 2.5F);
    public static final Item.ToolMaterial TITANIUM = createToolMaterial("titanium", 3, 500, 12.0F, 3.5F, 22, 2.0F);
    public static final Item.ToolMaterial COMPLETE_TITANIUM = createToolMaterial("complete_titanium", 3, 1000, 12.0F, 3.5F, 22, 2.0F);
    public static final Item.ToolMaterial URANIUM = createToolMaterial("uranium", 4, 120, 15.0F, 4.0F, 22, 2.0F);
    public static final Item.ToolMaterial COMPLETE_URANIUM = createToolMaterial("complete_uranium", 4, 240, 15.0F, 4.0F, 22, 2.0F);
    public static final Item.ToolMaterial TUNGSTEN = createToolMaterial("tungsten", 4, 2000, 20.0F, 4.0F, 22, 2F);
    public static final Item.ToolMaterial COMPLETE_TUNGSTEN = createToolMaterial("complete_tungsten", 4, 4000, 20.0F, 4.0F, 22, 2F);
    public static final Item.ToolMaterial TUNGSTEN_TITANIUM = createToolMaterial("tungsten_titanium", 4, 3000, 30.0F, 4.5F, 22, 2F);
    public static final Item.ToolMaterial COMPLETE_TUNGSTEN_TITANIUM = createToolMaterial("complete_tungsten_titanium", 4, 6000, 30.0F, 4.5F, 22, 2F);
    public static final Item.ToolMaterial TOPAZ = createToolMaterial("topaz", 5, 90, 14.0F, 3.5F, 22, 2F);
    public static final Item.ToolMaterial JADE = createToolMaterial("jade", 5, 120, 20.0F, 4.0F, 22, 2F);
    public static final Item.ToolMaterial RUBY = createToolMaterial("ruby", 6, 3122, 50.0F, 5.0F, 22, 2F);
    public static final Item.ToolMaterial SAPPHIRE = createToolMaterial("sapphire", 6, 3122, 70.0F, 5.5F, 22, 2F);
    public static final Item.ToolMaterial OLIVINE = createToolMaterial("olivine", 11, 3122, 90.0F, 6.0F, 22, 2);
    public static final Item.ToolMaterial WADSLEYITE = createToolMaterial("wadsleyite", 12, 3122, 120.0F, 6.5F, 22, 2);
    public static final Item.ToolMaterial RINGWOODITE = createToolMaterial("ringwoodite", 13, 3122, 150.0F, 7.0F, 22, 2);
    public static final Item.ToolMaterial BRIGMANITE = createToolMaterial("brigmanite", 14, 3122, 200.0F, 7.5F, 22, 2);
    public static final Item.ToolMaterial MAJORITE = createToolMaterial("majorite", 15, 3122, 250.0F, 8.0F, 22, 2);
    public static final Item.ToolMaterial AMAZONITE = createToolMaterial("amazonite", 100, 3122, 300.0F, 8.5F, 22, 2);
    public static final Item.ToolMaterial ONYX = createToolMaterial("onyx", 1000, 3122, 400.0F, 9.0F, 22, 2);
    public static final Item.ToolMaterial ONYX_II = createToolMaterial("onyx_II", 1000, 3122, 500.0F, 10.0F, 22, 2);
    public static final Item.ToolMaterial ONYX_III = createToolMaterial("onyx_III", 1000, 3122, 750.0F, 11.0F, 22, 2);
    public static final Item.ToolMaterial ONYX_IV = createToolMaterial("onyx_IV", 1000, 3122, 1000.0F, 12.0F, 22, 2);
    public static final Item.ToolMaterial ONYX_V = createToolMaterial("onyx_V", 1000, 3122, 1500.0F, 13.0F, 22, 2);

    public static Item.ToolMaterial createToolMaterial(String name, int harvestLevel, int maxUses, float efficiency, float damageVsEntity, int enchantability, float relentless) {
        Item.ToolMaterial toolMaterial = EnumHelper.addToolMaterial(name, harvestLevel, maxUses, efficiency, damageVsEntity, enchantability);
        relentlessMap.put(toolMaterial, relentless);
        return toolMaterial;
    }
}
