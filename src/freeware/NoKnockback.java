package freeware;

import net.minecraft.*;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public class NoKnockback extends Module
{
    public static boolean AH = false;
    
    public NoKnockback() {
        super("No Knockback", 49);
    }
    
    public static boolean AY() {
        return NoKnockback.AH;
    }
    
    public void AQ() {
        NoKnockback.AH = !NoKnockback.AH;
    }
    
    public static void packetListener(final Packet packet, INetHandler handler) {
        if (NoKnockback.AH) {
            if (!(packet instanceof S12PacketEntityVelocity)) {
                packet.processPacket(handler);
            }
        }
        else {
            packet.processPacket(handler);
        }
    }
}
