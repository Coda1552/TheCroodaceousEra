package coda.thecroodaceousera.registry;

import coda.thecroodaceousera.Croods;
import coda.thecroodaceousera.common.world.surfacebuilders.CroodaceousDesertSurfaceBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilder;
import net.minecraft.world.gen.surfacebuilders.SurfaceBuilderConfig;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CroodsSurfaceBuilders {
    private static final BlockState SAND = CroodsBlocks.CROODACEOUS_SAND_BLOCK.defaultBlockState();
    private static final BlockState SANDSTONE = CroodsBlocks.CROODACEOUS_SANDSTONE_BLOCK.defaultBlockState();

    public static final DeferredRegister<SurfaceBuilder<?>> REGISTER = DeferredRegister.create(ForgeRegistries.SURFACE_BUILDERS, Croods.MOD_ID);

    public static final RegistryObject<SurfaceBuilder<SurfaceBuilderConfig>> CROODACEOUS_DESERT = REGISTER.register("croodaceous_desert", () -> new CroodaceousDesertSurfaceBuilder(SurfaceBuilderConfig.CODEC));
    public static final SurfaceBuilderConfig SAND_CONFIG = new SurfaceBuilderConfig(SAND, SANDSTONE, SAND);
    public static final SurfaceBuilderConfig SANDSTONE_CONFIG = new SurfaceBuilderConfig(SANDSTONE, SANDSTONE, SANDSTONE);
}
