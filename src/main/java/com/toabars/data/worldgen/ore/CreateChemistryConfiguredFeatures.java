package com.toabars.data.worldgen.ore;

import com.toabars.createchemistry.MainClass;
import com.toabars.createchemistry.registrate.Blocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class CreateChemistryConfiguredFeatures {
    protected static ResourceKey<ConfiguredFeature<?, ?>> SULFUR_ORE = createKey("sulfur_ore");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context)
    {
        RuleTest stoneReplaceable = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceable = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

        List<OreConfiguration.TargetBlockState> sulfurOre =
            List.of(OreConfiguration.target(stoneReplaceable, Blocks.SULFUR_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceable, Blocks.DEEPSLATE_SULFUR_ORE.get().defaultBlockState()));

        register(context, SULFUR_ORE, Feature.ORE, new OreConfiguration(sulfurOre, 4));
    }

    private static ResourceKey<ConfiguredFeature<?, ?>> createKey(String name)
    {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(MainClass.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key,
                                                                                          F feature, FC config)
    {
        context.register(key, new ConfiguredFeature<>(feature, config));
    }
}