package com.KyMann.PrimevalMobsFabric.entity.model;

import com.KyMann.PrimevalMobsFabric.entity.TreasureSlimeEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.AnimalModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;


public class TreasureSlimeModel extends AnimalModel<TreasureSlimeEntity> {

    private final ModelPart body;

    public TreasureSlimeModel(ModelPart root) {
        this.body = root.getChild(EntityModelPartNames.BODY);
    }

    public static TexturedModelData getTexturedModelData() {
        // this method is used to make texture info available to other Models
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create()
                .uv(0,0)
                .cuboid(-4,-4,-4,8,8,8), ModelTransform.pivot(0,20,0));
        return TexturedModelData.of(modelData, 64,32);
    }

    @Override
    public void setAngles(TreasureSlimeEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }

    @Override
    protected Iterable<ModelPart> getHeadParts() {
        return ImmutableList.of();
    }

    @Override
    protected Iterable<ModelPart> getBodyParts() {
        return ImmutableList.of(body);
    }
}
