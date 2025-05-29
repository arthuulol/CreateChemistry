package com.toabars.createchemistry;

import com.simibubi.create.Create;
import com.toabars.createchemistry.PlacementFeatures;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class BiomeModifiers {
    public static final ResourceKey<BiomeModifier>
            SULFUR_ORE = key("SULFUR_ORE");

    private static ResourceKey<BiomeModifier> key(String name) {
        return ResourceKey.create(NeoForgeRegistries.Keys.BIOME_MODIFIERS, Create.asResource(name));
    }

    public static void bootstrap(BootstrapContext<BiomeModifier> ctx) {
        HolderGetter<Biome> biomeLookup = ctx.lookup(Registries.BIOME);
        HolderSet<Biome> isOverworld = biomeLookup.getOrThrow(BiomeTags.IS_OVERWORLD);
        HolderSet<Biome> isNether = biomeLookup.getOrThrow(BiomeTags.IS_NETHER);

        HolderGetter<PlacedFeature> featureLookup = ctx.lookup(Registries.PLACED_FEATURE);
        Holder<PlacedFeature> zincOre = featureLookup.getOrThrow(PlacementFeatures.SULFUR_ORE);
        //Holder<PlacedFeature> striatedOresOverworld = featureLookup.getOrThrow(AllPlacedFeatures.STRIATED_ORES_OVERWORLD);
        //Holder<PlacedFeature> striatedOresNether = featureLookup.getOrThrow(AllPlacedFeatures.STRIATED_ORES_NETHER);

        ctx.register(SULFUR_ORE, addOre(isOverworld, zincOre));
        //ctx.register(STRIATED_ORES_OVERWORLD, addOre(isOverworld, striatedOresOverworld));
        //ctx.register(STRIATED_ORES_NETHER, addOre(isNether, striatedOresNether));
    }

    private static net.neoforged.neoforge.common.world.BiomeModifiers.AddFeaturesBiomeModifier addOre(HolderSet<Biome> biomes, Holder<PlacedFeature> feature) {
        return new net.neoforged.neoforge.common.world.BiomeModifiers.AddFeaturesBiomeModifier(biomes, HolderSet.direct(feature), GenerationStep.Decoration.UNDERGROUND_ORES);
    }
}
