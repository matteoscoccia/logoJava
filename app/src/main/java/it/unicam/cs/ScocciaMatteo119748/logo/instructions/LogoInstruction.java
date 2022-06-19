package it.unicam.cs.ScocciaMatteo119748.logo.instructions;

import it.unicam.cs.ScocciaMatteo119748.logo.components.Cursor;
import it.unicam.cs.ScocciaMatteo119748.logo.components.Playground;

/**
 * Represents the basis of a logo instruction that has just one method to be executed
 */
@FunctionalInterface
public interface LogoInstruction {

    /**
     * Performs the instruction on the given cursor and returns the ending state of the cursor
     * @param start starting cursor state
     * @param field drawing area
     * @return next cursor state
     */
    Cursor performInstruction(Cursor start, Playground field);

}
