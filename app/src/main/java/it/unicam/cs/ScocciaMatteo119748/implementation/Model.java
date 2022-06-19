package it.unicam.cs.ScocciaMatteo119748.implementation;

import it.unicam.cs.ScocciaMatteo119748.logo.components.CursorImpl;
import it.unicam.cs.ScocciaMatteo119748.logo.file.FileReaderImpl;
import it.unicam.cs.ScocciaMatteo119748.logo.file.InstructionConverterImpl;
import it.unicam.cs.ScocciaMatteo119748.logo.file.InstructionExecuter;
import it.unicam.cs.ScocciaMatteo119748.logo.instructions.LogoInstruction;
import it.unicam.cs.ScocciaMatteo119748.logo.playground.PlaygroundImpl;

import java.util.ArrayList;
import java.util.Scanner;

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
        //TODO VALUTARE SE PASSARLI IN INPUT IN FASE DI COSTRUZIONE
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

    public void executeInstruction(LogoInstruction it) {
        executer.executeInstruction(it);
    }

    public InstructionExecuter getExecuter() {
        return executer;
    }
}
