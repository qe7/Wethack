package wethack.features.modules.impl.render;

import net.minecraft.client.Minecraft;
import net.minecraft.src.FontRenderer;
import net.minecraft.src.ScaledResolution;
import wethack.WetHack;
import wethack.events.EventHandler;
import wethack.events.impl.RenderScreenEvent;
import wethack.features.modules.Module;
import wethack.features.modules.ModuleCategory;

public final class HUDModule extends Module {

    // Constructor for the HUD module, sets the name, description and category of the module
    public HUDModule(String name, String description, ModuleCategory category) {
        super(name, description, category);

        this.setEnabled(true);
    }

    // This is called when ever the GuiIngame screen updates (every frame)
    // It will draw the watermark and the module names (if they are enabled)
    @EventHandler
    public void onRenderScreen(final RenderScreenEvent renderScreenEvent) {
        final ScaledResolution scaledResolution = renderScreenEvent.getScaledResolution();
        final FontRenderer fontRenderer = Minecraft.theMinecraft.fontRenderer;

        final int width = scaledResolution.getScaledWidth() - 2;

        final String watermark = WetHack.INSTANCE.getName() + " " + WetHack.INSTANCE.getVersion();

        fontRenderer.drawStringWithShadow(watermark, (width / 2) - (fontRenderer.getStringWidth(watermark) / 2), 20, 0xFFFFFF);

        int moduleOffset = 2;
        for (Module module : WetHack.INSTANCE.getModuleManager().getModules().values()) {
            if (!module.isEnabled()) {
                continue;
            }

            fontRenderer.drawStringWithShadow(module.getName(), width - fontRenderer.getStringWidth(module.getName()), moduleOffset, 0xFFFFFF);
            moduleOffset += 10;
        }
    }
}
