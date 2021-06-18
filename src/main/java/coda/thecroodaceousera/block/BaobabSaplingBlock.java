package coda.thecroodaceousera.block;

import coda.thecroodaceousera.init.CroodsBlocks;
import coda.thecroodaceousera.init.CroodsFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

import net.minecraft.block.AbstractBlock.Properties;

public class BaobabSaplingBlock extends SaplingBlock {
    public BaobabSaplingBlock(Properties properties) {
        super(null, properties);
    }
    
    @Override
    public boolean canSurvive(BlockState state, IWorldReader worldIn, BlockPos pos) {
        return worldIn.getBlockState(pos.below()).getBlock().equals(CroodsBlocks.CROODACEOUS_SAND.get());
    }
    
    @Override
    public void advanceTree(ServerWorld world, BlockPos pos, BlockState state, Random rand) {
        if (state.getValue(STAGE) == 0) {
            world.setBlock(pos, state.cycle(STAGE), 4);
        }
        else {
            if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(world, rand, pos)) {
                return;
            }
            CroodsFeatures.DESERT_BAOBAB.get().place(world, world.getChunkSource().generator, rand, pos, null);
        }
    }
}