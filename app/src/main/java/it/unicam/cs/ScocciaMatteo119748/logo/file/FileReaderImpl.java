package it.unicam.cs.ScocciaMatteo119748.logo.file;


import it.unicam.cs.ScocciaMatteo119748.logo.instructions.BasicInstruction;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

/**
 * Basic implementation of the file reader in order to convert a file into a set of LOGO instructions
 */
public class FileReaderImpl implements FileReader {

    private List<String> fileStrings;
    private final Path filePath;
    private final List<BasicInstruction> instructionList;
    private InstructionConverter converter;


    public FileReaderImpl(String path, InstructionConverter converter) {
        filePath = Path.of(path);
        fileStrings  = new ArrayList<>();
        instructionList = new ArrayList<>();
        this.converter = converter;
        readStringsList();
    }

    /**
     * Reads the instructions list from the file specified in the fileName
     */
    @Override
    public void readStringsList() {
        try{
            fileStrings = Files.readAllLines(filePath);
        } catch (IOException e) {
            System.out.println("Non è stato possibile leggere il contenuto del file specificato");
            e.printStackTrace();
        }
    }

    public ArrayList<BasicInstruction> getInstructionsList(){
        return converter.convert(fileStrings);
    }

    @Override
    public BasicInstruction readNextInstruction() {
        return null;
    }
}
