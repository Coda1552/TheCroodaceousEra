package coda.thecroodaceousera.client.renderer;

import coda.thecroodaceousera.Croods;
import coda.thecroodaceousera.client.model.BearOwlModel;
import coda.thecroodaceousera.common.entity.BearOwlEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class BearOwlRenderer extends MobRenderer<BearOwlEntity, BearOwlModel<BearOwlEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(Croods.MOD_ID, "textures/entity/bear_owl.png");

    public BearOwlRenderer(EntityRendererManager manager) {
        super(manager, new BearOwlModel<>(), 1.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(BearOwlEntity entity) {
        return TEXTURE;
    }
}
