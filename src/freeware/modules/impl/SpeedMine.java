package freeware.modules.impl;

import freeware.modules.Module;

public class SpeedMine extends Module
{
    public static boolean state1 = false;

    
    public SpeedMine() {
        super("Speed Mine", 37);
    }
    

    
    public void onToggle() {
        state1 = !state1;
    }
}
