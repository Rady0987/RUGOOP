package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.controller.UndoRedo.removeNode;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;

/**
 * This class creates a remove node action.
 */
public class RemoveNodeAction extends AbstractAction {
   private final GraphModel graph;

   /**
    * The Constructor.
    *
    * @param graph The GraphModel.
    */
   public RemoveNodeAction(GraphModel graph) {
      super("Remove node(s)");
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
      removeNode removeNodeEdit = new removeNode(graph);
      undoManager.addEdit(removeNodeEdit);
      removeNodeEdit.redo();
      graph.setSelectedNodeNull();
   }

}
