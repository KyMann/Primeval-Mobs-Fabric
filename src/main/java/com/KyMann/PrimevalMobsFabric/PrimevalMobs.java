package com.KyMann.PrimevalMobsFabric;

import net.fabricmc.api.ModInitializer;
import com.KyMann.PrimevalMobsFabric.registry.ModItems;

public class PrimevalMobs implements ModInitializer {

    public static final String MOD_ID = "primeval";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
    }
}
