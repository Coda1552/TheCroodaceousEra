package coda.thecroodaceousera;

import coda.thecroodaceousera.entity.JackrobatEntity;
import coda.thecroodaceousera.entity.LiyoteEntity;
import coda.thecroodaceousera.entity.MousephantEntity;
import coda.thecroodaceousera.init.*;
import coda.thecroodaceousera.client.ClientEvents;
import net.minecraft.entity.EntitySpawnPlacementRegistry;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.gen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod(Croods.MOD_ID)
public class Croods {
    public static final String MOD_ID = "thecroodaceousera";

    public Croods() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.addListener(this::registerClient);
        bus.addListener(this::registerEntityAttributes);
        bus.addListener(this::registerCommon);

        CroodsItems.REGISTER.register(bus);
        CroodsBlocks.REGISTER.register(bus);
        CroodsEntities.REGISTER.register(bus);
        CroodsFeatures.REGISTER.register(bus);
        CroodsSounds.REGISTER.register(bus);
    }

    private void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(CroodsEntities.JACKROBAT.get(), JackrobatEntity.createAttributes().build());
        event.put(CroodsEntities.LIYOTE.get(), LiyoteEntity.createAttributes().build());
        event.put(CroodsEntities.MOUSEPHANT.get(), MousephantEntity.createAttributes().build());
    }

    private void registerCommon(FMLCommonSetupEvent event) {
        EntitySpawnPlacementRegistry.register(CroodsEntities.LIYOTE.get(), EntitySpawnPlacementRegistry.PlacementType.ON_GROUND, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, LiyoteEntity::checkLiyoteSpawnRules);
    }

    private void registerClient(FMLClientSetupEvent event) {
        ClientEvents.clientSetup();
    }
}
