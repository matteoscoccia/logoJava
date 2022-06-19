package it.unicam.cs.ScocciaMatteo119748.logo.components;

/**
 * Represents the component resulting from the execution of an instruction, which can be both a polygon or a line
 */
public interface ExecutionResult {

    /**
     * Returns a string representation of the given execution result
     * @return string representation of the element
     */
    String getOutputRepresentation();

    /**
     * Returns a string representing the execution of the element
     * @return the execution of the instruction
     */
    String getExecution();

}
