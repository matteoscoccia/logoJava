package it.unicam.cs.ScocciaMatteo119748.logo.instructions;

import it.unicam.cs.ScocciaMatteo119748.logo.components.Cursor;
import it.unicam.cs.ScocciaMatteo119748.logo.playground.Playground;

import java.awt.*;

import static it.unicam.cs.ScocciaMatteo119748.logo.instructions.InstructionType.CLEARSCREEN;
import static it.unicam.cs.ScocciaMatteo119748.logo.instructions.InstructionType.SETSCREENCOLOR;

public class PlaygroundInstruction implements LogoInstruction{

    private final InstructionType type;
    private final Color color;

    public PlaygroundInstruction(InstructionType type){
        this.type = type;
        this.color = null;
    }

    public PlaygroundInstruction(InstructionType type, Color color) {
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
        if(type == CLEARSCREEN){
            return null;
        }else if(type == SETSCREENCOLOR){
            field.setBackground(color);
            return field;
        }
        return null;
    }
}
