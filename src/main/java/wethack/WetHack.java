package wethack;

/**
 * The main class of the client, this class is a singleton and is used to store the name and version of the client.
 * Anything modified in Minecraft's SRC will be marked with a comment like this: // WETHACK - {modification}
 */
public final class WetHack {

    // Singleton instance, only one instance of WetHack can exist
    // This allows us to access the instance of WetHack from anywhere in the client
    public static final WetHack INSTANCE = new WetHack();

    // Variables to store the name and version of the client
    private final String name, version;

    // Constructor to set the name and version of the client
    private WetHack() {
        this.name = "WetHack";
        this.version = "b1";
    }

    // Method to initialize the client
    // This is called when the client is started, this is where you would put your initialization code
    public void init() {

    }

    // Getters for the name and version of the client
    public String getName() {
        return name;
    }

    public String getVersion() {
        return version;
    }
}
