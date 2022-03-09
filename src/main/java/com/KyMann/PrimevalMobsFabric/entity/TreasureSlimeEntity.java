package com.KyMann.PrimevalMobsFabric.entity;

import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.mob.PathAwareEntity;
import net.minecraft.entity.mob.SlimeEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;


public class TreasureSlimeEntity extends SlimeEntity {
    private static TrackedData<Integer> SLIME_SIZE;


    public TreasureSlimeEntity(EntityType<? extends SlimeEntity> entityType, World world) {
        super(entityType, world);
        this.experiencePoints = 3;
        this.setHealth(40f);
    }

    @Nullable
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason, @Nullable EntityData entityData, @Nullable NbtCompound entityNbt) {
        int i = this.random.nextInt(3);
        if (i < 2 && this.random.nextFloat() < 0.5F * difficulty.getClampedLocalDifficulty()) {
            ++i;
        }
        int j = 1 << i;
        this.setSize(j, true);
        return super.initialize(world, difficulty, spawnReason, entityData, entityNbt);
    }

    protected void setSize(int size, boolean heal) {
        int i = MathHelper.clamp((int)size, (int)1, (int)127);
        this.dataTracker.set(SLIME_SIZE, i);
        this.refreshPosition();
        this.calculateDimensions();
        this.getAttributeInstance(EntityAttributes.GENERIC_MAX_HEALTH).setBaseValue((double)(i * i));
        this.getAttributeInstance(EntityAttributes.GENERIC_MOVEMENT_SPEED).setBaseValue((double)(0.2F + 0.1F * (float)i));
        this.getAttributeInstance(EntityAttributes.GENERIC_ATTACK_DAMAGE).setBaseValue((double)i);
        if (heal) {
            this.setHealth(this.getMaxHealth());
        }

        this.experiencePoints = i;
    }
//    public static DefaultAttributeContainer getAttributeContainer() {
//        return MobEntity
//                .createMobAttributes()
//                .add(EntityAttributes.GENERIC_MAX_HEALTH, 20D)
//                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.3D)
//                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 0.5D)
//                .build();
//    }
}
