package com.PlanetCore.anvils;

import com.PlanetCore.anvils.generic.BlockGenericAnvil;
import com.google.common.collect.Lists;
import io.netty.buffer.ByteBuf;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import net.minecraft.block.Block;
import net.minecraft.block.BlockFalling;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.MoverType;
import net.minecraft.entity.item.EntityFallingBlock;
import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSource;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.util.FakePlayerFactory;
import net.minecraftforge.fml.common.registry.IEntityAdditionalSpawnData;

public class EntityFallingAnvil extends EntityFallingBlock implements IEntityAdditionalSpawnData {
    private IBlockState fallTile;
    public int fallTime;
    public boolean shouldDropItem = true;
    private boolean dontSetBlock;
    private boolean hurtEntities;
    private int fallHurtMax = 2147483647;
    private double fallResistance;
    private double fallHurtAmount;
    public NBTTagCompound tileEntityData;
    private static final String anvilDamageName = "anvildamage";
    public static final DamageSource Main = new DamageSource("anvildamage");

    public EntityFallingAnvil(World worldIn) {
        super(worldIn);
    }

    public EntityFallingAnvil(World worldIn, double x, double y, double z, IBlockState fallingBlockState) {
        super(worldIn, x, y, z, fallingBlockState);
        this.fallTile = fallingBlockState;
        this.fallHurtAmount = ((BlockGenericAnvil)fallingBlockState.getBlock()).properties.weight * 2.0D;
        this.fallResistance = ((BlockGenericAnvil)fallingBlockState.getBlock()).properties.fallResistance;
    }

    public void fall(float distance, float damageMultiplier) {
        BlockGenericAnvil block = (BlockGenericAnvil)this.fallTile.getBlock();
        if (this.hurtEntities) {
            int i = MathHelper.ceil(distance - 1.0F);
            if (i > 0) {
                List<Entity> list = Lists.newArrayList(this.world.getEntitiesWithinAABBExcludingEntity(this, this.getEntityBoundingBox()));
                boolean flag = block.properties.causesPlayerDamage && i > 20;
                boolean shouldDamage = true;
                FakePlayer fakePlayer = flag ? FakePlayerFactory.getMinecraft((WorldServer)this.world) : null;
                float amount = (float)Math.min(MathHelper.floor((double)i * this.fallHurtAmount), this.fallHurtMax);
                Iterator var10 = list.iterator();

                while(var10.hasNext()) {
                    Entity entity = (Entity)var10.next();
                    if (entity instanceof EntityLivingBase) {
                        shouldDamage = false;
                    }

                    if (flag) {
                        entity.attackEntityFrom(new EntityDamageSource("anvildamage", fakePlayer), amount);
                    } else {
                        entity.attackEntityFrom(DamageSource.ANVIL, amount);
                    }
                }

                if (shouldDamage && (double)this.rand.nextFloat() * this.fallResistance < 0.05D * (double)(i + 1)) {
                    IBlockState iblockstate = BlockGenericAnvil.damage(this.fallTile);
                    if (iblockstate == null) {
                        if (((BlockGenericAnvil)this.fallTile.getBlock()).properties.material.equals("gold")) {
                            this.fallTile = Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE.getDefaultState();
                        } else {
                            this.dontSetBlock = true;
                        }
                    } else {
                        this.fallTile = iblockstate;
                    }
                }
            }
        }

    }

    public void onUpdate() {
        Block block = this.fallTile.getBlock();
        if (this.fallTile.getMaterial() == Material.AIR) {
            this.setDead();
        } else {
            this.prevPosX = this.posX;
            this.prevPosY = this.posY;
            this.prevPosZ = this.posZ;
            BlockPos blockpos1;
            if (this.fallTime++ == 0) {
                blockpos1 = new BlockPos(this);
                if (this.world.getBlockState(blockpos1).getBlock() == block) {
                    this.world.setBlockToAir(blockpos1);
                } else if (!this.world.isRemote) {
                    this.setDead();
                    return;
                }
            }

            if (!this.hasNoGravity()) {
                this.motionY -= 0.04D;
            }

            this.move(MoverType.SELF, this.motionX, this.motionY, this.motionZ);
            if (!this.world.isRemote) {
                blockpos1 = new BlockPos(this);
                if (!this.onGround) {
                    if (this.fallTime > 100 && (blockpos1.getY() < 1 || blockpos1.getY() > 256) || this.fallTime > 600) {
                        if (this.shouldDropItem && this.world.getGameRules().getBoolean("doEntityDrops")) {
                            this.entityDropItem(new ItemStack(block, 1, block.damageDropped(this.fallTile)), 0.0F);
                        }

                        this.setDead();
                    }
                } else {
                    IBlockState iblockstate = this.world.getBlockState(blockpos1);
                    if (this.world.isAirBlock(new BlockPos(this.posX, this.posY - 0.01D, this.posZ)) && BlockFalling.canFallThrough(this.world.getBlockState(new BlockPos(this.posX, this.posY - 0.01D, this.posZ)))) {
                        this.onGround = false;
                        return;
                    }

                    this.motionX *= 0.7D;
                    this.motionZ *= 0.7D;
                    this.motionY *= -0.5D;
                    if (iblockstate.getBlock() != Blocks.PISTON_EXTENSION) {
                        this.setDead();
                        if (!this.dontSetBlock) {
                            if (this.world.mayPlace(block, blockpos1, true, EnumFacing.UP, (Entity)null) && !BlockFalling.canFallThrough(this.world.getBlockState(blockpos1.down())) && this.world.setBlockState(blockpos1, this.fallTile, 3)) {
                                if (block instanceof BlockFalling) {
                                    ((BlockFalling)block).onEndFalling(this.world, blockpos1, this.fallTile, iblockstate);
                                }

                                if (this.tileEntityData != null && block.hasTileEntity(this.fallTile)) {
                                    TileEntity tileentity = this.world.getTileEntity(blockpos1);
                                    if (tileentity != null) {
                                        NBTTagCompound nbttagcompound = tileentity.writeToNBT(new NBTTagCompound());
                                        Iterator var6 = this.tileEntityData.getKeySet().iterator();

                                        while(var6.hasNext()) {
                                            String s = (String)var6.next();
                                            NBTBase nbtbase = this.tileEntityData.getTag(s);
                                            if (!"x".equals(s) && !"y".equals(s) && !"z".equals(s)) {
                                                nbttagcompound.setTag(s, nbtbase.copy());
                                            }
                                        }

                                        tileentity.readFromNBT(nbttagcompound);
                                        tileentity.markDirty();
                                    }
                                }
                            } else if (this.shouldDropItem && this.world.getGameRules().getBoolean("doEntityDrops")) {
                                this.entityDropItem(new ItemStack(block, 1, block.damageDropped(this.fallTile)), 0.0F);
                            }
                        } else if (block instanceof BlockFalling) {
                            ((BlockFalling)block).onBroken(this.world, blockpos1);
                        }
                    }
                }

                if (((BlockGenericAnvil)this.fallTile.getBlock()).properties.material.equals("vibrant_alloy") || ((BlockGenericAnvil)this.fallTile.getBlock()).properties.material.equals("enderium")) {
                    int r = 5;
                    List<Entity> entities = this.world.getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(this.posX - (double)r, this.posY - (double)r, this.posZ - (double)r, this.posX + (double)r, this.posY + (double)r, this.posZ + (double)r));
                    if (entities.size() > 0) {
                        EntityLivingBase entity = (EntityLivingBase)entities.get(0);
                        this.setPositionAndUpdate(entity.posX, this.posY, entity.posZ);
                    }
                }
            }

            this.motionX *= 0.98D;
            this.motionY *= 0.98D;
            this.motionZ *= 0.98D;
        }

    }

    protected void writeEntityToNBT(NBTTagCompound compound) {
        Block block = this.fallTile != null ? this.fallTile.getBlock() : Blocks.AIR;
        ResourceLocation resourcelocation = (ResourceLocation)Block.REGISTRY.getNameForObject(block);
        compound.setString("Block", resourcelocation.toString());
        compound.setByte("Data", (byte)block.getMetaFromState(this.fallTile));
        compound.setInteger("Time", this.fallTime);
        compound.setBoolean("DropItem", this.shouldDropItem);
        compound.setBoolean("HurtEntities", this.hurtEntities);
        compound.setFloat("FallHurtAmount", (float)this.fallHurtAmount);
        compound.setInteger("FallHurtMax", this.fallHurtMax);
        if (this.tileEntityData != null) {
            compound.setTag("TileEntityData", this.tileEntityData);
        }

    }

    protected void readEntityFromNBT(NBTTagCompound compound) {
        int i = compound.getByte("Data") & 255;
        if (compound.hasKey("Block", 8)) {
            this.fallTile = Block.getBlockFromName(compound.getString("Block")).getStateFromMeta(i);
        } else if (compound.hasKey("TileID", 99)) {
            this.fallTile = Block.getBlockById(compound.getInteger("TileID")).getStateFromMeta(i);
        } else {
            this.fallTile = Block.getBlockById(compound.getByte("Tile") & 255).getStateFromMeta(i);
        }

        this.fallTime = compound.getInteger("Time");
        Block block = this.fallTile.getBlock();
        if (compound.hasKey("HurtEntities", 99)) {
            this.hurtEntities = compound.getBoolean("HurtEntities");
            this.fallHurtAmount = (double)compound.getFloat("FallHurtAmount");
            this.fallHurtMax = compound.getInteger("FallHurtMax");
        } else if (block == Blocks.ANVIL) {
            this.hurtEntities = true;
        }

        if (compound.hasKey("DropItem", 99)) {
            this.shouldDropItem = compound.getBoolean("DropItem");
        }

        if (compound.hasKey("TileEntityData", 10)) {
            this.tileEntityData = compound.getCompoundTag("TileEntityData");
        }

        if (block.getDefaultState().getMaterial() == Material.AIR) {
            this.fallTile = Blocks.SAND.getDefaultState();
        }

    }

    @Nullable
    public IBlockState getBlock() {
        return this.fallTile;
    }

    public void setHurtEntities(boolean hurtEntities) {
        this.hurtEntities = hurtEntities;
    }

    public void writeSpawnData(ByteBuf buffer) {
        buffer.writeLong(this.getPosition().toLong());
    }

    public void readSpawnData(ByteBuf additionalData) {
        long blockPosLong = additionalData.readLong();
        this.fallTile = this.world.getBlockState(BlockPos.fromLong(blockPosLong));
    }
}
