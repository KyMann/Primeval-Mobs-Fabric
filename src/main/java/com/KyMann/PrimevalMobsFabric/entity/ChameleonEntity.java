package com.KyMann.PrimevalMobsFabric.entity;

import net.minecraft.entity.EntityType;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.world.World;

public class ChameleonEntity extends PathAwareEntity {
    public ChameleonEntity(EntityType<? extends ChameleonEntity> entityType, World world) {
        super(entityType, world);
    }
}
