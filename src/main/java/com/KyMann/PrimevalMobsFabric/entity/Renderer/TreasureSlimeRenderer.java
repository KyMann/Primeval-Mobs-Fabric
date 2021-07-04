package com.KyMann.PrimevalMobsFabric.entity.Renderer;

import com.KyMann.PrimevalMobsFabric.PrimevalMobs;
import com.KyMann.PrimevalMobsFabric.entity.model.TreasureSlimeModel;
import com.KyMann.PrimevalMobsFabric.entity.TreasureSlimeEntity;
import com.KyMann.PrimevalMobsFabric.registry.ModEntityRenderers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class TreasureSlimeRenderer extends MobEntityRenderer<TreasureSlimeEntity, TreasureSlimeModel> {
    private static final Identifier Texture = new Identifier(PrimevalMobs.MOD_ID, "textures/entities/treasure_slime.png");

    public TreasureSlimeRenderer(EntityRendererFactory.Context context) {
        super(context, new TreasureSlimeModel(context.getPart(ModEntityRenderers.TREASURE_SLIME_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(TreasureSlimeEntity entity) {
        return Texture;
    }
}
