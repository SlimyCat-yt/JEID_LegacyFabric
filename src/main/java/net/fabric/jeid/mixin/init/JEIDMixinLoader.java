package net.fabric.jeid.mixin.init;

import net.fabricmc.loader.api.ModContainer;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.impl.game.minecraft.patch.ModClassLoader_125_FML;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.List;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.MixinEnvironment;
import org.spongepowered.asm.mixin.Mixins;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.transformer.ext.Extensions;

@Mixin(FabricLoader.class)
public class JEIDMixinLoader {
    @Shadow
    private List<ModContainer> mods;
    @Shadow private ModClassLoader_125_FML modClassLoader125Fml;    // this1
    @Shadow private ModClassLoader_125_FML modClassLoader_125_fml;  // or this2

}

/*

//Load all mods & load mod support mixin configs. This can't be done later since constructing mods loads classes from them(?)
@Inject(method = "loadMods", at = @At(value = "INVOKE", target = "Lnet/minecraftforge/fml/common/LoadController;transition(Lnet/minecraftforge/fml/common/LoaderState;Z)V", ordinal = 1), remap = false)
private void beforeConstructingMods(List<String> nonMod, CallbackInfo ci) {
    // Add all mods to class loader
    for (ModContainer mod : mods) {
        try {
            modClassLoader.addFile(mod.getSource());
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    // Add and reload mixin configs
    Mixins.addConfiguration("mixins.jeid.modsupport.json");
    Mixins.addConfiguration("mixins.jeid.twilightforest.json");

    try {
        // This will very likely break on the next major mixin release.
        Class<?> proxyClass = Class.forName("org.spongepowered.asm.mixin.transformer.Proxy");
        Field transformerField = proxyClass.getDeclaredField("transformer");
        transformerField.setAccessible(true);
        Object transformer = transformerField.get(null);

        Class<?> mixinTransformerClass = Class.forName("org.spongepowered.asm.mixin.transformer.MixinTransformer");
        Field processorField = mixinTransformerClass.getDeclaredField("processor");
        processorField.setAccessible(true);
        Object processor = processorField.get(transformer);

        Class<?> mixinProcessorClass = Class.forName("org.spongepowered.asm.mixin.transformer.MixinProcessor");

        Field extensionsField = mixinProcessorClass.getDeclaredField("extensions");
        extensionsField.setAccessible(true);
        Object extensions = extensionsField.get(processor);

        Method selectConfigsMethod = mixinProcessorClass.getDeclaredMethod("selectConfigs", MixinEnvironment.class);
        selectConfigsMethod.setAccessible(true);
        selectConfigsMethod.invoke(processor, MixinEnvironment.getCurrentEnvironment());

        // Mixin 0.8.4+
        try {
            Method prepareConfigs = mixinProcessorClass.getDeclaredMethod("prepareConfigs", MixinEnvironment.class, Extensions.class);
            prepareConfigs.setAccessible(true);
            prepareConfigs.invoke(processor, MixinEnvironment.getCurrentEnvironment(), extensions);
            return;
        } catch (NoSuchMethodException ex) {
            // no-op
        }

        // Mixin 0.8+
        try {
            Method prepareConfigs = mixinProcessorClass.getDeclaredMethod("prepareConfigs", MixinEnvironment.class);
            prepareConfigs.setAccessible(true);
            prepareConfigs.invoke(processor, MixinEnvironment.getCurrentEnvironment());
            return;
        } catch (NoSuchMethodException ex) {
            // no-op
        }

        throw new UnsupportedOperationException("Unsupported Mixin");
    } catch (Exception ex) {
        throw new RuntimeException(ex);
    }
}
}

 */