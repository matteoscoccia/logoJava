package it.unicam.cs.ScocciaMatteo119748.implementation;

import it.unicam.cs.ScocciaMatteo119748.logo.file.InstructionExecuter;

/**
 * Controller of the MVC pattern, this couples the Model class with the View class and provides the actual execution
 */
public class Controller {

    private final Model model;
    private final ViewClass view;

    public Controller(ViewClass view) {
        this.view = view;
        this.model = prepareModel();
    }

    public void exec(){
        model.provideInstructionFromFile();
        model.instructions.forEach(
                model::executeInstruction
        );
        model.executer.history.forEach(
                System.out::println
        );
        model.executer.lines.forEach(
                System.out::println
        );
    }

    /**
     * Gets the instruction file path from the user and uses it to create the model
     * @return the model
     */
    private Model prepareModel() {
        String path = view.getFilePath();
        return new Model(path);
    }
}
