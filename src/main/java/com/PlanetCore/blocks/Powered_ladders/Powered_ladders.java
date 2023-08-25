package com.PlanetCore.blocks.Powered_ladders;

import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.*;
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

public class Powered_ladders extends BlockLadder {

    public static final PropertyBool POWERED = PropertyBool.create("powered");
    public static final PropertyDirection FACING = PropertyDirection.create("facing", EnumFacing.Plane.HORIZONTAL);


    public Powered_ladders(String name) {
        super();
        setTranslationKey(name);
        setRegistryName(name);
        setCreativeTab(CreativeTabs.BUILDING_BLOCKS);
        ModBlocks.BLOCKS.add(this);
        setSoundType(SoundType.METAL);
        setDefaultState(getDefaultState().withProperty(POWERED, false));
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, FACING, POWERED);
    }

    @Override
    public boolean isLadder(IBlockState state, IBlockAccess world, BlockPos pos, EntityLivingBase entity) {
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

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        super.breakBlock(world, pos, state);
        world.notifyNeighborsOfStateChange(pos, this, false);
    }


    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos) {
        if (!worldIn.isRemote) {
            this.updateState(state, worldIn, pos);
        }
    }

    protected void updateState(IBlockState state, World worldIn, BlockPos pos) {
        boolean flag = state.getValue(POWERED);
        boolean flag1 = worldIn.isBlockPowered(pos) || this.findPoweredLadderSignal(worldIn, pos, state, true, 0) || this.findPoweredLadderSignal(worldIn, pos, state, false, 0);

        if (flag1 != flag) {
            worldIn.setBlockState(pos, state.withProperty(POWERED, flag1), 3);
            worldIn.notifyNeighborsOfStateChange(pos.down(), this, false);
        }
    }

    protected boolean findPoweredLadderSignal(World worldIn, BlockPos pos, IBlockState state, boolean searchForward, int recursionCount) {
        if (recursionCount >= 8) {
            return false;
        } else {
            int x = pos.getX();
            int y = pos.getY();
            int z = pos.getZ();
            EnumFacing direction = state.getValue(FACING);

            if (searchForward) {
                y++;
            } else {
                y--;
            }

            return this.isSameLadderWithPower(worldIn, new BlockPos(x, y, z), searchForward, recursionCount, direction);
        }
    }

    protected boolean isSameLadderWithPower(World worldIn, BlockPos pos, boolean searchForward, int distance, EnumFacing direction) {
        IBlockState iblockstate = worldIn.getBlockState(pos);

        if (!(iblockstate.getBlock() instanceof Powered_ladders)) {
            return false;
        } else {
            EnumFacing direction2 = iblockstate.getValue(FACING);

            if (direction2 == direction) {
                if (iblockstate.getValue(POWERED)) {
                    return worldIn.isBlockPowered(pos) || this.findPoweredLadderSignal(worldIn, pos, iblockstate, searchForward, distance + 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
    }

    public void onBlockAdded(World worldIn, BlockPos pos, IBlockState state) {
        if (!worldIn.isRemote) {
            state.neighborChanged(worldIn, pos, this, pos);
        }
    }
}
