package coda.thecroodaceousera.client.renderer;

import coda.thecroodaceousera.Croods;
import coda.thecroodaceousera.client.model.MosquitoModel;
import coda.thecroodaceousera.common.entity.MosquitoEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MosquitoRenderer extends MobRenderer<MosquitoEntity, MosquitoModel<MosquitoEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(Croods.MOD_ID, "textures/entity/mosquito.png");

    public MosquitoRenderer(EntityRendererManager manager) {
        super(manager, new MosquitoModel<>(), 0.4f);
    }

    @Override
    public ResourceLocation getTextureLocation(MosquitoEntity entity) {
        return TEXTURE;
    }
}
