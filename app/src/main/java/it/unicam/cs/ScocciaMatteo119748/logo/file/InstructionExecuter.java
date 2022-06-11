package it.unicam.cs.ScocciaMatteo119748.logo.file;

import it.unicam.cs.ScocciaMatteo119748.logo.instructions.Command;
import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;

/**
 * Converts instructions into Shapes and Lines to be drawn
 */
public class InstructionExecuter {

    //TODO IMPLEMENTARE
    private static InstructionExecuter instance = null;
    private ArrayList<Command> commandsList = new ArrayList<>();

    /**
     * Constructor is private in order to implement singleton pattern
     */
    private InstructionExecuter(){}

    /**
     * Returns the single instance in the whole program
     * @return the single instance of the converter
     */
    public static InstructionExecuter getInstance() {
        if (instance == null) {
            instance = new InstructionExecuter();
        }
        return instance;
    }

    public void setCommandsList(ArrayList<Command> list){
        commandsList = list;
    }
}
