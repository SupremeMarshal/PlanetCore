package com.PlanetCore.blocks;




import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.init.Items;
import net.minecraft.item.EnumDyeColor;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.Random;

public class BlocksBase extends BlockBase {
	public final PlanetMaterial planetMaterial;
	public BlocksBase(String name, Material material, PlanetMaterial planetMaterial) {
		super(name, material);
		setSoundType(SoundType.STONE);
		setHarvestLevel("pickaxe", 0);
		setTickRandomly(true);
		this.planetMaterial = planetMaterial;
	}

	@Override
	public Item getItemDropped(IBlockState state, Random random, int i) {
		return this.planetMaterial.droppedItem;
	}

	@Override
	public int quantityDroppedWithBonus(int fortune, Random random) {
		if (this == ModBlocks.REDSTONE_SUPERCOMPACT || this == ModBlocks.LAPIS_SUPERCOMPACT)
		{
			return 24 + new Random().nextInt(fortune * 12 + 12);
		}
		else return 9 + random.nextInt(fortune * 9 + 1);
	}

	@Override
	public int damageDropped(IBlockState state) {
		if (this == ModBlocks.LAPIS_SUPERCOMPACT) {
			return EnumDyeColor.BLUE.getDyeDamage();
		}
		else return super.damageDropped(state);
	}
}
