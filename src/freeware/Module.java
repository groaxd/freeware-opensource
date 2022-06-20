package freeware;

import java.util.*;

import net.minecraft.util.EnumChatFormatting;

public class Module {
    public String name;
    public int key;
    public boolean state;

    public Module(final String ac, final int ad) {
        this.name = ac;
        this.key = ad;
        this.state = false;
    }

    public Module getModule(final String s) {
        for (final Module module : ModuleManager.AG()) {
            if (module.name.trim().equalsIgnoreCase(s.trim()) || module.toString().trim().equalsIgnoreCase(s.trim())) {
                return module;
            }
        }
        return null;
    }

    public Module getModule(Class<Module> module0) {
        for (final Module module : ModuleManager.AG()) {
            if (module.getClass().equals(module0)) {
                return module;
            }
        }
        return null;
    }

    public int AJ() {
        return this.key;
    }

    public void AK(final int ad) {
        this.key = ad;
    }

    public boolean AL() {
        return this.state;
    }

    public void AM(final boolean b) {
        this.AN(this.name, b);
        if (b) {
            this.onEnable();
            this.state = true;
        } else {
            this.onDisable();
            this.state = false;
        }
    }

    public void AN(final String s, final boolean b) {
        final String string = EnumChatFormatting.DARK_GRAY + "[" + EnumChatFormatting.GOLD + "Freeware" + EnumChatFormatting.DARK_GRAY + "] ";
        String s2;
        if (b) {
            s2 = EnumChatFormatting.DARK_GREEN + "activated.";
        } else {
            s2 = EnumChatFormatting.RED + "deactivated.";
        }
        TransformerHelpers.send(string + EnumChatFormatting.LIGHT_PURPLE + s + EnumChatFormatting.GRAY + " has " + s2);
    }

    public void onEnable() {
    }

    public void onDisable() {
    }

    public void AQ() {
        if (this.state) {
            try {
                this.onEnable();
            } catch (Exception ex) {
            }
        } else {
            try {
                this.onDisable();
            } catch (Exception ex2) {
            }
        }
    }

    public String AR() {
        return this.name;
    }

    public void AS() {
        this.AM(!this.AL());
        this.AQ();
    }
}
