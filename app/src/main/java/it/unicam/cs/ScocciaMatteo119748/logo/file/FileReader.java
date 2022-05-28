package it.unicam.cs.ScocciaMatteo119748.logo.file;

import it.unicam.cs.ScocciaMatteo119748.logo.instructions.BasicInstruction;

/**
 * Defines the basic methods of the logo instructions file reader
 */
public interface FileReader {

    /**
     * Reads the whole set of instructions from the file
     */
    void readStringsList();

    /**
     * Returns the next instruction to be performed
     * @return next instruction
     */
    BasicInstruction readNextInstruction();
}
