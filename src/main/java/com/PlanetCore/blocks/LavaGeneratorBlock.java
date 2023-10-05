package com.PlanetCore.blocks;

import com.PlanetCore.Main;
import com.PlanetCore.blockentity.LavaGeneratorBlockEntity;
import com.PlanetCore.util.handlers.GuiHandler;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fluids.FluidUtil;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import org.jetbrains.annotations.Nullable;

public class LavaGeneratorBlock extends Block {

    public static final PropertyInteger LEVEL = PropertyInteger.create("level", 0, 10);
    private final GeneratorStats generatorStats;

    public LavaGeneratorBlock(Material materialIn,GeneratorStats generatorStats) {
        super(materialIn);
        this.generatorStats = generatorStats;
        setDefaultState(getDefaultState().withProperty(LEVEL, 0));
    }

    @Override
    public boolean onBlockActivated(World world, BlockPos pos, IBlockState state, EntityPlayer player, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (world.isRemote) return true;
        ItemStack stack = player.getHeldItem(hand);
        if (stack.hasCapability(CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY, null)) {
            TileEntity tileEntity = world.getTileEntity(pos);
            if (tileEntity instanceof LavaGeneratorBlockEntity) {
                FluidUtil.interactWithFluidHandler(player,hand,((LavaGeneratorBlockEntity) tileEntity).getFluidTank());
                return true;
            }
        }

        player.openGui(Main.instance, GuiHandler.LAVA_GENERATOR, world, pos.getX(), pos.getY(), pos.getZ());
        return true;
    }

    public void onBlockPlacedBy(World worldIn, BlockPos pos, IBlockState state, EntityLivingBase placer, ItemStack stack) {
        super.onBlockPlacedBy(worldIn, pos, state, placer, stack);
        if (stack.hasDisplayName()) {
            TileEntity tileentity = worldIn.getTileEntity(pos);
            if (tileentity instanceof LavaGeneratorBlockEntity) {
                ((LavaGeneratorBlockEntity) tileentity).setCustomName(stack.getDisplayName());
            }
        }
    }

    @Override
    public int getMetaFromState(IBlockState state) {
        return state.getValue(LEVEL);
    }

    @Override
    public IBlockState getStateFromMeta(int meta) {
        return getDefaultState().withProperty(LEVEL, meta);
    }

    @Override
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, LEVEL);
    }

    @Override
    public boolean hasTileEntity(IBlockState state) {
        return true;
    }

    public GeneratorStats getGeneratorStats() {
        return generatorStats;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(World world, IBlockState state) {
        return generatorStats.create();
    }


    //I should be able to edit capacity, max extract capacity, temperature capacity, hardness, and fluid tank capacity.
    public interface GeneratorStats {
        int energyCapacity();
        int energyExtractRate();
        int maxTemperature();
        int fluidCapacity();
        TileEntity create();
    }

    @Override
    public int getLightValue(IBlockState state) {
        return state.getValue(LEVEL) > 0 ? 15 : 0;
    }
}
