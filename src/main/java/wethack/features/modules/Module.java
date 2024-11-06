package wethack.features.modules;

import wethack.features.commands.Command;

public abstract class Module extends Command {

    // Variable for storing the enum category of the module
    private final ModuleCategory category;

    // Variables for storing the keybind and the enabled state of the module
    private int keyBind;

    private boolean enabled;

    // Constructor for the module, sets the name, description and category of the module
    public Module(String name, String description, ModuleCategory category) {
        super(name, description);

        this.category = category;
    }

    // Methods for onEnable and onDisable, these are called when the module is toggled
    // The reason these aren't abstract is that not all modules will need to do something when toggled
    // For example, a module that only renders something doesn't need to do anything when toggled
    public void onEnable() {

    }

    public void onDisable() {

    }

    // Method for toggling the module, this will change the enabled state of the module
    // If the module is enabled, it will call the onEnable method
    // If the module is disabled, it will call the onDisable method
    public void toggle() {
        enabled = !enabled;

        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }

    // Getters for the category, keybind and enabled state of the module
    public ModuleCategory getCategory() {
        return category;
    }

    public int getKeyBind() {
        return keyBind;
    }

    public void setKeyBind(int keyBind) {
        this.keyBind = keyBind;
    }

    public boolean isEnabled() {
        return enabled;
    }

    // Since the enabled state can be changed, we need to call the onEnable and onDisable methods when setting the enabled state
    // This is to ensure that the module is in the correct state
    public void setEnabled(boolean enabled) {
        // If the enabled state is the same as the current state, we don't need to do anything
        // This is to avoid unnecessary calls to onEnable and onDisable
        if (this.enabled == enabled) {
            return;
        }

        // Set the new enabled state
        this.enabled = enabled;

        // Call the onEnable or onDisable method based on the new state
        if (enabled) {
            onEnable();
        } else {
            onDisable();
        }
    }
}
