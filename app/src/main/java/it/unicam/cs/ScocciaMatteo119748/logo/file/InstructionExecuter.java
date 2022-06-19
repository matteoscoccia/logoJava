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
    public Playground playground = new PlaygroundImpl();

    //The resulting program execution list
    private ArrayList<ExecutionResult> programResult = new ArrayList<>();
    public ArrayList<AbstractLine> lines = new ArrayList<>();
    public Polygon<AbstractLine> currentPolygon = new Polygon<>();

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

    /**
     * Takes an instruction and performs the execution of the command
     * @param it instruction
     */
    public void executeInstruction(LogoInstruction it) {
        //TODO GESTIRE VALORI CURSORE NULL [FATTO?]
        //TODO CAMBIARE PASSAGGIO PER RIFERIMENTO CURSORI [FATTO]
        //TODO GESTIRE POLIGONI
        //TODO CALCOLO DIMENSIONI FIELD
        //TODO STAMPA SU FILE
        Cursor nextCursor = cursor.copy();
        System.out.println(nextCursor.toString());
        if(!(it instanceof RepeatInstruction<?>)) {
            if(!(it instanceof PlaygroundInstruction)) {
                nextCursor = it.performInstruction(nextCursor, playground);
                history.add(nextCursor);
                drawLine(nextCursor, cursor);
                cursor = nextCursor.copy();
            }else{
                Playground nextPlayground = new PlaygroundImpl(playground.getWidth(), playground.getHeight(), playground.getBackground());
                nextPlayground = ((PlaygroundInstruction) it).performPlaygroundInstruction(nextPlayground);
                if(nextPlayground != null) playground = nextPlayground;
                else clearScreen();
            }
        }else{
            System.out.println("NEXT CURSOR BEFORE NESTED: " + nextCursor);
            ArrayList<Cursor> nextCursorStates = ((RepeatInstruction<LogoInstruction>) it).performNestedInstruction(nextCursor, playground);
            System.out.println("EXECUTER CURSOR AFTER NESTED: " + cursor);
            history.addAll(nextCursorStates);
            for (Cursor c:
                 nextCursorStates
            ) {
                System.out.println("NESTED NEXT CURSOR STATE: " + c.toString());
                drawLine(c, cursor);
                cursor = c.copy();
            }
        }
    }

    private void clearScreen() {
        //TODO RIMUOVERE ANCHE POLIGONI ECC
        lines.clear();
        programResult.clear();
    }

    private void drawLine(Cursor nextCursor, Cursor previousCursor) {
        if (cursorMoved(nextCursor, previousCursor)) {
            if (previousCursor.isPlot()) {
                AbstractLine newLine = new StraightLine(previousCursor.getPosition(),
                        nextCursor.getPosition(),
                        previousCursor.getLineColor(),
                        previousCursor.getPenSize());
                lines.add(newLine);
                programResult.add(newLine);
                drawPolygon(newLine, previousCursor);
            }
        }
    }

    private void drawPolygon(AbstractLine newLine, Cursor previousCursor) {
        currentPolygon.addEdge(newLine);
        currentPolygon.setAreaColor(previousCursor.getAreaColor());
        if(currentPolygon.checkPolygonClosed()){
            programResult.removeAll(currentPolygon.getEdges());
            programResult.add(currentPolygon.copy());
            ArrayList<AbstractLine> newEdges = new ArrayList<>();
            newEdges.add(currentPolygon.getEdges().get(currentPolygon.getEdges().size()-1));
            currentPolygon.setEdges(new ArrayList<>());
        }
    }

    public void setCursor(Cursor cursor) {
        this.cursor = cursor;
    }

    public void setPlayground(Playground playground) {
        this.playground = playground;
    }

    private boolean cursorMoved(Cursor previousCursor, Cursor cursor) {
        return (previousCursor.getPosition().x != cursor.getPosition().x) || (previousCursor.getPosition().y != cursor.getPosition().y);
    }

    public ArrayList<ExecutionResult> getProgramResult() {
        return programResult;
    }

    public Playground getPlayground(){
        return playground;
    }
}
