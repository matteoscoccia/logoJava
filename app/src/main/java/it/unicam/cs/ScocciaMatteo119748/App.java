/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package it.unicam.cs.ScocciaMatteo119748;

import it.unicam.cs.ScocciaMatteo119748.logo.file.FileReaderImpl;

public class App {

    public static void main(String[] args) {
        FileReaderImpl reader = new FileReaderImpl("C:\\Users\\matte\\Desktop\\firstInstructionSet.txt");
        reader.getInstructionsList();

    }
}
