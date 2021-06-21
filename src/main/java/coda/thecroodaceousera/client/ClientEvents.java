package coda.thecroodaceousera.client;

import coda.thecroodaceousera.Croods;
import coda.thecroodaceousera.client.renderer.MosquitoRenderer;
import coda.thecroodaceousera.client.renderer.MousephantRenderer;
import coda.thecroodaceousera.init.CroodsBlocks;
import coda.thecroodaceousera.item.CroodsSpawnEggItem;
import coda.thecroodaceousera.client.renderer.JackrobatRenderer;
import coda.thecroodaceousera.client.renderer.LiyoteRenderer;
import coda.thecroodaceousera.init.CroodsEntities;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.RenderTypeLookup;
import net.minecraft.client.renderer.color.IItemColor;
import net.minecraft.client.renderer.color.ItemColors;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.ColorHandlerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, modid = Croods.MOD_ID)
public class ClientEvents {

    public static void clientSetup() {
        RenderingRegistry.registerEntityRenderingHandler(CroodsEntities.JACKROBAT.get(), JackrobatRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(CroodsEntities.LIYOTE.get(), LiyoteRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(CroodsEntities.MOUSEPHANT.get(), MousephantRenderer::new);
        RenderingRegistry.registerEntityRenderingHandler(CroodsEntities.MOSQUITO.get(), MosquitoRenderer::new);

        RenderTypeLookup.setRenderLayer(CroodsBlocks.BARREN_SHRUB.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CroodsBlocks.DESERT_BAOBAB_WALL_BRANCHES.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CroodsBlocks.DESERT_BAOBAB_BRANCHES.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CroodsBlocks.DESERT_BAOBAB_TRAPDOOR.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CroodsBlocks.DESERT_BAOBAB_DOOR.get(), RenderType.cutout());
        RenderTypeLookup.setRenderLayer(CroodsBlocks.DESERT_BAOBAB_SAPLING.get(), RenderType.cutout());
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void itemColors(ColorHandlerEvent.Item event) {
        ItemColors handler = event.getItemColors();
        IItemColor eggColor = (stack, tintIndex) -> ((CroodsSpawnEggItem) stack.getItem()).getColor(tintIndex);
        for (CroodsSpawnEggItem e : CroodsSpawnEggItem.UNADDED_EGGS) handler.register(eggColor, e);
    }
}
