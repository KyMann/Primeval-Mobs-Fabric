package com.KyMann.PrimevalMobsFabric.entity.Renderer;

import com.KyMann.PrimevalMobsFabric.PrimevalMobs;
import com.KyMann.PrimevalMobsFabric.registry.ModEntityRenderers;
import com.KyMann.PrimevalMobsFabric.entity.ChameleonEntity;
import com.KyMann.PrimevalMobsFabric.entity.model.ChameleonModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ChameleonRenderer extends MobEntityRenderer<ChameleonEntity, ChameleonModel<ChameleonEntity>> {
    private static final Identifier TEXTURE = new Identifier(PrimevalMobs.MOD_ID, "textures/entities/chameleon.png");

    public ChameleonRenderer(EntityRendererFactory.Context context) {
        super(context, new ChameleonModel<>(context.getPart(ModEntityRenderers.CHAMELEON_LAYER)), 0.5f);
    }

    @Override
    public void scale(ChameleonEntity chameleonEntity, MatrixStack matrixStack, float f) {
        if (chameleonEntity.isBaby()) {
            matrixStack.scale(0.5F, 0.5F, 0.5F);
        } else {
            matrixStack.scale(1.0F, 1.0F, 1.0F);
        }
    }



    @Override
    public Identifier getTexture(ChameleonEntity entity) {
        return TEXTURE;
    }
}
