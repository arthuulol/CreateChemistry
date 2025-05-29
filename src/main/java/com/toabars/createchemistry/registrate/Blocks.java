package com.toabars.createchemistry.registrate;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.world.level.block.Block;
import net.neoforged.bus.api.IEventBus;

import static com.toabars.createchemistry.MainClass.REGISTRATE;

public class Blocks {
    //public static BlockEntry<Block> SHIT_BLOCK = REGISTRATE.block("shit_block", Block::new)
    //.register();

    public static BlockEntry<Block> SULFUR_ORE = REGISTRATE.block("sulfur_ore", Block::new)
        .register();

    public static void register(IEventBus modEventBus) {}
}
