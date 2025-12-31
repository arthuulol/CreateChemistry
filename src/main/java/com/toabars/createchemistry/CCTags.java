package com.toabars.createchemistry;

import net.createmod.catnip.lang.Lang;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.material.Fluid;

import static com.toabars.createchemistry.MainClass.MOD_ID;

@SuppressWarnings({"unused"})
public class CCTags {

    public enum NameSpace {
        MOD(MOD_ID),
        CREATE("create"),
        FORGE("forge"),
        MINECRAFT("minecraft");

        public final String id;

        NameSpace(String id) {
            this.id = id;
        }
    }

    /* ---------- helpers "forge:block_tag" / "forge:item_tag" ---------- */

    public static TagKey<Block> forgeBlockTag(String path) {
        return TagKey.create(Registries.BLOCK, ResourceLocation.fromNamespaceAndPath("forge", path));
    }

    public static TagKey<Item> forgeItemTag(String path) {
        return TagKey.create(Registries.ITEM, ResourceLocation.fromNamespaceAndPath("forge", path));
    }

    /* ----------------- BLOCK TAGS ENUM ----------------- */

    public enum CCBlockTags {
        SULFUR_ORES(NameSpace.MOD),
        ;

        public final TagKey<Block> tag;

        CCBlockTags(NameSpace ns) {
            this(ns, null);
        }

        CCBlockTags(NameSpace ns, String path) {
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath(
                ns.id,
                path == null ? Lang.asId(name()) : path
        );
        this.tag = BlockTags.create(id);
        }
    }

    /* ----------------- ITEM TAGS ENUM ----------------- */

    public enum CCItemTags {
        SULFUR_ORES(NameSpace.MOD),

        SULFUR_GEMS(NameSpace.FORGE, "gems/sulfur"),
        SULFUR_DUSTS(NameSpace.FORGE, "dusts/sulfur"),
        SULFATE_DUSTS(NameSpace.FORGE, "dusts/sulfate"),
        CALCIUM_DUSTS(NameSpace.FORGE, "dusts/calcium")
        ;

        public final TagKey<Item> tag;

        CCItemTags(NameSpace ns) {
            this(ns, null);
        }

        CCItemTags(NameSpace ns, String path) {
            ResourceLocation id = ResourceLocation.fromNamespaceAndPath(
                ns.id,
                path == null ? Lang.asId(name()) : path
            );
            this.tag = ItemTags.create(id);
        }
    }

    public enum CCFluidTags {
        SULFURIC_ACID("sulfuric_acid"),
        NITRIC_ACID("nitric_acid"),
        YEASTED_WATER("yeasted_water"),
        ETHANOL("ethanol"),
        BEER("beer");

        public final TagKey<Fluid> tag;

        CCFluidTags(String path) {
            this.tag = TagKey.create(
                Registries.FLUID,
                ResourceLocation.fromNamespaceAndPath("forge", path)
            );
        }
    }
}