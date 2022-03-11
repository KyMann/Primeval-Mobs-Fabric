package com.KyMann.PrimevalMobsFabric.registry;

import com.KyMann.PrimevalMobsFabric.PrimevalMobs;
import com.KyMann.PrimevalMobsFabric.entity.ChameleonEntity;
import com.KyMann.PrimevalMobsFabric.entity.SupportCreeperEntity;
import com.KyMann.PrimevalMobsFabric.entity.TreasureSlimeEntity;

import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.item.Item;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.world.Heightmap;

public class ModEntities {

    public static final EntityType<ChameleonEntity> CHAMELEON = FabricEntityTypeBuilder.<ChameleonEntity>createMob()
            .spawnGroup(SpawnGroup.CREATURE)
            .entityFactory(ChameleonEntity::new)
            .defaultAttributes(ChameleonEntity::createChameleonAttributes)
            .dimensions(EntityDimensions.fixed(0.75f, 0.75f))
            .spawnRestriction(SpawnRestriction.Location.NO_RESTRICTIONS, Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ChameleonEntity::canSpawn)
            .build();

    //public static final Tag<Block> CHAMELEON_SPAWN_BLOCKS = TagRegistry.block(new Identifier(PrimevalMobs.MOD_ID, "chameleon_spawn_blocks"));

    public static final EntityType<TreasureSlimeEntity> TREASURE_SLIME = FabricEntityTypeBuilder
            .create(SpawnGroup.MONSTER, TreasureSlimeEntity::new)
            .dimensions(EntityDimensions.fixed(0.75f, 0.75f))
            .build();

    public static final EntityType<SupportCreeperEntity> SUPPORT_CREEPER = FabricEntityTypeBuilder
            .create(SpawnGroup.MONSTER, SupportCreeperEntity::new)
            .dimensions(EntityDimensions.fixed(0.75f, 0.75f))
            .build();

    public static void registerEntities() {
        Registry.register(Registry.ENTITY_TYPE, new Identifier(PrimevalMobs.MOD_ID, "chameleon"), CHAMELEON);
        FabricDefaultAttributeRegistry.register(CHAMELEON, ChameleonEntity.createMobAttributes());
        Registry.register(Registry.ITEM, new Identifier(PrimevalMobs.MOD_ID, "spawn_chameleon"), new SpawnEggItem(CHAMELEON, 2956072, 14192743, new Item.Settings().group(PrimevalMobs.PRIMEVAL_GROUP)));

        Registry.register(Registry.ENTITY_TYPE, new Identifier(PrimevalMobs.MOD_ID, "treasure_slime"), TREASURE_SLIME);
        FabricDefaultAttributeRegistry.register(TREASURE_SLIME, TreasureSlimeEntity.createMobAttributes());
        Registry.register(Registry.ITEM, new Identifier(PrimevalMobs.MOD_ID, "spawn_treasure_slime"), new SpawnEggItem(TREASURE_SLIME, 1110010, 0001101, new Item.Settings().group(PrimevalMobs.PRIMEVAL_GROUP)));

        Registry.register(Registry.ENTITY_TYPE, new Identifier(PrimevalMobs.MOD_ID, "support_creeper"), SUPPORT_CREEPER);
        FabricDefaultAttributeRegistry.register(SUPPORT_CREEPER, SupportCreeperEntity.createMobAttributes());
        Registry.register(Registry.ITEM, new Identifier(PrimevalMobs.MOD_ID, "mysterious_egg"), new SpawnEggItem(SUPPORT_CREEPER, 1110111, 1110111, new Item.Settings().group(PrimevalMobs.PRIMEVAL_GROUP)));
    }

}

