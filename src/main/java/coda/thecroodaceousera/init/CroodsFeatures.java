package coda.thecroodaceousera.init;

import coda.thecroodaceousera.Croods;
import coda.thecroodaceousera.world.feature.CroodsNbtStructure;
import coda.thecroodaceousera.world.tree.DesertBaobabFeature;
import coda.thecroodaceousera.world.feature.HoodooFeature;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CroodsFeatures {
    public static final DeferredRegister<Feature<?>> REGISTER = DeferredRegister.create(ForgeRegistries.FEATURES, Croods.MOD_ID);

    public static final RegistryObject<HoodooFeature> HOODOO = REGISTER.register("hoodoo", HoodooFeature::new);
    public static final RegistryObject<DesertBaobabFeature> DESERT_BAOBAB = REGISTER.register("desert_baobab", DesertBaobabFeature::new);
    public static final RegistryObject<Feature<NoFeatureConfig>> BONE_PILE_1 = REGISTER.register("bone_pile_1", () -> new CroodsNbtStructure(new ResourceLocation(Croods.MOD_ID, "bone_pile_1")));
    public static final RegistryObject<Feature<NoFeatureConfig>> BONE_PILE_2 = REGISTER.register("bone_pile_2", () -> new CroodsNbtStructure(new ResourceLocation(Croods.MOD_ID, "bone_pile_2")));
    public static final RegistryObject<Feature<NoFeatureConfig>> BONE_PILE_3 = REGISTER.register("bone_pile_3", () -> new CroodsNbtStructure(new ResourceLocation(Croods.MOD_ID, "bone_pile_3")));
    public static final RegistryObject<Feature<NoFeatureConfig>> BONE_PILE_4 = REGISTER.register("bone_pile_4", () -> new CroodsNbtStructure(new ResourceLocation(Croods.MOD_ID, "bone_pile_4")));
    public static final RegistryObject<Feature<NoFeatureConfig>> BONE_PILE_5 = REGISTER.register("bone_pile_5", () -> new CroodsNbtStructure(new ResourceLocation(Croods.MOD_ID, "bone_pile_5")));

}
