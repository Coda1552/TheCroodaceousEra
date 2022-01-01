package coda.thecroodaceousera.client.model;

import coda.thecroodaceousera.common.entity.LiyoteEntity;
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
public class LiyoteModel<T extends Entity> extends EntityModel<LiyoteEntity> {
    public ModelRenderer chest;
    public ModelRenderer body;
    public ModelRenderer leftArm;
    public ModelRenderer rightArm;
    public ModelRenderer head;
    public ModelRenderer leftLeg;
    public ModelRenderer rightLeg;
    public ModelRenderer tail;
    public ModelRenderer snout;
    public ModelRenderer earLeft;
    public ModelRenderer earRight;
    public ModelRenderer tongue;

    public LiyoteModel() {
        this.texWidth = 64;
        this.texHeight = 32;
        this.tongue = new ModelRenderer(this, 32, 11);
        this.tongue.setPos(1.5F, 0.5F, -1.0F);
        this.tongue.addBox(0.0F, 0.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tongue, 0.0F, 0.0F, -0.03490658503988659F);
        this.head = new ModelRenderer(this, 0, 3);
        this.head.setPos(0.0F, 14.5F, -5.5F);
        this.head.addBox(-2.5F, -2.5F, -5.0F, 5.0F, 5.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.leftLeg = new ModelRenderer(this, 23, 22);
        this.leftLeg.setPos(1.0F, 0.0F, 6.0F);
        this.leftLeg.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leftLeg, 0.3490658503988659F, 0.0F, -0.3490658503988659F);
        this.earLeft = new ModelRenderer(this, 33, 3);
        this.earLeft.setPos(1.0F, -2.5F, -2.5F);
        this.earLeft.addBox(-0.5F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 37, 2);
        this.body.setPos(0.0F, 0.0F, 2.5F);
        this.body.addBox(-2.0F, -2.0F, -1.0F, 4.0F, 4.0F, 9.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(body, -0.2617993877991494F, 0.0F, 0.0F);
        this.rightLeg = new ModelRenderer(this, 23, 22);
        this.rightLeg.mirror = true;
        this.rightLeg.setPos(-1.0F, 0.0F, 6.0F);
        this.rightLeg.addBox(-1.0F, 0.0F, -1.0F, 2.0F, 7.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rightLeg, 0.3490658503988659F, 0.0F, 0.3490658503988659F);
        this.snout = new ModelRenderer(this, 0, 14);
        this.snout.setPos(0.0F, 1.0F, -5.0F);
        this.snout.addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.rightArm = new ModelRenderer(this, 32, 18);
        this.rightArm.mirror = true;
        this.rightArm.setPos(-2.0F, 1.5F, 0.0F);
        this.rightArm.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rightArm, -0.17453292519943295F, 0.0F, 0.2617993877991494F);
        this.chest = new ModelRenderer(this, 0, 21);
        this.chest.setPos(0.0F, 15.5F, -4.0F);
        this.chest.addBox(-3.0F, -2.5F, -2.5F, 6.0F, 5.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.tail = new ModelRenderer(this, 33, 16);
        this.tail.setPos(0.0F, 0.0F, 7.5F);
        this.tail.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 2.0F, 13.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tail, -0.17453292519943295F, 0.0F, 0.0F);
        this.leftArm = new ModelRenderer(this, 32, 18);
        this.leftArm.setPos(2.0F, 1.5F, 0.0F);
        this.leftArm.addBox(-1.0F, -1.0F, -1.0F, 2.0F, 8.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leftArm, -0.17453292519943295F, 0.0F, -0.2617993877991494F);
        this.earRight = new ModelRenderer(this, 33, 3);
        this.earRight.mirror = true;
        this.earRight.setPos(-1.0F, -2.5F, -2.5F);
        this.earRight.addBox(-5.5F, -3.0F, 0.0F, 6.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.snout.addChild(this.tongue);
        this.body.addChild(this.leftLeg);
        this.head.addChild(this.earLeft);
        this.chest.addChild(this.body);
        this.body.addChild(this.rightLeg);
        this.head.addChild(this.snout);
        this.chest.addChild(this.rightArm);
        this.body.addChild(this.tail);
        this.chest.addChild(this.leftArm);
        this.head.addChild(this.earRight);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) { 
        ImmutableList.of(this.chest, this.head).forEach((modelRenderer) -> {
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void prepareMobModel(LiyoteEntity entityIn, float limbSwing, float limbSwingAmount, float partialTick) {
        float speed = 1.0f;
        float degree = 1.5f;
        if (entityIn.isInSittingPose()) {
            this.head.xRot = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 1.1F * limbSwingAmount + 0.35F;

            this.leftLeg.xRot = -0.19826939703444338F;
            this.leftLeg.zRot = -0.3490658503988659F;

            this.rightLeg.xRot = -0.23736478492913152F;
            this.rightLeg.zRot = 0.3490658503988659F;

            this.rightArm.xRot = -0.17453292519943295F;
            this.rightArm.zRot = -0.16824974588436584F;

            this.leftArm.xRot = -0.17453292519943295F;
            this.leftArm.zRot = 0.1195550520971359F;

            this.body.xRot = -0.8595746566072073F;
            this.body.yRot = 0;

            this.chest.xRot = -0.19547687289441354F;
            this.chest.yRot = 0.0F;

            this.tail.xRot = 0.9773843811168246F;
            this.tail.yRot = 0;

            this.tongue.zRot = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount - 0.15F;
            this.earLeft.zRot = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.15F * limbSwingAmount;
            this.earRight.zRot = MathHelper.cos(0.5F + limbSwing * speed * 0.4F) * degree * -0.15F * limbSwingAmount;
        }
        else {
            limbSwingAmount = MathHelper.clamp(limbSwingAmount, -0.5f, 0.5f);

            this.leftLeg.xRot = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 1.1F * limbSwingAmount + 0.4F;
            this.rightLeg.xRot = MathHelper.cos(limbSwing * speed * 0.4F) * degree * -1.1F * limbSwingAmount + 0.4F;
            this.rightArm.xRot = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 1.1F * limbSwingAmount - 0.1F;
            this.rightArm.zRot = 0.2617993877991494F;
            this.leftArm.xRot = MathHelper.cos(limbSwing * speed * 0.4F) * degree * -1.1F * limbSwingAmount - 0.1F;
            this.leftArm.zRot = -0.2617993877991494F;
            this.body.yRot = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount;
            this.body.xRot = -0.2617993877991494F;
            this.chest.yRot = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * degree * -0.2F * limbSwingAmount;
            this.tail.xRot = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * degree * 0.3F * limbSwingAmount + 0.1F;
            this.tail.yRot = MathHelper.cos(-1.0F + limbSwing * speed * 0.2F) * degree * 0.14F * limbSwingAmount;
            this.tongue.zRot = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount - 0.15F;
            this.earLeft.zRot = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.15F * limbSwingAmount;
            this.earRight.zRot = MathHelper.cos(0.5F + limbSwing * speed * 0.4F) * degree * -0.15F * limbSwingAmount;
        }
    }

    @Override
    public void setupAnim(LiyoteEntity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        this.head.xRot = headPitch * ((float)Math.PI / 180F);
        this.head.yRot = netHeadYaw * ((float)Math.PI / 180F);
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
