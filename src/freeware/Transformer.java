package freeware;

import org.objectweb.asm.ClassReader;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.tree.*;

import java.lang.instrument.*;
import java.security.*;

public abstract class Transformer implements ClassFileTransformer, Opcodes {
    public static boolean initialize = false;
    
    @Override
    public byte[] transform(final ClassLoader classLoader, final String s, final Class clazz, final ProtectionDomain protectionDomain, final byte[] array) {
        if (initialize) {
            try {
                final ClassReader classReader = new ClassReader(array);
                final ClassNode classNode = new ClassNode();
                classReader.accept(classNode, 0);
                this.transform(classReader, classNode);
                final ClassWriter classWriter = new ClassWriter(0);
                classNode.accept(classWriter);
                return classWriter.toByteArray();
            }
            catch (Exception ex) {
                ex.printStackTrace();
                return new byte[0];
            }
        }
        System.out.println("bir şeyler yanlış");
        return array;
    }
    
    public abstract void transform(final ClassReader p0, final ClassNode p1);
}
