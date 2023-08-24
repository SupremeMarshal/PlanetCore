package com.PlanetCore.blocks.Elevator;

import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockLadder;
import net.minecraft.block.SoundType;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyBool;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;

public class Elevator extends BlockLadder {

    public static final PropertyBool POWERED = PropertyBool.create("powered");
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);


    public Elevator(String name) {
        super();
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        ModBlocks.BLOCKS.add(this);
        setSoundType(SoundType.METAL);
        setDefaultState(getDefaultState().withProperty(POWERED,false));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, POWERED);
    }

    @Override public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
        return false;
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        int facingBits = 0;
        EnumFacing facing = state.getValue(FACING);
        switch (facing) {
            case NORTH:
                facingBits = 0;
                break;
            case SOUTH:
                facingBits = 1;
                break;
            case WEST:
                facingBits = 2;
                break;
            case EAST:
                facingBits = 3;
                break;
        }
        int poweredBits = state.getValue(POWERED) ? 4 : 0;
        return facingBits | poweredBits;
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        EnumFacing facing;
        switch (meta & 3) {  // mask out the POWERED bit
            case 0:
                facing = EnumFacing.NORTH;
                break;
            case 1:
                facing = EnumFacing.SOUTH;
                break;
            case 2:
                facing = EnumFacing.WEST;
                break;
            case 3:
                facing = EnumFacing.EAST;
                break;
            default:
                facing = EnumFacing.NORTH;
                break;
        }
        boolean powered = (meta & 4) != 0;
        return this.getDefaultState().withProperty(FACING, facing).withProperty(POWERED, powered);
    }

    @Override
    public int getLightValue(IBlockState state, IBlockAccess world, BlockPos pos) {
        if (state.getValue(POWERED)) {
            return 5;
        } else {
            return 0;
        }
    }



    public void updatePowerState(World world, BlockPos pos) {
        IBlockState state = world.getBlockState(pos);

        if (state.getBlock() == this) {
            boolean currentPower = state.getValue(POWERED);
            boolean newPower = world.isBlockPowered(pos);

            if (newPower != currentPower) {
                world.setBlockState(pos, state.withProperty(POWERED, newPower), 2);
                propagatePower(world, pos, newPower);
            }
        }
    }

    public void propagatePower(World world, BlockPos originalPos, boolean powerState) {
        for (int y = -5; y <= 5; y++) {
            BlockPos newPos = originalPos.add(0, y, 0);
            IBlockState state = world.getBlockState(newPos);

            if (state.getBlock() instanceof Elevator && state.getValue(POWERED) != powerState) {
                // Check if the blocks are adjacent (i.e., no empty space)
                boolean shouldPropagate = true;
                if (y > 0) {
                    for (int checkY = 1; checkY <= y; checkY++) {
                        if (world.isAirBlock(originalPos.add(0, checkY, 0))) {
                            shouldPropagate = false;
                            break;
                        }
                    }
                } else if (y < 0) {
                    for (int checkY = -1; checkY >= y; checkY--) {
                        if (world.isAirBlock(originalPos.add(0, checkY, 0))) {
                            shouldPropagate = false;
                            break;
                        }
                    }
                }

                if (shouldPropagate) {
                    world.setBlockState(newPos, state.withProperty(POWERED, powerState), 2);
                }
            }
        }
    }


    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        super.breakBlock(world, pos, state);
        for (int y = -1; y <= 1; y++) {
            updatePowerState(world, pos.add(0, y, 0));
        }
    }


    @Override
    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos) {
        boolean isCurrentlyPowered = state.getValue(POWERED);
        boolean shouldBePowered = world.isBlockPowered(pos);

        // If the current state doesn't match the actual state, update all relevant blocks.
        if (isCurrentlyPowered != shouldBePowered) {
            world.setBlockState(pos, state.withProperty(POWERED, shouldBePowered), 2);

            propagatePower(world, pos, shouldBePowered);
        }
    }



//    @Override
//    public void neighborChanged(IBlockState state, World world, BlockPos pos, Block blockIn, BlockPos fromPos) {
//        boolean powered = world.isBlockPowered(pos);
//        if (powered != state.getValue(POWERED)) {
//            world.setBlockState(pos, state.withProperty(POWERED, powered), 2);
//        }
//    }
}
