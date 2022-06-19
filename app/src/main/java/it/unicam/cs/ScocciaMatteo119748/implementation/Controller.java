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
    private String instructionSetPath;

    public Controller(ViewClass view) {
        this.view = view;
        this.model = prepareModel();
    }

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


        /*model.executer.history.forEach(
                System.out::println
        );*/
        /*model.executer.lines.forEach(
                System.out::println
        );*/
        //System.out.println(model.executer.playground.getWidth() + " " + model.executer.playground.getHeight() + " " + model.executer.playground.getBackground());
        /*model.getExecuter().getProgramResult().forEach(
                it -> System.out.println(it.getOutputRepresentation())
        );

        model.getExecuter().getProgramResult().forEach(
                it -> System.out.println(it.getExecution())
        );*/
    }

    /**
     * Gets the instruction file path from the user and uses it to create the model
     * @return the model
     */
    private Model prepareModel() {
        instructionSetPath = view.getFilePath();
        int playgroundWidth = view.getPlaygroundWidth();
        int playgroundHeigth = view.getPlaygroundHeigth();
        return new Model(instructionSetPath,
                new PlaygroundImpl(playgroundWidth, playgroundHeigth));
    }
}
