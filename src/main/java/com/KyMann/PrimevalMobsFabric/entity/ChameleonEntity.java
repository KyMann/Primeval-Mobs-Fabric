package com.KyMann.PrimevalMobsFabric.entity;

import com.KyMann.PrimevalMobsFabric.registry.ModEntities;
import net.minecraft.block.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.Tameable;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.passive.TameableEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;
import org.jetbrains.annotations.Nullable;

import java.util.Random;


public class ChameleonEntity extends TameableEntity implements Tameable {

    private float[] skinColor = {0,0,0,255};
    private float[] desiredColor = {0,0,0,255};

    public ChameleonEntity(EntityType<? extends ChameleonEntity> entityType, World world) {
        super(entityType, world);
    }

    //attributes
    public static DefaultAttributeContainer.Builder createChameleonAttributes() {
        return AnimalEntity.createLivingAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH, 8.0D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.20000000298023224D)
                .add(EntityAttributes.GENERIC_ARMOR, .9);
    }

    public void changeColor() {
        if (this.isTouchingWater()) {
            float[] waterColor = {10F, 10F, 240F, 100F};
            setSkinColor(waterColor);
        } else  if (this.isFallFlying()) {
            //TODO: if block is air => green
            //TODO: color change on love interaction?
        } else {
            //get pos
            BlockPos pos = new BlockPos((this.getX()), (this.getY() - 0.06D), (this.getZ()));
            //get block at position
            BlockState blockState = world.getBlockState(pos);
            //get color of block

            int aBlockColor = blockState.getMapColor(world, pos).color;
            float[] aBlockRGB = bitWiseColorToRGB(aBlockColor);

            setDesiredColor(aBlockRGB);
            updateColor(aBlockRGB);
        }
    }

    public float[] getSkinColor() {
        return this.skinColor;
    }

    public void setSkinColor(float[] rgba) {
        this.skinColor = rgba;
    }

    public void setDesiredColor(float[] rgba) {
        this.desiredColor = rgba;
    }

    public void updateColor(float[] newRGB) {
        if (this.skinColor != this.desiredColor) {
            float r = crossFade(this.skinColor[0], newRGB[0]);
            float g = crossFade(this.skinColor[1], newRGB[1]);
            float b = crossFade(this.skinColor[2], newRGB[2]);
            float[] newSkinColor = {r, g, b, 100};
//            System.out.println(String.format("newSkinColor = %f, %f, %f", r, g, b));
            setSkinColor(newSkinColor);
        }
    }

    public float crossFade(float startColor, float endColor) {
        if (Math.abs(startColor - endColor) < 10) {
            float currentColor = endColor;
            return currentColor;
        } else {
            float currentColor = startColor + ((endColor-startColor)/10);
            return currentColor;
        }
    }

    public float[] bitWiseColorToRGB(int binaryColor) {
        //aaaaaaaaarrrrrrrrggggggggbbbbbbbbb
        float r = binaryColor >> 16 & 0xFF;
        float g = (binaryColor >> 8) & 0xFF;
        float b = (binaryColor) & 0xFF;
        float a = (binaryColor >> 24) & 0xFF;
        float[] rgb = {r,g,b,a};
        return rgb;
    }

    @Override
    public void tick() {
        super.tick();
        this.changeColor();
    }

    //AI
    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SitGoal(this));
        this.goalSelector.add(1, new FollowOwnerGoal(this, 0.4D, 1, 25, true));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.1D));
        this.goalSelector.add(3, new LookAroundGoal(this));
        this.goalSelector.add(4, new WanderAroundGoal(this, 0.3D));
        //TODO: add swimming
        //TODO; add run away from hurt
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.getItem() == Items.FERMENTED_SPIDER_EYE;
    }

    @Override
    @Nullable
    public PassiveEntity createChild(ServerWorld world, PassiveEntity mate) {
        ChameleonEntity chameleon = ModEntities.CHAMELEON.create(this.world);
        return chameleon;
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);

        if (itemStack.isItemEqual(new ItemStack(Items.MELON_SEEDS))) {
            if (!this.isTamed()) {
                this.setOwner(player);
                this.setTamed(true);
                return itemStack.useOnEntity(player, this, hand);
            }
        }

        if (this.isOwner(player) && !itemStack.isItemEqual(new ItemStack(Items.MELON_SEEDS)) && !itemStack.isItemEqual(new ItemStack(Items.FERMENTED_SPIDER_EYE))) {
            this.setSitting(!this.isSitting());
            this.navigation.stop();
            return ActionResult.SUCCESS;
        }

        return super.interactMob(player, hand);
    }

    public static boolean canSpawn(EntityType<ChameleonEntity> chameleonEntityType, WorldAccess worldAccess, SpawnReason spawnReason, BlockPos blockPos, Random random) {
        System.out.println("Trying to spawn Chameleon" + blockPos.toShortString());

        try {
            var spawnBlock = worldAccess.getBlockState(blockPos.down());
            return !worldAccess.isWater(blockPos) && spawnBlock.isIn(ModEntities.CHAMELEON_SPAWN_BLOCKS);
        }
        catch (Exception E) {
            return true;
        }
    }
}
