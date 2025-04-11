package net.fabric.jeid.mixin.core;

import com.google.common.collect.Maps;
import java.util.Map;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments; // EnchantmentData
import net.minecraft.enchantment.EnchantmentHelper;
// net.minecraft.init.Items
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.item.EnchantedBookItem; //ItemEnchantedBook
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NbtCompound; // NBTTagCompound
import net.minecraft.nbt.NbtList; // NBTTagList
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

@Mixin(EnchantmentHelper.class)
public class MixinEnchantmentHelper {
    /** @reason Mojang modifies their original types **/
    @Overwrite
    public static int getEnchantmentLevel(Enchantment enchID, ItemStack stack){
        if (stack.isEmpty()){return 0;}
        else {
            NbtList nbtList = stack.getEnchantments();
            //for (int i = 0; i < nbtList)
            return 0;
        }
    }
    /** @reason Mojang modifyies their original types **/
    @Overwrite
    public static Map<Enchantment, Integer> getEnchantments(ItemStack stack) {
        Map<Enchantment, Integer> map = Maps.<Enchantment, Integer>newLinkedHashMap();
        NbtList nbtList = stack.getItem() == Items.ENCHANTED_BOOK ? ItemEnchantedBook
    }
}
