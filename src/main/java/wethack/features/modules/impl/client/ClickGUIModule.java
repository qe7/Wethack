package wethack.features.modules.impl.client;

import net.minecraft.client.Minecraft;
import org.lwjgl.input.Keyboard;
import wethack.features.modules.Module;
import wethack.features.modules.ModuleCategory;
import wethack.screens.dropdown.GuiClick;

public final class ClickGUIModule extends Module {

    private GuiClick guiClick;

    public ClickGUIModule(String name, String description, ModuleCategory category) {
        super(name, description, category);

        this.setKeyBind(Keyboard.KEY_RSHIFT);
    }

    @Override
    public void onEnable() {
        super.onEnable();

        // Set instance of the GuiClick class
        if (guiClick == null) {
            guiClick = new GuiClick();
        }

        // Open the GuiClick
        Minecraft.theMinecraft.displayGuiScreen(guiClick);
    }

    @Override
    public void onDisable() {
        super.onDisable();

        // Close the GuiClick
        Minecraft.theMinecraft.displayGuiScreen(null);
    }
}
