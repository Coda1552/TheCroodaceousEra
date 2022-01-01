package coda.thecroodaceousera.common.world.surfacebuilders;

import coda.thecroodaceousera.registry.CroodsSurfaceBuilders;
import com.mojang.serialization.Codec;
import net.minecraft.block.BlockState;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.chunk.IChunk;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;

import java.util.Random;

public class CroodaceousDesertSurfaceBuilder extends SurfaceBuilder<SurfaceBuilderConfig> {

    public CroodaceousDesertSurfaceBuilder(Codec<SurfaceBuilderConfig> p_i232129_1_) {
        super(p_i232129_1_);
    }

    @Override
    public void apply(Random random, IChunk chunkIn, Biome biomeIn, int x, int z, int startHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed, SurfaceBuilderConfig config) {
        if (noise > 2.0D) {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, CroodsSurfaceBuilders.SANDSTONE_CONFIG);
        } else {
            SurfaceBuilder.DEFAULT.apply(random, chunkIn, biomeIn, x, z, startHeight, noise, defaultBlock, defaultFluid, seaLevel, seed, CroodsSurfaceBuilders.SAND_CONFIG);
        }
    }
}
