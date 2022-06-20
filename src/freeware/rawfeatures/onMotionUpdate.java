package freeware.rawfeatures;

import freeware.helper.FabricReflect;
import freeware.manager.FriendManager;
import freeware.helper.Timer;
import freeware.helper.TransformerHelpers;
import freeware.modules.impl.*;
import net.minecraft.client.gui.inventory.GuiChest;
import net.minecraft.entity.Entity;
import net.minecraft.init.Blocks;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.network.play.client.C02PacketUseEntity;
import net.minecraft.util.BlockPos;

import java.util.Arrays;

public class onMotionUpdate {
    private static final Timer AP = new Timer();
    public static Timer AQ = new Timer();
    public static boolean AR = false;
    public static int AS = 0;


    public static void onMotionUpdate() {
        if (!onMotionUpdate.AR) {
            FriendManager.AX();
            onMotionUpdate.AR = true;
        }
        if (KillAura.state1 && onMotionUpdate.AP.Ai(150.0) && TransformerHelpers.getMinecraft().thePlayer != null && TransformerHelpers.getMinecraft().theWorld != null && TransformerHelpers.getMinecraft().theWorld.loadedEntityList != null && !TransformerHelpers.getMinecraft().theWorld.loadedEntityList.isEmpty()) {
            for (int i = 0; i < TransformerHelpers.getMinecraft().theWorld.loadedEntityList.size(); ++i) {
                final Entity pc = TransformerHelpers.getMinecraft().theWorld.loadedEntityList.get(i);
                if (pc != null && pc != TransformerHelpers.getMinecraft().thePlayer && TransformerHelpers.getDistance(TransformerHelpers.getMinecraft().thePlayer, pc) <= 4.0f && !FriendManager.isFriend(pc.toString().split("'")[1])) {
                    TransformerHelpers.getMinecraft().thePlayer.swingItem();
                    TransformerHelpers.getMinecraft().getNetHandler().addToSendQueue(new C02PacketUseEntity(pc, C02PacketUseEntity.Action.ATTACK));
                }
            }
        }
        if (Eagle.state1 && TransformerHelpers.getMinecraft().thePlayer != null) {
            final BlockPos blockPos = new BlockPos(TransformerHelpers.getMinecraft().thePlayer.posX, TransformerHelpers.getMinecraft().thePlayer.posY - 1.0, TransformerHelpers.getMinecraft().thePlayer.posZ);
            if (TransformerHelpers.getBlock(blockPos) == Blocks.air) {
                    FabricReflect.writeField(TransformerHelpers.getMinecraft().gameSettings.keyBindSneak, true, "f", "pressed");
                }
        }
        if (ChestStealer.state1) {
            ++onMotionUpdate.AS;
            if (TransformerHelpers.getMinecraft().currentScreen instanceof GuiChest) {
                final GuiChest e8 = (GuiChest) TransformerHelpers.getMinecraft().currentScreen;
                for (int j = 0; j < e8.inventoryRows * 9; ++j) {
                    Slot slot = e8.inventorySlots.inventorySlots.get(j);
                    if (slot.getStack() != null) {
                        if (onMotionUpdate.AS >= 2) {
                            e8.handleMouseClick(slot, slot.slotNumber, 0, 1);
                            e8.handleMouseClick(slot, slot.slotNumber, 0, 6);
                            onMotionUpdate.AS = 0;
                        }
                    }
                }
            }
        }
        if (AutoArmor.state1 && !TransformerHelpers.isOnInventory()) {
            int[] bestArmor1 = new int[4];
            Arrays.fill(bestArmor1, -1);
            for (int i = 0; i < 36; i++) {
                ItemStack itemstack = TransformerHelpers.getMinecraft().thePlayer.inventory.getStackInSlot(i);
                if (itemstack != null && itemstack.getItem() instanceof ItemArmor) {
                    ItemArmor armor = (ItemArmor) itemstack.getItem();
                    if (armor.damageReduceAmount > bestArmor1[3 - armor.armorType]) bestArmor1[3 - armor.armorType] = i;
                }
            }
            for (int i = 0; i < 4; i++) {
                ItemStack itemstack = TransformerHelpers.getMinecraft().thePlayer.inventory.armorItemInSlot(i);
                ItemArmor currentArmor;
                if (itemstack != null && itemstack.getItem() instanceof ItemArmor) {
                    currentArmor = (ItemArmor) itemstack.getItem();
                } else {
                    currentArmor = null;
                }
                ItemArmor bestArmor;
                try {
                    bestArmor = (ItemArmor) TransformerHelpers.getMinecraft().thePlayer.inventory.getStackInSlot(bestArmor1[i])
                            .getItem();
                } catch (Exception e) {
                    bestArmor = null;
                }
                if (bestArmor != null &&
                        (currentArmor == null || bestArmor.damageReduceAmount > currentArmor.damageReduceAmount)) {
                    if (TransformerHelpers.getMinecraft().thePlayer.inventory.getFirstEmptyStack() != -1 ||
                            currentArmor == null) {
                        TransformerHelpers.getMinecraft().playerController
                                .windowClick(0, 8 - i, 0, 1, TransformerHelpers.getMinecraft().thePlayer);
                        TransformerHelpers.getMinecraft().playerController
                                .windowClick(0, bestArmor1[i] < 9 ? 36 + bestArmor1[i] : bestArmor1[i], 0, 1,
                                        TransformerHelpers.getMinecraft().thePlayer);
                    }
                }
            }
        }
        if (FastPlace.state1) {
            if ((int) FabricReflect.getFieldValue(TransformerHelpers.getMinecraft(), "l", "rightClickDelayTimer") > 0) {
                FabricReflect.writeField(TransformerHelpers.getMinecraft(), 0, "l", "rightClickDelayTimer");
            }
        }
        if (SpeedMine.state1) {
            if ((int) FabricReflect.getFieldValue(TransformerHelpers.getMinecraft().getNetHandler(), "e", "blockHitDelay") > 0) {
                FabricReflect.writeField(TransformerHelpers.getMinecraft().getNetHandler(), 0, "e", "blockHitDelay");
            }
            if ((float) FabricReflect.getFieldValue(TransformerHelpers.getMinecraft().getNetHandler(), "b", "curBlockDamageMP") < 1.0f) {
                FabricReflect.writeField(TransformerHelpers.getMinecraft().getNetHandler(), 1, "b", "curBlockDamageMP");
            }
        }
    }
}
