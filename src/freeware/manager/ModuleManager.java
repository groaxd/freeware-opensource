package freeware.manager;


import freeware.modules.impl.*;
import freeware.modules.Module;
import org.lwjgl.input.Keyboard;

import java.util.*;

public class ModuleManager {
    public static List<Module> modules = new ArrayList<>();
    public static boolean init = false;


    public static void listenKey(final int n) {
        initialize();
        final int eventKey = Keyboard.getEventKey();
        for (final Module module : modules) {
            if (module.key == eventKey) {
                module.toggle();
            }
        }
    }

    public static void initialize() {
        if (!init) {
            modules.add(new NoKnockback());
            modules.add(new ChestStealer());
            modules.add(new Eagle());
            modules.add(new AutoArmor());
            modules.add(new FastPlace());
            modules.add(new SpeedMine());
            modules.add(new KillAura());
            init = true;
        }
    }

    public static Module getModule(final String s) {
        if (s != null) {
            for (final Module module : modules) {
                if (module.name.contains(s)) {
                    return module;
                }
            }
        }
        return null;
    }

    public static Module getModule(final Class clazz) {
        if (clazz != null) {
            for (final Module module : modules) {
                if (module.getClass() == clazz) {
                    return module;
                }
            }
        }
        return null;
    }

}
