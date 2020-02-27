package com.SupremeMarshal.ToTheEarthCore.util.handlers;

import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import java.util.Random;

@Mod.EventBusSubscriber(modid="planetcore")
public class PlayerTickEventHandler {

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event)
    {

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
            event.player.attackEntityFrom(DamageSource.LAVA, (float) (-1*event.player.posY/1000));
            //every A seconds, 1/10 chance to burn player for B seconds below -1k Y.
            //A = (1 minute/(latitude+500)*-500);  (-1k Y = 1-5 minute,  -2k Y = 20-100 seconds, -5k = 6.67-33 seconds, -10k = 3.16-15.8 seconds.)
            //B = (latitude/-100-9); (At -1k latitude, burn for 2 second. at -1500, burn for 6 seconds. At -5k, burn for 41 seconds.
            //Damage = 5 damage every 1k distance downward. Starting at -1k. -2k = 10 damages, -5k = 25 damages, -10k = 50 damages.

        }
    }
}
