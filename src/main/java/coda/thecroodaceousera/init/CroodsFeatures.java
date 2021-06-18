package coda.thecroodaceousera.init;

import coda.thecroodaceousera.Croods;
import coda.thecroodaceousera.world.feature.DesertBaobabFeature;
import coda.thecroodaceousera.world.feature.DesertRockFeature;
import coda.thecroodaceousera.world.feature.HoodooFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CroodsFeatures {
    public static final DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(ForgeRegistries.FEATURES, Croods.MOD_ID);

    public static final RegistryObject<HoodooFeature> HOODOO = REGISTER.register("hoodoo", HoodooFeature::new);
    public static final RegistryObject<DesertRockFeature> DESERT_ROCK = REGISTER.register("desert_rock", DesertRockFeature::new);
    public static final RegistryObject<DesertBaobabFeature> DESERT_BAOBAB = REGISTER.register("desert_baobab", DesertBaobabFeature::new);
}
