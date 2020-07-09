package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.UndoRedo.removeEdge;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;
/**
 * This class creates a remove edge action.
 */
public class RemoveEdgeAction extends AbstractAction {
   private final GraphModel graph;

   /**
    * The Constructor.
    *
    * @param graph The GraphModel.
    */
   public RemoveEdgeAction(GraphModel graph) {
      super("Remove edge");
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
      removeEdge deleteEdgeEdit = new removeEdge(graph, graph.getEdgeList());
      undoManager.addEdit(deleteEdgeEdit);
      deleteEdgeEdit.redo();
   }
}
