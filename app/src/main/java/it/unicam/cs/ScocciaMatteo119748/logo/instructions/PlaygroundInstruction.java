package it.unicam.cs.ScocciaMatteo119748.logo.instructions;

import it.unicam.cs.ScocciaMatteo119748.logo.components.Cursor;
import it.unicam.cs.ScocciaMatteo119748.logo.playground.Playground;

import java.awt.*;

public class PlaygroundInstruction implements LogoInstruction{

    private final Type type;
    private final Color color;

    public PlaygroundInstruction(Type type){
        this.type = type;
        this.color = null;
    }

    public PlaygroundInstruction(Type type, Color color) {
        this.type = type;
        this.color = color;
    }

    /**
     * Performs the instruction on the given cursor, this instruction type doesn't perform transformation on the cursor
     * @param start starting cursor state
     * @param field drawing area
     * @return ending cursor state
     */
    @Override
    public Cursor performInstruction(Cursor start, Playground field) {
        return start;
    }

    /**
     * Performs the instruction on the given field
     * @param field Starting field
     * @return Modified field, null if the screen gets cleared
     */
    public Playground performPlaygroundInstruction(Playground field){
        if(type == Type.CLEARSCREEN){
            return null;
        }else{
            field.setBackground(color);
            return field;
        }
    }

    enum Type{
        CLEARSCREEN,
        SETSCREENCOLOR
    }
}
