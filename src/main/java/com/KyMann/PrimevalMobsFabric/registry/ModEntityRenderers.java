package com.KyMann.PrimevalMobsFabric.registry;

import com.KyMann.PrimevalMobsFabric.PrimevalMobs;
import com.KyMann.PrimevalMobsFabric.entity.Renderer.ChameleonRenderer;
import com.KyMann.PrimevalMobsFabric.entity.Renderer.TreasureSlimeRenderer;
import com.KyMann.PrimevalMobsFabric.entity.model.ChameleonModel;
import com.KyMann.PrimevalMobsFabric.entity.model.TreasureSlimeModel;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendereregistry.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

public class ModEntityRenderers {

    public static final EntityModelLayer CHAMELEON_LAYER = new EntityModelLayer(new Identifier(PrimevalMobs.MOD_ID, "chameleon_render_layer"), "chameleon_render_layer");
    public static final EntityModelLayer TREASURE_SLIME_LAYER  = new EntityModelLayer(new Identifier(PrimevalMobs.MOD_ID, "treasure_slime_render_layer"), "treasure_slime_render_layer");


    public static void register() {
        EntityRendererRegistry.INSTANCE.register(ModEntities.CHAMELEON, ChameleonRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(CHAMELEON_LAYER, ChameleonModel::getTexturedModelData);

        EntityRendererRegistry.INSTANCE.register(ModEntities.TREASURE_SLIME, TreasureSlimeRenderer::new);
        EntityModelLayerRegistry.registerModelLayer(TREASURE_SLIME_LAYER, TreasureSlimeModel::getTexturedModelData);

    }
}
