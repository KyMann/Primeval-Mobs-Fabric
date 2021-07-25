package com.KyMann.PrimevalMobsFabric.entity.model;

import com.KyMann.PrimevalMobsFabric.entity.ChameleonEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.client.util.math.MatrixStack;


public class ChameleonModel<T extends ChameleonEntity> extends CompositeEntityModel<T> {

    private final ModelPart body;
    private final ModelPart body2;
    private final ModelPart tail;
    private final ModelPart head;
    private final ModelPart head2;
    private final ModelPart leftEye;
    private final ModelPart rightEye;
    private final ModelPart leftFrontLeg;
    private final ModelPart leftFrontFoot;
    private final ModelPart leftBackLeg;
    private final ModelPart leftBackFoot;
    private final ModelPart rightFrontLeg;
    private final ModelPart rightFrontFoot;
    private final ModelPart rightBackLeg;
    private final ModelPart rightBackFoot;
    private final ModelPart tongue1;
    private final ModelPart tongue2;
    private T TLastAnimated;


    public ChameleonModel(ModelPart root) {
        this.body = root.getChild("body");
        this.body2 = root.getChild("body2");
        this.tail = root.getChild("tail");

        this.head = root.getChild("head");
        this.head2 = root.getChild("head2");
        this.leftEye = root.getChild("leftEye");
        this.rightEye = root.getChild("rightEye");
        this.tongue1 = root.getChild("tongue1");
        this.tongue2 = root.getChild("tongue2");

        this.leftFrontLeg = root.getChild("leftFrontLeg");
        this.leftFrontFoot = root.getChild("leftFrontFoot");

        this.leftBackLeg = root.getChild("leftBackLeg");
        this.leftBackFoot = root.getChild("leftBackFoot");

        this.rightFrontLeg = root.getChild("rightFrontLeg");
        this.rightFrontFoot = root.getChild("rightFrontFoot");

        this.rightBackLeg = root.getChild("rightBackLeg");
        this.rightBackFoot = root.getChild("rightBackFoot");
    }
    public static TexturedModelData getTexturedModelData() {
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData modelPartDataBody = modelPartData.addChild("body", ModelPartBuilder.create().uv(0,0).cuboid(-2,-1,0,4,4,6), ModelTransform.of(0,20,-4, 0.1487144F,0,0));
        ModelPartData modelPartDataBodyHump = modelPartData.addChild("body2", ModelPartBuilder.create().uv(0,11).cuboid(-1.5F,-2F,5.5F,3,3,2), ModelTransform.of(0,20,-4, -0.0743572F,0,0));
        modelPartData.addChild("tail", ModelPartBuilder.create().uv(0,17).cuboid(-1,-1,-0.2F,2,4,4), ModelTransform.of(0,20,3,-0.4461433F,0F,-0.59485578F));

        ModelPartData modelPartDataHead = modelPartData.addChild("head", ModelPartBuilder.create().uv(25,0).cuboid(-1.5F,-1.5F,-3.5F,3,3,4), ModelTransform.of(0F,21F,-4F, 0.2974289F,0,0));
        modelPartData.addChild("head2", ModelPartBuilder.create().uv(25,8).cuboid(-1F,-2F,-3F,2,4,2), ModelTransform.of(0,21,-4F, -0.7063936F,0,0));
        modelPartData.addChild("leftEye", ModelPartBuilder.create().uv(34,8).cuboid(1.3F,-0.5F,-2F,1,1,1), ModelTransform.of(0,21,-4F, 0.1115358F, 0.2230717F, -0.0743572F));
        modelPartData.addChild("rightEye", ModelPartBuilder.create().uv(34,11).cuboid(-2.3F,-0.5F,-2F,1,1,1), ModelTransform.of(0,21,-4F,0.1115358F, -0.2230717F, 0.0743572F));
        modelPartData.addChild("tongue1", ModelPartBuilder.create().uv(25,15).cuboid(-0.5F,0F,-7.4F,1,0,4), ModelTransform.of(0,21,-4, 0.2974216F,0,0));
        modelPartData.addChild("tongue2", ModelPartBuilder.create().uv(25,15).cuboid(-0.5F,0F,-8.4F,1,1,1), ModelTransform.of(0,21,-4, 0.2974216F,0,0));

        ModelPartData modelPartDataLeftFrontLeg = modelPartData.addChild("leftFrontLeg", ModelPartBuilder.create().uv(45,0).cuboid(-0.5F,0F,-0.5F,1,2,1), ModelTransform.of(2,21,-3.5F,1.115358F, 0.2974367F, 0.1115513F));
        modelPartData.addChild("leftFrontFoot", ModelPartBuilder.create().uv(45,4).cuboid(-0.5F,-0.5F,2F,1,3,1), ModelTransform.of(2,21,-3.5F,-0.4635966F, 0.297439F, 0.111544F));

        ModelPartData modelPartDataLeftBackLeg = modelPartData.addChild("leftBackLeg", ModelPartBuilder.create().uv(45,9).cuboid(-0.7F,0,-0.5F,1,2,1), ModelTransform.of(1,21,3,-1.152532F, -0.8179311F, -0.1487144F));
        modelPartData.addChild("leftBackFoot", ModelPartBuilder.create().uv(45,13).cuboid(-0.7F,-0.5F,-3F,1,3,1), ModelTransform.of(1,21,3,0.426418F, -0.8179311F, -0.1487195F));

        ModelPartData modelPartDataRightFrontLeg = modelPartData.addChild("rightFrontLeg", ModelPartBuilder.create().uv(50,0).cuboid(-0.5F,0F,-0.5F,1,2,1), ModelTransform.of(-2,21,-3.5F,1.115358F, -0.297439F, -0.111544F));
        modelPartData.addChild("rightFrontFoot", ModelPartBuilder.create().uv(50,4).cuboid(-0.5F,-0.5F,2F,1,3,1), ModelTransform.of(-2,21,-3.5F,-0.4635966F, -0.297439F, -0.111544F));

        ModelPartData modelPartDataRightBackLeg = modelPartData.addChild("rightBackLeg", ModelPartBuilder.create().uv(50,9).cuboid(-0.3F,0,-0.5F,1,2,1), ModelTransform.of(-1F,21,3F,-1.152528F, 0.8179334F, 0.1487195F));
        modelPartData.addChild("rightBackFoot", ModelPartBuilder.create().uv(50,13).cuboid(-0.3F,-0.5F,-3F,1,3,1), ModelTransform.of(-1F,21F,3F,0.426418F, 0.8179311F, 0.1487195F));

        return TexturedModelData.of(modelData, 64,32);
    }

    @Override
    public void setAngles(ChameleonEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }

//    @Override
//    public void setAngles(T entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
//    }

    @Override
    public void render(MatrixStack matrixStack, VertexConsumer vertices, int light, int overlay, float red, float green, float blue, float alpha) {
        this.getParts().forEach((part) -> {
            part.render(matrixStack, vertices, light, overlay, 255F - TLastAnimated.getSkinColor()[0], 255F - TLastAnimated.getSkinColor()[1], 255F - TLastAnimated.getSkinColor()[2], 100F);
//            System.out.println(String.format("defaultRgb, %f, %f, %f", red, green, blue));
//            part.render(matrixStack, vertices, light, overlay, 10F, 245F, 245F, 100F);
        });
    }
    @Override
    public void animateModel(T entity, float limbAngle, float limbDistance, float tickDelta) {
        this.TLastAnimated = entity;
    }

    public Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of(this.head, this.head2, this.leftEye, this.rightEye);
    }

    @Override
    public Iterable<ModelPart> getParts() {

        return ImmutableList.of(this.body, this.body2, this.tail, this.head, this.head2, this.leftEye, this.rightEye, this.leftFrontLeg, this.leftFrontFoot, this.leftBackLeg, this.leftBackFoot, this.rightFrontLeg, this.rightFrontFoot, this.rightBackLeg, this.rightBackFoot);
    }


}
