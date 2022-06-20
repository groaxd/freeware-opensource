package freeware.transformer.impl;
import freeware.Transformer;
import freeware.helper.Utils;
import freeware.rawfeatures.onMotionUpdate;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

public class onMotionUpdateTransformer extends Transformer
{
    public void transform(final ClassReader classReader, final ClassNode classNode) {
        if (classNode.name.equals("net/minecraft/client/gU")) {
            for (final MethodNode methodNode : classNode.methods) {
                if (methodNode.name.equals("Z") && methodNode.desc.equals("()V")) {
                    AbstractInsnNode abstractInsnNode = null;
                    for (final AbstractInsnNode abstractInsnNode2 : methodNode.instructions.toArray()) {
                        if (abstractInsnNode2.getOpcode() == INVOKESTATIC) {
                            abstractInsnNode = abstractInsnNode2;
                            break;
                        }
                    }
                    final InsnList list = new InsnList();
                    list.add(new MethodInsnNode(INVOKESTATIC, Utils.AB(onMotionUpdate.class), "onMotionUpdate", "()V", false));
                    methodNode.instructions.insert(abstractInsnNode, list);
                }
            }
        }
    }
}
