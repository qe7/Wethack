package wethack.features.modules;

/**
 * Enum for the different categories of modules
 */
public enum ModuleCategory {
    // Enum values for the different categories
    COMBAT("Combat"),
    RENDER("Render"),
    MOVEMENT("Movement"),
    MISC("Misc"),
    EXPLOIT("Exploit"),
    CLIENT("Client");

    // Variable for storing the name, we do this normally to avoid issues with obfuscation
    private final String name;

    // Constructor to set the name of the category
    ModuleCategory(String name) {
        this.name = name;
    }

    // Getter for the name of the category
    public String getName() {
        return name;
    }
}
