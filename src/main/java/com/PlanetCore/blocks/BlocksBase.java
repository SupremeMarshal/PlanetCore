package com.PlanetCore.blocks;




import com.PlanetCore.init.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import java.util.Random;

public class BlocksBase extends BlockBase {
	public BlocksBase(String name, Material material) {
		super(name, material);
		setSoundType(SoundType.STONE);
		setHarvestLevel("pickaxe", 0);
		setTickRandomly(true);
	}

	@Override
	public int quantityDropped(Random random) {
		String a = this.getTranslationKey();
		if (a.contains("redstone") || a.contains("lapis") || a.contains("coal") || a.contains("sulfur") || a.contains("emerald") || a.contains("sapphire")
				|| a.contains("ruby") || a.contains("diamond") || a.contains("topaz") || a.contains("jade")
				|| a.contains("olivine") || a.contains("wadsleyite") || a.contains("ringwoodite") || a.contains("brigmanite")
				|| a.contains("amazonite") || a.contains("majorite") || a.contains("onyx")) {
			return new Random().nextInt(5) + 4;
		}
		else return 1;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random random, int l) {
		String a = this.getTranslationKey();
		Boolean b = true;
		int amount = new Random().nextInt(5) + 4;
		Item drop = null;
		if (a.contains("redstone")) {
			drop = Items.REDSTONE;
		} else if (a.contains("lapis")) {
			drop = Items.DYE;
		} else if (a.contains("coal")) {
			drop = Items.COAL;
		} else if (a.contains("sulfur")) {
			drop = ModItems.SULFUR;
		} else if (a.contains("emerald")) {
			drop = Items.EMERALD;
		} else if (a.contains("sapphire")) {
			drop = ModItems.SAPPHIRE;
		} else if (a.contains("ruby")) {
			drop = ModItems.RUBY;
		} else if (a.contains("topaz")) {
			drop = ModItems.TOPAZ;
		} else if (a.contains("jade")) {
			drop = ModItems.JADE;
		} else if (a.contains("diamond")) {
			drop = ModItems.DIAMOND;
		} else if (a.contains("olivine")) {
			drop = ModItems.OLIVINE;
		} else if (a.contains("wadsleyite")) {
			drop = ModItems.WADSLEYITE;
		} else if (a.contains("ringwoodite")) {
			drop = ModItems.RINGWOODITE;
		} else if (a.contains("brigmanite")) {
			drop = ModItems.BRIGMANITE;
		} else if (a.contains("amazonite")) {
			drop = ModItems.AMAZONITE;
		} else if (a.contains("majorite")) {
			drop = ModItems.MAJORITE;
		} else if (a.contains("onyx")) {
			drop = ModItems.ONYX;
		}
		else b = false;

		if (!b) return new ItemStack(this, 1, 0).getItem();
		else return new ItemStack(drop, 1, 0).getItem();
	}

	@Override
	public boolean canDropFromExplosion(Explosion explosionIn) {


			int random = new Random().nextInt(3) + 1;
			if (random == 1) return true;
			else return false;
		}
}
