package coda.thecroodaceousera;

import coda.thecroodaceousera.entity.JackrobatEntity;
import coda.thecroodaceousera.entity.LiyoteEntity;
import coda.thecroodaceousera.entity.MosquitoEntity;
import coda.thecroodaceousera.entity.MousephantEntity;
import coda.thecroodaceousera.init.*;
import coda.thecroodaceousera.client.ClientEvents;
import com.google.common.collect.ImmutableMap;
import com.mojang.serialization.Codec;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.WorldGenRegistries;
import net.minecraft.world.World;
import net.minecraft.world.biome.Biome;
import net.minecraft.world.gen.ChunkGenerator;
import net.minecraft.world.gen.FlatChunkGenerator;
import net.minecraft.world.gen.Heightmap;
import net.minecraft.world.gen.feature.structure.Structure;
import net.minecraft.world.gen.settings.DimensionStructuresSettings;
import net.minecraft.world.gen.settings.StructureSeparationSettings;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.world.BiomeLoadingEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.ObfuscationReflectionHelper;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

@Mod(Croods.MOD_ID)
public class Croods {
    public static final String MOD_ID = "thecroodaceousera";
    public static final Logger LOGGER = LogManager.getLogger();

    public Croods() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        bus.addListener(this::registerClient);
        bus.addListener(this::registerEntityAttributes);
        bus.addListener(this::registerCommon);
        bus.addListener(this::setup);

        forgeBus.addListener(EventPriority.NORMAL, this::addDimensionalSpacing);

        CroodsItems.REGISTER.register(bus);
        CroodsBlocks.REGISTER.register(bus);
        CroodsEntities.REGISTER.register(bus);
        CroodsFeatures.REGISTER.register(bus);
        CroodsSounds.REGISTER.register(bus);
        CroodsStructures.REGISTER.register(bus);
        CroodsSurfaceBuilders.REGISTER.register(bus);
    }

    private void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(CroodsEntities.JACKROBAT.get(), JackrobatEntity.createAttributes().build());
        event.put(CroodsEntities.LIYOTE.get(), LiyoteEntity.createAttributes().build());
        event.put(CroodsEntities.MOUSEPHANT.get(), MousephantEntity.createAttributes().build());
        event.put(CroodsEntities.MOSQUITO.get(), MosquitoEntity.createAttributes().build());
    }

    private void registerCommon(FMLCommonSetupEvent event) {
        EntitySpawnPlacementRegistry.register(CroodsEntities.LIYOTE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LiyoteEntity::checkLiyoteSpawnRules);
        EntitySpawnPlacementRegistry.register(CroodsEntities.MOSQUITO.get(), EntitySpawnPlacementRegistry.PlacementType.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, MosquitoEntity::checkMosquitoSpawnRules);
    }

    private void registerClient(FMLClientSetupEvent event) {
        ClientEvents.clientSetup();
    }

    public void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            CroodsStructures.setupStructures();
            CroodsConfiguredStructures.registerConfiguredStructures();

            WorldGenRegistries.NOISE_GENERATOR_SETTINGS.entrySet().forEach(settings -> {
                Map<Structure<?>, StructureSeparationSettings> structureMap = settings.getValue().structureSettings().structureConfig();

                if (structureMap instanceof ImmutableMap) {
                    Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(structureMap);
                    tempMap.put(CroodsStructures.BEAROWL_DEN.get(), DimensionStructuresSettings.DEFAULTS.get(CroodsStructures.BEAROWL_DEN.get()));
                    settings.getValue().structureSettings().structureConfig = tempMap;
                }
                else {
                    structureMap.put(CroodsStructures.BEAROWL_DEN.get(), DimensionStructuresSettings.DEFAULTS.get(CroodsStructures.BEAROWL_DEN.get()));
                }
            });
        });
    }

    private static Method GETCODEC_METHOD;
    public void addDimensionalSpacing(final WorldEvent.Load event) {
        if(event.getWorld() instanceof ServerWorld){
            ServerWorld serverWorld = (ServerWorld)event.getWorld();

            try {
                if(GETCODEC_METHOD == null) GETCODEC_METHOD = ObfuscationReflectionHelper.findMethod(ChunkGenerator.class, "getCodec");
                ResourceLocation cgRL = Registry.CHUNK_GENERATOR.getKey((Codec<? extends ChunkGenerator>) GETCODEC_METHOD.invoke(serverWorld.getChunkSource().generator));
                if(cgRL != null && cgRL.getNamespace().equals("terraforged")) return;
            }
            catch(Exception e){
                Croods.LOGGER.error("Was unable to check if " + serverWorld.dimension().location() + " is using Terraforged's ChunkGenerator.");
            }

            if(serverWorld.getChunkSource().getGenerator() instanceof FlatChunkGenerator &&
                    serverWorld.dimension().equals(World.OVERWORLD)){
                return;
            }


            Map<Structure<?>, StructureSeparationSettings> tempMap = new HashMap<>(serverWorld.getChunkSource().generator.getSettings().structureConfig());
            tempMap.putIfAbsent(CroodsStructures.BEAROWL_DEN.get(), DimensionStructuresSettings.DEFAULTS.get(CroodsStructures.BEAROWL_DEN.get()));
            serverWorld.getChunkSource().generator.getSettings().structureConfig = tempMap;
        }
    }
}