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

public class OnyxBow extends ItemBow
{
    private Item arrow;
    private int damage;
    public OnyxBow()
    {
        this.maxStackSize = 1;
        this.setMaxDamage(1248);
        this.addPropertyOverride(new ResourceLocation("pulling"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && arrow == Items.ARROW && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
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
        this.addPropertyOverride(new ResourceLocation("pulling_majorite"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && arrow == ModItems.MAJORITE_ARROW && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling_amazonite"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && arrow == ModItems.AMAZONITE_ARROW && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
        this.addPropertyOverride(new ResourceLocation("pulling_onyx"), new IItemPropertyGetter()
        {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
            {
                return entityIn != null && arrow == ModItems.ONYX_ARROW && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
    }

    @Override
    public boolean getIsRepairable(ItemStack toRepair, ItemStack repair)
    {
        return repair.getItem() == ModItems.ONYX || super.getIsRepairable(toRepair, repair);
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
                || stack.getItem() == ModItems.DIAMOND_ARROW
                || stack.getItem() == ModItems.RUBY_ARROW
                || stack.getItem() == ModItems.SAPPHIRE_ARROW
                || stack.getItem() == ModItems.MAJORITE_ARROW
                || stack.getItem() == ModItems.AMAZONITE_ARROW
                || stack.getItem() == ModItems.ONYX_ARROW)
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
            boolean flag = entityplayer.capabilities.isCreativeMode;
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

                float f = getArrowVelocity(i);

                if ((double)f >= 0.1D)
                {

                    if (!worldIn.isRemote) {
                        EntityArrow entityarrow = null;
                        Item itemarrow = (itemstack.getItem() instanceof Item ? itemstack.getItem() : Items.ARROW);
                        if (itemstack.getItem() instanceof ItemArrow) {
                            entityarrow = ((ItemArrow) itemarrow).createArrow(worldIn, itemstack, entityplayer);
                            damage = 2;
                        }
                        if (itemstack.getItem() == ModItems.DIAMOND_ARROW) {
                            entityarrow = ((DiamondArrow) itemarrow).createArrow(worldIn, itemstack, entityplayer);
                            damage = 3;
                        }
                        if (itemstack.getItem() == ModItems.RUBY_ARROW) {
                            entityarrow = ((RubyArrow) itemarrow).createArrow(worldIn, itemstack, entityplayer);
                            damage = 6;
                        }
                        if (itemstack.getItem() == ModItems.SAPPHIRE_ARROW) {
                            entityarrow = ((SapphireArrow) itemarrow).createArrow(worldIn, itemstack, entityplayer);
                            damage = 7;
                        }
                        if (itemstack.getItem() == ModItems.MAJORITE_ARROW) {
                            entityarrow = ((MajoriteArrow) itemarrow).createArrow(worldIn, itemstack, entityplayer);
                            damage = 12;
                        }
                        if (itemstack.getItem() == ModItems.AMAZONITE_ARROW) {
                            entityarrow = ((AmazoniteArrow) itemarrow).createArrow(worldIn, itemstack, entityplayer);
                            damage = 13;
                        }
                        if (itemstack.getItem() == ModItems.ONYX_ARROW) {
                            entityarrow = ((OnyxArrow) itemarrow).createArrow(worldIn, itemstack, entityplayer);
                            damage = 14;
                        }

                        entityarrow = this.customizeArrow(entityarrow);
                        entityarrow.shoot(entityplayer, entityplayer.rotationPitch, entityplayer.rotationYaw, 0.0F, f * 3.0F, 1.0F);
                        entityarrow.setDamage(damage + 12);

                        if (f == 1.0F) {
                            entityarrow.setIsCritical(true);
                        }

                        int j = EnchantmentHelper.getEnchantmentLevel(Enchantments.POWER, stack);

                        if (j > 0) {
                            entityarrow.setDamage(damage + (double) j * 0.5D + 12.5D);
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

                    if (!entityplayer.capabilities.isCreativeMode)
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
        tooltip.add(net.minecraft.client.resources.I18n.format("Can use up to onyx tier arrows."));
        tooltip.add(net.minecraft.client.resources.I18n.format("Infinity enchantment don't work with this bow"));
        tooltip.add(net.minecraft.client.resources.I18n.format(getTranslationKey() + ".tooltip.0"));
        tooltip.add(net.minecraft.client.resources.I18n.format("Durability: " + (getMaxDamage() - getDamage(stack)) + " / " + getMaxDamage()));
    }
}
