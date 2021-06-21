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
public class MosquitoModel<T extends Entity> extends EntityModel<T> {
    public ModelRenderer body;
    public ModelRenderer butt;
    public ModelRenderer head;
    public ModelRenderer leftfrontleg;
    public ModelRenderer leftlastleg;
    public ModelRenderer leftmidleg;
    public ModelRenderer rightmidleg;
    public ModelRenderer rightlastleg;
    public ModelRenderer rightfrontleg;
    public ModelRenderer leftwing;
    public ModelRenderer rightwing;
    public ModelRenderer leftantenna;
    public ModelRenderer rightantenna;
    public ModelRenderer leftboi;
    public ModelRenderer rightboi;

    public MosquitoModel() {
        this.texWidth = 32;
        this.texHeight = 32;
        this.rightfrontleg = new ModelRenderer(this, 15, 0);
        this.rightfrontleg.mirror = true;
        this.rightfrontleg.setPos(-1.5F, 0.5F, -1.0F);
        this.rightfrontleg.addBox(-3.0F, -0.5F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rightfrontleg, 0.0F, -0.2617993877991494F, 0.0F);
        this.leftantenna = new ModelRenderer(this, 7, 26);
        this.leftantenna.mirror = true;
        this.leftantenna.setPos(0.5F, -1.0F, -1.0F);
        this.leftantenna.addBox(0.0F, -4.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leftantenna, 0.9599310885968813F, -0.2617993877991494F, 0.3490658503988659F);
        this.rightantenna = new ModelRenderer(this, 7, 26);
        this.rightantenna.setPos(-0.5F, -1.0F, -1.0F);
        this.rightantenna.addBox(0.0F, -4.0F, -1.0F, 0.0F, 4.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rightantenna, 0.9599310885968813F, 0.2617993877991494F, -0.3490658503988659F);
        this.leftwing = new ModelRenderer(this, 12, 21);
        this.leftwing.mirror = true;
        this.leftwing.setPos(0.5F, -1.0F, -1.0F);
        this.leftwing.addBox(0.0F, -7.0F, -0.5F, 0.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.rightwing = new ModelRenderer(this, 12, 21);
        this.rightwing.setPos(-0.5F, -1.0F, -1.0F);
        this.rightwing.addBox(0.0F, -7.0F, -0.5F, 0.0F, 7.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 0, 21);
        this.head.setPos(0.0F, 0.5F, -1.5F);
        this.head.addBox(-1.0F, -1.0F, -2.0F, 2.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.rightboi = new ModelRenderer(this, 1, 8);
        this.rightboi.setPos(-0.5F, 1.5F, -2.0F);
        this.rightboi.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rightboi, -0.2617993877991494F, 0.17453292519943295F, 0.17453292519943295F);
        this.leftlastleg = new ModelRenderer(this, 15, 0);
        this.leftlastleg.setPos(1.5F, 0.5F, 0.0F);
        this.leftlastleg.addBox(0.0F, -0.5F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leftlastleg, 0.0F, -0.2617993877991494F, 0.0F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setPos(0.0F, 17.0F, 0.0F);
        this.body.addBox(-1.5F, -1.0F, -1.5F, 3.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.rightmidleg = new ModelRenderer(this, 15, 0);
        this.rightmidleg.mirror = true;
        this.rightmidleg.setPos(-1.5F, 0.5F, -0.5F);
        this.rightmidleg.addBox(-3.0F, -0.5F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.leftfrontleg = new ModelRenderer(this, 15, 0);
        this.leftfrontleg.setPos(1.5F, 0.5F, -1.0F);
        this.leftfrontleg.addBox(0.0F, -0.5F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leftfrontleg, 0.0F, 0.2617993877991494F, 0.0F);
        this.butt = new ModelRenderer(this, 0, 9);
        this.butt.setPos(0.0F, -1.0F, 1.5F);
        this.butt.addBox(-2.5F, -1.0F, 0.0F, 5.0F, 5.0F, 6.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(butt, -0.2617993877991494F, 0.0F, 0.0F);
        this.rightlastleg = new ModelRenderer(this, 15, 0);
        this.rightlastleg.mirror = true;
        this.rightlastleg.setPos(-1.5F, 0.5F, 0.0F);
        this.rightlastleg.addBox(-3.0F, -0.5F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(rightlastleg, 0.0F, 0.2617993877991494F, 0.0F);
        this.leftmidleg = new ModelRenderer(this, 15, 0);
        this.leftmidleg.setPos(1.5F, 0.5F, -0.5F);
        this.leftmidleg.addBox(0.0F, -0.5F, 0.0F, 3.0F, 7.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.leftboi = new ModelRenderer(this, 1, 8);
        this.leftboi.setPos(0.5F, 1.5F, -2.0F);
        this.leftboi.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(leftboi, -0.2617993877991494F, -0.17453292519943295F, -0.17453292519943295F);
        this.body.addChild(this.rightfrontleg);
        this.head.addChild(this.leftantenna);
        this.head.addChild(this.rightantenna);
        this.body.addChild(this.leftwing);
        this.body.addChild(this.rightwing);
        this.body.addChild(this.head);
        this.head.addChild(this.rightboi);
        this.body.addChild(this.leftlastleg);
        this.body.addChild(this.rightmidleg);
        this.body.addChild(this.leftfrontleg);
        this.body.addChild(this.butt);
        this.body.addChild(this.rightlastleg);
        this.body.addChild(this.leftmidleg);
        this.head.addChild(this.leftboi);
    }

    @Override
    public void renderToBuffer(MatrixStack matrixStackIn, IVertexBuilder bufferIn, int packedLightIn, int packedOverlayIn, float red, float green, float blue, float alpha) {
        ImmutableList.of(this.body).forEach((modelRenderer) -> { 
            modelRenderer.render(matrixStackIn, bufferIn, packedLightIn, packedOverlayIn, red, green, blue, alpha);
        });
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float speed = 2.0f;
        float degree = 1.0f;
        this.body.y = MathHelper.cos(ageInTicks * speed * 0.3F) * degree * 0.1F * 0.5F + 17.0F;
        this.body.xRot = MathHelper.cos(ageInTicks * speed * 0.3F) * degree * 0.15F * 0.5F + 0.05F;
        this.head.xRot = MathHelper.cos(-1.0F + ageInTicks * speed * 0.3F) * degree * 0.2F * 0.5F - 0.05F;
        this.leftantenna.xRot = MathHelper.cos(-1.0F + ageInTicks * speed * 0.3F) * degree * 0.3F * 0.5F + 1.0F;
        this.rightantenna.xRot = MathHelper.cos(-1.5F + ageInTicks * speed * 0.3F) * degree * 0.3F * 0.5F + 1.0F;
        this.butt.xRot = MathHelper.cos(-2.0F + ageInTicks * speed * 0.3F) * degree * 0.2F * 0.5F - 0.25F;
        this.leftwing.zRot = MathHelper.cos(ageInTicks * speed * 0.6F) * degree * 1.8F * 0.5F + 0.8F;
        this.leftwing.yRot = MathHelper.cos(-2.0F + ageInTicks * speed * 0.6F) * degree * 1.4F * 0.5F + 0.2F;
        this.rightwing.zRot = MathHelper.cos(ageInTicks * speed * 0.6F) * degree * -1.8F * 0.5F - 0.8F;
        this.rightwing.yRot = MathHelper.cos(-2.0F + ageInTicks * speed * 0.6F) * degree * -1.4F * 0.5F - 0.2F;
        this.leftfrontleg.xRot = MathHelper.cos(-2.0F + ageInTicks * speed * 0.3F) * degree * 0.4F * 0.5F + 0.1F;
        this.leftmidleg.xRot = MathHelper.cos(-1.5F + ageInTicks * speed * 0.3F) * degree * 0.4F * 0.5F + 0.2F;
        this.leftlastleg.xRot = MathHelper.cos(-1.0F + ageInTicks * speed * 0.3F) * degree * 0.4F * 0.5F + 0.3F;
        this.rightfrontleg.xRot = MathHelper.cos(-2.5F + ageInTicks * speed * 0.3F) * degree * 0.4F * 0.5F + 0.1F;
        this.rightmidleg.xRot = MathHelper.cos(-2.0F + ageInTicks * speed * 0.3F) * degree * 0.4F * 0.5F + 0.2F;
        this.rightlastleg.xRot = MathHelper.cos(-1.5F + ageInTicks * speed * 0.3F) * degree * 0.4F * 0.5F + 0.3F;
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
