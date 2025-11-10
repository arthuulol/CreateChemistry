package com.toabars.createchemistry.registrate;

import com.tterrag.registrate.util.entry.BlockEntry;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.Tags;

import static com.simibubi.create.foundation.data.TagGen.pickaxeOnly;
import static com.simibubi.create.foundation.data.TagGen.tagBlockAndItem;
import static com.toabars.createchemistry.MainClass.REGISTRATE;

public class Blocks {
    //public static BlockEntry<Block> SHIT_BLOCK = REGISTRATE.block("shit_block", Block::new)
    //.register();

    public static BlockEntry<Block> SULFUR_ORE = REGISTRATE.block("sulfur_ore", Block::new)
        .initialProperties(() -> net.minecraft.world.level.block.Blocks.GOLD_ORE)
        .properties(p -> p.mapColor(MapColor.METAL)
            .requiresCorrectToolForDrops()
            .sound(SoundType.STONE))
        .transform(pickaxeOnly())
        .loot((lt, b) ->  {
            HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = lt.getRegistries().lookupOrThrow(Registries.ENCHANTMENT);

            lt.add(b,
                lt.createSilkTouchDispatchTable(b,
                    lt.applyExplosionDecay(b, LootItem.lootTableItem(Items.SULFUR.get())
                        .apply(ApplyBonusCount.addOreBonusCount(enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE))))));
        })
        .tag(BlockTags.NEEDS_IRON_TOOL)
        .tag(Tags.Blocks.ORES)
        .transform(tagBlockAndItem("ores/sulfur", "ores_in_ground/stone"))
        .tag(Tags.Items.ORES)
        .build()
        .register();

    public static BlockEntry<Block> DEEPSLATE_SULFUR_ORE = REGISTRATE.block("deepslate_sulfur_ore", Block::new)
        .initialProperties(() -> net.minecraft.world.level.block.Blocks.DEEPSLATE_GOLD_ORE)
        .properties(p -> p.mapColor(MapColor.METAL)
            .requiresCorrectToolForDrops()
            .sound(SoundType.STONE))
        .transform(pickaxeOnly())
        .loot((lt, b) ->  {
            HolderLookup.RegistryLookup<Enchantment> enchantmentRegistryLookup = lt.getRegistries().lookupOrThrow(Registries.ENCHANTMENT);

            lt.add(b,
                lt.createSilkTouchDispatchTable(b,
                    lt.applyExplosionDecay(b, LootItem.lootTableItem(Items.SULFUR.get())
                        .apply(ApplyBonusCount.addOreBonusCount(enchantmentRegistryLookup.getOrThrow(Enchantments.FORTUNE))))));
        })
        .tag(BlockTags.NEEDS_IRON_TOOL)
        .tag(Tags.Blocks.ORES)
        .transform(tagBlockAndItem("ores/sulfur", "ores_in_ground/deepslate"))
        .tag(Tags.Items.ORES)
        .build()
        .register();

    public static void register(IEventBus modEventBus) {}
}
