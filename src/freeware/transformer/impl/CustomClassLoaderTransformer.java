package freeware.transformer.impl;

import freeware.Agent;
import freeware.Transformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.*;

public class CustomClassLoaderTransformer extends Transformer {
    private static String BF() {
        return Agent.class.getProtectionDomain().getCodeSource().getLocation().getPath();
    }

    public void transform(final ClassReader classReader, final ClassNode classNode) {
        if (classNode.name.equals("ks")) {
            for (final MethodNode methodNode : classNode.methods) {
                if (methodNode.name.equals("<init>") && methodNode.desc.equals("([Ljava/net/URL;)V")) {
                    final LabelNode labelNode = new LabelNode();
                    final InsnList list = new InsnList();
                    list.add(labelNode);
                    list.add(new VarInsnNode(ALOAD, 0));
                    list.add(new TypeInsnNode(NEW, "java/io/File"));
                    list.add(new InsnNode(DUP));
                    list.add(new LdcInsnNode(BF()));
                    list.add(new MethodInsnNode(INVOKESPECIAL, "java/io/File", "<init>", "(Ljava/lang/String;)V"));
                    list.add(new MethodInsnNode(INVOKEVIRTUAL, "java/io/File", "toURI", "()Ljava/net/URI;"));
                    list.add(new MethodInsnNode(INVOKEVIRTUAL, "java/net/URI", "toURL", "()Ljava/net/URL;"));
                    list.add(new MethodInsnNode(INVOKEVIRTUAL, "ks", "addURL", "(Ljava/net/URL;)V"));
                    methodNode.instructions.add(list);
                    AbstractInsnNode[] array;
                    for (int length = (array = methodNode.instructions.toArray()).length, i = 0; i < length; ++i) {
                        final AbstractInsnNode abstractInsnNode = array[i];
                        if (abstractInsnNode.getOpcode() == RETURN) { // brainless trick lmao
                            methodNode.instructions.set(abstractInsnNode, new JumpInsnNode(GOTO, labelNode));
                            methodNode.instructions.add(abstractInsnNode);
                        }
                    }
                }
            }
        }
    }
}
