package nl.rug.oop.grapheditor.controller.UndoRedo;

import nl.rug.oop.grapheditor.model.GraphModel;
import nl.rug.oop.grapheditor.model.Node;

import javax.swing.undo.AbstractUndoableEdit;

/**
 * Class that creates a new undoable action to rename a node.
 */
public class renameNode extends AbstractUndoableEdit {
   private final GraphModel graph;
   private final Node node;
   private final String oldName;
   private final String newName;

   /**
    * The constructor.
    *
    * @param graph   The graphModel
    * @param node    The node that is renamed
    * @param newName The new name for the node
    */
   public renameNode(GraphModel graph, Node node, String newName) {
      this.graph = graph;
      this.node = node;
      oldName = node.getName();
      this.newName = newName;
   }

   /**
    * This method Undoes the edit.
    */
   @Override
   public void undo() {
      super.undo();
      graph.renameNode(node, oldName);
   }

   /**
    * This method Redoes the edit.
    */
   @Override
   public void redo() {
      if (super.canRedo()) {
         super.redo();
      }
      graph.renameNode(node, newName);
   }
}
