package com.PlanetCore.blockentity;

import com.PlanetCore.blocks.LavaGeneratorBlock;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SPacketUpdateTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ITickable;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.world.IWorldNameable;
import net.minecraft.world.World;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.util.Constants;
import net.minecraftforge.energy.CapabilityEnergy;
import net.minecraftforge.energy.EnergyStorage;
import net.minecraftforge.energy.IEnergyStorage;
import net.minecraftforge.fluids.Fluid;
import net.minecraftforge.fluids.FluidRegistry;
import net.minecraftforge.fluids.FluidStack;
import net.minecraftforge.fluids.FluidTank;
import net.minecraftforge.fluids.capability.CapabilityFluidHandler;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class LavaGeneratorBlockEntity extends TileEntity implements ITickable, IWorldNameable {

    //Pouring vanilla lava will increase energy by 250 every seconds for 5 minutes.
   // Pouring iron_lava, silver lava or gold lava will increase energy by 500 every seconds for 5 minutes or until completely full.
    //todo Pouring any other lava will melt the iron energy generator into lava as they are too hot.

    public static final Map<Fluid, LavaFuelStats> generatorStatsMap = new HashMap<>();
    private boolean active;

    private LavaFuelStats fuelCache;
    private Fluid currentFuel;
    private int progress;

    static {
        LavaFuelStats.bootstrap(generatorStatsMap);
    }

    public LavaGeneratorBlockEntity() {
        fluidTank.setTileEntity(this);
    }

    private final ItemStackHandler itemStackHandler = new ItemStackHandler() {
        @Override
        protected void onContentsChanged(int slot) {
            super.onContentsChanged(slot);
            markDirty();
        }
    };

    private final FluidTank fluidTank = new FluidTank(10000) {

        //check for melting and energy generation when fluid is added
        @Override
        public int fillInternal(FluidStack resource, boolean doFill) {
            int i = super.fillInternal(resource, doFill);
            checkMelt();
            checkEnergyGen();
            return i;
        }

        @Override
        protected void onContentsChanged() {
            super.onContentsChanged();
            markDirty();
        }
    };

    private final BEEnergyStorage energyStorage = new BEEnergyStorage(100000) {
        @Override
        public void onChange() {
            super.onChange();
            checkEnergyGen();
            updateBlockstate();
            markDirty();
        }
    };

    public void checkEnergyGen() {
        if (!active) {
            findFuel();
        }
    }

    protected String customName;

    public boolean hasCustomName()
    {
        return this.customName != null && !this.customName.isEmpty();
    }

    public void setCustomName(String p_190575_1_)
    {
        this.customName = p_190575_1_;
    }

    @Override
    public String getName() {
        return this.hasCustomName() ? this.customName : "planetcore.container.lava_generator";
    }

    public ITextComponent getDisplayName() {
        return this.hasCustomName() ? new TextComponentString(this.getName()) : new TextComponentTranslation(this.getName());
    }

    @Override
    public void update() {
        if (!world.isRemote) {
            serverTick();
        }
    }

    public void serverTick() {
        if (active) {
            progress++;
            if (progress >= fuelCache.time) {//time is up, search for new fuel or shut down
                progress = 0;
                findFuel();
            } else {//keep adding energy
                energyStorage.receiveEnergy(fuelCache.rate, false);
            }
        }

        ItemStack stack = itemStackHandler.getStackInSlot(0);
        if (stack.hasCapability(CapabilityEnergy.ENERGY,null)) {
            IEnergyStorage iEnergyStorage = stack.getCapability(CapabilityEnergy.ENERGY,null);
            if (iEnergyStorage != null) {
                //grab 10000 energy and try to shove it in the receiver
                int extractFromHandler = energyStorage.extractEnergy(10000,true);
                int receive = iEnergyStorage.receiveEnergy(extractFromHandler,true);
                //only transfer what is actually received
                iEnergyStorage.receiveEnergy(receive,false);
                energyStorage.extractEnergy(receive,false);
            }
        }
    }

    public void findFuel() {
        //energy storage is full, deactivate
        if (energyStorage.getEnergyStored() >= energyStorage.getMaxEnergyStored()) {
            deactivate();
        }

        FluidStack fluidStack = fluidTank.getFluid();
        //there is no fuel, deactivate
        if (fluidStack == null || !generatorStatsMap.containsKey(fluidStack.getFluid()) || fluidStack.amount < Fluid.BUCKET_VOLUME) {
            deactivate();
        } else {//fuel was found, consume and set timer;
            active = true;
            currentFuel = fluidStack.getFluid();
            fuelCache = generatorStatsMap.get(fluidStack.getFluid());
            fluidTank.drain(1000,true);
        }
    }

    public void deactivate() {
        active = false;
        fuelCache = null;
        currentFuel = null;
    }

    public static int TEMPERATURE_LIMIT = 3000;
    public void checkMelt() {
        FluidStack fluidStack = fluidTank.getFluid();
        if (fluidStack != null) {//warning, fluidstacks can be null
            Fluid fluid = fluidStack.getFluid();
            if (fluid.getTemperature(fluidStack) > TEMPERATURE_LIMIT) {
                melt();
            }
        }
    }

    public void melt() {
        world.setBlockState(pos, Blocks.LAVA.getDefaultState());
    }

    public void updateBlockstate() {
        //FluidStack fluidStack = fluidTank.getFluid();
        //double ratio = fluidStack == null ? 0 : (double) fluidTank.getFluidAmount() / fluidTank.getCapacity();

        double ratio = (double) energyStorage.getEnergyStored() / energyStorage.getMaxEnergyStored();
        int level = (int) Math.ceil(ratio * 10);
        world.setBlockState(pos,getBlockType().getDefaultState().withProperty(LavaGeneratorBlock.LEVEL,level));
    }

    @Override
    public void markDirty() {
        super.markDirty();
        IBlockState state = getBlockType().getStateFromMeta(getBlockMetadata());
        world.notifyBlockUpdate(pos,state,state,3);//needed to notify the client of changes
    }


    public ItemStackHandler getItemStackHandler() {
        return itemStackHandler;
    }

    public FluidTank getFluidTank() {
        return fluidTank;
    }

    public EnergyStorage getEnergyStorage() {
        return energyStorage;
    }

    @Override
    public NBTTagCompound writeToNBT(NBTTagCompound compound) {
        compound.setTag("ItemStackHandler",itemStackHandler.serializeNBT());
        fluidTank.writeToNBT(compound);
        compound.setTag("EnergyStorage",energyStorage.serialize());
        if (this.hasCustomName()) {
            compound.setString("CustomName", this.customName);
        }
        compound.setBoolean("active",active);
        compound.setInteger("progress",progress);
        if (currentFuel != null) {
            compound.setString("CurrentFuel", currentFuel.getName());
        }
        return super.writeToNBT(compound);
    }

    @Override
    public void readFromNBT(NBTTagCompound compound) {
        itemStackHandler.deserializeNBT(compound.getCompoundTag("ItemStackHandler"));
        fluidTank.readFromNBT(compound);
        energyStorage.read(compound.getCompoundTag("EnergyStorage"));
        if (compound.hasKey("CustomName", Constants.NBT.TAG_STRING)) {
            this.customName = compound.getString("CustomName");
        }
        active = compound.getBoolean("active");
        progress = compound.getInteger("progress");
        currentFuel = FluidRegistry.getFluid(compound.getString("CurrentFuel"));
        fuelCache = generatorStatsMap.get(currentFuel);
        super.readFromNBT(compound);
    }

    @Override
    public boolean hasCapability(Capability<?> capability, @Nullable EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY ||
                capability == CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY || capability == CapabilityEnergy.ENERGY) {
            return true;
        }
        return super.hasCapability(capability, facing);
    }

    @Nullable
    @Override
    public <T> T getCapability(Capability<T> capability, @Nullable EnumFacing facing) {
        if (capability == CapabilityItemHandler.ITEM_HANDLER_CAPABILITY) {
            return (T)itemStackHandler;
        } else if (capability == CapabilityFluidHandler.FLUID_HANDLER_ITEM_CAPABILITY) {
            return (T)fluidTank;
        } else if (capability == CapabilityEnergy.ENERGY) {
            return (T)energyStorage;
        }

        return super.getCapability(capability, facing);
    }

    @Override
    public NBTTagCompound getUpdateTag() {
        return this.writeToNBT(new NBTTagCompound());    // okay to send entire inventory on chunk load
    }

    @Override
    public SPacketUpdateTileEntity getUpdatePacket() {
        return new SPacketUpdateTileEntity(getPos(), 1, this.writeToNBT(new NBTTagCompound()));
    }

    @Override
    public void onDataPacket(NetworkManager net, SPacketUpdateTileEntity packet) {
        this.readFromNBT(packet.getNbtCompound());
    }

    public int getRemainingTime() {
        return fuelCache == null ? 0 : fuelCache.time - progress;
    }

    public Fluid getCurrentFuel() {
        return currentFuel;
    }

    @Override
    public boolean shouldRefresh(World world, BlockPos pos, IBlockState oldState, IBlockState newSate) {
        return oldState.getBlock() != newSate.getBlock();
    }
}
