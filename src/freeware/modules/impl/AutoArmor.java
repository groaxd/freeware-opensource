package freeware.modules.impl;

import freeware.modules.Module;

public class AutoArmor extends Module {
   public static boolean state1 = false;

   public AutoArmor() {
      super("Auto Armor", 44);
   }


   public void onToggle() {
      state1 = !state1;
   }
}
