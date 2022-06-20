package freeware.modules.impl;

import freeware.modules.Module;

public class FastPlace extends Module {
   public static boolean state1 = false;

   public FastPlace() {
      super("Fast Place", 45);
   }

   public static int getHardness() {
      return state1 ? 0 : 4;
   }

   public void onToggle() {
      state1 = !state1;
   }
}
