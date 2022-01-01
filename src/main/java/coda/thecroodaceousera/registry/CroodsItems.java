package coda.thecroodaceousera.registry;

import coda.thecroodaceousera.Croods;
import coda.thecroodaceousera.common.item.CroodsSpawnEggItem;
import coda.thecroodaceousera.common.item.RamuEggItem;
import net.minecraft.item.*;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class CroodsItems {
    public static final DeferredRegister<Item> REGISTER = DeferredRegister.create(ForgeRegistries.ITEMS, Croods.MOD_ID);

    public final static ItemGroup GROUP = new ItemGroup("croods_item_group") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(CroodsBlocks.CROODACEOUS_SAND.get());
        }
    };

    // Drops & Materials
    public static final RegistryObject<Item> RAMU_EGG = REGISTER.register("ramu_egg", () -> new RamuEggItem(new Item.Properties().tab(GROUP).stacksTo(16).food(new Food.Builder().nutrition(8).saturationMod(0.5f).build())));
    //public static final RegistryObject<Item> BAOBAB_BOAT_ITEM = REGISTER.register("baobab_boat_item", () -> new BaobabBoatItem(new Item.Properties().group(GROUP).maxStackSize(1)));

    // Spawn Eggs
    public static final RegistryObject<Item> JACKROBAT_SPAWN_EGG = REGISTER.register("jackrobat_spawn_egg", () -> new CroodsSpawnEggItem(CroodsEntities.JACKROBAT, 0x653941, 0x993e30, new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> LIYOTE_SPAWN_EGG = REGISTER.register("liyote_spawn_egg", () -> new CroodsSpawnEggItem(CroodsEntities.LIYOTE, 0xd67924, 0x8990d7, new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> MOUSEPHANT_SPAWN_EGG = REGISTER.register("mousephant_spawn_egg", () -> new CroodsSpawnEggItem(CroodsEntities.MOUSEPHANT, 0xaacbe4, 0x676d7c, new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> MOSQUITO_SPAWN_EGG = REGISTER.register("mosquito_spawn_egg", () -> new CroodsSpawnEggItem(CroodsEntities.MOSQUITO, 0xf48831, 0xff583c, new Item.Properties().tab(GROUP)));
    public static final RegistryObject<Item> BEAR_OWL_SPAWN_EGG = REGISTER.register("bear_owl_spawn_egg", () -> new CroodsSpawnEggItem(CroodsEntities.BEAR_OWL, 0x433836, 0xac9b88, new Item.Properties().tab(GROUP)));

    // Block Items
    public static final RegistryObject<BlockItem> DESERT_BAOBAB_SAPLING = REGISTER.register("desert_baobab_sapling", () -> new BlockItem(CroodsBlocks.DESERT_BAOBAB_SAPLING.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> BARREN_SHRUB = REGISTER.register("barren_shrub", () -> new BlockItem(CroodsBlocks.BARREN_SHRUB.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> CROODACEOUS_SAND = REGISTER.register("croodaceous_sand", () -> new BlockItem(CroodsBlocks.CROODACEOUS_SAND.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> CROODACEOUS_SANDSTONE = REGISTER.register("croodaceous_sandstone", () -> new BlockItem(CroodsBlocks.CROODACEOUS_SANDSTONE.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> CHISELED_CROODACEOUS_SANDSTONE = REGISTER.register("chiseled_croodaceous_sandstone", () -> new BlockItem(CroodsBlocks.CHISELED_CROODACEOUS_SANDSTONE.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> CUT_CROODACEOUS_SANDSTONE = REGISTER.register("cut_croodaceous_sandstone", () -> new BlockItem(CroodsBlocks.CUT_CROODACEOUS_SANDSTONE.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> SMOOTH_CROODACEOUS_SANDSTONE = REGISTER.register("smooth_croodaceous_sandstone", () -> new BlockItem(CroodsBlocks.SMOOTH_CROODACEOUS_SANDSTONE.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> CROODACEOUS_SANDSTONE_STAIRS = REGISTER.register("croodaceous_sandstone_stairs", () -> new BlockItem(CroodsBlocks.CROODACEOUS_SANDSTONE_STAIRS.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> CROODACEOUS_SANDSTONE_SLAB = REGISTER.register("croodaceous_sandstone_slab", () -> new BlockItem(CroodsBlocks.CROODACEOUS_SANDSTONE_SLAB.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> CUT_CROODACEOUS_SANDSTONE_SLAB = REGISTER.register("cut_croodaceous_sandstone_slab", () -> new BlockItem(CroodsBlocks.CUT_CROODACEOUS_SANDSTONE_SLAB.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> SMOOTH_CROODACEOUS_SANDSTONE_SLAB = REGISTER.register("smooth_croodaceous_sandstone_slab", () -> new BlockItem(CroodsBlocks.SMOOTH_CROODACEOUS_SANDSTONE_SLAB.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> SMOOTH_CROODACEOUS_SANDSTONE_STAIRS = REGISTER.register("smooth_croodaceous_sandstone_stairs", () -> new BlockItem(CroodsBlocks.SMOOTH_CROODACEOUS_SANDSTONE_STAIRS.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> CROODACEOUS_SANDSTONE_WALL = REGISTER.register("croodaceous_sandstone_wall", () -> new BlockItem(CroodsBlocks.CROODACEOUS_SANDSTONE_WALL.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> DESERT_BAOBAB_BRANCHES = REGISTER.register("desert_baobab_branches", () -> new WallOrFloorItem(CroodsBlocks.DESERT_BAOBAB_BRANCHES.get(), CroodsBlocks.DESERT_BAOBAB_WALL_BRANCHES.get(), (new Item.Properties().tab(GROUP))));
    public static final RegistryObject<BlockItem> DESERT_BAOBAB_LOG = REGISTER.register("desert_baobab_log", () -> new BlockItem(CroodsBlocks.DESERT_BAOBAB_LOG.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> DESERT_BAOBAB_WOOD = REGISTER.register("desert_baobab_wood", () -> new BlockItem(CroodsBlocks.DESERT_BAOBAB_WOOD.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> STRIPPED_DESERT_BAOBAB_LOG = REGISTER.register("stripped_desert_baobab_log", () -> new BlockItem(CroodsBlocks.STRIPPED_DESERT_BAOBAB_LOG.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> STRIPPED_DESERT_BAOBAB_WOOD = REGISTER.register("stripped_desert_baobab_wood", () -> new BlockItem(CroodsBlocks.STRIPPED_DESERT_BAOBAB_WOOD.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> DESERT_BAOBAB_PLANKS = REGISTER.register("desert_baobab_planks", () -> new BlockItem(CroodsBlocks.DESERT_BAOBAB_PLANKS.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> DESERT_BAOBAB_STAIRS = REGISTER.register("desert_baobab_stairs", () -> new BlockItem(CroodsBlocks.DESERT_BAOBAB_STAIRS.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> DESERT_BAOBAB_FENCE = REGISTER.register("desert_baobab_fence", () -> new BlockItem(CroodsBlocks.DESERT_BAOBAB_FENCE.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> DESERT_BAOBAB_SLAB = REGISTER.register("desert_baobab_slab", () -> new BlockItem(CroodsBlocks.DESERT_BAOBAB_SLAB.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> DESERT_BAOBAB_PRESSURE_PLATE = REGISTER.register("desert_baobab_pressure_plate", () -> new BlockItem(CroodsBlocks.DESERT_BAOBAB_PRESSURE_PLATE.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> DESERT_BAOBAB_BUTTON = REGISTER.register("desert_baobab_button", () -> new BlockItem(CroodsBlocks.DESERT_BAOBAB_BUTTON.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> DESERT_BAOBAB_TRAPDOOR = REGISTER.register("desert_baobab_trapdoor", () -> new BlockItem(CroodsBlocks.DESERT_BAOBAB_TRAPDOOR.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> DESERT_BAOBAB_DOOR = REGISTER.register("desert_baobab_door", () -> new BlockItem(CroodsBlocks.DESERT_BAOBAB_DOOR.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> DESERT_BAOBAB_FENCE_GATE = REGISTER.register("desert_baobab_fence_gate", () -> new BlockItem(CroodsBlocks.DESERT_BAOBAB_FENCE_GATE.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> HOODOO_SHALE = REGISTER.register("hoodoo_shale", () -> new BlockItem(CroodsBlocks.HOODOO_SHALE.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> POLISHED_HOODOO_SHALE = REGISTER.register("polished_hoodoo_shale", () -> new BlockItem(CroodsBlocks.POLISHED_HOODOO_SHALE.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> HOODOO_SHALE_TILES = REGISTER.register("hoodoo_shale_tiles", () -> new BlockItem(CroodsBlocks.HOODOO_SHALE_TLES.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> CHISELED_HOODOO_SHALE = REGISTER.register("chiseled_hoodoo_shale", () -> new BlockItem(CroodsBlocks.CHISELED_HOODOO_SHALE.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> HOODOO_SHALE_STAIRS = REGISTER.register("hoodoo_shale_stairs", () -> new BlockItem(CroodsBlocks.HOODOO_SHALE_STAIRS.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> POLISHED_HOODOO_SHALE_STAIRS = REGISTER.register("polished_hoodoo_shale_stairs", () -> new BlockItem(CroodsBlocks.POLISHED_HOODOO_SHALE_STAIRS.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> HOODOO_SHALE_SLAB = REGISTER.register("hoodoo_shale_slab", () -> new BlockItem(CroodsBlocks.HOODOO_SHALE_SLAB.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> POLISHED_HOODOO_SHALE_SLAB = REGISTER.register("polished_hoodoo_shale_slab", () -> new BlockItem(CroodsBlocks.POLISHED_HOODOO_SHALE_SLAB.get(), new Item.Properties().tab(GROUP)));
    public static final RegistryObject<BlockItem> HOODOO_SHALE_WALL = REGISTER.register("hoodoo_shale_wall", () -> new BlockItem(CroodsBlocks.HOODOO_SHALE_WALL.get(), new Item.Properties().tab(GROUP)));

}