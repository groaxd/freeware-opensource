package freeware;

public class Eagle extends Module {
   public static boolean AN = false;

   public Eagle() {
      super("Speed Bridge", 33);
   }

   public static boolean Am() {
      return AN;
   }

   public void AO() {
   }

   public void AP() {
      try {
         FabricReflect.writeField(TransformerHelpers.getMinecraft().gameSettings.keyBindSneak, false, "f", "pressed");
      } catch (Exception var2) {
      }

   }

   public void AQ() {
      AN = !AN;
   }
}
