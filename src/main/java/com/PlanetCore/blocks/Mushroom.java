package com.PlanetCore.blocks;

import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.init.ModItems;
import net.minecraft.block.BlockMushroom;
import net.minecraft.block.SoundType;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;

import java.util.Random;

public class Mushroom extends BlockMushroom {

    public Mushroom(String name) {
        super();
        setRegistryName(name);
        setTranslationKey(name);
        setSoundType(SoundType.PLANT);
        setHardness(0);
        setResistance(0);
        ModBlocks.BLOCKS.add(this);
        setCreativeTab(CreativeTabs.DECORATIONS);
        setTickRandomly(true);
    }

    @Override
    public net.minecraftforge.common.EnumPlantType getPlantType(net.minecraft.world.IBlockAccess world, BlockPos pos) {
        return net.minecraftforge.common.EnumPlantType.Cave;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune) {
        return ModItems.FIERY_MUSHROOM_FOOD;
    }
}
