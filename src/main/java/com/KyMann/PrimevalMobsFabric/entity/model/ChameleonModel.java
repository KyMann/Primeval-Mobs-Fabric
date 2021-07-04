package com.KyMann.PrimevalMobsFabric.entity.model;

import com.KyMann.PrimevalMobsFabric.entity.ChameleonEntity;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.model.*;
import net.minecraft.client.render.entity.model.CompositeEntityModel;
import net.minecraft.client.render.entity.model.EntityModelPartNames;


public class ChameleonModel<T extends ChameleonEntity> extends CompositeEntityModel<T> {

    private final ModelPart body;

    public ChameleonModel(ModelPart root) {
        this.body = root.getChild("body");
    }
    public static TexturedModelData getTexturedModelData() {
        // this method is used to make texture info available to other Models
        ModelData modelData = new ModelData();
        ModelPartData modelPartData = modelData.getRoot();

        modelPartData.addChild(EntityModelPartNames.BODY, ModelPartBuilder.create()
                .uv(0,0)
                .cuboid(-4,-4,-4,8,8,8), ModelTransform.pivot(0,20,0));
        return TexturedModelData.of(modelData, 16,16);
    }

    @Override
    public void setAngles(ChameleonEntity entity, float limbAngle, float limbDistance, float animationProgress, float headYaw, float headPitch) {
    }

    @Override
    public Iterable<ModelPart> getParts() {
        return ImmutableList.of(this.body);
    }
}
