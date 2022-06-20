package freeware;

public class AutoArmor extends Module {
   public static boolean AK = false;

   public AutoArmor() {
      super("Auto Armor", 44);
   }

   public static boolean Ae() {
      return AK;
   }

   public void AQ() {
      AK = !AK;
   }
}
