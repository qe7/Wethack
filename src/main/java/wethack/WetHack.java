package wethack;

import wethack.features.commands.CommandManager;
import wethack.events.EventBus;
import wethack.features.modules.ModuleManager;

/**
 * The main class of the client, this class is a singleton.
 * Anything modified in Minecraft's SRC will be marked with a comment like this: // WETHACK - {modification}
 */
public final class WetHack {

    // Singleton instance, only one instance of WetHack can exist
    // This allows us to access the instance of WetHack from anywhere in the client
    public static WetHack INSTANCE;

    // Variables to store the name and version of the client
    private final String name, version;

    // Creating the instance of the event bus and managers
    private final EventBus eventBus;
    private final CommandManager commandManager;
    private final ModuleManager moduleManager;

    // Constructor to set variables and initialize the client
    public WetHack() {
        // Setting the instance of WetHack, this is used to access the instance of WetHack from anywhere in the client
        INSTANCE = this;

        this.name = "WetHack";
        this.version = "b1";

        this.eventBus = new EventBus();

        this.commandManager = new CommandManager();
        this.moduleManager = new ModuleManager();
    }

    // Method to initialize the client
    // This is called when the client is started, this is where you would put your initialization code
    // Method is almost always called once Minecraft has finished initializing
    public void init() {
        this.getModuleManager().init();
    }

    // Getters for the name and version of the client
    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }

    public EventBus getEventBus() {
        return eventBus;
    }

    public CommandManager getCommandManager() {
        return commandManager;
    }

    public ModuleManager getModuleManager() {
        return moduleManager;
    }
}
