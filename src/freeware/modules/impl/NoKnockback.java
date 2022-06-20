package freeware.modules.impl;

import freeware.modules.Module;
import net.minecraft.*;
import net.minecraft.network.INetHandler;
import net.minecraft.network.Packet;
import net.minecraft.network.PacketBuffer;
import net.minecraft.network.play.server.S12PacketEntityVelocity;

public class NoKnockback extends Module
{
    public static boolean state1 = false;
    
    public NoKnockback() {
        super("No Knockback", 49);
    }

    
    public void onToggle() {
        state1 = !state1;
    }
    
    public static void packetListener(final Packet packet, INetHandler handler) {
        if (state1) {
            if (!(packet instanceof S12PacketEntityVelocity)) {
                packet.processPacket(handler);
            }
        }
        else {
            packet.processPacket(handler);
        }
    }
}
