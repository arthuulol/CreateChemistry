package com.toabars.data.worldgen.ore;

import com.toabars.createchemistry.MainClass;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.PlacementModifier;

import java.util.List;

public class CreateChemistryPlacedFeatures {
    public static ResourceKey<PlacedFeature> SULFUR_ORE = createKey("sulfur_ore");

    public static void bootstrap(BootstrapContext<PlacedFeature> context)
    {
        HolderGetter<ConfiguredFeature<?, ?>> configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        Holder<ConfiguredFeature<?, ?>> holder =
            configuredFeatures.getOrThrow(CreateChemistryConfiguredFeatures.SULFUR_ORE);

        register(context, SULFUR_ORE, holder, CreateChemistryPlacement.commonOrePlacements(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64),
            VerticalAnchor.absolute(70))));
    }

    private static ResourceKey<PlacedFeature> createKey(String name)
    {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MainClass.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key,
                                 Holder<ConfiguredFeature<?, ?>> feature, List<PlacementModifier> placementModifiers)
    {
        context.register(key, new PlacedFeature(feature, placementModifiers));
    }
}