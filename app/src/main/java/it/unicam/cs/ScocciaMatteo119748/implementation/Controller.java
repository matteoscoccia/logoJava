package it.unicam.cs.ScocciaMatteo119748.implementation;

import it.unicam.cs.ScocciaMatteo119748.logo.components.ExecutionResult;
import it.unicam.cs.ScocciaMatteo119748.logo.playground.PlaygroundImpl;

import java.util.ArrayList;

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
        ArrayList<ExecutionResult> previousInstructionResults = new ArrayList<>();

        model.instructions.forEach(
                it -> {
                    model.executeInstruction(it);
                    view.showInstructionResult(model.getExecuter().programResult);
                }
        );
        /*model.executer.history.forEach(
                System.out::println
        );*/
        /*model.executer.lines.forEach(
                System.out::println
        );*/
        //System.out.println(model.executer.playground.getWidth() + " " + model.executer.playground.getHeight() + " " + model.executer.playground.getBackground());
        model.getExecuter().programResult.forEach(
                it -> System.out.println(it.getOutputRepresentation())
        );

        model.getExecuter().programResult.forEach(
                it -> System.out.println(it.getExecution())
        );
    }

    /**
     * Gets the instruction file path from the user and uses it to create the model
     * @return the model
     */
    private Model prepareModel() {
        String path = view.getFilePath();
        int playgroundWidth = view.getPlaygroundWidth();
        int playgroundHeigth = view.getPlaygroundHeigth();
        return new Model(path,
                new PlaygroundImpl(playgroundWidth, playgroundHeigth));
    }
}
