package com.KyMann.PrimevalMobsFabric.registry;

import com.KyMann.PrimevalMobsFabric.PrimevalMobs;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
//import net.fabricmc.fabric.api.tool.attribute.v1.FabricToolTags;
//TODO: find the new tool tag class
import net.minecraft.block.Block;
import net.minecraft.block.Material;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModBlocks {

    public static final Block RAINBOW_BLOCK = new Block(FabricBlockSettings
            .of(Material.WOOL)
            //.breakByTool(FabricToolTags.SHEARS)
            .strength(0.2f, 1.1f)
            .sounds(BlockSoundGroup.WOOL)
    );

    public static void registerBlocks() {
        Registry.register(Registry.BLOCK, new Identifier(PrimevalMobs.MOD_ID, "rainbow_block"), RAINBOW_BLOCK);
    }
}
