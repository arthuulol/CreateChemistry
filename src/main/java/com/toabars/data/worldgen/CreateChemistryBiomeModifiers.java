package com.toabars.data.worldgen;

import com.toabars.createchemistry.MainClass;
import com.toabars.data.worldgen.ore.CreateChemistryPlacedFeatures;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.common.world.BiomeModifiers;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class CreateChemistryBiomeModifiers {
    protected static ResourceKey<BiomeModifier> ADD_SULFUR_ORE = createKey("add_sulfur_ore");

    public static void bootstrap(BootstrapContext<BiomeModifier> context)
    {
        HolderGetter<PlacedFeature> placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        HolderGetter<Biome> biomes = context.lookup(Registries.BIOME);

        context.register(
            ADD_SULFUR_ORE,
            new BiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(CreateChemistryPlacedFeatures.SULFUR_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES
            )
        );
    }

    private static ResourceKey<BiomeModifier> createKey(String name)
    {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(MainClass.MOD_ID, name));
    }
}
