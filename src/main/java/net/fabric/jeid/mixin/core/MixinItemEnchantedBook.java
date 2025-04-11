package net.fabric.jeid.mixin.core;

//import javax.annotation.Nullable; /*I used org.jetbrains.annotations.Nullable but prob won't work in game*/
import javax.swing.*;
import java.util.List;
/*  import net.minecraft.client.util.ITooltipFlag;
*   use ItemStack and World objects
*/

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.TooltipContext;
import net.minecraft.enchantment.Enchantment;
//import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.enchantment.EnchantmentLevelEntry;

import net.minecraft.item.Item;
import net.minecraft.item.EnchantedBookItem; // ItemEnchantedBook;
import net.minecraft.item.ItemStack;
//import net.minecraft.nbt.NBTTagCompound;
//import net.minecraft.nbt.NBTTagList;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.nbt.NbtList;
import net.minecraft.world.World;
/*  import net.minecraftforge.fml.relauncher.Side;
*   use @Environment ?
*/

//import net.minecraftforge.fml.relauncher.SideOnly;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import org.spongepowered.asm.mixin.Shadow;
import sun.awt.X11.InfoWindow;

@Mixin(EnchantedBookItem.class)
public class MixinItemEnchantedBook extends Item {
    @Shadow public static NbtList getEnchantmentNbt(ItemStack p_92110_0_) {
        NbtCompound nbtCompound = p_92110_0_.getNbtCompound();
        return nbtCompound != null ? nbtCompound.getList("StoredEnchantments",10) : new NbtList();
    }
    @Overwrite
    @Environment(EnvType.CLIENT)
    public void appendTooltips(ItemStack stack, @Nullable World world, List<String> tooltip, TooltipContext flag) {
        super.appendTooltips(stack, world, tooltip, flag):
    }
}
