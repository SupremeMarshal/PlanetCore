package com.PlanetCore.items.bows;

import com.PlanetCore.init.ModItems;
import com.PlanetCore.items.arrows.*;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Enchantments;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.*;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;
import java.util.List;

public class WadsleyiteBow extends ItemBow
{
    private Item arrow;
    private int damage;
    public WadsleyiteBow()
    {
        this.maxStackSize = 1;
        this.setMaxDamage(960);
        this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && arrow == Items.ARROW && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling_emerald"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && arrow == ModItems.EMERALD_ARROW && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling_ruby"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && arrow == ModItems.RUBY_ARROW && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling_sapphire"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && arrow == ModItems.SAPPHIRE_ARROW && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling_diamond"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && arrow == ModItems.DIAMOND_ARROW && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling_olivine"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && arrow == ModItems.OLIVINE_ARROW && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling_wadsleyite"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && arrow == ModItems.WADSLEYITE_ARROW && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
    }

    @Override
    public int getItemEnchantability()
    {
        return 10;
    }

    @Override
    protected boolean isArrow(ItemStack stack)
    {
        if(stack.getItem() instanceof ItemArrow
                || stack.getItem() == ModItems.EMERALD_ARROW
                || stack.getItem() == ModItems.RUBY_ARROW
                || stack.getItem() == ModItems.SAPPHIRE_ARROW
                || stack.getItem() == ModItems.DIAMOND_ARROW
                || stack.getItem() == ModItems.OLIVINE_ARROW
                || stack.getItem() == ModItems.WADSLEYITE_ARROW)
        {
            return true;
        }
        return false;
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        arrow = this.findAmmo(playerIn).getItem();
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }

    @Override
    public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft)
    {
        if (entityLiving instanceof EntityPlayer)
        {
            EntityPlayer entityplayer = (EntityPlayer)entityLiving;
            boolean flag = entityplayer.capabilities.isCreativeMode || EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0;
            ItemStack itemstack = this.findAmmo(entityplayer);

            int i = this.getMaxItemUseDuration(stack) - timeLeft;
            i = net.minecraftforge.event.ForgeEventFactory.onArrowLoose(stack, worldIn, entityplayer, i, !itemstack.isEmpty() || flag);
            if (i < 0) return;

            if (!itemstack.isEmpty() || flag)
            {
                if (itemstack.isEmpty())
                {
                    itemstack = new ItemStack(Items.ARROW);
                }
                if (!itemstack.isEmpty() && EnchantmentHelper.getEnchantmentLevel(Enchantments.INFINITY, stack) > 0 && itemstack.getItem() != Items.ARROW)
                {
                    itemstack.shrink(-1);
                }

                float f = getArrowVelocity(i);

                if ((double)f >= 0.1D)
                {
                    boolean flag1 = entityplayer.capabilities.isCreativeMode || (itemstack.getItem() instanceof ItemArrow && ((ItemArrow) itemstack.getItem()).isInfinite(itemstack, stack, entityplayer));


                    if (!worldIn.isRemote) {
                        EntityArrow entityarrow = null;
                        Item itemarrow = (itemstack.getItem() instanceof Item ? itemstack.getItem() : Items.ARROW);
                        if (itemstack.getItem() instanceof ItemArrow) {
                            entityarrow = ((ItemArrow) itemarrow).createArrow(worldIn, itemstack, entityplayer);
                            damage = 2;
                        }
                        if (itemstack.getItem() == ModItems.EMERALD_ARROW) {
                            entityarrow = ((EmeraldArrow) itemarrow).createArrow(worldIn, itemstack, entityplayer);
                            damage = 3;
                        }
                        if (itemstack.getItem() == ModItems.RUBY_ARROW) {
                            entityarrow = ((RubyArrow) itemarrow).createArrow(worldIn, itemstack, entityplayer);
                            damage = 4;
                        }
                        if (itemstack.getItem() == ModItems.SAPPHIRE_ARROW) {
                            entityarrow = ((SapphireArrow) itemarrow).createArrow(worldIn, itemstack, entityplayer);
                            damage = 5;
                        }
                        if (itemstack.getItem() == ModItems.DIAMOND_ARROW) {
                            entityarrow = ((DiamondArrow) itemarrow).createArrow(worldIn, itemstack, entityplayer);
                            damage = 6;
                        }
                        if (itemstack.getItem() == ModItems.OLIVINE_ARROW) {
                            entityarrow = ((OlivineArrow) itemarrow).createArrow(worldIn, itemstack, entityplayer);
                            damage = 7;
                        }
                        if (itemstack.getItem() == ModItems.WADSLEYITE_ARROW) {
                            entityarrow = ((WadsleyiteArrow) itemarrow).createArrow(worldIn, itemstack, entityplayer);
                            damage = 8;
                        }

                        entityarrow = this.customizeArrow(entityarrow);
                        entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F, 1.0F);
                        entityarrow.setDamage(damage + 2);

                        if (f == 1.0F) {
                            entityarrow.setIsCritical(true);
                        }

                        int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

                        if (j > 0) {
                            entityarrow.setDamage(damage + (double) j * 0.5D + 2.5D);
                        }

                        int k = EnchantmentHelper.getEnchantmentLevel(Enchantments.PUNCH, stack);

                        if (k > 0) {
                            entityarrow.setKnockbackStrength(k);
                        }

                        if (EnchantmentHelper.getEnchantmentLevel(Enchantments.FLAME, stack) > 0) {
                            entityarrow.setFire(100);
                        }

                        stack.damageItem(1, entityplayer);

                        worldIn.spawnEntity(entityarrow);
                    }




                    worldIn.playSound((EntityPlayer)null, entityplayer.posX, entityplayer.posY, entityplayer.posZ, SoundEvents.ENTITY_ARROW_SHOOT, SoundCategory.PLAYERS, 1.0F, 1.0F / (itemRand.nextFloat() * 0.4F + 1.2F) + f * 0.5F);

                    if (!flag1 && !entityplayer.capabilities.isCreativeMode)
                    {
                        itemstack.shrink(1);

                        if (itemstack.isEmpty())
                        {
                            entityplayer.inventory.deleteStack(itemstack);
                        }
                    }

                    entityplayer.addStat(StatList.getObjectUseStats(this));
                }
            }


        }
    }

    @SideOnly(Side.CLIENT)
    @Override
    public void addInformation(ItemStack stack, @Nullable World worldIn, List<String> tooltip, ITooltipFlag flagIn) {
        tooltip.add(net.minecraft.client.resources.I18n.format("Can use up to wadsleyite tier arrows."));
        tooltip.add(net.minecraft.client.resources.I18n.format("Increased damage: +2"));
        tooltip.add(net.minecraft.client.resources.I18n.format("Infinity enchantment give infinite normal arrows."));
        tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
    }
}
