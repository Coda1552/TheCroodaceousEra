package coda.thecroodaceousera.client.renderer;

import coda.thecroodaceousera.Croods;
import coda.thecroodaceousera.client.model.JackrobatModel;
import coda.thecroodaceousera.common.entity.JackrobatEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class JackrobatRenderer extends MobRenderer<JackrobatEntity, JackrobatModel<JackrobatEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(Croods.MOD_ID, "textures/entity/jackrobat.png");

    public JackrobatRenderer(EntityRendererManager manager) {
        super(manager, new JackrobatModel<>(), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(JackrobatEntity entity) {
        return TEXTURE;
    }
}
