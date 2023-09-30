package com.PlanetCore.util.handlers;

import com.PlanetCore.blocks.Powered_ladders.IronLadderBlock;
import com.PlanetCore.client.GuiTutorialBook;
import com.PlanetCore.init.ModBlocks;
import com.PlanetCore.items.Drills.IronDrillItem;
import com.PlanetCore.items.ItemPickaxeX;
import com.PlanetCore.items.armor.ArmorBase;
import com.PlanetCore.items.shields.Shield;
import com.PlanetCore.util.Reference;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.ISound;
import net.minecraft.client.audio.MusicTicker;
import net.minecraft.client.entity.EntityPlayerSP;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Enchantments;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.*;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.client.event.InputUpdateEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.RenderBlockOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.sound.PlaySoundEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import software.bernie.geckolib3.core.controller.AnimationController;
import software.bernie.geckolib3.util.GeckoLibUtil;

import java.lang.reflect.Field;

import static com.PlanetCore.util.Reference.MOD_ID;

@Mod.EventBusSubscriber(Side.CLIENT)
public class ClientHandler {

    @SubscribeEvent
    public static void addTooltips(ItemTooltipEvent event) {
        if (event.getEntityPlayer() != null) {
            ItemStack stack = event.getItemStack();
            EntityPlayer player = event.getEntityPlayer();
            if (stack.getItem() instanceof ItemPickaxe || stack.getDisplayName().contains("ickaxe")) {
                float efficiency = event.getItemStack().getDestroySpeed(Blocks.STONE.getDefaultState());
                float relentless = PickaxeRelentlessHandler.getRelentless(stack);
                Item item = stack.getItem();
                ItemTool toolItem = (ItemTool) item;
                IBlockState blockState = Blocks.STONE.getDefaultState();
                String toolClass = blockState.getBlock().getHarvestTool(blockState);
                int tierLevel = toolItem.getHarvestLevel(stack, toolClass, player, blockState);

                if (stack.getItem() instanceof ItemPickaxeX) {
                    event.getToolTip().add("Tier level: §9" + tierLevel);
                }
                event.getToolTip().add("Efficiency: §9" + efficiency);
                event.getToolTip().add("Relentless: §9" + relentless);


            }

            if (stack.getItem() instanceof ItemArmor && isItemInArmorSlot(stack, player)) {

                float toughness = (float) player.getEntityAttribute(SharedMonsterAttributes.ARMOR_TOUGHNESS).getAttributeValue();
                float armor = (float) player.getEntityAttribute(SharedMonsterAttributes.ARMOR).getAttributeValue();
                event.getToolTip().add("Total damage reduction:");

                ItemStack helmet = player.getItemStackFromSlot(EntityEquipmentSlot.HEAD);
                ItemStack chestplate = player.getItemStackFromSlot(EntityEquipmentSlot.CHEST);
                ItemStack leggings = player.getItemStackFromSlot(EntityEquipmentSlot.LEGS);
                ItemStack boots = player.getItemStackFromSlot(EntityEquipmentSlot.FEET);
                ItemStack shield = player.getItemStackFromSlot(EntityEquipmentSlot.OFFHAND);

                float helmetArmor = 0;
                float chestArmor = 0;
                float legsArmor = 0;
                float bootsArmor = 0;

                float helmetExtraArmor = 0;
                float chestExtraArmor = 0;
                float legsExtraArmor = 0;
                float bootsExtraArmor = 0;
                float shieldExtraArmor = 0;

                if (helmet.getItem() instanceof ArmorBase)
                    helmetExtraArmor = ((ArmorBase) helmet.getItem()).extraArmor;
                if (chestplate.getItem() instanceof ArmorBase)
                    chestExtraArmor = ((ArmorBase) chestplate.getItem()).extraArmor;
                if (leggings.getItem() instanceof ArmorBase)
                    legsExtraArmor = ((ArmorBase) leggings.getItem()).extraArmor;
                if (boots.getItem() instanceof ArmorBase)
                    bootsExtraArmor = ((ArmorBase) boots.getItem()).extraArmor;
                if (shield.getItem() instanceof Shield)
                    shieldExtraArmor = ((Shield) shield.getItem()).extraArmor;

                if (helmet.getItem() instanceof ItemArmor)
                    helmetArmor = ((ItemArmor) helmet.getItem()).damageReduceAmount;
                if (chestplate.getItem() instanceof ItemArmor)
                    chestArmor = ((ItemArmor) chestplate.getItem()).damageReduceAmount;
                if (leggings.getItem() instanceof ItemArmor)
                    legsArmor = ((ItemArmor) leggings.getItem()).damageReduceAmount;
                if (boots.getItem() instanceof ItemArmor)
                    bootsArmor = ((ItemArmor) boots.getItem()).damageReduceAmount;

                int helmetProtection = EnchantmentHelper.getEnchantmentLevel(Enchantments.PROTECTION, helmet);
                int chestProtection = EnchantmentHelper.getEnchantmentLevel(Enchantments.PROTECTION, chestplate);
                int legsProtection = EnchantmentHelper.getEnchantmentLevel(Enchantments.PROTECTION, leggings);
                int bootsProtection = EnchantmentHelper.getEnchantmentLevel(Enchantments.PROTECTION, boots);

                helmetArmor += (helmetArmor + helmetExtraArmor) * ((helmetProtection) * 0.25);
                chestArmor += (chestArmor + chestExtraArmor) * ((chestProtection) * 0.25);
                legsArmor += (legsArmor + legsExtraArmor) * ((legsProtection) * 0.25);
                bootsArmor += (bootsArmor + bootsExtraArmor) * ((bootsProtection) * 0.25);

                // Calculate the total extra armor value
                float totalExtraArmor = (helmetArmor + chestArmor + legsArmor + bootsArmor + shieldExtraArmor);

                float totalArmor = toughness + totalExtraArmor;
                // Check for Resistance effect
                PotionEffect resistanceEffect = player.getActivePotionEffect(MobEffects.RESISTANCE);
                int amplifier = 0;
                // Get enchantment levels from each armor piece

                if (resistanceEffect != null) {
                    amplifier = resistanceEffect.getAmplifier();
                    totalArmor += totalArmor * ((amplifier + 1) * 0.25); // 20% more armor for each level of Resistance
                }
                // Modify damage reduction calculation here
                //damage_done * 1 - (((armor)*0.06)/(1+0.06*(armor))

                float modifiedDamage = (float) (((totalArmor) * 0.09) / (float) (1 + 0.09 * (totalArmor)));
                event.getToolTip().add("§9" + String.format("%.2f", modifiedDamage * 100) + "%");
            }
        }
    }

    private static boolean isItemInArmorSlot(ItemStack itemStack, EntityPlayer player) {
        for (EntityEquipmentSlot slot : EntityEquipmentSlot.values()) {
            if (player.getItemStackFromSlot(slot) == itemStack && slot != EntityEquipmentSlot.MAINHAND && slot != EntityEquipmentSlot.OFFHAND) {
                return true;
            }
        }
        return false;
    }

    @SubscribeEvent
    public static void trackLeftClick(InputUpdateEvent e) {
        boolean attacking = Minecraft.getMinecraft().gameSettings.keyBindAttack.isKeyDown();
        ItemStack stack = Minecraft.getMinecraft().player.getHeldItemMainhand();
        if (stack.getItem() instanceof IronDrillItem) {
            IronDrillItem ironDrillItem = (IronDrillItem) stack.getItem();
            AnimationController<?> controller =
                    GeckoLibUtil.getControllerForStack(ironDrillItem.getFactory(), stack, IronDrillItem.CTRL_NAME);
            if (attacking) {
                controller.setAnimation(IronDrillItem.ACTIVE_DRILL);
            } else {
                controller.setAnimation(IronDrillItem.INACTIVE_DRILL);
            }
        }
    }

    static final int TEX_WIDTH = 48;
    static final int TEX_HEIGHT = 24;

    @SubscribeEvent
    public static void temperatureHud(RenderGameOverlayEvent.Post event) {
        if (event.getType() == RenderGameOverlayEvent.ElementType.ALL) {
            Minecraft minecraft = Minecraft.getMinecraft();
            EntityPlayer player = minecraft.player;
            int dimension = player.dimension;
            if (player != null) {
                double y = player.posY;
                if (y < 0 || dimension == -1) {
                    int temp = (int) TemperatureHandler.calcTemp(y, dimension);
                    PotionEffect effect = player.getActivePotionEffect(MobEffects.FIRE_RESISTANCE);
                    int fireResist = effect == null ? 0 : effect.getAmplifier() + 1;
                    int limit = TemperatureHandler.getLimit(fireResist);

                    Heat heat = Heat.SAFE;

                    if (temp >= limit) {
                        heat = Heat.DANGER;
                    } else if (limit - temp < limit - (limit / 1.2)) {
                        heat = Heat.WARN;
                    }

                    String s = temp + " C";

                    int textWidth = minecraft.fontRenderer.getStringWidth(s);

                    int x1 = event.getResolution().getScaledWidth() / 2 - TEX_WIDTH / 2;
                    int x2 = x1 + TEX_WIDTH / 2 - textWidth / 2;
                    int y1 = 0;


                    minecraft.getTextureManager().bindTexture(heat.tex);

                    Gui.drawModalRectWithCustomSizedTexture(x1, y1, 0, 0, TEX_WIDTH, TEX_HEIGHT, TEX_WIDTH, TEX_HEIGHT);
                    minecraft.fontRenderer.drawString(s, x2, y1 + 11, heat.color, true);
                }
            }
        }
    }

    enum Heat {
        SAFE(0x00ff00, new ResourceLocation(Reference.MOD_ID, "textures/gui/temp_gui.png")),
        WARN(0xffff00, new ResourceLocation(Reference.MOD_ID, "textures/gui/temp_gui_hot.png")),
        DANGER(0xff0000, new ResourceLocation(Reference.MOD_ID, "textures/gui/temp_gui_superheated.png"));
        final int color;
        final ResourceLocation tex;

        Heat(int color, ResourceLocation tex) {
            this.color = color;
            this.tex = tex;
        }
    }

    @SubscribeEvent
    public static void playSound(PlaySoundEvent e) {
        EntityPlayer player = Minecraft.getMinecraft().player;

        if (player != null) {
            ItemStack stack = player.getHeldItemMainhand();
            if (stack.getItem() instanceof IronDrillItem) {
                ISound sound = e.getSound();
                ResourceLocation rl = sound.getSoundLocation();
                if (rl.getPath().endsWith("hit")) {
                    e.setResultSound(null);
                }
            }
        }
    }

    @SubscribeEvent
    public static void overlay(RenderBlockOverlayEvent e) {
        RenderBlockOverlayEvent.OverlayType overlayType = e.getOverlayType();
        if (overlayType == RenderBlockOverlayEvent.OverlayType.FIRE) {
            EntityPlayer player = e.getPlayer();
            int dimension = player.dimension;
            if (player.isBurning()) {
                PotionEffect effect = player.getActivePotionEffect(MobEffects.FIRE_RESISTANCE);
                int fireResist = effect == null ? 0 : effect.getAmplifier() + 1;
                if (fireResist == 0) return;
                double y = player.posY;
                double temp = TemperatureHandler.calcTemp(y, dimension);
                double damage = TemperatureHandler.getDamage(temp, fireResist);
                if (damage <= 0) {
                    e.setCanceled(true);
                }
            }
        }
    }

    @SubscribeEvent
    public static void onModelRegister(ModelRegistryEvent event) {

        ForgeRegistries.ITEMS.getValues().stream()
                .filter(item -> MOD_ID.equals(item.getRegistryName().getNamespace())).forEach(item -> {
                    if (!item.getHasSubtypes()) {
                        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
                    }
                });

        RenderHandler.registerEntityRenders();
        RenderHandler.registerCustomMeshesAndStates();
        ModBlocks.registerRenders();
    }

    public static void hijackMusicTicker() {
        MusicHandler customMusicTicker = new MusicHandler(Minecraft.getMinecraft());
        try {
            // Use reflection to get the Minecraft class type

            // Locate the field for the MusicTicker
            Field musicTickerField = null;
            for (Field field : Minecraft.class.getDeclaredFields()) {
                if (field.getType().equals(MusicTicker.class)) {
                    musicTickerField = field;
                    break;
                }
            }

            // Make it accessible (it's likely a private field)
            if (musicTickerField != null) {
                musicTickerField.setAccessible(true);

                // Replace the MusicTicker instance
                musicTickerField.set(Minecraft.getMinecraft(), customMusicTicker);
            } else {
                // Log an error if the field is not found (this should not happen)
                // Replace this with your mod's logging system
                System.out.println("Error: Could not find the MusicTicker field.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static boolean wasOnElevator = false;
    private static long lastElevatorTime = 0L;

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.ClientTickEvent event) {
        if (event.phase == TickEvent.Phase.END) {
            EntityPlayerSP player = Minecraft.getMinecraft().player;
            if (player == null) return;
            boolean isPowered = false;
            boolean isOnElevator = player.world.getBlockState(new BlockPos(player.posX, player.posY, player.posZ)).getBlock() instanceof IronLadderBlock;
            IBlockState state = player.world.getBlockState(new BlockPos(player.posX, player.posY, player.posZ));
            if (state.getBlock() instanceof IronLadderBlock) {
                isPowered = state.getValue(IronLadderBlock.POWERED);
            }
            double elevatorSpeed = 0.2;
            if (isPowered) {
                elevatorSpeed = 1;
            }
            if (isOnElevator) {
                wasOnElevator = true;
                lastElevatorTime = System.currentTimeMillis();
                // If the player is looking downwards and pressing the "down" key
                if (player.movementInput.sneak) {
                    player.motionY = 0;
                } else if (player.rotationPitch > 45.0F || player.movementInput.backKeyDown) {
                    player.motionY = -elevatorSpeed;
                }
                // If the player is looking upwards and pressing the "up" key
                else if (player.rotationPitch < -45.0F && (player.movementInput.forwardKeyDown || player.movementInput.jump)) {
                    player.motionY = elevatorSpeed;
                }
                // If the player is on the ladder but not trying to go up or down
                else {
                    player.motionY = -elevatorSpeed;
                }
            } else {
                if (wasOnElevator && System.currentTimeMillis() - lastElevatorTime < 1000) { // 1000 ms = 1 second
                    player.motionY = 0;
                    wasOnElevator = false;
                }
            }
        }
    }

    public static void openBook() {
        Minecraft.getMinecraft().displayGuiScreen(new GuiTutorialBook());
    }
}
