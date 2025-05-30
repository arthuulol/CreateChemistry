package com.toabars.createchemistry.registrate;

import com.simibubi.create.AllTags;
import com.simibubi.create.content.equipment.BuildersTeaItem;
import com.tterrag.registrate.util.entry.ItemEntry;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;

import static com.toabars.createchemistry.MainClass.REGISTRATE;

public class Items {
    //public static BlockEntry<Block> SHIT_BLOCK = REGISTRATE.block("shit_block", Block::new)
            //.register();

    //public static ItemEntry<Item> SHIT_ITEM = REGISTRATE.item("shit", Item::new)
            //.register();

    public static ItemEntry<Item> SULFUR = REGISTRATE.item("sulfur", Item::new)
            .register();

    public static ItemEntry<Item> SULFUR_DUST = REGISTRATE.item("sulfur_dust", Item::new)
            .register();

    public static ItemEntry<Item> SULFATE_DUST = REGISTRATE.item("sulfate_dust", Item::new)
            .register();

    public static ItemEntry<Item> COPPER_SULFATE = REGISTRATE.item("copper_sulfate", Item::new)
            .register();

    public static ItemEntry<Item> CALCIUM_DUST = REGISTRATE.item("calcium_dust", Item::new)
            .register();

    public static ItemEntry<Item> CALCIUM_SULFATE = REGISTRATE.item("calcium_sulfate", Item::new)
            .register();

    public static ItemEntry<Item> CALCIUM_NITRATE = REGISTRATE.item("calcium_nitrate", Item::new)
            .register();


    public static final ItemEntry<BuildersTeaItem> SULFURIC_ACID_BOTTLE = REGISTRATE.item("sulfuric_acid_bottle", BuildersTeaItem::new)
            .tag(AllTags.AllItemTags.UPRIGHT_ON_BELT.tag)
            .properties(p -> p
                    .stacksTo(16)
                    .food(new FoodProperties.Builder()
                            .alwaysEdible()
                            .effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 100, false, false, false), 1F)
                            .build()
                    )
            )
            .register();

    public static final ItemEntry<BuildersTeaItem> NITRIC_ACID_BOTTLE = REGISTRATE.item("nitric_acid_bottle", BuildersTeaItem::new)
            .tag(AllTags.AllItemTags.UPRIGHT_ON_BELT.tag)
            .properties(p -> p
                    .stacksTo(16)
                    .food(new FoodProperties.Builder()
                            .alwaysEdible()
                            .effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 100, false, false, false), 1F)
                            .build()
                    )
            )
            .register();

    public static final ItemEntry<BuildersTeaItem> ETHANOL_BOTTLE = REGISTRATE.item("ethanol_bottle", BuildersTeaItem::new)
            .tag(AllTags.AllItemTags.UPRIGHT_ON_BELT.tag)
            .properties(p -> p
                    .stacksTo(16)
                    .food(new FoodProperties.Builder()
                            .alwaysEdible()
                            .effect(() -> new MobEffectInstance(MobEffects.HARM, 1, 5, false, false, false), 1F)
                            .build()
                    )
            )
            .register();

    public static final ItemEntry<BuildersTeaItem> YEASTED_WATER_BOTTLE = REGISTRATE.item("yeasted_water_bottle", BuildersTeaItem::new)
            .tag(AllTags.AllItemTags.UPRIGHT_ON_BELT.tag)
            .properties(p -> p
                    .stacksTo(16)
                    .food(new FoodProperties.Builder()
                            .alwaysEdible()
                            .build()
                    )
            )
            .register();

    public static final ItemEntry<BuildersTeaItem> BEER_MUG = REGISTRATE.item("beer_mug", BuildersTeaItem::new)
            .tag(AllTags.AllItemTags.UPRIGHT_ON_BELT.tag)
            .properties(p -> p
                    .stacksTo(16)
                    .food(new FoodProperties.Builder()
                            .alwaysEdible()
                            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 3, 1, false, false, false), 1F)
                            .build()
                    )
            )
            .register();

    public static ItemEntry<Item> LOOSE_SOIL = REGISTRATE.item("loose_soil", Item::new)
            .register();

    public static void register(IEventBus modEventBus) {}
}

//d