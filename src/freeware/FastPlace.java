package freeware;

public class FastPlace extends Module {
   public static boolean AO = false;

   public FastPlace() {
      super("Fast Place", 45);
   }

   public static boolean Aq() {
      return AO;
   }

   public static int Ar() {
      return Aq() ? 0 : 4;
   }

   public void AQ() {
      AO = !AO;
   }
}
