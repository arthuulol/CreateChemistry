package com.toabars.data.worldgen;

import com.toabars.createchemistry.MainClass;
import com.toabars.data.worldgen.ore.CreateChemistryConfiguredFeatures;
import com.toabars.data.worldgen.ore.CreateChemistryPlacedFeatures;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

import java.util.Set;
import java.util.concurrent.CompletableFuture;

public class CreateChemistryWorldGenProvider extends DatapackBuiltinEntriesProvider {
    public CreateChemistryWorldGenProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries)
    {
        super(output, registries, new RegistrySetBuilder()
                .add(Registries.CONFIGURED_FEATURE, CreateChemistryConfiguredFeatures::bootstrap)
                .add(Registries.PLACED_FEATURE, CreateChemistryPlacedFeatures::bootstrap)
                .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, CreateChemistryBiomeModifiers::bootstrap),
                Set.of(MainClass.MOD_ID));
    }
}
