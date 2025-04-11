package net.fabric.jeid.network;

/*  net.minecraftforge.fml.common.network.NetworkRegistry;
    net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
    net.minecraftforge.fml.relauncher.Side;*/
import net.fabric.jeid.JEID;
import net.legacyfabric.fabric.api.networking.v1.FutureListeners;
import net.legacyfabric.fabric.api.networking.v1.PacketByteBufs;
import net.legacyfabric.fabric.api.networking.v1.PacketSender;
import net.legacyfabric.fabric.api.networking.v1.S2CPlayChannelEvents;
import net.legacyfabric.fabric.api.networking.v1.ServerPlayNetworking;
import net.minecraft.util.Identifier;

public class MessageManager {
    public static final Identifier CHANNEL = new Identifier(JEID.jeid,"jeid");

    public static void init() {

    }
/*  Forge Version
    public static final SimpleNetworkWrapper CHANNEL = NetworkRegistry.INSTANCE.newSimpleChannel("jeid");
    public static void init() {
        CHANNEL.registerMessage(BiomeArrayMessage.Handler.class, BiomeArrayMessage.class, 0, Side.CLIENT);
        CHANNEL.registerMessage(BiomeChangeMessage.Handler.class, BiomeChangeMessage.class, 1, Side.CLIENT);
    }*/
}
