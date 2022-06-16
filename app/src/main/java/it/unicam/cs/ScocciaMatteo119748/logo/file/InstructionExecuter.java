package it.unicam.cs.ScocciaMatteo119748.logo.file;

import it.unicam.cs.ScocciaMatteo119748.logo.components.*;
import it.unicam.cs.ScocciaMatteo119748.logo.instructions.*;
import it.unicam.cs.ScocciaMatteo119748.logo.playground.Playground;
import it.unicam.cs.ScocciaMatteo119748.logo.playground.PlaygroundImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * Converts instructions into Shapes and Lines to be drawn
 */
public class InstructionExecuter {

    //TODO IMPLEMENTARE
    private static InstructionExecuter instance = null;
    //private ArrayList<Command> commandsList = new ArrayList<>();
    //private List<InstructionType> instructionTypes;

    public List<Cursor> history = new ArrayList<>();

    private Cursor cursor = new CursorImpl();
    private Playground playground = new PlaygroundImpl();

    //The resulting program execution list
    private ArrayList<ExecutionResult> programResult = new ArrayList<>();
    public ArrayList<AbstractLine> lines = new ArrayList<>();

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

    /*public void setInstructionTypes(List<InstructionType> list){
        instructionTypes = list;
    }*/

    /**
     * Takes an instruction and performs the execution of the command
     * @param it instruction
     */
    public void executeInstruction(LogoInstruction it) {
        /*switch (it.getCommand().getType()){
            case COLORINSTRUCTION -> executeColorInstruction((ColorInstruction) it);
            case SINGLEPARAMETERINSTRUCTION -> executeSingleParameterInstruction((SingleParameterInstruction) it);
            case BASICINSTRUCTION -> executeBasicInstruction(it);
            case REPEATINSTRUCTION -> executeRepeatInstruction((RepeatInstruction) it);
        }*/
        //TODO GESTIRE VALORI CURSORE NULL
        //TODO CAMBIARE PASSAGGIO PER RIFERIMENTO CURSORI
        //TODO GESTIRE POLIGONI
        //TODO CALCOLO DIMENSIONI FIELD
        //TODO STAMPA SU FILE
        Cursor nextCursor = cursor.copy();
        System.out.println(nextCursor.toString());
        if(!(it instanceof RepeatInstruction<?>)) {
            nextCursor = it.performInstruction(nextCursor, playground);
            history.add(nextCursor);
            drawLine(nextCursor, cursor);
            cursor = nextCursor.copy();
        }else{
            ArrayList<Cursor> nextCursorStates = ((RepeatInstruction<LogoInstruction>) it).performNestedInstruction(nextCursor, playground);
            for (Cursor c:
                 nextCursorStates
            ) {
                drawLine(cursor, c);
                cursor = c.copy();
            }
        }
    }

    private void drawLine(Cursor nextCursor, Cursor previousCursor) {
        if (cursorMoved(nextCursor, previousCursor)) {
            if (previousCursor.isPlot()) {
                lines.add(
                        new StraightLine(previousCursor.getPosition(),
                                nextCursor.getPosition(),
                                previousCursor.getLineColor(),
                                previousCursor.getPenSize()));
            }
        }
    }

    private boolean cursorMoved(Cursor previousCursor, Cursor cursor) {
        return (previousCursor.getPosition().x != cursor.getPosition().x) || (previousCursor.getPosition().y != cursor.getPosition().y);
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
