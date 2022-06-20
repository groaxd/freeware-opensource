package freeware.modules.impl;

import freeware.modules.Module;
import freeware.rawfeatures.onMotionUpdate;

public class KillAura extends Module
{
    public static boolean state1 = false;

    
    public KillAura() {
        super("Kill Aura", 19);
    }
    

    
    public void onDisable() {
        onMotionUpdate.AR = false;
    }
    
    public void onToggle() {
        state1 = !state1;
    }
}
