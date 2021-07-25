package com.KyMann.PrimevalMobsFabric.entity.Renderer;

import com.KyMann.PrimevalMobsFabric.PrimevalMobs;
import com.KyMann.PrimevalMobsFabric.entity.SupportCreeperEntity;
import com.KyMann.PrimevalMobsFabric.entity.model.SupportCreeperModel;
import com.KyMann.PrimevalMobsFabric.registry.ModEntityRenderers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.MobEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class SupportCreeperRenderer extends MobEntityRenderer<SupportCreeperEntity, SupportCreeperModel> {
    private static final Identifier Texture = new Identifier(PrimevalMobs.MOD_ID, "textures/entities/supportcreeper.png");

    public SupportCreeperRenderer(EntityRendererFactory.Context context) {
        super(context, new SupportCreeperModel(context.getPart(ModEntityRenderers.SUPPORT_CREEPER_LAYER)), 0.5f);
    }

    @Override
    public Identifier getTexture(SupportCreeperEntity entity) {
        return Texture;
    }
}
