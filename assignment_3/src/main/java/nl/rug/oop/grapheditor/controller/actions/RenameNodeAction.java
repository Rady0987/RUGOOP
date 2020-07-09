package nl.rug.oop.grapheditor.controller.actions;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.UndoRedo.renameNode;

import javax.swing.*;
import javax.swing.undo.UndoManager;
import java.awt.event.ActionEvent;

/**
 * This class creates a new action that renames a node.
 */
public class RenameNodeAction extends AbstractAction {
   private final GraphModel graph;

   /**
    * The Constructor.
    *
    * @param graph The graphModel.
    */
   public RenameNodeAction(GraphModel graph) {
      super("Rename node");
      this.graph = graph;
   }

   /**
    * This method calls the corresponding method from model.
    *
    * @param e ActionEvent that is raised from the user action.
    */
   @Override
   public void actionPerformed(ActionEvent e) {
      if(graph.getSelectedNodes().size() > 0) {
         String name = JOptionPane.showInputDialog("Node name ?");
         UndoManager undoManager = graph.getUndoManager();
         renameNode renameEdit = new renameNode(graph, graph.getSelectedNodes().get(0), name);
         undoManager.addEdit(renameEdit);
         renameEdit.redo();
      }
   }
}
