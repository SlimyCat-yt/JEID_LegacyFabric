package net.fabric.jeid.mixin.core;

import net.legacyfabric.fabric.api.registry.v1.RegistryIds;
import net.legacyfabric.fabric.api.registry.v1.RegistryHelper;
import net.legacyfabric.fabric.api.registry.v1.*;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

/**
 * Removes ID limits from forge registries. These are @ModifyConstants since javac
 * automatically inlines all static final fields that are constant expressions
 * (https://docs.oracle.com/javase/specs/jls/se7/html/jls-15.html#jls-15.28)
 */

//@Mixin(value = ???, priority = 500)
public abstract class MixinGameData {
    // Remove block ID limit.
    @ModifyConstant(method = "init", constant = @Constant(intValue=4095,ordinal=0),remap=false)
    private static int getBlockIDLimit(int value) {
        return Integer.MAX_VALUE - 1;
    }
    // Remove item ID limit
    @ModifyConstant(method = "init",constant = @Constant(intValue = 31999,ordinal=0), remap=false)
    private static int getItemIDLimit(int value) {
        return Integer.MAX_VALUE - 1;
    }
}
/* Forge Yapping
@Mixin(value = GameData.class, priority = 500)
public abstract class MixinGameData {
    // @reason Removes the block ID limit.
    @ModifyConstant(method = "init", constant = @Constant(intValue = 4095, ordinal = 0), remap = false)
    private static int getBlockIDLimit(int value) {
        return Integer.MAX_VALUE - 1;
    }

    // @reason Removes the item ID limit.
    @ModifyConstant(method = "init", constant = @Constant(intValue = 31999, ordinal = 0), remap = false)
    private static int getItemIDLimit(int value) {
        return Integer.MAX_VALUE - 1;
    }

    // @reason Removes the potion ID limit.
    @ModifyConstant(method = "init", constant = @Constant(intValue = 255, ordinal = 0), remap = false)
    private static int getPotionIDLimit(int value) {
        return Integer.MAX_VALUE - 1;
    }

    // @reason Removes the biome ID limit.
    @ModifyConstant(method = "init", constant = @Constant(intValue = 255, ordinal = 1), remap = false)
    private static int getBiomeIDLimit(int value) { return Integer.MAX_VALUE - 1; }

    // @reason Removes the enchantment ID limit.
    @ModifyConstant(method = "init", constant = @Constant(intValue = Short.MAX_VALUE - 1, ordinal = 0), remap = false)
    private static int getEnchantmentIDLimit(int value) { return Integer.MAX_VALUE - 1; }
}
    */