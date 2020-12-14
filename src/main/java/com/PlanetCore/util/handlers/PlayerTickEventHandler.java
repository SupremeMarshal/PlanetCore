package com.PlanetCore.util.handlers;

import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Random;

@Mod.EventBusSubscriber(modid="planetcore")
public class PlayerTickEventHandler {

    /*
    @SubscribeEvent
    public void onPlayerClone(PlayerEvent.Clone event) {
        EntityPlayer player = event.getEntityPlayer();
        IUserSettings cap = player.getCapability(UserSettingsStorageProvider.SETTINGS_CAP, null);
        IUserSettings old = event.getOriginal().getCapability(UserSettingsStorageProvider.SETTINGS_CAP, null);

        cap.setHeatResistance(old.getHeatResistance());
    }

    @SubscribeEvent
    public static void onPlayerEquip(LivingEquipmentChangeEvent.LivingUpdateEvent event) {
        Entity entity = event.getEntityLiving();
        IUserSettings cap = entity.getCapability(UserSettingsStorageProvider.SETTINGS_CAP, null);
        if (((EntityLivingBase) entity).getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() == ModItems.AEROGEL_GOLD_HELMET || cap != null)
        {
            cap.setHeatResistance(5);
            System.out.println(cap.getHeatResistance());
        }
    }
    */

    @SideOnly(Side.CLIENT)
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        //Heal player based on food level. Heal from 0% to 100% in 600 seconds at max food lvl. Heal fully in 3 hours if food level is 1. At 0 food, player stop healing.
        if (event.player.getFoodStats().getFoodLevel() >= 1) {
        if (event.player.world.getTotalWorldTime() % 20 != 1) {
            return;
        }
        event.player.heal(event.player.getMaxHealth() / (12000 / event.player.getFoodStats().getFoodLevel()));
        }


        int x,y,z;
        x = event.player.getPosition().getX();
        y = event.player.getPosition().getY();
        z = event.player.getPosition().getZ();
        Iterable<BlockPos> it = BlockPos.getAllInBox(x - 2, y - 2, z - 2, x + 2, y + 2, z + 2);
        int randomLava = new Random().nextInt(60) + 1;
        if (randomLava == 1) {
            for (BlockPos pos1 : it) {
                IBlockState state2 = event.player.world.getBlockState(pos1);
                if (state2.getMaterial() == Material.LAVA) {
                    event.player.setFire(5);
                }
            }
            for (BlockPos pos1 : it) {
                IBlockState state2 = event.player.world.getBlockState(pos1);
                if (state2.getBlock() == ModBlocks.HOT_LAVA_FLUID) {
                    event.player.setFire(15);
                }
            }
        }


        int random = new Random().nextInt(5)+1;
        if (event.player.posY < -600)
        {
            if (event.player.world.getTotalWorldTime() % (int)(-600000*random/(event.player.posY+500)) != 1)
            {
                return;
            }
            if (!event.player.isImmuneToFire()) {
                event.player.setFire((int)(event.player.posY/-250));
            }
            event.player.attackEntityFrom(DamageSource.LAVA, (float) (-1*event.player.posY/500));
            //every A seconds, 1/10 chance to burn player for B seconds below -1k Y.
            //A = (1 minute/(latitude+500)*-500);  (-1k Y = 1-5 minute,  -2k Y = 20-100 seconds, -5k = 6.67-33 seconds, -10k = 3.16-15.8 seconds.)
            //B = (latitude/-100-9); (At -1k latitude, burn for 2 second. at -1500, burn for 6 seconds. At -5k, burn for 41 seconds.
            //Damage = 5 damage every 1k distance downward. Starting at -1k. -2k = 10 damages, -5k = 25 damages, -10k = 50 damages.

        }
    }


}
