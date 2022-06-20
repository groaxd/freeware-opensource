package freeware;

import net.minecraft.util.EnumChatFormatting;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class onRender2D
{
    public static void onRender2D(final int n, final int n2) {
        final String string = EnumChatFormatting.AQUA + "F" + EnumChatFormatting.WHITE + "reeware " + EnumChatFormatting.GRAY + "| " + EnumChatFormatting.WHITE + FabricReflect.getFieldValue(TransformerHelpers.getMinecraft(), "aX", "currentFps") + EnumChatFormatting.GOLD + " fps";
        GL11.glPushMatrix();
        scale(1.0f, 1.0f, 1.0f);
        TransformerHelpers.getMinecraft().fontRendererObj.drawString(string, 7.0f, 8.0f, -1, true);
        GL11.glPopMatrix();
        final String string2 = EnumChatFormatting.AQUA + "Th3GamingGhast" + "#" + EnumChatFormatting.AQUA + "2768";
        final int a = TransformerHelpers.getMinecraft().fontRendererObj.getStringWidth(string2);
        GL11.glPushMatrix();
        scale(1.0f, 1.0f, 1.0f);
        TransformerHelpers.getMinecraft().fontRendererObj.drawString(string2, 7.0f, (float)((n - a) / 2), -1, true);
        TransformerHelpers.getMinecraft().fontRendererObj.drawString(string2, (float)((n - a) / 2), 8.0f, -1, true);
        GL11.glPopMatrix();
        int n3 = 2;
        for (final Module module : ModuleManager.AA) {
            TransformerHelpers.getMinecraft().fontRendererObj.drawString(EnumChatFormatting.GOLD + "[" + Keyboard.getKeyName(module.AJ()) + "] " + (module.AL() ? EnumChatFormatting.GREEN : EnumChatFormatting.GRAY) + module.name, n - TransformerHelpers.getMinecraft().fontRendererObj.getStringWidth(module.name) - 21.0f, (float)n3, 1, true);
            n3 += 10;
        }
    }
    

    
    public static void scale(final float n, final float n2, final float n3) {
        GL11.glScalef(n, n2, n3);
    }
}
