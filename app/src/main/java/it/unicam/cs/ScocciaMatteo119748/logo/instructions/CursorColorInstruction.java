package it.unicam.cs.ScocciaMatteo119748.logo.instructions;

import it.unicam.cs.ScocciaMatteo119748.logo.components.Cursor;
import it.unicam.cs.ScocciaMatteo119748.logo.components.Playground;

import java.awt.*;

import static it.unicam.cs.ScocciaMatteo119748.logo.instructions.InstructionType.SETFILLCOLOR;
import static it.unicam.cs.ScocciaMatteo119748.logo.instructions.InstructionType.SETPENCOLOR;

/**
 * Represents an operation that affects the cursor line color or area color
 */
public class CursorColorInstruction implements LogoInstruction{

    private final InstructionType type;
    private final Color color;

    public CursorColorInstruction(InstructionType type, Color color) {
        this.type = type;
        this.color = color;
    }

    /**
     * Performs the instruction on the given cursor
     * @param start Starting cursor state
     * @param field Drawing area
     * @return final cursor state
     */
    @Override
    public Cursor performInstruction(Cursor start, Playground field) {
        if (type == SETPENCOLOR){
            start.setLineColor(color);
        }else if (type == SETFILLCOLOR){
            start.setAreaColor(color);
        }
        return start;
    }

    public InstructionType getType() {
        return type;
    }

    public Color getColor() {
        return color;
    }
}
