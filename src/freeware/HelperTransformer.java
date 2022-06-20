package freeware;

import java.util.*;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.*;
public class HelperTransformer extends Transformer {
    public void transform(final ClassReader classReader, final ClassNode classNode) {
        if (classNode.name.equals(Utils.AB(TransformerHelpers.class))) {
            for (final MethodNode methodNode : classNode.methods) {
                if (methodNode.name.equals("getMinecraft")) {
                    methodNode.instructions.clear();
                    final InsnList list = new InsnList();
                    list.add(new MethodInsnNode(INVOKESTATIC, "net/minecraft/client/Minecraft", "getMinecraft", "()Lnet/minecraft/client/Minecraft;"));
                    list.add(new InsnNode(ARETURN));
                    methodNode.instructions.insert(list);
                }
                if (methodNode.name.equals("getBlock")) {
                    methodNode.instructions.clear();
                    final InsnList list2 = new InsnList();
                    list2.add(new MethodInsnNode(INVOKESTATIC, "net/minecraft/client/Minecraft", "getMinecraft", "()Lnet/minecraft/client/Minecraft;"));
                    list2.add(new FieldInsnNode(GETFIELD, "net/minecraft/client/Minecraft", "theWorld", "Lnet/minecraft/client/multiplayer/WorldClient;"));
                    list2.add(new VarInsnNode(ALOAD, 0));
                    list2.add(new MethodInsnNode(INVOKEVIRTUAL, "net/minecraft/client/multiplayer/WorldClient", "getBlockState", "(Lnet/minecraft/BlockPos;)Lnet/minecraft/block/state/IBlockState;"));
                    list2.add(new MethodInsnNode(INVOKEINTERFACE, "net/minecraft/block/state/IBlockState", "getBlock", "()Lnet/minecraft/block/Block;", true));
                    list2.add(new InsnNode(176));
                    methodNode.instructions.insert(list2);
                }
            }
        }
    }
}
