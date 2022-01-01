package coda.thecroodaceousera.registry;

import coda.thecroodaceousera.Croods;
import coda.thecroodaceousera.common.world.feature.BonePileFeature;
import coda.thecroodaceousera.common.world.tree.DesertBaobabFeature;
import coda.thecroodaceousera.common.world.feature.HoodooFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CroodsFeatures {
    public static final DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(ForgeRegistries.FEATURES, Croods.MOD_ID);

    public static final RegistryObject<HoodooFeature> HOODOO = REGISTER.register("hoodoo", HoodooFeature::new);
    public static final RegistryObject<DesertBaobabFeature> DESERT_BAOBAB = REGISTER.register("desert_baobab", DesertBaobabFeature::new);
    public static final RegistryObject<Feature<NoFeatureConfig>> BONE_PILE = REGISTER.register("bone_pile", BonePileFeature::new);

}
