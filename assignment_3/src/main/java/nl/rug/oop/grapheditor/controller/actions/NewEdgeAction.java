package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.controller.SelectionController;
import nl.rug.oop.grapheditor.model.Edge;
import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.controller.UndoRedo.addEdge;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;

/**
 * This class creates new edge action.
 */
public class NewEdgeAction extends AbstractAction {

   private GraphModel graph;

   /**
    * The Constructor.
    *
    * @param graph The GraphModel.
    */
   public NewEdgeAction(GraphModel graph) {
      super("New edge");
      this.graph = graph;
   }

   /**
    * This method updates the state of the new edge trigger from the selection controller.
    *
    * @param e ActionEvent that is raised from the user action.
    */
   @Override
   public void actionPerformed(ActionEvent e) {
      SelectionController.setNewEdge(true);
   }

   /**
    * This method calls the corresponding method from undoable edits.
    *
    */
   public void createEdit(Edge addedEdge) {
      UndoManager undoManager = graph.getUndoManager();
      addEdge addEdge = new addEdge(graph, addedEdge);
      undoManager.addEdit(addEdge);
      addEdge.redo();
   }
}
