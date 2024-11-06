package wethack.features.commands;

/**
 * Abstract class for the different commands
 */
public abstract class Command {

    // Variables for storing the name and description of the command
    private final String name, description;

    // Variable for storing the syntax of the command
    // This is not final as there can be cases where the syntax is dynamic
    // E.G. Module commands where the syntax is based on the module and settings with current values
    private String syntax;

    // Variable for storing the aliases of the command
    private String[] aliases;

    // Constructor for the command, sets the name and description of the command
    public Command(String name, String description) {
        this.name = name;
        this.description = description;
    }

    // Abstract method for the execution of the command
    // Reason for this is that each command will have a different execution
    // For example, the command to toggle a module will have a different execution than the command to set a value
    // Simple stuff
    public abstract void execute(String[] args);

    // Getters for the name, description, syntax and aliases of the command
    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getSyntax() {
        return syntax;
    }

    public void setSyntax(String syntax) {
        this.syntax = syntax;
    }

    public String[] getAliases() {
        return aliases;
    }

    public void setAliases(String[] aliases) {
        this.aliases = aliases;
    }
}
