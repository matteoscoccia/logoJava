package it.unicam.cs.ScocciaMatteo119748.implementation;

import it.unicam.cs.ScocciaMatteo119748.logo.components.CursorImpl;
import it.unicam.cs.ScocciaMatteo119748.logo.file.FileReaderImpl;
import it.unicam.cs.ScocciaMatteo119748.logo.file.InstructionConverterImpl;
import it.unicam.cs.ScocciaMatteo119748.logo.file.InstructionExecuter;
import it.unicam.cs.ScocciaMatteo119748.logo.instructions.LogoInstruction;
import it.unicam.cs.ScocciaMatteo119748.logo.components.PlaygroundImpl;

import java.util.ArrayList;

/**
 * Model of the MVC pattern, this manages the app data
 */
public class Model {

    String path;
    private final FileReaderImpl reader;
    private final InstructionExecuter executer;

    ArrayList<LogoInstruction> instructions;

    public Model(String path, PlaygroundImpl playground) {
        this.path = path;
        InstructionConverterImpl converter = InstructionConverterImpl.getInstance();
        this.reader = new FileReaderImpl(path, converter);
        this.executer = InstructionExecuter.getInstance();
        executer.setPlayground(playground);
        executer.setCursor(new CursorImpl());
    }

    /**
     * Gets and stores every instruction from the file provided using the path
     */
    public void provideInstructionFromFile(){
        reader.readStringsList();
        instructions = reader.getInstructionsList();
    }

    /**
     * Executes the given instruction
     * @param it instruction to perform
     */
    public void executeInstruction(LogoInstruction it) {
        executer.executeInstruction(it);
    }

    /**
     * Returns the instruction executer that actually performs the instructions
     * @return instruction Executer
     */
    public InstructionExecuter getExecuter() {
        return executer;
    }
}
