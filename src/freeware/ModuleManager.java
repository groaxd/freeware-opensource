package freeware;


import org.lwjgl.input.Keyboard;

import java.util.*;

public class ModuleManager {
    public static List<Module> AA = new ArrayList<>();
    public static boolean init = false;


    public static void listenKey(final int n) {
        initialize();
        final int eventKey = Keyboard.getEventKey();
        for (final Module module : ModuleManager.AA) {
            if (module.key == eventKey) {
                module.onEnable();
            }
        }
    }

    public static void initialize() {
        if (!init) {
            AA.add(new NoKnockback());
            AA.add(new ChestStealer());
            AA.add(new Eagle());
            AA.add(new AutoArmor());
            AA.add(new FastPlace());
            AA.add(new SpeedMine());
            AA.add(new KillAura());
            init = true;
        }
    }

    public static Module state(final String s) {
        if (s != null) {
            for (final Module module : AG()) {
                if (module.name.toString().contains(s)) {
                    return module;
                }
            }
        }
        return null;
    }

    public static Module AF(final Class clazz) {
        if (clazz != null) {
            for (final Module module : AG()) {
                if (module.getClass() == clazz) {
                    return module;
                }
            }
        }
        return null;
    }

    public static List<Module> AG() {
        return ModuleManager.AA;
    }
}
