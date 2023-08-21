package com.PlanetCore.asm.mixin;

import com.PlanetCore.blocks.BlocksBase;
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

import java.util.Random;

import static com.PlanetCore.blocks.BlocksBase.VARIANT_SUPERCOMPRESSED;

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
            return ModBlocks.SUPERCOMPRESSED_IRON.getDefaultState().withProperty(VARIANT_SUPERCOMPRESSED, BlocksBase.EnumType.byMetadata(new Random().nextInt(2)+1));
        }
        if (lava == ModBlocks.REDSTONE_LAVA_FLUID) {
            return ModBlocks.SUPERCOMPRESSED_REDSTONE.getDefaultState().withProperty(VARIANT_SUPERCOMPRESSED, BlocksBase.EnumType.byMetadata(new Random().nextInt(2)+1));
        }
        if (lava == ModBlocks.SILVER_LAVA_FLUID) {
            return ModBlocks.SUPERCOMPRESSED_SILVER.getDefaultState().withProperty(VARIANT_SUPERCOMPRESSED, BlocksBase.EnumType.byMetadata(new Random().nextInt(2)+1));
        }
        if (lava == ModBlocks.GOLD_LAVA_FLUID) {
            return ModBlocks.SUPERCOMPRESSED_GOLD.getDefaultState().withProperty(VARIANT_SUPERCOMPRESSED, BlocksBase.EnumType.byMetadata(new Random().nextInt(2)+1));
        }
        if (lava == ModBlocks.DIAMOND_LAVA_FLUID) {
            return ModBlocks.SUPERCOMPRESSED_DIAMOND.getDefaultState().withProperty(VARIANT_SUPERCOMPRESSED, BlocksBase.EnumType.byMetadata(new Random().nextInt(2)+1));
        }
        if (lava == ModBlocks.TITANIUM_LAVA_FLUID) {
            return ModBlocks.SUPERCOMPRESSED_TITANIUM.getDefaultState().withProperty(VARIANT_SUPERCOMPRESSED, BlocksBase.EnumType.byMetadata(new Random().nextInt(2)+1));
        }
        if (lava == ModBlocks.URANIUM_LAVA_FLUID) {
            return ModBlocks.SUPERCOMPRESSED_URANIUM.getDefaultState().withProperty(VARIANT_SUPERCOMPRESSED, BlocksBase.EnumType.byMetadata(new Random().nextInt(2)+1));
        }
        if (lava == ModBlocks.TUNGSTEN_LAVA_FLUID) {
            return ModBlocks.SUPERCOMPRESSED_TUNGSTEN.getDefaultState().withProperty(VARIANT_SUPERCOMPRESSED, BlocksBase.EnumType.byMetadata(new Random().nextInt(2)+1));
        }
        if (lava == ModBlocks.RUBY_LAVA_FLUID) {
            return ModBlocks.SUPERCOMPRESSED_RUBY.getDefaultState().withProperty(VARIANT_SUPERCOMPRESSED, BlocksBase.EnumType.byMetadata(new Random().nextInt(2)+1));
        }
        if (lava == ModBlocks.SAPPHIRE_LAVA_FLUID) {
            return ModBlocks.SUPERCOMPRESSED_SAPPHIRE.getDefaultState().withProperty(VARIANT_SUPERCOMPRESSED, BlocksBase.EnumType.byMetadata(new Random().nextInt(2)+1));
        }
        if (lava == ModBlocks.MAJORITE_LAVA_FLUID) {
            return ModBlocks.SUPERCOMPRESSED_MAJORITE.getDefaultState().withProperty(VARIANT_SUPERCOMPRESSED, BlocksBase.EnumType.byMetadata(new Random().nextInt(2)+1));
        }
        if (lava == ModBlocks.AMAZONITE_LAVA_FLUID) {
            return ModBlocks.SUPERCOMPRESSED_AMAZONITE.getDefaultState().withProperty(VARIANT_SUPERCOMPRESSED, BlocksBase.EnumType.byMetadata(new Random().nextInt(2)+1));
        }
        if (lava == ModBlocks.ONYX_LAVA_FLUID) {
            return ModBlocks.SUPERCOMPRESSED_ONYX.getDefaultState().withProperty(VARIANT_SUPERCOMPRESSED, BlocksBase.EnumType.byMetadata(new Random().nextInt(2)+1));
        }
        if (lava == ModBlocks.PAINITE_LAVA_FLUID) {
            return ModBlocks.SUPERCOMPRESSED_PAINITE.getDefaultState().withProperty(VARIANT_SUPERCOMPRESSED, BlocksBase.EnumType.byMetadata(new Random().nextInt(2)+1));
        }
        return default_;
    }
}
