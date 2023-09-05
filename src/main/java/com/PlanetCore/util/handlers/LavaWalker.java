package com.PlanetCore.util.handlers;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent;
import net.minecraftforge.event.world.GetCollisionBoxesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import javax.annotation.Nonnull;
import java.lang.reflect.Field;
import static net.minecraft.util.math.MathHelper.ceil;
import static net.minecraft.util.math.MathHelper.floor;

@Mod.EventBusSubscriber
public class LavaWalker {


//    static Field isJumping = ObfuscationReflectionHelper.findField(EntityLivingBase.class, "field_70703_bu");
//    @SubscribeEvent
//    public void livingUpdate(LivingEvent.LivingUpdateEvent event) throws IllegalAccessException {
//        if (!(event.getEntityLiving() instanceof EntityPlayer)) return;
//        EntityPlayer player = (EntityPlayer) event.getEntityLiving();
//        if (player.isSneaking()) return;
//
//        BlockPos liquid = new BlockPos(Math.floor(player.posX), Math.floor(player.posY), Math.floor(player.posZ));
//        BlockPos air = new BlockPos((int) player.posX, (int) (player.posY + player.height), (int) player.posZ);
//        IBlockState liquidBlockState = player.world.getBlockState(liquid);
//        Material liquidMaterial = liquidBlockState.getMaterial();
//
//        if ((liquidMaterial == Material.WATER && liquidMaterial.isLiquid()) && player.world.getBlockState(air).getBlock().isAir(player.world.getBlockState(air), player.world, air)
//                && isJumping(player)) {
//            player.move(MoverType.SELF, 0, 0.22, 0);
//        }
//    }
//
//    public static boolean isJumping(EntityLivingBase player) throws IllegalAccessException {
//        return isJumping.getBoolean(player);
//    }
//
//    @SubscribeEvent
//    public void waterWalking(LivingEvent.LivingUpdateEvent event) {
//        Entity entity = event.getEntity();
//        if (!(entity.motionY > 0) || !(entity instanceof EntityPlayer)) return;
//        EntityPlayer player = (EntityPlayer) entity;
//
//        AxisAlignedBB bb = player.getEntityBoundingBox();
//        AxisAlignedBB feet = new AxisAlignedBB(
//                bb.minX,
//                bb.minY,
//                bb.minZ,
//                bb.maxX,
//                bb.minY,
//                bb.maxZ
//        );
//        AxisAlignedBB ankles = new AxisAlignedBB(
//                bb.minX,
//                bb.minY + 0.5,
//                bb.minZ,
//                bb.maxX,
//                bb.minY + 0.5,
//                bb.maxZ
//        );
//        if (player.world.isMaterialInBB(feet, Material.WATER) &&
//                !(player.world.isMaterialInBB(ankles, Material.WATER) || (player.world.isMaterialInBB(ankles, Material.LAVA))
//                        && !(player.world.isMaterialInBB(ankles, Material.LAVA)
//                ))) {
//            player.motionY += 0.05F;
//        }
//    }
//
//    @SubscribeEvent
//    public void getCollisions(@Nonnull GetCollisionBoxesEvent event) {
//        Entity entity = event.getEntity();
//        if (!(entity instanceof EntityPlayer) || entity.isInWater() || entity.world.isMaterialInBB(entity.getEntityBoundingBox(), Material.LAVA) || entity.isSneaking()) return;
//
//        EntityPlayer player = (EntityPlayer) entity;
//
//        AxisAlignedBB entityBoundingBox = player.getEntityBoundingBox();
//
//        World world = event.getWorld();
//        for (BlockPos.MutableBlockPos mutableBlockPos : BlockPos.getAllInBoxMutable(
//                floor(entityBoundingBox.minX),
//                floor(entityBoundingBox.minY - 1),
//                floor(entityBoundingBox.minZ),
//                ceil(entityBoundingBox.minX),
//                floor(entityBoundingBox.minY),
//                ceil(entityBoundingBox.minZ)
//        )) {
//            IBlockState state = world.getBlockState(mutableBlockPos);
//
//            if (state.getMaterial() == Material.WATER || state.getMaterial().isLiquid()) {
//                AxisAlignedBB bb = new AxisAlignedBB(
//                        mutableBlockPos.getX(),
//                        mutableBlockPos.getY(),
//                        mutableBlockPos.getZ(),
//                        mutableBlockPos.getX() + 1,
//                        mutableBlockPos.getY() + 1,
//                        mutableBlockPos.getZ() + 1);
//                if (event.getAabb().intersects(bb)) {
//                    event.getCollisionBoxesList().add(bb);
//                }
//            }
//        }
//    }


}
