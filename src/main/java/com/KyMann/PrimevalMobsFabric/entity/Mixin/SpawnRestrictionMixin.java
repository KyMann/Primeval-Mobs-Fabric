package com.KyMann.PrimevalMobsFabric.entity.Mixin;

import com.KyMann.PrimevalMobsFabric.entity.ChameleonEntity;
import com.KyMann.PrimevalMobsFabric.registry.ModEntities;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnRestriction;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.Heightmap;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;


@Mixin(SpawnRestriction.class)
public class SpawnRestrictionMixin {

    @Shadow
    private static <T extends MobEntity> void register(EntityType<T> type, SpawnRestriction.Location location, Heightmap.Type heightMapType, SpawnRestriction.SpawnPredicate<T> predicate) {}

    static {
        register(ModEntities.CHAMELEON, SpawnRestriction.Location.ON_GROUND,
                Heightmap.Type.MOTION_BLOCKING_NO_LEAVES, ChameleonEntity::canSpawn);
    }
}
