package me.solar.blockentities;

import lombok.Getter;
import me.solar.TrekBlocks;
import me.solar.TrekTech;
import me.solar.itemhandlers.AdaptedItemHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.network.chat.Component;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BaseContainerBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.items.wrapper.CombinedInvWrapper;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nonnull;

public class ReplicatorBlockEntity extends BaseContainerBlockEntity {

    public static final int SLOT_INPUT = 0;
    public static final int SLOT_INPUT_COUNT = 1;

    public static final int SLOT_OUTPUT = 0;
    public static final int SLOT_OUTPUT_COUNT = 6;

    public static final int SLOT_COUNT = SLOT_INPUT_COUNT + SLOT_OUTPUT_COUNT;

    @Getter
    private final ItemStackHandler inputItems = createItemHandler(SLOT_INPUT_COUNT);
    private final ItemStackHandler outputItems = createItemHandler(SLOT_OUTPUT_COUNT);
    private final CombinedInvWrapper itemHandler = new CombinedInvWrapper(inputItems, outputItems);
    private final AdaptedItemHandler inputItemHandler = new AdaptedItemHandler(inputItems) {
        @Override
        public @NotNull ItemStack extractItem(int slot, int amount, boolean simulate) {
            return ItemStack.EMPTY;
        }
    };
    @Getter
    private final IItemHandler outputItemHandler = new AdaptedItemHandler(outputItems) {
        @Override
        public @NotNull ItemStack insertItem(int slot, @NotNull ItemStack stack, boolean simulate) {
            return stack;
        }
    };

    public ReplicatorBlockEntity(BlockPos pos, BlockState state) {
        super(TrekBlocks.REPLICATOR_BLOCK_ENTITY.get(), pos, state);
    }

    public IItemHandler getItemHandler() {
        return itemHandler;
    }

    public IItemHandler getInputItemHandler() {
        return inputItemHandler;
    }

    @Nonnull
    private ItemStackHandler createItemHandler(int slots) {
        return new ItemStackHandler(slots) {
            @Override
            protected void onContentsChanged(int slot) {
                setChanged();
            }
        };
    }

    public static <T extends BlockEntity> void tick(Level level, BlockPos blockPos, BlockState blockState, T t) {
        if (!(t instanceof ReplicatorBlockEntity replicator)) {
            return;
        }

        ItemStack diamond = new ItemStack(Items.DIAMOND);
        for(int i = 0; i < replicator.itemHandler.getSlots(); i++) {
            if(replicator.itemHandler.getStackInSlot(i).isEmpty()) {
                replicator.itemHandler.insertItem(i, diamond, false);
                break;
            }
        }
    }

    private final NonNullList<ItemStack> items = NonNullList.withSize(SLOT_COUNT, ItemStack.EMPTY);

    @Override
    public int getContainerSize() {
        return SLOT_COUNT;
    }

    @Override
    protected Component getDefaultName() {
        return Component.translatable("container.trektech.replicator");
    }

    @Override
    protected NonNullList<ItemStack> getItems() {
        return items;
    }

    @Override
    protected void setItems(NonNullList<ItemStack> nonNullList) {

    }

    @Override
    public boolean isEmpty() {
        return items.stream().allMatch(ItemStack::isEmpty);
    }

    @Override
    public ItemStack getItem(int i) {
        return items.get(i);
    }

    @Override
    public ItemStack removeItem(int slot, int amount) {
        ItemStack stack = ContainerHelper.removeItem(this.items, slot, amount);
        this.setChanged();
        return stack;
    }

    // Remove all items from the specified slot, returning the stack that was just removed.
    // We again defer to ContainerHelper here, and we again have to call #setChanged manually.
    @Override
    public ItemStack removeItemNoUpdate(int slot) {
        ItemStack stack = ContainerHelper.takeItem(this.items, slot);
        this.setChanged();
        return stack;
    }

    // Set the given item stack in the given slot. Limit to the max stack size of the container first.
    @Override
    public void setItem(int slot, ItemStack stack) {
        stack.limitSize(this.getMaxStackSize(stack));
        this.items.set(slot, stack);
        this.setChanged();
    }

    @Override
    public boolean stillValid(Player player) {
        return true;
    }

    @Override
    public void clearContent() {
        items.clear();
        this.setChanged();
    }

    @Override
    protected AbstractContainerMenu createMenu(int i, Inventory inventory) {
        return null;
    }
}