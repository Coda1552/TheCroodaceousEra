package coda.thecroodaceousera.init;

import coda.thecroodaceousera.Croods;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.gen.FlatGenerationSettings;
import net.minecraft.world.gen.feature.IFeatureConfig;
import net.minecraft.world.gen.feature.StructureFeature;

public class CroodsConfiguredStructures {
    public static StructureFeature<?, ?> CONFIGURED_BEAROWL_DEN = CroodsStructures.BEAROWL_DEN.get().configured(IFeatureConfig.NONE);

    public static void registerConfiguredStructures() {
        Registry<StructureFeature<?, ?>> registry = WorldGenRegistries.CONFIGURED_STRUCTURE_FEATURE;
        Registry.register(registry, new ResourceLocation(Croods.MOD_ID, "configured_bearowl_den"), CONFIGURED_BEAROWL_DEN);

        FlatGenerationSettings.STRUCTURE_FEATURES.put(CroodsStructures.BEAROWL_DEN.get(), CONFIGURED_BEAROWL_DEN);
    }
}
