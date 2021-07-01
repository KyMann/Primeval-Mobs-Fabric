package com.KyMann.PrimevalMobsFabric;

import net.fabricmc.api.ModInitializer;
import com.KyMann.PrimevalMobsFabric.registry.ModItems;

public class PrimevalMobs  implements ModInitializer {

    public static final String MOD_ID = "Primeval";

    @Override
    public void onInitialize() {
        ModItems.registerItems();
    }
}
