package com.toabars.createchemistry.content.corrosive;

import com.toabars.createchemistry.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class CorrosiveItem extends Item {
    public CorrosiveItem(Properties properties) {
        super(properties);
    }

    @Override
    public ItemStack finishUsingItem(ItemStack stack, Level level, LivingEntity entity) {
        if (!level.isClientSide && entity instanceof Player player) {
            DamageSource corrosion = level.damageSources()
                    .source(DamageTypes.CORROSION);

            player.hurt(corrosion, Float.MAX_VALUE);
        }

        return super.finishUsingItem(stack, level, entity);
    }
}