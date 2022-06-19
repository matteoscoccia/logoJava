package it.unicam.cs.ScocciaMatteo119748.implementation;

import it.unicam.cs.ScocciaMatteo119748.logo.components.ExecutionResult;
import it.unicam.cs.ScocciaMatteo119748.logo.playground.Playground;

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

    int getPlaygroundHeigth();

    void showExecutionResult(ExecutionResult executionResult);

    void saveExecutionFile(ArrayList<ExecutionResult> executionResult, String startingPath, Playground playground);
}
