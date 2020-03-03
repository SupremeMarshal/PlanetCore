package com.PlanetCore.anvils.Gold;

import com.PlanetCore.Main;
import com.PlanetCore.init.ModAnvils;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumFacing.Axis;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class BlockGoldAnvil extends BlockFalling {
    public static final PropertyDirection FACING;
    protected static final AxisAlignedBB X_AXIS_AABB;
    protected static final AxisAlignedBB Z_AXIS_AABB;
    protected static final Logger LOGGER;

    public BlockGoldAnvil(String name) {
        super(Material.ANVIL);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.setLightOpacity(0);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setHardness(5.0F);
        this.setSoundType(SoundType.ANVIL);
        this.setResistance(2000.0F);
        this.setRegistryName(name);
        this.setTranslationKey("planetcore:" + name);
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    public void onEndFalling(World worldIn, BlockPos pos, IBlockState fallingState, IBlockState hitState) {
        worldIn.playEvent(1031, pos, 0);
    }

    public IBlockState getStateForPlacement(World worldIn, BlockPos pos, EnumFacing facing, float hitX, float hitY, float hitZ, int meta, EntityLivingBase placer) {
        EnumFacing enumfacing = placer.getHorizontalFacing().rotateY();

        try {
            return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, meta, placer).withProperty(FACING, enumfacing);
        } catch (IllegalArgumentException var11) {
            if (!worldIn.isRemote) {
                LOGGER.warn(String.format("Invalid damage property for anvil at %s. Found %d, must be in [0, 1, 2]", pos, meta >> 2));
                if (placer instanceof EntityPlayer) {
                    placer.sendMessage(new TextComponentTranslation("Invalid damage property. Please pick in [0, 1, 2]", new Object[0]));
                }
            }

            return super.getStateForPlacement(worldIn, pos, facing, hitX, hitY, hitZ, 0, placer).withProperty(FACING, enumfacing);
        }
    }

    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
        return enumfacing.getAxis() == Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
    }

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            playerIn.openGui(Main.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }

        return true;
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Nullable
    public static IBlockState damage(IBlockState state) {
        Block block = state.getBlock();
        if (block == ModAnvils.blockGoldAnvil) {
            return ModAnvils.blockGoldAnvilChipped.getDefaultState().withProperty(FACING, state.getValue(FACING));
        } else {
            return block == ModAnvils.blockGoldAnvilChipped ? ModAnvils.blockGoldAnvilDamaged.getDefaultState().withProperty(FACING, state.getValue(FACING)) : null;
        }
    }

    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.byHorizontalIndex(meta & 3));
    }

    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{FACING});
    }

    @SideOnly(Side.CLIENT)
    public void registerModel() {
        ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), 0, new ModelResourceLocation(this.getRegistryName(), "inventory"));
    }

    static {
        FACING = BlockHorizontal.FACING;
        X_AXIS_AABB = new AxisAlignedBB(0.0D, 0.0D, 0.125D, 1.0D, 1.0D, 0.875D);
        Z_AXIS_AABB = new AxisAlignedBB(0.125D, 0.0D, 0.0D, 0.875D, 1.0D, 1.0D);
        LOGGER = LogManager.getLogger();
    }
}
