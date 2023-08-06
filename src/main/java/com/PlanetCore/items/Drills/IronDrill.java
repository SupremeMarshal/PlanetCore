package com.PlanetCore.items.Drills;

import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.*;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;
import software.bernie.geckolib3.core.AnimationState;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;
import software.bernie.geckolib3.util.GeckoLibUtil;

public class IronDrill extends Item implements IAnimatable {

    public static AnimationFactory getFactory;
    private boolean isDrilling = false;

    public IronDrill()
    {
        this.maxStackSize = 1;
        this.setMaxDamage(3000);
    }


    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state)
    {
        Material material = state.getMaterial();
        return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK ? super.getDestroySpeed(stack, state) : 15;
    }

    public AnimationFactory factory = new AnimationFactory(this);

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "iron_drill", 10, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    private <P extends Item & IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        return PlayState.CONTINUE;
    }

    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer player, EnumHand hand) {
        if (!worldIn.isRemote) {
            return super.onItemRightClick(worldIn, player, hand);
        } else {
            ItemStack stack = player.getHeldItem(hand);
            AnimationController<?> controller = GeckoLibUtil.getControllerForStack(this.factory, stack, "iron_drill");
            controller.markNeedsReload();
            controller.setAnimation((new AnimationBuilder()).addAnimation("drill_active", true));
            return super.onItemRightClick(worldIn, player, hand);
        }
    }

    //Just for test purpose
    @Override
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
        AnimationController<?> controller = GeckoLibUtil.getControllerForStack(this.factory, stack, "iron_drill");
        controller.setAnimation((new AnimationBuilder()).clearAnimations());
        return super.onItemUseFinish(stack, worldIn, entityLiving);
    }
}