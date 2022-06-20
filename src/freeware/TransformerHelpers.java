package freeware;

import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.Entity;
import net.minecraft.util.BlockPos;
import net.minecraft.util.ChatComponentText;

public class TransformerHelpers {
    public static Minecraft getMinecraft() {
        return Minecraft.getMinecraft();
    }

    public static Block getBlock(final BlockPos blockPos) {
        return getMinecraft().theWorld.getBlockState(blockPos).getBlock();
    }

    public static void send(final String s) {
        try {
            getMinecraft().thePlayer.addChatMessage(new ChatComponentText(s));
        } catch (NullPointerException ex) {
        }
    }

    public static float BB(Entity current, Entity entityIn) {
        float f = (float) (current.posX - entityIn.posX);
        float f1 = (float) (current.posY - entityIn.posY);
        float f2 = (float) (current.posZ - entityIn.posZ);
        return (float) Math.sqrt(f * f + f1 * f1 + f2 * f2);
    }

    public static boolean BC() {
        return getMinecraft().currentScreen instanceof GuiInventory;
    }

}
