package coda.thecroodaceousera.common.world;

import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;

public class Entry {
    public final BlockPos pos;
    public final BlockState state;

    public Entry(BlockPos pos, BlockState state) {
        this.pos = pos;
        this.state = state;
    }
}
