package it.unicam.cs.ScocciaMatteo119748.logo.instructions;

import it.unicam.cs.ScocciaMatteo119748.logo.components.Cursor;
import it.unicam.cs.ScocciaMatteo119748.logo.playground.Playground;

import java.awt.*;

/**
 * Represents an operation that affects the curore line color or area color
 */
public class CursorColorInstruction implements LogoInstruction{

    private final Type type;
    private final Color color;

    public CursorColorInstruction(Type type, Color color) {
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
        if (type == Type.SETPENCOLOR){
            start.setLineColor(color);
        }else{
            start.setAreaColor(color);
        }
        return start;
    }

    enum Type{
        SETPENCOLOR,
        SETFILLCOLOR
    }
}
