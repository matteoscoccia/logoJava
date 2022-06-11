/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package it.unicam.cs.ScocciaMatteo119748;

import it.unicam.cs.ScocciaMatteo119748.logo.file.FileReaderImpl;
import it.unicam.cs.ScocciaMatteo119748.logo.file.InstructionConverterImpl;

public class App {

    public static void main(String[] args) {
        String path = "C:\\Users\\matte\\Desktop\\secondInstructionSet.txt";
        InstructionConverterImpl converter = InstructionConverterImpl.getInstance();
        FileReaderImpl reader = new FileReaderImpl(path, converter);
        reader.getInstructionsList();
    }
}
