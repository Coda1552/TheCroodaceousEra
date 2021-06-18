package coda.thecroodaceousera.client.model;

import com.google.common.collect.ImmutableList;
import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.client.renderer.entity.model.AgeableModel;
import net.minecraft.client.renderer.entity.model.EntityModel;
import net.minecraft.client.renderer.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Collections;

@OnlyIn(Dist.CLIENT)
public class MousephantModel<T extends Entity> extends AgeableModel<T> {
    public ModelRenderer body;
    public ModelRenderer head;
    public ModelRenderer tail;
    public ModelRenderer frontpawleft;
    public ModelRenderer frontpawright;
    public ModelRenderer hindpawright;
    public ModelRenderer hindpawleft;
    public ModelRenderer earleft;
    public ModelRenderer earright;
    public ModelRenderer trunk;
    public ModelRenderer tuskleft;
    public ModelRenderer tuskright;

    public MousephantModel() {
        this.texWidth = 32;
        this.texHeight = 16;
        this.hindpawleft = new ModelRenderer(this, 13, 2);
        this.hindpawleft.setPos(1.5F, 1.5F, 2.5F);
        this.hindpawleft.addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hindpawleft, 0.0F, -0.4363323129985824F, 0.0F);
        this.trunk = new ModelRenderer(this, 0, 0);
        this.trunk.setPos(0.0F, -1.0F, -2.5F);
        this.trunk.addBox(-0.5F, -0.5F, -1.0F, 1.0F, 3.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.tuskright = new ModelRenderer(this, 24, 2);
        this.tuskright.setPos(-1.0F, -1.0F, -2.5F);
        this.tuskright.addBox(0.0F, -1.0F, -4.0F, 0.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tuskright, -0.2617993877991494F, 0.3490658503988659F, -0.2617993877991494F);
        this.body = new ModelRenderer(this, 0, 0);
        this.body.setPos(0.0F, 21.5F, 0.0F);
        this.body.addBox(-2.0F, -1.5F, -2.5F, 4.0F, 3.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.frontpawleft = new ModelRenderer(this, 14, 0);
        this.frontpawleft.setPos(1.0F, 1.5F, -2.0F);
        this.frontpawleft.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.head = new ModelRenderer(this, 19, 0);
        this.head.setPos(0.0F, -0.5F, -1.5F);
        this.head.addBox(-1.5F, -3.0F, -3.0F, 3.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F);
        this.frontpawright = new ModelRenderer(this, 14, 0);
        this.frontpawright.setPos(-1.0F, 1.5F, -2.0F);
        this.frontpawright.addBox(-0.5F, 0.0F, -0.5F, 1.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F);
        this.earleft = new ModelRenderer(this, 24, 10);
        this.earleft.setPos(0.5F, -3.0F, -0.5F);
        this.earleft.addBox(0.0F, -1.5F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(earleft, 0.0F, 0.0F, 0.17453292519943295F);
        this.hindpawright = new ModelRenderer(this, 13, 2);
        this.hindpawright.setPos(-1.5F, 1.5F, 2.5F);
        this.hindpawright.addBox(-0.5F, 0.0F, -2.0F, 1.0F, 1.0F, 2.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(hindpawright, 0.0F, 0.4363323129985824F, 0.0F);
        this.earright = new ModelRenderer(this, 24, 10);
        this.earright.mirror = true;
        this.earright.setPos(-0.5F, -3.0F, -0.5F);
        this.earright.addBox(-3.0F, -1.5F, 0.0F, 3.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(earright, 0.0F, 0.0F, -0.17453292519943295F);
        this.tuskleft = new ModelRenderer(this, 24, 2);
        this.tuskleft.mirror = true;
        this.tuskleft.setPos(1.0F, -1.0F, -2.5F);
        this.tuskleft.addBox(0.0F, -1.0F, -4.0F, 0.0F, 3.0F, 4.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tuskleft, -0.2617993877991494F, -0.3490658503988659F, 0.2617993877991494F);
        this.tail = new ModelRenderer(this, 0, 8);
        this.tail.setPos(0.0F, -1.0F, 2.5F);
        this.tail.addBox(-0.5F, 0.0F, 0.0F, 1.0F, 1.0F, 5.0F, 0.0F, 0.0F, 0.0F);
        this.setRotateAngle(tail, -0.46914448828868976F, 0.0F, 0.0F);
        this.body.addChild(this.hindpawleft);
        this.head.addChild(this.trunk);
        this.head.addChild(this.tuskright);
        this.body.addChild(this.frontpawleft);
        this.body.addChild(this.head);
        this.body.addChild(this.frontpawright);
        this.head.addChild(this.earleft);
        this.body.addChild(this.hindpawright);
        this.head.addChild(this.earright);
        this.head.addChild(this.tuskleft);
        this.body.addChild(this.tail);
    }

    @Override
    protected Iterable<ModelRenderer> headParts() {
        return Collections.emptyList();
    }

    @Override
    protected Iterable<ModelRenderer> bodyParts() {
        return ImmutableList.of(body);
    }

    @Override
    public void setupAnim(T entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
        float speed = 1.8f;
        float degree = 2.0f;
        limbSwingAmount = MathHelper.clamp(limbSwingAmount, -0.5f, 0.5f);
        this.earleft.zRot = MathHelper.cos(-2.0F + limbSwing * speed * 0.4F) * degree * 0.3F * limbSwingAmount + 0.2F;
        this.earright.zRot = MathHelper.cos(-2.0F + limbSwing * speed * 0.4F) * degree * -0.3F * limbSwingAmount - 0.2F;
        this.head.y = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * degree * 0.05F * limbSwingAmount - 0.475F;
        this.trunk.xRot = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount - 0.1F;
        this.body.yRot = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.2F * limbSwingAmount;
        this.body.zRot = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.2F * limbSwingAmount;
        this.frontpawleft.xRot = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * degree * 1.2F * limbSwingAmount;
        this.frontpawright.xRot = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * degree * -1.2F * limbSwingAmount;
        this.hindpawright.xRot = MathHelper.cos(1.0F + limbSwing * speed * 0.4F) * degree * 0.9F * limbSwingAmount + 0.1F;
        this.hindpawleft.xRot = MathHelper.cos(1.0F + limbSwing * speed * 0.4F) * degree * -0.9F * limbSwingAmount + 0.1F;
        this.tail.y = MathHelper.cos(-1.0F + limbSwing * speed * 0.4F) * degree * 0.05F * limbSwingAmount - 1.0F;
        this.tail.xRot = MathHelper.cos(limbSwing * speed * 0.4F) * degree * 0.4F * limbSwingAmount - 0.5F;
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.xRot = x;
        modelRenderer.yRot = y;
        modelRenderer.zRot = z;
    }
}
