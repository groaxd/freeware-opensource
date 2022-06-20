package freeware.helper;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.*;
import java.util.*;

public class Utils
{
    public MethodNode AA(final ClassNode classNode, final String s, final String... array) {
        for (final MethodNode methodNode : classNode.methods) {
            if (s != null && !s.equals(methodNode.desc)) {
                continue;
            }
            for (int length = array.length, i = 0; i < length; ++i) {
                if (methodNode.name.equals(array[i])) {
                    return methodNode;
                }
            }
        }
        return null;
    }
    
    public static String AB(final Class<?> clazz) {
        return name(clazz.getName());
    }
    
    public static String name(final String s) {
        return s.replace('.', '/');
    }
}
