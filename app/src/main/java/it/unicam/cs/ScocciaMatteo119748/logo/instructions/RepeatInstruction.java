package it.unicam.cs.ScocciaMatteo119748.logo.instructions;

import java.util.List;

/**
 * An instruction that repeats the specified instructions for a number of times
 * @param <T>
 */
public class RepeatInstruction<T extends BasicInstruction> extends BasicInstruction{

    private final int times;
    private final List<T> instructionList;

    public RepeatInstruction(int times, List<T> instructionList) {
        super(new Command("REPEAT", CommandType.REPEATINSTRUCTION));
        this.times = times;
        this.instructionList = instructionList;
    }

    public int getTimes() {
        return times;
    }

    public List<T> getInstructionList() {
        return instructionList;
    }
}
