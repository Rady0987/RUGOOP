package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.UndoRedo.addNode;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.undo.UndoManager;

/**
 * This class creates a new node action.
 */
public class NewNodeAction extends AbstractAction {

    private final GraphModel graph;

    /**
     * The Constructor.
     *
     * @param graph The graphModel.
     */
    public NewNodeAction(GraphModel graph) {
        super("New node");
        this.graph = graph;
    }

    /**
     * This method calls the corresponding method from undoable edits.
     *
     * @param e ActionEvent that is raised from the user action.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        UndoManager undoManager = graph.getUndoManager();
        addNode addNode = new addNode(graph);
        undoManager.addEdit(addNode);
        addNode.redo();
    }

}
