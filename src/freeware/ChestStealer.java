package freeware;

public class ChestStealer extends Module
{
    public static boolean AJ = false;

    
    public ChestStealer() {
        super("ChestStealer", 34);
    }

    
    public void AQ() {
        ChestStealer.AJ = !ChestStealer.AJ;
    }
}
