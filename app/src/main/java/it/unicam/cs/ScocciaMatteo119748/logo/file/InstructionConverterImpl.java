package it.unicam.cs.ScocciaMatteo119748.logo.file;

import it.unicam.cs.ScocciaMatteo119748.logo.instructions.*;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Basic implementation of an object that converts strings to logo instruction, using the basic set of instructions
 */
public class InstructionConverterImpl implements InstructionConverter{

    //TODO CAMBIARE IMPLEMENTAZIONE
    private static InstructionConverterImpl instance = null;
    public final ArrayList<Command> commandsList = createCommandsList();

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
    //OLDVERSION
    /*@Override
    public ArrayList<BasicInstruction> convert(List<String> fileStrings) {
        ArrayList<BasicInstruction> instructionSet = new ArrayList<>();
        for (String s:
             fileStrings) {
            BasicInstruction in = convertString(s);
            instructionSet.add(in);
        }
        return instructionSet;
    }*/

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
    //OLDVERSION
    /*@Override
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
            ArrayList<String> nextCommands = new ArrayList<>(Arrays.asList(instructionComponents));
            ArrayList<String> nextInstructions = new ArrayList<>(parseNestedCommands(nextCommands));
            System.out.println(nextInstructions);
            return new RepeatInstruction<>(Integer.parseInt(instructionComponents[1]), convert(nextInstructions));
        }

        return null;
    }*/

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

        //TODO RIPRENDERE DA QUI
        LogoInstruction instruction = provideInstruction(type, instructionComponents);

        /*if(comm.getType().equals(CommandType.BASICINSTRUCTION))
            return new BasicInstruction(comm);
        if(comm.getType().equals(CommandType.SINGLEPARAMETERINSTRUCTION)){
            int parameter = Integer.parseInt(instructionComponents[1]);
            return new SingleParameterInstruction(comm, parameter);
        }
        if(comm.getType().equals(CommandType.COLORINSTRUCTION)){
            Color color = new Color(
                    Integer.parseInt(instructionComponents[1]),
                    Integer.parseInt(instructionComponents[2]),
                    Integer.parseInt(instructionComponents[3])
            );
            return new ColorInstruction(comm, color);
        }*/

        /*if(comm.getType().equals(CommandType.REPEATINSTRUCTION)){
            ArrayList<String> nextCommands = new ArrayList<>(Arrays.asList(instructionComponents));
            ArrayList<String> nextInstructions = new ArrayList<>(parseNestedCommands(nextCommands));
            System.out.println(nextInstructions);
            return new RepeatInstruction<>(Integer.parseInt(instructionComponents[1]), convert(nextInstructions));
        }*/

        return instruction;
    }

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
                    Integer.parseInt(instructionComponents[2])
            );
            return new PlaygroundInstruction(type, color);
        }
        if(isClearscreenInstruction(type))
            return new PlaygroundInstruction(type);
        if(isRepeatInstruction(type)){
            ArrayList<String> nextCommands = new ArrayList<>(Arrays.asList(instructionComponents));
            ArrayList<String> nextInstructions = new ArrayList<>(parseNestedCommands(nextCommands));
            return new RepeatInstruction<>(Integer.parseInt(instructionComponents[1]), convert(nextInstructions));//TODO FINIRE
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

    //OLDVERSION
    /*@Override
    public Command convertCommand(String instructionComponent) {
        Optional<Command> command = commandsList.stream().filter(x -> x.getName().equals(instructionComponent)).findFirst();
        return command.orElse(null);
    }*/

}
