package com.KyMann.PrimevalMobsFabric.entity.model;

import com.KyMann.PrimevalMobsFabric.entity.SupportCreeperEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.AnimalModel;


public class SupportCreeperModel extends AnimalModel<SupportCreeperEntity> {

    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart right_hind_leg;
    private final ModelPart left_hind_leg;
    private final ModelPart right_front_leg;
    private final ModelPart left_front_leg;

    public SupportCreeperModel(ModelPart root) {

        this.body = root.getChild("body");
        this.head = root.getChild("head");
        this.right_hind_leg = root.getChild("right_hind_leg");
        this.right_front_leg = root.getChild("right_front_leg");
        this.left_front_leg = root.getChild("left_front_leg");
        this.left_hind_leg = root.getChild("left_hind_leg");
    }

    public static TexturedModelData getTexturedModelData() {
        // this method is used to make texture info available to other Models
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        ModelPartData modelPartDataHead = modelPartData.addChild("head", ModelPartBuilder.create().uv(0,0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), ModelTransform.pivot(0.0F, 6.0F, 0.0F));

        modelPartData.addChild("body", ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F), ModelTransform.pivot(0.0F, 6.0F, 0.0F));
        ModelPartBuilder modelLegBuilder = ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F);
        modelPartData.addChild("right_hind_leg", modelLegBuilder, ModelTransform.pivot(-2.0F, 18.0F, 4.0F));
        modelPartData.addChild("left_hind_leg", modelLegBuilder, ModelTransform.pivot(2.0F, 18.0F, 4.0F));
        modelPartData.addChild("right_front_leg", modelLegBuilder, ModelTransform.pivot(-2.0F, 18.0F, -4.0F));
        modelPartData.addChild("left_front_leg", modelLegBuilder, ModelTransform.pivot(2.0F, 18.0F, -4.0F));

        return TexturedModelData.of(modelData, 64,32);
    }

    @Override
    public void setAngles(SupportCreeperEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }

    @Override
    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of(this.head);
    }

    @Override
    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of(this.body, this.head, this.right_front_leg, this.right_hind_leg, this.left_front_leg, this.left_hind_leg);
    }
}