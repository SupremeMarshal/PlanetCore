package com.PlanetCore.blocks;

import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.BlockGravel;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

import java.util.Random;

public class GemsGravel extends BlockGravel {
    public final PlanetMaterial planetMaterial;
    public final PlanetHardness planetHardness;

    public GemsGravel(String name, PlanetMaterial planetMaterial, PlanetHardness planetHardness) {
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        ModBlocks.BLOCKS.add(this);
        setSoundType(SoundType.GROUND);
        this.planetMaterial = planetMaterial;
        this.planetHardness = planetHardness;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random rand, int fortune)
    {
        if (fortune > 3)
        {
            fortune = 3;
        }

        return rand.nextInt(10 - fortune * 3) == 0 ? planetMaterial.droppedItem : Item.getItemFromBlock(Blocks.GRAVEL);
    }

    @Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        return planetHardness.hardness;
    }
}
