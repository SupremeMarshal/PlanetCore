package com.PlanetCore.asm.mixin;

import com.PlanetCore.init.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.world.gen.feature.WorldGenLakes;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.Slice;

@Mixin(WorldGenLakes.class)
public class WorldGenLakesMixin {

    @Shadow @Final private Block block;

    @ModifyArg(method = "generate", remap = false,
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/world/World;setBlockState(Lnet/minecraft/util/math/BlockPos;Lnet/minecraft/block/state/IBlockState;I)Z"
            ),
            slice = @Slice(
                    from = @At(value = "FIELD", target = "Lnet/minecraft/block/material/Material;LAVA:Lnet/minecraft/block/material/Material;"),
                    to = @At(value = "FIELD", target = "Lnet/minecraft/block/material/Material;WATER:Lnet/minecraft/block/material/Material;")
            )
    )
    private IBlockState replaceLava(IBlockState state) {
        return planetCore$getCorrespondingStoneBlock(this.block, state);
    }

    @Unique
    private IBlockState planetCore$getCorrespondingStoneBlock(Block lava, IBlockState default_) {
        if (lava == ModBlocks.IRON_LAVA_FLUID) {
            return ModBlocks.IRON_SUPERCOMPACT.getDefaultState();
        }
        if (lava == ModBlocks.REDSTONE_LAVA_FLUID) {
            return ModBlocks.REDSTONE_SUPERCOMPACT.getDefaultState();
        }
        if (lava == ModBlocks.SILVER_LAVA_FLUID) {
            return ModBlocks.SILVER_SUPERCOMPACT.getDefaultState();
        }
        if (lava == ModBlocks.GOLD_LAVA_FLUID) {
            return ModBlocks.GOLD_SUPERCOMPACT.getDefaultState();
        }
        if (lava == ModBlocks.DIAMOND_LAVA_FLUID) {
            return ModBlocks.DIAMOND_SUPERCOMPACT.getDefaultState();
        }
        if (lava == ModBlocks.TITANIUM_LAVA_FLUID) {
            return ModBlocks.TITANIUM_SUPERCOMPACT.getDefaultState();
        }
        if (lava == ModBlocks.URANIUM_LAVA_FLUID) {
            return ModBlocks.URANIUM_SUPERCOMPACT.getDefaultState();
        }
        if (lava == ModBlocks.TUNGSTEN_LAVA_FLUID) {
            return ModBlocks.TUNGSTEN_SUPERCOMPACT.getDefaultState();
        }
        if (lava == ModBlocks.RUBY_LAVA_FLUID) {
            return ModBlocks.RUBY_SUPERCOMPACT.getDefaultState();
        }
        if (lava == ModBlocks.SAPPHIRE_LAVA_FLUID) {
            return ModBlocks.SAPPHIRE_SUPERCOMPACT.getDefaultState();
        }
        if (lava == ModBlocks.MAJORITE_LAVA_FLUID) {
            return ModBlocks.MAJORITE_SUPERCOMPACT.getDefaultState();
        }
        if (lava == ModBlocks.AMAZONITE_LAVA_FLUID) {
            return ModBlocks.AMAZONITE_SUPERCOMPACT.getDefaultState();
        }
        if (lava == ModBlocks.ONYX_LAVA_FLUID) {
            return ModBlocks.ONYX_SUPERCOMPACT.getDefaultState();
        }
        if (lava == ModBlocks.PAINITE_LAVA_FLUID) {
            return ModBlocks.PAINITE_SUPERCOMPACT.getDefaultState();
        }
        return default_;
    }
}
