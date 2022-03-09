package com.KyMann.PrimevalMobsFabric;

import com.KyMann.PrimevalMobsFabric.registry.*;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class PrimevalMobs implements ModInitializer {
    //Holds all the Registration

    public static final String MOD_ID = "primeval";

    public static final ItemGroup PRIMEVAL_GROUP = FabricItemGroupBuilder.build(
            new Identifier(MOD_ID, "primeval_group"),
            () -> new ItemStack(ModItems.CAMOUFLAGE_PASTE)
    );

    @Override
    public void onInitialize() {
        ModBlocks.registerBlocks();
        ModItems.registerItems();
        ModEntities.registerEntities();
        ModEntityRenderers.register();
        SpawnRegistry.register();
    }

}
