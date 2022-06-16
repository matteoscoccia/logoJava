package it.unicam.cs.ScocciaMatteo119748.logo.file;

import it.unicam.cs.ScocciaMatteo119748.logo.instructions.BasicInstruction;
import it.unicam.cs.ScocciaMatteo119748.logo.instructions.Command;
import it.unicam.cs.ScocciaMatteo119748.logo.instructions.InstructionType;
import it.unicam.cs.ScocciaMatteo119748.logo.instructions.LogoInstruction;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the basic methods of the object that converts the strings representing LOGO instructions into instruction objects
 */
public interface InstructionConverter {

    //TODO RIPROGETTARE L'INSTRUCTION CONVERTER

    /**
     * Converts every string received to a logo instruction
     * @param fileStrings strings to convert
     * @return list of instructions
     */
    ArrayList<LogoInstruction> convert(List<String> fileStrings);
    //OLDVERSION
    //ArrayList<BasicInstruction> convert(List<String> fileStrings);

    /**
     * Converts the string given as a parameter to a logo instruction
     * @param s string to convert
     * @return logo instruction
     */
    LogoInstruction convertString(String s);

    /**
     * Converts the given string into a logo instruction command
     * @param instructionComponent
     * @return the type of the instruction
     */
    InstructionType convertInstructionType(String instructionComponent);

    //OLDVERSION
    //Command convertCommand(String instructionComponent);
}
