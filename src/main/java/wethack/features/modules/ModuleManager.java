package wethack.features.modules;

import wethack.WetHack;
import wethack.events.EventHandler;
import wethack.events.impl.KeyBindEvent;
import wethack.features.modules.impl.client.ClickGUIModule;
import wethack.features.modules.impl.misc.FreeCamModule;
import wethack.features.modules.impl.misc.InstantMineModule;
import wethack.features.modules.impl.render.FullBrightModule;
import wethack.features.modules.impl.render.HUDModule;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class ModuleManager {

    // Stores all the modules
    private final HashMap<Class<? extends Module>, Module> modules = new HashMap<>();

    // Initializes all the modules and registers them
    public void init() {
        final List<Module> modules = new ArrayList<>();

        modules.add(new ClickGUIModule("ClickGUI", "Displays a clickable interface to manage your modules", ModuleCategory.CLIENT));

        modules.add(new FreeCamModule("FreeCam", "Allows you to move independently of the local player", ModuleCategory.MISC));
        modules.add(new InstantMineModule("InstantMine", "Instantly mine blocks", ModuleCategory.MISC));

        modules.add(new FullBrightModule("FullBright", "Makes the world bright", ModuleCategory.RENDER));
        modules.add(new HUDModule("HUD", "Displays information related to the client", ModuleCategory.RENDER));

        modules.forEach(this::register);

        WetHack.INSTANCE.getEventBus().register(this);
    }

    // Registers a module to the module manager so that it can be toggled and called
    public void register(final Module module) {
        this.modules.putIfAbsent(module.getClass(), module);
    }

    public HashMap<Class<? extends Module>, Module> getModules() {
        return this.modules;
    }

    // This is called when ever a key is pressed, so by checking what key is pressed against the modules keybind
    // we can toggle the module
    @EventHandler
    public void onKeyBind(final KeyBindEvent keyBindEvent) {
        int key = keyBindEvent.getKeyBind();

        for (Module module : this.modules.values()) {
            if (module.getKeyBind() == key) {
                module.toggle();
            }
        }
    }
}
