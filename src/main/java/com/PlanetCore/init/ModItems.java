package com.PlanetCore.init;

import com.PlanetCore.items.Gems;
import com.PlanetCore.items.ItemBase;
import com.PlanetCore.items.armor.*;
import com.PlanetCore.items.food.EnchantedFoodEffectBase;
import com.PlanetCore.items.food.EnchantedFoodEffectBase1;
import com.PlanetCore.items.food.FoodEffectBase;
import com.PlanetCore.items.shields.*;
import com.PlanetCore.items.tools.*;
import com.PlanetCore.items.tools.ItemSword;
import com.PlanetCore.items.tools.ItemAxe;
import com.PlanetCore.items.tools.ItemHoe;
import com.PlanetCore.items.tools.ItemSpade;
import com.PlanetCore.items.tools.ItemPickaxe;
import com.PlanetCore.util.Reference;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.util.EnumHelper;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;


public class ModItems {

	
	public static final List<Item> ITEMS = new ArrayList<Item>();

    public enum ToolMaterialCustom
	{
		WOODEN(1,5,1.0F,0.4F,15,1),
		STONE(1,32,1.5F,0.8F,15,3),
		ALUMINIUM(2, 60, 2.0F, 1.0F, 15, 3),
		COMPLETE_ALUMINIUM(2, 120, 2.5F, 1.0F, 15, 3),
		LEAD(2, 150, 3.0F, 1.4F, 5, 3),
		COMPLETE_LEAD(2, 300, 3.5F, 1.4F, 5, 3),
		SILICON(2, 360, 4.0F, 1.8F, 14, 3),
		COMPLETE_SILICON(2, 720, 4.5F, 1.8F, 14, 3),
		COPPER(2, 240, 5.0F, 2.4F, 10, 4),
		COMPLETE_COPPER(2, 480, 5.5F, 2.4F, 10, 4),
		ZINC(2, 300, 6.0F, 3.4F, 22, 3),
		COMPLETE_ZINC(2, 600, 6.5F, 3.4F, 22, 3),
		TIN(2, 190, 5.0F, 2.8F, 22, 3),
		COMPLETE_TIN(2, 380, 5.5F, 2.8F, 22, 3),
		BRONZE(2, 500, 9.0F, 4.0F, 22, 5),
		COMPLETE_BRONZE(2, 1000, 10.0F, 4.0F, 22, 5),
		IRON(2, 1000, 7.0F, 4.6F, 22, 5),
		COMPLETE_IRON(2, 2000, 8.0F, 4.6F, 22, 5),
		STEEL(2, 1600, 8.0F, 5.2F, 22, 5),
		COMPLETE_STEEL(2, 3200, 9.0F, 5.2F, 22, 5),
		SILVER(3, 600, 11.7F, 5.8F, 22, 5),
		COMPLETE_SILVER(3, 1200, 11.7F, 5.8F, 22, 5),
		GOLD(3, 800, 14.6F, 6.4F, 22, 5),
		COMPLETE_GOLD(3, 1600, 14.6F, 6.4F, 22, 5),
		PLATINUM(3, 1000, 18.3F, 7.0F, 22, 5),
		COMPLETE_PLATINUM(3, 2000, 18.3F, 7.0F, 22, 5),
		TITANIUM(3, 2000, 22.8F, 7.6F, 22, 5),
		COMPLETE_TITANIUM(3, 4000, 22.8F, 7.6F, 22, 5),
		URANIUM(4, 100, 35.7F, 9.4F, 22, 6),
		COMPLETE_URANIUM(4, 200, 35.7F, 9.4F, 22, 6),
		TOPAZ(4, 600, 44.7F, 8.2F, 22, 5),
		JADE(4, 800, 55.9F, 8.8F, 22, 5),
		TUNGSTEN(4, 6000, 28.6F, 7.0F, 22, 5),
		COMPLETE_TUNGSTEN(4, 12000, 28.6F, 7.0F, 22, 5),
		TITANIUM_URANIUM(4, 2100, 58.5F, 12.0F, 22, 7),
		COMPLETE_TITANIUM_URANIUM(4, 4200, 58.5F, 12.0F, 22, 7),
		TUNGSTEN_URANIUM(4, 6100, 64.3F, 12.0F, 22, 7),
		COMPLETE_TUNGSTEN_URANIUM(4, 12200, 64.3F, 12.0F, 22, 7),
		TUNGSTEN_TITANIUM(4, 20000, 51.4F, 9.0F, 22, 7),
		COMPLETE_TUNGSTEN_TITANIUM(4, 40000, 51.4F, 9.0F, 22, 7),
		EMERALD(5, 1000, 16.0F, 6.6F, 22, 5),
		RUBY(6, 2000, 87.3F, 10.2F, 22, 8),
		SAPPHIRE(6, 2400, 87.3F, 10.2F, 22, 8),
		DIAMOND(10, 6400, 109.0F, 10.8F, 22, 16),
		OLIVINE(11, 8000, 136.5F, 11.6F, 22, 24),
		WADSLEYITE(12, 9600, 170.5F, 12.6F, 22, 26),
		RINGWOODITE(13, 10200, 213.2F, 13.8F, 22, 28),
		BRIGMANITE(14, 12800, 266.5F, 15.2F, 22, 30),
		MAJORITE(15, 14400, 333.0F, 16.6F, 22, 32),
		AMAZONITE(100, 32000, 416.0F, 18.2F, 22, 64),
		ONYX(1000, 128000, 520.0F, 20.0F, 22, 128);


		/** The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = WOOD/GOLD) */
		private final int harvestLevel;
		/** The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32) */
		private final int maxUses;
		/** The strength of this tool material against blocks which it is effective against. */
		private final float efficiency;
		/** Damage versus entities. */
		private final float attackDamage;
		/** Defines the natural enchantability factor of the material. */
		private final int enchantability;
		/** Defines the number of second until the tool can't break the block. */
		private final int relentless;
		//Added by forge for custom Tool materials.
		private ItemStack repairMaterial = ItemStack.EMPTY;

		private ToolMaterialCustom(int harvestLevel, int maxUses, float efficiency, float damageVsEntity, int enchantability, int relentless)
		{
			this.harvestLevel = harvestLevel;
			this.maxUses = maxUses;
			this.efficiency = efficiency;
			this.attackDamage = damageVsEntity;
			this.enchantability = enchantability;
			this.relentless = relentless;
		}

		/**
		 * The number of uses this material allows. (wood = 59, stone = 131, iron = 250, diamond = 1561, gold = 32)
		 */
		public int getMaxUses()
		{
			return this.maxUses;
		}

		/**
		 * The strength of this tool material against blocks which it is effective against.
		 */
		public float getEfficiency()
		{
			return this.efficiency;
		}

		/**
		 * Returns the damage against a given entity.
		 */
		public float getAttackDamage()
		{
			return this.attackDamage;
		}

		/**
		 * The level of material this tool can harvest (3 = DIAMOND, 2 = IRON, 1 = STONE, 0 = IRON/GOLD)
		 */
		public int getHarvestLevel()
		{
			return this.harvestLevel;
		}

		/**
		 * Return the natural enchantability factor of the material.
		 */
		public int getEnchantability()
		{
			return this.enchantability;
		}

		/**
		 * Defines the number of seconds to break the block before the tool can't break it.
		 */
		public int getRelentless()
		{
			return this.relentless;
		}

		@Deprecated // Use getRepairItemStack below
		public Item getRepairItem()
		{
			if (this == WOODEN)
			{
				return Item.getItemFromBlock(Blocks.PLANKS);
			}
			else if (this == STONE)
			{
				return Item.getItemFromBlock(Blocks.COBBLESTONE);
			}
			else if (this == ALUMINIUM)
			{
				return ModItems.ALUMINIUM_INGOT;
			}
			else if (this == LEAD)
			{
				return ModItems.LEAD_INGOT;
			}
			else if (this == SILICON)
			{
				return ModItems.SILICON_INGOT;
			}
			else if (this == TIN)
			{
				return ModItems.TIN_INGOT;
			}
			else if (this == COPPER)
			{
				return ModItems.COPPER_INGOT;
			}
			else if (this == ZINC)
			{
				return ModItems.ZINC_INGOT;
			}
			else if (this == BRONZE)
			{
				return ModItems.BRONZE_INGOT;
			}
			else if (this == SILVER)
			{
				return ModItems.SILVER_INGOT;
			}
			else if (this == GOLD)
			{
				return ModItems.GOLD_INGOT;
			}
			else if (this == IRON)
			{
				return ModItems.IRON_INGOT;
			}
			else
			{
				return this == DIAMOND ? ModItems.DIAMOND : null;
			}
		}

		public com.PlanetCore.init.ModItems.ToolMaterialCustom setRepairItem(ItemStack stack)
		{
			if (!this.repairMaterial.isEmpty()) throw new RuntimeException("Repair material has already been set");
			if (this == ALUMINIUM || this == LEAD || this == SILICON || this == COPPER || this == ZINC || this == TIN || this == IRON || this == STEEL || this == BRONZE || this == SILVER || this == GOLD || this == PLATINUM
					|| this == TITANIUM || this == URANIUM || this == TOPAZ || this == JADE || this == TUNGSTEN || this == TITANIUM_URANIUM || this == TUNGSTEN_URANIUM || this == TUNGSTEN_TITANIUM || this == EMERALD
					|| this == RUBY || this == SAPPHIRE || this == DIAMOND || this == OLIVINE || this == WADSLEYITE || this == RINGWOODITE || this == BRIGMANITE || this == MAJORITE || this == AMAZONITE || this == ONYX) throw new RuntimeException("Can not change vanilla tool repair materials");
			this.repairMaterial = stack;
			return this;
		}

		public ItemStack getRepairItemStack()
		{
			if (!repairMaterial.isEmpty()) return repairMaterial;
			Item ret = this.getRepairItem();
			if (ret != null) repairMaterial = new ItemStack(ret, 1, net.minecraftforge.oredict.OreDictionary.WILDCARD_VALUE);
			return repairMaterial;
		}
	}

	public enum ItemOre {

		ONYX("onyx", id -> new ItemBase(id)),
		MAJORITE("majorite", id -> new ItemBase(id)),
		BRIGMANITE("brigmanite", id -> new ItemBase(id)),
		RINGWOODITE("ringwoodite", id -> new ItemBase(id)),
		AMAZONITE("amazonite", id -> new ItemBase(id)),
		DIAMOND("diamond", id -> new ItemBase(id)),
		SAPPHIRE("sapphire", id -> new ItemBase(id)),
		WADSLEYITE("wadsleyite", id -> new ItemBase(id)),
		RUBY("ruby", id -> new ItemBase(id)),
		TUNGSTEN("tungsten", id -> new ItemBase(id)),
		EMERALD("emerald", id -> new ItemBase(id)),
		TITANIUM("titanium", id -> new ItemBase(id)),
		URANIUM("uranium", id -> new ItemBase(id)),
		PLATINUM("platinum", id -> new ItemBase(id)),
		OLIVINE("olivine", id -> new ItemBase(id)),
		JADE("jade", id -> new ItemBase(id)),
		TOPAZ("topaz", id -> new ItemBase(id)),
		GOLD("gold", id -> new ItemBase(id)),
		SILVER("silver", id -> new ItemBase(id)),
		REDSTONE("redstone", id -> new ItemBase(id)),
		LAPIS("lapis", id -> new ItemBase(id)),
		SULFUR("sulfur", id -> new ItemBase(id)),
		TIN("tin", id -> new ItemBase(id)),
		COPPER("copper", id -> new ItemBase(id)),
		IRON("iron", id -> new ItemBase(id)),
		LEAD("lead", id -> new ItemBase(id)),
		ZINC("zinc", id -> new ItemBase(id)),
		ALUMINIUM("aluminium", id -> new ItemBase(id)),
		SILICON("silicon", id -> new ItemBase(id)),
		COAL("coal", id -> new ItemBase(id));

		private final String OreName;
		private final Function<String, Item> makeItem;


		ItemOre(String OreName,  Function<String, Item> makeItem) {
			this.OreName = OreName;
			this.makeItem = makeItem;


		}

		public String getOreName() {
			return OreName;
		}

		public Item makeItem(String registryName) {
			return makeItem.apply(registryName);
		}
	}

	public enum MaterialTier {

		WEAK(0.25, id -> new ItemBase(id)),
		NORMAL(1.00, id -> new ItemBase(id)),
		STRONG(4.00, id -> new ItemBase(id));

		private final double DurabilityModifier;
		private final Function<String, Item> makeItem;

		MaterialTier(double DurabilityModifier, Function<String, Item> makeItem) {
			this.DurabilityModifier = DurabilityModifier;
			this.makeItem = makeItem;
		}

		public double getDurabilityModifier() {
			return DurabilityModifier;
		}

		public Item makeItem(String registryName) {
			return makeItem.apply(registryName);
		}
	}



	//ARMOR MATERIAL (name, textureName, durability, reductionAmounts, enchantability, soundOnEquip, toughness)
	public static final ArmorMaterial ARMOR_MATERIAL_ALUMINIUM = EnumHelper.addArmorMaterial("armor_material_aluminium", Reference.MOD_ID + ":aluminium", 20,
			new int[] {1, 1, 1, 1}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_ZINC = EnumHelper.addArmorMaterial("armor_material_zinc", Reference.MOD_ID + ":zinc", 100,
			new int[] {1, 3, 2, 1}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 2.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_LEAD = EnumHelper.addArmorMaterial("armor_material_lead", Reference.MOD_ID + ":lead", 40,
			new int[] {1, 2, 2, 1}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_TIN = EnumHelper.addArmorMaterial("armor_material_tin", Reference.MOD_ID + ":tin", 50,
			new int[] {2, 4, 3, 2}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 1.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_SILICON = EnumHelper.addArmorMaterial("armor_material_silicon", Reference.MOD_ID + ":silicon", 30,
			new int[] {1, 2, 2, 1}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_COPPER = EnumHelper.addArmorMaterial("armor_material_copper", Reference.MOD_ID + ":copper", 50,
			new int[] {1, 2, 2, 1}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_IRON = EnumHelper.addArmorMaterial("armor_material_iron", Reference.MOD_ID + ":iron", 150,
			new int[] {3, 5, 4, 3}, 20, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_BRONZE = EnumHelper.addArmorMaterial("armor_material_bronze", Reference.MOD_ID + ":bronze", 180,
			new int[] {2, 4, 3, 2}, 22, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_STEEL = EnumHelper.addArmorMaterial("armor_material_steel", Reference.MOD_ID + ":steel", 300,
			new int[] {4, 6, 5, 3}, 18, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_SILVER = EnumHelper.addArmorMaterial("armor_material_silver", Reference.MOD_ID + ":silver", 180,
			new int[] {4, 7, 6, 3}, 16, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_GOLD = EnumHelper.addArmorMaterial("armor_material_gold", Reference.MOD_ID + ":gold", 180,
			new int[] {4, 7, 6, 4}, 14, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_AEROGEL_GOLD = EnumHelper.addArmorMaterial("armor_material_aerogel_gold", Reference.MOD_ID + ":aerogel_gold", 360,
			new int[] {4, 7, 6, 4}, 14, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_PLATINUM = EnumHelper.addArmorMaterial("armor_material_platinum", Reference.MOD_ID + ":platinum", 400,
			new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_TITANIUM = EnumHelper.addArmorMaterial("armor_material_titanium", Reference.MOD_ID + ":titanium", 600,
			new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_URANIUM = EnumHelper.addArmorMaterial("armor_material_uranium", Reference.MOD_ID + ":uranium", 60,
			new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_TOPAZ = EnumHelper.addArmorMaterial("armor_material_topaz", Reference.MOD_ID + ":topaz", 300,
			new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_JADE = EnumHelper.addArmorMaterial("armor_material_jade", Reference.MOD_ID + ":jade", 400,
			new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_TUNGSTEN = EnumHelper.addArmorMaterial("armor_material_tungsten", Reference.MOD_ID + ":tungsten", 1000,
			new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_TITANIUM_URANIUM = EnumHelper.addArmorMaterial("armor_material_titanium_uranium", Reference.MOD_ID + ":titanium_uranium", 660,
			new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_TUNGSTEN_URANIUM = EnumHelper.addArmorMaterial("armor_material_tungsten_uranium", Reference.MOD_ID + ":tungsten_uranium", 1060,
			new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_TUNGSTEN_TITANIUM = EnumHelper.addArmorMaterial("armor_material_tungsten_titanium", Reference.MOD_ID + ":tungsten_titanium", 1600,
			new int[] {5, 7, 6, 4}, 12, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 1.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_EMERALD = EnumHelper.addArmorMaterial("armor_material_emerald", Reference.MOD_ID + ":emerald", 36,
			new int[] {3, 5, 4, 3}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_RUBY = EnumHelper.addArmorMaterial("armor_material_ruby", Reference.MOD_ID + ":ruby", 3000,
			new int[] {7, 12, 10, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 10.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_SAPPHIRE = EnumHelper.addArmorMaterial("armor_material_sapphire", Reference.MOD_ID + ":sapphire", 3000,
			new int[] {6, 10, 9, 5}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_DIAMOND = EnumHelper.addArmorMaterial("armor_material_diamond", Reference.MOD_ID + ":diamond", 4500,
			new int[] {8, 14, 12, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 13.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_OLIVINE = EnumHelper.addArmorMaterial("armor_material_olivine", Reference.MOD_ID + ":olivine", 6000,
			new int[] {8, 14, 12, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 13.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_WADSLEYITE = EnumHelper.addArmorMaterial("armor_material_wadsleyite", Reference.MOD_ID + ":wadsleyite", 7000,
			new int[] {8, 14, 12, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 13.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_RINGWOODITE = EnumHelper.addArmorMaterial("armor_material_ringwoodite", Reference.MOD_ID + ":ringwoodite", 8000,
			new int[] {8, 14, 12, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 13.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_BRIGMANITE = EnumHelper.addArmorMaterial("armor_material_brigmanite", Reference.MOD_ID + ":brigmanite", 9000,
			new int[] {8, 14, 12, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 13.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_MAJORITE = EnumHelper.addArmorMaterial("armor_material_majorite", Reference.MOD_ID + ":majorite", 10000,
			new int[] {8, 14, 12, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 13.5F);

	public static final ArmorMaterial ARMOR_MATERIAL_AMAZONITE = EnumHelper.addArmorMaterial("armor_material_amazonite", Reference.MOD_ID + ":amazonite", 20000,
			new int[] {6, 12, 9, 6}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 6.0F);

	public static final ArmorMaterial ARMOR_MATERIAL_ONYX = EnumHelper.addArmorMaterial("armor_material_onyx", Reference.MOD_ID + ":onyx", 50000,
			new int[] {7, 14, 10, 7}, 30, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 8.0F);



//TOOLS

	//WOODEN//
	public static final ItemSword WOODEN_SWORD = new ToolSword("wooden_sword", ToolMaterialCustom.WOODEN);
	public static final ItemSpade WOODEN_SHOVEL = new ToolSpade("wooden_shovel", ToolMaterialCustom.WOODEN);
	public static final ItemPickaxe WOODEN_PICKAXE = new ToolPickaxe("wooden_pickaxe", ToolMaterialCustom.WOODEN);
	public static final ItemAxe WOODEN_AXE = new ToolAxe("wooden_axe", ToolMaterialCustom.WOODEN);
	public static final ItemHoe WOODEN_HOE = new ToolHoe("wooden_hoe", ToolMaterialCustom.WOODEN);

	//STONE//
	public static final ItemSword STONE_SWORD = new ToolSword("stone_sword", ToolMaterialCustom.STONE);
	public static final ItemSpade STONE_SHOVEL = new ToolSpade("stone_shovel", ToolMaterialCustom.STONE);
	public static final ItemPickaxe STONE_PICKAXE = new ToolPickaxe("stone_pickaxe", ToolMaterialCustom.STONE);
	public static final ItemAxe STONE_AXE = new ToolAxe("stone_axe", ToolMaterialCustom.STONE);
	public static final ItemHoe STONE_HOE = new ToolHoe("stone_hoe", ToolMaterialCustom.STONE);

	//ALUMINIUM//
	public static final ItemSword ALUMINIUM_SWORD = new ToolSword("aluminium_sword", ToolMaterialCustom.ALUMINIUM);
	public static final ItemSpade ALUMINIUM_SHOVEL = new ToolSpade("aluminium_shovel", ToolMaterialCustom.ALUMINIUM);
	public static final ItemPickaxe ALUMINIUM_PICKAXE = new ToolPickaxe("aluminium_pickaxe", ToolMaterialCustom.ALUMINIUM);
	public static final ItemAxe ALUMINIUM_AXE = new ToolAxe("aluminium_axe", ToolMaterialCustom.ALUMINIUM);
	public static final ItemHoe ALUMINIUM_HOE = new ToolHoe("aluminium_hoe", ToolMaterialCustom.ALUMINIUM);
	public static final ItemSword COMPLETE_ALUMINIUM_SWORD = new ToolSword("complete_aluminium_sword", ToolMaterialCustom.COMPLETE_ALUMINIUM);
	public static final ItemSpade COMPLETE_ALUMINIUM_SHOVEL = new ToolSpade("complete_aluminium_shovel", ToolMaterialCustom.COMPLETE_ALUMINIUM);
	public static final ItemPickaxe COMPLETE_ALUMINIUM_PICKAXE = new ToolPickaxe("complete_aluminium_pickaxe", ToolMaterialCustom.COMPLETE_ALUMINIUM);
	public static final ItemAxe COMPLETE_ALUMINIUM_AXE = new ToolAxe("complete_aluminium_axe", ToolMaterialCustom.COMPLETE_ALUMINIUM);
	public static final ItemHoe COMPLETE_ALUMINIUM_HOE = new ToolHoe("complete_aluminium_hoe", ToolMaterialCustom.COMPLETE_ALUMINIUM);

	public static final Item ALUMINIUM_HELMET = new ArmorBase("aluminium_helmet", ARMOR_MATERIAL_ALUMINIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item ALUMINIUM_CHESTPLATE = new ArmorBase("aluminium_chestplate", ARMOR_MATERIAL_ALUMINIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item ALUMINIUM_LEGGINGS = new ArmorBase("aluminium_leggings", ARMOR_MATERIAL_ALUMINIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item ALUMINIUM_BOOTS = new ArmorBase("aluminium_boots", ARMOR_MATERIAL_ALUMINIUM, 1, EntityEquipmentSlot.FEET);

	//ZINC//
	public static final ItemSword ZINC_SWORD = new ToolSword("zinc_sword", ModItems.ToolMaterialCustom.ZINC);
	public static final ItemSpade ZINC_SHOVEL = new ToolSpade("zinc_shovel", ToolMaterialCustom.ZINC);
	public static final ItemPickaxe ZINC_PICKAXE = new ToolPickaxe("zinc_pickaxe", ToolMaterialCustom.ZINC);
	public static final ItemAxe ZINC_AXE = new ToolAxe("zinc_axe", ToolMaterialCustom.ZINC);
	public static final ItemHoe ZINC_HOE = new ToolHoe("zinc_hoe", ToolMaterialCustom.ZINC);
	public static final ItemSword COMPLETE_ZINC_SWORD = new ToolSword("complete_zinc_sword", ToolMaterialCustom.COMPLETE_ZINC);
	public static final ItemSpade COMPLETE_ZINC_SHOVEL = new ToolSpade("complete_zinc_shovel", ToolMaterialCustom.COMPLETE_ZINC);
	public static final ItemPickaxe COMPLETE_ZINC_PICKAXE = new ToolPickaxe("complete_zinc_pickaxe", ToolMaterialCustom.COMPLETE_ZINC);
	public static final ItemAxe COMPLETE_ZINC_AXE = new ToolAxe("complete_zinc_axe", ToolMaterialCustom.COMPLETE_ZINC);
	public static final ItemHoe COMPLETE_ZINC_HOE = new ToolHoe("complete_zinc_hoe", ToolMaterialCustom.COMPLETE_ZINC);

	public static final Item ZINC_HELMET = new ArmorBase("zinc_helmet", ARMOR_MATERIAL_ZINC, 1, EntityEquipmentSlot.HEAD);
	public static final Item ZINC_CHESTPLATE = new ArmorBase("zinc_chestplate", ARMOR_MATERIAL_ZINC, 1, EntityEquipmentSlot.CHEST);
	public static final Item ZINC_LEGGINGS = new ArmorBase("zinc_leggings", ARMOR_MATERIAL_ZINC, 2, EntityEquipmentSlot.LEGS);
	public static final Item ZINC_BOOTS = new ArmorBase("zinc_boots", ARMOR_MATERIAL_ZINC, 1, EntityEquipmentSlot.FEET);

	//LEAD//
	public static final ItemSword LEAD_SWORD = new ToolSword("lead_sword", ToolMaterialCustom.LEAD);
	public static final ItemSpade LEAD_SHOVEL = new ToolSpade("lead_shovel", ToolMaterialCustom.LEAD);
	public static final ItemPickaxe LEAD_PICKAXE = new ToolPickaxe("lead_pickaxe", ToolMaterialCustom.LEAD);
	public static final ItemAxe LEAD_AXE = new ToolAxe("lead_axe", ToolMaterialCustom.LEAD);
	public static final ItemHoe LEAD_HOE = new ToolHoe("lead_hoe", ToolMaterialCustom.LEAD);
	public static final ItemSword COMPLETE_LEAD_SWORD = new ToolSword("complete_lead_sword", ToolMaterialCustom.COMPLETE_LEAD);
	public static final ItemSpade COMPLETE_LEAD_SHOVEL = new ToolSpade("complete_lead_shovel", ToolMaterialCustom.COMPLETE_LEAD);
	public static final ItemPickaxe COMPLETE_LEAD_PICKAXE = new ToolPickaxe("complete_lead_pickaxe", ToolMaterialCustom.COMPLETE_LEAD);
	public static final ItemAxe COMPLETE_LEAD_AXE = new ToolAxe("complete_lead_axe", ToolMaterialCustom.COMPLETE_LEAD);
	public static final ItemHoe COMPLETE_LEAD_HOE = new ToolHoe("complete_lead_hoe", ToolMaterialCustom.COMPLETE_LEAD);

	public static final Item LEAD_HELMET = new ArmorBase("lead_helmet", ARMOR_MATERIAL_LEAD, 1, EntityEquipmentSlot.HEAD);
	public static final Item LEAD_CHESTPLATE = new ArmorBase("lead_chestplate", ARMOR_MATERIAL_LEAD, 1, EntityEquipmentSlot.CHEST);
	public static final Item LEAD_LEGGINGS = new ArmorBase("lead_leggings", ARMOR_MATERIAL_LEAD, 2, EntityEquipmentSlot.LEGS);
	public static final Item LEAD_BOOTS = new ArmorBase("lead_boots", ARMOR_MATERIAL_LEAD, 1, EntityEquipmentSlot.FEET);

	//TIN//
	public static final ItemSword TIN_SWORD = new ToolSword("tin_sword", ToolMaterialCustom.TIN);
	public static final ItemSpade TIN_SHOVEL = new ToolSpade("tin_shovel", ToolMaterialCustom.TIN);
	public static final ItemPickaxe TIN_PICKAXE = new ToolPickaxe("tin_pickaxe", ToolMaterialCustom.TIN);
	public static final ItemAxe TIN_AXE = new ToolAxe("tin_axe", ToolMaterialCustom.TIN);
	public static final ItemHoe TIN_HOE = new ToolHoe("tin_hoe", ToolMaterialCustom.TIN);
	public static final ItemSword COMPLETE_TIN_SWORD = new ToolSword("complete_tin_sword", ToolMaterialCustom.COMPLETE_TIN);
	public static final ItemSpade COMPLETE_TIN_SHOVEL = new ToolSpade("complete_tin_shovel", ToolMaterialCustom.COMPLETE_TIN);
	public static final ItemPickaxe COMPLETE_TIN_PICKAXE = new ToolPickaxe("complete_tin_pickaxe", ToolMaterialCustom.COMPLETE_TIN);
	public static final ItemAxe COMPLETE_TIN_AXE = new ToolAxe("complete_tin_axe", ToolMaterialCustom.COMPLETE_TIN);
	public static final ItemHoe COMPLETE_TIN_HOE = new ToolHoe("complete_tin_hoe", ToolMaterialCustom.COMPLETE_TIN);

	public static final Item TIN_HELMET = new ArmorBase("tin_helmet", ARMOR_MATERIAL_TIN, 1, EntityEquipmentSlot.HEAD);
	public static final Item TIN_CHESTPLATE = new ArmorBase("tin_chestplate", ARMOR_MATERIAL_TIN, 1, EntityEquipmentSlot.CHEST);
	public static final Item TIN_LEGGINGS = new ArmorBase("tin_leggings", ARMOR_MATERIAL_TIN, 2, EntityEquipmentSlot.LEGS);
	public static final Item TIN_BOOTS = new ArmorBase("tin_boots", ARMOR_MATERIAL_TIN, 1, EntityEquipmentSlot.FEET);

	//SILICON//
	public static final ItemSword SILICON_SWORD = new ToolSword("silicon_sword", ToolMaterialCustom.SILICON);
	public static final ItemSpade SILICON_SHOVEL = new ToolSpade("silicon_shovel", ToolMaterialCustom.SILICON);
	public static final ItemPickaxe SILICON_PICKAXE = new ToolPickaxe("silicon_pickaxe", ToolMaterialCustom.SILICON);
	public static final ItemAxe SILICON_AXE = new ToolAxe("silicon_axe", ToolMaterialCustom.SILICON);
	public static final ItemHoe SILICON_HOE = new ToolHoe("silicon_hoe", ToolMaterialCustom.SILICON);
	public static final ItemSword COMPLETE_SILICON_SWORD = new ToolSword("complete_silicon_sword", ToolMaterialCustom.COMPLETE_SILICON);
	public static final ItemSpade COMPLETE_SILICON_SHOVEL = new ToolSpade("complete_silicon_shovel", ToolMaterialCustom.COMPLETE_SILICON);
	public static final ItemPickaxe COMPLETE_SILICON_PICKAXE = new ToolPickaxe("complete_silicon_pickaxe", ToolMaterialCustom.COMPLETE_SILICON);
	public static final ItemAxe COMPLETE_SILICON_AXE = new ToolAxe("complete_silicon_axe", ToolMaterialCustom.COMPLETE_SILICON);
	public static final ItemHoe COMPLETE_SILICON_HOE = new ToolHoe("complete_silicon_hoe", ToolMaterialCustom.COMPLETE_SILICON);

	public static final Item SILICON_HELMET = new ArmorBase("silicon_helmet", ARMOR_MATERIAL_SILICON, 1, EntityEquipmentSlot.HEAD);
	public static final Item SILICON_CHESTPLATE = new ArmorBase("silicon_chestplate", ARMOR_MATERIAL_SILICON, 1, EntityEquipmentSlot.CHEST);
	public static final Item SILICON_LEGGINGS = new ArmorBase("silicon_leggings", ARMOR_MATERIAL_SILICON, 2, EntityEquipmentSlot.LEGS);
	public static final Item SILICON_BOOTS = new ArmorBase("silicon_boots", ARMOR_MATERIAL_SILICON, 1, EntityEquipmentSlot.FEET);

	//COPPER//
	public static final ItemSword COPPER_SWORD = new ToolSword("copper_sword", ToolMaterialCustom.COPPER);
	public static final ItemSpade COPPER_SHOVEL = new ToolSpade("copper_shovel", ToolMaterialCustom.COPPER);
	public static final ItemPickaxe COPPER_PICKAXE = new ToolPickaxe("copper_pickaxe", ToolMaterialCustom.COPPER);
	public static final ItemAxe COPPER_AXE = new ToolAxe("copper_axe", ToolMaterialCustom.COPPER);
	public static final ItemHoe COPPER_HOE = new ToolHoe("copper_hoe", ToolMaterialCustom.COPPER);
	public static final ItemSword COMPLETE_COPPER_SWORD = new ToolSword("complete_copper_sword", ToolMaterialCustom.COMPLETE_COPPER);
	public static final ItemSpade COMPLETE_COPPER_SHOVEL = new ToolSpade("complete_copper_shovel", ToolMaterialCustom.COMPLETE_COPPER);
	public static final ItemPickaxe COMPLETE_COPPER_PICKAXE = new ToolPickaxe("complete_copper_pickaxe", ToolMaterialCustom.COMPLETE_COPPER);
	public static final ItemAxe COMPLETE_COPPER_AXE = new ToolAxe("complete_copper_axe", ToolMaterialCustom.COMPLETE_COPPER);
	public static final ItemHoe COMPLETE_COPPER_HOE = new ToolHoe("complete_copper_hoe", ToolMaterialCustom.COMPLETE_COPPER);

	public static final Item COPPER_HELMET = new ArmorBase("copper_helmet", ARMOR_MATERIAL_COPPER, 1, EntityEquipmentSlot.HEAD);
	public static final Item COPPER_CHESTPLATE = new ArmorBase("copper_chestplate", ARMOR_MATERIAL_COPPER, 1, EntityEquipmentSlot.CHEST);
	public static final Item COPPER_LEGGINGS = new ArmorBase("copper_leggings", ARMOR_MATERIAL_COPPER, 2, EntityEquipmentSlot.LEGS);
	public static final Item COPPER_BOOTS = new ArmorBase("copper_boots", ARMOR_MATERIAL_COPPER, 1, EntityEquipmentSlot.FEET);

	//IRON//
	public static final ItemSword IRON_SWORD = new ToolSword("iron_sword", ToolMaterialCustom.IRON);
	public static final ItemSpade IRON_SHOVEL = new ToolSpade("iron_shovel", ToolMaterialCustom.IRON);
	public static final ItemPickaxe IRON_PICKAXE = new ToolPickaxe("iron_pickaxe", ToolMaterialCustom.IRON);
	public static final ItemAxe IRON_AXE = new ToolAxe("iron_axe", ToolMaterialCustom.IRON);
	public static final ItemHoe IRON_HOE = new ToolHoe("iron_hoe", ToolMaterialCustom.IRON);
	public static final ItemSword COMPLETE_IRON_SWORD = new ToolSword("complete_iron_sword", ToolMaterialCustom.COMPLETE_IRON);
	public static final ItemSpade COMPLETE_IRON_SHOVEL = new ToolSpade("complete_iron_shovel", ToolMaterialCustom.COMPLETE_IRON);
	public static final ItemPickaxe COMPLETE_IRON_PICKAXE = new ToolPickaxe("complete_iron_pickaxe", ToolMaterialCustom.COMPLETE_IRON);
	public static final ItemAxe COMPLETE_IRON_AXE = new ToolAxe("complete_iron_axe", ToolMaterialCustom.COMPLETE_IRON);
	public static final ItemHoe COMPLETE_IRON_HOE = new ToolHoe("complete_iron_hoe", ToolMaterialCustom.COMPLETE_IRON);

	public static final Item IRON_HELMET = new ArmorBase("iron_helmet", ARMOR_MATERIAL_IRON, 1, EntityEquipmentSlot.HEAD);
	public static final Item IRON_CHESTPLATE = new ArmorBase("iron_chestplate", ARMOR_MATERIAL_IRON, 1, EntityEquipmentSlot.CHEST);
	public static final Item IRON_LEGGINGS = new ArmorBase("iron_leggings", ARMOR_MATERIAL_IRON, 2, EntityEquipmentSlot.LEGS);
	public static final Item IRON_BOOTS = new ArmorBase("iron_boots", ARMOR_MATERIAL_IRON, 1, EntityEquipmentSlot.FEET);

	//STEEL//
	public static final ItemSword STEEL_SWORD = new ToolSword("steel_sword", ToolMaterialCustom.STEEL);
	public static final ItemSpade STEEL_SHOVEL = new ToolSpade("steel_shovel", ToolMaterialCustom.STEEL);
	public static final ItemPickaxe STEEL_PICKAXE = new ToolPickaxe("steel_pickaxe", ToolMaterialCustom.STEEL);
	public static final ItemAxe STEEL_AXE = new ToolAxe("steel_axe", ToolMaterialCustom.STEEL);
	public static final ItemHoe STEEL_HOE = new ToolHoe("steel_hoe", ToolMaterialCustom.STEEL);
	public static final ItemSword COMPLETE_STEEL_SWORD = new ToolSword("complete_steel_sword", ToolMaterialCustom.COMPLETE_STEEL);
	public static final ItemSpade COMPLETE_STEEL_SHOVEL = new ToolSpade("complete_steel_shovel", ToolMaterialCustom.COMPLETE_STEEL);
	public static final ItemPickaxe COMPLETE_STEEL_PICKAXE = new ToolPickaxe("complete_steel_pickaxe", ToolMaterialCustom.COMPLETE_STEEL);
	public static final ItemAxe COMPLETE_STEEL_AXE = new ToolAxe("complete_steel_axe", ToolMaterialCustom.COMPLETE_STEEL);
	public static final ItemHoe COMPLETE_STEEL_HOE = new ToolHoe("complete_steel_hoe", ToolMaterialCustom.COMPLETE_STEEL);

	public static final Item STEEL_HELMET = new ArmorBase("steel_helmet", ARMOR_MATERIAL_STEEL, 1, EntityEquipmentSlot.HEAD);
	public static final Item STEEL_CHESTPLATE = new ArmorBase("steel_chestplate", ARMOR_MATERIAL_STEEL, 1, EntityEquipmentSlot.CHEST);
	public static final Item STEEL_LEGGINGS = new ArmorBase("steel_leggings", ARMOR_MATERIAL_STEEL, 2, EntityEquipmentSlot.LEGS);
	public static final Item STEEL_BOOTS = new ArmorBase("steel_boots", ARMOR_MATERIAL_STEEL, 1, EntityEquipmentSlot.FEET);

	//BRONZE//
	public static final ItemSword BRONZE_SWORD = new ToolSword("bronze_sword", ToolMaterialCustom.BRONZE);
	public static final ItemSpade BRONZE_SHOVEL = new ToolSpade("bronze_shovel", ToolMaterialCustom.BRONZE);
	public static final ItemPickaxe BRONZE_PICKAXE = new ToolPickaxe("bronze_pickaxe", ToolMaterialCustom.BRONZE);
	public static final ItemAxe BRONZE_AXE = new ToolAxe("bronze_axe", ToolMaterialCustom.BRONZE);
	public static final ItemHoe BRONZE_HOE = new ToolHoe("bronze_hoe", ToolMaterialCustom.BRONZE);
	public static final ItemSword COMPLETE_BRONZE_SWORD = new ToolSword("complete_bronze_sword", ToolMaterialCustom.COMPLETE_BRONZE);
	public static final ItemSpade COMPLETE_BRONZE_SHOVEL = new ToolSpade("complete_bronze_shovel", ToolMaterialCustom.COMPLETE_BRONZE);
	public static final ItemPickaxe COMPLETE_BRONZE_PICKAXE = new ToolPickaxe("complete_bronze_pickaxe", ToolMaterialCustom.COMPLETE_BRONZE);
	public static final ItemAxe COMPLETE_BRONZE_AXE = new ToolAxe("complete_bronze_axe", ToolMaterialCustom.COMPLETE_BRONZE);
	public static final ItemHoe COMPLETE_BRONZE_HOE = new ToolHoe("complete_bronze_hoe", ToolMaterialCustom.COMPLETE_BRONZE);

	public static final Item BRONZE_HELMET = new ArmorBase("bronze_helmet", ARMOR_MATERIAL_BRONZE, 1, EntityEquipmentSlot.HEAD);
	public static final Item BRONZE_CHESTPLATE = new ArmorBase("bronze_chestplate", ARMOR_MATERIAL_BRONZE, 1, EntityEquipmentSlot.CHEST);
	public static final Item BRONZE_LEGGINGS = new ArmorBase("bronze_leggings", ARMOR_MATERIAL_BRONZE, 2, EntityEquipmentSlot.LEGS);
	public static final Item BRONZE_BOOTS = new ArmorBase("bronze_boots", ARMOR_MATERIAL_BRONZE, 1, EntityEquipmentSlot.FEET);

	//SILVER//
	public static final ItemSword SILVER_SWORD = new ToolSword("silver_sword", ToolMaterialCustom.SILVER);
	public static final ItemSpade SILVER_SHOVEL = new ToolSpade("silver_shovel", ToolMaterialCustom.SILVER);
	public static final ItemPickaxe SILVER_PICKAXE = new ToolPickaxe("silver_pickaxe", ToolMaterialCustom.SILVER);
	public static final ItemAxe SILVER_AXE = new ToolAxe("silver_axe", ToolMaterialCustom.SILVER);
	public static final ItemHoe SILVER_HOE = new ToolHoe("silver_hoe", ToolMaterialCustom.SILVER);
	public static final ItemSword COMPLETE_SILVER_SWORD = new ToolSword("complete_silver_sword", ToolMaterialCustom.COMPLETE_SILVER);
	public static final ItemSpade COMPLETE_SILVER_SHOVEL = new ToolSpade("complete_silver_shovel", ToolMaterialCustom.COMPLETE_SILVER);
	public static final ItemPickaxe COMPLETE_SILVER_PICKAXE = new ToolPickaxe("complete_silver_pickaxe", ToolMaterialCustom.COMPLETE_SILVER);
	public static final ItemAxe COMPLETE_SILVER_AXE = new ToolAxe("complete_silver_axe", ToolMaterialCustom.COMPLETE_SILVER);
	public static final ItemHoe COMPLETE_SILVER_HOE = new ToolHoe("complete_silver_hoe", ToolMaterialCustom.COMPLETE_SILVER);

	public static final Item SILVER_HELMET = new SilverHelmet("silver_helmet", ARMOR_MATERIAL_SILVER, 1, EntityEquipmentSlot.HEAD);
	public static final Item SILVER_CHESTPLATE = new SilverBody("silver_chestplate", ARMOR_MATERIAL_SILVER, 1, EntityEquipmentSlot.CHEST);
	public static final Item SILVER_LEGGINGS = new SilverLegs("silver_leggings", ARMOR_MATERIAL_SILVER, 2, EntityEquipmentSlot.LEGS);
	public static final Item SILVER_BOOTS = new SilverBoots("silver_boots", ARMOR_MATERIAL_SILVER, 1, EntityEquipmentSlot.FEET);

	//GOLD//
	public static final ItemSword GOLD_SWORD = new ToolSword("gold_sword", ToolMaterialCustom.GOLD);
	public static final ItemSpade GOLD_SHOVEL = new ToolSpade("gold_shovel", ToolMaterialCustom.GOLD);
	public static final ItemPickaxe GOLD_PICKAXE = new ToolPickaxe("gold_pickaxe", ToolMaterialCustom.GOLD);
	public static final ItemAxe GOLD_AXE = new ToolAxe("gold_axe", ToolMaterialCustom.GOLD);
	public static final ItemHoe GOLD_HOE = new ToolHoe("gold_hoe", ToolMaterialCustom.GOLD);
	public static final ItemSword COMPLETE_GOLD_SWORD = new ToolSword("complete_gold_sword", ToolMaterialCustom.COMPLETE_GOLD);
	public static final ItemSpade COMPLETE_GOLD_SHOVEL = new ToolSpade("complete_gold_shovel", ToolMaterialCustom.COMPLETE_GOLD);
	public static final ItemPickaxe COMPLETE_GOLD_PICKAXE = new ToolPickaxe("complete_gold_pickaxe", ToolMaterialCustom.COMPLETE_GOLD);
	public static final ItemAxe COMPLETE_GOLD_AXE = new ToolAxe("complete_gold_axe", ToolMaterialCustom.COMPLETE_GOLD);
	public static final ItemHoe COMPLETE_GOLD_HOE = new ToolHoe("complete_gold_hoe", ToolMaterialCustom.COMPLETE_GOLD);

	public static final Item GOLD_HELMET = new GoldHelmet("gold_helmet", ARMOR_MATERIAL_GOLD, 1, EntityEquipmentSlot.HEAD);
	public static final Item GOLD_CHESTPLATE = new GoldBody("gold_chestplate", ARMOR_MATERIAL_GOLD, 1, EntityEquipmentSlot.CHEST);
	public static final Item GOLD_LEGGINGS = new GoldLegs("gold_leggings", ARMOR_MATERIAL_GOLD, 2, EntityEquipmentSlot.LEGS);
	public static final Item GOLD_BOOTS = new GoldBoots("gold_boots", ARMOR_MATERIAL_GOLD, 1, EntityEquipmentSlot.FEET);

	public static final Item AEROGEL_GOLD_HELMET = new GoldHelmet("aerogel_gold_helmet", ARMOR_MATERIAL_AEROGEL_GOLD, 1, EntityEquipmentSlot.HEAD);
	public static final Item AEROGEL_GOLD_CHESTPLATE = new GoldBody("aerogel_gold_chestplate", ARMOR_MATERIAL_AEROGEL_GOLD, 1, EntityEquipmentSlot.CHEST);
	public static final Item AEROGEL_GOLD_LEGGINGS = new GoldLegs("aerogel_gold_leggings", ARMOR_MATERIAL_AEROGEL_GOLD, 2, EntityEquipmentSlot.LEGS);
	public static final Item AEROGEL_GOLD_BOOTS = new GoldBoots("aerogel_gold_boots", ARMOR_MATERIAL_AEROGEL_GOLD, 1, EntityEquipmentSlot.FEET);

	//PLATINUM//
	public static final ItemSword PLATINUM_SWORD = new ToolSword("platinum_sword", ToolMaterialCustom.PLATINUM);
	public static final ItemSpade PLATINUM_SHOVEL = new ToolSpade("platinum_shovel", ToolMaterialCustom.PLATINUM);
	public static final ItemPickaxe PLATINUM_PICKAXE = new ToolPickaxe("platinum_pickaxe", ToolMaterialCustom.PLATINUM);
	public static final ItemAxe PLATINUM_AXE = new ToolAxe("platinum_axe", ToolMaterialCustom.PLATINUM);
	public static final ItemHoe PLATINUM_HOE = new ToolHoe("platinum_hoe", ToolMaterialCustom.PLATINUM);
	public static final ItemSword COMPLETE_PLATINUM_SWORD = new ToolSword("complete_platinum_sword", ToolMaterialCustom.COMPLETE_PLATINUM);
	public static final ItemSpade COMPLETE_PLATINUM_SHOVEL = new ToolSpade("complete_platinum_shovel", ToolMaterialCustom.COMPLETE_PLATINUM);
	public static final ItemPickaxe COMPLETE_PLATINUM_PICKAXE = new ToolPickaxe("complete_platinum_pickaxe", ToolMaterialCustom.COMPLETE_PLATINUM);
	public static final ItemAxe COMPLETE_PLATINUM_AXE = new ToolAxe("complete_platinum_axe", ToolMaterialCustom.COMPLETE_PLATINUM);
	public static final ItemHoe COMPLETE_PLATINUM_HOE = new ToolHoe("complete_platinum_hoe", ToolMaterialCustom.COMPLETE_PLATINUM);

	public static final Item PLATINUM_HELMET = new PlatinumHelmet("platinum_helmet", ARMOR_MATERIAL_PLATINUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item PLATINUM_CHESTPLATE = new PlatinumBody("platinum_chestplate", ARMOR_MATERIAL_PLATINUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item PLATINUM_LEGGINGS = new PlatinumLegs("platinum_leggings", ARMOR_MATERIAL_PLATINUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item PLATINUM_BOOTS = new PlatinumBoots("platinum_boots", ARMOR_MATERIAL_PLATINUM, 1, EntityEquipmentSlot.FEET);

	//TITANIUM//
	public static final ItemSword TITANIUM_SWORD = new ToolSword("titanium_sword", ToolMaterialCustom.TITANIUM);
	public static final ItemSpade TITANIUM_SHOVEL = new ToolSpade("titanium_shovel", ToolMaterialCustom.TITANIUM);
	public static final ItemPickaxe TITANIUM_PICKAXE = new ToolPickaxe("titanium_pickaxe", ToolMaterialCustom.TITANIUM);
	public static final ItemAxe TITANIUM_AXE = new ToolAxe("titanium_axe", ToolMaterialCustom.TITANIUM);
	public static final ItemHoe TITANIUM_HOE = new ToolHoe("titanium_hoe", ToolMaterialCustom.TITANIUM);
	public static final ItemSword COMPLETE_TITANIUM_SWORD = new ToolSword("complete_titanium_sword", ToolMaterialCustom.COMPLETE_TITANIUM);
	public static final ItemSpade COMPLETE_TITANIUM_SHOVEL = new ToolSpade("complete_titanium_shovel", ToolMaterialCustom.COMPLETE_TITANIUM);
	public static final ItemPickaxe COMPLETE_TITANIUM_PICKAXE = new ToolPickaxe("complete_titanium_pickaxe", ToolMaterialCustom.COMPLETE_TITANIUM);
	public static final ItemAxe COMPLETE_TITANIUM_AXE = new ToolAxe("complete_titanium_axe", ToolMaterialCustom.COMPLETE_TITANIUM);
	public static final ItemHoe COMPLETE_TITANIUM_HOE = new ToolHoe("complete_titanium_hoe", ToolMaterialCustom.COMPLETE_TITANIUM);

	public static final Item TITANIUM_HELMET = new ArmorBase("titanium_helmet", ARMOR_MATERIAL_TITANIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item TITANIUM_CHESTPLATE = new ArmorBase("titanium_chestplate", ARMOR_MATERIAL_TITANIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item TITANIUM_LEGGINGS = new ArmorBase("titanium_leggings", ARMOR_MATERIAL_TITANIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item TITANIUM_BOOTS = new ArmorBase("titanium_boots", ARMOR_MATERIAL_TITANIUM, 1, EntityEquipmentSlot.FEET);

	//URANIUM//
	public static final ItemSword URANIUM_SWORD = new ToolSword("uranium_sword", ToolMaterialCustom.URANIUM);
	public static final ItemSpade URANIUM_SHOVEL = new ToolSpade("uranium_shovel", ToolMaterialCustom.URANIUM);
	public static final ItemPickaxe URANIUM_PICKAXE = new ToolPickaxe("uranium_pickaxe", ToolMaterialCustom.URANIUM);
	public static final ItemAxe URANIUM_AXE = new ToolAxe("uranium_axe", ToolMaterialCustom.URANIUM);
	public static final ItemHoe URANIUM_HOE = new ToolHoe("uranium_hoe", ToolMaterialCustom.URANIUM);
	public static final ItemSword COMPLETE_URANIUM_SWORD = new ToolSword("complete_uranium_sword", ToolMaterialCustom.COMPLETE_URANIUM);
	public static final ItemSpade COMPLETE_URANIUM_SHOVEL = new ToolSpade("complete_uranium_shovel", ToolMaterialCustom.COMPLETE_URANIUM);
	public static final ItemPickaxe COMPLETE_URANIUM_PICKAXE = new ToolPickaxe("complete_uranium_pickaxe", ToolMaterialCustom.COMPLETE_URANIUM);
	public static final ItemAxe COMPLETE_URANIUM_AXE = new ToolAxe("complete_uranium_axe", ToolMaterialCustom.COMPLETE_URANIUM);
	public static final ItemHoe COMPLETE_URANIUM_HOE = new ToolHoe("complete_uranium_hoe", ToolMaterialCustom.COMPLETE_URANIUM);

	public static final Item URANIUM_HELMET = new ArmorBase("uranium_helmet", ARMOR_MATERIAL_URANIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item URANIUM_CHESTPLATE = new ArmorBase("uranium_chestplate", ARMOR_MATERIAL_URANIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item URANIUM_LEGGINGS = new ArmorBase("uranium_leggings", ARMOR_MATERIAL_URANIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item URANIUM_BOOTS = new ArmorBase("uranium_boots", ARMOR_MATERIAL_URANIUM, 1, EntityEquipmentSlot.FEET);

	//TOPAZ//
	public static final ItemSword TOPAZ_SWORD = new ToolSword("topaz_sword", ToolMaterialCustom.TOPAZ);
	public static final ItemSpade TOPAZ_SHOVEL = new ToolSpade("topaz_shovel", ToolMaterialCustom.TOPAZ);
	public static final ItemPickaxe TOPAZ_PICKAXE = new ToolPickaxe("topaz_pickaxe", ToolMaterialCustom.TOPAZ);
	public static final ItemAxe TOPAZ_AXE = new ToolAxe("topaz_axe", ToolMaterialCustom.TOPAZ);
	public static final ItemHoe TOPAZ_HOE = new ToolHoe("topaz_hoe", ToolMaterialCustom.TOPAZ);

	public static final Item TOPAZ_HELMET = new ArmorBase("topaz_helmet", ARMOR_MATERIAL_TOPAZ, 1, EntityEquipmentSlot.HEAD);
	public static final Item TOPAZ_CHESTPLATE = new ArmorBase("topaz_chestplate", ARMOR_MATERIAL_TOPAZ, 1, EntityEquipmentSlot.CHEST);
	public static final Item TOPAZ_LEGGINGS = new ArmorBase("topaz_leggings", ARMOR_MATERIAL_TOPAZ, 2, EntityEquipmentSlot.LEGS);
	public static final Item TOPAZ_BOOTS = new ArmorBase("topaz_boots", ARMOR_MATERIAL_TOPAZ, 1, EntityEquipmentSlot.FEET);

	//JADE//
	public static final ItemSword JADE_SWORD = new ToolSword("jade_sword", ToolMaterialCustom.JADE);
	public static final ItemSpade JADE_SHOVEL = new ToolSpade("jade_shovel", ToolMaterialCustom.JADE);
	public static final ItemPickaxe JADE_PICKAXE = new ToolPickaxe("jade_pickaxe", ToolMaterialCustom.JADE);
	public static final ItemAxe JADE_AXE = new ToolAxe("jade_axe", ToolMaterialCustom.JADE);
	public static final ItemHoe JADE_HOE = new ToolHoe("jade_hoe", ToolMaterialCustom.JADE);

	public static final Item JADE_HELMET = new ArmorBase("jade_helmet", ARMOR_MATERIAL_JADE, 1, EntityEquipmentSlot.HEAD);
	public static final Item JADE_CHESTPLATE = new ArmorBase("jade_chestplate", ARMOR_MATERIAL_JADE, 1, EntityEquipmentSlot.CHEST);
	public static final Item JADE_LEGGINGS = new ArmorBase("jade_leggings", ARMOR_MATERIAL_JADE, 2, EntityEquipmentSlot.LEGS);
	public static final Item JADE_BOOTS = new ArmorBase("jade_boots", ARMOR_MATERIAL_JADE, 1, EntityEquipmentSlot.FEET);

	//TUNGSTEN//
	public static final ItemSword TUNGSTEN_SWORD = new ToolSword("tungsten_sword", ToolMaterialCustom.TUNGSTEN);
	public static final ItemSpade TUNGSTEN_SHOVEL = new ToolSpade("tungsten_shovel", ToolMaterialCustom.TUNGSTEN);
	public static final ItemPickaxe TUNGSTEN_PICKAXE = new ToolPickaxe("tungsten_pickaxe", ToolMaterialCustom.TUNGSTEN);
	public static final ItemAxe TUNGSTEN_AXE = new ToolAxe("tungsten_axe", ToolMaterialCustom.TUNGSTEN);
	public static final ItemHoe TUNGSTEN_HOE = new ToolHoe("tungsten_hoe", ToolMaterialCustom.TUNGSTEN);
	public static final ItemSword COMPLETE_TUNGSTEN_SWORD = new ToolSword("complete_tungsten_sword", ToolMaterialCustom.COMPLETE_TUNGSTEN);
	public static final ItemSpade COMPLETE_TUNGSTEN_SHOVEL = new ToolSpade("complete_tungsten_shovel", ToolMaterialCustom.COMPLETE_TUNGSTEN);
	public static final ItemPickaxe COMPLETE_TUNGSTEN_PICKAXE = new ToolPickaxe("complete_tungsten_pickaxe", ToolMaterialCustom.COMPLETE_TUNGSTEN);
	public static final ItemAxe COMPLETE_TUNGSTEN_AXE = new ToolAxe("complete_tungsten_axe", ToolMaterialCustom.COMPLETE_TUNGSTEN);
	public static final ItemHoe COMPLETE_TUNGSTEN_HOE = new ToolHoe("complete_tungsten_hoe", ToolMaterialCustom.COMPLETE_TUNGSTEN);

	public static final Item TUNGSTEN_HELMET = new ArmorBase("tungsten_helmet", ARMOR_MATERIAL_TUNGSTEN, 1, EntityEquipmentSlot.HEAD);
	public static final Item TUNGSTEN_CHESTPLATE = new ArmorBase("tungsten_chestplate", ARMOR_MATERIAL_TUNGSTEN, 1, EntityEquipmentSlot.CHEST);
	public static final Item TUNGSTEN_LEGGINGS = new ArmorBase("tungsten_leggings", ARMOR_MATERIAL_TUNGSTEN, 2, EntityEquipmentSlot.LEGS);
	public static final Item TUNGSTEN_BOOTS = new ArmorBase("tungsten_boots", ARMOR_MATERIAL_TUNGSTEN, 1, EntityEquipmentSlot.FEET);

	//TITANIUM_URANIUM//
	public static final ItemSword TITANIUM_URANIUM_SWORD = new ToolSword("titanium_uranium_sword", ToolMaterialCustom.TITANIUM_URANIUM);
	public static final ItemSpade TITANIUM_URANIUM_SHOVEL = new ToolSpade("titanium_uranium_shovel", ToolMaterialCustom.TITANIUM_URANIUM);
	public static final ItemPickaxe TITANIUM_URANIUM_PICKAXE = new ToolPickaxe("titanium_uranium_pickaxe", ToolMaterialCustom.TITANIUM_URANIUM);
	public static final ItemAxe TITANIUM_URANIUM_AXE = new ToolAxe("titanium_uranium_axe", ToolMaterialCustom.TITANIUM_URANIUM);
	public static final ItemHoe TITANIUM_URANIUM_HOE = new ToolHoe("titanium_uranium_hoe", ToolMaterialCustom.TITANIUM_URANIUM);
	public static final ItemSword COMPLETE_TITANIUM_URANIUM_SWORD = new ToolSword("complete_titanium_uranium_sword", ToolMaterialCustom.COMPLETE_TITANIUM_URANIUM);
	public static final ItemSpade COMPLETE_TITANIUM_URANIUM_SHOVEL = new ToolSpade("complete_titanium_uranium_shovel", ToolMaterialCustom.COMPLETE_TITANIUM_URANIUM);
	public static final ItemPickaxe COMPLETE_TITANIUM_URANIUM_PICKAXE = new ToolPickaxe("complete_titanium_uranium_pickaxe", ToolMaterialCustom.COMPLETE_TITANIUM_URANIUM);
	public static final ItemAxe COMPLETE_TITANIUM_URANIUM_AXE = new ToolAxe("complete_titanium_uranium_axe", ToolMaterialCustom.COMPLETE_TITANIUM_URANIUM);
	public static final ItemHoe COMPLETE_TITANIUM_URANIUM_HOE = new ToolHoe("complete_titanium_uranium_hoe", ToolMaterialCustom.COMPLETE_TITANIUM_URANIUM);

	public static final Item TITANIUM_URANIUM_HELMET = new ArmorBase("titanium_uranium_helmet", ARMOR_MATERIAL_TITANIUM_URANIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item TITANIUM_URANIUM_CHESTPLATE = new ArmorBase("titanium_uranium_chestplate", ARMOR_MATERIAL_TITANIUM_URANIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item TITANIUM_URANIUM_LEGGINGS = new ArmorBase("titanium_uranium_leggings", ARMOR_MATERIAL_TITANIUM_URANIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item TITANIUM_URANIUM_BOOTS = new ArmorBase("titanium_uranium_boots", ARMOR_MATERIAL_TITANIUM_URANIUM, 1, EntityEquipmentSlot.FEET);

	//TUNGSTEN_URANIUM//
	public static final ItemSword TUNGSTEN_URANIUM_SWORD = new ToolSword("tungsten_uranium_sword", ToolMaterialCustom.TUNGSTEN_URANIUM);
	public static final ItemSpade TUNGSTEN_URANIUM_SHOVEL = new ToolSpade("tungsten_uranium_shovel", ToolMaterialCustom.TUNGSTEN_URANIUM);
	public static final ItemPickaxe TUNGSTEN_URANIUM_PICKAXE = new ToolPickaxe("tungsten_uranium_pickaxe", ToolMaterialCustom.TUNGSTEN_URANIUM);
	public static final ItemAxe TUNGSTEN_URANIUM_AXE = new ToolAxe("tungsten_uranium_axe", ToolMaterialCustom.TUNGSTEN_URANIUM);
	public static final ItemHoe TUNGSTEN_URANIUM_HOE = new ToolHoe("tungsten_uranium_hoe", ToolMaterialCustom.TUNGSTEN_URANIUM);
	public static final ItemSword COMPLETE_TUNGSTEN_URANIUM_SWORD = new ToolSword("complete_tungsten_uranium_sword", ToolMaterialCustom.COMPLETE_TUNGSTEN_URANIUM);
	public static final ItemSpade COMPLETE_TUNGSTEN_URANIUM_SHOVEL = new ToolSpade("complete_tungsten_uranium_shovel", ToolMaterialCustom.COMPLETE_TUNGSTEN_URANIUM);
	public static final ItemPickaxe COMPLETE_TUNGSTEN_URANIUM_PICKAXE = new ToolPickaxe("complete_tungsten_uranium_pickaxe", ToolMaterialCustom.COMPLETE_TUNGSTEN_URANIUM);
	public static final ItemAxe COMPLETE_TUNGSTEN_URANIUM_AXE = new ToolAxe("complete_tungsten_uranium_axe", ToolMaterialCustom.COMPLETE_TUNGSTEN_URANIUM);
	public static final ItemHoe COMPLETE_TUNGSTEN_URANIUM_HOE = new ToolHoe("complete_tungsten_uranium_hoe", ToolMaterialCustom.COMPLETE_TUNGSTEN_URANIUM);

	public static final Item TUNGSTEN_URANIUM_HELMET = new ArmorBase("tungsten_uranium_helmet", ARMOR_MATERIAL_TUNGSTEN_URANIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item TUNGSTEN_URANIUM_CHESTPLATE = new ArmorBase("tungsten_uranium_chestplate", ARMOR_MATERIAL_TUNGSTEN_URANIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item TUNGSTEN_URANIUM_LEGGINGS = new ArmorBase("tungsten_uranium_leggings", ARMOR_MATERIAL_TUNGSTEN_URANIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item TUNGSTEN_URANIUM_BOOTS = new ArmorBase("tungsten_uranium_boots", ARMOR_MATERIAL_TUNGSTEN_URANIUM, 1, EntityEquipmentSlot.FEET);

	//TUNGSTEN_TITANIUM//
	public static final ItemSword TUNGSTEN_TITANIUM_SWORD = new ToolSword("tungsten_titanium_sword", ToolMaterialCustom.TUNGSTEN_TITANIUM);
	public static final ItemSpade TUNGSTEN_TITANIUM_SHOVEL = new ToolSpade("tungsten_titanium_shovel", ToolMaterialCustom.TUNGSTEN_TITANIUM);
	public static final ItemPickaxe TUNGSTEN_TITANIUM_PICKAXE = new ToolPickaxe("tungsten_titanium_pickaxe", ToolMaterialCustom.TUNGSTEN_TITANIUM);
	public static final ItemPickaxe COMPLETE_TUNGSTEN_TITANIUM_PICKAXE = new ToolPickaxe("complete_tungsten_titanium_pickaxe", ToolMaterialCustom.COMPLETE_TUNGSTEN_TITANIUM);
	public static final ItemAxe TUNGSTEN_TITANIUM_AXE = new ToolAxe("tungsten_titanium_axe", ToolMaterialCustom.TUNGSTEN_TITANIUM);
	public static final ItemHoe TUNGSTEN_TITANIUM_HOE = new ToolHoe("tungsten_titanium_hoe", ToolMaterialCustom.TUNGSTEN_TITANIUM);

	public static final Item TUNGSTEN_TITANIUM_HELMET = new ArmorBase("tungsten_titanium_helmet", ARMOR_MATERIAL_TUNGSTEN_TITANIUM, 1, EntityEquipmentSlot.HEAD);
	public static final Item TUNGSTEN_TITANIUM_CHESTPLATE = new ArmorBase("tungsten_titanium_chestplate", ARMOR_MATERIAL_TUNGSTEN_TITANIUM, 1, EntityEquipmentSlot.CHEST);
	public static final Item TUNGSTEN_TITANIUM_LEGGINGS = new ArmorBase("tungsten_titanium_leggings", ARMOR_MATERIAL_TUNGSTEN_TITANIUM, 2, EntityEquipmentSlot.LEGS);
	public static final Item TUNGSTEN_TITANIUM_BOOTS = new ArmorBase("tungsten_titanium_boots", ARMOR_MATERIAL_TUNGSTEN_TITANIUM, 1, EntityEquipmentSlot.FEET);

	//EMERALD//
	public static final ItemSword EMERALD_SWORD = new ToolSword("emerald_sword", ToolMaterialCustom.EMERALD);
	public static final ItemSpade EMERALD_SHOVEL = new ToolSpade("emerald_shovel", ToolMaterialCustom.EMERALD);
	public static final ItemPickaxe EMERALD_PICKAXE = new ToolPickaxe("emerald_pickaxe", ToolMaterialCustom.EMERALD);
	public static final ItemAxe EMERALD_AXE = new ToolAxe("emerald_axe", ToolMaterialCustom.EMERALD);
	public static final ItemHoe EMERALD_HOE = new ToolHoe("emerald_hoe", ToolMaterialCustom.EMERALD);

	public static final Item EMERALD_HELMET = new EmeraldHelmet("emerald_helmet", ARMOR_MATERIAL_EMERALD, 1, EntityEquipmentSlot.HEAD);
	public static final Item EMERALD_CHESTPLATE = new EmeraldBody("emerald_chestplate", ARMOR_MATERIAL_EMERALD, 1, EntityEquipmentSlot.CHEST);
	public static final Item EMERALD_LEGGINGS = new EmeraldLegs("emerald_leggings", ARMOR_MATERIAL_EMERALD, 2, EntityEquipmentSlot.LEGS);
	public static final Item EMERALD_BOOTS = new EmeraldBoots("emerald_boots", ARMOR_MATERIAL_EMERALD, 1, EntityEquipmentSlot.FEET);

	//RUBY//
	public static final ItemSword RUBY_SWORD = new ToolSword("ruby_sword", ToolMaterialCustom.RUBY);
	public static final ItemSpade RUBY_SHOVEL = new ToolSpade("ruby_shovel", ToolMaterialCustom.RUBY);
	public static final ItemPickaxe RUBY_PICKAXE = new ToolPickaxe("ruby_pickaxe", ToolMaterialCustom.RUBY);
	public static final ItemAxe RUBY_AXE = new ToolAxe("ruby_axe", ToolMaterialCustom.RUBY);
	public static final ItemHoe RUBY_HOE = new ToolHoe("ruby_hoe", ToolMaterialCustom.RUBY);

	public static final Item RUBY_HELMET = new RubyHelmet("ruby_helmet", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.HEAD);
	public static final Item RUBY_CHESTPLATE = new RubyBody("ruby_chestplate", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.CHEST);
	public static final Item RUBY_LEGGINGS = new RubyLegs("ruby_leggings", ARMOR_MATERIAL_RUBY, 2, EntityEquipmentSlot.LEGS);
	public static final Item RUBY_BOOTS = new RubyBoots("ruby_boots", ARMOR_MATERIAL_RUBY, 1, EntityEquipmentSlot.FEET);

	//SAPPHIRE//
	public static final ItemSword SAPPHIRE_SWORD = new ToolSword("sapphire_sword", ToolMaterialCustom.SAPPHIRE);
	public static final ItemSpade SAPPHIRE_SHOVEL = new ToolSpade("sapphire_shovel", ToolMaterialCustom.SAPPHIRE);
	public static final ItemPickaxe SAPPHIRE_PICKAXE = new ToolPickaxe("sapphire_pickaxe", ToolMaterialCustom.SAPPHIRE);
	public static final ItemAxe SAPPHIRE_AXE = new ToolAxe("sapphire_axe", ToolMaterialCustom.SAPPHIRE);
	public static final ItemHoe SAPPHIRE_HOE = new ToolHoe("sapphire_hoe", ToolMaterialCustom.SAPPHIRE);

	public static final Item SAPPHIRE_HELMET = new SapphirHelmet("sapphire_helmet", ARMOR_MATERIAL_SAPPHIRE, 1, EntityEquipmentSlot.HEAD);
	public static final Item SAPPHIRE_CHESTPLATE = new SapphirBody("sapphire_chestplate", ARMOR_MATERIAL_SAPPHIRE, 1, EntityEquipmentSlot.CHEST);
	public static final Item SAPPHIRE_LEGGINGS = new SapphirLegs("sapphire_leggings", ARMOR_MATERIAL_SAPPHIRE, 2, EntityEquipmentSlot.LEGS);
	public static final Item SAPPHIRE_BOOTS = new SapphirBoots("sapphire_boots", ARMOR_MATERIAL_SAPPHIRE, 1, EntityEquipmentSlot.FEET);

	//DIAMOND//
	public static final ItemSword DIAMOND_SWORD = new ToolSword("diamond_sword", ToolMaterialCustom.DIAMOND);
	public static final ItemSpade DIAMOND_SHOVEL = new ToolSpade("diamond_shovel", ToolMaterialCustom.DIAMOND);
	public static final ItemPickaxe DIAMOND_PICKAXE = new ToolPickaxe("diamond_pickaxe", ToolMaterialCustom.DIAMOND);
	public static final ItemAxe DIAMOND_AXE = new ToolAxe("diamond_axe", ToolMaterialCustom.DIAMOND);
	public static final ItemHoe DIAMOND_HOE = new ToolHoe("diamond_hoe", ToolMaterialCustom.DIAMOND);

	public static final Item DIAMOND_HELMET = new DiamondHelmet("diamond_helmet", ARMOR_MATERIAL_DIAMOND, 1, EntityEquipmentSlot.HEAD);
	public static final Item DIAMOND_CHESTPLATE = new DiamondBody("diamond_chestplate", ARMOR_MATERIAL_DIAMOND, 1, EntityEquipmentSlot.CHEST);
	public static final Item DIAMOND_LEGGINGS = new DiamondLegs("diamond_leggings", ARMOR_MATERIAL_DIAMOND, 2, EntityEquipmentSlot.LEGS);
	public static final Item DIAMOND_BOOTS = new DiamondBoots("diamond_boots", ARMOR_MATERIAL_DIAMOND, 1, EntityEquipmentSlot.FEET);

	//OLIVINE//
	public static final ItemSword OLIVINE_SWORD = new ToolSword("olivine_sword", ToolMaterialCustom.OLIVINE);
	public static final ItemSpade OLIVINE_SHOVEL = new ToolSpade("olivine_shovel", ToolMaterialCustom.OLIVINE);
	public static final ItemPickaxe OLIVINE_PICKAXE = new ToolPickaxe("olivine_pickaxe", ToolMaterialCustom.OLIVINE);
	public static final ItemAxe OLIVINE_AXE = new ToolAxe("olivine_axe", ToolMaterialCustom.OLIVINE);
	public static final ItemHoe OLIVINE_HOE = new ToolHoe("olivine_hoe", ToolMaterialCustom.OLIVINE);

	public static final Item OLIVINE_HELMET = new SapphirHelmet("olivine_helmet", ARMOR_MATERIAL_OLIVINE, 1, EntityEquipmentSlot.HEAD);
	public static final Item OLIVINE_CHESTPLATE = new SapphirBody("olivine_chestplate", ARMOR_MATERIAL_OLIVINE, 1, EntityEquipmentSlot.CHEST);
	public static final Item OLIVINE_LEGGINGS = new SapphirLegs("olivine_leggings", ARMOR_MATERIAL_OLIVINE, 2, EntityEquipmentSlot.LEGS);
	public static final Item OLIVINE_BOOTS = new SapphirBoots("olivine_boots", ARMOR_MATERIAL_OLIVINE, 1, EntityEquipmentSlot.FEET);

	//WADSLEYITE//
	public static final ItemSword WADSLEYITE_SWORD = new ToolSword("wadsleyite_sword", ToolMaterialCustom.WADSLEYITE);
	public static final ItemSpade WADSLEYITE_SHOVEL = new ToolSpade("wadsleyite_shovel", ToolMaterialCustom.WADSLEYITE);
	public static final ItemPickaxe WADSLEYITE_PICKAXE = new ToolPickaxe("wadsleyite_pickaxe", ToolMaterialCustom.WADSLEYITE);
	public static final ItemAxe WADSLEYITE_AXE = new ToolAxe("wadsleyite_axe", ToolMaterialCustom.WADSLEYITE);
	public static final ItemHoe WADSLEYITE_HOE = new ToolHoe("wadsleyite_hoe", ToolMaterialCustom.WADSLEYITE);

	public static final Item WADSLEYITE_HELMET = new SapphirHelmet("wadsleyite_helmet", ARMOR_MATERIAL_WADSLEYITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item WADSLEYITE_CHESTPLATE = new SapphirBody("wadsleyite_chestplate", ARMOR_MATERIAL_WADSLEYITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item WADSLEYITE_LEGGINGS = new SapphirLegs("wadsleyite_leggings", ARMOR_MATERIAL_WADSLEYITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item WADSLEYITE_BOOTS = new SapphirBoots("wadsleyite_boots", ARMOR_MATERIAL_WADSLEYITE, 1, EntityEquipmentSlot.FEET);

	//RINGWOODITE//
	public static final ItemSword RINGWOODITE_SWORD = new ToolSword("ringwoodite_sword", ToolMaterialCustom.RINGWOODITE);
	public static final ItemSpade RINGWOODITE_SHOVEL = new ToolSpade("ringwoodite_shovel", ToolMaterialCustom.RINGWOODITE);
	public static final ItemPickaxe RINGWOODITE_PICKAXE = new ToolPickaxe("ringwoodite_pickaxe", ToolMaterialCustom.RINGWOODITE);
	public static final ItemAxe RINGWOODITE_AXE = new ToolAxe("ringwoodite_axe", ToolMaterialCustom.RINGWOODITE);
	public static final ItemHoe RINGWOODITE_HOE = new ToolHoe("ringwoodite_hoe", ToolMaterialCustom.RINGWOODITE);

	public static final Item RINGWOODITE_HELMET = new SapphirHelmet("ringwoodite_helmet", ARMOR_MATERIAL_RINGWOODITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item RINGWOODITE_CHESTPLATE = new SapphirBody("ringwoodite_chestplate", ARMOR_MATERIAL_RINGWOODITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item RINGWOODITE_LEGGINGS = new SapphirLegs("ringwoodite_leggings", ARMOR_MATERIAL_RINGWOODITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item RINGWOODITE_BOOTS = new SapphirBoots("ringwoodite_boots", ARMOR_MATERIAL_RINGWOODITE, 1, EntityEquipmentSlot.FEET);

	//BRIGMANITE//
	public static final ItemSword BRIGMANITE_SWORD = new ToolSword("brigmanite_sword", ToolMaterialCustom.BRIGMANITE);
	public static final ItemSpade BRIGMANITE_SHOVEL = new ToolSpade("brigmanite_shovel", ToolMaterialCustom.BRIGMANITE);
	public static final ItemPickaxe BRIGMANITE_PICKAXE = new ToolPickaxe("brigmanite_pickaxe", ToolMaterialCustom.BRIGMANITE);
	public static final ItemAxe BRIGMANITE_AXE = new ToolAxe("brigmanite_axe", ToolMaterialCustom.BRIGMANITE);
	public static final ItemHoe BRIGMANITE_HOE = new ToolHoe("brigmanite_hoe", ToolMaterialCustom.BRIGMANITE);

	public static final Item BRIGMANITE_HELMET = new SapphirHelmet("brigmanite_helmet", ARMOR_MATERIAL_BRIGMANITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item BRIGMANITE_CHESTPLATE = new SapphirBody("brigmanite_chestplate", ARMOR_MATERIAL_BRIGMANITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item BRIGMANITE_LEGGINGS = new SapphirLegs("brigmanite_leggings", ARMOR_MATERIAL_BRIGMANITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item BRIGMANITE_BOOTS = new SapphirBoots("brigmanite_boots", ARMOR_MATERIAL_BRIGMANITE, 1, EntityEquipmentSlot.FEET);

	//MAJORITE//
	public static final ItemSword MAJORITE_SWORD = new ToolSword("majorite_sword", ToolMaterialCustom.MAJORITE);
	public static final ItemSpade MAJORITE_SHOVEL = new ToolSpade("majorite_shovel", ToolMaterialCustom.MAJORITE);
	public static final ItemPickaxe MAJORITE_PICKAXE = new ToolPickaxe("majorite_pickaxe", ToolMaterialCustom.MAJORITE);
	public static final ItemAxe MAJORITE_AXE = new ToolAxe("majorite_axe", ToolMaterialCustom.MAJORITE);
	public static final ItemHoe MAJORITE_HOE = new ToolHoe("majorite_hoe", ToolMaterialCustom.MAJORITE);

	public static final Item MAJORITE_HELMET = new SapphirHelmet("majorite_helmet", ARMOR_MATERIAL_MAJORITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item MAJORITE_CHESTPLATE = new SapphirBody("majorite_chestplate", ARMOR_MATERIAL_MAJORITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item MAJORITE_LEGGINGS = new SapphirLegs("majorite_leggings", ARMOR_MATERIAL_MAJORITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item MAJORITE_BOOTS = new SapphirBoots("majorite_boots", ARMOR_MATERIAL_MAJORITE, 1, EntityEquipmentSlot.FEET);

	//AMAZONITE//
	public static final ItemSword AMAZONITE_SWORD = new ToolSword("amazonite_sword", ToolMaterialCustom.AMAZONITE);
	public static final ItemSpade AMAZONITE_SHOVEL = new ToolSpade("amazonite_shovel", ToolMaterialCustom.AMAZONITE);
	public static final ItemPickaxe AMAZONITE_PICKAXE = new ToolPickaxe("amazonite_pickaxe", ToolMaterialCustom.AMAZONITE);
	public static final ItemAxe AMAZONITE_AXE = new ToolAxe("amazonite_axe", ToolMaterialCustom.AMAZONITE);
	public static final ItemHoe AMAZONITE_HOE = new ToolHoe("amazonite_hoe", ToolMaterialCustom.AMAZONITE);

	public static final Item AMAZONITE_HELMET = new AmazoniteHelmet("amazonite_helmet", ARMOR_MATERIAL_AMAZONITE, 1, EntityEquipmentSlot.HEAD);
	public static final Item AMAZONITE_CHESTPLATE = new AmazoniteBody("amazonite_chestplate", ARMOR_MATERIAL_AMAZONITE, 1, EntityEquipmentSlot.CHEST);
	public static final Item AMAZONITE_LEGGINGS = new AmazoniteLegs("amazonite_leggings", ARMOR_MATERIAL_AMAZONITE, 2, EntityEquipmentSlot.LEGS);
	public static final Item AMAZONITE_BOOTS = new AmazoniteBoots("amazonite_boots", ARMOR_MATERIAL_AMAZONITE, 1, EntityEquipmentSlot.FEET);

	//ONYX//
	public static final ItemSword ONYX_SWORD = new ToolSword("onyx_sword", ToolMaterialCustom.ONYX);
	public static final ItemSpade ONYX_SHOVEL = new ToolSpade("onyx_shovel", ToolMaterialCustom.ONYX);
	public static final ItemPickaxe ONYX_PICKAXE = new ToolPickaxe("onyx_pickaxe", ToolMaterialCustom.ONYX);
	public static final ItemAxe ONYX_AXE = new ToolAxe("onyx_axe", ToolMaterialCustom.ONYX);
 	public static final ItemHoe ONYX_HOE = new ToolHoe("onyx_hoe", ToolMaterialCustom.ONYX);

	public static final Item ONYX_HELMET = new OnyxHelmet("onyx_helmet", ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.HEAD);
	public static final Item ONYX_CHESTPLATE = new OnyxBody("onyx_chestplate", ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.CHEST);
	public static final Item ONYX_LEGGINGS = new OnyxLegs("onyx_leggings", ARMOR_MATERIAL_ONYX, 2, EntityEquipmentSlot.LEGS);
	public static final Item ONYX_BOOTS = new OnyxBoots("onyx_boots", ARMOR_MATERIAL_ONYX, 1, EntityEquipmentSlot.FEET);


	//DEMON//CORE//


	//GEMS//
	public static final Item SULFUR_SHARD = new ItemBase("sulfur_shard");
	public static final Item REDSTONE_SHARD = new ItemBase("redstone_shard");
	public static final Item LAPIS_SHARD = new ItemBase("lapis_shard");
	public static final Item EMERALD_SHARD = new ItemBase("emerald_shard");
	public static final Item SAPPHIRE_SHARD = new ItemBase("sapphire_shard");
	public static final Item RUBY_SHARD = new ItemBase("ruby_shard");
	public static final Item TOPAZ_SHARD = new ItemBase("topaz_shard");
	public static final Item JADE_SHARD = new ItemBase("jade_shard");
	public static final Item DIAMOND_SHARD = new ItemBase("diamond_shard");
	public static final Item OLIVINE_SHARD = new ItemBase("olivine_shard");
	public static final Item WADSLEYITE_SHARD = new ItemBase("wadsleyite_shard");
	public static final Item RINGWOODITE_SHARD = new ItemBase("ringwoodite_shard");
	public static final Item BRIGMANITE_SHARD = new ItemBase("brigmanite_shard");
	public static final Item AMAZONITE_SHARD = new ItemBase("amazonite_shard");
	public static final Item MAJORITE_SHARD = new ItemBase("majorite_shard");
	public static final Item ONYX_SHARD = new ItemBase("onyx_shard");
	public static final Item SAPPHIRE = new ItemBase("sapphire");
	public static final Item RUBY = new ItemBase("ruby");
	public static final Item TOPAZ = new ItemBase("topaz");
	public static final Item JADE = new ItemBase("jade");
	public static final Item DIAMOND = new ItemBase("diamond");
	public static final Item OLIVINE = new ItemBase("olivine");
	public static final Item WADSLEYITE = new ItemBase("wadsleyite");
	public static final Item RINGWOODITE = new ItemBase("ringwoodite");
	public static final Item BRIGMANITE = new ItemBase("brigmanite");
	public static final Item AMAZONITE = new ItemBase("amazonite");
	public static final Item MAJORITE = new ItemBase("majorite");
	public static final Item ONYX = new ItemBase("onyx");

	//ROD//
	public static final Item ALUMINIUM_ROD = new ItemBase("aluminium_rod");
	public static final Item LEAD_ROD = new ItemBase("lead_rod");
	public static final Item SILICON_ROD = new ItemBase("silicon_rod");
	public static final Item COPPER_ROD = new ItemBase("copper_rod");
	public static final Item ZINC_ROD = new ItemBase("zinc_rod");
	public static final Item TIN_ROD = new ItemBase("tin_rod");
	public static final Item IRON_ROD = new ItemBase("iron_rod");
	public static final Item STEEL_ROD = new ItemBase("steel_rod");
	public static final Item BRONZE_ROD = new ItemBase("bronze_rod");
	public static final Item SILVER_ROD = new ItemBase("silver_rod");
	public static final Item GOLD_ROD = new ItemBase("gold_rod");
	public static final Item PLATINUM_ROD = new ItemBase("platinum_rod");
	public static final Item TITANIUM_ROD = new ItemBase("titanium_rod");
	public static final Item URANIUM_ROD = new ItemBase("uranium_rod");
	public static final Item TUNGSTEN_ROD = new ItemBase("tungsten_rod");
	public static final Item TITANIUM_URANIUM_ROD = new ItemBase("titanium_uranium_rod");
	public static final Item TUNGSTEN_URANIUM_ROD = new ItemBase("tungsten_uranium_rod");
	public static final Item TUNGSTEN_TITANIUM_ROD = new ItemBase("tungsten_titanium_rod");
	public static final Item TOPAZ_ROD = new ItemBase("topaz_rod");
	public static final Item JADE_ROD = new ItemBase("jade_rod");
	public static final Item EMERALD_ROD = new ItemBase("emerald_rod");
	public static final Item SAPPHIRE_ROD = new ItemBase("sapphire_rod");
	public static final Item RUBY_ROD = new ItemBase("ruby_rod");
	public static final Item DIAMOND_ROD = new ItemBase("diamond_rod");
	public static final Item OLIVINE_ROD = new ItemBase("olivine_rod");
	public static final Item WADSLEYITE_ROD = new ItemBase("wadsleyite_rod");
	public static final Item RINGWOODITE_ROD = new ItemBase("ringwoodite_rod");
	public static final Item BRIGMANITE_ROD = new ItemBase("brigmanite_rod");
	public static final Item AMAZONITE_ROD = new Gems("amazonite_rod");
	public static final Item MAJORITE_ROD = new Gems("majorite_rod");
	public static final Item ONYX_ROD = new Gems("onyx_rod");

	//Ingot//
	public static final Item ALUMINIUM_INGOT = new ItemBase("aluminium_ingot");
	public static final Item LEAD_INGOT = new ItemBase("lead_ingot");
	public static final Item SILICON_INGOT = new ItemBase("silicon_ingot");
	public static final Item COPPER_INGOT = new ItemBase("copper_ingot");
	public static final Item ZINC_INGOT = new ItemBase("zinc_ingot");
	public static final Item TIN_INGOT = new ItemBase("tin_ingot");
	public static final Item IRON_INGOT = new ItemBase("iron_ingot");
	public static final Item STEEL_INGOT = new ItemBase("steel_ingot");
	public static final Item BRONZE_INGOT = new ItemBase("bronze_ingot");
	public static final Item SILVER_INGOT = new ItemBase("silver_ingot");
	public static final Item GOLD_INGOT = new ItemBase("gold_ingot");
	public static final Item PLATINUM_INGOT = new ItemBase("platinum_ingot");
	public static final Item TITANIUM_INGOT = new ItemBase("titanium_ingot");
	public static final Item URANIUM_INGOT = new ItemBase("uranium_ingot");
	public static final Item TUNGSTEN_INGOT = new ItemBase("tungsten_ingot");
	public static final Item TITANIUM_URANIUM_INGOT = new ItemBase("titanium_uranium_ingot");
	public static final Item TUNGSTEN_URANIUM_INGOT = new ItemBase("tungsten_uranium_ingot");
	public static final Item TUNGSTEN_TITANIUM_INGOT = new ItemBase("tungsten_titanium_ingot");

	public static final Item IRON_COAL = new ItemBase("iron_coal");
	public static final Item SULFUR = new ItemBase("sulfur");

	public static final Item COAL_BIT = new ItemBase("coal_bit");
	public static final Item ALUMINIUM_NUGGET = new ItemBase("aluminium_nugget");
	public static final Item LEAD_NUGGET = new ItemBase("lead_nugget");
	public static final Item SILICON_NUGGET = new ItemBase("silicon_nugget");
	public static final Item COPPER_NUGGET = new ItemBase("copper_nugget");
	public static final Item ZINC_NUGGET = new ItemBase("zinc_nugget");
	public static final Item TIN_NUGGET = new ItemBase("tin_nugget");
	public static final Item IRON_NUGGET = new ItemBase("iron_nugget");
	public static final Item STEEL_NUGGET = new ItemBase("steel_nugget");
	public static final Item BRONZE_NUGGET = new ItemBase("bronze_nugget");
	public static final Item SILVER_NUGGET = new ItemBase("silver_nugget");
	public static final Item GOLD_NUGGET = new ItemBase("gold_nugget");
	public static final Item PLATINUM_NUGGET = new ItemBase("platinum_nugget");
	public static final Item TITANIUM_NUGGET = new ItemBase("titanium_nugget");
	public static final Item URANIUM_NUGGET = new ItemBase("uranium_nugget");
	public static final Item TUNGSTEN_NUGGET = new ItemBase("tungsten_nugget");
	public static final Item TITANIUM_URANIUM_NUGGET = new ItemBase("titanium_uranium_nugget");
	public static final Item TUNGSTEN_URANIUM_NUGGET = new ItemBase("tungsten_uranium_nugget");
	public static final Item TUNGSTEN_TITANIUM_NUGGET = new ItemBase("tungsten_titanium_nugget");

	public static final Item DEMON_STAR = new ItemBase("demon_star");
	public static final Item DEMON_STAR_CHARGED = new Gems("demon_star_charged");
	public static final Item CORE_STAR = new ItemBase("core_star");
	public static final Item ENHANCING_GEM = new ItemBase("enhancing_gem");

	public static final Item PLATINUM_APPLE = new FoodEffectBase("platinum_apple", 10, 3.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 6000,4, false, false),
			new PotionEffect(MobEffects.REGENERATION, 400,2, false, false),
			new PotionEffect(MobEffects.STRENGTH, 3000,0, false, false));

	public static final Item ENCHANTED_PLATINUM_APPLE = new EnchantedFoodEffectBase("enchanted_platinum_apple", 10, 3.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 6000,4, false, false),
			new PotionEffect(MobEffects.REGENERATION, 800,2, false, false),
			new PotionEffect(MobEffects.STRENGTH, 3000,1, false, false),
			new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000,1, false, false),
			new PotionEffect(MobEffects.RESISTANCE, 6000,1, false, false),
			new PotionEffect(MobEffects.GLOWING, 3000,0, false, false));

	public static final Item SAPPHIRE_APPLE = new EnchantedFoodEffectBase("sapphire_apple", 15, 6.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 12000,8, false, false),
			new PotionEffect(MobEffects.REGENERATION, 1200,3, false, false),
			new PotionEffect(MobEffects.STRENGTH, 6000,1, false, false),
			new PotionEffect(MobEffects.SPEED, 6000,0, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 6000,0, false, false),
			new PotionEffect(MobEffects.GLOWING, 3000,0, false, false));


	public static final Item ENCHANTED_SAPPHIRE_APPLE = new EnchantedFoodEffectBase1("enchanted_sapphire_apple", 15, 6.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 12000,8, false, false),
			new PotionEffect(MobEffects.REGENERATION, 1200,3, false, false),
			new PotionEffect(MobEffects.STRENGTH, 6000,2, false, false),
			new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000,2, false, false),
			new PotionEffect(MobEffects.RESISTANCE, 6000,2, false, false),
			new PotionEffect(MobEffects.SPEED, 6000,1, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 6000,1, false, false),
			new PotionEffect(MobEffects.GLOWING, 6000,0, false, false));

	public static final Item RUBY_APPLE = new EnchantedFoodEffectBase("ruby_apple", 20, 12.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 12000,12, false, false),
			new PotionEffect(MobEffects.REGENERATION, 3000,4, false, false),
			new PotionEffect(MobEffects.STRENGTH, 6000,2, false, false),
			new PotionEffect(MobEffects.SPEED, 6000,1, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 6000,1, false, false),
			new PotionEffect(MobEffects.GLOWING, 6000,0, false, false));


	public static final Item ENCHANTED_RUBY_APPLE = new EnchantedFoodEffectBase1("enchanted_ruby_apple", 20, 12.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 12000,12, false, false),
			new PotionEffect(MobEffects.REGENERATION, 3000,4, false, false),
			new PotionEffect(MobEffects.STRENGTH, 6000,3, false, false),
			new PotionEffect(MobEffects.FIRE_RESISTANCE, 6000,2, false, false),
			new PotionEffect(MobEffects.RESISTANCE, 6000,2, false, false),
			new PotionEffect(MobEffects.SPEED, 6000,2, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 6000,2, false, false),
			new PotionEffect(MobEffects.GLOWING, 6000,0, false, false));

	public static final Item DIAMOND_APPLE = new EnchantedFoodEffectBase("diamond_apple", 20, 24.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 24000,16, false, false),
			new PotionEffect(MobEffects.REGENERATION, 6000,4, false, false),
			new PotionEffect(MobEffects.SPEED, 6000,2, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 6000,2, false, false),
			new PotionEffect(MobEffects.STRENGTH, 6000,4, false, false),
			new PotionEffect(MobEffects.GLOWING, 6000,0, false, false));

	public static final Item ENCHANTED_DIAMOND_APPLE = new EnchantedFoodEffectBase1("enchanted_diamond_apple", 20, 24.0F, false,
			new PotionEffect(MobEffects.ABSORPTION, 24000,16, false, false),
			new PotionEffect(MobEffects.REGENERATION, 12000,4, false, false),
			new PotionEffect(MobEffects.STRENGTH, 12000,5, false, false),
			new PotionEffect(MobEffects.FIRE_RESISTANCE, 12000,2, false, false),
			new PotionEffect(MobEffects.RESISTANCE, 12000,2, false, false),
			new PotionEffect(MobEffects.SPEED, 12000,3, false, false),
			new PotionEffect(MobEffects.JUMP_BOOST, 12000,3, false, false),
			new PotionEffect(MobEffects.GLOWING, 12000,0, false, false));

//SHIELDS
	public static final Item ALUMINIUM_SHIELD = new ShieldBase("aluminium_shield");
	public static final Item LEAD_SHIELD = new ShieldBase("lead_shield");
	public static final Item SILICON_SHIELD = new ShieldBase("silicon_shield");
	public static final Item COPPER_SHIELD = new ShieldBase("copper_shield");
	public static final Item ZINC_SHIELD = new ShieldBase("zinc_shield");
	public static final Item TIN_SHIELD = new ShieldBase("tin_shield");
	public static final Item IRON_SHIELD = new ShieldBase("iron_shield");
	public static final Item STEEL_SHIELD = new ShieldBase("steel_shield");
	public static final Item BRONZE_SHIELD = new ShieldBase("bronze_shield");
	public static final Item SILVER_SHIELD = new ShieldBase("silver_shield");
	public static final Item GOLD_SHIELD = new ShieldBase("gold_shield");
	public static final Item PLATINUM_SHIELD = new ShieldBase("platinum_shield");
	public static final Item TITANIUM_SHIELD = new ShieldBase("titanium_shield");
	public static final Item URANIUM_SHIELD = new ShieldBase("uranium_shield");
	public static final Item TUNGSTEN_SHIELD = new ShieldBase("tungsten_shield");
	public static final Item TITANIUM_URANIUM_SHIELD = new ShieldBase("titanium_uranium_shield");
	public static final Item TUNGSTEN_URANIUM_SHIELD = new ShieldBase("tungsten_uranium_shield");
	public static final Item TUNGSTEN_TITANIUM_SHIELD = new ShieldBase("tungsten_titanium_shield");
	public static final Item TOPAZ_SHIELD = new ShieldBase("topaz_shield");
	public static final Item JADE_SHIELD = new ShieldBase("jade_shield");
	public static final Item EMERALD_SHIELD = new ShieldBase("emerald_shield");
	public static final Item SAPPHIRE_SHIELD = new ShieldBase("sapphire_shield");
	public static final Item RUBY_SHIELD = new ShieldBase("ruby_shield");
	public static final Item DIAMOND_SHIELD = new ShieldBase("diamond_shield");
	public static final Item OLIVINE_SHIELD = new ShieldBase("olivine_shield");
	public static final Item WADSLEYITE_SHIELD = new ShieldBase("wadsleyite_shield");
	public static final Item RINGWOODITE_SHIELD = new ShieldBase("ringwoodite_shield");
	public static final Item BRIGMANITE_SHIELD = new ShieldBase("brigmanite_shield");
	public static final Item AMAZONITE_SHIELD = new ShieldBase("amazonite_shield");
	public static final Item MAJORITE_SHIELD = new ShieldBase("majorite_shield");
	public static final Item ONYX_SHIELD = new ShieldBase("onyx_shield");


}
