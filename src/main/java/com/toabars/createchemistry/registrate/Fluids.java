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

    public static final FluidEntry<VirtualFluid> NITRIC_ACID = REGISTRATE.virtualFluid("nitric_acid")
            .lang("Nitric acid")
            .register();

    public static final FluidEntry<VirtualFluid> YEASTED_WATER = REGISTRATE.virtualFluid("yeasted_water")
            .lang("Yeasted water")
        .register();

    public static final FluidEntry<VirtualFluid> ETHANOL = REGISTRATE.virtualFluid("ethanol")
            .lang("Ethanol")
            .register();

    public static final FluidEntry<VirtualFluid> BEER = REGISTRATE.virtualFluid("beer")
            .lang("Beer")
            .register();

    // ADD THE BEER TEXTURE

    public static void register() {}
}

// I fucking hate to texture