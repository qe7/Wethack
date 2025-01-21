package wethack.screens.dropdown;

import net.minecraft.src.GuiScreen;
import wethack.WetHack;
import wethack.features.modules.impl.client.ClickGUIModule;

// TODO: Write me
public final class GuiClick extends GuiScreen {

    @Override
    public void onGuiClosed() {
        super.onGuiClosed();

        WetHack.INSTANCE.getModuleManager().getModules().get(ClickGUIModule.class).setEnabled(false);
    }
}
