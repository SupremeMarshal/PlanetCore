package com.PlanetCore.blocks.Powered_ladders;

import com.PlanetCore.net.PacketHandler;
import com.PlanetCore.net.S2CLadderPacket;
import com.PlanetCore.world.LadderSavedData;
import com.PlanetCore.world.Pillar;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.EnderTeleportEvent;

public class DiamondLadderBlock extends ComplexLadderBlock {


    @Override
    public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ) {

        if (!worldIn.isRemote) {

            LadderSavedData ladderSavedData = getOrCreate(worldIn);

            Pillar pillar = ladderSavedData.findPillarAt(pos);
            if (pillar != null) {
                BlockPos top = pillar.getTop();
                BlockPos bot = pillar.getBase();


                EntityPlayerMP entityplayermp = (EntityPlayerMP) playerIn;

                if (entityplayermp.rotationPitch < -45 && entityplayermp.connection.getNetworkManager().isChannelOpen() && !entityplayermp.isPlayerSleeping())
                {
                    EnderTeleportEvent event = new EnderTeleportEvent(entityplayermp, top.getX() +.5,top.getY()+1,top.getZ()+.5,0);
                    if (!MinecraftForge.EVENT_BUS.post(event)) {

                        if (entityplayermp.isRiding()) {
                            entityplayermp.dismountRidingEntity();
                        }
                        entityplayermp.setPositionAndUpdate(event.getTargetX(), event.getTargetY(), event.getTargetZ());
                        entityplayermp.fallDistance = 0.0F;
                    }
                }
                if (entityplayermp.rotationPitch > 45 && entityplayermp.connection.getNetworkManager().isChannelOpen() && !entityplayermp.isPlayerSleeping())
                {
                    EnderTeleportEvent event = new EnderTeleportEvent(entityplayermp, bot.getX() +.5,bot.getY(),bot.getZ()+.5,0);
                    if (!MinecraftForge.EVENT_BUS.post(event)) {

                        if (entityplayermp.isRiding()) {
                            entityplayermp.dismountRidingEntity();
                        }
                        entityplayermp.setPositionAndUpdate(event.getTargetX(), event.getTargetY(), event.getTargetZ());
                        entityplayermp.fallDistance = 0.0F;
                    }
                }
            }
        }
        return true;
    }

    public static LadderSavedData getOrCreate(World world) {
        LadderSavedData ladderSavedData = (LadderSavedData) world.getMapStorage().getOrLoadData(LadderSavedData.class, LadderSavedData.ID);
        if (ladderSavedData == null) {
            ladderSavedData = new LadderSavedData();
            world.getMapStorage().setData(LadderSavedData.ID, ladderSavedData);
        }
        return ladderSavedData;
    }


    @Override
    public void updatePoweredState(World world, BlockPos pos, IBlockState state, boolean powered) {
        super.updatePoweredState(world, pos, state, powered);

        LadderSavedData ladderSavedData = getOrCreate(world);


        if (powered) {
            ladderSavedData.addPos(pos);
        } else {
            ladderSavedData.removePos(pos);
        }
        PacketHandler.INSTANCE.sendToDimension(new S2CLadderPacket(ladderSavedData.getPillars()), world.provider.getDimension());
    }

    @Override
    public void breakBlock(World world, BlockPos pos, IBlockState state) {
        super.breakBlock(world, pos, state);
        if (!world.isRemote) {

            LadderSavedData ladderSavedData = getOrCreate(world);

            ladderSavedData.removePos(pos);
            PacketHandler.INSTANCE.sendToDimension(new S2CLadderPacket(ladderSavedData.getPillars()), world.provider.getDimension());
        }
    }
}
