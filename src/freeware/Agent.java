package freeware;

import java.io.File;
import java.lang.instrument.Instrumentation;
import java.text.SimpleDateFormat;

public class Agent {
    public static void agentmain(String var0, Instrumentation var1) {
        premain(var0, var1);
    }

    public static void premain(String var0, Instrumentation var1) {
        String var2 = "C:\\freeware\\config.txt";
        File var3 = new File(var2);
        System.out.println("Eger bu hileye para verdiysen dolandirildin, Discord : https://discord.gg/NJRjx2MKEJ");
        SimpleDateFormat var4 = new SimpleDateFormat("MM/dd/yyyy HH");
        if (var0.replace('.', '/').replace('-', ' ').equals(var4.format(var3.lastModified()))) {
            System.out.println("success, starting in a second");
            Transformer.initialize = true;
        } else {
            System.out.println("Yanlış şeyler deniyorsun...");
            Transformer.initialize = false;
            System.exit(0);
        }

        var1.addTransformer(new CustomClassLoaderTransformer(), true);
        var1.addTransformer(new FastPlaceTransformer(), true);
        var1.addTransformer(new AntikYontemTransformer(), true);
        var1.addTransformer(new ListenKeyTransformer(), true);
        var1.addTransformer(new NoKnockbackTransformer(), true);
        var1.addTransformer(new HelperTransformer(), true);
        var1.addTransformer(new Render2DTransformer(), true);
        var1.addTransformer(new onMotionUpdateTransformer(), true);
    }
}
