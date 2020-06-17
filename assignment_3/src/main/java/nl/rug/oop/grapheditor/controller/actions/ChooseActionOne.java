package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * Represents not an action yet
 */
public class ChooseActionOne extends AbstractAction {

    private GraphModel graph;

    /**
     * Creates not an action yet
     *
     * @param graph The option one
     */
    public ChooseActionOne(GraphModel graph) {
        super("Option 1");
        this.graph = graph;
    }

    /**
     * Not an action yet
     *
     * @param e ActionEvent that is raised from the user action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        //game.optionOneChosen();
    }

}
