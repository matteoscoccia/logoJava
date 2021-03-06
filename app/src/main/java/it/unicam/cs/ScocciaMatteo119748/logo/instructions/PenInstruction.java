package it.unicam.cs.ScocciaMatteo119748.logo.instructions;

import it.unicam.cs.ScocciaMatteo119748.logo.components.Cursor;
import it.unicam.cs.ScocciaMatteo119748.logo.components.Playground;

/**
 * Represents an instruction performed on the pen of the cursor
 */
public class PenInstruction implements LogoInstruction{

    private final InstructionType type;
    private final int parameter;

    public PenInstruction(InstructionType type, int parameter) {
        this.type = type;
        this.parameter = parameter;
    }

    /**
     * Executes the instruction on the provided cursor
     * @param start Starting state of the cursor
     * @param field The drawing area
     * @return new cursor position
     */
    @Override
    public Cursor performInstruction(Cursor start, Playground field) {
        switch (this.type){
            case PENUP -> start.setPlot(false);
            case PENDOWN -> start.setPlot(true);
            case SETPENSIZE -> start.setPenSize(parameter);
        }
        return start;
    }

    public InstructionType getType() {
        return type;
    }

    public int getParameter() {
        return parameter;
    }
}
