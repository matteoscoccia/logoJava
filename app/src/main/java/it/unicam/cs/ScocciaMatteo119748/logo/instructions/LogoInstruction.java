package it.unicam.cs.ScocciaMatteo119748.logo.instructions;

import it.unicam.cs.ScocciaMatteo119748.logo.components.Cursor;
import it.unicam.cs.ScocciaMatteo119748.logo.playground.Playground;

@FunctionalInterface
public interface LogoInstruction {

    Cursor performInstruction(Cursor start, Playground field);

}
