package coda.thecroodaceousera.init;

import coda.thecroodaceousera.Croods;
import coda.thecroodaceousera.world.structure.BearowlDenStructure;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.gen.feature.NoFeatureConfig;
import net.minecraft.world.gen.feature.structure.IStructurePieceType;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Locale;

@Mod.EventBusSubscriber(modid = Croods.MOD_ID)
public class CroodsStructures {
    public static IStructurePieceType BEAROWL_DEN_PIECE = register(BearowlDenStructure.Piece::new, "BearowlDen");

    public static final DeferredRegister<Structure<?>> REGISTER = DeferredRegister.create(ForgeRegistries.STRUCTURE_FEATURES, Croods.MOD_ID);

    public static final RegistryObject<Structure<NoFeatureConfig>> BEAROWL_DEN = REGISTER.register("bearowl_den", () -> (new BearowlDenStructure(NoFeatureConfig.CODEC)));

    public static void setupStructures() {
        setupMapSpacingAndLand(BEAROWL_DEN.get(), new StructureSeparationSettings(20, 12, 455353590), true);
    }

    static IStructurePieceType register(IStructurePieceType type, String key) {
        return Registry.register(Registry.STRUCTURE_PIECE, key.toLowerCase(Locale.ROOT), type);
    }

    public static <F extends Structure<?>> void setupMapSpacingAndLand(F structure, StructureSeparationSettings structureSeparationSettings, boolean transformSurroundingLand) {
        Structure.STRUCTURES_REGISTRY.put(structure.getRegistryName().toString(), structure);

        if (transformSurroundingLand) {
            Structure.NOISE_AFFECTING_FEATURES = ImmutableList.<Structure<?>>builder().addAll(Structure.NOISE_AFFECTING_FEATURES).add(structure).build();
        }

        DimensionStructuresSettings.DEFAULTS = ImmutableMap.<Structure<?>, StructureSeparationSettings>builder().putAll(DimensionStructuresSettings.DEFAULTS).put(structure, structureSeparationSettings).build();
    }
}
