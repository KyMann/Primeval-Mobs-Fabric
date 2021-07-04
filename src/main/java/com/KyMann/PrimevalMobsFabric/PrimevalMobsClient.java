package com.KyMann.PrimevalMobsFabric;

import com.KyMann.PrimevalMobsFabric.registry.ModEntityRenderers;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class PrimevalMobsClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        //Holds Client Only Code

        ModEntityRenderers.register();

    }
}
