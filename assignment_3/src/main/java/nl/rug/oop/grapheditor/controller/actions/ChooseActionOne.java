package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;
import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 * Class of a new node action
 */
public class ChooseActionOne extends AbstractAction {

    private GraphModel graph;

    /**
     * Constructor.
     * Creates an action to make a new node
     *
     * @param graph The option one
     */
    public ChooseActionOne(GraphModel graph) {
        super("New node");
        this.graph = graph;
    }

    /**
     * Calls the corresponding method from model
     *
     * @param e ActionEvent that is raised from the user action
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        graph.optionOneChosen();
    }

}
