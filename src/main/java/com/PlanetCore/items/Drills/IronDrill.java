package com.PlanetCore.items.Drills;

import com.PlanetCore.items.EnergyUser;
import com.PlanetCore.util.ItemStackEnergyCapabilityProvider;
import com.PlanetCore.util.handlers.pickaxe3x3Handler;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class IronDrill extends Item implements IAnimatable, EnergyUser {

    private int energy_per_block_broken = 50;

    public IronDrill() {
        this.maxStackSize = 1;
        setHarvestLevel("pickaxe",2);
    }

    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        if (getStoredEnergy(stack) < energy_per_block_broken) {
            return .1f;
        }
        return 1;
    }

    @Override
    public Set<String> getToolClasses(ItemStack stack) {
        if (getStoredEnergy(stack) < energy_per_block_broken) {
            return Collections.emptySet();
        }
        return super.getToolClasses(stack);
    }

    @Override
    public int getHarvestLevel(ItemStack stack, String toolClass, @Nullable EntityPlayer player, @Nullable IBlockState blockState) {
        if (getStoredEnergy(stack) < energy_per_block_broken) return -1;
        return super.getHarvestLevel(stack, toolClass, player, blockState);
    }

    @Override
    public boolean canHarvestBlock(IBlockState state, ItemStack stack) {
        return getStoredEnergy(stack) >= energy_per_block_broken;
    }

    @Override
    public boolean showDurabilityBar(ItemStack stack) {
        return true;
    }

    @Override
    public double getDurabilityForDisplay(ItemStack stack) {
        return 1 - (double) getStoredEnergy(stack) / getCapacity();
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        super.addInformation(stack, worldIn, tooltip, flagIn);
        addEnergyTooltip(stack,tooltip);
    }

    public AnimationFactory factory = new AnimationFactory(this);
    public static final String CTRL_NAME = "iron_drill";

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController<>(this, CTRL_NAME, 1, this::predicate));
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return oldStack.getItem() != newStack.getItem();
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    private <P extends Item & IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        return PlayState.CONTINUE;
    }

    /**
     * Breaks Blocks in a certain Radius
     * Has to be called on both Server and Client
     *
     * @param stack  The Drill
     * @param radius The Radius to break Blocks in (0 means only 1 Block will be broken!)
     * @param world  The World
     * @param player The Player who breaks the Blocks
     */
    public boolean breakBlocks(ItemStack stack, int radius, World world, BlockPos aPos, EnumFacing side, EntityPlayer player) {
        int xRange = radius;
        int yRange = radius;
        int zRange = 0;

        //Corrects Blocks to hit depending on Side of original Block hit
        if (side.getAxis() == EnumFacing.Axis.Y) {
            zRange = radius;
            yRange = 0;
        }
        if (side.getAxis() == EnumFacing.Axis.X) {
            xRange = 0;
            zRange = radius;
        }

        //Not defined later because main Block is getting broken below
        IBlockState state = world.getBlockState(aPos);
        float mainHardness = state.getBlockHardness(world, aPos);

        //Break Middle Block first
        int use = energy_per_block_broken;
        if (this.getStoredEnergy(stack) >= use) {
            if (!this.tryHarvestBlock(world, aPos, false, stack, player, use)) {
                return false;
            }
        } else {
            return false;
        }

        if (radius == 2 && side.getAxis() != EnumFacing.Axis.Y) {
            aPos = aPos.up();
            IBlockState theState = world.getBlockState(aPos);
            if (theState.getBlockHardness(world, aPos) <= mainHardness + 5.0F) {
                this.tryHarvestBlock(world, aPos, true, stack, player, use);
            }
        }

        //Break Blocks around
        if (radius > 0 && mainHardness >= 0.2F) {
            for (int xPos = aPos.getX() - xRange; xPos <= aPos.getX() + xRange; xPos++) {
                for (int yPos = aPos.getY() - yRange; yPos <= aPos.getY() + yRange; yPos++) {
                    for (int zPos = aPos.getZ() - zRange; zPos <= aPos.getZ() + zRange; zPos++) {
                        if (!(aPos.getX() == xPos && aPos.getY() == yPos && aPos.getZ() == zPos)) {
                            if (this.getStoredEnergy(stack) >= use) {
                                //Only break Blocks around that are (about) as hard or softer
                                BlockPos thePos = new BlockPos(xPos, yPos, zPos);
                                IBlockState theState = world.getBlockState(thePos);
                                if (theState.getBlockHardness(world, thePos) <= mainHardness + 5.0F) {
                                    this.tryHarvestBlock(world, thePos, true, stack, player, use);
                                }
                            } else {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    @Override
    public boolean onBlockStartBreak(ItemStack stack, BlockPos pos, EntityPlayer player) {
        boolean toReturn = false;
        int use = energy_per_block_broken;
        if (this.getStoredEnergy(stack) >= use) {

            //Block hit
            RayTraceResult ray = player.rayTrace(6,0);//WorldUtil.getNearestBlockWithDefaultReachDistance(player.world, player);
            if (ray != null) {

                //Breaks the Blocks
                if (!player.isSneaking())
                    toReturn = this.breakBlocks(stack, 1, player.world, pos, ray.sideHit, player);
            }
        }
        return toReturn;
    }

    /**
     * Tries to harvest a certain Block
     * Breaks the Block, drops Particles etc.
     * Has to be called on both Server and Client
     *
     * @param world   The World
     * @param isExtra If the Block is the Block that was looked at when breaking or an additional Block
     * @param stack   The Drill
     * @param player  The Player breaking the Blocks
     * @param use     The Energy that should be extracted per Block
     */
    private boolean tryHarvestBlock(World world, BlockPos pos, boolean isExtra, ItemStack stack, EntityPlayer player, int use) {
        IBlockState state = world.getBlockState(pos);
        Block block = state.getBlock();
        float hardness = state.getBlockHardness(world, pos);
        boolean canHarvest = ForgeHooks.canHarvestBlock(block, player, world, pos) && !block.isAir(state,world,pos);
        if (hardness >= 0.0F && canHarvest && !block.hasTileEntity(world.getBlockState(pos))) {
            if (!player.capabilities.isCreativeMode) {
                this.consumeEnergy(stack, use);
            }
            //Break the Block
            return pickaxe3x3Handler.breakExtraBlock(stack, world, player, pos);
        }
        return false;
    }

    public static final AnimationBuilder ACTIVE_DRILL = new AnimationBuilder().addAnimation("drill_active", true);
    public static final AnimationBuilder INACTIVE_DRILL = new AnimationBuilder().addAnimation("drill_inactive", false);

    //swing if the drill doesn't have enough energy
    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        return getStoredEnergy(stack) >= energy_per_block_broken;
    }

    @Override
    public int getStoredEnergy(ItemStack stack) {
        return stack.hasTagCompound() ? stack.getTagCompound().getInteger(ItemStackEnergyCapabilityProvider.ENERGY) : 0;
    }

    @Override
    public void consumeEnergy(ItemStack stack,int amount) {
        stack.getCapability(CapabilityEnergy.ENERGY,null).extractEnergy(amount,false);
    }

    @Override
    public int getCapacity() {
        return 100000;
    }

    @Override
    public int getTransfer() {
        return 1000;
    }

    @Nullable
    @Override
    public ICapabilityProvider initCapabilities(ItemStack stack, @Nullable NBTTagCompound nbt) {
        return new ItemStackEnergyCapabilityProvider<>(stack, this);
    }
}