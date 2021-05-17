package coda.thecroodaceousera.block;

import coda.thecroodaceousera.init.CroodsBlocks;
import coda.thecroodaceousera.init.CroodsFeatures;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.IWorldReader;
import net.minecraft.world.server.ServerWorld;

import java.util.Random;

public class BaobabSaplingBlock extends SaplingBlock
{
    public BaobabSaplingBlock(Properties properties)
    {
        super(null, properties);
    }
    
    @Override
    public boolean isValidPosition(BlockState state, IWorldReader worldIn, BlockPos pos)
    {
        return worldIn.getBlockState(pos.down()).getBlock().equals(CroodsBlocks.CROODACEOUS_SAND.get());
    }
    
    @Override
    public void placeTree(ServerWorld world, BlockPos pos, BlockState state, Random rand)
    {
        if (state.get(STAGE) == 0)
        {
            world.setBlockState(pos, state.func_235896_a_(STAGE), 4);
        }
        else
        {
            if (!net.minecraftforge.event.ForgeEventFactory.saplingGrowTree(world, rand, pos))
            {
                return;
            }
            CroodsFeatures.DESERT_BAOBAB.get().generate(world, world.getChunkProvider().generator, rand, pos, null);
        }
    }
}