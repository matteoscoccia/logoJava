package it.unicam.cs.ScocciaMatteo119748.implementation;
import it.unicam.cs.ScocciaMatteo119748.logo.components.PlaygroundImpl;

/**
 * Controller of the MVC pattern, this couples the Model class with the View class and provides the actual execution
 */
public class Controller {

    private final Model model;
    private final ViewClass view;
    private String instructionSetPath;

    public Controller(ViewClass view) {
        this.view = view;
        this.model = prepareModel();
    }

    /**
     * Implements the actual execution of the program
     */
    public void exec(){
        model.provideInstructionFromFile();

        model.instructions.forEach(
                model::executeInstruction
        );
        model.getExecuter().getProgramResult().forEach(
                view::showExecutionResult
        );

        view.saveExecutionFile(
                model.getExecuter().getProgramResult(),
                instructionSetPath,
                model.getExecuter().getPlayground()
        );
    }

    /**
     * Gets the instruction file path from the user and uses it to create the model
     * @return the model
     */
    private Model prepareModel() {
        instructionSetPath = view.getFilePath();
        int playgroundWidth = view.getPlaygroundWidth();
        int playgroundHeight = view.getPlaygroundHeight();
        return new Model(instructionSetPath,
                new PlaygroundImpl(playgroundWidth, playgroundHeight));
    }
}
