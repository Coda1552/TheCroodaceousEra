package coda.thecroodaceousera;

import coda.thecroodaceousera.entity.JackrobatEntity;
import coda.thecroodaceousera.entity.LiyoteEntity;
import coda.thecroodaceousera.init.CroodsFeatures;
import coda.thecroodaceousera.init.CroodsItems;
import coda.thecroodaceousera.init.CroodsBlocks;
import coda.thecroodaceousera.init.CroodsEntities;
import coda.thecroodaceousera.client.ClientEvents;
import net.minecraft.entity.ai.attributes.GlobalEntityTypeAttributes;
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
        bus.addListener(this::registerCommon);

        CroodsItems.REGISTER.register(bus);
        CroodsBlocks.REGISTER.register(bus);
        CroodsEntities.REGISTER.register(bus);
        CroodsFeatures.REGISTER.register(bus);
    }

    private void registerEntityAttributes() {
        GlobalEntityTypeAttributes.put(CroodsEntities.JACKROBAT.get(), JackrobatEntity.registerAttributes().create());
        GlobalEntityTypeAttributes.put(CroodsEntities.LIYOTE.get(), LiyoteEntity.registerAttributes().create());
    }

    private void registerCommon(FMLCommonSetupEvent event) {
        registerEntityAttributes();
    }

    private void registerClient(FMLClientSetupEvent event) {
        ClientEvents.clientSetup();
    }
}
