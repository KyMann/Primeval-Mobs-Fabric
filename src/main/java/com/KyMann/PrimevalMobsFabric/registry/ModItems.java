package com.KyMann.PrimevalMobsFabric.registry;

import com.KyMann.PrimevalMobsFabric.PrimevalMobs;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {

    //items
    public static final Item CAMOUFLAGE_PASTE = new Item(new Item.Settings().group(PrimevalMobs.PRIMEVAL_GROUP));

    //Block Items
    public static final BlockItem RAINBOW_BLOCK = new BlockItem(ModBlocks.RAINBOW_BLOCK, new Item.Settings().group(PrimevalMobs.PRIMEVAL_GROUP));

    public static void registerItems() {
        Registry.register(Registry.ITEM, new Identifier(PrimevalMobs.MOD_ID,"camouflage_paste"), CAMOUFLAGE_PASTE);
        Registry.register(Registry.ITEM, new Identifier(PrimevalMobs.MOD_ID, "rainbow_block"), RAINBOW_BLOCK);
    }
}
