package it.unicam.cs.ScocciaMatteo119748.implementation;

import it.unicam.cs.ScocciaMatteo119748.logo.components.ExecutionResult;
import it.unicam.cs.ScocciaMatteo119748.logo.playground.Playground;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Implements the View interface using a command line execution
 */
public class ConsoleView implements ViewClass {

    Scanner input;

    public ConsoleView() {
        this.input = new Scanner(System.in);
    }

    /**
     * Gets the path of the file to be read from the user
     * @return the path of the file
     */
    @Override
    public String getFilePath() {
        System.out.println("Inserire il path del file txt contenente le istruzioni da eseguire:");
        return input.nextLine();
    }

    @Override
    public int getPlaygroundWidth() {
        int width;
        do {
            System.out.println("INSERT FIELD WIDTH");
            width = Integer.parseInt(input.nextLine());
        } while (width<0);
        return width;
    }

    @Override
    public int getPlaygroundHeigth() {
        int width;
        do {
            System.out.println("INSERT FIELD HEIGTH");
            width = Integer.parseInt(input.nextLine());
        } while (width<0);
        return width;
    }

    @Override
    public void showExecutionResult(ExecutionResult executionResult) {
        System.out.println(executionResult.getExecution());
    }

    @Override
    public void saveExecutionFile(ArrayList<ExecutionResult> executionResult, String startingPath, Playground playground) {

        File output = createOutputFile(startingPath);

        if(output != null) {
            try {
                PrintWriter pw = new PrintWriter(output.getPath());
                String outputString = provideOutputResult(executionResult, playground);
                pw.print(outputString);
                pw.close();
                //Files.write(Paths.get(output.getPath()), outputString.getBytes(), StandardOpenOption.APPEND);
            } catch (IOException e) {
                System.out.println("Error writing to output file");
            }
            System.out.println("Program result saved to: " + output.getPath());
        }else{
            System.out.println("Error creating output file");
        }

    }

    private String provideOutputResult(ArrayList<ExecutionResult> executionResult, Playground playground) {
        String output = playground.outputRepresentation();
        for (ExecutionResult r:
             executionResult) {
            output += r.getOutputRepresentation();
        }
        return output;
    }

    private File createOutputFile(String startingPath) {
        Path path = Paths.get(startingPath);
        String directory = path.getParent().toString();//Output directory
        String originalFileName = path.getFileName().toString().replaceFirst("[.][^.]+$", "");//Removes extension
        File outputFile;
        try {
            outputFile = new File(directory + "/" + originalFileName + "Result.txt");
            if (!outputFile.createNewFile()) {
                System.out.println("Result file already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred during the storing of the output.");
            e.printStackTrace();
            return null;
        }
        return outputFile;
    }

}
