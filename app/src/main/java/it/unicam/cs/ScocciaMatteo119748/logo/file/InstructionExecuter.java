package it.unicam.cs.ScocciaMatteo119748.logo.file;

import it.unicam.cs.ScocciaMatteo119748.logo.components.Cursor;
import it.unicam.cs.ScocciaMatteo119748.logo.components.CursorImpl;
import it.unicam.cs.ScocciaMatteo119748.logo.components.ExecutionResult;
import it.unicam.cs.ScocciaMatteo119748.logo.instructions.*;
import it.unicam.cs.ScocciaMatteo119748.logo.playground.Playground;
import it.unicam.cs.ScocciaMatteo119748.logo.playground.PlaygroundImpl;
import org.checkerframework.checker.units.qual.A;

import java.awt.*;
import java.util.ArrayList;

/**
 * Converts instructions into Shapes and Lines to be drawn
 */
public class InstructionExecuter {

    //TODO IMPLEMENTARE
    private static InstructionExecuter instance = null;
    private ArrayList<Command> commandsList = new ArrayList<>();

    private Cursor cursor = new CursorImpl();
    private Playground playground = new PlaygroundImpl();

    //The resulting program execution list
    private ArrayList<ExecutionResult> programResult = new ArrayList<>();

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

    /**
     * Takes an instruction and performs the execution of the command
     * @param it instruction
     */
    public void executeInstruction(BasicInstruction it) {
        switch (it.getCommand().getType()){
            case COLORINSTRUCTION -> executeColorInstruction((ColorInstruction) it);
            case SINGLEPARAMETERINSTRUCTION -> executeSingleParameterInstruction((SingleParameterInstruction) it);
            case BASICINSTRUCTION -> executeBasicInstruction(it);
            case REPEATINSTRUCTION -> executeRepeatInstruction((RepeatInstruction) it);
        }
    }

    private void executeRepeatInstruction(RepeatInstruction it) {
    }

    private void executeBasicInstruction(BasicInstruction it) {
    }

    private void executeSingleParameterInstruction(SingleParameterInstruction it) {
    }

    public void executeColorInstruction(ColorInstruction it){

    }
}
