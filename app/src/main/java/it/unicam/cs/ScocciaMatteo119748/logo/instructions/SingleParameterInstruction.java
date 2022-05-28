package it.unicam.cs.ScocciaMatteo119748.logo.instructions;

/**
 * An instruction with just one int parameter
 */
public class SingleParameterInstruction extends BasicInstruction{

    private final int param;

    /**
     * Builds a basic instruction adding an integer parameter
     * @param command LOGO command of the instruction
     * @param param integer parameter of the instruction
     */
    public SingleParameterInstruction(Command command, int param) {
        super(command);
        this.param = param;
    }

    /**
     * Returns the integer parameter of the instruction
     * @return parameter of the instruction
     */
    public int getParam(){
        return param;
    }
}
