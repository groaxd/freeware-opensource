package freeware.modules.impl;

import freeware.modules.Module;

public class ChestStealer extends Module
{
    public static boolean state1 = false;

    
    public ChestStealer() {
        super("ChestStealer", 34);
    }

    
    public void onToggle() {
        state1 = !state1;
    }
}
