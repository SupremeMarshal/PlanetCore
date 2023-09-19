package com.PlanetCore.util.handlers;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Enchantments;
import net.minecraft.item.ItemStack;
import net.minecraft.scoreboard.Score;
import net.minecraft.scoreboard.ScoreCriteria;
import net.minecraft.scoreboard.ScoreObjective;
import net.minecraft.scoreboard.Scoreboard;
import net.minecraftforge.event.world.BlockEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.relauncher.Side;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class scoreEvent {

    private HashMap<String, Integer> offlinePlayerScores;
    File saveFileDirectory = new File(FMLCommonHandler.instance().getSavesDirectory(), "planetcore");
    File saveFile = new File(saveFileDirectory, "scoreboard.json");
    private final Gson gson = new Gson();

    public scoreEvent() {
        // Initialize or load saved scores
        loadScores();
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        if (event.getState().getBlock() instanceof Block) {
            // Get player and scoreboard
            EntityPlayer player = event.getPlayer();
            ItemStack heldItem = player.getHeldItemMainhand();
            IBlockState blockState = event.getState();
            if (EnchantmentHelper.getEnchantmentLevel(Enchantments.SILK_TOUCH, heldItem) > 0 || player.isCreative()) {
                // Player has Silk Touch or is in creative don't award points
                return;
            }
            Scoreboard scoreboard = player.getWorldScoreboard();
            // Initialize the score objective
            ScoreObjective objective = scoreboard.getObjective("planetcore_score");
            if (objective == null) {
                objective = scoreboard.addScoreObjective("planetcore_score", ScoreCriteria.DUMMY);
            }

            float hardness = blockState.getBlockHardness(event.getWorld(), event.getPos());
            float harvestLevel = blockState.getBlock().getHarvestLevel(blockState);
            int points = (int) (hardness * (harvestLevel + 1));



            // Get the Score instance for the player and objective
            Score score = scoreboard.getOrCreateScore(player.getName(), objective);

            // Update score
            int newScore = score.getScorePoints() + points;
            score.setScorePoints(newScore);
            displayScoreboard(event.getPlayer());
        }
    }

    private int tickCount = 0;
    @SubscribeEvent
    public void onTick(TickEvent.ServerTickEvent event) {
        if (event.phase == TickEvent.Phase.END && event.side == Side.SERVER) {
            tickCount++;
            if (tickCount % 200 == 0) {
                // Get a list of all online player names
                List<String> onlinePlayerNames = FMLCommonHandler.instance().getMinecraftServerInstance()
                        .getPlayerList().getPlayers().stream().map(EntityPlayer::getName).collect(Collectors.toList());

                Scoreboard scoreboard = FMLCommonHandler.instance().getMinecraftServerInstance().getWorld(0)
                        .getScoreboard();
                ScoreObjective objective = scoreboard.getObjective("planetcore_score");

                // If the objective doesn't exist, return
                if (objective == null) {
                    return;
                }

                // Get all scores and filter those relevant to our objective
                Collection<Score> allScores = scoreboard.getScores();
                List<Score> relevantScores = allScores.stream()
                        .filter(score -> score.getObjective().getName().equals("planetcore_score"))
                        .collect(Collectors.toList());

                // Remove all players from the scoreboard who are not currently online
                for (Score score : relevantScores) {
                    if (!onlinePlayerNames.contains(score.getPlayerName())) {
                        scoreboard.removeObjectiveFromEntity(score.getPlayerName(), objective);
                    }
                }

                // Update the display for all currently online players
                for (EntityPlayerMP player : FMLCommonHandler.instance().getMinecraftServerInstance()
                        .getPlayerList().getPlayers()) {
                    displayScoreboard(player);
                }
            }
        }
    }






    public void displayScoreboard(EntityPlayer player) {
        Scoreboard scoreboard = player.getWorldScoreboard();
        ScoreObjective objective = scoreboard.getObjective("planetcore_score");

        scoreboard.setObjectiveInDisplaySlot(1, objective); // 1 corresponds to the sidebar
    }

    @SubscribeEvent
    public void onPlayerLogout(PlayerEvent.PlayerLoggedOutEvent event) {
        EntityPlayer player = event.player;
        Scoreboard scoreboard = player.getWorldScoreboard();
        String playerName = player.getName();

        // Save the player's score to the HashMap before removing them
        ScoreObjective objective = scoreboard.getObjective("planetcore_score");
        if (objective != null) {
            Score score = scoreboard.getOrCreateScore(playerName, objective);
            offlinePlayerScores.put(playerName, score.getScorePoints());
        }

        // Save to disk
        saveScores();

        removePlayerFromScores(scoreboard, playerName);
    }

    public void removePlayerFromScores(Scoreboard scoreboard, String playerName) {
        // Get all objectives
        Collection<ScoreObjective> objectives = scoreboard.getScoreObjectives();

        // Loop through each objective and remove the player's score from each one
        for (ScoreObjective objective : objectives) {
            // Remove the player's score from the current objective
            scoreboard.removeObjectiveFromEntity(playerName, objective);
        }
    }

    public void addPlayerToScore(Scoreboard scoreboard, String playerName, String objectiveName) {
        ScoreObjective objective = scoreboard.getObjective(objectiveName);

        // If the objective doesn't exist, return
        if (objective == null) {
            return;
        }

        // Check if we have a stored score for this player
        Integer storedScore = offlinePlayerScores.getOrDefault(playerName, 0);

        // Add the player's score back to the scoreboard
        Score score = scoreboard.getOrCreateScore(playerName, objective);
        score.setScorePoints(storedScore);
    }

    @SubscribeEvent
    public void onPlayerJoin(PlayerEvent.PlayerLoggedInEvent event) {
        EntityPlayer player = event.player;
        Scoreboard scoreboard = player.getWorldScoreboard();
        addPlayerToScore(scoreboard, player.getName(), "planetcore_score");
    }

    // Existing methods...
    // ...

    public void saveScores() {
        if (!saveFileDirectory.exists()) {
            saveFileDirectory.mkdirs();
        }
        try (FileWriter writer = new FileWriter(saveFile)) {
            gson.toJson(offlinePlayerScores, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadScores() {
        if (!saveFileDirectory.exists()) {
            saveFileDirectory.mkdirs();
        }
        try (FileReader reader = new FileReader(saveFile)) {
            Type type = new TypeToken<HashMap<String, Integer>>() {}.getType();
            offlinePlayerScores = gson.fromJson(reader, type);
            if (offlinePlayerScores == null) {
                offlinePlayerScores = new HashMap<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
            offlinePlayerScores = new HashMap<>();
        }
    }
}