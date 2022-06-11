package it.unicam.cs.ScocciaMatteo119748.logo.file;

import it.unicam.cs.ScocciaMatteo119748.logo.instructions.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Basic implementation of an object that converts strings to logo instruction, using the basic set of instructions
 */
public class InstructionConverterImpl implements InstructionConverter{

    private static InstructionConverterImpl instance = null;
    private ArrayList<Command> commandsList = createCommandsList();

    /**
     * Constructor is private in order to implement singleton pattern
     */
    private InstructionConverterImpl(){}

    /**
     * Returns the single instance in the whole program
     * @return the single instance of the converter
     */
    public static InstructionConverterImpl getInstance() {
        if (instance == null) {
            instance = new InstructionConverterImpl();
        }
        return instance;
    }

    /**
     * Creates the commands set that the converter needs to be aware of. This builds the basic instruction set of logo
     * @return the commands list that the converter will recognize
     */
    private ArrayList<Command> createCommandsList() {
        ArrayList<Command> commandsList =  new ArrayList<>();
        commandsList.add(new Command("FORWARD", CommandType.SINGLEPARAMETERINSTRUCTION));
        commandsList.add(new Command("BACKWARD", CommandType.SINGLEPARAMETERINSTRUCTION));
        commandsList.add(new Command("LEFT", CommandType.SINGLEPARAMETERINSTRUCTION));
        commandsList.add(new Command("RIGHT", CommandType.SINGLEPARAMETERINSTRUCTION));
        commandsList.add(new Command("CLEARSCREEN", CommandType.BASICINSTRUCTION));
        commandsList.add(new Command("HOME", CommandType.BASICINSTRUCTION));
        commandsList.add(new Command("PENUP", CommandType.BASICINSTRUCTION));
        commandsList.add(new Command("PENDOWN", CommandType.BASICINSTRUCTION));
        commandsList.add(new Command("SETPENCOLOR", CommandType.COLORINSTRUCTION));
        commandsList.add(new Command("SETFILLCOLOR", CommandType.COLORINSTRUCTION));
        commandsList.add(new Command("SETSCREENCOLOR",CommandType.COLORINSTRUCTION));
        commandsList.add(new Command("SETPENSIZE", CommandType.SINGLEPARAMETERINSTRUCTION));
        commandsList.add(new Command("REPEAT", CommandType.REPEATINSTRUCTION));
        return  commandsList;
    }

    /**
     * Converts every string received into a logo instruction
     * @param fileStrings the strings read from the file reader
     * @return the list of the instructions of the logo program
     */
    @Override
    public ArrayList<BasicInstruction> convert(List<String> fileStrings) {
        for (String s:
             fileStrings) {
            BasicInstruction in = convertString(s);
            System.out.println(in.toString());
        }
        return null;
    }

    /**
     * Converts the given string to an instuction
     * @param s string to convert
     * @return converted instruction
     */
    @Override
    public BasicInstruction convertString(String s) {
        String[] instructionComponents = s.split(" ");
        if(instructionComponents[0] == null)
            return null;

        Command comm;
        comm = convertCommand(instructionComponents[0]);

        if(comm.getType().equals(CommandType.BASICINSTRUCTION))
            return new BasicInstruction(comm);
        if(comm.getType().equals(CommandType.SINGLEPARAMETERINSTRUCTION)){
            int parameter = Integer.parseInt(instructionComponents[1]);
            return new SingleParameterInstruction(comm, parameter);
        }
        if(comm.getType().equals(CommandType.COLORINSTRUCTION)){
            Color color = new Color(
                    Integer.parseInt(instructionComponents[1]),
                    Integer.parseInt(instructionComponents[2]),
                    Integer.parseInt(instructionComponents[2])
            );
            return new ColorInstruction(comm, color);
        }
        if(comm.getType().equals(CommandType.REPEATINSTRUCTION)){
            //TODO REPEAT VIENE MESSO DOPO LE ISTRUZIONI DA RIPETERE
            ArrayList<String> nextCommands = new ArrayList<>(Arrays.asList(instructionComponents));
            ArrayList<String> nextInstructions = new ArrayList<>(parseNestedCommands(nextCommands));
            return new RepeatInstruction<BasicInstruction>(Integer.parseInt(instructionComponents[1]), convert(nextInstructions));
        }

        return null;
    }

    private List<String> parseNestedCommands(ArrayList<String> nextCommands) {
        nextCommands.remove(0);
        nextCommands.remove(0);
        String newString = nextCommands.get(0).replace("[","");
        nextCommands.set(0, newString);
        String newLastString = nextCommands.get(nextCommands.size() - 1).replace("]","");
        nextCommands.set(nextCommands.size()-1, newLastString);
        return convertToStringList(nextCommands);
    }

    private List<String> convertToStringList(ArrayList<String> nextCommands) {
        ArrayList<String> newStringList = new ArrayList<>();
        for (String s:
             nextCommands) {
            if(isCommand(s)){//Se è un comando formo un'unica stringa con i parametri
                String newString = "\n".concat(s);
                newStringList.add(newString);
            }else{
                newStringList.add(" " + s);
            }
        }
        String concatInstructions = String.join("", newStringList);
        return convertStringToInstructionList(concatInstructions);
    }

    private ArrayList<String> convertStringToInstructionList(String concatInstructions) {
        String[] instructionsArray = concatInstructions.split("\n");
        List<String> instructionsList = Arrays.asList(instructionsArray);
        ArrayList<String> instructions = new ArrayList<>(instructionsList);
        instructions.removeIf(s -> s.equals(""));
        return instructions;
    }

    private boolean isCommand(String s) {
        return commandsList.stream().filter(x -> x.getName().equals(s)).count() == 1;
    }

    @Override
    public Command convertCommand(String instructionComponent) {
        Optional<Command> command = commandsList.stream().filter(x -> x.getName().equals(instructionComponent)).findFirst();
        return command.orElse(null);
    }

    /*private CommandType provideCommandType(String instructionComponent) {
        if(isBasicInstruction(instructionComponent))
            return CommandType.BASICINSTRUCTION;

        if(isSingleParameterInstruction(instructionComponent))
            return CommandType.SINGLEPARAMETERINSTRUCTION;

        if(isColorInstruction(instructionComponent))
            return CommandType.COLORINSTRUCTION;

        if(isRepeatInstruction(instructionComponent))
            return CommandType.REPEATINSTRUCTION;

        return null;
    }*/

}
