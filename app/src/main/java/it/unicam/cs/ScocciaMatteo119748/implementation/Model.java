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
            //"C:\\Users\\matte\\Desktop\\secondInstructionSet.txt";
    //TODO VALUTARE SE PASSARLI IN INPUT IN FASE DI COSTRUZIONE
    InstructionConverterImpl converter;
    FileReaderImpl reader;
    InstructionExecuter executer;

    ArrayList<LogoInstruction> instructions;

    private CursorImpl cursor;
    private PlaygroundImpl playground;


    public Model(String path) {
        this.path = path;
        this.converter = InstructionConverterImpl.getInstance();
        this.reader = new FileReaderImpl(path, converter);
        this.cursor = new CursorImpl();
        playground = providePlayground();
        this.executer = InstructionExecuter.getInstance();
        //executer.setInstructionTypes(converter.instructionTypes);
    }

    private PlaygroundImpl providePlayground(){
        Scanner input = new Scanner(System.in);
        int width, heigth;
        do {
            System.out.println("INSERT FIELD WIDTH");
            width = Integer.parseInt(input.nextLine());
        } while (width<0);
        do {
            System.out.println("INSERT FIELD HEIGTH");
            heigth = Integer.parseInt(input.nextLine());
        } while (heigth<0);
        return new PlaygroundImpl(width, heigth);
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
}
