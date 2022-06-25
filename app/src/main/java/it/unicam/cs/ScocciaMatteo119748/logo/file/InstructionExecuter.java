package it.unicam.cs.ScocciaMatteo119748.logo.file;

import it.unicam.cs.ScocciaMatteo119748.logo.components.*;
import it.unicam.cs.ScocciaMatteo119748.logo.instructions.*;
import it.unicam.cs.ScocciaMatteo119748.logo.components.Playground;
import it.unicam.cs.ScocciaMatteo119748.logo.components.PlaygroundImpl;

import java.util.ArrayList;

/**
 * Performs the instructions and converts them into Shapes and Lines to be drawn
 */
public class InstructionExecuter {

    private static InstructionExecuter instance = null;

    private Cursor cursor = new CursorImpl();
    public Playground playground = new PlaygroundImpl();

    //The resulting program execution list
    private final ArrayList<ExecutionResult> programResult = new ArrayList<>();
    private final ArrayList<AbstractLine> lines = new ArrayList<>();
    private final Polygon<AbstractLine> currentPolygon = new Polygon<>();

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
        Cursor nextCursor = cursor.copy();
        if(!(it instanceof RepeatInstruction<?>)) {
            if(!(it instanceof PlaygroundInstruction)) {
                nextCursor = it.performInstruction(nextCursor, playground);
                drawLine(nextCursor, cursor);
                cursor = nextCursor.copy();
            }else{
                Playground nextPlayground = new PlaygroundImpl(playground.getWidth(), playground.getHeight(), playground.getBackground());
                nextPlayground = ((PlaygroundInstruction) it).performPlaygroundInstruction(nextPlayground);
                if(nextPlayground != null) playground = nextPlayground;
                else clearScreen();
            }
        }else{
            ArrayList<Cursor> nextCursorStates = ((RepeatInstruction<LogoInstruction>) it).performNestedInstruction(nextCursor, playground);
            for (Cursor c:
                 nextCursorStates
            ) {
                drawLine(c, cursor);
                cursor = c.copy();
            }
        }
    }

    private void clearScreen() {
        lines.clear();
        programResult.clear();
    }

    /**
     * Draws a line between the given cursors if the pen is down
     * @param nextCursor final point
     * @param previousCursor initial point
     */
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

    /**
     * Adds the given line to the current polygon and checks if the polygon is closed
     * @param newLine line to add
     * @param previousCursor previous cursor state
     */
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

    /**
     * Checks if the cursor performed a movement
     * @param previousCursor previous cursor state
     * @param cursor current cursor state
     * @return true if the cursor moved
     */
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
