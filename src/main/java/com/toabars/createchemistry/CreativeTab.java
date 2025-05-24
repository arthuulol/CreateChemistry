package com.toabars.createchemistry;

import com.simibubi.create.AllBlocks;
import com.simibubi.create.AllCreativeModeTabs;
import com.toabars.createchemistry.registrate.Items;
import com.tterrag.registrate.util.entry.RegistryEntry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class CreativeTab {

    private static final DeferredRegister<CreativeModeTab> REGISTER =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MainClass.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> BASE_CREATIVE_TAB = REGISTER.register("based",
            () -> CreativeModeTab.builder()
                    .title(Component.literal("Create: Chemistry"))
                    .withTabsBefore(AllCreativeModeTabs.PALETTES_CREATIVE_TAB.getId())
                    .icon(() -> new ItemStack(Items.SULFUR.get()))
                    .displayItems((parameters, output) -> {
                        for (RegistryEntry<Item, Item> item : MainClass.REGISTRATE.getAll(Registries.ITEM)) {
                            output.accept(item.get());
                        }
                    }).build());

    public static void register(IEventBus modEventBus) {//call this in main
        REGISTER.register(modEventBus);
    }

}