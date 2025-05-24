package com.toabars.createchemistry.registrate;

import com.simibubi.create.content.fluids.VirtualFluid;
import com.tterrag.registrate.util.entry.FluidEntry;

import static com.toabars.createchemistry.MainClass.REGISTRATE;

public class Fluids {
    //public static final FluidEntry<VirtualFluid> FLUID_NAME = REGISTRATE.virtualFluid("fluid_id")
            //.lang("Readable fluid name")
            //.tag(AllTags.commonFluidTag("fluid_tag"))
            //.register();

    public static final FluidEntry<VirtualFluid> SULFURIC_ACID = REGISTRATE.virtualFluid("sulfuric_acid")
        .lang("Sulfuric acid")
        .register();

    public static void register() {}
}

// i fucking hate to texture