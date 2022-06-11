package it.unicam.cs.ScocciaMatteo119748.logo.instructions;

/**
 * The most basic instruction, that consists in just the command name
 */
public class BasicInstruction implements Instruction{

    private final Command command;

    public BasicInstruction(Command command) {
        this.command = command;
    }

    @Override
    public Command getCommand() {
        return command;
    }

    @Override
    public String toString() {
        return "BasicInstruction{" +
                "command=" + command.getName() + " " + command.getType() +
                '}';
    }
}
