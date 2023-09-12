package com.PlanetCore.util.handlers;
import com.PlanetCore.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.client.audio.Sound;
import net.minecraft.client.audio.SoundEventAccessor;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.SoundEvent;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.client.event.sound.SoundLoadEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.spongepowered.asm.mixin.gen.Accessor;

import java.util.Random;

import static com.PlanetCore.util.handlers.SoundHandler.*;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class MusicHandler {
//    private static boolean isMusicPlaying = false;
//    private static int startTick;
//    private static boolean crust_range = false;
//    private static boolean mantle_range = false;
//    private static float Y;
//    private static ISound selectedSound;
//    private static int randomIndex;
//    private static Random rand;
//    static ISound[] crust_soundtracks = {
//            new PositionedSoundRecord(CRUST_MUSIC.getSoundName(), SoundCategory.MUSIC, 1.0F, 1.0F, false, 0, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F),
//            new PositionedSoundRecord(CRUST1_MUSIC.getSoundName(), SoundCategory.MUSIC, 1.0F, 1.0F, false, 0, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F),
//            new PositionedSoundRecord(CRUST2_MUSIC.getSoundName(), SoundCategory.MUSIC, 1.0F, 1.0F, false, 0, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F)
//    };
//
//    static ISound[] mantle_soundtracks = {
//            new PositionedSoundRecord(MANTLE_MUSIC.getSoundName(), SoundCategory.MUSIC, 1.0F, 1.0F, false, 0, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F),
//            new PositionedSoundRecord(MANTLE1_MUSIC.getSoundName(), SoundCategory.MUSIC, 1.0F, 1.0F, false, 0, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F),
//            new PositionedSoundRecord(MANTLE1_1_MUSIC.getSoundName(), SoundCategory.MUSIC, 1.0F, 1.0F, false, 0, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F),
//            new PositionedSoundRecord(MANTLE2_MUSIC.getSoundName(), SoundCategory.MUSIC, 1.0F, 1.0F, false, 0, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F),
//            new PositionedSoundRecord(MANTLE2_1_MUSIC.getSoundName(), SoundCategory.MUSIC, 1.0F, 1.0F, false, 0, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F)
//    };
//    @SubscribeEvent
//    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
//        Y = (float) event.player.posY;
//          // Selects a random soundtrack
//
//
//        if (!event.player.isCreative() && !event.player.isSpectator() && (Y >= 0 || Y < -256))
//        {
//            crust_range = false;
//        }
//        if (!event.player.isCreative() && !event.player.isSpectator() && (Y >= -256 || Y < -768))
//        {
//            mantle_range = false;
//        }
//        if (!event.player.isCreative() && !event.player.isSpectator() && (Y >= -256 || Y < -768))
//        {
//            mantle_range = false;
//        }
//
//        if (event.phase != TickEvent.Phase.END) return;
//
//        //Check if player is in survival and below 0Y
//        if (!event.player.isCreative() && !event.player.isSpectator() && Y < 0 && Y >= -256) {
//            crust_range = true;
//            //If the music is no longer playing, play the music
//            if (!isMusicPlaying) {
//                isMusicPlaying = true;
//                rand = new Random();
//                randomIndex = rand.nextInt(crust_soundtracks.length);  // Generates a random index
//                selectedSound = crust_soundtracks[randomIndex];
//                Minecraft.getMinecraft().getSoundHandler().playSound(selectedSound);
//                startTick = event.player.ticksExisted;
//            }
//        }
//        else if (!event.player.isCreative() && !event.player.isSpectator() && event.player.posY < -256 && event.player.posY >= -1024) {
//            mantle_range = true;
//            //If the music is no longer playing, play the music
//            if (!isMusicPlaying) {
//                isMusicPlaying = true;
//                rand = new Random();
//                randomIndex = rand.nextInt(mantle_soundtracks.length);  // Generates a random index
//                selectedSound = mantle_soundtracks[randomIndex];
//                Minecraft.getMinecraft().getSoundHandler().playSound(selectedSound);
//                startTick = event.player.ticksExisted;
//            }
//        }
//
//        //TODO: Check for music length in tick and add 2000 ticks to it.
//        if (isMusicPlaying && (event.player.ticksExisted - startTick >= 10000)) {
//            isMusicPlaying = false;
//        }
//    }
//
//
//    @SubscribeEvent
//    public static void onSoundPlay(PlaySoundEvent event) {
//        //if player is below 0Y and minecraft music try to play, prevent it.
//        if (event.getSound().getCategory() == SoundCategory.MUSIC)
//        {
//            isMusicPlaying = true;
//        }
//
//        if (isMusicPlaying && crust_range && !event.getName().contains("crust") && event.getSound().getCategory() == SoundCategory.MUSIC) {
//            event.setResultSound(null);
//        }
//        if (isMusicPlaying && mantle_range && !event.getName().contains("mantle") && event.getSound().getCategory() == SoundCategory.MUSIC) {
//            event.setResultSound(null);
//        }
//        //if player is above 0Y and planetcore music try to play, prevent it.
//        if (isMusicPlaying && !crust_range && event.getName().contains("crust") && event.getSound().getCategory() == SoundCategory.MUSIC) {
//            event.setResultSound(null);
//        }
//        if (isMusicPlaying && !mantle_range && event.getName().contains("mantle") && event.getSound().getCategory() == SoundCategory.MUSIC) {
//            event.setResultSound(null);
//        }
//    }
}