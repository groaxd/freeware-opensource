package freeware;

public class KillAura extends Module
{
    public static boolean AF;
    
    static {
        KillAura.AF = false;
    }
    
    public KillAura() {
        super("Kill Aura", 19);
    }
    
    public static boolean AT() {
        return KillAura.AF;
    }
    
    public void AP() {
        onMotionUpdate.AR = false;
    }
    
    public void AQ() {
        KillAura.AF = !KillAura.AF;
    }
}
