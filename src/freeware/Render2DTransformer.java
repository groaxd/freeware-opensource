package freeware;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;
import java.util.*;

public class Render2DTransformer extends Transformer
{
    public void transform(final ClassReader classReader, final ClassNode classNode) {
        if (classNode.name.equals("net/minecraft/client/gui/GuiInGame")) {
            for (final MethodNode methodNode : classNode.methods) {
                if (methodNode.name.equals("renderGameOverlay")) {
                    if (!methodNode.desc.equals("(F)V")) {
                        continue;
                    }
                    AbstractInsnNode yk = null;
                    for (final AbstractInsnNode abstractInsnNode : methodNode.instructions.toArray()) {
                        if (abstractInsnNode instanceof MethodInsnNode && ((MethodInsnNode)abstractInsnNode).name.equals("disableLighting") && ((MethodInsnNode)abstractInsnNode).owner.equals("net/minecraft/client/renderer/GlStateManager")) {
                            yk = abstractInsnNode.getPrevious().getPrevious().getPrevious().getPrevious().getPrevious();
                            break;
                        }
                    }
                    final InsnList list = new InsnList();
                    list.add(new VarInsnNode(ALOAD, 5));
                    list.add(new VarInsnNode(ALOAD, 6));
                    list.add(new MethodInsnNode(INVOKESTATIC, Utils.AB(onRender2D.class), "onRender2D", "(II)V", false));
                    methodNode.instructions.insert(yk, list);
                }
            }
        }
    }
}
