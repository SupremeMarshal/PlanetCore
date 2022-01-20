package com.PlanetCore.blocks;

import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.util.IMetaName;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.Blocks;
import net.minecraft.init.MobEffects;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

public class Painite extends BlockBase {

    public final PlanetMaterial planetMaterial;
    public final PlanetHardness planetHardness;

    public Painite(String name, Material material, PlanetMaterial planetMaterial, PlanetHardness planetHardness)
    {
        super(name, material);
        this.planetMaterial = planetMaterial;
        this.planetHardness = planetHardness;
        setLightLevel(1.0F);
        setTickRandomly(true);
    }

    @Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        if (this == ModBlocks.CENTERCORESTONE_COMPACT_PAINITE) return (planetHardness.hardness * 4) + 127098;
        if (this == ModBlocks.CENTERCORESTONE_PAINITE) return (planetHardness.hardness) + 127098;
        if (this == ModBlocks.CENTERCORESTONE_SMALL_PAINITE) return (planetHardness.hardness / 2) + 127098;
        return (planetHardness.hardness * 4) + 127098;
    }

    @Override
    public Item getItemDropped(IBlockState state, Random random, int i) {
        return this.planetMaterial.droppedItem;
    }

    @Override
    public int getExpDrop(IBlockState state, IBlockAccess world, BlockPos pos, int fortune) {
        Random rand = world instanceof World ? ((World)world).rand : new Random();
        if (this.getItemDropped(state, rand, fortune) != Item.getItemFromBlock(this)) {
            int i = 0;
            if (this == ModBlocks.CENTERCORESTONE_SMALL_PAINITE) {
                i = MathHelper.getInt(rand, 32, 64);
            } else if (this == ModBlocks.CENTERCORESTONE_PAINITE) {
                i = MathHelper.getInt(rand, 64, 128);
            } else if (this == ModBlocks.CENTERCORESTONE_COMPACT_PAINITE) {
                i = MathHelper.getInt(rand, 128, 256);
            }
            return i;
        }
        else return 0;
    }

    @Override
    public int quantityDroppedWithBonus(int fortune, Random random) {
        if (this == ModBlocks.CENTERCORESTONE_SMALL_PAINITE) return 2 + random.nextInt(fortune * 2 + 1);
        else if (this == ModBlocks.CENTERCORESTONE_COMPACT_PAINITE) return 3 + random.nextInt(fortune * 3 + 1);
        else return 1 + random.nextInt(fortune + 1);
    }

    protected static final AxisAlignedBB COLLISION_AABB = new AxisAlignedBB(0.0125D, 0.0D, 0.0125D, 0.9875D, 0.9375D, 0.9875D);

    public AxisAlignedBB getCollisionBoundingBox(IBlockState blockState, IBlockAccess worldIn, BlockPos pos)
    {
        return COLLISION_AABB;
    }

    @Override
    public void onEntityCollision(World worldIn, BlockPos pos, IBlockState state, Entity entityIn) {
        if (entityIn instanceof EntityLivingBase && !EnchantmentHelper.hasFrostWalkerEnchantment((EntityLivingBase)entityIn))
        {
            PotionEffect effect = ((EntityLivingBase) entityIn).getActivePotionEffect(MobEffects.FIRE_RESISTANCE);
            float damage = 128;
            if (effect == null) {
                entityIn.attackEntityFrom(DamageSource.LAVA, damage);
                entityIn.setFire(10);
            }
            else if (effect != null && effect.getAmplifier() == 0) {
                damage = damage / 4;
                if (damage >= 1) entityIn.attackEntityFrom(DamageSource.GENERIC, damage);
            }
            else if (effect != null && effect.getAmplifier() == 1) {
                damage = damage / 16;
                if (damage >= 1) entityIn.attackEntityFrom(DamageSource.GENERIC, damage);
            }
            else if (effect != null && effect.getAmplifier() == 2) {
                damage = damage / 64;
                if (damage >= 1) entityIn.attackEntityFrom(DamageSource.GENERIC, damage);
            }
        }
        //entityIn.attackEntityFrom(DamageSource.CACTUS, 1.0F);
        super.onEntityCollision(worldIn, pos, state, entityIn);
    }

    @Override
    public void neighborChanged(IBlockState state, World worldIn, BlockPos pos, Block blockIn, BlockPos fromPos)
    {
        super.neighborChanged(state, worldIn, pos, blockIn, fromPos);
        for (EnumFacing side : EnumFacing.values()) {
            if (worldIn.getBlockState(pos.offset(side)).getBlock() == Blocks.WATER || worldIn.getBlockState(pos.offset(side)).getBlock() == Blocks.FLOWING_WATER || worldIn.getBlockState(pos.offset(side)).getBlock() == Blocks.WATERLILY) {
                worldIn.setBlockToAir(pos.offset(side));
                worldIn.playSound(null, pos, SoundEvents.BLOCK_FIRE_EXTINGUISH, SoundCategory.BLOCKS, 0.5F, 2.6F + (worldIn.rand.nextFloat() - worldIn.rand.nextFloat()) * 0.8F);
                if (worldIn instanceof WorldServer) {
                    ((WorldServer) worldIn).spawnParticle(EnumParticleTypes.SMOKE_LARGE, (double) pos.offset(side).getX() + 0.5D, (double) pos.offset(side).getY() + 0.25D, (double) pos.offset(side).getZ() + 0.5D, 8, 0.5D, 0.25D, 0.5D, 0.0D);
                }
            }
        }
    }

    public void naturalGasExplosion(World worldIn, BlockPos pos, IBlockState state) {
        Random rand = new Random();
        int X = pos.getX();
        int Z = pos.getZ();
        int Y = pos.getY();
        if (!worldIn.isRemote && Y < -1700 && rand.nextInt(320) == 0) {
                worldIn.createExplosion(null, X, Y, Z, rand.nextInt(9) + 10, true);
        }
    }


    @Override
    public void onPlayerDestroy(World worldIn, BlockPos pos, IBlockState state) {
        super.onPlayerDestroy(worldIn, pos, state);
        naturalGasExplosion(worldIn, pos, state);
    }
}
