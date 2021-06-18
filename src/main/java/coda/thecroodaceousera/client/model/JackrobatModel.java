package coda.thecroodaceousera.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class JackrobatModel<T extends Entity> extends EntityModel<T> {
    public ModelRenderer body;
    public ModelRenderer legRight;
    public ModelRenderer head;
    public ModelRenderer legLeft;
    public ModelRenderer armRight;
    public ModelRenderer tail;
    public ModelRenderer armLeft;
    public ModelRenderer earLeft;
    public ModelRenderer earRight;
    public ModelRenderer snout;
    public ModelRenderer wingRight;
    public ModelRenderer wingLeft;

    public JackrobatModel() {
        this.texWidth = 64;
        this.texHeight = 32;
        this.earRight = new ModelRenderer(this, 16, 0);
        this.earRight.setPos(-2.5F, -2.0F, -0.5F);
        this.earRight.addBox(-2.0F, -4.0F, 0.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.snout = new ModelRenderer(this, 0, 13);
        this.snout.setPos(0.0F, 0.0F, -2.5F);
        this.snout.addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.armRight = new ModelRenderer(this, 12, 13);
        this.armRight.setPos(-1.5F, 0.5F, -1.0F);
        this.armRight.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(armRight, -0.6981317007977318F, 0.3490658503988659F, 0.0F);
        this.wingLeft = new ModelRenderer(this, 0, 19);
        this.wingLeft.setPos(0.5F, 1.0F, 0.0F);
        this.wingLeft.addBox(0.0F, -1.0F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.earLeft = new ModelRenderer(this, 16, 0);
        this.earLeft.mirror = true;
        this.earLeft.setPos(2.5F, -2.0F, -0.5F);
        this.earLeft.addBox(-2.0F, -4.0F, 0.0F, 4.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.armLeft = new ModelRenderer(this, 12, 13);
        this.armLeft.setPos(1.5F, 0.5F, -1.0F);
        this.armLeft.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(armLeft, -0.6981317007977318F, -0.3490658503988659F, 0.0F);
        this.tail = new ModelRenderer(this, 14, 6);
        this.tail.setPos(0.0F, -1.0F, 1.5F);
        this.tail.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.legRight = new ModelRenderer(this, 8, 13);
        this.legRight.setPos(1.5F, 0.5F, 1.5F);
        this.legRight.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(legRight, -0.4363323129985824F, -0.5235987755982988F, 0.0F);
        this.legLeft = new ModelRenderer(this, 8, 13);
        this.legLeft.setPos(-1.5F, 0.5F, 1.5F);
        this.legLeft.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(legLeft, -0.4363323129985824F, 0.5235987755982988F, 0.0F);
        this.wingRight = new ModelRenderer(this, 0, 19);
        this.wingRight.mirror = true;
        this.wingRight.setPos(-0.5F, 1.0F, 0.0F);
        this.wingRight.addBox(-2.0F, -1.0F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setPos(0.0F, 21.0F, 0.0F);
        this.body.addBox(-2.0F, -1.5F, -2.0F, 4.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(body, 0.17453292519943295F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 7);
        this.head.setPos(0.0F, -0.5F, -1.5F);
        this.head.addBox(-2.5F, -2.0F, -2.5F, 5.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(head, -0.08726646259971647F, 0.0F, 0.0F);
        this.head.addChild(this.earRight);
        this.head.addChild(this.snout);
        this.body.addChild(this.armRight);
        this.armLeft.addChild(this.wingLeft);
        this.head.addChild(this.earLeft);
        this.body.addChild(this.armLeft);
        this.body.addChild(this.tail);
        this.body.addChild(this.legRight);
        this.body.addChild(this.legLeft);
        this.armRight.addChild(this.wingRight);
        this.body.addChild(this.head);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.body).forEach((modelRenderer) -> {
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entityIn.isOnGround()) {
            float speed = 1.0f;
            float degree = 1.0f;
            this.body.xRot = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.2F * limbSwingAmount + 0.18F;
            this.head.xRot = MathHelper.cos(2.0F + limbSwing * speed * 0.4F) * degree * 0.2F * limbSwingAmount - 0.1F;
            this.legRight.xRot = MathHelper.cos(1.0F + limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount - 0.42F;
            this.legRight.yRot = -0.5235987755982988F;
            this.legLeft.xRot = MathHelper.cos(1.0F + limbSwing * speed * 0.4F) * degree * -1.0F * limbSwingAmount - 0.42F;
            this.legLeft.yRot = 0.5235987755982988F;
            this.armRight.xRot = MathHelper.cos(1.0F + limbSwing * speed * 0.4F) * degree * 1.0F * limbSwingAmount - 0.65F;
            this.armRight.yRot = 0.3490658503988659F;
            this.armRight.zRot = 0.0f;
            this.armLeft.xRot = MathHelper.cos(1.0F + limbSwing * speed * 0.4F) * degree * -1.0F * limbSwingAmount - 0.65F;
            this.armLeft.yRot = -0.3490658503988659F;
            this.armLeft.zRot = 0.0f;
            this.earLeft.xRot = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
            this.earRight.xRot = MathHelper.cos(-1.5F + limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
        }
        else {
            float speed = 3.2f;
            float degree = 1.1f;
            this.body.xRot = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.2F * limbSwingAmount - 0.3F;
            this.head.xRot = MathHelper.cos(1.0F + limbSwing * speed * 0.4F) * degree * 0.2F * limbSwingAmount + 0.4F;
            this.legRight.xRot = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * 0.45f * 0.8F * limbSwingAmount + 1.2F;
            this.legRight.yRot = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * 0.45f * 0.8F * limbSwingAmount + 0.4F;
            this.legLeft.xRot = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * 0.45f * 0.8F * limbSwingAmount + 1.2F;
            this.legLeft.yRot = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * 0.45f * -0.8F * limbSwingAmount - 0.4F;
            this.armRight.xRot = -0.6981317007977318F;
            this.armRight.yRot = 1.2F;
            this.armRight.zRot = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 2.0F * limbSwingAmount + 0.8F;
            this.armLeft.xRot = -0.6981317007977318F;
            this.armLeft.yRot = -1.2F;
            this.armLeft.zRot = MathHelper.cos(limbSwing * speed * 0.4F) * degree * -2.0F * limbSwingAmount - 0.8F;
            this.earLeft.xRot = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
            this.earRight.xRot = MathHelper.cos(-1.5F + limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
        }
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
