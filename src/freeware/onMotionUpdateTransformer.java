package freeware;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import java.util.*;

public class onMotionUpdateTransformer extends Transformer
{
    public void transform(final ClassReader classReader, final ClassNode classNode) {
        if (classNode.name.equals("net/minecraft/client/gU")) {
            for (final MethodNode methodNode : classNode.methods) {
                if (methodNode.name.equals("Z") && methodNode.desc.equals("()V")) {
                    AbstractInsnNode abstractInsnNode = null;
                    for (final AbstractInsnNode abstractInsnNode2 : methodNode.instructions.toArray()) {
                        if (abstractInsnNode2.getOpcode() == 184) {
                            abstractInsnNode = abstractInsnNode2;
                            break;
                        }
                    }
                    final InsnList list = new InsnList();
                    list.add((AbstractInsnNode)new MethodInsnNode(184, Utils.AB((Class)onMotionUpdate.class), "onMotionUpdate", "()V", false));
                    methodNode.instructions.insert((AbstractInsnNode)abstractInsnNode, list);
                }
            }
        }
    }
}
