package it.unicam.cs.ScocciaMatteo119748.implementation;

import it.unicam.cs.ScocciaMatteo119748.logo.components.ExecutionResult;

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

    void showInstructionResult(ArrayList<ExecutionResult> instructionResult);
}
