package it.unicam.cs.ScocciaMatteo119748.implementation;

import it.unicam.cs.ScocciaMatteo119748.logo.components.ExecutionResult;
import it.unicam.cs.ScocciaMatteo119748.logo.components.Playground;

import java.util.ArrayList;

/**
 * Represents the View interface of the MVC pattern
 */
public interface ViewClass {

    /**
     * Gets the path of the file to be read from the user
     * @return the file path
     */
    String getFilePath();

    int getPlaygroundWidth();

    int getPlaygroundHeight();

    /**
     * Shows the execution result of a logo instruction
     * @param executionResult result of the instruction
     */
    void showExecutionResult(ExecutionResult executionResult);

    /**
     * Stores the result of the execution to a txt file
     * @param executionResult result of the execution
     * @param startingPath path of the instruction file
     * @param playground area of the drawing
     */
    void saveExecutionFile(ArrayList<ExecutionResult> executionResult, String startingPath, Playground playground);
}
