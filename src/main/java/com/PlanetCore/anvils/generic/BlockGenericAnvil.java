package com.PlanetCore.anvils.generic;

import com.PlanetCore.Main;
import com.PlanetCore.anvils.EnumVariants;
import com.PlanetCore.anvils.EntityFallingAnvil;
import java.util.List;
import java.util.Random;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

import net.minecraft.block.BlockFalling;
import net.minecraft.block.BlockHorizontal;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyDirection;
import net.minecraft.block.state.BlockFaceShape;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.NonNullList;
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
import org.lwjgl.input.Keyboard;

public class BlockGenericAnvil extends BlockFalling  {
    public static final PropertyDirection FACING;
    protected static final AxisAlignedBB X_AXIS_AABB;
    protected static final AxisAlignedBB Z_AXIS_AABB;
    protected static final Logger LOGGER;
    public AnvilProperties properties;
    public EnumVariants variant;

    public BlockGenericAnvil(AnvilProperties properties, EnumVariants variant) {
        super(Material.ANVIL);
        this.setDefaultState(this.blockState.getBaseState().withProperty(FACING, EnumFacing.NORTH));
        this.setLightOpacity(0);
        this.setCreativeTab(CreativeTabs.DECORATIONS);
        this.setHardness(5.0F);
        this.setSoundType(SoundType.ANVIL);
        this.setResistance(2000.0F);
        this.properties = properties;
        this.variant = variant;
        Main.anvils.add(this);
    }

    public boolean isFullCube(IBlockState state) {
        return false;
    }

    @Nonnull
    public AxisAlignedBB getBoundingBox(IBlockState state, IBlockAccess source, BlockPos pos) {
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
        return enumfacing.getAxis() == Axis.X ? X_AXIS_AABB : Z_AXIS_AABB;
    }

    public void onEndFalling(World worldIn, BlockPos pos, IBlockState p_176502_3_, IBlockState p_176502_4_) {
        worldIn.playEvent(1031, pos, 0);
    }

    @Nonnull
    public BlockFaceShape getBlockFaceShape(IBlockAccess worldIn, IBlockState state, BlockPos pos, EnumFacing face) {
        return BlockFaceShape.UNDEFINED;
    }

    @Nonnull
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

    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {
        if (!worldIn.isRemote) {
            playerIn.openGui(Main.instance, 0, worldIn, pos.getX(), pos.getY(), pos.getZ());
        }

        return true;
    }

    public static IBlockState damage(IBlockState state) {
        BlockGenericAnvil block = (BlockGenericAnvil)state.getBlock();
        EnumFacing enumfacing = (EnumFacing)state.getValue(FACING);
        switch(block.variant) {
            case NORMAL:
            case CHIPPED:
                return Main.anvilDamageMap.get(block).getDefaultState().withProperty(FACING, enumfacing);
            case DAMAGED:
            default:
                return null;
        }
    }

    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        items.add(new ItemStack(this));
    }

    @Nonnull
    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(FACING, EnumFacing.byHorizontalIndex(meta & 3));
    }

    public int getMetaFromState(IBlockState state) {
        return ((EnumFacing)state.getValue(FACING)).getHorizontalIndex();
    }

    protected void onStartFalling(EntityFallingBlock fallingEntity) {
        this.onStartFall((EntityFallingAnvil)fallingEntity);
    }

    private void onStartFall(EntityFallingAnvil anvil) {
        anvil.setHurtEntities(true);
    }

    public boolean isOpaqueCube(IBlockState state) {
        return false;
    }

    @Nonnull
    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{FACING});
    }

    private void checkFallable(World worldIn, BlockPos pos) {
        if ((worldIn.isAirBlock(pos.down()) || canFallThrough(worldIn.getBlockState(pos.down()))) && pos.getY() >= 0) {
            int i = 32;
            if (!fallInstantly && worldIn.isAreaLoaded(pos.add(-i, -i, -i), pos.add(i, i, i))) {
                if (!worldIn.isRemote) {
                    EntityFallingAnvil entityfallinganvil = new EntityFallingAnvil(worldIn, (double)pos.getX() + 0.5D, (double)pos.getY(), (double)pos.getZ() + 0.5D, worldIn.getBlockState(pos));
                    this.onStartFalling(entityfallinganvil);
                    worldIn.spawnEntity(entityfallinganvil);
                }
            } else {
                IBlockState state = worldIn.getBlockState(pos);
                worldIn.setBlockToAir(pos);

                BlockPos blockpos;
                for(blockpos = pos.down(); (worldIn.isAirBlock(blockpos) || canFallThrough(worldIn.getBlockState(blockpos))) && blockpos.getY() > 0; blockpos = blockpos.down()) {
                }

                if (blockpos.getY() > 0) {
                    worldIn.setBlockState(blockpos.up(), state);
                }
            }
        }

    }

    public void updateTick(World worldIn, @Nonnull BlockPos pos, IBlockState state, Random rand) {
        if (!worldIn.isRemote) {
            if ((this.properties.material.equals("energetic_alloy") || this.properties.material.equals("signalum")) && worldIn.isBlockPowered(pos)) {
                return;
            }

            this.checkFallable(worldIn, pos);
        }

    }

    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        if (worldIn != null) {
            if (Keyboard.isKeyDown(42)) {
                tooltip.add("Level Cap: " + this.properties.cap);
                tooltip.add("Durability Multiplier: " + this.properties.durabilityMultiplier);
                tooltip.add("Enchantability: " + this.properties.enchantability);
                if (this.properties.causesPlayerDamage) {
                    tooltip.add("Causes Player Damage");
                }

            }
        }
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
