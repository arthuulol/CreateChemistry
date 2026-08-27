package com.toabars.createchemistry.registrate;

import com.simibubi.create.AllTags;
import com.simibubi.create.content.fluids.VirtualFluid;
import com.toabars.createchemistry.CCTags.CCFluidTags;
import com.tterrag.registrate.util.entry.FluidEntry;

import static com.toabars.createchemistry.MainClass.REGISTRATE;

public class Fluids {
    public static final FluidEntry<VirtualFluid> SULFURIC_ACID = REGISTRATE.virtualFluid("sulfuric_acid")
        .tag(CCFluidTags.SULFURIC_ACID.tag)
        .register();

    public static final FluidEntry<VirtualFluid> NITRIC_ACID = REGISTRATE.virtualFluid("nitric_acid")
        .tag(CCFluidTags.NITRIC_ACID.tag)
        .register();

    public static final FluidEntry<VirtualFluid> YEASTED_WATER = REGISTRATE.virtualFluid("yeasted_water")
        .tag(CCFluidTags.YEASTED_WATER.tag)
        .register();

    public static final FluidEntry<VirtualFluid> ETHANOL = REGISTRATE.virtualFluid("ethanol")
        .tag(CCFluidTags.ETHANOL.tag)
        .register();

    public static final FluidEntry<VirtualFluid> BEER = REGISTRATE.virtualFluid("beer")
        .tag(CCFluidTags.BEER.tag)
        .register();

    public static void register() {}
}