package com.PlanetCore.blocks;

import com.PlanetCore.Main;
import com.PlanetCore.blockentity.LavaGeneratorBlockEntity;
import com.PlanetCore.util.handlers.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class LavaGeneratorBlock extends Block {

    public static final PropertyInteger LEVEL = PropertyInteger.create("level",0,9);
    public LavaGeneratorBlock(Material materialIn) {
        super(materialIn);
        setDefaultState(getDefaultState().withProperty(LEVEL,0));
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) return true;
        player.openGui(Main.instance, GuiHandler.LAVA_GENERATOR, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(LEVEL);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(LEVEL,meta);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this,LEVEL);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return new LavaGeneratorBlockEntity();
    }

    @Override
    public int getLightValue(IBlockState state) {
        return state.getValue(LEVEL) > 0 ? 15 : 0;
    }
}
