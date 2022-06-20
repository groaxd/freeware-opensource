package freeware;

import freeware.transformer.impl.*;

import java.io.File;
import java.lang.instrument.Instrumentation;
import java.text.SimpleDateFormat;

public class Agent {
    public static void agentmain(String arg, Instrumentation instrunmentation) {
        premain(arg, instrunmentation);
    }

    public static void premain(String arg, Instrumentation instrunmentation) {
        String var2 = "C:\\freeware\\config.txt";
        File var3 = new File(var2);
        System.out.println("Eger bu hileye para verdiysen dolandirildin, Discord : https://discord.gg/NJRjx2MKEJ");
        SimpleDateFormat var4 = new SimpleDateFormat("MM/dd/yyyy HH");
        if (arg.replace('.', '/').replace('-', ' ').equals(var4.format(var3.lastModified()))) {
            System.out.println("success, starting in a second");
            freeware.Transformer.initialize = true;
        } else {
            System.out.println("Yanlış şeyler deniyorsun...");
            freeware.Transformer.initialize = false;
            System.exit(0);
        }

        instrunmentation.addTransformer(new CustomClassLoaderTransformer(), true);
        instrunmentation.addTransformer(new FastPlaceTransformer(), true);
        instrunmentation.addTransformer(new AntikYontemTransformer(), true);
        instrunmentation.addTransformer(new ListenKeyTransformer(), true);
        instrunmentation.addTransformer(new NoKnockbackTransformer(), true);
        instrunmentation.addTransformer(new HelperTransformer(), true);
        instrunmentation.addTransformer(new Render2DTransformer(), true);
        instrunmentation.addTransformer(new onMotionUpdateTransformer(), true);
    }
}
