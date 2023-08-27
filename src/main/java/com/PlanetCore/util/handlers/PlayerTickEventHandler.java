package com.PlanetCore.util.handlers;

import com.PlanetCore.util.Reference;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;

import static com.PlanetCore.util.handlers.TemperatureHandler.calcTemp;
import static com.PlanetCore.util.handlers.TemperatureHandler.getDamage;

@Mod.EventBusSubscriber(modid= Reference.MOD_ID)
public class PlayerTickEventHandler {

    public static final DamageSource OVERHEAT = new DamageSource("planetcore.overheat");

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {

        EntityPlayer player = event.player;
        if (!"PlanetCore".equals(player.getEntityWorld().getWorldType().getName())) return;

        if (!player.getEntityWorld().isRemote) {
            PotionEffect effect = player.getActivePotionEffect(MobEffects.FIRE_RESISTANCE);
            int fireResist = effect == null ? 0 : effect.getAmplifier() + 1;
            double y = event.player.posY;
            double temp = calcTemp(y, player.dimension);
            double damage = getDamage(temp,fireResist);
            int dimension = player.dimension;
            if (damage > 0 && damage <= 2 && player.world.getTotalWorldTime() % 300 == 1)
                TemperatureHandler.tickTemps(event.player, dimension);
            else if (damage > 2)
            {
                TemperatureHandler.tickTemps(event.player, dimension);
            }
        }
    }
}