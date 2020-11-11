package com.PlanetCore.items.tools;

import com.PlanetCore.init.ModItems;
import com.google.common.collect.Sets;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Set;

public class ToolPickaxe extends ItemPickaxe {

	private static final Set<Block> EFFECTIVE_ON = Sets.newHashSet(Blocks.ACTIVATOR_RAIL, Blocks.COAL_ORE, Blocks.COBBLESTONE, Blocks.DETECTOR_RAIL, Blocks.DIAMOND_BLOCK, Blocks.DIAMOND_ORE, Blocks.DOUBLE_STONE_SLAB, Blocks.GOLDEN_RAIL, Blocks.GOLD_BLOCK, Blocks.GOLD_ORE, Blocks.ICE, Blocks.IRON_BLOCK, Blocks.IRON_ORE, Blocks.LAPIS_BLOCK, Blocks.LAPIS_ORE, Blocks.LIT_REDSTONE_ORE, Blocks.MOSSY_COBBLESTONE, Blocks.NETHERRACK, Blocks.PACKED_ICE, Blocks.RAIL, Blocks.REDSTONE_ORE, Blocks.SANDSTONE, Blocks.RED_SANDSTONE, Blocks.STONE, Blocks.STONE_SLAB, Blocks.STONE_BUTTON, Blocks.STONE_PRESSURE_PLATE);

	public ToolPickaxe(String name, ModItems.ToolMaterialCustom material)
	{
		super(material);
		setTranslationKey(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.TOOLS);
		
		ModItems.ITEMS.add(this);

	}


	//public static final int [] relentless = {5, 5, 6, 6, 6/**5*/, 5, 7, 8, 8, 9/**10*/, 10, 11, 12, 10, 10/**15*/, 12, 12, 12, 12, 12/**20*/, 15, 15, 15, 20, 20/**25*/, 20, 20, 20, 20, 20/**30*/, 20};

	//private static final ItemPickaxe[] pickaxe = {ModItems.ALUMINIUM_PICKAXE, ModItems.ZINC_PICKAXE, ModItems.LEAD_PICKAXE, ModItems.TIN_PICKAXE, ModItems.SILICON_PICKAXE/**5*/,
			//ModItems.COPPER_PICKAXE, ModItems.IRON_PICKAXE, ModItems.BRONZE_PICKAXE, ModItems.STEEL_PICKAXE, ModItems.SILVER_PICKAXE/**10*/,
			//ModItems.GOLD_PICKAXE, ModItems.PLATINUM_PICKAXE, ModItems.TITANIUM_PICKAXE, ModItems.URANIUM_PICKAXE, ModItems.TOPAZ_PICKAXE/**15*/,
			//ModItems.JADE_PICKAXE, ModItems.TUNGSTEN_PICKAXE, ModItems.TITANIUM_URANIUM_PICKAXE, ModItems.TUNGSTEN_URANIUM_PICKAXE, ModItems.TUNGSTEN_TITANIUM_PICKAXE/**20*/,
			//ModItems.EMERALD_PICKAXE, ModItems.RUBY_PICKAXE, ModItems.SAPPHIRE_PICKAXE, ModItems.DIAMOND_PICKAXE, ModItems.OLIVINE_PICKAXE/**25*/,
			//ModItems.WADSLEYITE_PICKAXE, ModItems.RINGWOODITE_PICKAXE, ModItems.BRIGMANITE_PICKAXE, ModItems.MAJORITE_PICKAXE, ModItems.AMAZONITE_PICKAXE/**30*/, ModItems.ONYX_PICKAXE};





	@SideOnly(Side.CLIENT)
	@Override
	public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn)
	{
		int Relentless = 0;
		/*
		for (int i = 0; i < 29; i++) {
			if (stack.getItem() != pickaxe[i]) {
				continue;
			}
			Relentless = relentless[i];
			break;
		}

		 */

		if (!stack.hasTagCompound()) {

			stack.setTagCompound(new NBTTagCompound());

		}

		if (!stack.getTagCompound().hasKey("HideFlags")) {

			// hides normal info

			stack.getTagCompound().setInteger("HideFlags", 2);

		}
		tooltip.add(net.minecraft.client.resources.I18n.format("When in main hand:"));
		tooltip.add(net.minecraft.client.resources.I18n.format((int)this.attackDamage+" Attack Damage"));
		tooltip.add(net.minecraft.client.resources.I18n.format(this.attackSpeed+" Attack Speed"));
		tooltip.add(net.minecraft.client.resources.I18n.format(this.efficiency+" Efficiency"));
		tooltip.add(net.minecraft.client.resources.I18n.format((int)this.relentless+" Relentless"));
		tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " +(getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
	}

	public float getDestroySpeed(ItemStack stack, IBlockState state)
	{
		Material material = state.getMaterial();
		return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK ? super.getDestroySpeed(stack, state) : this.efficiency;
	}
}
