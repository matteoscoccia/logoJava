package it.unicam.cs.ScocciaMatteo119748.implementation;

import it.unicam.cs.ScocciaMatteo119748.logo.components.CursorImpl;
import it.unicam.cs.ScocciaMatteo119748.logo.file.FileReaderImpl;
import it.unicam.cs.ScocciaMatteo119748.logo.file.InstructionConverterImpl;
import it.unicam.cs.ScocciaMatteo119748.logo.file.InstructionExecuter;
import it.unicam.cs.ScocciaMatteo119748.logo.instructions.BasicInstruction;
import it.unicam.cs.ScocciaMatteo119748.logo.playground.PlaygroundImpl;

import java.util.ArrayList;

/**
 * Model of the MVC pattern, this manages the app data
 */
public class Model {

    String path;
            //"C:\\Users\\matte\\Desktop\\secondInstructionSet.txt";
    //TODO VALUTARE SE PASSARLI IN INPUT IN FASE DI COSTRUZIONE
    InstructionConverterImpl converter;
    FileReaderImpl reader;
    InstructionExecuter executer;

    ArrayList<BasicInstruction> instructions;

    private CursorImpl cursor;
    private PlaygroundImpl playground;


    public Model(String path) {
        this.path = path;
        this.converter = InstructionConverterImpl.getInstance();
        this.reader = new FileReaderImpl(path, converter);
        this.cursor = new CursorImpl();
        //TODO CHIEDERE ALL'UTENTE LA DIMENSIONE DEL PLAYGROUND
        playground = new PlaygroundImpl(300,300);
        this.executer = InstructionExecuter.getInstance();
        executer.setCommandsList(converter.commandsList);
    }

    /**
     * Gets and stores every instruction from the file provided using the path
     */
    public void provideInstructionFromFile(){
        reader.readStringsList();
        instructions = reader.getInstructionsList();
    }


    public void executeInstruction(BasicInstruction it) {

    }
}
