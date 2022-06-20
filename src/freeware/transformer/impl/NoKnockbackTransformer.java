package freeware.transformer.impl;

import freeware.Transformer;
import freeware.helper.Utils;
import freeware.modules.impl.NoKnockback;
import org.objectweb.asm.*;
import org.objectweb.asm.tree.*;

import java.util.*;

public class NoKnockbackTransformer extends Transformer
{
    public void transform(final ClassReader classReader, final ClassNode classNode) {
        if (classNode.name.contains("net/minecraft/network/NetworkManager")) {
            for (final MethodNode methodNode : classNode.methods) {
                if (classNode.name.contains("net/minecraft/network/NetworkManager") && methodNode.name.equals("channelRead0") && methodNode.desc.equals("(Lio/netty/channel/ChannelHandlerContext;Lnet/minecraft/network/Packet;)V")) {
                    AbstractInsnNode yj = null;
                    AbstractInsnNode abstractInsnNode = null;
                    AbstractInsnNode[] array;
                    for (int length = (array = methodNode.instructions.toArray()).length, i = 0; i < length; ++i) {
                        final AbstractInsnNode abstractInsnNode2 = array[i];
                        if (abstractInsnNode2.getOpcode() == 25 && ((VarInsnNode)abstractInsnNode2).var == 2) {
                            abstractInsnNode = abstractInsnNode2;
                            yj = abstractInsnNode2.getPrevious();
                            break;
                        }
                    }
                    methodNode.instructions.remove(Objects.requireNonNull(abstractInsnNode).getNext().getNext().getNext());
                    methodNode.instructions.remove(abstractInsnNode.getNext().getNext());
                    methodNode.instructions.remove(abstractInsnNode.getNext());
                    methodNode.instructions.remove(abstractInsnNode);
                    final InsnList list = new InsnList();
                    list.add(new VarInsnNode(ALOAD, 2));
                    list.add(new VarInsnNode(ALOAD, 0));
                    list.add(new FieldInsnNode(GETFIELD, "net/minecraft/network/NetworkManager", "packetListener", "Lnet/minecraft/network/INetHandler;"));
                    list.add(new MethodInsnNode(INVOKESTATIC, Utils.AB(NoKnockback.class), "packetListener", "(Lnet/minecraft/network/Packet;Lnet/minecraft/network/INetHandler;)V", false));
                    methodNode.instructions.insert(yj, list);
                }
            }
        }
    }
}
