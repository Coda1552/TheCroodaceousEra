package coda.thecroodaceousera.common.world.surfacebuilders;

import coda.thecroodaceousera.registry.CroodsBlocks;
import coda.thecroodaceousera.registry.CroodsSurfaceBuilders;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class DesertCanyonsSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

    public DesertCanyonsSurfaceBuilder(Codec<SurfaceBuilderConfig> p_i232129_1_) {
        super(p_i232129_1_);
    }

    @Override
    public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        if (noise >= -0.5 && noise <= 0.5) {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, CroodsSurfaceBuilders.SHALE_CONFIG);

            for (int i = startHeight - 5; i < startHeight; i++) {
                BlockPos pos = new BlockPos(x, i, z);
                chunkIn.setBlockState(pos, Blocks.AIR.defaultBlockState(), false);
            }
        }
        if (noise >= -0.4 && noise <= 0.4) {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, CroodsSurfaceBuilders.SHALE_CONFIG);

            for (int i = startHeight - 5; i < startHeight; i++) {
                BlockPos pos = new BlockPos(x, i, z);
                chunkIn.setBlockState(pos, Blocks.AIR.defaultBlockState(), false);
            }
        }
        else {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, CroodsSurfaceBuilders.SAND_CONFIG);
        }
    }
}
