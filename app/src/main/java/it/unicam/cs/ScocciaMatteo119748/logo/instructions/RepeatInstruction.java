package it.unicam.cs.ScocciaMatteo119748.logo.instructions;

import it.unicam.cs.ScocciaMatteo119748.logo.components.Cursor;
import it.unicam.cs.ScocciaMatteo119748.logo.playground.Playground;

import java.util.ArrayList;
import java.util.List;

/**
 * An instruction that repeats the specified instructions for a number of times
 * @param <T>
 */
public class RepeatInstruction<T extends LogoInstruction> implements LogoInstruction{

    private final int times;
    private final List<T> instructionList;
    private final InstructionType type = InstructionType.REPEAT;

    private ArrayList<Cursor> cursorHistory;

    public RepeatInstruction(int times, List<T> instructionList) {
        this.times = times;
        this.instructionList = instructionList;
        cursorHistory = new ArrayList<>();
    }

    public int getTimes() {
        return times;
    }

    public List<T> getInstructionList() {
        return instructionList;
    }

    @Override
    public String toString() {
        return "RepeatInstruction{" +
                "times=" + times +
                ", instructionList=" + instructionList +
                '}';
    }

    @Override
    public Cursor performInstruction(Cursor start, Playground field) {
        return null;
    }

    /**
     * Performs every instruction contained in the repeat instruction and return the cursor positions list
     * @param start starting cursor state
     * @param field drawing area
     * @return List of cursors states
     */
    public ArrayList<Cursor> performNestedInstruction(Cursor start, Playground field){
        Cursor currentCursor = start.copy();
        for(int i = 0; i < times; i++){
            for (LogoInstruction in:
                    instructionList) {
                currentCursor = in.performInstruction(currentCursor, field);
                cursorHistory.add(currentCursor.copy());
            }
        }
        return cursorHistory;
    }
}
