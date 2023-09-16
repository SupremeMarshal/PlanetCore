package com.PlanetCore.util.handlers;
import com.PlanetCore.util.Reference;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.audio.PositionedSoundRecord;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

import java.util.Arrays;
import java.util.Random;

import static com.PlanetCore.util.handlers.SoundHandler.*;

@SideOnly(Side.CLIENT)
@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class MusicHandler extends MusicTicker {

    private static int randomIndex;
    private static ISound selectedSound;
    private final Random rand;
    private final Minecraft mc;
    private ISound currentMusic;
    private int timeUntilNextMusic = 100;
    static ISound[] crust_soundtracks = {
            new PositionedSoundRecord(CRUST_MUSIC.getSoundName(), SoundCategory.MUSIC, 1.0F, 1.0F, false, 0, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F),
            new PositionedSoundRecord(CRUST1_MUSIC.getSoundName(), SoundCategory.MUSIC, 1.0F, 1.0F, false, 0, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F),
            new PositionedSoundRecord(CRUST2_MUSIC.getSoundName(), SoundCategory.MUSIC, 1.0F, 1.0F, false, 0, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F)
    };

    static ISound[] mantle_soundtracks = {
            new PositionedSoundRecord(MANTLE_MUSIC.getSoundName(), SoundCategory.MUSIC, 1.0F, 1.0F, false, 0, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F),
            new PositionedSoundRecord(MANTLE1_MUSIC.getSoundName(), SoundCategory.MUSIC, 1.0F, 1.0F, false, 0, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F),
            new PositionedSoundRecord(MANTLE1_1_MUSIC.getSoundName(), SoundCategory.MUSIC, 1.0F, 1.0F, false, 0, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F),
            new PositionedSoundRecord(MANTLE2_MUSIC.getSoundName(), SoundCategory.MUSIC, 1.0F, 1.0F, false, 0, ISound.AttenuationType.NONE, 0.0F, 0.0F, 0.0F)
    };

    public MusicHandler(Minecraft mcIn) {
        super(mcIn);
        this.mc = mcIn;
        this.rand = new Random();
    }

    @Override
    public void update() {
        MusicTicker.MusicType musicticker$musictype = this.mc.getAmbientMusicType();
        double Y = 64; 
        boolean flag = false;
        //this.timeUntilNextMusic--;
        if (this.mc.player != null) {
            Y = this.mc.player.posY;
            flag = !mc.player.isCreative() && !mc.player.isSpectator();
        }
        if (this.currentMusic != null && !musicticker$musictype.getMusicLocation().getSoundName().equals(this.currentMusic.getSoundLocation()) &&
                !Arrays.asList(crust_soundtracks).contains(this.currentMusic) && !Arrays.asList(mantle_soundtracks).contains(this.currentMusic)) {
            this.mc.getSoundHandler().stopSound(this.currentMusic);
            this.timeUntilNextMusic = MathHelper.getInt(this.rand, 0, musicticker$musictype.getMinDelay() / 2);
        }
        if (Y <= 0 && Y > -100 && flag) {
            if (this.currentMusic != null && !this.mc.getSoundHandler().isSoundPlaying(this.currentMusic)) {
                this.currentMusic = null;
                this.timeUntilNextMusic = Math.min(MathHelper.getInt(this.rand, musicticker$musictype.getMinDelay(), musicticker$musictype.getMaxDelay()), this.timeUntilNextMusic);
            }
            this.timeUntilNextMusic = Math.min(this.timeUntilNextMusic, musicticker$musictype.getMaxDelay());

            if (this.currentMusic == null && this.timeUntilNextMusic-- <= 0) {
                this.playMusic(musicticker$musictype);
            }
        }
        else if (Y <= -100 && flag) {
                if (this.currentMusic != null && !this.mc.getSoundHandler().isSoundPlaying(this.currentMusic)) {
                    this.currentMusic = null;
                    this.timeUntilNextMusic = Math.min(MathHelper.getInt(this.rand, musicticker$musictype.getMinDelay(), musicticker$musictype.getMaxDelay()), this.timeUntilNextMusic);
                }
            this.timeUntilNextMusic = Math.min(this.timeUntilNextMusic, musicticker$musictype.getMaxDelay());

            if (this.currentMusic == null && this.timeUntilNextMusic-- <= 0) {
                this.playMusic(musicticker$musictype);
            }
        }
        else {

            if (this.currentMusic != null) {

                if (!this.mc.getSoundHandler().isSoundPlaying(this.currentMusic)) {
                    this.currentMusic = null;
                    this.timeUntilNextMusic = Math.min(MathHelper.getInt(this.rand, musicticker$musictype.getMinDelay(), musicticker$musictype.getMaxDelay()), this.timeUntilNextMusic);
                }
            }

        }
        this.timeUntilNextMusic = Math.min(this.timeUntilNextMusic, musicticker$musictype.getMaxDelay());

        if (this.currentMusic == null && this.timeUntilNextMusic-- <= 0) {
            this.playMusic(musicticker$musictype);
        }
    }

    @Override
    public void playMusic(MusicTicker.MusicType requestedMusicType) {
        double Y = 64;
        if (this.mc.player != null) {
            Y = this.mc.player.posY;
        }

        if (Y <= 0) {
            if (Y > -256) {
                // Play crust music
                randomIndex = rand.nextInt(crust_soundtracks.length);
                selectedSound = crust_soundtracks[randomIndex];
            } else {
                // Play mantle music
                randomIndex = rand.nextInt(mantle_soundtracks.length);
                selectedSound = mantle_soundtracks[randomIndex];
            }

            this.currentMusic = selectedSound;
            this.mc.getSoundHandler().playSound(this.currentMusic);
            this.timeUntilNextMusic = 5000 + rand.nextInt(5000);
            return;
        }

        // The existing logic for when Y > 0, typically you'd play Minecraft's default music here
        this.currentMusic = PositionedSoundRecord.getMusicRecord(requestedMusicType.getMusicLocation());
        this.mc.getSoundHandler().playSound(this.currentMusic);
        this.timeUntilNextMusic = 5000 + rand.nextInt(5000);
    }
}