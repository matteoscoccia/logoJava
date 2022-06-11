package it.unicam.cs.ScocciaMatteo119748.implementation;

import java.util.Scanner;

/**
 * Implements the View interface using a command line execution
 */
public class ConsoleView implements ViewClass {

    Scanner input;

    public ConsoleView() {
        this.input = new Scanner(System.in);
    }

    /**
     * Gets the path of the file to be read from the user
     * @return the path of the file
     */
    @Override
    public String getFilePath() {
        System.out.println("Inserire il path del file txt contenente le istruzioni da eseguire:");
        return input.nextLine();
    }
}
