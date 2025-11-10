package com.toabars.createchemistry;

import com.toabars.data.worldgen.CreateChemistryWorldGenProvider;
import com.tterrag.registrate.providers.RegistrateDataProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.data.event.GatherDataEvent;

import java.util.concurrent.CompletableFuture;

import static com.toabars.createchemistry.MainClass.REGISTRATE;

public class RunData {
    public static void onData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        new RegistrateDataProvider(REGISTRATE, MainClass.MOD_ID, event);

        generator.addProvider(
            event.includeServer(),
            new CreateChemistryWorldGenProvider(output, lookupProvider)
        );
    }
}
