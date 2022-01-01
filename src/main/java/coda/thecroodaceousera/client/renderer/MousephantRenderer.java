package coda.thecroodaceousera.client.renderer;

import coda.thecroodaceousera.Croods;
import coda.thecroodaceousera.client.model.MousephantModel;
import coda.thecroodaceousera.common.entity.MousephantEntity;
import net.minecraft.client.renderer.entity.EntityRendererManager;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.util.ResourceLocation;

public class MousephantRenderer extends MobRenderer<MousephantEntity, MousephantModel<MousephantEntity>> {
    protected static final ResourceLocation TEXTURE = new ResourceLocation(Croods.MOD_ID, "textures/entity/mousephant.png");

    public MousephantRenderer(EntityRendererManager manager) {
        super(manager, new MousephantModel<>(), 0.2f);
    }

    @Override
    public ResourceLocation getTextureLocation(MousephantEntity entity) {
        return TEXTURE;
    }
}
