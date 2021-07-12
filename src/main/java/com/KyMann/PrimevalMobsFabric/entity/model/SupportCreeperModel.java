package com.KyMann.PrimevalMobsFabric.entity.model;

import com.KyMann.PrimevalMobsFabric.entity.SupportCreeperEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;

public class SupportCreeperModel extends AnimalModel<SupportCreeperEntity> {

    private final ModelPart body;
    private final ModelPart head;
    private final ModelPart right_hind_leg;
    private final ModelPart left_hind_leg;
    private final ModelPart right_front_leg;
    private final ModelPart left_front_leg;

    public SupportCreeperModel(ModelPart root) {

        this.body = root.getChild(EntityModelPartNames.BODY);
        this.head = root.getChild(EntityModelPartNames.HEAD);
        this.right_hind_leg = root.getChild(EntityModelPartNames.RIGHT_HIND_LEG);
        this.right_front_leg = root.getChild(EntityModelPartNames.RIGHT_FRONT_LEG);
        this.left_front_leg = root.getChild(EntityModelPartNames.LEFT_FRONT_LEG);
        this.left_hind_leg = root.getChild(EntityModelPartNames.LEFT_HIND_LEG);
    }

    public static TexturedModelData getTexturedModelData() {
        // this method is used to make texture info available to other Models
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        modelPartData.addChild(EntityModelPartNames.HEAD, ModelPartBuilder.create().uv(0, 0).cuboid(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), ModelTransform.pivot(0.0F, 6.0F, 0.0F));
        modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create().uv(16, 16).cuboid(-4.0F, 0.0F, -2.0F, 8.0F, 12.0F, 4.0F), ModelTransform.pivot(0.0F, 6.0F, 0.0F));
        ModelPartBuilder modelPartBuilder = ModelPartBuilder.create().uv(0, 16).cuboid(-2.0F, 0.0F, -2.0F, 4.0F, 6.0F, 4.0F);
        modelPartData.addChild(EntityModelPartNames.RIGHT_HIND_LEG, modelPartBuilder, ModelTransform.pivot(-2.0F, 18.0F, 4.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_HIND_LEG, modelPartBuilder, ModelTransform.pivot(2.0F, 18.0F, 4.0F));
        modelPartData.addChild(EntityModelPartNames.RIGHT_FRONT_LEG, modelPartBuilder, ModelTransform.pivot(-2.0F, 18.0F, -4.0F));
        modelPartData.addChild(EntityModelPartNames.LEFT_FRONT_LEG, modelPartBuilder, ModelTransform.pivot(2.0F, 18.0F, -4.0F));
        return TexturedModelData.of(modelData, 16,16);
    }

    @Override
    public void setAngles(SupportCreeperEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }

    @Override
    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of(head);
    }

    @Override
    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of(body, head, right_front_leg, right_hind_leg, left_front_leg, left_hind_leg);
    }
}