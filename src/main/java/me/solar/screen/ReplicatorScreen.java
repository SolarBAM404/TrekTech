package me.solar.screen;

import me.solar.menus.ReplicatorMenu;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.jetbrains.annotations.NotNull;

import static net.neoforged.neoforge.internal.versions.neoforge.NeoForgeVersion.MOD_ID;

public class ReplicatorScreen extends AbstractContainerScreen<ReplicatorMenu> {

    private static final ResourceLocation BACKGROUND_LOCATION = ResourceLocation.fromNamespaceAndPath(MOD_ID, "textures/gui/container/my_container_screen.png");

    public ReplicatorScreen(ReplicatorMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);

        this.titleLabelX = 10;
        this.inventoryLabelX = 10;
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        guiGraphics.blit(
                RenderType::guiTextured,
                BACKGROUND_LOCATION,
                this.leftPos, this.topPos,
                0, 0,
                this.imageWidth, this.imageHeight,
                256, 256
        );
    }

    // In some AbstractContainerScreen subclass
    @Override
    protected void renderLabels(@NotNull GuiGraphics graphics, int mouseX, int mouseY) {
        super.renderLabels(graphics, mouseX, mouseY);

        // Assume we have some Component 'label'
        // 'label' is drawn at 'labelX' and 'labelY'
        // The color is an ARGB value, if the alpha is less than 4, than the alpha is set to 255
        // The final boolean renders the drop shadow when true
        graphics.drawString(this.font, "Test Replicator", this.inventoryLabelX, this.inventoryLabelY, 0x404040, false);
    }
}
