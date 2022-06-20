package freeware.modules.impl;

import freeware.helper.FabricReflect;
import freeware.helper.TransformerHelpers;
import freeware.modules.Module;

public class Eagle extends Module {
   public static boolean state1 = false;

   public Eagle() {
      super("Speed Bridge", 33);
   }


   public void onDisable() {
      try {
         FabricReflect.writeField(TransformerHelpers.getMinecraft().gameSettings.keyBindSneak, false, "f", "pressed");
      } catch (Exception var2) {
      }

   }

   public void onToggle() {
      state1 = !state1;
   }
}
