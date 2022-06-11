package it.unicam.cs.ScocciaMatteo119748.logo.instructions;

/**
 * Represents the command of a logo instruction
 */
public class Command {

    private final String name;

    private final CommandType type;

    public Command(String name, CommandType type) {
        this.name = name;
        this.type = type;
    }

    /**
     * Get the name of the command
     * @return command name
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the type of the command
     * @return command type
     */
    public CommandType getType() {
        return type;
    }
}
