package coda.thecroodaceousera.registry;

import coda.thecroodaceousera.Croods;
import coda.thecroodaceousera.common.block.BaobabSaplingBlock;
import coda.thecroodaceousera.common.block.BranchesBlock;
import coda.thecroodaceousera.common.block.BranchesWallBlock;
import coda.thecroodaceousera.common.block.BarrenShrubBlock;
import net.minecraft.block.*;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.function.Supplier;

public class CroodsBlocks {
    public static final DeferredRegister<Block> REGISTER = DeferredRegister.create(ForgeRegistries.BLOCKS, Croods.MOD_ID);

    // Croodaceous Sand
    public static final Block CROODACEOUS_SAND_BLOCK = new SandBlock(0xe7ba8a, AbstractBlock.Properties.of(Material.SAND).strength(0.5f).sound(SoundType.SAND));
    public static final Block CROODACEOUS_SANDSTONE_BLOCK = new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.SAND).strength(1.2f).requiresCorrectToolForDrops());
    public static final RegistryObject<Block> CROODACEOUS_SAND = register("croodaceous_sand", () -> CROODACEOUS_SAND_BLOCK);
    public static final RegistryObject<Block> CROODACEOUS_SANDSTONE = register("croodaceous_sandstone", () -> CROODACEOUS_SANDSTONE_BLOCK);
    public static final RegistryObject<Block> CHISELED_CROODACEOUS_SANDSTONE = register("chiseled_croodaceous_sandstone", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.SAND).strength(1.2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CUT_CROODACEOUS_SANDSTONE = register("cut_croodaceous_sandstone", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.SAND).strength(1.2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_CROODACEOUS_SANDSTONE = register("smooth_croodaceous_sandstone", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.SAND).strength(1.2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CROODACEOUS_SANDSTONE_STAIRS = register("croodaceous_sandstone_stairs", () -> new StairsBlock(() -> CROODACEOUS_SANDSTONE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.SAND).strength(1.2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CROODACEOUS_SANDSTONE_SLAB = register("croodaceous_sandstone_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.SAND).strength(1.2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CUT_CROODACEOUS_SANDSTONE_SLAB = register("cut_croodaceous_sandstone_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.SAND).strength(1.2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_CROODACEOUS_SANDSTONE_SLAB = register("smooth_croodaceous_sandstone_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.SAND).strength(1.2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMOOTH_CROODACEOUS_SANDSTONE_STAIRS = register("smooth_croodaceous_sandstone_stairs", () -> new StairsBlock(() -> SMOOTH_CROODACEOUS_SANDSTONE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.SAND).strength(1.2f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CROODACEOUS_SANDSTONE_WALL = register("croodaceous_sandstone_wall", () -> new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.SAND).strength(1.2f).requiresCorrectToolForDrops()));

    // Hoodoo Shale
    public static final Block HOODOO_SHALE_BLOCK = new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(1.5f, 6.0f).requiresCorrectToolForDrops());
    public static final RegistryObject<Block> HOODOO_SHALE = register("hoodoo_shale", () -> HOODOO_SHALE_BLOCK);
    public static final RegistryObject<Block> POLISHED_HOODOO_SHALE = register("polished_hoodoo_shale", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(1.5f, 6.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> HOODOO_SHALE_TLES = register("hoodoo_shale_tiles", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(1.5f, 6.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> CHISELED_HOODOO_SHALE = register("chiseled_hoodoo_shale", () -> new Block(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(1.5f, 6.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> HOODOO_SHALE_STAIRS = register("hoodoo_shale_stairs", () -> new StairsBlock(() -> HOODOO_SHALE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(1.5f, 6.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_HOODOO_SHALE_STAIRS = register("polished_hoodoo_shale_stairs", () -> new StairsBlock(() -> POLISHED_HOODOO_SHALE.get().defaultBlockState(), AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(1.5f, 6.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> HOODOO_SHALE_SLAB = register("hoodoo_shale_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(1.5f, 6.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> POLISHED_HOODOO_SHALE_SLAB = register("polished_hoodoo_shale_slab", () -> new SlabBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(1.5f, 6.0f).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> HOODOO_SHALE_WALL = register("hoodoo_shale_wall", () -> new WallBlock(AbstractBlock.Properties.of(Material.STONE, MaterialColor.COLOR_BROWN).strength(1.5f, 6.0f).requiresCorrectToolForDrops()));

    // Desert Baobab
    public static final RegistryObject<Block> DESERT_BAOBAB_SAPLING = register("desert_baobab_sapling", () -> new BaobabSaplingBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_ORANGE).strength(0).sound(SoundType.GRASS)));
    public static final RegistryObject<Block> DESERT_BAOBAB_LOG = register("desert_baobab_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.of(Material.WOOD, MaterialColor.TERRACOTTA_ORANGE).strength(2.0f).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DESERT_BAOBAB_WOOD = REGISTER.register("desert_baobab_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(DESERT_BAOBAB_LOG.get())));
    public static final RegistryObject<Block> STRIPPED_DESERT_BAOBAB_LOG = REGISTER.register("stripped_desert_baobab_log", () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(DESERT_BAOBAB_LOG.get())));
    public static final RegistryObject<Block> STRIPPED_DESERT_BAOBAB_WOOD = REGISTER.register("stripped_desert_baobab_wood", () -> new RotatedPillarBlock(AbstractBlock.Properties.copy(DESERT_BAOBAB_LOG.get())));
    public static final RegistryObject<Block> DESERT_BAOBAB_PLANKS = REGISTER.register("desert_baobab_planks", () -> new Block(AbstractBlock.Properties.copy(Blocks.OAK_PLANKS)));
    public static final RegistryObject<Block> DESERT_BAOBAB_STAIRS = REGISTER.register("desert_baobab_stairs", () -> new StairsBlock(() -> DESERT_BAOBAB_PLANKS.get().defaultBlockState(), AbstractBlock.Properties.copy(Blocks.OAK_STAIRS)));
    public static final RegistryObject<Block> DESERT_BAOBAB_FENCE = REGISTER.register("desert_baobab_fence", () -> new FenceBlock(AbstractBlock.Properties.copy(Blocks.OAK_FENCE)));
    public static final RegistryObject<Block> DESERT_BAOBAB_SLAB = REGISTER.register("desert_baobab_slab", () -> new SlabBlock(AbstractBlock.Properties.copy(Blocks.OAK_SLAB)));
    public static final RegistryObject<Block> DESERT_BAOBAB_PRESSURE_PLATE = REGISTER.register("desert_baobab_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, AbstractBlock.Properties.copy(Blocks.OAK_PRESSURE_PLATE)));
    public static final RegistryObject<Block> DESERT_BAOBAB_BUTTON = REGISTER.register("desert_baobab_button", () -> new WoodButtonBlock(AbstractBlock.Properties.copy(Blocks.OAK_BUTTON)));
    public static final RegistryObject<Block> DESERT_BAOBAB_TRAPDOOR = REGISTER.register("desert_baobab_trapdoor", () -> new TrapDoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_TRAPDOOR)));
    public static final RegistryObject<Block> DESERT_BAOBAB_DOOR = REGISTER.register("desert_baobab_door", () -> new DoorBlock(AbstractBlock.Properties.copy(Blocks.OAK_DOOR)));
    public static final RegistryObject<Block> DESERT_BAOBAB_FENCE_GATE = REGISTER.register("desert_baobab_fence_gate", () -> new FenceGateBlock(AbstractBlock.Properties.copy(Blocks.OAK_DOOR)));
    public static final RegistryObject<Block> DESERT_BAOBAB_BRANCHES = register("desert_baobab_branches", () -> new BranchesBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_BROWN).sound(SoundType.GRASS).noCollission().instabreak()));
    public static final RegistryObject<Block> DESERT_BAOBAB_WALL_BRANCHES = register("desert_baobab_wall_branches", () -> new BranchesWallBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_BROWN).sound(SoundType.GRASS).noCollission().instabreak()));

    // Other
    public static final RegistryObject<Block> BARREN_SHRUB = register("barren_shrub", () -> new BarrenShrubBlock(AbstractBlock.Properties.of(Material.PLANT, MaterialColor.COLOR_BROWN).noCollission().sound(SoundType.GRASS).strength(0.0f)));

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block) {
        RegistryObject<T> object = REGISTER.register(name, block);
        return object;
    }
}
