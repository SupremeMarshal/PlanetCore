package com.PlanetCore.entity;

import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.world.ColdExplosion;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;

public class NitrogenCoolerEntity extends EntityThrowable {
    public NitrogenCoolerEntity(World worldIn) {
        super(worldIn);
    }

    public NitrogenCoolerEntity(World worldIn, EntityLivingBase throwerIn) {
        super(worldIn, throwerIn);
    }

    public NitrogenCoolerEntity(World worldIn, double x, double y, double z) {
        super(worldIn, x, y, z);
    }



    private static final Map<IBlockState, IBlockState> conversionMap = new HashMap<>();

    static {
        addBlock(Blocks.FIRE,Blocks.AIR);
        addBlock(Blocks.LAVA,Blocks.COBBLESTONE.getDefaultState());
        addState(Blocks.LAVA.getStateFromMeta(0),Blocks.OBSIDIAN.getDefaultState());
        addBlock(Blocks.WATER,Blocks.ICE.getDefaultState());
        addBlock(ModBlocks.IRON_LAVA_FLUID,Blocks.COBBLESTONE);
        addBlock(ModBlocks.DIAMOND_LAVA_FLUID,Blocks.COBBLESTONE);
        addBlock(ModBlocks.TITANIUM_LAVA_FLUID,Blocks.COBBLESTONE);
        addBlock(ModBlocks.URANIUM_LAVA_FLUID,Blocks.COBBLESTONE);
        addBlock(ModBlocks.TUNGSTEN_LAVA_FLUID,Blocks.COBBLESTONE);
        addBlock(ModBlocks.RUBY_LAVA_FLUID,Blocks.COBBLESTONE);
        addBlock(ModBlocks.SAPPHIRE_LAVA_FLUID,Blocks.COBBLESTONE);
        addBlock(ModBlocks.MAJORITE_LAVA_FLUID,Blocks.COBBLESTONE);
        addBlock(ModBlocks.AMAZONITE_LAVA_FLUID,Blocks.COBBLESTONE);
        addBlock(ModBlocks.ONYX_LAVA_FLUID,Blocks.COBBLESTONE);
    }
    public static void addBlock(Block from,Block to) {
        addBlock(from,to.getDefaultState());
    }

    public static void addBlock(Block from,IBlockState to) {
        for (IBlockState state : from.getBlockState().getValidStates() ) {
            addState(state,to);
        }
    }

    public static void addState(IBlockState from, IBlockState to) {
        conversionMap.put(from,to);
    }

    public IBlockState getConversion(IBlockState state) {
        return conversionMap.get(state);
    }

    @Override
    protected void onImpact(RayTraceResult result) {
        if (!world.isRemote) {
            this.createExplosion(this, this.posX, this.posY + (double) (this.height / 16.0F), this.posZ, 4.0F, true);
            setDead();
        }
    }

    public Explosion createExplosion(@Nullable Entity entityIn, double x, double y, double z, float strength, boolean damagesTerrain) {
        return this.newExplosion(entityIn, x, y, z, strength, false, damagesTerrain);
    }

    public Explosion newExplosion(@Nullable Entity entityIn, double x, double y, double z, float strength, boolean causesFire, boolean damagesTerrain) {
        Explosion explosion = new ColdExplosion(this.world,(NitrogenCoolerEntity) entityIn, x, y, z, strength, causesFire, damagesTerrain);
        if (net.minecraftforge.event.ForgeEventFactory.onExplosionStart(this.world, explosion)) return explosion;
        explosion.doExplosionA();
        explosion.doExplosionB(true);
        return explosion;
    }

    @Override
    public float getExplosionResistance(Explosion explosionIn, World worldIn, BlockPos pos, IBlockState blockStateIn) {
        return Math.min(super.getExplosionResistance(explosionIn, worldIn, pos, blockStateIn),1);
    }
}
