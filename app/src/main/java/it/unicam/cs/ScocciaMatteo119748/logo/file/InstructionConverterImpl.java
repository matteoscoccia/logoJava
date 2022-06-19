package it.unicam.cs.ScocciaMatteo119748.logo.file;

import it.unicam.cs.ScocciaMatteo119748.logo.instructions.*;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Basic implementation of an object that converts strings to logo instruction, using the basic set of instructions
 */
public class InstructionConverterImpl implements InstructionConverter{

    private static InstructionConverterImpl instance = null;
    public final List<InstructionType> instructionTypes;

    /**
     * Constructor is private in order to implement singleton pattern
     */
    private InstructionConverterImpl(){
        instructionTypes = new ArrayList<>(EnumSet.allOf(InstructionType.class));
    }

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
     * Converts every string received into a logo instruction
     * @param fileStrings the strings read from the file reader
     * @return the list of the instructions of the logo program
     */
    @Override
    public ArrayList<LogoInstruction> convert(List<String> fileStrings) {
        ArrayList<LogoInstruction> instructionSet = new ArrayList<>();
        for (String s:
                fileStrings) {
            LogoInstruction in = convertString(s);
            instructionSet.add(in);
        }
        return instructionSet;
    }

    /**
     * Converts the given string to an instuction
     * @param s string to convert
     * @return converted instruction
     */
    @Override
    public LogoInstruction convertString(String s) {
        String[] instructionComponents = s.split(" ");
        if(instructionComponents[0] == null)
            return null;

        InstructionType type;
        type = convertInstructionType(instructionComponents[0]);
        return provideInstruction(type, instructionComponents);
    }

    /**
     * Actully builds the instruction pairing the instruction type with the parameters
     * @param type instruction type
     * @param instructionComponents parameters of the instruction
     * @return the actual instruction
     */
    private LogoInstruction provideInstruction(InstructionType type, String[] instructionComponents) {
        if(isMoveInstruction(type))
            return new MoveInstruction(type, Integer.parseInt(instructionComponents[1]));
        if(isHomeInstruction(type))
            return new MoveInstruction(type, 0);
        if(isCursorColorInstruction(type)){
            Color color = new Color(
                    Integer.parseInt(instructionComponents[1]),
                    Integer.parseInt(instructionComponents[2]),
                    Integer.parseInt(instructionComponents[3])
            );
            return new CursorColorInstruction(type, color);
        }
        if(isPenPositionInstruction(type))
            return new PenInstruction(type, 0);
        if(isPenSizePosition(type))
            return new PenInstruction(type, Integer.parseInt(instructionComponents[1]));
        if(isPlaygroundInstruction(type)){
            Color color = new Color(
                    Integer.parseInt(instructionComponents[1]),
                    Integer.parseInt(instructionComponents[2]),
                    Integer.parseInt(instructionComponents[3])
            );
            return new PlaygroundInstruction(type, color);
        }
        if(isClearscreenInstruction(type))
            return new PlaygroundInstruction(type);
        if(isRepeatInstruction(type)){
            ArrayList<String> nextCommands = new ArrayList<>(Arrays.asList(instructionComponents));
            ArrayList<String> nextInstructions = new ArrayList<>(parseNestedCommands(nextCommands));
            return new RepeatInstruction<>(Integer.parseInt(instructionComponents[1]), convert(nextInstructions));
        }

        return null;
    }

    private boolean isRepeatInstruction(InstructionType type) {
        return type == InstructionType.REPEAT;
    }

    private boolean isClearscreenInstruction(InstructionType type){
        return type == InstructionType.CLEARSCREEN;
    }

    private boolean isPlaygroundInstruction(InstructionType type) {
        return type == InstructionType.SETSCREENCOLOR;
    }

    private boolean isPenSizePosition(InstructionType type) {
        return type == InstructionType.SETPENSIZE;
    }

    private boolean isPenPositionInstruction(InstructionType type) {
        return type == InstructionType.PENUP || type == InstructionType.PENDOWN;
    }

    private boolean isCursorColorInstruction(InstructionType type) {
        return type == InstructionType.SETPENCOLOR || type == InstructionType.SETFILLCOLOR;
    }

    private boolean isHomeInstruction(InstructionType type) {
        return type == InstructionType.HOME;
    }

    private boolean isMoveInstruction(InstructionType type) {
        return type == InstructionType.FORWARD ||
                type == InstructionType.BACKWARD ||
                type == InstructionType.RIGHT ||
                type == InstructionType.LEFT;
    }

    /**
     * Converts the string read from the file to an instruction type to build the instruction
     * @param instructionComponent
     * @return type of the instruction
     */
    @Override
    public InstructionType convertInstructionType(String instructionComponent) {
        InstructionType a;
        Optional<InstructionType> type = instructionTypes.stream().filter(x -> x.name().equals(instructionComponent)).findFirst();
        return type.orElse(null);
    }


    /**
     * Parses repeat instructions
     * @param nextCommands Next commands read from the file
     * @return the list of strings that contain the next commands
     */
    private List<String> parseNestedCommands(ArrayList<String> nextCommands) {
        nextCommands.remove(0);
        nextCommands.remove(0);
        String newString = nextCommands.get(0).replace("[","");
        nextCommands.set(0, newString);
        String newLastString = nextCommands.get(nextCommands.size() - 1).replace("]","");
        nextCommands.set(nextCommands.size()-1, newLastString);
        return convertToStringList(nextCommands);
    }

    /**
     * Formats the nested strings
     * @param nextCommands next strings from the file
     * @return
     */
    private List<String> convertToStringList(ArrayList<String> nextCommands) {
        ArrayList<String> newStringList = new ArrayList<>();
        for (String s:
             nextCommands) {
            if(isInstruction(s)){//Se è un comando formo un'unica stringa con i parametri
                String newString = "\n".concat(s);
                newStringList.add(newString);
            }else{
                newStringList.add(" " + s);
            }
        }
        String concatInstructions = String.join("", newStringList);
        return convertStringToInstructionList(concatInstructions);
    }

    /**
     * Formats the string to instruction format
     * @param concatInstructions
     * @return
     */
    private ArrayList<String> convertStringToInstructionList(String concatInstructions) {
        String[] instructionsArray = concatInstructions.split("\n");
        List<String> instructionsList = Arrays.asList(instructionsArray);
        ArrayList<String> instructions = new ArrayList<>(instructionsList);
        instructions.removeIf(s -> s.equals(""));
        return instructions;
    }

    /**
     * Checks if the given string is a compliant string
     * @param s
     * @return
     */
    private boolean isInstruction(String s){
        return instructionTypes.stream().filter(it -> it.toString().equals(s)).count() == 1;
    }

}
