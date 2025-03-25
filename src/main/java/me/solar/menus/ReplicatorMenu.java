package me.solar.menus;

import me.solar.TrekBlocks;
import me.solar.TrekMenus;
import me.solar.blockentities.ReplicatorBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.*;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.SlotItemHandler;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.BiFunction;

import static me.solar.blockentities.ReplicatorBlockEntity.SLOT_COUNT;

public class ReplicatorMenu extends AbstractContainerMenu  {

    private final BlockPos pos;
    private final IItemHandler inventory;
    public static final int INVENTORY_SIZE = SLOT_COUNT; // Size of your container
    public static final int SLOT_SIZE = 18; // Standard slot size in pixels


    public ReplicatorMenu(int containerId, Inventory playerInventory) {
        this(containerId, playerInventory, new ItemStackHandler(INVENTORY_SIZE), BlockPos.ZERO);
    }

    public ReplicatorMenu(int containerId, Inventory playerInventory, IItemHandler inventory, BlockPos pos) {
        super(MenuType.GENERIC_9x1, containerId); // Using basic 9x1 menu type as example
        this.inventory = inventory;
        this.pos = pos;

        // Add custom container slots
        for (int i = 0; i < INVENTORY_SIZE; i++) {
            addSlot(new SlotItemHandler(inventory, i, 8 + i * SLOT_SIZE, 20));
        }

        // Add player inventory slots
        for (int row = 0; row < 3; row++) {
            for (int col = 0; col < 9; col++) {
                addSlot(new Slot(playerInventory, col + row * 9 + 9,
                        8 + col * SLOT_SIZE,
                        84 + row * SLOT_SIZE));
            }
        }

        // Add player hotbar slots
        for (int col = 0; col < 9; col++) {
            addSlot(new Slot(playerInventory, col,
                    8 + col * SLOT_SIZE, 142));
        }
    }

    @Override
    public ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemstack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);

        if (slot != null && slot.hasItem()) {
            ItemStack itemstack1 = slot.getItem();
            itemstack = itemstack1.copy();

            if (index < INVENTORY_SIZE) {
                if (!this.moveItemStackTo(itemstack1, INVENTORY_SIZE, this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(itemstack1, 0, INVENTORY_SIZE, false)) {
                return ItemStack.EMPTY;
            }

            if (itemstack1.isEmpty()) {
                slot.setByPlayer(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemstack;
    }

    @Override
    public boolean stillValid(Player player) {
        return player.distanceToSqr(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5) <= 64;
    }


}
