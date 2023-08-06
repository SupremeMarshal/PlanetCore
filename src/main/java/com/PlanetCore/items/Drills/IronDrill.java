package com.PlanetCore.items.Drills;

import ibxm.Player;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.*;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingDestroyBlockEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.Event;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import software.bernie.geckolib3.core.IAnimatable;
import software.bernie.geckolib3.core.PlayState;
import software.bernie.geckolib3.core.builder.AnimationBuilder;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.core.event.predicate.AnimationEvent;
import software.bernie.geckolib3.core.manager.AnimationData;
import software.bernie.geckolib3.core.manager.AnimationFactory;

@Mod.EventBusSubscriber()
public class IronDrill extends Item implements IAnimatable {

    public static boolean drill_active;
    public static boolean isLeftClicking;

    public IronDrill() {
        this.maxStackSize = 1;
        this.setMaxDamage(3000);
    }


    @Override
    public float getDestroySpeed(ItemStack stack, IBlockState state) {
        Material material = state.getMaterial();
        return material != Material.IRON && material != Material.ANVIL && material != Material.ROCK ? super.getDestroySpeed(stack, state) : 15;
    }

    public AnimationFactory factory = new AnimationFactory(this);

    @Override
    public void registerControllers(AnimationData animationData) {
        animationData.addAnimationController(new AnimationController(this, "iron_drill", 1, this::predicate));
    }

    @Override
    public AnimationFactory getFactory() {
        return this.factory;
    }

    private <P extends Item & IAnimatable> PlayState predicate(AnimationEvent<P> event) {
        if(drill_active) {
            event.getController().setAnimation((new AnimationBuilder()).addAnimation("drill_active", true));
        } else {
            event.getController().setAnimation((new AnimationBuilder()).addAnimation("drill_inactive", true));
        }
        return PlayState.CONTINUE;
    }

    @Override
    public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
        if (entityLiving.isSwingInProgress) {
            entityLiving.swingProgress = -10000000f;
            entityLiving.swingProgressInt = -10000000;
            return true;
        }
        return super.onEntitySwing(entityLiving, stack);
    }

//    @SubscribeEvent
//    public static void onPlayerLeftClicking(PlayerInteractEvent.LeftClickBlock event) {
//        drill_active = true;
//        isLeftClicking = true;
//    }

    @SubscribeEvent
    public static void onPlayerStoppedLeftClicking(InputEvent.MouseInputEvent event) {
        GameSettings gs = Minecraft.getMinecraft().gameSettings;
        if (gs.keyBindAttack.isKeyDown()) // add your additional conditions here
        {
            drill_active = true;
        }
        else
        {
            drill_active = false;
        }
    }

//    @SubscribeEvent
//    public static void blockDestroyed(BlockEvent.BreakEvent event)
//    {
//        drill_active = false;
//    }
}