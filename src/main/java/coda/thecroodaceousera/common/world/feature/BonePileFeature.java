package coda.thecroodaceousera.common.world.feature;

import coda.thecroodaceousera.Croods;
import net.minecraft.util.Mirror;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Rotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.ChunkPos;
import net.minecraft.util.math.MutableBoundingBox;
import net.minecraft.world.ISeedReader;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.template.*;

import java.util.Random;

public class BonePileFeature extends Feature<NoFeatureConfig> {
    private static final ResourceLocation BONE_PILE_1 = new ResourceLocation(Croods.MOD_ID, "bone_pile_1");
    private static final ResourceLocation BONE_PILE_2 = new ResourceLocation(Croods.MOD_ID, "bone_pile_2");
    private static final ResourceLocation BONE_PILE_3 = new ResourceLocation(Croods.MOD_ID, "bone_pile_3");
    private static final ResourceLocation BONE_PILE_4 = new ResourceLocation(Croods.MOD_ID, "bone_pile_4");
    private static final ResourceLocation BONE_PILE_5 = new ResourceLocation(Croods.MOD_ID, "bone_pile_5");
    private static final ResourceLocation[] bonePiles = new ResourceLocation[]{BONE_PILE_1, BONE_PILE_2, BONE_PILE_3, BONE_PILE_4, BONE_PILE_5};

    public BonePileFeature() {
        super(NoFeatureConfig.CODEC);
    }

    @Override
    public boolean place(ISeedReader p_241855_1_, ChunkGenerator p_241855_2_, Random rand, BlockPos pos, NoFeatureConfig p_241855_5_) {
        Rotation rotation = Rotation.getRandom(rand);
        int i = rand.nextInt(bonePiles.length);
        TemplateManager templatemanager = p_241855_1_.getLevel().getServer().getStructureManager();
        Template template = templatemanager.getOrCreate(bonePiles[i]);
        ChunkPos chunkpos = new ChunkPos(pos);
        MutableBoundingBox mutableboundingbox = new MutableBoundingBox(chunkpos.getMinBlockX(), 0, chunkpos.getMinBlockZ(), chunkpos.getMaxBlockX(), 256, chunkpos.getMaxBlockZ());
        PlacementSettings placementsettings = (new PlacementSettings()).setRotation(rotation).setBoundingBox(mutableboundingbox).setRandom(rand).addProcessor(BlockIgnoreStructureProcessor.STRUCTURE_AND_AIR);
        BlockPos blockpos = template.getSize(rotation);
        int j = rand.nextInt(16 - blockpos.getX());
        int k = rand.nextInt(16 - blockpos.getZ());
        int l = 256;

        for(int i1 = 0; i1 < blockpos.getX(); ++i1) {
            for(int j1 = 0; j1 < blockpos.getZ(); ++j1) {
                l = Math.min(l, p_241855_1_.getHeight(Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, pos.getX() + i1 + j, pos.getZ() + j1 + k));
            }
        }

        BlockPos blockpos1 = template.getZeroPositionWithTransform(pos.offset(j, l - pos.getY() - 1, k), Mirror.NONE, rotation);
        if (rand.nextFloat() > 0.9F) {
            template.placeInWorld(p_241855_1_, blockpos1, blockpos1, placementsettings, rand, 4);
        }
        return true;
    }
}