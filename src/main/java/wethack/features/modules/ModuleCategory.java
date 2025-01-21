package wethack.features.modules;

/**
 * Enum for the different categories of modules
 * Enums use the casing convention of all uppercase with underscores
 * This is because they are constants and should be treated as such
 * (E.G. ModuleCategory.COMBAT)
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
    // This is because when the client is obfuscated, the name of the category will be obfuscated (E.G. "Combat" -> "WetHack_Enum2424")
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
