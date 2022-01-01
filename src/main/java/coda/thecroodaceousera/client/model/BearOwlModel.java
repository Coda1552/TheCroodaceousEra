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
public class BearOwlModel<T extends Entity> extends EntityModel<T> {
    public ModelRenderer chest;
    public ModelRenderer head;
    public ModelRenderer armRight;
    public ModelRenderer armLeft;
    public ModelRenderer body;
    public ModelRenderer tuftLeft1;
    public ModelRenderer tuftRight1;
    public ModelRenderer snout;
    public ModelRenderer tuftLeft2;
    public ModelRenderer tuftRight2;
    public ModelRenderer frontClawRight1;
    public ModelRenderer frontClawRight2;
    public ModelRenderer frontClawLeft1;
    public ModelRenderer frontClawLeft2;
    public ModelRenderer thighLeft;
    public ModelRenderer thighRight;
    public ModelRenderer tail1;
    public ModelRenderer legLeft;
    public ModelRenderer backClawLeft1;
    public ModelRenderer backClawLeft2;
    public ModelRenderer legRight;
    public ModelRenderer backClawRight2;
    public ModelRenderer backClawRight1;
    public ModelRenderer tail2;
    public ModelRenderer tailTuft;

    public BearOwlModel() {
        this.texWidth = 192;
        this.texHeight = 128;
        this.head = new ModelRenderer(this, 0, 61);
        this.head.setPos(0.0F, 2.5F, -9.5F);
        this.head.addBox(-11.0F, -7.0F, -12.0F, 22.0F, 14.0F, 12.0F, 0.0F, 0.0F, 0.0F);
        this.backClawRight2 = new ModelRenderer(this, 0, 46);
        this.backClawRight2.setPos(1.5F, 14.5F, 0.0F);
        this.backClawRight2.addBox(-1.0F, -1.5F, -4.0F, 2.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.tuftRight1 = new ModelRenderer(this, 0, 87);
        this.tuftRight1.setPos(-11.0F, -2.0F, -8.0F);
        this.tuftRight1.addBox(-7.0F, -5.0F, 0.0F, 7.0F, 14.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.snout = new ModelRenderer(this, 57, 62);
        this.snout.setPos(0.0F, 2.5F, -12.0F);
        this.snout.addBox(-4.0F, -3.5F, -3.0F, 8.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.armRight = new ModelRenderer(this, 69, 74);
        this.armRight.setPos(-8.5F, 5.5F, 0.0F);
        this.armRight.addBox(-5.0F, -3.0F, -4.0F, 8.0F, 24.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.thighLeft = new ModelRenderer(this, 94, 55);
        this.thighLeft.setPos(5.0F, -3.0F, 20.0F);
        this.thighLeft.addBox(0.0F, -3.0F, -5.0F, 8.0F, 16.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.tail2 = new ModelRenderer(this, 44, 21);
        this.tail2.setPos(0.0F, 0.0F, 27.0F);
        this.tail2.addBox(-2.0F, -2.0F, -2.0F, 4.0F, 4.0F, 28.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tail2, 0.8726646259971648F, 0.0F, 0.0F);
        this.backClawLeft1 = new ModelRenderer(this, 0, 46);
        this.backClawLeft1.setPos(1.5F, 14.5F, 0.0F);
        this.backClawLeft1.addBox(-1.0F, -1.5F, -4.0F, 2.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.backClawRight1 = new ModelRenderer(this, 0, 46);
        this.backClawRight1.setPos(-1.5F, 14.5F, 0.0F);
        this.backClawRight1.addBox(-1.0F, -1.5F, -4.0F, 2.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.backClawLeft2 = new ModelRenderer(this, 0, 46);
        this.backClawLeft2.setPos(-1.5F, 14.5F, 0.0F);
        this.backClawLeft2.addBox(-1.0F, -1.5F, -4.0F, 2.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.frontClawRight2 = new ModelRenderer(this, 0, 101);
        this.frontClawRight2.setPos(1.0F, 19.5F, -4.0F);
        this.frontClawRight2.addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.frontClawLeft1 = new ModelRenderer(this, 0, 101);
        this.frontClawLeft1.setPos(3.0F, 19.5F, -4.0F);
        this.frontClawLeft1.addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.frontClawRight1 = new ModelRenderer(this, 0, 101);
        this.frontClawRight1.setPos(-3.0F, 19.5F, -4.0F);
        this.frontClawRight1.addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.frontClawLeft2 = new ModelRenderer(this, 0, 101);
        this.frontClawLeft2.setPos(-1.0F, 19.5F, -4.0F);
        this.frontClawLeft2.addBox(-1.5F, -1.5F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.tailTuft = new ModelRenderer(this, 131, 70);
        this.tailTuft.setPos(0.0F, 0.0F, 24.0F);
        this.tailTuft.addBox(-2.5F, -2.5F, 0.0F, 5.0F, 5.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tailTuft, 0.3490658503988659F, 0.0F, 0.0F);
        this.tuftLeft2 = new ModelRenderer(this, 156, 96);
        this.tuftLeft2.mirror = true;
        this.tuftLeft2.setPos(-5.0F, -5.5F, 0.0F);
        this.tuftLeft2.addBox(0.0F, -10.5F, 0.0F, 12.0F, 11.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.tuftLeft1 = new ModelRenderer(this, 0, 87);
        this.tuftLeft1.mirror = true;
        this.tuftLeft1.setPos(11.0F, -2.0F, -8.0F);
        this.tuftLeft1.addBox(0.0F, -5.0F, 0.0F, 7.0F, 14.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.armLeft = new ModelRenderer(this, 69, 74);
        this.armLeft.setPos(8.5F, 5.5F, 0.0F);
        this.armLeft.addBox(-3.0F, -3.0F, -4.0F, 8.0F, 24.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.legRight = new ModelRenderer(this, 121, 37);
        this.legRight.setPos(-3.5F, 13.0F, -2.5F);
        this.legRight.addBox(-3.0F, -3.0F, -1.0F, 6.0F, 19.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.chest = new ModelRenderer(this, 0, 88);
        this.chest.setPos(0.0F, -2.5F, -15.0F);
        this.chest.addBox(-12.0F, -10.5F, -9.5F, 24.0F, 21.0F, 19.0F, 0.0F, 0.0F, 0.0F);
        this.tail1 = new ModelRenderer(this, 1, 24);
        this.tail1.setPos(0.0F, -4.5F, 25.0F);
        this.tail1.addBox(-3.0F, -3.0F, -3.0F, 6.0F, 6.0F, 30.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tail1, -1.0471975511965976F, 0.0F, 0.0F);
        this.thighRight = new ModelRenderer(this, 94, 55);
        this.thighRight.setPos(-5.0F, -3.0F, 20.0F);
        this.thighRight.addBox(-8.0F, -3.0F, -5.0F, 8.0F, 16.0F, 10.0F, 0.0F, 0.0F, 0.0F);
        this.tuftRight2 = new ModelRenderer(this, 156, 96);
        this.tuftRight2.setPos(5.0F, -5.5F, 0.0F);
        this.tuftRight2.addBox(-12.0F, -10.5F, 0.0F, 12.0F, 11.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.legLeft = new ModelRenderer(this, 121, 37);
        this.legLeft.setPos(3.5F, 13.0F, -2.5F);
        this.legLeft.addBox(-3.0F, -3.0F, -1.0F, 6.0F, 19.0F, 8.0F, 0.0F, 0.0F, 0.0F);
        this.body = new ModelRenderer(this, 87, 82);
        this.body.setPos(0.0F, 0.5F, 9.0F);
        this.body.addBox(-10.0F, -9.0F, -2.0F, 20.0F, 18.0F, 28.0F, 0.0F, 0.0F, 0.0F);
        this.chest.addChild(this.head);
        this.legRight.addChild(this.backClawRight2);
        this.head.addChild(this.tuftRight1);
        this.head.addChild(this.snout);
        this.chest.addChild(this.armRight);
        this.body.addChild(this.thighLeft);
        this.tail1.addChild(this.tail2);
        this.legLeft.addChild(this.backClawLeft1);
        this.legRight.addChild(this.backClawRight1);
        this.legLeft.addChild(this.backClawLeft2);
        this.armRight.addChild(this.frontClawRight2);
        this.armLeft.addChild(this.frontClawLeft1);
        this.armRight.addChild(this.frontClawRight1);
        this.armLeft.addChild(this.frontClawLeft2);
        this.tail2.addChild(this.tailTuft);
        this.tuftLeft1.addChild(this.tuftLeft2);
        this.head.addChild(this.tuftLeft1);
        this.chest.addChild(this.armLeft);
        this.thighRight.addChild(this.legRight);
        this.body.addChild(this.tail1);
        this.body.addChild(this.thighRight);
        this.tuftRight1.addChild(this.tuftRight2);
        this.thighLeft.addChild(this.legLeft);
        this.chest.addChild(this.body);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.chest).forEach((modelRenderer) -> {
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setupAnim(T entityIn, float f, float f1, float ageInTicks, float netHeadYaw, float headPitch) {
        float speed = 1.5f;
        float degree = 0.5f;

        f1 = MathHelper.clamp(f1, -0.55F, 0.55F);

        this.chest.y = MathHelper.cos(f * speed * 0.4F) * degree * 0.4F * f1 - 2.55F;
        this.chest.xRot = MathHelper.cos(-1.0F + f * speed * 0.4F) * degree * 0.4F * f1;
        this.armRight.xRot = MathHelper.cos(-1.0F + f * speed * 0.4F) * degree * 2.0F * f1;
        this.armLeft.xRot = MathHelper.cos(-2.0F + f * speed * 0.4F) * degree * 2.0F * f1;
        this.thighLeft.xRot = MathHelper.cos(-1.0F + f * speed * 0.4F) * degree * 2.0F * f1;
        this.thighRight.xRot = MathHelper.cos(-2.0F + f * speed * 0.4F) * degree * 2.0F * f1;
        this.head.y = MathHelper.cos(1.0F + f * speed * 0.4F) * degree * 0.4F * f1 + 2.5F;
        this.head.xRot = MathHelper.cos(-1.0F + f * speed * 0.4F) * degree * 0.3F * f1;
        this.body.y = MathHelper.cos(f * speed * 0.4F) * degree * 0.4F * f1 - 0.5F;
        this.tail1.xRot = MathHelper.cos(-1.0F + f * speed * 0.4F) * degree * 0.8F * f1 - 0.3F;
        this.tail2.xRot = MathHelper.cos(-3.0F + f * speed * 0.4F) * degree * 1.2F * f1 + 0.15F;
        this.tailTuft.xRot = MathHelper.cos(-4.0F + f * speed * 0.4F) * degree * 0.8F * f1 + 0.15F;
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
