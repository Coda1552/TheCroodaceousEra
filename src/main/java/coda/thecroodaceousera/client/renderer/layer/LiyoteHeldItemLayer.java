package coda.thecroodaceousera.client.renderer.layer;

import coda.thecroodaceousera.client.model.LiyoteModel;
import coda.thecroodaceousera.entity.LiyoteEntity;
import com.mojang.blaze3d.matrix.MatrixStack;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.entity.IEntityRenderer;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.client.renderer.model.ItemCameraTransforms;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.vector.Vector3f;

public class LiyoteHeldItemLayer extends LayerRenderer<LiyoteEntity, LiyoteModel<LiyoteEntity>> {
    public LiyoteHeldItemLayer(IEntityRenderer<LiyoteEntity, LiyoteModel<LiyoteEntity>> p_i50938_1_) {
        super(p_i50938_1_);
    }

    public void render(MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int packedLightIn, LiyoteEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        matrixStackIn.pushPose();

        matrixStackIn.translate((double)((this.getParentModel()).head.x / 16.0F), (double)((this.getParentModel()).head.y / 16.0F), (double)((this.getParentModel()).head.z / 16.0F));
        matrixStackIn.mulPose(Vector3f.YP.rotationDegrees(netHeadYaw));
        matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(headPitch));
        matrixStackIn.mulPose(Vector3f.XP.rotationDegrees(90));
        matrixStackIn.mulPose(Vector3f.ZP.rotationDegrees(90));

        matrixStackIn.translate(-0.5D, -0.1D, -0.1D);
        matrixStackIn.scale(0.9F, 0.9F, 0.9F);

        ItemStack itemstack = entitylivingbaseIn.getItemBySlot(EquipmentSlotType.MAINHAND);
        Minecraft.getInstance().getItemInHandRenderer().renderItem(entitylivingbaseIn, itemstack, ItemCameraTransforms.TransformType.GROUND, false, matrixStackIn, bufferIn, packedLightIn);
        matrixStackIn.popPose();
    }
}