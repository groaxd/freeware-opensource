package freeware;

public class SpeedMine extends Module
{
    public static boolean AI;
    
    static {
        SpeedMine.AI = false;
    }
    
    public SpeedMine() {
        super("Speed Mine", 37);
    }
    
    public static boolean Aa() {
        return SpeedMine.AI;
    }
    
    public void AQ() {
        SpeedMine.AI = !SpeedMine.AI;
    }
}
