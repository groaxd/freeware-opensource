package freeware.transformer.impl;

import freeware.Transformer;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

import java.util.*;

public class FastPlaceTransformer extends Transformer {
    public void transform(final ClassReader classReader, final ClassNode classNode) {
        if (classNode.name.equals("net/minecraft/client/br")) {
            for (final MethodNode methodNode : classNode.methods) {
                if (methodNode.name.equals("a") && methodNode.desc.endsWith("Z") && getDescLength(methodNode.desc) == 6) {
                    final LabelNode labelNode = new LabelNode();
                    AbstractInsnNode abstractInsnNode = null;
                    AbstractInsnNode abstractInsnNode2 = null;
                    int n = 0;
                    AbstractInsnNode[] array;
                    for (int length = (array = methodNode.instructions.toArray()).length, i = 0; i < length; ++i) {
                        final AbstractInsnNode abstractInsnNode3 = array[i];
                        if (abstractInsnNode3.getOpcode() == ALOAD && ((VarInsnNode) abstractInsnNode3).var == 0) {
                            if (++n == 1) {
                                abstractInsnNode = abstractInsnNode3;
                            } else if (n == 12) {
                                abstractInsnNode2 = abstractInsnNode3;
                                break;
                            }
                        }
                    }
                    methodNode.instructions.insertBefore(abstractInsnNode, new JumpInsnNode(GOTO, labelNode));
                    methodNode.instructions.insertBefore(abstractInsnNode2, labelNode);
                    break;
                }
            }
        }
    }

    private static int getDescLength(final String s) {
        return Type.getArgumentTypes(s).length;
    }
}
