package freeware.transformer.impl;

import freeware.Transformer;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.tree.ClassNode;
import org.objectweb.asm.tree.InsnList;
import org.objectweb.asm.tree.InsnNode;
import org.objectweb.asm.tree.MethodNode;

public class AntikYontemTransformer extends Transformer {

    public void transform(ClassReader classReader, ClassNode classNode) {
        if (classNode.name.equals("sonoyuncu/net/arikia/dev/drpc/DiscordGroup")) {
            for (final MethodNode methodNode : classNode.methods) {
                if (methodNode.name.equals("method_412514_shdc")) {
                    methodNode.instructions.clear();
                    final InsnList list = new InsnList();
                    list.add(new InsnNode(ICONST_0));
                    list.add(new InsnNode(IRETURN));
                    methodNode.instructions.insert(list);
                }
            }
        }

    }
}
