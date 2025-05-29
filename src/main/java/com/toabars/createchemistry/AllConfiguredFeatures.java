package com.toabars.createchemistry;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.Create;
import com.simibubi.create.infrastructure.worldgen.AllFeatures;
import com.simibubi.create.infrastructure.worldgen.AllLayerPatterns;
import com.simibubi.create.infrastructure.worldgen.LayerPattern;
import com.simibubi.create.infrastructure.worldgen.LayeredOreConfiguration;
import com.toabars.createchemistry.registrate.Blocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.TargetBlockState;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

import static net.minecraft.data.worldgen.features.FeatureUtils.register;

public class AllConfiguredFeatures {
	public static final ResourceKey<ConfiguredFeature<?, ?>>
				SULFUR_ORE = key("sulfur_ore");

	private static ResourceKey<ConfiguredFeature<?, ?>> key(String name) {
		return ResourceKey.create(Registries.CONFIGURED_FEATURE, Create.asResource(name));
	}

	public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> ctx) {
		RuleTest stoneOreReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
		RuleTest deepslateOreReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);

		List<TargetBlockState> zincTargetStates = List.of(
			OreConfiguration.target(stoneOreReplaceables, Blocks.SULFUR_ORE.get()
				.defaultBlockState())
			//OreConfiguration.target(deepslateOreReplaceables, AllBlocks.DEEPSLATE_ZINC_ORE.get()
				//.defaultBlockState())
		);

		register(ctx, SULFUR_ORE, Feature.ORE, new OreConfiguration(zincTargetStates, 12));
	}
}
