package freeware.transformer.impl;

import freeware.Transformer;
import freeware.manager.ModuleManager;
import freeware.helper.Utils;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.*;

public class ListenKeyTransformer extends Transformer
{
    public void transform(final ClassReader classReader, final ClassNode classNode) {
        if (classNode.name.equals("net/minecraft/client/Minecraft")) {
            for (final MethodNode methodNode : classNode.methods) {
                if (methodNode.name.equals("t")) {
                    if (!methodNode.desc.equals("()V")) {
                        continue;
                    }
                    AbstractInsnNode yk = null;
                    final AbstractInsnNode[] array = methodNode.instructions.toArray();
                    int n = 0;
                    for (final AbstractInsnNode abstractInsnNode : array) {
                        if (abstractInsnNode instanceof MethodInsnNode && ((MethodInsnNode) abstractInsnNode).name.equals("getEventKeyState") && ++n == 2) {
                            yk = abstractInsnNode.getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext().getNext();
                        }
                    }
                    final InsnList list = new InsnList();
                    list.add(new VarInsnNode(ILOAD, 2));
                    list.add(new MethodInsnNode(INVOKESTATIC, Utils.AB(ModuleManager.class), "listenKey", "(I)V", false));
                    methodNode.instructions.insert(yk, list);
                }
            }
        }
    }
}
