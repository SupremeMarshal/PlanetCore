package com.SupremeMarshal.ToTheEarthCore.items.shields;

import com.SupremeMarshal.ToTheEarthCore.Main;
import com.SupremeMarshal.ToTheEarthCore.init.ModItems;
import com.SupremeMarshal.ToTheEarthCore.util.IHasModel;
import net.minecraft.block.BlockDispenser;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.*;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import javax.annotation.Nullable;


public class ShieldBase extends ItemShield implements IHasModel

         {

             public ShieldBase(String name)
             {
                 super();
                 this.setTranslationKey(name);
                 this.setRegistryName(name);
                 this.maxStackSize = 1;
                 this.setCreativeTab(CreativeTabs.COMBAT);
                 this.setMaxDamage(5);
                 ModItems.ITEMS.add(this);
                 this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter()

                 {
                     @SideOnly(Side.CLIENT)
                     public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn)
                     {
                         return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
                     }
                 });
                 BlockDispenser.DISPENSE_BEHAVIOR_REGISTRY.putObject(this, ItemArmor.DISPENSER_BEHAVIOR);

             }


             @Override
             public void registerModels()
             {
                 Main.proxy.registerModel(this, 0);
             }


             public static boolean isUsable(ItemStack stack) {

                 return stack.getItemDamage()<stack.getMaxDamage();

             }

             @Override
             public boolean isShield(ItemStack stack, @Nullable EntityLivingBase entity)
             {
                 return true;
             }


             /**
              * returns the action that specifies what animation to play when the items is being used
              */
             public EnumAction getItemUseAction(ItemStack stack)
             {
                 return EnumAction.BLOCK;
             }

             /**
              * How long it takes to use or consume an item
              */
             public int getMaxItemUseDuration(ItemStack stack)
             {
                 return 72000;
             }

             /**
              * Called when the equipped item is right clicked.
              */
             @Override

             public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn,

                                                             EnumHand handIn) {

                 ItemStack itemstack = playerIn.getHeldItem(handIn);

                 if (isUsable(itemstack)) {

                     playerIn.setActiveHand(handIn);

                     return new ActionResult<ItemStack>(EnumActionResult.SUCCESS, itemstack);

                 } else {

                     return new ActionResult<ItemStack>(EnumActionResult.FAIL, itemstack);

                 }

             }

             /**
              * Return whether this item is repairable in an anvil.
              *
              * @param toRepair the {@code ItemStack} being repaired
              * @param repair the {@code ItemStack} being used to perform the repair
              */

         }